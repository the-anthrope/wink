package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:d.class */
public final class d implements Runnable {
    private static int a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile Image f30a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile String f31a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile boolean f32a = false;
    private static int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final int[] f33a = {0, 0, 0, 0};
    private static int c = 0;
    private static int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f34a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static long f35b = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static long f36c = 0;
    private static int e = 0;
    private static int f = 0;
    private static int g = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f37b = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f38b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static String f39c = null;
    private static int h = 0;
    private static int i = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final int[] f40b = {-1, -1};
    private static int j = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static volatile boolean f41c = false;
    private static volatile int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f42a = new Object();
    private static int l = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Vector f43a = new Vector();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static boolean f44d = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static boolean f45e = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static final Object f46b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static final Object f47c = new Object();

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static boolean f48f = true;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private static boolean f49g = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f50a = {104, 116, 116, 112, 58, 47, 47, 119, 97, 112, 46, 104, 101, 114, 111, 99, 114, 97, 102, 116, 46, 99, 111, 109, 47, 101, 120, 116, 101, 114, 110, 97, 108, 47, 97, 112, 105, 47, 103, 101, 116, 95, 115, 108, 105, 100, 101, 115, 104, 111, 119};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    private boolean f51h;

    private d(boolean z) {
        this.f51h = false;
        this.f51h = z;
    }

    public static final void a(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        h = i2;
        i = i3;
        a = h > i ? 0 : 1;
        f38b = str == null ? new String(f50a) : str;
        f38b = new StringBuffer().append(f38b).append(f38b.indexOf("?") == -1 ? "?" : "&").append("width=").append(h).toString();
        f38b = new StringBuffer().append(f38b).append("&port=").append(i4).toString();
        f38b = new StringBuffer().append(f38b).append("&prod=").append(i5).toString();
        f39c = str2;
        c = 0;
        d = 0;
        synchronized (f43a) {
            f43a.removeAllElements();
            f44d = false;
            f45e = false;
        }
        a();
    }

