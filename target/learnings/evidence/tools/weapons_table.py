"""Print the weapon table, the per-unit weapon loadout and a damage matrix.

usage: python3 -I weapons_table.py <path-to-a.json>

Reads only the balance data (a.json). Nothing here runs game code. The
meaning of each column comes from reading p.java (see
gameplay/05-damage.md and gameplay/06-weapons-and-special-modes.md).
"""
import json, sys

a = json.load(open(sys.argv[1]))
seg = [[v - 256 if v > 127 else v for v in s] for s in a['seg']]
useg = a['seg']

UNIT = {0: 'Infantry', 1: 'Assault', 2: 'Grenadier', 3: 'Heavy Assault',
        4: 'Sniper', 5: 'Flame Assault', 6: 'Coyote', 7: 'AV-40 + flame gun',
        8: 'Armadillo', 9: 'T-21 Hammer', 10: 'Rhino', 11: 'T-22 + rockets',
        12: 'Porcupine', 13: 'MLRS (march)', 14: 'Sniper (siege)',
        15: 'Rhino (siege)', 16: 'MLRS (siege)', 17: 'T-22 Zeus',
        18: 'AV-40 Fortress'}
BLD = ['Command center', 'Generator', 'Infantry center', 'Machine factory',
       'Technology center', 'Bunker (C)', 'Locator', 'Rocket launcher',
       'Headquarters', 'Powerplant', 'Barracks', 'Factory', 'Laboratory',
       'Bunker (R)', 'Tower']
KIND = {0: 'bullet', 1: 'shell', 2: 'rocket', 3: 'flame'}
EARLY = 1011  # bit mask of weapons with the 50% early-restart rule (p.java:1384)


def shots(w, building=False):
    """Shots per reload cycle (p.java:1633 for units, p.java:1912-1915 for buildings)."""
    rel, step, win = seg[37][w], seg[45][w], seg[46][w]
    if win == 0:
        return 2 if (w == 14 and not building) else 1
    want = 0 if (building and w == 9) else 1
    return sum(1 for c in range(rel) if c < win and c % step == want)


def cycle(w, building=False):
    """Average ticks per cycle; some unit guns restart early half of the time."""
    rel, win = seg[37][w], seg[46][w]
    if not building and (EARLY >> w) & 1 and 0 < win < rel:
        return (rel + win) / 2.0
    return float(rel)


def hit(dmg, armour):
    """Damage of one hit (p.java:2478)."""
    return max(min(dmg * (10 - armour) // 10, dmg - armour), 1)


print('WEAPONS  id dmg range reload speed scatter arc step window splash/12 kind')
for w in range(25):
    print('%2d %3d %3d %4d %3d %2d %2d %2d %3d %2d %s' % (
        w, seg[35][w], seg[36][w], seg[37][w], seg[38][w], seg[39][w],
        seg[40][w], seg[45][w], seg[46][w], seg[47][w], KIND[seg[48][w]]))

print('\nUNITS  type name hp armour sight range period turn(body,t1,t2) weapons(slot0,1,2) dmg-per-10-ticks')
for t in range(19):
    ws = seg[34][t * 3:t * 3 + 3]
    dps = sum(seg[35][w] * shots(w) * 10 / cycle(w) for w in ws if w >= 0)
    print('%2d %-18s %3d %d %2d %2d %d %s %s %.1f' % (
        t, UNIT[t], seg[42][t], seg[29][t], seg[28][t], seg[30][t],
        seg[27][t], seg[32][t * 3:t * 3 + 3], ws, dps))

print('\nBUILDINGS  type name hp sight weapon shots/cycle reload')
for b in range(15):
    w = seg[60][b]
    print('%2d %-18s %3d %2d %s' % (
        b, BLD[b], useg[59][b], seg[65][b],
        '-' if w < 0 else 'w%d x%d per %d ticks, dmg %d, range %d' % (
            w, shots(w, True), seg[37][w], seg[35][w], seg[36][w])))

print('\nDAMAGE PER HIT  rows = weapon damage, columns = armour 0..9')
for d in sorted(set(seg[35]) - {0}):
    print('%3d: %s' % (d, ' '.join('%3d' % hit(d, ar) for ar in range(10))))

print('\nMINES  type damage radius falloff/12')
for m in range(3):
    print(m, seg[68][m], seg[69][m], seg[70 + m])
