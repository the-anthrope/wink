# How do you make an economy that fits in twenty lines?

> **In one line:** Money arrives on a timer from a building you can lose,
> energy is a fixed budget you must not overdraw, and both rules create
> decisions without any resource gathering.

## The idea

Classic strategy games send workers to mine. That needs pathfinding for
workers, depots, and a lot of screen attention. On a small screen it is a
chore. The original removes gathering completely and still gives the player
real economic choices. Ask yourself before reading on: with no workers, what
could make "more income" a risky decision?

Its answer: income comes from an expensive building with falling returns,
and every other building eats from a second budget, energy.

## What the original does

**Money**

```
every 128 ticks (12.8 s):
    pay = 100                       # 120 with the finance upgrade
    for each finished command center:
        money = min(money + pay, 30000)
        pay   = pay * 7 / 10        # each extra center yields 30% less
on enemy unit killed:
    money += price_of(unit) * 20 / 100      # 30 with an upgrade
```

| Command centers | 1 | 2 | 3 | 4 |
|---|---|---|---|---|
| Money per payout | 100 | 170 | 219 | 253 |

A second center costs 700 and adds 70 per payout: it pays for itself after
about two minutes. The third adds 49 and takes about three and a half. The
curve tells the player "expand once, maybe twice, then fight".

**Energy**

```
supply = 6 * finished_generators            # 8 with an upgrade
for each building, oldest slot first:
    if used + need[building] <= supply: powered = true;  used += need
    else:                               powered = false  # fully frozen
```

Needs are tiny whole numbers: 0 for the core and generators, 1 for
defences, 2 for barracks and labs, 3 for the vehicle factory. A player can
do the sum in their head: one generator carries a barracks, a factory and
a bunker.

**Spending** has no refunds, and a unit is paid when its training starts,
not when it is queued. So a long queue never locks up money.

## Recipe

1. One income source, tied to a building that is costly and can be lost.
2. Falling returns per extra source. A geometric factor (x0.7) is enough.
3. A second, non-accumulating budget (energy, supply, upkeep) with needs
   small enough to add up mentally.
4. Reward fighting: a bounty per kill as a share of the victim's price.
5. Pay for queued things when work starts.
6. Show both budgets permanently on screen.

## Knobs

| Knob | Original | Turn it up and... |
|---|---|---|
| Payout interval | 12.8 s | Slower game, more waiting |
| Base payout | 100 | Bigger armies sooner |
| Falloff factor | 0.7 | Closer to 1 rewards wide expansion |
| Bounty share | 20% | Aggression pays; snowballing grows |
| Supply per generator | 6 | Fewer generators needed, less to defend |
| Starting money | 500-2000 per mission | The cheapest difficulty dial there is |

## Pitfalls seen in the original

- **Power by slot order.** Which building switches off depends on creation
  order, which the player cannot see. Let the player choose priorities, or
  switch off the newest first and say so.
- **The enemy has no economy.** It gets no income and pays nothing. That is
  fine for scripted missions but means raiding its economy is pointless.
  Decide on purpose whether your opponent plays by the same rules.
- **No refunds at all**, even for a mis-tap. A short undo window is kinder.
- **Bounty by current form.** A unit that switched form pays a different
  bounty. Harmless here, a surprise if prices differ a lot.

## Evidence
- Full rules with every line reference: [gameplay/01-money](../gameplay/01-money.md), [gameplay/02-energy](../gameplay/02-energy.md)
- [`p.java:1773`](../source/decompiled/p.java#L1773) to [`p.java:1775`](../source/decompiled/p.java#L1775) : interval, cap and the 7/10 step (Observed)
- [`p.java:2140`](../source/decompiled/p.java#L2140) : bounty (Observed)
- [`p.java:652`](../source/decompiled/p.java#L652) and [`p.java:3655`](../source/decompiled/p.java#L3655) : supply 6, then 8 (Observed)
- Payback times (Inferred: 700 / 70 = 10 payouts x 12.8 s, plus the 67.5 s build time)
- The design intent behind the curve (Inferred)

**Next:** [A combat recipe](06-combat-recipe.md)
