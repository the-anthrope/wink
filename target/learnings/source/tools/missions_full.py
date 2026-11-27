#!/usr/bin/env python3
"""Full decoder for the mission files mi0..mi6 of Art Of War 2 (J2ME).

Usage:  python3 -I missions_full.py <folder with extracted JAR files> [data folder]

Argument 1 must contain mi0..mi6, m0..m5 and d.  The optional data folder
(the one holding a.json and sn8p.json) is only used to cross-check the
built-in balance tables and to print the first words of each dialogue.

The script consumes every byte of each mission file and stops with exit
code 1 if a file is not parsed to exactly its length.

Layout (loader: g.java:918-1072, terrain: g.java:1073-1135):
  i8   terrain id (>=0: terrain is in file m<id>; <0: terrain follows inline)
  u8   entity count, then 4 bytes each: type, x, y, flag
  2x3  build zones    [class][group]: u8 n, n*(x,y,w,h)   class 0 normal, 1 defensive
  3    mine fields    [group]: u8 n, n*(x,y,w,h)
  3    wall lines     [group]: u8 n, n*(x,y,w,h)
  3    attack routes  [group]: i8 routes, u8 nbytes, nbytes of x,y; routes+1 offsets
  3    rally points   [group]: u8 n, n*(x,y)
  3    alarm areas    [group]: u8 n, n*4 bytes
  u8   script length, then 6 bytes each: opcode, p1, p2, value, delay, group
"""
import json
import os
import sys

BUILDINGS = ['Command center', 'Generator', 'Infantry center', 'Machine factory',
             'Technology center', 'Bunker', 'Locator', 'Rocket launcher',
             'Headquarters', 'Powerplant', 'Barracks', 'Factory', 'Laboratory',
             'Bunker(R)', 'Tower']
UNITS = {0: 'Infantry', 1: 'Assault', 2: 'Grenadier', 3: 'Heavy Assault', 4: 'Sniper',
         5: 'Flame Assault', 6: 'Coyote', 8: 'Armadillo', 9: 'T-21 Hammer',
         10: 'Rhino', 12: 'Porcupine', 13: 'MLRS Torrent', 17: 'T-22 Zeus',
         18: 'AV-40 Fortress'}
MISSIONS = ['Pucallpa', 'Ucayali Bank', 'Miguel Capture', 'Outpost', 'Slaughter',
            'Storm In Gorge', 'The Last Battle']
DIALOGUE_BASE = [1, 11, 15, 18, 20, 26, 28]          # g.java:880-904

# Copies of a.json segments (checked against a.json when a data folder is given).
SEG = {
    107: [8, 9, 10, 9, 11, 13, 14, 9, 10, 11, 8, 9, 13, 14, 9, 13, 14, 13, 14, 9, 13,
          14, 14, 8, 9, 10, 9, 11, 13, 14, 9, 10, 9, 13, 14, 14, 13, 14, 8, 9, 8],
    108: [0, 0, 23, 38, 41],
    109: [0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1],
    114: [3, 6, 10], 115: [2, 4, 6],
    116: [1, 3, 5, 1, 3, 5], 117: [0, 1, 2, 3, 6],
    118: [9, 7, 11, 11, 13, 9, 7, 11, 13], 119: [0, 1, 3, 5, 9],
    120: [0, 2, 4, 0, 2, 4], 121: [0, 1, 2, 3, 6],
    122: [6, 8, 8, 10, 10, 12, 6, 8, 10, 12], 123: [0, 2, 4, 6, 10],
}
# p.java:702-711 rewrites seg[118] at start: 11 -> 17 (Zeus), 7 -> 18 (Fortress)
SEG[118] = [{11: 17, 7: 18}.get(v, v) for v in SEG[118]]


class Reader:
    def __init__(self, data):
        self.b = data
        self.p = 0

    def u(self, n=1):
        if self.p + n > len(self.b):
            raise ValueError('read past end at %d' % self.p)
        v = int.from_bytes(self.b[self.p:self.p + n], 'big')
        self.p += n
        return v

    def s8(self):
        v = self.u()
        return v - 256 if v > 127 else v


