package defpackage;

import java.io.DataInputStream;
import java.io.EOFException;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:o.class */
public final class o {
    private k a;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f390a;
    private int n;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    int f391b;
    int c;
    int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    boolean f392a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    boolean f393b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String[][] f384a = new String[4][];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static i[] f385a = new i[4];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static int[][] f386a = new int[100][6];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int f387a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String[] f388a = new String[50];
    private static int e = 0;
    private static String[] b = new String[100];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static int[][] f389b = new int[100][4];
    private static int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static byte f394a = 11;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f395b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static String f396c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static int[] f397a = {20, 17, 24};

    public o(k kVar) {
        this.a = kVar;
        if (i.f268a) {
            byte height = (byte) Font.getDefaultFont().getHeight();
            f394a = height;
            g.f231l = height;
        }
    }

    static void a(int i, int i2, int i3, String str, int i4) {
        int i5 = 0;
        if (i4 >= 0) {
            i5 = i4 + 1;
        }
        int i6 = f397a[i3];
        int i7 = i5;
        if (str != null) {
            a(4, e, i, i2, i6, i7);
            String[] strArr = f388a;
            int i8 = e;
            e = i8 + 1;
            strArr[i8] = str;
        }
    }

    static void a(int i, int i2, int i3, int i4) {
        a(3, i4, i, i2, f397a[1], 0);
    }

    static void b(int i, int i2, int i3, int i4) {
        a(0, i4, i, i2, f397a[i3], 0);
    }

    final void a(Graphics graphics) {
        if (f387a > 0) {
            for (int i = 0; i < f387a; i++) {
                this.h = f386a[i][4];
                this.i = f386a[i][5];
                this.j = f386a[i][0];
                this.k = f386a[i][1];
                this.l = f386a[i][2];
                this.m = f386a[i][3];
                this.f390a = this.h == 4 ? f388a[this.i] : f384a[this.h][this.i];
                this.j += 15 + this.a.f340a.f151k;
                this.k += 10 + this.a.f340a.f152l;
                if (this.a.f288a && !this.a.f340a.f149c) {
                    this.j -= this.a.f280b;
                    this.k -= this.a.f281c;
                }
                try {
                    f385a[this.m].a(graphics, this.f390a, this.j, this.k, this.l);
                } catch (Throwable unused) {
                    graphics.setColor(16777215);
                    graphics.drawString(this.f390a, this.j, this.k, this.l);
                }
            }
            if (f387a > 0) {
                f387a = 0;
                if (e > 0) {
                    for (int i2 = 0; i2 < e; i2++) {
                        f388a[i2] = null;
                    }
                    e = 0;
                }
            }
        }
    }

