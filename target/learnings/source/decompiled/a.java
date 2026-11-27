package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:a.class */
public final class a {
    private static final byte[] a = {89, 67, 80, 82, 80};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static aow2 f0a = null;
    private static String i = null;
    private static String j = "1.0.0";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f1a = "1.0.0";
    public static String b = null;
    public static String c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f3b = false;
    public static String d = null;
    public static String e = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String[] f4a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String[] f5b = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    public static String f = null;
    public static String g = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int f6a = 1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f7c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f8d = false;
    private static String n = "JADPRP-";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Hashtable f9a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static byte[] f10b = {65, 114, 116, 79, 102, 87, 97, 114, 50};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static byte[] f11c = {97, 114, 116, 111, 102, 119, 97, 114, 50};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private static final byte[] f12d = {104, 116, 116, 112, 58, 47, 47, 117, 112, 100, 97, 116, 101, 46, 104, 101, 114, 111, 99, 114, 97, 102, 116, 46, 99, 111, 109, 47, 106, 97, 100, 47};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static byte[] f13e = {119, 105, 114, 101, 108, 101, 115, 115, 46, 109, 101, 115, 115, 97, 103, 105, 110, 103, 46, 115, 109, 115, 46, 115, 109, 115, 99};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String[] f14c = null;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static byte[] f15f = {85, 77, 71, 68};
    public static String h = null;

    public static void a(aow2 aow2Var) {
        f0a = aow2Var;
        k.f364a = new String((byte[]) k.f364a);
        h = new String(f15f);
    }

    public static void a() {
        boolean z = a(new String(new byte[]{83, 77, 83, 95, 74, 65, 86, 65}), 0) > 0;
        f3b = z;
        if (z) {
            String strM5c = m5c();
            i = strM5c;
            if (strM5c != null && i.startsWith("+")) {
                i = i.substring(1);
            }
            e = b("TAFSMS");
            String[] strArrM1a = m1a(a("UNLKS"), i);
            f4a = strArrM1a;
            if (strArrM1a != null) {
                f4a[2] = a(f4a[2], "[USER_AGENT]", a("SMSUA"));
            }
            String[] strArrM1a2 = m1a(a("ADDMS"), i);
            f5b = strArrM1a2;
            if (strArrM1a2 != null) {
                f5b[2] = a(f5b[2], "[USER_AGENT]", a("SMSUA"));
                try {
                    f6a = Integer.parseInt(new String(f.a(a("ADDCRD"), k.f361i, false)));
                } catch (Exception unused) {
                }
                o.f384a[3][34] = a(o.f384a[3][34], "[CRD]", new StringBuffer().append("").append(f6a).toString());
            }
        }
        boolean zA = a("WAP_JAVA", false);
        f2a = zA;
        if (zA) {
            d = m3b();
            String strB = b("UMG");
            b = strB;
            if (strB != null && !b.startsWith(new String(g.f255r))) {
                a("UMG", new StringBuffer().append(n).append(b).toString());
                b = b("UMG");
            }
            c = b;
            f8d = a("SSAD", false);
            if (!g.m52a() && a("HCOC", false) && f5b != null) {
                String str = new String(a);
                String str2 = a(str) == null ? null : new String(f.a(a(str), k.f361i, false));
                f9a.remove(str);
                f.a(f0a, new String[]{o.f384a[1][50], o.f384a[3][23], o.f384a[3][24], o.f384a[3][25], o.f384a[3][26], o.f384a[3][27], o.f384a[3][28], o.f384a[3][29], null, null, o.f384a[3][44], null, null, o.f384a[3][49]}, new String[]{o.f384a[3][14], o.f384a[3][15], o.f384a[3][2], o.f384a[3][3], o.f384a[3][16], o.f384a[3][17], o.f384a[3][39], o.f384a[3][40], o.f384a[3][45], o.f384a[3][46], o.f384a[3][48]}, m, new String(f11c), k, a("HCOCG", false), a("HCOCL", false), 2, str2);
                if (f.f62e) {
                    d = null;
                }
            }
        }
        try {
            f14c = m7a(b("YAY"));
        } catch (Exception unused2) {
        }
    }

