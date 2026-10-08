package androidx.work;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.Parcel;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.lazy.LazyListState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draw.ShadowGraphicsLayerElement;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.SimpleGraphicsLayerModifier;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.vector.GroupComponent;
import androidx.compose.ui.graphics.vector.VNode;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RectRulersImpl;
import androidx.compose.ui.layout.WindowInsetsRulers;
import androidx.compose.ui.layout.WindowInsetsRulersImpl;
import androidx.compose.ui.layout.WindowInsetsRulers_androidKt;
import androidx.compose.ui.layout.WindowWindowInsetsAnimationValues;
import androidx.compose.ui.node.AlignmentLinesOwner;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LookaheadAlignmentLines;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.DisposableSaveableStateRegistry;
import androidx.compose.ui.platform.GlobalSnapshotManager;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import coil.disk.RealDiskCache;
import coil.memory.EmptyStrongMemoryCache;
import com.caverock.androidsvg.SVG;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.common.internal.zzd;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JobListenableFuture implements ListenableFuture {
    public final SettableFuture underlying = new SettableFuture();

    /* JADX INFO: renamed from: androidx.work.JobListenableFuture$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            super(1);
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        /* JADX WARN: Type inference failed for: r0v57, types: [androidx.compose.ui.layout.Placeable, androidx.compose.ui.node.AlignmentLinesOwner] */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            int i = this.$r8$classId;
            int i2 = 0;
            Object obj2 = this.this$0;
            switch (i) {
                case 0:
                    Throwable th = (Throwable) obj;
                    JobListenableFuture jobListenableFuture = (JobListenableFuture) obj2;
                    if (th == null) {
                        if (!jobListenableFuture.underlying.isDone()) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    } else if (th instanceof CancellationException) {
                        jobListenableFuture.underlying.cancel(true);
                    } else {
                        SettableFuture settableFuture = jobListenableFuture.underlying;
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            th = cause;
                        }
                        settableFuture.setException(th);
                    }
                    return Unit.INSTANCE;
                case 1:
                    return ((CameraX) obj2).mInitInternalFuture;
                case 2:
                    return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
                case 3:
                    AnimationVector4D animationVector4D = (AnimationVector4D) obj;
                    float f = animationVector4D.v2;
                    if (f < 0.0f) {
                        f = 0.0f;
                    }
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    float f2 = animationVector4D.v3;
                    if (f2 < -0.5f) {
                        f2 = -0.5f;
                    }
                    if (f2 > 0.5f) {
                        f2 = 0.5f;
                    }
                    float f3 = animationVector4D.v4;
                    float f4 = f3 >= -0.5f ? f3 : -0.5f;
                    float f5 = f4 <= 0.5f ? f4 : 0.5f;
                    float f6 = animationVector4D.v1;
                    float f7 = f6 >= 0.0f ? f6 : 0.0f;
                    return new Color(Color.m431convertvNxB06k(BrushKt.Color(f, f2, f5, f7 <= 1.0f ? f7 : 1.0f, ColorSpaces.Oklab), (ColorSpace) obj2));
                case 4:
                    return Boolean.valueOf(!Intrinsics.areEqual(obj, ((Transition) obj2).targetState$delegate.getValue()));
                case 5:
                    ((ReusableGraphicsLayerScope) obj).setAlpha(((Number) ((State) obj2).getValue()).floatValue());
                    return Unit.INSTANCE;
                case 6:
                    return new IntOffset((((long) 0) << 32) | (4294967295L & ((long) ((Number) ((LazyListState$$ExternalSyntheticLambda3) obj2).invoke(Integer.valueOf((int) (((IntSize) obj).packedValue & 4294967295L)))).intValue())));
                case 7:
                    return new IntOffset((((long) 0) << 32) | (4294967295L & ((long) ((Number) ((LazyListState$$ExternalSyntheticLambda3) obj2).invoke(Integer.valueOf((int) (((IntSize) obj).packedValue & 4294967295L)))).intValue())));
                case 8:
                    DragAndDropNode dragAndDropNode = (DragAndDropNode) obj;
                    if (!dragAndDropNode.node.isAttached) {
                        return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                    }
                    DragAndDropNode dragAndDropNode2 = dragAndDropNode.thisDragAndDropTarget;
                    TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                    if (dragAndDropNode2 != null) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(8, (EmptyStrongMemoryCache) obj2);
                        if (anonymousClass1.invoke(dragAndDropNode2) == traversableNode$Companion$TraverseDescendantsAction) {
                            HitTestResultKt.traverseDescendants(dragAndDropNode2, anonymousClass1);
                        }
                    }
                    dragAndDropNode.thisDragAndDropTarget = null;
                    dragAndDropNode.lastChildDragAndDropModifierNode = null;
                    return traversableNode$Companion$TraverseDescendantsAction;
                case 9:
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                    ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj2;
                    reusableGraphicsLayerScope.setShadowElevation(reusableGraphicsLayerScope.graphicsDensity.getDensity() * shadowGraphicsLayerElement.elevation);
                    reusableGraphicsLayerScope.setShape(shadowGraphicsLayerElement.shape);
                    reusableGraphicsLayerScope.setClip(shadowGraphicsLayerElement.clip);
                    reusableGraphicsLayerScope.m446setAmbientShadowColor8_81llA(shadowGraphicsLayerElement.ambientColor);
                    reusableGraphicsLayerScope.m447setSpotShadowColor8_81llA(shadowGraphicsLayerElement.spotColor);
                    return Unit.INSTANCE;
                case 10:
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                    SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = (SimpleGraphicsLayerModifier) obj2;
                    reusableGraphicsLayerScope2.setScaleX(simpleGraphicsLayerModifier.scaleX);
                    reusableGraphicsLayerScope2.setScaleY(simpleGraphicsLayerModifier.scaleY);
                    reusableGraphicsLayerScope2.setAlpha(simpleGraphicsLayerModifier.alpha);
                    reusableGraphicsLayerScope2.setTranslationX(0.0f);
                    reusableGraphicsLayerScope2.setTranslationY(0.0f);
                    reusableGraphicsLayerScope2.setShadowElevation(simpleGraphicsLayerModifier.shadowElevation);
                    reusableGraphicsLayerScope2.setRotationX(0.0f);
                    reusableGraphicsLayerScope2.setRotationY(0.0f);
                    reusableGraphicsLayerScope2.setRotationZ(simpleGraphicsLayerModifier.rotationZ);
                    float f8 = simpleGraphicsLayerModifier.cameraDistance;
                    if (reusableGraphicsLayerScope2.cameraDistance != f8) {
                        reusableGraphicsLayerScope2.mutatedFields |= 2048;
                        reusableGraphicsLayerScope2.cameraDistance = f8;
                    }
                    reusableGraphicsLayerScope2.m448setTransformOrigin__ExYCQ(simpleGraphicsLayerModifier.transformOrigin);
                    reusableGraphicsLayerScope2.setShape(simpleGraphicsLayerModifier.shape);
                    reusableGraphicsLayerScope2.setClip(simpleGraphicsLayerModifier.clip);
                    reusableGraphicsLayerScope2.m446setAmbientShadowColor8_81llA(simpleGraphicsLayerModifier.ambientShadowColor);
                    reusableGraphicsLayerScope2.m447setSpotShadowColor8_81llA(simpleGraphicsLayerModifier.spotShadowColor);
                    int i3 = simpleGraphicsLayerModifier.blendMode;
                    if (reusableGraphicsLayerScope2.blendMode != i3) {
                        reusableGraphicsLayerScope2.mutatedFields |= 524288;
                        reusableGraphicsLayerScope2.blendMode = i3;
                    }
                    return Unit.INSTANCE;
                case 11:
                    DrawScope drawScope = (DrawScope) obj;
                    GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                    AndroidPath androidPath = graphicsLayer.outlinePath;
                    if (graphicsLayer.usePathForClip && graphicsLayer.clip && androidPath != null) {
                        SVG drawContext = drawScope.getDrawContext();
                        long jM795getSizeNHjbRc = drawContext.m795getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            ((SVG) ((RealDiskCache.RealEditor) drawContext.rootElement).editor).getCanvas().mo390clipPathmtrdDE(androidPath);
                            graphicsLayer.drawWithChildTracking(drawScope);
                        } finally {
                            ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM795getSizeNHjbRc);
                        }
                    } else {
                        graphicsLayer.drawWithChildTracking(drawScope);
                    }
                    return Unit.INSTANCE;
                case 12:
                    VNode vNode = (VNode) obj;
                    GroupComponent groupComponent = (GroupComponent) obj2;
                    groupComponent.markTintForVNode(vNode);
                    Function1 function1 = groupComponent.invalidateListener;
                    if (function1 != null) {
                        function1.invoke(vNode);
                    }
                    return Unit.INSTANCE;
                case 13:
                    Throwable th2 = (Throwable) obj;
                    SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj2;
                    CancellableContinuationImpl cancellableContinuationImpl = pointerEventHandlerCoroutine.pointerAwaiter;
                    if (cancellableContinuationImpl != null) {
                        cancellableContinuationImpl.cancel(th2);
                    }
                    pointerEventHandlerCoroutine.pointerAwaiter = null;
                    return Unit.INSTANCE;
                case 14:
                    AlignmentLinesOwner alignmentLinesOwner = (AlignmentLinesOwner) obj;
                    LookaheadAlignmentLines lookaheadAlignmentLines = (LookaheadAlignmentLines) obj2;
                    if (alignmentLinesOwner.getPlaceOrder() != Integer.MAX_VALUE) {
                        if (alignmentLinesOwner.getAlignmentLines().dirty) {
                            alignmentLinesOwner.layoutChildren();
                        }
                        for (Map.Entry entry : alignmentLinesOwner.getAlignmentLines().alignmentLineMap.entrySet()) {
                            LookaheadAlignmentLines.access$addAlignmentLine(lookaheadAlignmentLines, (AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), alignmentLinesOwner.getInnerCoordinator());
                        }
                        for (NodeCoordinator nodeCoordinator = alignmentLinesOwner.getInnerCoordinator().wrappedBy; !nodeCoordinator.equals(lookaheadAlignmentLines.alignmentLinesOwner.getInnerCoordinator()); nodeCoordinator = nodeCoordinator.wrappedBy) {
                            for (AlignmentLine alignmentLine : lookaheadAlignmentLines.getAlignmentLinesMap(nodeCoordinator).keySet()) {
                                LookaheadAlignmentLines.access$addAlignmentLine(lookaheadAlignmentLines, alignmentLine, lookaheadAlignmentLines.getPositionFor(nodeCoordinator, alignmentLine), nodeCoordinator);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 15:
                    ((MutableVector) obj2).add((Modifier.Element) obj);
                    return Boolean.TRUE;
                case 16:
                    return Boolean.valueOf(((FocusTargetNode) obj).m350requestFocus3ESFkO8(((FocusDirection) obj2).value));
                case 17:
                    LookaheadCapablePlaceable.ResettableRulerScope resettableRulerScope = (LookaheadCapablePlaceable.ResettableRulerScope) obj;
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    if (androidComposeView.getInsetsListener().generation.getIntValue() > 0) {
                        MutableIntObjectMap mutableIntObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
                        resettableRulerScope.coordinatesAccessed = true;
                        LookaheadCapablePlaceable lookaheadCapablePlaceable = LookaheadCapablePlaceable.this;
                        LayoutCoordinates coordinates = lookaheadCapablePlaceable.getCoordinates();
                        if (IntOffset.m709equalsimpl0(resettableRulerScope.positionOnScreen, 9223372034707292159L)) {
                            resettableRulerScope.positionOnScreen = IntOffsetKt.m714roundk4lQ0M(coordinates.mo524localToScreenMKHz9U(0L));
                            resettableRulerScope.size = coordinates.mo520getSizeYbymL2g();
                        }
                        lookaheadCapablePlaceable.getLayoutNode().layoutDelegate.onCoordinatesUsed();
                        long jMo520getSizeYbymL2g = coordinates.mo520getSizeYbymL2g();
                        MutableScatterMap mutableScatterMap = androidComposeView.getInsetsListener().insetsValues;
                        int i4 = (int) (jMo520getSizeYbymL2g >> 32);
                        int i5 = (int) (4294967295L & jMo520getSizeYbymL2g);
                        for (WindowInsetsRulers windowInsetsRulers : WindowInsetsRulers_androidKt.AnimatableInsetsRulers) {
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = (WindowWindowInsetsAnimationValues) mutableScatterMap.get(windowInsetsRulers);
                            WindowInsetsRulersImpl windowInsetsRulersImpl = (WindowInsetsRulersImpl) windowInsetsRulers;
                            WindowInsetsRulers_androidKt.m538provideInsetsValuescytEWk0(resettableRulerScope, windowInsetsRulersImpl.current, windowWindowInsetsAnimationValues.current, i4, i5);
                            if (((Boolean) windowWindowInsetsAnimationValues.isAnimating$delegate.getValue()).booleanValue()) {
                                WindowInsetsRulers_androidKt.m538provideInsetsValuescytEWk0(resettableRulerScope, windowWindowInsetsAnimationValues.source, windowWindowInsetsAnimationValues.sourceValueInsets, i4, i5);
                                WindowInsetsRulers_androidKt.m538provideInsetsValuescytEWk0(resettableRulerScope, windowWindowInsetsAnimationValues.target, windowWindowInsetsAnimationValues.targetValueInsets, i4, i5);
                            }
                            WindowInsetsRulers_androidKt.m538provideInsetsValuescytEWk0(resettableRulerScope, windowInsetsRulersImpl.maximum, windowWindowInsetsAnimationValues.maximum, i4, i5);
                        }
                        MutableObjectList mutableObjectList = androidComposeView.getInsetsListener().displayCutouts;
                        if (mutableObjectList.isNotEmpty()) {
                            SnapshotStateList snapshotStateList = androidComposeView.getInsetsListener().displayCutoutRulers;
                            Object[] objArr = mutableObjectList.content;
                            int i6 = mutableObjectList._size;
                            while (i2 < i6) {
                                MutableState mutableState = (MutableState) objArr[i2];
                                RectRulersImpl rectRulersImpl = (RectRulersImpl) snapshotStateList.get(i2);
                                Rect rect = (Rect) mutableState.getValue();
                                resettableRulerScope.provides(rectRulersImpl.getLeft(), rect.left);
                                resettableRulerScope.provides(rectRulersImpl.getTop(), rect.top);
                                resettableRulerScope.provides(rectRulersImpl.getRight(), rect.right);
                                resettableRulerScope.provides(rectRulersImpl.getBottom(), rect.bottom);
                                i2++;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 18:
                    return Boolean.valueOf(((IntObjectMap) obj2).containsKey(((SemanticsNode) obj).id));
                case 19:
                    return Boolean.valueOf(InvertMatrixKt.access$isScreenReaderFocusable((SemanticsNode) obj, (Resources) obj2));
                case 20:
                    return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(12, (DisposableSaveableStateRegistry) obj2);
                case 21:
                    if (GlobalSnapshotManager.sent.compareAndSet(false, true)) {
                        ((BufferedChannel) obj2).mo851trySendJP2dKIU(Unit.INSTANCE);
                    }
                    return Unit.INSTANCE;
                case 22:
                    DrawScope drawScope2 = (DrawScope) obj;
                    Canvas canvas = drawScope2.getDrawContext().getCanvas();
                    Function2 function2 = ((GraphicsLayerOwnerLayer) obj2).drawBlock;
                    if (function2 != null) {
                        function2.invoke(canvas, (GraphicsLayer) drawScope2.getDrawContext().cssRules);
                    }
                    return Unit.INSTANCE;
                case 23:
                    NullableInputConnectionWrapperApi21 nullableInputConnectionWrapperApi21 = (NullableInputConnectionWrapperApi21) obj;
                    RecordingInputConnection recordingInputConnection = nullableInputConnectionWrapperApi21.delegate;
                    if (recordingInputConnection != null) {
                        nullableInputConnectionWrapperApi21.closeDelegate(recordingInputConnection);
                        nullableInputConnectionWrapperApi21.delegate = null;
                    }
                    InputMethodSession inputMethodSession = (InputMethodSession) obj2;
                    MutableVector mutableVector = inputMethodSession.connections;
                    Object[] objArr2 = mutableVector.content;
                    int i7 = mutableVector.size;
                    while (true) {
                        if (i2 >= i7) {
                            i2 = -1;
                        } else if (!Intrinsics.areEqual((WeakReference) objArr2[i2], nullableInputConnectionWrapperApi21)) {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        mutableVector.removeAt(i2);
                    }
                    if (mutableVector.size == 0) {
                        inputMethodSession.onAllConnectionsClosed.invoke();
                    }
                    return Unit.INSTANCE;
                case 24:
                    if (((Throwable) obj) != null) {
                        ((CancellationSignal) obj2).cancel();
                    }
                    return Unit.INSTANCE;
                case 25:
                    SemanticsPropertiesKt.m614setRolekuIjeqM((SemanticsPropertyReceiver) obj, ((Role) obj2).value);
                    return Unit.INSTANCE;
                case 26:
                    SemanticsPropertiesKt.setContentDescription((SemanticsPropertyReceiver) obj, (String) obj2);
                    return Unit.INSTANCE;
                case 27:
                    ((List) obj).add((Float) ((LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1) obj2).invoke());
                    return true;
                case 28:
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    Navigator navigator = (Navigator) obj2;
                    NavDestination navDestination = navBackStackEntry.destination;
                    if (navDestination == null) {
                        navDestination = null;
                    }
                    if (navDestination == null) {
                        return null;
                    }
                    navBackStackEntry.getArguments();
                    NavDestination navDestinationNavigate = navigator.navigate(navDestination);
                    if (navDestinationNavigate == null) {
                        return null;
                    }
                    if (navDestinationNavigate.equals(navDestination)) {
                        return navBackStackEntry;
                    }
                    NavController$NavControllerNavigatorState state = navigator.getState();
                    Bundle bundleAddInDefaultArgs = navDestinationNavigate.addInDefaultArgs(navBackStackEntry.getArguments());
                    NavHostController navHostController = state.this$0;
                    return zzd.create$default(navHostController.context, navDestinationNavigate, bundleAddInDefaultArgs, navHostController.getHostLifecycleState$navigation_runtime_release(), navHostController.viewModel);
                default:
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        ((IBinder) obj2).transact(1, parcelObtain, null, 0);
                        break;
                    } catch (Exception unused) {
                    } finally {
                        parcelObtain.recycle();
                    }
                    return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Navigator navigator, NavOptions navOptions) {
            super(1);
            this.$r8$classId = 28;
            this.this$0 = navigator;
        }
    }

    public JobListenableFuture(JobImpl jobImpl) {
        jobImpl.invokeOnCompletion(new AnonymousClass1(0, this));
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.underlying.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.underlying.value instanceof AbstractFuture.Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.underlying.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.underlying.get(j, timeUnit);
    }
}
