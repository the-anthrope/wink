package defpackage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:k.class */
public final class k extends q implements Runnable, CommandListener {
    private boolean j;
    private long b;
    private long c;
    private long d;
    private long e;
    static short a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static byte f276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    short[][] f277a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    static short f278b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static int f279a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    int f280b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    int f281c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Image[] f282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Graphics[] f283a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    byte f284b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public byte f285c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public byte f286d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile c f287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    boolean f288a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    boolean f289b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    boolean f290c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    boolean f291d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    boolean f292e;
    boolean f;
    boolean g;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    byte f293e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    byte[] f294a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    byte[] f295b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    short[] f296a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    short[] f297b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    short[] f298c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    byte[][] f299a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    short[][] f300b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int[][][] f301a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    byte[][] f302b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    byte[][] f303c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    byte[] f304c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    byte[][] f305d;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    byte f306f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    byte f307g;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    byte[] f308d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    byte[][] f309e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    byte[][] f310f;
    byte h;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    short[][] f311c;
    byte i;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    byte[][] f312g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    byte[][] f313h;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    byte[] f314e;
    private int n;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    byte f315j;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    int f316d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    int f317e;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static short f318c;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    byte f319k;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    boolean f320h;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    int f321f;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    byte f322l;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    boolean f323i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Image[][] f324a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    short[][] f325d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    short[][] f326e;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    byte[][] f327i;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    short[][] f328f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private aow2 f329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int[] f330a;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private byte[] f331f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private byte[] f332g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    private byte[] f333h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    private byte[] f334i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private InputStream f335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private DataInputStream f336a;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    private byte[] f337j;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    p f338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private o f339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    g f340a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Image f343b;
    private int p;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int[][] f344a;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    protected int f345g;
    private int q;
    private int r;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private int[][] f346b;
    private int s;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f347b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f348a;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private byte f349m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private TextBox f352a;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Command f353c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private Command f354d;
    private volatile int v;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private String f355c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String[] f356a;
    private int w;
    private int x;
    private int y;
    private int z;
    private int A;
    private int B;
    private int C;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    private static int f275j = 0;
    private static int k = 0;
    private static int l = 0;
    private static int m = 0;
    private static volatile int o = 0;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    private static volatile boolean f341k = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile Image f342a = null;
    private static volatile int t = 0;
    private static volatile int u = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Command f350a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static Command f351b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f357a = null;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    private static boolean f358l = false;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private static boolean f359m = false;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static int f360h = 0;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static int f361i = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long[] f362a = {95, 34, -55, 39, 66, 454, 95, -54, 565, 454, 0, -546767};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static Object f363b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Object f364a = {49, 56, 55};

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final byte[][] f365j = {new byte[]{0, 0}, new byte[]{0, -69, 84, 72, 65, 78, 75, 32, 89, 79, 85, 32, 70, 79, 82, 32, 80, 85, 82, 67, 72, 65, 83, 73, 78, 71, 32, 84, 72, 73, 83, 32, 71, 65, 77, 69, 44, 32, 89, 79, 85, 32, 87, 73, 76, 76, 32, 70, 73, 78, 68, 32, 65, 32, 68, 79, 87, 78, 76, 79, 65, 68, 32, 76, 73, 78, 75, 32, 73, 78, 32, 84, 72, 69, 32, 83, 77, 83, 32, 87, 69, 39, 82, 69, 32, 83, 69, 78, 68, 73, 78, 71, 32, 89, 79, 85, 32, 78, 79, 87, 46, 32, 80, 76, 69, 65, 83, 69, 44, 32, 85, 78, 73, 78, 83, 84, 65, 76, 76, 32, 84, 72, 73, 83, 32, 86, 69, 82, 83, 73, 79, 78, 32, 79, 70, 32, 84, 72, 69, 32, 71, 65, 77, 69, 32, 66, 69, 70, 79, 82, 69, 32, 68, 79, 87, 78, 76, 79, 65, 68, 73, 78, 71, 32, 65, 78, 68, 32, 73, 78, 83, 84, 65, 76, 76, 73, 78, 71, 32, 65, 32, 78, 69, 87, 32, 79, 78, 69, 46}, new byte[]{0, 127, 73, 39, 77, 32, 65, 32, 80, 73, 82, 65, 84, 69, 68, 32, 67, 79, 80, 89, 44, 32, 73, 32, 87, 79, 78, 39, 84, 32, 87, 79, 82, 75, 32, 65, 78, 89, 32, 77, 79, 82, 69, 44, 32, 80, 76, 69, 65, 83, 69, 32, 85, 78, 73, 78, 83, 84, 65, 76, 76, 32, 84, 72, 73, 83, 32, 86, 69, 82, 83, 73, 79, 78, 32, 65, 78, 68, 32, 66, 85, 89, 32, 65, 32, 76, 69, 71, 65, 76, 32, 86, 69, 82, 83, 73, 79, 78, 32, 79, 70, 32, 77, 69, 32, 70, 82, 79, 77, 32, 84, 72, 69, 32, 65, 78, 68, 82, 79, 73, 68, 32, 77, 65, 82, 75, 69, 84, 46}, new byte[]{0, 2, 79, 75}};

