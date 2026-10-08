package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldLabelPosition$Attached {
    public final BiasAlignment.Horizontal expandedAlignment;
    public final BiasAlignment.Horizontal minimizedAlignment;

    public TextFieldLabelPosition$Attached() {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        this.minimizedAlignment = horizontal;
        this.expandedAlignment = horizontal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldLabelPosition$Attached)) {
            return false;
        }
        TextFieldLabelPosition$Attached textFieldLabelPosition$Attached = (TextFieldLabelPosition$Attached) obj;
        return Intrinsics.areEqual(this.minimizedAlignment, textFieldLabelPosition$Attached.minimizedAlignment) && Intrinsics.areEqual(this.expandedAlignment, textFieldLabelPosition$Attached.expandedAlignment);
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.expandedAlignment.bias) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.minimizedAlignment.bias, 38347, 31);
    }

    public final String toString() {
        return "Attached(alwaysMinimize=false, minimizedAlignment=" + this.minimizedAlignment + ", expandedAlignment=" + this.expandedAlignment + ')';
    }
}
