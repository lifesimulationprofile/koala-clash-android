package androidx.compose.material3;

import android.graphics.PathMeasure;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CheckDrawingCache {
    public final AndroidPath checkPath;
    public final AndroidPathMeasure pathMeasure;
    public final AndroidPath pathToDraw;

    public CheckDrawingCache() {
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        AndroidPathMeasure androidPathMeasure = new AndroidPathMeasure(new PathMeasure());
        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
        this.checkPath = androidPathPath;
        this.pathMeasure = androidPathMeasure;
        this.pathToDraw = androidPathPath2;
    }
}
