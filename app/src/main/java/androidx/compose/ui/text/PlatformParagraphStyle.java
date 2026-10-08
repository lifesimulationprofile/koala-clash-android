package androidx.compose.ui.text;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformParagraphStyle {
    public static final PlatformParagraphStyle Default = new PlatformParagraphStyle(0, false);
    public final int emojiSupportMatch;
    public final boolean includeFontPadding;

    public PlatformParagraphStyle() {
        this.includeFontPadding = false;
        this.emojiSupportMatch = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformParagraphStyle)) {
            return false;
        }
        PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj;
        return this.includeFontPadding == platformParagraphStyle.includeFontPadding && this.emojiSupportMatch == platformParagraphStyle.emojiSupportMatch;
    }

    public final int hashCode() {
        return ((this.includeFontPadding ? 1231 : 1237) * 31) + this.emojiSupportMatch;
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + ((Object) EmojiSupportMatch.m623toStringimpl(this.emojiSupportMatch)) + ')';
    }

    public PlatformParagraphStyle(int i, boolean z) {
        this.includeFontPadding = z;
        this.emojiSupportMatch = i;
    }
}
