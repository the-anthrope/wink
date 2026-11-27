# Plan: an original 3D RTS in Godot 4, built on the learnings

Status: plan only. Nothing is built yet.

Decisions already made:

| Decision | Choice |
|---|---|
| Engine | Godot 4 (native builds, Android first) |
| 3D models | Built in code, stylised low-poly, high visual quality bar |
| Scope | Campaign plus skirmish against an AI |
| Setting | Near-future military |

Learnings live in [`target/learnings/`](target/learnings/README.md). Each
piece below names the note it is built on.

## What this is, and what it is not

The learnings describe Art Of War 2 - Global Confederation, whose code, art,
text and maps belong to HeroCraft and Gear Games
([README limits](target/learnings/README.md)). This project is **not a port**
of that game. It is an original game that applies what the learnings teach
about how such a game works.

**Using the original as reference**

| Taken from the original (how things work and read) | Made new (what things are) |
|---|---|
| The rules: timer economy, energy budget, armour formula, scripted missions | Every model, building and HUD element |
| Scale relations: soldier vs tank vs building footprint | Every map layout |
| Top-down readability: silhouettes, team colour areas | Unit, building and faction names |
| Hull / turret / muzzle layering for animation | Story, characters, dialogue |
| Effects vocabulary: tracers, smoke, craters, wrecks | Music and sound |
| The balance formula shapes | The roster and its tuned numbers |

**On visual quality.** Code-built models give a clean, stylised low-poly
look. Quality comes from lighting, animation, effects and consistency; the
models will not look hand-sculpted. Models load through one interface, so an
artist's glTF files can replace any of them later.

## Stack

- **Engine:** latest stable Godot 4, version pinned in piece 0.2.
- **Language:** typed GDScript, with the simulation as plain classes over
  packed integer arrays.
  - GDScript: built in, exports everywhere, fast enough for 100 + 100
    entities at 10 steps per second.
  - C#: faster, but weaker mobile and web export.
  - GDExtension: native C++ speed, only worth it if profiling demands it.
- **Renderer:** Mobile, with Compatibility as a fallback.
  - Mobile: Vulkan/Metal, good lighting at phone cost.
  - Compatibility: OpenGL ES 3 for older phones, fewer effects.
  - Forward+: desktop-grade, too heavy here.
- **Verification:** Godot is not installed in the cloud environment used so
  far. Its download hosts responded, so installing it is piece 0.2 and
  untested until then. Touch feel can only be judged on a real phone, so
  each control piece ends with a build to try.

## Phase 0: Foundations

| # | Piece | Built on |
|---|---|---|
| 0.1 | Fill the gaps in the learnings: weapons and special modes, vision and fog, the seven missions one by one, building and effect animation, draw order and timing, the combat recipe. These notes are linked but missing (`gameplay/06`, `gameplay/07`, `gameplay/13`, `animations/04`, `animations/05`, `build/06`). Derive them from [`p.java`](target/learnings/source/decompiled/p.java) and [`a.json`](target/learnings/source/data/a.json). | [`weapons_table.py`](target/learnings/source/tools/weapons_table.py) |
| 0.2 | Project skeleton: `sim/` (rules, no nodes), `view/`, `ui/`, `data/`, `tests/`; landscape lock; headless test runner; screenshot run under a virtual display. | [build/03](target/learnings/build/03-architecture-you-can-copy.md) |
| 0.3 | Identity one-pager for approval: name, two factions, conflict, roster by role. | new |

**Done when:** the missing notes exist, `godot --headless` runs an empty test
suite green, and the one-pager is approved.

## Phase 1: Simulation (no graphics, tested headless)

| # | Piece | Built on | Improvement over the original |
|---|---|---|---|
| 1.1 | Fixed 100 ms step, with smooth drawing between steps | [build/03](target/learnings/build/03-architecture-you-can-copy.md) | Catches up after a slow frame; the original just ran slower |
| 1.2 | World state in flat arrays; save is an array dump; replay is an order log | [build/03](target/learnings/build/03-architecture-you-can-copy.md) | Separate arrays for units and buildings, wider integers |
| 1.3 | All numbers in named tables, plus a validator and a balance-sheet printer | [build/04](target/learnings/build/04-put-your-numbers-in-tables.md) | Named columns; build time gets its own column |
| 1.4 | Grid movement: 8 directions, one unit per cell, turn rates, cell reservation | [gameplay/04](target/learnings/gameplay/04-movement.md) | A* routing; group orders spread over nearby cells |
| 1.5 | Money on a timer with falling returns, kill bounty, energy budget | [build/05](target/learnings/build/05-economy-recipe.md), [gameplay/01](target/learnings/gameplay/01-money.md), [gameplay/02](target/learnings/gameplay/02-energy.md) | Power-off order is visible and newest-first; short undo refund |
| 1.6 | Construction radius, round-robin queue, pay when work starts, rally point | [gameplay/03](target/learnings/gameplay/03-building-and-training.md) | Queue shown; no silent failures |
| 1.7 | Combat: armour formula, locked bullets, area shells, flame, target choice, retaliation | [gameplay/05](target/learnings/gameplay/05-damage.md), [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) | Unit cards show the real damage |
| 1.8 | Deploy / siege forms as a type swap; vehicles crushing infantry | [build/04](target/learnings/build/04-put-your-numbers-in-tables.md), [animations/03](target/learnings/animations/03-unit-animation.md) | - |
| 1.9 | Fog of war and sight | note written in 0.1 | The opponent obeys fog too |
| 1.10 | Research as table edits with prerequisite chains | [gameplay/08](target/learnings/gameplay/08-research-effects.md) | Descriptions generated from the numbers, so text cannot drift |
| 1.11 | Mission script: timeline commands for spawns, waves, dialogue, objectives, win / lose | [gameplay/12](target/learnings/gameplay/12-mission-scripting.md) | Adds event triggers (zone entered, building lost, kill count) |
| 1.12 | Opponents: scripted bases for the campaign; a skirmish AI with a real economy | [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) | Fixes the dead alarm zones; three difficulty levels |

