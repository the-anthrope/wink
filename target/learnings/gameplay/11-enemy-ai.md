# How does the computer opponent play?

> **In one line:** The enemy has no planner. A per-mission script switches a handful of timers (rebuild, train, send a wave, repair walls, lay mines, research), and everything it makes is free.

## The short answer
- The enemy never decides *what* to do. The mission script tells each of up to three enemy "groups" (bases) what to train and how often to attack.
- It never chooses *where* to attack either. Waves walk one of the routes drawn by the mission designer, picked at random.
- It cheats on money: units, buildings and research cost it nothing. It does need energy, so killing Powerplants switches its buildings off.
- A group stops rebuilding, repairing walls and laying mines once its last Headquarters is dead. Training and waves go on.
- Hard makes enemy batches 1.4x to 2.0x larger, enemy training 25% faster and its orders 25% more frequent. Your scripted reinforcements shrink to x0.8 or x0.9.
- Units of both sides share one behaviour: shoot the toughest target in view, follow it while it stays in sight, hit back when shot, call idle friends.

## How it works

One simulation tick is 100 ms. Every 10 ticks (1 second) the game runs the enemy logic for the side that is not the player. The enemy is split into groups 0..2. Every enemy building carries a group number (the 4th byte of its record in the mission file) and every enemy unit carries the group of the building or script command that created it.

| Timer (per group) | Period | What happens |
|---|---|---|
| Rebuild | 20 s. After the list is complete: 80 s on Easy, 30 s on Hard | Walk the group's build list. For the first entry with no matching live building, try 20 random spots inside the group's build zone and place it there. One building per pass. |
| Train | 150 s on Easy, 112.5 s on Hard | Every idle Barracks or Factory of the group queues one batch of the ordered kind. |
| Wave | `value x 20 s` plus 0..20 s random | Every unit of the group that has no route gets one. |
| Wall repair | 20 s | Put back one missing wall tile. |
| Mines | 10 s | Lay one mine at a random cell of the group's mine fields (max 4 mines around it). |
| Research | 42 s (shared) | An idle Laboratory may start the next allowed research. |

**Build list.** At load the list is "the enemy buildings that stand inside a build zone". Script command 32 can replace it with a list from `seg[107]`/`seg[108]` (list 1 has 23 buildings, list 2 has 15, list 0 is empty). New buildings appear at 10% hit points and grow like a player construction. Quirk: the "list complete" test compares against an absolute table offset, so it only ever becomes true for list 1 and for the load-time list. Missions that use list 2 keep the fast 20 s cadence for the whole game.

**Training.** An order is one number: `composition x 3 + size`. Sizes are 3 / 6 / 10 for Barracks and 2 / 4 / 6 for Factory. Compositions: Barracks 0 = Infantry, 1 = Grenadier, 2 = Sniper, 3 = any of the three. Factory 0 = Coyote or Armadillo, 1 = Armadillo or Rhino, 2 = Rhino or Porcupine, 3 = any. One unit type is rolled per batch. Trained units walk to the group's rally points, which are used in turn.

**Waves.** When the wave timer fires, the game counts the group's units `n` and forms squads of `n / max(n/12 + rnd(0..1), 1) + 1` units. Each squad gets one random route. Units walk it in attack-move. They wait at the third-from-last waypoint until the slowest squad member is expected to arrive, then go in together. Survivors that finish a route are idle again, so the next wave tick sends them back to waypoint 0 and round again (Inferred).

**Defence.** Three things. (1) A unit or building that is hit calls idle friends: a unit alerts those within its own sight range, a building alerts those within 7 cells. (2) Walls and mines are topped up as in the table. (3) An "alarm area" per group is meant to pause wall repair and mine laying while player units are inside. The file stores it as x, y, width, height but the code compares the last two bytes as far corners, so in missions 2 and 7 it can never trigger.