    public k(aow2 aow2Var) {
        System.currentTimeMillis();
        this.f282a = new Image[3];
        this.f283a = new Graphics[3];
        this.f287a = null;
        this.f294a = new byte[2];
        this.f299a = new byte[128][128];
        this.f300b = new short[128][128];
        this.f302b = new byte[5][51];
        this.f308d = new byte[7272];
        this.f309e = new byte[7][50];
        this.f311c = new short[2][11];
        this.f312g = new byte[5][19];
        this.f313h = new byte[3][25];
        this.f314e = new byte[20000];
        this.f330a = new int[]{0, 5251341, 16704820, 16033043, 12010496};
        this.f331f = new byte[]{0, 1, 1, 1, 1};
        this.f332g = new byte[]{0, 1, 1, 2, 3};
        this.f333h = new byte[]{100, 98, 0, 0, 0};
        this.f334i = new byte[]{5, 3, 1, 1, 1};
        byte[] bArr = {71, 107, 115, 50, 56, 114, 116, 55};
        this.f337j = new byte[]{43, 43, 43};
        this.f343b = null;
        this.p = 0;
        this.f344a = null;
        this.f345g = -1;
        this.q = -1;
        this.r = -1;
        this.f346b = null;
        this.s = -1;
        this.f347b = null;
        this.f348a = System.currentTimeMillis();
        this.f349m = (byte) -2;
        this.f352a = null;
        this.f353c = null;
        this.f354d = null;
        this.v = 0;
        this.f355c = null;
        this.f356a = new String[]{"s0"};
        setFullScreenMode(true);
        this.f344a = new int[20][3];
        this.f346b = new int[20][2];
        this.f329a = aow2Var;
        this.j = false;
        this.b = 0L;
        this.c = 0L;
        this.f280b = 0;
        this.f281c = 0;
        this.f284b = (byte) 2;
        this.f288a = true;
        this.f289b = true;
        this.f290c = true;
        this.f291d = true;
        this.f292e = true;
        this.f = true;
        this.g = true;
        this.f293e = (byte) 0;
        this.f306f = (byte) 0;
        this.f307g = (byte) 0;
        this.h = (byte) 0;
        this.i = (byte) -2;
        this.n = 0;
        this.f315j = (byte) 0;
        this.f316d = this.f315j ^ 1;
        this.f317e = 0;
        this.f319k = (byte) -1;
        this.f320h = true;
        this.f321f = 0;
        this.f322l = (byte) 0;
        f362a[0] = 0;
        f362a[2] = 11;
        f362a[9] = 10;
    }

    public final void a() {
        Thread thread = new Thread(this);
        thread.setPriority(10);
        f361i *= 125;
        thread.start();
    }

    public final void a(String str) {
        this.j = false;
        this.f347b = str;
        if (this.f287a != null) {
            this.f287a.b();
            this.f287a = null;
        }
    }

