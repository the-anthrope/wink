# Learnings from a pocket strategy game

**Goal:** learn how to build something exciting by taking apart something
that worked. The subject is one file in this repo,
`target/92aace22-artofwea_S8000.jar`: a 2010 Java ME phone game, *Art Of
War 2 - Global Confederation*, a complete real-time strategy game in 546 KB.

These notes are not a forensic report. They are organised around one
question: **what would I copy, what would I fix, and how do I build my
own?** The detailed analysis is kept underneath as backing, and every claim
links to the line of code or the data table that shows it.

## Start here

| I want to... | Go to |
|---|---|
| **Learn to build one** | [`build/`](build/README.md): 11 lessons and recipes, in order |
| Understand exactly how a rule works | [`gameplay/`](gameplay/README.md): 14 deep-dive notes |
| Understand how the pictures move | [`animations/`](animations/README.md): 5 notes with proof images |
| Look up a number | [`reference/`](reference/01-units.md): units, buildings, research, missions, story |
| See how the original is put together | [`internals/`](internals/README.md): files, formats, code layout, online features |
| Check a claim or reproduce a result | [`evidence/`](evidence/README.md): decompiled code, decoded data, scripts |

## The map

```
learnings/
├── build/        LEARN   what to copy, recipes, balance study, build plan
├── gameplay/     RULES   economy, combat, research, enemy, missions
├── animations/   LOOKS   sheets, frame tables, units, effects, timing
├── reference/    NUMBERS units, buildings, research, missions, story
├── internals/    ANATOMY identity, code, assets, data formats, online
└── evidence/     PROOF   decompiled/  data/  tools/
```

Read top to bottom for understanding; read bottom to top to verify.

## How every note is written

- One question per note, stated in the title. Short enough to read in a few
  minutes.
- **Build notes:** The idea -> What the original does -> Recipe -> Knobs ->
  Pitfalls -> Evidence -> Next.
- **All other notes:** In one line -> The short answer -> How it works ->
  How we know -> Still unknown -> Next.
- Follow **Next** at the bottom of a note to walk its folder in order.
- Claims are tagged **Observed** (a code line or data value shows it),
  **Inferred** (reasoned from observed facts) or **Unknown**.

## Ten ideas worth taking

1. One loop with a fixed 100 ms step; rules kept apart from drawing.
2. World state in flat arrays with hard caps; a save is a dump of them.
3. Every number and every string in a table indexed by a small id.
4. Income on a timer from a building you can lose, with falling returns.
5. A second budget, energy, that never accumulates.
6. One damage formula in which armour makes small guns bounce.
7. Weapons, modes and upgrades as table rows, not code.
8. A unit cap as the lever that makes expensive units worth buying.
9. Enemies and missions made of timers, painted zones and a linear script.
10. Pictures assembled in layers from shared parts.

Each is explained in [`build/`](build/README.md).

## How this was made

Static analysis only: the game was never run. The JAR was unpacked, its 18
classes decompiled with the JADX library, and each data file decoded by a
small script written from the game's own loader. Five readers then worked
through the simulation code by topic, and their findings were checked
against the cited lines. Details and a rebuild recipe are in
[`evidence/README`](evidence/README.md).

## Limits

- Decompiled code is a reconstruction and is wrong in places; where it
  mattered, bytecode was read directly.
- Timings assume the game keeps up with its 100 ms step.
- The mechanics and patterns are yours to use. The original's names, story,
  art and text belong to HeroCraft and Gear Games.
