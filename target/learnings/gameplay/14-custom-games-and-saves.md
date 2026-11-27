# What are custom games, and how is progress saved?

> **In one line:** A custom game is a replay of a campaign mission you already won, or of a downloaded map, with its own save slot and its own difficulty; a save is one record of about 12 KB that packs the live state bit by bit.

## The short answer
- "Custom Game" has two entries: Continue (resume the custom save) and New Game, which opens Select Map, Load Map and Delete Map.
- Select Map lists the campaign missions you have completed, then the downloaded maps. There is no skirmish generator and no opponent setup.
- A custom game runs the same mission file and script as the campaign. It does not advance the campaign, raise your rank or add to the total score.
- There is exactly one save per mode: `aow211` for the campaign, `aow214` for custom games. Saving overwrites it.
- The save holds units, buildings, shots, fog, mines, walls, script position and enemy timers. Terrain, zones and the script itself are read again from the mission file.
- Loading an older state, or restarting, costs 10% of the time bonus each time.

## How it works

### The menus
The menu tree is data (`seg[80]` items, `seg[81]` offsets, `seg[82]` titles, `seg[83]` targets).

| Screen | Items |
|---|---|
| Main | Campaign, Custom Game, Options, Rank, Help, About, More games, Exit |
| Campaign | Continue, New game |
| Custom Game | Continue, New Game |
| New Game (custom) | Select Map; Load Map and Delete Map when the online part is available |
| Pause | Continue, Objectives, Save, Load, Rank, Help, Options, Restart, Main Menu |

Entering the Campaign screen sets the mode flag `t = 0`, entering Custom Game sets `t = 1`. After a map is chosen the Difficulty screen follows (Easy / Hard). The choice is stored separately per mode (`p` for campaign, `q` for custom). The "Turn on tutorial?" question is asked only in campaign mode.

### What a custom game changes

| | Campaign (`t = 0`) | Custom (`t = 1`) |
|---|---|---|
| Maps offered | next mission | completed missions `f200a[0..6]` + downloaded maps |
| On victory | mission marked complete, rank check, next mission unlocked, score added to the total | none of these. For a downloaded map its "done" byte is set |
| Save slot | `aow211`, mission number in `m` | `aow214`, mission number in `o` |
| Mission data | `mi<n>` from the JAR | same file, or record store `aow2m<n>` for n above 6 |

The battle itself is identical: same script, same enemy, same rank caps. A replayed campaign mission uses its own technology row. A downloaded map has number `server id + 6`, so it uses row 7 (see [file 9](09-tech-availability.md)) and dialogue base 32 with the generic texts from file `dmt`.

### Record stores

| Store | Written by | Content |
|---|---|---|
| `aow2m<n>` | map download | One record: 2-byte length, then the map in `mi` format. On load it is copied into the resource buffer and the 39 bytes of `dmt` are appended. |
| `aow211` | Save, campaign | One mid-mission save game. |
| `aow214` | Save, custom | Same layout as `aow211`. |
| `aow212` | many places | Profile: install id (random 9 digits), saved mission `m`, next mission `n`, 7 "completed" flags, list of downloaded maps (id, name), 2 + 15 achievement and map-done bytes, custom saved mission `o`, tutorial flag, graphics level, both difficulties, rank, total score, last score. |
| `aow213` | pause, victory, restart, load | Two ints: `r` = furthest game tick reached in this mission, `s` = retry count. |

### What a save contains
In write order:
1. **Header, 47 bytes:** next entity serial, game tick, player side, shot ring head and count, script pointer, win rule, score inputs `e` and `f`, lose rule, objective number, time of last script command, loop counter, "need room" value, camera x and y, research bitmask (64 bits), result state and countdown, both Hard multipliers, cursor x and y, one more byte, victory dialogue.
2. **Explored map:** 4 x 128 ints, one bit per cell (2048 bytes). The "visible now" layer is rebuilt.
3. **Mines:** count, then x, y, kind. **Walls:** count, then x, y, damage value.
4. **Bit-packed block:** each value uses only the bits it needs.
   - both sides' 10 counters (units, buildings, energy used, energy made, money, kills, ...) at 18 bits;
   - the 4 control groups, 51 x 7 bits each;
   - the unit and building table: 72 fields x 100 slots, widths from `seg[8]` (0 to 8 bits, 432 bits per slot in total), offsets from `seg[9]`;
   - 60 production queue slots (item, count, owner);
   - 400 shot slots, 14 fields each;
   - enemy AI state per group: list-complete flag, build list number, Headquarters count, wall and alarm flags, both training orders, wave interval, three timers.
5. **Tail:** technology preset, wave flag.

Total: about 12 KB (Inferred from the widths). Four unit fields have width 0 and are rebuilt: path position, path length, the "seen by player" counter and the powered flag.

