package okhttp3.internal.http;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpMethod {
    public static ImageVector _settings;

    public static final ImageVector getSettings() {
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Settings", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(19.14f, 12.94f);
        builder2.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        builder2.curveToRelative(0.0f, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        builder2.lineToRelative(2.03f, -1.58f);
        builder2.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        builder2.lineToRelative(-1.92f, -3.32f);
        builder2.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        builder2.lineToRelative(-2.39f, 0.96f);
        builder2.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        builder2.lineTo(14.4f, 2.81f);
        builder2.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        builder2.horizontalLineToRelative(-3.84f);
        builder2.curveToRelative(-0.24f, 0.0f, -0.43f, 0.17f, -0.47f, 0.41f);
        builder2.lineTo(9.25f, 5.35f);
        builder2.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        builder2.lineTo(5.24f, 5.33f);
        builder2.curveToRelative(-0.22f, -0.08f, -0.47f, 0.0f, -0.59f, 0.22f);
        builder2.lineTo(2.74f, 8.87f);
        builder2.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        builder2.lineToRelative(2.03f, 1.58f);
        builder2.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12.0f);
        builder2.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        builder2.lineToRelative(-2.03f, 1.58f);
        builder2.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        builder2.lineToRelative(1.92f, 3.32f);
        builder2.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        builder2.lineToRelative(2.39f, -0.96f);
        builder2.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        builder2.lineToRelative(0.36f, 2.54f);
        builder2.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        builder2.horizontalLineToRelative(3.84f);
        builder2.curveToRelative(0.24f, 0.0f, 0.44f, -0.17f, 0.47f, -0.41f);
        builder2.lineToRelative(0.36f, -2.54f);
        builder2.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        builder2.lineToRelative(2.39f, 0.96f);
        builder2.curveToRelative(0.22f, 0.08f, 0.47f, 0.0f, 0.59f, -0.22f);
        builder2.lineToRelative(1.92f, -3.32f);
        builder2.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        builder2.lineTo(19.14f, 12.94f);
        builder2.close();
        builder2.moveTo(12.0f, 15.6f);
        builder2.curveToRelative(-1.98f, 0.0f, -3.6f, -1.62f, -3.6f, -3.6f);
        builder2.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        builder2.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        builder2.reflectiveCurveTo(13.98f, 15.6f, 12.0f, 15.6f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _settings = imageVectorBuild;
        return imageVectorBuild;
    }

    public static final boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }
}
