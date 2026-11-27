#!/usr/bin/env python3
"""Slice and compose sprites of Art Of War 2 from the `d0` frame tables.

Usage (run with `python3 -I`):

    frames.py SHEETS_DIR D0_JSON OUT_DIR                 # write the proof images
    frames.py SHEETS_DIR D0_JSON OUT_DIR strip NAME KIND ID[,ID...] [COLS]
    frames.py SHEETS_DIR D0_JSON OUT_DIR info KIND ID

SHEETS_DIR holds the sheets extracted from `i0` as NNN_merged.png (colour with
the alpha mask already applied). D0_JSON is the JSON dump of `d0`
({"bytes": [26 arrays], "shorts": [18 arrays]}).

KIND is one of: piece, frame, anim (all frames of one animation), pose,
seq (all poses of one unit sequence), object.

The table layout below mirrors the drawing code in g.java
(d() 7102, a() 7085, n() 7068, c() 7003, a(int x5) 6805):

  piece     B0 sheet, B1 x, B2 y, B3 w, B4 h, B5 colour index (unsigned bytes)
            sheets 43..46 are not images: line, rect outline, filled rect,
            rect outline with all numbers x4
  frame     S0 first part, S1 last part (inclusive) ->
            S2 child id, S3 dx, S4 dy, B6 child kind (0 piece, 1 frame)
  anim      S5 first step, S6 last step -> S7 frame id, B7 dx, B8 dy, B9 kind
  pose      S8 first part, S9 last part ->
            S10 id, B10 dx, B11 dy, B12 kind (0 piece, 1 frame, 2 anim),
            B13 layer (1 hull, 0 turret, 3/4/5 muzzle-flash animations)
  sequence  S11 first, S12 last -> S13 pose id, B15 dx, B16 dy
  object    S14 first part, S15 last part ->
            S16 id, S17 dx, B20 dy, B23 kind, B24 pass (0 ground, 1 upper,
            2 special), B25 condition; B18/B19 = size in map cells
"""
import json
import os
import sys

from PIL import Image, ImageDraw

BG = (88, 92, 104, 255)       # neutral background
CELL = (30, 20)               # one map cell in pixels
PALETTE = [0x000000, 0x324B64, 0x649383, 0x7DD7F4, 0xFF0000]   # n.java


def u(v):
    return v & 255


