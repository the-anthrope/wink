package defpackage;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:e.class */
public final class e {
    private int a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static int[] f52a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static char[] f53a;

    private long a() {
        return ((long) this.a) & 4294967295L;
    }

    private void a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = this.a;
        int i3 = -1;
        while (true) {
            int i4 = i2 ^ i3;
            length--;
            if (length < 0) {
                this.a = i4 ^ (-1);
                return;
            }
            int i5 = i;
            i++;
            i2 = f52a[(i4 ^ bArr[i5]) & 255];
            i3 = i4 >>> 8;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final String m23a(byte[] bArr) {
        e eVar = new e();
        eVar.a = 0;
        eVar.a(bArr);
        return new String(new char[]{f53a[(int) (Math.abs(eVar.a()) % ((long) f53a.length))], f53a[(int) ((Math.abs(eVar.a()) >> 9) % ((long) f53a.length))], f53a[(int) ((Math.abs(eVar.a()) >> 18) % ((long) f53a.length))]});
    }

    public static long a(String str) {
        e eVar = new e();
        eVar.a = 0;
        eVar.a(str.getBytes());
        return eVar.a();
    }

    static {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            int i3 = 8;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    i2 = (i2 & 1) != 0 ? (-306674912) ^ (i2 >>> 1) : i2 >>> 1;
                }
            }
            iArr[i] = i2;
        }
        f52a = iArr;
        f53a = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }
}
