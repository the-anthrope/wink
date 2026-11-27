# What files are in the JAR, and what is each for?

> **In one line:** 52 files: 18 classes and 34 resources with cryptic
> one- or two-letter names, each loaded by one known routine.

## The short answer
- Resource names are short to save bytes; the name says nothing. The loader
  that opens each file tells you what it is.
- Biggest files: `i0` (sprites, 271 KB), `g.class` (120 KB), `d0` (frame
  tables, 106 KB).
- Six files are plain PNG images without the `.png` suffix.
- Five files the code asks for are absent: `prov.png`, `prov2.png`, `wd`,
  `rsu` and `GMG/GMG_settings.txt`. The game tolerates all of them.

## How it works

| File(s) | Bytes | What it is | Loaded at | Notes |
|---|---|---|---|---|
| `*.class` (18) | 292,011 | The program | | [class map](../02-code/01-class-map.md) |
| `META-INF/MANIFEST.MF` | 435 | App descriptor | by the phone | [identity](../01-identity/01-what-is-this-file.md) |
| `sn8p` | 31,352 | Settings + all text | [`a.java:267`](../source/decompiled/a.java#L267) | [format](../04-data-formats/01-sn8p-text-file.md) |
| `i0` | 271,333 | 43 sprite sheets (PNG inside) | [`k.java:991`](../source/decompiled/k.java#L991) | [format](../04-data-formats/02-i0-sprite-container.md) |
| `d0` | 106,423 | Sprite frame tables | [`k.java:1069`](../source/decompiled/k.java#L1069) | [format](../04-data-formats/04-d0-and-ml.md) |
| `a` | 5,501 | Balance data: stats, costs, lookup tables | [`k.java:498`](../source/decompiled/k.java#L498) | [format](../04-data-formats/03-a-balance-tables.md) |
| `d` | 164 | 3 small extra segments for the balance blob | [`k.java:521`](../source/decompiled/k.java#L521) | same note |
| `ml` | 1,489 | 2 tileset records | [`k.java:1114`](../source/decompiled/k.java#L1114) | [format](../04-data-formats/04-d0-and-ml.md) |
| `m0`..`m5` | 4.9-14 KB | 6 terrain maps | [`g.java:941`](../source/decompiled/g.java#L941) | [format](../04-data-formats/05-terrain-m-files.md) |
| `mi0`..`mi6` | 309-690 | 7 mission scripts | [`g.java:929`](../source/decompiled/g.java#L929) | [format](../04-data-formats/06-mission-mi-files.md) |
| `dmt` | 39 | Small table read by the map-list code | [`g.java:6262`](../source/decompiled/g.java#L6262) | Not decoded |
| `f0_0`..`f3_0` | 42-368 | Font glyph lists and widths | [`i.java:66`](../source/decompiled/i.java#L66) | [fonts](03-fonts-and-sound.md) |
| `f0_0p`..`f3_0p` | 140-628 | Font glyph strips (PNG) | [`i.java:64`](../source/decompiled/i.java#L64) | same |
| `s0m` | 12,285 | Music, standard MIDI | [`c.java:144`](../source/decompiled/c.java#L144) | same |
| `l2` | 44,601 | Splash screen, PNG 240x320 | [`k.java:669`](../source/decompiled/k.java#L669) | |
| `hc` | 1,853 | HeroCraft logo, PNG 170x142 | [`k.java:420`](../source/decompiled/k.java#L420) | |
| `gg` | 2,033 | Gear Games logo, PNG 105x70 | [`k.java:420`](../source/decompiled/k.java#L420) | |
| `icon.png` | 434 | App icon, 32x32 | by the phone | |

Related names that are easy to mix up:
- `d` is a 164-byte table file; `d0` is the big frame-table file; `d.class`
  is the advert code. Three unrelated things.
- `m0`..`m5` are terrain; `mi0`..`mi6` are missions; `ml` is the tileset
  list; `m.class` is the XML parser.
- `a` is balance data; `a.class` is the settings helper.

## How we know
- `unzip -l` on the JAR for names and sizes (Observed)
- Each "Loaded at" link is the line that opens the file (Observed)
- Missing files: `prov.png`, `prov2.png` at [`k.java:420`](../source/decompiled/k.java#L420), `wd` at [`k.java:603`](../source/decompiled/k.java#L603), `rsu` at [`f.java:765`](../source/decompiled/f.java#L765), `GMG_settings.txt` at [`a.java:173`](../source/decompiled/a.java#L173); none are in the zip listing (Observed)

## Still unknown
- What `dmt` holds exactly.
- What picture `wd` was meant to be (a wait/"working" image, by its use).

**Next:** [The text and settings file](02-text-and-settings.md)
