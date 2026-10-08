package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BlendModeColorFilter {
    public final int blendMode;
    public final long color;
    public final ColorFilter nativeColorFilter;

    public BlendModeColorFilter(int i, long j) {
        ColorFilter porterDuffColorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            CanvasZHelper$$ExternalSyntheticApiModelOutline0.m430m();
            porterDuffColorFilter = CanvasZHelper$$ExternalSyntheticApiModelOutline0.m(BrushKt.m424toArgb8_81llA(j), BrushKt.m422toAndroidBlendModes9anfk8(i));
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(BrushKt.m424toArgb8_81llA(j), BrushKt.m426toPorterDuffModes9anfk8(i));
        }
        this.nativeColorFilter = porterDuffColorFilter;
        this.color = j;
        this.blendMode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return Color.m433equalsimpl0(this.color, blendModeColorFilter.color) && this.blendMode == blendModeColorFilter.blendMode;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return (ULong.m836hashCodeimpl(this.color) * 31) + this.blendMode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BlendModeColorFilter(color=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.color, sb, ", blendMode=");
        sb.append((Object) BrushKt.m427toStringimpl(this.blendMode));
        sb.append(')');
        return sb.toString();
    }
}
