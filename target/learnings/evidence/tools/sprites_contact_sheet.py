import sys,os,glob
from PIL import Image,ImageDraw
src,out=sys.argv[1],sys.argv[2]
ims=[]
for f in sorted(glob.glob(os.path.join(src,'*_color.png'))):
    idx=int(os.path.basename(f)[:3])
    im=Image.open(f).convert('RGBA')
    af=f.replace('_color','_alpha')
    if os.path.exists(af):
        a=Image.open(af).convert('RGB').split()[2]   # blue channel = alpha, per loader
        im.putalpha(a)
    im.save(os.path.join(src,'%03d_merged.png'%idx))
    ims.append((idx,im))
def sheet(sel,name,W=1100,bg=(70,70,90,255)):
    x=y=4;rowh=0;pos=[]
    for idx,im in sel:
        if x+im.width+4>W: x=4;y+=rowh+18;rowh=0
        pos.append((idx,im,x,y));x+=im.width+6;rowh=max(rowh,im.height)
    H=y+rowh+20
    S=Image.new('RGBA',(W,H),bg);d=ImageDraw.Draw(S)
    for idx,im,x,y in pos:
        S.alpha_composite(im,(x,y+12));d.text((x,y),str(idx),fill=(255,255,0,255))
    S.convert('RGB').save(name)
    print(name,S.size)
sheet(ims[:16],os.path.join(out,'sheet_a.png'))
sheet(ims[16:],os.path.join(out,'sheet_b.png'))
