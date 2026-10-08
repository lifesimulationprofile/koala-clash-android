package androidx.compose.ui.semantics;

import kotlin.ranges.ClosedFloatRange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressBarRangeInfo {
    public static final ProgressBarRangeInfo Indeterminate = new ProgressBarRangeInfo(new ClosedFloatRange());
    public final ClosedFloatRange range;

    public ProgressBarRangeInfo(ClosedFloatRange closedFloatRange) {
        this.range = closedFloatRange;
        if (Float.isNaN(0.0f)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProgressBarRangeInfo) && this.range.equals(((ProgressBarRangeInfo) obj).range);
    }

    public final ClosedFloatRange getRange() {
        return this.range;
    }

    public final int hashCode() {
        return (this.range.hashCode() + (Float.floatToIntBits(0.0f) * 31)) * 31;
    }

    public final String toString() {
        return "ProgressBarRangeInfo(current=0.0, range=" + this.range + ", steps=0)";
    }
}
