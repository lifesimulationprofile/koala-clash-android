package androidx.compose.ui.text.style;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextGeometricTransform {
    public static final TextGeometricTransform None = new TextGeometricTransform(1.0f, 0.0f);
    public final float scaleX;
    public final float skewX;

    public TextGeometricTransform(float f, float f2) {
        this.scaleX = f;
        this.skewX = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextGeometricTransform)) {
            return false;
        }
        TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj;
        return this.scaleX == textGeometricTransform.scaleX && this.skewX == textGeometricTransform.skewX;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.skewX) + (Float.floatToIntBits(this.scaleX) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextGeometricTransform(scaleX=");
        sb.append(this.scaleX);
        sb.append(", skewX=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.skewX, ')');
    }
}
