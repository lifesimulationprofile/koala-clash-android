package coil.decode;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DecodeResult {
    public final BitmapDrawable drawable;
    public final boolean isSampled;

    public DecodeResult(BitmapDrawable bitmapDrawable, boolean z) {
        this.drawable = bitmapDrawable;
        this.isSampled = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return this.drawable.equals(decodeResult.drawable) && this.isSampled == decodeResult.isSampled;
    }

    public final int hashCode() {
        return (this.drawable.hashCode() * 31) + (this.isSampled ? 1231 : 1237);
    }
}
