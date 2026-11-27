# How is a mission scripted?

> **In one line:** Each `mi` file ends with zones, routes and a list of 6-byte commands that run one after another on a seconds timer; there are no event or zone triggers at all.

## The short answer
- A mission is a straight-line program. Each command waits `delay` seconds after the previous one, then runs. A dialogue pauses the clock.
- Commands spawn units for either side, set what enemy bases train, start attack waves, show dialogue, and set the win and lose rules.
- Nothing reacts to the player. No command tests a position, a kill count or a building. The only test is "does the player have room for N more units".
- Winning and losing are checked when a unit or a building dies, against the rule the script set last.
- All seven files parse to their exact length with `source/tools/missions_full.py`.

## How it works

### The rest of the `mi` file
After the entity list (type, x, y, flag) the loader reads these sections in order. "Group" is an enemy base number, 0..2. All coordinates are map cells.

| # | Section | Layout | Meaning |
|---|---|---|---|
| 1 | Build zones `f434b[class][group]` | 2 x 3 lists: count, then x, y, w, h | Where the enemy may place buildings. Class 0 = normal, class 1 = defensive (Bunker, Tower; `seg[109]`). |
| 2 | Mine fields `f435a[group]` | 3 lists of x, y, w, h | Where the group lays mines. |
| 3 | Wall lines `f436b[group]` | 3 lists of x, y, w, h | Cells the group fills with wall and repairs. |
| 4 | Attack routes `f458y`, `f456g`, `f457h` | per group: route count, byte count, x,y pairs, count+1 offsets | Waypoint lists for attack waves. |
| 5 | Rally points `f460i[group]` | 3 lists of x, y | Where freshly trained units gather. |
| 6 | Alarm areas `f439d[group]` | 3 lists of 4 bytes | Player units inside should pause wall repair and mines. Stored as x, y, w, h, read by the code as two corners. |
| 7 | Script `f443e` | count, then 6 bytes per command | opcode, p1, p2, value, delay, group. |

Entity notes: types 0..14 are buildings and the flag is the enemy group. Types 15 and 25 are **wall tiles** for side 0 and side 1, not units. No mission file places a unit; every unit comes from command 27. A defensive enemy building outside every zone is moved to group 3 and is never rebuilt.

For downloaded maps (mission number above 6) the 39-byte file `dmt` is appended to the map data. It supplies 9 extra dialogues that point at strings T2_95..T2_110, which is where the generic objective texts T2_95..T2_98 come from.

### The script machine
State: a command pointer, the time of the last command, one loop counter. Once per second: while `now >= last + delay x 10 ticks`, run the command, advance, set `last = now`. So `delay` is in seconds, 0..255.

