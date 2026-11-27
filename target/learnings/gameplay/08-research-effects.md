# What does each research actually do?

> **In one line:** Every research adds a small flat number to a stat table (or swaps a unit type, or lengthens a build menu); most match their description, but *Enhanced firing rate* gives +33% where the text says +50%, and *Titanium cover* moves building armour from 8 to 9, which halves incoming damage.

## The short answer

- There are 24 player (Confederation) researches, index 0 to 23. Each costs `tables[7][i]`, paid in full when you start it. No cost multiplier exists.
- Every research takes the same time: 100 steps, one step every 4 ticks = **400 ticks (40 s)**, counted only while the Technology center has energy.
- Effects are edits to shared tables, so they hit units already on the map as well as new ones.
- Prerequisites are five small chains: 0→1, 5→6, 8→9/10/11/12, 13→14. Everything else is open from the start.
- Research does not carry over. Each mission starts with a fixed set already done (see [file 09](09-tech-availability.md)).
- The enemy has its own 24 researches (index 24 to 47). They are free, have no names, and are picked in index order.

## How it works

Three 64-bit masks hold the state, one bit per research (bits 0-23 player, 24-47 enemy):

| field | meaning | filled from |
|---|---|---|
| `f414a` | done **or in progress** | `seg[127]` per mission, then set on purchase |
| `f415b` | prerequisite met | constant `281138895495613`, then `g(n)` calls |
| `f416c` | not offered in this mission | `seg[128]` per mission, plus script tech levels |

Buying: allowed when the `f414a` bit is clear and the `f415b` bit is set and money ≥ cost. The menu cursor skips every research whose `f416c` bit is set. If the Technology center is destroyed mid-research the `f414a` bit is cleared again; the money is gone (Inferred: no refund code).

Damage formula used below: `damage = max(min(W×(10−A)/10, W−A), 1)`, W = weapon damage, A = target armour. "Period" = ticks between events, so lower is faster.

### Player researches (code `case i`)

| # | Name | Cost | What the code changes | Description says | Match |
|---|---|---|---|---|---|
| 0 | Energy suit | 300 | armour +2 for Assault, Heavy Assault, Flame Assault (0/1/0 → 2/3/2); unlocks 1 | armour +2 | yes |
| 1 | Bio suit | 200 | infantry heal period 20 → 6 ticks (`20/3`) | regen ×3 | ×3.33 |
| 2 | Enhanced firing rate | 200 | Assault rifle (weapon 1) reload 8 → 6 ticks | rate +50% | **no: +33%** |
| 3 | Armour-piercing bullet | 300 | weapon 1 damage 5 → 7; shown attack +2 | +40% | yes |
| 4 | Forced light missiles | 350 | Heavy Assault missile (weapon 16) damage 10 → 14; shown attack +4 | +40% | yes |
| 5 | "Lava" flame fuel | 250 | infantry menu level +1: adds Flame Assault; unlocks 6 | allows Flame Assault | yes |
| 6 | "Volcano" flame gun | 300 | AV-40 slot builds type 7 (was 18); all existing type 18 become 7; reinforcement table too | flame gun on AV-40 | yes |
| 7 | Heavy shells | 500 | Hammer gun (weapon 11) 20 → 25; Zeus gun (weapon 13) 35 → 43; shown attack +5 on both | +25% | Hammer yes, **Zeus +23%** |
| 8 | Reinforced engine | 500 | move period −1 for all 7 vehicle types; unlocks 9, 10, 11, 12 | speed +1 | yes |
| 9 | Energy armour | 500 | armour +2 for all 7 vehicle types (4 → 6, Hammer 3 → 5) | armour +2 | yes |
| 10 | Damage diagnostics | 400 | vehicle heal period 30 → 10 ticks | repair ×3 | yes |
| 11 | Fast recharging | 500 | reload: Hammer gun 12 → 10, Zeus gun 15 → 13 ticks | "reduces" | yes (+20% / +15% rate) |
| 12 | T-22 rocket launcher | 600 | Zeus slot builds type 11 (was 17); existing type 17 become 11 | rockets on Zeus | yes |
| 13 | Torrent-5 MRLS | 800 | vehicle menu level +1: adds MLRS Torrent; unlocks 14 | allows Torrent | yes |
| 14 | Torrent-10 MRLS | 700 | siege salvo (weapon 21) damage 35 → 45, range 13 → 15 | +30% dmg, +15% range | +29%, +15% |
| 15 | Reinforced generator | 300 | energy per Generator 6 → 8 | +30% | +33% |
| 16 | Titanium cover | 500 | building armour 8 → 9 | armour +50% | **wording: damage taken halves** |
| 17 | Walls Active armour | 250 | wall damage divisor 2 → 4; new wall sprite | endurance ×2 | yes |
| 18 | Alarm System | 400 | Command center menu level +1: adds Locator | allows radars | yes |
| 19 | Infantry express-training | 300 | infantry build-time factor 10 → 7 | −30% | yes |
| 20 | Upgraded assembly line | 300 | vehicle build-time factor 10 → 7 | −30% | yes |
| 21 | Finance department | 500 | income percent 100 → 120 | +20% | yes |
| 22 | Incentive system | 1000 | kill bounty 20% → 30% of unit price | +50% | yes |
| 23 | Communications system | 700 | build radius 20 → 25 cells | +25% | yes |

Variant units: type 7 = AV-40 with a second weapon (flame, weapon 10); type 11 = Zeus with a second weapon (rockets, weapon 17). Same price and HP as types 18 and 17.

Titanium cover worked example: a Zeus shell (W = 35) does `min(35×2/10, 27) = 7` to a building before and `min(35×1/10, 26) = 3` after.

