# How do you earn and spend money?

> **In one line:** Every 12.8 seconds each finished Command center pays you (100 for the first, 70 for the second, 49 for the third...), every dead enemy unit pays 20% of its price, and what you spend on buildings, walls, units and research is never refunded.

## The short answer

- **Starting money** comes from the mission script: 500, 1000, 500, 500, 1500, 2000, 2000 for missions 1 to 7.
- **Income** arrives every 128 game ticks (12.8 s). The first Command center pays 100, each further one pays 70% of the one before it, rounded down.
- **Bounty**: when an enemy unit dies you get 20% of its price (30% after the *Incentive system* research). Destroyed buildings pay nothing.
- **Spending**: a building or wall is paid when you place it, a research when you start it, a unit at the moment its own training starts (not when you queue it).
- **No refunds.** Blowing up your own building gives nothing back and counts as a lost building in the score.
- **Cap**: income stops topping you up at 30 000.
- **The computer opponent has no economy.** It gets no income and its units cost it nothing.

## How it works

Time unit used on these pages: 1 game tick = 100 ms, so 10 ticks per second. This assumes the phone keeps up with the 100 ms frame budget; a slow phone runs the whole game slower.

Money is one 16-bit number per side, slot 4 of a small per-side stats array. The same array holds everything the top bar and the score screen show:

| slot | meaning | slot | meaning |
|---|---|---|---|
| 0 | units alive | 5 | enemy units killed |
| 1 | buildings alive | 6 | enemy buildings destroyed |
| 2 | energy needed | 7 | own units lost |
| 3 | energy supplied | 8 | own buildings lost |
| 4 | **money** | 9 / 10 | mission score / running total |

### Starting money

Mission setup first writes 1000, then the mission script overwrites it on tick 0 with a "set money" step (step type 25): `player = byte1 x 10`, `enemy = byte2 x 10`.

| Mission | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|---|---|---|---|---|---|---|---|
| Player | 500 | 1000 | 500 | 500 | 1500 | 2000 | 2000 |
| Enemy (never used) | 500 | 1000 | 500 | 500 | 1500 | 1990 | 2000 |

### Income

On every tick where `tick & 127 == 127` (ticks 127, 255, 383...), the game walks the player's building slots in order. Each **finished Command center** does:

```
money  = clamp(money + pay, 0, 30000)
pay    = pay * 7 / 10        (integer division)
```

`pay` starts at the side's income percent `I` = 100 (120 after *Finance department*). A Command center still under construction pays nothing and does not use up a step of the 70% ladder.

| Command centers | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|
| Per payout | 100 | 170 | 219 | 253 | 276 |
| With Finance department | 120 | 204 | 262 | 302 | 330 |
| Per minute (4.69 payouts) | 469 | 797 | 1027 | 1186 | 1294 |

Worked example: a second Command center costs 700 and adds 70 per payout. It needs 10 payouts (128 s) after its 67.5 s build time to pay for itself.

### Bounty

When a unit's death animation ends, the **other** side receives `price x J / 100`, rounded down. `J` is 20, or 30 after *Incentive system* (the help text calls this "+50%"). The price is that of the unit's current form, so a Torrent caught in siege form (type 16, price 250) pays 50 while one in march form (type 13, price 300) pays 60.

| Enemy unit | Infantry | Grenadier | Sniper | Coyote | Armadillo | Rhino | Porcupine |
|---|---|---|---|---|---|---|---|
| Price | 10 | 20 | 40 | 40 | 70 | 150 | 220 |
| Bounty 20% / 30% | 2 / 3 | 4 / 6 | 8 / 12 | 8 / 12 | 14 / 21 | 30 / 45 | 44 / 66 |

The bounty line has no cap, but the next income tick clamps money back to 30 000, so the 16-bit limit (32 767) is out of reach in practice.

### Spending

| What | Price from | Charged when |
|---|---|---|
| Building | `tables[6][type]` (see [file 03](03-building-and-training.md)) | you confirm the placement |
| Wall | `tables[6][15]` = 20 | you confirm the placement |
| Unit | `tables[5][type] x f412s / 10`; `f412s` is always 10, so the list price | each unit starts training; if you cannot pay, the factory waits |
| Research | `tables[7][index]` | you start it |

