# sim

The rules of the game. Movement, economy, combat, research, mission
scripts and the opponents live here.

Rules for this folder:

- No nodes, no scenes, no drawing, no input. Plain classes only.
- A fixed 100 ms step. The same orders always give the same battle.
- World state in packed integer arrays, for any number of sides.
- No balance number is typed into code. Numbers come from `data/`.

Nothing is implemented yet. See phase 1 of [PLAN.md](../../PLAN.md).
