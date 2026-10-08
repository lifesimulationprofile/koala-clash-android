package androidx.compose.ui.input.pointer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerKeyboardModifiers {
    public final int packedValue;

    public final boolean equals(Object obj) {
        if (obj instanceof PointerKeyboardModifiers) {
            return this.packedValue == ((PointerKeyboardModifiers) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return this.packedValue;
    }

    public final String toString() {
        return "PointerKeyboardModifiers(packedValue=" + this.packedValue + ')';
    }
}
