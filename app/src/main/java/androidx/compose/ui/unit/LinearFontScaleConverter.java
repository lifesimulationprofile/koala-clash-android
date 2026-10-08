package androidx.compose.ui.unit;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LinearFontScaleConverter implements FontScaleConverter {
    public final float fontScale;

    public LinearFontScaleConverter(float f) {
        this.fontScale = f;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertDpToSp(float f) {
        return f / this.fontScale;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertSpToDp(float f) {
        return f * this.fontScale;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LinearFontScaleConverter) && Float.compare(this.fontScale, ((LinearFontScaleConverter) obj).fontScale) == 0;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.fontScale);
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("LinearFontScaleConverter(fontScale="), this.fontScale, ')');
    }
}
