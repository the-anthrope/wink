# Plan: Sinews of War

An original 3D real-time strategy game in Godot 4, built on the
[learnings](target/learnings/README.md).

Status: plan only. Nothing is built yet.

## The bar

This section is the owner's intent in the owner's words. It outranks every
table below. Where a piece of the plan and this section disagree, this
section wins.

> "make this game the best game played with interest"
>
> "a killer and extremely fun to play game, a game which I would play myself"
>
> "keep minds like mine occupied throughout, not too much complications I
> give up, not too simple that it's boring, just the right amount"
>
> "good visuals, super quality"
>
> "2026 picture quality, cool but simple animation of high quality"
>
> "if you pacify it in plan we will get something which is mediocre"

What that means for the work:

- **Mediocre is a failure, not a stage.** "It works" never closes a piece.
  A piece closes when it is something to be proud of.
- **The owner's verdict is the test.** Not a checklist, not a frame
  counter. Does the owner pick up the phone to play it again without being
  asked?
- **Nothing gets softened to make it easier to build.** If a piece cannot
  reach the bar the way it was planned, the approach changes. The bar
  stays.
- **Bad news is said out loud.** When something falls short it is reported
  as short, with what it would take to fix.

What counts as mediocre, so it can be caught early:

| Symptom | Where it shows |
|---|---|
| More than about 15 seconds with nothing worth deciding | Economy pacing, wave timers |
| A moment where the player feels lost or buried in options | Menus, research list, tutorial |
| A unit or building that looks like a placeholder | Models, materials, lighting |
| An animation that pops, slides or floats | Movement, turrets, deaths |
| A shot or explosion you see but do not feel | Effects, sound, camera shake, haptics |
| A tap that needs a second try | Touch targets, gesture handling |
| A win that felt handed over, or a loss that felt unfair | Opponent behaviour, balance |
| A mission you would skip on a replay | Mission design, story |

Any one of these, found in play, reopens the piece that caused it.

## Decisions so far

