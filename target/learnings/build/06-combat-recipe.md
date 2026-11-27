# How do you make combat that players can reason about?

> **In one line:** No dice: one damage formula, weapons as data records,
> armour that makes small guns useless against big targets, and movement on
> a grid with one thing per cell.

## The idea

Suppose a rifle does 5 damage and a tank has 100 health. Twenty rifle hits
kill a tank. That makes rifles a fine answer to tanks, and then why build
anything else? A strategy game needs "this beats that". Try to guess the
smallest rule that makes a rifle bad against a tank and still good against
a soldier, with no special-case tables.

The original's answer is a single line.

## What the original does

**Damage**

```
damage = max( min( D * (10 - A) / 10 ,  D - A ),  1 )
```

`D` = weapon damage, `A` = target armour (0-4 for units, 8 for buildings).

- For big guns (`D` >= 10) armour removes 10% per point.
- For small guns the subtraction wins: each point removes 1 whole damage.
- The floor of 1 means nothing is ever fully immune.

| Weapon | vs armour 0 | vs armour 4 | vs building (8) |
|---|---|---|---|
| Rifle, D = 5 | 5 | 1 | 1 |
| Tank shell, D = 20 | 20 | 12 | 4 |
| Heavy shell, D = 35 | 35 | 21 | 7 |

One formula, and rifles need 72 seconds to kill a heavy vehicle while a
tank needs 12. No randomness, and bullets never miss, so the player can
learn the match-ups.

**Weapons are records, not code**

| Field | Example (tank gun) | Role |
|---|---|---|
| damage | 20 | `D` above |
| range | 6 cells | When it may fire |
| reload | 12 ticks | Rate of fire |
| projectile speed | 16 | Flight time; shells can be dodged |
| splash | 4/12 | Share of damage on the 8 cells around the hit |
| kind | bullet / shell / rocket / flame | Hit rule |

A unit type lists up to three weapon ids (hull plus two turrets). Each slot
aims on its own, so a turreted vehicle fires while it drives.

**Three hit rules**

| Kind | Rule | Consequence |
|---|---|---|
| Bullet | Tracks its target; always hits | Reliable, single target |
| Shell, rocket | Flies to where the target stood; 3x3 splash | Can be dodged; hurts friends too |
| Flame | Short line; kills infantry outright | Hard counter to massed infantry |

**Modes as type swaps.** Siege mode is not a flag with special code. The
unit's type id is swapped for a twin entry with zero mobility and a
longer-ranged weapon. Every stat follows from the tables.

**Movement** is cell to cell on a 30x20 pixel grid, 8 directions, one unit
per cell. Speed is "ticks per cell" (4 to 9). Route finding is "walk the
straight line, trace around what blocks you", with no search over the map.

**Reflexes.** Target the toughest enemy type in view, then the nearest;
shoot back when hit; alert idle friends.

## Recipe

1. One deterministic damage formula with armour. Start with the line above.
2. A weapon table; unit types reference weapons by id.
3. Two or three hit rules (homing, area, cone) cover every weapon you want.
4. Make modes and upgrades a swap to another table row.
5. Put units on a grid, one per cell. It makes collisions, splash and
   targeting trivial.
6. Print a damage matrix from your tables before you playtest.

## Knobs

| Knob | Original | Effect |
|---|---|---|
| Armour range | 0-4 units, 8 buildings | How sharply roles separate |
| Splash share | 25%-67% | How much clumping is punished |
| Reload | 4-25 ticks | Burst versus steady damage |
| Sight vs range | Siege forms out-range their own sight | Creates the need for spotters |

## Pitfalls seen in the original

- **The menu lies.** The "attack" number shown is a separate display table.
  The real damage is the weapon's (a tank shows 24 and does 35). Show the
  number the game uses.
- **Research text and numbers disagree** (+50% claimed, +33% real).
- **Straight-line route finding gets stuck** on concave obstacles; a unit
  blocked near its goal simply stops. Use a real path search today (A* on
  a grid this size is cheap).
- **All units ordered to one cell.** Groups bunch up and splash punishes
  them. Spread destinations.
- **Friendly fire from splash but not from flame.** Pick one rule.

## Evidence
- Formula and hit rules: [gameplay/05-damage](../gameplay/05-damage.md); [`p.java:2478`](../evidence/decompiled/p.java#L2478) (Observed)
- Weapon records and modes: [gameplay/06-weapons-and-special-modes](../gameplay/06-weapons-and-special-modes.md); `../evidence/tools/weapons_table.py` prints them (Observed)
- Grid and routes: [gameplay/04-movement](../gameplay/04-movement.md)
- Sight and fog: [gameplay/07-vision](../gameplay/07-vision.md)
- The 72 s and 12 s figures: `../evidence/tools/balance_sheet.py`, single target, no research (Inferred from the tables)

**Next:** [An opponent without an AI](07-enemy-and-mission-recipe.md)
