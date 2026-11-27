# How is a map stored?

> **In one line:** Size, tileset, run-length-coded ground tiles, a list of
> trees and rocks, then one bit per cell saying "is this cell open ground".

## The short answer
- A map is a grid of cells, up to 80x80. On screen a cell is 30x20 pixels.
- Ground is run-length coded: pairs of (count, tile id).
- Decor objects (trees, rocks, bushes) are (kind, x, y) triples.
- Six terrain files serve seven missions: missions 4 and 5 share `m3`.

## How it works

```
byte   width  (cells)
byte   height (cells)
byte   tileset (index into `ml`)
u16    run count
  per run:    byte count, byte tile id        fills row by row
u16    object count
  per object: byte kind, byte x, byte y
per row:
  ceil(width / 32) x u32    bit mask, leftmost cell = highest bit
```

All multi-byte numbers are big-endian.

Loading builds two grids:

| Grid | Holds | Values after loading |
|---|---|---|
| ground | which tile picture to draw | tile id, randomised within its class |
| occupancy | what stands on the cell | 0 = open, 124 = closed (the starting value), 125/126 = covered by decor or water, 128+n = decor object n anchored here |

The occupancy grid starts as 124 everywhere. Water tiles and the footprint of
each decor object overwrite that with 125, 126 or an anchor code. The final
bit mask then opens the map up: where a cell's bit is **0**, any of those
codes is reset to 0, open ground. Where the bit is 1, the code stays.

So the mask, not the picture, decides where units can go. A wide tree can be
drawn over four cells while the mask leaves three of them open. During play
the same grid also carries unit numbers, building numbers, mines (121-123)
and walls (1001 upward).

| File | Size | Tileset | Decor objects | Mission |
|---|---|---|---|---|
| `m0` | 60x40 | 0 | 293 | 1 Pucallpa |
| `m1` | 60x60 | 0 | 251 | 2 Ucayali Bank |
| `m2` | 40x80 | 0 | 302 | 3 Miguel Capture |
| `m3` | 80x60 | 1 | 660 | 4 Outpost, 5 Slaughter |
| `m4` | 60x80 | 1 | 756 | 6 Storm In Gorge |
| `m5` | 80x80 | 1 | 801 | 7 The Last Battle |

Schematic renders of each mission's map are in
[reference/missions](../06-reference/04-missions.md).

## How we know
- [`g.java:1073`](../source/decompiled/g.java#L1073) : the terrain parser; each field above is one read in this method (Observed)
- [`g.java:1137`](../source/decompiled/g.java#L1137) : the reader helper, most significant byte first (Observed)
- [`g.java:1078`](../source/decompiled/g.java#L1078) : every cell starts as 124 (Observed)
- [`g.java:1126`](../source/decompiled/g.java#L1126) to [`g.java:1129`](../source/decompiled/g.java#L1129) : the bit-mask pass; a 0 bit resets codes between 100 and 1001 to 0 (Observed)
- Cell size 30x20: screen positions are computed as `x * 30`, `y * 20`, for example [`g.java:4436`](../source/decompiled/g.java#L4436) (Observed)
- `../source/tools/maps.py` : sizes and counts in the table (Observed)
- That 0 means open ground for movement (Inferred here; see [gameplay/04-movement](../gameplay/04-movement.md))

## Still unknown
- `maps.py` does not check that each `m` file is consumed to its last byte.

**Next:** [Mission files `mi0`..`mi6`](06-mission-mi-files.md)
