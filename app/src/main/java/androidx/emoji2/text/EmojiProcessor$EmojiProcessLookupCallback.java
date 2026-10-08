package androidx.emoji2.text;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiProcessor$EmojiProcessLookupCallback implements EmojiProcessor$EmojiProcessCallback {
    public final int mOffset;
    public int start = -1;
    public int end = -1;

    public EmojiProcessor$EmojiProcessLookupCallback(int i) {
        this.mOffset = i;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public final boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        int i3 = this.mOffset;
        if (i > i3 || i3 >= i2) {
            return i2 <= i3;
        }
        this.start = i;
        this.end = i2;
        return false;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public final Object getResult() {
        return this;
    }
}
