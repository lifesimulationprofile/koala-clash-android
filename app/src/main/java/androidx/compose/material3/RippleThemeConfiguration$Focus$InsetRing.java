package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleThemeConfiguration$Focus$InsetRing extends ScrimKt {
    public final float innerStrokeInset;
    public final float innerStrokeWidth;
    public final float outerStrokeInset;
    public final float outerStrokeWidth;

    public RippleThemeConfiguration$Focus$InsetRing(float f, float f2, float f3, float f4) {
        this.outerStrokeInset = f;
        this.outerStrokeWidth = f2;
        this.innerStrokeInset = f3;
        this.innerStrokeWidth = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleThemeConfiguration$Focus$InsetRing)) {
            return false;
        }
        RippleThemeConfiguration$Focus$InsetRing rippleThemeConfiguration$Focus$InsetRing = (RippleThemeConfiguration$Focus$InsetRing) obj;
        return Dp.m701equalsimpl0(this.outerStrokeInset, rippleThemeConfiguration$Focus$InsetRing.outerStrokeInset) && Dp.m701equalsimpl0(this.outerStrokeWidth, rippleThemeConfiguration$Focus$InsetRing.outerStrokeWidth) && Dp.m701equalsimpl0(this.innerStrokeInset, rippleThemeConfiguration$Focus$InsetRing.innerStrokeInset) && Dp.m701equalsimpl0(this.innerStrokeWidth, rippleThemeConfiguration$Focus$InsetRing.innerStrokeWidth);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.innerStrokeWidth) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.innerStrokeInset, ImageAnalysis$$ExternalSyntheticLambda1.m(this.outerStrokeWidth, Float.floatToIntBits(this.outerStrokeInset) * 31, 31), 31);
    }
}
