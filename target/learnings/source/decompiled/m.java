package defpackage;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:m.class */
public final class m implements j {
    private Hashtable a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Reader f368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private char[] f369a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private int f370b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private int f371c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f374a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f375b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private String f376c;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f377b;
    private int h;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private String f379d;
    private int j;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private boolean f381c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private boolean f382d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private boolean f383e;
    private String[] b = new String[16];
    private String[] c = new String[8];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int[] f367a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private char[] f372b = new char[128];

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private String[] f378d = new String[16];
    private int i = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private int[] f380b = new int[2];

    public m() {
        this.f369a = new char[Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : 128];
    }

    private static String[] a(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void a(String str) throws l {
        throw new l(str.length() < 100 ? str : new StringBuffer().append(str.substring(0, 100)).append("\n").toString(), this, null);
    }

    private final int a(boolean z) throws IOException, l {
        int i;
        int i2;
        String str = "";
        int i3 = 0;
        c();
        int iC = c();
        if (iC == 63) {
            if ((m62a(0) == 120 || m62a(0) == 88) && (m62a(1) == 109 || m62a(1) == 77)) {
                if (z) {
                    m61a(m62a(0));
                    m61a(m62a(1));
                }
                c();
                c();
                if ((m62a(0) == 108 || m62a(0) == 76) && m62a(1) <= 32) {
                    if (this.d != 1 || this.e > 4) {
                        a("PI must not start with xml");
                    }
                    b(true);
                    if (this.h <= 0 || !"version".equals(this.f378d[2])) {
                        a("version expected");
                    }
                    int i4 = 1;
                    if (1 < this.h && "encoding".equals(this.f378d[6])) {
                        i4 = 1 + 1;
                    }
                    if (i4 < this.h && "standalone".equals(this.f378d[(i4 * 4) + 2])) {
                        String str2 = this.f378d[3 + (i4 * 4)];
                        if ("yes".equals(str2)) {
                            new Boolean(true);
                        } else if ("no".equals(str2)) {
                            new Boolean(false);
                        } else {
                            a(new StringBuffer().append("illegal standalone value: ").append(str2).toString());
                        }
                        i4++;
                    }
                    if (i4 != this.h) {
                        a("illegal xmldecl");
                    }
                    this.f373a = true;
                    this.f = 0;
                    return 998;
                }
            }
            i2 = 63;
            i = 8;
        } else {
            if (iC != 33) {
                a(new StringBuffer().append("illegal: <").append(iC).toString());
                return 9;
            }
            if (m62a(0) == 45) {
                i = 9;
                str = "--";
                i2 = 45;
            } else if (m62a(0) == 91) {
                i = 5;
                str = "[CDATA[";
                i2 = 93;
                z = true;
            } else {
                i = 10;
                str = "DOCTYPE";
                i2 = -1;
            }
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            a(str.charAt(i5));
        }
        if (i == 10) {
            m60a(z);
        } else {
            while (true) {
                int iC2 = c();
                if (iC2 == -1) {
                    a("Unexpected EOF");
                    return 9;
                }
                if (z) {
                    m61a(iC2);
                }
                if ((i2 == 63 || iC2 == i2) && m62a(0) == i2 && m62a(1) == 62) {
                    if (i2 == 45 && i3 == 45) {
                        a("illegal comment delimiter: --->");
                    }
                    c();
                    c();
                    if (z && i2 != 63) {
                        this.f--;
                    }
                } else {
                    i3 = iC2;
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private final void m60a(boolean z) throws IOException, l {
        int i = 1;
        boolean z2 = false;
        while (true) {
            int iC = c();
            switch (iC) {
                case -1:
                    a("Unexpected EOF");
                    return;
                case 39:
                    z2 = !z2;
                    break;
                case 60:
                    if (!z2) {
                        i++;
                    }
                    break;
                case 62:
                    if (!z2) {
                        i--;
                        if (i == 0) {
                            return;
                        }
                    }
                    break;
            }
            if (z) {
                m61a(iC);
            }
        }
    }

    private final int b() {
        switch (m62a(0)) {
            case -1:
                return 1;
            case 38:
                return 6;
            case 60:
                switch (m62a(1)) {
                    case 33:
                    case 63:
                        return 999;
                    case 47:
                        return 3;
                    default:
                        return 2;
                }
            default:
                return 4;
        }
    }

    private final String a(int i) {
        return new String(this.f372b, i, this.f - i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private final void m61a(int i) {
        this.f373a &= i <= 32;
        if (this.f == this.f372b.length) {
            char[] cArr = new char[((this.f << 2) / 3) + 4];
            System.arraycopy(this.f372b, 0, cArr, 0, this.f);
            this.f372b = cArr;
        }
        char[] cArr2 = this.f372b;
        int i2 = this.f;
        this.f = i2 + 1;
        cArr2[i2] = (char) i;
    }

    private final void b(boolean z) throws IOException, l {
        if (!z) {
            c();
        }
        this.f376c = m63c();
        this.h = 0;
        while (true) {
            m64b();
            int iM62a = m62a(0);
            if (!z) {
                if (iM62a != 47) {
                    if (iM62a == 62 && !z) {
                        c();
                        break;
                    }
                } else {
                    this.f377b = true;
                    c();
                    m64b();
                    a('>');
                    break;
                }
            } else if (iM62a == 63) {
                c();
                a('>');
                return;
            }
            if (iM62a == -1) {
                a("Unexpected EOF");
                return;
            }
            String strM63c = m63c();
            if (strM63c.length() == 0) {
                a("attr name expected");
                break;
            }
            int i = this.h;
            this.h = i + 1;
            int i2 = i << 2;
            this.f378d = a(this.f378d, i2 + 4);
            int i3 = i2 + 1;
            this.f378d[i2] = "";
            int i4 = i3 + 1;
            this.f378d[i3] = null;
            int i5 = i4 + 1;
            this.f378d[i4] = strM63c;
            m64b();
            if (m62a(0) != 61) {
                a(new StringBuffer().append("Attr.value missing f. ").append(strM63c).toString());
                this.f378d[i5] = "1";
            } else {
                a('=');
                m64b();
                int iM62a2 = m62a(0);
                int i6 = iM62a2;
                if (iM62a2 == 39 || i6 == 34) {
                    c();
                } else {
                    a("attr value delimiter missing!");
                    i6 = 32;
                }
                int i7 = this.f;
                a(i6, true);
                this.f378d[i5] = a(i7);
                this.f = i7;
                if (i6 != 32) {
                    c();
                }
            }
        }
        int i8 = this.f366a;
        this.f366a = i8 + 1;
        int i9 = i8 << 2;
        this.b = a(this.b, i9 + 4);
        this.b[i9 + 3] = this.f376c;
        if (this.f366a >= this.f367a.length) {
            int[] iArr = new int[this.f366a + 4];
            System.arraycopy(this.f367a, 0, iArr, 0, this.f367a.length);
            this.f367a = iArr;
        }
        this.f367a[this.f366a] = this.f367a[this.f366a - 1];
        this.f374a = "";
        this.b[i9] = this.f374a;
        this.b[i9 + 1] = this.f375b;
        this.b[i9 + 2] = this.f376c;
    }

    private final void a() throws IOException, l {
        m61a(c());
        int i = this.f;
        while (true) {
            int iC = c();
            if (iC == 59) {
                String strA = a(i);
                this.f = i - 1;
                if (strA.charAt(0) == '#') {
                    m61a(strA.charAt(1) == 'x' ? Integer.parseInt(strA.substring(2), 16) : Integer.parseInt(strA.substring(1)));
                    return;
                }
                String str = (String) this.a.get(strA);
                this.f382d = str == null;
                if (this.f382d) {
                    a(new StringBuffer().append("unresolved: &").append(strA).append(";").toString());
                    return;
                }
                for (int i2 = 0; i2 < str.length(); i2++) {
                    m61a((int) str.charAt(i2));
                }
                return;
            }
            if (iC < 128 && ((iC < 48 || iC > 57) && ((iC < 97 || iC > 122) && ((iC < 65 || iC > 90) && iC != 95 && iC != 45 && iC != 35)))) {
                a("unterminated entity ref");
                if (iC != -1) {
                    m61a(iC);
                    return;
                }
                return;
            }
            m61a(iC);
        }
    }

    private final void a(int i, boolean z) throws IOException, l {
        int iM62a = m62a(0);
        int i2 = 0;
        while (iM62a != -1 && iM62a != i) {
            if (i == 32 && (iM62a <= 32 || iM62a == 62)) {
                return;
            }
            if (iM62a == 38) {
                if (!z) {
                    return;
                } else {
                    a();
                }
            } else if (iM62a == 10 && this.g == 2) {
                c();
                m61a(32);
            } else {
                m61a(c());
            }
            if (iM62a == 62 && i2 >= 2 && i != 93) {
                a("Illegal: ]]>");
            }
            i2 = iM62a == 93 ? i2 + 1 : 0;
            iM62a = m62a(0);
        }
    }

    private final void a(char c) throws IOException, l {
        int iC = c();
        if (iC != c) {
            a(new StringBuffer().append("expected: '").append(c).append("' actual: '").append((char) iC).append("'").toString());
        }
    }

    private final int c() throws IOException {
        int iM62a;
        if (this.j == 0) {
            iM62a = m62a(0);
        } else {
            iM62a = this.f380b[0];
            this.f380b[0] = this.f380b[1];
        }
        this.j--;
        this.e++;
        if (iM62a == 10) {
            this.d++;
            this.e = 1;
        }
        return iM62a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private final int m62a(int i) throws IOException {
        int i2;
        while (i >= this.j) {
            if (this.f369a.length <= 1) {
                i2 = this.f368a.read();
            } else if (this.f370b < this.f371c) {
                char[] cArr = this.f369a;
                int i3 = this.f370b;
                this.f370b = i3 + 1;
                i2 = cArr[i3];
            } else {
                this.f371c = this.f368a.read(this.f369a, 0, this.f369a.length);
                i2 = this.f371c <= 0 ? -1 : this.f369a[0];
                this.f370b = 1;
            }
            if (i2 == 13) {
                this.f381c = true;
                int[] iArr = this.f380b;
                int i4 = this.j;
                this.j = i4 + 1;
                iArr[i4] = 10;
            } else {
                if (i2 != 10) {
                    int[] iArr2 = this.f380b;
                    int i5 = this.j;
                    this.j = i5 + 1;
                    iArr2[i5] = i2;
                } else if (!this.f381c) {
                    int[] iArr3 = this.f380b;
                    int i6 = this.j;
                    this.j = i6 + 1;
                    iArr3[i6] = 10;
                }
                this.f381c = false;
            }
        }
        return this.f380b[i];
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private final String m63c() throws IOException, l {
        int i = this.f;
        int iM62a = m62a(0);
        if ((iM62a < 97 || iM62a > 122) && ((iM62a < 65 || iM62a > 90) && iM62a != 95 && iM62a != 58 && iM62a < 192)) {
            a("name expected");
        }
        while (true) {
            m61a(c());
            int iM62a2 = m62a(0);
            if (iM62a2 < 97 || iM62a2 > 122) {
                if (iM62a2 < 65 || iM62a2 > 90) {
                    if (iM62a2 < 48 || iM62a2 > 57) {
                        if (iM62a2 != 95 && iM62a2 != 45 && iM62a2 != 58 && iM62a2 != 46 && iM62a2 < 183) {
                            String strA = a(i);
                            this.f = i;
                            return strA;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private final void m64b() throws IOException {
        while (true) {
            int iM62a = m62a(0);
            if (iM62a > 32 || iM62a == -1) {
                return;
            } else {
                c();
            }
        }
    }

    public final void a(Reader reader) {
        this.f368a = reader;
        this.d = 1;
        this.e = 0;
        this.g = 0;
        this.f376c = null;
        this.f374a = null;
        this.f377b = false;
        this.h = -1;
        if (reader == null) {
            return;
        }
        this.f370b = 0;
        this.f371c = 0;
        this.j = 0;
        this.f366a = 0;
        this.a = new Hashtable();
        this.a.put("amp", "&");
        this.a.put("apos", "'");
        this.a.put("gt", ">");
        this.a.put("lt", "<");
        this.a.put("quot", "\"");
    }

    @Override // defpackage.j
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final String mo65a() {
        StringBuffer stringBuffer = new StringBuffer(this.g < j.a.length ? j.a[this.g] : "unknown");
        stringBuffer.append(' ');
        if (this.g == 2 || this.g == 3) {
            if (this.f377b) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.g == 3) {
                stringBuffer.append('/');
            }
            if (this.f375b != null) {
                stringBuffer.append(new StringBuffer().append("{").append(this.f374a).append("}").append(this.f375b).append(":").toString());
            }
            stringBuffer.append(this.f376c);
            int i = this.h << 2;
            for (int i2 = 0; i2 < i; i2 += 4) {
                stringBuffer.append(' ');
                if (this.f378d[i2 + 1] != null) {
                    stringBuffer.append(new StringBuffer().append("{").append(this.f378d[i2]).append("}").append(this.f378d[i2 + 1]).append(":").toString());
                }
                stringBuffer.append(new StringBuffer().append(this.f378d[i2 + 2]).append("='").append(this.f378d[i2 + 3]).append("'").toString());
            }
            stringBuffer.append('>');
        } else if (this.g != 7) {
            if (this.g != 4) {
                stringBuffer.append(d());
            } else if (this.f373a) {
                stringBuffer.append("(whitespace)");
            } else {
                String strD = d();
                String string = strD;
                if (strD.length() > 16) {
                    string = new StringBuffer().append(string.substring(0, 16)).append("...").toString();
                }
                stringBuffer.append(string);
            }
        }
        stringBuffer.append(new StringBuffer().append("@").append(this.d).append(":").append(this.e).toString());
        if (this.f368a != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.f368a.toString());
        }
        return stringBuffer.toString();
    }

    private String d() {
        if (this.g < 4) {
            return null;
        }
        if (this.g == 6 && this.f382d) {
            return null;
        }
        return a(0);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final String m66b() {
        return this.f376c;
    }

    public final String a(String str, String str2) {
        for (int i = (this.h << 2) - 4; i >= 0; i -= 4) {
            if (this.f378d[i + 2].equals(str2)) {
                return this.f378d[i + 3];
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x019e  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ff  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final int m67a() throws IOException, l {
        this.f = 0;
        this.f373a = true;
        int i = 9999;
        this.f383e = false;
        while (true) {
            if (this.f368a == null) {
                a("No Input specified");
            }
            if (this.g == 3) {
                this.f366a--;
            }
            do {
                this.h = -1;
                if (this.f377b) {
                    this.f377b = false;
                    this.g = 3;
                } else if (this.f379d == null) {
                    this.f375b = null;
                    this.f376c = null;
                    this.f374a = null;
                    this.g = b();
                    switch (this.g) {
                        case 1:
                            break;
                        case 2:
                            b(false);
                            break;
                        case 3:
                            c();
                            c();
                            this.f376c = m63c();
                            m64b();
                            a('>');
                            int i2 = (this.f366a - 1) << 2;
                            if (this.f366a == 0) {
                                a("element stack empty");
                                this.g = 9;
                            } else if (this.f376c.equals(this.b[i2 + 3])) {
                                this.f374a = this.b[i2];
                                this.f375b = this.b[i2 + 1];
                                this.f376c = this.b[i2 + 2];
                            } else {
                                a(new StringBuffer().append("expected: /").append(this.b[i2 + 3]).append(" read: ").append(this.f376c).toString());
                                int i3 = i2;
                                while (i3 >= 0 && !this.f376c.toLowerCase().equals(this.b[i3 + 3].toLowerCase())) {
                                    this.i++;
                                    i3 -= 4;
                                }
                                if (i3 < 0) {
                                    this.i = 0;
                                    this.g = 9;
                                } else {
                                    this.f374a = this.b[i2];
                                    this.f375b = this.b[i2 + 1];
                                    this.f376c = this.b[i2 + 2];
                                }
                            }
                            break;
                        case 4:
                            a(60, true);
                            if (this.f366a == 0 && this.f373a) {
                                this.g = 7;
                            }
                            break;
                        case 5:
                        default:
                            this.g = a(false);
                            break;
                        case 6:
                            a();
                            break;
                    }
                } else {
                    for (int i4 = 0; i4 < this.f379d.length(); i4++) {
                        m61a((int) this.f379d.charAt(i4));
                    }
                    this.f379d = null;
                    this.g = 9;
                }
                if (this.g < i) {
                    i = this.g;
                }
                if (i <= 6 || (i >= 4 && b() >= 4)) {
                }
            } while (this.g == 998);
            if (this.g < i) {
                i = this.g;
            }
            if (i <= 6) {
            }
        }
        this.g = i;
        if (this.g > 4) {
            this.g = 4;
        }
        return this.g;
    }
}
