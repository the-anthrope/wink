# Prints the economy numbers quoted in gameplay/01-money.md, 02-energy.md and
# 03-building-and-training.md, straight from the balance data.
# Static data only: nothing from the game is executed.
#
# Usage: python3 -I economy_tables.py <a.json> [<dir holding mi0..mi6 and m0..m5>]
import json, os, sys

TICK_S = 0.1  # one simulation tick = one 100 ms main-loop pass (k.java:792)

a = json.load(open(sys.argv[1]))
seg, tab = a['seg'], a['tables']
u8 = lambda v: v & 255

UNITS = {1: 'Assault', 3: 'Heavy Assault', 5: 'Flame Assault', 18: 'AV-40 Fortress',
         9: 'T-21 Hammer', 17: 'T-22 Zeus', 13: 'MLRS Torrent', 0: 'Infantry',
         2: 'Grenadier', 4: 'Sniper', 6: 'Coyote', 8: 'Armadillo', 10: 'Rhino',
         12: 'Porcupine'}
BUILDINGS = ['Command center', 'Generator', 'Infantry center', 'Machine factory',
             'Technology center', 'Bunker', 'Locator', 'Rocket launcher',
             'Headquarters', 'Powerplant', 'Barracks', 'Factory', 'Laboratory',
             'Bunker (Rebel)', 'Tower']

print('== Income per payout (every 128 ticks = %.1f s), p.java:1773-1775' % (128 * TICK_S))
for pct in (100, 120):
    i, total, row = pct, 0, []
    for n in range(1, 6):
        total += i
        row.append('%d CC: %d' % (n, total))
        i = i * 7 // 10
    print('  first payout %d -> %s' % (pct, ', '.join(row)))

print('== Units: cost, bounty at 20% / 30%, training time (p.java:1930, 2029, 2140)')
for t, name in UNITS.items():
    cost, hp = tab[5][t], u8(seg[42][t])
    times = ['%.1f' % (2 * (hp * f // 10) * TICK_S) for f in (10, 7)]
    print('  %-15s cost %3d  bounty %2d/%2d  HP %3d  train %s s (upgraded %s s)'
          % (name, cost, cost * 20 // 100, cost * 30 // 100, hp, times[0], times[1]))

print('== Buildings: cost, energy need, full HP, build time (c() at p.java:1852-1858)')
for b, name in enumerate(BUILDINGS):
    hp = u8(seg[59][b])
    steps = hp - hp // 10
    print('  %-17s cost %3d  energy %d  HP %3d  build %.1f s'
          % (name, tab[6][b], seg[61][b], hp, steps * 3 * TICK_S))
print('  Wall              cost %3d  energy %d  (a map cell, placed at once)' % (tab[6][15], seg[61][15]))

print('== Rank caps: units seg[130] =', seg[130], ' facilities seg[131] =', seg[131])

if len(sys.argv) > 2:
    x = sys.argv[2]
    rd = lambda n: open(os.path.join(x, n), 'rb').read()

    class R:
        def __init__(s, b): s.b, s.p = b, 0
        def u(s, n=1):
            v = int.from_bytes(s.b[s.p:s.p + n], 'big'); s.p += n; return v
        def skip(s, size, width=1):          # read a count, skip count*size bytes
            n = s.u(width); s.p += n * size

    def terrain(r):
        w, h = r.u(), r.u(); r.u()
        r.skip(2, 2)
        r.skip(3, 2)
        r.p += 4 * h * ((w - 1) // 32 + 1)

    print('== Starting money (script step type 25, value x 10), p.java:2835-2836')
    for mi in range(7):
        r = R(rd('mi%d' % mi))
        mapid = r.u()
        if mapid > 127:                                   # terrain stored inline
            terrain(r)
        r.skip(4)                                         # entities
        for _ in range(6): r.skip(4)                      # zones
        for _ in range(6): r.skip(4)                      # two 3-list blocks
        for _ in range(3):
            y = r.u(); y = y - 256 if y > 127 else y
            r.skip(1); r.p += y + 1
        for _ in range(3): r.skip(2)
        for _ in range(3): r.skip(4)
        steps = [tuple(r.u() for _ in range(6)) for _ in range(r.u())]
        ok = 'ok' if r.p == len(r.b) else 'PARSE MISMATCH'
        for s in steps:
            if s[0] == 25:
                print('  mission %d: player %d, enemy %d  (%s)' % (mi + 1, s[1] * 10, s[2] * 10, ok))
