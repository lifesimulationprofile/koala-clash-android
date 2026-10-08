package okhttp3.internal.platform;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class OpenJSSEPlatform extends Platform {
    public static final boolean isSupported;
    public final Provider provider = new OpenJSSE();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static String zza(String str, Object... objArr) {
            int length;
            int length2;
            int iIndexOf;
            String string;
            int i = 0;
            int i2 = 0;
            while (true) {
                length = objArr.length;
                if (i2 >= length) {
                    break;
                }
                Object obj = objArr[i2];
                if (obj == null) {
                    string = "null";
                } else {
                    try {
                        string = obj.toString();
                    } catch (Exception e) {
                        String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                        Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e);
                        StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("<", str2, " threw ");
                        sbM13m.append(e.getClass().getName());
                        sbM13m.append(">");
                        string = sbM13m.toString();
                    }
                }
                objArr[i2] = string;
                i2++;
            }
            StringBuilder sb = new StringBuilder(str.length() + (length * 16));
            int i3 = 0;
            while (true) {
                length2 = objArr.length;
                if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                    break;
                }
                sb.append((CharSequence) str, i3, iIndexOf);
                sb.append(objArr[i]);
                i++;
                i3 = iIndexOf + 2;
            }
            sb.append((CharSequence) str, i3, str.length());
            if (i < length2) {
                sb.append(" [");
                sb.append(objArr[i]);
                for (int i4 = i + 1; i4 < objArr.length; i4++) {
                    sb.append(", ");
                    sb.append(objArr[i4]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
    }

    static {
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, Companion.class.getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() {
        return SSLContext.getInstance("TLSv1.3", this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers: ".concat(Arrays.toString(trustManagers)).toString());
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }
}
