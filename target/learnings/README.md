# Learnings: `92aace22-artofwea_S8000.jar`

Notes from taking apart one file: a 2010 Java ME phone game, **Art Of War 2 -
Global Confederation** (HeroCraft / Gear Games), a real-time strategy game.

Everything here comes from **static analysis**: reading the decompiled code
and decoding the data files. The game was never run.

## How to read these notes

- Every note is short and answers **one question**, stated in its title.
- Every note has the same shape: *In one line* -> *The short answer* -> *How
  it works* -> *How we know* -> *Still unknown* -> *Next*.
- Follow the **Next** link at the bottom to walk a folder in order.
- **How we know** links straight to the line of decompiled code or the data
  table behind each claim. Claims are tagged:
  - **Observed**: a code line or data value shows it.
  - **Inferred**: reasoned from observed facts.
  - **Unknown**: not established.

## Where to start

| If you want to know... | Start here |
|---|---|
| What this file is | [01-identity/01-what-is-this-file](01-identity/01-what-is-this-file.md) |
| How the game plays, in depth | [gameplay/README](gameplay/README.md) |
| How sprites become animation | [animations/README](animations/README.md) |
| The numbers: units, buildings, research | [06-reference/01-units](06-reference/01-units.md) |
| How to find something in the code | [02-code/01-class-map](02-code/01-class-map.md) |
| The raw material | [source/README](source/README.md) |

## Folders

| Folder | Question it answers | Notes |
|---|---|---|
| [`01-identity/`](01-identity/) | What is this file, who made it, when? | what it is, packaging and dates, glossary |
| [`02-code/`](02-code/) | How is the program organised? | class map, boot sequence, reading obfuscated code |
| [`03-assets/`](03-assets/) | What is shipped besides code? | file inventory, text and settings, fonts and sound, sprite sheets |
| [`04-data-formats/`](04-data-formats/) | How is each data file laid out, byte by byte? | `sn8p`, `i0`, `a`/`d`, `d0`/`ml`, terrain, missions |
| [`05-online-and-payments/`](05-online-and-payments/) | What does it do beyond the game? | SMS, online account, updates and adverts, integrity checks |
| [`06-reference/`](06-reference/) | Lookup tables | units, buildings, research, missions, story |
| [`gameplay/`](gameplay/) | **Deep dive:** the rules of play as the code implements them | economy, energy, production, movement, damage, weapons, vision, research, tech tree, ranks, AI, mission scripts |
| [`animations/`](animations/) | **Deep dive:** how pictures are stored, cut and animated | sheets, frame tables, units, buildings and effects, timing |
| [`source/`](source/) | The evidence | decompiled Java, decoded data as JSON, the scripts that made them |

## Five things worth knowing first

1. It is a **MIDlet**, not an Android app. 18 obfuscated classes, 52 files.
2. Two classes are the game: `g` (interface) and `p` (simulation).
3. Nearly every tuning number sits in one small file, `a`, decoded to
   [`source/data/a.json`](source/data/a.json).
4. All text and all build settings sit in one file, `sn8p`, decoded to
   [`source/data/sn8p.json`](source/data/sn8p.json).
5. The SMS, account, advert and update features exist in code but are
   switched off or unconfigured in this copy.

## How this was made

- Inventory and file identity: REA (`rea-agents` 6.10.1).
- Decompilation: the JADX library, driven by
  [`source/tools/Decompile.java`](source/tools/Decompile.java). REA's Android
  path refused the file because it is not an APK.
- Data files: small Python parsers in [`source/tools/`](source/tools/), each
  written by reading the game's own loader.
- Links are checked by [`source/tools/check_links.py`](source/tools/check_links.py).

## Limits

- The decompiled code is a reconstruction and is wrong in places.
- Numbers in the notes are the stored values. Several are scaled at run
  time; each note says where.
- The code, art and text belong to HeroCraft and Gear Games.
