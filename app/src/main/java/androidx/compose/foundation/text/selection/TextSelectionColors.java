package androidx.compose.foundation.text.selection;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextSelectionColors {
    public final long backgroundColor;
    public final long handleColor;

    public TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return Color.m433equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m433equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.backgroundColor) + (ULong.m836hashCodeimpl(this.handleColor) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SelectionColors(selectionHandleColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.handleColor, sb, ", selectionBackgroundColor=");
        sb.append((Object) Color.m439toStringimpl(this.backgroundColor));
        sb.append(')');
        return sb.toString();
    }
}
