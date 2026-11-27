# Sinews of War

> Money, power, supply. The battle is decided before the first shot.

A 3D real-time strategy game for phones (landscape, touch first) and
desktop, where you run the commerce and logistics of a war. You fund the
front, keep it powered, decide what gets built and researched, and send
forces where they are needed. Your units handle the shooting.

**Status:** planning. No game code exists yet. The full plan is in
[PLAN.md](PLAN.md).

## The idea

- **The manager's war.** Income arrives on a timer from command posts you
  must protect. Every building draws from a power budget you must not
  overdraw. Winning is a matter of spending better than the other side.
- **Just enough to think about.** Two budgets, seven unit classes, a short
  research list. Always a decision waiting, never a spreadsheet.
- **Real nations, added as packs.** Parties are real nations and
  coalitions. The game starts with two and is built so more can be added
  as data, with no change to the rules.
- **Same classes, signature looks.** Every party fields the same classes at
  near-equal power. What differs is how each party's equipment looks,
  sounds and is named.
- **Terrain matters quietly.** High ground sees further, woods shelter
  infantry, roads speed vehicles, mud slows them. Small nudges, never
  pop-ups.
- **A story for every party.** Each party has its own campaign, told from
  its own side.
- **2026 picture quality.** Modern lighting and materials on a miniature
  battlefield look, with a few animations polished until they feel right.

## Parties and theatres

| Theatre | Working title | Parties at launch | Location |
|---|---|---|---|
| 1 | Black Soil | NATO, Russia | Ukraine |

More parties and theatres are planned. Each arrives as a content pack: a
skin kit, sounds, text and a campaign on top of the shared class table.

## How the story is told

The first theatre is a fictional near-future escalation, not a retelling of
real events. This is a real and ongoing war, so the project follows these
rules:

- Real countries and coalitions appear as parties.
- All characters are fictional. No real leaders or commanders appear.
- No real atrocities and no re-enacted real battles.
- Civilians are never targets and never score.
- Soldiers on every side are written as professionals.

## Technology

| Part | Choice |
|---|---|
| Engine | Godot 4 |
| Language | Typed GDScript |
| Simulation | Fixed 100 ms step, deterministic, separate from drawing |
| Renderers | Mobile on phones, Forward+ on desktop |
| 3D models | Built in code, replaceable with authored glTF files |
| First target | Android, landscape |

## What is in this repository

| Path | What it is |
|---|---|
| [PLAN.md](PLAN.md) | The build plan, in small pieces, each tied to a learnings note |
| [target/learnings/](target/learnings/README.md) | Study notes on how a 2010 phone strategy game works: economy, combat, movement, missions, animation |
| `target/92aace22-artofwea_S8000.jar` | The file those notes were made from |

The JAR and everything decoded from it belong to HeroCraft and Gear Games.
They are study material only. Sinews of War reuses the lessons about how
such a game works and none of that game's code, art, maps, names or story.

## Roadmap

| Phase | Outcome |
|---|---|
| 0 Foundations | Missing study notes filled in; project skeleton; class roster, story bible and art direction approved |
| 1 Simulation | The full rules running headless and deterministic, for any number of sides |
| 2 3D presentation | Terrain, models, animation, effects and sound |
| 3 Touch controls | A whole mission playable with two thumbs |
| 4 Content | Two campaigns, skirmish maps, and a proven way to add a party |
| 5 Polish and ship | Performance, saves, languages, store readiness |

Details, open questions and risks are in [PLAN.md](PLAN.md).
