# What is the least you must build before it is a game?

> **In one line:** A grid, one building that pays, one that trains, two
> unit types, one damage rule and one scripted wave: about eight tables and
> eight functions.

## The idea

The full game has 19 unit types, 16 buildings, 25 weapons, 24 upgrades and
a script language. It is tempting to start by listing all of it. Mission 1
of the original shows a better starting point: it is a complete, fun level
that uses almost none of that.

## What the original does

Mission 1 ("Pucallpa") in numbers:

| Thing | Mission 1 uses | Whole game has |
|---|---|---|
| Buildings in the menu | 4 (Generator, Infantry center, Bunker, Wall) | 16 |
| Player unit types | 2 (Assault, Heavy Assault) | 7 |
| Enemy unit types | 4 | 7 |
| Enemy buildings | 0 | up to 47 |
| Upgrades | 0 | 24 |
| Script commands needed | spawn, dialogue, objective, win/lose rule, money, loop | 20 |
| Length | about 10 minutes of waves | |

You get 500 money, a Command center, a Generator, an Infantry center and
two Bunkers. Waves arrive at the map edge on a timer and grow. Survive and
clean up. That is a game.

## Recipe: the vertical slice

**Tables (data)**

| Table | Columns | Rows to start |
|---|---|---|
| `unit_type` | cost, hp, armour, move_ticks, sight, weapon | 2 per side |
| `weapon` | damage, range, reload, kind | 3 |
| `building_type` | cost, hp, energy_need, weapon | 4 |
| `map` | width, height, ground[], blocked[] | 1 |
| `mission` | start entities, script[] | 1 |
| `strings` | key -> text | a dozen |

**State (arrays with a hard cap)**

```
units:      alive, side, type, x, y, hp, target, reload, order
buildings:  alive, side, type, x, y, hp, powered, progress, queue
grid[y][x]: 0 free | unit id | building id | blocked
per side:   money, energy_need, energy_supply
tick
```

**Functions (rules), one step each tick**

| # | Function | Rule to copy |
|---|---|---|
| 1 | `run_script()` | Next command when its delay has passed |
| 2 | `income()` | Every 128 ticks, 100 per center, x0.7 each |
| 3 | `power()` | Supply 6 per generator; serve buildings in order |
| 4 | `produce()` | Training time = 2 ticks x hp; pay when it starts |
| 5 | `acquire()` | Toughest enemy type in view, then nearest |
| 6 | `move()` | One cell per `move_ticks`; one unit per cell |
| 7 | `shoot()` | `max(min(D(10-A)/10, D-A), 1)` on reload |
| 8 | `win_lose()` | Check the rule when something dies |

Then one draw function that reads the state, and input that writes orders.

**Order of work** (each step is playable)

1. Grid + one unit you can move by tapping.
2. A second side that stands still; shooting; death.
3. A building that trains units for money.
4. Income on a timer. Now there is a loop: earn, train, fight.
5. A script that spawns enemy waves. Now there is a level.
6. Energy and a second building type. Now there is a trade-off.
7. Win and lose rules, a results screen.

Everything after that is content: more rows in the tables.

## Knobs

The first balance pass needs only five numbers: starting money, payout,
cheapest unit price, wave interval, wave size. Mission 1 uses 500, 100 per
12.8 s, 10, about 80 s, and 10 to 40 units.

## Pitfalls seen in the original

- The original has no clean seam between "engine" and "mission 1"; it was
  built whole. If you build the slice first you get that seam for free.
- Fog of war is expensive to do well and easy to add later. The original
  always has it on; a slice does not need it.
- Do not start with pathfinding. On an open map, "walk straight, step
  around" is enough for a first level, which is all the original ever had.

## Evidence
- Mission 1 contents and timings: [gameplay/13-missions-one-by-one](../gameplay/13-missions-one-by-one.md)
- Mission 1 menu (4 buildings, no Technology center): [gameplay/09-tech-availability](../gameplay/09-tech-availability.md), [gameplay/03-building-and-training](../gameplay/03-building-and-training.md)
- Each rule in the function table: [gameplay/01-money](../gameplay/01-money.md), [02-energy](../gameplay/02-energy.md), [03-building-and-training](../gameplay/03-building-and-training.md), [04-movement](../gameplay/04-movement.md), [05-damage](../gameplay/05-damage.md), [11-enemy-ai](../gameplay/11-enemy-ai.md), [12-mission-scripting](../gameplay/12-mission-scripting.md)
- The slice itself is our proposal (Inferred), assembled from rules that
  are Observed in those notes.

**Next:** [An architecture you can copy](03-architecture-you-can-copy.md)