    public static void b() {
        try {
            a("/sn8p", true, "SL");
        } catch (IOException unused) {
        }
        System.gc();
        a(10L);
        Vector vector = new Vector(200);
        for (int i2 = 0; i2 < o.f384a.length; i2++) {
            int i3 = 0;
            while (true) {
                String string = new StringBuffer().append("T").append(i2).append("_").append(i3).toString();
                Object obj = f9a.get(string);
                if (obj != null) {
                    f9a.remove(string);
                    vector.addElement(obj);
                    i3++;
                }
            }
            o.f384a[i2] = a(vector);
            vector.removeAllElements();
            System.gc();
            a(10L);
        }
        k = a("GAME_ID");
        l = a("PROV_ID");
        m = a("LANG_ID");
        f = a("PROD_ID");
        g = a("PORT_ID");
        f7c = a("SP", false);
        i.f268a = a("DEFFNT", false);
        e();
        if (a("gmgPlayerX", 0) == 1) {
            boolean z = false;
            String strSubstring = "";
            try {
                DataInputStream dataInputStream = new DataInputStream(m4a("/GMG/GMG_settings.txt"));
                while (true) {
                    try {
                        String strA = a(dataInputStream, false);
                        if (strA == null) {
                            break;
                        }
                        int iIndexOf = strA.indexOf(58);
                        if (iIndexOf >= 0) {
                            String strSubstring2 = strA.substring(0, iIndexOf);
                            if (strSubstring2.equals("GMG-Mode")) {
                                String strSubstring3 = strA.substring(iIndexOf + 2, strA.length());
                                if (strSubstring3.equals("Off")) {
                                    z = false;
                                } else if (strSubstring3.equals("On")) {
                                    z = true;
                                }
                            }
                            if (strSubstring2.equals("GMG-URL")) {
                                strSubstring = strA.substring(iIndexOf + 2, strA.length());
                            }
                        }
                    } catch (EOFException unused2) {
                    }
                }
                dataInputStream.close();
            } catch (Exception unused3) {
            }
            String appProperty = f0a.getAppProperty("GMG-Mode");
            String property = appProperty;
            if (appProperty == null) {
                property = System.getProperty("GMG-Mode");
            }
            if (property != null) {
                if (property.equals("Off")) {
                    z = false;
                } else if (property.equals("On")) {
                    String appProperty2 = f0a.getAppProperty("GMG-URL");
                    String property2 = appProperty2;
                    if (appProperty2 == null) {
                        property2 = System.getProperty("GMG-URL");
                    }
                    if (property2 != null) {
                        z = true;
                        strSubstring = property2;
                    }
                }
            }
            if (!z || strSubstring.length() <= 0) {
                a("UMG", "");
            } else {
                a("UMG", strSubstring);
            }
        }
    }

    public static final void c() {
        k.f361i += 2;
        String appProperty = f0a.getAppProperty("MIDlet-Version");
        if (appProperty != null) {
            j = appProperty;
        }
        f1a = j;
        if (l != null) {
            f1a = new StringBuffer().append(f1a).append(" (").append(l).append(")").toString();
        }
    }

    public static void d() {
        f0a = null;
    }

