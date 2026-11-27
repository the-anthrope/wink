"""Dump the game's table files to JSON.

usage: python3 -I tables.py <extracted-jar-dir> <out-dir>

Writes a.json (balance data: 139 byte segments + 9 short tables, little-endian
lengths and values) and d0.json (frame tables: 26 byte arrays + 18 short
arrays, big-endian) and prints the two tileset records of `ml`.
"""
import sys, os, struct, json
x, out = sys.argv[1], sys.argv[2]
rd = lambda n: open(os.path.join(x, n), 'rb').read()

# --- a : u16le length + bytes, 139 times; then 9 x (u16le count + u16le values)
d = rd('a'); p = 0; seg = []; tabs = []
for _ in range(139):
    n = struct.unpack('<H', d[p:p+2])[0]; p += 2
    seg.append(list(d[p:p+n])); p += n
for _ in range(9):
    n = struct.unpack('<H', d[p:p+2])[0]; p += 2
    tabs.append(list(struct.unpack('<%dH' % n, d[p:p+2*n]))); p += 2*n
assert p == len(d), ('a', p, len(d))
json.dump({'seg': seg, 'tables': tabs}, open(os.path.join(out, 'a.json'), 'w'))

# --- d0 : 26 x (s16be count + signed bytes), 18 x (s16be count + s16be values)
d = rd('d0'); p = 0; B = []; S = []
for _ in range(26):
    n = struct.unpack('>h', d[p:p+2])[0]; p += 2
    B.append(list(struct.unpack('>%db' % n, d[p:p+n]))); p += n
for _ in range(18):
    n = struct.unpack('>h', d[p:p+2])[0]; p += 2
    S.append(list(struct.unpack('>%dh' % n, d[p:p+2*n]))); p += 2*n
assert p == len(d), ('d0', p, len(d))
json.dump({'bytes': B, 'shorts': S}, open(os.path.join(out, 'd0.json'), 'w'))

# --- ml : tileset records
d = rd('ml'); p = 1
for i in range(d[0]):
    c = struct.unpack('>h', d[p:p+2])[0]; p += 2
    objs = struct.unpack('>%dh' % c, d[p:p+2*c]); p += 2*c
    thr = struct.unpack('>30h', d[p:p+60]); p += 60
    print('tileset', i, 'decor frame ids:', c, 'thresholds:', list(thr))
assert p == len(d), ('ml', p, len(d))
print('wrote a.json and d0.json to', out)
