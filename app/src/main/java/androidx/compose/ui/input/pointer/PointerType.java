package androidx.compose.ui.input.pointer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerType {
    public final int value;

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m511toStringimpl(int i) {
        if (i == 1) {
            return "Touch";
        }
        if (i == 2) {
            return "Mouse";
        }
        if (i != 3) {
            return i != 4 ? "Unknown" : "Eraser";
        }
        return "Stylus";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PointerType) {
            return this.value == ((PointerType) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return this.value;
    }

    public final String toString() {
        return m511toStringimpl(this.value);
    }
}
