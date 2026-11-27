package defpackage;

import javax.microedition.lcdui.Canvas;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:c.class */
public final class c implements Runnable, PlayerListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f20a;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private boolean f21c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Player[] f22a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Player f23a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Player f24b;
    private int g;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private boolean f25d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    private static boolean f26e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private static boolean f27f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f29a;
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f19b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f28a = false;

    public c(String[] strArr, int i) {
        this(null, null, strArr, i, false);
    }

    private c(MIDlet mIDlet, Canvas canvas, String[] strArr, int i, boolean z) {
        this.f21c = false;
        this.g = 1;
        this.f29a = new Object();
        f = i;
        if (i < 0 || f > e) {
            f = 0;
        }
        f19b = false;
        this.f22a = new Player[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.f22a[i2] = a(strArr[i2]);
        }
        if (f < d) {
            this.f25d = true;
            this.f20a = new Thread(this);
            this.f20a.setPriority(1);
            this.f20a.start();
        }
    }

    private void c() {
        synchronized (this.f29a) {
            this.f29a.notify();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (this.f25d) {
            if (!this.f21c) {
                synchronized (this.f29a) {
                    try {
                        this.f29a.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                if (!this.f25d) {
                    return;
                }
            }
            if (this.f21c && a(this.f24b)) {
                this.f21c = false;
                this.f24b = null;
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException unused2) {
            }
        }
    }

    public final void playerUpdate(Player player, String str, Object obj) {
        if (str.equals("endOfMedia") || str.equals("stopped")) {
            if (this.g != -1) {
                int i = this.g - 1;
                this.g = i;
                if (i <= 0) {
                    return;
                }
            }
            try {
                this.f24b = player;
                this.f21c = true;
                if (f > c) {
                    a(this.f24b);
                } else {
                    c();
                }
            } catch (Exception unused) {
            }
        }
    }

    private static Player a(String str) {
        Player playerCreatePlayer = null;
        String[] strArr = {"audio/midi", "audio/mmf", "audio/mpeg", "audio/amr", "audio/x-wav"};
        String[] strArr2 = {"m", "f", "3", "a", "w"};
        if (f26e) {
            strArr = new String[]{"audio/mpeg", "audio/midi", "audio/amr", "audio/x-wav", "audio/mmf"};
            strArr2 = new String[]{"3", "m", "a", "w", "f"};
        } else if (f27f) {
            strArr = new String[]{"audio/amr", "audio/midi", "audio/x-wav", "audio/mmf", "audio/mpeg"};
            strArr2 = new String[]{"a", "m", "w", "f", "3"};
        }
        for (int i = 0; playerCreatePlayer == null && i < strArr.length; i++) {
            try {
                playerCreatePlayer = Manager.createPlayer(a.m4a(new StringBuffer().append(str).append(strArr2[i]).toString()), strArr[i]);
                if (f == 0 || f == e) {
                    playerCreatePlayer.prefetch();
                }
                playerCreatePlayer.realize();
            } catch (Exception unused) {
            }
        }
        return playerCreatePlayer;
    }

    public final boolean a() {
        if (this.f23a != null) {
            return this.g == -1 || this.f23a.getState() == 400;
        }
        return false;
    }

    public final int a(int i, int i2) {
        if (!f28a || this.f22a[0] == null) {
            return -1;
        }
        if (f == b) {
            m13a();
        }
        this.g = -1;
        this.f24b = this.f22a[0];
        this.f21c = true;
        if (f > c) {
            return !a(this.f24b) ? -1 : 0;
        }
        c();
        return 0;
    }

    private boolean a(Player player) {
        if (!f19b && this.f23a != null && this.f23a.getState() == 400) {
            return false;
        }
        if (f == b) {
            try {
                player.prefetch();
            } catch (Exception unused) {
                this.f23a = player;
                m13a();
                return false;
            }
        } else if (f == c || f == d) {
            if (player != this.f23a) {
                m13a();
                try {
                    player.prefetch();
                } catch (Exception unused2) {
                    this.f23a = player;
                    m13a();
                    return false;
                }
            } else if (player.getState() == 400) {
                try {
                    player.stop();
                    player.setMediaTime(0L);
                } catch (Exception unused3) {
                    this.f23a = player;
                    m13a();
                    return false;
                }
            }
        }
        try {
            if (f == b || f == c) {
                try {
                    if (this.g == -1 || this.g > 1) {
                        player.removePlayerListener(this);
                        player.addPlayerListener(this);
                    }
                } catch (Exception unused4) {
                }
            } else {
                player.setLoopCount(this.g);
            }
            player.start();
            this.f23a = player;
            return true;
        } catch (Exception unused5) {
            this.f23a = player;
            m13a();
            return false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m13a() {
        this.f21c = false;
        if (this.f23a != null) {
            this.g = 1;
            if (f == b || f == c) {
                this.f23a.removePlayerListener(this);
            }
            if (this.f23a.getState() == 400) {
                try {
                    this.f23a.stop();
                } catch (MediaException unused) {
                }
            }
            if ((f == b || f == c || f == d) && this.f23a.getState() == 300) {
                this.f23a.deallocate();
            }
            this.f23a = null;
        }
    }

    public final void b() {
        m13a();
        this.f25d = false;
        for (int i = 0; i < this.f22a.length; i++) {
            if (this.f22a[i] != null) {
                try {
                    if (this.f22a[i].getState() == 400) {
                        this.f22a[i].stop();
                    }
                    if (this.f22a[i].getState() == 300) {
                        this.f22a[i].deallocate();
                    }
                    if (this.f22a[i].getState() == 200 || this.f22a[i].getState() == 100) {
                        this.f22a[i].close();
                    }
                } catch (Exception unused) {
                }
            }
            this.f22a[i] = null;
        }
        this.f23a = null;
        this.f24b = null;
        this.f22a = null;
        if (this.f20a != null) {
            try {
                this.f21c = false;
                c();
            } catch (Exception unused2) {
            }
            this.f20a = null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m14a(String str) {
        int i;
        if (str.equals("NORM_PRIORITY")) {
            i = 5;
        } else if (str.equals("MIN_PRIORITY")) {
            i = 1;
        } else if (!str.equals("MAX_PRIORITY")) {
            return;
        } else {
            i = 10;
        }
        if (this.f20a != null) {
            this.f20a.setPriority(i);
        }
    }

    public final void a(int i) {
        if (i == 0) {
            m13a();
        } else {
            if (this.f22a == null || this.f22a[0] == null) {
                return;
            }
            try {
                this.f22a[0].getControl("VolumeControl").setLevel(i * 10);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        f26e = false;
        f27f = false;
        f26e = false;
        f27f = false;
        try {
            String[] supportedContentTypes = Manager.getSupportedContentTypes((String) null);
            if (supportedContentTypes != null) {
                for (int i = 0; i < supportedContentTypes.length; i++) {
                    if (supportedContentTypes[i] != null) {
                        if (supportedContentTypes[i].equals("audio/mpeg")) {
                            f26e = true;
                        } else if (supportedContentTypes[i].equals("audio/amr")) {
                            f27f = true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            f26e = false;
            f27f = false;
        }
    }
}
