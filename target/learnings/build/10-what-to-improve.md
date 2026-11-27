# What would you do differently today?

> **In one line:** Keep the skeleton, fix the places where the original cut
> a corner that no longer needs cutting: fairness of the opponent, clarity
> of the rules, and robustness of the loop.

## The idea

Reading old code is most useful when you sort what you find into three
piles: **copy**, **fix**, and **only there because of 2010 hardware**. This
note is the "fix" and "hardware" piles, each tied to evidence so you can
judge for yourself.

## What the original does, and what to change

**Rules the player cannot see**

| Found | Why it hurts | Do instead |
|---|---|---|
| Menu "attack" is a display-only table; real damage is in the weapon (Zeus shows 24, does 35) | Players learn wrong match-ups | Show computed damage per second from the same tables the rules use |
| Upgrade texts disagree with the data (+50% claimed, +33% real; +30% claimed, +33% real) | Erodes trust | Generate the text from the numbers |
| Flame kills infantry outright; heavy vehicles crush infantry; long-range weapons need spotters. None is explained | The best mechanics go unnoticed | One line of tooltip per special rule |
| Power cuts follow hidden slot order | Feels random | Let the player rank buildings, or cut newest first |

**The opponent**

| Found | Why it hurts | Do instead |
|---|---|---|
| Enemy pays nothing, earns nothing | No economic warfare; "cheating" feels cheap when noticed | Give it income, even a simple one, so raids matter |
| Script has no triggers, only timers | Missions play the same every time | Add "when unit enters zone" and "when building dies" events |
| Enemy sees whatever the player can see | Invisible, but removes scouting from the enemy's side | Give it the same fog, or say it has satellites and make that fiction |
| Hard = bigger numbers | Fine, but one-dimensional | Also change what it builds |

**Movement and control**

| Found | Why it hurts | Do instead |
|---|---|---|
| Route finding traces around obstacles, max 50 cells and 10 obstacles | Units stall in concave terrain | Grid A* or flow fields; trivial cost today |
| A group order sends everyone to one cell | Blobs, splash deaths | Spread targets around the tap |
| No formations, patrol or hold | Thin control | Add "hold position" first; it is the cheapest win |

**Engineering**

| Found | Why it hurts | Do instead |
|---|---|---|
| Loop sleeps the remainder, never catches up | Slow device = slow game | Fixed-step with an accumulator; interpolate drawing |
| Byte fields, 50-per-side caps | 2010 memory limits | Wider ints, larger caps, same flat arrays |
| Mixed byte order across files, unnamed columns | Tooling pain | One format, named columns, a validator |
| A rectangle read as two corners in one place | A real bug: enemy "alarm area" misfires | One rectangle type, used everywhere |
| Rules escaped the tables (time = hp x constant) | Cannot tune speed apart from toughness | Give time its own column, default to the old formula |

**Only there because of the hardware (do not copy)**

- Separate alpha-mask images merged at load: phones lacked alpha PNGs.
- Every direction drawn by hand with no mirroring: the blit could not flip.
- One 33 KB decode buffer reused for all images.
- Strings hidden as byte arrays and scattered genuineness checks.
- SMS billing and operator-specific builds.

## Recipe

For each system you take from an old game, write three lines: what you
copy, what you fix, what was a hardware workaround. If you cannot fill in
the first line, you do not need that system.

## Evidence
- Display-only attack table: [gameplay/05-damage](../gameplay/05-damage.md); upgrade mismatches: [gameplay/08-research-effects](../gameplay/08-research-effects.md), [gameplay/02-energy](../gameplay/02-energy.md)
- Flame and crush: [`p.java:2392`](../evidence/decompiled/p.java#L2392), [`p.java:1569`](../evidence/decompiled/p.java#L1569) (Observed); spotters: [gameplay/07-vision](../gameplay/07-vision.md)
- Enemy economy, vision and timers: [gameplay/11-enemy-ai](../gameplay/11-enemy-ai.md), [gameplay/12-mission-scripting](../gameplay/12-mission-scripting.md)
- Route finding limits: [gameplay/04-movement](../gameplay/04-movement.md)
- Loop: [`k.java:792`](../evidence/decompiled/k.java#L792) (Observed); buffers: [`k.java:994`](../evidence/decompiled/k.java#L994) (Observed)
- Hardware workarounds: [the i0 container](../internals/data-formats/02-i0-sprite-container.md), [integrity checks](../internals/online-and-payments/04-integrity-checks.md), [SMS](../internals/online-and-payments/01-sms.md)
- Every "do instead" is our suggestion (Inferred).

**Next:** [A build plan](11-build-plan.md)
