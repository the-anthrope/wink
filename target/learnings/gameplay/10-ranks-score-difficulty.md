# How do ranks, score and difficulty work?

> **In one line:** Rank is a 0-2 counter that only sets your unit and building caps; score is a time bonus (plus up to 50% for kills) that Easy cuts in half; Hard makes scripted enemy waves up to twice as big and enemy production faster, and changes nothing about HP, damage or money.

## The short answer

- **Rank** rises after winning campaign missions 2 and 4. It caps units at 20 / 35 / 50 and buildings at 10 / 25 / 50. Nothing else reads it.
- **Score** = time bonus + kill bonus worth at most half the time bonus. Two missions (1 and 5) have no time bonus and score kills only.
- **Easy divides the final score by 2.** Hard keeps it whole.
- Each restart or rewind of a mission cuts the time bonus by 10%.
- **Hard** multiplies scripted enemy wave sizes by a per-mission factor (×1.4 to ×2.0), shrinks your scripted reinforcements in missions 4-7, and speeds up enemy training, ordering, rebuilding and research.
- Difficulty does not touch starting money, prices, income, HP or damage.

## Ranks

Rank is the integer `g.c`, saved as one byte in the profile record. The name shown is string `T0_{94 + rank}`.

| rank | name | reached by | unit cap `seg[130]` | building cap `seg[131]` |
|---|---|---|---|---|
| 0 | Major-General | new profile | 20 | 10 |
| 1 | Lieutenant-General | winning mission 2 | 35 | 25 |
| 2 | General of Army | winning mission 4 | 50 | 50 (table says 51; the 50-slot limit hits first) |

How it rises: after a campaign win the game runs `while (seg[132][rank] < missionNumberWon && rank < 2) rank++`, with `seg[132]` = [1, 3, 6]. The third threshold (6) can never apply because of the `rank < 2` stop. A pop-up "Your rank raised to: [RANK]" (`T3_12`) follows. Two other places raise it: finishing a custom-map download sets rank to at least 1, and an online/unlock callback applies the same threshold table.

What it gates (all for the player only; the enemy cap is a flat 50 units):

- A unit that finishes training while you are at the cap waits one step short of done until there is room.
- The order counter in the unit menu cannot go above the cap.
- Scripted reinforcements stop arriving at the cap.
- A real building (not a wall) cannot be placed at the cap. The message is `T1_30` "Not available with the current rank"; at 50 it is `T1_37` "Maximum buildings constructed".
- Opening the unit menu at the cap shows `T1_30` once per mission (ranks 0 and 1 only).

The rank is shared by campaign and custom games. Strings `T0_97..99` (General, Senator, Captain) are not ranks: rank never exceeds 2, and the strings after them are character names (Inferred: dialogue speakers).

## Score

During the mission a running kill score `P` lives in stats slot 9:

- enemy unit killed: `+seg[43][type]` (Infantry 2, Grenadier 2, Sniper 3, Coyote 4, Armadillo 5, Rhino 6, Porcupine 7)
- own unit lost: `−seg[44][type]` (infantry 1, AV-40 2, Hammer 2, Zeus 3, Torrent 3)
- at victory: `+10` per enemy building destroyed, `−5` per own building lost

Then, with `e` and `f` set by the mission script, `ticks` the mission clock (10 per second), `s` the retry counter and `d` = 0 Easy / 1 Hard:

```
P = clamp(P, 0, f×100)            (cap is 100000 when e = 0)
T = max(e×500 − ticks/20, 0) × 0.9^s
score = (T + P × (T/2) / (f×100)) / (2 − d)     when e > 0
score = P / (2 − d)                              when e = 0
```

| mission | e | f | time bonus at 0:00 | zero after | kill cap |
|---|---|---|---|---|---|
| 1 | 0 | 0 | none | - | none |
| 2 | 3 | 12 | 1500 | 50 min | 1200 |
| 3 | 5 | 15 | 2500 | 83 min | 1500 |
| 4 | 1 | 5 | 500 | 16.7 min | 500 |
| 5 | 0 | 35 | none | - | none |
| 6 | 5 | 50 | 2500 | 83 min | 5000 |
| 7 | 6 | 50 | 3000 | 100 min | 5000 |

Worked example, mission 2 on Hard, won at 12:00 (7200 ticks), first try: T = 1500 − 360 = 1140. Kills 30 Infantry (+60), 10 Armadillo (+50), lost 10 Assault (−10), razed 22 buildings (+220): P = 320. Score = 1140 + 320 × 570 / 1200 = 1140 + 152 = **1292**. On Easy: 646.

`s` goes up by one when you restart a campaign mission (other than mission 1) after playing it, and when you load a save that is older than your last checkpoint (checkpoints are taken every 300 ticks). It resets on victory. In the campaign the mission score is added to the total (slot 10); the total is zeroed when a new campaign starts at mission 1. In custom games the "Total score" line shows the mission score.

This matches help text `T1_11`: faster is better, kills and losses count, and in missions "where the time does not depend on the player" (1 and 5, scripted survival) time is ignored.

## Difficulty

The menu screen has two items, Easy (index 0) and Hard (index 1); the index is `g.d`. Every place that reads it:

| what | Easy | Hard |
|---|---|---|
| final score | ÷ 2 | ÷ 1 |
| scripted enemy wave size | base | base × `f421h`/10 |
| scripted player reinforcement size | base | base × `f420g`/10 |
| enemy factory batch size | base | base × `f421h`/10 |
| enemy unit training time | full | × 3/4 |
| pause between enemy production orders | 1500 ticks | 1125 ticks |
| enemy rebuild cycle after its first full build pass | 800 ticks | 300 ticks |
| chance an idle enemy lab starts research (every 420 ticks) | 70% | 90% |

