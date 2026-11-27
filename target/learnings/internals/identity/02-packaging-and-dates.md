# How and when was this copy packaged?

> **In one line:** The code was built in May 2011, then re-wrapped with a
> distributor-specific settings file in November 2012.

## The short answer
- Two timestamps live in the zip: **2011-05-17 13:25** and
  **2012-11-12 05:54**.
- The older group is the game itself: all 18 classes, sprites, maps, tables.
- The newer group is the "skin" a distributor would change: manifest,
  settings/text file, logos, fonts, icon, music.
- The settings name the distributor by number, not by name.
- Conclusion (inferred): HeroCraft built one game and stamped out one JAR per
  operator or store by swapping a handful of files.

## How it works

| Stamped 2011-05-17 (37 files) | Stamped 2012-11-12 (15 files) |
|---|---|
| `*.class` (18) | `META-INF/MANIFEST.MF` |
| `a`, `d`, `d0`, `dmt`, `ml` (tables) | `sn8p` (settings and all text) |
| `i0` (sprites) | `l2` (splash), `hc`, `gg` (logos), `icon.png` |
| `m0`..`m5`, `mi0`..`mi6` (maps, missions) | `f0_0`..`f3_0` and `f0_0p`..`f3_0p` (fonts) |
| | `s0m` (music) |

The distributor identity sits in `sn8p`:

| Setting | Value | Reading |
|---|---|---|
| `GAME_ID` | 180 | HeroCraft's id for this game. It also appears in the "more games" link `http://m.herocraft.com/f/s/180`. |
| `PROV_ID` | 1102 | Provider (distributor) id. Shown in brackets after the version on the About screen. |
| `PROD_ID` | 108952 | Product id |
| `PORT_ID` | 13277 | Port id: the handset build |
| `LANG_ID` | en | Language |

## How we know
- `unzip -l` on the JAR: the two timestamp groups listed above (Observed)
- [`a.java:161`](../../evidence/decompiled/a.java#L161) to [`a.java:165`](../../evidence/decompiled/a.java#L165) : the five ids are read from the settings table (Observed)
- [`a.java:229`](../../evidence/decompiled/a.java#L229) : version string becomes `1.12.0 (1102)` (Observed)
- The "one build, many skins" reading (Inferred from the two date groups and
  the id fields)

## Still unknown
- Who provider 1102 is.
- Whether this copy was changed by anyone after HeroCraft packaged it. Some
  integrity checks in the code look inactive; see
  [integrity checks](../online-and-payments/04-integrity-checks.md).

**Next:** [Words you will meet](03-glossary.md)
