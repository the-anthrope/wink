import sys,os,struct
src,out=sys.argv[1],sys.argv[2]
os.makedirs(out,exist_ok=True)
d=open(src,'rb').read();p=0;n=0;rows=[]
while p<len(d):
    b=d[p]
    if b==255: rows.append(('END',p));break
    L=(d[p]<<16)|(d[p+1]<<8)|d[p+2];p+=3
    blob=d[p:p+L];p+=L
    kind='color' if n%2==0 else 'alpha'
    w=h=None
    if L>=24 and blob[:8]==b'\x89PNG\r\n\x1a\n':
        w,h=struct.unpack('>II',blob[16:24])
        open(os.path.join(out,'%03d_%s.png'%(n//2,kind)),'wb').write(blob)
    rows.append((n//2,kind,L,w,h))
    n+=1
print('slots',n,'consumed',p,'of',len(d))
for r in rows: print(r)
