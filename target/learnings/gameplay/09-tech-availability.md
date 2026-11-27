# What can you build in each mission?

> **In one line:** Three small tables indexed by mission number decide it: one picks the Command center's building list, one marks researches as already done, one hides researches; unit lists then grow only through research.

## The short answer

- The player is always the Confederation (side 0). The enemy is always the Rebels.
- Mission 1 has no Technology center and no Machine factory. Mission 3 has no Machine factory. From mission 4 on everything except the Locator is in the menu.
- Vehicles in the menu are always AV-40, Hammer and Zeus. The Torrent needs research 13, the Flame Assault needs research 5, the Locator needs research 18.
- Later missions hand you researches for free at the start (2 in mission 4, 16 in mission 7).
- Custom games use the same row as "mission 8": full building list, nothing pre-researched, nothing hidden.
- The enemy's masks mirror yours, shifted by 24 bits, with a few extras.

## How it works

At mission start the game reads row `min(missionIndex, 7)` (mission 1 = index 0) of three tables:

| table | size | becomes | meaning |
|---|---|---|---|
| `seg[129]` | 1 byte per row | `f112b[0]` | level of the Command center building list |
| `seg[127]` | 6 bytes per row | `f414a` | researches already done (bit i = research i) |
| `seg[128]` | 6 bytes per row | `f416c` | researches not offered |

On a fresh start every research whose `f414a` bit is set has its effect applied at once. Research numbers below are those of [file 08](08-research-effects.md).

### Player, per mission

| Mission | Command center builds | Already researched | Hidden researches |
|---|---|---|---|
| 1 Pucallpa | Generator, Infantry center, Bunker, Wall | none | all except 0 and 2 (and there is no Technology center) |
| 2 Ucayali Bank | Command center, Generator, Infantry center, Machine factory, Technology center, Bunker, Wall | none | 7-14, 16, 17, 18, 20, 21 |
| 3 Miguel Capture | as mission 2 **without** Machine factory, **plus** Rocket launcher | none | 6-14, 20, 21 |
| 4 Outpost | everything except Locator | 0, 5 | 11, 12, 14 |
| 5 Slaughter | everything except Locator | 0-5, 17 | 14 |
| 6 Storm In Gorge | everything except Locator | 0-6, 8, 16, 17 | none |
| 7 The Last Battle | everything (Locator included, via research 18) | 0-10, 13, 16, 17, 18, 23 | none |
| Custom game | everything except Locator | none | none |

What that means for units:

| Mission | Infantry center | Machine factory |
|---|---|---|
| 1 | Assault, Heavy Assault | no factory |
| 2 | + Flame Assault after research 5 | AV-40, Hammer, Zeus (vehicle researches 7-14 hidden) |
| 3 | + Flame Assault after research 5 | no factory; Locator after research 18 |
| 4, 5 | Flame Assault from the start | AV-40, Hammer, Zeus; Torrent after research 13 |
| 6 | Flame Assault from the start | AV-40 is the flame variant from the start; Torrent after 13 |
| 7 | Flame Assault from the start | flame AV-40, Hammer, Zeus, Torrent from the start |
| Custom | + Flame Assault after research 5 | AV-40, Hammer, Zeus; Torrent after 13 |

### The menu lists behind this

Each production building reads a list `seg[95+2c]`, cut by offsets `seg[96+2c]`, at level `f112b[c]` (c = 0 Command center, 1 Infantry center, 2 Machine factory). Research moves the level up by one.

| list | level | contents |
|---|---|---|
| buildings | 0 | Generator, Infantry center, Bunker, Wall |
| buildings | 1 | Command center, Generator, Infantry center, Machine factory, Technology center, Bunker, Wall |
| buildings | 2 / 3 | level 1 without Machine factory, plus Rocket launcher / plus Locator too |
| buildings | 4 / 5 | all without Locator / all nine |
| infantry | 0 / 1 | Assault, Heavy Assault / plus Flame Assault |
| vehicles | 0 / 1 | AV-40, Hammer, Zeus / plus Torrent |
| vehicles | 2 / 3 | AV-40, Hammer / plus Torrent |
| vehicles | 4 / 5 | AV-40 / plus Torrent |

`seg[129]` = [0, 1, 2, 4, 4, 4, 4, 4]. Research 18 turns level 2 into 3 and level 4 into 5, In mission 2 it is hidden; level 1 + 1 would remove the Machine factory, which is the likely reason (Inferred).

Vehicle levels 2-5 are reachable only through a mission-script command (opcode 33 with value 21, 22 or 23). It sets a "tech level" and hides the matching researches:

