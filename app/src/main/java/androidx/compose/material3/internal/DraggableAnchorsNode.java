package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.work.impl.StartStopTokens;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableAnchorsNode extends Modifier.Node implements LayoutModifierNode {
    public Function2 anchors;
    public boolean didInitializeAnchors;
    public Orientation orientation;
    public StartStopTokens state;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo22measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Object orNull;
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(j);
        boolean z = true;
        if (!measureScope.isLookingAhead() || !this.didInitializeAnchors) {
            Pair pair = (Pair) this.anchors.invoke(new IntSize((((long) placeableMo515measureBRTryo0.width) << 32) | (((long) placeableMo515measureBRTryo0.height) & 4294967295L)), new Constraints(j));
            DefaultDraggableAnchors defaultDraggableAnchors = (DefaultDraggableAnchors) pair.first;
            Object obj = pair.second;
            if (!defaultDraggableAnchors.hasPositionFor(obj) && (orNull = CollectionsKt.getOrNull(0, defaultDraggableAnchors.keys)) != null) {
                obj = orNull;
            }
            NodeChain nodeChain = (NodeChain) this.state.lock;
            DefaultDraggableAnchors anchors = nodeChain.getAnchors();
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) nodeChain.buffer;
            if (!Intrinsics.areEqual(anchors, defaultDraggableAnchors)) {
                ((ParcelableSnapshotMutableState) nodeChain.stack).setValue(defaultDraggableAnchors);
                MutexImpl mutexImpl = ((MutatorMutex) nodeChain.sentinelHead).mutex;
                boolean zTryLock = mutexImpl.tryLock();
                if (zTryLock) {
                    try {
                        AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer;
                        float fPositionOf = nodeChain.getAnchors().positionOf(obj);
                        if (!Float.isNaN(fPositionOf)) {
                            anchoredDraggableState$anchoredDragScope$1.dragTo(fPositionOf, 0.0f);
                            parcelableSnapshotMutableState.setValue(null);
                        }
                        nodeChain.setCurrentValue(obj);
                        ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(obj);
                        mutexImpl.unlock(null);
                    } catch (Throwable th) {
                        mutexImpl.unlock(null);
                        throw th;
                    }
                }
                if (!zTryLock) {
                    parcelableSnapshotMutableState.setValue(obj);
                }
            }
            this.didInitializeAnchors = true;
        }
        if (!measureScope.isLookingAhead() && !this.didInitializeAnchors) {
            z = false;
        }
        this.didInitializeAnchors = z;
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new LifecycleEffectKt$$ExternalSyntheticLambda1(measureScope, this, placeableMo515measureBRTryo0, 15));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo22measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.didInitializeAnchors = false;
    }
}
