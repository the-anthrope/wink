package defpackage;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

/* JADX INFO: loaded from: 92aace22-artofwea_S8000.jar:h.class */
public final class h {
    public static boolean a(String str, String str2) {
        MessageConnection messageConnection = null;
        try {
            MessageConnection messageConnectionOpen = Connector.open(new StringBuffer().append("sms://").append(str).toString());
            messageConnection = messageConnectionOpen;
            TextMessage textMessageNewMessage = messageConnectionOpen.newMessage("text");
            textMessageNewMessage.setPayloadText(str2);
            messageConnection.send(textMessageNewMessage);
            if (messageConnection == null) {
                return true;
            }
            try {
                messageConnection.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception unused2) {
            if (messageConnection == null) {
                return false;
            }
            try {
                messageConnection.close();
                return false;
            } catch (Exception unused3) {
                return false;
            }
        } catch (Throwable th) {
            if (messageConnection != null) {
                try {
                    messageConnection.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }
}
