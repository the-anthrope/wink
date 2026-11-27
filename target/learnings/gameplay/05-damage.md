# How much damage does a hit do?

> **In one line:** A hit does the weapon's damage cut down by the target's armour (10% per armour point for weapons of 10 or more, 1 point per armour point for weaker ones), never less than 1, with no dice.

## The short answer

- **One formula** for everything: `damage = max(min(D x (10 - A) / 10, D - A), 1)`. `D` is the weapon's damage, `A` the target's armour. Integer maths, rounded down.
- **No randomness in damage, and bullets never miss.** Once a bullet is fired at a target, that target takes the damage when the bullet arrives.
- **Shells and rockets hit an area** of 3 x 3 cells. The centre cell takes full damage, the 8 cells around it take 25% to 67%. This hurts friend and foe alike.
- **The "Attack" number in the build menu is not used in combat.** Real damage belongs to the weapon. The T-22 Zeus shows 24 but its shell does 35. The Sniper shows 12 but his bullet does 7.
- **Buildings have armour 8**, so big guns do 20% and rifles do 1 point. Walls have armour 0 and their own hit counter.
- **Flame is special:** it kills enemy infantry outright, does 12 damage to machines and buildings, and never touches the player's own units.

## How it works

### The formula

For `D` of 10 or more the percentage part is the smaller one, so each armour point removes 10%. For `D` below 10 the subtraction is smaller, so each armour point removes 1. This is why rifles are nearly useless against tanks.

| weapon damage `D` | A=0 | A=1 | A=2 | A=3 | A=4 | building A=8 | A=9 |
|---|---|---|---|---|---|---|---|
| 4 (Infantry rifle) | 4 | 3 | 2 | 1 | 1 | 1 | 1 |
| 5 (Assault rifle) | 5 | 4 | 3 | 2 | 1 | 1 | 1 |
| 8 (Grenadier) | 8 | 7 | 6 | 5 | 4 | 1 | 1 |
| 10 (Heavy Assault) | 10 | 9 | 8 | 7 | 6 | 2 | 1 |
| 20 (T-21 Hammer, Rhino) | 20 | 18 | 16 | 14 | 12 | 4 | 2 |
| 25 (MLRS, march form) | 25 | 22 | 20 | 17 | 15 | 5 | 2 |
| 35 (T-22 Zeus, MLRS salvo) | 35 | 31 | 28 | 24 | 21 | 7 | 3 |

Armour values (`seg[29]`): Infantry, Assault, Grenadier, Sniper, Flame Assault 0. Heavy Assault, Coyote, Sniper in siege form 1. Armadillo 2. T-21 Hammer 3. Rhino, AV-40, T-22 Zeus, Porcupine, MLRS 4. Every building 8. Every wall 0. *Energy suit* and *Energy armour* add 2 to Confederation infantry and machinery. *Titanium cover* raises building armour to 9, which halves what big guns do.

### Bullets, shells and rockets

- **Bullets** (rifles, machine guns, sniper, bunker and tower guns) carry the index of their target. On arrival the target takes the damage if it is still the same unit. Where the target stands by then only changes the little impact picture.
- **Shells and rockets** fly to where the target stood when they were fired. They land on a cell and damage everything on that cell and the 8 cells around it: units of both sides, buildings, walls. A moving target can step out of the centre cell.
- A small random wobble is added to the flight of some weapons. For bullets it is cosmetic. For shells it can shift the landing cell.

| splash on the 8 neighbour cells | weapons |
|---|---|
| 3/12 = 25% | Grenadier, Heavy Assault rockets |
| 4/12 = 33% | T-21 Hammer and Rhino shells |
| 6/12 = 50% | T-22 Zeus shell and rockets, Rhino in siege form, MLRS march rocket, Porcupine rockets, Rocket launcher |
| 8/12 = 67% | MLRS salvo in siege form |

Armour is applied first, then the fraction, then the minimum of 1. A building is hit once for every one of its cells inside the blast, so a shell that lands in the middle of a large building counts up to 9 times.

### Flame

A flame puff lives 6 ticks and checks the cell under it on ticks 2, 4 and 6, which are the first three cells along the line of fire. On each check:

- a unit of the player's side: nothing happens;
- any other infantry: it loses all its health;
- a machine, a building or a wall: 12 damage through the normal formula. This includes the player's own buildings and walls.

### Buildings and walls

- Building health (`seg[59]`): Command center, Confederation Bunker, Rebel Headquarters 250. Rebel Bunker 180. Rocket launcher, Tower 160. Machine factory, Barracks 150. Technology center 100. All others 120.
- A wall has a counter from 0 to 99. Each hit adds `damage / 2`, rounded down. When the counter passes 99 the wall is gone. So a wall takes 200 points of raw damage. *Walls Active armour* changes the divisor to 4, which doubles that.

### Worked example: T-21 Hammer against a Rhino

Assumptions: no research on either side, the Rhino stands still, 1 tick = 100 ms.

