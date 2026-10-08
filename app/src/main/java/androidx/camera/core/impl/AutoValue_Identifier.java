package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Identifier {
    public final Object value;

    public AutoValue_Identifier(Object obj) {
        this.value = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_Identifier) {
            return this.value.equals(((AutoValue_Identifier) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "Identifier{value=" + this.value + "}";
    }
}
