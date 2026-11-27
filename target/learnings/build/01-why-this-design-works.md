# Why does a full strategy game work on a tiny screen?

> **In one line:** Because every system was cut down to the one decision
> that matters, and the decisions that cost attention were removed.

## The idea

A desktop strategy game asks for a mouse, a keyboard and a big monitor.
This one ran on a 240x320 touch phone with a few megabytes of memory, and
it still feels like the genre: you build a base, grow an economy, research
upgrades, command an army, fight through a campaign. Something had to give.
What would you cut?

The useful lesson is not what the designers kept. It is **what they
removed without the player missing it**.

## What the original does

| Genre staple | What this game does instead | What the player still decides |
|---|---|---|
| Workers gathering resources | Money arrives on a timer from Command centers | When to pay 700 for another center |
| Many resource types | Money and energy | Whether a generator or a soldier comes next |
| Free build placement | Anywhere within 20 cells of a center | How far to stretch the base |
| Build and training time tables | Time = health x a constant | Nothing; it just feels consistent |
| A thinking enemy | Timed waves along painted routes | How to be ready by the next wave |
| Hit chances | Fixed damage, armour, no misses | Which unit beats which |
| Formations, patrols, stances | Move, attack, siege toggle | Where to stand and when to deploy |
| Large armies | 20 / 35 / 50 unit cap by rank | Quality against quantity |
| Tech tree screens | 24 upgrades in one list, five short chains | What to buy first |

Each row removes input or reading while keeping a choice. That is the whole
trick.

**Five ideas that carry the game**

1. **Two budgets.** Money accumulates, energy does not. One is "how much",
   the other is "how many at once". See [economy](05-economy-recipe.md).
2. **A second currency for armies: slots.** Cheap units win per coin,
   strong units win per slot. See [balance](09-balance-study.md).
3. **One damage rule with a threshold.** Small guns bounce off armour. See
   [combat](06-combat-recipe.md).
4. **Missions as scripts.** Seven missions from one engine: two defences,
   one base-less assault, four base assaults, by changing only data. See
   [missions](07-enemy-and-mission-recipe.md).
5. **Everything is a table.** The same program is every mission, every
   language, every balance patch. See [tables](04-put-your-numbers-in-tables.md).

**How the campaign teaches**

| Mission | New thing | How it is introduced |
|---|---|---|
| 1 | Base, infantry, bunkers | Only 4 buildings in the menu; tutorial pages on a timer; enemy only attacks |
| 2 | Vehicles, attacking a base | Enemy base with no laboratory, so it never upgrades |
| 3 | Fighting with infantry only | Vehicle factory removed from the menu |
| 4 | Using an army you are given | No buildings at all |
| 5 | Holding out | Same map as 4, now defended |
| 6-7 | Siege weapons, two enemy bases | Rocket launcher unlocked, more upgrades pre-researched |

The game restricts the menu per mission so the player meets one idea at a
time, and it reuses a map to save content.

## Recipe

1. List the genre's staples. For each, name the one decision it gives the
   player.
2. Keep the decision. Replace the mechanism with the cheapest thing that
   still forces it.
3. Remove anything that needs constant attention or precise input.
4. Introduce one system per level by hiding the others in data.

## Pitfalls seen in the original

- **Removed too much on the enemy side.** With no economy and no
  reactions, the opponent is a clock. Fine for a first play-through, thin
  for a second.
- **The second half of the campaign repeats** "destroy the base" with
  bigger numbers. Give late levels a new verb, not only a bigger count.
- **Hidden rules.** Several of the best ideas (flame kills infantry, crush,
  spotting for long-range weapons) are never explained in the interface.

## Evidence
- Menu restrictions and pre-researched upgrades per mission: [gameplay/09-tech-availability](../gameplay/09-tech-availability.md)
- What each mission contains: [gameplay/13-missions-one-by-one](../gameplay/13-missions-one-by-one.md)
- Build radius, time rules: [gameplay/03-building-and-training](../gameplay/03-building-and-training.md)
- Caps by rank: [gameplay/10-ranks-score-difficulty](../gameplay/10-ranks-score-difficulty.md)
- The "what was cut and why" reading is our interpretation (Inferred); the
  mechanisms themselves are Observed in the linked notes.

**Next:** [The smallest playable version](02-the-smallest-playable-version.md)
