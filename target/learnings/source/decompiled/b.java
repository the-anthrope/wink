package defpackage;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:b.class */
public final class b {
    private static char[] a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static byte[] f18a;

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static char[] a(byte[] bArr) {
        int i;
        int i2;
        int length = bArr.length;
        int i3 = ((length << 2) + 2) / 3;
        char[] cArr = new char[((length + 2) / 3) << 2];
        int i4 = 0;
        int i5 = length + 0;
        int i6 = 0;
        while (i4 < i5) {
            int i7 = i4;
            i4++;
            int i8 = bArr[i7] & 255;
            if (i4 < i5) {
                i4++;
                i = bArr[i4] & 255;
            } else {
                i = 0;
            }
            int i9 = i;
            if (i4 < i5) {
                int i10 = i4;
                i4++;
                i2 = bArr[i10] & 255;
            } else {
                i2 = 0;
            }
            int i11 = i2;
            int i12 = i8 >>> 2;
            int i13 = ((i8 & 3) << 4) | (i9 >>> 4);
            int i14 = ((i9 & 15) << 2) | (i11 >>> 6);
            int i15 = i11 & 63;
            int i16 = i6;
            int i17 = i6 + 1;
            cArr[i16] = a[i12];
            int i18 = i17 + 1;
            cArr[i17] = a[i13];
            cArr[i18] = i18 < i3 ? a[i14] : '=';
            int i19 = i18 + 1;
            cArr[i19] = i19 < i3 ? a[i15] : '=';
            i6 = i19 + 1;
        }
        return cArr;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m11a(String str) {
        char c;
        char c2;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (length > 0 && charArray[(length + 0) - 1] == '=') {
            length--;
        }
        int i = (length * 3) / 4;
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = length + 0;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2;
            int i6 = i2 + 1;
            char c3 = charArray[i5];
            i2 = i6 + 1;
            char c4 = charArray[i6];
            if (i2 < i3) {
                i2++;
                c = charArray[i2];
            } else {
                c = 'A';
            }
            char c5 = c;
            if (i2 < i3) {
                int i7 = i2;
                i2++;
                c2 = charArray[i7];
            } else {
                c2 = 'A';
            }
            char c6 = c2;
            if (c3 > 127 || c4 > 127 || c5 > 127 || c6 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = f18a[c3];
            byte b2 = f18a[c4];
            byte b3 = f18a[c5];
            byte b4 = f18a[c6];
            if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i8 = (b << 2) | (b2 >>> 4);
            int i9 = ((b2 & 15) << 4) | (b3 >>> 2);
            int i10 = ((b3 & 3) << 6) | b4;
            int i11 = i4;
            i4++;
            bArr[i11] = (byte) i8;
            if (i4 < i) {
                i4++;
                bArr[i4] = (byte) i9;
            }
            if (i4 < i) {
                int i12 = i4;
                i4++;
                bArr[i12] = (byte) i10;
            }
        }
        return bArr;
    }

    private b() {
    }

    static {
        System.getProperty("line.separator");
        a = new char[64];
        int i = 0;
        char c = 'A';
        while (true) {
            char c2 = c;
            if (c2 > 'Z') {
                break;
            }
            int i2 = i;
            i++;
            a[i2] = c2;
            c = (char) (c2 + 1);
        }
        char c3 = 'a';
        while (true) {
            char c4 = c3;
            if (c4 > 'z') {
                break;
            }
            int i3 = i;
            i++;
            a[i3] = c4;
            c3 = (char) (c4 + 1);
        }
        char c5 = '0';
        while (true) {
            char c6 = c5;
            if (c6 > '9') {
                break;
            }
            int i4 = i;
            i++;
            a[i4] = c6;
            c5 = (char) (c6 + 1);
        }
        a[i] = '+';
        a[i + 1] = '/';
        f18a = new byte[128];
        for (int i5 = 0; i5 < f18a.length; i5++) {
            f18a[i5] = -1;
        }
        for (int i6 = 0; i6 < 64; i6++) {
            f18a[a[i6]] = (byte) i6;
        }
    }
}
