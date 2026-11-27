# What buildings exist, and what do they cost?

> **In one line:** Eight Confederation and seven Rebel buildings plus walls;
> each has a price and an energy need.

## The short answer
- The two sides have matching roles under different names (Command center /
  Headquarters, Generator / Powerplant, and so on).
- Most Rebel buildings are cheaper than their Confederation twin.
- The Confederation has eight buildings, the Rebels seven. Which
  Confederation building the Rebel "Tower" mirrors is not established here.
- Walls cost 20 and need no energy.

## How it works

| Id | Confederation | Cost | Energy | Id | Rebel | Cost | Energy |
|---|---|---|---|---|---|---|---|
| 0 | Command center | 700 | 0 | 8 | Headquarters | 550 | 0 |
| 1 | Generator | 200 | 0 | 9 | Powerplant | 200 | 0 |
| 2 | Infantry center | 300 | 2 | 10 | Barracks | 250 | 2 |
| 3 | Machine factory | 400 | 3 | 11 | Factory | 300 | 3 |
| 4 | Technology center | 350 | 2 | 12 | Laboratory | 250 | 2 |
| 5 | Bunker | 300 | 1 | 13 | Bunker | 250 | 1 |
| 6 | Locator | 250 | 1 | 14 | Tower | 350 | 1 |
| 7 | Rocket launcher | 450 | 2 | | | | |
| 15 | Wall | 20 | 0 | | | | |

"Energy" is the number the build panel prints next to the price
(`seg[61]`). How energy is produced and what a shortage does is in
[gameplay/02-energy](../gameplay/02-energy.md).

What the game's own help says each one is for:

| Building | Help text (shortened) |
|---|---|
| Command center | Directs construction; all buildings must stand within its radius; source of money |
| Generator | Produces energy for a number of facilities |
| Infantry center | Trains infantry, several types queued |
| Machine factory | Produces vehicles, several types queued |
| Technology center | Researches upgrades, one at a time |
| Bunker | Heavy armour, fast heavy machine gun, medium range |
| Locator | Reveals the map; long sight |
| Rocket launcher | Very long range heavy rockets |
| Wall | Barrier that slows the enemy |

## How we know
- [`g.java:4894`](../source/decompiled/g.java#L4894) : building panel draws name `T0_{63+b}` (Observed)
- [`g.java:4900`](../source/decompiled/g.java#L4900) : price from `tables[6]` (Observed)
- [`g.java:4903`](../source/decompiled/g.java#L4903) : the second number from `seg[61]` (Observed)
- `../source/data/a.json` `tables[6]`, `seg[61]` : the values (Observed)
- `../source/data/sn8p.json` `T0_63`..`T0_78` names, `T1_85`..`T1_93` help (Observed)
- Mission files use ids 0..14 with side = id / 8, see [mission format](../04-data-formats/06-mission-mi-files.md) (Observed)

## Still unknown
- `tables[6]` has 21 entries; ids 15..20 all cost 20. Whether those are six
  wall shapes or something else was not traced here.

**Next:** [Research list](03-research.md)
