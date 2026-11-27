# How are `d0` and `ml` laid out?

> **In one line:** `d0` is 44 number arrays that describe how to cut and
> place sprite frames; `ml` is two short records, one per terrain tileset.

## The short answer
- `d0`: 26 arrays of signed bytes, then 18 arrays of signed 16-bit numbers,
  each with its own count in front. Big-endian.
- Arrays of the same length belong together: they are columns of one table.
- `ml`: per tileset, a list of decor frame ids and 30 threshold numbers that
  split tile ids into classes.
- What the `d0` columns mean (frame rectangles, anchors, sequences) is in
  [animations/02-frame-tables](../../animations/02-frame-tables.md).

## How it works

**`d0`**

```
26 times:   s16 big-endian n,  n signed bytes     -> bytes[0..25]
18 times:   s16 big-endian n,  n x s16 BE         -> shorts[0..17]
```

Group the arrays by length and the tables appear:

| Rows | Byte arrays | Short arrays |
|---|---|---|
| 2173 / 2295 | 0, 1, 2, 3, 4, 5 | 0, 1 |
| 7237 | 6 | 2, 3, 4 |
| 1704 | 7, 8, 9 | 7 |
| 992 | 10, 11, 12, 13 | 10 |
| 263 | 14 | 11, 12 |
| 797 | 15, 16, 17 | 13 |
| 146 | 18, 19 | 14, 15 |
| 997 | 20, 21, 22, 23, 24, 25 | 16, 17 |
| 305, 405 | | 5, 6 and 8, 9 |

One group is confirmed here: the 146-row table is **map objects**.
`bytes[18][i]` and `bytes[19][i]` are the width and height in cells of
object `i`, used when trees, rocks and buildings block cells.

**`ml`**

```
byte    number of tilesets (2)
per tileset:
    s16 BE  n
    n x s16 BE     decor list: frame id for each placeable decor object
    30 x s16 BE    thresholds
```

| Tileset | Decor entries | Used by |
|---|---|---|
| 0 | 342 | Missions 1-3 (jungle) |
| 1 | 340 | Missions 4-7 (mountain) |

The thresholds cut the ground-tile id range into classes. When a map is
loaded, each tile id is replaced by a random id from the same class, so the
same map file looks slightly different each time. Entry 13 is special: tile
ids at or above it are impassable (water or cliff).

## How we know
- [`k.java:1069`](../../evidence/decompiled/k.java#L1069) : `d0` loader, 26 then 18 arrays (Observed)
- [`k.java:1114`](../../evidence/decompiled/k.java#L1114) : `ml` loader (Observed)
- [`g.java:1083`](../../evidence/decompiled/g.java#L1083) and [`g.java:1084`](../../evidence/decompiled/g.java#L1084) : a map picks its tileset record (Observed)
- [`g.java:1093`](../../evidence/decompiled/g.java#L1093) to [`g.java:1097`](../../evidence/decompiled/g.java#L1097) : random tile within its class (Observed)
- [`g.java:1099`](../../evidence/decompiled/g.java#L1099) : threshold 13 marks blocked ground (Observed)
- [`g.java:1116`](../../evidence/decompiled/g.java#L1116) and [`g.java:1117`](../../evidence/decompiled/g.java#L1117) : object width and height from `bytes[18]`, `bytes[19]` (Observed)
- `../../evidence/tools/tables.py` : both files parse to their last byte (Observed)

## Still unknown
- The class names behind each threshold (grass, sand, road, water...).

**Next:** [Terrain files `m0`..`m5`](05-terrain-m-files.md)
