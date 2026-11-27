# Build track: what this game teaches about making one

This folder turns the analysis into things you can use. Each note takes one
system of the original, shows the smallest version of the idea, gives a
recipe to copy, the knobs to tune, and the mistakes not to repeat.

Every note has the same shape:

**The idea** (a question to think about first) -> **What the original
does** -> **Recipe** -> **Knobs** -> **Pitfalls seen in the original** ->
**Evidence** (links into the deep dives and the code) -> **Next**.

## Read in this order

| # | Note | The question |
|---|---|---|
| 1 | [Why this design works](01-why-this-design-works.md) | Why does a full strategy game work on a tiny screen? |
| 2 | [The smallest playable version](02-the-smallest-playable-version.md) | What is the least you must build before it is a game? |
| 3 | [An architecture you can copy](03-architecture-you-can-copy.md) | What is the simplest architecture that runs it? |
| 4 | [Put your numbers in tables](04-put-your-numbers-in-tables.md) | Where should a game keep its numbers? |
| 5 | [An economy recipe](05-economy-recipe.md) | How do you make an economy in twenty lines? |
| 6 | [A combat recipe](06-combat-recipe.md) | How do you make combat players can reason about? |
| 7 | [An opponent without an AI](07-enemy-and-mission-recipe.md) | How do you build an enemy from timers and a script? |
| 8 | [An animation recipe](08-animation-recipe.md) | How do you animate an army with almost no memory? |
| 9 | [A balance study](09-balance-study.md) | What keeps players from building only the cheapest unit? |
| 10 | [What to do differently](10-what-to-improve.md) | What would you fix today? |
| 11 | [A build plan](11-build-plan.md) | In what order should you build your own? |

## The ten ideas in one screen

1. One loop, fixed 100 ms step, rules separate from drawing.
2. World state in flat arrays with hard caps. Saving is dumping arrays.
3. Every number and every string in a table, indexed by a small id.
4. Income on a timer from a building you can lose, with falling returns.
5. A second budget (energy) that does not accumulate.
6. One damage formula where armour makes small guns bounce.
7. Weapons, modes and upgrades as table rows, not code.
8. A population cap as the lever that makes expensive units matter.
9. Enemies and missions as timers, painted zones and a linear script.
10. Pictures assembled from shared parts in layers.

## A word on scope

The mechanics and patterns here are common property of the genre and yours
to use. The original's names, story, art and text belong to its makers.
Build your own world on the machinery.
