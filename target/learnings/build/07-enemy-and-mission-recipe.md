# How do you build an opponent without writing an AI?

> **In one line:** Give the designer a tiny script language and a few
> timers; the "enemy" is a list of timed commands plus zones and routes
> drawn on the map.

## The idea

A computer opponent that plans like a human is one of the hardest things in
game programming. The original does not attempt it. Its enemy never decides
what to build, what to train or where to attack. A mission designer decided
all of that in advance. Yet a player meets growing attacks from several
directions, bases that rebuild, minefields that refill. Before reading on,
guess how few moving parts that needs.

It needs three: **zones and routes** painted on the map, **six timers** per
enemy base, and a **straight-line script** of about twenty commands.

## What the original does

**Map annotations per enemy base ("group", up to 3)**

| Annotation | Used for |
|---|---|
| Build zones | Where rebuilt buildings may be placed (random spot inside) |
| Wall lines, mine fields | Cells to refill with walls and mines |
| Attack routes | Waypoint lists; each wave squad picks one at random |
| Rally points | Where new units gather |

**Timers per base**

| Timer | Period | Action |
|---|---|---|
| Rebuild | 20 s | Replace the first missing building of the base's list |
| Train | 150 s (112 s on Hard) | Each idle factory queues one batch |
| Wave | `n x 20 s` + random 0-20 s | Every waiting unit gets a route |
| Wall repair | 20 s | Put back one wall tile |
| Mines | 10 s | Lay one mine |
| Research | 42 s | Maybe start the next upgrade |

**The script.** Six bytes per command: `opcode, p1, p2, value, delay,
group`. One pointer walks down the list; each command waits `delay` seconds
after the previous one. There are no "if the player does X" triggers.

```
set money 500
objective  "Build the base"
wait 60:   spawn enemy infantry x3 at north edge, group 0
wait 30:   dialogue "General, we are under attack!"
loop 5:    wait 45: spawn enemy x6 ...
win rule:  enemy has no units and no buildings
```

Useful commands it has: spawn units for either side, set what a base
trains, switch waves on, set win and lose rules, show dialogue or a
tutorial tip, move the camera, lift fog for a moment, loop, and "only if
the player has room for N more units".

**Unit reflexes** are shared by both sides and are four rules: pick the
toughest target in view, follow it while visible, shoot back when shot,
alert idle friends nearby. Nothing else. No patrols.

**Difficulty** is multipliers, not smarter play: Hard makes enemy batches
1.4x to 2x larger and timers shorter, and shrinks your reinforcements.

## Recipe

1. Let designers paint zones and routes in the map editor.
2. Run a handful of fixed timers per enemy base.
3. Drive each mission with a linear command list on a seconds clock.
4. Keep unit behaviour to a few local reflexes shared by both sides.
5. Make difficulty a set of multipliers the script can set per mission.
6. Express win and lose as a small rule id the script sets, checked when
   something dies.

## Knobs

| Knob | Original | Feel |
|---|---|---|
| Wave interval | `n x 20 s` | The mission's heartbeat |
| Batch size | 3 / 6 / 10 infantry, 2 / 4 / 6 vehicles | Pressure per wave |
| Squad size | about 12 | Whether attacks arrive as a blob or a trickle |
| Hard multiplier | 1.4 to 2.0 per mission | Difficulty without new content |

## Pitfalls seen in the original

- **The enemy pays nothing** and earns nothing. Simple, but the player
  cannot starve it. Killing its power plants is the only economic attack.
- **Nothing reacts to the player.** A wave arrives on its timer whether you
  are ready or not. One or two real triggers ("when the player enters this
  zone") would add a lot for little cost.
- **Timers by wall clock make missions solvable by rote.** Random jitter is
  there (0-20 s) and helps; add more.
- **A likely bug:** alarm areas are stored as x, y, width, height and read
  as two corners, so the "pause repairs while under attack" rule misfires.
  Decide one rectangle convention and use it everywhere.

## Evidence
- Every rule above with line references: [gameplay/11-enemy-ai](../gameplay/11-enemy-ai.md), [gameplay/12-mission-scripting](../gameplay/12-mission-scripting.md), [gameplay/13-missions-one-by-one](../gameplay/13-missions-one-by-one.md)
- [`p.java:1267`](../source/decompiled/p.java#L1267) to [`p.java:1270`](../source/decompiled/p.java#L1270) : enemy logic once per second, rebuild every 200 ticks (Observed)
- [`p.java:3134`](../source/decompiled/p.java#L3134) : train period `1500 x (4 - difficulty) / 4` ticks (Observed)
- [`p.java:3181`](../source/decompiled/p.java#L3181) : squad size; [`p.java:3215`](../source/decompiled/p.java#L3215) : next wave time with jitter (Observed)
- `../source/tools/missions_full.py` : decodes all seven scripts to the last byte (Observed)
- The script sample above is an illustration in our own notation, not a
  listing of a real mission.

**Next:** [An animation recipe](08-animation-recipe.md)
