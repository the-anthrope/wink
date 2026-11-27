# Decode the per-mission technology bitmasks and menu lists from a.json.
# Usage: python3 -I tech_masks.py <path to a.json>
# Static data only. Mirrors p.java:676-684 (masks) and g.java:832, 2043 (menu lists).
import json, sys

seg = json.load(open(sys.argv[1]))['seg']

CONF = ['Energy suit', 'Bio suit', 'Enhanced firing rate', 'Armour-piercing bullet',
        'Forced light missiles', 'Lava flame fuel', 'Volcano flame gun', 'Heavy shells',
        'Reinforced engine', 'Energy armour', 'Damage diagnostics', 'Fast recharging',
        'T-22 rocket launcher', 'Torrent-5 MRLS', 'Torrent-10 MRLS', 'Reinforced generator',
        'Titanium cover', 'Walls Active armour', 'Alarm System', 'Infantry express-training',
        'Upgraded assembly line', 'Finance department', 'Incentive system', 'Communications system']
BLD = ['Command center', 'Generator', 'Infantry center', 'Machine factory', 'Technology center',
       'Bunker', 'Locator', 'Rocket launcher'] + ['?'] * 7 + ['Wall']
UNIT = {1: 'Assault', 3: 'Heavy Assault', 5: 'Flame Assault', 18: 'AV-40 Fortress',
        9: 'T-21 Hammer', 17: 'T-22 Zeus', 13: 'MLRS Torrent', 0: 'Infantry', 2: 'Grenadier',
        4: 'Sniper', 6: 'Coyote', 8: 'Armadillo', 10: 'Rhino', 12: 'Porcupine'}


def mask(s, mission):
    """48-bit little-endian mask, 6 bytes per mission (p.java:680-681)."""
    return int.from_bytes(bytes(s[6 * mission:6 * mission + 6]), 'little')


def bits(v, lo=0, hi=48):
    return [i for i in range(lo, hi) if v >> i & 1]


def menu(cat, level):
    """Item list of production category `cat` at list level `level` (g.java:2043)."""
    lst, off = seg[95 + 2 * cat], seg[96 + 2 * cat]
    return lst[off[level]:off[level + 1]]


START = 281138895495613  # p.java:684, f415b
print('f415b start mask: locked (bit clear) =', [i for i in range(48) if not START >> i & 1])
for m in range(8):
    done, forb = mask(seg[127], m), mask(seg[128], m)
    label = 'mission %d' % (m + 1) if m < 7 else 'custom game'
    lvl = seg[129][m]
    print('==', label, '(building list level %d)' % lvl)
    print('  buildings :', [BLD[b] for b in menu(0, lvl)])
    print('  infantry  :', [UNIT[seg[92][i]] for i in menu(1, 0)], '(level 0)')
    print('  vehicles  :', [UNIT[seg[92][i]] for i in menu(2, 0)], '(level 0)')
    print('  player pre-researched:', bits(done, 0, 24))
    print('  player not offered   :', bits(forb, 0, 24))
    print('  enemy pre-researched (R = bit-24):', [b - 24 for b in bits(done, 24)])
    print('  enemy not allowed    (R = bit-24):', [b - 24 for b in bits(forb, 24)])
print('script tech levels (p.java:3008-3029): op 33 value 21 forbids', bits(8192 | 16384),
      '; 22 forbids', bits(30720), '; 23 forbids', bits(1146496))
for lv in range(6):
    print('  vehicle list level', lv, [UNIT[seg[92][i]] for i in menu(2, lv)])
for lv in range(2):
    print('  infantry list level', lv, [UNIT[seg[92][i]] for i in menu(1, lv)])
for lv in range(6):
    print('  building list level', lv, [BLD[b] for b in menu(0, lv)])
