# Where should a game keep its numbers?

> **In one line:** Outside the code, in plain tables indexed by type id, so
> that balancing, new content and new languages never need a programmer.

## The idea

Imagine changing a tank's price. If the number is typed into the code, you
edit code, rebuild and retest. If it sits in a table, you change one cell.
The original keeps almost every number and every word outside the code, and
that is the main reason one team could ship it on hundreds of handsets and
in many languages.

## What the original does

| File | Holds | Shape |
|---|---|---|
| `a` (5.5 KB) | All balance numbers | 139 byte arrays + 9 arrays of 16-bit values |
| `sn8p` (31 KB) | Build settings + every text string | `KEY: value` records |
| `d0` (106 KB) | How sprite sheets are cut into frames | 44 number arrays |
| `mi0`..`mi6` | Mission start state and script | byte records |
| `m0`..`m5` | Terrain | run-length rows |

The balance file is "columns by type id". One array per property, one entry
per unit type:

```
cost[type]     = [10, 10, 20, 20, 40, 30, 40, 100, ...]
max_hp[type]   = [30, 30, 40, 40, 50, 70, 60, 120, ...]
armour[type]   = [ 0,  0,  0,  1,  0,  0,  1,   4, ...]
```

The code never says "tank". It says `max_hp[type]`. A new unit is a new
column entry in each table plus pictures.

Three patterns worth copying:

| Pattern | In the original | Why it helps |
|---|---|---|
| **Indirection tables** | `menu_slot -> type id` (`seg[92]`), `unit type -> weapon ids` (`seg[34]`) | Reorder menus or share a weapon between units without touching stats |
| **Alternate-form links** | `seg[52]`: type 13 <-> 16 (a launcher's march and siege forms) | A "mode switch" is just swapping the type id; all stats follow |
| **Unlock masks** | 6 bytes per mission in `seg[127]`/`seg[128]` | The campaign's pacing (what you may build when) is data, not code |

Text works the same way. Code asks for string number 49 of table 0, never
for "Assault". Placeholders such as `[RANK]` are filled at run time. A new
language is a new text file.

## Recipe

1. Give every kind of thing a small integer id.
2. Make one table per property, indexed by id. Start with CSV or JSON.
3. Load tables at start; never write a balance number in code.
4. Put text in a string table; refer to strings by key.
5. Describe what is unlocked per level as a list or bit mask in data.
6. Build a tiny tool that validates tables (same length, no gaps) and one
   that prints a human-readable balance sheet.

## Knobs

Everything. That is the point. The tables this game exposes: price, HP,
armour, speed, sight, range, weapon, reload, projectile speed, splash,
build menu order, research price, rank caps, per-mission unlocks.

## Pitfalls seen in the original

- **No names in the file.** Segment 42 is HP only because the code uses it
  that way. It took a decompiler to find out. Name your columns.
- **Some rules escaped the tables.** Build time is `3 ticks x HP` and
  training time `2 ticks x HP`, hard-coded. Price and toughness therefore
  cannot be tuned apart from speed of production.
- **Text drifted from data.** The help says a generator upgrade gives +30%;
  the table change is 6 -> 8, which is +33%. Generate help text from the
  numbers where you can.
- **Byte order differs between files** (`a` little-endian, `d0` big-endian).
  Pick one format and one loader.

## Evidence
- File layouts: [a and d](../internals/data-formats/03-a-balance-tables.md), [sn8p](../internals/data-formats/01-sn8p-text-file.md), [d0 and ml](../internals/data-formats/04-d0-and-ml.md)
- [`p.java:3240`](../evidence/decompiled/p.java#L3240) : HP read by type id, the access pattern used everywhere (Observed)
- [`g.java:4769`](../evidence/decompiled/g.java#L4769) : menu slot -> type id indirection (Observed)
- `../evidence/data/a.json` `seg[52]` : the alternate-form links (Observed)
- Unlock masks: [gameplay/09-tech-availability](../gameplay/09-tech-availability.md)
- Hard-coded times and the 30% vs 33% mismatch: [gameplay/03-building-and-training](../gameplay/03-building-and-training.md), [gameplay/02-energy](../gameplay/02-energy.md)
- The "hundreds of handsets" motive (Inferred from the per-distributor settings, see [packaging](../internals/identity/02-packaging-and-dates.md))

**Next:** [An economy recipe](05-economy-recipe.md)
