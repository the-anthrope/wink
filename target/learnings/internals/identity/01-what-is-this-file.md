# What is `92aace22-artofwea_S8000.jar`?

> **In one line:** A Java ME phone game, "Art Of War 2 - Global
> Confederation", a real-time strategy game published by HeroCraft in 2010.

## The short answer
- It is a **MIDlet JAR**: a Java app for pre-smartphone handsets. It is not
  an Android app.
- Publisher HeroCraft, developer Gear Games, version 1.12.0.
- Built for a 240x320 touch screen. "S8000" in the file name is the Samsung
  S8000 (Jet).
- 546,006 bytes zipped, 52 files, 828,701 bytes unpacked.
- Inside: 18 Java classes, one settings-and-text file, 43 sprite sheets,
  balance tables, 6 maps, 7 missions, 4 bitmap fonts, 1 MIDI tune.

## How it works

Open the JAR as a zip and the first clue is `META-INF/MANIFEST.MF`:

| Manifest key | Value | Meaning |
|---|---|---|
| `MIDlet-1` | `Art Of War 2 - Global Confederation, icon.png, aow2` | App name, icon, and the start class `aow2` |
| `MIDlet-Vendor` | `HeroCraft` | Publisher |
| `MIDlet-Version` | `1.12.0` | Build version |
| `MicroEdition-Profile` | `MIDP-2.0` | The phone API level it needs |
| `MicroEdition-Configuration` | `CLDC-1.0` | The Java runtime level it needs |
| `MIDlet-Touch-Support` | `TRUE` | Touch screen build |
| `MIDlet-Data-Size` | `8192` | Minimum save storage, in bytes |
| `MIDlet-Info-URL` | `http://www.herocraft.com` | Publisher site |
| `MIDlet-Install-Notify` | `http://www.herocraft.com/logfile.php` | The phone reports a successful install here |

The About screen text confirms the credits: "Development: Gear Games 2009,
Publishing and porting: Herocraft 2010" (string `T1_0`).

## How we know
- SHA-256 of the JAR: `69370e29a7bad49956febef74f20f19a8baca6bc865dbf695ba515421aa6b6ee` (Observed)
- REA `inspect-artifact` inventory: zip, 52 entries, no integrity
  contradictions (Observed)
- [`aow2.java:7`](../../evidence/decompiled/aow2.java#L7) : `class aow2 extends MIDlet`, the entry point (Observed)
- `../../evidence/data/sn8p.json` key `T1_0` : the About text (Observed)
- Screen size: splash image `l2` is 240x320 and the back buffers are 270
  pixels wide, [`k.java:665`](../../evidence/decompiled/k.java#L665) (Observed)

## Still unknown
- The matching `.jad` descriptor file. It is not in the repo, and the game
  reads a few optional settings from it.
- Which store or operator this exact copy came from. See the next note.

**Next:** [How and when was it packaged?](02-packaging-and-dates.md)
