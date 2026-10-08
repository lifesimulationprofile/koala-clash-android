package androidx.compose.ui.node;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.TransitionData;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.DialogNavigator;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.HttpException;
import com.caverock.androidsvg.SVG;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeDrawScope$record$1 extends Lambda implements Function1 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ Object $currentDrawNode;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeDrawScope$record$1(FocusTargetNode focusTargetNode, FocusOwnerImpl focusOwnerImpl, Function1 function1) {
        super(1);
        this.$r8$classId = 5;
        this.this$0 = focusTargetNode;
        this.$currentDrawNode = focusOwnerImpl;
        this.$block = (Lambda) function1;
    }

    /* JADX WARN: Type inference failed for: r2v34, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zBooleanValue;
        switch (this.$r8$classId) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) this.this$0;
                DrawModifierNode drawModifierNode = layoutNodeDrawScope.drawNode;
                layoutNodeDrawScope.drawNode = (DrawModifierNode) this.$currentDrawNode;
                try {
                    Density density = drawScope.getDrawContext().getDensity();
                    LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                    Canvas canvas = drawScope.getDrawContext().getCanvas();
                    long jM795getSizeNHjbRc = drawScope.getDrawContext().m795getSizeNHjbRc();
                    GraphicsLayer graphicsLayer = (GraphicsLayer) drawScope.getDrawContext().cssRules;
                    Function1 function1 = (Function1) this.$block;
                    Density density2 = layoutNodeDrawScope.getDrawContext().getDensity();
                    LayoutDirection layoutDirection2 = layoutNodeDrawScope.getDrawContext().getLayoutDirection();
                    Canvas canvas2 = layoutNodeDrawScope.getDrawContext().getCanvas();
                    long jM795getSizeNHjbRc2 = layoutNodeDrawScope.getDrawContext().m795getSizeNHjbRc();
                    GraphicsLayer graphicsLayer2 = (GraphicsLayer) layoutNodeDrawScope.getDrawContext().cssRules;
                    SVG drawContext = layoutNodeDrawScope.getDrawContext();
                    drawContext.setDensity(density);
                    drawContext.setLayoutDirection(layoutDirection);
                    drawContext.setCanvas(canvas);
                    drawContext.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
                    drawContext.cssRules = graphicsLayer;
                    canvas.save();
                    try {
                        function1.invoke(layoutNodeDrawScope);
                        canvas.restore();
                        SVG drawContext2 = layoutNodeDrawScope.getDrawContext();
                        drawContext2.setDensity(density2);
                        drawContext2.setLayoutDirection(layoutDirection2);
                        drawContext2.setCanvas(canvas2);
                        drawContext2.m797setSizeuvyYCjk(jM795getSizeNHjbRc2);
                        drawContext2.cssRules = graphicsLayer2;
                        layoutNodeDrawScope.drawNode = drawModifierNode;
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        canvas.restore();
                        SVG drawContext3 = layoutNodeDrawScope.getDrawContext();
                        drawContext3.setDensity(density2);
                        drawContext3.setLayoutDirection(layoutDirection2);
                        drawContext3.setCanvas(canvas2);
                        drawContext3.m797setSizeuvyYCjk(jM795getSizeNHjbRc2);
                        drawContext3.cssRules = graphicsLayer2;
                        throw th;
                    }
                } catch (Throwable th2) {
                    layoutNodeDrawScope.drawNode = drawModifierNode;
                    throw th2;
                }
            case 1:
                return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1((SnapshotStateList) this.this$0, this.$currentDrawNode, (AnimatedContentTransitionScopeImpl) this.$block);
            case 2:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                State state = (State) this.$currentDrawNode;
                State state2 = (State) this.this$0;
                reusableGraphicsLayerScope.setAlpha(state2 != null ? ((Number) state2.getValue()).floatValue() : 1.0f);
                reusableGraphicsLayerScope.setScaleX(state != null ? ((Number) state.getValue()).floatValue() : 1.0f);
                reusableGraphicsLayerScope.setScaleY(state != null ? ((Number) state.getValue()).floatValue() : 1.0f);
                State state3 = (State) this.$block;
                reusableGraphicsLayerScope.m448setTransformOrigin__ExYCQ(state3 != null ? ((TransformOrigin) state3.getValue()).packedValue : TransformOrigin.Center);
                return Unit.INSTANCE;
            case 3:
                ExitTransitionImpl exitTransitionImpl = (ExitTransitionImpl) this.$block;
                int iOrdinal = ((EnterExitState) obj).ordinal();
                TransformOrigin transformOrigin = null;
                if (iOrdinal == 0) {
                    TransitionData transitionData = exitTransitionImpl.data;
                } else if (iOrdinal == 1) {
                    transformOrigin = (TransformOrigin) this.this$0;
                } else {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    TransitionData transitionData2 = exitTransitionImpl.data;
                }
                return new TransformOrigin(transformOrigin != null ? transformOrigin.packedValue : TransformOrigin.Center);
            case 4:
                TraversableNode traversableNode = (TraversableNode) obj;
                DragAndDropNode dragAndDropNode = (DragAndDropNode) traversableNode;
                if (!((AndroidDragAndDropManager) ((AndroidComposeView) HitTestResultKt.requireOwner((DragAndDropNode) this.$currentDrawNode)).m597getDragAndDropManager()).interestedTargets.contains(dragAndDropNode) || !DragAndDropNodeKt.m335access$containsUv8p0NA(dragAndDropNode, DragAndDrop_androidKt.getPositionInRoot((EmptyStrongMemoryCache) this.$block))) {
                    return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                }
                ((Ref$ObjectRef) this.this$0).element = traversableNode;
                return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
            case 5:
                FocusTargetNode focusTargetNode = (FocusTargetNode) obj;
                if (Intrinsics.areEqual(focusTargetNode, (FocusTargetNode) this.this$0)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, ((FocusOwnerImpl) this.$currentDrawNode).rootFocusNode)) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    zBooleanValue = ((Boolean) ((Lambda) this.$block).invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            default:
                SnapshotStateList snapshotStateList = (SnapshotStateList) this.this$0;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.$currentDrawNode;
                snapshotStateList.add(navBackStackEntry);
                return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1((DialogNavigator) this.$block, navBackStackEntry, snapshotStateList, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope$record$1(Object obj, Object obj2, Object obj3, int i) {
        super(1);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$currentDrawNode = obj2;
        this.$block = obj3;
    }
}
