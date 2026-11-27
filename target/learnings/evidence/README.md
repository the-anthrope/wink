# Evidence: the proof behind every note

Every note in `learnings/` cites this folder. Use it to check a claim, to
look up how the original did something, or to regenerate any table.

| Folder | What it holds |
|---|---|
| [`decompiled/`](decompiled/) | The game's 18 classes as Java, 19,538 lines, names obfuscated (`a`, `g`, `p`...). Output of the JADX library, bundled in jadx-headless-mcp 0.7.1. |
| [`data/`](data/) | The game's binary data files decoded to JSON. |
| [`tools/`](tools/) | The scripts that produced the data, the tables and the pictures. |

## How citations work

A note says, for example, [`p.java:2140`](decompiled/p.java#L2140). Click
and you land on that line. Data is cited as `data/a.json` `seg[42]`
(segment 42 of the balance file) or `tables[5]`.

Where to look first in the code:

| Looking for | File | Guide |
|---|---|---|
| A rule of play | [`decompiled/p.java`](decompiled/p.java) | [gameplay notes](../gameplay/README.md) |
| Menus, input, drawing, mission loading | [`decompiled/g.java`](decompiled/g.java) | [class map](../internals/code/01-class-map.md) |
| The loop and file loaders | [`decompiled/k.java`](decompiled/k.java) | [boot sequence](../internals/code/02-boot-sequence.md) |
| How to read the naming | | [reading obfuscated code](../internals/code/03-reading-the-obfuscated-code.md) |

## `data/`

| File | From | Content |
|---|---|---|
| `a.json` | `a` | `seg`: 139 byte arrays (values above 127 are negative, subtract 256). `tables`: 9 arrays of 16-bit numbers. Unit stats, weapons, costs, lookup tables. |
| `d0.json` | `d0` | `bytes`: 26 arrays, `shorts`: 18 arrays. The sprite frame tree. |
| `sn8p.json` | `sn8p` | List of `[key, value]`: 24 settings, then 403 text strings `T0_n`..`T3_n`. |
| `missions.json` | `mi*`, `m*` | Per mission: map size, tileset, starting buildings, wall tile count. |

## `tools/`

| Script | What it does | Used by |
|---|---|---|
| `Decompile.java` | Drives JADX over the JAR | everything |
| `text_and_settings.py` | `sn8p` -> `sn8p.json` | internals, reference |
| `tables.py` | `a`, `d0` -> JSON; prints tilesets | internals |
| `sprites_extract.py` | `i0` -> 43 PNG sheets (+ masks) | animations |
| `sprites_contact_sheet.py` | Merges masks; makes contact sheets | animations, internals |
| `maps.py` | Terrain + start state; schematic map images; stat tables | reference |
| `missions_full.py` | Decodes every mission file to its last byte | gameplay 11-13 |
| `economy_tables.py` | Income ladder, build and training times | gameplay 1-3 |
| `weapons_table.py` | Weapons, loadouts, damage matrix | gameplay 4-7 |
| `tech_masks.py` | Per-mission unlock masks | gameplay 8-9 |
| `balance_sheet.py` | Cost efficiency and duel tables | build 9 |
| `frames.py` | Rebuilds the frame tree; renders any frame, pose or object | animations |
| `check_links.py` | Verifies every link in these notes | all |

## Rebuild it yourself

Needs Python 3 with Pillow, a JDK 17 or newer, and the JADX engine JAR
(`jadx-headless-mcp-0.7.1-all.jar`, SHA-256
`6e5eacf500b64292bfb73c49797c1958f6ee44646e43e868039ae7feb573ff75`).

```bash
JAR=target/92aace22-artofwea_S8000.jar
T=target/learnings/evidence/tools
mkdir -p work/x work/out && (cd work/x && unzip -q ../../$JAR)

# 1. decompile the classes -> work/src/sources/defpackage/*.java
javac -cp jadx-headless-mcp-0.7.1-all.jar -d work $T/Decompile.java
java  -cp jadx-headless-mcp-0.7.1-all.jar:work Decompile $JAR work/src

# 2. decode the data files
python3 -I $T/text_and_settings.py work/x/sn8p work/out/sn8p.json
python3 -I $T/tables.py            work/x work/out
python3 -I $T/sprites_extract.py   work/x/i0 work/out/i0
python3 -I $T/sprites_contact_sheet.py work/out/i0 work/out
python3 -I $T/maps.py              work/x work/out

# 3. print the tables the notes quote
python3 -I $T/weapons_table.py work/out/a.json
python3 -I $T/balance_sheet.py work/out/a.json
python3 -I $T/missions_full.py work/x work/out
```

Nothing here runs the game. The scripts only read bytes.

## Caveats

- The decompiled Java is a reconstruction. JADX flagged 197 uncertain spots
  (search for `JADX WARN`), 165 of them in `g.java`. A few conditions come
  out inverted; the notes say where bytecode was read to settle it.
- Do not edit `decompiled/`. Line numbers are what the notes link to.
- The code, art and text belong to HeroCraft and Gear Games. They are kept
  here for study next to the JAR that was already in this repo.