    public static final void a() {
        if (j != -1) {
            return;
        }
        b();
        j = 0;
        if (!f44d) {
            f44d = true;
            new Thread(new d(true)).start();
            Thread.yield();
        }
        synchronized (f47c) {
            f41c = true;
        }
        new Thread(new d(false)).start();
        Thread.yield();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final synchronized int m16a() {
        return j;
    }

    public static final void b() {
        b(-1);
        f41c = false;
        k = 0;
        l = -1;
        f32a = false;
        f30a = null;
        f31a = null;
        b = 0;
        f34a = 0L;
        f48f = true;
        f49g = false;
        f();
    }

    private static void e() {
        f32a = false;
        f34a = System.currentTimeMillis();
        k++;
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.microedition.lcdui.Graphics] */
    public static final void a(Graphics graphics) {
        ?? M17a = m17a();
        if (M17a != 0) {
            try {
                M17a = graphics;
                M17a.drawImage(f30a, f33a[0] + c, f33a[1] + d, 20);
            } catch (Exception e2) {
                M17a.printStackTrace();
            }
        }
    }

    public static String a(int i2, int i3) {
        String str = null;
        try {
            if (m16a() == 1 && f32a && f31a != null && f31a.trim().length() > 0 && b != 0 && i2 >= f33a[0] + c && i2 <= f33a[0] + c + f33a[2] && i3 >= f33a[1] + d && i3 <= f33a[1] + d + f33a[3]) {
                str = f31a;
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [int[], java.lang.Throwable] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m17a() {
        boolean z;
        boolean zA = false;
        if (j == 1) {
            ?? r0 = f33a;
            synchronized (r0) {
                try {
                    switch (b) {
                        case 0:
                            if ((Math.abs(System.currentTimeMillis() - f34a) >= 3000 || f49g) && f32a && !f48f) {
                                f49g = false;
                                f33a[2] = f30a.getWidth();
                                f33a[3] = f30a.getHeight();
                                if (a == 0 || a == 1) {
                                    g = 1;
                                    f33a[0] = (h - f33a[2]) >> 1;
                                    if (a == 0) {
                                        f33a[1] = -(f33a[3] + 1);
                                        e = 0;
                                        f37b = true;
                                    } else {
                                        f33a[1] = i + 1;
                                        e = i - f33a[3];
                                        f37b = false;
                                    }
                                    f = f33a[1];
                                } else {
                                    g = 0;
                                    switch (a) {
                                        case 2:
                                            f33a[0] = -(f33a[2] + 1);
                                            f33a[1] = 0;
                                            f = h + 1;
                                            f37b = true;
                                            break;
                                        case 3:
                                            f33a[0] = -(f33a[2] + 1);
                                            f33a[1] = i - f33a[3];
                                            f = h + 1;
                                            f37b = true;
                                            break;
                                        case 4:
                                            f33a[0] = h + 1;
                                            f33a[1] = 0;
                                            f = -(f33a[2] + 1);
                                            f37b = false;
                                            break;
                                        case 5:
                                            f33a[0] = h + 1;
                                            f33a[1] = i - f33a[3];
                                            f = -(f33a[2] + 1);
                                            f37b = false;
                                            break;
                                    }
                                    e = (h - f33a[2]) >> 1;
                                }
                                f36c = 0L;
                                b = 2;
                                z = true;
                            } else {
                                z = false;
                            }
                            zA = z;
                            break;
                        case 1:
                            if ((Math.abs(System.currentTimeMillis() - f34a) >= 10000 && f43a.size() > 1) || f48f) {
                                e = f;
                                f36c = 0L;
                                boolean z2 = a != 0 && (a == 1 || a == 2 || a == 3);
                                f37b = z2;
                                b = 3;
                            }
                            zA = true;
                            break;
                        case 2:
                            zA = a(true);
                            break;
                        case 3:
                            zA = a(false);
                        default:
                            break;
                    }
                } catch (Exception e2) {
                    r0.printStackTrace();
                }
            }
        }
        return zA && f32a;
    }

    private static final boolean a(boolean z) {
        f35b = 3 + (f36c / 10);
        f36c += 5;
        int[] iArr = f33a;
        int i2 = g;
        iArr[i2] = (int) (((long) iArr[i2]) + (f37b ? f35b : -f35b));
        if ((!f37b || f33a[g] < e) && (f37b || f33a[g] > e)) {
            return true;
        }
        f34a = System.currentTimeMillis();
        f33a[g] = e;
        if (z) {
            b = 1;
            return true;
        }
        b = 0;
        e();
        return false;
    }

    public static final void c() {
        f48f = true;
    }

    public static final void d() {
        if (f48f) {
            f49g = true;
            f48f = false;
        }
    }

    private static void f() {
        synchronized (f42a) {
            f42a.notify();
        }
        Thread.yield();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static Vector m18a() {
        try {
            byte[] bArrA = f.a(f38b, "GET", (byte[]) null);
            if (bArrA == null) {
                return null;
            }
            m mVar = new m();
            mVar.a(new InputStreamReader(new ByteArrayInputStream(bArrA)));
            String[] strArr = null;
            Vector vector = new Vector();
            while (true) {
                int iM67a = mVar.m67a();
                if (iM67a == 1) {
                    break;
                }
                if (iM67a == 2) {
                    if ("slideshow".equals(mVar.m66b())) {
                        try {
                            f40b[0] = Integer.parseInt(mVar.a((String) null, "width"));
                            f40b[1] = Integer.parseInt(mVar.a((String) null, "height"));
                        } catch (Exception unused) {
                        }
                    } else if ("slide".equals(mVar.m66b())) {
                        String[] strArr2 = new String[4];
                        strArr = strArr2;
                        strArr2[0] = mVar.a((String) null, "game_id");
                        strArr[1] = mVar.a((String) null, "link");
                        strArr[2] = mVar.a((String) null, "src");
                        strArr[3] = mVar.a((String) null, "timestamp");
                    }
                } else if (iM67a == 3 && "slide".equals(mVar.m66b()) && strArr != null) {
                    vector.addElement(strArr);
                    strArr = null;
                }
            }
            if (vector.size() > 0) {
                return vector;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static boolean a(int i2) {
        try {
            if (f43a.size() <= i2) {
                return false;
            }
            String[] strArr = (String[]) f43a.elementAt(i2);
            byte[] bArrM20a = m20a(Integer.parseInt(strArr[2]));
            f30a = Image.createImage(bArrM20a, 0, bArrM20a.length);
            f31a = strArr[1];
            return (f30a == null || f31a == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static Vector m19b() {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(m20a(-1)));
            int i2 = dataInputStream.readInt();
            if (i2 <= 0) {
                return null;
            }
            Vector vector = new Vector(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                String[] strArr = new String[4];
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    strArr[i4] = dataInputStream.readUTF();
                }
                vector.addElement(strArr);
            }
            dataInputStream.close();
            return vector;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Vector vector) {
        RecordStore recordStore = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int size = vector.size();
            dataOutputStream.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                String[] strArr = (String[]) vector.elementAt(i2);
                int i3 = 0;
                while (i3 < strArr.length) {
                    dataOutputStream.writeUTF(i3 == 1 ? "" : strArr[i3]);
                    i3++;
                }
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            m21a(-1);
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(f39c, true);
            recordStore = recordStoreOpenRecordStore;
            recordStoreOpenRecordStore.addRecord(byteArray, 0, byteArray.length);
            if (recordStore != null) {
                try {
                    recordStore.closeRecordStore();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            if (recordStore != null) {
                try {
                    recordStore.closeRecordStore();
                } catch (Exception unused2) {
                    throw th;
                }
            }
            throw th;
        }
    }

    private static int a(byte[] bArr) throws Exception {
        RecordStore recordStore = null;
        for (int i2 = 0; i2 < 15; i2++) {
            try {
                RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(new StringBuffer().append(f39c).append("i").append(i2).toString(), true);
                recordStore = recordStoreOpenRecordStore;
                if (recordStoreOpenRecordStore.getNumRecords() == 0) {
                    recordStore.addRecord(bArr, 0, bArr.length);
                    int i3 = i2;
                    if (recordStore != null) {
                        try {
                            recordStore.closeRecordStore();
                        } catch (Exception unused) {
                        }
                    }
                    return i3;
                }
                if (recordStore != null) {
                    try {
                        recordStore.closeRecordStore();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                if (recordStore != null) {
                    try {
                        recordStore.closeRecordStore();
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                throw th;
            }
        }
        throw new Exception();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static byte[] m20a(int i2) {
        RecordStore recordStore = null;
        try {
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(new StringBuffer().append(f39c).append(i2 >= 0 ? new StringBuffer().append("i").append(i2).toString() : "").toString(), false);
            RecordStore recordStore2 = recordStoreOpenRecordStore;
            return recordStoreOpenRecordStore.getRecord(1);
        } finally {
            if (recordStore != null) {
                try {
                    recordStore.closeRecordStore();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m21a(int i2) {
        try {
            RecordStore.deleteRecordStore(new StringBuffer().append(f39c).append(i2 >= 0 ? new StringBuffer().append("i").append(i2).toString() : "").toString());
        } catch (Exception unused) {
        }
    }

    private static final void g() {
        for (int i2 = -1; i2 < 15; i2++) {
            m21a(i2);
        }
    }

    private static synchronized void b(int i2) {
        if (j != -1) {
            j = i2;
        }
    }

    private static void h() {
        synchronized (f43a) {
            if (!f45e || f43a.size() > 0) {
                if (m16a() == 0 && f43a.size() > 0) {
                    b(1);
                }
                if (m16a() == 1 && k == 0) {
                    e();
                    f49g = true;
                }
            } else {
                b(2);
            }
        }
        while (true) {
            if ((j != 0 && j != 1) || !f41c) {
                return;
            }
            if (k <= 0) {
                synchronized (f42a) {
                    try {
                        f42a.wait();
                        if (!f41c) {
                            return;
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
            synchronized (f43a) {
                if (k > 0) {
                    f32a = false;
                    while (k > 0) {
                        int i2 = l + 1;
                        l = i2;
                        if (i2 >= f43a.size()) {
                            l = 0;
                        }
                        k--;
                    }
                    if (!a(l)) {
                        k++;
                    } else if (k <= 0) {
                        f32a = true;
                    }
                }
            }
            Thread.yield();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f51h) {
            synchronized (f47c) {
                h();
            }
            return;
        }
        synchronized (f46b) {
            try {
                Vector vectorM18a = m18a();
                if (vectorM18a != null) {
                    Vector vectorM19b = m19b();
                    Vector vector = vectorM19b;
                    if (vectorM19b == null) {
                        synchronized (f43a) {
                            g();
                            vector = null;
                            f43a.removeAllElements();
                        }
                    }
                    Vector vector2 = new Vector();
                    for (int i2 = 0; i2 < vectorM18a.size(); i2++) {
                        String[] strArr = (String[]) vectorM18a.elementAt(i2);
                        boolean z = false;
                        for (int i3 = 0; vector != null && i3 < vector.size(); i3++) {
                            try {
                                String[] strArr2 = (String[]) vector.elementAt(i3);
                                if (strArr2[0].equals(strArr[0]) && strArr2[3].equals(strArr[3]) && Integer.parseInt(strArr2[2]) >= 0) {
                                    strArr[2] = strArr2[2];
                                    z = true;
                                    break;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if (z) {
                            synchronized (f43a) {
                                f43a.addElement(strArr);
                                a(f43a);
                                if (m16a() == 0) {
                                    b(1);
                                    e();
                                    f49g = true;
                                }
                            }
                        } else {
                            vector2.addElement(strArr);
                        }
                    }
                    for (int i4 = 0; i4 < 15; i4++) {
                        boolean z2 = true;
                        for (int i5 = 0; i5 < f43a.size(); i5++) {
                            if (i4 == Integer.parseInt(((String[]) f43a.elementAt(i5))[2])) {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2) {
                            synchronized (f43a) {
                                m21a(i4);
                            }
                        }
                        Thread.yield();
                    }
                    for (int i6 = 0; i6 < vector2.size(); i6++) {
                        String[] strArr3 = (String[]) vector2.elementAt(i6);
                        byte[] bArr = null;
                        for (int i7 = 0; i7 < 2; i7++) {
                            try {
                                byte[] bArrA = f.a(strArr3[2], "GET", (byte[]) null);
                                bArr = bArrA;
                                if (bArrA != null) {
                                    break;
                                }
                            } catch (Exception unused2) {
                                Thread.yield();
                            }
                        }
                        if (bArr != null) {
                            strArr3[2] = new StringBuffer().append("").append(a(bArr)).toString();
                            synchronized (f43a) {
                                f43a.addElement(strArr3);
                                a(f43a);
                                if (m16a() == 0) {
                                    b(1);
                                    e();
                                    f49g = true;
                                }
                            }
                            Thread.yield();
                        }
                    }
                }
            } catch (Exception e2) {
                synchronized (f43a) {
                    g();
                    f43a.removeAllElements();
                    e2.printStackTrace();
                }
            }
            b(f43a.size() > 0 ? 1 : 2);
            f45e = true;
        }
    }
}
