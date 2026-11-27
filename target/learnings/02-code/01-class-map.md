# Which class does what?

> **In one line:** Two big classes hold the game (`g` = everything you see
> and touch, `p` = the battle itself); the other sixteen are small helpers.

## The short answer
- 18 classes, 19,538 decompiled lines. `g` and `p` are 69 percent of it.
- All names are obfuscated to single letters. The roles below were worked out
  from what each class imports and does.
- The game is one screen object (`k`) running one loop on its own thread.
- Online, SMS and ad features are cleanly separated in `f`, `h`, `d`.

## How it works

| Class | Lines | Role | Tell-tale sign |
|---|---|---|---|
| [`aow2`](../source/decompiled/aow2.java) | 58 | Entry point. Start, pause, exit. | `extends MIDlet` |
| [`k`](../source/decompiled/k.java) | 1532 | The screen, the game loop, all file loaders. | `extends q`, `implements Runnable` |
| [`q`](../source/decompiled/q.java) | 39 | Tiny base screen: repaint and key forwarding. | `extends Canvas` |
| [`g`](../source/decompiled/g.java) | 9138 | Menus, HUD, touch input, build panels, mission loading, saves, drawing. | Uses every string table |
| [`p`](../source/decompiled/p.java) | 4279 | The simulation: units, buildings, combat, enemy AI, research. | Owns the unit arrays |
| [`o`](../source/decompiled/o.java) | 300 | Text: string tables `f384a[4][]`, fonts `f385a`, dialogue boxes. | `String[][] f384a` |
| [`i`](../source/decompiled/i.java) | 179 | Bitmap font: loads glyph strips, measures and draws text. | `Image.createImage(... "p")` |
| [`c`](../source/decompiled/c.java) | 342 | Sound player. Tries MIDI, MMF, MP3, AMR, WAV by file suffix. | `PlayerListener` |
| [`a`](../source/decompiled/a.java) | 786 | Settings table, text loading, word wrap, platform helpers. | `Hashtable f9a` |
| [`n`](../source/decompiled/n.java) | 6 | Five colour constants. | |
| [`e`](../source/decompiled/e.java) | 67 | CRC-32 checksum, used to sign web requests. | Polynomial `0xEDB88320` |
| [`b`](../source/decompiled/b.java) | 176 | Base64 encode and decode. | "Illegal character in Base64" |
| [`h`](../source/decompiled/h.java) | 46 | Sends one text message. | `sms://` |
| [`f`](../source/decompiled/f.java) | 1176 | HeroCraft online account: login, register, achievements, map shop. | `HttpConnection`, `Form` |
| [`d`](../source/decompiled/d.java) | 673 | Slideshow adverts fetched from HeroCraft, cached in storage. | `get_slideshow` |
| [`m`](../source/decompiled/m.java) | 709 | XML pull parser (the open-source kXML design). | `START_TAG`, `END_TAG` |
| [`j`](../source/decompiled/j.java) | 9 | The parser's interface and event names. | |
| [`l`](../source/decompiled/l.java) | 23 | The parser's exception type. | "(position:" |

How they hang together:

```
aow2 (MIDlet)
  └─ k (Canvas + loop thread)
       ├─ g (UI, input, drawing)  ←→  p (simulation)
       ├─ o + i (text and fonts)
       ├─ c (sound)
       └─ a (settings, helpers)   ─→  f (account), h (SMS), d (ads) ─→ m/j/l (XML), b, e
```

## How we know
- [`aow2.java:16`](../source/decompiled/aow2.java#L16) : `startApp` creates `k` and shows it (Observed)
- [`k.java:724`](../source/decompiled/k.java#L724) to [`k.java:728`](../source/decompiled/k.java#L728) : `k` creates `g`, `p`, `o` in that order (Observed)
- [`e.java:59`](../source/decompiled/e.java#L59) : the CRC-32 table loop with constant -306674912 (Observed)
- [`h.java:12`](../source/decompiled/h.java#L12) : opens `sms://` plus a number (Observed)
- [`c.java:133`](../source/decompiled/c.java#L133) : the list of audio types and suffixes (Observed)
- `m` being kXML (Inferred from the event names in [`j.java:5`](../source/decompiled/j.java#L5) and the error strings)

## Still unknown
- `f` extends `Exception`, an odd choice. Probably an obfuscator merge of two
  classes; not investigated.

**Next:** [What happens when the game starts?](02-boot-sequence.md)