    final void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        a(i, i2, i3, i4, f384a[i5][i6], i7);
    }

    final void a(int i, int i2, int i3, int i4, String str, int i5) {
        Vector vectorA;
        a();
        if (str == f384a[1][0]) {
            str = new StringBuffer().append(str).append(g.b(new StringBuffer().append("").append(i).toString())).toString();
        }
        String strA = a(str);
        f395b = strA;
        if (strA == null || (vectorA = a.a(i3, f395b, f385a[0])) == null || vectorA.size() <= 0) {
            return;
        }
        int i6 = i5 < 3 ? f397a[i5] : 17;
        if (i6 == 17) {
            i += i3 >> 1;
        } else if (i6 == 24) {
            i += i3;
        }
        int size = vectorA.size();
        for (int i7 = 0; i7 < size; i7++) {
            String str2 = (String) vectorA.elementAt(i7);
            f389b[f][0] = i;
            f389b[f][1] = 0;
            f389b[f][2] = i6;
            f389b[f][3] = 0;
            b[f] = str2;
            f++;
        }
        this.c = size;
        this.n = i2 + ((i5 != 3 || this.c * f394a >= i4) ? 0 : (i4 - (this.c * f394a)) / 2);
        this.f391b = i4 / f394a;
        this.d = 0;
    }

    final void b(Graphics graphics) {
        if (f > 0) {
            this.g = this.d;
            while (this.g < this.d + this.f391b && this.g < this.c) {
                this.j = f389b[this.g][0];
                this.k = this.n + ((this.g - this.d) * f394a);
                this.l = f389b[this.g][2];
                this.m = f389b[this.g][3];
                this.f390a = b[this.g];
                this.j += 15 + this.a.f340a.f151k;
                this.k += 10 + this.a.f340a.f152l;
                if (this.a.f288a && !this.a.f340a.f149c) {
                    this.j -= this.a.f280b;
                    this.k -= this.a.f281c;
                }
                try {
                    f385a[this.m].a(graphics, this.f390a, this.j, this.k, this.l);
                } catch (Throwable unused) {
                    graphics.setColor(16777215);
                    graphics.drawString(this.f390a, this.j, this.k, this.l);
                }
                this.g++;
            }
            this.f392a = this.d == 0;
            this.f393b = this.d + this.f391b >= this.c;
        }
    }

    private final String a(String str) {
        try {
            f396c = str;
            String strA = a.a(str, "[RANK]", f384a[0][94 + this.a.f340a.c]);
            f396c = strA;
            String strA2 = a.a(strA, "[VER]", new StringBuffer().append(a.f1a).append(g.m54a(a.f1a)).toString());
            f396c = strA2;
            f396c = a.a(strA2, "[M_ID]", new StringBuffer().append("").append(this.a.f340a.a).toString());
        } catch (Exception unused) {
        }
        return f396c;
    }

    private static final void a(int i, int i2, int i3, int i4, int i5, int i6) {
        f386a[f387a][4] = i;
        f386a[f387a][5] = i2;
        f386a[f387a][0] = i3;
        f386a[f387a][1] = i4;
        f386a[f387a][2] = i5;
        f386a[f387a][3] = i6;
        f387a++;
    }

    public static final void a() {
        if (f > 0) {
            for (int i = 0; i < f; i++) {
                b[i] = null;
            }
            f = 0;
        }
    }

    static int a(MIDlet mIDlet, Hashtable hashtable, String str, int i) {
        DataInputStream dataInputStreamA;
        int iM51a = g.m51a();
        String str2 = new String(g.f249l);
        try {
            String appProperty = mIDlet.getAppProperty(str2);
            String appProperty2 = mIDlet.getAppProperty(str);
            String strSubstring = appProperty2;
            if (appProperty2 == null) {
                strSubstring = System.getProperty(str);
            }
            if (strSubstring == null && (dataInputStreamA = a.a(a.m4a(new String(g.f253p)))) != null) {
                while (true) {
                    try {
                        String strA = a.a(dataInputStreamA, false);
                        if (strA == null) {
                            break;
                        }
                        int iIndexOf = strA.indexOf(58);
                        if (iIndexOf >= 0 && strA.substring(0, iIndexOf).equals(str)) {
                            strSubstring = strA.substring(iIndexOf + 2, strA.length());
                            break;
                        }
                    } catch (EOFException unused) {
                    }
                }
                dataInputStreamA.close();
            }
            if (strSubstring == null) {
                int i2 = -iM51a;
                hashtable.put(str2, new StringBuffer().append("").append(i2).toString());
                return i2;
            }
            if (strSubstring != null) {
                return iM51a;
            }
            byte[] bArrA = f.a(strSubstring, i, false);
            int i3 = appProperty == null ? -1 : Integer.parseInt(appProperty);
            int i4 = ((bArrA[0] & 255) << 24) | ((bArrA[1] & 255) << 16) | ((bArrA[2] & 255) << 8) | (bArrA[3] & 255);
            String str3 = new String();
            if (Math.abs(i3 - i4) < 3 && Math.abs((i3 >> 2) - (i4 >> 2)) < 2) {
                iM51a = -g.m51a();
                hashtable.put(str2, new StringBuffer().append("").append(iM51a).toString());
            }
            String str4 = new String(g.f251n);
            String appProperty3 = mIDlet.getAppProperty(str4);
            if (appProperty3.equals(str3)) {
                hashtable.put(str4, str3);
            } else {
                String string = "";
                for (int length = appProperty3.length() - 1; length >= 0; length--) {
                    string = new StringBuffer().append(string).append(appProperty3.charAt(length)).toString();
                }
                if (appProperty3.equals(string)) {
                    iM51a -= (iM51a - 297987) - (Integer.parseInt(appProperty3) >> 8);
                    hashtable.put(string, new StringBuffer().append("").append(iM51a).toString());
                }
            }
            return iM51a;
        } catch (Exception unused2) {
            int i5 = -iM51a;
            hashtable.put(str2, new StringBuffer().append("").append(i5).toString());
            return i5;
        }
    }
}