| Decision | Choice |
|---|---|
| Working name | **Sinews of War** (see [Name](#name)) |
| Engine | Godot 4, native builds, Android first |
| Priority | Fun first. A killer game the owner cannot put down, before any extra content. See [The bar](#the-bar). |
| Play style | You manage the commerce and logistics of a war: money, power, production, research. Units fight on their own judgment. |
| Depth | The original's level of complexity, which got it right. No more, no less. See [Complexity budget](#complexity-budget). |
| Logistics | The economy of the learnings (money, power, production) plus roads and terrain. No supply-line system. |
| Parties | Real nations and coalitions. Two at launch, built so more can be added as data. |
| First theatre | NATO vs Russia, located in Ukraine. Real countries and coalitions; no real battles and no real leaders. |
| Balance | Every party fields the same classes at near-equal power. Each party has its own signature look. |
| Story | One campaign per party, each with its own story |
| Terrain | Gives quiet advantages inside the existing rules |
| Visuals | 2026 picture quality; few animations, each done well |
| 3D models | Built in code |
| Scope | Campaigns plus skirmish against an AI |

## What this is, and what it is not

The learnings describe Art Of War 2 - Global Confederation, whose code, art,
text and maps belong to HeroCraft and Gear Games
([README limits](target/learnings/README.md)). This project is **not a port**
of that game. It applies what the learnings teach about how such a game
works.

| Taken from the original (how things work and read) | Made new (what things are) |
|---|---|
| The rules: timer economy, energy budget, armour formula, scripted missions | Every model, building and HUD element |
| Scale relations: soldier vs tank vs building footprint | Every map layout |
| Top-down readability: silhouettes, team colour areas | Parties, classes and their names |
| Hull / turret / muzzle layering for animation | Story, characters, dialogue |
| Effects vocabulary: tracers, smoke, craters, wrecks | Music and sound |
| The balance formula shapes | The class table and its tuned numbers |

## Pillars

1. **The manager's war.** The player wins by funding, powering and supplying
   the fight. This is the economy of the learnings
   ([build/05](target/learnings/build/05-economy-recipe.md)) kept as the
   centre of play, at the original's depth.
2. **Parties are data.** A party is a content pack. Adding one never touches
   the rules code.
3. **Same classes, signature looks.** One shared class table sets power. A
   party changes how a class looks, sounds and is named.
4. **Terrain matters quietly.** Ground gives small integer nudges to rules
   that already exist. No extra panels, no pop-ups.
5. **Every party has a story.** Each campaign is told from that party's side
   by fictional characters.
6. **Looks like 2026 on a phone.** Modern lighting and materials, and a
   small set of animations polished until they feel good.

## Complexity budget

The aim is a game that keeps a busy mind occupied the whole time without
ever feeling like homework. The original hit that balance, so its size is
the ceiling here.

| What the player juggles | The original | Budget here |
|---|---|---|
| Resources | 2: money and energy | 2 |
| Unit classes per party | 7: three infantry, four vehicles | 7 |
| Buildings | 8 plus walls | 8 plus walls |
| Research items | 24, in five short chains | About 24 |
| Special unit modes | Deploy / siege on a few units | The same few |
| Workers, gathering, unit abilities to trigger by hand | None | None |

Sources: [reference/01](target/learnings/06-reference/01-units.md),
[reference/02](target/learnings/06-reference/02-buildings.md),
[reference/03](target/learnings/06-reference/03-research.md).

Why the original holds attention, and what to protect:

- **A decision is always a few seconds away.** Income lands every 12.8 s,
  a queue finishes, a research completes, a wave is on its timer
  ([gameplay/01](target/learnings/gameplay/01-money.md),
  [gameplay/11](target/learnings/gameplay/11-enemy-ai.md)).
- **The sums fit in your head.** Energy needs are 0 to 3 per building
  ([gameplay/02](target/learnings/gameplay/02-energy.md)).
- **Units look after themselves.** They pick targets, hit back and call
  for help, so attention goes to the plan
  ([gameplay/11](target/learnings/gameplay/11-enemy-ai.md)).

The rule for anything new: it must hide inside a rule that already exists,
or replace something. Terrain passes this test because it only nudges
existing numbers. Supply lines fail it, so they are out.

## Build order: fun first

The phases below are grouped by subject. The order of work is set by these
milestones, so there is a game to play as early as possible.

| Milestone | Contents | Judged by |
|---|---|---|
| A. First playable | One skirmish map, one skin kit used by both sides, the whole core loop: economy, building, training, combat, terrain, a simple opponent, touch controls. Pieces 0.2, 0.3, 1.1 to 1.8, a first cut of 1.13, 2.1, a first cut of 2.3, 3.1 to 3.4. | You play it on your phone |
| B. Fun pass | Tune the tables and the feel until the game is hard to put down. As many rounds as it takes. Nothing else starts before this passes. | You keep playing after the test is over |
| C. Looks and sound | The rest of phase 2 and 3, second skin kit | Screenshots and feel |
| D. Story and content | Story bible, both campaigns, skirmish maps, the "add a party" proof | Campaigns playable end to end |
| E. Ship | Phase 5 | Signed build |

Party extensibility stays in the architecture from the start because it is
cheap there. Content for further parties waits until after milestone D.

## Parties, sides and classes

The words used in this plan:

| Term | Meaning |
|---|---|
| **Nation** | A real country |
| **Coalition** | A real alliance of nations, such as NATO |
| **Party** | What the player picks: a nation or a coalition, shipped as one content pack |
| **Side** | One seat in a battle (1 to 8). Each side plays one party. |
| **Team** | Sides that are allied in a battle and share vision |
| **Class** | A role with fixed stats, such as rifle squad or main battle tank |
| **Skin kit** | A party's models, colours, sounds and names for every class |
| **Trait** | A small stat nudge that gives a party flavour, capped at 10% |
| **Theatre** | A location with its maps and campaigns. The first is Ukraine. |

How a party pack is put together:

| Layer | Shared by all parties | Per party |
|---|---|---|
| Rules | Class table: price, health, armour, speed, sight, weapons | Up to a few traits, each within 10% |
| Look | Footprint, muzzle points, selection size | Skin kit: silhouettes, details, palette, markings |
| Sound | Mix levels, event hooks | Weapon sounds, voice lines, music theme |
| Text | String keys | Class names, briefings, dialogue |
| Story | Mission script format | Its own campaign |

The original fixes two sides in its indexing and gives the computer side
special cases ([build/03](target/learnings/build/03-architecture-you-can-copy.md),
[gameplay/01](target/learnings/gameplay/01-money.md)). Here the number of
sides is a parameter from the first line of simulation code, and a
three-side battle is part of the tests even though launch content has two
parties.

Launch parties: **NATO** (a coalition) and **Russia**. Parties planned for
later are added as packs; a written "add a party" guide and a proof pack are
piece 4.6.

## Story

Direction for approval in piece 0.4:

- **Premise.** A fictional near-future escalation: a direct NATO-Russia
  conflict on Ukrainian territory that has not happened. It is not a
  retelling of real battles.
- **The player's role.** In each campaign the player is a theatre logistics
  commander. The story is about keeping an army paid, powered and supplied,
  which is exactly what the player does with their hands.
- **Two campaigns.** The NATO campaign follows a multinational supply
  command: many capitals, promises that arrive late, coordination as the
  struggle. The Russian campaign follows a rail-and-depot command: distance,
  attrition, keeping lines running under strain.
- **Shared ground.** Some maps are played from both sides. The learnings
  show one map serving an attack mission and a defence mission
  ([reference/04](target/learnings/06-reference/04-missions.md)).

Content guidelines, recommended because this is a real and ongoing war with
real victims, and because app stores review such content:

| Guideline | Reason |
|---|---|
| All characters are fictional. No real leaders or commanders appear. | Respect, and store rules on real entities |
| No real atrocities and no re-enacted real battles | The game is a hypothetical, not a commentary on events |
| Civilians are never targets and never score | Tone |
| Soldiers on every side are written as professionals | Each party gets a campaign worth playing |
| Real region, fictional town names (assumed, see open questions) | Avoids staging the destruction of real cities |

## Terrain

Terrain type is one more table indexed by cell. Each effect is a nudge of
one point to a number the rules already use, so the armour formula, move
periods and sight ranges do the work.

| Terrain | Effect | Rule it plugs into |
|---|---|---|
| High ground | +1 sight, and +1 range when firing downhill | Sight and range tables |
| Woods | Infantry inside get +1 armour and are spotted from 2 cells closer | [Armour formula](target/learnings/gameplay/05-damage.md) |
| Ruins and rubble | Infantry inside get +1 armour; vehicles move 1 tick per cell slower | Armour formula, [move period](target/learnings/gameplay/04-movement.md) |
| Road | Vehicles move 1 tick per cell faster | Move period |
| Mud and soft ground | Vehicles move 1 tick per cell slower; can be seasonal per mission | Move period |
| River | Blocked except at bridges and fords; fords are slow | [Walkability mask](target/learnings/04-data-formats/05-terrain-m-files.md) |

Why this stays subtle: one armour point removes 1 damage from a small-arms
hit and 10% from a heavy hit, so cover helps without deciding the fight.
Modifiers never stack past 2 points. The only display is a small marker on
the selection ring and on the unit card. Routing and target choice weigh
terrain, so the AI uses it too.

## Visual and animation targets

Art direction: a miniature battlefield diorama. Clean, readable models on
richly lit terrain. This direction makes code-built models look intended.

| Tier | Renderer | Picture features |
|---|---|---|
| Phone | Mobile | Physically based materials, soft sun shadows, baked ambient shading, bloom with filmic tone mapping, GPU particles, decals, animated water, wind-swayed vegetation, weather |
| Desktop | Forward+ | Adds screen-space ambient occlusion, volumetric fog and smoke lighting, depth of field. To be confirmed against the pinned Godot version in piece 0.5. |

Animation rule: few motions, each polished.

- Six motions per unit: move, aim, fire, take a hit, die, deploy.
- Driven by simulation state, so pictures never drift from the 10-step rules
  ([animations/03](target/learnings/animations/03-unit-animation.md)).
- Quality comes from easing, recoil springs, suspension rock on stopping and
  firing, scrolling tracks, dust and settling turrets.
- No motion capture and no long cinematic clips.

Limit to state plainly: code-built models give a stylised look. They will
not look hand-sculpted. Every model faces a turntable review against
[the bar](#the-bar). A model that falls short is reworked or replaced with
an authored glTF model through the same interface. It is never accepted as
good enough.

## Stack

- **Engine:** latest stable Godot 4, version pinned in piece 0.2.
- **Language:** typed GDScript, with the simulation as plain classes over
  packed integer arrays.
  - GDScript: built in, exports everywhere, fast enough for a few hundred
    entities at 10 steps per second.
  - C#: faster, but weaker mobile and web export.
  - GDExtension: native C++ speed, only worth it if profiling demands it.
- **Renderer:** Mobile on phones, Compatibility as a fallback, Forward+ on
  desktop.
  - Mobile: Vulkan/Metal, good lighting at phone cost.
  - Compatibility: OpenGL ES 3 for older phones, fewer effects.
  - Forward+: desktop-grade, the full feature set.
- **Verification:** Godot is not installed in the cloud environment used so
  far. Its download hosts responded, so installing it is piece 0.2 and
  untested until then. Touch feel can only be judged on a real phone, so
  each control piece ends with a build to try.

## Phase 0: Foundations

| # | Piece | Built on |
|---|---|---|
| 0.1 | Fill the gaps in the learnings: weapons and special modes, vision and fog, the seven missions one by one, building and effect animation, draw order and timing, the combat recipe. These notes are linked but missing (`gameplay/06`, `gameplay/07`, `gameplay/13`, `animations/04`, `animations/05`, `build/06`). Derive them from [`p.java`](target/learnings/source/decompiled/p.java) and [`a.json`](target/learnings/source/data/a.json). | [`weapons_table.py`](target/learnings/source/tools/weapons_table.py) |
| 0.2 | Project skeleton: `sim/` (rules, no nodes), `view/`, `ui/`, `data/`, `parties/`, `tests/`; landscape lock; headless test runner; screenshot run under a virtual display. | [build/03](target/learnings/build/03-architecture-you-can-copy.md) |
| 0.3 | Class roster one-pager for approval: the shared classes by role, buildings, research list, and the trait budget per party. | Role coverage in [reference/01](target/learnings/06-reference/01-units.md) |
| 0.4 | Story bible for approval: premise, cast for both campaigns, mission outline, content guidelines. | [Story](#story) |
| 0.5 | Art direction sheet for approval: diorama look, lighting targets, design cues per party, quality tiers checked against the pinned engine. | [Visual targets](#visual-and-animation-targets) |

**Done when:** the missing notes exist, `godot --headless` runs an empty test
suite green, and the three approval documents are signed off.

## Phase 1: Simulation (no graphics, tested headless)

| # | Piece | Built on | Improvement over the original |
|---|---|---|---|
| 1.1 | Fixed 100 ms step, with smooth drawing between steps | [build/03](target/learnings/build/03-architecture-you-can-copy.md) | Catches up after a slow frame; the original just ran slower |
| 1.2 | World state in flat arrays for any number of sides; teams and a hostility table; save is an array dump; replay is an order log | [build/03](target/learnings/build/03-architecture-you-can-copy.md) | Side count is a parameter; separate arrays for units and buildings |
| 1.3 | Tables: shared class table, party packs with capped traits, terrain table; a validator and a balance-sheet printer | [build/04](target/learnings/build/04-put-your-numbers-in-tables.md) | Named columns; build time gets its own column |
| 1.4 | Grid movement: 8 directions, one unit per cell, turn rates, cell reservation | [gameplay/04](target/learnings/gameplay/04-movement.md) | A* routing; group orders spread over nearby cells |
| 1.5 | Terrain effects as one-point nudges to sight, range, armour and move period; routing weighs terrain | [Terrain](#terrain), [gameplay/05](target/learnings/gameplay/05-damage.md) | The original has blocked or open ground only |
| 1.6 | Money on a timer with falling returns, kill bounty, energy budget | [build/05](target/learnings/build/05-economy-recipe.md), [gameplay/01](target/learnings/gameplay/01-money.md), [gameplay/02](target/learnings/gameplay/02-energy.md) | Every side runs the same economy; power-off order is visible; short undo refund |
| 1.7 | Construction radius, round-robin queue, pay when work starts, rally point | [gameplay/03](target/learnings/gameplay/03-building-and-training.md) | Queue shown; no silent failures |
| 1.8 | Combat: armour formula, locked bullets, area shells, flame, target choice, retaliation | [gameplay/05](target/learnings/gameplay/05-damage.md), [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) | Unit cards show the real damage |
| 1.9 | Deploy / siege forms as a type swap; vehicles crushing infantry | [build/04](target/learnings/build/04-put-your-numbers-in-tables.md), [animations/03](target/learnings/animations/03-unit-animation.md) | - |
| 1.10 | Fog of war and sight, shared per team | note written in 0.1 | Every side obeys fog |
| 1.11 | Research as table edits with prerequisite chains | [gameplay/08](target/learnings/gameplay/08-research-effects.md) | Descriptions generated from the numbers, so text cannot drift |
| 1.12 | Mission script: timeline commands for spawns, waves, dialogue, objectives, win / lose | [gameplay/12](target/learnings/gameplay/12-mission-scripting.md) | Adds event triggers (zone entered, building lost, kill count) and story beats |
| 1.13 | Opponents: scripted bases for campaigns; a skirmish AI with a real economy that works for any party and any number of sides | [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) | Fixes the dead alarm zones; three difficulty levels |

**Done when:** a two-side battle and a three-side battle each run headless
from an orders file and give the same final state hash twice.

## Phase 2: 3D presentation

| # | Piece | Built on |
|---|---|---|
| 2.1 | Camera rig (tilted, narrow field of view, pan and zoom limits); terrain mesh with height, roads, woods, mud, water and bridges read from the terrain table | [data-formats/05](target/learnings/04-data-formats/05-terrain-m-files.md) |
| 2.2 | Lighting and picture pipeline for both tiers: sun, shadows, baked shading, bloom, tone mapping, weather | [Visual targets](#visual-and-animation-targets) |
| 2.3 | Model kit in code: shared chassis parts with fixed footprints and muzzle points, then one skin kit per launch party. Each asset is reviewed on a turntable screenshot. | Scale and readability from [animations/01](target/learnings/animations/01-sprite-sheets.md) |
| 2.4 | Unit animation: the six polished motions; hull, turret and muzzle turn independently; death reactions keyed to bullet, blast, flame or crush | [animations/03](target/learnings/animations/03-unit-animation.md) |
| 2.5 | Buildings: rise during construction, visible powered-off state, damage stages, collapse to rubble | [gameplay/02](target/learnings/gameplay/02-energy.md), [gameplay/03](target/learnings/gameplay/03-building-and-training.md) |
| 2.6 | Effects: tracers, arcing shells, rocket trails, explosions, smoke, scorch decals, craters, wrecks, dust, camera shake | Sheet list in [animations/01](target/learnings/animations/01-sprite-sheets.md) |
| 2.7 | Audio: weapon and impact sounds per party, unit acknowledgements, layered music. The original shipped one tune and no sound effects. | [assets/03](target/learnings/03-assets/03-fonts-and-sound.md) |

**Done when:** the phase 1 replay plays back in 3D at 60 frames per second in
the software-rendered test run, with both launch skin kits on screen.

## Phase 3: Touch controls and HUD (landscape)

| # | Piece | Built on |
|---|---|---|
| 3.1 | Gestures: one-finger pan, pinch zoom, tap select, tap ground to move, tap enemy to attack, double-tap for same class, long-press drag for box select; mouse and keyboard mapping | new |
| 3.2 | Layout inside safe areas: command card under the right thumb, control groups under the left, money and energy always on top, tappable minimap | [build/05](target/learnings/build/05-economy-recipe.md) recipe step 6 |
| 3.3 | Build flow: ghost with green / red cells, radius ring, confirm and cancel; walls drawn as a dragged line | [gameplay/03](target/learnings/gameplay/03-building-and-training.md) |
| 3.4 | Production steppers with visible queue and rally flag; research tree panel | [gameplay/03](target/learnings/gameplay/03-building-and-training.md), [gameplay/08](target/learnings/gameplay/08-research-effects.md) |
| 3.5 | Feel: haptics, attack-move toggle, idle-unit button, under-attack alert with jump, terrain marker on the selection ring, pause, autosave checkpoints | [gameplay/10](target/learnings/gameplay/10-ranks-score-difficulty.md) |
| 3.6 | Story presentation: briefing screen, in-mission dialogue with portraits, objectives panel | [gameplay/12](target/learnings/gameplay/12-mission-scripting.md) |

**Done when:** a full mission can be finished on a phone using only thumbs,
with every touch target at least 48 dp.

## Phase 4: Content

| # | Piece | Built on |
|---|---|---|
| 4.1 | Class table tuned and checked by a headless duel matrix; party traits kept inside the 10% cap by the validator | Method from [gameplay/05](target/learnings/gameplay/05-damage.md) |
| 4.2 | Map pipeline: ground, walkability mask, terrain types and decor as separate data; an in-engine editor scene | [data-formats/05](target/learnings/04-data-formats/05-terrain-m-files.md) |
| 4.3 | Theatre one, Ukraine: a NATO campaign and a Russian campaign of about six missions each, sharing maps where the story allows; tech unlocked per mission; score and ranks | [gameplay/09](target/learnings/gameplay/09-tech-availability.md), [gameplay/10](target/learnings/gameplay/10-ranks-score-difficulty.md) |
| 4.4 | Skirmish: 4 to 6 symmetric maps for two to four sides, AI levels, start settings | [gameplay/11](target/learnings/gameplay/11-enemy-ai.md) |
| 4.5 | Story production: briefings, dialogue, portraits and voice lines for both campaigns | Story bible from 0.4 |
| 4.6 | "Add a party" guide, proven by adding a third test party with no change to rules code | [build/04](target/learnings/build/04-put-your-numbers-in-tables.md) |

**Done when:** both campaigns can be played start to finish, a skirmish can
be won and lost against each AI level, and the third test party loads and
plays.

## Phase 5: Polish and ship

| # | Piece |
|---|---|
| 5.1 | Performance budget on a mid-range Android phone, with quality tiers |
| 5.2 | Save / load, settings, string tables for languages ([build/04](target/learnings/build/04-put-your-numbers-in-tables.md)), colour-blind team colours |
| 5.3 | Playtest loop: mission length and loss stats feed table tuning |
| 5.4 | Store readiness: content review against the guidelines, age rating, store policy check |
| 5.5 | Android export first, then desktop and iOS |

**Done when:** a signed Android build holds the frame budget through the
largest mission and passes the content review.

## Risks

| Risk | What is known | Mitigation |
|---|---|---|
| App store review of a game about a current conflict | Google Play's sensitive events policy names conflicts and bars apps that exploit or are insensitive to them, with an exception for content of educational, documentary, scientific or artistic value. Apple's guideline on real entities as game enemies still has to be read against this design. | Content guidelines above; party names and markings live in data packs, so presentation can be adjusted without touching rules |
| Public reception | The setting is a war that is still being fought | Fictional premise and characters; no real events staged |
| Name clash | A quick web search found no game called Sinews of War. That is not a trademark clearance. | Proper search before any store listing |
| Code-built models fall short of the bar | They give a stylised look only | Turntable review per model; any that fall short are replaced with authored glTF models through the same interface |
| The game works but is not gripping | The most likely way this project ends up mediocre | Milestone B blocks everything after it; the symptom table in [The bar](#the-bar) reopens pieces |
| No on-device testing from the cloud environment | Touch feel and frame rate need a real phone | A build to try at the end of every control and visual piece |

## Name

**Sinews of War.** "The sinews of war" is the old phrase, from Cicero, for
the money and supply that make fighting possible. It names exactly what the
player manages.

Alternates if it does not land: *Frontline Ledger*, *Quartermaster's War*.
The first theatre carries its own title, working name *Black Soil*, so later
theatres can be added under the same game name.

## Open questions

| # | Question | Assumed until answered |
|---|---|---|
| 1 | What is Ukraine's role: the location only, an allied force in the story, or a playable party later? | Location, with Ukrainian forces present in the story |
| 2 | Real equipment designations, or invented designations on looks inspired by each nation's design school? | Invented designations |
| 3 | Real town and city names, or a real region with fictional towns? | Fictional towns |
| 4 | How different may parties be? | Traits within 10%, same classes for all |
| 5 | Is the name Sinews of War approved? | Yes, as a working name |
| 6 | Is there an Android phone to test builds on? iOS export needs a Mac and a developer account. | Android first |
| 7 | Where does music come from? Sound effects can be synthesised in code. | CC0 tracks |
| 8 | What is the oldest phone to support? | A 2021 mid-range Android |
