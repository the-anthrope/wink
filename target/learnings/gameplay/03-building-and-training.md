# How do construction and unit training work?

> **In one line:** A building is placed on free, visible ground within 20 cells of a finished Command center and grows from 10% to full HP at 1 HP per 0.3 s; a unit takes 0.2 s per point of its max HP, and a factory hands out one unit of each ordered type in turn.

## The short answer

- **Where**: every cell of the footprint must be empty and currently visible, and the footprint centre must be within **20 cells** (25 after *Communications system*) of a finished Command center.
- **Build time** is not a table. A site starts at 10% HP and gains 1 HP every 3 ticks, so time = 0.27 s x full HP (Generator 32 s, Command center 68 s).
- **Training time** is not a table either: 2 ticks per point of the unit's max HP (Assault 6 s, T-22 Zeus 24 s). The two "-30%" researches multiply it by 0.7.
- **Queue**: up to 20 / 35 / 50 of each unit type per order (by rank). The factory builds one of each ordered type in turn, and pays for each unit as it starts.
- **Caps by rank** (Major-General / Lieutenant-General / General of Army): units 20 / 35 / 50, facilities 10 / 25 / 50. Walls are free of the facility cap.
- **Self-destruct**: any own building can be blown up from its menu. No refund.

Times assume 10 ticks per second (see [file 01](01-money.md)).

## How it works

### Placing a building

1. The Command center menu lists what the mission allows (`seg[95]`, level from `seg[129][mission]`; *Alarm System* adds the Locator). Mission 1 offers only Generator, Infantry center, Bunker and Wall.
2. Cap check (bytecode order): a non-wall with `buildings >= seg[131][rank]` shows "Not available with the current rank"; a non-wall with `buildings >= 50` shows "Maximum buildings constructed". `seg[131]` = [10, 25, 51], so the second message is the one a General of Army sees.
3. Radius: `dx^2 + dy^2 <= R^2`, measured from the centre of the new footprint to the centre of any **finished** own Command center. `R` = 20 cells, 25 after *Communications system* (+25%, as the help says).
4. On confirm: money >= price, every footprint cell has nothing on it (no unit, building, wall, rock or tree) and, with fog on, is both explored and currently in sight. Then the price is deducted and the site appears.

A **wall** (price 20) is not a building record. It is written straight into the map cell, complete at once, needs no energy and uses no facility slot. Damage to a wall is divided by 2 (by 4 after *Walls Active armour*) and it falls after 100 stored points.

### Build time

A new site gets `HP = fullHP / 10` and an "under construction" bit. Every 3rd tick it gains 1 HP; at full HP the bit clears and energy is recomputed. Damage taken meanwhile must be rebuilt too. A site without power does not progress ([file 02](02-energy.md)). Difficulty and research do not change it.

`time = 3 ticks x (fullHP - fullHP/10)`, full HP from `seg[59]`:

| Building | Price | Full HP | Time | Building | Price | Full HP | Time |
|---|---|---|---|---|---|---|---|
| Command center | 700 | 250 | 67.5 s | Headquarters | 550 | 250 | 67.5 s |
| Generator | 200 | 120 | 32.4 s | Powerplant | 200 | 120 | 32.4 s |
| Infantry center | 300 | 120 | 32.4 s | Barracks | 250 | 150 | 40.5 s |
| Machine factory | 400 | 150 | 40.5 s | Factory | 300 | 120 | 32.4 s |
| Technology center | 350 | 100 | 27.0 s | Laboratory | 250 | 120 | 32.4 s |
| Bunker | 300 | 250 | 67.5 s | Bunker (Rebel) | 250 | 180 | 48.6 s |
| Locator | 250 | 120 | 32.4 s | Tower | 350 | 160 | 43.2 s |
| Rocket launcher | 450 | 160 | 43.2 s | | | | |

### Training time

```
target = (maxHP x f411r[factory kind] / 10) x (4 - (side + difficulty) / 2) / 4
```

