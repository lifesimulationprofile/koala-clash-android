package androidx.compose.ui.input.pointer;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPointerIconType implements PointerIcon {
    public final int type;

    public AndroidPointerIconType(int i) {
        this.type = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return AndroidPointerIconType.class.equals(obj != null ? obj.getClass() : null) && this.type == ((AndroidPointerIconType) obj).type;
    }

    public final int hashCode() {
        return this.type;
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("AndroidPointerIcon(type="), this.type, ')');
    }
}
