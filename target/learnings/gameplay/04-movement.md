# How do units move and find their way?

> **In one line:** Units step from cell to cell on a grid of 30 x 20 pixel cells, in 8 directions, one unit per cell, following a straight line with detours traced around obstacles. There is no A* search and there are no formations.

## The short answer

- **Grid.** The map is at most 128 x 128 cells. A cell holds one thing: a unit, part of a building, a wall, a mine, blocked terrain, or nothing.
- **Speed.** Each unit type has a *move period*: the number of game ticks one straight step takes (4 to 9 ticks, so 0.4 to 0.9 s per cell). A diagonal step takes about 1.4 times as long. The build menu shows `speed = 10 - period`.
- **Turning.** Vehicles must turn the hull to face the next cell before they move (2, 4 or 6 ticks per 45 degrees). Infantry turns at once.
- **Route finding** is "draw a line, then walk around whatever is in the way". One plan is at most 50 cells long and handles at most 10 obstacles. The rest is planned when the unit gets there.
- **Group orders** send every selected unit to the same cell. A unit that finds its way blocked within 5 cells of the goal just stops.
- **Crushing.** Machinery of types 7 to 13 drives over enemy infantry and kills it. Units in siege form cannot move.

## How it works

Time unit: 1 game tick = 100 ms (10 ticks per second), assuming the phone keeps up with the frame budget.

### The grid

Everything that blocks a cell lives in one 16-bit grid, `f511c[y][x]`:

| value | meaning |
|---|---|
| 0 | free |
| 1..100 | the unit with that index (1..50 player, 51..100 enemy) |
| -1..-100 | the building with that index, on every cell of its footprint |
| 121, 122, 123 | a mine of kind 0, 1, 2 (units may walk onto it) |
| 124, 125, 126 | blocked ground or scenery from the map file |
| 127 | reserved: a unit is stepping into this cell |
| 128 and up | the anchor cell of a scenery object |
| 1001..1100, 1101..1200 | a wall of side 0, side 1. The offset is the damage it has taken |

Distances everywhere are straight-line distances in cells, rounded, read from a 31 x 31 table. The table stops at 15 cells.

### One step

| move period | 4 | 5 | 6 | 7 | 8 | 9 |
|---|---|---|---|---|---|---|
| straight step, ticks | 4 | 5 | 6 | 7 | 8 | 9 |
| diagonal step, ticks | 6 | 7 | 8 | 10 | 11 | 13 |
| straight cells per second | 2.5 | 2.0 | 1.67 | 1.43 | 1.25 | 1.11 |
| units | Coyote | Infantry, Armadillo | Assault, Grenadier, T-21 Hammer, Rhino | Heavy Assault, Sniper, Flame Assault, AV-40, Porcupine | T-22 Zeus | MLRS Torrent |

A step works like this:

1. The unit looks at the next cell of its route. If it is free (or a mine), the cell is marked 127 so nobody else takes it.
2. A step counter runs from 0 to `n - 1`, one per tick. Pixel offsets inside the cell come from small tables, so the sprite glides.
3. Half way through, the unit leaves the old cell and takes the new one.
4. When the counter is back at 0 the unit is centred and may think again.

The same period is also the thinking interval of a standing unit: it looks for targets and re-plans once per period. A moving unit thinks once per cell.

*Reinforced engine* lowers the period by 1 for Confederation machinery, which is the "+1 speed" of the help text.

### Turning

Facing is a number 0..7: 0 = east, then clockwise (2 = down the screen). The hull turns one 45 degree step on every tick where `(tick + unit index) % turn period == 0`, the short way round.

| hull turn period (ticks per 45 degrees) | units |
|---|---|
| 0 (instant) | all infantry, all siege forms |
| 2 | Coyote, Armadillo, Rhino |
| 4 | AV-40, T-21 Hammer, T-22 Zeus, Porcupine |
| 6 | MLRS Torrent |

### Finding a route

1. Split the trip into straight steps and diagonal steps. Build three candidate lines: straight steps first, diagonal steps first, and the two mixed evenly. Count the blocked cells on each and keep the line with the fewest.
2. Walk along that line and note each blocked stretch (at most 10), with the free cell before it (entry) and after it (exit).
3. For each stretch, hug the obstacle both clockwise and anticlockwise, at most 50 steps each way, until an exit cell of this or a later stretch is reached. Splice the shorter detour into the line.
4. If neither way gets through, the route ends at the traced cell that is closest to the goal.
5. A second pass uses the middle of each detour as a waypoint and plans again from waypoint to waypoint. This straightens the path.

Blocked means any non-zero cell, with these exceptions: the unit's own cell, mines, cells the player has never seen (player units only), and enemy infantry when the mover is a crusher.

### When the way is blocked