Base group sizes are `seg[114]` = 3 / 6 / 10 infantry and `seg[115]` = 2 / 4 / 6 vehicles. The two factors default to 10 and are set by each mission's script:

| mission | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|---|---|---|---|---|---|---|---|
| enemy factor `f421h` | 19 | 14 | 16 | 19 | 20 | 19 | 19 |
| player factor `f420g` | 10 | 10 | 10 | 9 | 9 | 8 | 8 |

So a 10-man enemy wave in mission 5 is 20 men on Hard. Training time: steps = `maxHP × factor/10 × (4 − (side + d)/2) / 4`, one step per 2 ticks. The integer division makes the last term 3/4 only for side 1 on Hard. An enemy Infantry (30 HP) takes 60 ticks on Easy and 44 on Hard.

The multiplier arrays named in the brief are not difficulty knobs: `f411r` (build time) changes only through researches 19, 20, 43, 44; `I` and `J` only through 21, 22, 45, 46; `f412s` (price) is set to 10 and never written again.

## How we know

- [`g.java:1472`](../evidence/decompiled/g.java#L1472) : rank loop on campaign win; [`g.java:6419`](../evidence/decompiled/g.java#L6419) : rank byte in the profile; [`o.java:206`](../evidence/decompiled/o.java#L206) : `[RANK]` → `T0_{94+c}` (Observed)
- [`g.java:8946`](../evidence/decompiled/g.java#L8946), [`g.java:8593`](../evidence/decompiled/g.java#L8593) : the two other rank raises; [`g.java:3664`](../evidence/decompiled/g.java#L3664) : pop-up (Observed)
- [`p.java:1935`](../evidence/decompiled/p.java#L1935) : training held at the cap, enemy cap 50; [`g.java:8193`](../evidence/decompiled/g.java#L8193) : order counter clamp; [`g.java:2045`](../evidence/decompiled/g.java#L2045) : unit-menu message (Observed)
- [`g.java:2393`](../evidence/decompiled/g.java#L2393) : building cap. JADX prints `>= 15`; the bytecode (`javap -c g`, offsets 1103-1252) tests `type < 15`, so walls are exempt (Observed)
- [`p.java:2130`](../evidence/decompiled/p.java#L2130) : slots 5, 7 and 9 updated on a unit death; [`p.java:1690`](../evidence/decompiled/p.java#L1690) : slots 6 and 8 for buildings; [`p.java:548`](../evidence/decompiled/p.java#L548) : slots 0-9 zeroed per mission (Observed)
- [`g.java:1443`](../evidence/decompiled/g.java#L1443) : the whole score formula, lines 1446-1462 (Observed)
- [`p.java:2822`](../evidence/decompiled/p.java#L2822) : script opcode 24 sets `e`, `f`; defaults 2, 2 at [`g.java:843`](../evidence/decompiled/g.java#L843); values per mission from `../evidence/tools/missions_full.py` (Observed)
- [`g.java:6747`](../evidence/decompiled/g.java#L6747), [`g.java:3240`](../evidence/decompiled/g.java#L3240), [`g.java:1222`](../evidence/decompiled/g.java#L1222) : retry counter `s` and the 300-tick checkpoint. The branch on campaign/custom at 3226 is printed inverted by JADX; bytecode of `g.b(byte)` offsets 238-306 was used (Observed)
- [`g.java:5591`](../evidence/decompiled/g.java#L5591) : clock shown as ticks × 100 ms; [`g.java:5681`](../evidence/decompiled/g.java#L5681) : total-score line (Observed)
- [`g.java:3061`](../evidence/decompiled/g.java#L3061) : `d` = chosen menu index; `../evidence/data/a.json` `seg[80]`/`seg[81]` screen 10 = strings 18, 19 (Observed)
- [`p.java:2853`](../evidence/decompiled/p.java#L2853), [`p.java:3146`](../evidence/decompiled/p.java#L3146) : wave and batch sizes; [`p.java:2957`](../evidence/decompiled/p.java#L2957) : opcode 33 sets `f420g` (value 2-9) or `f421h` (value 10-19, plus 1) (Observed)
- [`p.java:1930`](../evidence/decompiled/p.java#L1930), [`p.java:3134`](../evidence/decompiled/p.java#L3134), [`p.java:1270`](../evidence/decompiled/p.java#L1270), [`p.java:3108`](../evidence/decompiled/p.java#L3108) : the other four difficulty reads (Observed)
- [`p.java:2835`](../evidence/decompiled/p.java#L2835) : starting money from opcode 25, no difficulty term; [`p.java:662`](../evidence/decompiled/p.java#L662) : only write to `f412s` (Observed)

## Still unknown

- `T1_31` and `T1_52` ("Your rank is not high enough to ...") and `T0_45` "Demo!": no code sets them by number. `T1_31` is the text of data-driven screen 52 (`seg[84]`) and "Demo!" is the only item of menu screen 15 (`seg[80]`); what opens those screens was not found. They look like leftovers of a gated build (Inferred).
- Missions 1 and 5 set `e`, `f` only in the last script command. The win type `f445k` starts at −1 ([`p.java:722`](../evidence/decompiled/p.java#L722)) and the win tests need 0, 1, 2 or more than 50, so a win before that command looks impossible (Inferred, not traced end to end).
- The exact meaning of the "first full build pass" flag `f433a` (see [file 11](11-enemy-ai.md)).

**Next:** [How does the enemy AI decide what to do?](11-enemy-ai.md)
