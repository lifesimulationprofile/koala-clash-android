package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State {
    public int lastFirstVisibleItem;
    public final ParcelableSnapshotMutableState value$delegate;

    public LazyLayoutNearestRangeState(int i) {
        int i2 = (i / 30) * 30;
        this.value$delegate = new ParcelableSnapshotMutableState(RangesKt.until(Math.max(i2 - 100, 0), i2 + 130), NeverEqualPolicy.INSTANCE$3);
        this.lastFirstVisibleItem = i;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (IntRange) this.value$delegate.getValue();
    }
}
