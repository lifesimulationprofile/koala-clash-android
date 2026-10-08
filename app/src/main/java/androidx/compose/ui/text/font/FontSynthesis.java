package androidx.compose.ui.text.font;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis {
    public final int value;

    public final boolean equals(Object obj) {
        if (obj instanceof FontSynthesis) {
            return this.value == ((FontSynthesis) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return this.value;
    }

    public final String toString() {
        int i = this.value;
        if (i == 0) {
            return "None";
        }
        if (i == 1) {
            return "Weight";
        }
        if (i == 2) {
            return "Style";
        }
        return i == 65535 ? "All" : "Invalid";
    }
}
