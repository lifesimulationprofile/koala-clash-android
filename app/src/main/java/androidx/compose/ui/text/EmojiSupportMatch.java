package androidx.compose.ui.text;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiSupportMatch {
    public final int value;

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m623toStringimpl(int i) {
        if (i == 0) {
            return "EmojiSupportMatch.Default";
        }
        if (i == 1) {
            return "EmojiSupportMatch.None";
        }
        if (i == 2) {
            return "EmojiSupportMatch.All";
        }
        return "Invalid(value=" + i + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof EmojiSupportMatch) {
            return this.value == ((EmojiSupportMatch) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return this.value;
    }

    public final String toString() {
        return m623toStringimpl(this.value);
    }
}
