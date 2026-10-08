package androidx.compose.ui.text.style;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Hyphens {
    public final int value;

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m667toStringimpl(int i) {
        if (i == 1) {
            return "Hyphens.None";
        }
        if (i == 2) {
            return "Hyphens.Auto";
        }
        return i == 0 ? "Hyphens.Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Hyphens) {
            return this.value == ((Hyphens) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return this.value;
    }

    public final String toString() {
        return m667toStringimpl(this.value);
    }
}