class Tables:
    def __init__(self, sheets_dir, d0_json):
        with open(d0_json) as fh:
            d = json.load(fh)
        self.B = d["bytes"]
        self.S = d["shorts"]
        self.sheets = {}
        self.dir = sheets_dir

    # ---- counts -----------------------------------------------------
    def counts(self):
        B, S = self.B, self.S
        return {"pieces": len(B[0]), "frames": len(S[0]), "frame parts": len(S[2]),
                "animations": len(S[5]), "animation steps": len(S[7]),
                "poses": len(S[8]), "pose parts": len(S[10]),
                "sequences": len(S[11]), "sequence steps": len(S[13]),
                "objects": len(S[14]), "object parts": len(S[16])}

    def sheet(self, n):
        if n not in self.sheets:
            path = os.path.join(self.dir, "%03d_merged.png" % n)
            self.sheets[n] = Image.open(path).convert("RGBA")
        return self.sheets[n]

    # ---- op builders: every op is (kind, x, y, payload) --------------
    def piece(self, i, x, y, ops, red=False):
        B = self.B
        sh = u(B[0][i])
        px, py = x + 15, y + 10                     # g.java:7110-7111
        bx, by, bw, bh = u(B[1][i]), u(B[2][i]), u(B[3][i]), u(B[4][i])
        if sh >= 43:                                # primitives, g.java:7117-7131
            col = PALETTE[u(B[5][i]) % len(PALETTE)]
            ops.append(("prim", px, py, (sh, bx, by, bw, bh, col)))
            return
        if sh == 8 and red:                         # side 1 infantry, g.java:7134
            sh = 9
        if bw == 0 or bh == 0:
            return
        ops.append(("img", px, py, self.sheet(sh).crop((bx, by, bx + bw, by + bh))))

    def frame(self, i, x, y, ops, red=False):
        S, B = self.S, self.B
        for j in range(S[0][i], S[1][i] + 1):
            cx, cy = x + S[3][j], y + S[4][j]
            if B[6][j] == 0:
                self.piece(S[2][j], cx, cy, ops, red)
            else:
                self.frame(S[2][j], cx, cy, ops, red)

    def anim_len(self, i):
        return self.S[6][i] - self.S[5][i] + 1

    def anim(self, i, tick, x, y, ops, red=False):
        S, B = self.S, self.B
        j = S[5][i] + tick % self.anim_len(i)       # g.java:7070
        if B[9][j] == 0:
            self.piece(S[7][j], x + B[7][j], y + B[8][j], ops, red)
        else:
            self.frame(S[7][j], x + B[7][j], y + B[8][j], ops, red)

    def pose(self, i, x, y, ops, turret=0, fire=None, tick=0, red=False,
             layers=(0, 1, 2)):
        """turret = turret direction minus hull direction (added to the ids
        of layer 0/2/4/5 parts). fire = animation tick of the muzzle flash
        (None = not firing)."""
        S, B = self.S, self.B
        hide = set()
        for j in range(S[8][i], S[9][i] + 1):
            lay, kind, pid = B[13][j], B[12][j], S[10][j]
            if lay in hide:
                continue
            if lay >= 3 and fire is None:
                continue
            if lay < 3 and lay not in layers:
                continue
            if lay in (0, 2, 4, 5):
                pid += turret
            px, py = x + B[10][j], y + B[11][j]
            if kind == 0:
                self.piece(pid, px, py, ops, red)
            elif kind == 1:
                self.frame(pid, px, py, ops, red)
            elif lay <= 2:
                self.anim(pid, tick, px, py, ops, red)
            elif fire < self.anim_len(pid):
                hide.add({3: 1, 4: 0, 5: 2}[lay])   # a.json seg[54]
                self.anim(pid, fire, px, py, ops, red)

    def seq_len(self, i):
        return self.S[12][i] - self.S[11][i] + 1

    def seq(self, i, step, x, y, ops, **kw):
        S, B = self.S, self.B
        j = S[11][i] + step
        self.pose(S[13][j], x + B[15][j], y + B[16][j], ops, **kw)

    def obj(self, i, x, y, ops, passes=(0, 1), stage=4, tick=0, working=True,
            off=False, turret=0, fire=None, shadows=True):
        """Draw a map object (building 0..14, wall/decor 15..132).
        Mirrors g.java:6805-6979. stage = damage stage 4 (intact) .. 7
        (almost destroyed) from g.java:6809. working = powered, finished and
        (for factories) producing: only then kind-2 animations play.
        off = draw the condition-10 "switched off" frames. turret/fire are
        for bunkers and towers (direction 0..7, flash tick or None)."""
        S, B = self.S, self.B
        for j in range(S[14][i], S[15][i] + 1):
            kind, pas, c, pid = B[23][j], B[24][j], B[25][j], S[16][j]
            px, py = x + S[17][j], y + B[20][j]
            if pas == 2:
                if 1 not in passes or i >= 15:
                    continue
                if c == 1 and kind == 2 and fire is not None:
                    self.anim(pid + turret, fire, px, py, ops)
                elif c == 2 and kind == 1:
                    self.frame(pid + turret, px, py, ops)
                elif c == 10 and kind == 1 and off:
                    self.frame(pid, px, py, ops)
                continue
            if pas not in passes:
                continue
            if c > 0 and not ((pas == 0 and c == stage) or (pas == 1 and c <= stage)):
                continue
            if kind == 0:
                if pid < 2095 or shadows:
                    self.piece(pid, px, py, ops)
            elif kind == 1:
                if pid < 2257 or shadows:
                    self.frame(pid, px, py, ops)
            elif working and not off:
                self.anim(pid, tick + i, px, py, ops)


# ---- rendering -------------------------------------------------------
def bbox(ops):
    x0 = y0 = 10 ** 9
    x1 = y1 = -10 ** 9
    for kind, x, y, p in ops:
        if kind == "img":
            w, h = p.size
        else:
            sh, bx, by, bw, bh, _ = p
            if sh == 43:
                x, y, w, h = x + min(bx, bw), y + min(by, bh), abs(bw - bx) + 1, abs(bh - by) + 1
            elif sh == 46:
                x, y, w, h = x + bx * 4, y + by * 4, bw * 4 + 1, bh * 4 + 1
            else:
                x, y, w, h = x + bx, y + by, bw + 1, bh + 1
        x0, y0, x1, y1 = min(x0, x), min(y0, y), max(x1, x + w), max(y1, y + h)
    if x1 < x0:
        return (0, 0, 1, 1)
    return (x0, y0, x1, y1)


