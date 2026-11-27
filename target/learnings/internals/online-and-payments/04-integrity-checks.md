# Does the game check that it is a genuine copy?

> **In one line:** Yes, four start-up routines compare the manifest and the
> phone against expected values, but this build ships without the expected
> values, so the checks have nothing to compare.

## The short answer
- The checks look at: the vendor name, the phone platform string, the JAR
  size and the JAR download address recorded in the manifest or JAD.
- They do not stop the game on the spot. Each leaves a coded mark in a
  table; the main loop reads the marks later and can interrupt play.
- The expected values would be settings in `sn8p` under short code names.
  None of those settings exist in this build.
- This note describes what is there. It is not a guide to changing it.

## How it works

Why spread a check out like this? If a check ran once and showed an error,
it would be easy to find. Here the comparison, the result and the reaction
sit in three different classes, and the result is hidden as a random-looking
number whose sign carries the meaning.

| Routine | Compares | Against setting | Runs at |
|---|---|---|---|
| in `g` | `MIDlet-Vendor` | code name `ZLP` | boot, while the logos show |
| in `k` | System property `microedition.platform` | code name `YUH` | boot, with the splash |
| in `o` | `MIDlet-Jar-Size` | code name `PZD` | boot, 12 percent |
| in `a` | `MIDlet-Jar-URL` | code name `ASS` | boot, when fonts load |

Each routine stores its outcome under a manifest-key name in the shared
settings table. During play, the UI loop polls six such names (vendor,
platform, jar size, jar URL and two more) and reacts when a mark says
"mismatch": it sets a flag in the simulation and shows a message.

In this build:

- `sn8p` contains none of the code-name settings (`ZLP`, `YUH`, `PZD`,
  `ASS`).
- Each routine therefore takes its "no expected value" exit.
- JADX also shows unreachable code after an early `return` in two of the
  routines (`k` and `o`). That can be an obfuscator trick, a decompiler slip, or a later
  edit of the class file. The class files all carry the same 2011 timestamp
  as the rest of the game code, which speaks against a later edit, but a
  timestamp is weak evidence.

## How we know
- [`g.java:8973`](../../evidence/decompiled/g.java#L8973) : the vendor routine; [`k.java:467`](../../evidence/decompiled/k.java#L467) : its call (Observed)
- [`k.java:1459`](../../evidence/decompiled/k.java#L1459) : the platform routine; [`k.java:667`](../../evidence/decompiled/k.java#L667) : its call (Observed)
- [`o.java:235`](../../evidence/decompiled/o.java#L235) : the JAR-size routine; [`k.java:688`](../../evidence/decompiled/k.java#L688) : its call (Observed)
- [`a.java:722`](../../evidence/decompiled/a.java#L722) : the JAR-address routine; [`i.java:96`](../../evidence/decompiled/i.java#L96) : its call (Observed)
- [`i.java:28`](../../evidence/decompiled/i.java#L28) : the code names are byte-array fields `f270a`..`f273d` in this class (Observed)
- [`g.java:1151`](../../evidence/decompiled/g.java#L1151) : the polling loop over the six names (Observed)
- `../../evidence/data/sn8p.json` : no `ZLP`, `YUH`, `PZD` or `ASS` key (Observed)
- "Nothing to compare" (Inferred from the missing settings and the early exits)

## Still unknown
- Whether HeroCraft shipped operator builds this way on purpose (checks
  present, values absent) or whether the values were removed later.
- What the reaction looks like to the player. Not traced.

**Next:** [Unit reference table](../../reference/01-units.md)
