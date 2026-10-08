package androidx.navigation.compose;

import android.os.IBinder;
import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.ScrollObservationScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestinationBuilder;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1;
import com.github.kr328.kaidl.SuspendTransactionKt$$ExternalSyntheticLambda0;
import com.github.kr328.kaidl.SuspendTransactionKt$suspendTransact$2$link$1;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogHostKt$DialogHost$1$1$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $backStackEntry;
    public final /* synthetic */ Object $dialogNavigator;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogHostKt$DialogHost$1$1$1(int i, Object obj, Object obj2) {
        super(0);
        this.$r8$classId = i;
        this.$dialogNavigator = obj;
        this.$backStackEntry = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v11 */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        SemanticsNode semanticsNode;
        LayoutNode layoutNode;
        Rect rect;
        switch (this.$r8$classId) {
            case 0:
                ((DialogNavigator) this.$dialogNavigator).popBackStack((NavBackStackEntry) this.$backStackEntry, false);
                return Unit.INSTANCE;
            case 1:
                ((CacheDrawModifierNodeImpl) this.$dialogNavigator).block.invoke((CacheDrawScope) this.$backStackEntry);
                return Unit.INSTANCE;
            case 2:
                ((Ref$ObjectRef) this.$dialogNavigator).element = ((FocusTargetNode) this.$backStackEntry).fetchFocusProperties$ui();
                return Unit.INSTANCE;
            case 3:
                ((HitPathTracker) this.$dialogNavigator).removePointerInputModifierNode((Modifier.Node) this.$backStackEntry);
                return Unit.INSTANCE;
            case 4:
                NodeChain nodeChain = ((LayoutNode) this.$dialogNavigator).nodes;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.$backStackEntry;
                if ((((Modifier.Node) nodeChain.head).aggregateChildKindSet & 8) != 0) {
                    for (Modifier.Node node = (TailModifierNode) nodeChain.tail; node != null; node = node.parent) {
                        if ((node.kindSet & 8) != 0) {
                            ?? Access$pop = node;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Access$pop;
                                    if (semanticsModifierNode.getShouldClearDescendantSemantics()) {
                                        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
                                        ref$ObjectRef.element = semanticsConfiguration;
                                        semanticsConfiguration.isClearingSemantics = true;
                                    }
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        ((SemanticsConfiguration) ref$ObjectRef.element).isMergingSemanticsOfDescendants = true;
                                    }
                                    semanticsModifierNode.applySemantics((SemanticsPropertyReceiver) ref$ObjectRef.element);
                                } else if ((Access$pop.kindSet & 8) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                    int i = 0;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 8) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Access$pop = Access$pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Access$pop = node2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        } else {
                                            Access$pop = Access$pop;
                                            mutableVector = mutableVector;
                                        }
                                        node2 = node2.child;
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            case 5:
                Function1 function1 = (Function1) this.$dialogNavigator;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                function1.invoke(reusableGraphicsLayerScope);
                NodeCoordinator nodeCoordinator = (NodeCoordinator) this.$backStackEntry;
                boolean zAreEqual = Intrinsics.areEqual(nodeCoordinator.lastShape, reusableGraphicsLayerScope.shape);
                boolean z = nodeCoordinator.lastClip;
                boolean z2 = reusableGraphicsLayerScope.clip;
                boolean z3 = z != z2;
                if (!zAreEqual || z3) {
                    nodeCoordinator.lastShape = reusableGraphicsLayerScope.shape;
                    nodeCoordinator.lastClip = z2;
                    if (nodeCoordinator.wasLayerBlockInvoked && (z3 || (z2 && !zAreEqual))) {
                        nodeCoordinator.layoutNode.invalidateSemantics$ui();
                    }
                }
                nodeCoordinator.wasLayerBlockInvoked = true;
                reusableGraphicsLayerScope.outline = reusableGraphicsLayerScope.shape.mo57createOutlinePq9zytI(reusableGraphicsLayerScope.size, reusableGraphicsLayerScope.layoutDirection, reusableGraphicsLayerScope.graphicsDensity);
                return Unit.INSTANCE;
            case 6:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) this.$backStackEntry));
            case 7:
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) this.$backStackEntry;
                ScrollObservationScope scrollObservationScope = (ScrollObservationScope) this.$dialogNavigator;
                ScrollAxisRange scrollAxisRange = scrollObservationScope.horizontalScrollAxisRange;
                ScrollAxisRange scrollAxisRange2 = scrollObservationScope.verticalScrollAxisRange;
                Float f = scrollObservationScope.oldXValue;
                Float f2 = scrollObservationScope.oldYValue;
                float fFloatValue = (scrollAxisRange == null || f == null) ? 0.0f : ((Number) scrollAxisRange.value.invoke()).floatValue() - f.floatValue();
                float fFloatValue2 = (scrollAxisRange2 == null || f2 == null) ? 0.0f : ((Number) scrollAxisRange2.value.invoke()).floatValue() - f2.floatValue();
                if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                    int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.semanticsNodeId);
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId);
                    if (semanticsNodeWithAdjustedBounds != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                            if (accessibilityNodeInfoCompat != null) {
                                accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds));
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException unused) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId);
                    if (semanticsNodeWithAdjustedBounds2 != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI;
                            if (accessibilityNodeInfoCompat2 != null) {
                                accessibilityNodeInfoCompat2.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                Unit unit3 = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException unused2) {
                            Unit unit4 = Unit.INSTANCE;
                        }
                    }
                    androidComposeViewAccessibilityDelegateCompat.view.invalidate();
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId);
                    if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.semanticsNode) != null && (layoutNode = semanticsNode.layoutNode) != null) {
                        if (scrollAxisRange != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange);
                        }
                        if (scrollAxisRange2 != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange2);
                        }
                        androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    }
                    break;
                }
                if (scrollAxisRange != null) {
                    scrollObservationScope.oldXValue = (Float) scrollAxisRange.value.invoke();
                }
                if (scrollAxisRange2 != null) {
                    scrollObservationScope.oldYValue = (Float) scrollAxisRange2.value.invoke();
                }
                return Unit.INSTANCE;
            case 8:
                Function0 function0 = (Function0) this.$dialogNavigator;
                if (function0 != null && (rect = (Rect) function0.invoke()) != null) {
                    return rect;
                }
                NodeCoordinator nodeCoordinator2 = (NodeCoordinator) this.$backStackEntry;
                if (!nodeCoordinator2.getTail().isAttached) {
                    nodeCoordinator2 = null;
                }
                if (nodeCoordinator2 != null) {
                    return RectKt.m380Recttz77jQw(0L, IntSizeKt.m721toSizeozmzZPI(nodeCoordinator2.measuredSize));
                }
                return null;
            case 9:
                NavDestinationBuilder navDestinationBuilder = ((ConstraintController) this.$dialogNavigator).tracker;
                ConstraintController$track$1$listener$1 constraintController$track$1$listener$1 = (ConstraintController$track$1$listener$1) this.$backStackEntry;
                synchronized (navDestinationBuilder.arguments) {
                    if (((LinkedHashSet) navDestinationBuilder.actions).remove(constraintController$track$1$listener$1) && ((LinkedHashSet) navDestinationBuilder.actions).isEmpty()) {
                        navDestinationBuilder.stopTracking();
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 10:
                try {
                    ((IBinder) this.$dialogNavigator).unlinkToDeath((SuspendTransactionKt$suspendTransact$2$link$1) this.$backStackEntry, 0);
                    break;
                } catch (Exception unused3) {
                }
                return Unit.INSTANCE;
            default:
                try {
                    ((IBinder) this.$dialogNavigator).unlinkToDeath((SuspendTransactionKt$$ExternalSyntheticLambda0) this.$backStackEntry, 0);
                    break;
                } catch (Exception unused4) {
                }
                return Unit.INSTANCE;
        }
    }
}
