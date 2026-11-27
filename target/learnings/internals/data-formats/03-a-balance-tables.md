# Where do the game's numbers live?

> **In one line:** File `a` is 139 small byte arrays plus 9 arrays of 16-bit
> numbers; nearly every tuning value in the game is one of them.

## The short answer
- No names, no structure: just numbered arrays. Meaning comes from how the
  code indexes them.
- Byte arrays ("segments") hold small values: HP, armour, speeds, lookup
  tables, direction vectors. Short tables hold prices and larger values.
- Lengths give hints: 19 entries = per unit type, 15 or 16 = per building
  type, 25 = per weapon or research, 3 = per rank.
- The decoded file is `../../evidence/data/a.json`.

## How it works

```
139 times:   u16 little-endian n,  n bytes          -> seg[0..138]
  9 times:   u16 little-endian n,  n x u16 LE       -> tables[0..8]
```

File `d` (164 bytes) adds three more segments at run time: skip 4 bytes, then
read 33, 32 and 95 bytes into `seg[139]`, `seg[140]`, `seg[141]`.

**Segments and tables identified so far**

| Where | Length | Meaning | Confidence |
|---|---|---|---|
| `tables[5]` | 19 | Unit cost by unit type | Observed |
| `tables[6]` | 21 | Building cost by building type (15 = wall) | Observed |
| `tables[7]` | 51 | Research cost by research index | Observed |
| `seg[42]` | 19 | Unit max HP | Observed |
| `seg[27]` | 19 | Unit move period (menu shows speed = 10 - value) | Observed |
| `seg[29]` | 19 | Unit armour | Observed |
| `seg[31]` | 19 | Unit attack as shown in the menu | Observed |
| `seg[28]`, `seg[30]` | 19 | Unit sight range, attack range | Inferred |
| `seg[52]` | 19 | Alternate form of a unit type, or -1 | Observed |
| `seg[92]` | 14 | Menu slot -> unit type id | Observed |
| `seg[93]` | 16 | Menu slot -> building type id | Observed |
| `seg[61]` | 21 | Building energy need | Observed |
| `seg[130]`, `seg[131]` | 3 | Unit cap and building cap per rank: 20/35/50 and 10/25/51 | Observed |
| `seg[127]`, `seg[128]` | 48 | Per-mission "what is unlocked" bit masks, 6 bytes x 8 | Observed |
| `seg[14]` | 64 | Sine and cosine table (two 32-step circles) | Inferred |
| `seg[0]`, `seg[1]`, `seg[12]`, `seg[13]` | | Direction step vectors | Inferred |

The gameplay notes pin down many more as they use them; start at
[gameplay/README](../../gameplay/README.md).

**A trap in the code.** The loader reads each length as two bytes and the
decompiled line reads like big-endian. Read that way, the first length is
9,984 and the file ends after one segment. Read little-endian, all 139
segments and 9 tables consume exactly 5,501 bytes. The file decides.

## How we know
- [`k.java:490`](../../evidence/decompiled/k.java#L490) : the loader for `a` and `d` (Observed)
- [`k.java:501`](../../evidence/decompiled/k.java#L501) : the 139-segment loop; [`k.java:509`](../../evidence/decompiled/k.java#L509) : the 9 short tables (Observed)
- [`k.java:521`](../../evidence/decompiled/k.java#L521) : file `d` fills segments 139-141 (Observed)
- `../../evidence/tools/tables.py` asserts that parsing ends at the last byte (Observed)
- [`g.java:4826`](../../evidence/decompiled/g.java#L4826) : unit cost shown from `tables[5]`; [`g.java:4900`](../../evidence/decompiled/g.java#L4900) : building cost from `tables[6]`; [`g.java:4984`](../../evidence/decompiled/g.java#L4984) : research cost from `tables[7]` (Observed)
- [`p.java:635`](../../evidence/decompiled/p.java#L635) : segments 27..31 are copied into the 5x19 unit stat table (Observed)

## Still unknown
- Most of the 139 segments have no confirmed meaning in this note. The
  gameplay and animation notes identify the ones they use.
- What the three segments from file `d` are for (they are text-like buffers
  that downloaded maps overwrite, by [`g.java:1054`](../../evidence/decompiled/g.java#L1054)).

**Next:** [Frame tables `d0` and tilesets `ml`](04-d0-and-ml.md)
