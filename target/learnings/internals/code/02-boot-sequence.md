# What happens when the game starts?

> **In one line:** One thread loads everything in a fixed order behind a
> progress bar, then enters an endless update-and-draw loop.

## The short answer
- The phone calls `aow2.startApp()`. That builds the screen object `k` and
  starts its thread.
- Loading is strictly sequential: settings, logos, splash, texts, sprites,
  fonts, frame tables, tilesets, balance tables, then the game objects.
- The numbers passed to `c(n)` are the loading bar percentage.
- After loading, the loop in `k.run()` never exits until you quit.

## How it works

| Bar % | Step | File(s) read | Where |
|---|---|---|---|
| - | Wait until the screen is visible | | [`k.java:626`](../../evidence/decompiled/k.java#L626) |
| - | Load **settings only** from the text file | `sn8p` | [`k.java:627`](../../evidence/decompiled/k.java#L627) |
| - | Show distributor and publisher logos with a fade | `prov.png`, `prov2.png` (absent here), `gg`, `hc` | [`k.java:632`](../../evidence/decompiled/k.java#L632), [`k.java:412`](../../evidence/decompiled/k.java#L412) |
| - | Read soft-key codes and layout settings | | [`k.java:634`](../../evidence/decompiled/k.java#L634) |
| 5 | Create a 270-pixel-wide back buffer, draw the splash | `l2` | [`k.java:665`](../../evidence/decompiled/k.java#L665), [`k.java:669`](../../evidence/decompiled/k.java#L669) |
| 12 | Load **all text strings** | `sn8p` again | [`k.java:686`](../../evidence/decompiled/k.java#L686), [`a.java:137`](../../evidence/decompiled/a.java#L137) |
| 15-25 | Load the 43 sprite sheets | `i0` | [`k.java:691`](../../evidence/decompiled/k.java#L691), [`k.java:991`](../../evidence/decompiled/k.java#L991) |
| 25-35 | Load 4 bitmap fonts | `f0_0`..`f3_0` + `...p` | [`k.java:694`](../../evidence/decompiled/k.java#L694), [`k.java:971`](../../evidence/decompiled/k.java#L971) |
| 35-40 | Load sprite frame tables | `d0` | [`k.java:700`](../../evidence/decompiled/k.java#L700), [`k.java:1069`](../../evidence/decompiled/k.java#L1069) |
| 40-45 | Load tileset records | `ml` | [`k.java:703`](../../evidence/decompiled/k.java#L703), [`k.java:1114`](../../evidence/decompiled/k.java#L1114) |
| 55 | Read version, set up SMS and web options | | [`k.java:713`](../../evidence/decompiled/k.java#L713), [`k.java:715`](../../evidence/decompiled/k.java#L715) |
| 60 | Load balance tables | `a`, `d` | [`k.java:722`](../../evidence/decompiled/k.java#L722), [`k.java:490`](../../evidence/decompiled/k.java#L490) |
| 65-80 | Create `g` (UI), `p` (simulation), `o` (text) | | [`k.java:724`](../../evidence/decompiled/k.java#L724) |
| 80-85 | Start sound | `s0m` | [`k.java:731`](../../evidence/decompiled/k.java#L731) |
| 90-100 | `g` sets up the main menu | | [`k.java:737`](../../evidence/decompiled/k.java#L737) |
| - | Main loop | | [`k.java:747`](../../evidence/decompiled/k.java#L747) |

Why `sn8p` is read twice: the first pass stops at the first text key so the
logos can appear quickly; the second pass loads the 403 strings. The mode
flag is the third argument, `"SO"` (settings only) or `"SL"` (settings and
language), see [`a.java:267`](../../evidence/decompiled/a.java#L267).

Map and mission files are not loaded here. They are read when a mission
starts, see [mission files](../data-formats/06-mission-mi-files.md).

## How we know
- [`aow2.java:16`](../../evidence/decompiled/aow2.java#L16) : `startApp` (Observed)
- [`k.java:397`](../../evidence/decompiled/k.java#L397) : the loop thread is created (Observed)
- [`k.java:621`](../../evidence/decompiled/k.java#L621) : `run()`, every step in the table is a line in this method (Observed)
- The meaning of `c(n)` as a progress bar (Inferred from the rising values 5..100)

## Still unknown
- JADX marked `run()` as "decompiled incorrectly" near its start
  ([`k.java:619`](../../evidence/decompiled/k.java#L619)). The step order is clear, but small details
  of the first lines may be off.

**Next:** [How to read the obfuscated code](03-reading-the-obfuscated-code.md)