### Loading
Continue first loads the mission with the flag `l = false`. That reads terrain, zones, routes and script as usual but skips placing the starting buildings and walls. Then the record is read back, every finished research is applied again, power is recomputed, the cell grid is refilled from the unit and building tables, and the enemy build lists are rebuilt from the saved list numbers. In campaign mode, Continue starts the next mission fresh when it is newer than the saved one.

The random generator is not saved. A reloaded game will not replay the same rolls.

### The retry counter
`r` is stored when you pause and whenever the game is interrupted. On load, if `r` is larger than the tick inside the save, you have gone back in time: `s` goes up by one. Restart does the same. At victory the time bonus is multiplied by 0.9 once per `s`.

## How we know
- `a.json seg[80..83]` with strings T0_0..T0_40 : the menu table above (Observed)
- [`g.java:3742`](../source/decompiled/g.java#L3742) : `t` set by screens 4 and 5; [`g.java:3060`](../source/decompiled/g.java#L3060) : difficulty stored in `p` or `q`; [`g.java:3685`](../source/decompiled/g.java#L3685) : tutorial question skipped when `t == 1` (Observed)
- [`g.java:3509`](../source/decompiled/g.java#L3509)-[`3522`](../source/decompiled/g.java#L3522) : the custom New Game list is built from Select Map, Load Map, Open maps, Delete Map (Observed)
- [`g.java:3592`](../source/decompiled/g.java#L3592), [`g.java:3598`](../source/decompiled/g.java#L3598) : Select Map list; [`g.java:8815`](../source/decompiled/g.java#L8815), [`g.java:8825`](../source/decompiled/g.java#L8825) : pick gives mission 0..6 or map id + 6 (Observed)
- [`g.java:1460`](../source/decompiled/g.java#L1460), [`g.java:1470`](../source/decompiled/g.java#L1470) : total score and campaign progress only when `t == 0`; [`g.java:3090`](../source/decompiled/g.java#L3090) : map-done byte (Observed)
- [`g.java:928`](../source/decompiled/g.java#L928) : missions above 6 come from a record store; [`g.java:6223`](../source/decompiled/g.java#L6223), [`g.java:6247`](../source/decompiled/g.java#L6247), [`g.java:6262`](../source/decompiled/g.java#L6262), [`g.java:8473`](../source/decompiled/g.java#L8473) : write, read, `dmt` append, delete (Observed)
- [`g.java:6346`](../source/decompiled/g.java#L6346)-[`6379`](../source/decompiled/g.java#L6379) : profile fields in order; [`g.java:6434`](../source/decompiled/g.java#L6434) : defaults for a new profile (Observed)
- [`g.java:6464`](../source/decompiled/g.java#L6464) : slot name by mode; [`g.java:6467`](../source/decompiled/g.java#L6467)-[`6491`](../source/decompiled/g.java#L6491) : header; [`g.java:6495`](../source/decompiled/g.java#L6495) : explored map; [`g.java:6514`](../source/decompiled/g.java#L6514), [`g.java:6532`](../source/decompiled/g.java#L6532) : mines and walls; [`g.java:6543`](../source/decompiled/g.java#L6543)-[`6582`](../source/decompiled/g.java#L6582) : packed arrays; [`g.java:6586`](../source/decompiled/g.java#L6586) : tail (Observed)
- [`g.java:6148`](../source/decompiled/g.java#L6148) : the bit packer; `a.json seg[8]` sums to 432, zero at fields 10, 11, 51, 71 (Observed)
- [`g.java:3144`](../source/decompiled/g.java#L3144)-[`3166`](../source/decompiled/g.java#L3166) : Continue; [`g.java:958`](../source/decompiled/g.java#L958) : entities placed only when `l` is true (Observed)
- [`g.java:6706`](../source/decompiled/g.java#L6706), [`g.java:6721`](../source/decompiled/g.java#L6721), [`g.java:6730`](../source/decompiled/g.java#L6730), [`g.java:6761`](../source/decompiled/g.java#L6761) : rebuild steps after reading (Observed)
- [`p.java:451`](../source/decompiled/p.java#L451) : `new Random()` with no seed, and no generator state in the save (Observed)
- [`g.java:1346`](../source/decompiled/g.java#L1346), [`g.java:2085`](../source/decompiled/g.java#L2085) : `r` stored on pause and interruption; [`g.java:6747`](../source/decompiled/g.java#L6747) : retry on load; [`g.java:3205`](../source/decompiled/g.java#L3205) : retry on restart; [`g.java:1450`](../source/decompiled/g.java#L1450) : x0.9 per retry (Observed)

## Still unknown
- The format of a real downloaded map. The loader re-opens a JAR file `mi<n>` after reading an external terrain, which cannot work above 6, so such maps must carry their terrain inline (Inferred). No sample was available.
- The byte `af` in the save header.
- In the New game / Restart handler ([`g.java:3190`](../source/decompiled/g.java#L3190)) the campaign and custom branches look swapped in the decompiled text. Which counters each mode resets is not certain.

**Next:** [Back to the gameplay index](README.md)
