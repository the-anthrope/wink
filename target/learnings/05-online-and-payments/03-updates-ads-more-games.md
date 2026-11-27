# Does the game phone home?

> **In one line:** It has three optional web hooks (update check, "More
> games" link, slideshow adverts) and all three are disabled by this build's
> settings.

## The short answer
- Everything web-related sits behind one master switch, `WAP_JAVA`. It is 0.
- **More games** and the **update check** do not download anything
  themselves. They hand a web address to the phone's browser.
- **Slideshow adverts** are fetched by the game over HTTP as XML and cached.
- Separately, the manifest asks the phone to report a successful install to
  HeroCraft. That is done by the phone, not by game code.

## How it works

| Hook | Switch | Address | Mechanism |
|---|---|---|---|
| More games (`T0_4`) | `UMG` (0 = off) | From `UMG`; the default in settings is `http://m.herocraft.com/f/s/180` | Open in phone browser |
| Update check (`T1_42` "Check for updates?") | `SPRT` (0 = off) | `SPRTURL`, or the built-in `http://update.herocraft.com/jad/` | Open in phone browser |
| Slideshow adverts | `SSAD` (0 = off) | `SSADURL`, or the built-in `http://wap.herocraft.com/external/api/get_slideshow` | Game fetches XML, caches pictures |
| Install report | manifest `MIDlet-Install-Notify` | `http://www.herocraft.com/logfile.php` | The phone posts a status code after install |

**What the update address carries.** The game appends an encoded query:
game id, language, provider id, a timestamp, the version, and a CRC-32 over
those values plus the word `ArtOfWar2`. The server can tell which build is
asking and whether the request was made by a genuine copy.

**How adverts work.** The reply is XML: a `slideshow` element with `slide`
children, each with a `link` and a picture `src`. Class `d` parses it with
the bundled XML parser, downloads the pictures, and stores them in phone
storage (`aow2sad` plus one store per image) so they can be shown without a
connection.

The GMG lines in the code are a fourth, operator-specific variant of "More
games": if a file `GMG/GMG_settings.txt` or the JAD says `GMG-Mode: On`, its
`GMG-URL` replaces the link. The file is not in this JAR.

## How we know
- [`a.java:109`](../source/decompiled/a.java#L109) : `WAP_JAVA` gates the whole block down to line 130 (Observed)
- [`a.java:113`](../source/decompiled/a.java#L113) : the `UMG` link; [`g.java:2727`](../source/decompiled/g.java#L2727) : it is passed to the browser (Observed)
- [`a.java:545`](../source/decompiled/a.java#L545) : builds the update address; [`a.java:65`](../source/decompiled/a.java#L65) : the default host as a byte array (Observed)
- [`a.java:530`](../source/decompiled/a.java#L530) : `platformRequest`, the hand-off to the browser (Observed)
- [`k.java:716`](../source/decompiled/k.java#L716) : adverts start only if `SSAD` is on (Observed)
- [`d.java:89`](../source/decompiled/d.java#L89) : the slideshow address; [`d.java:337`](../source/decompiled/d.java#L337) to [`d.java:351`](../source/decompiled/d.java#L351) : XML handling (Observed)
- [`a.java:169`](../source/decompiled/a.java#L169) to [`a.java:226`](../source/decompiled/a.java#L226) : the GMG variant (Observed)
- `../source/data/sn8p.json` : `WAP_JAVA: 0`, `UMG: 0`, `SPRT: 0`, `SSAD: 0` (Observed)

## Still unknown
- Whether any of these addresses still respond. Nothing was contacted.

**Next:** [Does the game check that it is genuine?](04-integrity-checks.md)
