# In what order should you build your own?

> **In one line:** Seven milestones, each ending in something you can play,
> each pointing at the note that holds the rule to start from.

## The idea

The notes in this folder are a parts list. This one is the assembly order.
Every milestone is small enough to finish in a few sittings and ends with a
test you can run by hand. Use your own theme, names, art and story: what is
worth taking from the original is the machinery, not its content.

## The plan

| # | Milestone | You can now... | Start from | Done when |
|---|---|---|---|---|
| 0 | **Tables and a viewer** | See your units and numbers on a page | [tables](04-put-your-numbers-in-tables.md), [balance](09-balance-study.md) | A script prints a balance sheet from your data files |
| 1 | **Loop and grid** | Tap to move one unit across a map | [architecture](03-architecture-you-can-copy.md), [movement](../gameplay/04-movement.md) | 10 rule steps per second, drawing reads state only |
| 2 | **Combat** | Watch two squads fight to the death | [combat](06-combat-recipe.md), [damage](../gameplay/05-damage.md) | Results match your damage matrix exactly, every run |
| 3 | **Production and money** | Earn, train, fight in a loop | [economy](05-economy-recipe.md), [training](../gameplay/03-building-and-training.md) | A second income building pays back in the time you predicted |
| 4 | **A scripted level** | Lose to waves, then win | [missions](07-enemy-and-mission-recipe.md), [mission 1](../gameplay/13-missions-one-by-one.md) | A 10-minute defence level with a win screen |
| 5 | **Energy, defences, upgrades** | Choose between growth and safety | [energy](../gameplay/02-energy.md), [research](../gameplay/08-research-effects.md) | Two build orders both work and feel different |
| 6 | **An enemy base** | Attack something that rebuilds | [enemy](../gameplay/11-enemy-ai.md) | The base recovers if you retreat |
| 7 | **Look and feel** | Recognise every unit and hit | [animation](08-animation-recipe.md), [draw order](../animations/05-timing-and-draw-order.md) | Layered units, effects pool, fog |

Milestones 0 to 4 are the [smallest playable version](02-the-smallest-playable-version.md).

**Three tests to keep from day one**

| Test | Why |
|---|---|
| Same orders in, same battle out | Proves the rules are deterministic; enables replays and regression tests |
| Save, load, step: state equals stepping without the save | Proves your state is complete |
| Balance sheet diff | Any table change shows up as changed ratios before anyone plays |

**Decisions to make before milestone 1**

| Decision | The original's choice | Note |
|---|---|---|
| Step length | 100 ms | Fine for strategy; interpolate drawing |
| Map | Square cells, one unit per cell, max 80x80 used | Simplest possible; hexes cost more than they give at first |
| Caps | 50 units and 50 buildings per side | Set a cap on purpose; it is a balance tool |
| Sides | Asymmetric, one playable | Symmetric is far easier to balance for two players |
| Input | Tap, drag-select, hold for context menu | Design for the smallest screen you target |

## What to read when

| You are stuck on... | Read |
|---|---|
| "My cheap unit beats everything" | [balance](09-balance-study.md) |
| "My economy has no decisions" | [economy](05-economy-recipe.md) |
| "I need an AI" | [missions](07-enemy-and-mission-recipe.md) first; you may not |
| "Too much art to draw" | [animation](08-animation-recipe.md) |
| "What does the original do exactly?" | [gameplay/](../gameplay/README.md), then the linked code line |

## Evidence
- Every rule the plan refers to is documented, with code lines, in
  [gameplay/](../gameplay/README.md) and [animations/](../animations/README.md).
- Map sizes used by the seven missions: [missions](../reference/04-missions.md) (Observed)
- The milestone order and the tests are our proposal (Inferred).

**Next:** back to the [build index](README.md), or dive into [gameplay](../gameplay/README.md).
