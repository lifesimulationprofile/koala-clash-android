package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda3;
import coil.disk.DiskLruCache;
import coil.network.RealNetworkObserver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    public int lastNumberOfNestedPrefetchItems;
    public final LazyListState$$ExternalSyntheticLambda3 onNestedPrefetch;
    public DiskLruCache.Editor prefetchHandleProvider;
    public final RealNetworkObserver prefetchMetrics = new RealNetworkObserver(5);
    public int realizedNestedPrefetchCount = -1;
    public int idealNestedPrefetchCount = -1;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class NestedPrefetchScopeImpl {
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    public LazyLayoutPrefetchState(LazyListState$$ExternalSyntheticLambda3 lazyListState$$ExternalSyntheticLambda3) {
        this.onNestedPrefetch = lazyListState$$ExternalSyntheticLambda3;
    }
}
