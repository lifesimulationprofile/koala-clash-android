package kotlin.uuid;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import kotlin.text.HexExtensionsKt;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public abstract class UuidKt {
    public static ImageVector _allInclusive;

    public static final void checkHyphenAt(String str, int i) {
        if (str.charAt(i) == '-') {
            return;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Expected '-' (hyphen) at index ", ", but was '");
        sbM.append(str.charAt(i));
        sbM.append('\'');
        throw new IllegalArgumentException(sbM.toString().toString());
    }

    public static final void formatBytesInto(long j, byte[] bArr, int i, int i2, int i3) {
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static final ImageVector getAllInclusive() {
        ImageVector imageVector = _allInclusive;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.AllInclusive", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(18.6f, 6.62f);
        builder2.curveToRelative(-1.44f, 0.0f, -2.8f, 0.56f, -3.77f, 1.53f);
        builder2.lineTo(12.0f, 10.66f);
        builder2.lineTo(10.48f, 12.0f);
        builder2.horizontalLineToRelative(0.01f);
        builder2.lineTo(7.8f, 14.39f);
        builder2.curveToRelative(-0.64f, 0.64f, -1.49f, 0.99f, -2.4f, 0.99f);
        builder2.curveToRelative(-1.87f, 0.0f, -3.39f, -1.51f, -3.39f, -3.38f);
        builder2.reflectiveCurveTo(3.53f, 8.62f, 5.4f, 8.62f);
        builder2.curveToRelative(0.91f, 0.0f, 1.76f, 0.35f, 2.44f, 1.03f);
        builder2.lineToRelative(1.13f, 1.0f);
        builder2.lineToRelative(1.51f, -1.34f);
        builder2.lineTo(9.22f, 8.2f);
        builder2.curveTo(8.2f, 7.18f, 6.84f, 6.62f, 5.4f, 6.62f);
        builder2.curveTo(2.42f, 6.62f, 0.0f, 9.04f, 0.0f, 12.0f);
        builder2.reflectiveCurveToRelative(2.42f, 5.38f, 5.4f, 5.38f);
        builder2.curveToRelative(1.44f, 0.0f, 2.8f, -0.56f, 3.77f, -1.53f);
        builder2.lineToRelative(2.83f, -2.5f);
        builder2.lineToRelative(0.01f, 0.01f);
        builder2.lineTo(13.52f, 12.0f);
        builder2.horizontalLineToRelative(-0.01f);
        builder2.lineToRelative(2.69f, -2.39f);
        builder2.curveToRelative(0.64f, -0.64f, 1.49f, -0.99f, 2.4f, -0.99f);
        builder2.curveToRelative(1.87f, 0.0f, 3.39f, 1.51f, 3.39f, 3.38f);
        builder2.reflectiveCurveToRelative(-1.52f, 3.38f, -3.39f, 3.38f);
        builder2.curveToRelative(-0.9f, 0.0f, -1.76f, -0.35f, -2.44f, -1.03f);
        builder2.lineToRelative(-1.14f, -1.01f);
        builder2.lineToRelative(-1.51f, 1.34f);
        builder2.lineToRelative(1.27f, 1.12f);
        builder2.curveToRelative(1.02f, 1.01f, 2.37f, 1.57f, 3.82f, 1.57f);
        builder2.curveToRelative(2.98f, 0.0f, 5.4f, -2.41f, 5.4f, -5.38f);
        builder2.reflectiveCurveToRelative(-2.42f, -5.37f, -5.4f, -5.37f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _allInclusive = imageVectorBuild;
        return imageVectorBuild;
    }
}
