package okhttp3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.Base64;
import okio.SegmentedByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new CertificatePinner(CollectionsKt.toSet(new ArrayList()), null);
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set pins;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static ImageVector _linkOff;

        public static final ImageVector getLinkOff() {
            ImageVector imageVector = _linkOff;
            if (imageVector != null) {
                return imageVector;
            }
            ImageVector.Builder builder = new ImageVector.Builder("Filled.LinkOff", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
            int i = VectorKt.$r8$clinit;
            SolidColor solidColor = new SolidColor(Color.Black);
            Headers.Builder builder2 = new Headers.Builder(2);
            builder2.moveTo(17.0f, 7.0f);
            builder2.horizontalLineToRelative(-4.0f);
            builder2.verticalLineToRelative(1.9f);
            builder2.horizontalLineToRelative(4.0f);
            builder2.curveToRelative(1.71f, 0.0f, 3.1f, 1.39f, 3.1f, 3.1f);
            builder2.curveToRelative(0.0f, 1.43f, -0.98f, 2.63f, -2.31f, 2.98f);
            builder2.lineToRelative(1.46f, 1.46f);
            builder2.curveTo(20.88f, 15.61f, 22.0f, 13.95f, 22.0f, 12.0f);
            builder2.curveToRelative(0.0f, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
            builder2.close();
            builder2.moveTo(16.0f, 11.0f);
            builder2.horizontalLineToRelative(-2.19f);
            builder2.lineToRelative(2.0f, 2.0f);
            builder2.lineTo(16.0f, 13.0f);
            builder2.close();
            builder2.moveTo(2.0f, 4.27f);
            builder2.lineToRelative(3.11f, 3.11f);
            builder2.curveTo(3.29f, 8.12f, 2.0f, 9.91f, 2.0f, 12.0f);
            builder2.curveToRelative(0.0f, 2.76f, 2.24f, 5.0f, 5.0f, 5.0f);
            builder2.horizontalLineToRelative(4.0f);
            builder2.verticalLineToRelative(-1.9f);
            builder2.lineTo(7.0f, 15.1f);
            builder2.curveToRelative(-1.71f, 0.0f, -3.1f, -1.39f, -3.1f, -3.1f);
            builder2.curveToRelative(0.0f, -1.59f, 1.21f, -2.9f, 2.76f, -3.07f);
            builder2.lineTo(8.73f, 11.0f);
            builder2.lineTo(8.0f, 11.0f);
            builder2.verticalLineToRelative(2.0f);
            builder2.horizontalLineToRelative(2.73f);
            builder2.lineTo(13.0f, 15.27f);
            builder2.lineTo(13.0f, 17.0f);
            builder2.horizontalLineToRelative(1.73f);
            builder2.lineToRelative(4.01f, 4.0f);
            builder2.lineTo(20.0f, 19.74f);
            builder2.lineTo(3.27f, 3.0f);
            builder2.lineTo(2.0f, 4.27f);
            builder2.close();
            ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
            ImageVector imageVectorBuild = builder.build();
            _linkOff = imageVectorBuild;
            return imageVectorBuild;
        }

        public static String pin(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
            if (!ImageAnalysis$$ExternalSyntheticLambda1.m14m((Object) x509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            StringBuilder sb = new StringBuilder("sha256/");
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            int length = encoded.length;
            int i = 0;
            SegmentedByteString.checkOffsetAndCount(encoded.length, 0, length);
            ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(length, encoded.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 0, length);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArrCopyOfRange, 0, bArrCopyOfRange.length);
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArr = Base64.BASE64;
            byte[] bArr2 = new byte[((bArrDigest.length + 2) / 3) * 4];
            int length2 = bArrDigest.length - (bArrDigest.length % 3);
            int i2 = 0;
            while (i < length2) {
                byte b = bArrDigest[i];
                int i3 = i + 2;
                byte b2 = bArrDigest[i + 1];
                i += 3;
                byte b3 = bArrDigest[i3];
                bArr2[i2] = bArr[(b & 255) >> 2];
                bArr2[i2 + 1] = bArr[((b & 3) << 4) | ((b2 & 255) >> 4)];
                int i4 = i2 + 3;
                bArr2[i2 + 2] = bArr[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
                i2 += 4;
                bArr2[i4] = bArr[b3 & 63];
            }
            int length3 = bArrDigest.length - length2;
            if (length3 == 1) {
                byte b4 = bArrDigest[i];
                bArr2[i2] = bArr[(b4 & 255) >> 2];
                bArr2[i2 + 1] = bArr[(b4 & 3) << 4];
                bArr2[i2 + 2] = 61;
                bArr2[i2 + 3] = 61;
            } else if (length3 == 2) {
                int i5 = i + 1;
                byte b5 = bArrDigest[i];
                byte b6 = bArrDigest[i5];
                bArr2[i2] = bArr[(b5 & 255) >> 2];
                bArr2[i2 + 1] = bArr[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
                bArr2[i2 + 2] = bArr[(b6 & 15) << 2];
                bArr2[i2 + 3] = 61;
            }
            sb.append(new String(bArr2, Charsets.UTF_8));
            return sb.toString();
        }
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Intrinsics.areEqual(certificatePinner.pins, this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }
}
