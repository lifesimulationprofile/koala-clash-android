package kotlinx.coroutines.internal;

import android.text.TextUtils;
import androidx.compose.ui.Modifier;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Symbol implements EmojiProcessor$EmojiProcessCallback {
    public final /* synthetic */ int $r8$classId;
    public String symbol;

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.symbol)) {
            return true;
        }
        typefaceEmojiRasterizer.mCache = (typefaceEmojiRasterizer.mCache & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return Modifier.CC.m(new StringBuilder("<"), this.symbol, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ Symbol(String str, int i) {
        this.$r8$classId = i;
        this.symbol = str;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return this;
    }
}
