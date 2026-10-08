package androidx.compose.ui.geometry;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundRect {
    public final float bottom;
    public final long bottomLeftCornerRadius;
    public final long bottomRightCornerRadius;
    public final float left;
    public final float right;
    public final float top;
    public final long topLeftCornerRadius;
    public final long topRightCornerRadius;

    static {
        RoundRectKt.m381RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m364equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m364equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m364equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m364equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.bottom, ImageAnalysis$$ExternalSyntheticLambda1.m(this.right, ImageAnalysis$$ExternalSyntheticLambda1.m(this.top, Float.floatToIntBits(this.left) * 31, 31), 31), 31);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        int i = (((int) (j2 ^ (j2 >>> 32))) + ((((int) (j ^ (j >>> 32))) + iM) * 31)) * 31;
        long j3 = this.bottomRightCornerRadius;
        int i2 = (((int) (j3 ^ (j3 >>> 32))) + i) * 31;
        long j4 = this.bottomLeftCornerRadius;
        return ((int) (j4 ^ (j4 >>> 32))) + i2;
    }

    public final String toString() {
        String str = GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        boolean zM364equalsimpl0 = CornerRadius.m364equalsimpl0(j, j2);
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        if (!zM364equalsimpl0 || !CornerRadius.m364equalsimpl0(j2, j3) || !CornerRadius.m364equalsimpl0(j3, j4)) {
            StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("RoundRect(rect=", str, ", topLeft=");
            sbM13m.append((Object) CornerRadius.m365toStringimpl(j));
            sbM13m.append(", topRight=");
            sbM13m.append((Object) CornerRadius.m365toStringimpl(j2));
            sbM13m.append(", bottomRight=");
            sbM13m.append((Object) CornerRadius.m365toStringimpl(j3));
            sbM13m.append(", bottomLeft=");
            sbM13m.append((Object) CornerRadius.m365toStringimpl(j4));
            sbM13m.append(')');
            return sbM13m.toString();
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            StringBuilder sbM13m2 = ImageAnalysis$$ExternalSyntheticLambda1.m13m("RoundRect(rect=", str, ", radius=");
            sbM13m2.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i)));
            sbM13m2.append(')');
            return sbM13m2.toString();
        }
        StringBuilder sbM13m3 = ImageAnalysis$$ExternalSyntheticLambda1.m13m("RoundRect(rect=", str, ", x=");
        sbM13m3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i)));
        sbM13m3.append(", y=");
        sbM13m3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i2)));
        sbM13m3.append(')');
        return sbM13m3.toString();
    }
}
