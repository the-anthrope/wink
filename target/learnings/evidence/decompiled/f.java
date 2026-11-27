package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:f.class */
public final class f extends Exception implements CommandListener, ItemStateListener {
    private static int b = 226;
    private static String a = "account";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f54b = "user_id";
    private static String c = "cur_ach";
    private static String d = "cur_email";
    private static String e = "cur_phone";
    private static String f = "sess";
    private static String g = "sess_t";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f55a = {72, 67, 45};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final byte[] f56b = {89, 67, 45};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static final byte[] f57c = {47, 114, 115, 117};
    private static final String h = new String(f55a);
    private static final String i = new String(f56b);
    private static final String j;
    private static final String k;
    private static final String l;
    private static final String m;
    private static final String n;
    private static final String o;
    private static final String p;
    private static final String q;
    private static final String r;
    private static final String s;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f58a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f59b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f60c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f61d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static boolean f62e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int f63a;
    private static String t;
    private static String u;
    private static String v;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String[] f65b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static String[] f66c;
    private static String w;
    private static String x;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final Hashtable f70b;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static final String[] f71d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static MIDlet f72a;
    private static String z;
    private static String A;
    private static String B;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private static boolean f73g;
    private static String C;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static Hashtable f74c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static f f75a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static int f76d;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    private static boolean f77h;
    private static String D;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static String[] f85f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String[] f64a = {"", ""};
    private String y = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private int f67c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Hashtable f68a = new Hashtable();

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private boolean f69f = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private volatile int f78e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Form f79a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ChoiceGroup f80a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Command f81a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Command f82b = null;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private String[] f83e = null;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private volatile int f84f = 0;

    private f() {
    }

    private f(String str, String str2, String str3, String str4) {
        this.f64a[0] = str;
        this.f64a[1] = str2;
    }

    public static final void a(MIDlet mIDlet, String[] strArr, String[] strArr2, String str, String str2, String str3, boolean z2, boolean z3, int i2, String str4) {
        f72a = mIDlet;
        f65b = strArr;
        f66c = strArr2;
        z = str;
        A = str2;
        B = str3;
        x = z2 ? "GET" : "POST";
        f62e = z3;
        f63a = 2;
        try {
            String[] strArrA = a.a(str4, '%');
            if (strArrA != null) {
                for (int i3 = 0; i3 < strArrA.length; i3++) {
                    int iIndexOf = strArrA[i3].indexOf(61);
                    if (iIndexOf >= 0) {
                        a.a(strArrA[i3].substring(0, iIndexOf), strArrA[i3].substring(iIndexOf + 1, strArrA[i3].length()));
                    }
                }
            }
        } catch (Exception unused) {
        }
        t = a.a(l);
        u = a.a(m);
        v = a.a(n);
        f58a = a.a(q, true);
        f59b = a.a(r, true);
        f60c = a.a(s, true);
        a.f9a.remove(l);
        a.f9a.remove(m);
        a.f9a.remove(n);
        a.f9a.remove(q);
        a.f9a.remove(r);
        a.f9a.remove(s);
        w = new StringBuffer().append(A).append(B).append("yc").append(f62e ? "h" : "").toString();
        C = null;
        f74c = null;
        f75a = null;
        f73g = true;
        d();
        f();
        if (a.a(j) == null) {
            f61d = false;
            return;
        }
        f61d = true;
        if (!f59b || f71d[0].length() == 0 || f71d[1].length() == 0) {
            f71d[0] = a.a(j);
            f71d[1] = a.a(k);
        }
    }

    public static final boolean a() {
        return f73g;
    }