| script value | vehicle list | researches hidden in addition |
|---|---|---|
| 20 | level 0 | none |
| 21 | level 0 | 13, 14 |
| 22 | level 2 | 11, 12, 13, 14 |
| 23 | level 4 | 7, 9, 10, 11, 12, 13, 14, 16, 20 |

None of the seven campaign scripts uses these values, so they matter only for downloaded custom maps (Inferred).

### What `f415b = 281138895495613` means

It is the "prerequisite met" mask at mission start. Set bits: 0, 2-5, 7, 8, 13, 15-29, 31, 32, 36, 37, 39-47. The twelve clear bits are the researches with a prerequisite:

| clear bit(s) | set when this is researched |
|---|---|
| 1 Bio suit / 6 Volcano flame gun / 14 Torrent-10 | 0 Energy suit / 5 Lava flame fuel / 13 Torrent-5 |
| 9, 10, 11, 12 | 8 Reinforced engine |
| enemy 30 / 33, 34, 35 / 38 | enemy 29 / 32 / 37 |

A prerequisite never unlocks a research that the mission hides.

### Enemy, per mission (bit numbers 24-47)

| Mission | Already researched | Not allowed |
|---|---|---|
| 1 | none | all except 24 and 26 |
| 2 | none | 31-38, 40, 41, 42, 44, 45 |
| 3 | none | 31-38, 44, 45 |
| 4 | 24-29, 36, 41 | 35, 38 |
| 5 | 24-29, 36, 37, 41 | 38 |
| 6 | 24-30, 32, 36, 37, 40-44 | none |
| 7 | 24-34, 36, 37, 40-44, 47 | none |
| Custom | 41, 42 | none |

The enemy needs a living Laboratory to research the rest. Which units and buildings the enemy produces is not set by these masks: the mission script orders them (see [file 11](11-enemy-ai.md)).

Scripted reinforcements for the player follow your research: a Torrent in the wave table is replaced by the entry before it until research 13 is done, and researches 6 and 12 rewrite the table to the upgraded AV-40 and Zeus.

## How we know

- [`p.java:680`](../source/decompiled/p.java#L680) : `f414a` and `f416c` built from `seg[127]` / `seg[128]`, 6 bytes per row, row = `min(mission, 7)` (Observed)
- [`g.java:832`](../source/decompiled/g.java#L832) : `f112b[0] = seg[129][min(mission, 7)]`, other levels 0 (Observed)
- [`g.java:873`](../source/decompiled/g.java#L873) : on a fresh start, `c(i)` runs for every set bit (Observed)
- [`g.java:2043`](../source/decompiled/g.java#L2043) : menu length from `seg[96+2c]` at level `f112b[c]`; [`p.java:1929`](../source/decompiled/p.java#L1929) : item looked up in `seg[95+2c]` (Observed)
- [`p.java:3543`](../source/decompiled/p.java#L3543), [`p.java:3640`](../source/decompiled/p.java#L3640), [`p.java:3670`](../source/decompiled/p.java#L3670) : researches 5, 13, 18 add 1 to a list level (Observed)
- [`p.java:3008`](../source/decompiled/p.java#L3008) : script tech levels 20-23; [`p.java:2963`](../source/decompiled/p.java#L2963) : reached from opcode 33 (Observed)
- [`p.java:684`](../source/decompiled/p.java#L684), [`p.java:3853`](../source/decompiled/p.java#L3853) : start mask and unlock rule (Observed)
- [`k.java:384`](../source/decompiled/k.java#L384) : player side fixed at 0; [`g.java:3438`](../source/decompiled/g.java#L3438) : player menu limited to bits 0-23 (Observed)
- [`p.java:2857`](../source/decompiled/p.java#L2857) : Torrent swap in reinforcement waves; [`p.java:3554`](../source/decompiled/p.java#L3554), [`p.java:3633`](../source/decompiled/p.java#L3633) : wave table rewritten (Observed)
- `../source/tools/tech_masks.py ../source/data/a.json` prints every table on this page from `seg[92]`, `seg[95..100]`, `seg[127..129]` (Observed)
- `../source/tools/missions_full.py` output: opcode 33 values used in the campaign are 1, 8, 9, 13, 15, 18, 19, 100, 150, 200, 220; none is 20-28 (Observed)
- `../source/data/sn8p.json` `T2_56` "Now the machine factory and technology center are available to you" fits mission 2 (Inferred)

## Still unknown

- Which downloadable custom maps use script tech levels 21-23. No custom map file is in the JAR.
- Whether placing a building needs another building first (not seen in the menu code; not traced further).

**Next:** [How do ranks, score and difficulty work?](10-ranks-score-difficulty.md)
