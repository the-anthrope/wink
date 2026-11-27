package defpackage;

import java.io.DataInputStream;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:i.class */
public final class i {
    private Image[] a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int[][] f264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[][] f265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f268a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static int[] f269a = {199474, 155452, 183318, 99657, 150160};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static final byte[] f270a = {90, 76, 80};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    static final byte[] f271b = {89, 85, 72};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    static final byte[] f272c = {80, 90, 68};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    static final byte[] f273d = {65, 83, 83};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f274b = false;
    private int c = 0;
    private int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f266a = 0;
    public int b = 16777215;
    private int e = 0;
    private int f = 0;

    private i() {
    }

    public static i a(String str, int i, int i2) {
        i iVar = new i();
        i iVar2 = iVar;
        iVar.e = 0;
        if (!f268a) {
            try {
                iVar2.f267a = new String[2];
                iVar2.a = new Image[2];
                iVar2.f264a = new int[2][];
                iVar2.f265a = new byte[2][];
                for (int i3 = 0; i3 < 2; i3++) {
                    iVar2.a[i3] = Image.createImage(new StringBuffer().append(str).append("_").append(i3).append("p").toString());
                    StringBuffer stringBuffer = new StringBuffer();
                    DataInputStream dataInputStreamA = a.a(a.m4a(new StringBuffer().append(str).append("_").append(i3).toString()));
                    try {
                        byte b = dataInputStreamA.readByte();
                        if (i3 == 0) {
                            iVar2.d = dataInputStreamA.readByte();
                        } else {
                            dataInputStreamA.readByte();
                        }
                        iVar2.f264a[i3] = new int[b + 1];
                        iVar2.f265a[i3] = new byte[b + 1];
                        for (int i4 = 0; i4 < b; i4++) {
                            stringBuffer.append(dataInputStreamA.readUTF());
                            iVar2.f265a[i3][i4] = dataInputStreamA.readByte();
                            if (iVar2.c < iVar2.f265a[i3][i4]) {
                                iVar2.c = iVar2.f265a[i3][i4];
                            }
                            iVar2.f264a[i3][i4 + 1] = iVar2.f264a[i3][i4] + iVar2.f265a[i3][i4];
                        }
                        dataInputStreamA.close();
                        iVar2.f267a[i3] = stringBuffer.toString();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (iVar2.a == null || iVar2.a[0] == null) {
                    iVar2 = null;
                }
            }
        }
        if (!f274b) {
            f269a[3] = a.m8a();
            f274b = true;
        }
        return iVar2;
    }

    public final void a(Graphics graphics, String str, int i, int i2, int i3) {
        int iA = i2 + this.f266a;
        if (f268a) {
            try {
                this.f = graphics.getColor();
                graphics.setColor(this.b);
                graphics.drawString(str, i, iA, i3);
                graphics.setColor(this.f);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        int clipX = graphics.getClipX();
        int clipY = graphics.getClipY();
        int clipWidth = graphics.getClipWidth();
        int clipHeight = graphics.getClipHeight();
        if ((i3 & 1) == 1) {
            i -= a(str) >> 1;
        } else if ((i3 & 8) == 8) {
            i -= a(str);
        }
        if ((i3 & 64) == 64 || (i3 & 2) == 2) {
            iA -= a() >> 1;
        } else if ((i3 & 32) == 32) {
            iA -= a();
        }
        int i4 = -1;
        int i5 = i;
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (str.charAt(i6) == ' ') {
                i5 = i5 + (this.f265a[0][0] - 2) + this.d;
            } else {
                for (int i7 = 0; i7 < this.f267a.length; i7++) {
                    if (this.f267a[i7] != null) {
                        int iIndexOf = this.f267a[i7].indexOf(str.charAt(i6));
                        i4 = iIndexOf;
                        if (iIndexOf != -1) {
                            graphics.setClip(i5, iA, this.f265a[i7][i4], this.a[i7].getHeight());
                            graphics.drawImage(this.a[i7], i5 - this.f264a[i7][i4], iA, 20);
                            i5 = i5 + this.f265a[i7][i4] + this.e + this.d;
                            break;
                        }
                    }
                }
                graphics.setClip(clipX, clipY, clipWidth, clipHeight);
                if (i4 == -1) {
                    System.out.println(new StringBuffer().append("Not_found: ").append(str.charAt(i6)).toString());
                }
            }
        }
    }

    public final int a() {
        return f268a ? Font.getDefaultFont().getHeight() : this.a[0].getHeight();
    }

    public final int a(String str) {
        int iIndexOf;
        if (f268a) {
            return Font.getDefaultFont().stringWidth(str);
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != ' ') {
                for (int i3 = 0; i3 < this.f267a.length; i3++) {
                    if (this.f267a[i3] != null && (iIndexOf = this.f267a[i3].indexOf(str.charAt(i2))) != -1) {
                        i = i + this.f265a[i3][iIndexOf] + this.e + this.d;
                        break;
                    }
                }
            } else {
                i = i + (this.f265a[0][0] - 2) + this.d;
            }
        }
        return i;
    }
}