A counter rises by 1 on every even tick; the unit appears when it reaches `target`. `f411r` is 10, or 7 after *Infantry express-training* (Infantry center) or *Upgraded assembly line* (Machine factory). It scales time only; a new unit always gets the plain `seg[42]` HP. The last factor is 1 for the player on both difficulties and 3/4 for the enemy on Hard.

| Unit | Price | Max HP | Time | With research |
|---|---|---|---|---|
| Assault | 10 | 30 | 6.0 s | 4.2 s |
| Heavy Assault | 20 | 40 | 8.0 s | 5.6 s |
| Flame Assault | 30 | 70 | 14.0 s | 9.8 s |
| AV-40 Fortress | 100 | 120 | 24.0 s | 16.8 s |
| T-21 Hammer | 120 | 90 | 18.0 s | 12.6 s |
| T-22 Zeus | 220 | 120 | 24.0 s | 16.8 s |
| MLRS Torrent | 300 | 100 | 20.0 s | 14.0 s |

Example: T-22 Zeus, max HP 120. Target 120, one point per 2 ticks, 240 ticks = 24 s. With *Upgraded assembly line*: 120 x 7 / 10 = 84, 168 ticks = 16.8 s. Rebel units follow the same rule (Infantry 6 s ... Rhino and Porcupine 20 s).

### The queue

- In the order menu you set a count per unit type, each from 0 to `seg[130][rank]`. Confirming replaces the building's whole order; a unit already in training is kept.
- Storage is one shared pool of 60 slots for all factories of both sides. An order takes one slot per distinct type, and the slots must be next to each other. If no such run is free, the order is silently not stored.
- Execution is round-robin: after each unit the factory moves to the next ordered type and skips types whose count is 0. An order of 2 Assault + 2 Heavy Assault comes out as A, H, A, H.
- When a unit's turn starts the game charges `price x f412s / 10` (`f412s` is always 10) and lowers that count. If you cannot pay, or the side already has 50 units, nothing starts and the factory retries every tick from the first ordered type.
- **Unit cap**: if your unit count is at `seg[130][rank]` (20 / 35 / 50), a unit in training is held one step before completion until a place frees up. It is already paid.
- **Rally point**: a new unit appears on the free cell nearest the middle of the factory's bottom row and walks to the rally cell. The default is the cell just below the bottom-right corner. The flag button in the order menu lets you pick any cell.

The cap counts units one for one. `seg[43]` and `seg[44]` are **score**: `seg[43][type]` is added to the mission score when you kill an enemy of that type (Infantry 2 ... Porcupine 7), `seg[44][type]` is taken off when you lose one of yours (1 to 3).

### Self-destruct

Tapping a site under construction, or a building with no menu, or "x" in a menu, asks "Destroy this building?". Confirming deals the building its own current HP as damage. It then dies like any destroyed building: footprint cleared, building count -1, energy recomputed, own-buildings-lost +1 (5 score points off), no money back.

## How we know

