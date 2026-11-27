package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreFullException;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:g.class */
public final class g {
    private boolean i;
    int a;
    private int m;
    private int n;
    private int o;
    int b;
    private int p;
    private int q;
    private int r;
    private int s;
    int c;
    private boolean j;
    private boolean k;
    private int t;
    int d;
    int e;
    int f;
    private boolean l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    boolean f86a;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private byte f87n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    private byte f88o;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    byte f89a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    byte f90b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    byte f91c;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    private byte f92p;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    private byte f93q;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    private byte f94r;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    short f95a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private short f96d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private short f97e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private short f98f;
    private int u;
    private int v;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    private byte f99s;

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    private byte f100t;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private byte f101u;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    byte f102d;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private boolean f103m;
    private short g;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    byte f104e;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    short f105b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    short f106c;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private byte f107v;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private boolean f108n;
    private short h;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    private short f109i;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    private boolean f111o;
    private int A;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    int f113g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    int f114h;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    int f115i;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private static byte f117w;

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    private static byte f118x = 100;

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    private static byte f119y;

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    private static byte f120z;

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    private static byte f121A;

    /* JADX INFO: renamed from: B, reason: collision with other field name */
    private static byte f122B;

    /* JADX INFO: renamed from: C, reason: collision with other field name */
    private static byte f123C;

    /* JADX INFO: renamed from: D, reason: collision with other field name */
    private static byte f124D;

    /* JADX INFO: renamed from: E, reason: collision with other field name */
    private static byte f125E;

    /* JADX INFO: renamed from: F, reason: collision with other field name */
    private static byte f126F;

    /* JADX INFO: renamed from: G, reason: collision with other field name */
    private static byte f127G;

    /* JADX INFO: renamed from: H, reason: collision with other field name */
    private static byte f128H;

    /* JADX INFO: renamed from: I, reason: collision with other field name */
    private static byte f129I;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String[] f130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static int[] f131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f132a;
    private static int O;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    private static boolean f133p;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    private static boolean f134q;
    private int P;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    private boolean f135r;

    /* JADX INFO: renamed from: J, reason: collision with other field name */
    private static byte f136J;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    private boolean f137s;
    private int Q;
    private int R;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    boolean f138b;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short[] f139a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private short[] f140b;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    byte f141f;

    /* JADX INFO: renamed from: K, reason: collision with other field name */
    private byte f142K;

    /* JADX INFO: renamed from: L, reason: collision with other field name */
    private byte f143L;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    int f144j;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    byte f145g;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    boolean f149c;

    /* JADX INFO: renamed from: M, reason: collision with other field name */
    private byte f150M;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    int f151k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    int f152l;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    private boolean f153t;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    byte f155h;

    /* JADX INFO: renamed from: N, reason: collision with other field name */
    private byte f156N;

    /* JADX INFO: renamed from: O, reason: collision with other field name */
    private byte f157O;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    byte f158i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    byte f159j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    byte f160k;
    private int ag;
    private int ah;
    private int ai;
    private int aj;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f161b;

    /* JADX INFO: renamed from: P, reason: collision with other field name */
    private byte f165P;

    /* JADX INFO: renamed from: Q, reason: collision with other field name */
    private byte f166Q;

    /* JADX INFO: renamed from: R, reason: collision with other field name */
    private byte f167R;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private int ap;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private boolean f168u;
    private int aq;

    /* JADX INFO: renamed from: S, reason: collision with other field name */
    private byte f169S;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int[][] f170a;
    private static int ar;
    private int as;
    private int at;
    private int au;
    private int av;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private long f172b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RecordStore f173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private DataOutputStream f174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private DataInputStream f175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private k f178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    p f179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    o f180a;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private byte[] f181v;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private short[] f182d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private short[] f183e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private short[] f184f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Graphics[] f185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[][] f186a;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private byte[] f187w;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[][] f188b;

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    private byte[] f189x;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private byte[][] f190c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private byte[][] f191d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private byte[][] f192e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private byte[][] f193f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private byte[][] f194g;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private short[][] f195b;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    boolean f196d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    boolean f197e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    boolean f198f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    boolean f199g;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static String f204d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static String f205e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static String f206f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private static String f207g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long f209a;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static long f210c;

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    private static boolean f218A;
    private int aE;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Vector f222c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private Vector f223d;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;

    /* JADX INFO: renamed from: V, reason: collision with other field name */
    private byte f225V;

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    private static final byte[] f226y;

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    private static final byte[] f227z;

    /* JADX INFO: renamed from: C, reason: collision with other field name */
    private boolean f228C;

    /* JADX INFO: renamed from: W, reason: collision with other field name */
    private byte f229W;

    /* JADX INFO: renamed from: X, reason: collision with other field name */
    private byte f230X;
    private int aL;
    private int aM;
    private int aN;
    private int aO;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    static byte f231l;

    /* JADX INFO: renamed from: Y, reason: collision with other field name */
    private static byte f232Y;
    private int aP;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    byte f235m;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    boolean f236h;

    /* JADX INFO: renamed from: F, reason: collision with other field name */
    private boolean f237F;

    /* JADX INFO: renamed from: G, reason: collision with other field name */
    private boolean f238G;

    /* JADX INFO: renamed from: H, reason: collision with other field name */
    private boolean f239H;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    private static String f240l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private static String f241m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private static String f242n;
    private static int aQ;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    static byte[] f243h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    static byte[] f244i;

    /* JADX INFO: renamed from: A, reason: collision with other field name */
    private static byte[] f245A;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    static byte[] f246j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    static byte[] f247k;

    /* JADX INFO: renamed from: B, reason: collision with other field name */
    private static byte[] f248B;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    static byte[] f249l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    static byte[] f250m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    static byte[] f251n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    static final byte[] f252o;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    static byte[] f253p;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    static byte[] f254q;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    static byte[] f255r;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    static byte[] f256s;

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    static byte[] f257t;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Random f258a;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    private static String f259o;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static int[] f260b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Object f261b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Hashtable f262a;
    private int aT;
    private static final int aU;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static final int[] f263c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    byte[] f110a = new byte[16];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    byte[] f112b = new byte[6];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    byte[] f116c = new byte[5];

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    byte[] f146d = new byte[7];

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    byte[] f147e = new byte[16];

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    byte[] f148f = new byte[2];

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    byte[] f154g = new byte[2];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private short[] f162c = new short[100];

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private byte[] f163u = new byte[100];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[][] f164a = new String[3][100];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short[][] f171a = new short[2][7];

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private boolean f176v = false;
    private int aw = -1000;

    /* JADX INFO: renamed from: T, reason: collision with other field name */
    private byte f177T = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean[] f200a = new boolean[7];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Vector f201a = new Vector(15);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private String f202c = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[][] f203b = null;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private boolean f208w = false;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    private String f211h = null;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    private String f212i = null;
    private int ax = -1;

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    private boolean f213x = false;

    /* JADX INFO: renamed from: y, reason: collision with other field name */
    private boolean f214y = false;
    private int ay = -1;

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    private boolean f215z = true;

    /* JADX INFO: renamed from: U, reason: collision with other field name */
    private byte f216U = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f217a = null;
    private int az = 0;
    private int aA = 0;
    private int aB = 0;
    private int aC = 0;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    private String f219j = null;
    private int aD = 0;

    /* JADX INFO: renamed from: B, reason: collision with other field name */
    private boolean f220B = true;
    private int aF = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Vector f221b = new Vector(4);

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    private String f224k = "/";

    /* JADX INFO: renamed from: D, reason: collision with other field name */
    private boolean f233D = false;

    /* JADX INFO: renamed from: E, reason: collision with other field name */
    private boolean f234E = false;
    private int aR = 0;
    private int aS = 0;

    public g(k kVar) {
        byte[] bArr = {56, 117, 23, 98, 41, 111, 60, 86};
        this.f196d = false;
        this.f197e = false;
        this.f198f = false;
        this.f199g = false;
        this.f261b = "186";
        this.aT = 3;
        this.f178a = kVar;
        f259o = new String(f257t);
        ar = ((k.a - 1) / 40) * 40;
        this.a = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.b = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.c = 0;
        this.j = false;
        this.t = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.l = true;
        this.f86a = false;
        this.f87n = (byte) -1;
        this.f88o = (byte) 0;
        this.aT = 10;
        this.f89a = (byte) 4;
        this.f90b = (byte) 0;
        this.f91c = (byte) 0;
        this.f92p = (byte) 0;
        this.f93q = (byte) 0;
        this.f94r = (byte) 0;
        this.f95a = (short) 0;
        this.f96d = (short) 0;
        this.f97e = (short) 0;
        this.f98f = (short) 0;
        this.u = 0;
        this.v = 0;
        this.f99s = (byte) 0;
        this.f100t = (byte) 0;
        this.f101u = (byte) 0;
        this.f102d = (byte) 0;
        this.f103m = false;
        this.g = (short) 0;
        this.f104e = (byte) 0;
        this.f105b = (short) 0;
        this.f106c = (short) 0;
        this.f107v = (byte) 0;
        this.f108n = false;
        this.h = (short) -1;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.f109i = (short) 0;
        this.A = 0;
        this.f113g = 0;
        this.f114h = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = -1;
        this.f115i = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = 27;
        this.f135r = true;
        this.f137s = true;
        this.Q = 0;
        this.R = 0;
        this.f138b = true;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f141f = (byte) 0;
        this.f142K = (byte) 0;
        this.f143L = (byte) 0;
        this.f144j = 0;
        this.f145g = (byte) 0;
        this.f149c = false;
        this.f150M = (byte) 0;
        this.f151k = 0;
        this.f152l = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 2;
        this.f153t = true;
        this.f155h = (byte) 0;
        this.f156N = (byte) 0;
        this.f157O = (byte) 0;
        this.f158i = (byte) 0;
        this.f159j = (byte) 0;
        this.f160k = (byte) 0;
        this.ag = 0;
        this.f161b = "";
        this.ah = 0;
        this.ai = 0;
        this.aj = 0;
        this.f161b = "";
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.av = 0;
        this.f172b = 0L;
        this.f165P = (byte) 0;
        this.f166Q = (byte) 0;
        this.f167R = (byte) 0;
        this.ak = 0;
        this.al = 0;
        this.am = 0;
        this.an = 0;
        this.ao = 0;
        this.ap = 0;
        this.f168u = false;
        this.f261b = new StringBuffer().append("").append(1 + Integer.parseInt((String) this.f261b)).toString();
        this.f181v = this.f178a.f295b;
        this.f182d = this.f178a.f296a;
        this.f183e = this.f178a.f297b;
        this.f184f = this.f178a.f298c;
        a.c = null;
        this.f185a = this.f178a.f283a;
        this.f189x = this.f178a.f308d;
        this.f190c = this.f178a.f302b;
        this.f192e = this.f178a.f309e;
        this.f193f = this.f178a.f310f;
        this.f191d = this.f178a.f312g;
        this.f194g = this.f178a.f299a;
        this.f195b = this.f178a.f300b;
        this.f196d = a.a(new String(f243h), 66666) > 0;
        this.f186a = this.f178a.f303c;
        this.f187w = this.f178a.f304c;
        this.f188b = this.f178a.f305d;
        this.f197e = a.a(new String(f246j), m51a()) > 0;
        for (int i = 0; i < this.f110a.length; i++) {
            this.f110a[i] = -1;
        }
        this.f198f = a.a(new String(f249l), m51a() << 1) > 0;
        this.W = 20;
        this.f199g = a.a(new String(f250m), 99999) > 0 || a.a(new String(f252o), 9843) > 0;
        this.f170a = new int[4][12];
        this.f167R = (byte) -1;
        this.f235m = (byte) -1;
        this.f236h = true;
        this.f237F = false;
    }

    private boolean b() {
        this.f179a.a();
        this.aD = 5;
        if (!a(this.b)) {
            a(o.f384a[3][18], new StringBuffer().append("10").append(f260b[2]).toString(), 0, false, true, 0, false, true);
            return false;
        }
        if (f209a > f210c && (a.c != null || this.f196d || this.f197e || this.f198f || this.f199g || p.f525a == null)) {
            k.f278b = (short) 5;
            k.a = (short) 5;
            this.f178a = null;
        }
        this.f112b[0] = this.f181v[this.f182d[129] + Math.min(this.b, 7)];
        for (int i = 1; i < 6; i++) {
            this.f112b[i] = 0;
        }
        this.f113g = 0;
        for (int i2 = 0; i2 < this.f146d.length; i2++) {
            this.f146d[i2] = this.f181v[this.f182d[124] + i2];
        }
        for (int i3 = 0; i3 < this.f147e.length; i3++) {
            this.f147e[i3] = this.f181v[this.f182d[125] + i3];
        }
        this.f = 2;
        this.e = 2;
        this.g = (short) -1;
        this.f94r = (byte) -1;
        this.f98f = (short) -1;
        this.f96d = (short) 0;
        this.f95a = (short) 0;
        this.f144j = 0;
        this.f105b = (short) -1;
        this.h = (short) -1;
        this.f102d = (byte) -1;
        this.f90b = this.f189x[5253];
        this.f91c = this.f189x[5354];
        m47d();
        this.f141f = (byte) -1;
        for (int i4 = 0; i4 < this.f110a.length; i4++) {
            this.f110a[i4] = -1;
        }
        this.f109i = (short) 0;
        this.f145g = (byte) -1;
        this.f178a.f311c[this.f178a.f315j][4] = 1000;
        this.f160k = (byte) -1;
        this.f159j = (byte) -1;
        this.f155h = (byte) -1;
        this.f106c = (short) -1;
        byte[] bArr = this.f154g;
        this.f154g[1] = 20;
        bArr[0] = 20;
        this.f148f[0] = 15;
        this.f148f[1] = 25;
        if (this.l) {
            for (int i5 = 0; i5 < 48; i5++) {
                if ((this.f179a.f414a & (1 << i5)) != 0) {
                    this.f179a.c(i5);
                }
            }
        }
        switch (this.b) {
            case 0:
                this.f158i = (byte) 1;
                break;
            case 1:
                this.f158i = (byte) 11;
                break;
            case 2:
                this.f158i = (byte) 15;
                break;
            case 3:
                this.f158i = (byte) 18;
                break;
            case 4:
                this.f158i = (byte) 20;
                break;
            case 5:
                this.f158i = (byte) 26;
                break;
            case 6:
                this.f158i = (byte) 28;
                break;
            default:
                this.f158i = (byte) 32;
                break;
        }
        this.j = false;
        if (f209a > f210c && (i.f269a[0] > 0 || i.f269a[1] > 0 || i.f269a[2] > 0 || i.f269a[3] > 0)) {
            this.f178a = null;
            this.f179a = null;
        }
        this.f178a.f317e = 0;
        this.ag = -100;
        this.C = 0;
        this.f111o = false;
        return true;
    }