def read_terrain(r):
    """Same walk as maps.py / g.java:1073-1135; returns (width, height, tileset)."""
    w, h, ts = r.u(), r.u(), r.u()
    for _ in range(r.u(2)):          # run-length ground tiles
        r.u(); r.u()
    for _ in range(r.u(2)):          # decor objects
        r.u(); r.u(); r.u()
    for _ in range(h):               # passability mask, 32 bits per word
        for _ in range((w - 1) // 32 + 1):
            r.u(4)
    return w, h, ts


def rects(r):
    return [tuple(r.u() for _ in range(4)) for _ in range(r.u())]


def parse(folder, index):
    data = open(os.path.join(folder, 'mi%d' % index), 'rb').read()
    r = Reader(data)
    m = {'index': index, 'bytes': len(data)}
    m['map_id'] = r.s8()
    if m['map_id'] >= 0:
        m['size'] = read_terrain(Reader(open(os.path.join(folder, 'm%d' % m['map_id']), 'rb').read()))
    else:
        m['size'] = read_terrain(r)
    m['entities'] = [tuple(r.u() for _ in range(4)) for _ in range(r.u())]
    m['build_zones'] = [[rects(r) for _ in range(3)] for _ in range(2)]
    m['mine_fields'] = [rects(r) for _ in range(3)]
    m['wall_lines'] = [rects(r) for _ in range(3)]
    m['routes'] = []
    for _ in range(3):
        n_routes = r.s8()
        coords = [r.u() for _ in range(r.u())]
        offs = [r.u() for _ in range(n_routes + 1)]
        m['routes'].append([[(coords[i], coords[i + 1]) for i in range(offs[k], offs[k + 1], 2)]
                            for k in range(n_routes)])
    m['rally'] = [[(r.u(), r.u()) for _ in range(r.u())] for _ in range(3)]
    m['alarm'] = [rects(r) for _ in range(3)]
    m['script'] = [tuple(r.s8() for _ in range(6)) for _ in range(r.u())]
    m['consumed'] = r.p
    return m


def composition(side, row, comp):
    lst, off = SEG[116 + side * 4 + row * 2], SEG[117 + side * 4 + row * 2]
    names = []
    for t in lst[off[comp]:off[comp + 1]]:
        if UNITS[t] not in names:
            names.append(UNITS[t])
    return '/'.join(names)


def batch(value, side, scale):
    """value = size index + 3*composition (two rows share it). Returns text."""
    size, comp = value % 3, (value % 30) // 3
    rows = {0: (0, 1), 1: (0,), 2: (1,)}[value // 30] if value // 30 < 3 else ()
    parts = []
    for row in rows:
        n = SEG[114 + row][size]
        hard = n * scale // 10
        parts.append('%d (Hard %d) x %s' % (n, hard, composition(side, row, comp)))
    return ' + '.join(parts)


def order(value):
    """Opcode 20: what the group's barracks / factories train (enemy side)."""
    if value // 30 == 0:
        rows = [(0, value), (1, value)]
    else:
        rows = [(value // 30 - 1, value % 30)]
    out = []
    for row, v in rows:
        out.append('%s: batches of %d x %s' % (('barracks', 'factory')[row],
                   SEG[114 + row][v % 3], composition(1, row, v // 3)))
    return '; '.join(out)


def describe(cmd, base, st, dlg):
    op, p1, p2, v, delay, grp = cmd
    uv = v & 255
    if op == 20:
        return 'group %d production order -> %s' % (grp, order(v))
    if op == 21:
        return 'group %d attack waves every %d-%d s' % (grp, v * 20, v * 20 + 20)
    if op == 22:
        return 'loop start'
    if op == 23:
        return 'loop back to the last "loop start" ' + (
            'forever' if v == -1 else '%d more time(s), then go on' % v)
    if op == 24:
        cond = {0: 'no enemy units and no enemy buildings left',
                1: 'every enemy Headquarters destroyed',
                2: 'immediately (win now)'}.get(v, 'enemy building slots 1..%d destroyed' % (v - 50))
        return 'WIN when %s; score: time budget %d, kill cap %d' % (cond, p1, p2)
    if op == 25:
        cond = {0: 'no own units and no own buildings left',
                1: 'every own Command center destroyed'}.get(v, 'any own building slot 1..%d destroyed' % (v - 50))
        return 'LOSE when %s; money: player %d, enemy %d' % (cond, (p1 & 255) * 10, (p2 & 255) * 10)
    if op == 26:
        return 'group %d rally point #%d = (%d,%d)' % (grp, v, p1, p2)
    if op == 27:
        side = 1 if grp < 3 else 0
        scale = st['enemy'] if side == 1 else st['player']
        who = 'enemy group %d' % grp if side == 1 else 'PLAYER reinforcement'
        need = ' (only if the player has room for %d more units)' % st['room'] if st['room'] else ''
        return 'spawn at (%d,%d) for %s: %s%s' % (p1, p2, who, batch(v, side, scale), need)
    if op in (28, 39):
        d = base + v
        first, last = dlg['offs'][d], dlg['offs'][d + 1] - 1
        text = dlg['text'].get(first, '')
        return '%s %d = T2_%d..T2_%d%s' % ('dialogue' if op == 28 else 'tutorial dialogue (only if tutorial is on)',
                                           d, first, last, (' "%s..."' % text[:50]) if text else '')
    if op == 29:
        first = dlg['offs'][base + v]
        return 'objective text = T2_%d %s' % (first, json.dumps(dlg['text'].get(first, '')))
    if op == 30:
        return 'group %d: cancel production order (row %s)' % (grp, 'both' if v == 0 else v - 1)
    if op == 31:
        return 'group %d: stop attack waves' % grp
    if op == 32:
        lst = SEG[107][SEG[108][v]:SEG[108][v + 1]]
        return 'group %d base build list #%d: %s' % (grp, v, ', '.join(BUILDINGS[t] for t in lst) or '(empty, nothing is rebuilt)')
    if op == 33:
        if uv <= 1:
            return 'group %d: wall repair on%s' % (grp, ' and all wall lines built now' if uv == 1 else '')
        if uv < 10:
            st['player'] = v
            return 'Hard only: player reinforcement size x%.1f' % (v / 10)
        if uv < 20:
            st['enemy'] = v + 1
            return 'Hard only: enemy batch and spawn size x%.1f' % ((v + 1) / 10)
        if uv < 29:
            return 'technology limit preset %d' % uv
        if uv < 30:
            return 'waves wait at their gathering waypoint (flag f461o)'
        return 'group %d: lay %d mines at random inside its mine fields' % (grp, uv)
    if op == 34:
        d = base + v
        return 'victory dialogue = %d (T2_%d..T2_%d)' % (d, dlg['offs'][d], dlg['offs'][d + 1] - 1)
    if op == 35:
        return 'order every unit tagged %d (%s) to move to (%d,%d)' % (
            grp, 'player side' if grp >= 3 else 'enemy group', p1, p2)
    if op == 36:
        return 'move camera to (%d,%d)' % (p1, p2)
    if op == 37:
        return 'reveal the map around (%d,%d), radius %d' % (p1, p2, v)
    if op == 38:
        st['room'] = v
        return 'next spawn needs room for %d units under the 50 cap' % v
    return 'UNKNOWN opcode'


def load_dialogues(folder, data_dir):
    d = open(os.path.join(folder, 'd'), 'rb').read()
    n_dlg, n_lines = int.from_bytes(d[0:2], 'big'), int.from_bytes(d[2:4], 'big')
    offs = list(d[4:4 + n_dlg + 1])
    assert 4 + (n_dlg + 1) + n_dlg + n_lines == len(d), 'file d has an unexpected size'
    text = {}
    if data_dir:
        strings = dict(json.load(open(os.path.join(data_dir, 'sn8p.json'))))
        for k, v in strings.items():
            if k.startswith('T2_'):
                text[int(k[3:])] = v
        seg = json.load(open(os.path.join(data_dir, 'a.json')))['seg']
        for k, v in SEG.items():
            ref = seg[k] if k != 118 else [{11: 17, 7: 18}.get(x, x) for x in seg[k]]
            assert ref == v, 'built-in seg[%d] differs from a.json' % k
    return {'offs': offs, 'text': text}


def show(m, dlg):
    i = m['index']
    print('=' * 78)
    print('MISSION %d "%s"  file mi%d  %d bytes  terrain %s  map %dx%d tileset %d' % (
        i + 1, MISSIONS[i], i, m['bytes'], 'm%d' % m['map_id'] if m['map_id'] >= 0 else 'inline',
        m['size'][0], m['size'][1], m['size'][2]))
    print('-- entities (%d)' % len(m['entities']))
    for t, x, y, flag in m['entities']:
        if t < 15:
            side = t // 8
            note = ''
            if side == 1:
                zones = m['build_zones'][SEG[109][t]][flag] if flag < 3 else []
                inside = any(zx <= x < zx + zw and zy <= y < zy + zh for zx, zy, zw, zh in zones)
                note = '  group %d, %s a build zone' % (flag, 'inside' if inside else 'outside')
            print('   %-17s side %d at (%2d,%2d)%s' % (BUILDINGS[t], side, x, y, note))
    walls = [e for e in m['entities'] if e[0] >= 15]
    if walls:
        print('   %d wall tiles (types %s): %s' % (len(walls), sorted({e[0] for e in walls}),
              ' '.join('(%d,%d)' % (e[1], e[2]) for e in walls)))
    for g in range(3):
        rows = []
        for cls, name in ((0, 'build zones, normal'), (1, 'build zones, defensive')):
            if m['build_zones'][cls][g]:
                rows.append('%s x,y,w,h: %s' % (name, m['build_zones'][cls][g]))
        if m['mine_fields'][g]:
            rows.append('mine fields x,y,w,h: %s' % m['mine_fields'][g])
        if m['wall_lines'][g]:
            rows.append('wall lines x,y,w,h: %s' % m['wall_lines'][g])
        if m['rally'][g]:
            rows.append('rally points: %s' % m['rally'][g])
        if m['alarm'][g]:
            rows.append('alarm areas (4 raw bytes): %s' % m['alarm'][g])
        for k, route in enumerate(m['routes'][g]):
            rows.append('attack route %d: %s' % (k, ' -> '.join('(%d,%d)' % p for p in route)))
        if rows:
            print('-- enemy group %d' % g)
            for row in rows:
                print('   ' + row)
    print('-- script (%d commands; delay is seconds after the previous command)' % len(m['script']))
    st = {'player': 10, 'enemy': 10, 'room': 0}
    clock, loop_at, retry = 0, None, False
    for n, cmd in enumerate(m['script']):
        delay = cmd[4] & 255
        clock += delay
        text = describe(cmd, DIALOGUE_BASE[i], st, dlg)
        if len(text) > 150:
            text = text[:147] + '...'
        print('   %2d t=%5ds%s +%3ds  op %2d %-18s %s' % (
            n, clock, '*' if loop_at is not None else ' ', delay, cmd[0], str(cmd[1:4] + cmd[5:]), text))
        if cmd[0] == 22:
            loop_at, retry = clock, st['room'] > 0
        elif cmd[0] == 27:
            st['room'] = 0
        elif cmd[0] == 23:
            st['room'] = 0
            if loop_at is not None and cmd[3] > 0 and not retry:
                clock += cmd[3] * (clock - loop_at)      # the body runs value+1 times
            loop_at = None
    print('   (t = game seconds if nothing waits; * = inside a loop, time of the first pass)')
    ok = m['consumed'] == m['bytes']
    print('-- consumed %d of %d bytes: %s' % (m['consumed'], m['bytes'], 'OK' if ok else 'MISMATCH'))
    return ok


def main():
    if len(sys.argv) < 2:
        sys.exit(__doc__)
    folder = sys.argv[1]
    data_dir = sys.argv[2] if len(sys.argv) > 2 else None
    dlg = load_dialogues(folder, data_dir)
    good = True
    for i in range(7):
        try:
            good &= show(parse(folder, i), dlg)
        except ValueError as e:
            print('mi%d: %s' % (i, e))
            good = False
    print('=' * 78)
    print('ALL SEVEN FILES PARSED TO THEIR EXACT LENGTH' if good else 'AT LEAST ONE FILE DID NOT PARSE CLEANLY')
    sys.exit(0 if good else 1)


if __name__ == '__main__':
    main()