If you cannot afford a building or a research, nothing is placed or started and a money-bar animation is triggered ([`g.java:1965`](../evidence/decompiled/g.java#L1965), Inferred to be a flash). There is no code path that adds money back: self-destruct, a cancelled queue entry (not yet paid anyway) and a lost Technology center with research in progress all return nothing.

### The computer opponent

Three checks skip the enemy side: the income line requires "side is not the enemy side", and the unit payment both skips the "can afford" test and the deduction for the enemy side. Its rebuilt buildings are created directly, with no price. The enemy still collects bounties into its money slot, but nothing ever reads it.

## How we know

- [`k.java:792`](../evidence/decompiled/k.java#L792) and [`k.java:784-790`](../evidence/decompiled/k.java#L784) : the main loop sleeps for what is left of 100 ms per pass (two 50 ms halves in smooth mode); [`k.java:771`](../evidence/decompiled/k.java#L771) runs one simulation step per pass; [`p.java:1821`](../evidence/decompiled/p.java#L1821) : tick counter +1 per step (Observed). 10 ticks/s on a fast enough phone (Inferred).
- [`k.java:333`](../evidence/decompiled/k.java#L333) : stats array is `short[2][11]`; slots identified from [`p.java:2093`](../evidence/decompiled/p.java#L2093), [`p.java:1680`](../evidence/decompiled/p.java#L1680), [`p.java:3482-3492`](../evidence/decompiled/p.java#L3482), [`p.java:2128-2137`](../evidence/decompiled/p.java#L2128), [`p.java:1688-1693`](../evidence/decompiled/p.java#L1688), [`g.java:1446`](../evidence/decompiled/g.java#L1446), [`g.java:4574-4596`](../evidence/decompiled/g.java#L4574) (Observed).
- [`g.java:863`](../evidence/decompiled/g.java#L863) : default 1000; [`p.java:2835-2836`](../evidence/decompiled/p.java#L2835) : script step 25 sets both sides to `byte x 10` (Observed). Per-mission values: `../evidence/tools/economy_tables.py` run on the `mi0`..`mi6` files (Observed).
- [`p.java:1660`](../evidence/decompiled/p.java#L1660) : `pay` starts at `I[side]`; [`p.java:1773-1775`](../evidence/decompiled/p.java#L1773) : the income test, the clamp to 30 000 and `pay * 7 / 10` (Observed, also checked in the `javap` bytecode of `p.class`).
- [`p.java:1744`](../evidence/decompiled/p.java#L1744) with [`p.java:1843-1853`](../evidence/decompiled/p.java#L1843) : a building under construction is skipped before the income line (Observed).
- `../evidence/data/a.json` `seg[94]` = [0,-1,1,2,-1,...,3,...] : only building type 0 (Command center) has value 0, which is what the income test asks for (Observed).
- [`p.java:661-663`](../evidence/decompiled/p.java#L661) : defaults `I` = 100, `f412s` = 10, `J` = 20; [`p.java:3680`](../evidence/decompiled/p.java#L3680), [`p.java:3683`](../evidence/decompiled/p.java#L3683) : research 21 sets `I` = 120, research 22 sets `J` = 30 (Observed).
- [`p.java:2139-2140`](../evidence/decompiled/p.java#L2139) : bounty = `tables[5][type] x J / 100` to the opposite side, inside the unit-death routine; the building-death block [`p.java:1668-1694`](../evidence/decompiled/p.java#L1668) has no money line (Observed).
- [`g.java:1927`](../evidence/decompiled/g.java#L1927), [`g.java:1956`](../evidence/decompiled/g.java#L1956) : building and wall price check and deduction; [`g.java:2466-2472`](../evidence/decompiled/g.java#L2466) : research; [`p.java:2029-2035`](../evidence/decompiled/p.java#L2029) : unit price and deduction (Observed).
- `f412s` is written only at [`p.java:662`](../evidence/decompiled/p.java#L662) (grep over all files), so the cost multiplier never leaves 1.0 (Observed).
- [`g.java:2388`](../evidence/decompiled/g.java#L2388) and [`p.java:2569-2577`](../evidence/decompiled/p.java#L2569) : self-destruct is plain damage equal to the building's HP; no money is added (Observed).
- [`p.java:1773`](../evidence/decompiled/p.java#L1773), [`p.java:2030`](../evidence/decompiled/p.java#L2030), [`p.java:2033`](../evidence/decompiled/p.java#L2033) : the three "not the enemy side" tests; [`p.java:1303`](../evidence/decompiled/p.java#L1303) : enemy rebuilds without paying (Observed).
- Help text `T1_2`, `T1_85`, `T1_122`, `T1_123` in `../evidence/data/sn8p.json` state the 30% drop, the 20% bounty, +20% finance and +50% reward (Observed).

## Still unknown

- Whether a Rebel Headquarters was meant to earn money. As written, the income test only accepts the Command center. It never matters in the seven missions: the player always has Command centers and the enemy side earns nothing anyway.
- Why the mission files carry enemy starting money (1990 in mission 6) when no code spends it.

**Next:** [What does energy do, and what happens when you run short?](02-energy.md)
