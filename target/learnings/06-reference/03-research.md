# What can be researched, and what does it cost?

> **In one line:** 24 upgrades bought at the Technology center, 200 to 1000
> each, in five loose groups: infantry, vehicles, rockets, base, economy.

## The short answer
- One research at a time per Technology center.
- Several upgrades require an earlier one ("Requires: Reinforced engine").
- Prices are in `tables[7]`; the descriptions below are the game's own.
- What the code actually changes for each one, and where the description
  and the code disagree, is in
  [gameplay/08-research-effects](../gameplay/08-research-effects.md).

## How it works

| # | Name | Cost | The game says | Requires |
|---|---|---|---|---|
| 0 | Energy suit | 300 | Infantry armour +2 | |
| 1 | Bio suit | 200 | Infantry health regeneration x3 | Energy suit |
| 2 | Enhanced firing rate | 200 | Assault firing rate +50% | |
| 3 | Armour-piercing bullet | 300 | Assault damage +40% | |
| 4 | Forced light missiles | 350 | Heavy Assault damage +40% | |
| 5 | "Lava" flame fuel | 250 | Allows Flame Assaults | |
| 6 | "Volcano" flame gun | 300 | Heavy flame gun on the AV-40 Fortress | Lava flame fuel |
| 7 | Heavy shells | 500 | T-22 Zeus and T-21 Hammer damage +25% | |
| 8 | Reinforced engine | 500 | All vehicles speed +1 | |
| 9 | Energy armour | 500 | All vehicles armour +2 | Reinforced engine |
| 10 | Damage diagnostics | 400 | Vehicle repair time / 3 | Reinforced engine |
| 11 | Fast recharging | 500 | Faster reload for Zeus and Hammer | Reinforced engine |
| 12 | T-22 rocket launcher | 600 | Rocket system mounted on the T-22 Zeus | Reinforced engine |
| 13 | Torrent-5 MRLS | 800 | Allows production of the MLRS Torrent | |
| 14 | Torrent-10 MRLS | 700 | Torrent range +15%, damage +30% | Torrent-5 MRLS |
| 15 | Reinforced generator | 300 | Energy production +30% | |
| 16 | Titanium cover | 500 | Building armour +50% | |
| 17 | Walls Active armour | 250 | Wall endurance x2 | |
| 18 | Alarm System | 400 | Allows production of radars | |
| 19 | Infantry express-training | 300 | Infantry training time -30% | |
| 20 | Upgraded assembly line | 300 | Vehicle production time -30% | |
| 21 | Finance department | 500 | Financing +20% | |
| 22 | Incentive system | 1000 | Reward per destroyed enemy unit +50% | |
| 23 | Communications system | 700 | Base construction range +25% | |

Total to buy everything: 10,650.

Names are strings `T1_61`..`T1_84`, descriptions `T1_101`..`T1_124`. The
price table continues past index 23: entries 24..47 belong to the enemy's
own, unnamed research list.

## How we know
- [`g.java:4984`](../source/decompiled/g.java#L4984) : the research panel prints `tables[7][index]` (Observed)
- [`g.java:5555`](../source/decompiled/g.java#L5555) : the info box shows `T1_{101+index}` (Observed)
- `../source/data/a.json` `tables[7]` : the prices (Observed)
- `../source/data/sn8p.json` : names and descriptions (Observed)
- Help text `T1_89` : "Can carry out just one research at a time" (Observed)

## Still unknown
- Nothing significant. Every research takes the same 40 seconds; see the
  gameplay note for effects.

**Next:** [The seven missions](04-missions.md)
