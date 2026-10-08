package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonElevation {
    public final float defaultElevation;
    public final float disabledElevation;
    public final float focusedElevation;
    public final float hoveredElevation;
    public final float pressedElevation;

    public ButtonElevation(float f, float f2, float f3, float f4, float f5) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
        this.disabledElevation = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        return Dp.m701equalsimpl0(this.defaultElevation, buttonElevation.defaultElevation) && Dp.m701equalsimpl0(this.pressedElevation, buttonElevation.pressedElevation) && Dp.m701equalsimpl0(this.focusedElevation, buttonElevation.focusedElevation) && Dp.m701equalsimpl0(this.hoveredElevation, buttonElevation.hoveredElevation) && Dp.m701equalsimpl0(this.disabledElevation, buttonElevation.disabledElevation);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.disabledElevation) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.hoveredElevation, ImageAnalysis$$ExternalSyntheticLambda1.m(this.focusedElevation, ImageAnalysis$$ExternalSyntheticLambda1.m(this.pressedElevation, Float.floatToIntBits(this.defaultElevation) * 31, 31), 31), 31);
    }
}
