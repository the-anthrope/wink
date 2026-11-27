# What units exist, and what are their numbers?

> **In one line:** 14 buildable units, 7 per side, with cost and HP read
> straight from the balance file.

## The short answer
- Each side has three infantry and four vehicles. The sides are not mirror
  images: Rebel vehicles are cheaper and faster, Confederation units hit
  harder.
- The build menu shows three stats per unit: attack, armour, speed.
- The code uses **type ids** 0..18, which are not the menu order. Rebel
  units have the even ids 0..12; Confederation units have odd ids plus 18.
- Five more type ids (7, 11, 14, 15, 16) are alternate forms of a base
  unit.

## How it works

| Menu slot | Unit | Side | Type id | Cost | HP | Attack | Armour | Speed |
|---|---|---|---|---|---|---|---|---|
| 0 | Assault | Confederation | 1 | 10 | 30 | 5 | 0 | 4 |
| 1 | Heavy Assault | Confederation | 3 | 20 | 40 | 10 | 1 | 3 |
| 2 | Flame Assault | Confederation | 5 | 30 | 70 | 14 | 0 | 3 |
| 3 | AV-40 Fortress | Confederation | 18 | 100 | 120 | 16 | 4 | 3 |
| 4 | T-21 Hammer | Confederation | 9 | 120 | 90 | 18 | 3 | 4 |
| 5 | T-22 Zeus | Confederation | 17 | 220 | 120 | 24 | 4 | 2 |
| 6 | MLRS Torrent | Confederation | 13 | 300 | 100 | 50 | 4 | 1 |
| 7 | Infantry | Rebel | 0 | 10 | 30 | 4 | 0 | 5 |
| 8 | Grenadier | Rebel | 2 | 20 | 40 | 8 | 0 | 4 |
| 9 | Sniper | Rebel | 4 | 40 | 50 | 12 | 0 | 3 |
| 10 | Coyote | Rebel | 6 | 40 | 60 | 6 | 1 | 6 |
| 11 | Armadillo | Rebel | 8 | 70 | 90 | 9 | 2 | 5 |
| 12 | Rhino | Rebel | 10 | 150 | 100 | 15 | 4 | 4 |
| 13 | Porcupine | Rebel | 12 | 220 | 100 | 20 | 4 | 3 |

Where each column comes from (`../source/data/a.json`):

| Column | Source | Note |
|---|---|---|
| Type id | `seg[92][slot]` | |
| Cost | `tables[5][type]` | The menu shows cost x a per-side factor / 10; the factor is 10 by default |
| HP | `seg[42][type]` | Used as stored. The same value also sets training time, see [gameplay/03](../gameplay/03-building-and-training.md) |
| Attack | `seg[31][type]` | The value shown. The damage a hit really does is in [gameplay/05-damage](../gameplay/05-damage.md) |
| Armour | `seg[29][type]` | |
| Speed | `10 - seg[27][type]` | `seg[27]` is a delay, so smaller is faster |

Names are strings `T0_49`..`T0_62`; descriptions `T1_94`..`T1_100` cover the
seven Confederation units only.

Alternate forms in the data, by type id:

| Type id | Cost | HP | Attack | Armour | `seg[52]` link |
|---|---|---|---|---|---|
| 7 | 100 | 120 | 20 | 4 | none |
| 11 | 220 | 120 | 30 | 4 | none |
| 14 | 40 | 50 | 12 | 1 | 14 -> 4 (Sniper) |
| 15 | 150 | 100 | 10 | 4 | 15 -> 10 (Rhino) |
| 16 | 250 | 100 | 13 | 4 | 16 -> 13 (MLRS Torrent) |

What each alternate form is in play is covered in
[gameplay/06-weapons-and-special-modes](../gameplay/06-weapons-and-special-modes.md).

## How we know
- [`g.java:4808`](../source/decompiled/g.java#L4808) : menu slot `b` draws name `T0_{49+b}` (Observed)
- [`g.java:4769`](../source/decompiled/g.java#L4769) : slot -> type id through the copy of `seg[92]` (Observed)
- [`g.java:4817`](../source/decompiled/g.java#L4817), [`g.java:4820`](../source/decompiled/g.java#L4820), [`g.java:4823`](../source/decompiled/g.java#L4823) : the three stats the panel prints (Observed)
- [`g.java:4826`](../source/decompiled/g.java#L4826) : the cost line (Observed)
- [`p.java:3240`](../source/decompiled/p.java#L3240) : HP at spawn from `seg[42]` (Observed)
- Tutorial text `T2_28` names the panel values "attack, armor, speed" in that order (Observed)

## Still unknown
- Nothing significant for the base table.

**Next:** [Buildings](02-buildings.md)