**Done when:** a full battle runs headless from an orders file and gives the
same final state hash twice.

## Phase 2: 3D presentation

| # | Piece | Built on |
|---|---|---|
| 2.1 | Camera rig (tilted, narrow field of view, pan and zoom limits); terrain mesh from the grid; water and cliffs | [data-formats/05](target/learnings/04-data-formats/05-terrain-m-files.md) |
| 2.2 | Model kit in code: bevelled hulls, turrets, tracks, barrels; team-colour shader; baked shading; instanced props. Each asset is reviewed on a turntable screenshot. | scale and readability from [animations/01](target/learnings/animations/01-sprite-sheets.md) |
| 2.3 | Unit animation: hull, turret and muzzle turn independently; infantry walk and aim; death reactions keyed to bullet, blast, flame or crush; moving tracks and wheels | [animations/03](target/learnings/animations/03-unit-animation.md) |
| 2.4 | Buildings: rise during construction, visible powered-off state, damage stages, collapse to rubble | [gameplay/02](target/learnings/gameplay/02-energy.md), [gameplay/03](target/learnings/gameplay/03-building-and-training.md) |
| 2.5 | Effects: tracers, arcing shells, rocket trails, explosions, smoke, scorch decals, craters, wrecks, camera shake | sheet list in [animations/01](target/learnings/animations/01-sprite-sheets.md) |
| 2.6 | Audio: weapon and impact sounds, unit acknowledgements, layered music. The original shipped one tune and no sound effects. | [assets/03](target/learnings/03-assets/03-fonts-and-sound.md) |

**Done when:** the phase 1 replay plays back in 3D at 60 frames per second in
the software-rendered test run.

## Phase 3: Touch controls and HUD (landscape)

| # | Piece | Built on |
|---|---|---|
| 3.1 | Gestures: one-finger pan, pinch zoom, tap select, tap ground to move, tap enemy to attack, double-tap for same type, long-press drag for box select; mouse and keyboard mapping | new |
| 3.2 | Layout inside safe areas: command card under the right thumb, control groups under the left, money and energy always on top, tappable minimap | [build/05](target/learnings/build/05-economy-recipe.md) recipe step 6 |
| 3.3 | Build flow: ghost with green / red cells, radius ring, confirm and cancel; walls drawn as a dragged line | [gameplay/03](target/learnings/gameplay/03-building-and-training.md) |
| 3.4 | Production steppers with visible queue and rally flag; research tree panel | [gameplay/03](target/learnings/gameplay/03-building-and-training.md), [gameplay/08](target/learnings/gameplay/08-research-effects.md) |
| 3.5 | Feel: haptics, attack-move toggle, idle-unit button, under-attack alert with jump, pause, autosave checkpoints | [gameplay/10](target/learnings/gameplay/10-ranks-score-difficulty.md) |

**Done when:** a full mission can be finished on a phone using only thumbs,
with every touch target at least 48 dp.

## Phase 4: Content

| # | Piece | Built on |
|---|---|---|
| 4.1 | Two asymmetric factions tuned in tables, checked by a headless duel matrix | method from [gameplay/05](target/learnings/gameplay/05-damage.md), principle from [reference/01](target/learnings/06-reference/01-units.md) |
| 4.2 | Map pipeline: ground, walkability mask and decor as separate data; an in-engine editor scene | [data-formats/05](target/learnings/04-data-formats/05-terrain-m-files.md) |
| 4.3 | Campaign of about 8 new missions on new maps, mixing defence, base assault, no-base raid and hold-out; tech unlocked per mission; score and ranks | [gameplay/09](target/learnings/gameplay/09-tech-availability.md), [gameplay/10](target/learnings/gameplay/10-ranks-score-difficulty.md) |
| 4.4 | Skirmish: 4 to 6 symmetric maps, AI levels, start settings | [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) |
| 4.5 | New briefings, portraits and dialogue | new |

**Done when:** the campaign can be played start to finish and a skirmish can
be won and lost against each AI level.

## Phase 5: Polish and ship

| # | Piece |
|---|---|
| 5.1 | Performance budget on a mid-range Android phone, with quality tiers |
| 5.2 | Save / load, settings, string tables for languages ([build/04](target/learnings/build/04-put-your-numbers-in-tables.md)), colour-blind team colours |
| 5.3 | Playtest loop: mission length and loss stats feed table tuning |
| 5.4 | Android export first, then desktop and iOS |

**Done when:** a signed Android build holds the frame budget through the
largest mission.

## Open questions

| # | Question | Assumed until answered |
|---|---|---|
| 1 | Is there an Android phone to test builds on? iOS export needs a Mac and a developer account. | Android first |
| 2 | Where does music come from? Sound effects can be synthesised in code. | CC0 tracks |
| 3 | What is the oldest phone to support? | A 2021 mid-range Android |
| 4 | Simulation first, or something visible early? | Simulation first; pieces 2.1 and 2.2 can move up after 1.4 |
