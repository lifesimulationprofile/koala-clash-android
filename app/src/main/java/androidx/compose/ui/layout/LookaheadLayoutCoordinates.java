package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m531getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        return Offset.m370minusMKHz9U(mo522localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, 0L), lookaheadDelegate.coordinator.mo522localPositionOfS_NoaFU(rootLookaheadDelegate.coordinator, 0L));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinator = ((NodeCoordinator) this.lookaheadDelegate.coordinator.layoutNode.nodes.outerCoordinator).wrappedBy;
        if (nodeCoordinator == null || (lookaheadDelegate = nodeCoordinator.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo520getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return (((long) lookaheadDelegate.width) << 32) | (((long) lookaheadDelegate.height) & 4294967295L);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        return this.lookaheadDelegate.coordinator.getTail().isAttached;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return this.lookaheadDelegate.coordinator.localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public final long mo521localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo522localPositionOfS_NoaFU(layoutCoordinates, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public final long mo522localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j) {
        boolean z = layoutCoordinates instanceof LookaheadLayoutCoordinates;
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (!z) {
            LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
            NodeCoordinator nodeCoordinator = rootLookaheadDelegate.coordinator;
            long jMo522localPositionOfS_NoaFU = mo522localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, j);
            long j2 = rootLookaheadDelegate.position;
            long jM370minusMKHz9U = Offset.m370minusMKHz9U(jMo522localPositionOfS_NoaFU, (4294967295L & ((long) Float.floatToRawIntBits((int) (j2 & 4294967295L)))) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32));
            if (!nodeCoordinator.getTail().isAttached) {
                InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
            }
            nodeCoordinator.onCoordinatesUsed$ui();
            NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator = nodeCoordinator2;
            }
            return Offset.m371plusMKHz9U(jM370minusMKHz9U, nodeCoordinator.mo522localPositionOfS_NoaFU(layoutCoordinates, 0L));
        }
        LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
        NodeCoordinator nodeCoordinator3 = lookaheadDelegate2.coordinator;
        nodeCoordinator3.onCoordinatesUsed$ui();
        LookaheadDelegate lookaheadDelegate3 = lookaheadDelegate.coordinator.findCommonAncestor$ui(nodeCoordinator3).getLookaheadDelegate();
        if (lookaheadDelegate3 != null) {
            long jM710minusqkQi6aY = IntOffset.m710minusqkQi6aY(IntOffset.m711plusqkQi6aY(lookaheadDelegate2.m554positionIniSbpLlY$ui(lookaheadDelegate3, false), IntOffsetKt.m714roundk4lQ0M(j)), lookaheadDelegate.m554positionIniSbpLlY$ui(lookaheadDelegate3, false));
            return (((long) Float.floatToRawIntBits((int) (jM710minusqkQi6aY >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jM710minusqkQi6aY & 4294967295L))) & 4294967295L);
        }
        LookaheadDelegate rootLookaheadDelegate2 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long jM711plusqkQi6aY = IntOffset.m711plusqkQi6aY(IntOffset.m711plusqkQi6aY(lookaheadDelegate2.m554positionIniSbpLlY$ui(rootLookaheadDelegate2, false), rootLookaheadDelegate2.position), IntOffsetKt.m714roundk4lQ0M(j));
        LookaheadDelegate rootLookaheadDelegate3 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        long jM710minusqkQi6aY2 = IntOffset.m710minusqkQi6aY(jM711plusqkQi6aY, IntOffset.m711plusqkQi6aY(lookaheadDelegate.m554positionIniSbpLlY$ui(rootLookaheadDelegate3, false), rootLookaheadDelegate3.position));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jM710minusqkQi6aY2 >> 32));
        return rootLookaheadDelegate3.coordinator.wrappedBy.mo522localPositionOfS_NoaFU(rootLookaheadDelegate2.coordinator.wrappedBy, (((long) Float.floatToRawIntBits((int) (jM710minusqkQi6aY2 & 4294967295L))) & 4294967295L) | (jFloatToRawIntBits << 32));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public final long mo523localToRootMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo523localToRootMKHz9U(Offset.m371plusMKHz9U(j, m531getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public final long mo524localToScreenMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo524localToScreenMKHz9U(Offset.m371plusMKHz9U(0L, m531getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public final long mo525localToWindowMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo525localToWindowMKHz9U(Offset.m371plusMKHz9U(j, m531getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public final long mo526screenToLocalMKHz9U(long j) {
        return Offset.m371plusMKHz9U(this.lookaheadDelegate.coordinator.mo526screenToLocalMKHz9U(j), m531getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public final void mo527transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        this.lookaheadDelegate.coordinator.mo527transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public final void mo528transformToScreen58bKbWc(float[] fArr) {
        this.lookaheadDelegate.coordinator.mo528transformToScreen58bKbWc(fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public final long mo529windowToLocalMKHz9U(long j) {
        return Offset.m371plusMKHz9U(this.lookaheadDelegate.coordinator.mo529windowToLocalMKHz9U(j), m531getLookaheadOffsetF1C5BW0());
    }
}
