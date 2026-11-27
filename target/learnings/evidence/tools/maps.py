import sys,os,struct,json
from PIL import Image,ImageDraw
x,out=sys.argv[1],sys.argv[2]
data=sys.argv[3] if len(sys.argv)>3 else out
def rd(n): return open(os.path.join(x,n),'rb').read()
# ml
d=rd('ml');p=1;ML=[]
for i in range(d[0]):
    c=struct.unpack('>h',d[p:p+2])[0];p+=2
    a_=list(struct.unpack('>%dh'%c,d[p:p+2*c]));p+=2*c
    b_=list(struct.unpack('>30h',d[p:p+60]));p+=60
    ML.append((a_,b_))
print('ml: tilesets',len(ML),'consumed',p,'of',len(d))
for i,(a_,b_) in enumerate(ML): print('  tileset',i,'objs',len(a_),'thresholds',b_[:16])
class R:
    def __init__(s,b): s.b=b;s.p=0
    def u(s,n=1):
        v=int.from_bytes(s.b[s.p:s.p+n],'big');s.p+=n;return v
def terrain(r):
    w,h=r.u(),r.u();ts=r.u();thr=ML[ts][1]
    g=[[0]*w for _ in range(h)];blk=[[0]*w for _ in range(h)]
    n=r.u(2);i=j=0
    for _ in range(n):
        c,v=r.u(),r.u()
        for _ in range(c):
            if i<h: g[i][j]=v
            j+=1
            if j>=w: j-=w;i+=1
    no=r.u(2);objs=[]
    for _ in range(no): objs.append((r.u(),r.u(),r.u()))
    rows=[]
    for _ in range(h):
        rows.append([r.u(4) for _ in range((w-1)//32+1)])
    return dict(w=w,h=h,ts=ts,ground=g,objs=objs,runs=n,mask=rows)
BN=['Command center','Generator','Infantry center','Machine factory','Technology center','Bunker','Locator','Rocket launcher','Headquarters','Powerplant','Barracks','Factory','Laboratory','Bunker(R)','Tower']
MN=['Pucallpa','Ucayali Bank','Miguel Capture','Outpost','Slaughter','Storm In Gorge','The Last Battle']
summary=[]
for mi in range(7):
    b=rd('mi%d'%mi);r=R(b);mapid=struct.unpack('b',bytes([r.u()]))[0]
    if mapid>=0:
        t=terrain(R(rd('m%d'%mapid)))
    else:
        t=terrain(r)
    ne=r.u();ents=[(r.u(),r.u(),r.u(),r.u()) for _ in range(ne)]
    bl=[e for e in ents if e[0]<15];un=[e for e in ents if e[0]>=15]
    zones=[[ [tuple(r.u() for _ in range(4)) for _ in range(r.u())] for _ in range(3)] for _ in range(2)]
    info=dict(mission=mi+1,name=MN[mi],map_file=('m%d'%mapid if mapid>=0 else 'inline'),w=t['w'],h=t['h'],tileset=t['ts'],decor=len(t['objs']),
        bld_conf=[BN[e[0]] for e in bl if e[0]<8],bld_reb=[BN[e[0]] for e in bl if e[0]>=8],wall_tiles=len(un),mi_bytes=len(b),parsed_to=r.p)
    summary.append(info)
    print(info)
    # schematic render
    S=6;im=Image.new('RGB',(t['w']*S,t['h']*S));dr=ImageDraw.Draw(im)
    thr=ML[t['ts']][1]
    pal=[(60,110,50),(90,130,60),(120,110,60),(110,90,50),(70,100,70),(40,70,110),(30,60,100),(80,80,80)]
    for i in range(t['h']):
        for j in range(t['w']):
            v=t['ground'][i][j];k=0
            for q in range(13):
                if v>=thr[q]: k=q
            c=pal[min(k,len(pal)-1)] if v<thr[13] else (25,50,95)
            dr.rectangle([j*S,i*S,j*S+S-1,i*S+S-1],fill=c)
    for (o,ox,oy) in t['objs']:
        dr.rectangle([ox*S+1,oy*S+1,ox*S+S-2,oy*S+S-2],fill=(20,60,20))
    for (ty,ex,ey,f) in ents:
        if ty<15:
            c=(60,140,255) if ty<8 else (255,70,60)
            dr.rectangle([ex*S-S,ey*S-S,ex*S+S,ey*S+S],fill=c,outline=(255,255,255))
        else:
            c=(150,210,255) if (ty-15)//10==0 else (255,170,150)  # types 15 / 25 are wall tiles of side 0 / 1
            dr.ellipse([ex*S,ey*S,ex*S+S-1,ey*S+S-1],fill=c)
    im.save(os.path.join(out,'map_m%d.png'%(mi+1)))
json.dump(summary,open(os.path.join(out,'missions.json'),'w'),indent=1)
# stats tables
a=json.load(open(os.path.join(data,'a.json')));seg=a['seg'];T=a['tables']
sb=lambda v:v-256 if v>127 else v
names=['Assault','Heavy Assault','Flame Assault','AV-40 Fortress','T-21 Hammer','T-22 Zeus','MLRS Torrent','Infantry','Grenadier','Sniper','Coyote','Armadillo','Rhino','Porcupine']
print('\nUNIT           side   cost  hp  attack armour speed(10-x) sight range')
for i,nm in enumerate(names):
    t_=seg[92][i]
    print('%-15s %-6s %4d %4d %5d %5d %6d %8d %5d'%(nm,'Conf' if i<7 else 'Rebel',T[5][t_],seg[42][t_],seg[31][t_],seg[29][t_],10-seg[27][t_],seg[28][t_],seg[30][t_]))
print('\nBUILDING cost / energy(seg61)')
for i,nm in enumerate(BN+['Wall']): print('  %-18s %4d  %d'%(nm,T[6][i],seg[61][i]))
RN=['Energy suit','Bio suit','Enhanced firing rate','Armour-piercing bullet','Forced light missiles','"Lava" flame fuel','"Volcano" flame gun','Heavy shells','Reinforced engine','Energy armour','Damage diagnostics','Fast recharging','T-22 rocket launcher','Torrent-5 MRLS','Torrent-10 MRLS','Reinforced generator','Titanium cover','Walls Active armour','Alarm System','Infantry express-training','Upgraded assembly line','Finance department','Incentive system','Communications system']
print('\nRESEARCH cost'); print('  '+', '.join('%s %d'%(n,T[7][i]) for i,n in enumerate(RN)))
print('rank caps units',seg[130],'facilities',seg[131])