    private void i() {
        a.a(new String(g.f252o), "-99857");
        i.f269a[4] = -9064;
        f360h = t / 3;
        String str = "WW3";
        if (a.a(str, 0) > 0) {
            f360h = a.a(str, 0) / 3;
        }
        String[] strArr = {"/prov.png", "/prov2.png", "/gg", "/hc"};
        int[] iArr = {a.a("ProvColor", 16777215), a.a("ProvColor2", 16777215), 4156, 0};
        this.i = (byte) -1;
        int i = this.p;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            Image imageCreateImage = null;
            this.f343b = null;
            try {
                imageCreateImage = Image.createImage(strArr[i2]);
            } catch (IOException unused) {
            }
            if (imageCreateImage != null) {
                if (i >= 0) {
                    int i3 = iArr[i2];
                    int i4 = (i3 >> 16) & 255;
                    int i5 = (i3 >> 8) & 255;
                    int i6 = i3 & 255;
                    int i7 = (i >> 16) & 255;
                    int i8 = (i >> 8) & 255;
                    int i9 = i & 255;
                    int i10 = (i4 - i7) / 15;
                    int i11 = (i5 - i8) / 15;
                    int i12 = (i6 - i9) / 15;
                    for (int i13 = 0; i13 < 15; i13++) {
                        this.p = (i7 << 16) | (i8 << 8) | i9;
                        h();
                        a.a(16L);
                        i7 += i10;
                        i8 += i11;
                        i9 += i12;
                    }
                } else {
                    this.p = iArr[i2];
                    h();
                    a.a(280L);
                }
                this.f343b = imageCreateImage;
                this.p = iArr[i2];
                h();
                a.a(1600L);
                i = this.p;
            }
        }
        this.f343b = null;
        this.p = 0;
        h();
        a.e();
        i.f269a[0] = g.a(this.f329a, a.f9a, new String(i.f270a), f360h);
    }

    private void c(int i) {
        if (i > 98) {
            i = 98;
        }
        byte[] bArr = this.f333h;
        byte[] bArr2 = this.f333h;
        byte b = (byte) i;
        this.f333h[4] = b;
        bArr2[3] = b;
        bArr[2] = b;
        for (int i2 = 0; i2 < 5; i2++) {
            this.f283a[1].setColor(this.f330a[i2]);
            this.f283a[1].fillRect(85 + this.f331f[i2], f318c + this.f332g[i2], this.f333h[i2], this.f334i[i2]);
        }
        h();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x019a A[Catch: Throwable -> 0x01d7, TryCatch #1 {Throwable -> 0x01d7, blocks: (B:3:0x002b, B:5:0x003e, B:8:0x004e, B:10:0x0085, B:11:0x0098, B:12:0x009e, B:15:0x00b5, B:17:0x00db, B:21:0x00f5, B:22:0x0125, B:23:0x012b, B:24:0x0132, B:29:0x0151, B:34:0x016f, B:39:0x019a, B:40:0x01af, B:41:0x01c8, B:42:0x01cf), top: B:53:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01af A[SYNTHETIC] */
    private void j() {
        a.e();
        this.f295b = new byte[5500];
        this.f296a = new short[142];
        this.f297b = new short[1000];
        this.f298c = new short[9];
        this.f336a = null;
        try {
            this.f336a = a.a(a.m4a("/a"));
            if (this.f336a != null) {
                this.f296a[0] = 0;
                for (int i = 0; i < 139; i++) {
                    int i2 = ((this.f336a.read() & 255) << 8) + (this.f336a.read() & 255);
                    this.f296a[i + 1] = (short) (this.f296a[i] + i2);
                    if (i2 > 0) {
                        this.f336a.readFully(this.f295b, this.f296a[i], i2);
                    }
                }
                this.f295b[this.f296a[82] + 1] = 0;
                for (int i3 = 0; i3 < 9; i3++) {
                    int i4 = ((this.f336a.read() & 255) << 8) + (this.f336a.read() & 255);
                    if (i3 < 8) {
                        this.f298c[i3 + 1] = (short) (this.f298c[i3] + i4);
                    }
                    for (int i5 = 0; i5 < i4; i5++) {
                        this.f297b[this.f298c[i3] + i5] = (short) (((this.f336a.read() & 255) << 8) + (this.f336a.read() & 255));
                    }
                }
                this.f336a.close();
            }
            this.f336a = null;
            this.f336a = a.a(a.m4a("/d"));
            if (this.f336a != null) {
                for (int i6 = 0; i6 < 4; i6++) {
                    this.f336a.read();
                }
                for (int i7 = 139; i7 < 142; i7++) {
                    short s = 33;
                    switch (i7) {
                        case 140:
                            s = 32;
                            if (i7 < 141) {
                                this.f296a[i7 + 1] = (short) (this.f296a[i7] + s + 10);
                            }
                            this.f336a.readFully(this.f295b, this.f296a[i7], s);
                            break;
                        case 141:
                            s = 95;
                            if (i7 < 141) {
                                this.f296a[i7 + 1] = (short) (this.f296a[i7] + s + 10);
                            }
                            this.f336a.readFully(this.f295b, this.f296a[i7], s);
                            break;
                        default:
                            if (i7 < 141) {
                                this.f296a[i7 + 1] = (short) (this.f296a[i7] + s + 10);
                            }
                            this.f336a.readFully(this.f295b, this.f296a[i7], s);
                            break;
                    }
                }
                this.f336a.close();
            }
            this.f336a = null;
        } catch (Throwable unused) {
        }
        if (this.f336a != null) {
            try {
                this.f336a.close();
            } catch (Exception unused2) {
            }
            this.f336a = null;
        }
        a.e();
    }

    final void b(String str) {
        a.e();
        this.f335a = null;
        try {
            this.f335a = a.m4a(str);
            if (this.f335a != null) {
                try {
                    this.n = 0;
                    while (true) {
                        int i = this.f335a.read();
                        if (i == -1) {
                            break;
                        }
                        this.f314e[this.n] = (byte) i;
                        this.n++;
                    }
                } catch (Exception unused) {
                }
                this.f335a.close();
            }
            this.f335a = null;
        } catch (IOException unused2) {
        }
        if (this.f335a != null) {
            try {
                this.f335a.close();
            } catch (Exception unused3) {
            }
            this.f335a = null;
        }
        a.e();
    }

    private void k() {
        while (f341k) {
            if (f342a == null) {
                try {
                    f342a = Image.createImage("/wd");
                } catch (IOException unused) {
                }
            }
            h();
            a.a(50L);
            this.f319k = (byte) -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        throw new java.lang.RuntimeException("stm init er!");
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Thread.yield();
        do {
            h();
            a.a(15L);
        } while (this.f329a.f16a.getCurrent() != this);
        a.a("/sn8p", true, "SO");
        if (!Display.getDisplay(this.f329a).equals(a.f9a)) {
            a.a(new String(g.f257t), new StringBuffer().append("").append(-g.m51a()).toString());
        }
        sizeChanged(getWidth(), getHeight());
        i();
        a.e();
        f275j = a.a("LSK1", -6);
        k = a.a("LSK2", -6);
        l = a.a("RSK1", -7);
        m = a.a("RSK2", -7);
        this.f284b = (byte) a.a("PRODY", 2);
        this.f285c = (byte) a.a("PRODMAX", 2);
        this.f286d = (byte) a.a("PRODMIN", 0);
        if (this.f284b > this.f285c) {
            this.f284b = this.f285c;
        } else if (this.f284b < this.f286d) {
            this.f284b = this.f286d;
        }
        o = a.a("ORIENT", 0);
        s();
        k();
        short height = (short) getHeight();
        a = height;
        f276a = (byte) (((height - 1) / 20) + 1);
        f278b = a;
        f279a = a > f278b + 20 ? a : f278b + 20;
        this.f277a = new short[f276a + 2][10];
        f318c = (short) (a - 8);
        this.f310f = new byte[f276a + 2][11];
        long[] jArr = f362a;
        jArr[0] = jArr[0] + 1;
        long[] jArr2 = f362a;
        jArr2[2] = jArr2[2] - f362a[9];
        long[] jArr3 = f362a;
        jArr3[9] = jArr3[9] + f362a[0];
        this.f319k = (byte) -1;
        try {
            this.f282a[1] = Image.createImage(270, f279a);
            this.f283a[1] = this.f282a[1].getGraphics();
            i.f269a[1] = a(this.f329a, a.f9a, new String(i.f271b), f360h);
            try {
                this.f343b = Image.createImage("/l2");
            } catch (IOException unused) {
            }
            this.f283a[1].setColor(0);
            this.f283a[1].fillRect(0, 0, 270, f279a);
            if (this.f343b != null) {
                this.f283a[1].drawImage(this.f343b, 135, f279a / 2, 3);
            }
            a.a("KPSPLSH", false);
            this.f343b = null;
            this.i = (byte) 0;
            a.e();
            c(5);
            this.f282a[0] = Image.createImage(270, f279a);
            this.f283a[0] = this.f282a[0].getGraphics();
            this.f282a[2] = Image.createImage(51, 51);
            this.f283a[2] = this.f282a[2].getGraphics();
            a.b();
            c(12);
            i.f269a[2] = o.a(this.f329a, a.f9a, new String(i.f272c), f360h);
            c(15);
            a.e();
            m();
            a.e();
            c(25);
            l();
            a.e();
            c(35);
            if (p.f525a == null) {
                p.f525a = new String[]{new String(g.f243h), new String(g.f246j), new String(g.f249l), new String(g.f250m), new String(g.f252o), new String(g.f257t)};
            }
            n();
            a.e();
            c(40);
            o();
            a.e();
            c(45);
            c(50);
            this.f303c = new byte[128][128];
            this.f304c = new byte[90];
            this.f305d = new byte[7][90];
            if (this.f293e < 2) {
                this.f301a = new int[2][4][128];
            }
            a.c();
            c(55);
            a.a();
            if (a.f8d) {
                d.a(a.a("SSADURL"), "aow2sad", t, u, Integer.parseInt(a.g), Integer.parseInt(a.f), 0, 0);
                a.e();
                a.a(50L);
            }
            c(60);
            j();
            c(65);
            this.f340a = new g(this);
            c(70);
            this.f338a = new p(this);
            c(75);
            this.f339a = new o(this);
            c(80);
            c.f28a = false;
            f();
            c(85);
            this.f340a.f179a = this.f338a;
            this.f340a.f180a = this.f339a;
            this.f338a.f505a = this.f340a;
            c(90);
            this.f340a.g();
            c(100);
            a.e();
            this.j = true;
            this.f343b = null;
            a.e();
            a.a(100L);
            this.f345g = -1;
            this.f319k = (byte) -1;
            this.b = System.currentTimeMillis();
            while (this.j) {
                k();
                this.f338a.f527d = this.b >> 1;
                p();
                this.f306f = this.f338a.c;
                this.f307g = this.f338a.d;
                q();
                r();
                if (!this.f323i) {
                    this.f340a.h();
                    this.f340a.i();
                    this.f319k = this.f340a.f235m;
                    this.f340a.f236h = true;
                }
                this.f340a.a();
                if (!this.f323i && this.f319k != this.f340a.f235m && this.f340a.f236h) {
                    this.f340a.f235m = this.f319k;
                }
                switch (this.i) {
                    case 0:
                        this.f340a.f();
                        break;
                    case 1:
                        try {
                            this.f338a.b();
                            this.f340a.a(true);
                        } catch (Exception unused2) {
                        }
                        break;
                    case 2:
                        this.f340a.e();
                        break;
                }
                h();
                this.c = System.currentTimeMillis();
                this.d = this.c - this.b;
                if (this.f288a && this.i == 1) {
                    a.a(50 - this.d);
                    this.e = System.currentTimeMillis();
                    this.f338a.a(false);
                    this.f338a.m76c();
                    this.f340a.a(true);
                    h();
                    a.a(50 - (System.currentTimeMillis() - this.e));
                } else {
                    a.a(100 - this.d);
                }
                if (this.i == 1 && this.f349m == 1 && System.currentTimeMillis() - this.b > 3000) {
                    this.f340a.m44b();
                }
                this.b = System.currentTimeMillis();
                this.f349m = this.i;
            }
        } catch (Exception unused3) {
        }
        if (this.f287a != null) {
            this.f287a.b();
            this.f287a = null;
        }
        if (a.c != null) {
            a.m2a(a.c);
        } else if (this.f347b != null) {
            a.m2a(this.f347b);
        }
        if (a.f7c) {
            a.a(3000L);
        }
        a.d();
        this.f329a.destroyApp(false);
        this.f329a.notifyDestroyed();
    }

    @Override // defpackage.q
    protected final void a(Graphics graphics) {
        if (this.i == -2) {
            try {
                int width = getWidth() << 1;
                int height = getHeight() << 1;
                graphics.setClip(0, 0, width, height);
                graphics.setColor(this.p);
                graphics.fillRect(0, 0, width, height);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (f341k) {
            try {
                int i = t;
                int i2 = u;
                graphics.setColor(0);
                graphics.setClip(0, 0, i, i2);
                graphics.fillRect(0, 0, i, i2);
                if (f342a != null) {
                    graphics.drawImage(f342a, i >> 1, i2 >> 1, 3);
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        if (this.i == -1) {
            graphics.setClip(0, 0, t, u);
            if (this.p >= 0) {
                graphics.setColor(this.p);
                graphics.fillRect(0, 0, t, u);
            }
            if (this.f343b != null) {
                graphics.drawImage(this.f343b, t >> 1, u >> 1, 3);
                return;
            }
            return;
        }
        if (this.f288a) {
            graphics.drawImage(this.f282a[1], (-15) + this.f280b, (-10) + this.f281c, 0);
        } else {
            graphics.drawImage(this.f282a[1], -15, -10, 0);
        }
        if (this.i == 0 && a.f8d) {
            d.a(graphics);
        }
        this.f281c = 0;
        this.f280b = 0;
    }

    @Override // defpackage.q
    protected final void a(int i) {
        a(i, 0);
    }

    @Override // defpackage.q
    protected final void b(int i) {
        a(i, 1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private byte m58a(int i) {
        byte b = -1;
        if (i == f275j || i == k) {
            b = 10;
        } else if (i == l || i == m) {
            b = 11;
        } else {
            switch (i) {
                case 48:
                    b = 0;
                    break;
                case 49:
                    b = 1;
                    break;
                case 50:
                    b = 2;
                    break;
                case 51:
                    b = 3;
                    break;
                case 52:
                    b = 4;
                    break;
                case 53:
                    b = 5;
                    break;
                case 54:
                    b = 6;
                    break;
                case 55:
                    b = 7;
                    break;
                case 56:
                    b = 8;
                    break;
                case 57:
                    b = 9;
                    break;
            }
            if (b == -1) {
                try {
                    int gameAction = getGameAction(i);
                    if (gameAction == 8) {
                        b = 5;
                    } else if (gameAction == 1) {
                        b = 2;
                    } else if (gameAction == 6) {
                        b = 8;
                    } else if (gameAction == 2) {
                        b = 4;
                    } else if (gameAction == 5) {
                        b = 6;
                    }
                } catch (Exception unused) {
                    b = -1;
                }
            }
        }
        return b;
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (displayable != this.f352a) {
            if (command == null) {
                keyPressed(f275j);
                return;
            } else {
                if (command == null) {
                    keyPressed(l);
                    return;
                }
                return;
            }
        }
        if (command == this.f353c) {
            this.f355c = this.f352a.getString().trim();
            if (this.f355c.length() > 0) {
                this.v = 1;
                return;
            }
            return;
        }
        if (command == this.f354d) {
            this.f355c = null;
            this.v = 2;
        }
    }

    private static void l() {
        for (int i = 0; i < o.f385a.length; i++) {
            o.f385a[i] = i.a(new StringBuffer().append("/f").append(i).toString(), 0, 2);
        }
        if (!i.f268a) {
            int i2 = o.f385a[0].a() > 18 ? 1 : 3;
            o.f385a[0].f266a = -i2;
            o.f385a[1].f266a = -i2;
            return;
        }
        int i3 = o.f385a[0].a() > 18 ? 7 : 5;
        for (int i4 = 0; i4 < o.f385a.length; i4++) {
            o.f385a[i4].f266a = -i3;
        }
        o.f385a[0].b = 12845055;
        o.f385a[1].b = 16766251;
        o.f385a[2].b = 51677;
        o.f385a[3].b = 16766251;
    }

    private void m() {
        int i = this.f337j[0];
        this.f324a = new Image[1][i];
        int[] iArr = new int[17415];
        byte[] bArr = new byte[17415];
        byte[] bArr2 = new byte[33000];
        int i2 = 0;
        for (int i3 = 0; i3 <= 0; i3++) {
            DataInputStream dataInputStreamA = null;
            try {
                dataInputStreamA = a.a(a.m4a(new StringBuffer().append("/i").append(i3).toString()));
                for (int i4 = 0; i4 < (i << 1); i4++) {
                    if (i2 == i) {
                        c(20);
                    }
                    int i5 = dataInputStreamA.readByte() & 255;
                    if (i5 == 255) {
                        break;
                    }
                    int i6 = (i5 << 16) | ((dataInputStreamA.readByte() & 255) << 8) | (dataInputStreamA.readByte() & 255);
                    if (i6 > 0) {
                        dataInputStreamA.readFully(bArr2, 0, i6);
                    }
                    if (i6 > 0) {
                        try {
                            if ((i2 & 1) == 0) {
                                this.f324a[0][i2 >> 1] = Image.createImage(bArr2, 0, i6);
                            } else {
                                Image imageCreateImage = Image.createImage(bArr2, 0, i6);
                                int width = this.f324a[0][i2 >> 1].getWidth();
                                int height = this.f324a[0][i2 >> 1].getHeight();
                                imageCreateImage.getRGB(iArr, 0, width, 0, 0, width, height);
                                for (int i7 = 0; i7 < width * height; i7++) {
                                    bArr[i7] = (byte) iArr[i7];
                                }
                                this.f324a[0][i2 >> 1].getRGB(iArr, 0, width, 0, 0, width, height);
                                for (int i8 = 0; i8 < width * height; i8++) {
                                    iArr[i8] = (bArr[i8] << 24) | (iArr[i8] & 16777215);
                                }
                                this.f324a[0][i2 >> 1] = null;
                                System.gc();
                                a.a(20L);
                                this.f324a[0][i2 >> 1] = Image.createRGBImage(iArr, width, height, true);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    System.gc();
                    Thread.yield();
                    i2++;
                }
                a.e();
                if (dataInputStreamA != null) {
                    try {
                        dataInputStreamA.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
                if (dataInputStreamA != null) {
                    try {
                        dataInputStreamA.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th) {
                if (dataInputStreamA != null) {
                    try {
                        dataInputStreamA.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
            System.gc();
        }
    }

    private void n() {
        DataInputStream dataInputStreamA = null;
        try {
            dataInputStreamA = a.a(a.m4a("/d0"));
            this.f327i = new byte[26][];
            this.f328f = new short[18][];
            for (int i = 0; i < 26; i++) {
                int i2 = dataInputStreamA.readShort();
                this.f327i[i] = new byte[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    this.f327i[i][i3] = dataInputStreamA.readByte();
                }
            }
            for (int i4 = 0; i4 < 18; i4++) {
                int i5 = dataInputStreamA.readShort();
                this.f328f[i4] = new short[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    this.f328f[i4][i6] = dataInputStreamA.readShort();
                }
            }
            Thread.yield();
            if (dataInputStreamA != null) {
                try {
                    dataInputStreamA.close();
                } catch (IOException unused) {
                }
            }
        } catch (Exception unused2) {
            if (dataInputStreamA != null) {
                try {
                    dataInputStreamA.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th) {
            if (dataInputStreamA != null) {
                try {
                    dataInputStreamA.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private void o() {
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStreamA = a.a(a.m4a("/ml"));
            dataInputStream = dataInputStreamA;
            int i = dataInputStreamA.readByte();
            this.f325d = new short[i][];
            this.f326e = new short[i][30];
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = dataInputStream.readShort();
                this.f325d[i2] = new short[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    this.f325d[i2][i4] = dataInputStream.readShort();
                }
                for (int i5 = 0; i5 < 30; i5++) {
                    this.f326e[i2][i5] = dataInputStream.readShort();
                }
            }
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (Exception unused2) {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th) {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        a.e();
    }

    public final void hideNotify() {
        b();
    }

    public final void showNotify() {
        c();
    }

    public final void b() {
        if (f358l || f359m) {
            return;
        }
        f359m = true;
        g();
        this.f319k = (byte) -1;
        f358l = true;
    }

    public final void c() {
        this.f319k = (byte) -1;
        f359m = false;
    }

    final void d() {
        c.f28a = true;
        f();
    }

    final void e() {
        if (this.f287a != null) {
            this.f287a.m13a();
        }
    }

    final void f() {
        try {
            if (this.f287a == null) {
                this.f287a = new c(this.f356a, a.a("SMTYPE", 0));
                Thread.yield();
                this.f287a.m14a(a.a("SMPRIOR"));
                a.a(20L);
                int iA = a.a("SMLEVEL", -1);
                if (iA >= 0) {
                    this.f287a.a(iA);
                }
            }
            if (!c.f28a || this.f287a.a()) {
                return;
            }
            this.f287a.a(0, -1);
        } catch (Exception unused) {
        }
    }

    final void g() {
        if (this.f287a != null) {
            try {
                this.f287a.b();
                this.f287a = null;
                a.e();
            } catch (Exception unused) {
            }
        }
    }

    private void p() {
        if (f358l) {
            f358l = false;
            this.f340a.m44b();
            g();
            while (f359m) {
                a.a(30L);
            }
            a.a(300L);
            if (!f358l) {
                f();
            }
            this.f319k = (byte) -1;
        }
    }

    protected final void pointerPressed(int i, int i2) {
        a(i, i2, 0);
        this.q = i;
        this.r = i2;
    }

    protected final void pointerReleased(int i, int i2) {
        a(i, i2, 1);
        this.q = -1;
        this.r = -1;
    }

    protected final void pointerDragged(int i, int i2) {
        if (this.q == -1 || this.r == -1 || Math.abs(i - this.q) > 10 || Math.abs(i2 - this.r) > 10) {
            a(i, i2, 2);
            this.q = i;
            this.r = i2;
        }
    }

    private void q() {
        if (this.f345g >= 0) {
            synchronized (this.f344a) {
                this.w = this.f344a[0][0];
                this.x = this.f344a[0][1];
                this.y = this.f344a[0][2];
                this.z = 0;
                while (this.z < this.f345g) {
                    this.f344a[this.z][0] = this.f344a[this.z + 1][0];
                    this.f344a[this.z][1] = this.f344a[this.z + 1][1];
                    this.f344a[this.z][2] = this.f344a[this.z + 1][2];
                    this.z++;
                }
                this.f345g--;
            }
            switch (this.y) {
                case 0:
                    int i = this.w;
                    int i2 = this.x;
                    if (this.f340a != null) {
                        if (a.f8d && this.i == 0 && f357a == null) {
                            String strA = d.a(i, i2);
                            f357a = strA;
                            if (strA != null) {
                                return;
                            }
                        }
                        this.f340a.m49a(i, i2);
                        if (this.i == 1 && this.f340a.f105b == -1) {
                            if (this.f322l == 0) {
                                this.f322l = (byte) 6;
                            } else {
                                this.f322l = (byte) 7;
                            }
                        }
                        this.f320h = false;
                        this.f321f = 0;
                        this.f323i = false;
                        return;
                    }
                    return;
                case 1:
                    int i3 = this.w;
                    int i4 = this.x;
                    if (this.f340a != null) {
                        this.f340a.c(i3, i4);
                        this.f320h = true;
                        if (this.f321f <= 0 || this.f319k == -1 || (3754 & (1 << this.f319k)) != 0) {
                            return;
                        }
                        this.f319k = (byte) -1;
                        return;
                    }
                    return;
                case 2:
                    int i5 = this.w;
                    int i6 = this.x;
                    if (this.f340a != null) {
                        this.f320h = false;
                        this.f340a.b(i5, i6);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(int i, int i2, int i3) {
        synchronized (this.f344a) {
            if (this.f345g < 19) {
                if (i3 != 2 || this.f345g == -1 || this.f344a[this.f345g][2] != 2) {
                    this.f345g++;
                }
                this.f344a[this.f345g][0] = i;
                this.f344a[this.f345g][1] = i2;
                this.f344a[this.f345g][2] = i3;
            } else if (i3 == 1) {
                this.f344a[19][0] = i;
                this.f344a[19][1] = i2;
                this.f344a[19][2] = i3;
            }
        }
    }

    private void r() {
        if (this.s >= 0) {
            synchronized (this.f346b) {
                this.A = this.f346b[0][0];
                this.B = this.f346b[0][1];
                this.C = 0;
                while (this.C < this.s) {
                    this.f346b[this.C][0] = this.f346b[this.C + 1][0];
                    this.f346b[this.C][1] = this.f346b[this.C + 1][1];
                    this.C++;
                }
                this.s--;
            }
            switch (this.B) {
                case 0:
                    int i = this.A;
                    byte b = this.f319k;
                    this.f319k = m58a(i);
                    if (this.i == 1) {
                        if (this.f319k == 10) {
                            pointerPressed(2, f278b - 2);
                            pointerReleased(2, f278b - 2);
                            this.f319k = (byte) -1;
                            return;
                        } else if (this.f319k == 11) {
                            if (this.f340a.f105b != -1 || this.f340a.f102d >= 0) {
                                pointerPressed(238, f278b - 2);
                                pointerReleased(238, f278b - 2);
                            }
                            this.f319k = (byte) -1;
                            return;
                        }
                    }
                    if ((this.f319k == 5 || this.f319k == 1 || this.f319k == 3 || this.f319k == 7 || this.f319k == 9) && this.i == 1) {
                        if (this.f322l == 0) {
                            this.f322l = (byte) 6;
                        } else {
                            this.f322l = (byte) 7;
                        }
                    }
                    if (this.f319k != -1) {
                        this.f320h = false;
                        this.f321f = 0;
                    } else {
                        this.f319k = b;
                    }
                    this.f323i = true;
                    return;
                case 1:
                    if (this.f319k == m58a(this.A)) {
                        this.f320h = true;
                        if (this.f321f <= 0 || this.f319k == -1 || (3754 & (1 << this.f319k)) != 0) {
                            return;
                        }
                        this.f319k = (byte) -1;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void a(int i, int i2) {
        synchronized (this.f346b) {
            if (this.s < 19) {
                this.s++;
                this.f346b[this.s][0] = i;
                this.f346b[this.s][1] = i2;
            } else if (i2 == 1) {
                this.f346b[19][0] = i;
                this.f346b[19][1] = i2;
            }
        }
    }

    protected final void sizeChanged(int i, int i2) {
        t = i;
        u = i2;
        s();
    }

    private static final void s() {
        if ((o != 1 || t <= u) && (o != 2 || u <= t)) {
            f341k = false;
        } else {
            f341k = true;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final String m59a() {
        this.v = 0;
        this.f352a = new TextBox(o.f384a[3][4], "", 12, 3);
        this.f353c = new Command(o.f384a[3][2], 4, 1);
        this.f354d = new Command(o.f384a[3][3], 3, 2);
        this.f352a.addCommand(this.f353c);
        this.f352a.addCommand(this.f354d);
        this.f352a.setCommandListener(this);
        byte b = this.i;
        this.i = (byte) -2;
        this.f329a.f16a.setCurrent(this.f352a);
        while (this.v == 0) {
            a.a(30L);
        }
        this.f329a.f16a.setCurrent(this);
        this.f352a = null;
        this.f354d = null;
        this.f353c = null;
        a.e();
        this.i = b;
        return this.f355c;
    }

    private static int a(MIDlet mIDlet, Hashtable hashtable, String str, int i) {
        int iM51a = g.m51a();
        try {
            String property = System.getProperty(new String(g.f246j));
            String appProperty = mIDlet.getAppProperty(new String(g.f247k));
            String str2 = property == null ? appProperty : property;
            String str3 = (String) a.f9a.get(str);
            if (str3 == null) {
                int i2 = -iM51a;
                hashtable.put(new String(g.f246j), new StringBuffer().append("").append(i2).toString());
                return i2;
            }
            if (str3 != null) {
                return iM51a;
            }
            String[] strArrA = a.a(new String(f.a(str3, i, false)), '@');
            boolean z = false;
            for (int i3 = 0; i3 < strArrA.length - 1; i3++) {
                if (str2.startsWith(strArrA[i3])) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                for (String str4 : strArrA) {
                    if (str4.equals(str2)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                String str5 = new String(g.f246j);
                StringBuffer stringBufferAppend = new StringBuffer().append("");
                int i4 = z ? -iM51a : iM51a;
                iM51a = i4;
                hashtable.put(str5, stringBufferAppend.append(i4).toString());
            }
            if (str2.equals(mIDlet.getAppProperty(new String(g.f244i)))) {
                iM51a = g.m51a();
            } else {
                hashtable.put(appProperty, new StringBuffer().append("").append(iM51a).toString());
            }
            return iM51a;
        } catch (Exception unused) {
        }
    }

    public static boolean a(Object obj) {
        if (f363b == null) {
            try {
                f363b = ((Hashtable) obj).elements().nextElement();
                while (a.f9a == null) {
                    a.a(40L);
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException(new StringBuffer().append("").append(e).append(" ").append(g.m53a()).toString());
            }
        }
        Object obj2 = f363b;
        long[] jArr = f362a;
        long j = jArr[10] + 1;
        jArr[10] = j;
        ((Hashtable) obj).put(obj2, new Long(j));
        return obj == null && f363b == null;
    }

    public final void a(int i, int i2, boolean z) {
        if (i == 0 || i2 <= 0) {
            return;
        }
        p.f();
    }
}
