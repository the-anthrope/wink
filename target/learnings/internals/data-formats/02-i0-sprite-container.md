# How are 43 pictures packed into `i0`?

> **In one line:** A chain of ordinary PNG files, each with a 3-byte length
> in front, in pairs: colour picture, then optional transparency mask.

## The short answer
- 86 slots = 43 pairs. Even slot = colour PNG. Odd slot = mask PNG or empty.
- Length 0 means "no mask": the colour PNG's own transparency is used.
- A single byte `0xFF` ends the file.
- 16 of the 43 sheets have a mask. The mask's blue channel becomes the alpha
  channel.

## How it works

```
repeat:
    byte b0
    if b0 == 0xFF: stop
    length = b0<<16 | b1<<8 | b2        (3 bytes, big-endian)
    length bytes: one complete PNG file  (may be 0 bytes)
```

Why two pictures per sheet? MIDP 2.0 phones could show PNG transparency only
as on/off for palette images. To get soft edges on smoke and glows, the game
loads a second greyscale-like picture and builds a true alpha image itself:

```
for every pixel:  result = (mask.blue << 24) | (colour & 0x00FFFFFF)
```

That is why the masked sheets are exactly the soft ones: smoke (16),
tracers (17), dust (18), shadows (19), explosions (23), flashes (24),
selection rings (26), HUD (27-29), briefing photos (31-34), shading (37),
labels (38).

The loader reuses one 33,000-byte buffer for every PNG and one 17,415-pixel
buffer for the merge. Both numbers are limits: no single PNG may exceed
33,000 bytes and no masked sheet may exceed 17,415 pixels. The largest PNG
is sheet 5 at 32,090 bytes, just under the limit.

## How we know
- [`k.java:1001`](../../evidence/decompiled/k.java#L1001) : opens `/i0` (Observed)
- [`k.java:1006`](../../evidence/decompiled/k.java#L1006) to [`k.java:1010`](../../evidence/decompiled/k.java#L1010) : the `0xFF` stop byte and the 3-byte length (Observed)
- [`k.java:1016`](../../evidence/decompiled/k.java#L1016) : even slots become images (Observed)
- [`k.java:1018`](../../evidence/decompiled/k.java#L1018) to [`k.java:1033`](../../evidence/decompiled/k.java#L1033) : odd slots are merged as alpha through the low byte (Observed)
- [`k.java:994`](../../evidence/decompiled/k.java#L994) to [`k.java:996`](../../evidence/decompiled/k.java#L996) : the buffer sizes (Observed)
- `../../evidence/tools/sprites_extract.py` : reads 86 slots and lands on the final `0xFF` at byte 271,332 of 271,333 (Observed)

## Still unknown
- The first array element `f337j[0]` gives the sheet count; where that value
  is set was not traced. The file itself yields 43.

**Next:** [The balance tables `a` and `d`](03-a-balance-tables.md)