| Op | Name | Fields used | Effect |
|---|---|---|---|
| 20 | Train order | value, group | `value < 30`: both Barracks and Factory get order `value`. 30..59: Barracks get `value-30`. 60..89: Factory gets `value-60`. Order = composition x 3 + size. |
| 21 | Waves on | value, group | Attack wave now, then every `value x 20 s` + 0..20 s. |
| 22 | Loop start | | Marker. |
| 23 | Loop end | value | Jump back to the last 22 until done `value` times (body runs value+1 times). -1 = forever. |
| 24 | Win rule | value, p1, p2 | 0 = enemy has no units and no buildings. 1 = no enemy Headquarters. 2 = win now. Above 50 = enemy building slots 1..value-50 gone. p1 and p2 feed the score. |
| 25 | Lose rule, money | value, p1, p2 | 0 = player has no units and no buildings. 1 = no Command center. Above 50 = any of player building slots 1..value-50 lost. Money: player p1 x 10, enemy p2 x 10. |
| 26 | Set rally point | p1, p2, value, group | Rally point number `value` = (p1, p2). Unused in the campaign. |
| 27 | Spawn | p1, p2, value, group | Create units near (p1, p2). Group 0..2 = enemy units for that group. Group 3 = units for the player. `value` as in 20, with 0..29 meaning infantry and vehicles together. |
| 28 | Dialogue | value | Show dialogue `base + value`. |
| 29 | Objective | value | Set the text of the Objectives screen and show it. |
| 30, 31 | Cancel | group | Cancel train orders / waves. Unused in the campaign. |
| 32 | Build list | value, group | Replace the group's rebuild list by list `value`. |
| 33 | Setup | value, group | 0/1 = wall repair on (1 also builds all walls now). 2..9 = Hard multiplier for player spawns, in tenths. 10..19 = Hard multiplier for enemy sizes, `(value+1)/10`. 20..28 = technology limit preset. 29 = wave flag. 30+ = that many attempts to lay a mine (needs a mine field). |
| 34 | Victory dialogue | value | Dialogue shown when the mission is won. |
| 35 | Move order | p1, p2, group | Every unit tagged `group` walks to (p1, p2). |
| 36 | Camera | p1, p2 | Jump the view there and clear the selection. |
| 37 | Reveal | p1, p2, value | Lift the fog around a point, radius `value`, for a few seconds. |
| 38 | Need room | value | The next 27 runs only if the player's unit count + value is 50 or less. If it runs, the command after it is skipped. |
| 39 | Tutorial | value | Like 28, shown only if the player answered yes to "Turn on tutorial?". |

**Spawn sizes.** Size index 0/1/2 gives 3/6/10 infantry or 2/4/6 vehicles. On Hard the count is multiplied by the factor from command 33. Player spawns with no "need room" stop at the rank cap (20 / 35 / 50 units). A Torrent rolled for the player becomes a Zeus unless research 13 is done.

**The retry idiom.** `38 n; 22; 27 X; 23 k; 27 X` means: deliver reinforcement X if there is room for n. On success the loop end is skipped and the second 27 runs too, so X arrives twice (the second copy only up to the rank cap). With no room, retry k times one second apart, then run the second 27 alone.

**Dialogue and objectives.** File `d` holds 32 dialogues as offsets into the T2 string table. Each mission has a base index (1, 11, 15, 18, 20, 26, 28 for missions 1..7). `28 value` shows all lines of dialogue `base + value`. `29 value` uses the first line of dialogue `base + value` as the objective text. Every trigger is time: the tutorial pages of mission 1 are commands 39 at 3 s, 43 s, 73 s, 138 s and 158 s.

**Winning and losing.** When a building finishes dying or a unit dies, the game tests the current rule for that side. A result starts a 50-tick (5 s) countdown, then the win or lose screen. Before the first command 24 the win rule is "none", so the two defence missions cannot be won until their script reaches its last line.

**Score inputs.** Command 24 also stores `e = p1` (time bonus budget, x500 points) and `f = p2` (kill point cap, x100). The formula is in [How do ranks, score and difficulty work?](10-ranks-score-difficulty.md).

### Worked example: mission 1, commands 25 to 33
`38 3` (need room for 3), `22`, `27 (58,36) value 32 group 3` gives the player 10 Assault at the east edge, `35 (14,25) group 3` walks them to the base, `37` and `36` reveal and show the spot, `28 2` plays "Captain is calling" (T2_14..16), `29 3` sets objective T2_17.

