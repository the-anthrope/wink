"""Balance study: what does 100 money buy on each side?

usage: python3 -I balance_sheet.py <path-to-a.json>

Uses the same weapon model as weapons_table.py (single target, no splash,
no research, target standing in range). Flame weapons kill infantry
outright in the game; here they are counted at their listed damage, so the
Flame Assault is understated against infantry.
"""
import json, sys

a = json.load(open(sys.argv[1]))
seg = [[v - 256 if v > 127 else v for v in s] for s in a['seg']]
cost = a['tables'][5]
EARLY = 1011
BASE = [(1, 'Assault', 'C'), (3, 'Heavy Assault', 'C'), (5, 'Flame Assault', 'C'),
        (18, 'AV-40 Fortress', 'C'), (9, 'T-21 Hammer', 'C'), (17, 'T-22 Zeus', 'C'),
        (13, 'MLRS Torrent', 'C'), (16, 'MLRS (siege)', 'C'),
        (0, 'Infantry', 'R'), (2, 'Grenadier', 'R'), (4, 'Sniper', 'R'),
        (6, 'Coyote', 'R'), (8, 'Armadillo', 'R'), (10, 'Rhino', 'R'),
        (12, 'Porcupine', 'R')]


def shots(w):
    rel, step, win = seg[37][w], seg[45][w], seg[46][w]
    if win == 0:
        return 2 if w == 14 else 1
    return sum(1 for c in range(rel) if c < win and c % step == 1)


def cycle(w):
    rel, win = seg[37][w], seg[46][w]
    return (rel + win) / 2.0 if (EARLY >> w) & 1 and 0 < win < rel else float(rel)


def hit(d, ar):
    return max(min(d * (10 - ar) // 10, d - ar), 1)


def dps(t, armour):
    """Damage per second (10 ticks) against one target of the given armour."""
    return sum(hit(seg[35][w], armour) * shots(w) * 10 / cycle(w)
               for w in seg[34][t * 3:t * 3 + 3] if w >= 0)


print('PER UNIT')
print('%-15s side cost  hp arm  range  dps@0 dps@2 dps@4 dps@8 | per 100 money: hp  dps@0 dps@4 | train s' )
for t, n, s in BASE:
    c = cost[t]
    print('%-15s  %s  %4d %4d  %d   %3d   %5.1f %5.1f %5.1f %5.1f |              %4.0f %5.1f %5.1f | %5.1f' % (
        n, s, c, seg[42][t], seg[29][t], seg[30][t], dps(t, 0), dps(t, 2), dps(t, 4), dps(t, 8),
        seg[42][t] * 100 / c, dps(t, 0) * 100 / c, dps(t, 4) * 100 / c, seg[42][t] * 0.2))

print('\nDUELS: seconds for the row unit to kill the column unit (one on one, both in range)')
names = [n[:9] for _, n, _ in BASE]
print('%-15s' % '' + ' '.join('%9s' % n for n in names))
for t, n, s in BASE:
    row = []
    for u, m, _ in BASE:
        d = dps(t, seg[29][u])
        row.append('%9.1f' % (seg[42][u] / d))
    print('%-15s' % n + ' '.join(row))

print('\nEQUAL-MONEY TRADE: money destroyed per second by 100 money of the row unit shooting the column unit')
print('%-15s' % '' + ' '.join('%9s' % n for n in names))
for t, n, s in BASE:
    row = []
    for u, m, _ in BASE:
        d = dps(t, seg[29][u]) * 100 / cost[t]          # dps bought by 100 money
        row.append('%9.1f' % (d / seg[42][u] * cost[u]))  # money of target destroyed per second
    print('%-15s' % n + ' '.join(row))