- Hammer gun: `D` = 20, one shell every 12 ticks. Rhino: 100 health, armour 4.
- Per shell: `min(20 x 6 / 10, 20 - 4) = min(12, 16) = 12`.
- The Rhino regains 1 health every 30 ticks, about 3 during the fight. `9 x 12 = 108` covers 103, so it takes **9 shells**, fired over `8 x 12 = 96` ticks, about **9.6 s**.
- The other way round: Rhino gun `D` = 20 every 14 ticks against Hammer armour 3 and 90 health. `min(14, 17) = 14` per shell, 7 shells, `6 x 14 = 84` ticks, **8.4 s**. The Rhino wins the duel.
- With *Heavy shells* the Hammer does 25, so 15 per shell and 7 shells in 7.2 s. Now the Hammer wins.

### After the hit

A unit that is hit by an enemy, is alive, has no target and is not under a player order turns on the shooter. Idle friends within its sight range join in. A building that is hit calls idle friends within 7 cells. Health at 0 starts the death animation; the unit leaves the map when it ends.

## How we know

- [`p.java:2478`](../source/decompiled/p.java#L2478) : the formula, for a direct hit (Observed). Same expression at [`p.java:2451`](../source/decompiled/p.java#L2451) (splash), [`p.java:2397`](../source/decompiled/p.java#L2397) (flame), [`p.java:2781`](../source/decompiled/p.java#L2781) (mines)
- [`p.java:644`](../source/decompiled/p.java#L644) : weapon rows loaded from `seg[35]` (damage), `seg[36]` (range), `seg[37]` (reload) (Observed)
- [`p.java:2396`](../source/decompiled/p.java#L2396) : armour is `seg[29]` for a unit, `G[side]` for a building, 0 for a wall. [`p.java:653`](../source/decompiled/p.java#L653) : `G` starts at 8. [`p.java:3659`](../source/decompiled/p.java#L3659) : Titanium cover sets 9 (Observed)
- [`p.java:3531`](../source/decompiled/p.java#L3531) : research adds to the weapon row and, separately, to the display row `seg[31]`. No other code in `p.java` reads the display row. [`g.java:4817`](../source/decompiled/g.java#L4817) prints it (Observed)
- [`p.java:2463`](../source/decompiled/p.java#L2463) : a bullet damages its target whenever the target's generation number still matches (Observed). The hit-box test at [`p.java:2429`](../source/decompiled/p.java#L2429) only picks the impact animation (Observed)
- [`p.java:2436`](../source/decompiled/p.java#L2436) : weapons with `seg[47]` not 0 damage the 3 x 3 block, with no check of sides (Observed)
- [`p.java:2309`](../source/decompiled/p.java#L2309) : random wobble from `seg[39]` (Observed). Effect on the landing cell (Inferred)
- [`p.java:2392`](../source/decompiled/p.java#L2392) : flame checks, skipping units of side `f315j`. [`k.java:384`](../source/decompiled/k.java#L384) : that side is always 0, the player. Checked against the bytecode of `p.class`. Help text `T1_106` agrees (Observed)
- [`p.java:2394`](../source/decompiled/p.java#L2394) : flame damage to infantry = its current health (Observed)
- [`p.java:2302`](../source/decompiled/p.java#L2302) : flame speed capped at 15 px, 10 px per tick, so half a cell (Observed). "First three cells" (Inferred)
- [`p.java:2569`](../source/decompiled/p.java#L2569) : building health. [`p.java:2520`](../source/decompiled/p.java#L2520) : wall counter and divisor `f294a`. [`k.java:327`](../source/decompiled/k.java#L327), [`p.java:651`](../source/decompiled/p.java#L651) : divisor 2. [`p.java:3662`](../source/decompiled/p.java#L3662) : research adds 2 (Observed)
- [`p.java:2511`](../source/decompiled/p.java#L2511) : hit-back rule. [`p.java:3893`](../source/decompiled/p.java#L3893) and [`p.java:4111`](../source/decompiled/p.java#L4111) : friends within sight range join (Observed; JADX prints the distance test at 4112 the wrong way round, the bytecode says "distance <= range")
- [`p.java:1831`](../source/decompiled/p.java#L1831) : attacked building calls friends within 7 cells (Observed)
- [`p.java:1371`](../source/decompiled/p.java#L1371) : regeneration used in the example, `seg[16]` = 30 ticks for machinery (Observed)
- [`../source/tools/weapons_table.py`](../source/tools/weapons_table.py) : prints the damage matrix above from `a.json`

## Still unknown

- Footprint sizes were not read here, so "up to 9 times" for buildings is an upper bound.
- How often shell wobble really moves the landing cell. In high-detail graphics mode a shot takes twice as many half-steps, which may double the wobble.
- Whether any mission script changes armour or damage. None was seen in `p.java`.

**Next:** [What weapons, variants and special modes exist?](06-weapons-and-special-modes.md)
