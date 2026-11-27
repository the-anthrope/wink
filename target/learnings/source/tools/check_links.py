"""Check every Markdown link in learnings/ and, with --show, print the cited source line.

usage: python3 -I check_links.py <learnings-dir> [--show] [file-substring]
"""
import sys, os, re
root = sys.argv[1]; show = '--show' in sys.argv
flt = [a for a in sys.argv[2:] if not a.startswith('--')]
bad = 0; n = 0
for dp, dn, fn in os.walk(root):
    if os.sep + 'source' + os.sep + 'decompiled' in dp + os.sep: continue
    for f in sorted(fn):
        if not f.endswith('.md'): continue
        path = os.path.join(dp, f)
        if flt and not any(x in path for x in flt): continue
        text = open(path, encoding='utf-8').read()
        for m in re.finditer(r'\]\(([^)\s]+)\)', text):
            link = m.group(1)
            if link.startswith('http'): continue
            target, _, anchor = link.partition('#')
            tp = os.path.normpath(os.path.join(dp, target)) if target else path
            n += 1
            if not os.path.exists(tp):
                bad += 1; print('MISSING', os.path.relpath(path, root), '->', link); continue
            if anchor.startswith('L') and anchor[1:].isdigit():
                lines = open(tp, encoding='utf-8', errors='replace').read().split('\n')
                ln = int(anchor[1:])
                if ln < 1 or ln > len(lines):
                    bad += 1; print('BAD LINE', os.path.relpath(path, root), '->', link); continue
                if show:
                    print('%-46s %-12s %s' % (os.path.relpath(path, root)[-46:], os.path.basename(tp) + ':' + str(ln), lines[ln-1].strip()[:110]))
print('checked', n, 'links;', bad, 'broken')
sys.exit(1 if bad else 0)
