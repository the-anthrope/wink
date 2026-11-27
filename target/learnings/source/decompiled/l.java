package defpackage;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:l.class */
public final class l extends Exception {
    private Throwable a;

    public l(String str, j jVar, Throwable th) {
        super(new StringBuffer().append(str == null ? "" : new StringBuffer().append(str).append(" ").toString()).append(jVar == null ? "" : new StringBuffer().append("(position:").append(jVar.mo65a()).append(") ").toString()).append("").toString());
        this.a = null;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        if (this.a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(new StringBuffer().append(super.getMessage()).append("; nested exception is:").toString());
            this.a.printStackTrace();
        }
    }
}
