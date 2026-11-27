package defpackage;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:q.class */
public class q extends Canvas {
    private boolean a = true;

    public void paint(Graphics graphics) {
        if (this.a) {
            this.a = false;
            a(graphics);
        }
    }

    protected void a(Graphics graphics) {
    }

    public final void h() {
        this.a = true;
        repaint();
        serviceRepaints();
    }

    protected void a(int i) {
    }

    protected void b(int i) {
    }

    protected void keyPressed(int i) {
        a(i);
    }

    protected void keyReleased(int i) {
        b(i);
    }
}
