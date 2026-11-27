# What can each side see?

> **In one line:** Only the player has fog of war: the map starts black, each of the player's units and buildings lights a disc around itself, and enemy units outside those discs can be neither seen nor targeted. The computer side needs no vision at all.

## The short answer

- **Fog is always on.** There are three states per cell: never seen (black), seen before (terrain and remembered buildings under a haze), visible now.
- **Sight range** is a per-type number of cells: 5 for most infantry, 7 to 8 for vehicles, 9 for the Sniper (12 in siege form), 11 for the MLRS in siege form.
- **Buildings see too.** A Command center sees 10 cells, a Bunker 8, and the **Locator 15**, the largest disc in the game.
- **An enemy that shoots gives itself away:** its own cell becomes visible while it fires.
- **You cannot order an attack on a unit you cannot see now.** Buildings and walls can be attacked once they have been seen.
- **Some weapons outrange their owner's sight** (MLRS in siege form 13 against 11, Rocket launcher 11 against 9). They need a spotter.

## How it works

### Two bit maps

The game keeps two bit maps of the whole map, both for the player only:

- **visible now**: wiped and rebuilt every 4 ticks (0.4 s);
- **explored**: every cell that has ever been visible. Bits are only added.

Each rebuild lights:

1. a disc around every unit of the player, radius = the unit's sight;
2. the single cell of every enemy unit that has a weapon firing;
3. a disc around every building of the player, radius from a per-building table. No check for power or for "finished" is made, so a Locator under construction already sees;
4. the footprint of every enemy building that currently has a target;
5. a disc requested by the mission script (step type 37), kept for 13 rebuilds, about 5 s.

The disc is an octagon. For radius 5 the rows are 3, 5, 7, 9, 11, 11, 11, 9, 7, 5, 3 cells wide.

### Sight ranges

| sight | units |
|---|---|
| 5 | Infantry, Assault, Grenadier, Heavy Assault, Flame Assault |
| 6 | Coyote |
| 7 | Armadillo, T-21 Hammer, AV-40 Fortress (both forms) |
| 8 | Rhino, T-22 Zeus (both forms), Porcupine, MLRS (march form) |
| 9 | Sniper, Rhino in siege form |
| 11 | MLRS in siege form |
| 12 | Sniper in siege form |

| sight | buildings |
|---|---|
| 5 | Generator, Powerplant |
| 6 | Infantry center, Machine factory, Technology center |
| 7 | Barracks, Factory, Laboratory |
| 8 | both Bunkers |
| 9 | Rocket launcher |
| 10 | Command center, Headquarters |
| 12 | Tower |
| 15 | Locator |

### What fog changes

- **Drawing.** Unexplored cells are black. Explored cells that are not visible get a haze sprite and units on them are not drawn. An enemy building is drawn from the moment it is first seen and stays drawn under the haze.
- **Orders.** An attack order on an enemy unit only sticks if its cell is visible now. For a building or a wall it is enough that the cell is explored. Otherwise the order becomes a plain move.
- **Automatic targeting.** A target is only considered if its cell is visible to the player now. The same test is used when the enemy looks for targets, but the player's units and buildings always stand inside their own discs, so it never stops the enemy. In effect the computer side has no fog.
- **Route finding.** The player's units treat unexplored cells as free ground when they plan, so a route does not reveal what is hidden.
- **Sight as a search radius.** An idle unit looks for targets within the larger of its sight and its range. When a unit picks a target or is shot at, idle friends within its sight join in.

### The Locator and the Alarm System

The Locator (building type 6, cost 250, 1 energy) has no weapon and makes nothing. Its only effect is the 15-cell disc, which lets long-range weapons use their full range and shows attacks early. The help text says "Used to reveal map. Has a long-range sight."

The build list of the Command center is a level, set per mission. The *Alarm System* research raises that level by 1, and the next level's list adds building 6. That is the "allows production of radars" of the help text.

