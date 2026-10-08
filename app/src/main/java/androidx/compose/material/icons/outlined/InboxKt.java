package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InboxKt {
    public static ImageVector _inbox;

    public static final ImageVector getInbox() {
        ImageVector imageVector = _inbox;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Inbox", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(19.0f, 3.0f);
        builder2.lineTo(5.0f, 3.0f);
        builder2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        builder2.verticalLineToRelative(14.0f);
        builder2.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        builder2.horizontalLineToRelative(14.0f);
        builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        builder2.lineTo(21.0f, 5.0f);
        builder2.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        builder2.close();
        builder2.moveTo(19.0f, 19.0f);
        builder2.lineTo(5.0f, 19.0f);
        builder2.verticalLineToRelative(-3.0f);
        builder2.horizontalLineToRelative(3.56f);
        builder2.curveToRelative(0.69f, 1.19f, 1.97f, 2.0f, 3.45f, 2.0f);
        builder2.reflectiveCurveToRelative(2.75f, -0.81f, 3.45f, -2.0f);
        builder2.lineTo(19.0f, 16.0f);
        builder2.verticalLineToRelative(3.0f);
        builder2.close();
        builder2.moveTo(19.0f, 14.0f);
        builder2.horizontalLineToRelative(-4.99f);
        builder2.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        builder2.reflectiveCurveToRelative(-2.0f, -0.9f, -2.0f, -2.0f);
        builder2.lineTo(5.0f, 14.0f);
        builder2.lineTo(5.0f, 5.0f);
        builder2.horizontalLineToRelative(14.0f);
        builder2.verticalLineToRelative(9.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _inbox = imageVectorBuild;
        return imageVectorBuild;
    }
}