## How we know
- [`g.java:975`](../source/decompiled/g.java#L975)-[`1053`](../source/decompiled/g.java#L1053) : section order and sizes (Observed). `source/tools/missions_full.py` consumes 392, 363, 456, 309, 690, 643, 683 bytes = full length of `mi0`..`mi6` (Observed)
- [`g.java:960`](../source/decompiled/g.java#L960) : entity type 15 and up writes a wall value `1001 + 100 x side` into the cell grid (Observed)
- [`g.java:994`](../source/decompiled/g.java#L994), [`g.java:1003`](../source/decompiled/g.java#L1003) : load-time rebuild list and group 3 (Observed)
- [`p.java:1291`](../source/decompiled/p.java#L1291) build zones, [`p.java:3079`](../source/decompiled/p.java#L3079) mine fields, [`p.java:3052`](../source/decompiled/p.java#L3052) wall lines, [`p.java:3197`](../source/decompiled/p.java#L3197) routes, [`p.java:3150`](../source/decompiled/p.java#L3150) rally points, [`p.java:3042`](../source/decompiled/p.java#L3042) alarm areas (Observed)
- [`p.java:1324`](../source/decompiled/p.java#L1324) : the delay test and the dispatch on opcode 20..39 (Observed)
- [`p.java:2791`](../source/decompiled/p.java#L2791) op 20, [`2805`](../source/decompiled/p.java#L2805) op 21, [`2809`](../source/decompiled/p.java#L2809) op 23, [`2820`](../source/decompiled/p.java#L2820) op 24, [`2833`](../source/decompiled/p.java#L2833) op 25, [`2842`](../source/decompiled/p.java#L2842) op 27, [`2877`](../source/decompiled/p.java#L2877) ops 28/29, [`2901`](../source/decompiled/p.java#L2901) op 32, [`2913`](../source/decompiled/p.java#L2913) op 35, [`2938`](../source/decompiled/p.java#L2938) op 33, [`2978`](../source/decompiled/p.java#L2978) ops 36/37, [`2996`](../source/decompiled/p.java#L2996) ops 38/39 (Observed)
- [`p.java:2847`](../source/decompiled/p.java#L2847), [`p.java:2853`](../source/decompiled/p.java#L2853), [`p.java:2857`](../source/decompiled/p.java#L2857), [`p.java:2866`](../source/decompiled/p.java#L2866) : room test, count and caps, Torrent swap, skip of the next command (Observed). JADX broke this loop's shape; the count rule is read from its exit condition (Inferred)
- `a.json seg[114]`, `seg[115]` sizes; `seg[116..123]` compositions per side (Observed)
- [`k.java:521`](../source/decompiled/k.java#L521) : file `d` fills `seg[139..141]`; [`g.java:880`](../source/decompiled/g.java#L880) : base index per mission; [`g.java:1414`](../source/decompiled/g.java#L1414), [`g.java:3756`](../source/decompiled/g.java#L3756) : dialogue and Objectives screen read `seg[139]` (Observed)
- [`g.java:1054`](../source/decompiled/g.java#L1054), [`g.java:6262`](../source/decompiled/g.java#L6262) : extra text tables for maps above 6, with `dmt` appended; `dmt` is 39 bytes = 4 + 10 + 9 + 16 (Observed)
- [`g.java:2997`](../source/decompiled/g.java#L2997) : tutorial flag set from screen 28, text T1_21 (Observed)
- [`p.java:1695`](../source/decompiled/p.java#L1695)-[`1740`](../source/decompiled/p.java#L1740), [`p.java:2141`](../source/decompiled/p.java#L2141) : win and lose tests; `a.json seg[94]` marks Command center and Headquarters as class 0 and 3, the `% 3 == 0` test (Observed)
- [`p.java:721`](../source/decompiled/p.java#L721) : both rules start at -1, "none"; [`g.java:1225`](../source/decompiled/g.java#L1225) : 50-tick countdown (Observed)
- [`p.java:2822`](../source/decompiled/p.java#L2822) : command 24 writes `g.e` and `g.f`; [`g.java:1447`](../source/decompiled/g.java#L1447) : the score code reads them (Observed)

## Still unknown
- `seg[140]` (one byte per dialogue) and the exact meaning of `seg[141]` (one byte per line, looks like the speaker). Neither affects triggers.
- What the technology presets 20..28 of command 33 look like in play. No campaign mission uses them.
- Win and lose rules above 50 are only reachable from downloaded maps. No sample map was available.

**Next:** [What happens in each of the seven missions?](13-missions-one-by-one.md)
