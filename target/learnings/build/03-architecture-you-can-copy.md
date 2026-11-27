# What is the simplest architecture that runs a whole strategy game?

> **In one line:** One loop, a fixed 100 ms step, two halves that never mix
> (rules and presentation), and all world state in flat arrays.

## The idea

A strategy game looks complicated: dozens of units, buildings, bullets, an
enemy that thinks. The original runs all of it on a 2010 feature phone with
about a megabyte of memory. It manages because the architecture is tiny, and
the same shape still works today in any language.

## What the original does

**One loop.** Each pass: read input, advance the rules one step, draw, sleep
for whatever is left of 100 ms. That gives 10 rule steps per second.

```
loop:
    read input
    simulation.step()        # rules only, no drawing
    ui.draw()                # reads the world, never changes rules
    sleep(100 ms - time used)
```

A "smooth" mode sleeps 50 ms, runs a movement-interpolation pass and draws a
second time, so the screen shows 20 pictures per second while the rules
still tick 10 times.

**Two halves.** Class `p` is the simulation: movement, combat, production,
the enemy. Class `g` is everything the player sees and touches. `g` reads
`p`'s arrays to draw; orders go from `g` into `p` as small writes. Neither
half contains the other's logic.

**Flat state.** There is no `Unit` object. One byte array of 7,272 bytes
holds 72 fields x 101 slots. Field `f` of entity `i` is `state[f*101 + i]`.

| Slots | Used for |
|---|---|
| 1..50, 51..100 | Units of side 0 and side 1 |
| the same indexes, other fields | Buildings of side 0 and side 1 |

Side is `(i - 1) / 50`. A free slot is one whose HP field is 0.

Why this is good, even now:

| Property | Benefit |
|---|---|
| Fixed caps (50 per side) | No allocation during play, no surprises |
| One array | Saving the game is writing the array; loading is reading it |
| Fields side by side | A loop over "all HP" touches one tight memory range |
| Fixed step | The same inputs give the same battle: replays, fair AI, easy tests |

**One timer for everything.** A single tick counter drives all periodic
work with bit masks: income when `tick & 127 == 127`, training progress on
even ticks, building progress every third tick. No timer objects.

## Recipe

1. Pick a fixed step (100 ms is plenty for a strategy game).
2. Write `step(world, orders)` as a pure function of the world arrays.
3. Keep the world in arrays with hard caps: `hp[N]`, `x[N]`, `type[N]`...
4. Let the UI only read the world and append orders.
5. Derive every periodic effect from one tick counter.
6. Save and load by dumping those arrays. Test by replaying orders.

## Knobs

| Knob | Original | Effect of raising it |
|---|---|---|
| Step length | 100 ms | Shorter = more responsive, more CPU |
| Entity cap per side | 50 units, 50 buildings | Bigger battles, slower loops |
| Draws per step | 1 or 2 | Smoother motion at no rule cost |

## Pitfalls seen in the original

- The loop sleeps for the remainder but never catches up. On a slow device
  the whole game runs slower. A modern loop should accumulate lag and run
  extra steps.
- Byte-sized fields cap coordinates and HP at 255 and force tricks
  elsewhere. Use wider integers.
- Units and buildings share index ranges across different fields, which is
  easy to confuse. Give each kind its own array set.

## Evidence
- [`k.java:747`](../source/decompiled/k.java#L747) : the loop; [`k.java:792`](../source/decompiled/k.java#L792) : sleep `100 - used`; [`k.java:785`](../source/decompiled/k.java#L785) to [`k.java:790`](../source/decompiled/k.java#L790) : the two-draw smooth mode (Observed)
- [`k.java:331`](../source/decompiled/k.java#L331) : the single `byte[7272]` state array; [`p.java:509`](../source/decompiled/p.java#L509) and [`g.java:795`](../source/decompiled/g.java#L795) : both halves alias it (Observed)
- [`p.java:1773`](../source/decompiled/p.java#L1773) : `tick & 127` income test (Observed)
- Rules of the periodic effects: [gameplay/01-money](../gameplay/01-money.md), [gameplay/03-building-and-training](../gameplay/03-building-and-training.md)
- "No allocation during play" (Inferred from the fixed arrays created once in [`k.java:331`](../source/decompiled/k.java#L331))

**Next:** [Put your numbers in tables](04-put-your-numbers-in-tables.md)
