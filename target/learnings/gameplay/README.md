# Gameplay: the rules as the code implements them

Fourteen notes, one question each. They describe what the program does,
with a link to the code line behind every claim. For "how would I build
this", read the matching recipe in [build/](../build/README.md).

## The game in one minute

You command the Confederation on a grid map covered by fog. A **Command
center** pays you money every 12.8 seconds and lets you place buildings
within 20 cells. **Generators** supply energy; every other building needs
some or it freezes. An **Infantry center** and a **Machine factory** train
units, a **Technology center** researches 24 upgrades. Units move cell by
cell, pick their own targets and shoot with fixed, predictable damage that
armour reduces. You may hold 20, 35 or 50 units depending on rank. The
enemy is driven by a per-mission script: timed waves along fixed routes,
bases that rebuild themselves. Seven missions; win by wiping out the enemy
or surviving its script.

One step of the rules is a **tick** of 100 ms. All times below are in
ticks or seconds at 10 ticks per second.

## The notes

| # | Note | In one line |
|---|---|---|
| 1 | [Money](01-money.md) | 100 per Command center every 12.8 s, each extra center pays 70% of the last; 20% bounty per kill; no refunds |
| 2 | [Energy](02-energy.md) | 6 per Generator; buildings are powered in slot order; an unpowered building is frozen |
| 3 | [Building and training](03-building-and-training.md) | Build time = 0.27 s per HP, training = 0.2 s per HP; round-robin queues; caps by rank |
| 4 | [Movement](04-movement.md) | 8 directions on a 30x20 px grid, one unit per cell, straight line with detours, no search |
| 5 | [Damage](05-damage.md) | `max(min(D(10-A)/10, D-A), 1)`, no dice; shells splash 3x3; flame kills infantry |
| 6 | [Weapons and special modes](06-weapons-and-special-modes.md) | 25 weapon records, up to 3 per unit; siege forms are type swaps; mines; healing |
| 7 | [Vision](07-vision.md) | Fog for the player only; sight discs per type; some weapons out-range their sight |
| 8 | [Research effects](08-research-effects.md) | What each of the 24 upgrades changes in the tables, and where the text is wrong |
| 9 | [Tech availability](09-tech-availability.md) | Which buildings, units and upgrades each mission allows |
| 10 | [Ranks, score, difficulty](10-ranks-score-difficulty.md) | Rank only sets caps; score = time bonus + kills; Hard = bigger, faster enemy |
| 11 | [Enemy AI](11-enemy-ai.md) | No planner: six timers per base, free units, shared unit reflexes |
| 12 | [Mission scripting](12-mission-scripting.md) | Zones, routes and a 20-command linear script on a seconds clock |
| 13 | [Missions one by one](13-missions-one-by-one.md) | The decoded script of each mission: start, waves, win and lose rules |
| 14 | [Custom games and saves](14-custom-games-and-saves.md) | Replaying won missions and downloaded maps; what a save record holds |

## Suggested paths

- **I want the core loop:** 1 -> 2 -> 3 -> 5.
- **I want to understand a fight:** 4 -> 5 -> 6 -> 7.
- **I want to design missions:** 12 -> 13 -> 11 -> 9.

## Things that surprised us

- The "attack" number in the build menu is not used in combat (note 5).
- The enemy pays for nothing and has no income (notes 1, 11).
- Build and training times are not in any table; they are health times a
  constant (note 3).
- Nothing in a mission reacts to the player; it is all timers (note 12).
- Several upgrade descriptions disagree with what the code does (note 8).

## Tools used by these notes

| Script | Prints |
|---|---|
| [`economy_tables.py`](../source/tools/economy_tables.py) | Income ladder, build and training times, starting money |
| [`weapons_table.py`](../source/tools/weapons_table.py) | Weapons, unit loadouts, armed buildings, damage matrix |
| [`tech_masks.py`](../source/tools/tech_masks.py) | Per-mission unlock masks |
| [`missions_full.py`](../source/tools/missions_full.py) | Every mission file decoded to its last byte |
| [`balance_sheet.py`](../source/tools/balance_sheet.py) | Cost efficiency and duel tables |