**Siege mode.** Enemy Snipers switch to siege form when their target is a building or when enemy units worth 10 hit points stand within 5 cells of the target. Rhinos need 200 hit points there and the Rebel research that unlocks their siege form. They switch back when the target leaves range.

**Does it cheat?**

| Question | Answer |
|---|---|
| Money | Yes. No cost and no money check for its units. Buildings and research are created directly. It earns no Headquarters income. |
| Energy | No cheat. The same power check runs for both sides. |
| Fog | Effectively yes. A target is valid if the *player* can currently see that cell, and the player always sees his own units and buildings. |
| Unit cap | 50, not tied to rank. |
| Free armies | Yes. Script command 27 creates units at a map edge. |

**Easy versus Hard** (`g.d`: 0 = Easy, 1 = Hard)

| Effect | Easy | Hard |
|---|---|---|
| Enemy batch and spawn size | x1.0 | x1.4 to x2.0, set per mission |
| Player scripted reinforcements | x1.0 | x0.8 or x0.9 in missions 4 to 7 |
| Train order period | 150 s | 112.5 s |
| Enemy unit build time | x1 | x3/4 |
| Rebuild period after list complete | 80 s | 30 s |
| Research start chance per check | about 70% | about 90% |
| Mission score | divided by 2 | full |

**Unit behaviour, both sides.** A unit thinks only when it stands on a cell centre.
- *Acquire:* if it has no forced move order and no target in weapon range, it scans a square of `max(sight, range)` cells. Enemy units are checked first, buildings only if it has no target at all. Among candidates it prefers the unit type with the highest maximum hit points, then the nearest. For buildings, armed ones first.
- *Chase:* the target's cell becomes the destination. The unit stops when the distance is within its attack range. The target is dropped when it leaves sight range (Inferred, that function decompiled badly).
- *Retaliate:* a unit that is hit, has no order and no target, targets the attacker. Splash damage does not trigger this.
- *Weapons:* each of up to three weapon slots can pick its own target inside its own range and arc, so turreted vehicles fire while moving.
- *Idle:* nothing else. No patrol, no wandering. Scripted enemy units stand where they appeared until a wave timer picks them up.

