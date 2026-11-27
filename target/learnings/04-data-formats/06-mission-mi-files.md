# How is a mission stored?

> **In one line:** A mission file names its terrain map, lists what stands
> where at the start, then carries the script sections that drive the enemy
> and the story.

## The short answer
- First byte: which terrain file to load (`m{n}`). A negative value would
  mean "terrain follows inline".
- Then a list of 4-byte records: every starting building and wall tile.
- Then zones, routes and a list of 6-byte script commands.
- Missions 0-6 are in the JAR. Higher numbers are downloaded maps kept in
  phone storage and carry extra text.

## How it works

**Part 1: start state** (decoded here)

```
s8     terrain map id            -> load "m{id}" first
u8     entity count
  per entity:  u8 type, u8 x, u8 y, u8 flag
```

| `type` | Meaning |
|---|---|
| 0..7 | Confederation building (0 Command center ... 7 Rocket launcher) |
| 8..14 | Rebel building (8 Headquarters ... 14 Tower) |
| 15, 25 | A **wall tile** of side 0 or side 1. It is written into the map grid as `1001 + 100 * side`, plus a damage offset. No mission file places a unit; units come from script commands. |

For buildings, side = `type / 8`. The `flag` byte is the enemy group (base)
the building belongs to.

**Part 2: zones, routes and the script**

| Order | Section | Shape |
|---|---|---|
| 1 | Build zones: where the enemy may place buildings | 2 classes x 3 groups of rectangles (x, y, w, h), count first |
| 2 | Mine fields | 3 groups of rectangles |
| 3 | Wall lines | 3 groups of rectangles |
| 4 | Attack routes | per group: route count, byte count, x,y pairs, count+1 offsets |
| 5 | Rally points | 3 groups of (x, y) |
| 6 | Alarm areas | 3 groups of 4 bytes |
| 7 | Script | count, then 6 bytes per command: opcode, p1, p2, value, delay, group |
| 8 | Downloaded maps only: title and briefing text | two u16 lengths, then bytes |

A "group" is one enemy base, 0..2. What each section means, and a parser that reads every byte, are in
[gameplay/12-mission-scripting](../gameplay/12-mission-scripting.md).

| File | Bytes | Terrain | Player buildings | Rebel buildings | Wall tiles |
|---|---|---|---|---|---|
| `mi0` | 392 | `m0` | 5 | 0 | 0 |
| `mi1` | 363 | `m1` | 2 | 22 | 0 |
| `mi2` | 456 | `m2` | 1 | 14 | 23 |
| `mi3` | 309 | `m3` | 0 | 24 | 0 |
| `mi4` | 690 | `m3` | 3 | 0 | 0 |
| `mi5` | 643 | `m4` | 4 | 47 | 11 |
| `mi6` | 683 | `m5` | 4 | 45 | 0 |

## How we know
- [`g.java:918`](../source/decompiled/g.java#L918) : the mission loader (Observed)
- [`g.java:929`](../source/decompiled/g.java#L929) : missions 0-6 come from `mi{n}`; others from storage (Observed)
- [`g.java:937`](../source/decompiled/g.java#L937) to [`g.java:944`](../source/decompiled/g.java#L944) : first byte selects `m{n}`, then the `mi` file is re-read (Observed)
- [`g.java:952`](../source/decompiled/g.java#L952) to [`g.java:962`](../source/decompiled/g.java#L962) : entity records and the type split at 15 (Observed)
- [`g.java:975`](../source/decompiled/g.java#L975) to [`g.java:1050`](../source/decompiled/g.java#L1050) : the script sections in the order shown (Observed)
- [`g.java:1054`](../source/decompiled/g.java#L1054) : extra text for mission numbers above 6 (Observed)
- `../source/tools/maps.py` : the counts in the last table (Observed)

## Still unknown
- Nothing significant. `../source/tools/missions_full.py` reads all seven
  files to their last byte.

**Next:** [Can the game send text messages?](../05-online-and-payments/01-sms.md)