    private boolean a(int i) {
        if (a.f8d) {
            d.b();
        }
        f210c = m51a() << 1;
        if (i > ((long[]) f262a.get(this.f261b))[2]) {
            this.aD += i + 14;
        } else {
            this.aD -= 5;
        }
        if (i <= 6) {
            this.f178a.b(new StringBuffer().append("mi").append(i).toString());
        } else if (!m48b(i)) {
            return false;
        }
        long[] jArr = (long[]) f262a.get(this.f261b);
        int i2 = this.aT;
        jArr[i2] = jArr[i2] + ((long) this.aD);
        a.e();
        this.ah = 0;
        byte bM43a = (byte) m43a(1);
        try {
            if (bM43a >= 0) {
                this.f178a.b(new StringBuffer().append("m").append((int) bM43a).toString());
                this.ah = 0;
                j();
                this.f178a.b(new StringBuffer().append("mi").append(i).toString());
                this.ah = 1;
            } else {
                j();
            }
            int iM43a = m43a(1);
            byte[][] bArr = new byte[4][51];
            bArr[0][50] = 0;
            for (int i3 = 0; i3 < iM43a; i3++) {
                int iM43a2 = m43a(1);
                int iM43a3 = m43a(1);
                int iM43a4 = m43a(1);
                int iM43a5 = m43a(1);
                if (iM43a3 >= 0 && iM43a4 >= 0 && iM43a3 < this.f179a.a && iM43a4 < this.f179a.b) {
                    if (this.l) {
                        if (iM43a2 >= 15) {
                            this.f195b[iM43a4][iM43a3] = (short) (1001 + (100 * ((iM43a2 - 15) / 10)) + (((iM43a2 - 15) % 5) * 20));
                        } else {
                            a((byte) iM43a2, iM43a3, iM43a4, iM43a2 / 8, iM43a5, true);
                        }
                    }
                    if (iM43a2 < 15 && iM43a2 / 8 == this.f178a.f316d) {
                        bArr[0][bArr[0][50]] = (byte) iM43a2;
                        bArr[1][bArr[0][50]] = (byte) iM43a3;
                        bArr[2][bArr[0][50]] = (byte) iM43a4;
                        bArr[3][bArr[0][50]] = (byte) iM43a5;
                        byte[] bArr2 = bArr[0];
                        bArr2[50] = (byte) (bArr2[50] + 1);
                    }
                }
            }
            for (int i4 = 0; i4 < 2; i4++) {
                for (int i5 = 0; i5 < 3; i5++) {
                    this.f179a.f434b[i4][i5][20] = (byte) m43a(1);
                    for (int i6 = 0; i6 < this.f179a.f434b[i4][i5][20]; i6++) {
                        for (int i7 = 0; i7 < 4; i7++) {
                            this.f179a.f434b[i4][i5][(i6 << 2) + i7] = (byte) m43a(1);
                        }
                    }
                }
            }
            byte[] bArr3 = this.f179a.f438c[0];
            byte[] bArr4 = this.f179a.f438c[1];
            this.f179a.f438c[2][50] = 0;
            bArr4[50] = 0;
            bArr3[50] = 0;
            for (int i8 = 0; i8 < bArr[0][50]; i8++) {
                byte b = this.f181v[this.f182d[109] + bArr[0][i8]];
                int i9 = 0;
                while (i9 < this.f179a.f434b[b][bArr[3][i8]][20]) {
                    if (bArr[1][i8] >= this.f179a.f434b[b][bArr[3][i8]][i9 << 2] && bArr[2][i8] >= this.f179a.f434b[b][bArr[3][i8]][(i9 << 2) + 1] && bArr[1][i8] < this.f179a.f434b[b][bArr[3][i8]][i9 << 2] + this.f179a.f434b[b][bArr[3][i8]][(i9 << 2) + 2] && bArr[2][i8] < this.f179a.f434b[b][bArr[3][i8]][(i9 << 2) + 1] + this.f179a.f434b[b][bArr[3][i8]][(i9 << 2) + 3]) {
                        this.f179a.f438c[bArr[3][i8]][this.f179a.f438c[bArr[3][i8]][50]] = bArr[0][i8];
                        byte[] bArr5 = this.f179a.f438c[bArr[3][i8]];
                        bArr5[50] = (byte) (bArr5[50] + 1);
                        break;
                    }
                    i9++;
                }
                if (b == 1 && this.l && i9 >= this.f179a.f434b[b][bArr[3][i8]][20]) {
                    this.f189x[i8 + 6666 + (50 * this.f178a.f316d) + 1] = 3;
                }
            }
            for (int i10 = 0; i10 < 3; i10++) {
                this.f179a.f435a[i10][40] = (byte) m43a(1);
                for (int i11 = 0; i11 < this.f179a.f435a[i10][40]; i11++) {
                    for (int i12 = 0; i12 < 4; i12++) {
                        this.f179a.f435a[i10][(i11 << 2) + i12] = (byte) m43a(1);
                    }
                }
            }
            for (int i13 = 0; i13 < 3; i13++) {
                this.f179a.f436b[i13][40] = (byte) m43a(1);
                for (int i14 = 0; i14 < this.f179a.f436b[i13][40]; i14++) {
                    for (int i15 = 0; i15 < 4; i15++) {
                        this.f179a.f436b[i13][(i14 << 2) + i15] = (byte) m43a(1);
                    }
                }
            }
            for (int i16 = 0; i16 < 3; i16++) {
                this.f179a.f458y[i16] = (byte) m43a(1);
                int iM43a6 = m43a(1);
                for (int i17 = 0; i17 < iM43a6; i17++) {
                    this.f179a.f456g[i16][i17] = (byte) m43a(1);
                }
                for (int i18 = 0; i18 < this.f179a.f458y[i16] + 1; i18++) {
                    this.f179a.f457h[i16][i18] = (byte) m43a(1);
                }
            }
            for (int i19 = 0; i19 < 3; i19++) {
                this.f179a.f460i[i19][8] = (byte) m43a(1);
                for (int i20 = 0; i20 < this.f179a.f460i[i19][8]; i20++) {
                    for (int i21 = 0; i21 < 2; i21++) {
                        this.f179a.f460i[i19][(i20 << 1) + i21] = (byte) m43a(1);
                    }
                }
            }
            for (int i22 = 0; i22 < 3; i22++) {
                this.f179a.f439d[i22][8] = (byte) m43a(1);
                for (int i23 = 0; i23 < this.f179a.f439d[i22][8]; i23++) {
                    for (int i24 = 0; i24 < 4; i24++) {
                        this.f179a.f439d[i22][(i23 << 2) + i24] = (byte) m43a(1);
                    }
                }
            }
            this.f179a.f444c = m43a(1);
            for (int i25 = 0; i25 < this.f179a.f444c; i25++) {
                for (int i26 = 0; i26 < 6; i26++) {
                    this.f179a.f443e[i26][i25] = (byte) m43a(1);
                }
            }
            if (i > 6) {
                int iM43a7 = m43a(2);
                int iM43a8 = m43a(2);
                for (int i27 = 0; i27 < iM43a7 + 1; i27++) {
                    this.f181v[this.f182d[139] + 32 + i27] = (byte) (95 + m43a(1));
                }
                for (int i28 = 0; i28 < iM43a7; i28++) {
                    this.f181v[this.f182d[140] + 32 + i28] = (byte) m43a(1);
                }
                for (int i29 = 0; i29 < iM43a8; i29++) {
                    this.f181v[this.f182d[141] + 95 + i29] = (byte) m43a(1);
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void j() {
        this.f179a.a = (byte) m43a(1);
        this.f179a.b = (byte) m43a(1);
        for (int i = 0; i < this.f179a.b; i++) {
            for (int i2 = 0; i2 < this.f179a.a; i2++) {
                this.f195b[i][i2] = 124;
                this.f194g[i][i2] = 0;
            }
        }
        int iM43a = m43a(1);
        this.f139a = this.f178a.f325d[iM43a];
        this.f140b = this.f178a.f326e[iM43a];
        int iM43a2 = m43a(2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < iM43a2; i5++) {
            int iM43a3 = m43a(1);
            int iM43a4 = m43a(1);
            for (int i6 = 0; i6 < iM43a3; i6++) {
                this.f194g[i3][i4] = (byte) iM43a4;
                for (int i7 = 0; i7 < 5; i7++) {
                    if (this.f194g[i3][i4] >= this.f140b[i7] && this.f194g[i3][i4] < this.f140b[i7 + 1]) {
                        this.f194g[i3][i4] = (byte) (this.f140b[i7] + ((this.f179a.f462a.nextInt() & 65535) % (this.f140b[i7 + 1] - this.f140b[i7])));
                        break;
                    }
                }
                if (this.f194g[i3][i4] >= this.f140b[13]) {
                    this.f195b[i3][i4] = 126;
                }
                i4++;
                if (i4 >= this.f179a.a) {
                    i4 -= this.f179a.a;
                    i3++;
                }
            }
        }
        int iM43a5 = m43a(2);
        for (int i8 = 0; i8 < iM43a5; i8++) {
            int iM43a6 = m43a(1);
            int iM43a7 = m43a(1);
            int iM43a8 = m43a(1);
            int i9 = iM43a6 + this.f140b[14];
            if (iM43a7 >= 0 && iM43a8 >= 0 && iM43a7 < this.f179a.a && iM43a8 < this.f179a.b) {
                for (int i10 = iM43a7; i10 < iM43a7 + this.f178a.f327i[18][this.f139a[i9]]; i10++) {
                    for (int i11 = iM43a8; i11 < iM43a8 + this.f178a.f327i[19][this.f139a[i9]]; i11++) {
                        this.f195b[i11][i10] = (short) ((i9 < this.f140b[13] || i9 >= this.f140b[15]) ? 125 : 126);
                    }
                }
                this.f195b[iM43a8][iM43a7] = (short) (i9 + 128);
            }
        }
        for (int i12 = 0; i12 < this.f179a.b; i12++) {
            for (int i13 = 0; i13 < ((this.f179a.a - 1) / 32) + 1; i13++) {
                int iM43a9 = m43a(4);
                for (int i14 = i13 << 5; i14 < ((i13 + 1) << 5) && i14 < this.f179a.a; i14++) {
                    if ((iM43a9 & (1 << ((((i13 + 1) << 5) - 1) - i14))) == 0 && this.f195b[i12][i14] > 100 && this.f195b[i12][i14] < 1001) {
                        this.f195b[i12][i14] = 0;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private int m43a(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += (this.f178a.f314e[this.ah + i3] & 255) << (((i - 1) - i3) << 3);
        }
        this.ah += i;
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:208:0x0681  */
    /* JADX WARN: Code duplicated, block: B:210:0x0688  */
    final void a() {
        this.aE = m51a();
        for (int i = 0; i < p.f525a.length; i++) {
            int iA = a.a(p.f525a[i], this.aE);
            if (iA > 0 && (((this.ay != 2 && this.ay != 14) || this.f178a.i != 0 || this.P != f119y) && (this.f178a.i != 0 || this.P != f120z))) {
                int i2 = iA - 100;
                if (i2 <= 0) {
                    p.f526a = true;
                    int iM51a = m51a() >> 2;
                    this.f178a.i = (byte) 0;
                    this.P = -1;
                    try {
                        if (p.f525a[i].equals(f259o) && a.f14c == null) {
                            a.f14c = new String[6];
                        }
                        a(a.f14c[0], a.f14c[1], -1, a.f14c[4] != null, a.f14c[5] != null, p.f525a[i].equals(f259o) ? 14 : 2, true, true);
                    } catch (Throwable unused) {
                        a(f120z, true);
                    }
                    a.a(499L);
                    this.f178a.f319k = (byte) -1;
                    a.f9a.put(p.f525a[i], new StringBuffer().append("").append(iM51a).toString());
                    a.c = a.b(a.h);
                    return;
                }
                a.f9a.put(p.f525a[i], new StringBuffer().append("").append(i2).toString());
            }
        }
        if (a.f8d && k.f357a != null) {
            a((String) null, o.f384a[3][9], this.P, false, true, 1, true, true);
            a.e();
            if (a.m2a(k.f357a)) {
                this.f178a.a((String) null);
            }
            k.f357a = null;
        }
        if (this.f167R >= 0) {
            this.f167R = (byte) (this.f167R + 1);
            if (this.f167R > 3) {
                this.f167R = (byte) -1;
                return;
            }
            return;
        }
        if (this.f178a.f322l > 0 && this.f178a.f322l < 7) {
            k kVar = this.f178a;
            kVar.f322l = (byte) (kVar.f322l - 1);
        }
        if (this.h >= 0) {
            this.f107v = (byte) (this.f107v + 1);
            if (this.f107v > this.f178a.f328f[6][this.h] - this.f178a.f328f[5][this.h]) {
                if (this.f178a.i == 0 && this.h == 271) {
                    this.f178a.i = (byte) 1;
                    this.f89a = (byte) 4;
                    if (this.f106c >= 0) {
                        if (this.f178a.f290c) {
                            this.h = (short) 270;
                            this.f107v = (byte) 0;
                        }
                        this.f105b = this.f106c;
                        this.f106c = (short) -1;
                        this.f95a = (short) this.K;
                        this.f114h = this.L;
                        if (this.f105b == 137) {
                            this.f138b = true;
                        }
                    }
                    this.f178a.f345g = -1;
                    this.f178a.f319k = (byte) -1;
                }
                this.h = (short) -1;
            }
        }
        if (this.f178a.i == 1 && this.f178a.f317e % 300 == 0) {
            this.r = this.f178a.f317e;
        }
        if (this.f179a.f418e != 0 && this.f178a.i == 1) {
            p pVar = this.f179a;
            pVar.f419f = (byte) (pVar.f419f + 1);
            if (this.f179a.f419f >= 50) {
                k();
            }
        }
        for (int i3 = 10; i3 < this.f110a.length; i3++) {
            if (this.f110a[i3] >= 0) {
                byte[] bArr = this.f110a;
                int i4 = i3;
                bArr[i4] = (byte) (bArr[i4] + 1);
                if (this.f110a[i3] >= this.f181v[this.f182d[126] + i3]) {
                    this.f110a[i3] = -1;
                }
            }
        }
        switch (this.f178a.i) {
            case 0:
                if (this.f157O != 0) {
                    m();
                }
                w();
                break;
            case 1:
                l();
                if (this.f155h < 0) {
                    if (this.h < 0) {
                        if (this.f105b == -1 && (this.C <= 0 || !this.f228C || !this.f178a.f323i)) {
                            if ((this.f178a.f319k != 4 && this.f178a.f319k != 6 && this.f178a.f319k != 2 && this.f178a.f319k != 8) || this.f102d < 0 || (this.f178a.f321f & 1) != 0) {
                                switch (this.f178a.f319k) {
                                    case -1:
                                        if (this.f220B) {
                                            if (this.f102d >= 0 && (this.f220B || this.f178a.f319k == 4 || this.f178a.f319k == 6 || this.f178a.f319k == 2 || this.f178a.f319k == 8)) {
                                                n();
                                                this.f220B = false;
                                            }
                                        }
                                        break;
                                    case 0:
                                    default:
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 1:
                                    case 3:
                                    case 7:
                                    case 9:
                                        if (this.f109i != 0 || this.f102d >= 0 || this.f141f >= 0) {
                                            this.f178a.f322l = (byte) 0;
                                        } else if (this.f178a.f322l == 7) {
                                            if (this.f144j == this.f181v[this.f182d[67] + this.f178a.f319k]) {
                                                B();
                                            }
                                            this.f178a.f322l = (byte) 0;
                                        } else if (this.f178a.f321f >= 4) {
                                            d(0, this.f181v[this.f182d[67] + this.f178a.f319k]);
                                        } else if (this.f178a.f320h) {
                                            d(this.f181v[this.f182d[67] + this.f178a.f319k], 0);
                                        } else if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        this.f178a.f319k = (byte) -1;
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 2:
                                        r();
                                        A();
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 4:
                                        p();
                                        A();
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 5:
                                        o();
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 6:
                                        q();
                                        A();
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 8:
                                        s();
                                        A();
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 10:
                                        this.f178a.i = (byte) 2;
                                        this.f89a = (byte) 4;
                                        this.f178a.f319k = (byte) -1;
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                    case 11:
                                        if (!this.i) {
                                            this.r = this.f178a.f317e;
                                            F();
                                            this.f178a.i = (byte) 0;
                                            this.P = -1;
                                            a(1, true);
                                            if (this.f178a.f290c) {
                                                this.h = (short) 270;
                                                this.f107v = (byte) 0;
                                            }
                                        } else if (this.f109i != 0) {
                                            this.f95a = this.f109i;
                                            this.f109i = (short) 0;
                                            this.f105b = (short) 135;
                                            if (this.f178a.f290c) {
                                                this.h = (short) 270;
                                                this.f107v = (byte) 0;
                                            }
                                        } else if (this.f102d >= 0) {
                                            this.f102d = (byte) -1;
                                        } else if (this.f141f >= 0 || this.f190c[0][50] > 0) {
                                            this.f141f = (byte) -1;
                                            m45a(0);
                                        }
                                        this.f178a.f319k = (byte) -1;
                                        if (this.f102d >= 0) {
                                            n();
                                            this.f220B = false;
                                        }
                                        break;
                                }
                            }
                        } else {
                            t();
                            break;
                        }
                    }
                } else {
                    if (this.h < 0 && this.f105b >= 0) {
                        if (this.k) {
                            if (this.f106c >= 0) {
                                this.f105b = this.f106c;
                            } else {
                                this.f105b = (short) -1;
                            }
                            this.k = false;
                        }
                        if (this.f105b >= 0) {
                            this.f106c = this.f105b;
                            short s = this.f95a;
                            this.K = s;
                            this.M = s;
                            int i5 = this.f114h;
                            this.L = i5;
                            this.N = i5;
                            if (this.f178a.f290c) {
                                this.h = (short) 271;
                                this.f107v = (byte) 0;
                            }
                            this.f105b = (short) -1;
                        }
                    }
                    if (this.h < 0 && this.f105b < 0) {
                        this.f178a.i = (byte) 0;
                        this.P = -1;
                        if (this.f155h < 50) {
                            a(18, true);
                            this.f156N = (byte) 0;
                            this.f157O = (byte) 1;
                            this.W = this.f181v[this.f182d[139] + this.f155h];
                        } else {
                            a(17, true);
                        }
                        if (this.f178a.f290c) {
                            this.h = (short) 270;
                            this.f107v = (byte) 0;
                        }
                        this.f138b = true;
                    }
                    this.f178a.f319k = (byte) -1;
                    break;
                }
                break;
            case 2:
                v();
                break;
        }
        if (this.f179a.f527d > 0) {
            this.f179a = null;
        }
        if (this.f178a.f319k != -1) {
            this.f178a.f321f++;
            if (this.f178a.f320h) {
                this.f178a.f319k = (byte) -1;
            }
        }
    }

    private void k() {
        if (this.f179a.f418e == 1) {
            short[] sArr = this.f178a.f311c[this.f178a.f315j];
            sArr[9] = (short) (sArr[9] + ((this.f178a.f311c[this.f178a.f315j][6] * 10) - (this.f178a.f311c[this.f178a.f315j][8] * 5)));
            int iA = p.a((int) this.f178a.f311c[this.f178a.f315j][9], 0, this.e > 0 ? this.f * 100 : 100000);
            int iMax = Math.max((this.e * 500) - (this.f178a.f317e / 20), 0);
            this.f178a.a(-(this.b + 10), this.b, true);
            if (this.s > 0) {
                for (int i = 0; i < this.s; i++) {
                    iMax = (iMax * 9) / 10;
                }
            }
            if (this.e > 0) {
                this.f178a.f311c[this.f178a.f315j][9] = (short) ((iMax + ((iA * (iMax / 2)) / (this.f * 100))) / (2 - this.d));
            } else {
                this.f178a.f311c[this.f178a.f315j][9] = (short) (iA / (2 - this.d));
            }
            if (this.t == 0) {
                short[] sArr2 = this.f178a.f311c[this.f178a.f315j];
                sArr2[10] = (short) (sArr2[10] + this.f178a.f311c[this.f178a.f315j][9]);
            } else if (this.b > 6) {
                H();
            }
            this.r = 0;
            this.s = 0;
            F();
        }
        if (this.f179a.f418e == 1 && this.t == 0) {
            this.f200a[this.b] = true;
            while (this.f181v[this.f182d[132] + this.c] < this.b + 1 && this.c < 2) {
                this.c++;
                this.f208w = true;
            }
            if (this.b < 6) {
                this.b++;
                this.n = this.b;
            } else {
                this.b = -1;
                this.m = -1;
                this.n = -1;
            }
            H();
        }
        this.f178a.i = (byte) 0;
        this.f89a = (byte) 4;
        this.P = -1;
        if (this.f159j < 0 || this.f179a.f418e != 1) {
            a((25 + this.f179a.f418e) - 1, true);
        } else {
            a(18, true);
            this.f156N = (byte) 0;
            this.f157O = (byte) 1;
            this.f155h = this.f159j;
            this.W = this.f181v[this.f182d[139] + this.f159j];
            this.f159j = (byte) -1;
        }
        if (this.f178a.f290c) {
            this.h = (short) 270;
            this.f107v = (byte) 0;
        }
        this.f138b = true;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0347  */
    /* JADX WARN: Code duplicated, block: B:104:0x0353  */
    /* JADX WARN: Code duplicated, block: B:109:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:111:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:112:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:116:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:119:0x0420  */
    /* JADX WARN: Code duplicated, block: B:121:0x042b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0447  */
    /* JADX WARN: Code duplicated, block: B:125:0x0452  */
    /* JADX WARN: Code duplicated, block: B:127:0x0461  */
    /* JADX WARN: Code duplicated, block: B:129:0x0472  */
    /* JADX WARN: Code duplicated, block: B:140:0x0546  */
    /* JADX WARN: Code duplicated, block: B:142:0x0565  */
    /* JADX WARN: Code duplicated, block: B:143:0x0569  */
    /* JADX WARN: Code duplicated, block: B:144:0x056d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0535 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x0535 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x019e  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x01bd  */
    private void l() {
        short s;
        int i;
        int i2;
        int i3;
        int i4;
        short s2;
        int iMax;
        boolean z;
        int iMax2;
        int i5;
        int[] iArr;
        if (this.g >= 0) {
            this.f101u = (byte) (this.f101u + 1);
            if (this.f101u > this.f178a.f328f[6][this.g] - this.f178a.f328f[5][this.g]) {
                this.g = (short) -1;
            }
        }
        if (this.P == f120z) {
            this.f178a.a((String) null);
            this.f178a = null;
        }
        if (this.f145g >= 0) {
            this.f145g = (byte) (this.f145g + 1);
            if (this.f145g >= 5) {
                this.f145g = (byte) -1;
            }
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (this.f110a[i6] >= 0) {
                byte[] bArr = this.f110a;
                int i7 = i6;
                bArr[i7] = (byte) (bArr[i7] + 1);
                if (this.f110a[i6] >= this.f181v[this.f182d[126] + i6]) {
                    this.f110a[i6] = -1;
                }
            }
        }
        if (this.f94r >= 0 && this.f98f >= 0) {
            this.f94r = (byte) (this.f94r + 1);
            if (this.f94r > this.f178a.f328f[6][this.f98f] - this.f178a.f328f[5][this.f98f]) {
                this.f94r = (byte) -1;
                this.f98f = (short) (this.f95a > 0 ? this.f98f - 4 : this.f98f == 261 ? 2015 : 2023);
            }
        }
        boolean z2 = true;
        if (this.f109i == 0 && this.f102d < 0 && this.f141f < 0 && this.f105b == -1) {
            this.f95a = (short) 0;
            this.f92p = this.f90b;
            this.f93q = this.f91c;
            if (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][this.f90b >> 5][this.f91c] >> (this.f90b & 31)) & 1) == 0) {
                if (this.f178a.f293e == 2) {
                    int[] iArr2 = null;
                    if (((iArr2[this.f91c] >> (this.f90b & 31)) & 1) == 0) {
                        if (this.f178a.f293e > 2) {
                            if ((-this.f195b[this.f91c][this.f90b]) > 100 && this.f195b[this.f91c][this.f90b] <= 100 && this.f195b[this.f91c][this.f90b] != 0) {
                                boolean z3 = this.f195b[this.f91c][this.f90b] > 0;
                                boolean z4 = z3;
                                boolean z5 = z3 ? this.f195b[this.f91c][this.f90b] > this.f178a.f315j * 50 && this.f195b[this.f91c][this.f90b] <= (this.f178a.f315j + 1) * 50 : (-this.f195b[this.f91c][this.f90b]) > this.f178a.f315j * 50 && (-this.f195b[this.f91c][this.f90b]) <= (this.f178a.f315j + 1) * 50;
                                if ((z4 ? this.f189x[1616 + this.f195b[this.f91c][this.f90b]] > 0 : ((this.f189x[5454 - this.f195b[this.f91c][this.f90b]] + 1) & 255) > 1) && !(this.f178a.f293e < 2 && ((this.f178a.f301a[1][this.f90b >> 5][this.f91c] >> (this.f90b & 31)) & 1) == 0 && (z4 || (this.f189x[6060 - this.f195b[this.f91c][this.f90b]] & 2) == 0))) {
                                    this.f95a = this.f195b[this.f91c][this.f90b];
                                    z = z5;
                                } else if (this.f190c[0][50] <= 0) {
                                }
                            } else if (this.f190c[0][50] <= 0 && this.f195b[this.f91c][this.f90b] >= 1001 + ((this.f178a.f315j ^ 1) * 100) && this.f195b[this.f91c][this.f90b] < 1001 + (((this.f178a.f315j ^ 1) + 1) * 100)) {
                                this.f95a = this.f195b[this.f91c][this.f90b];
                                z = false;
                            }
                        }
                    } else if ((-this.f195b[this.f91c][this.f90b]) > 100) {
                        if (this.f190c[0][50] <= 0) {
                        }
                    } else if (this.f190c[0][50] <= 0) {
                    }
                } else if (this.f178a.f293e > 2) {
                    if ((-this.f195b[this.f91c][this.f90b]) > 100) {
                        if (this.f190c[0][50] <= 0) {
                        }
                    } else if (this.f190c[0][50] <= 0) {
                    }
                }
                if (this.f190c[0][50] <= 0) {
                    i = this.f178a.f315j;
                } else {
                    i = this.f178a.f315j ^ 1;
                }
                i2 = i;
                int i8 = 10000;
                i3 = 0;
                i4 = 0;
                s2 = 0;
                for (iMax = Math.max(this.f91c - 1, 0); iMax <= Math.min(this.f91c + 1, this.f179a.b - 1); iMax++) {
                    for (iMax2 = Math.max(this.f90b - 1, 0); iMax2 <= Math.min(this.f90b + 1, this.f179a.a - 1); iMax2++) {
                        if (this.f178a.f293e < 2 || ((this.f178a.f301a[1][iMax2 >> 5][iMax] >> (iMax2 & 31)) & 1) != 0) {
                            if (this.f178a.f293e == 2) {
                                iArr = null;
                                if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                    if (this.f195b[iMax][iMax2] <= i2 * 50 && this.f195b[iMax][iMax2] <= (i2 + 1) * 50 && this.f189x[1616 + this.f195b[iMax][iMax2]] > 0 && i8 > (i5 = ((((iMax2 - this.f90b) * 30) + this.f189x[202 + this.f195b[iMax][iMax2]]) * (((iMax2 - this.f90b) * 30) + this.f189x[202 + this.f195b[iMax][iMax2]])) + ((((iMax - this.f91c) * 20) + this.f189x[303 + this.f195b[iMax][iMax2]]) * (((iMax - this.f91c) * 20) + this.f189x[303 + this.f195b[iMax][iMax2]])))) {
                                        i8 = i5;
                                        s2 = this.f195b[iMax][iMax2];
                                        i3 = iMax2;
                                        i4 = iMax;
                                    }
                                }
                            } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                            }
                        }
                    }
                }
                if (s2 > 0) {
                    this.f95a = s2;
                    this.f92p = (byte) i3;
                    this.f93q = (byte) i4;
                    if (i2 == this.f178a.f315j) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
            } else if ((-this.f195b[this.f91c][this.f90b]) > 100) {
                if (this.f190c[0][50] <= 0) {
                    if (this.f190c[0][50] <= 0) {
                        i = this.f178a.f315j;
                    } else {
                        i = this.f178a.f315j ^ 1;
                    }
                    i2 = i;
                    int i9 = 10000;
                    i3 = 0;
                    i4 = 0;
                    s2 = 0;
                    while (iMax <= Math.min(this.f91c + 1, this.f179a.b - 1)) {
                        while (iMax2 <= Math.min(this.f90b + 1, this.f179a.a - 1)) {
                            if (this.f178a.f293e < 2) {
                                if (this.f178a.f293e == 2) {
                                    iArr = null;
                                    if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                        if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                        }
                                    }
                                } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                }
                            } else if (this.f178a.f293e == 2) {
                                iArr = null;
                                if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                    if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                    }
                                }
                            } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                            }
                        }
                    }
                    if (s2 > 0) {
                        this.f95a = s2;
                        this.f92p = (byte) i3;
                        this.f93q = (byte) i4;
                        if (i2 == this.f178a.f315j) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                } else {
                    if (this.f190c[0][50] <= 0) {
                        i = this.f178a.f315j;
                    } else {
                        i = this.f178a.f315j ^ 1;
                    }
                    i2 = i;
                    int i10 = 10000;
                    i3 = 0;
                    i4 = 0;
                    s2 = 0;
                    while (iMax <= Math.min(this.f91c + 1, this.f179a.b - 1)) {
                        while (iMax2 <= Math.min(this.f90b + 1, this.f179a.a - 1)) {
                            if (this.f178a.f293e < 2) {
                                if (this.f178a.f293e == 2) {
                                    iArr = null;
                                    if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                        if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                        }
                                    }
                                } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                }
                            } else if (this.f178a.f293e == 2) {
                                iArr = null;
                                if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                    if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                    }
                                }
                            } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                            }
                        }
                    }
                    if (s2 > 0) {
                        this.f95a = s2;
                        this.f92p = (byte) i3;
                        this.f93q = (byte) i4;
                        if (i2 == this.f178a.f315j) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                }
            } else if (this.f190c[0][50] <= 0) {
                if (this.f190c[0][50] <= 0) {
                    i = this.f178a.f315j;
                } else {
                    i = this.f178a.f315j ^ 1;
                }
                i2 = i;
                int i11 = 10000;
                i3 = 0;
                i4 = 0;
                s2 = 0;
                while (iMax <= Math.min(this.f91c + 1, this.f179a.b - 1)) {
                    while (iMax2 <= Math.min(this.f90b + 1, this.f179a.a - 1)) {
                        if (this.f178a.f293e < 2) {
                            if (this.f178a.f293e == 2) {
                                iArr = null;
                                if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                    if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                    }
                                }
                            } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                            }
                        } else if (this.f178a.f293e == 2) {
                            iArr = null;
                            if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                }
                            }
                        } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                        }
                    }
                }
                if (s2 > 0) {
                    this.f95a = s2;
                    this.f92p = (byte) i3;
                    this.f93q = (byte) i4;
                    if (i2 == this.f178a.f315j) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
            } else {
                if (this.f190c[0][50] <= 0) {
                    i = this.f178a.f315j;
                } else {
                    i = this.f178a.f315j ^ 1;
                }
                i2 = i;
                int i12 = 10000;
                i3 = 0;
                i4 = 0;
                s2 = 0;
                while (iMax <= Math.min(this.f91c + 1, this.f179a.b - 1)) {
                    while (iMax2 <= Math.min(this.f90b + 1, this.f179a.a - 1)) {
                        if (this.f178a.f293e < 2) {
                            if (this.f178a.f293e == 2) {
                                iArr = null;
                                if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                    if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                    }
                                }
                            } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                            }
                        } else if (this.f178a.f293e == 2) {
                            iArr = null;
                            if (((iArr[iMax] >> (iMax2 & 31)) & 1) != 0) {
                                if (this.f195b[iMax][iMax2] <= i2 * 50) {
                                }
                            }
                        } else if (this.f195b[iMax][iMax2] <= i2 * 50) {
                        }
                    }
                }
                if (s2 > 0) {
                    this.f95a = s2;
                    this.f92p = (byte) i3;
                    this.f93q = (byte) i4;
                    if (i2 == this.f178a.f315j) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
            }
            z2 = z;
        }
        if (this.f109i != 0 || this.f111o) {
            s = 249;
        } else if (z2) {
            s = this.f190c[0][50] > 0 ? (short) 251 : (short) 250;
        } else {
            s = 252;
        }
        this.f97e = s;
        if (this.f96d != this.f95a) {
            if (this.f95a == 0 || (!z2 && this.f190c[0][50] <= 0)) {
                this.f94r = (byte) -1;
                this.f98f = (short) -1;
            } else {
                this.f98f = (short) (((this.f95a <= 0 || (16447 & (1 << this.f189x[2323 + this.f95a])) != 0) ? 0 : 1) + (this.f95a < 0 ? z2 ? 261 : 265 : z2 ? 257 : 259));
                this.f94r = (byte) 0;
            }
            this.f96d = this.f95a;
        }
    }

    private void m() {
        if (this.f157O >= 0) {
            this.f157O = (byte) (this.f157O + 1);
            if (this.f157O - 1 > this.f178a.f328f[6][290] - this.f178a.f328f[5][290]) {
                this.f157O = (byte) 0;
                return;
            }
            return;
        }
        this.f157O = (byte) (this.f157O - 1);
        if ((-this.f157O) - 1 > this.f178a.f328f[6][286] - this.f178a.f328f[5][286]) {
            this.f156N = (byte) (this.f156N + 1);
            if (this.f156N < this.f181v[(this.f182d[139] + this.f155h) + 1] - this.f181v[this.f182d[139] + this.f155h]) {
                this.f157O = (byte) 1;
                this.W = this.f181v[this.f182d[139] + this.f155h] + this.f156N;
                this.f138b = true;
                return;
            }
            if (this.f160k >= 0) {
                this.f155h = this.f160k;
                this.f160k = (byte) -1;
                this.P = -1;
                a(17, true);
                this.f138b = true;
                this.f157O = (byte) 0;
                return;
            }
            if (this.f179a.f419f >= 50) {
                a((25 + this.f179a.f418e) - 1, true);
                this.f155h = (byte) -1;
                this.f157O = (byte) 0;
                return;
            }
            if (this.f178a.f290c) {
                this.h = (short) 271;
                this.f107v = (byte) 0;
            } else {
                this.f178a.i = (byte) 1;
                this.f89a = (byte) 4;
                if (this.f106c >= 0) {
                    this.f105b = this.f106c;
                    this.f106c = (short) -1;
                    this.f95a = (short) this.K;
                    this.f114h = this.L;
                }
            }
            this.f155h = (byte) -1;
            this.f157O = (byte) 0;
        }
    }

    private void n() {
        this.f103m = false;
        for (int i = (this.f178a.f315j * 50) + 1; i <= (this.f178a.f315j + 1) * 50 && !this.f103m; i++) {
            if (((this.f189x[i + 5454] + 1) & 255) > 1 && (this.f189x[i + 6060] & 1) == 0 && this.f181v[this.f182d[94] + this.f189x[i + 5656]] % 3 == 0) {
                this.f103m = (((this.f90b + (this.f178a.f327i[18][this.f102d] / 2)) - this.f189x[i + 5252]) * ((this.f90b + (this.f178a.f327i[18][this.f102d] / 2)) - this.f189x[i + 5252])) + (((this.f91c + (this.f178a.f327i[19][this.f102d] / 2)) - this.f189x[i + 5353]) * ((this.f91c + (this.f178a.f327i[19][this.f102d] / 2)) - this.f189x[i + 5353])) <= this.f154g[this.f178a.f315j] * this.f154g[this.f178a.f315j];
            }
        }
    }

    private void o() {
        boolean z;
        if (this.f102d >= 0 || this.f109i != 0) {
            if (this.f109i != 0) {
                this.f189x[6161 - this.f109i] = this.f90b;
                this.f189x[6262 - this.f109i] = this.f91c;
                this.f95a = this.f109i;
                this.f109i = (short) 0;
                this.f105b = (short) 135;
                if (this.f178a.f290c) {
                    this.h = (short) 270;
                    this.f107v = (byte) 0;
                }
                this.f178a.f319k = (byte) -1;
                return;
            }
            if (this.f102d >= 0) {
                if (this.f178a.f311c[this.f178a.f315j][1] < 50 || this.f102d >= 15) {
                    if (this.f178a.f311c[this.f178a.f315j][4] >= this.f183e[this.f184f[6] + this.f102d]) {
                        byte b = this.f90b;
                        byte b2 = this.f91c;
                        byte b3 = this.f102d;
                        int i = b2;
                        loop2: while (true) {
                            if (i >= b2 + this.f178a.f327i[19][b3]) {
                                z = this.f103m;
                                break;
                            }
                            int i2 = b;
                            while (true) {
                                if (i2 < b + this.f178a.f327i[18][b3]) {
                                    if (this.f195b[i][i2] == 0 && (this.f178a.f293e >= 2 || (((this.f178a.f301a[0][i2 >> 5][i] >> (i2 & 31)) & 1) != 0 && ((this.f178a.f301a[1][i2 >> 5][i] >> (i2 & 31)) & 1) != 0))) {
                                        if (this.f178a.f293e == 2) {
                                            int[] iArr = null;
                                            if (((iArr[i] >> (i2 & 31)) & 1) == 0) {
                                            }
                                        }
                                        i2++;
                                    }
                                    z = false;
                                    break loop2;
                                }
                                i++;
                            }
                        }
                        if (z) {
                            short[] sArr = this.f178a.f311c[this.f178a.f315j];
                            sArr[4] = (short) (sArr[4] - this.f183e[this.f184f[6] + this.f102d]);
                            if (this.f102d < 15) {
                                a(this.f102d, this.f90b, this.f91c, 0, 0, false);
                            } else {
                                this.f195b[this.f91c][this.f90b] = (short) (1001 + (this.f178a.f315j * 100));
                                this.f89a = (byte) 4;
                            }
                        }
                    } else {
                        this.f110a[5] = 0;
                    }
                }
                this.f178a.f319k = (byte) -1;
                return;
            }
            return;
        }
        if (this.f141f == -1 && !this.f178a.f320h && !this.f111o) {
            if (this.f178a.f321f == 4) {
                if (this.f190c[0][50] <= 0) {
                    this.f141f = this.f90b;
                    this.f142K = this.f91c;
                    A();
                } else if (this.C > 0) {
                    this.f114h = 2;
                    this.f228C = true;
                }
                this.f178a.f319k = (byte) -1;
                return;
            }
            return;
        }
        if (this.f111o) {
            this.f111o = false;
            for (int i3 = 0; i3 < this.f190c[0][50]; i3++) {
                if ((this.f189x[2929 + this.f190c[0][i3]] & 96) == 0 && this.f181v[this.f182d[58] + this.f189x[2323 + this.f190c[0][i3]]] >= 2) {
                    this.f189x[1717 + this.f190c[0][i3]] = this.f90b;
                    this.f189x[1818 + this.f190c[0][i3]] = this.f91c;
                    this.f189x[1919 + this.f190c[0][i3]] = 127;
                    this.f189x[1111 + this.f190c[0][i3]] = 0;
                    this.f189x[4545 + this.f190c[0][i3]] = 0;
                    this.f189x[707 + this.f190c[0][i3]] = this.f189x[404 + this.f190c[0][i3]];
                    this.f189x[1515 + this.f190c[0][i3]] = 1;
                    a((short) 248);
                }
            }
        } else if (this.f141f != -1) {
            a(this.f141f, this.f142K, this.f90b, this.f91c);
            this.f141f = (byte) -1;
            this.f178a.f322l = (byte) 0;
        } else if (this.f95a > this.f178a.f315j * 50 && this.f95a <= (this.f178a.f315j + 1) * 50) {
            a(this.f92p, this.f93q, this.f92p, this.f93q);
            if (this.f92p - this.f90b == -1) {
                p();
            } else if (this.f92p - this.f90b == 1) {
                q();
            }
            if (this.f93q - this.f91c == -1) {
                r();
            } else if (this.f93q - this.f91c == 1) {
                s();
            }
        } else if ((-this.f95a) > this.f178a.f315j * 50 && (-this.f95a) <= (this.f178a.f315j + 1) * 50) {
            this.f141f = (byte) -1;
            if (this.f178a.f290c) {
                this.h = (short) 270;
                this.f107v = (byte) 0;
            }
            if ((this.f189x[6060 - this.f95a] & 1) != 0 || (this.f181v[this.f182d[94] + this.f189x[5656 - this.f95a]] < 0 && this.f189x[5656 - this.f95a] != 4 && this.f189x[5656 - this.f95a] != 12)) {
                this.P = -1;
                this.f105b = (short) 139;
                this.W = 125;
                this.f108n = true;
                this.k = true;
                this.f138b = true;
            } else if (this.f189x[5656 - this.f95a] == 4 || this.f189x[5656 - this.f95a] == 12) {
                this.f108n = false;
                this.f105b = (short) 137;
                this.f114h = this.f189x[6868 - this.f95a];
                if (this.f114h < 0) {
                    this.f114h = this.f189x[6565 - this.f95a];
                }
                this.f138b = true;
            } else {
                this.f108n = false;
                this.f105b = (short) (136 - ((this.f189x[5656 - this.f95a] & 7) / 2));
                this.A = this.f181v[this.f182d[94] + this.f189x[5656 - this.f95a]];
                this.B = this.f181v[(this.f182d[96 + (this.A << 1)] + this.f112b[this.A]) + 1] - this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]];
                if (this.f105b == 135) {
                    if (!this.j && this.f178a.f311c[this.f178a.f315j][0] >= this.f181v[this.f182d[130] + this.c] && this.c < 2) {
                        this.f108n = true;
                        this.P = -1;
                        this.f105b = (short) 139;
                        this.f106c = (short) 135;
                        this.W = 30;
                        this.L = -1;
                        this.N = -1;
                        this.f138b = true;
                        this.j = true;
                    }
                    int i4 = 0;
                    for (int i5 = 0; i5 < this.B; i5++) {
                        if (this.f189x[6767 - this.f95a] >= 0 && this.f179a.o[this.f189x[6767 - this.f95a] + i4] == i5 && this.f179a.f410q[this.f189x[6767 - this.f95a] + i4] == (-this.f95a)) {
                            this.f116c[i5] = this.f179a.f409p[this.f189x[6767 - this.f95a] + i4];
                            i4++;
                        } else {
                            this.f116c[i5] = 0;
                        }
                    }
                }
                if (this.f105b != 139) {
                    this.f114h = Math.max((int) this.f189x[6868 - this.f95a], 0);
                }
            }
        } else if (this.f190c[0][50] > 0) {
            y();
        }
        if (this.f178a.f322l == 7) {
            if (this.f105b < 0) {
                a(this.f179a.c, this.f179a.d, (this.f179a.c + 8) - 1, (this.f179a.d + this.f179a.f430i) - 1);
            }
            this.f178a.f322l = (byte) 0;
        }
        this.f178a.f319k = (byte) -1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    final void m44b() {
        if (this.f178a.i == 1) {
            this.r = this.f178a.f317e;
            F();
            this.f178a.i = (byte) 0;
            this.P = -1;
            this.f106c = (short) -1;
            this.f105b = (short) -1;
            this.k = false;
            a(1, true);
        }
    }

    private void p() {
        if (this.f90b > 0) {
            this.f90b = (byte) (this.f90b - 1);
            if (this.f90b < this.f179a.c + 1 && this.f179a.c > 0) {
                p pVar = this.f179a;
                pVar.c = (byte) (pVar.c - 1);
                for (int i = 10; i > 0; i--) {
                    for (int i2 = 0; i2 < k.f276a + 2; i2++) {
                        this.f193f[i2][i] = this.f193f[i2][i - 1];
                    }
                }
                for (int i3 = 0; i3 < k.f276a + 2; i3++) {
                    this.f193f[i3][0] = -1;
                }
                for (int i4 = 0; i4 < 50; i4++) {
                    if (this.f192e[1][i4] != -1) {
                        byte[] bArr = this.f192e[2];
                        int i5 = i4;
                        bArr[i5] = (byte) (bArr[i5] + 1);
                        if (this.f192e[2][i4] >= 11) {
                            this.f192e[6][i4] = -1;
                            this.f192e[1][i4] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f280b = -15;
                }
                this.f89a = this.f89a == -1 ? (byte) 0 : (byte) 4;
            }
            if (this.f178a.f288a) {
                this.u = -15;
            }
        }
    }

    private void q() {
        if (this.f90b + (this.f102d >= 0 ? this.f178a.f327i[18][this.f102d] - 1 : 0) < this.f179a.a - 1) {
            this.f90b = (byte) (this.f90b + 1);
            if (this.f90b + (this.f102d >= 0 ? this.f178a.f327i[18][this.f102d] - 1 : 0) >= (this.f179a.c + 8) - 1 && this.f179a.c + 8 < this.f179a.a) {
                p pVar = this.f179a;
                pVar.c = (byte) (pVar.c + 1);
                for (int i = 0; i < 10; i++) {
                    for (int i2 = 0; i2 < k.f276a + 2; i2++) {
                        this.f193f[i2][i] = this.f193f[i2][i + 1];
                    }
                }
                for (int i3 = 0; i3 < k.f276a + 2; i3++) {
                    this.f193f[i3][10] = -1;
                }
                for (int i4 = 0; i4 < 50; i4++) {
                    if (this.f192e[1][i4] != -1) {
                        byte[] bArr = this.f192e[2];
                        int i5 = i4;
                        bArr[i5] = (byte) (bArr[i5] - 1);
                        if (this.f192e[2][i4] < 0) {
                            this.f192e[6][i4] = -1;
                            this.f192e[1][i4] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f280b = 15;
                }
                this.f89a = this.f89a == -1 ? (byte) 1 : (byte) 4;
            }
            if (this.f178a.f288a) {
                this.u = 15;
            }
        }
    }

    private void r() {
        if (this.f91c > 0) {
            this.f91c = (byte) (this.f91c - 1);
            if (this.f91c < this.f179a.d + 3 && this.f179a.d > 0) {
                p pVar = this.f179a;
                pVar.d = (byte) (pVar.d - 1);
                for (int i = 0; i < 11; i++) {
                    for (int i2 = (k.f276a + 2) - 1; i2 > 0; i2--) {
                        this.f193f[i2][i] = this.f193f[i2 - 1][i];
                    }
                }
                for (int i3 = 0; i3 < 11; i3++) {
                    this.f193f[0][i3] = -1;
                }
                for (int i4 = 0; i4 < 50; i4++) {
                    if (this.f192e[1][i4] != -1) {
                        byte[] bArr = this.f192e[3];
                        int i5 = i4;
                        bArr[i5] = (byte) (bArr[i5] + 1);
                        if (this.f192e[3][i4] >= k.f276a + 2) {
                            this.f192e[6][i4] = -1;
                            this.f192e[1][i4] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f281c = -10;
                }
                this.f89a = this.f89a == -1 ? (byte) 2 : (byte) 4;
            }
            if (this.f178a.f288a) {
                this.v = -10;
            }
        }
    }

    private void s() {
        if (this.f91c + (this.f102d >= 0 ? this.f178a.f327i[19][this.f102d] - 1 : 0) < this.f179a.b - 1) {
            this.f91c = (byte) (this.f91c + 1);
            if (this.f91c + (this.f102d >= 0 ? this.f178a.f327i[19][this.f102d] - 1 : 0) >= (this.f179a.d + this.f179a.f430i) - 2 && this.f179a.d + this.f179a.f430i < this.f179a.b) {
                p pVar = this.f179a;
                pVar.d = (byte) (pVar.d + 1);
                for (int i = 0; i < 11; i++) {
                    for (int i2 = 0; i2 < (k.f276a + 2) - 1; i2++) {
                        this.f193f[i2][i] = this.f193f[i2 + 1][i];
                    }
                }
                for (int i3 = 0; i3 < 11; i3++) {
                    this.f193f[(k.f276a + 2) - 1][i3] = -1;
                }
                for (int i4 = 0; i4 < 50; i4++) {
                    if (this.f192e[1][i4] != -1) {
                        byte[] bArr = this.f192e[3];
                        int i5 = i4;
                        bArr[i5] = (byte) (bArr[i5] - 1);
                        if (this.f192e[3][i4] < 0) {
                            this.f192e[6][i4] = -1;
                            this.f192e[1][i4] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f281c = 10;
                }
                this.f89a = this.f89a == -1 ? (byte) 3 : (byte) 4;
            }
            if (this.f178a.f288a) {
                this.v = 10;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:112:0x03df  */
    /* JADX WARN: Code duplicated, block: B:115:0x040c  */
    /* JADX WARN: Code duplicated, block: B:120:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:122:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:126:0x0570  */
    /* JADX WARN: Code duplicated, block: B:128:0x0574  */
    /* JADX WARN: Code duplicated, block: B:130:0x0580  */
    /* JADX WARN: Code duplicated, block: B:132:0x0590  */
    /* JADX WARN: Code duplicated, block: B:142:0x05df  */
    /* JADX WARN: Code duplicated, block: B:144:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:148:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:150:0x0602  */
    /* JADX WARN: Code duplicated, block: B:153:0x0610  */
    /* JADX WARN: Code duplicated, block: B:155:0x061a  */
    /* JADX WARN: Code duplicated, block: B:159:0x0668  */
    /* JADX WARN: Code duplicated, block: B:166:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:170:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:175:0x0790  */
    /* JADX WARN: Code duplicated, block: B:183:0x05eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0657 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x064d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0109  */
    private void t() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        byte bA;
        byte bA2;
        int i3;
        byte b;
        byte b2;
        int i4;
        if (this.f178a.f321f <= 0 || this.f178a.f321f > 2) {
            switch (this.f178a.f319k) {
                case 0:
                    this.W = -1;
                    byte b3 = this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h];
                    switch (this.f105b) {
                        case 135:
                            this.W = b3 + 94;
                            break;
                        case 136:
                            this.W = Math.min((int) b3, 8) + 85;
                            break;
                        case 137:
                            this.W = this.f114h + 101;
                            break;
                    }
                    this.P = -1;
                    if (this.W >= 0) {
                        this.f106c = this.f105b;
                        this.L = this.f114h;
                        this.K = this.f95a;
                        this.P = -1;
                        this.f138b = true;
                        this.f108n = true;
                        a(2, true);
                        this.f178a.i = (byte) 0;
                    }
                    this.f178a.f319k = (byte) -1;
                    break;
                case 1:
                    if (this.f105b == 135) {
                        this.f109i = this.f95a;
                        this.f178a.f319k = (byte) -1;
                        if (this.f178a.f290c) {
                            this.h = (short) 271;
                            this.f107v = (byte) 0;
                        }
                        this.f105b = (short) -1;
                    }
                    if (this.f178a.f319k == 3 && (this.f105b == 135 || this.f105b == 136 || this.f105b == 137)) {
                        this.f108n = true;
                        this.P = -1;
                        this.f106c = this.f105b;
                        this.f105b = (short) 139;
                        this.W = 125;
                        short s = this.f105b;
                        this.L = s;
                        this.N = s;
                        this.k = true;
                        this.f138b = true;
                        this.f178a.f319k = (byte) -1;
                    }
                    if (this.f105b == 145 && this.f181v[this.f182d[67] + this.f178a.f319k] <= this.B) {
                        this.f114h = this.f181v[this.f182d[67] + this.f178a.f319k] - 1;
                        z();
                        this.f105b = (short) -1;
                    }
                    this.f178a.f319k = (byte) -1;
                    break;
                case 2:
                    if (this.f105b == -1) {
                        this.f114h++;
                        if (this.f114h > 3) {
                            this.f114h = 3;
                        }
                    }
                    if (!this.f180a.f392a) {
                        this.f180a.d--;
                    }
                    if (this.f105b == 135 && this.f116c[this.f114h] < this.f181v[this.f182d[130] + this.c]) {
                        byte[] bArr = this.f116c;
                        int i5 = this.f114h;
                        bArr[i5] = (byte) (bArr[i5] + 1);
                    }
                    this.f110a[12] = 0;
                    break;
                case 3:
                    if (this.f178a.f319k == 3) {
                        this.f108n = true;
                        this.P = -1;
                        this.f106c = this.f105b;
                        this.f105b = (short) 139;
                        this.W = 125;
                        short s2 = this.f105b;
                        this.L = s2;
                        this.N = s2;
                        this.k = true;
                        this.f138b = true;
                        this.f178a.f319k = (byte) -1;
                    }
                    if (this.f105b == 145) {
                        this.f114h = this.f181v[this.f182d[67] + this.f178a.f319k] - 1;
                        z();
                        this.f105b = (short) -1;
                    }
                    this.f178a.f319k = (byte) -1;
                    break;
                case 4:
                    if (this.f105b == 137) {
                        if (this.f189x[6868 - this.f95a] < 0 && a(this.f114h, -1) >= 0) {
                            this.f114h = a(this.f114h, -1);
                            this.f138b = true;
                        }
                    } else if (!this.k && this.f105b >= 0 && this.f114h > 0) {
                        this.f114h--;
                    }
                    this.f110a[10] = 0;
                    break;
                case 5:
                    if (!this.k) {
                        if (this.f105b == 145) {
                            z();
                        }
                        if (this.k) {
                            this.f179a.a((byte) (-this.f95a), this.f189x[5454 - this.f95a] & 255);
                            this.f106c = (short) -1;
                        }
                        if (this.f105b == 136) {
                            this.f102d = this.f179a.u[this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h]];
                            if (this.f102d >= 15 && this.f178a.f311c[this.f178a.f315j][1] >= this.f181v[this.f182d[131] + this.c]) {
                                this.f102d = (byte) -1;
                                this.f108n = true;
                                this.P = -1;
                                this.f105b = (short) 139;
                                this.W = 30;
                                this.L = 136;
                                this.N = 136;
                                this.f138b = true;
                                z = true;
                            } else if (this.f102d < 15 || this.f178a.f311c[this.f178a.f315j][1] < 50) {
                                this.f189x[6868 - this.f95a] = (byte) this.f114h;
                                this.f103m = true;
                                this.f90b = (byte) p.a((int) this.f90b, this.f179a.c + 1, ((this.f179a.c + 8) - this.f178a.f327i[18][this.f102d]) - 1);
                                this.f91c = (byte) p.a((int) this.f91c, this.f179a.d + 1, ((this.f179a.d + this.f179a.f430i) - this.f178a.f327i[19][this.f102d]) - 1);
                                z = false;
                            } else {
                                this.f102d = (byte) -1;
                                this.f108n = true;
                                this.P = -1;
                                this.f105b = (short) 139;
                                this.W = 37;
                                this.f138b = true;
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (this.f105b == 135) {
                                if (this.f189x[6767 - this.f95a] >= 0) {
                                    for (i4 = this.f189x[6767 - this.f95a]; i4 < 60 && this.f179a.f410q[i4] == (-this.f95a); i4++) {
                                        this.f179a.f410q[i4] = 0;
                                    }
                                    this.f189x[6767 - this.f95a] = -1;
                                }
                                i = 0;
                                for (i2 = 0; i2 < this.B; i2++) {
                                    if (this.f116c[i2] > 0) {
                                        i++;
                                    }
                                }
                                if (i > 0) {
                                    bA2 = this.f179a.a(i);
                                    if (bA2 >= 0) {
                                        i3 = 0;
                                        b = 0;
                                        while (true) {
                                            b2 = b;
                                            if (b2 < this.B) {
                                                if (this.f116c[b2] > 0) {
                                                    this.f179a.f410q[bA2 + i3] = (byte) (-this.f95a);
                                                    this.f179a.o[bA2 + i3] = b2;
                                                    this.f179a.f409p[bA2 + i3] = this.f116c[b2];
                                                    i3++;
                                                }
                                                b = (byte) (b2 + 1);
                                            } else {
                                                this.f189x[6767 - this.f95a] = bA2;
                                            }
                                        }
                                    }
                                } else if (this.f189x[6868 - this.f95a] >= 0 && (bA = this.f179a.a(1)) >= 0) {
                                    this.f179a.f410q[bA] = (byte) (-this.f95a);
                                    this.f179a.o[bA] = this.f189x[6868 - this.f95a];
                                    this.f179a.f409p[bA] = 0;
                                    this.f189x[6767 - this.f95a] = bA;
                                }
                            }
                            if (this.f105b != 137) {
                                z2 = false;
                            } else if ((this.f179a.f414a & (1 << this.f114h)) == 0 || (this.f179a.f415b & (1 << this.f114h)) == 0) {
                                z2 = true;
                            } else if (this.f178a.f311c[this.f178a.f315j][4] >= this.f183e[this.f184f[7] + this.f114h]) {
                                this.f189x[6868 - this.f95a] = (byte) this.f114h;
                                this.f189x[6767 - this.f95a] = 100;
                                this.f189x[6565 - this.f95a] = 0;
                                this.f179a.f414a |= 1 << this.f114h;
                                short[] sArr = this.f178a.f311c[this.f178a.f315j];
                                sArr[4] = (short) (sArr[4] - this.f183e[this.f184f[7] + this.f114h]);
                                z2 = false;
                            } else {
                                this.f110a[5] = 0;
                                z2 = true;
                            }
                            if (z2) {
                            }
                            u();
                            this.f178a.f319k = (byte) -1;
                        }
                    }
                    break;
                case 6:
                    if (this.f105b == 137) {
                        if (this.f189x[6868 - this.f95a] < 0 && a(this.f114h, 1) >= 0) {
                            this.f114h = a(this.f114h, 1);
                            this.f138b = true;
                        }
                    } else if (!this.k && this.f105b >= 0 && this.f114h < this.B - 1) {
                        this.f114h++;
                    }
                    this.f110a[11] = 0;
                    break;
                case 7:
                case 9:
                    if (this.f105b == 145) {
                        this.f114h = this.f181v[this.f182d[67] + this.f178a.f319k] - 1;
                        z();
                        this.f105b = (short) -1;
                    }
                    this.f178a.f319k = (byte) -1;
                    break;
                case 8:
                    if (this.f105b == -1) {
                        this.f114h--;
                        if (this.f114h < 2) {
                            this.f114h = 2;
                        }
                    }
                    if (!this.f180a.f393b) {
                        this.f180a.d++;
                    }
                    if (this.f105b == 135 && this.f116c[this.f114h] > 0) {
                        byte[] bArr2 = this.f116c;
                        int i6 = this.f114h;
                        bArr2[i6] = (byte) (bArr2[i6] - 1);
                    }
                    this.f110a[13] = 0;
                    break;
                case 10:
                    if (this.k) {
                        this.f179a.a((byte) (-this.f95a), this.f189x[5454 - this.f95a] & 255);
                        this.f106c = (short) -1;
                    }
                    if (this.f105b == 136) {
                        this.f102d = this.f179a.u[this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h]];
                        if (this.f102d >= 15) {
                            if (this.f102d < 15) {
                            }
                            this.f189x[6868 - this.f95a] = (byte) this.f114h;
                            this.f103m = true;
                            this.f90b = (byte) p.a((int) this.f90b, this.f179a.c + 1, ((this.f179a.c + 8) - this.f178a.f327i[18][this.f102d]) - 1);
                            this.f91c = (byte) p.a((int) this.f91c, this.f179a.d + 1, ((this.f179a.d + this.f179a.f430i) - this.f178a.f327i[19][this.f102d]) - 1);
                            z = false;
                        } else {
                            if (this.f102d < 15) {
                            }
                            this.f189x[6868 - this.f95a] = (byte) this.f114h;
                            this.f103m = true;
                            this.f90b = (byte) p.a((int) this.f90b, this.f179a.c + 1, ((this.f179a.c + 8) - this.f178a.f327i[18][this.f102d]) - 1);
                            this.f91c = (byte) p.a((int) this.f91c, this.f179a.d + 1, ((this.f179a.d + this.f179a.f430i) - this.f178a.f327i[19][this.f102d]) - 1);
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (this.f105b == 135) {
                            if (this.f189x[6767 - this.f95a] >= 0) {
                                while (i4 < 60) {
                                    this.f179a.f410q[i4] = 0;
                                }
                                this.f189x[6767 - this.f95a] = -1;
                            }
                            i = 0;
                            while (i2 < this.B) {
                                if (this.f116c[i2] > 0) {
                                    i++;
                                }
                            }
                            if (i > 0) {
                                bA2 = this.f179a.a(i);
                                if (bA2 >= 0) {
                                    i3 = 0;
                                    b = 0;
                                    while (true) {
                                        b2 = b;
                                        if (b2 < this.B) {
                                            if (this.f116c[b2] > 0) {
                                                this.f179a.f410q[bA2 + i3] = (byte) (-this.f95a);
                                                this.f179a.o[bA2 + i3] = b2;
                                                this.f179a.f409p[bA2 + i3] = this.f116c[b2];
                                                i3++;
                                            }
                                            b = (byte) (b2 + 1);
                                        } else {
                                            this.f189x[6767 - this.f95a] = bA2;
                                        }
                                    }
                                }
                            } else if (this.f189x[6868 - this.f95a] >= 0) {
                                this.f179a.f410q[bA] = (byte) (-this.f95a);
                                this.f179a.o[bA] = this.f189x[6868 - this.f95a];
                                this.f179a.f409p[bA] = 0;
                                this.f189x[6767 - this.f95a] = bA;
                            }
                        }
                        if (this.f105b != 137) {
                            z2 = false;
                        } else if ((this.f179a.f414a & (1 << this.f114h)) == 0) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                        }
                        u();
                        this.f178a.f319k = (byte) -1;
                    }
                    break;
                case 11:
                    u();
                    this.f178a.f319k = (byte) -1;
                    break;
            }
        }
    }

    private void u() {
        if (this.f105b == 137 && this.f189x[6868 - this.f95a] < 0) {
            this.f189x[6565 - this.f95a] = (byte) this.f114h;
        }
        if (this.f106c < 0) {
            if (this.f105b != 145) {
                if (this.f178a.f290c) {
                    this.h = (short) 271;
                    this.f107v = (byte) 0;
                }
                this.k = false;
            }
            this.f105b = (short) -1;
            return;
        }
        if (this.f105b == 139 && this.f106c == 135 && !this.k) {
            this.f114h = 0;
        }
        this.f105b = this.f106c;
        this.f106c = (short) -1;
        this.f138b = true;
        this.k = false;
        this.f178a.f319k = (byte) -1;
    }

    private void v() {
        switch (this.f178a.f319k) {
            case -1:
                return;
            case 0:
            case 7:
            case 9:
            default:
                return;
            case 1:
            case 3:
                this.af = (this.f178a.f319k + 1) / 2;
                this.f89a = (byte) 4;
                this.f178a.f319k = (byte) -1;
                return;
            case 2:
                if (this.ae > 0) {
                    this.ae = Math.max(this.ae - (this.f178a.f321f == 0 ? 1 : 2), 0);
                    if (this.ac <= 0 || this.ae - this.ac >= 5) {
                        return;
                    }
                    this.ac -= 20;
                    this.f89a = (byte) 2;
                    return;
                }
                return;
            case 4:
                if (this.ad > 0) {
                    this.ad = Math.max(this.ad - (this.f178a.f321f == 0 ? 1 : 2), 0);
                    if (this.ab <= 0 || this.ad - this.ab >= 5) {
                        return;
                    }
                    this.ab -= 20;
                    this.f89a = (byte) 0;
                    return;
                }
                return;
            case 5:
            case 10:
                this.f90b = (byte) this.ad;
                this.f91c = (byte) this.ae;
                byte b = this.f179a.c;
                byte b2 = this.f179a.d;
                this.f179a.c = (byte) p.a(this.f90b - 4, 0, this.f179a.a - 8);
                this.f179a.d = (byte) p.a(this.f91c - (this.f179a.f430i / 2), 0, this.f179a.b - this.f179a.f430i);
                e(this.f179a.c - b, this.f179a.d - b2);
                A();
                if (this.f102d >= 0) {
                    n();
                }
                break;
            case 6:
                if (this.ad < this.f179a.a - 1) {
                    this.ad = Math.min(this.ad + (this.f178a.f321f == 0 ? 1 : 2), this.f179a.a - 1);
                    if (this.ab >= this.f179a.a - (this.X / this.af) || (this.ab + (this.X / this.af)) - this.ad >= 5) {
                        return;
                    }
                    this.ab += 20;
                    this.f89a = (byte) 1;
                    return;
                }
                return;
            case 8:
                if (this.ae < this.f179a.b - 1) {
                    this.ae = Math.min(this.ae + (this.f178a.f321f == 0 ? 1 : 2), this.f179a.b - 1);
                    if (this.ac >= this.f179a.b - (this.Y / this.af) || (this.ac + (this.Y / this.af)) - this.ae >= 5) {
                        return;
                    }
                    this.ac += 20;
                    this.f89a = (byte) 3;
                    return;
                }
                return;
            case 11:
                break;
        }
        this.f89a = (byte) 4;
        this.f178a.i = (byte) 1;
        this.f153t = true;
        this.f178a.f319k = (byte) -1;
    }

    private boolean c() {
        boolean z = false;
        if (this.P == 0) {
            int i = 0;
            if (a.b != null) {
                if (this.f114h == this.az) {
                    z = true;
                    a((String) null, o.f384a[3][9], this.P, false, true, 1, true, true);
                    a.e();
                    if (a.m2a(a.b)) {
                        this.f178a.a((String) null);
                    }
                } else if (this.f114h > this.az) {
                    i = 0 - 1;
                }
            }
            if (a.e != null) {
                if (this.f114h == this.aA) {
                    z = true;
                    a(o.f384a[3][1], "", a.e, 2);
                } else if (this.f114h > this.aA) {
                    i--;
                }
            }
            if (f.a()) {
                if (this.f114h == this.aB) {
                    z = true;
                    c(2);
                } else if (this.f114h > this.aB) {
                    i--;
                }
            }
            if (!z) {
                if (this.f114h == this.B - 1) {
                    i++;
                }
                this.f114h += i;
            }
        }
        if (z) {
            this.f178a.f319k = (byte) -1;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x011f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0126  */
    /* JADX WARN: Code duplicated, block: B:29:0x012f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0136  */
    /* JADX WARN: Code duplicated, block: B:32:0x0142  */
    /* JADX WARN: Code duplicated, block: B:37:0x015e  */
    private void w() {
        boolean z;
        if (this.f87n >= 0) {
            this.f87n = (byte) (this.f87n + 1);
            switch (this.f88o) {
                case 0:
                    if (this.f87n > this.f178a.f328f[6][294] - this.f178a.f328f[5][294]) {
                        this.f87n = (byte) 0;
                        if (this.b == 0 || this.b == 3 || this.b == 5) {
                            this.f88o = (byte) ((this.b / 2) + 1);
                        } else {
                            this.f88o = (byte) 4;
                        }
                        a(16, true);
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (this.f87n > this.f178a.f328f[6][(295 + this.f88o) - 1] - this.f178a.f328f[5][(295 + this.f88o) - 1]) {
                        this.f87n = (byte) 0;
                        this.f88o = (byte) 4;
                    }
                    break;
                case 4:
                    if (this.f87n > this.f178a.f328f[6][298 + this.b] - this.f178a.f328f[5][298 + this.b]) {
                        this.f87n = (byte) 0;
                    }
                    break;
            }
            if (this.f88o < 4) {
                this.f178a.f319k = (byte) -1;
                z = true;
            } else if (this.J != 0) {
                this.J = 0;
                z = true;
            } else if (this.h >= 0) {
                this.f178a.f319k = (byte) -1;
                z = true;
            } else if (this.P == 18 || this.f157O == 0) {
                z = false;
            } else {
                this.f178a.f319k = (byte) -1;
                z = true;
            }
        } else if (this.J != 0) {
            this.J = 0;
            z = true;
        } else if (this.h >= 0) {
            this.f178a.f319k = (byte) -1;
            z = true;
        } else if (this.P == 18) {
            z = false;
        } else {
            z = false;
        }
        if (z) {
        }
        if (this.f178a.f321f <= 0 || this.f178a.f321f > 2) {
            boolean z2 = this.f181v[(this.f182d[81] + this.P) + 1] - this.f181v[this.f182d[81] + this.P] > 0;
            boolean z3 = (this.f181v[this.f182d[89] + (this.P >> 3)] & (1 << (this.P & 7))) != 0;
            switch (this.f178a.f319k) {
                case 2:
                    if (z3) {
                        if (!this.f180a.f392a) {
                            this.f180a.d--;
                        }
                    } else if (this.f114h > 0) {
                        this.f114h--;
                        if (this.f114h < this.E) {
                            this.E = this.f114h;
                        }
                        this.J = this.f178a.f289b ? 1 : 0;
                    }
                    this.f110a[12] = 0;
                    break;
                case 3:
                case 7:
                case 9:
                    this.f178a.f319k = (byte) -1;
                    break;
                case 5:
                case 10:
                    this.f110a[14] = 0;
                    if (this.P == f121A) {
                        c(true);
                    } else if (this.P == f119y) {
                        b(true);
                    } else if (this.P != f120z) {
                        this.aF = this.P == 0 ? this.f114h : -1;
                        if (c()) {
                            if (this.aF != -1 && this.P == 0) {
                                this.f114h = this.aF;
                            }
                            this.aF = -1;
                        } else if (!d()) {
                            if (z2) {
                                byte b = this.f181v[this.f182d[80] + this.f181v[this.f182d[81] + this.P] + this.f114h];
                                if (this.f181v[this.f182d[83] + b] < 0 || !a((int) this.f181v[this.f182d[83] + b], true)) {
                                    byte b2 = this.f181v[this.f182d[80] + this.f181v[this.f182d[81] + this.P] + this.f114h];
                                    switch (this.f181v[this.f182d[83] + b2]) {
                                        case -18:
                                        case -17:
                                        case -15:
                                        case -14:
                                        case -13:
                                        case -12:
                                        case -11:
                                        case -10:
                                        case -9:
                                        case -8:
                                            switch (this.f181v[this.f182d[83] + b2]) {
                                                case -14:
                                                    if (this.M >= 0) {
                                                        a(this.M, false);
                                                        this.f114h = this.N;
                                                    } else {
                                                        this.f105b = (short) this.N;
                                                        this.f178a.i = (byte) 1;
                                                        this.f89a = (byte) 4;
                                                        this.f137s = false;
                                                    }
                                                    break;
                                                case -12:
                                                    if (this.K >= 0) {
                                                        a(this.K, false);
                                                        this.f114h = this.L;
                                                    } else {
                                                        this.f105b = (short) this.L;
                                                        this.f178a.i = (byte) 1;
                                                        this.f89a = (byte) 4;
                                                        this.f137s = false;
                                                    }
                                                    break;
                                                case -9:
                                                    int i = this.f178a.f284b;
                                                    while (true) {
                                                        int i2 = (byte) ((i + 1) % 3);
                                                        if (i2 <= this.f178a.f285c && i2 >= this.f178a.f286d) {
                                                            f(this.f178a.f284b, i2);
                                                            H();
                                                        } else {
                                                            i = i2;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                case -8:
                                                    boolean z4 = !c.f28a;
                                                    c.f28a = z4;
                                                    if (!z4) {
                                                        this.f178a.e();
                                                    } else {
                                                        this.f178a.d();
                                                    }
                                                    break;
                                            }
                                            break;
                                        case -7:
                                        case -2:
                                            a(b2);
                                            break;
                                        case -6:
                                        case -5:
                                        case -4:
                                        case -3:
                                            b(b2);
                                            break;
                                    }
                                }
                            }
                            if (this.P == 18) {
                                if (this.f156N + 1 >= this.f181v[(this.f182d[139] + this.f155h) + 1] - this.f181v[this.f182d[139] + this.f155h] || this.f181v[this.f182d[141] + this.f181v[this.f182d[139] + this.f155h] + this.f156N] != this.f181v[this.f182d[141] + this.f181v[this.f182d[139] + this.f155h] + this.f156N + 1]) {
                                    this.f157O = (byte) -1;
                                } else {
                                    this.f156N = (byte) (this.f156N + 1);
                                    this.W = this.f181v[this.f182d[139] + this.f155h] + this.f156N;
                                    this.f138b = true;
                                }
                            }
                            if (this.aF != -1 && this.P == 0) {
                                this.f114h = this.aF;
                            }
                            this.aF = -1;
                            this.f178a.f319k = (byte) -1;
                        } else {
                            if (this.aF != -1 && this.P == 0) {
                                this.f114h = this.aF;
                            }
                            this.aF = -1;
                        }
                    } else {
                        this.f178a.a((String) null);
                    }
                    break;
                case 8:
                    if (z3) {
                        if (!this.f180a.f393b) {
                            this.f180a.d++;
                        }
                    } else if (this.f114h < this.B - 1) {
                        this.f114h++;
                        if (this.f114h >= this.E + this.F) {
                            this.E = (this.f114h - this.F) + 1;
                        }
                        this.J = this.f178a.f289b ? -1 : 0;
                    }
                    this.f110a[13] = 0;
                    break;
                case 11:
                    this.f110a[15] = 0;
                    if (this.P == f121A) {
                        c(false);
                    } else if (this.P == f119y) {
                        b(false);
                    } else if (this.P != f120z) {
                        x();
                        this.f178a.f319k = (byte) -1;
                    } else {
                        this.f178a.a((String) null);
                    }
                    break;
            }
        }
    }

    private boolean d() {
        if (this.P == 28) {
            this.f86a = true;
            H();
        }
        if (this.P == 0 && this.f114h <= 1) {
            this.t = this.f114h;
        }
        if (this.P == 57) {
            this.K = 57;
            this.L = this.f114h;
            a(58, true);
            this.f178a.f319k = (byte) -1;
            return true;
        }
        if (this.P == 8) {
            if (this.f162c[this.f114h] == 0) {
                a(59, true);
            } else {
                this.M = 8;
                this.K = 8;
                int i = this.f114h;
                this.N = i;
                this.L = i;
                a(this.f163u[this.f114h] < 2 ? 54 : 55, true);
            }
            this.f178a.f319k = (byte) -1;
            return true;
        }
        if (this.P == 59 || this.P == 48) {
            return true;
        }
        if (this.P == 15 && this.W < this.f181v[this.f182d[139] + 1] - 1) {
            this.W++;
            this.f138b = true;
            this.f178a.f319k = (byte) -1;
            return true;
        }
        if (this.P == 63 && this.W != 51) {
            this.W = 51;
            this.f138b = true;
            this.f178a.f319k = (byte) -1;
            return true;
        }
        if (this.P == 9 && this.t == 0) {
            this.f87n = (byte) 0;
            if (this.b == 0) {
                this.f88o = (byte) 0;
                this.f178a.f319k = (byte) -1;
                return true;
            }
            if (this.b == 0) {
                this.f88o = (byte) 1;
            } else if (this.b == 3) {
                this.f88o = (byte) 2;
            } else if (this.b == 5) {
                this.f88o = (byte) 3;
            } else {
                this.f88o = (byte) 4;
            }
        }
        if (this.P == 27) {
            c.f28a = true;
            this.f178a.d();
        }
        if (this.P == 10) {
            this.d = this.f114h;
            if (this.t == 0) {
                this.p = this.d;
            } else {
                this.q = this.d;
            }
            H();
        }
        if (this.P != 12) {
            return false;
        }
        if ((this.t != 0 || this.b >= 0) && this.b <= 6) {
            if (this.t != 1) {
                return false;
            }
            this.P = -1;
            a(0, true);
            this.f178a.f319k = (byte) -1;
            return true;
        }
        this.P = 0;
        this.M = 0;
        this.K = 0;
        this.N = 0;
        this.L = 0;
        boolean z = false;
        if (this.t != 0) {
            byte b = (byte) (this.b - 6);
            a(33, true);
            f227z[b - 1] = 1;
            H();
            boolean z2 = true;
            for (int i2 = 0; i2 < f227z.length; i2++) {
                if (f227z[i2] == 0) {
                    z2 = false;
                }
            }
            if (z2) {
                f226y[1] = 1;
                for (int i3 = 0; i3 < f227z.length; i3++) {
                    f227z[i3] = 0;
                }
                H();
                z = true;
            }
        } else {
            a(47, true);
            f226y[0] = 1;
            H();
            z = true;
        }
        if (f.a() && z) {
            a((String) null, o.f384a[3][42], (int) f124D, true, true, 9, false, true);
        }
        this.f178a.f319k = (byte) -1;
        return true;
    }

    private void a(byte b) {
        if (c.f28a && a.a("PSNDSTP", false)) {
            this.f178a.d();
        }
        switch (this.f181v[this.f182d[83] + b]) {
            case -7:
                this.f155h = (byte) -1;
                this.f138b = true;
                if (this.f178a.f290c) {
                    this.h = (short) 271;
                    this.f107v = (byte) 0;
                } else {
                    this.f178a.i = (byte) 1;
                    this.f89a = (byte) 4;
                    this.f137s = false;
                    if (this.f106c >= 0) {
                        this.f105b = this.f106c;
                        this.f106c = (short) -1;
                        this.f95a = (short) this.K;
                        this.f114h = this.L;
                    }
                }
                this.f178a.f345g = -1;
                this.f178a.f319k = (byte) -1;
                break;
            case -2:
                if (this.t != 0) {
                    if (this.o < 0) {
                        this.W = 0;
                        a(9, true);
                    } else {
                        this.b = this.o;
                        this.l = false;
                        if (b()) {
                            J();
                        }
                    }
                } else if (this.n > this.m) {
                    this.b = this.n;
                    this.W = 0;
                    a(9, true);
                } else {
                    this.b = this.m;
                    this.l = false;
                    if (b()) {
                        J();
                    }
                }
                this.f178a.i = (byte) 1;
                this.f137s = false;
                this.f89a = (byte) 4;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:44:0x012d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0138  */
    /* JADX WARN: Code duplicated, block: B:47:0x014e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0172  */
    private void b(byte b) {
        switch (this.f181v[this.f182d[83] + b]) {
            case -6:
                if (p.f525a == null) {
                    this.f178a.a((String) null);
                } else {
                    for (int i = 0; i < p.f525a.length; i++) {
                        if (a.a(p.f525a[i], m51a()) > 0) {
                            a.d = null;
                            a.c = a.b(a.h);
                            if (this.t == 0) {
                                this.r = 0;
                                this.s = 0;
                                this.o = -1;
                                F();
                            } else if (this.b == 0) {
                                this.r = 0;
                                this.s = 0;
                                this.n = 0;
                                this.m = -1;
                                this.f178a.f311c[this.f178a.f315j][10] = 0;
                                H();
                                F();
                            } else {
                                G();
                                if (this.r > 0) {
                                    this.s++;
                                    this.r = 0;
                                    F();
                                }
                            }
                            this.f87n = (byte) -1;
                            this.l = true;
                            if (b()) {
                                this.f178a.i = (byte) 1;
                                this.f137s = false;
                                this.f89a = (byte) 4;
                                if (c.f28a && a.a("PSNDSTP", false)) {
                                    this.f178a.d();
                                }
                                this.f178a.f345g = -1;
                                this.f178a.f319k = (byte) -1;
                            }
                        }
                        break;
                    }
                    if (this.t == 0) {
                        this.r = 0;
                        this.s = 0;
                        this.o = -1;
                        F();
                    } else if (this.b == 0) {
                        this.r = 0;
                        this.s = 0;
                        this.n = 0;
                        this.m = -1;
                        this.f178a.f311c[this.f178a.f315j][10] = 0;
                        H();
                        F();
                    } else {
                        G();
                        if (this.r > 0) {
                            this.s++;
                            this.r = 0;
                            F();
                        }
                    }
                    this.f87n = (byte) -1;
                    this.l = true;
                    if (b()) {
                        this.f178a.i = (byte) 1;
                        this.f137s = false;
                        this.f89a = (byte) 4;
                        if (c.f28a) {
                            this.f178a.d();
                        }
                        this.f178a.f345g = -1;
                        this.f178a.f319k = (byte) -1;
                    }
                }
                break;
            case -5:
                this.f178a.a((String) null);
                break;
            case -4:
                if (a.d != null && a.c == null && p.f525a != null) {
                    for (int i2 = 0; i2 < p.f525a.length; i2++) {
                        if (a.a(p.f525a[i2], m51a()) > 0) {
                            a.d = null;
                        }
                        break;
                    }
                    a((String) null, o.f384a[1][42], (int) f124D, true, true, 7, false, true);
                    break;
                }
                break;
            case -3:
                I();
                if (this.t == 0) {
                    this.m = this.b;
                } else {
                    this.o = this.b;
                }
                H();
                a(this.H, true);
                break;
        }
    }

    private void x() {
        if (this.P == 28) {
            this.f86a = false;
            H();
        }
        if (this.P == 14 && !this.f137s) {
            this.H = 1;
            this.f115i = 5;
        }
        if (this.f181v[this.f182d[85] + this.P] == -20) {
            a(61, false);
            this.f114h = 0;
            return;
        }
        if (this.f181v[this.f182d[85] + this.P] == -12) {
            if (this.K >= 0) {
                a(this.K, false);
                this.f114h = this.L;
                return;
            } else {
                this.f105b = (short) this.L;
                this.f178a.i = (byte) 1;
                this.f89a = (byte) 4;
                return;
            }
        }
        if (this.f181v[this.f182d[85] + this.P] >= -2 && this.H >= 0) {
            a(this.H, false);
            return;
        }
        if (this.f181v[this.f182d[85] + this.P] != -2) {
            if (this.f181v[this.f182d[85] + this.P] >= 0) {
                a((int) this.f181v[this.f182d[85] + this.P], false);
                return;
            }
            return;
        }
        if (this.f160k >= 0) {
            this.f155h = this.f160k;
            this.f160k = (byte) -1;
            this.P = -1;
            a(17, true);
            this.f138b = true;
            return;
        }
        if (this.P == 18 && this.f179a.f419f >= 50) {
            a((25 + this.f179a.f418e) - 1, true);
            return;
        }
        if (this.P == 2 && this.W >= 85) {
            this.f114h = this.L;
        }
        if (this.P == 1 && c.f28a && a.a("PSNDSTP", false)) {
            this.f178a.d();
        }
        if (!this.f178a.f290c || (this.P == 2 && this.W >= 85)) {
            this.f178a.i = (byte) 1;
            this.f89a = (byte) 4;
            if (this.f106c >= 0) {
                this.f105b = this.f106c;
                this.f106c = (short) -1;
                this.f95a = (short) this.K;
                this.f114h = this.L;
            }
        } else {
            this.h = (short) 271;
            this.f107v = (byte) 0;
        }
        this.f155h = (byte) -1;
        this.f157O = (byte) 0;
        this.f138b = true;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x02d4  */
    private void y() {
        char c;
        short s;
        short s2;
        if (this.f95a > (this.f178a.f315j ^ 1) * 50 && this.f95a <= ((this.f178a.f315j ^ 1) + 1) * 50) {
            c = 1;
        } else if ((-this.f95a) <= (this.f178a.f315j ^ 1) * 50 || (-this.f95a) > ((this.f178a.f315j ^ 1) + 1) * 50) {
            c = (this.f95a < 1001 + ((this.f178a.f315j ^ 1) * 100) || this.f95a >= 1001 + (((this.f178a.f315j ^ 1) + 1) * 100)) ? (char) 0 : (char) 3;
        } else {
            c = 2;
        }
        char c2 = c;
        for (int i = 0; i < this.f190c[0][50]; i++) {
            if ((this.f189x[2929 + this.f190c[0][i]] & 96) == 0) {
                this.f189x[1717 + this.f190c[0][i]] = (byte) (c2 == 2 ? this.f191d[3][this.f189x[2323 + this.f190c[0][i]]] > 1 ? this.f189x[5252 - this.f95a] : p.a((int) this.f189x[0 + this.f190c[0][i]], (int) this.f189x[6363 - this.f95a], (this.f189x[6363 - this.f95a] + this.f178a.f327i[18][this.f189x[5656 - this.f95a]]) - 1) : this.f92p);
                this.f189x[1818 + this.f190c[0][i]] = (byte) (c2 == 2 ? this.f191d[3][this.f189x[2323 + this.f190c[0][i]]] > 1 ? this.f189x[5353 - this.f95a] : p.a((int) this.f189x[101 + this.f190c[0][i]], (int) this.f189x[6464 - this.f95a], (this.f189x[6464 - this.f95a] + this.f178a.f327i[19][this.f189x[5656 - this.f95a]]) - 1) : this.f93q);
                this.f189x[1111 + this.f190c[0][i]] = 0;
                this.f189x[4545 + this.f190c[0][i]] = 0;
                if (this.f178a.f293e < 2) {
                    s = (c2 <= 0 || this.f191d[3][this.f189x[2323 + this.f190c[0][i]]] <= 0 || (((this.f178a.f301a[1][this.f92p >> 5][this.f93q] >> (this.f92p & 31)) & 1) == 0 && (((this.f178a.f301a[0][this.f92p >> 5][this.f93q] >> (this.f92p & 31)) & 1) == 0 || c2 < 2))) ? (short) 0 : c2 <= 2 ? this.f95a : (short) 126;
                } else if (this.f178a.f293e == 2) {
                    if (c2 <= 0 || this.f191d[3][this.f189x[2323 + this.f190c[0][i]]] <= 0) {
                        s2 = 0;
                    } else {
                        int[] iArr = null;
                        if (((iArr[this.f93q] >> (this.f92p & 31)) & 1) != 0) {
                            s2 = c2 <= 2 ? this.f95a : (short) 126;
                        } else {
                            s2 = 0;
                        }
                    }
                    s = s2;
                } else {
                    s = (c2 <= 0 || this.f191d[3][this.f189x[2323 + this.f190c[0][i]]] <= 0) ? (short) 0 : c2 <= 2 ? this.f95a : (short) 126;
                }
                this.f189x[1919 + this.f190c[0][i]] = (byte) s;
                this.f189x[3131 + this.f190c[0][i]] = c2 == 3 ? (byte) 0 : c2 == 1 ? this.f189x[3030 + this.f95a] : this.f189x[5858 - this.f95a];
                this.f189x[707 + this.f190c[0][i]] = this.f189x[404 + this.f190c[0][i]];
                this.f189x[1515 + this.f190c[0][i]] = 1;
                a(c2 > 0 ? (short) 248 : (short) 246);
            }
        }
        this.f178a.f322l = (byte) 0;
    }

    private void z() {
        switch (this.f114h) {
            case 2:
                for (int i = 0; i < this.f190c[0][50]; i++) {
                    if ((this.f189x[2929 + this.f190c[0][i]] & 96) == 0 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] >= 0 && ((this.f150M == 0 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] > this.f189x[2323 + this.f190c[0][i]]) || (this.f150M == 1 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] < this.f189x[2323 + this.f190c[0][i]]))) {
                        byte[] bArr = this.f189x;
                        int i2 = 2929 + this.f190c[0][i];
                        bArr[i2] = (byte) (bArr[i2] | 32);
                    }
                }
                break;
            case 3:
                for (int i3 = 0; i3 < this.f190c[0][50]; i3++) {
                    if ((this.f189x[2929 + this.f190c[0][i3]] & 96) == 0 && this.f181v[this.f182d[58] + this.f189x[2323 + this.f190c[0][i3]]] >= 2) {
                        this.f189x[1717 + this.f190c[0][i3]] = this.f90b;
                        this.f189x[1818 + this.f190c[0][i3]] = this.f91c;
                        this.f189x[1919 + this.f190c[0][i3]] = 127;
                        this.f189x[1111 + this.f190c[0][i3]] = 0;
                        this.f189x[4545 + this.f190c[0][i3]] = 0;
                        this.f189x[707 + this.f190c[0][i3]] = this.f189x[404 + this.f190c[0][i3]];
                        this.f189x[1515 + this.f190c[0][i3]] = 1;
                        a((short) 248);
                    }
                }
                break;
        }
        this.f178a.f319k = (byte) -1;
        this.f228C = false;
    }

    final int a(int i, int i2) {
        do {
            i += i2;
            if (i < (this.f178a.f315j == 0 ? 0 : 24)) {
                return -1;
            }
            if (i >= (this.f178a.f315j == 0 ? 24 : 48)) {
                return -1;
            }
        } while ((this.f179a.f416c & (1 << i)) != 0);
        return i;
    }

    private boolean a(int i, boolean z) {
        while (true) {
            if (i == 7) {
                i = f125E;
            } else if (i == 57) {
                i = f126F;
            } else if (i == 6 || (i == 5 && this.o < 0)) {
                i = f127G;
            } else if (i == f121A) {
                i = O;
            }
            synchronized (this.f221b) {
                if (!z) {
                    if (this.f221b.size() > 0) {
                        for (int i2 = r0 - 1; i2 >= 0; i2--) {
                            int[] iArr = (int[]) this.f221b.elementAt(i2);
                            this.f221b.removeElementAt(i2);
                            int i3 = iArr[0];
                            this.f115i = iArr[1];
                            this.I = iArr[2];
                            if (i == f124D) {
                                i = iArr[0];
                                break;
                            }
                            if (i3 == i) {
                                break;
                            }
                        }
                    }
                } else {
                    this.f221b.addElement(new int[]{this.P == f121A ? O : this.P, this.aF != -1 ? this.aF : this.f114h, this.E});
                }
                if (i == 0 || i == 1) {
                    if (i == 1 && c.f28a && a.a("PSNDSTP", false)) {
                        this.f178a.e();
                    } else if (i == 0 && c.f28a && a.a("PSNDSTP", false)) {
                        this.f178a.d();
                    }
                    this.f221b.removeAllElements();
                    a.e();
                }
            }
            if (a.f8d) {
                if (i == 0 || (this.f137s && (i == 14 || i == f127G || i == 11 || i == 14 || i == 2))) {
                    d.a();
                    d.d();
                    if (d.m16a() == 1) {
                        a.b = null;
                    }
                } else {
                    d.c();
                }
            }
            if (i == f127G) {
                f.m26a();
                a.e();
                this.f222c = new Vector();
                this.f223d = new Vector();
                this.f222c.addElement(o.f384a[0][14]);
                this.f223d.addElement(new Integer(f125E));
                if (f.a()) {
                    this.f222c.addElement(o.f384a[0][13]);
                    this.aR = 0;
                    this.f223d.addElement(new Integer(f.b() ? f129I : f122B));
                }
                if (a.f4a != null) {
                    this.f222c.addElement(o.f384a[3][20]);
                    this.f223d.addElement(new Integer(f128H));
                }
                if (f.a()) {
                    this.f222c.addElement(o.f384a[0][40]);
                    this.f223d.addElement(new Integer(f126F));
                }
                f130a = a.a(this.f222c);
                f131a = a.m6a(this.f223d);
                f132a = o.f384a[0][1];
                O = i;
                f133p = true;
                f134q = true;
                this.t = 1;
                i = f121A;
                this.f223d = null;
                this.f222c = null;
                a.e();
            } else if (i == f122B) {
                this.f222c = new Vector();
                f130a = null;
                if (f.f59b) {
                    this.f222c.addElement(o.f384a[3][14]);
                }
                if (f.f58a) {
                    this.f222c.addElement(o.f384a[3][15]);
                }
                if (this.f222c.size() > 0) {
                    if (!f.f61d) {
                        this.f222c.addElement(o.f384a[3][46]);
                    }
                    if (f.f60c) {
                        this.f222c.addElement(o.f384a[0][2]);
                    }
                    if (this.f222c.size() > 1) {
                        f130a = a.a(this.f222c);
                    }
                }
                f131a = null;
                f132a = o.f384a[3][21];
                O = i;
                f133p = true;
                f134q = true;
                i = f121A;
                this.f222c = null;
                if (f130a == null) {
                    if (z) {
                        this.P = i;
                        this.f114h = 0;
                        this.c(true);
                        return true;
                    }
                    z = false;
                    i = f124D;
                    this = this;
                }
            } else if (i == f129I) {
                this.f222c = new Vector();
                this.f222c.addElement(o.f384a[0][13]);
                this.f222c.addElement(o.f384a[3][32]);
                if (!f.f62e && f.m25a().m33b() != null) {
                    this.f222c.addElement(o.f384a[3][33]);
                }
                f130a = a.a(this.f222c);
                f131a = null;
                f132a = null;
                f132a = new StringBuffer().append(o.f384a[3][30]).append(": ").append(f.m25a().m28a(false)).toString();
                O = i;
                f133p = true;
                f134q = true;
                this.f222c = null;
                i = f121A;
            } else if (i == f125E || i == f126F) {
                Vector vector = new Vector();
                if (i == f125E) {
                    for (int i4 = 0; i4 < this.f200a.length; i4++) {
                        if (this.f200a[i4]) {
                            vector.addElement(o.f384a[0][i4 + 87]);
                        }
                    }
                }
                for (int i5 = 0; i5 < this.f201a.size(); i5++) {
                    vector.addElement(new StringBuffer().append(((String[]) this.f201a.elementAt(i5))[1]).append(i == f125E ? f206f : "").toString());
                }
                if (vector.size() <= 0) {
                    if (this.f221b.size() > 0 && z) {
                        this.f221b.removeElementAt(this.f221b.size() - 1);
                    }
                    this.a((String) null, o.f384a[1][40], (int) f127G, false, true, 0, false, true);
                    return false;
                }
                f130a = a.a(vector);
                f131a = null;
                f132a = o.f384a[0][i == f125E ? (char) 14 : '('];
                O = i;
                f133p = true;
                f134q = true;
                i = f121A;
                a.e();
            } else if (i == f123C) {
                f130a = new String[this.f203b[1].length];
                for (int i6 = 0; i6 < f130a.length; i6++) {
                    f130a[i6] = this.f203b[1][i6];
                    if (this.a(this.f203b[0][i6])) {
                        StringBuffer stringBuffer = new StringBuffer();
                        String[] strArr = f130a;
                        int i7 = i6;
                        strArr[i7] = stringBuffer.append(strArr[i7]).append(f204d).toString();
                    } else if (Integer.parseInt(this.f203b[3][i6]) > 0) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        String[] strArr2 = f130a;
                        int i8 = i6;
                        strArr2[i8] = stringBuffer2.append(strArr2[i8]).append(f205e).toString();
                    }
                }
                f131a = null;
                f132a = o.f384a[0][13];
                O = i;
                f133p = true;
                f134q = true;
                i = f121A;
            } else if (i == f128H) {
                f130a = new String[this.f200a.length];
                for (int i9 = 0; i9 < this.f200a.length; i9++) {
                    f130a[i9] = o.f384a[0][i9 + 87];
                    if (this.f200a[i9]) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        String[] strArr3 = f130a;
                        int i10 = i9;
                        strArr3[i10] = stringBuffer3.append(strArr3[i10]).append(f204d).toString();
                    }
                }
                f131a = null;
                f132a = o.f384a[3][20];
                O = i;
                f133p = true;
                f134q = true;
                i = f121A;
            } else if (this.P == f121A) {
                f130a = null;
                f131a = null;
                f132a = null;
                a.e();
            }
            if (i == 12 && this.f208w) {
                this.f208w = false;
                f218A = true;
                this.a((String) null, o.f384a[3][12], 12, true, false, 0, false, false);
                this.f178a.f319k = (byte) -1;
                return true;
            }
            if (i == 6 || ((i == 5 && this.o < 0) || i != 33)) {
                if (i == 30) {
                    i = 31;
                }
                if (i == 4) {
                    if (this.m < 0 && this.n <= 0) {
                        this.t = 0;
                        this.P = 23;
                        this.f114h = 0;
                        i = 10;
                    }
                } else if (i == 16) {
                    if (this.t == 1) {
                        this.P = 16;
                        this.f114h = 0;
                        return false;
                    }
                } else if (i == 28 && this.t == 1) {
                    this.P = 28;
                    this.f114h = 0;
                    i = 9;
                }
                if (i == 0) {
                    this.b = 0;
                }
                if (this.P == 14) {
                    this.W = 1 + this.f114h;
                    this.f138b = true;
                }
                if (z) {
                    if ((this.P >= 19 || (i >= 25 && i < 29)) && this.P < f118x) {
                        this.H = -1;
                        this.I = 0;
                    } else {
                        this.H = this.P == f121A ? O : this.P;
                        this.f115i = this.f114h;
                        if (this.aF != -1) {
                            this.f115i = this.aF;
                        }
                        this.I = this.E;
                    }
                    this.f114h = 0;
                    this.E = 0;
                } else {
                    if (this.P != 28) {
                        this.f114h = this.f115i >= 0 ? this.f115i : this.f181v[this.f182d[86] + this.P];
                        this.E = this.I;
                        if (i == 0 && this.f115i < 0 && this.P < 18 && this.f114h > 1) {
                            if (a.b != null) {
                                this.f114h++;
                            }
                            if (a.e != null) {
                                this.f114h++;
                            }
                            if (f.a()) {
                                this.f114h++;
                            }
                        }
                    } else {
                        this.E = 0;
                        this.f114h = 0;
                    }
                    this.f115i = -1;
                    this.H = -1;
                    this.I = 0;
                }
                if (this.P < 0 || (this.f181v[this.f182d[88] + (i >> 3)] & (1 << (i & 7))) == 0) {
                    this.f89a = (byte) 4;
                }
                this.P = i;
                if (i == f120z) {
                    this.P = 3;
                }
                this.f135r = true;
                if (this.P == 4) {
                    this.t = 0;
                } else if (this.P == 5) {
                    this.t = 1;
                }
                if (this.P == 9) {
                    this.W = -1;
                }
                if (this.f181v[this.f182d[84] + this.P] >= 0 || i == f120z) {
                    g gVar = this;
                    gVar.W = this.f181v[this.f182d[84] + this.P] == 127 ? 126 : this.f181v[this.f182d[84] + this.P] + (this.P >= 19 ? (byte) 12 : (byte) 0);
                    this.f138b = true;
                }
                if (this.P == 17) {
                    this.W = this.f181v[this.f182d[139] + this.f158i + this.f179a.f447m];
                    this.f138b = true;
                }
                if (i == f120z) {
                    this.P = f120z;
                }
                if (this.P == f121A && O == f127G && this.f208w) {
                    this.f208w = false;
                    this.a((String) null, o.f384a[3][12], (int) f124D, false, true, 0, false, true);
                }
                if (this.P != 0 && this.P != 9) {
                    return true;
                }
                this.f137s = true;
                return true;
            }
            z = false;
            i = 0;
            this = this;
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        m45a(0);
        for (int iMin = Math.min(i, i3); iMin <= Math.max(i, i3); iMin++) {
            for (int iMin2 = Math.min(i2, i4); iMin2 <= Math.max(i2, i4); iMin2++) {
                if (this.f195b[iMin2][iMin] > this.f178a.f315j * 50 && this.f195b[iMin2][iMin] <= (this.f178a.f315j + 1) * 50 && this.f189x[1616 + this.f195b[iMin2][iMin]] > 0) {
                    this.f190c[0][this.f190c[0][50]] = (byte) this.f195b[iMin2][iMin];
                    byte[] bArr = this.f189x;
                    int i5 = 2929 + this.f195b[iMin2][iMin];
                    bArr[i5] = (byte) (bArr[i5] | 1);
                    byte[] bArr2 = this.f190c[0];
                    bArr2[50] = (byte) (bArr2[50] + 1);
                }
            }
        }
        this.f228C = false;
        this.f111o = false;
        m46c();
    }

    private void d(int i, int i2) {
        if (this.f190c[i][50] <= 0) {
            return;
        }
        m45a(i2);
        for (int i3 = 0; i3 < this.f190c[i][50]; i3++) {
            if (i2 > 0) {
                for (int i4 = 1; i4 <= 4; i4++) {
                    if ((this.f189x[2929 + this.f190c[i][i3]] & (1 << i4)) != 0) {
                        byte[] bArr = this.f189x;
                        int i5 = 2929 + this.f190c[i][i3];
                        bArr[i5] = (byte) (bArr[i5] & ((1 << i4) ^ (-1)));
                        int i6 = 0;
                        while (i6 < this.f190c[i4][50]) {
                            if (this.f190c[i4][i6] == this.f190c[i][i3]) {
                                while (i6 < this.f190c[i4][50] - 1) {
                                    this.f190c[i4][i6] = this.f190c[i4][i6 + 1];
                                    i6++;
                                }
                                byte[] bArr2 = this.f190c[i4];
                                bArr2[50] = (byte) (bArr2[50] - 1);
                                break;
                            }
                            i6++;
                        }
                    }
                }
            }
            this.f190c[i2][i3] = this.f190c[i][i3];
            byte[] bArr3 = this.f189x;
            int i7 = 2929 + this.f190c[i2][i3];
            bArr3[i7] = (byte) (bArr3[i7] | (1 << i2));
        }
        this.f190c[i2][50] = this.f190c[i][50];
        this.f144j = Math.max(i, i2);
        if (i2 == 0) {
            this.f228C = false;
            this.f111o = false;
            m46c();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m45a(int i) {
        for (int i2 = 0; i2 < this.f190c[i][50]; i2++) {
            byte[] bArr = this.f189x;
            int i3 = 2929 + this.f190c[i][i2];
            bArr[i3] = (byte) (bArr[i3] & ((1 << i) ^ (-1)));
        }
        this.f190c[i][50] = 0;
        this.f144j = 0;
        m46c();
        if (i == 0) {
            this.f111o = false;
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    final void m46c() {
        this.C = 0;
        this.f150M = (byte) 1;
        for (int i = 0; i < this.f190c[0][50]; i++) {
            if (this.f181v[this.f182d[58] + this.f189x[2323 + this.f190c[0][i]]] > this.C) {
                this.C = this.f181v[this.f182d[58] + this.f189x[2323 + this.f190c[0][i]]];
            }
            if (this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] >= 0 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] > this.f189x[2323 + this.f190c[0][i]]) {
                this.f150M = (byte) 0;
            }
        }
    }

    private void A() {
        if (this.f141f < 0) {
            return;
        }
        this.f143L = (byte) 0;
        for (int iMin = Math.min((int) this.f90b, (int) this.f141f); iMin <= Math.max((int) this.f90b, (int) this.f141f); iMin++) {
            for (int iMin2 = Math.min((int) this.f91c, (int) this.f142K); iMin2 <= Math.max((int) this.f91c, (int) this.f142K); iMin2++) {
                if (this.f195b[iMin2][iMin] > this.f178a.f315j * 50 && this.f195b[iMin2][iMin] <= (this.f178a.f315j + 1) * 50 && this.f189x[1616 + this.f195b[iMin2][iMin]] > 0) {
                    this.f143L = (byte) (this.f143L + 1);
                }
            }
        }
    }

    private void B() {
        if (this.f190c[0][50] <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 1000;
        byte b = 0;
        for (int i4 = 0; i4 < this.f190c[0][50]; i4++) {
            i += this.f189x[0 + this.f190c[0][i4]];
            i2 += this.f189x[101 + this.f190c[0][i4]];
        }
        int i5 = i / this.f190c[0][50];
        int i6 = i2 / this.f190c[0][50];
        for (int i7 = 0; i7 < this.f190c[0][50]; i7++) {
            int iAbs = Math.abs(i5 - this.f189x[0 + this.f190c[0][i7]]) + Math.abs(i6 - this.f189x[101 + this.f190c[0][i7]]);
            if (iAbs < i3) {
                i3 = iAbs;
                b = this.f190c[0][i7];
            }
        }
        this.f90b = this.f189x[b + 0];
        this.f91c = this.f189x[b + 101];
        m47d();
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    final void m47d() {
        byte b = this.f179a.c;
        byte b2 = this.f179a.d;
        this.f179a.c = (byte) p.a(this.f90b - 4, 0, this.f179a.a - 8);
        this.f179a.d = (byte) p.a(this.f91c - (this.f179a.f430i / 2), 0, this.f179a.b - this.f179a.f430i);
        e(this.f179a.c - b, this.f179a.d - b2);
        this.f89a = (byte) 4;
    }

    private void e(int i, int i2) {
        int i3 = i >= 0 ? 0 : 10;
        while (true) {
            int i4 = i3;
            if ((i < 0 || i4 >= 11) && (i >= 0 || i4 < 0)) {
                break;
            }
            int i5 = i2 >= 0 ? 0 : (k.f276a + 2) - 1;
            while (true) {
                int i6 = i5;
                if ((i2 < 0 || i6 >= k.f276a + 2) && (i2 >= 0 || i6 < 0)) {
                    break;
                }
                if (i4 + i < 0 || i6 + i2 < 0 || i4 + i >= 11 || i6 + i2 >= k.f276a + 2) {
                    this.f193f[i6][i4] = -1;
                } else {
                    this.f193f[i6][i4] = this.f193f[i6 + i2][i4 + i];
                }
                i5 = i6 + (i2 >= 0 ? 1 : -1);
            }
            i3 = i4 + (i >= 0 ? 1 : -1);
        }
        for (int i7 = 0; i7 < 50; i7++) {
            if (this.f192e[1][i7] != -1) {
                byte[] bArr = this.f192e[2];
                int i8 = i7;
                bArr[i8] = (byte) (bArr[i8] - i);
                byte[] bArr2 = this.f192e[3];
                int i9 = i7;
                bArr2[i9] = (byte) (bArr2[i9] - i2);
                if (this.f192e[2][i7] < 0 || this.f192e[3][i7] < 0 || this.f192e[2][i7] >= 11 || this.f192e[3][i7] >= k.f276a + 2) {
                    this.f192e[6][i7] = -1;
                    this.f192e[1][i7] = -1;
                }
            }
        }
    }

    private void a(short s) {
        this.g = s;
        this.f99s = this.f92p;
        this.f100t = this.f93q;
        this.f101u = (byte) 0;
    }

    private void f(int i, int i2) {
        this.f178a.f284b = (byte) i2;
        this.f178a.f288a = i2 >= 2;
        this.f178a.f289b = i2 >= 2;
        this.f178a.f290c = i2 > 0;
        this.f178a.f291d = i2 > 0;
        this.f178a.f292e = i2 > 0;
        this.f178a.f = i2 > 0;
        this.f178a.g = i2 > 0;
        this.f178a.f293e = (byte) (i2 > 0 ? 0 : 1);
        if (this.H == 1) {
            if (i <= 1 && i2 >= 2) {
                for (int i3 = 0; i3 < 400; i3++) {
                    int i4 = this.f179a.l[i3] - this.f179a.k[i3];
                    if (i4 > 0) {
                        byte[] bArr = this.f179a.l;
                        int i5 = i3;
                        bArr[i5] = (byte) (bArr[i5] + i4);
                        byte[] bArr2 = this.f179a.h;
                        int i6 = i3;
                        bArr2[i6] = (byte) (bArr2[i6] / 2);
                        byte[] bArr3 = this.f179a.i;
                        int i7 = i3;
                        bArr3[i7] = (byte) (bArr3[i7] / 2);
                    }
                }
            }
            if (i == 2 && i2 <= 1) {
                for (int i8 = 0; i8 < 400; i8++) {
                    int i9 = this.f179a.l[i8] - this.f179a.k[i8];
                    if (i9 > 0) {
                        byte[] bArr4 = this.f179a.l;
                        int i10 = i8;
                        bArr4[i10] = (byte) (bArr4[i10] - (i9 / 2));
                        byte[] bArr5 = this.f179a.h;
                        int i11 = i8;
                        bArr5[i11] = (byte) (bArr5[i11] << 1);
                        byte[] bArr6 = this.f179a.i;
                        int i12 = i8;
                        bArr6[i12] = (byte) (bArr6[i12] << 1);
                    }
                }
            }
        }
        if (i2 == 0) {
            this.f179a.f430i = (byte) (k.f276a - p.f431j);
        }
        this.f179a.f430i = k.f276a;
        if (this.H == 1) {
            this.f179a.d = (byte) Math.min((int) this.f179a.d, this.f179a.b - k.f276a);
        }
        this.ag = -100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    final void a(boolean z) {
        this.f185a[0].setClip(0, 0, 1000, 1000);
        this.f185a[1].setClip(0, 0, 1000, 1000);
        this.f149c = true;
        if (this.f89a != -1) {
            this.f104e = (byte) 0;
            if (this.f89a != 4) {
                this.f185a[1].drawImage(this.f178a.f282a[0], this.f181v[this.f182d[12] + (this.f89a << 1)] * 30, this.f181v[this.f182d[12] + (this.f89a << 1) + 1] * 20, 0);
                this.f185a[0].drawImage(this.f178a.f282a[1], 0, 0, 0);
            }
            this.aK = k.a % 20 != 0 ? 2 : 1;
            this.aG = this.f89a == 1 ? (this.f179a.c + 8) - this.aK : this.f179a.c - 1;
            this.aH = this.f89a == 0 ? this.f179a.c + 1 : this.f179a.c + 8 + 1;
            this.aI = this.f89a == 3 ? (this.f179a.d + this.f179a.f430i) - this.aK : this.f179a.d - 1;
            this.aJ = this.f89a == 2 ? this.f179a.d + 1 : this.f179a.d + this.f179a.f430i + 1;
            for (int i = this.aI; i < this.aJ; i++) {
                if (i >= 0 && i < this.f179a.b) {
                    for (int i2 = this.aG; i2 < this.aH; i2++) {
                        if (i2 >= 0 && i2 < this.f179a.a) {
                            a(this.f139a[this.f194g[i][i2] & 255], (i2 - this.f179a.c) * 30, (i - this.f179a.d) * 20);
                        }
                    }
                }
            }
            for (int i3 = this.aI - 1; i3 < this.aJ + 1; i3++) {
                if (i3 >= 0 && i3 < this.f179a.b) {
                    for (int i4 = this.aG - 1; i4 < this.aH + 1; i4++) {
                        if (i4 >= 0 && i4 < this.f179a.a) {
                            byte b = this.f186a[i3][i4];
                            while (true) {
                                byte b2 = b;
                                if (b2 >= 0) {
                                    a(this.f179a.m85a((int) this.f188b[5][b2]) + this.f188b[6][b2], (((i4 - this.f179a.c) * 30) + this.f188b[2][b2]) - 90, (((i3 - this.f179a.d) * 20) + this.f188b[3][b2]) - 60);
                                    b = this.f187w[b2];
                                }
                            }
                        }
                    }
                }
            }
            for (int i5 = this.f179a.d - 4; i5 < this.f179a.d + this.f179a.f430i + 2; i5++) {
                if (i5 >= 0 && i5 < this.f179a.b) {
                    for (int i6 = this.f179a.c - 4; i6 < this.f179a.c + 8 + 1; i6++) {
                        if (i6 >= 0 && i6 < this.f179a.a) {
                            b(i6, i5, 0);
                        }
                    }
                }
            }
            this.f89a = (byte) -1;
        }
        this.f151k = 0;
        this.f152l = (-(this.f179a.d + this.f179a.f430i == this.f179a.b ? (20 - ((this.f178a.f ? k.a : k.a - 15) % 20)) % 20 : 0)) + (this.f178a.f ? 0 : 15);
        if (this.f151k < -15) {
            this.f151k = -15;
        }
        this.f104e = (byte) 1;
        this.f185a[this.f104e].drawImage(this.f178a.f282a[0], this.f151k, this.f152l, 0);
        if (!z) {
            this.f104e = (byte) 0;
            this.f185a[this.f104e].drawImage(this.f178a.f282a[1], 0, 0, 0);
        }
        C();
        E();
        this.ak = this.f179a.c > 0 ? 30 : -1;
        this.al = this.f179a.d > 0 ? 35 : -1;
        this.am = this.f179a.c + 8 < this.f179a.a ? 210 : 241;
        this.an = this.f179a.d + this.f179a.f430i < this.f179a.b ? (k.a - 15) - 20 : k.a + 1;
        this.f149c = false;
        this.f152l = 0;
        this.f151k = 0;
        a(133, 0, 0, 1, 0);
        a(134, 0, 0, 1, 0);
        if (!z) {
            a(2133, 0, 0);
            this.f185a[this.f104e].setClip(0, 0, 270, k.f279a);
        }
        if (this.f178a.i == 1 && this.f105b == -1) {
            a(145, 0, k.a, 1, 0);
        }
        a(144, 0, k.a, 1, 0);
        if (this.h >= 0 && z) {
            n(this.h, 120, k.a / 2, this.f107v, -1);
        } else {
            if (this.f105b < 0 || !z) {
                return;
            }
            a(this.f105b, this.f105b != 145 ? 120 : 0, this.f105b != 145 ? k.a / 2 : 0, 1, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    private void C() {
        char c;
        for (int i = this.f179a.d - 4; i < this.f179a.d + this.f179a.f430i + 2; i++) {
            if (i >= 0 && i < this.f179a.b) {
                for (int i2 = this.f179a.c - 4; i2 < this.f179a.c + 8 + 1; i2++) {
                    if (i2 >= 0 && i2 < this.f179a.a) {
                        char c2 = 0;
                        if (i2 >= this.f179a.c - 1 && i >= this.f179a.d - 1 && i2 < this.f179a.c + 8 + 1 && i < this.f179a.d + this.f179a.f430i + 1) {
                            if (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][i2 >> 5][i] >> (i2 & 31)) & 1) != 0) {
                                if (this.f178a.f293e == 2) {
                                    int[] iArr = null;
                                    if (((iArr[i] >> (i2 & 31)) & 1) == 0) {
                                        c = 2;
                                    }
                                }
                                c = (this.f178a.f293e >= 2 || ((this.f178a.f301a[1][i2 >> 5][i] >> (i2 & 31)) & 1) != 0) ? (char) 0 : (char) 1;
                            } else {
                                c = 2;
                            }
                            c2 = c;
                        }
                        if (this.f195b[i][i2] <= 0 || this.f195b[i][i2] > 100) {
                            b(i2, i, 1);
                        } else if (i2 >= this.f179a.c - 1 && i >= this.f179a.d - 1 && i2 < this.f179a.c + 8 + 1 && i < this.f179a.d + this.f179a.f430i + 1 && (this.f178a.f293e >= 3 || c2 == 0)) {
                            c(this.f195b[i][i2], (i2 - this.f179a.c) * 30, (i - this.f179a.d) * 20);
                        }
                        if ((this.f178a.f293e >= 3 || c2 < 2) && i2 >= this.f179a.c - 3 && i >= this.f179a.d - 2 && i2 < this.f179a.c + 8 && i < this.f179a.d + this.f179a.f430i) {
                            byte b = this.f193f[(i - this.f179a.d) + 2][(i2 - this.f179a.c) + 3];
                            while (true) {
                                byte b2 = b;
                                if (b2 < 0) {
                                    break;
                                }
                                n(this.f192e[0][b2], ((i2 - this.f179a.c) * 30) + this.f192e[4][b2], ((i - this.f179a.d) * 20) + this.f192e[5][b2], this.f192e[1][b2], -1);
                                b = this.f192e[6][b2];
                            }
                        }
                        if (i2 >= this.f179a.c - 1 && i >= this.f179a.d - 1 && i2 < this.f179a.c + 8 + 1 && i < this.f179a.d + this.f179a.f430i + 1) {
                            if ((this.f178a.f293e >= 3 || c2 == 0) && i2 >= this.f179a.c - 1 && i >= this.f179a.d - 1 && i2 <= this.f179a.c + 8 && i <= this.f179a.d + this.f179a.f430i) {
                                g(i2 - this.f179a.c, i - this.f179a.d);
                            }
                            if (this.f105b == 135 && this.f189x[6161 - this.f95a] == i2 && this.f189x[6262 - this.f95a] == i) {
                                a(1830, ((i2 - this.f179a.c) * 30) - 90, ((i - this.f179a.d) * 20) - 60);
                            }
                            if (this.f178a.f293e < 2 && c2 == 1) {
                                a(1852 + this.f178a.f293e, ((i2 - this.f179a.c) * 30) - 90, ((i - this.f179a.d) * 20) - 60);
                            }
                        }
                    }
                }
            }
        }
        if (this.f102d >= 0) {
            this.f185a[this.f104e].setColor(65280);
            for (int i3 = (this.f178a.f315j * 50) + 1; i3 <= (this.f178a.f315j + 1) * 50; i3++) {
                if (((this.f189x[i3 + 5454] + 1) & 255) > 1 && (this.f189x[i3 + 6060] & 1) == 0 && this.f181v[this.f182d[94] + this.f189x[i3 + 5656]] % 3 == 0) {
                    for (int i4 = 0; i4 < 20; i4++) {
                        d(this.f185a[this.f104e], 15 + this.f151k + ((this.f189x[i3 + 5252] - this.f179a.c) * 30) + ((this.f183e[this.f184f[8] + (i4 << 1)] * this.f154g[this.f178a.f315j]) / 20), 10 + this.f152l + ((this.f189x[i3 + 5353] - this.f179a.d) * 20) + ((this.f183e[(this.f184f[8] + (i4 << 1)) + 1] * this.f154g[this.f178a.f315j]) / 20), 15 + this.f151k + ((this.f189x[i3 + 5252] - this.f179a.c) * 30) + ((this.f183e[(this.f184f[8] + (i4 << 1)) + 2] * this.f154g[this.f178a.f315j]) / 20), 10 + this.f152l + ((this.f189x[i3 + 5353] - this.f179a.d) * 20) + ((this.f183e[(this.f184f[8] + (i4 << 1)) + 3] * this.f154g[this.f178a.f315j]) / 20));
                    }
                }
            }
        }
        if (this.f178a.f293e < 3) {
            D();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f7  */
    private void D() {
        char c;
        boolean z = false;
        int i = 0;
        for (int i2 = this.f179a.d - 1; i2 < this.f179a.d + this.f179a.f430i + 1; i2++) {
            if (i2 >= 0 && i2 < this.f179a.b) {
                for (int i3 = this.f179a.c - 1; i3 < this.f179a.c + 8 + 1; i3++) {
                    if (i3 >= 0) {
                        if (i3 < this.f179a.a) {
                            if (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][i3 >> 5][i2] >> (i3 & 31)) & 1) != 0) {
                                if (this.f178a.f293e == 2) {
                                    int[] iArr = null;
                                    if (((iArr[i2] >> (i3 & 31)) & 1) == 0) {
                                        c = 2;
                                    }
                                }
                                c = (this.f178a.f293e >= 2 || ((this.f178a.f301a[1][i3 >> 5][i2] >> (i3 & 31)) & 1) != 0) ? (char) 0 : (char) 1;
                            } else {
                                c = 2;
                            }
                            char c2 = c;
                            if (c == 2 && !z) {
                                z = true;
                                i = i3;
                            }
                            if ((c2 < 2 || i3 + 1 >= this.f179a.c + 8 + 1) && z) {
                                int i4 = (i3 - i) + (c2 == 2 ? 1 : 0);
                                this.f185a[this.f104e].setColor(0);
                                a(this.f185a[this.f104e], 15 + this.f151k + ((i - this.f179a.c) * 30), 10 + this.f152l + ((i2 - this.f179a.d) * 20), i4 * 30, 20);
                                z = false;
                            }
                        } else if (z) {
                            this.f185a[this.f104e].setColor(0);
                            a(this.f185a[this.f104e], 15 + this.f151k + ((i - this.f179a.c) * 30), 10 + this.f152l + ((i2 - this.f179a.d) * 20), ((i3 - i) + 1) * 30, 20);
                            z = false;
                        }
                    }
                }
            }
        }
        if (this.f178a.f293e == 0) {
            for (int i5 = this.f179a.d - 1; i5 < this.f179a.d + this.f179a.f430i + 1; i5++) {
                if (i5 >= 0 && i5 < this.f179a.b) {
                    for (int i6 = this.f179a.c - 1; i6 < this.f179a.c + 8 + 1; i6++) {
                        if (i6 >= 0 && i6 < this.f179a.a && ((this.f178a.f301a[0][i6 >> 5][i5] >> (i6 & 31)) & 1) == 0 && ((i6 > 0 && ((this.f178a.f301a[0][(i6 - 1) >> 5][i5] >> ((i6 - 1) & 31)) & 1) != 0) || ((i6 < this.f179a.a - 1 && ((this.f178a.f301a[0][(i6 + 1) >> 5][i5] >> ((i6 + 1) & 31)) & 1) != 0) || ((i5 > 0 && ((this.f178a.f301a[0][i6 >> 5][i5 - 1] >> (i6 & 31)) & 1) != 0) || (i5 < this.f179a.b - 1 && ((this.f178a.f301a[0][i6 >> 5][i5 + 1] >> (i6 & 31)) & 1) != 0))))) {
                            a(1851, ((i6 - this.f179a.c) * 30) - 90, ((i5 - this.f179a.d) * 20) - 60);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0262  */
    /* JADX WARN: Code duplicated, block: B:103:0x026d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0283  */
    /* JADX WARN: Code duplicated, block: B:84:0x0208  */
    private void b(int i, int i2, int i3) {
        int i4;
        boolean z;
        boolean z2;
        boolean z3 = (-this.f195b[i2][i]) > 0 && (-this.f195b[i2][i]) <= 100;
        boolean z4 = this.f195b[i2][i] >= 1001 && this.f195b[i2][i] <= 1200;
        boolean z5 = this.f195b[i2][i] >= 128;
        if (z3) {
            i4 = this.f189x[5656 - this.f195b[i2][i]];
        } else if (z4) {
            i4 = 15 + (((this.f195b[i2][i] - 1001) % 100) / 50);
        } else {
            i4 = (!z5 || this.f195b[i2][i] - 128 < this.f140b[14]) ? -1 : this.f139a[this.f195b[i2][i] - 128];
        }
        int i5 = i4;
        if (i3 != 1) {
            z = false;
        } else {
            if (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][i >> 5][i2] >> (i & 31)) & 1) != 0) {
                if (this.f178a.f293e == 2) {
                    int[] iArr = null;
                    if (((iArr[i2] >> (i & 31)) & 1) == 0) {
                    }
                }
                z = false;
            }
            z = true;
        }
        boolean z6 = z;
        if ((i < this.f179a.c - 1 || i2 < this.f179a.d - 1 || i2 >= this.f179a.d + this.f179a.f430i + 1) && (i5 < 0 || i < this.f179a.c - this.f178a.f327i[18][i5 == true ? 1 : 0] || i2 <= this.f179a.d - this.f178a.f327i[19][i5 == true ? 1 : 0])) {
            return;
        }
        if (z6) {
            if (i5 < 0 || z4) {
                return;
            }
            for (int i6 = 0; i6 < this.f178a.f327i[18][i5 == true ? 1 : 0] && z6; i6++) {
                for (int i7 = i2 > 0 ? -i3 : 0; i7 < this.f178a.f327i[19][i5 == true ? 1 : 0] && z6; i7++) {
                    if (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][(i + i6) >> 5][i2 + i7] >> ((i + i6) & 31)) & 1) != 0) {
                        if (this.f178a.f293e == 2) {
                            int[] iArr2 = null;
                            z2 = ((iArr2[i2 + i7] >> ((i + i6) & 31)) & 1) == 0;
                        }
                    }
                    z6 = z2;
                }
            }
            if (z6) {
                return;
            }
        }
        if (!z3) {
            if (z4) {
                a(this.f148f[this.f195b[i2][i] / 1101] + (((this.f195b[i2][i] - 1001) % 100) / 20), (i - this.f179a.c) * 30, (i2 - this.f179a.d) * 20, i3, 0);
                return;
            }
            if (z5) {
                if (this.f195b[i2][i] - 128 >= this.f140b[14]) {
                    a(this.f139a[this.f195b[i2][i] - 128], (i - this.f179a.c) * 30, (i2 - this.f179a.d) * 20, i3, 0);
                    return;
                } else {
                    if (i3 == 1) {
                        a(this.f139a[this.f195b[i2][i] - 128], (i - this.f179a.c) * 30, (i2 - this.f179a.d) * 20);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.f178a.f293e < 2 && ((this.f178a.f301a[1][i >> 5][i2] >> (i & 31)) & 1) != 0) {
            if ((this.f189x[6060 - this.f195b[i2][i]] & 2) == 0) {
                this.f104e = (byte) 0;
                a(i5 == true ? 1 : 0, ((this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30) - this.f151k, ((this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20) - this.f152l, 0, -this.f195b[i2][i]);
                this.f104e = (byte) i3;
            }
            byte[] bArr = this.f189x;
            int i8 = 6060 - this.f195b[i2][i];
            bArr[i8] = (byte) (bArr[i8] | 2);
        } else if (this.f178a.f293e == 2) {
            int[] iArr3 = null;
            if (((iArr3[i2] >> (i & 31)) & 1) != 0) {
                if ((this.f189x[6060 - this.f195b[i2][i]] & 2) == 0) {
                    this.f104e = (byte) 0;
                    a(i5 == true ? 1 : 0, ((this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30) - this.f151k, ((this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20) - this.f152l, 0, -this.f195b[i2][i]);
                    this.f104e = (byte) i3;
                }
                byte[] bArr2 = this.f189x;
                int i9 = 6060 - this.f195b[i2][i];
                bArr2[i9] = (byte) (bArr2[i9] | 2);
            } else if (this.f178a.f293e > 2) {
                if ((this.f189x[6060 - this.f195b[i2][i]] & 2) == 0 && (this.f189x[6363 - this.f195b[i2][i]] != i || this.f189x[6464 - this.f195b[i2][i]] != i2 || i3 != 0)) {
                    this.f104e = (byte) 0;
                    a(i5 == true ? 1 : 0, ((this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30) - this.f151k, ((this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20) - this.f152l, 0, -this.f195b[i2][i]);
                    this.f104e = (byte) i3;
                }
                byte[] bArr3 = this.f189x;
                int i10 = 6060 - this.f195b[i2][i];
                bArr3[i10] = (byte) (bArr3[i10] | 2);
            }
        } else if (this.f178a.f293e > 2) {
            if ((this.f189x[6060 - this.f195b[i2][i]] & 2) == 0) {
                this.f104e = (byte) 0;
                a(i5 == true ? 1 : 0, ((this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30) - this.f151k, ((this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20) - this.f152l, 0, -this.f195b[i2][i]);
                this.f104e = (byte) i3;
            }
            byte[] bArr4 = this.f189x;
            int i11 = 6060 - this.f195b[i2][i];
            bArr4[i11] = (byte) (bArr4[i11] | 2);
        }
        if (this.f189x[6363 - this.f195b[i2][i]] == i && this.f189x[6464 - this.f195b[i2][i]] == i2 && (this.f189x[6060 - this.f195b[i2][i]] & 2) != 0) {
            b(i, i2, i3, i5 == true ? 1 : 0);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        a(i4, (i - this.f179a.c) * 30, (i2 - this.f179a.d) * 20, i3, -this.f195b[i2][i]);
        if (i3 != 1 || ((this.f189x[5454 - this.f195b[i2][i]] + 1) & 255) <= 1) {
            return;
        }
        int i5 = 0;
        int i6 = 30 + ((((this.f181v[this.f182d[59] + i4] & 255) - 100) / 35) * 10);
        int i7 = this.f178a.f327i[3][1399] & 255;
        if ((this.f95a == this.f195b[i2][i] && ((-this.f195b[i2][i]) - 1) / 50 == this.f178a.f315j) || (this.f189x[6060 - this.f195b[i2][i]] & 1) != 0) {
            a(1863 + (((this.f181v[this.f182d[59] + i4] & 255) - 100) / 35), (((i - this.f179a.c) * 30) + (this.f178a.f327i[18][i4] * 15)) - 90, ((i2 - this.f179a.d) * 20) - 60);
            this.z = (this.f189x[6060 - this.f195b[i2][i]] & 1) == 0 ? 1399 - ((((this.f189x[5454 - this.f195b[i2][i]] & 255) - 1) * 3) / (this.f181v[this.f182d[59] + i4] & 255)) : 1401;
            int i8 = (i6 * (this.f189x[5454 - this.f195b[i2][i]] & 255)) / (this.f181v[this.f182d[59] + i4] & 255);
            this.y = i7;
            while (i5 < i8 / i7) {
                d(this.z, this.w + (i5 * this.y), this.x);
                i5++;
            }
            this.y = i8 % i7;
            d(this.z, this.w + (i5 * i7), this.x);
        }
        if (this.f189x[6868 - this.f195b[i2][i]] >= 0 && ((-this.f195b[i2][i]) - 1) / 50 == this.f178a.f315j && (this.f181v[this.f182d[94] + i4] > 0 || i4 == 4 || i4 == 12)) {
            byte b = (i4 == 4 || i4 == 12) ? (byte) 0 : this.f179a.f413t[this.f181v[this.f182d[95 + (this.f181v[this.f182d[94] + i4] << 1)] + this.f181v[this.f182d[96 + (this.f181v[this.f182d[94] + i4] << 1)] + this.f112b[this.f181v[this.f182d[94] + i4]]] + this.f189x[6868 - this.f195b[i2][i]]]];
            a(1863 + (((this.f181v[this.f182d[59] + i4] & 255) - 100) / 35), (((i - this.f179a.c) * 30) + (this.f178a.f327i[18][i4] * 15)) - 90, (((i2 - this.f179a.d) * 20) - 60) + 5);
            int i9 = (i6 * this.f189x[6565 - this.f195b[i2][i]]) / ((i4 == 4 || i4 == 12) ? this.f189x[6767 - this.f195b[i2][i]] : (this.f181v[this.f182d[42] + b] * this.f179a.f411r[this.f181v[this.f182d[94] + i4]]) / 10);
            this.y = i7;
            int i10 = 0;
            while (i10 < i9 / i7) {
                d(1400, this.w + (i10 * this.y), this.x);
                i10++;
            }
            this.y = i9 % i7;
            d(1400, this.w + (i10 * i7), this.x);
        }
        if (this.f189x[7171 - this.f195b[i2][i]] == 0) {
            n(269, ((this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30) + ((this.f178a.f327i[18][i4] - 1) * 15), ((this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20) + ((this.f178a.f327i[19][i4] - 1) * 10), this.f178a.f317e - this.f195b[i2][i], -1);
        }
        if (this.f95a != this.f195b[i2][i] || this.f98f < 0) {
            return;
        }
        if (this.f94r >= 0) {
            n(this.f98f, (this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30, (this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20, this.f94r, -1);
            n(this.f98f + 1, (((this.f189x[6363 - this.f195b[i2][i]] + this.f178a.f327i[18][i4]) - 1) - this.f179a.c) * 30, (this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20, this.f94r, -1);
            n(this.f98f + 2, (this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30, (((this.f189x[6464 - this.f195b[i2][i]] + this.f178a.f327i[19][i4]) - 1) - this.f179a.d) * 20, this.f94r, -1);
            n(this.f98f + 3, (((this.f189x[6363 - this.f195b[i2][i]] + this.f178a.f327i[18][i4]) - 1) - this.f179a.c) * 30, (((this.f189x[6464 - this.f195b[i2][i]] + this.f178a.f327i[19][i4]) - 1) - this.f179a.d) * 20, this.f94r, -1);
            return;
        }
        a(this.f98f, (this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30, (this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20);
        a(this.f98f + 1, (((this.f189x[6363 - this.f195b[i2][i]] + this.f178a.f327i[18][i4]) - 1) - this.f179a.c) * 30, (this.f189x[6464 - this.f195b[i2][i]] - this.f179a.d) * 20);
        a(this.f98f + 2, (this.f189x[6363 - this.f195b[i2][i]] - this.f179a.c) * 30, (((this.f189x[6464 - this.f195b[i2][i]] + this.f178a.f327i[19][i4]) - 1) - this.f179a.d) * 20);
        a(this.f98f + 3, (((this.f189x[6363 - this.f195b[i2][i]] + this.f178a.f327i[18][i4]) - 1) - this.f179a.c) * 30, (((this.f189x[6464 - this.f195b[i2][i]] + this.f178a.f327i[19][i4]) - 1) - this.f179a.d) * 20);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:60:0x03ed  */
    private void E() {
        int i;
        int i2;
        if (this.g >= 0) {
            n(this.g, (this.f99s - this.f179a.c) * 30, (this.f100t - this.f179a.d) * 20, this.f101u, -1);
        }
        if (this.f178a.f288a) {
            if (this.f102d >= 0) {
                for (int i3 = this.f91c; i3 < this.f91c + this.f178a.f327i[19][this.f102d]; i3++) {
                    for (int i4 = this.f90b; i4 < this.f90b + this.f178a.f327i[18][this.f102d]; i4++) {
                        if (this.f195b[i3][i4] == 0 && this.f103m && (this.f178a.f293e >= 2 || (((this.f178a.f301a[0][i4 >> 5][i3] >> (i4 & 31)) & 1) != 0 && ((this.f178a.f301a[1][i4 >> 5][i3] >> (i4 & 31)) & 1) != 0))) {
                            if (this.f178a.f293e == 2) {
                                int[] iArr = null;
                                i2 = ((iArr[i3] >> (i4 & 31)) & 1) == 0 ? 2045 : 2044;
                            }
                        }
                        a(i2, ((i4 - this.f179a.c) * 30) - this.u, ((i3 - this.f179a.d) * 20) - this.v);
                    }
                }
                a(2019, ((this.f90b - this.f179a.c) * 30) - this.u, ((this.f91c - this.f179a.d) * 20) - this.v);
                a(2020, ((((this.f90b + this.f178a.f327i[18][this.f102d]) - 1) - this.f179a.c) * 30) - this.u, ((this.f91c - this.f179a.d) * 20) - this.v);
                a(2021, ((this.f90b - this.f179a.c) * 30) - this.u, ((((this.f91c + this.f178a.f327i[19][this.f102d]) - 1) - this.f179a.d) * 20) - this.v);
                a(2022, ((((this.f90b + this.f178a.f327i[18][this.f102d]) - 1) - this.f179a.c) * 30) - this.u, ((((this.f91c + this.f178a.f327i[19][this.f102d]) - 1) - this.f179a.d) * 20) - this.v);
                o.a((((this.f90b - this.f179a.c) * 30) - this.u) + 2, ((((this.f91c - 1) - this.f179a.d) * 20) - this.v) + 9, 0, new StringBuffer().append("").append((int) this.f183e[this.f184f[6] + this.f102d]).append("$").toString(), 0);
                this.f180a.a(this.f185a[this.f104e]);
            } else {
                n(this.f97e, ((this.f90b - this.f179a.c) * 30) - this.u, ((this.f91c - this.f179a.d) * 20) - this.v, this.f178a.f317e, -1);
                if (this.f190c[0][50] > 0) {
                    o.a(((((this.f90b + 1) - this.f179a.c) * 30) - this.u) - 7, ((((this.f91c + 1) - this.f179a.d) * 20) - this.v) + 4, 0, new StringBuffer().append("").append((int) this.f190c[0][50]).toString(), 0);
                    this.f180a.a(this.f185a[this.f104e]);
                }
            }
            this.v = 0;
            this.u = 0;
        } else if (this.f102d >= 0) {
            for (int i5 = this.f91c; i5 < this.f91c + this.f178a.f327i[19][this.f102d]; i5++) {
                for (int i6 = this.f90b; i6 < this.f90b + this.f178a.f327i[18][this.f102d]; i6++) {
                    if (this.f195b[i5][i6] == 0 && this.f103m && (this.f178a.f293e >= 2 || (((this.f178a.f301a[0][i6 >> 5][i5] >> (i6 & 31)) & 1) != 0 && ((this.f178a.f301a[1][i6 >> 5][i5] >> (i6 & 31)) & 1) != 0))) {
                        if (this.f178a.f293e == 2) {
                            int[] iArr2 = null;
                            i = ((iArr2[i5] >> (i6 & 31)) & 1) == 0 ? 2045 : 2044;
                        }
                    }
                    a(i, (i6 - this.f179a.c) * 30, (i5 - this.f179a.d) * 20);
                }
            }
            a(2019, (this.f90b - this.f179a.c) * 30, (this.f91c - this.f179a.d) * 20);
            a(2020, (((this.f90b + this.f178a.f327i[18][this.f102d]) - 1) - this.f179a.c) * 30, (this.f91c - this.f179a.d) * 20);
            a(2021, (this.f90b - this.f179a.c) * 30, (((this.f91c + this.f178a.f327i[19][this.f102d]) - 1) - this.f179a.d) * 20);
            a(2022, (((this.f90b + this.f178a.f327i[18][this.f102d]) - 1) - this.f179a.c) * 30, (((this.f91c + this.f178a.f327i[19][this.f102d]) - 1) - this.f179a.d) * 20);
            o.a(((this.f90b - this.f179a.c) * 30) + 2, (((this.f91c - 1) - this.f179a.d) * 20) + 9, 0, new StringBuffer().append("").append((int) this.f183e[this.f184f[6] + this.f102d]).append("$").toString(), 0);
            this.f180a.a(this.f185a[this.f104e]);
        } else {
            n(this.f97e, (this.f90b - this.f179a.c) * 30, (this.f91c - this.f179a.d) * 20, this.f178a.f317e, -1);
            if (this.f190c[0][50] > 0) {
                o.a((((this.f90b + 1) - this.f179a.c) * 30) - 7, (((this.f91c + 1) - this.f179a.d) * 20) + 4, 0, new StringBuffer().append("").append((int) this.f190c[0][50]).toString(), 0);
                this.f180a.a(this.f185a[this.f104e]);
            }
        }
        if (this.f141f >= 0) {
            int iMax = Math.max(this.f179a.c - 1, Math.min((int) this.f90b, (int) this.f141f));
            int iMin = Math.min(this.f179a.c + 8, Math.max((int) this.f90b, (int) this.f141f));
            int iMax2 = Math.max(this.f179a.d - 1, Math.min((int) this.f91c, (int) this.f142K));
            int iMin2 = Math.min(this.f179a.d + this.f179a.f430i, Math.max((int) this.f91c, (int) this.f142K));
            if (this.f178a.g) {
                for (int i7 = iMax; i7 <= iMin; i7++) {
                    for (int i8 = iMax2; i8 <= iMin2; i8++) {
                        a(2043, (i7 - this.f179a.c) * 30, (i8 - this.f179a.d) * 20);
                    }
                }
            }
            for (int i9 = iMax; i9 <= iMin; i9++) {
                a(2039, (i9 - this.f179a.c) * 30, (Math.min((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
                a(2040, (i9 - this.f179a.c) * 30, (Math.max((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
            }
            for (int i10 = iMax2; i10 <= iMin2; i10++) {
                a(2041, (Math.min((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (i10 - this.f179a.d) * 20);
                a(2042, (Math.max((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (i10 - this.f179a.d) * 20);
            }
            a(2015, (Math.min((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (Math.min((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
            a(2016, (Math.max((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (Math.min((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
            a(2017, (Math.min((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (Math.max((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
            a(2018, (Math.max((int) this.f90b, (int) this.f141f) - this.f179a.c) * 30, (Math.max((int) this.f91c, (int) this.f142K) - this.f179a.d) * 20);
            o.a((((this.f90b + 1) - this.f179a.c) * 30) - 7, (((this.f91c + 1) - this.f179a.d) * 20) + 4, 0, new StringBuffer().append("").append((int) this.f143L).toString(), -1);
            this.f180a.a(this.f185a[this.f104e]);
        }
    }

    private void g(int i, int i2) {
        short s = this.f179a.f506a[i2 + 1][i + 1];
        while (true) {
            short s2 = s;
            if (s2 < 0) {
                return;
            }
            int i3 = (((i * 30) + this.f179a.f403c[s2]) + 15) - 90;
            int i4 = (((((i2 * 20) + this.f179a.f404d[s2]) - ((this.f179a.m[s2] * ((this.f179a.l[s2] + 1) - this.f179a.k[s2])) / (this.f179a.l[s2] + 1))) + 10) - 60) - 10;
            switch (this.f181v[this.f182d[48] + this.f179a.n[s2]]) {
                case 0:
                    a(1277 + (this.f181v[this.f182d[49] + this.f179a.n[s2]] << 5) + this.f179a.f405j[s2], i3, i4);
                    break;
                case 1:
                    a(1341 + (this.f181v[this.f182d[49] + this.f179a.n[s2]] << 5) + this.f179a.f405j[s2], i3, i4);
                    break;
                case 2:
                    if ((0 & (1 << this.f179a.n[s2])) != 0) {
                        i4 -= this.f181v[((this.f182d[50] + 15) - this.f179a.l[s2]) + (this.f179a.k[s2] << 1)] - this.f181v[(this.f182d[50] + 15) - this.f179a.l[s2]];
                    }
                    if (this.f179a.f406a[1][0][s2] >= 0) {
                        a(1405 + (this.f181v[this.f182d[49] + this.f179a.n[s2]] << 4) + this.f179a.f405j[s2], i3, i4);
                    }
                    int i5 = i3;
                    int i6 = i4;
                    byte b = this.f181v[this.f182d[49] + this.f179a.n[s2]];
                    int i7 = 4 / (this.f178a.f288a ? 1 : 2);
                    int i8 = i7;
                    int i9 = 0;
                    for (int i10 = 0; i10 < 4 && (this.f179a.f406a[0][i10][s2] != 0 || this.f179a.f406a[1][i10][s2] != 0); i10++) {
                        while (i8 < 7 && i9 < 7) {
                            this.f171a[0][i9] = (short) (i5 + ((this.f179a.f406a[0][i10][s2] * i8) / 7));
                            this.f171a[1][i9] = (short) (i6 + ((this.f179a.f406a[1][i10][s2] * i8) / 7));
                            i8 += i7;
                            i9++;
                        }
                        i8 -= 7;
                        i5 += this.f179a.f406a[0][i10][s2];
                        i6 += this.f179a.f406a[1][i10][s2];
                    }
                    int i11 = this.f179a.f406a[1][0][s2] >= 0 ? 0 : i9 - 1;
                    while (true) {
                        int i12 = i11;
                        if ((this.f179a.f406a[1][0][s2] >= 0 && i12 < i9) || (this.f179a.f406a[1][0][s2] < 0 && i12 >= 0)) {
                            a(1440 + (this.f181v[this.f182d[49] + this.f179a.n[s2]] * 7) + i12, this.f171a[0][i12], this.f171a[1][i12]);
                            i11 = i12 + (this.f179a.f406a[1][0][s2] >= 0 ? 1 : -1);
                        }
                    }
                    if (this.f179a.f406a[1][0][s2] < 0) {
                        a(1405 + (this.f181v[this.f182d[49] + this.f179a.n[s2]] << 4) + this.f179a.f405j[s2], i3, i4);
                    }
                    break;
                case 3:
                    n(59, (i * 30) + this.f179a.f403c[s2], (i2 * 20) + this.f179a.f404d[s2], this.f179a.k[s2] - 1, s2);
                    break;
            }
            s = this.f179a.f398a[s2];
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:105:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:152:0x0449 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0321  */
    private void b(int i, int i2, int i3, int i4, int i5) {
        short s;
        switch (i) {
            case 0:
                if (i2 == 0) {
                    if (this.f110a[4] >= 0) {
                        n(i3, i4, i5, this.f110a[4], -1);
                    }
                } else if (i2 != 1) {
                    o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][0]).toString(), -1);
                } else if (this.f110a[6] >= 0) {
                    n(i3, i4, i5, this.f110a[6], -1);
                }
                break;
            case 1:
                if (i2 == 0) {
                    if (this.f178a.f311c[this.f178a.f315j][2] > this.f178a.f311c[this.f178a.f315j][3]) {
                        a(i3, i4, i5);
                    }
                } else if (i2 != 1) {
                    o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][2]).append(this.f224k).append((int) this.f178a.f311c[this.f178a.f315j][3]).toString(), -1);
                } else if (this.f110a[8] >= 0) {
                    n(i3, i4, i5, this.f110a[8], -1);
                }
                break;
            case 2:
                if (i2 == 0) {
                    if (this.f110a[5] >= 0) {
                        n(i3, i4, i5, this.f110a[5], -1);
                    }
                } else if (i2 != 1) {
                    o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][4]).toString(), (this.f110a[5] < 0 || this.f110a[5] > 1) ? -1 : 0);
                } else if (this.f110a[7] >= 0) {
                    n(i3, i4, i5, this.f110a[7], -1);
                }
                break;
            case 3:
                if (i2 == 0) {
                    this.ai = i4;
                    this.aj = i5;
                } else if (i2 == 2) {
                    if (this.f110a[9] >= 0) {
                        n(i3, i4, i5, this.f110a[9], -1);
                    }
                } else if (this.f178a.f292e) {
                    int i6 = (this.f179a.c + 4) - this.ai;
                    int i7 = (this.f179a.d + (this.f179a.f430i / 2)) - this.aj;
                    if (this.f178a.f288a) {
                        c(this.f185a[this.f104e], (15 + this.f151k) - this.f178a.f280b, (10 + this.f152l) - this.f178a.f281c, i4, i5);
                    } else {
                        c(this.f185a[this.f104e], 15 + this.f151k, 10 + this.f152l, i4, i5);
                    }
                    for (int i8 = 0; i8 < (this.aj << 1); i8++) {
                        if (i7 + i8 >= 0 && i7 + i8 < this.f179a.b) {
                            for (int i9 = 0; i9 < (this.ai << 1); i9++) {
                                if (i6 + i9 >= 0 && i6 + i9 < this.f179a.a && (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][(i6 + i9) >> 5][i7 + i8] >> ((i6 + i9) & 31)) & 1) != 0)) {
                                    if (this.f178a.f293e == 2) {
                                        int[] iArr = null;
                                        if (((iArr[i7 + i8] >> ((i6 + i9) & 31)) & 1) != 0) {
                                            s = this.f195b[i7 + i8][i6 + i9];
                                            if (s > 0 || s > 100) {
                                                if ((-s) <= 0 && (-s) <= 100 && ((this.f189x[6060 - s] >> 1) & 1) != 0 && this.f189x[5252 - s] == i6 + i9 && this.f189x[5353 - s] == i7 + i8) {
                                                    a(2047 + ((((-s) - 1) / 50) << 2), i9 - 90, i8 - 60);
                                                }
                                            } else if (this.f178a.f293e >= 2 || ((this.f178a.f301a[1][(i6 + i9) >> 5][i7 + i8] >> ((i6 + i9) & 31)) & 1) != 0) {
                                                a(2047 + this.f181v[this.f182d[57] + this.f189x[s + 2323]] + (((s - 1) / 50) << 2), i9 - 90, i8 - 60);
                                                if (this.f189x[s + 5151] >= 0 && this.f189x[s + 5151] <= this.f178a.f328f[6][285] - this.f178a.f328f[5][285]) {
                                                    n(285, i9, i8, this.f189x[s + 5151], -1);
                                                }
                                            }
                                        }
                                    } else {
                                        s = this.f195b[i7 + i8][i6 + i9];
                                        if (s > 0) {
                                            if ((-s) <= 0) {
                                            }
                                        } else if ((-s) <= 0) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    c(this.f185a[this.f104e], 0, 0, 270, k.f279a);
                }
                break;
            case 4:
                if (this.f178a.f292e) {
                    a(i3, i4, i5);
                } else {
                    if (this.f178a.f317e - this.ag >= 10) {
                        b(i3 + 1);
                    }
                    if (this.f178a.f288a) {
                        this.f185a[this.f104e].drawImage(this.f178a.f282a[2], (15 + this.f151k) - this.f178a.f280b, (10 + this.f152l) - this.f178a.f281c, 0);
                    } else {
                        this.f185a[this.f104e].drawImage(this.f178a.f282a[2], 15 + this.f151k, 10 + this.f152l, 0);
                    }
                }
                break;
            case 5:
                a(i3 + (this.f178a.f ? 0 : 1), i4, i5);
                break;
            case 15:
                this.f170a[0][9] = 0;
                this.f170a[1][9] = 0;
                this.f170a[2][9] = i4 + this.f178a.f327i[3][i3] + 5;
                this.f170a[3][9] = i5 + this.f178a.f327i[4][i3] + 5;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:83:0x0231 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private void b(int i) {
        short s;
        this.f225V = this.f104e;
        this.f104e = (byte) 2;
        a(i, (-15) + (this.f178a.f288a ? this.f178a.f280b : 0), (-10) + (this.f178a.f288a ? this.f178a.f281c : 0));
        int i2 = (this.f179a.c + 4) - this.ai;
        int i3 = (this.f179a.d + (this.f179a.f430i / 2)) - this.aj;
        for (int i4 = 0; i4 < (this.ai << 1); i4++) {
            if (i3 + i4 >= 0 && i3 + i4 < this.f179a.b) {
                for (int i5 = 0; i5 < (this.aj << 1); i5++) {
                    if (i2 + i5 >= 0 && i2 + i5 < this.f179a.a && (this.f178a.f293e >= 2 || ((this.f178a.f301a[0][(i2 + i5) >> 5][i3 + i4] >> ((i2 + i5) & 31)) & 1) != 0)) {
                        if (this.f178a.f293e == 2) {
                            int[] iArr = null;
                            if (((iArr[i3 + i4] >> ((i2 + i5) & 31)) & 1) != 0) {
                                s = this.f195b[i3 + i4][i2 + i5];
                                if (s > 0 || s > 100) {
                                    if ((-s) <= 0 && (-s) <= 100 && ((this.f189x[6060 - s] >> 1) & 1) != 0 && this.f189x[5252 - s] == i2 + i5 && this.f189x[5353 - s] == i3 + i4) {
                                        a(2047 + ((((-s) - 1) / 50) << 2), ((i5 - 90) - 15) + (this.f178a.f288a ? this.f178a.f280b : 0), ((i4 - 60) - 10) + (this.f178a.f288a ? this.f178a.f281c : 0));
                                    }
                                } else if (this.f178a.f293e >= 2 || ((this.f178a.f301a[1][(i2 + i5) >> 5][i3 + i4] >> ((i2 + i5) & 31)) & 1) != 0) {
                                    a(2047 + this.f181v[this.f182d[57] + this.f189x[s + 2323]] + (((s - 1) / 50) << 2), ((i5 - 90) - 15) + (this.f178a.f288a ? this.f178a.f280b : 0), ((i4 - 60) - 10) + (this.f178a.f288a ? this.f178a.f281c : 0));
                                }
                            }
                        } else {
                            s = this.f195b[i3 + i4][i2 + i5];
                            if (s > 0) {
                                if ((-s) <= 0) {
                                }
                            } else if ((-s) <= 0) {
                            }
                        }
                    }
                }
            }
        }
        this.ag = this.f178a.f317e;
        this.f104e = this.f225V;
    }

    private void c(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 6:
                a(i3 + (this.f178a.f ? 0 : 1), i4, i5);
                break;
            case 15:
                if ((i2 > 0 && i2 < 3) || this.f178a.i == 1) {
                    byte b = this.f181v[(this.f182d[66] + i2) - (this.f178a.i == 1 ? 0 : 1)];
                    this.f170a[0][b] = i4;
                    this.f170a[1][b] = i5;
                    this.f170a[2][b] = this.f178a.f327i[3][i3];
                    this.f170a[3][b] = this.f178a.f327i[4][i3];
                    break;
                }
                break;
            default:
                if (this.f178a.i != 2) {
                    if (i2 == 1 && this.f110a[(i + 0) - 2] >= 0) {
                        n(i3, i4, i5, this.f110a[(i + 0) - 2], -1);
                    }
                    if (i - 1 != this.f144j) {
                        if (i2 > 1) {
                            if (i.f268a && i2 != 2) {
                                i5 += 2;
                                i4--;
                            }
                            o.a(i4, i5, i2 == 2 ? 1 : 0, new StringBuffer().append("").append((int) (i2 == 2 ? this.f190c[i - 1][50] : this.f181v[(this.f182d[66] + i) - 2])).toString(), i2 == 2 ? -1 : 1);
                        }
                    } else if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (i2 > 1) {
                        if (i.f268a && i2 != 2) {
                            i5 += 2;
                            i4--;
                        }
                        o.a(i4, i5, i2 == 2 ? 1 : 0, new StringBuffer().append("").append((int) (i2 == 2 ? this.f190c[i - 1][50] : this.f181v[(this.f182d[66] + i) - 2])).toString(), i2 == 2 ? -1 : 2);
                    }
                    break;
                } else if (i > 2 && i < 5 && i2 > 1) {
                    o.a(i4, i5, i2 == 2 ? 1 : 0, i2 == 2 ? i == 3 ? "-" : "+" : new StringBuffer().append("").append((int) this.f181v[(this.f182d[66] + i) - 3]).toString(), i2 == 2 ? -1 : 1);
                    break;
                }
                break;
        }
    }

    private void d(int i, int i2, int i3, int i4, int i5) {
        char c;
        byte b = this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h];
        byte b2 = this.f179a.f413t[b];
        switch (i) {
            case 0:
                if (this.f114h > 0) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[10] >= 0) {
                        n(i3, i4, i5, this.f110a[10], -1);
                    }
                }
                break;
            case 1:
                if (this.f114h < this.B - 1) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[11] >= 0) {
                        n(i3, i4, i5, this.f110a[11], -1);
                    }
                }
                break;
            case 2:
                if (this.f116c[this.f114h] < 50) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[12] >= 0) {
                        n(i3, i4, i5, this.f110a[12], -1);
                    }
                }
                break;
            case 3:
                if (this.f116c[this.f114h] > 0) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[13] >= 0) {
                        n(i3, i4, i5, this.f110a[13], -1);
                    }
                }
                break;
            case 4:
                o.b(i4, i5, 1, b + 49);
                break;
            case 5:
                a(i3 + this.f146d[this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h]], i4, i5);
                break;
            case 6:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f116c[this.f114h]).toString(), -1);
                break;
            case 7:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f191d[4][b2]).toString(), -1);
                break;
            case 8:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f191d[2][b2]).toString(), -1);
                break;
            case 9:
                o.a(i4, i5, 1, new StringBuffer().append("").append(10 - this.f191d[0][b2]).toString(), -1);
                break;
            case 10:
                o.a(i4, i5, 1, new StringBuffer().append("").append((this.f183e[this.f184f[5] + b2] * this.f179a.f412s[0]) / 10).toString(), -1);
                break;
            case 11:
                if (this.f114h == this.f189x[6868 - this.f95a]) {
                    if (i2 != 0) {
                        int i6 = 0;
                        int i7 = (52 * this.f189x[6565 - this.f95a]) / ((this.f181v[this.f182d[42] + b2] * this.f179a.f411r[this.f181v[this.f182d[94] + this.f189x[5656 - this.f95a]]]) / 10);
                        while (i6 < i7 / (this.f178a.f327i[3][1402] & 255)) {
                            this.y = this.f178a.f327i[3][1402] & 255;
                            d(i3, i4 + (i6 * this.y), i5);
                            i6++;
                        }
                        this.y = i7 % (this.f178a.f327i[3][1402] & 255);
                        d(i3, i4 + (i6 * (this.f178a.f327i[3][1402] & 255)), i5);
                    } else {
                        a(i3, i4, i5);
                    }
                }
                break;
            case 15:
                if (i2 == 0) {
                    c = 4;
                } else if (i2 == 1) {
                    c = 6;
                } else if (i2 == 2) {
                    c = 2;
                } else if (i2 == 3) {
                    c = '\b';
                } else if (i2 == 4) {
                    c = 1;
                } else if (i2 == 5) {
                    c = 0;
                } else {
                    c = i2 == 6 ? (char) 3 : (char) 5;
                }
                char c2 = c;
                this.f170a[0][c2] = i4;
                this.f170a[1][c2] = i5;
                this.f170a[2][c2] = this.f178a.f327i[3][i3];
                this.f170a[3][c2] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void e(int i, int i2, int i3, int i4, int i5) {
        char c;
        byte b = this.f181v[this.f182d[95 + (this.A << 1)] + this.f181v[this.f182d[96 + (this.A << 1)] + this.f112b[this.A]] + this.f114h];
        byte b2 = this.f181v[this.f182d[93] + b];
        switch (i) {
            case 0:
                if (this.f114h > 0) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[10] >= 0) {
                        n(i3, i4, i5, this.f110a[10], -1);
                    }
                }
                break;
            case 1:
                if (this.f114h < this.B - 1) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[11] >= 0) {
                        n(i3, i4, i5, this.f110a[11], -1);
                    }
                }
                break;
            case 2:
                o.b(i4, i5, 1, b + 63);
                break;
            case 3:
                a(i3 + this.f147e[b], i4, i5);
                break;
            case 4:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f183e[this.f184f[6] + b2]).toString(), -1);
                break;
            case 5:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f181v[this.f182d[61] + b2]).toString(), -1);
                break;
            case 15:
                if (i2 == 0) {
                    c = 4;
                } else if (i2 == 1) {
                    c = 6;
                } else if (i2 == 2) {
                    c = 0;
                } else {
                    c = i2 == 3 ? (char) 3 : (char) 5;
                }
                char c2 = c;
                this.f170a[0][c2] = i4;
                this.f170a[1][c2] = i5;
                this.f170a[2][c2] = this.f178a.f327i[3][i3];
                this.f170a[3][c2] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void f(int i, int i2, int i3, int i4, int i5) {
        char c;
        switch (i) {
            case 0:
                if (this.f189x[6868 - this.f95a] < 0 && a(this.f114h, -1) >= 0) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[10] >= 0) {
                        n(i3, i4, i5, this.f110a[10], -1);
                    }
                    break;
                }
                break;
            case 1:
                if (this.f189x[6868 - this.f95a] < 0 && a(this.f114h, 1) >= 0) {
                    if (i2 == 0) {
                        a(i3, i4, i5);
                    } else if (this.f110a[11] >= 0) {
                        n(i3, i4, i5, this.f110a[11], -1);
                    }
                    break;
                }
                break;
            case 2:
                if (this.f138b) {
                    if (i2 == 0) {
                        this.S = i4;
                        this.T = i5;
                    } else {
                        this.U = i4 - this.S;
                        this.V = i5 - this.T;
                        this.f180a.a(this.S, this.T, this.U, this.V, 1, 61 + this.f114h, 1);
                        this.f138b = false;
                    }
                }
                if (i2 == 1) {
                    this.f180a.b(this.f185a[this.f104e]);
                    if (i.f268a) {
                        if (this.f180a.c > this.f180a.f391b + this.f180a.d) {
                            a(1999, 87, this.T - 16);
                        }
                        if (this.f180a.d > 0) {
                            a(1998, 145, this.T - 16);
                        }
                    }
                }
                break;
            case 3:
                if (i2 == 0) {
                    a(i3 + this.f114h, i4, i5);
                    break;
                } else if ((this.f179a.f415b & (1 << this.f114h)) == 0) {
                    a(i3, i4, i5);
                    break;
                } else if ((this.f179a.f414a & (1 << this.f114h)) != 0 && this.f189x[6868 - this.f95a] < 0) {
                    a(i3 + 1, i4, i5);
                    break;
                }
                break;
            case 4:
                o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f183e[this.f184f[7] + this.f114h]).toString(), -1);
                break;
            case 5:
                if (this.f189x[6868 - this.f95a] >= 0) {
                    if (i2 != 0) {
                        this.y = (34 * this.f189x[6565 - this.f95a]) / this.f189x[6767 - this.f95a];
                        d(i3, i4, i5);
                    } else {
                        a(i3, i4, i5);
                    }
                }
                break;
            case 15:
                if (i2 == 0) {
                    c = 4;
                } else if (i2 == 1) {
                    c = 6;
                } else if (i2 == 2) {
                    c = 0;
                } else {
                    c = i2 == 3 ? (char) 3 : (char) 5;
                }
                char c2 = c;
                this.f170a[0][c2] = i4;
                this.f170a[1][c2] = i5;
                this.f170a[2][c2] = this.f178a.f327i[3][i3];
                this.f170a[3][c2] = this.f178a.f327i[4][i3];
                if (i.f268a) {
                    if (this.f180a.c > this.f180a.f391b + this.f180a.d) {
                        this.f170a[0][8] = 62;
                        this.f170a[1][8] = this.T - 35;
                        this.f170a[2][8] = 50;
                        this.f170a[3][8] = 45;
                    }
                    if (this.f180a.d > 0) {
                        this.f170a[0][2] = 120;
                        this.f170a[1][2] = this.T - 35;
                        this.f170a[2][2] = 50;
                        this.f170a[3][2] = 45;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x028e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0298  */
    /* JADX WARN: Code duplicated, block: B:107:0x029c  */
    /* JADX WARN: Code duplicated, block: B:109:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:111:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:113:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:115:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:117:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:119:0x02da  */
    /* JADX WARN: Code duplicated, block: B:121:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:123:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:129:0x030e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0320  */
    /* JADX WARN: Code duplicated, block: B:134:0x0324  */
    /* JADX WARN: Code duplicated, block: B:135:0x0329  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:46:0x0140  */
    /* JADX WARN: Code duplicated, block: B:48:0x0145  */
    /* JADX WARN: Code duplicated, block: B:50:0x0160  */
    /* JADX WARN: Code duplicated, block: B:52:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0175  */
    /* JADX WARN: Code duplicated, block: B:56:0x0183  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01db  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x0201  */
    /* JADX WARN: Code duplicated, block: B:78:0x0207  */
    /* JADX WARN: Code duplicated, block: B:83:0x0231  */
    /* JADX WARN: Code duplicated, block: B:86:0x023f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0243  */
    private void g(int i, int i2, int i3, int i4, int i5) {
        int i6;
        boolean z;
        boolean z2;
        char c;
        int i7;
        int i8;
        boolean z3;
        int i9;
        int i10 = -1;
        if (this.P < 0 && this.k) {
            i9 = 63 + this.f189x[5656 - this.f95a];
        } else {
            if (this.P != 17 && this.W >= 12) {
                if (this.W < 101 && (this.W < 22 || this.W >= 61)) {
                    i6 = i10;
                    i6 = i10;
                    i6 = i10;
                    if (this.W < 85) {
                        i9 = this.f181v[((this.f182d[82] + this.W) - 12) + 19];
                    } else if (this.W < 94) {
                        i9 = ((63 + this.W) - 85) + (this.W - 85 == 8 ? 7 : 0);
                    } else {
                        i9 = this.W < 101 ? (49 + this.W) - 94 : -1;
                    }
                }
                i6 = i10;
                i6 = i10;
                i6 = i10;
                if (i6 >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
                if (this.P == f119y) {
                    if (this.f212i != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = z3;
                }
                switch (i) {
                    case 0:
                        if (z2) {
                            switch (i2) {
                                case 0:
                                    if (this.P != f119y) {
                                        o.a(i4, i5, 1, this.f212i, -1);
                                    } else {
                                        o.b(i4, i5, 1, i6 == true ? 1 : 0);
                                    }
                                    break;
                                case 1:
                                    a(i3, i4, i5);
                                    break;
                            }
                        }
                        break;
                    case 1:
                        if (((!z2 && i2 == 1) || (!z2 && i2 == 0)) && this.f138b) {
                            this.S = i4;
                            this.T = i5;
                            break;
                        }
                        break;
                    case 2:
                        if (this.f138b) {
                            this.U = i4 - this.S;
                            this.V = i5 - this.T;
                            if (this.P == f119y) {
                                o oVar = this.f180a;
                                int i11 = this.S;
                                int i12 = this.T;
                                int i13 = this.U;
                                int i14 = this.V;
                                if (this.P != 17 || this.P == 15) {
                                    i7 = 2;
                                } else {
                                    i7 = 1;
                                }
                                int i15 = this.W;
                                if (this.P == 17) {
                                    i8 = 0;
                                } else {
                                    i8 = ((this.W >= 12 || this.W >= 61 || this.P == 30 || this.P == 31) && this.W != 126) ? 1 : 3;
                                }
                                oVar.a(i11, i12, i13, i14, i7, i15, i8);
                            } else if (this.f211h != null) {
                                this.f180a.a(this.S, this.T, this.U, this.V, this.f211h, 3);
                            } else {
                                o.a();
                            }
                            this.f138b = false;
                        }
                        this.f180a.b(this.f185a[this.f104e]);
                        break;
                    case 3:
                        if (!this.f180a.f393b) {
                            if (i2 == 0) {
                                d(i3, i4, i5);
                            } else if (this.f110a[13] >= 0) {
                                n(i3, i4, i5, this.f110a[13], -1);
                            }
                        }
                        break;
                    case 4:
                        if (!this.f180a.f392a) {
                            if (i2 == 0) {
                                d(i3, i4, i5);
                            } else if (this.f110a[12] >= 0) {
                                n(i3, i4, i5, this.f110a[12], -1);
                            }
                        }
                        break;
                    case 5:
                        if (this.P != 30 || this.P == 31) {
                            if (i.f268a) {
                                i5 += 14;
                            }
                            a(i3 + this.c, i4, i5);
                        }
                        break;
                    case 15:
                        if (i2 == 0) {
                            c = '\b';
                        } else {
                            c = 2;
                        }
                        char c2 = c;
                        this.f170a[0][c2] = i4;
                        this.f170a[1][c2] = i5;
                        this.f170a[2][c2] = this.f178a.f327i[3][i3];
                        this.f170a[3][c2] = this.f178a.f327i[4][i3];
                        break;
                }
            }
            i9 = 0 + this.f181v[this.f182d[82] + this.P];
        }
        i6 = i9;
        i6 = i10;
        i6 = i10;
        i6 = i10;
        if (i6 >= 0) {
            z = true;
        } else {
            z = false;
        }
        z2 = z;
        if (this.P == f119y) {
            if (this.f212i != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 = z3;
        }
        switch (i) {
            case 0:
                if (z2) {
                    switch (i2) {
                        case 0:
                            if (this.P != f119y) {
                                o.a(i4, i5, 1, this.f212i, -1);
                            } else {
                                o.b(i4, i5, 1, i6 == true ? 1 : 0);
                            }
                            break;
                        case 1:
                            a(i3, i4, i5);
                            break;
                    }
                }
                break;
            case 1:
                if (!z2) {
                }
                break;
            case 2:
                if (this.f138b) {
                    this.U = i4 - this.S;
                    this.V = i5 - this.T;
                    if (this.P == f119y) {
                        o oVar2 = this.f180a;
                        int i16 = this.S;
                        int i17 = this.T;
                        int i18 = this.U;
                        int i19 = this.V;
                        if (this.P != 17) {
                            i7 = 2;
                        } else {
                            i7 = 2;
                        }
                        int i110 = this.W;
                        if (this.P == 17) {
                            i8 = 0;
                        } else if (this.W >= 12) {
                        }
                        oVar2.a(i16, i17, i18, i19, i7, i110, i8);
                    } else if (this.f211h != null) {
                        this.f180a.a(this.S, this.T, this.U, this.V, this.f211h, 3);
                    } else {
                        o.a();
                    }
                    this.f138b = false;
                }
                this.f180a.b(this.f185a[this.f104e]);
                break;
            case 3:
                if (!this.f180a.f393b) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[13] >= 0) {
                        n(i3, i4, i5, this.f110a[13], -1);
                    }
                }
                break;
            case 4:
                if (!this.f180a.f392a) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[12] >= 0) {
                        n(i3, i4, i5, this.f110a[12], -1);
                    }
                }
                break;
            case 5:
                if (this.P != 30) {
                }
                if (i.f268a) {
                    i5 += 14;
                }
                a(i3 + this.c, i4, i5);
                break;
            case 15:
                if (i2 == 0) {
                    c = '\b';
                } else {
                    c = 2;
                }
                char c3 = c;
                this.f170a[0][c3] = i4;
                this.f170a[1][c3] = i5;
                this.f170a[2][c3] = this.f178a.f327i[3][i3];
                this.f170a[3][c3] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void h(int i, int i2, int i3, int i4, int i5) {
        byte b;
        switch (i) {
            case 0:
                if (this.f181v[this.f182d[82] + this.P] >= 0) {
                    switch (i2) {
                        case 0:
                            if (this.P == f121A) {
                                if (f132a != null) {
                                    o.a(i4, i5, 1, f132a, -1);
                                }
                            } else if (this.P == 1) {
                                o.a(i4, i5, 1, 51);
                            } else {
                                o.b(i4, i5, 1, 0 + this.f181v[this.f182d[82] + this.P]);
                            }
                            break;
                        case 1:
                            a(i3, i4, i5);
                            break;
                    }
                }
                break;
            case 1:
                if (this.f135r) {
                    if (this.P == f121A && f132a != null) {
                        this.T = i5;
                    }
                    if ((this.f181v[this.f182d[82] + this.P] >= 0 && i2 == 1) || (this.f181v[this.f182d[82] + this.P] < 0 && i2 == 0)) {
                        this.T = i5;
                        break;
                    }
                }
                break;
            case 2:
                if (this.f135r) {
                    this.V = i5 - this.T;
                    if (this.f178a.f285c == this.f178a.f286d && this.P == 11) {
                        this.B = 1;
                    } else if (this.P == f121A) {
                        this.B = f130a.length;
                    } else {
                        this.B = this.f181v[(this.f182d[81] + this.P) + 1] - this.f181v[this.f182d[81] + this.P];
                        if (this.P == 0) {
                            this.B--;
                            int i6 = 0;
                            if (a.b != null) {
                                this.B++;
                                this.az = 2;
                                i6 = 0 + 1;
                            }
                            if (a.e != null) {
                                this.aA = i6 + 2;
                                this.B++;
                                i6++;
                            }
                            if (f.a()) {
                                this.B++;
                                this.aB = i6 + 2;
                            }
                        }
                    }
                    this.D = (this.B * f136J) - 5;
                    if (this.D > this.V) {
                        this.D = this.T + 2;
                        this.F = this.V / f136J;
                    } else {
                        this.D = this.T + ((this.V - this.D) / 2) + 2;
                        this.F = this.B;
                    }
                    if (this.f114h >= this.B) {
                        this.f114h = 0;
                    }
                    if (this.E > this.f114h) {
                        this.E = this.f114h;
                    }
                    if (this.E + this.F > this.B) {
                        this.E = Math.max(0, this.B - this.F);
                    }
                    this.f135r = false;
                }
                int i7 = 0;
                if (this.P == 0) {
                    if (a.b != null && this.E > this.az) {
                        i7 = 0 - 1;
                    }
                    if (a.e != null && this.E > this.aA) {
                        i7--;
                    }
                    if (f.a() && this.E > this.aB) {
                        i7--;
                    }
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.F; i9++) {
                    int i10 = (this.D + (f136J * i8)) - ((this.J == 0 || !(this.f114h == i8 + this.E || this.f114h + this.J == i8 + this.E)) ? 0 : this.J);
                    if (this.P == 0 && a.b != null && i9 + this.E == this.az) {
                        o.b(120, i10, 1, 4);
                        if (i8 + this.E == this.f114h) {
                            this.aC = o.f385a[0].a(o.f384a[0][4]);
                        }
                    } else if (this.P == 0 && a.e != null && i9 + this.E == this.aA) {
                        o.a(120, i10, 1, 0);
                        if (i8 + this.E == this.f114h) {
                            this.aC = o.f385a[0].a(o.f384a[3][0]);
                        }
                    } else if (this.P == 0 && f.a() && i9 + this.E == this.aB) {
                        o.a(120, i10, 1, 35);
                        if (i8 + this.E == this.f114h) {
                            this.aC = o.f385a[0].a(o.f384a[3][35]);
                        }
                    } else {
                        if (this.P == 0 && i9 + this.E == this.B - 1) {
                            i7++;
                        }
                        this.f219j = null;
                        int i11 = -1;
                        if (this.P == f121A) {
                            this.f219j = f130a[i7 + this.E];
                        } else {
                            int i12 = 0 + this.f181v[this.f182d[80] + this.f181v[this.f182d[81] + this.P] + i7 + this.E];
                            if (this.P != 11) {
                                b = 0;
                            } else if (i7 == 0) {
                                b = c.f28a ? (byte) 1 : (byte) 0;
                            } else {
                                b = this.f178a.f284b;
                            }
                            i11 = i12 + b;
                        }
                        if (this.f219j != null) {
                            o.a(120, i10, 1, this.f219j, -1);
                            if (i8 + this.E == this.f114h) {
                                this.aC = o.f385a[0].a(this.f219j);
                            }
                            this.f219j = null;
                        } else if (i11 >= 0) {
                            o.b(120, i10, 1, i11);
                            if (i8 + this.E == this.f114h) {
                                this.aC = o.f385a[0].a(o.f384a[0][i11]);
                            }
                        }
                        i7++;
                    }
                    if (i8 + this.E == this.f114h) {
                        if (this.J != 0) {
                            this.G = (this.aC + this.G) / 2;
                        } else {
                            this.G = this.aC;
                        }
                        if (this.G > 139) {
                            this.G = 139;
                        }
                    }
                    i8++;
                }
                break;
            case 3:
                if (this.E + this.F < this.B || this.f114h < this.B - 1) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[13] >= 0) {
                        n(i3, i4, i5, this.f110a[13], -1);
                    }
                }
                break;
            case 4:
                if (this.E > 0 || this.f114h > 0) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[12] >= 0) {
                        n(i3, i4, i5, this.f110a[12], -1);
                    }
                }
                break;
            case 15:
                char c = i2 == 0 ? '\b' : (char) 2;
                this.f170a[0][c] = i4;
                this.f170a[1][c] = i5;
                this.f170a[2][c] = this.f178a.f327i[3][i3];
                this.f170a[3][c] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void i(int i, int i2, int i3, int i4, int i5) {
        byte b = this.f181v[this.f182d[141] + this.f181v[this.f182d[139] + this.f155h] + this.f156N];
        switch (i) {
            case 0:
                if (this.f157O == 0 && i2 == 0) {
                    a(i3 + b, i4, i5);
                    break;
                } else if (this.f157O < 0 && i2 == 1) {
                    n(i3 + b, i4, i5, (-this.f157O) - 1, -1);
                    break;
                } else if (this.f157O > 1 && i2 == 2) {
                    n(i3 + b, i4, i5, this.f157O - 1, -1);
                    break;
                }
                break;
            case 1:
                if (this.f138b) {
                    this.S = i4;
                    this.T = i5;
                }
                break;
            case 2:
                if (this.f138b) {
                    this.U = i4 - this.S;
                    this.V = i5 - this.T;
                    this.f180a.a(this.S, this.T, this.U, this.V, 2, this.W, 0);
                    this.f138b = false;
                }
                this.f180a.b(this.f185a[this.f104e]);
                break;
            case 3:
                if (!this.f180a.f393b) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[13] >= 0) {
                        n(i3, i4, i5, this.f110a[13], -1);
                    }
                }
                break;
            case 4:
                if (!this.f180a.f392a) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[12] >= 0) {
                        n(i3, i4, i5, this.f110a[12], -1);
                    }
                }
                break;
            case 5:
                if (i.f268a) {
                    i5--;
                }
                o.b(i4, i5, 0, b + 97);
                break;
            case 6:
                o.b(i4, i5, 0, b + 101);
                break;
            case 7:
                if (i.f268a) {
                    i5 += 4;
                }
                o.b(i4, i5, 0, b + 105);
                break;
            case 15:
                char c = i2 == 0 ? '\b' : (char) 2;
                this.f170a[0][c] = i4;
                this.f170a[1][c] = i5;
                this.f170a[2][c] = this.f178a.f327i[3][i3];
                this.f170a[3][c] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void j(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        StringBuffer stringBufferAppend;
        short[] sArr;
        char c;
        if (i == 6 && this.P == 12) {
            return;
        }
        if (i == 6 || this.P == 12) {
            switch (i) {
                case 0:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 0, 109);
                            break;
                        case 1:
                            int i9 = ((this.f178a.f317e * 100) / 1000) % 60;
                            int i10 = ((this.f178a.f317e * 100) / 60000) % 60;
                            int i11 = (this.f178a.f317e * 100) / 3600000;
                            o.a(i4, i5, 2, new StringBuffer().append(i11 < 10 ? "0" : "").append(i11).append(i10 < 10 ? ":0" : ":").append(i10).append(i9 < 10 ? ":0" : ":").append(i9).toString(), -1);
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            if (this.P == 12) {
                                a(i3, i4, i5);
                            }
                            break;
                    }
                    return;
                case 1:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 1, 110);
                            break;
                        case 1:
                            o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][5]).toString(), -1);
                            break;
                    }
                    return;
                case 2:
                    i6 = i4;
                    i7 = i5;
                    i8 = 2;
                    stringBufferAppend = new StringBuffer().append("");
                    sArr = this.f178a.f311c[this.f178a.f315j];
                    c = 6;
                    break;
                case 3:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 1, 111);
                            break;
                        case 1:
                            o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][7]).toString(), -1);
                            break;
                    }
                    return;
                case 4:
                    i6 = i4;
                    i7 = i5;
                    i8 = 2;
                    stringBufferAppend = new StringBuffer().append("");
                    sArr = this.f178a.f311c[this.f178a.f315j];
                    c = '\b';
                    break;
                case 5:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 0, 112);
                            break;
                        case 1:
                            o.a(i4, i5, 2, new StringBuffer().append("").append((int) this.f178a.f311c[this.f178a.f315j][9]).toString(), -1);
                            break;
                    }
                    return;
                case 6:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 1, 79 + (this.t == 0 ? this.b : 7));
                            break;
                        case 1:
                            if (i.f268a) {
                                i5 += 5;
                            }
                            if (this.b <= 6) {
                                o.b(i4, i5, 1, 87 + this.b);
                            } else if (this.f202c != null) {
                                o.a(i4, i5, 1, this.f202c, -1);
                            }
                            break;
                    }
                    return;
                case 7:
                    switch (i2) {
                        case 0:
                            o.b(i4, i5, 0, 113);
                            return;
                        case 1:
                            i6 = i4;
                            i7 = i5;
                            i8 = 2;
                            stringBufferAppend = new StringBuffer().append("");
                            sArr = this.f178a.f311c[this.f178a.f315j];
                            c = this.t != 0 ? '\t' : '\n';
                            break;
                        default:
                            return;
                    }
                    break;
                default:
                    return;
            }
            o.a(i6, i7, i8, stringBufferAppend.append((int) sArr[c]).toString(), -1);
        }
    }

    private void k(int i, int i2, int i3, int i4, int i5) {
        char c;
        switch (i) {
            case 0:
                o.a(i4, i5, 1, this.f161b, -1);
                break;
            case 1:
            case 2:
            case 3:
                if (this.B >= i) {
                    switch (i2) {
                        case 0:
                            if (this.f114h == (this.E + i) - 1) {
                                a(i3, i4, i5);
                            }
                            break;
                        case 1:
                        case 2:
                        case 3:
                            if (i2 == 3 && this.f163u[(this.E + i) - 1] == 1) {
                                o.a(i4, i5, 2, ">", 0);
                            } else if (i2 != 3 || this.f163u[(this.E + i) - 1] == 0) {
                                o.a(i4, i5, i2 == 1 ? 1 : i2 == 2 ? 0 : 2, this.f164a[i2 - 1][(this.E + i) - 1], -1);
                            }
                            break;
                        case 4:
                            if (this.f163u[(this.E + i) - 1] >= 2) {
                                a(i3, i4, i5);
                            }
                            break;
                    }
                }
                break;
            case 4:
                if (this.E + this.F < this.B) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[13] >= 0) {
                        n(i3, i4, i5, this.f110a[13], -1);
                    }
                }
                break;
            case 5:
                if (this.E > 0) {
                    if (i2 == 0) {
                        d(i3, i4, i5);
                    } else if (this.f110a[12] >= 0) {
                        n(i3, i4, i5, this.f110a[12], -1);
                    }
                }
                break;
            case 15:
                if (i2 == 0) {
                    c = '\b';
                } else if (i2 == 1) {
                    c = 2;
                } else if (i2 == 2) {
                    c = 1;
                } else {
                    c = i2 == 3 ? (char) 3 : (char) 7;
                }
                char c2 = c;
                this.f170a[0][c2] = i4;
                this.f170a[1][c2] = i5;
                this.f170a[2][c2] = this.f178a.f327i[3][i3] & 255;
                this.f170a[3][c2] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void l(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                if (this.f178a.i != 0 || (this.f181v[this.f182d[90] + (this.P >> 3)] & (1 << (this.P & 7))) != 0 || ((!this.f137s && i2 <= 0) || ((this.P == f119y && (this.f213x || !this.f215z)) || ((this.P == f121A && f133p) || (this.P == 3 && a.d != null))))) {
                    if (this.f178a.i == 0) {
                        if (this.P != f119y || this.f213x || !this.f215z) {
                            if (this.P != f121A || f133p) {
                                if (this.P == 3 && a.d == null) {
                                }
                            }
                        }
                    }
                    if (i2 <= 0 || this.P != f119y || this.f213x) {
                        if (i2 != 2) {
                            if (this.P == 3 && i2 == 1) {
                                o.a(i4 + 4, i5 + 3, 0, f206f, -1);
                            } else {
                                a(i3 + ((i2 == 1 && this.f105b == -1 && this.f178a.i == 1 && this.f102d < 0) ? 1 : 0), i4, i5);
                            }
                            break;
                        } else if (this.f110a[14] >= 0 && this.P != 3) {
                            n(i3, i4, i5, this.f110a[14], -1);
                            break;
                        }
                    }
                }
                break;
            case 1:
                if (this.f178a.i != 0 || (this.f181v[this.f182d[91] + (this.P >> 3)] & (1 << (this.P & 7))) != 0 || ((!this.f137s && i2 <= 0) || ((this.P == f119y && (this.f214y || !this.f215z)) || (this.P == f121A && f134q)))) {
                    if (this.f178a.i == 0) {
                        if (this.P != f119y || this.f214y || !this.f215z) {
                            if (this.P == f121A && !f134q) {
                            }
                        }
                    }
                    if (i2 <= 0 || this.P != f119y || this.f214y) {
                        if (this.f178a.i != 1 || this.f105b >= 0 || this.f109i != 0 || this.f102d >= 0 || this.f141f >= 0 || this.f190c[0][50] > 0) {
                            if (i2 != 2) {
                                a(i3 + ((i2 == 1 && this.f102d < 0 && this.f141f < 0 && this.f109i == 0 && this.f105b == -1 && this.f178a.i == 1 && this.f190c[0][50] == 0) ? 1 : 0), i4, i5);
                            } else if (this.f110a[15] >= 0) {
                                n(i3, i4, i5, this.f110a[15], -1);
                            }
                        }
                    }
                }
                break;
            case 15:
                char c = i2 == 0 ? '\n' : (char) 11;
                this.f170a[0][c] = i4;
                this.f170a[1][c] = i5;
                this.f170a[2][c] = this.f178a.f327i[3][i3];
                this.f170a[3][c] = this.f178a.f327i[4][i3];
                break;
        }
    }

    private void m(int i, int i2, int i3, int i4, int i5) {
        switch (i) {
            case 0:
                if (this.C > 0) {
                    a(i3 + (this.f228C ? this.C : 0), i4, i5);
                }
                break;
            case 1:
                if (this.f190c[0][50] > 0) {
                    switch (i2) {
                        case 0:
                            a(i3, i4, i5);
                            break;
                        case 1:
                            o.a(i4, i5, 1, new StringBuffer().append("").append((int) this.f190c[0][50]).toString(), -1);
                            break;
                    }
                }
                break;
            case 15:
                int i6 = 2 + (i2 << 1);
                this.f170a[0][i6] = i4;
                this.f170a[1][i6] = i5;
                this.f170a[2][i6] = this.f178a.f327i[3][i3];
                this.f170a[3][i6] = this.f178a.f327i[4][i3];
                break;
            default:
                if (this.f228C && i <= this.C + 1) {
                    switch (i2) {
                        case 0:
                            if (i == this.f114h) {
                                a(i3, i4, i5);
                            }
                            break;
                        case 1:
                            d(i3 + (i == 2 ? this.f150M : (byte) 0), i4, i5);
                            break;
                        case 2:
                            o.a(i4, i5, 0, new StringBuffer().append("").append((int) this.f181v[this.f182d[66] + i]).toString(), i == this.f114h ? 2 : 1);
                            break;
                    }
                }
                break;
        }
    }

    final void e() {
        if (this.f89a != -1) {
            this.f104e = (byte) 0;
            this.f89a = (byte) 4;
            if (this.f89a != 4) {
                this.f185a[1].drawImage(this.f178a.f282a[0], this.f181v[this.f182d[12] + (this.f89a << 1)] * 20, this.f181v[this.f182d[12] + (this.f89a << 1) + 1] * 20, 0);
                this.f185a[0].drawImage(this.f178a.f282a[1], 0, 0, 0);
            } else {
                a(false);
                this.f89a = (byte) 4;
                if (this.f153t) {
                    this.ad = this.f179a.c + 4;
                    this.ae = this.f179a.d + (this.f179a.f430i / 2);
                    this.f153t = false;
                }
                if (this.f179a.a * this.af < 200) {
                    this.X = this.f179a.a * this.af;
                    this.ab = 0;
                } else {
                    this.X = 200;
                    this.ab = p.a(this.ad - ((this.X / 2) / this.af), 0, this.f179a.a - (this.X / this.af));
                }
                if (this.f179a.b * this.af < ar) {
                    this.Y = this.f179a.b * this.af;
                    this.ac = 0;
                } else {
                    this.Y = ar;
                    this.ac = p.a(this.ae - ((this.Y / 2) / this.af), 0, this.f179a.b - (this.Y / this.af));
                }
                this.Z = (240 - this.X) / 2;
                this.aa = (k.a - this.Y) / 2;
                a(2063, this.Z - 90, this.aa - 60);
                a(2064, (this.Z + this.X) - 90, this.aa - 60);
                a(2065, (this.Z + this.X) - 90, (this.aa + this.Y) - 60);
                a(2066, this.Z - 90, (this.aa + this.Y) - 60);
                for (int i = 0; i < this.X; i += 20) {
                    a(2067, (this.Z + i) - 90, this.aa - 60);
                }
                for (int i2 = 0; i2 < this.Y; i2 += 20) {
                    a(2068, (this.Z + this.X) - 90, (this.aa + i2) - 60);
                }
                for (int i3 = 0; i3 < this.X; i3 += 20) {
                    a(2069, (this.Z + i3) - 90, (this.aa + this.Y) - 60);
                }
                for (int i4 = 0; i4 < this.Y; i4 += 20) {
                    a(2070, this.Z - 90, (this.aa + i4) - 60);
                }
                this.f185a[this.f104e].setColor(1825);
                a(this.f185a[this.f104e], 15 + this.f151k + this.Z, 10 + this.f152l + this.aa, this.X, this.Y);
            }
            c(this.f185a[this.f104e], 15 + this.f151k + this.Z, 10 + this.f152l + this.aa, this.X, this.Y);
            int i5 = this.f89a == 1 ? (this.Z + this.X) - 20 : this.Z;
            int i6 = this.f89a == 0 ? this.Z + 20 : this.Z + this.X;
            int i7 = this.f89a == 3 ? (this.aa + this.Y) - 20 : this.aa;
            int i8 = this.f89a == 2 ? this.aa + 1 : this.aa + this.Y;
            int i9 = 0;
            int i10 = 0;
            byte b = -1;
            int i11 = -1;
            int i12 = i7;
            while (true) {
                int i13 = i12;
                if (i13 >= i8) {
                    break;
                }
                int i14 = i5;
                while (true) {
                    int i15 = i14;
                    if (i15 < i6) {
                        short s = this.f195b[this.ac + ((i13 - this.aa) / this.af)][this.ab + ((i15 - this.Z) / this.af)];
                        int i16 = 0;
                        if (this.f178a.f293e < 2) {
                            if (((this.f178a.f301a[0][(this.ab + ((i15 - this.Z) / this.af)) >> 5][this.ac + ((i13 - this.aa) / this.af)] >> ((this.ab + ((i15 - this.Z) / this.af)) & 31)) & 1) == 0) {
                                s = -101;
                            } else if (((this.f178a.f301a[1][(this.ab + ((i15 - this.Z) / this.af)) >> 5][this.ac + ((i13 - this.aa) / this.af)] >> ((this.ab + ((i15 - this.Z) / this.af)) & 31)) & 1) == 0) {
                                if ((-s) > 0 && (-s) <= 100 && ((this.f189x[6060 - s] >> 1) & 1) == 0) {
                                    s = 0;
                                }
                                i16 = 3;
                            }
                        }
                        if (this.f178a.f293e == 2) {
                            int[] iArr = null;
                            if (((iArr[this.ac + ((i13 - this.aa) / this.af)] >> ((this.ab + ((i15 - this.Z) / this.af)) & 31)) & 1) == 0) {
                                s = -101;
                            }
                        }
                        for (int i17 = 0; i17 < 15; i17++) {
                            if (s <= this.f183e[this.f184f[3] + i17]) {
                                if (i15 < i6 - this.af) {
                                    if (b != this.f181v[this.f182d[79] + i17] || i11 != i16) {
                                        if (i10 > 0) {
                                            a(this.f185a[this.f104e], 15 + this.f151k + i9, 10 + this.f152l + i13, i10 * this.af, this.af);
                                        }
                                        i10 = 1;
                                        b = this.f181v[this.f182d[79] + i17];
                                        i9 = i15;
                                        i11 = i16;
                                        this.f185a[this.f104e].setColor(this.f181v[this.f182d[i16 + 73] + i17] & 255, this.f181v[this.f182d[i16 + 74] + i17] & 255, this.f181v[this.f182d[i16 + 75] + i17] & 255);
                                        break;
                                    }
                                    i10++;
                                    break;
                                }
                                if (b == this.f181v[this.f182d[79] + i17] && i11 == i16) {
                                    a(this.f185a[this.f104e], 15 + this.f151k + i9, 10 + this.f152l + i13, (i10 + 1) * this.af, this.af);
                                } else {
                                    a(this.f185a[this.f104e], 15 + this.f151k + i9, 10 + this.f152l + i13, i10 * this.af, this.af);
                                    this.f185a[this.f104e].setColor(this.f181v[this.f182d[i16 + 73] + i17] & 255, this.f181v[this.f182d[i16 + 74] + i17] & 255, this.f181v[this.f182d[i16 + 75] + i17] & 255);
                                    a(this.f185a[this.f104e], 15 + this.f151k + i15, 10 + this.f152l + i13, this.af, this.af);
                                }
                                i10 = 0;
                                b = -1;
                                break;
                            }
                        }
                        i14 = i15 + this.af;
                    }
                }
                i12 = i13 + this.af;
            }
            for (int i18 = i7 - ((this.ac * this.af) % 20); i18 < i8; i18 += 20) {
                for (int i19 = i5 - ((this.ab * this.af) % 20); i19 < i6; i19 += 20) {
                    a(2071, i19, i18);
                }
            }
            c(this.f185a[this.f104e], 0, 0, 270, k.f279a);
            this.f89a = (byte) -1;
        }
        this.f104e = (byte) 1;
        this.f185a[this.f104e].drawImage(this.f178a.f282a[0], 0, 0, 0);
        c(this.f185a[this.f104e], 15 + this.f151k + this.Z, 10 + this.f152l + this.aa, this.X, this.Y);
        a(2062, (this.Z + ((this.ad - this.ab) * this.af)) - 200, (this.aa + ((this.ae - this.ac) * this.af)) - 200);
        c(this.f185a[this.f104e], 0, 0, 270, k.f279a);
    }

    final void f() {
        int i;
        if (this.P == f120z) {
            this.aS++;
            this.P = 3;
        } else {
            this.aS = 0;
        }
        if (this.f89a != -1) {
            this.f104e = (byte) 0;
            if (this.f137s || ((this.P == f119y && this.f215z) || this.P == f121A)) {
                this.f185a[this.f104e].setClip(0, 0, 270, k.f279a);
                this.f185a[this.f104e].setColor(778);
                this.f185a[this.f104e].fillRect(0, 0, 270, k.f279a);
                a(2134, 0, 0);
            } else {
                a(false);
            }
            this.f89a = (byte) -1;
        }
        this.f104e = (byte) 1;
        this.f185a[this.f104e].drawImage(this.f178a.f282a[0], 0, 0, 0);
        if (this.f87n >= 0) {
            if (this.f88o == 0) {
                n(294, 0, 0, this.f87n, -1);
            } else if (this.b == 0) {
                a(2221, 0, 0);
            }
        }
        if (this.h >= 0) {
            n(this.h, 120, k.a / 2, this.f107v, -1);
        } else {
            int i2 = 0;
            if (this.f137s) {
                if (k.a == 208) {
                    i2 = 5;
                } else if (k.a == 180) {
                    i2 = 15;
                }
            }
            if (this.P == 12 || this.P == 9) {
                a(141, 120, (k.a / 2) + i2, 1, 0);
            } else if (this.P == 62 || this.P == 16) {
                int i3 = k.a / 2;
                if (k.a == 208 && this.f137s) {
                    i = 5;
                } else {
                    i = (k.a == 180 && this.f137s) ? 15 : 0;
                }
                a(142, 120, i3 + i, 1, 0);
            } else if (this.P == 18) {
                a(140, 120, k.a / 2, 1, 0);
            } else if (this.P == 8) {
                a(143, 120, k.a / 2, 1, 0);
            } else if ((this.f181v[this.f182d[89] + (this.P >> 3)] & (1 << (this.P & 7))) == 0) {
                this.f108n = false;
                a(139, 120, (k.a / 2) + i2, 1, 0);
                a(1902 + Math.max((this.G - 40) / 10, 0), 30, (((this.D + ((this.f114h - this.E) * f136J)) + ((f136J / 2) * this.J)) + 3) - 60);
            } else {
                this.f108n = true;
                a(139, 120, (k.a / 2) + i2, 1, 0);
            }
        }
        if (this.aS > 0) {
            this.P = f120z;
        } else {
            a(144, 0, k.a, 1, 0);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    final boolean a(byte b, int i, int i2, int i3, int i4, boolean z) {
        if (this.f178a.f311c[i3][1] >= 50) {
            return false;
        }
        int i5 = i3 * 50;
        while (true) {
            byte b2 = (byte) (i5 + 1);
            if (b2 > (i3 + 1) * 50) {
                return false;
            }
            if (this.f189x[b2 + 5454] == 0) {
                this.f189x[b2 + 6363] = (byte) i;
                this.f189x[b2 + 6464] = (byte) i2;
                this.f189x[b2 + 5252] = (byte) (i + (this.f178a.f327i[18][b] / 2));
                this.f189x[b2 + 5353] = (byte) (i2 + (this.f178a.f327i[19][b] / 2));
                this.f189x[b2 + 6161] = (byte) ((this.f189x[b2 + 6363] + this.f178a.f327i[18][b]) - 1);
                this.f189x[b2 + 6262] = (byte) (this.f189x[b2 + 6464] + this.f178a.f327i[19][b]);
                this.f189x[b2 + 5656] = b;
                if (z) {
                    this.f189x[b2 + 5454] = this.f181v[this.f182d[59] + b];
                    this.f189x[b2 + 6060] = 0;
                } else {
                    this.f189x[b2 + 5454] = (byte) ((this.f181v[this.f182d[59] + b] & 255) / 10);
                    this.f189x[b2 + 6060] = 1;
                }
                this.f189x[b2 + 6565] = 0;
                this.f189x[b2 + 5959] = 0;
                this.f189x[b2 + 5757] = 0;
                this.f189x[b2 + 7070] = 0;
                this.f189x[b2 + 6868] = -1;
                this.f189x[b2 + 6767] = -1;
                this.f189x[b2 + 6666] = (byte) i4;
                this.f189x[b2 + 5858] = this.f178a.h;
                this.f189x[b2 + 6969] = -1;
                this.f189x[b2 + 5555] = 0;
                k kVar = this.f178a;
                kVar.h = (byte) (kVar.h + 1);
                for (int i6 = i2; i6 < i2 + this.f178a.f327i[19][b]; i6++) {
                    for (int i7 = i; i7 < i + this.f178a.f327i[18][b]; i7++) {
                        this.f195b[i6][i7] = (byte) (-b2);
                    }
                }
                short[] sArr = this.f178a.f311c[i3];
                sArr[1] = (short) (sArr[1] + 1);
                if (i3 == this.f178a.f315j) {
                    this.f102d = (byte) -1;
                    if (this.f178a.f293e == 2) {
                        this.f179a.m83a((int) this.f189x[b2 + 5252], (int) this.f189x[b2 + 5353], (int) this.f179a.v[b]);
                    }
                }
                this.f179a.d(-b2);
                this.f179a.m82b(i3);
                if (i3 == this.f178a.f316d && this.f181v[this.f182d[94] + b] % 3 == 0) {
                    byte[] bArr = this.f179a.z;
                    bArr[i4] = (byte) (bArr[i4] + 1);
                }
                if (i + this.f178a.f327i[18][b] <= this.f179a.c || i2 + this.f178a.f327i[19][b] <= this.f179a.d || i >= this.f179a.c + 8 || i2 >= this.f179a.d + this.f179a.f430i) {
                    return true;
                }
                this.f89a = (byte) 4;
                return true;
            }
            i5 = b2;
        }
    }

    private void a(boolean[] zArr, byte[] bArr, short[] sArr, int[] iArr, int i, int i2, int i3, int i4) {
        try {
            this.as = i2;
            while (this.as < i2 + i3) {
                this.f172b <<= i;
                this.au += i;
                if (zArr != null) {
                    if (zArr[this.as]) {
                        this.f172b++;
                    }
                } else if (bArr != null) {
                    this.f172b += (long) (bArr[this.as] + i4);
                } else if (sArr != null) {
                    this.f172b += (long) (sArr[this.as] + i4);
                } else if (iArr != null) {
                    this.f172b += (long) (iArr[this.as] + i4);
                }
                if (this.au >= 32 || this.as == (i2 + i3) - 1) {
                    while (this.au >= 8) {
                        this.f174a.write((int) (this.f172b >> (this.au - 8)));
                        this.au -= 8;
                    }
                }
                this.as++;
            }
        } catch (Exception unused) {
        }
    }

    private void b(boolean[] zArr, byte[] bArr, short[] sArr, int[] iArr, int i, int i2, int i3, int i4) {
        try {
            this.av = 1;
            this.as = 0;
            while (this.as < i) {
                this.av <<= 1;
                this.as++;
            }
            this.av--;
            this.as = i2;
            while (this.as < i2 + i3) {
                while (this.au < i) {
                    this.f172b <<= 8;
                    this.f172b += (long) this.f175a.read();
                    this.au += 8;
                }
                this.at = (int) ((this.f172b >> (this.au - i)) & ((long) this.av));
                this.at -= i4;
                if (zArr != null) {
                    if (this.at > 0) {
                        zArr[this.as] = true;
                    } else {
                        zArr[this.as] = false;
                    }
                } else if (bArr != null) {
                    bArr[this.as] = (byte) this.at;
                } else if (sArr != null) {
                    sArr[this.as] = (short) this.at;
                } else if (iArr != null) {
                    iArr[this.as] = this.at;
                }
                this.au -= i;
                this.as++;
            }
        } catch (Exception unused) {
        }
    }

    private static String a(byte[] bArr, int i) {
        String str = "1011";
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length + 2];
            bArr2[0] = (byte) (length >> 8);
            bArr2[1] = (byte) length;
            System.arraycopy(bArr, 0, bArr2, 2, length);
            String string = new StringBuffer().append("aow2m").append(i).toString();
            try {
                RecordStore.deleteRecordStore(string);
            } catch (Exception unused) {
            }
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(string, true);
                recordStoreOpenRecordStore.addRecord(bArr2, 0, bArr2.length);
                recordStoreOpenRecordStore.closeRecordStore();
                return null;
            } catch (RecordStoreFullException unused2) {
                str = o.f384a[1][47];
                return str;
            }
        } catch (Exception unused3) {
            return str;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private boolean m48b(int i) {
        boolean z = false;
        try {
            int i2 = 0;
            this.f173a = RecordStore.openRecordStore(new StringBuffer().append("aow2m").append(i).toString(), true);
            if (this.f173a.getNumRecords() > 0) {
                try {
                    this.f175a = new DataInputStream(new ByteArrayInputStream(this.f173a.getRecord(1)));
                    short s = this.f175a.readShort();
                    for (int i3 = 0; i3 < s; i3++) {
                        this.f178a.f314e[i3] = this.f175a.readByte();
                        i2 = i3;
                    }
                    z = true;
                } catch (Exception unused) {
                }
                if (this.f175a != null) {
                    this.f175a.close();
                }
                InputStream inputStreamM4a = a.m4a("/dmt");
                if (inputStreamM4a != null) {
                    while (true) {
                        try {
                            int i4 = inputStreamM4a.read();
                            if (i4 == -1) {
                                break;
                            }
                            i2++;
                            this.f178a.f314e[i2] = (byte) i4;
                        } catch (IOException unused2) {
                            inputStreamM4a.close();
                        } catch (Throwable th) {
                            inputStreamM4a.close();
                            throw th;
                        }
                    }
                    inputStreamM4a.close();
                }
            }
            this.f173a.closeRecordStore();
            this.f173a = null;
        } catch (Exception unused3) {
        }
        return z;
    }

    private void F() {
        try {
            try {
                RecordStore.deleteRecordStore("aow213");
            } catch (Exception unused) {
                return;
            }
        } catch (Exception unused2) {
        }
        this.f173a = RecordStore.openRecordStore("aow213", true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f174a = new DataOutputStream(byteArrayOutputStream);
        this.f174a.writeInt(this.r);
        this.f174a.writeInt(this.s);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f174a.close();
        this.f173a.addRecord(byteArray, 0, byteArray.length);
        this.f173a.closeRecordStore();
    }

    private void G() {
        try {
            boolean z = true;
            this.f173a = RecordStore.openRecordStore("aow213", true);
            if (this.f173a.getNumRecords() > 0) {
                try {
                    this.f175a = new DataInputStream(new ByteArrayInputStream(this.f173a.getRecord(1)));
                    this.r = this.f175a.readInt();
                    this.s = this.f175a.readInt();
                } catch (Exception unused) {
                    z = false;
                }
                if (this.f175a != null) {
                    this.f175a.close();
                }
            } else {
                z = false;
            }
            this.f173a.closeRecordStore();
            if (z) {
                return;
            }
            this.r = 0;
            this.s = 0;
        } catch (Exception unused2) {
        }
    }

    private void H() {
        try {
            try {
                RecordStore.deleteRecordStore("aow212");
            } catch (Exception unused) {
                return;
            }
        } catch (Exception unused2) {
        }
        this.f173a = RecordStore.openRecordStore("aow212", true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f174a = new DataOutputStream(byteArrayOutputStream);
        this.f174a.writeInt(this.a);
        this.f174a.writeByte(this.m);
        this.f174a.writeByte(this.n);
        for (int i = 0; i < this.f200a.length; i++) {
            this.f174a.writeBoolean(this.f200a[i]);
        }
        synchronized (this.f201a) {
            int size = this.f201a.size();
            this.f174a.writeByte(size & 255);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    String[] strArr = (String[]) this.f201a.elementAt(i2);
                    this.f174a.writeUTF(strArr[0]);
                    this.f174a.writeUTF(strArr[1]);
                }
            }
        }
        for (int i3 = 0; i3 < f226y.length; i3++) {
            this.f174a.writeByte(f226y[i3]);
        }
        for (int i4 = 0; i4 < f227z.length; i4++) {
            this.f174a.writeByte(f227z[i4]);
        }
        this.f174a.writeByte(this.o);
        this.f174a.writeBoolean(this.f86a);
        this.f174a.writeByte(this.f178a.f284b);
        this.f174a.writeByte(this.p);
        this.f174a.writeByte(this.q);
        this.f174a.writeByte(this.c & 255);
        this.f174a.writeShort(this.f178a.f311c[this.f178a.f315j][10]);
        this.f174a.writeShort(this.f178a.f311c[this.f178a.f315j][9]);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f174a.close();
        this.f173a.addRecord(byteArray, 0, byteArray.length);
        this.f173a.closeRecordStore();
        this.f173a = null;
    }

    final void g() {
        try {
            boolean z = true;
            this.f173a = RecordStore.openRecordStore("aow212", true);
            if (this.f173a.getNumRecords() > 0) {
                try {
                    this.f175a = new DataInputStream(new ByteArrayInputStream(this.f173a.getRecord(1)));
                    this.a = this.f175a.readInt();
                    this.m = this.f175a.readByte();
                    this.n = this.f175a.readByte();
                    for (int i = 0; i < this.f200a.length; i++) {
                        this.f200a[i] = this.f175a.readBoolean();
                    }
                    this.f201a.removeAllElements();
                    int i2 = this.f175a.readByte() & 255;
                    if (i2 > 0) {
                        this.f201a.removeAllElements();
                        for (int i3 = 0; i3 < i2; i3++) {
                            this.f201a.addElement(new String[]{this.f175a.readUTF(), this.f175a.readUTF()});
                        }
                    }
                    for (int i4 = 0; i4 < f226y.length; i4++) {
                        f226y[i4] = this.f175a.readByte();
                    }
                    for (int i5 = 0; i5 < f227z.length; i5++) {
                        f227z[i5] = this.f175a.readByte();
                    }
                    this.o = this.f175a.readByte();
                    this.f86a = this.f175a.readBoolean();
                    this.f178a.f284b = this.f175a.readByte();
                    this.p = this.f175a.readByte();
                    this.q = this.f175a.readByte();
                    this.c = this.f175a.readByte() & 255;
                    this.f178a.f311c[this.f178a.f315j][10] = this.f175a.readShort();
                    this.f178a.f311c[this.f178a.f315j][9] = this.f175a.readShort();
                } catch (Exception unused) {
                    z = false;
                }
                if (this.f175a != null) {
                    this.f175a.close();
                }
            } else {
                z = false;
            }
            this.f173a.closeRecordStore();
            this.f173a = null;
            if (!z) {
                this.a = 100000000 + ((this.f179a.f462a.nextInt() & Integer.MAX_VALUE) % 900000000);
                this.m = -1;
                this.n = -1;
                this.o = -1;
                for (int i6 = 0; i6 < this.f200a.length; i6++) {
                    this.f200a[i6] = false;
                }
                this.f201a.removeAllElements();
                this.c = 0;
            }
            f(-1, this.f178a.f284b);
            H();
        } catch (Exception unused2) {
        }
    }

    private void I() {
        for (int i = 0; i < p.f525a.length; i++) {
            try {
                if (a.a(p.f525a[i], 1) > 0) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        try {
            RecordStore.deleteRecordStore(this.t == 0 ? "aow211" : "aow214");
        } catch (Exception unused2) {
        }
        this.f173a = RecordStore.openRecordStore(this.t == 0 ? "aow211" : "aow214", true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f174a = new DataOutputStream(byteArrayOutputStream);
        this.f174a.writeByte(this.f178a.h);
        this.f174a.writeInt(this.f178a.f317e);
        this.f174a.writeByte(this.f178a.f315j);
        this.f174a.writeInt(this.f179a.f407a);
        this.f174a.writeInt(this.f179a.f408b);
        this.f174a.writeByte(this.f179a.f448d);
        this.f174a.writeByte(this.f179a.f445k);
        this.f174a.writeByte(this.e);
        this.f174a.writeByte(this.f);
        this.f174a.writeByte(this.f179a.f446l);
        this.f174a.writeByte(this.f179a.f447m);
        this.f174a.writeInt(this.f179a.f449e);
        this.f174a.writeInt(this.f179a.f450f);
        this.f174a.writeByte(this.f179a.f459n);
        this.f174a.writeByte(this.f179a.c);
        this.f174a.writeByte(this.f179a.d);
        this.f174a.writeLong(this.f179a.f414a);
        this.f174a.writeByte(this.f179a.f418e);
        this.f174a.writeByte(this.f179a.f419f);
        this.f174a.writeByte(this.f179a.f420g);
        this.f174a.writeByte(this.f179a.f421h);
        this.f174a.writeByte(this.f90b);
        this.f174a.writeByte(this.f91c);
        this.f174a.writeByte(this.af);
        this.f174a.writeByte(this.f159j);
        if (this.f178a.f293e < 2) {
            for (int i2 = 0; i2 < 4; i2++) {
                for (int i3 = 0; i3 < 128; i3++) {
                    this.f174a.writeInt(this.f178a.f301a[0][i2][i3]);
                }
            }
        } else if (this.f178a.f293e < 3) {
            for (int i4 = 0; i4 < 4; i4++) {
                for (int i5 = 0; i5 < 128; i5++) {
                    int[] iArr = null;
                    this.f174a.writeInt(iArr[i5]);
                }
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f179a.b; i7++) {
            for (int i8 = 0; i8 < this.f179a.a; i8++) {
                if (this.f195b[i7][i8] >= 121 && this.f195b[i7][i8] <= 123) {
                    i6++;
                }
            }
        }
        this.f174a.writeInt(i6);
        for (int i9 = 0; i9 < this.f179a.b; i9++) {
            for (int i10 = 0; i10 < this.f179a.a; i10++) {
                if (this.f195b[i9][i10] >= 121 && this.f195b[i9][i10] <= 123) {
                    this.f174a.writeByte(i10);
                    this.f174a.writeByte(i9);
                    this.f174a.writeByte(this.f195b[i9][i10] - 121);
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f179a.b; i12++) {
            for (int i13 = 0; i13 < this.f179a.a; i13++) {
                if (this.f195b[i12][i13] >= 1001 && this.f195b[i12][i13] <= 1200) {
                    i11++;
                }
            }
        }
        this.f174a.writeInt(i11);
        for (int i14 = 0; i14 < this.f179a.b; i14++) {
            for (int i15 = 0; i15 < this.f179a.a; i15++) {
                if (this.f195b[i14][i15] >= 1001 && this.f195b[i14][i15] <= 1200) {
                    this.f174a.writeByte(i15);
                    this.f174a.writeByte(i14);
                    this.f174a.writeByte(this.f195b[i14][i15] - 1001);
                }
            }
        }
        this.au = 0;
        a((boolean[]) null, (byte[]) null, this.f178a.f311c[0], (int[]) null, 18, 0, 10, 65536);
        a((boolean[]) null, (byte[]) null, this.f178a.f311c[1], (int[]) null, 18, 0, 10, 65536);
        for (int i16 = 1; i16 <= 4; i16++) {
            a((boolean[]) null, this.f190c[i16], (short[]) null, (int[]) null, 7, 0, 51, 0);
        }
        int i17 = 0;
        for (int i18 = 0; i18 < 72; i18++) {
            if (this.f181v[this.f182d[8] + i18] > 0) {
                a((boolean[]) null, this.f189x, (short[]) null, (int[]) null, this.f181v[this.f182d[8] + i18], i17 + 1, 100, this.f181v[this.f182d[9] + i18] & 255);
            }
            i17 += 101;
        }
        a((boolean[]) null, this.f179a.o, (short[]) null, (int[]) null, 5, 0, 60, 1);
        a((boolean[]) null, this.f179a.f409p, (short[]) null, (int[]) null, 6, 0, 60, 1);
        a((boolean[]) null, this.f179a.f410q, (short[]) null, (int[]) null, 7, 0, 60, 1);
        a((boolean[]) null, this.f179a.f401a, (short[]) null, (int[]) null, 7, 0, 400, 0);
        a((boolean[]) null, this.f179a.f402b, (short[]) null, (int[]) null, 7, 0, 400, 0);
        a((boolean[]) null, this.f179a.f403c, (short[]) null, (int[]) null, 5, 0, 400, 16);
        a((boolean[]) null, this.f179a.f404d, (short[]) null, (int[]) null, 5, 0, 400, 16);
        a((boolean[]) null, this.f179a.e, (short[]) null, (int[]) null, 8, 0, 400, 128);
        a((boolean[]) null, this.f179a.f, (short[]) null, (int[]) null, 8, 0, 400, 128);
        a((boolean[]) null, this.f179a.g, (short[]) null, (int[]) null, 8, 0, 400, 128);
        a((boolean[]) null, this.f179a.h, (short[]) null, (int[]) null, 8, 0, 400, 128);
        a((boolean[]) null, this.f179a.i, (short[]) null, (int[]) null, 8, 0, 400, 128);
        a((boolean[]) null, this.f179a.f405j, (short[]) null, (int[]) null, 5, 0, 400, 0);
        a((boolean[]) null, this.f179a.k, (short[]) null, (int[]) null, 5, 0, 400, 1);
        a((boolean[]) null, this.f179a.l, (short[]) null, (int[]) null, 5, 0, 400, 1);
        a((boolean[]) null, this.f179a.m, (short[]) null, (int[]) null, 5, 0, 400, 1);
        a((boolean[]) null, this.f179a.n, (short[]) null, (int[]) null, 5, 0, 400, 1);
        a(this.f179a.f433a, (byte[]) null, (short[]) null, (int[]) null, 1, 0, 3, 0);
        a((boolean[]) null, this.f179a.f437w, (short[]) null, (int[]) null, 5, 0, 3, 0);
        a((boolean[]) null, this.f179a.z, (short[]) null, (int[]) null, 5, 0, 3, 0);
        a(this.f179a.f440b, (byte[]) null, (short[]) null, (int[]) null, 1, 0, 3, 0);
        a(this.f179a.f441c, (byte[]) null, (short[]) null, (int[]) null, 1, 0, 3, 0);
        a((boolean[]) null, this.f179a.f451f[0], (short[]) null, (int[]) null, 5, 0, 3, 1);
        a((boolean[]) null, this.f179a.f451f[1], (short[]) null, (int[]) null, 5, 0, 3, 1);
        a((boolean[]) null, this.f179a.f452x, (short[]) null, (int[]) null, 5, 0, 3, 1);
        a((boolean[]) null, (byte[]) null, (short[]) null, this.f179a.f453a, 24, 0, 3, 1);
        a((boolean[]) null, (byte[]) null, (short[]) null, this.f179a.f454b, 24, 0, 3, 1);
        a((boolean[]) null, (byte[]) null, (short[]) null, this.f179a.f455c, 24, 0, 3, 1);
        if (this.au > 0) {
            this.f174a.write((int) (this.f172b << (8 - this.au)));
        }
        this.f174a.writeByte(this.f113g);
        this.f174a.writeByte(this.f179a.f461o);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f174a.close();
        this.f173a.addRecord(byteArray, 0, byteArray.length);
        this.f173a.closeRecordStore();
    }

    private void J() {
        try {
            this.f173a = RecordStore.openRecordStore(new StringBuffer().append("aow21").append(this.t == 0 ? "1" : "4").toString(), true);
            if (this.f173a.getNumRecords() > 0) {
                try {
                    this.f175a = new DataInputStream(new ByteArrayInputStream(this.f173a.getRecord(1)));
                    this.f178a.h = this.f175a.readByte();
                    this.f178a.f317e = this.f175a.readInt();
                    this.f178a.f315j = this.f175a.readByte();
                    this.f179a.f407a = this.f175a.readInt();
                    this.f179a.f408b = this.f175a.readInt();
                    this.f179a.f448d = this.f175a.readByte();
                    this.f179a.f445k = this.f175a.readByte();
                    this.e = this.f175a.readByte();
                    this.f = this.f175a.readByte();
                    this.f179a.f446l = this.f175a.readByte();
                    this.f179a.f447m = this.f175a.readByte();
                    this.f179a.f449e = this.f175a.readInt();
                    this.f179a.f450f = this.f175a.readInt();
                    this.f179a.f459n = this.f175a.readByte();
                    this.f179a.c = this.f175a.readByte();
                    this.f179a.d = this.f175a.readByte();
                    this.f179a.f414a = this.f175a.readLong();
                    this.f179a.f418e = this.f175a.readByte();
                    this.f179a.f419f = this.f175a.readByte();
                    this.f179a.f420g = this.f175a.readByte();
                    this.f179a.f421h = this.f175a.readByte();
                    this.f90b = this.f175a.readByte();
                    this.f91c = this.f175a.readByte();
                    this.af = this.f175a.readByte();
                    this.f159j = this.f175a.readByte();
                    if (this.f178a.f293e < 2) {
                        for (int i = 0; i < 4; i++) {
                            for (int i2 = 0; i2 < 128; i2++) {
                                this.f178a.f301a[0][i][i2] = this.f175a.readInt();
                            }
                        }
                    } else if (this.f178a.f293e < 3) {
                        for (int i3 = 0; i3 < 4; i3++) {
                            for (int i4 = 0; i4 < 128; i4++) {
                                int[] iArr = null;
                                iArr[i4] = this.f175a.readInt();
                            }
                        }
                    }
                    int i5 = this.f175a.readInt();
                    for (int i6 = 0; i6 < i5; i6++) {
                        this.f195b[this.f175a.readByte()][this.f175a.readByte()] = (short) (121 + this.f175a.readByte());
                    }
                    int i7 = this.f175a.readInt();
                    for (int i8 = 0; i8 < i7; i8++) {
                        this.f195b[this.f175a.readByte()][this.f175a.readByte()] = (short) (1001 + (this.f175a.readByte() & 255));
                    }
                    this.au = 0;
                    b(null, null, this.f178a.f311c[0], null, 18, 0, 10, 65536);
                    b(null, null, this.f178a.f311c[1], null, 18, 0, 10, 65536);
                    for (int i9 = 1; i9 <= 4; i9++) {
                        b(null, this.f190c[i9], null, null, 7, 0, 51, 0);
                    }
                    int i10 = 0;
                    for (int i11 = 0; i11 < 72; i11++) {
                        if (this.f181v[this.f182d[8] + i11] > 0) {
                            b(null, this.f189x, null, null, this.f181v[this.f182d[8] + i11], i10 + 1, 100, this.f181v[this.f182d[9] + i11] & 255);
                        } else {
                            for (int i12 = 1; i12 < 101; i12++) {
                                this.f189x[i10 + i12] = 0;
                            }
                        }
                        i10 += 101;
                    }
                    b(null, this.f179a.o, null, null, 5, 0, 60, 1);
                    b(null, this.f179a.f409p, null, null, 6, 0, 60, 1);
                    b(null, this.f179a.f410q, null, null, 7, 0, 60, 1);
                    b(null, this.f179a.f401a, null, null, 7, 0, 400, 0);
                    b(null, this.f179a.f402b, null, null, 7, 0, 400, 0);
                    b(null, this.f179a.f403c, null, null, 5, 0, 400, 16);
                    b(null, this.f179a.f404d, null, null, 5, 0, 400, 16);
                    b(null, this.f179a.e, null, null, 8, 0, 400, 128);
                    b(null, this.f179a.f, null, null, 8, 0, 400, 128);
                    b(null, this.f179a.g, null, null, 8, 0, 400, 128);
                    b(null, this.f179a.h, null, null, 8, 0, 400, 128);
                    b(null, this.f179a.i, null, null, 8, 0, 400, 128);
                    b(null, this.f179a.f405j, null, null, 5, 0, 400, 0);
                    b(null, this.f179a.k, null, null, 5, 0, 400, 1);
                    b(null, this.f179a.l, null, null, 5, 0, 400, 1);
                    b(null, this.f179a.m, null, null, 5, 0, 400, 1);
                    b(null, this.f179a.n, null, null, 5, 0, 400, 1);
                    b(this.f179a.f433a, null, null, null, 1, 0, 3, 0);
                    b(null, this.f179a.f437w, null, null, 5, 0, 3, 0);
                    b(null, this.f179a.z, null, null, 5, 0, 3, 0);
                    b(this.f179a.f440b, null, null, null, 1, 0, 3, 0);
                    b(this.f179a.f441c, null, null, null, 1, 0, 3, 0);
                    b(null, this.f179a.f451f[0], null, null, 5, 0, 3, 1);
                    b(null, this.f179a.f451f[1], null, null, 5, 0, 3, 1);
                    b(null, this.f179a.f452x, null, null, 5, 0, 3, 1);
                    b(null, null, null, this.f179a.f453a, 24, 0, 3, 1);
                    b(null, null, null, this.f179a.f454b, 24, 0, 3, 1);
                    b(null, null, null, this.f179a.f455c, 24, 0, 3, 1);
                    try {
                        this.f113g = this.f175a.readByte();
                        this.f179a.m77a(this.f113g);
                        this.f179a.f461o = this.f175a.readByte();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
                if (this.f175a != null) {
                    this.f175a.close();
                }
            }
            this.f173a.closeRecordStore();
            this.f190c[0][50] = 0;
            for (int i13 = 0; i13 < 48; i13++) {
                if ((this.f179a.f414a & (1 << i13)) != 0) {
                    boolean z = true;
                    for (int i14 = ((i13 / 24) * 50) + 1; i14 <= ((i13 / 24) + 1) * 50; i14++) {
                        if (((this.f189x[i14 + 5454] + 1) & 255) > 1 && ((this.f189x[i14 + 5656] == 4 || this.f189x[i14 + 5656] == 12) && this.f189x[i14 + 6868] == i13)) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        this.f179a.c(i13);
                    }
                }
            }
            for (int i15 = 0; i15 < 2; i15++) {
                this.f179a.m82b(i15);
            }
            for (int i16 = 1; i16 < 101; i16++) {
                this.f189x[i16 + 5151] = -1;
            }
            for (int i17 = 1; i17 <= 100; i17++) {
                if (this.f189x[i17 + 5454] != 0) {
                    for (int i18 = 0; i18 < this.f178a.f327i[18][this.f189x[i17 + 5656]]; i18++) {
                        for (int i19 = 0; i19 < this.f178a.f327i[19][this.f189x[i17 + 5656]]; i19++) {
                            this.f195b[this.f189x[i17 + 6464] + i19][this.f189x[i17 + 6363] + i18] = (short) (-i17);
                        }
                    }
                }
            }
            for (byte b = 1; b <= 100; b = (byte) (b + 1)) {
                if (this.f189x[b + 1616] != 0) {
                    if (this.f195b[this.f189x[b + 101]][this.f189x[b + 0]] == 0) {
                        this.f195b[this.f189x[b + 101]][this.f189x[b + 0]] = b;
                    }
                    if ((this.f189x[b + 2828] & 16) != 0 && this.f195b[this.f189x[b + 101] + this.f181v[this.f182d[1] + 8 + this.f189x[b + 404]]][this.f189x[b + 0] + this.f181v[this.f182d[1] + this.f189x[b + 404]]] == 0) {
                        this.f195b[this.f189x[b + 101] + this.f181v[this.f182d[1] + 8 + this.f189x[b + 404]]][this.f189x[b + 0] + this.f181v[this.f182d[1] + this.f189x[b + 404]]] = 127;
                    }
                }
            }
            this.f179a.d();
            G();
            if (this.r > this.f178a.f317e) {
                this.s++;
                this.r = this.f178a.f317e;
                F();
            }
            if (this.f178a.f293e < 2) {
                this.f179a.e();
            }
            if (this.t == 0) {
                this.d = this.p;
            } else {
                this.d = this.q;
            }
            for (byte b2 = 0; b2 < 3; b2 = (byte) (b2 + 1)) {
                if (this.f179a.f437w[b2] > 0) {
                    this.f179a.f438c[b2][50] = (byte) (this.f181v[(this.f182d[108] + this.f179a.f437w[b2]) + 1] - this.f181v[this.f182d[108] + this.f179a.f437w[b2]]);
                    for (byte b3 = 0; b3 < this.f179a.f438c[b2][50]; b3 = (byte) (b3 + 1)) {
                        this.f179a.f438c[b2][b3] = this.f179a.u[this.f181v[this.f182d[107] + this.f181v[this.f182d[108] + this.f179a.f437w[b2]] + b3]];
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }

    private static boolean a(Graphics graphics, Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        try {
            graphics.drawRegion(image, i, i2, i3, i4, 0, i5, i6, 20);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void a(Graphics graphics, int i, int i2, int i3, int i4) {
        graphics.fillRect(i, i2, i3, i4);
    }

    private static void b(Graphics graphics, int i, int i2, int i3, int i4) {
        graphics.drawRect(i, i2, i3, i4);
    }

    private static void c(Graphics graphics, int i, int i2, int i3, int i4) {
        graphics.setClip(i, i2, i3, i4);
    }

    private static void d(Graphics graphics, int i, int i2, int i3, int i4) {
        graphics.drawLine(i, i2, i3, i4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x053f  */
    /* JADX WARN: Code duplicated, block: B:185:0x075f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0524  */
    /* JADX WARN: Code duplicated, block: B:94:0x052b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0530  */
    /* JADX WARN: Code duplicated, block: B:97:0x0534  */
    /* JADX WARN: Code duplicated, block: B:99:0x053a  */
    final void a(int i, int i2, int i3, int i4, int i5) {
        char c;
        int i6 = 0;
        int i7 = -1;
        int iA = i5 > 0 ? this.f189x[i5 + 5454] == -1 ? 7 : p.a((this.f189x[i5 + 6060] & 1) != 0 ? 4 : 7 - (((this.f189x[i5 + 5454] & 255) << 2) / (this.f181v[this.f182d[59] + i] & 255)), 4, 7) : 0;
        for (int i8 = this.f178a.f328f[14][i]; i8 <= this.f178a.f328f[15][i]; i8++) {
            short s = this.f178a.f328f[16][i8];
            if (this.f178a.f327i[24][i8] == 2) {
                if (i >= 15) {
                    if (this.f178a.f327i[25][i8] != i6) {
                        i6 = this.f178a.f327i[25][i8];
                        i7 = 0;
                    } else {
                        i7++;
                    }
                    if (i >= 134 && i < 144 && i6 == 15 && i7 == 0) {
                        for (int i9 = 0; i9 <= 8; i9++) {
                            this.f170a[2][i9] = -1;
                        }
                    }
                    switch (i) {
                        case 133:
                            b(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 134:
                            c(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 135:
                            d(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 136:
                            e(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 137:
                            f(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 139:
                            if (this.f108n) {
                                g(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            } else {
                                h(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            }
                            break;
                        case 140:
                            i(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 141:
                            j(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 142:
                            int i10 = i6;
                            int i11 = i7;
                            int i12 = i2 + this.f178a.f328f[17][i8];
                            int i13 = i3 + this.f178a.f327i[20][i8];
                            if (i10 != 0) {
                                if (i10 != 15) {
                                    if (i11 == 0) {
                                        c = 4;
                                    } else if (i11 == 1) {
                                        c = 6;
                                    } else {
                                        c = 5;
                                    }
                                    char c2 = c;
                                    this.f170a[0][c2] = i12;
                                    this.f170a[1][c2] = i13;
                                    this.f170a[2][c2] = this.f178a.f327i[3][s];
                                    this.f170a[3][c2] = this.f178a.f327i[4][s];
                                }
                                break;
                            } else {
                                switch (i11) {
                                    case 0:
                                        a(s, i12, i13);
                                        if (i10 != 15) {
                                            if (i11 == 0) {
                                                c = 4;
                                            } else if (i11 == 1) {
                                                c = 6;
                                            } else {
                                                c = 5;
                                            }
                                            char c3 = c;
                                            this.f170a[0][c3] = i12;
                                            this.f170a[1][c3] = i13;
                                            this.f170a[2][c3] = this.f178a.f327i[3][s];
                                            this.f170a[3][c3] = this.f178a.f327i[4][s];
                                        }
                                        break;
                                    case 1:
                                        switch (this.f88o) {
                                            case 1:
                                            case 2:
                                            case 3:
                                                n((295 + this.f88o) - 1, i12, i13, this.f87n, -1);
                                                break;
                                            case 4:
                                                n(298 + this.b, i12, i13, this.f87n, -1);
                                                break;
                                            default:
                                                if (i10 != 15) {
                                                    if (i11 == 0) {
                                                        c = 4;
                                                    } else if (i11 == 1) {
                                                        c = 6;
                                                    } else {
                                                        c = 5;
                                                    }
                                                    char c4 = c;
                                                    this.f170a[0][c4] = i12;
                                                    this.f170a[1][c4] = i13;
                                                    this.f170a[2][c4] = this.f178a.f327i[3][s];
                                                    this.f170a[3][c4] = this.f178a.f327i[4][s];
                                                }
                                                break;
                                        }
                                        break;
                                    default:
                                        if (i10 != 15) {
                                            if (i11 == 0) {
                                                c = 4;
                                            } else if (i11 == 1) {
                                                c = 6;
                                            } else {
                                                c = 5;
                                            }
                                            char c5 = c;
                                            this.f170a[0][c5] = i12;
                                            this.f170a[1][c5] = i13;
                                            this.f170a[2][c5] = this.f178a.f327i[3][s];
                                            this.f170a[3][c5] = this.f178a.f327i[4][s];
                                        }
                                        break;
                                }
                            }
                            break;
                        case 143:
                            k(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 144:
                            l(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                        case 145:
                            m(i6, i7, s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            break;
                    }
                } else {
                    switch (this.f178a.f327i[25][i8]) {
                        case 1:
                            if (i4 == 1 && this.f178a.f327i[23][i8] == 2 && this.f189x[i5 + 6969] >= 0 && this.f189x[i5 + 6969] < this.f181v[this.f182d[46] + this.f181v[this.f182d[60] + i]]) {
                                n(s + this.f189x[i5 + 7070], i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8], this.f189x[i5 + 6969], -1);
                            }
                            break;
                        case 2:
                            if (i4 == 1 && this.f178a.f327i[23][i8] == 1) {
                                a(s + this.f189x[i5 + 7070], i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            }
                            break;
                        case 10:
                            if (i4 == 1 && (((this.f189x[i5 + 6060] & 1) != 0 || this.f189x[i5 + 7171] == 0 || ((this.f181v[this.f182d[94] + i] % 3 > 0 || i == 4 || i == 12) && this.f189x[i5 + 6868] < 0)) && this.f178a.f327i[23][i8] == 1)) {
                                a(s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                            }
                            break;
                    }
                }
            } else if ((this.f178a.f327i[24][i8] == i4 || i >= 133) && (this.f178a.f327i[25][i8] <= 0 || ((i4 != 0 || this.f178a.f327i[25][i8] == iA) && (i4 != 1 || this.f178a.f327i[25][i8] <= iA)))) {
                if (this.f178a.f327i[23][i8] == 0) {
                    d(s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                } else if (this.f178a.f327i[23][i8] == 1) {
                    a(s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8]);
                } else if (this.f178a.f327i[23][i8] == 2 && this.f189x[i5 + 7171] != 0 && (this.f189x[i5 + 6060] & 1) == 0 && ((this.f181v[this.f182d[94] + i] % 3 <= 0 && i != 4 && i != 12) || this.f189x[i5 + 6868] >= 0)) {
                    n(s, i2 + this.f178a.f328f[17][i8], i3 + this.f178a.f327i[20][i8], this.f178a.f317e + i + i5, -1);
                }
            }
        }
        if (o.f387a > 0) {
            this.f180a.a(this.f185a[this.f104e]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x030b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0337  */
    /* JADX WARN: Code duplicated, block: B:66:0x0349  */
    /* JADX WARN: Code duplicated, block: B:67:0x0375  */
    /* JADX WARN: Code duplicated, block: B:69:0x0387  */
    /* JADX WARN: Code duplicated, block: B:70:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x03f0  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void c(int i, int i2, int i3) {
        int i4 = i2 + this.f189x[i + 202];
        int i5 = i3 + this.f189x[i + 303];
        if (this.f189x[i + 1616] > 0 && i > this.f178a.f315j * 50 && i <= (this.f178a.f315j + 1) * 50 && (this.f189x[i + 2929] & 1) != 0) {
            a(1811 + (3 - this.f181v[this.f182d[57] + this.f189x[i + 2323]]), i4 - 90, i5 - 60);
        }
        int iM84a = this.f189x[i + 1414] >= 10 ? (231 + this.f189x[i + 1414]) - 10 : this.f179a.m84a((int) this.f189x[i + 2323], (int) this.f189x[i + 1414]) + (((15 & (1 << this.f189x[i + 2323])) == 0 || this.f189x[i + 1414] != 0 || (this.f189x[i + 2828] & 7) == 0) ? (short) 0 : (short) 8) + this.f189x[i + 404];
        int i6 = (this.f178a.f328f[12][iM84a] - this.f178a.f328f[11][iM84a]) + 1;
        boolean z = this.f141f >= 0 && i > this.f178a.f315j * 50 && i <= (this.f178a.f315j + 1) * 50 && Math.min((int) this.f141f, (int) this.f90b) <= this.f189x[i + 0] && Math.max((int) this.f141f, (int) this.f90b) >= this.f189x[i + 0] && Math.min((int) this.f142K, (int) this.f91c) <= this.f189x[i + 101] && Math.max((int) this.f142K, (int) this.f91c) >= this.f189x[i + 101];
        int i7 = this.f178a.f328f[11][iM84a] + (this.f189x[i + 1313] < i6 ? this.f189x[i + 1313] : (byte) 0);
        short s = this.f178a.f328f[13][i7];
        int i8 = i4 + this.f178a.f327i[15][i7];
        int i9 = i5 + this.f178a.f327i[16][i7];
        byte b = 7;
        this.f176v = i >= 51;
        for (int i10 = 0; i10 < 3; i10++) {
            b = (byte) (b | (1 << this.f181v[this.f182d[54 + ((this.f189x[i + 2828] >> i10) & 1)] + i10]));
        }
        for (int i11 = this.f178a.f328f[8][s]; i11 <= this.f178a.f328f[9][s]; i11++) {
            if ((b & (1 << this.f178a.f327i[13][i11])) != 0) {
                int i12 = this.f178a.f328f[10][i11];
                byte b2 = this.f181v[this.f182d[53] + this.f178a.f327i[13][i11]];
                if (b2 <= 0) {
                    if (this.f178a.f327i[12][i11] == 0) {
                        d(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11]);
                    } else if (this.f178a.f327i[12][i11] == 1) {
                        a(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11]);
                    } else if (this.f178a.f327i[13][i11] <= 2) {
                        n(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11], this.f178a.f317e + i, -1);
                    } else if (this.f189x[2525 + (b2 * 101) + i] <= this.f178a.f328f[6][i12] - this.f178a.f328f[5][i12]) {
                        b = (byte) (b & ((1 << this.f181v[(this.f182d[54] + this.f178a.f327i[13][i11]) - 3]) ^ (-1)));
                        n(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11], this.f189x[2525 + (b2 * 101) + i], -1);
                    }
                } else if (this.f189x[i + 2323] != 17) {
                    i12 += this.f189x[(404 + (b2 * 101)) + i] - this.f189x[i + 404];
                    if (this.f178a.f327i[12][i11] == 0) {
                        d(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11]);
                    } else if (this.f178a.f327i[12][i11] == 1) {
                        a(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11]);
                    } else if (this.f178a.f327i[13][i11] <= 2) {
                        n(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11], this.f178a.f317e + i, -1);
                    } else if (this.f189x[2525 + (b2 * 101) + i] <= this.f178a.f328f[6][i12] - this.f178a.f328f[5][i12]) {
                        b = (byte) (b & ((1 << this.f181v[(this.f182d[54] + this.f178a.f327i[13][i11]) - 3]) ^ (-1)));
                        n(i12, i8 + this.f178a.f327i[10][i11], i9 + this.f178a.f327i[11][i11], this.f189x[2525 + (b2 * 101) + i], -1);
                    }
                }
            }
        }
        this.f176v = false;
        if (this.f189x[i + 1616] > 0 && (i - 1) / 50 == this.f178a.f315j && ((this.f189x[i + 2929] & 1) != 0 || this.f95a == i || z)) {
            a(1854 + ((this.f181v[this.f182d[42] + this.f189x[i + 2323]] - 30) / 12), i4 - 90, i5 - 60);
            this.y = ((12 + (((this.f181v[this.f182d[42] + this.f189x[i + 2323]] - 30) / 12) << 1)) * this.f189x[i + 1616]) / this.f181v[this.f182d[42] + this.f189x[i + 2323]];
            this.z = ((this.f189x[i + 1616] - 1) * 3) / this.f181v[this.f182d[42] + this.f189x[i + 2323]];
            d(1399 - this.z, this.w, this.x);
        }
        if (this.f189x[i + 1616] > 0) {
            if (this.f95a == i && this.f98f >= 0) {
                n(this.f98f, i4, i5, Math.max((int) this.f94r, 0), -1);
            }
            if (z) {
                n(253 + ((16447 & (1 << this.f189x[i + 2323])) == 0 ? 1 : 0), i4, i5, Math.max((int) this.f94r, 0), -1);
            }
        }
    }

    private void n(int i, int i2, int i3, int i4, int i5) {
        try {
            int i6 = this.f178a.f328f[5][i] + (i4 % ((this.f178a.f328f[6][i] - this.f178a.f328f[5][i]) + 1));
            if (i == 59) {
                this.aw = i2;
                this.f177T = this.f179a.f405j[i5];
            }
            if (this.f178a.f327i[9][i6] == 0) {
                d(this.f178a.f328f[7][i6], i2 + this.f178a.f327i[7][i6], i3 + this.f178a.f327i[8][i6]);
            } else {
                a(this.f178a.f328f[7][i6], i2 + this.f178a.f327i[7][i6], i3 + this.f178a.f327i[8][i6]);
            }
            this.aw = -1000;
        } catch (Exception unused) {
        }
    }

    final void a(int i, int i2, int i3) {
        if (this.f178a.f291d || i < 2257) {
            for (int i4 = this.f178a.f328f[0][i]; i4 <= this.f178a.f328f[1][i]; i4++) {
                short s = this.f178a.f328f[2][i4];
                if (this.f178a.f327i[6][i4] == 0) {
                    d(s, i2 + this.f178a.f328f[3][i4], i3 + this.f178a.f328f[4][i4]);
                } else {
                    a(s, i2 + this.f178a.f328f[3][i4], i3 + this.f178a.f328f[4][i4]);
                }
                if (i4 == this.f178a.f328f[0][i] && i >= 1854 && i <= 1867) {
                    this.w = i2 + this.f178a.f328f[3][i4] + 1;
                    this.x = i3 + this.f178a.f328f[4][i4] + 1;
                }
            }
        }
    }

    private void d(int i, int i2, int i3) {
        if (this.f178a.f291d || i < 2095) {
            int i4 = this.f178a.f327i[0][i] & 255;
            try {
                if (this.aw > -1000) {
                    i3 += ((i2 - this.aw) * this.f181v[(this.f182d[14] + 32) + this.f177T]) / 100;
                    i2 = ((this.aw + (((((i2 - this.aw) - 15) + ((this.f178a.f327i[3][i] & 255) / 2)) * this.f181v[this.f182d[14] + this.f177T]) / 100)) - ((this.f178a.f327i[3][i] & 255) / 2)) + 15;
                }
                int i5 = i2 + 15 + this.f151k;
                int i6 = i3 + 10 + this.f152l;
                if (this.f178a.f288a && !this.f149c) {
                    i5 -= this.f178a.f280b;
                    i6 -= this.f178a.f281c;
                }
                switch (i4) {
                    case 43:
                        this.f185a[this.f104e].setColor(n.a[this.f178a.f327i[5][i] & 255]);
                        d(this.f185a[this.f104e], i5 + (this.f178a.f327i[1][i] & 255), i6 + (this.f178a.f327i[2][i] & 255), i5 + (this.f178a.f327i[3][i] & 255), i6 + (this.f178a.f327i[4][i] & 255));
                        break;
                    case 44:
                        this.f185a[this.f104e].setColor(n.a[this.f178a.f327i[5][i] & 255]);
                        b(this.f185a[this.f104e], i5 + (this.f178a.f327i[1][i] & 255), i6 + (this.f178a.f327i[2][i] & 255), this.f178a.f327i[3][i] & 255, this.f178a.f327i[4][i] & 255);
                        break;
                    case 45:
                        this.f185a[this.f104e].setColor(n.a[this.f178a.f327i[5][i] & 255]);
                        a(this.f185a[this.f104e], i5 + (this.f178a.f327i[1][i] & 255), i6 + (this.f178a.f327i[2][i] & 255), this.f178a.f327i[3][i] & 255, this.f178a.f327i[4][i] & 255);
                        break;
                    case 46:
                        this.f185a[this.f104e].setColor(n.a[this.f178a.f327i[5][i] & 255]);
                        b(this.f185a[this.f104e], i5 + ((this.f178a.f327i[1][i] & 255) << 2), i6 + ((this.f178a.f327i[2][i] & 255) << 2), (this.f178a.f327i[3][i] & 255) << 2, (this.f178a.f327i[4][i] & 255) << 2);
                        break;
                    default:
                        a(this.f185a[this.f104e], this.f178a.f324a[0][i4 + ((i4 == 8 && this.f176v) ? 1 : 0)], this.f178a.f327i[1][i] & 255, this.f178a.f327i[2][i] & 255, (i < 1397 || i > 1402) ? this.f178a.f327i[3][i] & 255 : this.y, this.f178a.f327i[4][i] & 255, i5, i6, 20);
                        break;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0300  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    final void m49a(int i, int i2) {
        int i3;
        this.f165P = (byte) -1;
        this.f168u = false;
        if (this.f178a.f322l > 0 && (this.ao - i < -15 || this.ao - i > 15 || this.ap - i2 < -10 || this.ap - i2 > 10)) {
            this.f178a.f322l = (byte) 0;
        }
        this.ao = i;
        this.ap = i2;
        this.aP = 0;
        this.aq = 0;
        this.aO = 0;
        this.aM = 0;
        this.aN = 0;
        this.aL = 0;
        this.f169S = (byte) -1;
        this.f229W = this.f90b;
        this.f230X = this.f91c;
        if (this.f178a.i == 1 && this.f105b == -1) {
            int i4 = this.f179a.c + 8;
            byte b = this.f179a.a;
            byte bA = (byte) p.a((i / 30) + this.f179a.c, 0, this.f179a.a - 1);
            this.f90b = bA;
            this.f165P = bA;
            byte bA2 = (byte) p.a((((i2 + (this.f179a.d + this.f179a.f430i == this.f179a.b ? (20 - ((this.f178a.f288a ? k.a : (k.a - 15) - 15) % 20)) % 20 : 0)) - (this.f178a.f288a ? 0 : 15)) / 20) + this.f179a.d, 0, this.f179a.b - 1);
            this.f91c = bA2;
            this.f166Q = bA2;
            if (this.f102d >= 0) {
                if (this.f90b < this.f229W || this.f90b >= this.f229W + this.f178a.f327i[18][this.f102d] || this.f91c < this.f230X || this.f91c >= this.f230X + this.f178a.f327i[19][this.f102d]) {
                    this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                    this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                } else {
                    this.f90b = this.f229W;
                    this.f91c = this.f230X;
                }
            }
        }
        if (i >= this.f170a[2][10] || i2 < this.f170a[1][10]) {
            if (i < this.f170a[0][11] || i2 < this.f170a[1][11]) {
                switch (this.f178a.i) {
                    case 0:
                        byte b2 = 0;
                        while (true) {
                            byte b3 = b2;
                            if (b3 < 12) {
                                if (((340 >> b3) & 1) == 0 || i < this.f170a[0][b3] || i >= this.f170a[0][b3] + this.f170a[2][b3] || i2 < this.f170a[1][b3] || i2 >= this.f170a[1][b3] + this.f170a[3][b3]) {
                                    b2 = (byte) (b3 + 1);
                                } else {
                                    c(b3);
                                }
                            }
                        }
                        if (this.f178a.f319k == 2) {
                            this.f114h = this.E;
                        }
                        if (this.f178a.f319k == 8) {
                            this.f114h = (this.E + this.F) - 1;
                        }
                        break;
                    case 1:
                        if (this.f105b != -1) {
                            byte b4 = 0;
                            while (true) {
                                byte b5 = b4;
                                if (b5 < 12) {
                                    if (((340 >> b5) & 1) != 0 && i >= this.f170a[0][b5] && i < this.f170a[0][b5] + this.f170a[2][b5] && i2 >= this.f170a[1][b5] && i2 < this.f170a[1][b5] + this.f170a[3][b5]) {
                                        c(b5);
                                    } else {
                                        b4 = (byte) (b5 + 1);
                                    }
                                }
                                break;
                            }
                        } else {
                            for (int i5 = 0; i5 < 4; i5++) {
                                if (i >= this.f170a[0][this.f181v[this.f182d[66] + i5]] && i < this.f170a[0][this.f181v[this.f182d[66] + i5]] + this.f170a[2][this.f181v[this.f182d[66] + i5]] && i2 >= this.f170a[1][this.f181v[this.f182d[66] + i5]] && i2 < this.f170a[1][this.f181v[this.f182d[66] + i5]] + this.f170a[3][this.f181v[this.f182d[66] + i5]]) {
                                    if (i5 < 3) {
                                        c(this.f181v[this.f182d[66] + i5]);
                                    }
                                    if (i5 >= 4) {
                                        i3 = 2;
                                        while (i3 <= 8 && (i < this.f170a[0][i3] || i >= this.f170a[0][i3] + this.f170a[2][i3] || i2 < this.f170a[1][i3] || i2 >= this.f170a[1][i3] + this.f170a[3][i3])) {
                                            i3 += 2;
                                        }
                                        if (i3 <= 8 && ((i3 != 8 || this.f190c[0][50] <= 0) && ((i3 != 2 || this.C <= 0) && (i3 != 4 || this.C <= 1 || !this.f228C)))) {
                                            i3 = 9;
                                        }
                                        if (i3 <= 8 && this.f102d >= 0) {
                                            if (i < this.ak) {
                                                c((byte) 4);
                                            } else if (i2 < this.al) {
                                                c((byte) 2);
                                            } else if (i > this.am) {
                                                c((byte) 6);
                                            } else if (i2 > this.an) {
                                                c((byte) 8);
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                            if (i5 >= 4) {
                                i3 = 2;
                                while (i3 <= 8) {
                                    i3 += 2;
                                }
                                if (i3 <= 8) {
                                    i3 = 9;
                                }
                                if (i3 <= 8) {
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x015f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0169  */
    /* JADX WARN: Code duplicated, block: B:49:0x0175  */
    /* JADX WARN: Code duplicated, block: B:50:0x017a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0195  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:76:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0201  */
    /* JADX WARN: Code duplicated, block: B:84:0x0218  */
    /* JADX WARN: Code duplicated, block: B:86:0x0229  */
    /* JADX WARN: Code duplicated, block: B:97:0x026f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0276  */
    final void b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.f168u || Math.abs(this.ao - i) >= 10 || Math.abs(this.ap - i2) >= 10) {
            if (this.f178a.f322l < 7) {
                this.f178a.f322l = (byte) 0;
            }
            this.f168u = true;
            this.f178a.f319k = (byte) -1;
            switch (this.f178a.i) {
                case 0:
                    c((byte) -1);
                    boolean z = (this.f181v[this.f182d[89] + (this.P >> 3)] & (1 << (this.P & 7))) != 0;
                    if (this.f169S == -1 && (Math.abs(this.ap - i2) >= 10 || Math.abs(this.ao - i) >= 10)) {
                        this.f169S = Math.abs(this.ap - i2) >= Math.abs(this.ao - i) ? (byte) 0 : (byte) 1;
                    }
                    if (this.f169S != -1) {
                        this.aP = this.f169S == 0 ? (this.ap - i2) / (!z ? f232Y : f231l) : (i - this.ao) / 30;
                    }
                    break;
                case 1:
                    if (this.f105b != -1) {
                        c((byte) -1);
                        if (this.f169S == -1 && (Math.abs(this.ap - i2) >= 10 || Math.abs(this.ao - i) >= 10)) {
                            this.f169S = Math.abs(this.ap - i2) >= Math.abs(this.ao - i) ? (byte) 0 : (byte) 1;
                        }
                        if (this.f169S != -1) {
                            this.aP = this.f169S == 0 ? (this.ap - i2) / (!this.f108n ? (byte) 10 : f231l) : (i - this.ao) / 30;
                        }
                    } else {
                        int iA = p.a(i2, this.f178a.f284b == 0 ? 15 : 0, k.a - 1);
                        int i9 = this.f179a.c + 8;
                        byte b = this.f179a.a;
                        this.f90b = (byte) p.a((i / 30) + this.f179a.c, 0, this.f179a.a - 1);
                        this.f91c = (byte) p.a((((iA + (this.f179a.d + this.f179a.f430i == this.f179a.b ? (20 - ((this.f178a.f288a ? k.a : (k.a - 15) - 15) % 20)) % 20 : 0)) - (this.f178a.f288a ? 0 : 15)) / 20) + this.f179a.d, 0, this.f179a.b - 1);
                        if (this.f179a.c > 0) {
                            if (i < this.ak + (this.f102d >= 0 ? 30 : 0) && (this.f102d >= 0 || this.f141f >= 0)) {
                                c((byte) 4);
                            } else if (this.f179a.d > 0) {
                                i7 = this.al;
                                if (this.f102d >= 0) {
                                    i8 = 40;
                                } else {
                                    i8 = 0;
                                }
                                if (iA >= i7 + i8 && (this.f102d >= 0 || this.f141f >= 0)) {
                                    c((byte) 2);
                                } else if (this.f179a.c + 8 < this.f179a.a) {
                                    i5 = this.am;
                                    if (this.f102d >= 0) {
                                        i6 = 30;
                                    } else {
                                        i6 = 0;
                                    }
                                    if (i <= i5 - i6 && (this.f102d >= 0 || this.f141f >= 0)) {
                                        c((byte) 6);
                                    } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                        i3 = this.an;
                                        if (this.f102d >= 0) {
                                            i4 = 40;
                                        } else {
                                            i4 = 0;
                                        }
                                        if (iA > i3 - i4 || (this.f102d < 0 && this.f141f < 0)) {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7 && this.f102d < 0) {
                                                this.aN = (((this.ao - i) / 15) + (this.ao - i > 0 ? 1 : -1)) / 2;
                                                this.aO = (((this.ap - iA) / 10) + (this.ap - iA > 0 ? 1 : -1)) / 2;
                                            } else if (this.f102d < 0 && this.f109i == 0 && !this.f111o && (Math.abs(this.ao - i) >= 10 || Math.abs(this.ap - iA) >= 10)) {
                                                this.f237F = true;
                                            }
                                        } else {
                                            c((byte) 8);
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                    i3 = this.an;
                                    if (this.f102d >= 0) {
                                        i4 = 40;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (iA > i3 - i4) {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else if (this.f179a.c + 8 < this.f179a.a) {
                                i5 = this.am;
                                if (this.f102d >= 0) {
                                    i6 = 30;
                                } else {
                                    i6 = 0;
                                }
                                if (i <= i5 - i6) {
                                    if (this.f179a.d + k.f276a < this.f179a.b) {
                                        i3 = this.an;
                                        if (this.f102d >= 0) {
                                            i4 = 40;
                                        } else {
                                            i4 = 0;
                                        }
                                        if (iA > i3 - i4) {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                    i3 = this.an;
                                    if (this.f102d >= 0) {
                                        i4 = 40;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (iA > i3 - i4) {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                i3 = this.an;
                                if (this.f102d >= 0) {
                                    i4 = 40;
                                } else {
                                    i4 = 0;
                                }
                                if (iA > i3 - i4) {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else {
                                c((byte) -1);
                                if (this.f178a.f322l >= 7) {
                                    if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            }
                        } else if (this.f179a.d > 0) {
                            i7 = this.al;
                            if (this.f102d >= 0) {
                                i8 = 40;
                            } else {
                                i8 = 0;
                            }
                            if (iA >= i7 + i8) {
                                if (this.f179a.c + 8 < this.f179a.a) {
                                    i5 = this.am;
                                    if (this.f102d >= 0) {
                                        i6 = 30;
                                    } else {
                                        i6 = 0;
                                    }
                                    if (i <= i5 - i6) {
                                        if (this.f179a.d + k.f276a < this.f179a.b) {
                                            i3 = this.an;
                                            if (this.f102d >= 0) {
                                                i4 = 40;
                                            } else {
                                                i4 = 0;
                                            }
                                            if (iA > i3 - i4) {
                                                c((byte) -1);
                                                if (this.f178a.f322l >= 7) {
                                                    if (this.f102d < 0) {
                                                        this.f237F = true;
                                                    }
                                                } else if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else {
                                                c((byte) -1);
                                                if (this.f178a.f322l >= 7) {
                                                    if (this.f102d < 0) {
                                                        this.f237F = true;
                                                    }
                                                } else if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            }
                                        } else {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        }
                                    } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                        i3 = this.an;
                                        if (this.f102d >= 0) {
                                            i4 = 40;
                                        } else {
                                            i4 = 0;
                                        }
                                        if (iA > i3 - i4) {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                    i3 = this.an;
                                    if (this.f102d >= 0) {
                                        i4 = 40;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (iA > i3 - i4) {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else if (this.f179a.c + 8 < this.f179a.a) {
                                i5 = this.am;
                                if (this.f102d >= 0) {
                                    i6 = 30;
                                } else {
                                    i6 = 0;
                                }
                                if (i <= i5 - i6) {
                                    if (this.f179a.d + k.f276a < this.f179a.b) {
                                        i3 = this.an;
                                        if (this.f102d >= 0) {
                                            i4 = 40;
                                        } else {
                                            i4 = 0;
                                        }
                                        if (iA > i3 - i4) {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else {
                                            c((byte) -1);
                                            if (this.f178a.f322l >= 7) {
                                                if (this.f102d < 0) {
                                                    this.f237F = true;
                                                }
                                            } else if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                    i3 = this.an;
                                    if (this.f102d >= 0) {
                                        i4 = 40;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (iA > i3 - i4) {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                i3 = this.an;
                                if (this.f102d >= 0) {
                                    i4 = 40;
                                } else {
                                    i4 = 0;
                                }
                                if (iA > i3 - i4) {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else {
                                c((byte) -1);
                                if (this.f178a.f322l >= 7) {
                                    if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            }
                        } else if (this.f179a.c + 8 < this.f179a.a) {
                            i5 = this.am;
                            if (this.f102d >= 0) {
                                i6 = 30;
                            } else {
                                i6 = 0;
                            }
                            if (i <= i5 - i6) {
                                if (this.f179a.d + k.f276a < this.f179a.b) {
                                    i3 = this.an;
                                    if (this.f102d >= 0) {
                                        i4 = 40;
                                    } else {
                                        i4 = 0;
                                    }
                                    if (iA > i3 - i4) {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else {
                                        c((byte) -1);
                                        if (this.f178a.f322l >= 7) {
                                            if (this.f102d < 0) {
                                                this.f237F = true;
                                            }
                                        } else if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else if (this.f179a.d + k.f276a < this.f179a.b) {
                                i3 = this.an;
                                if (this.f102d >= 0) {
                                    i4 = 40;
                                } else {
                                    i4 = 0;
                                }
                                if (iA > i3 - i4) {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else {
                                    c((byte) -1);
                                    if (this.f178a.f322l >= 7) {
                                        if (this.f102d < 0) {
                                            this.f237F = true;
                                        }
                                    } else if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                }
                            } else {
                                c((byte) -1);
                                if (this.f178a.f322l >= 7) {
                                    if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            }
                        } else if (this.f179a.d + k.f276a < this.f179a.b) {
                            i3 = this.an;
                            if (this.f102d >= 0) {
                                i4 = 40;
                            } else {
                                i4 = 0;
                            }
                            if (iA > i3 - i4) {
                                c((byte) -1);
                                if (this.f178a.f322l >= 7) {
                                    if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            } else {
                                c((byte) -1);
                                if (this.f178a.f322l >= 7) {
                                    if (this.f102d < 0) {
                                        this.f237F = true;
                                    }
                                } else if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            }
                        } else {
                            c((byte) -1);
                            if (this.f178a.f322l >= 7) {
                                if (this.f102d < 0) {
                                    this.f237F = true;
                                }
                            } else if (this.f102d < 0) {
                                this.f237F = true;
                            }
                        }
                        if (this.f102d >= 0) {
                            this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                            this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                            if (this.f179a.c + 8 < this.f179a.a && (this.f90b + this.f178a.f327i[18][this.f102d]) - 1 >= ((this.f179a.c + 8) - 1) - 1) {
                                c((byte) 6);
                            } else if (this.f179a.d + k.f276a < this.f179a.b && (this.f91c + this.f178a.f327i[19][this.f102d]) - 1 >= ((this.f179a.d + this.f179a.f430i) - 1) - 1) {
                                c((byte) 8);
                            }
                            this.f90b = (byte) Math.min((int) this.f90b, (this.f179a.c + 8) - this.f178a.f327i[18][this.f102d]);
                            this.f91c = (byte) Math.min((int) this.f91c, (this.f179a.d + this.f179a.f430i) - this.f178a.f327i[19][this.f102d]);
                        } else if (this.f141f >= 0) {
                            A();
                        }
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:106:0x0314  */
    /* JADX WARN: Code duplicated, block: B:108:0x0319  */
    /* JADX WARN: Code duplicated, block: B:113:0x0335  */
    /* JADX WARN: Code duplicated, block: B:116:0x033e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0345  */
    /* JADX WARN: Code duplicated, block: B:127:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:129:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:79:0x027c  */
    /* JADX WARN: Code duplicated, block: B:93:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:98:0x02ec  */
    final void c(int i, int i2) {
        int i3;
        this.f233D = false;
        if (!this.f168u) {
            if (i < this.f170a[0][10] + this.f170a[2][10] && i2 >= this.f170a[1][10]) {
                if (this.f178a.i != 1 || this.f105b >= 0) {
                    c((byte) 10);
                } else {
                    this.i = false;
                    if (this.f102d >= 0) {
                        c((byte) 5);
                    } else {
                        c((byte) 11);
                    }
                }
                this.f233D = true;
            } else if (i >= this.f170a[0][11] && i2 >= this.f170a[1][11]) {
                if (this.f178a.i == 1) {
                    this.i = true;
                }
                c((byte) 11);
                if (this.f178a.i != 1 || this.f105b >= 0 || this.f109i != 0 || this.f102d >= 0 || this.f141f >= 0 || this.f190c[0][50] > 0) {
                    this.f233D = true;
                } else {
                    this.f233D = false;
                }
            }
        }
        if (!this.f233D && this.f178a.i == 1 && this.f105b == -1) {
            i2 = p.a(i2, 0, k.a - 1);
            int i4 = this.f179a.c + 8;
            byte b = this.f179a.a;
            this.f90b = (byte) p.a((i / 30) + this.f179a.c, 0, this.f179a.a - 1);
            this.f91c = (byte) p.a(((i2 + (this.f179a.d + this.f179a.f430i == this.f179a.b ? (20 - ((this.f178a.f288a ? k.a : (k.a - 15) - 15) % 20)) % 20 : 0)) / 20) + this.f179a.d, 0, this.f179a.b - 1);
        }
        this.f234E = false;
        if (this.f168u) {
            if (this.f178a.i == 1 && this.f105b == -1) {
                if (this.f102d >= 0) {
                    this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                    this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                    return;
                } else {
                    if (this.f141f >= 0 || this.f237F) {
                        c((byte) 5);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.f233D) {
            return;
        }
        switch (this.f178a.i) {
            case 0:
                byte b2 = 0;
                while (true) {
                    byte b3 = b2;
                    if (b3 < 12) {
                        if (((340 >> b3) & 1) != 0 || i < this.f170a[0][b3] || i >= this.f170a[0][b3] + this.f170a[2][b3] || i2 < this.f170a[1][b3] || i2 >= this.f170a[1][b3] + this.f170a[3][b3]) {
                            b2 = (byte) (b3 + 1);
                        } else {
                            c(b3);
                        }
                    }
                }
                if (this.P == 8) {
                    switch (this.f235m) {
                        case 1:
                            this.f114h = this.E;
                            c((byte) 5);
                            this.f167R = (byte) 0;
                            break;
                        case 3:
                            this.f114h = this.E + 1;
                            c((byte) 5);
                            this.f167R = (byte) 0;
                            break;
                        case 7:
                            this.f114h = this.E + 2;
                            c((byte) 5);
                            this.f167R = (byte) 0;
                            break;
                    }
                } else if ((this.f181v[this.f182d[89] + (this.P >> 3)] & (1 << (this.P & 7))) != 0 || this.P == 12 || this.P == 9 || this.P == 62 || this.P == 16 || this.P == 18) {
                    if (this.f178a.f319k == -1 && this.P != 62 && i >= 45 && i2 >= (k.a - 150) / 2 && i < 195 && i2 < (k.a + 150) / 2) {
                        c((this.f181v[this.f182d[90] + (this.P >> 3)] & (1 << (this.P & 7))) != 0 ? (byte) 10 : (byte) 11);
                        break;
                    }
                } else if (i2 >= this.D - 4 && i2 < (this.D - 4) + (Math.min(this.F, this.B) * f136J) && i >= 70 && i < 170) {
                    this.f114h = this.E + (((i2 + 4) - this.D) / f136J);
                    c((byte) 5);
                    this.f167R = (byte) 0;
                    break;
                }
                break;
            case 1:
                if (this.f105b != -1) {
                    byte b4 = 0;
                    while (true) {
                        byte b5 = b4;
                        if (b5 < 12) {
                            if (((340 >> b5) & 1) == 0 && i >= this.f170a[0][b5] && i < this.f170a[0][b5] + this.f170a[2][b5] && i2 >= this.f170a[1][b5] && i2 < this.f170a[1][b5] + this.f170a[3][b5]) {
                                c(b5);
                            } else {
                                b4 = (byte) (b5 + 1);
                            }
                        }
                        break;
                    }
                } else {
                    for (int i5 = 0; i5 < 4; i5++) {
                        if (i >= this.f170a[0][this.f181v[this.f182d[66] + i5]] && i < this.f170a[0][this.f181v[this.f182d[66] + i5]] + this.f170a[2][this.f181v[this.f182d[66] + i5]] && i2 >= this.f170a[1][this.f181v[this.f182d[66] + i5]] && i2 < this.f170a[1][this.f181v[this.f182d[66] + i5]] + this.f170a[3][this.f181v[this.f182d[66] + i5]]) {
                            if (i5 >= 3) {
                                c((byte) 10);
                            }
                            if (i5 >= 4) {
                                i3 = 2;
                                while (i3 <= 8 && (i < this.f170a[0][i3] || i >= this.f170a[0][i3] + this.f170a[2][i3] || i2 < this.f170a[1][i3] || i2 >= this.f170a[1][i3] + this.f170a[3][i3])) {
                                    i3 += 2;
                                }
                                if (i3 <= 8) {
                                    if (i3 != 8 && this.f190c[0][50] > 0) {
                                        this.f238G = true;
                                    } else if (i3 == 2 || this.C <= 0) {
                                        if (i3 == 4 || this.C <= 1 || !this.f228C) {
                                            i3 = 9;
                                        } else {
                                            this.f111o = true;
                                            this.f228C = false;
                                        }
                                    } else if (this.f228C) {
                                        this.f239H = true;
                                        this.f228C = false;
                                    } else {
                                        this.f228C = true;
                                    }
                                }
                                if (i3 > 8) {
                                    if (this.f102d >= 0) {
                                        if (this.f90b >= this.f229W || this.f90b >= this.f229W + this.f178a.f327i[18][this.f102d] || this.f91c < this.f230X || this.f91c >= this.f230X + this.f178a.f327i[19][this.f102d]) {
                                            this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                                            this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                                        } else {
                                            this.f90b = this.f229W;
                                            this.f91c = this.f230X;
                                            c((byte) 5);
                                        }
                                        this.f220B = true;
                                        break;
                                    } else if (this.f178a.f319k != -1 && this.f235m == -1) {
                                        c((byte) 5);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (i5 >= 4) {
                        i3 = 2;
                        while (i3 <= 8) {
                            i3 += 2;
                        }
                        if (i3 <= 8) {
                            if (i3 != 8) {
                                if (i3 == 2) {
                                    if (i3 == 4) {
                                        i3 = 9;
                                    } else {
                                        i3 = 9;
                                    }
                                } else if (i3 == 4) {
                                    i3 = 9;
                                } else {
                                    i3 = 9;
                                }
                            } else if (i3 == 2) {
                                if (i3 == 4) {
                                    i3 = 9;
                                } else {
                                    i3 = 9;
                                }
                            } else if (i3 == 4) {
                                i3 = 9;
                            } else {
                                i3 = 9;
                            }
                        }
                        if (i3 > 8) {
                            if (this.f102d >= 0) {
                                if (this.f90b >= this.f229W) {
                                    this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                                    this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                                } else {
                                    this.f90b = (byte) Math.max(this.f90b - (this.f178a.f327i[18][this.f102d] / 2), 0);
                                    this.f91c = (byte) Math.max(this.f91c - (this.f178a.f327i[19][this.f102d] / 2), 0);
                                }
                                this.f220B = true;
                                break;
                            } else if (this.f178a.f319k != -1) {
                            }
                        }
                    }
                }
                break;
            case 2:
                byte b6 = 0;
                while (true) {
                    byte b7 = b6;
                    if (b7 < 12) {
                        if (i < this.f170a[0][b7] || i >= this.f170a[0][b7] + this.f170a[2][b7] || i2 < this.f170a[1][b7] || i2 >= this.f170a[1][b7] + this.f170a[3][b7]) {
                            b6 = (byte) (b7 + 1);
                        } else {
                            c(b7);
                        }
                    }
                }
                if (i >= this.Z && i <= this.Z + this.X && i2 >= this.aa && i2 <= this.aa + this.Y) {
                    this.ad = this.ab + ((i - this.Z) / this.af);
                    this.ae = this.ac + ((i2 - this.aa) / this.af);
                    c((byte) 5);
                    break;
                }
                break;
        }
    }

    private void c(byte b) {
        if (this.f235m != b) {
            this.f236h = false;
            this.f235m = b;
        }
    }

    final void h() {
        if (this.f237F) {
            this.f141f = this.f165P;
            this.f142K = this.f166Q;
            this.f237F = false;
        }
        if (this.f238G) {
            B();
            this.f238G = false;
        }
        if (this.f239H) {
            for (int i = 0; i < this.f190c[0][50]; i++) {
                if ((this.f189x[2929 + this.f190c[0][i]] & 96) == 0 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] >= 0 && ((this.f150M == 0 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] > this.f189x[2323 + this.f190c[0][i]]) || (this.f150M == 1 && this.f181v[this.f182d[52] + this.f189x[2323 + this.f190c[0][i]]] < this.f189x[2323 + this.f190c[0][i]]))) {
                    byte[] bArr = this.f189x;
                    int i2 = 2929 + this.f190c[0][i];
                    bArr[i2] = (byte) (bArr[i2] | 32);
                }
            }
            this.f239H = false;
        }
    }

    final void i() {
        if (this.f178a.i != 1 || this.f105b != -1) {
            if (this.f178a.i != 1 || this.f105b < 0) {
                if (this.f178a.i == 0) {
                    if (this.f169S == 0) {
                        int i = this.aP - this.aq;
                        if ((this.f181v[this.f182d[89] + (this.P >> 3)] & (1 << (this.P & 7))) == 0) {
                            int iA = p.a(this.E + i, 0, this.B - this.F);
                            this.E = iA;
                            this.f114h = iA;
                        } else {
                            this.f180a.d = p.a(this.f180a.d + i, 0, this.f180a.c - this.f180a.f391b);
                        }
                    } else if (this.P == 62) {
                        this.f114h = (((this.f114h + (this.B * 10)) + this.aP) - this.aq) % this.B;
                        this.f135r = true;
                    }
                    this.aq = this.aP;
                    return;
                }
                return;
            }
            if (this.f169S == 0) {
                int i2 = this.aP - this.aq;
                if (this.f108n || (i.f268a && this.f105b == 137)) {
                    this.f180a.d = p.a(this.f180a.d + i2, 0, this.f180a.c - this.f180a.f391b);
                } else if (this.f105b == 135) {
                    this.f116c[this.f114h] = (byte) p.a(this.f116c[this.f114h] + i2, 0, (int) this.f181v[this.f182d[130] + this.c]);
                }
            } else {
                int i3 = this.aP - this.aq;
                if (this.f105b == 137) {
                    if (this.f189x[6868 - this.f95a] < 0 && i3 != 0) {
                        for (int i4 = 0; i4 < Math.abs(i3); i4++) {
                            if (a(this.f114h, i3 / Math.abs(i3)) >= 0) {
                                this.f114h = a(this.f114h, i3 / Math.abs(i3));
                                this.f138b = true;
                            }
                        }
                    }
                } else if (this.f105b != 140 && this.f105b != 139) {
                    this.f114h = p.a(this.f114h + i3, 0, this.B - 1);
                }
            }
            this.aq = this.aP;
            return;
        }
        while (true) {
            if (this.aN == this.aL && this.aO == this.aM) {
                return;
            }
            int i5 = this.aN - this.aL;
            int i6 = this.aO - this.aM;
            if (i5 < 0 && this.f179a.c > 0) {
                p pVar = this.f179a;
                pVar.c = (byte) (pVar.c - 1);
                for (int i7 = 10; i7 > 0; i7--) {
                    for (int i8 = 0; i8 < k.f276a + 2; i8++) {
                        this.f193f[i8][i7] = this.f193f[i8][i7 - 1];
                    }
                }
                for (int i9 = 0; i9 < k.f276a + 2; i9++) {
                    this.f193f[i9][0] = -1;
                }
                for (int i10 = 0; i10 < 50; i10++) {
                    if (this.f192e[1][i10] != -1) {
                        byte[] bArr = this.f192e[2];
                        int i11 = i10;
                        bArr[i11] = (byte) (bArr[i11] + 1);
                        if (this.f192e[2][i10] >= 11) {
                            this.f192e[6][i10] = -1;
                            this.f192e[1][i10] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f280b = -15;
                }
                this.f89a = this.f89a == -1 ? (byte) 0 : (byte) 4;
            }
            if (i5 > 0 && this.f179a.c + 8 < this.f179a.a) {
                p pVar2 = this.f179a;
                pVar2.c = (byte) (pVar2.c + 1);
                for (int i12 = 0; i12 < 10; i12++) {
                    for (int i13 = 0; i13 < k.f276a + 2; i13++) {
                        this.f193f[i13][i12] = this.f193f[i13][i12 + 1];
                    }
                }
                for (int i14 = 0; i14 < k.f276a + 2; i14++) {
                    this.f193f[i14][10] = -1;
                }
                for (int i15 = 0; i15 < 50; i15++) {
                    if (this.f192e[1][i15] != -1) {
                        byte[] bArr2 = this.f192e[2];
                        int i16 = i15;
                        bArr2[i16] = (byte) (bArr2[i16] - 1);
                        if (this.f192e[2][i15] < 0) {
                            this.f192e[6][i15] = -1;
                            this.f192e[1][i15] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f280b = 15;
                }
                this.f89a = this.f89a == -1 ? (byte) 1 : (byte) 4;
            }
            if (i6 < 0 && this.f179a.d > 0) {
                p pVar3 = this.f179a;
                pVar3.d = (byte) (pVar3.d - 1);
                for (int i17 = 0; i17 < 11; i17++) {
                    for (int i18 = (k.f276a + 2) - 1; i18 > 0; i18--) {
                        this.f193f[i18][i17] = this.f193f[i18 - 1][i17];
                    }
                }
                for (int i19 = 0; i19 < 11; i19++) {
                    this.f193f[0][i19] = -1;
                }
                for (int i20 = 0; i20 < 50; i20++) {
                    if (this.f192e[1][i20] != -1) {
                        byte[] bArr3 = this.f192e[3];
                        int i21 = i20;
                        bArr3[i21] = (byte) (bArr3[i21] + 1);
                        if (this.f192e[3][i20] >= k.f276a + 2) {
                            this.f192e[6][i20] = -1;
                            this.f192e[1][i20] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f281c = -10;
                }
                this.f89a = this.f89a == -1 ? (byte) 2 : (byte) 4;
            }
            if (i6 > 0 && this.f179a.d + this.f179a.f430i < this.f179a.b) {
                p pVar4 = this.f179a;
                pVar4.d = (byte) (pVar4.d + 1);
                for (int i22 = 0; i22 < 11; i22++) {
                    for (int i23 = 0; i23 < (k.f276a + 2) - 1; i23++) {
                        this.f193f[i23][i22] = this.f193f[i23 + 1][i22];
                    }
                }
                for (int i24 = 0; i24 < 11; i24++) {
                    this.f193f[(k.f276a + 2) - 1][i24] = -1;
                }
                for (int i25 = 0; i25 < 50; i25++) {
                    if (this.f192e[1][i25] != -1) {
                        byte[] bArr4 = this.f192e[3];
                        int i26 = i25;
                        bArr4[i26] = (byte) (bArr4[i26] - 1);
                        if (this.f192e[3][i25] < 0) {
                            this.f192e[6][i25] = -1;
                            this.f192e[1][i25] = -1;
                        }
                    }
                }
                if (this.f178a.f288a) {
                    this.f178a.f281c = 10;
                }
                this.f89a = this.f89a == -1 ? (byte) 3 : (byte) 4;
            }
            if (this.aN != this.aL) {
                this.aL += this.aN > this.aL ? 1 : -1;
            }
            if (this.aO != this.aM) {
                this.aM += this.aO > this.aM ? 1 : -1;
            }
        }
    }

    private void a(String str, String str2, int i, boolean z, boolean z2, int i2, boolean z3, boolean z4) {
        if (this.f178a.i == 0 && this.P == f119y) {
            K();
        }
        if (i2 == 14) {
            try {
                if (a.f14c == null || a.f14c[2] == null || !h.a(a.f14c[2], new StringBuffer().append(a.f14c[3]).append(a.m9a()).toString())) {
                    str2 = a.a(k.f365j[2], true);
                } else {
                    a.c = null;
                    str2 = a.a(k.f365j[1], true);
                }
                str = a.a(k.f365j[0], true);
                z = false;
                z2 = true;
            } catch (Exception unused) {
            }
            i2 = 2;
        }
        this.f211h = str2;
        this.f212i = str;
        this.ax = i;
        this.f213x = z;
        this.f214y = z2;
        this.ay = !p.f526a ? i2 : 2;
        this.f215z = z4;
        this.f216U = this.f178a.i;
        this.f138b = true;
        this.f89a = (byte) 4;
        if (this.ay == 1 && c.f28a) {
            this.f178a.e();
            Thread.yield();
        }
        this.f178a.i = (byte) 0;
        a((int) f119y, true);
        if (z3) {
            f();
            this.f178a.h();
        }
    }

    private void K() {
        if (this.f178a.i == 0 && this.P == f119y) {
            if (this.ay == 1 && c.f28a) {
                this.f178a.f();
            }
            this.f211h = null;
            this.f212i = null;
            this.f213x = false;
            this.f214y = false;
            this.ay = -1;
            this.f89a = (byte) 4;
            this.f178a.i = this.f216U;
            if (this.ax >= 0) {
                a(this.ax, f218A);
            }
            f218A = false;
        }
    }

    private void b(boolean z) {
        String str;
        int iM50a;
        this.f178a.f319k = (byte) -1;
        if (!z || this.f213x) {
            if (z || this.f214y) {
                switch (!p.f526a ? this.ay : 2) {
                    case 0:
                    case 1:
                        K();
                        return;
                    case 2:
                        if (z) {
                            try {
                                if (a(a.f14c[2], new StringBuffer().append(a.f14c[3]).append(a.m9a()).toString())) {
                                    a((String) null, o.f384a[3][6], -1, false, false, 0, true, true);
                                } else {
                                    a((String) null, o.f384a[3][7], -1, false, false, 0, true, true);
                                }
                                break;
                            } catch (Exception unused) {
                            }
                            a.a(2999L);
                        }
                        a.e();
                        this.f178a.a((String) null);
                        return;
                    case 3:
                        if (a.f3b) {
                            if (!z) {
                                f240l = null;
                                K();
                                return;
                            }
                            if (aQ == 2 && (f240l == null || f240l.length() <= 0)) {
                                String strM59a = this.f178a.m59a();
                                f240l = strM59a;
                                if (strM59a == null) {
                                    K();
                                    return;
                                }
                            }
                            K();
                            if (!a(f240l, f241m)) {
                                a((String) null, new StringBuffer().append(o.f384a[3][7]).append("&").append(o.f384a[3][8]).toString(), (int) f124D, true, true, 3, false, true);
                                return;
                            }
                            a((String) null, o.f384a[3][6], (int) (aQ == 1 ? f128H : f124D), false, true, aQ == 3 ? 8 : 0, false, true);
                            L();
                            f240l = null;
                            return;
                        }
                        return;
                    case 4:
                        K();
                        if (z) {
                            try {
                                d(((Integer) this.f217a).intValue());
                                break;
                            } catch (Exception unused2) {
                            }
                        }
                        this.f217a = null;
                        return;
                    case 5:
                    default:
                        return;
                    case 6:
                        boolean z2 = false;
                        if (z && (iM50a = m50a((str = (String) this.f217a))) >= 0) {
                            int size = this.f201a.size();
                            try {
                                for (int i = 0; i < size; i++) {
                                    if (str.equals(((String[]) this.f201a.elementAt(i))[1])) {
                                        this.f201a.removeElementAt(i);
                                        H();
                                        z2 = true;
                                        RecordStore.deleteRecordStore(new StringBuffer().append("aow2m").append(iM50a + 6).toString());
                                    }
                                    break;
                                }
                                RecordStore.deleteRecordStore(new StringBuffer().append("aow2m").append(iM50a + 6).toString());
                                break;
                            } catch (Exception unused3) {
                            }
                            H();
                            z2 = true;
                        }
                        K();
                        if (z2) {
                            int i2 = this.f114h - 1;
                            this.f114h = i2;
                            if (i2 < 0) {
                                this.f114h = 0;
                            }
                        }
                        this.f217a = null;
                        return;
                    case 7:
                        if (a.f2a) {
                            if (!z || a.d == null || a.c != null) {
                                K();
                                return;
                            }
                            this.f178a.g();
                            this.f178a.i = (byte) -2;
                            this.f178a.a(a.d);
                            return;
                        }
                        return;
                    case 8:
                        if (f.a() && !f.f62e) {
                            K();
                            a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
                            a.a(3000L);
                            try {
                                f.m25a().m28a(true);
                                break;
                            } catch (f unused4) {
                            }
                        }
                        K();
                        return;
                    case 9:
                        K();
                        if (z && f.a()) {
                            c(1);
                            return;
                        }
                        return;
                    case 10:
                        break;
                    case 11:
                        if (z) {
                            K();
                            b(f.m25a(), false);
                        }
                        break;
                    case 12:
                        K();
                        if (z) {
                            M();
                            return;
                        }
                        return;
                    case 13:
                        K();
                        if (f.a()) {
                            a(f.m25a(), z);
                            return;
                        }
                        return;
                }
                if (z) {
                    return;
                }
                K();
                if (this.P == f121A && O == f122B) {
                    a((int) f124D, false);
                }
            }
        }
    }

    private void a(String str, String str2, String str3, int i) {
        if (!a.f3b || str == null || str2 == null || str3 == null) {
            return;
        }
        f240l = str2;
        f241m = str3;
        f242n = str;
        aQ = i;
        a((String) null, f242n, (int) f124D, true, true, 3, false, true);
        this.f178a.f319k = (byte) -1;
    }

    private boolean a(String str, String str2) {
        if (c.f28a) {
            this.f178a.e();
        }
        a((String) null, o.f384a[3][5], (int) f124D, false, false, -1, true, true);
        a.a(500L);
        boolean zA = h.a(str, str2);
        this.f178a.h();
        a.a(500L);
        K();
        if (c.f28a) {
            this.f178a.f();
        }
        return zA;
    }

    private void L() {
        if (a.f3b) {
            switch (aQ) {
                case 1:
                    this.f200a[this.b] = true;
                    while (this.f181v[this.f182d[132] + this.c] < this.b && this.c < 2) {
                        this.c++;
                        this.f208w = true;
                    }
                    H();
                    break;
                case 3:
                    if (f.f62e) {
                        f.m25a().m30a(a.f6a);
                    }
                    break;
            }
        }
    }

    private void a(f fVar, boolean z) {
        if (z) {
            try {
                a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
                a.a(500L);
                fVar.a(f226y);
                byte[] bArr = f226y;
                f226y[1] = 0;
                bArr[0] = 0;
                H();
                K();
            } catch (f e) {
                a(o.f384a[3][18], e.getMessage(), (int) f124D, false, true, 10, false, true);
                return;
            }
        }
        byte[] bArrM32a = fVar.m32a(false);
        int i = 0;
        for (byte b : bArrM32a) {
            if (b == 1) {
                i++;
            }
        }
        a(new StringBuffer().append(o.f384a[3][35]).append(": ").append(i).append("/").append(f.f63a).toString(), new StringBuffer().append(new StringBuffer().append("\"").append(o.f384a[3][37]).append("\"").append(bArrM32a[0] == 1 ? f204d : "").toString()).append(f207g).append(f207g).append(new StringBuffer().append("\"").append(o.f384a[3][38]).append("\"").append(bArrM32a[1] == 1 ? f204d : "").toString()).toString(), (int) f124D, false, true, 10, false, true);
    }

    private void c(int i) {
        this.aR = i;
        if (f.b()) {
            b(f.m25a(), false);
        } else {
            a((int) f122B, true);
        }
    }

    private void b(f fVar, boolean z) {
        Throwable th = null;
        String message = null;
        try {
            switch (this.aR) {
                case 0:
                    a((int) f129I, true);
                    break;
                case 1:
                    a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
                    a.a(500L);
                    String string = "";
                    int i = 0;
                    while (i < f226y.length) {
                        if (f226y[i] != 0) {
                            if (fVar.m31a(i)) {
                                string = new StringBuffer().append(string).append(f207g).append("\"").append(o.f384a[3][i == 0 ? '%' : '&']).append("\"").toString();
                            }
                            f226y[i] = 0;
                            H();
                        }
                        i++;
                    }
                    a((String) null, string.length() <= 0 ? o.f384a[3][43] : new StringBuffer().append(o.f384a[3][36]).append(string).toString(), (int) f124D, false, true, 10, false, true);
                    break;
                case 2:
                    if (!z) {
                        a((String) null, o.f384a[3][42], (int) f124D, true, true, 13, true, true);
                        break;
                    } else {
                        a(fVar, false);
                        break;
                    }
                default:
                    break;
            }
        } catch (f e) {
            message = th.getMessage();
        } catch (Exception unused) {
            message = "1012";
        }
        if (message != null) {
            a(o.f384a[3][18], new StringBuffer().append(message).append(f207g).append(o.f384a[3][8]).toString(), (int) f124D, true, true, 11, false, true);
        }
    }

    private void M() {
        a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
        try {
            if (f.c()) {
                a((String) null, o.f384a[3][50], (int) f124D, false, true, 0, false, true);
            } else {
                K();
            }
        } catch (f e) {
            a(o.f384a[3][18], e.getMessage(), (int) f124D, false, true, 0, false, true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x022c A[Catch: f -> 0x0244, TRY_LEAVE, TryCatch #0 {f -> 0x0244, blocks: (B:75:0x01f2, B:77:0x020f, B:79:0x0214, B:81:0x0220, B:82:0x022c), top: B:183:0x01f2 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v167 */
    /* JADX WARN: Type inference failed for: r0v180, types: [g] */
    private void c(boolean z) {
        String strM33b;
        this.f178a.f319k = (byte) -1;
        if (!z || f133p) {
            if (z || f134q) {
                boolean z2 = false;
                boolean z3 = false;
                if (O == f122B) {
                    int i = this.f114h;
                    if (f130a != null) {
                        if (f130a[this.f114h] == o.f384a[3][14]) {
                            i = 0;
                        } else if (f130a[this.f114h] == o.f384a[3][15]) {
                            i = 1;
                        } else if (f130a[this.f114h] == o.f384a[3][46]) {
                            i = 2;
                        } else if (f130a[this.f114h] == o.f384a[0][2]) {
                            i = 3;
                        }
                    }
                    switch (i) {
                        case 0:
                        case 1:
                            if (z) {
                                boolean z4 = this.f114h == 1;
                                a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
                                f fVar = 0;
                                f fVarA = null;
                                try {
                                    fVarA = f.a(z4);
                                    fVar = this;
                                    fVar.K();
                                } catch (f e) {
                                    boolean z5 = fVar.m34a() == 3 && !f.f61d;
                                    a(o.f384a[3][18], new StringBuffer().append(e.getMessage()).append(z5 ? new StringBuffer().append(f207g).append(o.f384a[3][47]).toString() : "").toString(), (int) f124D, z5, true, z5 ? 12 : 0, false, true);
                                }
                                if (fVarA != null) {
                                    b(fVarA, true);
                                }
                                z2 = true;
                            }
                            break;
                        case 2:
                            if (z) {
                                M();
                                z2 = true;
                            }
                            break;
                        case 3:
                            if (z) {
                                a(o.f384a[0][2], o.f384a[3][13], (int) f124D, false, true, 0, false, true);
                                z2 = true;
                            }
                            break;
                    }
                } else if (O == f129I) {
                    if (z) {
                        switch (this.f114h) {
                            case 0:
                                a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
                                a.e();
                                a.a(500L);
                                try {
                                    String[] strArrA = f.m25a().a("id;name;price;is_purchased", "id", 0, 1000);
                                    a.e();
                                    K();
                                    if (strArrA == null || strArrA.length <= 0) {
                                        a((String) null, o.f384a[1][40], (int) f124D, false, true, 0, false, true);
                                    } else {
                                        String[][] strArrA2 = a(strArrA);
                                        this.f203b = strArrA2;
                                        if (strArrA2 != null) {
                                            a((int) f123C, true);
                                        } else {
                                            a((String) null, o.f384a[1][40], (int) f124D, false, true, 0, false, true);
                                        }
                                    }
                                } catch (f e2) {
                                    a(o.f384a[3][18], e2.getMessage(), (int) f124D, false, true, 0, false, true);
                                }
                                break;
                            case 1:
                                if (a.f5b != null) {
                                    try {
                                        a(a.a(o.f384a[3][34], "[SMS_COST]", a.f5b[3]), a.f5b[1], new StringBuffer().append(a.f5b[2]).append(f.m25a().m29a()).toString(), 3);
                                    } catch (f unused) {
                                    }
                                }
                                break;
                            case 2:
                                if (!f.f62e && (strM33b = f.m25a().m33b()) != null) {
                                    a((String) null, o.f384a[3][9], (int) f124D, false, true, 1, true, true);
                                    a.e();
                                    if (a.m2a(strM33b)) {
                                        this.f178a.a((String) null);
                                    }
                                }
                                break;
                        }
                    } else {
                        a((int) f127G, false);
                    }
                    z3 = true;
                    z2 = true;
                } else if (O == f125E) {
                    if (z) {
                        this.b = -1;
                        if (f130a[this.f114h].indexOf(f206f) == -1) {
                            int i2 = -1;
                            for (int i3 = 0; i3 < this.f200a.length && this.b == -1; i3++) {
                                if (this.f200a[i3]) {
                                    i2++;
                                }
                                if (i2 == this.f114h) {
                                    this.b = i3;
                                }
                            }
                        } else {
                            this.f202c = a.a(f130a[this.f114h], f206f, "");
                            this.b = m50a(this.f202c) + 6;
                        }
                        if (this.b >= 0) {
                            a(10, true);
                        }
                        z2 = true;
                    }
                } else if (O == f126F) {
                    if (z) {
                        this.f217a = f130a[this.f114h];
                        a((String) null, o.f384a[1][48], (int) f124D, true, true, 6, false, true);
                        z2 = true;
                    }
                } else if (O == f123C) {
                    if (z) {
                        if (f130a[this.f114h].indexOf(f204d) >= 0) {
                            a(o.f384a[0][13], o.f384a[3][19], (int) f124D, false, true, 0, false, true);
                        } else if (f130a[this.f114h].indexOf(f205e) >= 0) {
                            try {
                                d(this.f114h);
                            } catch (Exception unused2) {
                            }
                        } else {
                            try {
                                int iM28a = f.m25a().m28a(false);
                                int i4 = 0;
                                try {
                                    i4 = Integer.parseInt(this.f203b[2][this.f114h]);
                                } catch (Exception unused3) {
                                }
                                if (iM28a >= i4) {
                                    String strA = a.a(a.a(o.f384a[3][22], "[S]", this.f203b[2][this.f114h]), "[B]", new StringBuffer().append("").append(iM28a).toString());
                                    this.f217a = new Integer(this.f114h);
                                    a(o.f384a[0][13], strA, (int) f124D, true, true, 4, false, true);
                                } else {
                                    String string = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(o.f384a[3][26]).append("&").toString()).append(o.f384a[3][31]).append(": ").append(i4).append("&").toString()).append(o.f384a[3][30]).append(": ").append(iM28a).append("&").toString();
                                    if (a.f5b != null) {
                                        try {
                                            a(new StringBuffer().append(string).append("&").append(a.a(o.f384a[3][34], "[SMS_COST]", a.f5b[3])).toString(), a.f5b[1], new StringBuffer().append(a.f5b[2]).append(f.m25a().m29a()).toString(), 3);
                                        } catch (f unused4) {
                                        }
                                    } else {
                                        a(o.f384a[0][13], string, (int) f124D, false, true, 0, false, true);
                                    }
                                }
                            } catch (f e3) {
                                a(o.f384a[3][18], e3.getMessage(), (int) f124D, false, true, 0, false, true);
                            }
                        }
                        z2 = true;
                    }
                } else if (O == f128H && z) {
                    if (f130a[this.f114h].indexOf(f204d) >= 0) {
                        a(o.f384a[3][20], o.f384a[3][19], (int) f124D, false, true, 0, false, true);
                    } else {
                        this.b = this.f114h;
                        if (a.f4a != null) {
                            a(a.a(o.f384a[3][10], "[SMS_COST]", a.f4a[3]), a.f4a[1], a.f4a[2], 1);
                        }
                    }
                    z2 = true;
                }
                if (z && !z2 && f131a != null && f131a[this.f114h] >= 0) {
                    a(f131a[this.f114h], true);
                } else if (!z && !z3) {
                    a((int) f124D, false);
                }
                this.f178a.f319k = (byte) -1;
            }
        }
    }

    private static String[][] a(String[] strArr) {
        int length = strArr.length;
        String[][] strArr2 = new String[4][length];
        for (int i = 0; i < length; i++) {
            try {
                String[] strArrA = a.a(strArr[i], '\t');
                strArr2[0][i] = strArrA[0];
                strArr2[1][i] = strArrA[1];
                strArr2[2][i] = strArrA[2];
                strArr2[3][i] = strArrA[3];
            } catch (Exception unused) {
                return null;
            }
        }
        return strArr2;
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        int size = this.f201a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(((String[]) this.f201a.elementAt(i))[0])) {
                return true;
            }
        }
        return false;
    }

    private void d(int i) {
        int i2 = Integer.parseInt(this.f203b[0][i]);
        a((String) null, o.f384a[1][44], (int) f124D, false, false, 1, true, true);
        a.a(500L);
        try {
            byte[] bArrA = f.m25a().a(i2);
            a.e();
            K();
            this.f203b[3][i] = "1";
            if (bArrA == null || bArrA.length <= 0) {
                return;
            }
            String strA = a(bArrA, i2 + 6);
            if (strA != null) {
                a(o.f384a[3][18], strA, (int) f124D, false, true, 0, false, true);
                return;
            }
            this.f201a.addElement(new String[]{this.f203b[0][i], this.f203b[1][i]});
            if (this.c <= 0) {
                this.c = 1;
                this.f208w = true;
            }
            H();
            a((String) null, o.f384a[1][46], (int) f124D, false, true, 0, false, true);
        } catch (f e) {
            a(o.f384a[3][18], e.getMessage(), (int) f124D, false, true, 0, false, true);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private int m50a(String str) {
        int size = this.f201a.size();
        for (int i = 0; i < size; i++) {
            String[] strArr = (String[]) this.f201a.elementAt(i);
            if (str.equals(strArr[1])) {
                return Integer.parseInt(strArr[0]);
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    static int m51a() {
        return Math.abs(f258a.nextInt() % 98111) + 199876;
    }

    static int a(MIDlet mIDlet, Hashtable hashtable, String str, int i) {
        int iM51a = m51a();
        try {
            String str2 = new String(f243h);
            String appProperty = mIDlet.getAppProperty(str2);
            String str3 = new String(f.a((String) a.f9a.get(str), i, false));
            if (appProperty.equals(str3)) {
                hashtable.put(str2, new StringBuffer().append("").append(iM51a).toString());
                if (mIDlet.getAppProperty(new String(f248B)).equals("1.1")) {
                    hashtable.put(str2, "1.1");
                } else {
                    hashtable.put(str2, "1.0");
                }
                if (mIDlet.getAppProperty(new String(f251n)).equals("1.0")) {
                    hashtable.put(str2, "1.0");
                } else {
                    hashtable.put(str2, "2.0");
                }
            } else if (mIDlet.getAppProperty(new String(f245A)).equals(str3)) {
                hashtable.put(str2, new StringBuffer().append("").append(-iM51a).toString());
            }
        } catch (Exception unused) {
            if (0 == 0) {
                int i2 = -iM51a;
                hashtable.put(new String(f243h), new StringBuffer().append("").append(i2).toString());
                return i2;
            }
        }
        return iM51a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final boolean m52a() {
        int iM51a = m51a();
        int i = iM51a + f263c[0];
        return i < 0 || i - f263c[1] != iM51a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final String m53a() {
        StringBuffer stringBufferAppend = new StringBuffer().append("");
        int[] iArr = f263c;
        int i = iArr[1];
        iArr[1] = i + 1;
        return stringBufferAppend.append(i).toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final String m54a(String str) {
        String str2 = "";
        int i = 0;
        while (true) {
            if (i >= (str == null ? 2 : 1)) {
                break;
            }
            if (m52a()) {
                str2 = ".";
                if (!".".equals(str)) {
                    break;
                }
            }
            i++;
        }
        return str2;
    }

    public static final String b(String str) {
        String str2 = "";
        try {
            int iM51a = m51a();
            for (int i = 0; i < p.f525a.length; i++) {
                if (a.a(p.f525a[i], Math.abs(iM51a)) > 0) {
                    str2 = ".";
                    if (!".".equals(str)) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    static {
        f117w = (byte) 100;
        f117w = (byte) (100 + 1);
        byte b = f117w;
        f117w = (byte) (b + 1);
        f119y = b;
        byte b2 = f117w;
        f117w = (byte) (b2 + 1);
        f120z = b2;
        byte b3 = f117w;
        f117w = (byte) (b3 + 1);
        f121A = b3;
        byte b4 = f117w;
        f117w = (byte) (b4 + 1);
        f122B = b4;
        byte b5 = f117w;
        f117w = (byte) (b5 + 1);
        f123C = b5;
        byte b6 = (byte) (f117w + 1);
        f117w = b6;
        f117w = (byte) (b6 + 1);
        f124D = b6;
        byte b7 = f117w;
        f117w = (byte) (b7 + 1);
        f125E = b7;
        byte b8 = f117w;
        f117w = (byte) (b8 + 1);
        f126F = b8;
        byte b9 = f117w;
        f117w = (byte) (b9 + 1);
        f127G = b9;
        byte b10 = f117w;
        f117w = (byte) (b10 + 1);
        f128H = b10;
        byte b11 = f117w;
        f117w = (byte) (b11 + 1);
        f129I = b11;
        f130a = null;
        f131a = null;
        f132a = null;
        O = 0;
        f133p = false;
        f134q = false;
        f136J = (byte) 34;
        f204d = "{";
        f205e = "}";
        f206f = "®";
        f207g = "&";
        f209a = 0L;
        f210c = 0L;
        f218A = false;
        f226y = new byte[]{0, 0};
        f227z = new byte[15];
        f231l = o.f394a;
        f232Y = f136J;
        f240l = null;
        f241m = null;
        f242n = null;
        aQ = 0;
        byte[] bArr = {77, 73, 68, 108, 101, 116, 45, 72, 101, 97, 112, 45, 83, 105, 122, 101};
        f243h = new byte[]{77, 73, 68, 108, 101, 116, 45, 86, 101, 110, 100, 111, 114};
        f244i = new byte[]{77, 105, 99, 114, 111, 69, 100, 105, 116, 105, 111, 110, 46, 86, 101, 114, 115, 105, 111, 110};
        f245A = new byte[]{77, 105, 99, 114, 111, 69, 100, 105, 116, 105, 111, 110, 46, 83, 68, 75};
        f246j = new byte[]{109, 105, 99, 114, 111, 101, 100, 105, 116, 105, 111, 110, 46, 112, 108, 97, 116, 102, 111, 114, 109};
        f247k = new byte[]{77, 73, 68, 108, 101, 116, 45, 86, 101, 114, 115, 105, 111, 110};
        f248B = new byte[]{77, 73, 68, 108, 101, 116, 45, 67, 76, 68, 67};
        f249l = new byte[]{77, 73, 68, 108, 101, 116, 45, 74, 97, 114, 45, 83, 105, 122, 101};
        f250m = new byte[]{77, 73, 68, 108, 101, 116, 45, 74, 97, 114, 45, 85, 82, 76};
        f251n = new byte[]{77, 73, 68, 108, 101, 116, 45, 77, 73, 68, 80};
        f252o = new byte[]{15, 18, 81, 9, 14, 21, 34, 30, 97, 17};
        f253p = new byte[]{47, 77, 69, 84, 65, 45, 73, 78, 70, 47, 77, 65, 78, 73, 70, 69, 83, 84, 46, 77, 70};
        f254q = new byte[]{102, 105, 108, 101, 58, 47, 47};
        f255r = new byte[]{104, 116, 116, 112, 58, 47, 47};
        f256s = new byte[]{104, 116, 116, 112, 115, 58, 47, 47};
        f257t = new byte[]{65, 67, 68, 70, 78};
        f258a = new Random(System.currentTimeMillis());
        f259o = "XYZ";
        f260b = new int[]{5490, 3434, 110, 4903};
        f262a = null;
        aU = m51a();
        f263c = new int[]{aU, aU};
    }
}
