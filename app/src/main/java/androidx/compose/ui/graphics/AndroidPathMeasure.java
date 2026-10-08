package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathMeasure {
    public final PathMeasure internalPathMeasure;

    public AndroidPathMeasure(PathMeasure pathMeasure) {
        this.internalPathMeasure = pathMeasure;
    }

    public final boolean getSegment(float f, float f2, AndroidPath androidPath) {
        if (!ImageAnalysis$$ExternalSyntheticLambda1.m14m((Object) androidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        return this.internalPathMeasure.getSegment(f, f2, androidPath.internalPath, true);
    }
}
