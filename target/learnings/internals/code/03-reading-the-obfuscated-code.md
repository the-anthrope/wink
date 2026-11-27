# How do you read code where everything is called `a`?

> **In one line:** Ignore the names, follow the data: a handful of access
> patterns repeat everywhere, and once you know them the code opens up.

## The short answer
- Names carry no meaning. Numbers and string keys do.
- Four patterns cover most of the game logic: the balance blob, the unit
  field blocks, the string tables, and strings hidden as byte arrays.
- JADX leaves comments where it struggled. Treat those spots with care.
- When a number matters, check it against the data files and the help text.

## How it works

**Pattern 1: the balance blob.** All tuning numbers live in one byte array
with an offset table. The same data has different field names per class:

| Meaning | In `p.java` | In `g.java` | In `data/a.json` |
|---|---|---|---|
| byte `i` of segment `N` | `f507P[f508d[N] + i]` | `f181v[f182d[N] + i]` | `seg[N][i]` |
| short `i` of table `N` | `f509e[f510f[N] + i]` | `f183e[f184f[N] + i]` | `tables[N][i]` |

So `this.f507P[this.f508d[42] + type]` reads "max HP of this unit type".

**Pattern 2: unit fields in blocks of 101.** There is no Unit class. One
array, `p.f515R` (the same array as `g.f189x`), holds every field of every
unit side by side: `f515R[FIELD + unitIndex]`, where `FIELD` is a multiple of
101. For example `f515R[1616 + u]` is unit `u`'s HP and `f515R[2323 + u]` is
its type. Unit indexes 1..50 are one side, 51..100 the other.

**Pattern 3: string tables.** `o.f384a[t][n]` is text `T{t}_{n}` in
`data/sn8p.json`. `o.b(x, y, font, n)` draws string `n` of table 0. If you
see `b + 49`, look up `T0_49`: the first unit name. This is how menu slots
were tied to unit names.

**Pattern 4: hidden strings.** Sensitive strings are stored as byte arrays,
for example `{104, 116, 116, 112, ...}` is `http...`. Decode with
`bytes(...).decode()`. They hold URLs and manifest key names.

**Decompiler artefacts to expect**

| You see | What it means |
|---|---|
| `/* renamed from: a */ f329a` | JADX added a suffix because two things shared a name. Harmless. |
| `/* JADX WARN: ... */` | JADX could not rebuild this part cleanly. 197 places, 165 in `g.java`. |
| `Code decompiled incorrectly` | The method body may be wrong or partial. |
| `(a << 8) + b` where the data says `(b << 8) + a` | Operand order can flip. File `a` is the proven case: the code looks big-endian, only little-endian fits the file exactly. |
| Unreachable code after `return` | Either an obfuscator trick or a decompiler slip. Do not build conclusions on it. |

## How we know
- [`p.java:505`](../../evidence/decompiled/p.java#L505) to [`p.java:508`](../../evidence/decompiled/p.java#L508) and [`g.java:789`](../../evidence/decompiled/g.java#L789) to [`g.java:792`](../../evidence/decompiled/g.java#L792) : both classes alias the arrays that `k` loaded (Observed)
- [`p.java:3240`](../../evidence/decompiled/p.java#L3240) : a new unit's HP field is set from segment 42 (Observed)
- [`g.java:4808`](../../evidence/decompiled/g.java#L4808) : the unit panel draws string `b + 49` (Observed)
- [`a.java:65`](../../evidence/decompiled/a.java#L65) : the update URL as a byte array (Observed)
- [`k.java:501`](../../evidence/decompiled/k.java#L501) : the length read that looks big-endian; `source/tools/tables.py`
  proves little-endian by consuming exactly 5,501 bytes (Observed)

## Still unknown
- Meaning of many unit field offsets. The gameplay notes name the ones they
  rely on.

**Next:** [What files are in the JAR?](../assets/01-file-inventory.md)
