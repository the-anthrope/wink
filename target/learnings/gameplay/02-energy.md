# What does energy do, and what happens when you run short?

> **In one line:** Each finished Generator supplies 6 energy, each building reserves a fixed amount from the moment it is placed, and buildings are served in slot order; one that does not fit is frozen completely until supply returns.

## The short answer

- A finished Generator (Rebels: Powerplant) supplies **6**. After *Reinforced generator* it supplies **8**. That is +33%; the help text says 30%.
- Needs are fixed per building type: 0 for Command center, Generator and walls, 1 for defences and the Locator, 2 for Infantry center and Technology center, 3 for the Machine factory.
- A building counts toward the need **as soon as it is placed**, even while it is still a construction site. A Generator only supplies once it is **finished**.
- When supply is short, buildings are powered in slot order, usually oldest first. A building whose need does not fit in what is left is switched off; a smaller one further down the list can still be on.
- A switched-off building does nothing at all: no construction progress, no shooting, no training, no research, no self-repair. Nothing is lost; it continues when power is back.
- The top bar shows `need/supply` and marks it when need is larger.

## How it works

### Supply and need

The game keeps two numbers per side: energy needed (slot 2) and energy supplied (slot 3) of the per-side stats array described in [file 01](01-money.md). They are recomputed from scratch by one routine:

```
supply = H x (number of finished Generators / Powerplants that are alive)
need   = sum of seg[61][type] over every living building, finished or not
```

`H` is 6 per side at mission start. Research 15 (*Reinforced generator*) sets the Confederation value to 8; the Rebel twin (research case 39) does the same for side 1.

| Building | Need | Building | Need |
|---|---|---|---|
| Command center / Headquarters | 0 | Bunker (both sides) | 1 |
| Generator / Powerplant | 0 | Locator, Tower | 1 |
| Infantry center / Barracks | 2 | Rocket launcher | 2 |
| Machine factory / Factory | 3 | Technology center / Laboratory | 2 |
| Wall | 0 | | |

So one Generator carries, for example, an Infantry center, a Machine factory and one Bunker (2 + 3 + 1 = 6).

### Who gets switched off

Right after the totals, the same routine walks the side's 50 building slots from the lowest index up and hands out the supply:

```
used = 0
for each living building, in slot order:
    if used + need(building) <= supply:  powered = 1; used += need(building)
    else:                                powered = 0
```

Two consequences:

- It is first come, first served by **slot**, not by importance. A new building takes the lowest free slot. Buildings present at mission start hold the first slots, in mission-file order. When a building is destroyed its slot is freed, and the next thing you place takes that slot and moves ahead of younger buildings.
- It is "fit or skip", not "stop at the first failure". With supply 6 and, in slot order, Infantry center (2), Machine factory (3), Technology center (2), Bunker (1): the first two use 5, the Technology center does not fit (7 > 6) and is off, the Bunker fits (6) and stays on.

Buildings with need 0 always pass the test, so Command centers keep paying and Generators keep building even at supply 0.

### What "off" means

Every tick each building first runs a small upkeep routine. If the powered flag is 0 it clears its current target and returns early. Everything else a building does comes after that point and is skipped:

| Skipped while off | Normal rate when on |
|---|---|
| Construction progress | +1 HP every 3 ticks until full HP |
| Self-repair of a finished building | +1 HP every 15 ticks (1.5 s) |
| Turret fire (Bunker, Rocket launcher, Tower) | per weapon |
| Unit training | counter +1 every 2 ticks |
| Research | counter +1 every 4 ticks |

Progress counters are not reset, so work resumes where it stopped. The building is drawn with a small warning animation (sprite id 269) while it is off.

The check is **not** run every tick. Power is redistributed only when a building is placed, when a construction finishes, when a destroyed building is removed, when the generator research completes, and when a saved game is loaded. Damage alone never changes it.

### Worked example (mission 1)

You start with Command center, Generator, Infantry center and two Bunkers: need 0 + 0 + 2 + 1 + 1 = 4, supply 6, shown as `4/6`.