    public static final String a(DataInputStream dataInputStream, boolean z) {
        if (z) {
            return dataInputStream.readUTF();
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                byte b2 = dataInputStream.readByte();
                if (b2 == 13) {
                    break;
                }
                stringBuffer.append((char) b2);
            } catch (Exception unused) {
            }
        }
        dataInputStream.readByte();
        if (stringBuffer.length() > 0) {
            return stringBuffer.toString();
        }
        return null;
    }

    public static void a(String str, boolean z, String str2) {
        boolean zEquals = "SO".equals(str2);
        boolean zEquals2 = "SL".equals(str2);
        if (f9a.size() == 0) {
            f9a.put(f0a, new String(g.f257t));
            f9a.put(k.f364a, k.f362a);
            g.f262a = f9a;
        }
        DataInputStream dataInputStreamA = a(m4a(str));
        if (dataInputStreamA != null) {
            while (true) {
                try {
                    String strA = a(dataInputStreamA, true);
                    if (strA == null) {
                        break;
                    }
                    int iIndexOf = strA.indexOf(58);
                    if (iIndexOf >= 0) {
                        String strSubstring = strA.substring(0, iIndexOf);
                        String strSubstring2 = strA.substring(iIndexOf + 2, strA.length());
                        boolean z2 = strSubstring.charAt(0) == 'T' && strSubstring.charAt(2) == '_';
                        if (zEquals) {
                            if (z2) {
                                break;
                            }
                        } else if (z2) {
                            if (!zEquals2) {
                                if (strSubstring.endsWith(str2)) {
                                    strSubstring = strSubstring.substring(0, strSubstring.length() - str2.length());
                                }
                            }
                        }
                        f9a.put(strSubstring, strSubstring2);
                    }
                } catch (EOFException unused) {
                    if (dataInputStreamA != null) {
                        dataInputStreamA.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (dataInputStreamA != null) {
                        dataInputStreamA.close();
                    }
                    throw th;
                }
            }
            if (dataInputStreamA != null) {
                dataInputStreamA.close();
            }
        }
    }

    public static String a(String str) {
        String str2 = (String) f9a.get(str);
        String appProperty = str2;
        if (str2 != null && appProperty.startsWith(n)) {
            try {
                appProperty = f0a.getAppProperty(appProperty.substring(n.length()).trim());
            } catch (Throwable unused) {
                appProperty = null;
            }
        }
        return appProperty;
    }

    public static int a(String str, int i2) {
        try {
            if (str == p.f525a[3]) {
                f0a.a.f338a.f527d -= f0a.a.f338a.f527d;
            }
        } catch (Exception unused) {
        }
        String strA = a(str);
        int i3 = i2;
        if (strA != null) {
            try {
                i3 = Integer.parseInt(strA);
            } catch (Exception unused2) {
            }
        }
        return i3;
    }

    public static boolean a(String str, boolean z) {
        String strA = a(str);
        boolean z2 = z;
        if (strA != null) {
            z2 = "true".equals(strA) || "TRUE".equals(strA) || "1".equals(strA);
        }
        return z2;
    }

    public static void a(String str, String str2) {
        f9a.put(str, str2);
    }

    public static String b(String str) {
        String strA = a(str);
        String str2 = strA;
        if (strA != null && str2.trim().length() <= 0) {
            str2 = null;
        }
        return str2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m1a(String str, String str2) {
        String[] strArrA;
        String[] strArr = null;
        if (str == null || (strArrA = a(str, '%')) == null || strArrA.length != 4) {
            return null;
        }
        String[] strArrA2 = a(strArrA[0], '|');
        String[] strArrA3 = a(strArrA[1], '|');
        String[] strArrA4 = a(strArrA[2], '|');
        String[] strArrA5 = a(strArrA[3], '|');
        int length = strArrA2.length;
        if (strArrA3.length != length || strArrA4.length != length || strArrA5.length != length) {
            return null;
        }
        if (strArrA2.length == 1) {
            if (strArrA3[0].length() > 0 && strArrA4[0].length() > 0 && strArrA5[0].length() > 0) {
                strArr = new String[]{null, strArrA3[0], strArrA4[0], strArrA5[0]};
            }
        } else if (str2 != null && str2.length() > 0) {
            for (int i2 = 0; i2 < strArrA2.length; i2++) {
                if (str2.startsWith(strArrA2[i2])) {
                    if (strArrA3[i2].length() <= 0 || strArrA4[i2].length() <= 0 || strArrA5[i2].length() <= 0) {
                        break;
                        break;
                        break;
                    }
                    strArr = new String[]{strArrA2[i2], strArrA3[i2], strArrA4[i2], strArrA5[i2]};
                    break;
                }
            }
        }
        if (strArr != null) {
            try {
                String appProperty = f0a.getAppProperty("HC-MP-suffix");
                if (appProperty != null && appProperty.length() > 0) {
                    String[] strArr2 = strArr;
                    strArr2[2] = new StringBuffer().append(strArr2[2]).append(" ").append(appProperty).toString();
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    public static Vector a(int i2, String str, i iVar) {
        int i3;
        char[] cArr = {'.', '-', ',', '@', '/', ':'};
        String strReplace = str.replace('&', '\n');
        Vector vector = new Vector();
        if (i2 <= 0) {
            return vector;
        }
        int i4 = -1;
        boolean z = false;
        do {
            if (z) {
                z = false;
                i3 = i4;
                i4--;
            } else {
                try {
                    i3 = i4 + 1;
                } catch (Exception unused) {
                }
            }
            do {
                int iIndexOf = strReplace.indexOf(" ", i4 + 1);
                int length = iIndexOf != -1 ? iIndexOf : strReplace.length();
                int iIndexOf2 = strReplace.indexOf("\n", i4 + 1);
                int length2 = iIndexOf2 != -1 ? iIndexOf2 : strReplace.length();
                int i5 = length2;
                if (length2 < length) {
                    length = i5;
                }
                if (iVar.a(strReplace.substring(i3, length)) > i2) {
                    if (i4 >= i3) {
                        break;
                    }
                    int i6 = 0;
                    while (i3 + i6 < strReplace.length() && iVar.a(strReplace.substring(i3, i3 + i6)) < i2) {
                        i6++;
                    }
                    String strSubstring = strReplace.substring(i3, (i3 + i6) - 1);
                    int i7 = i6 - 1;
                    while (i7 > 0) {
                        for (char c2 : cArr) {
                            if (strSubstring.charAt(i7 - 1) == c2) {
                                i6 = i7 + 1;
                                i7 = 0;
                                break;
                            }
                        }
                        i7--;
                    }
                    i4 = i3 + (i6 - 1);
                    z = true;
                    break;
                }
                int i8 = length;
                i4 = i8;
                if (i8 == i5) {
                    break;
                }
            } while (i4 != strReplace.length());
            vector.addElement(strReplace.substring(i3, i4));
        } while (i4 < strReplace.length());
        return vector;
    }

    public static String a(String str, String str2, String str3) {
        String string;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            string = str;
            return string;
        }
        if (str3 == null) {
            string = str;
            str3 = "";
        }
        string = str;
        while (true) {
            try {
                int iIndexOf = string.indexOf(str2);
                if (iIndexOf < 0) {
                    break;
                }
                string = new StringBuffer().append(string.substring(0, iIndexOf)).append(str3).append(string.substring(iIndexOf + str2.length())).toString();
            } catch (Exception unused) {
            }
        }
        return string;
    }

    public static String[] a(String str, char c2) {
        int i2 = 1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == c2) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        while (true) {
            i2--;
            if (i2 <= 0) {
                strArr[0] = str;
                return strArr;
            }
            strArr[i2] = str.substring(str.lastIndexOf(c2) + 1);
            str = str.substring(0, str.lastIndexOf(c2));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m2a(String str) {
        boolean zPlatformRequest;
        if (str == null) {
            return false;
        }
        a(20L);
        try {
            zPlatformRequest = f0a.platformRequest(str);
        } catch (Exception unused) {
            zPlatformRequest = false;
        }
        return zPlatformRequest;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static String m3b() {
        if (!a("SPRT", false) || k == null || l == null || m == null) {
            return null;
        }
        try {
            String strB = b("SPRTURL");
            String str = strB;
            if (strB == null) {
                str = new String(f12d);
            }
            String str2 = new String(f10b);
            long jCurrentTimeMillis = System.currentTimeMillis();
            return new StringBuffer().append(str).append(b.a(new StringBuffer().append("id=").append(k).append("&lng=").append(m).append("&p=").append(l).append("&port=").append(e.a(new StringBuffer().append(str2).append(k).append(m).append(l).append(jCurrentTimeMillis).append(j).toString())).append("&ts=").append(jCurrentTimeMillis).append("&v=").append(j).toString())).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static InputStream m4a(String str) {
        if (f0a == null) {
            return null;
        }
        return f0a.getClass().getResourceAsStream(str);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private static String m5c() {
        String property = null;
        try {
            property = System.getProperty(new String(f13e));
        } catch (Throwable unused) {
        }
        return property;
    }

    public static void a(long j2) {
        if (j2 < 3) {
            j2 = 3;
        }
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    public static void e() {
        System.gc();
        a(50L);
    }

    public static final DataInputStream a(InputStream inputStream) {
        if (!a("BUFRD", false)) {
            return new DataInputStream(inputStream);
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            } catch (IOException unused) {
            }
        }
        return new DataInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    public static String[] a(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static int[] m6a(Vector vector) {
        int size = vector.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Integer) vector.elementAt(i2)).intValue();
        }
        return iArr;
    }

    public static final String a(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        String utf = null;
        try {
            utf = new DataInputStream(new ByteArrayInputStream(bArr)).readUTF();
        } catch (IOException unused) {
        }
        return utf;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m7a(String str) {
        String[] strArr = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(f.a(str, k.f361i, true));
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            String utf = dataInputStream.readUTF();
            try {
                dataInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception unused) {
            }
            String[] strArrA = a(utf, '|');
            if (strArrA.length > 7) {
                String[] strArr2 = new String[6];
                strArr = strArr2;
                strArr2[0] = strArrA[0];
                strArr[1] = strArrA[1];
                if (f3b) {
                    strArr[4] = strArrA[5];
                    strArr[5] = strArrA[6];
                } else {
                    strArr[4] = strArrA[7];
                }
                if (strArrA.length == 10) {
                    String str2 = i;
                    String strSubstring = str2;
                    if (str2 == null) {
                        return null;
                    }
                    if (strSubstring.startsWith("+")) {
                        strSubstring = strSubstring.substring(1);
                    }
                    String[] strArrA2 = a(strArrA[3], ';');
                    String[] strArrA3 = a(strArrA[4], ';');
                    String[] strArrA4 = a(strArrA[8], ';');
                    String[] strArrA5 = a(strArrA[9], ';');
                    for (int i2 = 0; i2 < strArrA4.length; i2++) {
                        if (strSubstring.startsWith(strArrA4[i2])) {
                            strArr[1] = new StringBuffer().append(strArr[1]).append(strArrA2[i2]).append(" (").append(strArrA5[i2]).append(").").toString();
                            if (f3b) {
                                strArr[1] = new StringBuffer().append(strArr[1]).append(" ").append(strArrA[2]).toString();
                            }
                            strArr[2] = strArrA2[i2];
                            strArr[3] = strArrA3[i2];
                            return strArr;
                        }
                    }
                    return null;
                }
                if (f3b) {
                    strArr[1] = new StringBuffer().append(strArr[1]).append(" ").append(strArrA[2]).toString();
                    strArr[2] = strArrA[3];
                    strArr[3] = strArrA[4];
                }
            }
            return strArr;
        } catch (Exception unused2) {
            try {
                dataInputStream.close();
                byteArrayInputStream.close();
                return null;
            } catch (Exception unused3) {
                return null;
            }
        } catch (Throwable th) {
            try {
                dataInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception unused4) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    static int m8a() {
        int iM51a = g.m51a();
        String str = (String) f9a.get(new String(i.f273d));
        if (str == null) {
            int i2 = -iM51a;
            f9a.put(new String(g.f250m), new StringBuffer().append("").append(i2).toString());
            return i2;
        }
        try {
            String str2 = new String(g.f250m);
            String appProperty = f0a.getAppProperty(str2);
            String str3 = new String(f.a(str, k.f360h, false));
            int i3 = 0;
            boolean zEquals = str3.equals(new String(g.f254q));
            boolean z = zEquals;
            if (zEquals) {
                return iM51a;
            }
            if (appProperty.startsWith(new String(g.f255r)) && appProperty.startsWith(new String(g.f255r))) {
                if (appProperty.startsWith(new String(g.f255r))) {
                    appProperty = appProperty.substring(g.f255r.length);
                }
                if (appProperty.startsWith(new String(g.f256s))) {
                    appProperty = appProperty.substring(g.f256s.length);
                }
                String[] strArrA = a(appProperty, '/');
                for (String str4 : a(str3, '$')) {
                    if (strArrA[0].indexOf(str4) >= 0) {
                        z = true;
                        break;
                    }
                }
            }
            byte[] bArr = new byte[appProperty.length()];
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                if (i5 >= str2.length()) {
                    i5 = 0;
                }
                bArr[i4] = (byte) (str2.charAt(i5) & appProperty.charAt(i4));
                if (bArr[i4] == 0) {
                    i3++;
                }
                i4++;
                i5++;
            }
            if (z) {
                iM51a = (-(i3 * str2.length())) - iM51a;
            }
            f9a.put(str2, new StringBuffer().append("").append(iM51a).toString());
        } catch (Exception unused) {
        }
        return iM51a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m9a() {
        String string = "a";
        for (int i2 = 0; i2 < p.f525a.length; i2++) {
            string = new StringBuffer().append(string).append(a(p.f525a[i2], i2 + 3) > 0 ? 1 : 0).toString();
        }
        return string;
    }
}
