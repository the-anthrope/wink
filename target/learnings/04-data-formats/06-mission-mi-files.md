# How is a mission stored?

> **In one line:** A mission file names its terrain map, lists what stands
> where at the start, then carries the script sections that drive the enemy
> and the story.

## The short answer
- First byte: which terrain file to load (`m{n}`). A negative value would
  mean "terrain follows inline".
- Then a list of 4-byte records: every starting building and placed object.
- Then several counted sections of rectangles and records: the script.
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
| 15 and up | A placed object, not a building. It is written into the map grid as code `1001 + 100 * ((type-15)/10) + 20 * ((type-15)%5)`: the first term picks the owning side, the second a variant. |

For buildings, side = `type / 8`. The `flag` byte ties an entity to one of
three script groups used later in the file.

**Part 2: script sections** (layout known, meaning in the gameplay notes)

| Order | Shape | Count stored at |
|---|---|---|
| 1 | 2 sides x 3 groups of rectangles (x, y, w, h) | first byte of each group |
| 2 | 3 groups of 4-byte records | first byte |
| 3 | 3 more groups of 4-byte records | first byte |
| 4 | 3 groups: a length, a list, then length+1 more bytes | |
| 5 | 3 groups of 2-byte records | first byte |
| 6 | 3 groups of 4-byte records | first byte |
| 7 | n records of 6 bytes | one count byte |
| 8 | Downloaded maps only: title and briefing text | two u16 lengths |

What each section means, and a parser that reads every byte, are in
[gameplay/12-mission-scripting](../gameplay/12-mission-scripting.md).

| File | Bytes | Terrain | Player buildings | Rebel buildings | Placed objects (type 15+) |
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
- What the placed objects of type 15 and up are in game terms. The story
  talks about minefields, so mines are the likely answer; the gameplay
  notes settle it.

**Next:** [Can the game send text messages?](../05-online-and-payments/01-sms.md)
