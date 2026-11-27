# How are text and sound stored?

> **In one line:** Text is drawn from four hand-made bitmap fonts (a PNG
> strip plus a width list each); sound is a single MIDI file.

## The short answer
- Each font is two files: `fN_0p` is a PNG strip with all glyphs side by
  side, `fN_0` lists the characters and their pixel widths.
- Four fonts: a full one, a symbols-and-digits one, and two tiny digit-only
  fonts for counters.
- The glyph widths add up exactly to the strip width, which proves the
  format.
- One music track, `s0m`. The sound code can play five formats but only the
  MIDI is shipped.

## How it works

**Font metric file `fN_0`**

```
byte   glyph count
byte   (font parameter; 1 in all four files)
repeat count times:
    UTF string   the character (2-byte length + bytes)
    byte         its width in pixels
```

Glyph `i` sits in the strip at x = sum of the widths before it.

| Font | Glyphs | Strip size | Characters |
|---|---|---|---|
| `f0` | 91 | 614x12 | Letters A-Z a-z, digits, punctuation, (c), (R) |
| `f1` | 36 | 218x12 | Digits and punctuation only |
| `f2` | 10 | 39x5 | Digits 0-9 |
| `f3` | 10 | 39x5 | Digits 0-9 (second colour) |

The loader asks for two pages per font (`_0` and `_1`). Only page 0 exists
here; a missing page is skipped. That second page is where a non-Latin
alphabet would go in other language builds (inferred).

If the setting `DEFFNT` is on, the game skips bitmap fonts and uses the
phone's own font with fixed colours.

**Sound**

The player is given a base name and tries suffixes in order until one loads:

| Suffix | Format |
|---|---|
| `m` | MIDI |
| `f` | MMF (Yamaha SMAF, common on Samsung phones) |
| `3` | MP3 |
| `a` | AMR |
| `w` | WAV |

Only `s0` + `m` = `s0m` is in the JAR: one MIDI tune, format 0, one track.
There are no sound effects in this build.

## How we know
- [`i.java:53`](../../evidence/decompiled/i.java#L53) : the font loader, two pages, strip + metrics (Observed)
- [`i.java:102`](../../evidence/decompiled/i.java#L102) : the draw routine; with `DEFFNT` it calls the system `drawString` (Observed)
- [`k.java:971`](../../evidence/decompiled/k.java#L971) : four fonts `/f0`..`/f3` are loaded (Observed)
- Width sums 614, 218, 39, 39 equal the PNG widths (Observed, by parsing the files)
- [`c.java:133`](../../evidence/decompiled/c.java#L133) : the suffix and MIME type lists (Observed)
- `file` identifies `s0m` as "Standard MIDI data (format 0) using 1 track" (Observed)

## Still unknown
- What the second header byte of a font file controls.
- Whether the code ever asks for sounds other than `s0` (not traced).

**Next:** [The sprite sheets at a glance](04-sprite-sheets-at-a-glance.md)
