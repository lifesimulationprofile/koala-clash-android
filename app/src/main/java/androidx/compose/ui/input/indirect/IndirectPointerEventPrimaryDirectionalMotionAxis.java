package androidx.compose.ui.input.indirect;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IndirectPointerEventPrimaryDirectionalMotionAxis {
    public final int value;

    public final boolean equals(Object obj) {
        if (obj instanceof IndirectPointerEventPrimaryDirectionalMotionAxis) {
            return this.value == ((IndirectPointerEventPrimaryDirectionalMotionAxis) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return this.value;
    }

    public final String toString() {
        return "IndirectPointerEventPrimaryDirectionalMotionAxis(value=" + this.value + ')';
    }
}
