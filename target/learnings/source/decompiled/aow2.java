package defpackage;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:aow2.class */
public class aow2 extends MIDlet {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f17a = false;
    k a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Display f16a = null;

    public void startApp() {
        if (this.a != null) {
            this.a.c();
            return;
        }
        a.a(this);
        try {
            this.f16a = Display.getDisplay(this);
            this.a = new k(this);
            this.f16a.setCurrent(this.a);
            this.a.a();
        } catch (Exception unused) {
        }
    }

    public void pauseApp() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public void destroyApp(boolean z) {
        if (this.f17a) {
            return;
        }
        this.f17a = true;
        if (this.a != null) {
            this.a.a((String) null);
            a.a(z ? 5L : 10L);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return k.a(obj);
        } catch (Exception unused) {
            return super/*java.lang.Object*/.equals(obj);
        }
    }
}