### Worked example

An MLRS in siege form at cell (20, 20) sees 11 cells and shoots 13. An enemy Tower at (32, 20) is 12 cells away: in range, out of sight. The MLRS will not fire on its own, and an attack order works only if the Tower has been seen before. Put an Infantry (sight 5) at (28, 20) or a Locator within 15 cells of the Tower and the cell is visible, so the MLRS engages by itself.

## How we know

- [`p.java:1361`](../source/decompiled/p.java#L1361) : rebuild every 4 ticks while fog mode is below 2 (Observed)
- [`g.java:3972`](../source/decompiled/g.java#L3972) : fog mode is set to 0 or 1 by the graphics-detail setting (two haze sprites). No code sets 2 or more, so fog cannot be switched off (Observed)
- [`p.java:4168`](../source/decompiled/p.java#L4168) : the five sources of light, in the order listed. Line 4176 uses row 1 of the unit stats (`seg[28]`), line 4186 uses `seg[65]` (Observed)
- [`k.java:711`](../source/decompiled/k.java#L711) : one pair of bit maps, `[2][4][128]`. Index 1 = visible now, index 0 = explored ([`p.java:4215`](../source/decompiled/p.java#L4215)) (Observed)
- [`p.java:4225`](../source/decompiled/p.java#L4225) : disc rows from `seg[6]` and `seg[7]` (Observed)
- `../source/data/a.json` `seg[28]` = sight per unit type, `seg[65]` = sight per building type (Observed)
- [`p.java:2987`](../source/decompiled/p.java#L2987) : script reveal. [`p.java:4208`](../source/decompiled/p.java#L4208) : 13 rebuilds (Observed)
- [`g.java:4127`](../source/decompiled/g.java#L4127) : three drawing states. [`g.java:4142`](../source/decompiled/g.java#L4142) : units drawn only on visible cells. [`g.java:4164`](../source/decompiled/g.java#L4164) : haze sprite 1852 or 1853 (Observed)
- [`g.java:4314`](../source/decompiled/g.java#L4314) : a building gets flag bit 2 the first time it is drawn on a visible cell and is drawn from then on (line 4354) (Observed)
- [`g.java:3382`](../source/decompiled/g.java#L3382) : attack order needs visible (unit) or explored (building, wall) (Observed)
- [`p.java:4074`](../source/decompiled/p.java#L4074) : target search skips cells that are not visible now. Confirmed in the bytecode of `p.class`, because JADX duplicated and damaged this method (Observed). "The computer side has no fog" (Inferred from it)
- [`p.java:1235`](../source/decompiled/p.java#L1235) : unexplored cells count as free for the player's route planner (Observed)
- [`p.java:3999`](../source/decompiled/p.java#L3999) : search radius. [`p.java:3893`](../source/decompiled/p.java#L3893) : friends within sight join (Observed)
- `seg[60][6]` = -1, `seg[94][6]` = -1 : the Locator has no weapon and no production (Observed). `tables[6][6]` = 250, `seg[61][6]` = 1 (Observed)
- [`p.java:3669`](../source/decompiled/p.java#L3669) : research 18 adds 1 to the Command center's build level. `seg[95]`, `seg[96]` : build lists per level; levels 3 and 5 contain building 6, levels 2 and 4 do not. `seg[129]` : starting level per mission (Observed). Help texts `T1_91`, `T1_119` agree.
- Help text `T1_92` says the Rocket launcher has "a long-range sight but less missile range". The data says the opposite: sight 9, range 11 (Observed contradiction)

## Still unknown

- Whether the mini-map uses the same two bit maps. Not checked here.
- Unit field 5151 counts up when an enemy unit comes into view ([`p.java:1428`](../source/decompiled/p.java#L1428)). It looks like a fade-in for drawing only.
- Fog mode 2 exists in the code with broken (null) arrays. It looks like a removed variant.

**Next:** [What does each research do?](08-research-effects.md)