1. Place a second Infantry center (the tutorial asks for it): need 6, supply 6. It fits and builds.
2. Place a third Bunker: need 7, supply 6. The new Bunker sits in the last slot, does not fit, and stays a frozen construction site at 10% HP.
3. Place a Generator (need 0, so it always builds; 32.4 s). The moment it finishes, supply becomes 12, power is handed out again and the Bunker starts building.

Had you placed the Generator first, nothing would have stalled. A site without power cannot finish, so the order of placement matters.

## How we know

- [`p.java:3481-3509`](../evidence/decompiled/p.java#L3481) : the whole energy routine. Lines [`3487-3489`](../evidence/decompiled/p.java#L3487) add `H[side]` for building types 1 and 9 whose "under construction" bit is clear; [`3492`](../evidence/decompiled/p.java#L3492) adds `seg[61][type]` for every living building; [`3499-3507`](../evidence/decompiled/p.java#L3499) is the slot-order hand-out that writes the powered flag (field 7171) (Observed, and checked against the `javap` bytecode of `p.class`).
- `../evidence/data/a.json` `seg[61]` = [0,0,2,3,2,1,1,2, 0,0,2,3,2,1,1, 0,...] : need per building type 0..15 (Observed).
- [`p.java:652`](../evidence/decompiled/p.java#L652) : `H` = 6 for both sides; [`p.java:3655-3656`](../evidence/decompiled/p.java#L3655) : research 15 sets `H[0]` = 8 and recomputes; [`p.java:3823-3824`](../evidence/decompiled/p.java#L3823) : same for side 1 (Observed). 8 / 6 = 1.33 against "30 percent" in help text `T1_116` (Observed).
- [`p.java:1838-1842`](../evidence/decompiled/p.java#L1838) : powered flag 0 means clear target, return early; [`p.java:1744-1779`](../evidence/decompiled/p.java#L1744) : turret fire, training, research and income all sit behind that call (Observed).
- [`p.java:1852-1864`](../evidence/decompiled/p.java#L1852) : construction step every 3 ticks and the recompute when it completes; [`p.java:1844-1849`](../evidence/decompiled/p.java#L1844) : self-repair every 15 ticks. Both come after the power test (Observed).
- [`g.java:6086-6092`](../evidence/decompiled/g.java#L6086) : a new building takes the first slot whose HP is 0 (Observed). "Oldest first" follows from that (Inferred).
- Callers of the routine: [`g.java:6133`](../evidence/decompiled/g.java#L6133) (placed), [`p.java:1864`](../evidence/decompiled/p.java#L1864) (finished), [`p.java:1681`](../evidence/decompiled/p.java#L1681) (removed), [`p.java:3656`](../evidence/decompiled/p.java#L3656) (research), [`g.java:6721`](../evidence/decompiled/g.java#L6721) (load). There are no others (Observed, grep).
- [`g.java:4581-4585`](../evidence/decompiled/g.java#L4581) : top bar prints slot 2, a separator, slot 3, and draws a marker when slot 2 > slot 3; [`g.java:4392-4393`](../evidence/decompiled/g.java#L4392) : animation 269 on a building whose powered flag is 0 (Observed).
- `../evidence/data/missions.json` mission 1 `bld_conf` : the five starting buildings of the worked example (Observed). Build times: [file 03](03-building-and-training.md).
- Help text `T1_86` and tutorial `T2_25` in `../evidence/data/sn8p.json` : "If a facility is short of energy, it is no longer in operation" (Observed).

## Still unknown

- Whether an unpowered Locator still reveals the map. The powered flag is read in only one place in the simulation (the upkeep routine), so sight is probably unaffected (Inferred), but the fog code was not traced here.
- Whether you can still open the order menu of a switched-off factory. The code that opens it ([`g.java:2018-2069`](../evidence/decompiled/g.java#L2018)) does not read the powered flag, so probably yes, with the order simply not progressing (Inferred).

**Next:** [How do construction and unit training work?](03-building-and-training.md)
