package androidx.compose.foundation.lazy;

import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.foundation.lazy.layout.PriorityTask;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import coil.ImageLoader$Builder;
import coil.disk.DiskLruCache;
import coil.network.RealNetworkObserver;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyItemScope$-CC, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class LazyItemScope$CC {
    public static Modifier fillParentMaxSize$default(LazyItemScopeImpl lazyItemScopeImpl) {
        return new ParentSizeElement(lazyItemScopeImpl.maxWidthState, lazyItemScopeImpl.maxHeightState);
    }

    public static void item$default(LazyListIntervalContent lazyListIntervalContent, String str, ComposableLambdaImpl composableLambdaImpl, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        lazyListIntervalContent.intervals.addInterval(1, new ImageLoader$Builder(str != null ? new Recomposer$$ExternalSyntheticLambda0(8, str) : null, new BasicTextKt$$ExternalSyntheticLambda3(13), new ComposableLambdaImpl(-857469575, new LazyListIntervalContent$$ExternalSyntheticLambda2(0, composableLambdaImpl), true), 5));
    }

    public static LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch$default(Toolbar.AnonymousClass1 anonymousClass1, int i) {
        LazyListState lazyListState = (LazyListState) anonymousClass1.this$0;
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) lazyListState.layoutInfoState.getValue();
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LazyLayoutPrefetchState lazyLayoutPrefetchState = lazyListState.prefetchState;
            long j = lazyListMeasureResult.childConstraints;
            boolean z = lazyListState.executeRequestsInHighPriorityMode;
            BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3 = new BasicTextKt$$ExternalSyntheticLambda3(i, lazyListMeasureResult);
            DiskLruCache.Editor editor = lazyLayoutPrefetchState.prefetchHandleProvider;
            if (editor == null) {
                return DummyHandle.INSTANCE;
            }
            RealNetworkObserver realNetworkObserver = lazyLayoutPrefetchState.prefetchMetrics;
            PrefetchScheduler prefetchScheduler = (PrefetchScheduler) editor.this$0;
            boolean z2 = prefetchScheduler instanceof AndroidPrefetchScheduler;
            PrefetchHandleProvider$HandleAndRequestImpl prefetchHandleProvider$HandleAndRequestImpl = new PrefetchHandleProvider$HandleAndRequestImpl(editor, i, realNetworkObserver, basicTextKt$$ExternalSyntheticLambda3);
            prefetchHandleProvider$HandleAndRequestImpl.premeasureConstraints = new Constraints(j);
            if (!z2) {
                prefetchScheduler.schedulePrefetch(prefetchHandleProvider$HandleAndRequestImpl);
            } else if (z) {
                AndroidPrefetchScheduler androidPrefetchScheduler = (AndroidPrefetchScheduler) prefetchScheduler;
                androidPrefetchScheduler.prefetchRequests.add(new PriorityTask(1, prefetchHandleProvider$HandleAndRequestImpl));
                if (!androidPrefetchScheduler.prefetchScheduled) {
                    androidPrefetchScheduler.prefetchScheduled = true;
                    androidPrefetchScheduler.view.post(androidPrefetchScheduler);
                }
            } else {
                AndroidPrefetchScheduler androidPrefetchScheduler2 = (AndroidPrefetchScheduler) prefetchScheduler;
                androidPrefetchScheduler2.prefetchRequests.add(new PriorityTask(0, prefetchHandleProvider$HandleAndRequestImpl));
                if (!androidPrefetchScheduler2.prefetchScheduled) {
                    androidPrefetchScheduler2.prefetchScheduled = true;
                    androidPrefetchScheduler2.view.post(androidPrefetchScheduler2);
                }
            }
            AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", i);
            return prefetchHandleProvider$HandleAndRequestImpl;
        } catch (Throwable th) {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
