package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryCache$Value {
    public final Bitmap bitmap;
    public final Map extras;

    public MemoryCache$Value(Bitmap bitmap, Map map) {
        this.bitmap = bitmap;
        this.extras = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryCache$Value)) {
            return false;
        }
        MemoryCache$Value memoryCache$Value = (MemoryCache$Value) obj;
        return Intrinsics.areEqual(this.bitmap, memoryCache$Value.bitmap) && Intrinsics.areEqual(this.extras, memoryCache$Value.extras);
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.bitmap.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
    }
}