def paint(canvas, ops, ox, oy):
    dr = ImageDraw.Draw(canvas)
    for kind, x, y, p in ops:
        if kind == "img":
            canvas.alpha_composite(p, (x + ox, y + oy))
            continue
        sh, bx, by, bw, bh, col = p
        rgb = ((col >> 16) & 255, (col >> 8) & 255, col & 255, 255)
        X, Y = x + ox, y + oy
        if sh == 43:
            dr.line((X + bx, Y + by, X + bw, Y + bh), fill=rgb)
        elif sh == 44:
            dr.rectangle((X + bx, Y + by, X + bx + bw, Y + by + bh), outline=rgb)
        elif sh == 45:
            dr.rectangle((X + bx, Y + by, X + bx + bw - 1, Y + by + bh - 1), fill=rgb)
        else:
            dr.rectangle((X + bx * 4, Y + by * 4, X + (bx + bw) * 4, Y + (by + bh) * 4), outline=rgb)


def strip(cells, path, cols=8, title=None, scale=1, pad=4, same_box=True):
    """cells = [(label, ops)]. All cells share one bounding box so that the
    anchor point stays at the same place in every cell."""
    boxes = [bbox(o) for _, o in cells]
    if same_box:
        b = (min(b[0] for b in boxes), min(b[1] for b in boxes),
             max(b[2] for b in boxes), max(b[3] for b in boxes))
        boxes = [b] * len(cells)
    lab_h = 11
    cw = max(max(b[2] - b[0] for b in boxes), max(6 * len(l) for l, _ in cells)) + 2 * pad
    ch = max(b[3] - b[1] for b in boxes) + 2 * pad + lab_h
    rows = (len(cells) + cols - 1) // cols
    top = 14 if title else 0
    W, H = cw * min(cols, len(cells)), ch * rows + top
    art = Image.new("RGBA", (W, H), BG)
    for k, ((label, ops), b) in enumerate(zip(cells, boxes)):
        cx, cy = (k % cols) * cw, (k // cols) * ch + top
        paint(art, ops, cx + pad - b[0], cy + pad - b[1])
    if scale != 1:
        art = art.resize((W * scale, H * scale), Image.NEAREST)
    dr = ImageDraw.Draw(art)
    if title:
        dr.text((3, 1), title, fill=(255, 255, 255, 255))
    for k, (label, _) in enumerate(cells):
        cx, cy = (k % cols) * cw, (k // cols) * ch + top
        dr.rectangle((cx * scale, cy * scale, (cx + cw) * scale - 1, (cy + ch) * scale - 1),
                     outline=(60, 62, 72, 255))
        dr.text((cx * scale + 3, (cy + ch - lab_h) * scale + (scale - 1) * 9), label,
                fill=(235, 235, 160, 255))
    art = art.convert("RGB").quantize(colors=128, method=Image.MEDIANCUT)
    art.save(path, optimize=True)
    print("%s %dx%d %d bytes" % (path, art.width, art.height, os.path.getsize(path)))


def rows(rws, path, title=None, pad=3, max_w=None):
    """rws = [(label, [ops, ops, ...])]. One animation per row. Inside a row
    every step uses the row's common bounding box, so movement between
    steps is the real per-step offset from the tables."""
    lab_w = max(6 * len(l) for l, _ in rws) + 8
    geo = []
    W, H = 0, (14 if title else 0)
    for label, steps in rws:
        bs = [bbox(o) for o in steps]
        b = (min(x[0] for x in bs), min(x[1] for x in bs),
             max(x[2] for x in bs), max(x[3] for x in bs))
        cw, ch = b[2] - b[0] + 2 * pad, max(b[3] - b[1] + 2 * pad, 12)
        geo.append((b, cw, ch, H))
        W = max(W, lab_w + cw * len(steps))
        H += ch
    art = Image.new("RGBA", (W, H), BG)
    dr = ImageDraw.Draw(art)
    if title:
        dr.text((3, 1), title, fill=(255, 255, 255, 255))
    for (label, steps), (b, cw, ch, y) in zip(rws, geo):
        dr.line((0, y, W, y), fill=(60, 62, 72, 255))
        dr.text((3, y + ch // 2 - 5), label, fill=(235, 235, 160, 255))
        for k, ops in enumerate(steps):
            paint(art, ops, lab_w + k * cw + pad - b[0], y + pad - b[1])
    art = art.convert("RGB").quantize(colors=128, method=Image.MEDIANCUT)
    art.save(path, optimize=True)
    print("%s %dx%d %d bytes" % (path, art.width, art.height, os.path.getsize(path)))


DIRS = ["0 E", "1 SE", "2 S", "3 SW", "4 W", "5 NW", "6 N", "7 NE"]


def generic(t, kind, ids):
    cells = []
    for i in ids:
        if kind == "piece":
            ops = []; t.piece(i, 0, 0, ops); cells.append(("p%d" % i, ops))
        elif kind == "frame":
            ops = []; t.frame(i, 0, 0, ops); cells.append(("f%d" % i, ops))
        elif kind == "anim":
            for k in range(t.anim_len(i)):
                ops = []; t.anim(i, k, 0, 0, ops); cells.append(("a%d.%d" % (i, k), ops))
        elif kind == "pose":
            ops = []; t.pose(i, 0, 0, ops); cells.append(("po%d" % i, ops))
        elif kind == "seq":
            for k in range(t.seq_len(i)):
                ops = []; t.seq(i, k, 0, 0, ops); cells.append(("s%d.%d" % (i, k), ops))
        elif kind == "object":
            ops = []; t.obj(i, 0, 0, ops); cells.append(("o%d" % i, ops))
    return cells


def _frames(t, a, b):
    out = []
    for f in range(a, b):
        ops = []; t.frame(f, 0, 0, ops); out.append(ops)
    return out


def _anim(t, a):
    out = []
    for k in range(t.anim_len(a)):
        ops = []; t.anim(a, k, 0, 0, ops); out.append(ops)
    return out


def _seq(t, s, **kw):
    out = []
    for k in range(t.seq_len(s)):
        ops = []; t.seq(s, k, 0, 0, ops, **kw); out.append(ops)
    return out


def proofs(t, out):
    j = lambda n: os.path.join(out, n)
    # 1. infantry walk cycle, 8 directions x 4 steps (sequences 134..141)
    cells = []
    for d in range(8):
        for k in range(4):
            ops = []; t.seq(134 + d, k, 0, 0, ops)
            cells.append(("%s.%d" % (DIRS[d], k), ops))
    strip(cells, j("infantry-walk.png"), cols=8, scale=2,
          title="Assault / Infantry walk: sequences 134..141 (one per direction), 4 steps each")
    # 2. the two team sheets and the fire pose
    cells = []
    for d in range(8):
        ops = []; t.seq(150 + d, 0, 0, 0, ops, fire=0)
        cells.append(("blue %d" % d, ops))
    for d in range(8):
        ops = []; t.seq(150 + d, 0, 0, 0, ops, fire=0, red=True)
        cells.append(("red %d" % d, ops))
    for k, (lab, kw) in enumerate([("legs L1", dict(layers=(1,))), ("+torso L0", {}),
                                   ("torso +1", dict(turret=1)), ("torso +2", dict(turret=2)),
                                   ("flash t0", dict(fire=0)), ("flash t1", dict(fire=1)),
                                   ("flash t2", dict(fire=2)), ("flash t3", dict(fire=3))]):
        ops = []; t.seq(142, 0, 0, 0, ops, **kw)
        cells.append((lab, ops))
    strip(cells, j("infantry-fire-teams.png"), cols=8, scale=2,
          title="Rows 1-2: aim sequences 150..157 from sheet 8 and sheet 9. Row 3: layers of idle sequence 142")
    # 3. vehicle: hull only, hull+turret, turret turned, firing
    cells = []
    for d in range(8):
        ops = []; t.seq(24 + d, 0, 0, 0, ops, layers=(1,))
        cells.append(("hull %d" % d, ops))
    for d in range(8):
        ops = []; t.seq(24 + d, 0, 0, 0, ops)
        cells.append(("+turret %d" % d, ops))
    for d in range(8):
        ops = []; t.seq(24, 0, 0, 0, ops, turret=d)
        cells.append(("hull0 tur%d" % d, ops))
    for k in range(6):
        ops = []; t.seq(24, 0, 0, 0, ops, turret=1, fire=k)
        cells.append(("fire t%d" % k, ops))
    strip(cells, j("tank-hull-turret.png"), cols=8, scale=2,
          title="T-21 Hammer (type 9), sequences 24..31: layer 1 hull, layer 0 turret, layer 4 flash animation 109+dir")
    # 4. buildings
    cells = []
    for lab, kw in [("base pass0", dict(passes=(0,))), ("top pass1", dict(passes=(1,))),
                    ("working t0", {}), ("working t3", dict(tick=3)), ("off", dict(off=True)),
                    ("stage 5", dict(stage=5)), ("stage 6", dict(stage=6)), ("stage 7", dict(stage=7))]:
        ops = []; t.obj(1, 0, 0, ops, **kw); cells.append(("Gen " + lab, ops))
    for d in range(8):
        ops = []; t.obj(7, 0, 0, ops, turret=d, fire=(1 if d == 0 else None))
        cells.append(("Launcher d%d" % d, ops))
    for lab, kw in [("working t0", {}), ("working t2", dict(tick=2)), ("working t4", dict(tick=4)),
                    ("off", dict(off=True)), ("no shadows", dict(shadows=False)),
                    ("stage 5", dict(stage=5)), ("stage 6", dict(stage=6)), ("stage 7", dict(stage=7))]:
        ops = []; t.obj(12, 0, 0, ops, **kw); cells.append(("Lab " + lab, ops))
    strip(cells, j("building-states.png"), cols=8,
          title="Objects 1 (Generator), 7 (Rocket launcher, turret frame 1221+dir), 12 (Rebel Laboratory)")
    # 5. effects
    rows([("a11 vehicle blast", _anim(t, 11)), ("a21 shell hit", _anim(t, 21)),
          ("a27 debris", _anim(t, 27)), ("a39 dirt", _anim(t, 39)),
          ("a45 blood", _anim(t, 45)), ("a51 sparks", _anim(t, 51)),
          ("a59 flame jet", _anim(t, 59)), ("a37 building blast", _anim(t, 37))],
         j("explosion-sequences.png"),
         title="Effect animations: one row per animation id, one column per 100 ms tick")
    # 6. deaths
    rows([("s231 shot", _seq(t, 231)), ("s247 crushed", _seq(t, 247)),
          ("s249 blast", _seq(t, 249)), ("s259 burned", _seq(t, 259)),
          ("s231 red", _seq(t, 231, red=True))],
         j("infantry-deaths.png"),
         title="Death sequences (state 10+): one pose per 100 ms tick, the body fades into the ground")
    # 7. projectiles and ground decals
    rows([("tracer 1277+", _frames(t, 1277, 1309)), ("shell 1373+", _frames(t, 1373, 1405)),
          ("rocket 1421+", _frames(t, 1421, 1437)), ("trail 1447+", _frames(t, 1447, 1454)),
          ("ruin kind 0", _frames(t, 1741, 1747)), ("crater kind 6", _frames(t, 1773, 1784)),
          ("crater kind 9", _frames(t, 1802, 1811))],
         j("projectiles-decals.png"),
         title="Projectile frames (32 or 16 directions) and ground decals painted into the background")
    # 8. UI
    rows([("a270 dialog open", _anim(t, 270)), ("a290 portrait on", _anim(t, 290)),
          ("a246 move order", _anim(t, 246)), ("a248 attack order", _anim(t, 248)),
          ("a261 select", _anim(t, 261)), ("a269 no power", _anim(t, 269)),
          ("f1811-13 rings", _frames(t, 1811, 1814)), ("f1851-53 fog", _frames(t, 1851, 1854)),
          ("f1854-62 HP bars", _frames(t, 1854, 1863))],
         j("ui-animations.png"), title="UI animations and marker frames")


def main(argv):
    if len(argv) < 4:
        print(__doc__)
        return 2
    t = Tables(argv[1], argv[2])
    out = argv[3]
    os.makedirs(out, exist_ok=True)
    if len(argv) == 4:
        for k, v in t.counts().items():
            print("%-16s %d" % (k, v))
        proofs(t, out)
        return 0
    if argv[4] == "strip":
        name, kind = argv[5], argv[6]
        ids = []
        for part in argv[7].split(","):
            if "-" in part:
                a, b = part.split("-")
                ids += list(range(int(a), int(b) + 1))
            else:
                ids.append(int(part))
        cols = int(argv[8]) if len(argv) > 8 else 8
        scale = int(argv[9]) if len(argv) > 9 else 1
        strip(generic(t, kind, ids), os.path.join(out, name + ".png"), cols=cols, scale=scale)
        return 0
    return 2


if __name__ == "__main__":
    sys.exit(main(sys.argv))
