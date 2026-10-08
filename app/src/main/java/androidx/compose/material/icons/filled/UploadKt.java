package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UploadKt {
    public static ImageVector _upload;

    public static final ImageVector getUpload() {
        ImageVector imageVector = _upload;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Upload", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(5.0f, 20.0f);
        builder2.horizontalLineToRelative(14.0f);
        builder2.verticalLineToRelative(-2.0f);
        builder2.horizontalLineTo(5.0f);
        builder2.verticalLineTo(20.0f);
        builder2.close();
        builder2.moveTo(5.0f, 10.0f);
        builder2.horizontalLineToRelative(4.0f);
        builder2.verticalLineToRelative(6.0f);
        builder2.horizontalLineToRelative(6.0f);
        builder2.verticalLineToRelative(-6.0f);
        builder2.horizontalLineToRelative(4.0f);
        builder2.lineToRelative(-7.0f, -7.0f);
        builder2.lineTo(5.0f, 10.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _upload = imageVectorBuild;
        return imageVectorBuild;
    }
}
