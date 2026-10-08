package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import androidx.work.JobListenableFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface AlignmentLinesOwner extends Measurable {
    void forEachChildAlignmentLinesOwner(JobListenableFuture.AnonymousClass1 anonymousClass1);

    LookaheadAlignmentLines getAlignmentLines();

    InnerNodeCoordinator getInnerCoordinator();

    AlignmentLinesOwner getParentAlignmentLinesOwner();

    int getPlaceOrder();

    void layoutChildren();

    void requestLayout();

    void requestMeasure();
}
