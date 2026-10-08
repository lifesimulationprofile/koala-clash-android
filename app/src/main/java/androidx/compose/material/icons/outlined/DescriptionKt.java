package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DescriptionKt {
    public static ImageVector _description;

    public static final ImageVector getDescription() {
        ImageVector imageVector = _description;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Description", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(8.0f, 16.0f);
        builder2.horizontalLineToRelative(8.0f);
        builder2.verticalLineToRelative(2.0f);
        builder2.lineTo(8.0f, 18.0f);
        builder2.close();
        builder2.moveTo(8.0f, 12.0f);
        builder2.horizontalLineToRelative(8.0f);
        builder2.verticalLineToRelative(2.0f);
        builder2.lineTo(8.0f, 14.0f);
        builder2.close();
        builder2.moveTo(14.0f, 2.0f);
        builder2.lineTo(6.0f, 2.0f);
        builder2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        builder2.verticalLineToRelative(16.0f);
        builder2.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 1.99f, 2.0f);
        builder2.lineTo(18.0f, 22.0f);
        builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        builder2.lineTo(20.0f, 8.0f);
        builder2.lineToRelative(-6.0f, -6.0f);
        builder2.close();
        builder2.moveTo(18.0f, 20.0f);
        builder2.lineTo(6.0f, 20.0f);
        builder2.lineTo(6.0f, 4.0f);
        builder2.horizontalLineToRelative(7.0f);
        builder2.verticalLineToRelative(5.0f);
        builder2.horizontalLineToRelative(5.0f);
        builder2.verticalLineToRelative(11.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _description = imageVectorBuild;
        return imageVectorBuild;
    }
}
