import sys,struct,json
data=open(sys.argv[1],'rb').read()
pos=0;ents=[]
while pos+2<=len(data):
    n=struct.unpack('>H',data[pos:pos+2])[0];pos+=2
    raw=data[pos:pos+n];pos+=n
    try: s=raw.decode('utf-8')
    except Exception: s=raw.decode('utf-8','replace')
    ents.append(s)
kv=[]
for s in ents:
    i=s.find(':')
    kv.append((s[:i],s[i+2:]) if i>=0 else (None,s))
json.dump(kv,open(sys.argv[2],'w'),ensure_ascii=False,indent=0)
print("entries",len(ents),"consumed",pos,"of",len(data))
cfg=[(k,v) for k,v in kv if k and not (k[0]=='T' and len(k)>2 and k[2]=='_')]
txt=[(k,v) for k,v in kv if k and (k[0]=='T' and len(k)>2 and k[2]=='_')]
print("config keys",len(cfg),"text keys",len(txt))
for k,v in cfg: print("  %s: %s"%(k,v[:160]))
