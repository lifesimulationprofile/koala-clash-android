package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1;
import androidx.compose.ui.scrollcapture.ScrollCaptureCandidate;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzts {
    public static final void visitScrollCaptureCandidates(SemanticsNode semanticsNode, int i, ScrollCapture$onScrollCaptureSearch$1 scrollCapture$onScrollCaptureSearch$1) {
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16]);
        List children$ui = semanticsNode.getChildren$ui(false, false);
        while (true) {
            mutableVector.addAll(mutableVector.size, children$ui);
            while (true) {
                int i2 = mutableVector.size;
                if (i2 == 0) {
                    return;
                }
                SemanticsNode semanticsNode2 = (SemanticsNode) mutableVector.removeAt(i2 - 1);
                boolean zIsHidden = SemanticsNodeKt.isHidden(semanticsNode2);
                SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
                MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                if (!zIsHidden && !mutableScatterMap.containsKey(SemanticsProperties.Disabled)) {
                    NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode2.findCoordinatorToGetBounds$ui();
                    if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                        throw Modifier.CC.m("Expected semantics node to have a coordinator.");
                    }
                    IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(RulerKt.boundsInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui, true));
                    if (intRectRoundToIntRect.left < intRectRoundToIntRect.right && intRectRoundToIntRect.top < intRectRoundToIntRect.bottom) {
                        Object obj = semanticsConfiguration.props.get(SemanticsActions.ScrollByOffset);
                        if (obj == null) {
                            obj = null;
                        }
                        Function2 function2 = (Function2) obj;
                        Object obj2 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) (obj2 != null ? obj2 : null);
                        if (function2 == null || scrollAxisRange == null || ((Number) scrollAxisRange.maxValue.invoke()).floatValue() <= 0.0f) {
                            children$ui = semanticsNode2.getChildren$ui(false, false);
                        } else {
                            int i3 = 1 + i;
                            scrollCapture$onScrollCaptureSearch$1.invoke(new ScrollCaptureCandidate(semanticsNode2, i3, intRectRoundToIntRect, nodeCoordinatorFindCoordinatorToGetBounds$ui));
                            visitScrollCaptureCandidates(semanticsNode2, i3, scrollCapture$onScrollCaptureSearch$1);
                        }
                    }
                }
            }
        }
    }
}