    public static final boolean b() {
        return C != null && C.equals(f71d[0]);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static f m25a() {
        if (!b()) {
            return null;
        }
        if (f75a == null) {
            f fVar = new f(f71d[0], f71d[1], null, null);
            f75a = fVar;
            fVar.f68a = f74c;
        }
        return f75a;
    }

    public static f a(boolean z2) throws f {
        if (!f73g) {
            return null;
        }
        if (!f58a) {
            z2 = false;
        }
        f fVar = new f();
        if (!f61d || f59b) {
            if (!fVar.a(z2 ? (byte) 1 : (byte) 0)) {
                return null;
            }
        } else {
            fVar.f64a[0] = f71d[0];
            fVar.f64a[1] = f71d[1];
            if (!(fVar.f64a[0] != null && fVar.f64a[0].length() > 0 && fVar.f64a[1] != null && fVar.f64a[1].length() > 0)) {
                return null;
            }
        }
        if (z2) {
            int i2 = -1;
            try {
                String strA = fVar.a(d);
                String strA2 = fVar.a(e);
                byte[] bArrA = fVar.a(u, "register", new StringBuffer().append((strA == null || strA.length() <= 0) ? "" : new StringBuffer().append("&email=").append(strA).toString()).append((strA2 == null || strA2.length() <= 0) ? "" : new StringBuffer().append("&phone=").append(strA2).toString()).toString(), 0);
                if (bArrA != null) {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                    int i3 = dataInputStream.readInt();
                    i2 = i3;
                    if (i3 == 0) {
                        fVar.f68a.clear();
                        fVar.f68a.put(c, new byte[f63a]);
                        fVar.m38a(dataInputStream.readUTF());
                    }
                    dataInputStream.close();
                }
            } catch (Exception unused) {
            } finally {
                fVar.m39a(i2);
                if (fVar.f67c == 0) {
                    if (fVar.a(a) == null) {
                        fVar.f68a.put(a, "0");
                    }
                    fVar.e();
                }
            }
        } else {
            fVar.m27b();
        }
        return fVar;
    }

    public static boolean c() throws f {
        if (!f73g) {
            return false;
        }
        f fVar = new f();
        if (!fVar.a((byte) 2)) {
            return false;
        }
        int i2 = -1;
        try {
            byte[] bArrA = fVar.a(u, "auth_mail", (String) null, 2);
            if (bArrA != null) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                int i3 = dataInputStream.readInt();
                i2 = i3;
                if (i3 == 0) {
                    fVar.m38a(dataInputStream.readUTF());
                }
                dataInputStream.close();
            }
            return true;
        } catch (Exception unused) {
            return true;
        } finally {
            fVar.m39a(i2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m26a() {
        f75a = null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private void m27b() throws f {
        int i2 = -1;
        try {
            byte[] bArrA = a(u, "auth", "&get_achievements", 1);
            if (bArrA != null) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                int i3 = dataInputStream.readInt();
                i2 = i3;
                if (i3 == 0) {
                    try {
                        if (dataInputStream.readInt() > 0) {
                            byte[] bArr = new byte[f63a];
                            for (int i4 = 0; i4 < f63a; i4++) {
                                bArr[i4] = (byte) dataInputStream.read();
                            }
                            this.f68a.put(c, bArr);
                        }
                        m38a(dataInputStream.readUTF());
                    } catch (Exception unused) {
                        i2 = 1000019;
                    }
                }
                dataInputStream.close();
            }
        } catch (Exception unused2) {
        } finally {
            m39a(i2);
            if (this.f67c == 0) {
                e();
            }
        }
    }

    public final String[] a(String str, String str2, int i2, int i3) throws f {
        int i4 = -1;
        String[] strArr = null;
        try {
            byte[] bArrA = a(t, "list", new StringBuffer().append("&fields=").append(b(str)).append("&sort=").append(str2).append(new StringBuffer().append("&offset=").append(0).append("&count=").append(1000).toString()).toString(), 1);
            if (bArrA != null) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                int i5 = dataInputStream.readInt();
                i4 = i5;
                if (i5 == 0) {
                    try {
                        strArr = new String[dataInputStream.readInt()];
                        for (int i6 = 0; i6 < strArr.length; i6++) {
                            strArr[i6] = dataInputStream.readUTF();
                        }
                        m38a(dataInputStream.readUTF());
                    } catch (Exception unused) {
                        i4 = 1000010;
                    }
                }
                dataInputStream.close();
            }
        } catch (Exception unused2) {
        } finally {
            m39a(i4);
        }
        return strArr;
    }

    public final byte[] a(int i2) throws f {
        int i3 = -1;
        byte[] bArr = null;
        try {
            byte[] bArrA = a(t, "download", new StringBuffer().append("&id=").append(i2).toString(), 1);
            if (bArrA != null) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                int i4 = dataInputStream.readInt();
                i3 = i4;
                if (i4 == 0) {
                    try {
                        bArr = new byte[dataInputStream.readInt()];
                        dataInputStream.readFully(bArr);
                        m38a(dataInputStream.readUTF());
                    } catch (Exception unused) {
                        i3 = 1000011;
                    }
                }
                dataInputStream.close();
            }
        } catch (Exception unused2) {
        } finally {
            m39a(i3);
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final int m28a(boolean z2) throws f {
        Object objA;
        int i2 = 0;
        if (f62e) {
            objA = f70b.get(this.f64a[0]);
        } else {
            if (z2 || a(a) == null) {
                m27b();
            }
            objA = a(a);
        }
        try {
            i2 = Integer.parseInt(objA.toString());
        } catch (Exception unused) {
        }
        this.f68a.put(a, new StringBuffer().append("").append(i2).toString());
        return i2;
    }

    private int b(boolean z2) throws f {
        int i2 = -1;
        if (a(f54b) == null) {
            m27b();
        }
        try {
            i2 = Integer.parseInt(a(f54b));
        } catch (Exception unused) {
        }
        return i2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final String m29a() {
        return f62e ? "" : new StringBuffer().append("").append(b(false)).toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final int m30a(int i2) {
        int iM28a = 0;
        if (f62e) {
            try {
                iM28a = m28a(false);
            } catch (f unused) {
            }
            int i3 = iM28a + i2;
            iM28a = i3;
            if (i3 < 0) {
                iM28a = 0;
            }
            f70b.put(this.f64a[0], new StringBuffer().append("").append(iM28a).toString());
            m35c();
        }
        return iM28a;
    }

    public final byte[] a(byte[] bArr) throws f {
        int i2 = -1;
        byte[] bArr2 = new byte[f63a];
        try {
            byte[] bArrA = a(u, "achievements", (bArr == null || bArr.length != f63a) ? "" : new StringBuffer().append("&achievements=").append(b(new String(b.a(bArr)))).toString(), 1);
            if (bArrA != null) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArrA));
                int i3 = dataInputStream.readInt();
                i2 = i3;
                if (i3 == 0) {
                    try {
                        if (dataInputStream.readInt() > 0) {
                            for (int i4 = 0; i4 < f63a; i4++) {
                                bArr2[i4] = (byte) dataInputStream.read();
                            }
                        }
                        this.f68a.put(c, bArr2);
                        m38a(dataInputStream.readUTF());
                    } catch (Exception unused) {
                        i2 = 1000013;
                    }
                }
                dataInputStream.close();
            }
        } catch (Exception unused2) {
        } finally {
            m39a(i2);
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m31a(int i2) throws f {
        byte[] bArrA = a((byte[]) null);
        if (bArrA[i2] == 1) {
            return false;
        }
        bArrA[i2] = 1;
        a(bArrA);
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final byte[] m32a(boolean z2) throws f {
        if (this.f68a.get(c) == null) {
            a((byte[]) null);
        }
        byte[] bArr = (byte[]) this.f68a.get(c);
        byte[] bArr2 = bArr;
        if (bArr == null || bArr2.length != f63a) {
            bArr2 = new byte[f63a];
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final String m33b() {
        String strA = a.a(o);
        String strA2 = strA;
        if (strA != null) {
            String strA3 = a.a(a.a(strA2, "[L]", b(this.f64a[0])), "[P]", b(this.f64a[1]));
            strA2 = strA3;
            if (strA3.indexOf("[PP]") >= 0) {
                String strM36a = null;
                try {
                    strM36a = m36a(true);
                } catch (Exception unused) {
                }
                this.f68a.remove(f);
                strA2 = a.a(strA2, "[PP]", strM36a);
            }
        }
        return strA2;
    }

    private String a(String str) {
        return (String) this.f68a.get(str);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.y;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final int m34a() {
        return this.f67c;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private static void m35c() {
        if (f73g) {
            try {
                try {
                    RecordStore.deleteRecordStore(w);
                } catch (Exception unused) {
                }
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(w, true);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                a(dataOutputStream, f71d[0]);
                a(dataOutputStream, f71d[1]);
                dataOutputStream.writeInt(f76d);
                if (f62e) {
                    dataOutputStream.writeByte(f70b.size());
                    Enumeration enumerationKeys = f70b.keys();
                    while (enumerationKeys.hasMoreElements()) {
                        String str = (String) enumerationKeys.nextElement();
                        a(dataOutputStream, str);
                        a(dataOutputStream, f70b.get(str).toString());
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                dataOutputStream.close();
                recordStoreOpenRecordStore.addRecord(byteArray, 0, byteArray.length);
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Exception unused2) {
            }
        }
    }

    private static void d() {
        byte b2;
        if (f73g) {
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(w, true);
                if (recordStoreOpenRecordStore.getNumRecords() > 0) {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(recordStoreOpenRecordStore.getRecord(1)));
                    try {
                        f71d[0] = a(dataInputStream);
                        f71d[1] = a(dataInputStream);
                        f76d = dataInputStream.readInt();
                        if (f62e && (b2 = dataInputStream.readByte()) > 0) {
                            f70b.clear();
                            for (int i2 = 0; i2 < b2; i2++) {
                                f70b.put(a(dataInputStream), a(dataInputStream));
                            }
                        }
                    } catch (Exception unused) {
                    }
                    dataInputStream.close();
                }
                recordStoreOpenRecordStore.closeRecordStore();
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m36a(boolean z2) throws Exception {
        String strM37b = m37b(z2);
        if (strM37b != null) {
            return e.m23a(a(new StringBuffer().append(strM37b).append(this.f64a[1]).toString(), false));
        }
        return null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private String m37b(boolean z2) throws Exception {
        String strA = a(f);
        long j2 = 0;
        try {
            j2 = Long.parseLong(a(g));
        } catch (Exception unused) {
        }
        if (z2 || strA == null || Math.abs(System.currentTimeMillis() - j2) > 600000) {
            strA = null;
            this.f68a.remove(f);
            this.f68a.remove(g);
            byte[] bArrA = a(v, (String) null, (String) null, 2);
            if (bArrA != null) {
                strA = new String(bArrA);
                this.f68a.put(f, strA);
                this.f68a.put(g, new StringBuffer().append("").append(System.currentTimeMillis()).toString());
            }
        }
        return strA;
    }

    private byte[] a(String str, String str2, String str3, int i2) throws Exception {
        String string;
        if (!f73g || str == null) {
            return null;
        }
        String strA = a.a(p);
        String str4 = strA;
        if (strA != null && str4.trim().length() == 0) {
            str4 = null;
        }
        String strB = null;
        if (i2 == 0) {
            strB = b(this.f64a[1]);
        } else if (i2 == 1) {
            String strM36a = m36a(false);
            strB = strM36a;
            if (strM36a == null) {
                throw new Exception();
            }
        }
        StringBuffer stringBufferAppend = new StringBuffer().append("login=").append(b(this.f64a[0]));
        if (str == v) {
            string = "";
        } else {
            string = new StringBuffer().append("&app=").append(b(A)).append("&language=").append(z).append("&uid=").append(f76d).append("&game_id=").append(B).append(strB == null ? "" : new StringBuffer().append("&password=").append(strB).toString()).append(f62e ? new StringBuffer().append("&ec=").append(m28a(false)).toString() : "").toString();
        }
        String string2 = stringBufferAppend.append(string).append(str2 == null ? "" : new StringBuffer().append("&action=").append(str2).toString()).append(str4 == null ? "" : new StringBuffer().append("&system=").append(str4).toString()).append(str3 == null ? "" : str3).toString();
        byte[] bytes = null;
        if (x == "GET") {
            str = new StringBuffer().append(str).append(str.indexOf("?") == -1 ? "?" : "&").append(string2).toString();
        } else {
            bytes = string2.getBytes();
        }
        byte[] bArrA = a(str, x, bytes);
        if (this.f69f || i2 != 1 || bArrA == null || bArrA.length <= 3 || bArrA[3] != 12) {
            return bArrA;
        }
        this.f68a.remove(f);
        try {
            this.f69f = true;
            return a(str, str2, str3, i2);
        } finally {
            this.f69f = false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m38a(String str) {
        if (str != null) {
            for (String str2 : a.a(str, ';')) {
                String[] strArrA = a.a(str2, ':');
                if (strArrA != null && strArrA.length == 2) {
                    Hashtable hashtable = this.f68a;
                    String strTrim = strArrA[0].trim();
                    strArrA[0] = strTrim;
                    String strTrim2 = strArrA[1].trim();
                    strArrA[1] = strTrim2;
                    hashtable.put(strTrim, strTrim2);
                    if (f.equals(strArrA[0])) {
                        this.f68a.put(g, new StringBuffer().append("").append(System.currentTimeMillis()).toString());
                    } else if (f62e) {
                        if ((C != null && C.equals(this.f64a[0])) && a.equals(strArrA[0])) {
                            try {
                                int iM28a = m28a(false);
                                f70b.put(this.f64a[0], strArrA[1]);
                                if (iM28a != m28a(false)) {
                                    m35c();
                                }
                            } catch (f unused) {
                            }
                        }
                    }
                }
            }
        }
    }

    private final void e() {
        C = this.f64a[0];
        f74c = this.f68a;
        f71d[0] = this.f64a[0];
        f71d[1] = this.f64a[1];
        if (f62e) {
            f70b.put(this.f64a[0], a(a));
        }
        m35c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m39a(int i2) throws f {
        this.y = null;
        this.f67c = i2;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        if (i2 == 3 || i2 == 12 || i2 == 1 || i2 == -1) {
            this.f68a.remove(f);
        }
        try {
            this.y = f65b[i2];
        } catch (Exception unused) {
        }
        if (this.y == null || this.y.length() <= 0) {
            this.y = new StringBuffer().append("").append(i2).toString();
        }
        throw this;
    }

    private static final void f() {
        try {
            String appProperty = f72a.getAppProperty(new StringBuffer().append(new String(f55a)).append("P").toString());
            String string = appProperty;
            if (appProperty == null) {
                InputStream inputStreamM4a = null;
                try {
                    inputStreamM4a = a.m4a(new String(f57c));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int i2 = inputStreamM4a.read();
                        if (i2 == -1) {
                            break;
                        } else {
                            stringBuffer.append((char) i2);
                        }
                    }
                    string = stringBuffer.toString();
                    if (inputStreamM4a != null) {
                        try {
                            inputStreamM4a.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    if (inputStreamM4a != null) {
                        try {
                            inputStreamM4a.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    if (inputStreamM4a != null) {
                        try {
                            inputStreamM4a.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            if (string == null) {
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(m40a(string)));
            while (true) {
                try {
                    a.a(dataInputStream.readUTF(), dataInputStream.readUTF());
                } catch (Exception unused5) {
                    return;
                }
            }
        } catch (Exception unused6) {
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static byte[] m40a(String str) {
        byte[] bArrM11a = b.m11a(str);
        byte[] bArr = new byte[bArrM11a.length];
        byte b2 = 49;
        for (int i2 = 0; i2 < bArrM11a.length; i2++) {
            bArr[i2] = (byte) (b2 ^ bArrM11a[i2]);
            b2 = bArrM11a[i2];
        }
        return bArr;
    }

    private static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        String string;
        byte[] bArrA = a(str, false);
        int i2 = b;
        if (bArrA == null) {
            string = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer(2 * bArrA.length);
            for (byte b2 : bArrA) {
                byte b3 = (byte) (b2 ^ i2);
                stringBuffer.append(D.charAt((b3 & 240) >> 4)).append(D.charAt(b3 & 15));
            }
            string = stringBuffer.toString();
        }
        dataOutputStream.writeUTF(string);
    }

    private static String a(DataInputStream dataInputStream) {
        return new DataInputStream(new ByteArrayInputStream(a(dataInputStream.readUTF(), b, true))).readUTF();
    }

    public static byte[] a(String str, String str2, byte[] bArr) {
        byte[] byteArray = null;
        Connection connection = null;
        DataInputStream dataInputStreamOpenDataInputStream = null;
        try {
            try {
                HttpConnection httpConnectionOpen = Connector.open(str, 3);
                httpConnectionOpen.setRequestMethod(str2);
                if (str2 == "POST") {
                    httpConnectionOpen.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
                }
                httpConnectionOpen.setRequestProperty("Connection", "close");
                if (bArr != null) {
                    DataOutputStream dataOutputStreamOpenDataOutputStream = httpConnectionOpen.openDataOutputStream();
                    dataOutputStreamOpenDataOutputStream.write(bArr);
                    dataOutputStreamOpenDataOutputStream.close();
                }
                if (httpConnectionOpen.getResponseCode() == 200) {
                    int length = (int) httpConnectionOpen.getLength();
                    dataInputStreamOpenDataInputStream = httpConnectionOpen.openDataInputStream();
                    if (length < 0) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                        while (true) {
                            int i2 = dataInputStreamOpenDataInputStream.read();
                            if (i2 < 0) {
                                break;
                            }
                            dataOutputStream.write(i2);
                        }
                        byteArray = byteArrayOutputStream.toByteArray();
                    } else if (length > 0) {
                        byteArray = new byte[length];
                        dataInputStreamOpenDataInputStream.readFully(byteArray);
                    }
                }
                if (dataInputStreamOpenDataInputStream != null) {
                    dataInputStreamOpenDataInputStream.close();
                }
                if (httpConnectionOpen != null) {
                    httpConnectionOpen.close();
                }
                return byteArray;
            } catch (Exception e2) {
                throw null;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                dataInputStreamOpenDataInputStream.close();
            }
            if (0 != 0) {
                connection.close();
            }
            throw th;
        }
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('A' <= cCharAt && cCharAt <= 'Z') {
                stringBuffer.append(cCharAt);
            } else if ('a' <= cCharAt && cCharAt <= 'z') {
                stringBuffer.append(cCharAt);
            } else if ('0' <= cCharAt && cCharAt <= '9') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == ' ') {
                stringBuffer.append('+');
            } else if (cCharAt == '-' || cCharAt == '_' || cCharAt == '.' || cCharAt == '!' || cCharAt == '~' || cCharAt == '*' || cCharAt == '\'' || cCharAt == '(' || cCharAt == ')') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt <= 127) {
                stringBuffer.append(f85f[cCharAt]);
            } else if (cCharAt <= 2047) {
                stringBuffer.append(f85f[192 | (cCharAt >> 6)]);
                stringBuffer.append(f85f[128 | (cCharAt & '?')]);
            } else {
                stringBuffer.append(f85f[224 | (cCharAt >> '\f')]);
                stringBuffer.append(f85f[128 | ((cCharAt >> 6) & 63)]);
                stringBuffer.append(f85f[128 | (cCharAt & '?')]);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m41a() {
        String[] strArr = new String[256];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            stringBuffer.setLength(0);
            stringBuffer.append('%');
            stringBuffer.append(D.charAt((i2 & 240) >> 4));
            stringBuffer.append(D.charAt(i2 & 15));
            strArr[i2] = stringBuffer.toString();
        }
        return strArr;
    }

    private static int b(int i2) {
        if (i2 >= 48 && i2 <= 57) {
            return i2 - 48;
        }
        if (i2 >= 65 && i2 <= 90) {
            return (i2 - 65) + 10;
        }
        if (i2 < 97 || i2 > 122) {
            return 0;
        }
        return (i2 - 97) + 10;
    }

    public static byte[] a(String str, int i2, boolean z2) {
        int i3 = 0;
        int length = str.length() >> 1;
        if (z2) {
            i3 = 2;
        }
        byte[] bArr = new byte[length + i3];
        if (z2) {
            bArr[0] = (byte) ((length >> 8) & 255);
            bArr[1] = (byte) length;
        }
        int i4 = 0;
        int i5 = i3;
        while (i4 < str.length()) {
            bArr[i5] = (byte) ((((b(str.charAt(i4)) << 4) & 240) | (b(str.charAt(i4 + 1)) & 15)) ^ i2);
            i4 += 2;
            i5++;
        }
        return bArr;
    }

    private static byte[] a(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        byte[] byteArray = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeUTF(str);
            byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
        byte[] bArr = new byte[byteArray.length - 2];
        System.arraycopy(byteArray, 2, bArr, 0, bArr.length);
        return bArr;
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (displayable == this.f79a) {
            if (command != this.f81a) {
                if (command == this.f82b) {
                    this.f83e = null;
                    this.f78e = 2;
                    return;
                }
                return;
            }
            this.f83e = new String[this.f79a.size() - (this.f84f == 2 ? 0 : 1)];
            for (int i2 = 0; i2 < this.f83e.length; i2++) {
                this.f83e[i2] = this.f79a.get(i2).getString().trim();
            }
            if (this.f83e[0].length() <= 0 || ((this.f84f != 2 && this.f83e[1].length() <= 0) || !(this.f84f == 0 || this.f84f == 2 || this.f83e[1].equals(this.f83e[2])))) {
                this.f83e = null;
            } else {
                this.f78e = 1;
            }
        }
    }

    public final void itemStateChanged(Item item) {
        if (item != this.f80a || this.f79a == null || this.f84f == 2) {
            return;
        }
        f77h = this.f80a.isSelected(0);
        int i2 = 1;
        while (true) {
            if (i2 >= (this.f84f == 0 ? 2 : 3)) {
                return;
            }
            try {
                TextField textField = this.f79a.get(i2);
                textField.setConstraints(f77h ? textField.getConstraints() & (-65537) : textField.getConstraints() | 65536);
            } catch (Exception unused) {
            }
            i2++;
        }
    }

    private boolean a(byte b2) {
        this.f78e = 0;
        this.f84f = b2;
        String str = null;
        String str2 = null;
        String str3 = null;
        if (b2 == 0) {
            str = f66c[0];
            str2 = f71d[0];
            str3 = f71d[1];
        } else if (b2 == 1) {
            str = f66c[1];
            str2 = "";
            str3 = "";
        } else if (b2 == 2) {
            str = f66c[9];
            str2 = this.f64a[0];
        }
        this.f79a = new Form(str);
        TextField textField = new TextField(new StringBuffer().append(f66c[4]).append("*").toString(), str2, 25, 786432 | (f61d ? 131072 : 0));
        textField.setLayout(2049);
        this.f79a.append(textField);
        if (b2 == 0 || b2 == 1) {
            TextField textField2 = new TextField(new StringBuffer().append(f66c[5]).append("*").toString(), str3, 25, 786432 | (f77h ? 0 : 65536));
            textField2.setLayout(2049);
            this.f79a.append(textField2);
        }
        if (b2 == 1) {
            TextField textField3 = new TextField(new StringBuffer().append(f66c[6]).append("*").toString(), "", 25, 786432 | (f77h ? 0 : 65536));
            textField3.setLayout(2049);
            this.f79a.append(textField3);
        }
        if (b2 == 1) {
            TextField textField4 = new TextField(f66c[7], "", 25, 786433);
            textField4.setLayout(2049);
            this.f79a.append(textField4);
        }
        if (b2 == 1) {
            TextField textField5 = new TextField(f66c[10], "", 12, 786435);
            textField5.setLayout(2049);
            this.f79a.append(textField5);
        }
        if (b2 == 0 || b2 == 1) {
            this.f80a = new ChoiceGroup((String) null, 2, new String[]{f66c[8]}, (Image[]) null);
            this.f80a.setLayout(2049);
            this.f80a.setSelectedIndex(0, f77h);
            this.f79a.append(this.f80a);
        }
        boolean z2 = f77h;
        this.f81a = new Command(f66c[2], 4, 1);
        this.f82b = new Command(f66c[3], 3, 2);
        this.f79a.addCommand(this.f81a);
        this.f79a.addCommand(this.f82b);
        this.f79a.setCommandListener(this);
        this.f79a.setItemStateListener(this);
        Display display = Display.getDisplay(f72a);
        Displayable current = display.getCurrent();
        Thread.yield();
        display.setCurrent(this.f79a);
        while (this.f78e == 0) {
            a.a(30L);
        }
        display.setCurrent(current);
        this.f79a = null;
        this.f80a = null;
        this.f82b = null;
        this.f81a = null;
        a.e();
        if (this.f78e != 1 || this.f83e == null) {
            f77h = z2;
            return false;
        }
        if (b2 == 0) {
            this.f64a[0] = this.f83e[0];
            this.f64a[1] = this.f83e[1];
            return true;
        }
        if (b2 != 1) {
            if (b2 != 2) {
                return true;
            }
            this.f64a[0] = this.f83e[0];
            return true;
        }
        this.f64a[0] = this.f83e[0];
        this.f64a[1] = this.f83e[1];
        this.f68a.put(d, this.f83e[3]);
        this.f68a.put(e, this.f83e[4]);
        return true;
    }

    static {
        new StringBuffer().append(h).append("uid").toString();
        j = new StringBuffer().append(h).append("l").toString();
        k = new StringBuffer().append(h).append("p").toString();
        l = new StringBuffer().append(i).append("url_ugc").toString();
        m = new StringBuffer().append(i).append("url_users").toString();
        n = new StringBuffer().append(i).append("url_sess").toString();
        o = new StringBuffer().append(i).append("url_prof").toString();
        p = new StringBuffer().append(i).append("sys").toString();
        q = new StringBuffer().append(i).append("isreg").toString();
        r = new StringBuffer().append(i).append("islog").toString();
        s = new StringBuffer().append(i).append("isinfo").toString();
        f58a = false;
        f59b = false;
        f60c = false;
        f61d = false;
        f62e = false;
        f63a = 0;
        t = null;
        u = null;
        v = null;
        byte[][] bArr = {new byte[]{104, 116, 116, 112, 58, 47, 47, 119, 97, 112, 46, 104, 101, 114, 111, 99, 114, 97, 102, 116, 46, 99, 111, 109, 47}, new byte[]{117, 103, 99, 47, 97, 112, 105}, new byte[]{117, 115, 101, 114, 115, 47, 97, 112, 105}, new byte[]{97, 112, 105, 47, 103, 101, 116, 95, 115, 101, 115, 115, 105, 111, 110}, new byte[]{104, 101, 114, 111, 101, 115, 47}, new byte[]{47, 63, 97, 112, 112, 61, 49, 38, 112, 97, 115, 115, 119, 111, 114, 100, 61}, new byte[]{38, 108, 111, 103, 105, 110, 61}};
        f65b = null;
        f66c = null;
        w = null;
        x = "GET";
        f70b = new Hashtable();
        f71d = new String[]{"", ""};
        f72a = null;
        z = null;
        A = null;
        B = null;
        f73g = false;
        C = null;
        f74c = null;
        f75a = null;
        f76d = (int) (System.currentTimeMillis() & 2147483647L);
        f77h = false;
        D = "0123456789ABCDEF";
        f85f = m41a();
    }
}
