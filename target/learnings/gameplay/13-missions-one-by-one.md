# What happens in each of the seven missions?

> **In one line:** Two missions are timed defences against armies that appear at the map edge, one is a base-less assault with a gift army, and four are "build up and wipe out a self-repairing Rebel base".

## The short answer
- Missions 1 and 5 have no enemy base. You win by outliving the script and then killing what is left.
- Mission 3 is the only one won by killing the Headquarters alone. Missions 2, 4, 6, 7 need every enemy unit and building gone.
- Mission 2 is the only one lost by losing your Command centers. Everywhere else you lose when you have nothing left at all.
- Mission 4 gives you about 35 units and no buildings.
- Times below are game seconds from the script. Dialogue screens stop the clock. "xN" is the Hard size factor for enemy batches.

## How it works

Everything here is the output of `python3 -I source/tools/missions_full.py <jar folder> source/data`, read with the rules of [file 12](12-mission-scripting.md). Sizes are the Easy numbers. Infantry sizes are 3/6/10, vehicle sizes 2/4/6. The enemy can never have more than 50 units alive; spawns beyond that are dropped.

### 1. Pucallpa (`mi0`, 60x40) : hold the base
- **Start:** Command center, Generator, Infantry center, 2 Bunkers. Money 500. No enemy buildings. Hard x1.9.
- **Objective:** T2_13 "Build the base, be ready for the rebels' assaults; wait for the report", later T2_17 "Support the reconnaissance group; repel the attack".
- **Waves:** 93 s: 10 Infantry from the north-east. 178 to 338 s, three rounds: 20 Infantry (north-east), then 6 Grenadiers + 10 Infantry (south-east). 368 s: 20 Infantry + 20 Grenadiers.
- **418 s:** Captain Rogers' group, 10 Assault, appears at (58,36) and walks to your base. The camera jumps there, dialogue T2_14..16 plays.
- **427 to 607 s, three rounds:** 10 Infantry + 6 Coyote/Armadillo on Rogers' heels, then 10 Grenadiers + 10 Infantry + 6 vehicles from the north-east. **607 s:** last wave, 10 Grenadiers + 20 Infantry + 10 vehicles.
- **Win:** the rule "no enemy left" is switched on at 617 s. **Lose:** no units and no buildings.
- **Tutorial pages** (if switched on): 3 s, 43 s, 73 s, 138 s, 158 s.

### 2. Ucayali Bank (`mi1`, 60x60) : first real base
- **Start:** Command center, Generator, plus 6 Assault and 4 T-21 Hammer from the script. Money 1000.
- **Enemy:** one base in the south-east, 22 buildings (Headquarters, 5 Powerplants, 2 Barracks, 2 Factories, 11 Bunkers, 1 Tower). Build list 1, walls built at once, 2 mine fields filled one mine per 10 s. 7 attack routes. No Laboratory, so no research. Hard x1.4.
- **Orders:** 33 s: 6 Infantry / 4 Coyote-Armadillo per building. 313 s: 10 / 6. 513 s: 6 Grenadiers / 4 Armadillo-Rhino. 913 s: 10 mixed infantry / 4 Armadillo-Rhino. Free extras: 10 units at 463 s, 5 at 513 s.
- **Waves:** from 113 s every 40-60 s; from 713 s every 60-80 s; from 1113 s every 40-60 s. The script ends there and the last settings stay.
- **Win:** no enemy units and no enemy buildings (T2_43 "Destroy enemy base"). **Lose:** no Command center left.

### 3. Miguel Capture (`mi2`, 40x80) : infantry only
- **Start:** one Command center at the south edge. Money 500. No Machine factory in the menu.
- **Enemy:** base in the north, 14 buildings with a Laboratory, 23 wall tiles already placed plus 4 wall lines, 3 mine fields, 6 routes. Build list 2. Hard x1.6. The script first shows you the Headquarters at (33,9).
- **Orders:** 3 s: 6 Infantry / 4 Coyote-Armadillo. 303 s: 3 Grenadiers / 4 vehicles. 553 s: back to 6 / 4. From 753 s an endless 1050 s loop cycles the Barracks order (3 mixed, 6 Infantry, 6 Grenadiers, 6 mixed, 10 Infantry). Factories stay on 4 Coyote/Armadillo.
- **Waves:** from 103 s every 40-60 s, from 453 s every 60-80 s, from 703 s every 40-60 s.
- **Win:** every Headquarters destroyed (T2_59). Other buildings may stand. **Lose:** nothing left.

### 4. Outpost (`mi3`, 80x60) : assault with a fixed army
- **Start:** no buildings. Seven groups of 6 arrive in the north-east: Heavy Assault, T-21 Hammer, Fortress/Zeus, and four groups of Zeus (Torrent is rolled but swapped for Zeus because research 13 is missing). Delivery stops at your rank cap, 35 at this point of the campaign (Inferred). Hard: groups of 5.
- **Enemy:** 24 buildings in two clusters, 100 mine attempts at start in 3 fields, 3 wall lines. Build list 2, so a destroyed building is replaced every 20 s while the Headquarters lives. Starting units: 3 + 3 Snipers, 4 + 4 Armadillo/Rhino (Hard x1.9). No training orders at all.
- **Waves:** from 250 s every 20-40 s, but the only route runs between the two halves of the enemy base. It is a patrol.
- **Win:** no enemy units and no enemy buildings (T2_66). **Lose:** your last unit dies.

