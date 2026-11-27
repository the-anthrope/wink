# How is the `sn8p` file laid out?

> **In one line:** A plain run of length-prefixed strings, each of the form
> `KEY: value`; no header, no index.

## The short answer
- 427 records back to back, 31,352 bytes.
- Each record is a Java "UTF string": 2 bytes of length (big-endian), then
  that many bytes of UTF-8-like text.
- Split each string at the first `:`; the value starts two characters later.
- Settings come first, text keys (`T0_0`...) after. The loader relies on
  that order.

## How it works

```
repeat until end of file:
    u16 big-endian   n
    n bytes          "KEY: value"
```

Reading it in Python:

```python
n = int.from_bytes(data[p:p+2], 'big'); s = data[p+2:p+2+n].decode('utf-8')
key, value = s.split(':', 1)[0], s[s.index(':')+2:]
```

The loader takes a mode:

| Mode | Used when | Behaviour |
|---|---|---|
| `SO` (settings only) | First thing at boot | Stops at the first key shaped `T?_...` |
| `SL` (settings + language) | After the splash | Reads everything |
| a language suffix | Multi-language builds | Keeps text keys ending in that suffix and strips it |

After loading, text keys `T{t}_{n}` are moved out of the hash table into
arrays `o.f384a[t][n]`, counting `n` up from 0 until a key is missing. A gap
in the numbering would silently cut a table short.

Inside values, `&` is a line break and bracketed words such as `[VER]`,
`[RANK]`, `[SMS_COST]`, `[CRD]`, `[B]`, `[S]` are replaced at run time.

## How we know
- [`a.java:267`](../../evidence/decompiled/a.java#L267) : the loader and its three modes (Observed)
- [`a.java:247`](../../evidence/decompiled/a.java#L247) : `readUTF` is used when the flag is true (Observed)
- [`a.java:148`](../../evidence/decompiled/a.java#L148) : the loop that builds `T{t}_{n}` keys (Observed)
- `../../evidence/tools/text_and_settings.py` parses 427 records and stops exactly
  at byte 31,352 (Observed)
- [`a.java:421`](../../evidence/decompiled/a.java#L421) : `&` becomes a newline in the word-wrap routine (Observed)

## Still unknown
- Nothing significant.

**Next:** [The `i0` sprite container](02-i0-sprite-container.md)
