package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import coil.ImageLoader$Builder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IntervalList$Interval {
    public final int size;
    public final int startIndex;
    public final ImageLoader$Builder value;

    public IntervalList$Interval(int i, int i2, ImageLoader$Builder imageLoader$Builder) {
        this.startIndex = i;
        this.size = i2;
        this.value = imageLoader$Builder;
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("startIndex should be >= 0");
        }
        if (i2 > 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("size should be > 0");
    }
}