- [`g.java:1900-1906`](../evidence/decompiled/g.java#L1900) : radius test against finished buildings with `seg[94] % 3 == 0`; [`g.java:868-870`](../evidence/decompiled/g.java#L868) : `R` = 20; [`p.java:3686`](../evidence/decompiled/p.java#L3686) : research 23 sets 25 (Observed).
- [`g.java:1926-1962`](../evidence/decompiled/g.java#L1926) : price test, per-cell empty and visibility tests, deduction, wall cell write `1001 + side x 100` (Observed; the inner loop is garbled by JADX, the tests were confirmed in the `javap` bytecode of `g.class`).
- [`g.java:2393-2417`](../evidence/decompiled/g.java#L2393) : cap messages 30 and 37 (`T1_30`, `T1_37`). JADX prints the wall test inverted (`>= 15`); bytecode offsets 1106 and 1202 are "skip if type >= 15", so walls are exempt (Observed in bytecode).
- [`g.java:6082-6133`](../evidence/decompiled/g.java#L6082) : building record creation, start HP = `seg[59] / 10`, bit 0 of field 6060 set, default rally cell at lines 6097-6098 (Observed).
- [`p.java:1852-1864`](../evidence/decompiled/p.java#L1852) : +1 HP when `tick % 3 == slot % 3`, completion at `seg[59]` (Observed). `../evidence/data/a.json` `seg[59]` (unsigned), `tables[6]` (Observed). Table rows: `../evidence/tools/economy_tables.py`.
- [`p.java:2520-2534`](../evidence/decompiled/p.java#L2520) : wall damage `/ f294a[side]`, removal on passing 100; [`p.java:651`](../evidence/decompiled/p.java#L651), [`p.java:3662-3663`](../evidence/decompiled/p.java#L3662) : divisor 2, then 4 (Observed).
- [`p.java:1928-1939`](../evidence/decompiled/p.java#L1928) : training target, even-tick counter, hold at `target - 1` under the cap (Observed, checked in bytecode). [`p.java:3674`](../evidence/decompiled/p.java#L3674), [`p.java:3677`](../evidence/decompiled/p.java#L3677) : research 19 and 20 set `f411r[1]`, `f411r[2]` to 7. [`p.java:3240`](../evidence/decompiled/p.java#L3240) : spawn HP is `seg[42][type]`, unscaled (Observed).
- [`g.java:3061`](../evidence/decompiled/g.java#L3061) with strings `T0_18`/`T0_19` : difficulty is 0 Easy or 1 Hard (Inferred from the two-entry menu).
- [`g.java:8193`](../evidence/decompiled/g.java#L8193) : count clamped to `seg[130][rank]`; [`g.java:2422-2460`](../evidence/decompiled/g.java#L2422) : order written into slot arrays; [`p.java:1953-1973`](../evidence/decompiled/p.java#L1953) : search for a run of free slots among 60 (Observed).
- [`p.java:1975-2045`](../evidence/decompiled/p.java#L1975) : next-type selection, payment, 50-unit stop (Observed). [`p.java:1921-1923`](../evidence/decompiled/p.java#L1921) : retry each tick (Observed).
- [`p.java:1940-1945`](../evidence/decompiled/p.java#L1940) : spawn cell search and rally destination; [`g.java:2304-2305`](../evidence/decompiled/g.java#L2304), [`g.java:1912-1914`](../evidence/decompiled/g.java#L1912) : flag button, then cell pick (Observed). Tutorial `T2_30`.
- [`p.java:2128-2137`](../evidence/decompiled/p.java#L2128) : `seg[44]` subtracted from / `seg[43]` added to slot 9; [`g.java:1446`](../evidence/decompiled/g.java#L1446), [`g.java:5649`](../evidence/decompiled/g.java#L5649) : slot 9 is the score shown at mission end (Observed).
- [`g.java:2024-2030`](../evidence/decompiled/g.java#L2024), [`g.java:2523-2525`](../evidence/decompiled/g.java#L2523) : dialog 125 and the damage call; [`p.java:1668-1694`](../evidence/decompiled/p.java#L1668) : removal (Observed).
- Help text `T1_3`, `T1_4`, `T1_9`, `T1_87`, `T1_120`, `T1_121`, `T1_124` in `../evidence/data/sn8p.json` agree (Observed).

## Still unknown

- Footprint sizes (`k.f327i[18]`, `[19]`) come from file `d`, not `a.json`; not listed here.
- A factory destroyed with an order pending does not seem to release its queue slots (no release found in [`p.java:1668-1742`](../evidence/decompiled/p.java#L1668)); effect on later orders not traced.
- How rank rises (`seg[132]` = [1, 3, 6]) is only read in passing at [`g.java:1472`](../evidence/decompiled/g.java#L1472).

**Next:** [Movement](04-movement.md)
