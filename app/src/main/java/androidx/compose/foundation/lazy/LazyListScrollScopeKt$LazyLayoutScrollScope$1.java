package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutationInterruptedException;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.node.NodeChain;
import androidx.work.impl.StartStopTokens;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListScrollScopeKt$LazyLayoutScrollScope$1 implements ScrollScope {
    public final /* synthetic */ Object $$delegate_0;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $state;

    public /* synthetic */ LazyListScrollScopeKt$LazyLayoutScrollScope$1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.$$delegate_0 = obj;
        this.$state = obj2;
    }

    public int getFirstVisibleItemIndex() {
        return ((ParcelableSnapshotMutableIntState) ((LazyListState) this.$state).scrollPosition.call).getIntValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.List] */
    public int getLastVisibleItemIndex() {
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.lastOrNull(((LazyListState) this.$state).getLayoutInfo().visibleItemsInfo);
        if (lazyListMeasuredItem != null) {
            return lazyListMeasuredItem.index;
        }
        return 0;
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public final float scrollBy(float f) {
        switch (this.$r8$classId) {
            case 0:
                return ((ScrollScope) this.$$delegate_0).scrollBy(f);
            case 1:
                AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) this.$$delegate_0;
                float fNewOffsetForDelta$foundation = anchoredDraggableNode.state.newOffsetForDelta$foundation(f);
                float floatValue = fNewOffsetForDelta$foundation - ((ParcelableSnapshotMutableFloatState) anchoredDraggableNode.state.head).getFloatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) this.$state).dragTo(fNewOffsetForDelta$foundation, 0.0f);
                return floatValue;
            case 2:
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.$$delegate_0;
                if (Math.abs(f) == 0.0f || ((Boolean) scrollingLogic.isScrollableNodeAttached.invoke()).booleanValue()) {
                    return scrollingLogic.reverseIfNeeded(scrollingLogic.m104toFloatk4lQ0M(((ScrollingLogic$nestedScrollScope$1) this.$state).m107scrollByWithOverscrollOzD1aCk(2, scrollingLogic.m103reverseIfNeededMKHz9U(scrollingLogic.m105toOffsettuRUvjQ(f)))));
                }
                throw new MutationInterruptedException("The fling animation was cancelled", 1);
            default:
                NodeChain nodeChain = (NodeChain) ((StartStopTokens) this.$$delegate_0).lock;
                float fCoerceIn = RangesKt.coerceIn((Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) ? 0.0f : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) + f, nodeChain.getAnchors().minPosition(), nodeChain.getAnchors().maxPosition());
                float floatValue2 = fCoerceIn - ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) this.$state).dragTo(fCoerceIn, 0.0f);
                return floatValue2;
        }
    }
}