### 5. Slaughter (`mi4`, same map as 4) : the long defence
- **Start:** Command center, 2 Generators, 10 mixed infantry, 6 mixed vehicles, 6 Fortress/Zeus. Money 1500. Hard: enemy x2.0, your reinforcements x0.9.
- **Enemy:** no buildings. Groups 0 and 1 appear in the north-east corner, group 2 in the south-west corner. All three send waves every 20-40 s.
- **103 to 478 s:** opening waves, then four 60 s rounds of 37 units each (Infantry, Grenadiers, Armadillo/Rhino).
- **513 s:** "the highlanders", 4 + 4 Zeus/Torrent, arrive at the north edge (waits up to 16 s for room). T2_72..75.
- **515 to 735 s:** four 55 s rounds of 30 units with Snipers and Rhino/Porcupine. **755 s:** T2_76..77. **810 s:** 6 + 6 Zeus/Torrent for you in the south-west.
- **811 to 1315 s:** four 126 s rounds, each 84 enemy units ordered and 10 vehicles for you. **1355 s:** 22 Rhino/Porcupine.
- **Win:** rule switched on at 1356 s, then no enemy left (T2_71 "Hold on till the arrival of reinforcements"). **Lose:** nothing left.

### 6. Storm In Gorge (`mi5`, 60x80) : two bases
- **Start:** Command center, 2 Generators, Infantry center, 10 mixed infantry + 6 mixed vehicles. Money 2000. Hard: enemy x1.9, yours x0.8.
- **Enemy:** group 0 in the north-west (30 buildings, Laboratory, 150 mine attempts in one large field, walls). Group 1 north of centre (17 buildings, 3 Factories, no Barracks, no mines). Each rebuilds only what stood inside its zones at the start.
- **Orders:** group 0 starts with 10 Infantry per Barracks, group 1 with 2 Coyote/Armadillo per Factory. Orders step up to Armadillo/Rhino, then Rhino/Porcupine. From 1055 s an endless 1820 s loop keeps changing them and adds 2 free vehicles five times per pass.
- **Waves:** group 0 from 90 s every 40-60 s, group 1 from 105 s every 60-80 s; the loop varies this between 40 and 100 s.
- **Win:** no enemy units and no enemy buildings (T2_85). **Lose:** nothing left.

### 7. The Last Battle (`mi6`, 80x80) : two bigger bases
- **Start:** as mission 6. Money 2000. Torrents can be in the starting vehicles because research 13 is pre-done.
- **Enemy:** group 0 in the north-east (23 buildings, 4 Factories), group 1 down the east side (22 buildings, 3 Factories), a Laboratory each. 200 mine attempts for group 0. The 220 ordered for group 1 do nothing because group 1 has no mine field.
- **Orders:** from 0 s Grenadiers and Infantry in tens plus light vehicles; Armadillo/Rhino from 305 s; Rhino/Porcupine from 1105 s; Snipers in the endless 1200 s loop that starts at 1311 s.
- **1210 s:** 6 + 6 Zeus/Torrent for you at (4,75) (waits up to 31 s for room), T2_89 "The reinforcement has arrived".
- **Win:** no enemy units and no enemy buildings (T2_88), then dialogue T2_90..94. **Lose:** nothing left.

Texts T2_95..T2_98 ("Destroy the enemy base", "All command centers must survive", "Stand your ground until reinforcement arrives", "Don't let enemy destroy Rogers' base") belong to downloaded maps. They match the rule numbers the script can set: win rule 0, lose rule 1, win rule 2, and a lose rule above 50 (Inferred).

## How we know
- `source/tools/missions_full.py` : every number above. It parses all seven files to their exact length (Observed)
- [`p.java:2820`](../source/decompiled/p.java#L2820), [`p.java:2833`](../source/decompiled/p.java#L2833) : win and lose rule and money come from commands 24 and 25 (Observed)
- [`p.java:1697`](../source/decompiled/p.java#L1697), [`p.java:1700`](../source/decompiled/p.java#L1700), [`p.java:1720`](../source/decompiled/p.java#L1720), [`p.java:1723`](../source/decompiled/p.java#L1723) : meaning of rules 0 and 1 (Observed)
- [`p.java:3221`](../source/decompiled/p.java#L3221) : a unit is not created when its side already has 50 (Observed)
- [`p.java:2853`](../source/decompiled/p.java#L2853) : player spawns stop at `seg[130][rank]`; rank 1 is reached by winning mission 2, see [file 10](10-ranks-score-difficulty.md). Mission 4 total of 35 follows (Inferred)
- [`p.java:2857`](../source/decompiled/p.java#L2857) : Torrent swapped unless research bit 13 is set; `a.json seg[127]` row 3 has bits 0 and 5 only, row 6 has bit 13 (Observed)
- [`p.java:2969`](../source/decompiled/p.java#L2969) : the mine command needs a mine field for that group; `mi6` has none for group 1 (Observed)
- [`p.java:1269`](../source/decompiled/p.java#L1269) : rebuilding needs a live Headquarters in the group (Observed)
- `sn8p.json` T2_13, T2_17, T2_43, T2_59, T2_66, T2_71, T2_85, T2_88 : objective texts, reached through `d` offsets 13, 17, 43, 59, 66, 71, 85, 88 (Observed)
- `dmt` : dialogues 32..35 start at T2_95, 96, 97, 98 (Observed)

## Still unknown
- Real elapsed times. Dialogue pauses the clock and Hard changes nothing in the script timing.
- How many mines a start-of-mission command really lays. Each attempt fails on an occupied cell or a crowded neighbourhood.
- Which unit types a "mixed" batch gives; it is a random roll per unit (script spawns) or per batch (training).

**Next:** [What are custom games, and how is progress saved?](14-custom-games-and-saves.md)
