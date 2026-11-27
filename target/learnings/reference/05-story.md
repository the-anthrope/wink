# What is the story?

> **In one line:** In 2038 a general of the world government hunts a rebel
> leader across Peru, with too little intelligence and a senator on the line.

## The short answer
- The whole plot is told through radio dialogue and briefings, string table
  `T2` (111 strings, about 16,700 characters).
- Four portraits exist (sheet 35) and nine speaker names.
- This game shows the Confederation's side. The ending text is "To be
  continued..." (`T1_39`).
- This is a summary in our words. The full text is in
  `../evidence/data/sn8p.json`.

## How it works

**Setting.** 2038. For twenty years the Global Confederation has ruled every
country. Territorial wars are over, but revolts against the Senate are
spreading. With most forces tied up in the Middle East, a small expedition
is sent to Peru, near the city of Pucallpa (`T2_0`..`T2_2`).

**Cast** (names from `T0_100`..`T0_108`)

| Name | Role in the dialogue |
|---|---|
| The General | You. Blunt, short of patience with politicians |
| Senator Seiler | The Senate's man in charge of the operation |
| Captain Rogers | Leads the reconnaissance group and later a second base |
| Natalie | Communications officer who puts calls through |
| Assistant | The tutorial voice |
| William, Heinrich, Steve, Norman, Jeannette | Listed as names; their lines were not matched to speakers |

**Plot by mission**

| # | What happens |
|---|---|
| 1 Pucallpa | You arrive late, in the rainy season, with no satellite support. Rogers scouts the city, is driven back, and the rebels attack your new base. |
| 2 Ucayali Bank | Rogers has found a large rebel camp on the river north of the city. You strike it before the rebels can mobilise. |
| 3 Miguel Capture | A satellite photo shows seven more rebel bases moving toward the coast. Prisoners say the leader, Miguel Monteros, is at a northern river base. Rogers attacks it with infantry only; Miguel escapes by river. |
| 4 Outpost | Marching on Uanuco, your vanguard goes silent near a minefield. You destroy the rebel outpost. |
| 5 Slaughter | New photos: rebel forces arrive from the south too. You are closed in on both sides and must hold until reinforcements come. A detachment reaches you over the mountains first. |
| 6 Storm In Gorge | The rebels retreat and block the gorge that leads to their main base. You get the Torrent rocket launcher and break through mined approaches. |
| 7 The Last Battle | The assault on the main base. Miguel Monteros is captured; the Senator promises rewards. |

Extra lines (`T2_95`..`T2_110`) carry objectives and dialogue for scenarios
outside the seven missions: protecting Rogers' base, a surrounded division
calling for help. They read like material for custom or downloadable maps.

## How we know
- `../evidence/data/sn8p.json` `T2_0`..`T2_110` : every line summarised here (Observed)
- `T1_0` : credits; `T1_39` : "To be continued..." (Observed)
- Which dialogue belongs to which mission (Inferred from the order of the
  strings and the mission names; the trigger wiring is in
  [gameplay/12-mission-scripting](../gameplay/12-mission-scripting.md))

## Still unknown
- Which portrait is which character.

**Next:** [Gameplay deep dive](../gameplay/README.md)