## How we know
- [`k.java:771`](../source/decompiled/k.java#L771), [`k.java:784`](../source/decompiled/k.java#L784) : one `p.b()` call per frame, frame padded to 100 ms (Observed)
- [`p.java:1267`](../source/decompiled/p.java#L1267) : enemy logic every 10 ticks; [`p.java:1270`](../source/decompiled/p.java#L1270) : rebuild period 200 ticks, or 800 / 300 once `f433a` is set (Observed)
- [`p.java:1280`](../source/decompiled/p.java#L1280), [`p.java:1291`](../source/decompiled/p.java#L1291), [`p.java:1303`](../source/decompiled/p.java#L1303) : match list entry to a live building, 20 random tries in zone, create (Observed)
- [`p.java:1312`](../source/decompiled/p.java#L1312) : "complete" compares the loop index with `seg[108][list+1]`; `a.json seg[108]` = 0,0,23,38,41 (Observed). The quirk follows (Inferred)
- [`g.java:6104`](../source/decompiled/g.java#L6104) : new building starts at max/10 hit points; [`g.java:6134`](../source/decompiled/g.java#L6134) : Headquarters counter `z[group]`; [`p.java:1683`](../source/decompiled/p.java#L1683) : counter drops when one dies (Observed)
- [`p.java:3134`](../source/decompiled/p.java#L3134) : order period `1500 x (4 - d) / 4` ticks; [`p.java:3145`](../source/decompiled/p.java#L3145) : unit type from `seg[110..113]`; [`p.java:3146`](../source/decompiled/p.java#L3146) : size from `seg[114]`/`seg[115]` times `f421h/10` on Hard; [`p.java:3150`](../source/decompiled/p.java#L3150) : rally points in turn (Observed)
- [`p.java:3181`](../source/decompiled/p.java#L3181) : squad size; [`p.java:3194`](../source/decompiled/p.java#L3194) : random route; [`p.java:3215`](../source/decompiled/p.java#L3215) : next wave time; [`p.java:1513`](../source/decompiled/p.java#L1513) : wait at waypoint `count-3`; [`p.java:1530`](../source/decompiled/p.java#L1530) : enemy waypoint moves are not forced moves (Observed)
- [`p.java:3033`](../source/decompiled/p.java#L3033), [`p.java:3042`](../source/decompiled/p.java#L3042) : wall timer and the alarm test with `<=` on bytes 3 and 4; mission data such as `(50,6,30,24)` only makes sense as width and height (Observed data, Inferred bug)
- [`p.java:3072`](../source/decompiled/p.java#L3072), [`p.java:3093`](../source/decompiled/p.java#L3093) : mine timer and the "fewer than 5 neighbours" rule (Observed)
- [`p.java:3099`](../source/decompiled/p.java#L3099), [`p.java:3108`](../source/decompiled/p.java#L3108), [`p.java:3113`](../source/decompiled/p.java#L3113) : research check, chance `nextInt() % 10 < 4 x (1 + d)`, first allowed item, no cost (Observed). 70% / 90% assumes Java's signed remainder (Inferred)
- [`p.java:2030`](../source/decompiled/p.java#L2030) : money test and deduction skipped for the enemy side; [`p.java:1773`](../source/decompiled/p.java#L1773) : income only for the non-enemy side; [`p.java:3481`](../source/decompiled/p.java#L3481) : power check for either side (Observed)
- [`p.java:1930`](../source/decompiled/p.java#L1930) : build time factor `(4 - (side + d)/2) / 4`; [`p.java:1935`](../source/decompiled/p.java#L1935) : cap is rank-based for the player, 50 for the enemy (Observed)
- [`p.java:4074`](../source/decompiled/p.java#L4074) : target cell must be set in `f301a[1]`; [`p.java:4174`](../source/decompiled/p.java#L4174) : that bitmap is built from the player's units and buildings (Observed)
- [`p.java:3990`](../source/decompiled/p.java#L3990), [`p.java:4000`](../source/decompiled/p.java#L4000), [`p.java:4007`](../source/decompiled/p.java#L4007) : when a unit scans, the radius, units before buildings; [`p.java:4098`](../source/decompiled/p.java#L4098), [`p.java:4103`](../source/decompiled/p.java#L4103) : priority = max hit points of the type (`seg[42]`), then distance (Observed)
- [`p.java:2511`](../source/decompiled/p.java#L2511) : retaliation conditions; [`p.java:3892`](../source/decompiled/p.java#L3892), [`p.java:4112`](../source/decompiled/p.java#L4112) : alert idle friends in sight range; [`p.java:1831`](../source/decompiled/p.java#L1831) : attacked building alerts within 7 (Observed)
- [`p.java:1536`](../source/decompiled/p.java#L1536), [`p.java:1542`](../source/decompiled/p.java#L1542) : enemy siege toggle; `a.json tables[4]` = 10 for type 4, 200 for type 10; [`p.java:3809`](../source/decompiled/p.java#L3809) : Rebel research 36 gives the Rhino its siege form (Observed)
- [`p.java:3329`](../source/decompiled/p.java#L3329), [`p.java:4176`](../source/decompiled/p.java#L4176) : row 1 of `f520r` is sight; [`p.java:1402`](../source/decompiled/p.java#L1402) : row 3 is attack range (Observed)

## Still unknown
- `p.m78a` ([`p.java:3318`](../source/decompiled/p.java#L3318)) is marked "decompiled incorrectly". The exact rule for dropping a target is inferred from its readable ends.
- Whether the enemy money set by script command 25 is read anywhere. No reader was found.
- Flag `f461o` (script value 29) changes how a blocked wave unit behaves at its gathering point. No campaign mission sets it.

**Next:** [How is a mission scripted?](12-mission-scripting.md)