### Enemy (Rebel) researches (code `case 24..47`)

| bit | effect | bit | effect |
|---|---|---|---|
| 24 | infantry armour +1 | 36 | enables Rhino siege form (`seg[52][10] = 15`) |
| 25 | infantry heal period 20 → 6 | 37 | nothing itself; unlocks 38 |
| 26 | Infantry and Sniper damage +1 | 38 | Porcupine 2nd weapon damage +2, range +2, sight +2 |
| 27 | infantry move period −1 | 39 | energy per Powerplant 6 → 8 |
| 28 | Grenadier range +1, sight +1 | 40 | building armour 8 → 9 |
| 29 | nothing itself; unlocks 30 | 41, 42 | mine kinds the enemy lays: 1 → 2 → 3 (Inferred) |
| 30 | Sniper siege shot damage +2, range +2, sight +2 | 43, 44 | infantry / vehicle build-time factor 7 |
| 31 | Coyote and Armadillo damage +1 | 45 | income 120 (no use: enemy has no income) |
| 32 | vehicle move period −1; unlocks 33-35 | 46 | bounty 30% |
| 33 / 34 | vehicle armour +1 / heal period 30 → 10 | 47 | build radius 25 |
| 35 | Rhino reload −2 ticks (both forms) | | |

Index 24 with cost 350 is simply the first enemy research. `tables[7][24..50]` are never charged: the enemy routine starts a research without touching money.

How the enemy researches: once every 420 ticks, each idle enemy Laboratory rolls `nextInt() % 10 < 4×(1+difficulty)`. Because Java `%` keeps the sign, that is a 70% chance on Easy and 90% on Hard. On success it starts the lowest-numbered research that is not done, is unlocked and is allowed in this mission. It also takes 400 ticks.

## How we know

- [`p.java:3511`](../source/decompiled/p.java#L3511) : the effect switch, cases 0-47 (Observed)
- [`p.java:3853`](../source/decompiled/p.java#L3853) : `g(n)` sets the `f415b` bit unless `f416c` forbids it (Observed)
- [`p.java:684`](../source/decompiled/p.java#L684) : start value of `f415b`; clear bits are 1, 6, 9-12, 14, 30, 33-35, 38, exactly the "Requires:" texts (Observed)
- [`g.java:2464`](../source/decompiled/g.java#L2464) : purchase check and cost. JADX prints the first test inverted; the bytecode (`javap -c g`, offsets 1740-1782) refuses when the `f414a` bit **is** set (Observed)
- [`g.java:2468`](../source/decompiled/g.java#L2468) : research total fixed at 100; [`p.java:1753`](../source/decompiled/p.java#L1753) : +1 every 4 ticks; [`p.java:1760`](../source/decompiled/p.java#L1760) : effect applied on completion (Observed)
- [`p.java:1744`](../source/decompiled/p.java#L1744), [`p.java:1838`](../source/decompiled/p.java#L1838) : no progress while the building is unpowered (Observed)
- [`p.java:1672`](../source/decompiled/p.java#L1672) : bit cleared when the lab dies mid-research (Observed)
- [`g.java:3438`](../source/decompiled/g.java#L3438) : menu cursor stays in 0-23 and skips `f416c` bits; [`g.java:4955`](../source/decompiled/g.java#L4955), [`g.java:2287`](../source/decompiled/g.java#L2287) : name `T1_{61+i}`, description `T1_{101+i}` (Observed)
- `../source/data/a.json` `tables[7]` costs; `seg[35]`/`seg[36]`/`seg[37]` = weapon damage / range / reload (copied to `f521s` at [`p.java:644`](../source/decompiled/p.java#L644)); `seg[34]` = weapons per unit type; `seg[16]` = heal periods [30, 20] (Observed)
- [`p.java:1383`](../source/decompiled/p.java#L1383) : reload counter wraps at `f521s[2][weapon]`; [`p.java:1371`](../source/decompiled/p.java#L1371) : +1 HP every `j[side][infantry?]` ticks (Observed)
- [`p.java:2396`](../source/decompiled/p.java#L2396) : buildings use `G[side]` as armour; [`p.java:2397`](../source/decompiled/p.java#L2397) : damage formula (Observed)
- [`p.java:2525`](../source/decompiled/p.java#L2525) : wall damage divided by `f294a[side]`; [`p.java:3489`](../source/decompiled/p.java#L3489) : `H[side]` energy per generator; [`g.java:1904`](../source/decompiled/g.java#L1904) : build radius test (Observed)
- [`p.java:3098`](../source/decompiled/p.java#L3098) : enemy research routine, called once per 10 ticks from [`p.java:1322`](../source/decompiled/p.java#L1322) (Observed). 70% / 90% follows from signed remainder (Inferred)
- [`p.java:3094`](../source/decompiled/p.java#L3094) : `y` = number of kinds for map cells 121-123, which explode with `seg[68]` = 15/30/80 damage (Observed); calling them mines is Inferred
- Bit shifts on the masks are 64-bit (`lshl` in the bytecode), although JADX prints `1 << i` (Observed)

## Still unknown

- Whether the "flame gun does not hurt Confederation units" claim of research 5 holds; the flame branch at [`p.java:2392`](../source/decompiled/p.java#L2392) was not traced.
- Type 7 has attack-range row value 2 where type 18 has 6 (`seg[30]`). The effect on targeting was not traced.
- Enemy researches 29 and 37 do nothing themselves. Whether they were meant to unlock a unit is unknown.

**Next:** [What can you build in each mission?](09-tech-availability.md)
