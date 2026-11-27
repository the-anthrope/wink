# What weapons, variants and special modes exist?

> **In one line:** Each unit type carries up to three of 25 weapon records (one on the hull, two on turrets); type ids 7 and 11 are upgraded vehicles, 14, 15 and 16 are siege forms; mines, armed buildings, walls and slow self-healing complete the rules.

## The short answer

- **Weapons are data.** A weapon record has damage, range, reload time, projectile speed, splash and firing arc. A unit type lists which record sits in which of its 3 slots.
- **Rate of fire** is a reload period in ticks (10 ticks = 1 s). Rifles and machine guns skip the pause half of the time.
- **Variants:** type 7 = AV-40 with a second turret (flame gun), type 11 = T-22 with a rocket turret. Research converts every living vehicle on the spot.
- **Siege mode** swaps the unit to another type id: Sniper 4 to 14, Rhino 10 to 15, MLRS 13 to 16. The unit cannot move and gets a longer-ranged weapon. Only the MLRS in siege form can fire at empty ground.
- **Mines** come in 3 kinds (15, 30, 80 damage). Only the player's units set them off. The enemy keeps laying new ones.
- **Healing:** every unit regains 1 health every 2 s (infantry) or 3 s (machinery). Powered buildings regain 1 every 1.5 s. Walls never heal.

## How it works

### The weapon record

| data | meaning |
|---|---|
| `seg[35]`, `seg[36]`, `seg[37]` | damage, range in cells, reload period in ticks |
| `seg[38]` | projectile speed. Flight time in ticks = 4 x distance / speed |
| `seg[39]` | random wobble of the flight path |
| `seg[40]` | arc while the unit is moving: 4 = any direction, 1 = within 45 degrees of the heading, 0 = dead ahead |
| `seg[45]`, `seg[46]` | shot timing inside the reload cycle (see below) |
| `seg[47]` | splash on neighbour cells, in twelfths. 0 = single target |
| `seg[48]` | kind: 0 bullet, 1 shell, 2 rocket, 3 flame |
| `seg[34]` (3 per unit type) | weapon id in slot 0 (hull), 1 and 2 (turrets). -1 = empty |
| `seg[32]` (3 per unit type) | ticks per 45 degree turn of hull, turret 1, turret 2 |

### Who carries what

| unit (type id) | weapon id | damage | range | reload | shots per cycle | splash |
|---|---|---|---|---|---|---|
| Infantry (0) / Assault (1) | 0 / 1 | 4 / 5 | 4 | 8 or 4 | 1 | none |
| Grenadier (2) / Heavy Assault (3) | 15 / 16 | 8 / 10 | 5 | 10 | 1 | 25% |
| Sniper (4), siege form (14) | 2, 3 | 7 | 6, 9 | 20, 18 | 1 | none |
| Flame Assault (5) | 10 | 12 | 3 | 15 | 1 puff | line of 3 cells |
| Coyote (6) | 4 | 6 | 5 | 8 or 4 | 1 | none |
| Armadillo (8) | 5 | 7 | 6 | 12 or 8 | 3 | none |
| AV-40 Fortress (18) | 6 | 7 | 6 | 10 or 6 | 2 | none |
| AV-40 with flame gun (7) | 6 and 10 | 7 and 12 | 6 and 3 | as above | | |
| T-21 Hammer (9) | 11 | 20 | 6 | 12 | 1 | 33% |
| Rhino (10), siege form (15) | 12, 14 | 20, 16 | 6, 8 | 14, 12 | 1, 2 | 33%, 50% |
| T-22 Zeus (17) | 13 on the hull | 35 | 7 | 15 | 1 | 50% |
| T-22 with launcher (11) | 13 and 17 | 35 and 15 | 7 | 15 and 14 | 1 each | 50% |
| Porcupine (12) | 7 and 20 | 6 and 8 | 7 | 8 or 6, and 4 | 3 and 1 | none and 50% |
| MLRS (13), siege form (16) | 18, 21 | 25, 35 | 7, 13 | 16, 120 | 1, 5 | 50%, 67% |

### Rate of fire

While a weapon is engaged, a counter runs from 0 to `reload - 1` and wraps.

