package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.DefaultLazyKey;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda7;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemProviderImpl {
    public final LazyListIntervalContent intervalContent;
    public final LazyItemScopeImpl itemScope;
    public final StatusLine keyIndexMap;
    public final LazyListState state;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, LazyItemScopeImpl lazyItemScopeImpl, StatusLine statusLine) {
        this.state = lazyListState;
        this.intervalContent = lazyListIntervalContent;
        this.itemScope = lazyItemScopeImpl;
        this.keyIndexMap = statusLine;
    }

    public final void Item(int i, Object obj, GapComposer gapComposer, int i2) {
        int i3;
        Object obj2;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(-462424778);
        int i4 = (gapComposer.changed(i) ? 4 : 2) | i2 | (gapComposer.changedInstance(obj) ? 32 : 16) | (gapComposer.changed(this) ? 256 : 128);
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
            i3 = i;
            obj2 = obj;
            gapComposer2 = gapComposer;
            LazyLayoutKt.LazyLayoutPinnableItem(obj2, i3, this.state.pinnedItems, Thread_jvmKt.rememberComposableLambda(-824725566, new ProfilesScreenKt$$ExternalSyntheticLambda7(i, 1, this), gapComposer), gapComposer2, ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112));
        } else {
            i3 = i;
            obj2 = obj;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LazyListItemProviderImpl$$ExternalSyntheticLambda1(this, i3, obj2, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyListItemProviderImpl)) {
            return false;
        }
        return Intrinsics.areEqual(this.intervalContent, ((LazyListItemProviderImpl) obj).intervalContent);
    }

    public final Object getContentType(int i) {
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        IntervalList$Interval intervalList$Interval = lazyListIntervalContent.intervals.get(i);
        return ((Function1) intervalList$Interval.value.defaults).invoke(Integer.valueOf(i - intervalList$Interval.startIndex));
    }

    public final int getItemCount() {
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        return lazyListIntervalContent.intervals.code;
    }

    public final Object getKey(int i) {
        Object objInvoke;
        StatusLine statusLine = this.keyIndexMap;
        Object[] objArr = (Object[]) statusLine.message;
        int i2 = i - statusLine.code;
        Object obj = (i2 < 0 || i2 >= objArr.length) ? null : objArr[i2];
        if (obj != null) {
            return obj;
        }
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        IntervalList$Interval intervalList$Interval = lazyListIntervalContent.intervals.get(i);
        int i3 = i - intervalList$Interval.startIndex;
        Function1 function1 = (Function1) intervalList$Interval.value.applicationContext;
        return (function1 == null || (objInvoke = function1.invoke(Integer.valueOf(i3))) == null) ? new DefaultLazyKey(i) : objInvoke;
    }

    public final int hashCode() {
        return this.intervalContent.hashCode();
    }
}
