# Source to look things up in

Every note in `learnings/` cites this folder. Three parts:

| Folder | What it holds | Made by |
|---|---|---|
| [`decompiled/`](decompiled/) | The game's 18 classes as Java, 19,538 lines. Names are obfuscated (`a`, `g`, `p`...). | The JADX library (bundled in jadx-headless-mcp 0.7.1), via [`tools/Decompile.java`](tools/Decompile.java) |
| [`data/`](data/) | The binary data files decoded to JSON. | The Python scripts in `tools/` |
| [`tools/`](tools/) | Small scripts that rebuild everything here from the JAR. | Written during the analysis |

## How citations work

A note says, for example, [`p.java:2140`](decompiled/p.java#L2140). Click it
and you land on that line. Data is cited as `data/a.json` `seg[42]` (segment
42 of the balance file) or `tables[5]`.

## What is in `data/`

| File | Source file in the JAR | Content |
|---|---|---|
| `a.json` | `a` | `seg`: 139 byte arrays (values above 127 are negative, subtract 256). `tables`: 9 arrays of 16-bit numbers (above 32767 are negative). Unit stats, costs, lookup tables. |
| `d0.json` | `d0` | `bytes`: 26 arrays, `shorts`: 18 arrays. Sprite frame tables. |
| `sn8p.json` | `sn8p` | List of `[key, value]`: 24 settings, then 403 text strings `T0_n`..`T3_n`. |
| `missions.json` | `mi0`..`mi6`, `m0`..`m5` | Per mission: map size, tileset, starting buildings. |

## Rebuild it yourself

Needs Python 3 with Pillow, a JDK 17 or newer, and the JADX engine JAR
(`jadx-headless-mcp-0.7.1-all.jar`, SHA-256
`6e5eacf500b64292bfb73c49797c1958f6ee44646e43e868039ae7feb573ff75`).

```bash
JAR=target/92aace22-artofwea_S8000.jar
T=target/learnings/source/tools
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
```

Nothing here runs the game. The scripts only read bytes.

## Caveats

- The decompiled Java is a reconstruction. JADX flagged 197 spots where it
  was unsure (search for `JADX WARN`), 165 of them in `g.java`.
- Do not edit `decompiled/`. Line numbers are what the notes link to.
- The code and art belong to HeroCraft and Gear Games. They are here for
  study alongside the JAR that was already in this repo.
