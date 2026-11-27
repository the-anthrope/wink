# What is in the text and settings file?

> **In one line:** `sn8p` holds 24 switches that configure this build and
> 403 English strings: every menu, help page and line of dialogue.

## The short answer
- One file doubles as config and language pack. Swap it and you have a
  different language or a different distributor's build.
- Text comes in four tables: `T0` short labels, `T1` help and descriptions,
  `T2` campaign dialogue, `T3` online and payment messages.
- In text, `&` means a line break and `[RANK]`, `[VER]`, `[SMS_COST]` are
  placeholders filled in at run time.
- The decoded file is at `../source/data/sn8p.json`.

## How it works

**The four text tables**

| Table | Strings | Characters | Content | Examples |
|---|---|---|---|---|
| `T0` | 114 | 996 | Menu labels, unit and building names, mission names, ranks, character names | `T0_49` Assault, `T0_87` Pucallpa |
| `T1` | 126 | 8,567 | About, help pages, confirmations, research names (61-84), building text (85-93), unit text (94-100), research text (101-124) | `T1_9` rank limits |
| `T2` | 111 | 16,689 | Story intro, briefings, radio dialogue, tutorial, objectives | `T2_0` "2038 AD..." |
| `T3` | 52 | 1,145 | Tell a friend, SMS, login, payment, achievements | `T3_10` SMS unlock prompt |

**The settings**

| Key | Value | Meaning | Confidence |
|---|---|---|---|
| `LSK1`, `RSK1` | -6, -7 | Key codes of the left and right soft keys | Observed |
| `LSK2`, `RSK2` | 0, 0 | Alternative soft-key codes (unused here) | Observed |
| `SMTYPE` | 0 | Sound mode passed to the sound player | Observed |
| `SMPRIOR` | NORM_PRIORITY | Sound thread priority | Observed |
| `PRODY` | 1 | A small number clamped between `PRODMIN` and `PRODMAX`; purpose not traced | Unknown |
| `GAME_ID`, `PROV_ID`, `PROD_ID`, `PORT_ID`, `LANG_ID` | 180, 1102, 108952, 13277, en | Who and what this build is | Observed |
| `SMS_JAVA` | 1 | SMS features compiled in and enabled | Observed |
| `WAP_JAVA` | 0 | Web features (more games, updates, ads, account) disabled | Observed |
| `UMG` | 0 | "More games" link disabled | Observed |
| `UMGD` | `http://m.herocraft.com/f/s/180` | Default "more games" address | Inferred |
| `SPRT` | 0 | Update check disabled | Observed |
| `HCOC`, `HCOCL` | 1, 1 | HeroCraft online client flags; only used when `WAP_JAVA` is on | Observed |
| `SSAD` | 0 | Slideshow adverts disabled | Observed |
| `VP`, `CMDLR`, `INV_CMDLR` | TRUE, FALSE, 0 | Not read by name anywhere in the code | Unknown |
| `_eop_` | 1 | End-of-properties marker | Inferred |

Settings the code looks for but this file does not define, so their features
stay off: `UNLKS`, `ADDMS`, `TAFSMS`, `ADDCRD`, `SMSUA` (SMS numbers and
texts), `YAY`, `SPRTURL`, `SSADURL`, `WW3`, `ORIENT`, `DEFFNT`, `BUFRD`,
`KPSPLSH`, `ProvColor`.

A setting whose value starts with `JADPRP-` is a pointer: the real value is
read from the JAD/manifest property named after the prefix.

## How we know
- `../source/data/sn8p.json` : all keys and strings (Observed)
- [`a.java:267`](../source/decompiled/a.java#L267) : the loader; keys shaped `T?_` are text, everything else a setting (Observed)
- [`a.java:137`](../source/decompiled/a.java#L137) : text keys `T{table}_{n}` are collected into `o.f384a` (Observed)
- [`k.java:634`](../source/decompiled/k.java#L634) : soft keys; [`k.java:1194`](../source/decompiled/k.java#L1194) : sound; [`a.java:109`](../source/decompiled/a.java#L109) : `WAP_JAVA`; [`a.java:120`](../source/decompiled/a.java#L120) : `SSAD` (Observed)
- [`a.java:323`](../source/decompiled/a.java#L323) : the `JADPRP-` indirection (Observed)

## Still unknown
- `VP`, `CMDLR`, `INV_CMDLR`: probably read by a different build of the code.

**Next:** [Fonts and sound](03-fonts-and-sound.md)
