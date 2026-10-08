package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentPasteKt {
    public static ImageVector _contentPaste;

    public static final ImageVector getContentPaste() {
        ImageVector imageVector = _contentPaste;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.ContentPaste", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(19.0f, 2.0f);
        builder2.horizontalLineToRelative(-4.18f);
        builder2.curveTo(14.4f, 0.84f, 13.3f, 0.0f, 12.0f, 0.0f);
        builder2.reflectiveCurveTo(9.6f, 0.84f, 9.18f, 2.0f);
        builder2.lineTo(5.0f, 2.0f);
        builder2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        builder2.verticalLineToRelative(16.0f);
        builder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        builder2.horizontalLineToRelative(14.0f);
        builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        builder2.lineTo(21.0f, 4.0f);
        builder2.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        builder2.close();
        builder2.moveTo(12.0f, 2.0f);
        builder2.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        builder2.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        builder2.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        builder2.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        builder2.close();
        builder2.moveTo(19.0f, 20.0f);
        builder2.lineTo(5.0f, 20.0f);
        builder2.lineTo(5.0f, 4.0f);
        builder2.horizontalLineToRelative(2.0f);
        builder2.verticalLineToRelative(3.0f);
        builder2.horizontalLineToRelative(10.0f);
        builder2.lineTo(17.0f, 4.0f);
        builder2.horizontalLineToRelative(2.0f);
        builder2.verticalLineToRelative(16.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _contentPaste = imageVectorBuild;
        return imageVectorBuild;
    }
}
