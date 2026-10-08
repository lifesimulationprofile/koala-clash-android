package androidx.compose.foundation;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class OverscrollConfiguration {
    public final PaddingValuesImpl drawPadding;
    public final long glowColor;

    public OverscrollConfiguration() {
        long jColor = BrushKt.Color(4284900966L);
        PaddingValuesImpl paddingValuesImplM119PaddingValuesYgX7TsA$default = OffsetKt.m119PaddingValuesYgX7TsA$default(3, 0.0f);
        this.glowColor = jColor;
        this.drawPadding = paddingValuesImplM119PaddingValuesYgX7TsA$default;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!OverscrollConfiguration.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) obj;
        return Color.m433equalsimpl0(this.glowColor, overscrollConfiguration.glowColor) && Intrinsics.areEqual(this.drawPadding, overscrollConfiguration.drawPadding);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return this.drawPadding.hashCode() + (ULong.m836hashCodeimpl(this.glowColor) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverscrollConfiguration(glowColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.glowColor, sb, ", drawPadding=");
        sb.append(this.drawPadding);
        sb.append(')');
        return sb.toString();
    }
}