- `seg[46]` = 0: one shot per cycle, at counter = `seg[45]`.
- `seg[46]` above 0: a burst. A shot leaves whenever `counter % seg[45] == 1` and `counter < seg[46]`.
- Weapons 0, 1 and 4 to 9 (rifles and machine guns): when the counter reaches `seg[46]`, a coin flip restarts the cycle at once. That is the "8 or 4" in the table.
- Weapon 14 (Rhino in siege form) fires a second shell at counter 2.
- A turret must finish turning to the target before it fires.
- Research: *Enhanced firing rate* cuts the Assault reload from 8 to 6. *Fast recharging* cuts the Hammer from 12 to 10 and the Zeus from 15 to 13.

### Range and target choice

- A weapon fires when the target is within `seg[36]` cells. The MLRS in siege form also needs the target at least 2 cells away.
- The unit stat "range" (`seg[30]`) is where a unit with a target stops walking. It equals the main weapon's range, except for flame carriers, which close to 2.
- An idle unit looks for targets within the larger of its sight and range (range only, in siege form). Enemy units come before buildings. Among units, the type with the highest full health wins, then the nearest. Among buildings, armed ones come first.

### Variants and siege mode

| id | what it is | how it appears |
|---|---|---|
| 18, 17 | AV-40 and T-22 as built | the build menu (`seg[92]`) lists 18 and 17. A second unit list, `seg[118]`, has its 7 and 11 rewritten to 18 and 17 at game start |
| 7 | AV-40 with *Volcano* flame gun | research 6 turns every 18 into 7 |
| 11 | T-22 with rocket turret | research 12 turns every 17 into 11 |
| 14, 15, 16 | siege forms | `seg[52]` pairs 4 and 14, 10 and 15, 13 and 16 |

Going into or out of siege form: the unit drops its orders, a vehicle turns its hull to face east, an animation plays, then the type id is swapped. Health carries over. The Rhino pair is switched off at game start and only enemy research 36 turns it on. The enemy AI deploys and packs up its Snipers and Rhinos by itself.

### Mines

| kind | damage | reach | cells next to the centre |
|---|---|---|---|
| 0 | 15 | 1 | 33%, diagonal 25% |
| 1 | 30 | 2 | 67% at 1 cell, 33% at 2 cells |
| 2 | 80 | 1 | 50%, diagonal 33% |

A mine goes off when a unit of side 0 (the player) finishes its step onto it. Kind 2 ignores infantry. Enemy units walk over mines freely. A shell or rocket that lands exactly on a mine cell also sets it off, which is how the MLRS clears minefields. The blast uses the normal armour formula and hits everything in reach. While an enemy base with mine areas is alive, it gets one try every 100 ticks (10 s) to drop a mine on a random cell of those areas. The try fails if the cell is not free or already has 5 mines around it. Kinds 1 and 2 need enemy research 41 and 42.

### Armed buildings

| building | weapon | damage | range | fire |
|---|---|---|---|---|
| Confederation Bunker | 8 | 5 | 7 | 3 bullets per 6 ticks |
| Rocket launcher | 19 | 20, splash 50% | 11 | 2 rockets per 25 ticks |
| Rebel Headquarters, Rebel Bunker | 23 | 6 | 7 | 2 bullets per 6 ticks |
| Rebel Barracks, Laboratory | 24 | 4 | 6 | 2 bullets per 6 ticks |
| Rebel Tower | 9 | 9 | 11 | 1 bullet per 8 ticks |

A building without power neither shoots nor repairs itself. Walls only block the way; their hit counter is on the [damage page](05-damage.md).

### Healing

- A unit below full health gains 1 point every 20 ticks (infantry) or 30 ticks (machinery), in or out of combat. *Bio suit* makes that 6 ticks for Confederation infantry, *Damage diagnostics* 10 ticks for Confederation machinery.
- A finished, powered building gains 1 point every 15 ticks. Walls have no healing code.

## How we know

