# What keeps players from building only the cheapest unit?

> **In one line:** Per coin, the cheapest soldier is the best unit in the
> game by a wide margin; the unit cap, armour and area weapons are what make
> expensive units worth buying.

## The idea

Take the price list and ask a blunt question: what does 100 money buy?
If one unit wins that comparison everywhere, the game has one strategy.
Before looking at the table, guess which unit gives the most health and the
most firepower per coin: the 10-coin rifleman or the 300-coin rocket
launcher?

## What the original does

Numbers below are computed from the balance tables, one unit shooting one
target, no research.

| Unit | Cost | HP | Damage/s vs soft | vs armour 4 | HP per 100 | Dmg/s per 100 (soft) | per 100 (armour 4) |
|---|---|---|---|---|---|---|---|
| Assault | 10 | 30 | 8.3 | 1.7 | 300 | 83 | 17 |
| Heavy Assault | 20 | 40 | 10.0 | 6.0 | 200 | 50 | 30 |
| Flame Assault | 30 | 70 | 8.0 | 4.7 | 233 | 27 | 16 |
| AV-40 Fortress | 100 | 120 | 17.5 | 7.5 | 120 | 18 | 8 |
| T-21 Hammer | 120 | 90 | 16.7 | 10.0 | 75 | 14 | 8 |
| T-22 Zeus | 220 | 120 | 23.3 | 14.0 | 55 | 11 | 6 |
| MLRS Torrent | 300 | 100 | 15.6 | 9.4 | 33 | 5 | 3 |
| Infantry (R) | 10 | 30 | 6.7 | 1.7 | 300 | 67 | 17 |
| Grenadier (R) | 20 | 40 | 8.0 | 4.0 | 200 | 40 | 20 |
| Sniper (R) | 40 | 50 | 3.5 | 1.5 | 125 | 9 | 4 |
| Coyote (R) | 40 | 60 | 10.0 | 3.3 | 150 | 25 | 8 |
| Armadillo (R) | 70 | 90 | 21.0 | 9.0 | 129 | 30 | 13 |
| Rhino (R) | 150 | 100 | 14.3 | 8.6 | 67 | 10 | 6 |
| Porcupine (R) | 220 | 100 | 45.7 | 18.6 | 45 | 21 | 8 |

Per coin the rifleman has **9 times the health and 16 times the
firepower** of the rocket launcher. So why does the game not collapse into
rifle spam? Four separate brakes:

| Brake | How it works | Where |
|---|---|---|
| **A second currency: slots** | A side may hold 20, 35 or 50 units by rank. Per slot, a Zeus brings 4x the health and 3x the firepower of an Assault | [ranks](../gameplay/10-ranks-score-difficulty.md) |
| **Armour** | A rifle does 1 damage to armour 4. The rifleman's lead per coin shrinks from 8x to under 3x, and per slot a Zeus is then 8 times stronger | [damage](../gameplay/05-damage.md) |
| **Area and line weapons** | Shells splash 3x3; flame kills infantry outright; heavy vehicles crush infantry | [weapons](../gameplay/06-weapons-and-special-modes.md) |
| **Reach** | The MLRS in siege form fires 13 cells, beyond every defensive building (11) | same |

The cost-inefficient units are bought for what the table cannot show:
range, splash and slot value. That is a healthy design: cheap units are
the efficient backbone, expensive ones are tools.

**Asymmetry.** The sides are not mirrors. Rebel vehicles are cheaper and
faster; the Porcupine has double the damage of anything else. The
Confederation gets sturdier vehicles and upgrades (the Rebel list has no
names and is driven by the script). Since the player only ever commands the
Confederation, the Rebel side is tuned as an obstacle, not as a fair
faction.

**Time is tied to health.** Training takes 0.2 s per health point and
construction 0.27 s per point. Tougher always means slower to make.

## Recipe

1. Print "per 100 money" columns for health and damage. Do it early.
2. Expect cheap units to win on efficiency. Do not fix that with price.
3. Add at least two brakes that are not money: a population cap, armour
   thresholds, area damage, range.
4. Give every expensive unit one job the table cannot express.
5. Run duels from the tables (who kills whom, in how many seconds) and
   look for a unit that beats everything. The script
   `balance_sheet.py` does this in 80 lines.

## Knobs

| Knob | Original | Lesson |
|---|---|---|
| Unit cap | 20 / 35 / 50 | The single strongest lever on army composition |
| Cheapest unit price | 10 | Sets the floor for every ratio |
| Armour steps | 0 to 4 | Each step is a wall for small weapons |

## Pitfalls seen in the original

- **The Sniper is weak on paper** (a tenth of the rifleman's damage per
  coin). Its value is sight (9, or 12 deployed). If a unit's point is
  information, make sure the game rewards information.
- **The Flame Assault's real strength is invisible** in every stat the menu
  shows: it kills infantry outright. Surface special rules in the UI.
- **One-sided tuning** is fine for a campaign and would break in
  two-player.

## Evidence
- `../evidence/tools/balance_sheet.py` on `../evidence/data/a.json` : every number in the table, plus duel and equal-money trade matrices (Observed data; the damage-per-second model is Inferred from the weapon rules and ignores splash and movement)
- [`g.java:4826`](../evidence/decompiled/g.java#L4826) : prices; [`p.java:3240`](../evidence/decompiled/p.java#L3240) : health (Observed)
- Unit cap by rank: `../evidence/data/a.json` `seg[130]` = 20, 35, 50 (Observed)
- "9 times" and "16 times": 300 / 33 and 83 / 5 from the table (Inferred)
- Design intent (Inferred)

**Next:** [What to do differently](10-what-to-improve.md)
