package okhttp3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    public final String javaName;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static ImageVector _refresh;

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static TlsVersion forJavaName(String str) {
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
        }

        public static final ImageVector getRefresh() {
            ImageVector imageVector = _refresh;
            if (imageVector != null) {
                return imageVector;
            }
            ImageVector.Builder builder = new ImageVector.Builder("Filled.Refresh", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
            int i = VectorKt.$r8$clinit;
            SolidColor solidColor = new SolidColor(Color.Black);
            Headers.Builder builder2 = new Headers.Builder(2);
            builder2.moveTo(17.65f, 6.35f);
            builder2.curveTo(16.2f, 4.9f, 14.21f, 4.0f, 12.0f, 4.0f);
            builder2.curveToRelative(-4.42f, 0.0f, -7.99f, 3.58f, -7.99f, 8.0f);
            builder2.reflectiveCurveToRelative(3.57f, 8.0f, 7.99f, 8.0f);
            builder2.curveToRelative(3.73f, 0.0f, 6.84f, -2.55f, 7.73f, -6.0f);
            builder2.horizontalLineToRelative(-2.08f);
            builder2.curveToRelative(-0.82f, 2.33f, -3.04f, 4.0f, -5.65f, 4.0f);
            builder2.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
            builder2.reflectiveCurveToRelative(2.69f, -6.0f, 6.0f, -6.0f);
            builder2.curveToRelative(1.66f, 0.0f, 3.14f, 0.69f, 4.22f, 1.78f);
            builder2.lineTo(13.0f, 11.0f);
            builder2.horizontalLineToRelative(7.0f);
            builder2.verticalLineTo(4.0f);
            builder2.lineToRelative(-2.35f, 2.35f);
            builder2.close();
            ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
            ImageVector imageVectorBuild = builder.build();
            _refresh = imageVectorBuild;
            return imageVectorBuild;
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }
}