- [`p.java:644`](../source/decompiled/p.java#L644) : rows 0..2 of the weapon array = `seg[35..37]`. Research edits them, e.g. [`p.java:3527`](../source/decompiled/p.java#L3527), [`p.java:3618`](../source/decompiled/p.java#L3618) (Observed)
- [`p.java:1382`](../source/decompiled/p.java#L1382) : reload counter, coin flip for weapons in mask 1011. [`p.java:1633`](../source/decompiled/p.java#L1633) : when a shot leaves (Observed)
- [`p.java:2273`](../source/decompiled/p.java#L2273) : flight time. [`p.java:3477`](../source/decompiled/p.java#L3477) : arc. [`p.java:2212`](../source/decompiled/p.java#L2212) : turret turning (Observed)
- [`p.java:3357`](../source/decompiled/p.java#L3357) : range and minimum range. JADX lost the branch bodies here; the conditions were confirmed in the bytecode of `p.class` (Observed)
- [`p.java:1402`](../source/decompiled/p.java#L1402), [`p.java:1406`](../source/decompiled/p.java#L1406) : stop distance = `seg[30]` (Observed)
- [`p.java:3999`](../source/decompiled/p.java#L3999) : search radius. [`p.java:4097`](../source/decompiled/p.java#L4097) : priority by `seg[42]` (full health), then distance (Observed)
- [`p.java:704`](../source/decompiled/p.java#L704), [`p.java:3548`](../source/decompiled/p.java#L3548), [`p.java:3625`](../source/decompiled/p.java#L3625) : ids 7, 11, 17, 18 (Observed)
- [`g.java:3412`](../source/decompiled/g.java#L3412) : siege toggle. [`p.java:2226`](../source/decompiled/p.java#L2226), [`p.java:1466`](../source/decompiled/p.java#L1466), [`p.java:2058`](../source/decompiled/p.java#L2058) : drop orders, turn, swap id (Observed)
- [`p.java:685`](../source/decompiled/p.java#L685), [`p.java:3809`](../source/decompiled/p.java#L3809) : Rhino pair off, then on. [`p.java:1536`](../source/decompiled/p.java#L1536) : AI deploys by itself, thresholds in `tables[4]` (Observed)
- [`g.java:3421`](../source/decompiled/g.java#L3421) : fire at ground needs `seg[58]` = 2, true only for type 16. Help text `T2_82` agrees (Observed)
- [`p.java:2200`](../source/decompiled/p.java#L2200) : mine trigger, side 0 only. [`p.java:2457`](../source/decompiled/p.java#L2457) : set off by splash. [`p.java:2773`](../source/decompiled/p.java#L2773) : blast, `seg[68..72]`. [`p.java:3070`](../source/decompiled/p.java#L3070) : laying, called from the every-10-ticks block at [`p.java:1319`](../source/decompiled/p.java#L1319). [`p.java:3829`](../source/decompiled/p.java#L3829) : kinds unlocked (Observed)
- [`p.java:1745`](../source/decompiled/p.java#L1745) : building weapon from `seg[60]`. [`p.java:1912`](../source/decompiled/p.java#L1912) : its shot timing. [`p.java:1838`](../source/decompiled/p.java#L1838) : no power, no action (Observed)
- [`p.java:1371`](../source/decompiled/p.java#L1371) : unit healing, periods from `seg[16]` = 30 (machinery), 20 (infantry). [`p.java:3523`](../source/decompiled/p.java#L3523), [`p.java:3615`](../source/decompiled/p.java#L3615) : *Bio suit* and *Damage diagnostics* divide the period by 3 (Observed). [`p.java:1844`](../source/decompiled/p.java#L1844) : building repair every 15 ticks (Observed)
- [`../source/tools/weapons_table.py`](../source/tools/weapons_table.py) : prints all the tables above from `a.json`

## Still unknown

- How long the siege animation lasts. It depends on sprite frame counts.
- Whether mines are ever drawn. No drawing code for grid values 121..123 was found (Inferred: invisible).
- `seg[49]`, `seg[50]`, `seg[56]`, `seg[62]`, `seg[63]` look like drawing data (shell arcs, hit boxes, muzzle offsets) and are left to the animation pages.
- This topic is large. Target choice and the enemy AI's siege logic deserve their own page.

**Next:** [What can each side see?](07-vision.md)