- With an attack target: plan again.
- Without a target: plan again if a later cell of the route is free or the goal is more than 5 cells away. Otherwise stop here and drop the order. This is how a crowd settles around one destination.
- If planning returns nothing several thinks in a row (a counter reaches 5), the unit gives up.
- Walls: every armed unit first plans as if enemy walls were not there. If that route meets an enemy wall within the first few cells (as many cells as its attack range) and the honest route around is over 10 cells longer, the unit targets the wall and shoots it open.

### Crushing

Types 7 to 13 (AV-40 with flame gun, Armadillo, T-21 Hammer, Rhino, T-22 with rocket launcher, Porcupine, MLRS in march form) treat enemy infantry as walkable. When such a vehicle takes the cell, the soldier dies at once. The plain AV-40 (type 18), the plain T-22 (type 17) and the Coyote (type 6) are not in the list, so they do not crush.

## How we know

- [`p.java:2277`](../source/decompiled/p.java#L2277), [`p.java:2371`](../source/decompiled/p.java#L2371) : cell = 30 px wide, 20 px tall (Observed)
- [`g.java:1073`](../source/decompiled/g.java#L1073) : map loader fills the grid with 124, then 125/126/128+ for scenery, then clears passable cells (Observed)
- [`g.java:960`](../source/decompiled/g.java#L960), [`g.java:6121`](../source/decompiled/g.java#L6121) : wall and building values in the grid (Observed)
- [`p.java:2157`](../source/decompiled/p.java#L2157) : step counter modulo `seg[23]` (straight) or `seg[24]` (diagonal), indexed by the move period (Observed)
- `../source/data/a.json` `seg[27]` = move period per type, `seg[23]` = [0,0,2,3,4,5,6,7,8,9], `seg[24]` = [0,0,3,4,6,7,8,10,11,13] (Observed)
- [`p.java:2160`](../source/decompiled/p.java#L2160) : cell change at the half-way step (Observed)
- [`p.java:1609`](../source/decompiled/p.java#L1609) : next cell reserved with 127 (Observed)
- [`p.java:1647`](../source/decompiled/p.java#L1647), [`p.java:1405`](../source/decompiled/p.java#L1405) : thinking runs when a counter modulo the move period is 0 (Observed)
- [`g.java:4823`](../source/decompiled/g.java#L4823) : menu speed = 10 - period. [`p.java:3579`](../source/decompiled/p.java#L3579) : Reinforced engine subtracts 1 (Observed). Help text `T1_109` agrees.
- [`p.java:2208`](../source/decompiled/p.java#L2208) : turning. `seg[32]` = turn period (3 per type: hull, turret 1, turret 2), `seg[33]` = which way to turn, `seg[1]` = the 8 direction vectors (Observed)
- [`p.java:954`](../source/decompiled/p.java#L954) : three candidate lines, built from `seg[0]` (straight and diagonal step for each of 8 octants) (Observed)
- [`p.java:1071`](../source/decompiled/p.java#L1071) : at most 10 blocked stretches. [`p.java:1101`](../source/decompiled/p.java#L1101) : 50 tracing steps per side. [`p.java:771`](../source/decompiled/p.java#L771) : 50 cells per plan (Observed)
- [`p.java:846`](../source/decompiled/p.java#L846) : fallback to the closest traced cell. [`p.java:802`](../source/decompiled/p.java#L802) : waypoint pass (Observed, the summary of steps 3 to 5 is Inferred from dense code)
- [`p.java:1231`](../source/decompiled/p.java#L1231) : what counts as blocked (Observed)
- [`p.java:1566`](../source/decompiled/p.java#L1566) : blocked next cell, the 5-cell rule at line 1581 (Observed). [`p.java:889`](../source/decompiled/p.java#L889) : give-up counter (Observed)
- [`p.java:917`](../source/decompiled/p.java#L917) : plan through enemy walls, then shoot the wall when the detour is over 10 cells longer (line 944) (Observed)
- [`p.java:1569`](../source/decompiled/p.java#L1569), [`p.java:2189`](../source/decompiled/p.java#L2189) : crushing. Mask 16256 = types 7..13, mask 16447 = infantry types 0..5 and 14 (Observed)
- [`p.java:872`](../source/decompiled/p.java#L872) : siege forms (mask 114688 = types 14, 15, 16) get no route (Observed)
- [`g.java:3377`](../source/decompiled/g.java#L3377) : a move order writes the same destination cell into every selected unit (Observed)
- [`k.java:792`](../source/decompiled/k.java#L792) : one simulation step per 100 ms loop (Observed)

## Still unknown

- `seg[13]` (96 bytes) and the last 7 bytes of `seg[0]` are not read by the simulation. `seg[12]` is only the screen scroll step ([`g.java:4034`](../source/decompiled/g.java#L4034)).
- Exact behaviour of the tracer in tight corners. The code is dense and was read, not run.
- Scripted enemy patrol routes (unit fields 3535, 4545, 4646) were not followed up here.

**Next:** [How much damage does a hit do?](05-damage.md)
