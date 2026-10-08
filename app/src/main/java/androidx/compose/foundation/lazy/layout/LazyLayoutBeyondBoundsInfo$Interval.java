package androidx.compose.foundation.lazy.layout;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.internal.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsInfo$Interval {
    public final int end;
    public final int start;

    public LazyLayoutBeyondBoundsInfo$Interval(int i, int i2) {
        this.start = i;
        this.end = i2;
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative start index");
        }
        if (i2 >= i) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("end index greater than start");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutBeyondBoundsInfo$Interval)) {
            return false;
        }
        LazyLayoutBeyondBoundsInfo$Interval lazyLayoutBeyondBoundsInfo$Interval = (LazyLayoutBeyondBoundsInfo$Interval) obj;
        return this.start == lazyLayoutBeyondBoundsInfo$Interval.start && this.end == lazyLayoutBeyondBoundsInfo$Interval.end;
    }

    public final int hashCode() {
        return (this.start * 31) + this.end;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Interval(start=");
        sb.append(this.start);
        sb.append(", end=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.end, ')');
    }
}
