package androidx.lifecycle.compose;

import android.R;
import android.app.RemoteAction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.textclassifier.TextClassification;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.AnchoredDraggableUninitializedException;
import androidx.compose.material3.internal.DraggableAnchorsNode;
import androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1;
import androidx.compose.material3.internal.ripple.BorderKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.disk.RealDiskCache;
import coil.memory.RealStrongMemoryCache;
import coil.util.ContinuationCallback;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$3;
import com.github.kr328.clash.compose.connections.ComposableSingletons$ConnectionsScreenKt;
import com.github.kr328.clash.compose.sharetotv.ShareToTvScreenKt$ShareToTvScreen$2$invoke$lambda$5$lambda$4$lambda$3$$inlined$items$default$4;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LifecycleEffectKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, Job job, ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1) {
        this.$r8$classId = 3;
        this.f$0 = contentInViewNode;
        this.f$1 = job;
        this.f$2 = scrollingLogic$nestedScrollScope$1;
    }

    private final Object invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$ShareToTvScreen$2$$ExternalSyntheticLambda0(Object obj) {
        AppColors appColors = (AppColors) this.f$0;
        State state = (State) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        LazyItemScope$CC.item$default(lazyListIntervalContent, null, new ComposableLambdaImpl(-935337207, new LogsScreenKt.AnonymousClass4.AnonymousClass2(appColors, 8), true), 3);
        List list = (List) state.getValue();
        lazyListIntervalContent.items(list.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(15, list, new AsyncImagePainter$$ExternalSyntheticLambda0(26)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(16, list), new ComposableLambdaImpl(802480018, new ShareToTvScreenKt$ShareToTvScreen$2$invoke$lambda$5$lambda$4$lambda$3$$inlined$items$default$4(0, list, function1), true));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6, types: [androidx.compose.ui.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        long jFloatToRawIntBits;
        ?? r25;
        Canvas canvas;
        ComposableLambdaImpl composableLambdaImpl;
        ComposableLambdaImpl composableLambdaImpl2;
        int i = this.$r8$classId;
        Fill fill = Fill.INSTANCE;
        int i2 = 5;
        int i3 = 11;
        int i4 = 6;
        int i5 = 3;
        ComposableLambdaImpl composableLambdaImpl3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        final int i6 = 2;
        final int i7 = 0;
        ?? r8 = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        final int i8 = 1;
        switch (i) {
            case 0:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj3;
                final LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) obj2;
                final Function1 function1 = (Function1) r8;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda3
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                        int i9 = LifecycleEffectKt.WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                        Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                        if (i9 == 1) {
                            ref$ObjectRef2.element = function1.invoke(lifecycleStartStopEffectScope);
                        } else {
                            if (i9 != 2) {
                                return;
                            }
                            BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 = (BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1) ref$ObjectRef2.element;
                            if (backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 != null) {
                                backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1.runStopOrDisposeEffect();
                            }
                            ref$ObjectRef2.element = null;
                        }
                    }
                };
                lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(lifecycleOwner, lifecycleEventObserver, ref$ObjectRef, 3);
            case 1:
                RoundRect roundRect = (RoundRect) obj2;
                Brush brush = (Brush) r8;
                DrawScope drawScope = (DrawScope) obj;
                float fFloatValue = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) ((Request) obj3).method).f$0).floatValue();
                float f = fFloatValue < 0.0f ? 0.0f : fFloatValue;
                float f2 = 2;
                float f3 = f / f2;
                float f4 = f2 * f;
                float fMin = Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
                float f5 = roundRect.top;
                float f6 = roundRect.left;
                boolean z4 = f4 > fMin;
                long j = roundRect.topLeftCornerRadius;
                Stroke stroke = new Stroke(f, 0.0f, 0, 0, 30);
                if (z4) {
                    Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), j, 0.0f, null, null, 0, 240);
                } else if (Float.intBitsToFloat((int) (j >> 32)) < f3) {
                    float f7 = f6 + f;
                    float f8 = f5 + f;
                    float f9 = roundRect.right - f;
                    float f10 = roundRect.bottom - f;
                    SVG drawContext = drawScope.getDrawContext();
                    long jM795getSizeNHjbRc = drawContext.m795getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        ((RealDiskCache.RealEditor) drawContext.rootElement).m784clipRectN_I0leg(f7, f8, f9, f10, 0);
                        Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), j, 0.0f, null, null, 0, 240);
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM795getSizeNHjbRc);
                    }
                } else {
                    Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6 + f3)) << 32) | (((long) Float.floatToRawIntBits(f5 + f3)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth() - f)) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight() - f)) & 4294967295L), CoroutineContext.DefaultImpls.m838shrinkKibmq7A(f3, j), 0.0f, stroke, null, 0, 208);
                }
                return Unit.INSTANCE;
            case 2:
                Rect rect = (Rect) obj2;
                float f11 = rect.top;
                float f12 = rect.bottom;
                float f13 = rect.left;
                float f14 = rect.right;
                Brush brush2 = (Brush) r8;
                DrawScope drawScope2 = (DrawScope) obj;
                float fFloatValue2 = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) ((Request) obj3).method).f$0).floatValue();
                float f15 = fFloatValue2 < 0.0f ? 0.0f : fFloatValue2;
                float f16 = 2;
                boolean z5 = f15 * f16 > Math.min(Math.abs(f14 - f13), Math.abs(f12 - f11));
                if (z5) {
                    jFloatToRawIntBits = rect.m378getTopLeftF1C5BW0();
                } else {
                    float f17 = f15 / f16;
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f13 + f17)) << 32) | (((long) Float.floatToRawIntBits(f17 + f11)) & 4294967295L);
                }
                Modifier.CC.m313drawRectAsUm42w$default(drawScope2, brush2, jFloatToRawIntBits, z5 ? rect.m377getSizeNHjbRc() : (((long) Float.floatToRawIntBits((f14 - f13) - f15)) << 32) | (((long) Float.floatToRawIntBits((f12 - f11) - f15)) & 4294967295L), 0.0f, z5 ? fill : new Stroke(f15, 0.0f, 0, 0, 30), null, 0, 104);
                return Unit.INSTANCE;
            case 3:
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj3;
                Job job = (Job) obj2;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) r8;
                float fFloatValue3 = ((Float) obj).floatValue();
                float f18 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                long jM103reverseIfNeededMKHz9U = scrollingLogic.m103reverseIfNeededMKHz9U(scrollingLogic.m105toOffsettuRUvjQ(f18 * fFloatValue3));
                ScrollingLogic scrollingLogic2 = scrollingLogic$nestedScrollScope$1.this$0;
                float fM104toFloatk4lQ0M = scrollingLogic.m104toFloatk4lQ0M(scrollingLogic.m103reverseIfNeededMKHz9U(scrollingLogic2.m102performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM103reverseIfNeededMKHz9U, 1))) * f18;
                if (Math.abs(fM104toFloatk4lQ0M) < Math.abs(fFloatValue3)) {
                    CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + fM104toFloatk4lQ0M + " < " + fFloatValue3 + ')');
                    cancellationException.initCause(null);
                    job.cancel(cancellationException);
                }
                return Unit.INSTANCE;
            case 4:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj3;
                AnimationScope animationScope = (AnimationScope) obj;
                float fFloatValue4 = ((Number) animationScope.value$delegate.getValue()).floatValue() - ref$FloatRef.element;
                float fScrollBy = ((ScrollScope) obj2).scrollBy(fFloatValue4);
                ref$FloatRef.element = ((Number) animationScope.value$delegate.getValue()).floatValue();
                ((Ref$FloatRef) r8).element = ((Number) animationScope.getVelocity()).floatValue();
                if (Math.abs(fFloatValue4 - fScrollBy) > 0.5f) {
                    animationScope.cancelAnimation();
                }
                return Unit.INSTANCE;
            case 5:
                MutableState mutableState = (MutableState) obj3;
                ArrayList arrayList = (ArrayList) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                placementScope.motionFrameOfReferencePlacement = true;
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((LazyListMeasuredItem) arrayList.get(i9)).place(placementScope);
                }
                int size2 = r8.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    ((LazyListMeasuredItem) r8.get(i10)).place(placementScope);
                }
                Unit unit = Unit.INSTANCE;
                placementScope.motionFrameOfReferencePlacement = false;
                mutableState.getValue();
                return Unit.INSTANCE;
            case 6:
                Function1 function2 = (Function1) r8;
                MutableState mutableState2 = (MutableState) obj2;
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                ((MutableState) obj3).setValue(textFieldValue);
                boolean zAreEqual = Intrinsics.areEqual((String) mutableState2.getValue(), textFieldValue.annotatedString.text);
                AnnotatedString annotatedString = textFieldValue.annotatedString;
                mutableState2.setValue(annotatedString.text);
                if (!zAreEqual) {
                    function2.invoke(annotatedString.text);
                }
                return Unit.INSTANCE;
            case 7:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj3;
                long j2 = ((TextFieldValue) obj2).selection;
                OffsetMapping offsetMapping = (OffsetMapping) r8;
                DrawScope drawScope3 = (DrawScope) obj;
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    Canvas canvas2 = drawScope3.getDrawContext().getCanvas();
                    long j3 = ((TextRange) legacyTextFieldState.selectionPreviewHighlightRange$delegate.getValue()).packedValue;
                    long j4 = ((TextRange) legacyTextFieldState.deletionPreviewHighlightRange$delegate.getValue()).packedValue;
                    TextLayoutResult textLayoutResult = layoutResult.value;
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
                    AndroidPaint androidPaint = legacyTextFieldState.highlightPaint;
                    long j5 = j4;
                    long j6 = legacyTextFieldState.selectionBackgroundColor;
                    if (!TextRange.m639getCollapsedimpl(j3)) {
                        androidPaint.m402setColor8_81llA(j6);
                        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m642getMinimpl(j3));
                        int iOriginalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m641getMaximpl(j3));
                        if (iOriginalToTransformed != iOriginalToTransformed2) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed, iOriginalToTransformed2), androidPaint);
                        }
                    } else if (!TextRange.m639getCollapsedimpl(j5)) {
                        long jM647getColor0d7_KjU = textLayoutInput.style.m647getColor0d7_KjU();
                        Color color = jM647getColor0d7_KjU == 16 ? null : new Color(jM647getColor0d7_KjU);
                        long j7 = color != null ? color.value : Color.Black;
                        androidPaint.m402setColor8_81llA(BrushKt.Color(Color.m438getRedimpl(j7), Color.m437getGreenimpl(j7), Color.m435getBlueimpl(j7), Color.m434getAlphaimpl(j7) * 0.2f, Color.m436getColorSpaceimpl(j7)));
                        int iOriginalToTransformed3 = offsetMapping.originalToTransformed(TextRange.m642getMinimpl(j5));
                        int iOriginalToTransformed4 = offsetMapping.originalToTransformed(TextRange.m641getMaximpl(j5));
                        if (iOriginalToTransformed3 != iOriginalToTransformed4) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed3, iOriginalToTransformed4), androidPaint);
                        }
                    } else if (!TextRange.m639getCollapsedimpl(j2)) {
                        androidPaint.m402setColor8_81llA(j6);
                        int iOriginalToTransformed5 = offsetMapping.originalToTransformed(TextRange.m642getMinimpl(j2));
                        int iOriginalToTransformed6 = offsetMapping.originalToTransformed(TextRange.m641getMaximpl(j2));
                        if (iOriginalToTransformed5 != iOriginalToTransformed6) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed5, iOriginalToTransformed6), androidPaint);
                        }
                    }
                    boolean z6 = textLayoutResult.getHasVisualOverflow() && textLayoutInput.overflow != 3;
                    if (z6) {
                        long j8 = textLayoutResult.size;
                        Rect rectM380Recttz77jQw = RectKt.m380Recttz77jQw(0L, (((long) Float.floatToRawIntBits((int) (j8 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j8 & 4294967295L))) & 4294967295L));
                        canvas2.save();
                        canvas2.mo392clipRectmtrdDE(rectM380Recttz77jQw);
                    }
                    SpanStyle spanStyle = textLayoutInput.style.spanStyle;
                    TextDecoration textDecoration = spanStyle.textDecoration;
                    TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
                    if (textDecoration == null) {
                        textDecoration = TextDecoration.None;
                    }
                    TextDecoration textDecoration2 = textDecoration;
                    Shadow shadow = spanStyle.shadow;
                    if (shadow == null) {
                        shadow = Shadow.None;
                    }
                    Shadow shadow2 = shadow;
                    DrawStyle drawStyle = spanStyle.drawStyle;
                    DrawStyle drawStyle2 = drawStyle == null ? fill : drawStyle;
                    try {
                        Brush brush3 = textForegroundStyle.getBrush();
                        TextForegroundStyle.Unspecified unspecified = TextForegroundStyle.Unspecified.INSTANCE;
                        try {
                            if (brush3 != null) {
                                canvas = canvas2;
                                MultiParagraph.m625painthn5TExg$default(multiParagraph, canvas, brush3, textForegroundStyle != unspecified ? textForegroundStyle.getAlpha() : 1.0f, shadow2, textDecoration2, drawStyle2);
                            } else {
                                canvas = canvas2;
                                MultiParagraph.m624paintLG529CI$default(multiParagraph, canvas, textForegroundStyle != unspecified ? textForegroundStyle.mo666getColor0d7_KjU() : Color.Black, shadow2, textDecoration2, drawStyle2);
                            }
                            if (z6) {
                                canvas.restore();
                            }
                        } catch (Throwable th) {
                            th = th;
                            r25 = j5;
                            if (z6) {
                                r25.restore();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r25 = canvas2;
                    }
                }
                return Unit.INSTANCE;
            case 8:
                Function1 function3 = (Function1) r8;
                TextInputSession textInputSession = (TextInputSession) ((Ref$ObjectRef) obj2).element;
                TextFieldValue textFieldValueApply = ((RealStrongMemoryCache) obj3).apply((List) obj);
                if (textInputSession != null) {
                    textInputSession.updateState(null, textFieldValueApply);
                }
                function3.invoke(textFieldValueApply);
                return Unit.INSTANCE;
            case 9:
                Context context = (Context) obj2;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) r8;
                ContextMenuScope contextMenuScope = (ContextMenuScope) obj;
                ?? r2 = ((TextContextMenuData) obj3).components;
                int size3 = r2.size();
                int i11 = 0;
                while (i11 < size3) {
                    TextContextMenuComponent textContextMenuComponent = (TextContextMenuComponent) r2.get(i11);
                    if (textContextMenuComponent instanceof TextContextMenuItem) {
                        final TextContextMenuItem textContextMenuItem = (TextContextMenuItem) textContextMenuComponent;
                        int i12 = 10;
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(i12, textContextMenuItem);
                        if (textContextMenuItem.leadingIcon != 0) {
                            final int i13 = 1;
                            composableLambdaImpl3 = new ComposableLambdaImpl(-1930700965, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                    switch (i13) {
                                        case 0:
                                            long j9 = ((Color) obj4).value;
                                            GapComposer gapComposer = (GapComposer) obj5;
                                            int iIntValue = ((Number) obj6).intValue();
                                            if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) textContextMenuItem).getIcon(), gapComposer, 48);
                                            } else {
                                                gapComposer.skipToGroupEnd();
                                            }
                                            break;
                                        case 1:
                                            long j10 = ((Color) obj4).value;
                                            GapComposer gapComposer2 = (GapComposer) obj5;
                                            int iIntValue2 = ((Number) obj6).intValue();
                                            if ((iIntValue2 & 6) == 0) {
                                                iIntValue2 |= gapComposer2.changed(j10) ? 4 : 2;
                                            }
                                            if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                DefaultTextContextMenuDropdownProvider_androidKt.m181IconBoxRPmYEkk(((TextContextMenuItem) textContextMenuItem).leadingIcon, j10, gapComposer2, (iIntValue2 << 3) & 112);
                                            } else {
                                                gapComposer2.skipToGroupEnd();
                                            }
                                            break;
                                        default:
                                            long j11 = ((Color) obj4).value;
                                            GapComposer gapComposer3 = (GapComposer) obj5;
                                            int iIntValue3 = ((Number) obj6).intValue();
                                            if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) textContextMenuItem, gapComposer3, 48);
                                            } else {
                                                gapComposer3.skipToGroupEnd();
                                            }
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, true);
                        }
                        ContextMenuScope.item$default(contextMenuScope, updater$$ExternalSyntheticLambda0, composableLambdaImpl3, new Recomposer$$ExternalSyntheticLambda6(i12, textContextMenuItem, textContextMenuSession), 6);
                    } else if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            TextContextMenuTextClassificationItem textContextMenuTextClassificationItem = (TextContextMenuTextClassificationItem) textContextMenuComponent;
                            if (context != null) {
                                int i14 = textContextMenuTextClassificationItem.index;
                                TextClassification textClassification = textContextMenuTextClassificationItem.textClassification;
                                if (i14 < 0) {
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = new Updater$$ExternalSyntheticLambda0(i3, textClassification);
                                    final Drawable icon = textClassification.getIcon();
                                    if (icon != null) {
                                        final int i15 = 2;
                                        composableLambdaImpl2 = new ComposableLambdaImpl(-1123224187, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                switch (i15) {
                                                    case 0:
                                                        long j9 = ((Color) obj4).value;
                                                        GapComposer gapComposer = (GapComposer) obj5;
                                                        int iIntValue = ((Number) obj6).intValue();
                                                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) icon).getIcon(), gapComposer, 48);
                                                        } else {
                                                            gapComposer.skipToGroupEnd();
                                                        }
                                                        break;
                                                    case 1:
                                                        long j10 = ((Color) obj4).value;
                                                        GapComposer gapComposer2 = (GapComposer) obj5;
                                                        int iIntValue2 = ((Number) obj6).intValue();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= gapComposer2.changed(j10) ? 4 : 2;
                                                        }
                                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            DefaultTextContextMenuDropdownProvider_androidKt.m181IconBoxRPmYEkk(((TextContextMenuItem) icon).leadingIcon, j10, gapComposer2, (iIntValue2 << 3) & 112);
                                                        } else {
                                                            gapComposer2.skipToGroupEnd();
                                                        }
                                                        break;
                                                    default:
                                                        long j11 = ((Color) obj4).value;
                                                        GapComposer gapComposer3 = (GapComposer) obj5;
                                                        int iIntValue3 = ((Number) obj6).intValue();
                                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) icon, gapComposer3, 48);
                                                        } else {
                                                            gapComposer3.skipToGroupEnd();
                                                        }
                                                        break;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, true);
                                    } else {
                                        composableLambdaImpl2 = null;
                                    }
                                    ContextMenuScope.item$default(contextMenuScope, updater$$ExternalSyntheticLambda1, composableLambdaImpl2, new Recomposer$$ExternalSyntheticLambda6(i3, context, textClassification), 6);
                                } else {
                                    final RemoteAction remoteActionM = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m(textClassification.getActions().get(i14));
                                    boolean z7 = i14 == 0;
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = new Updater$$ExternalSyntheticLambda0(12, remoteActionM);
                                    if (z7 || remoteActionM.shouldShowIcon()) {
                                        final int i16 = 0;
                                        composableLambdaImpl = new ComposableLambdaImpl(-1261173016, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                switch (i16) {
                                                    case 0:
                                                        long j9 = ((Color) obj4).value;
                                                        GapComposer gapComposer = (GapComposer) obj5;
                                                        int iIntValue = ((Number) obj6).intValue();
                                                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) remoteActionM).getIcon(), gapComposer, 48);
                                                        } else {
                                                            gapComposer.skipToGroupEnd();
                                                        }
                                                        break;
                                                    case 1:
                                                        long j10 = ((Color) obj4).value;
                                                        GapComposer gapComposer2 = (GapComposer) obj5;
                                                        int iIntValue2 = ((Number) obj6).intValue();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= gapComposer2.changed(j10) ? 4 : 2;
                                                        }
                                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            DefaultTextContextMenuDropdownProvider_androidKt.m181IconBoxRPmYEkk(((TextContextMenuItem) remoteActionM).leadingIcon, j10, gapComposer2, (iIntValue2 << 3) & 112);
                                                        } else {
                                                            gapComposer2.skipToGroupEnd();
                                                        }
                                                        break;
                                                    default:
                                                        long j11 = ((Color) obj4).value;
                                                        GapComposer gapComposer3 = (GapComposer) obj5;
                                                        int iIntValue3 = ((Number) obj6).intValue();
                                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) remoteActionM, gapComposer3, 48);
                                                        } else {
                                                            gapComposer3.skipToGroupEnd();
                                                        }
                                                        break;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, true);
                                    } else {
                                        composableLambdaImpl = null;
                                    }
                                    ContextMenuScope.item$default(contextMenuScope, updater$$ExternalSyntheticLambda2, composableLambdaImpl, new BasicTextKt$$ExternalSyntheticLambda0(13, remoteActionM), 6);
                                }
                            }
                        }
                    } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                        contextMenuScope.composables.add(ContextMenuPopupPositionProviderKt.f0lambda$1455401925);
                    }
                    i11++;
                    composableLambdaImpl3 = null;
                }
                return Unit.INSTANCE;
            case 10:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) r8;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (((MouseSelectionObserver) obj3).mo205onDrag3MmeM6k(pointerInputChange.position, (SelectionAdjustment$Companion$$ExternalSyntheticLambda0) obj2)) {
                    pointerInputChange.consume();
                    ref$BooleanRef.element = true;
                }
                return Unit.INSTANCE;
            case 11:
                final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                Context context2 = (Context) r8;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                textContextMenuBuilderScope.separator();
                MutableObjectList mutableObjectList = textContextMenuBuilderScope.components;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Autofill;
                boolean z8 = (TextRange.m639getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) || !textFieldSelectionManager.getEditable() || textFieldSelectionManager.clipboard == null) ? false : true;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, z3 ? 1 : 0, 1));
                Resources resources = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda0 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda6, null, 1);
                if (z8) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.CutKey, resources.getString(R.string.cut), R.attr.actionModeCutDrawable, selectionManager_androidKt$$ExternalSyntheticLambda0));
                }
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Autofill;
                boolean z9 = (TextRange.m639getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) || textFieldSelectionManager.clipboard == null) ? false : true;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda7 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, z2 ? 1 : 0, i6));
                Resources resources2 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda1 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda7, null, 1);
                if (z9) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.CopyKey, resources2.getString(R.string.copy), R.attr.actionModeCopyDrawable, selectionManager_androidKt$$ExternalSyntheticLambda1));
                }
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Autofill;
                boolean z10 = textFieldSelectionManager.getEditable() && ((Boolean) textFieldSelectionManager.hasAvailableTextToPaste$delegate.getValue()).booleanValue() && textFieldSelectionManager.clipboard != null;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda8 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, z ? 1 : 0, i5));
                Resources resources3 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda2 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda8, null, 1);
                if (z10) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.PasteKey, resources3.getString(R.string.paste), R.attr.actionModePasteDrawable, selectionManager_androidKt$$ExternalSyntheticLambda2));
                }
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.Autofill;
                boolean z11 = TextRange.m640getLengthimpl(textFieldSelectionManager.getValue$foundation().selection) != textFieldSelectionManager.getValue$foundation().annotatedString.text.length();
                Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i7) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                            case 1:
                                TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                TextFieldValue textFieldValueM227createTextFieldValueFDrldGo = TextFieldSelectionManager.m227createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager2.onValueChange.invoke(textFieldValueM227createTextFieldValueFDrldGo);
                                long j9 = textFieldValueM227createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager2.latestSelection = new TextRange(j9);
                                textFieldSelectionManager2.oldValue = TextFieldValue.m661copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j9, 5);
                                textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                return Unit.INSTANCE;
                            default:
                                Function0 function4 = textFieldSelectionManager.requestAutofillAction;
                                if (function4 != null) {
                                    function4.invoke();
                                }
                                return Unit.INSTANCE;
                        }
                    }
                };
                final int i17 = 1;
                Function0 function4 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i17) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                            case 1:
                                TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                TextFieldValue textFieldValueM227createTextFieldValueFDrldGo = TextFieldSelectionManager.m227createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager2.onValueChange.invoke(textFieldValueM227createTextFieldValueFDrldGo);
                                long j9 = textFieldValueM227createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager2.latestSelection = new TextRange(j9);
                                textFieldSelectionManager2.oldValue = TextFieldValue.m661copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j9, 5);
                                textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                return Unit.INSTANCE;
                            default:
                                Function0 function5 = textFieldSelectionManager.requestAutofillAction;
                                if (function5 != null) {
                                    function5.invoke();
                                }
                                return Unit.INSTANCE;
                        }
                    }
                };
                Resources resources4 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda3 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(function4, function0, 1);
                if (z11) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.SelectAllKey, resources4.getString(R.string.selectAll), R.attr.actionModeSelectAllDrawable, selectionManager_androidKt$$ExternalSyntheticLambda3));
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    TextContextMenuItems textContextMenuItems5 = TextContextMenuItems.Autofill;
                    if (textFieldSelectionManager.getEditable() && TextRange.m639getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                        i7 = 1;
                    }
                    Function0 function5 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            switch (i6) {
                                case 0:
                                    return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                                case 1:
                                    TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                    TextFieldValue textFieldValueM227createTextFieldValueFDrldGo = TextFieldSelectionManager.m227createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                    textFieldSelectionManager2.onValueChange.invoke(textFieldValueM227createTextFieldValueFDrldGo);
                                    long j9 = textFieldValueM227createTextFieldValueFDrldGo.selection;
                                    textFieldSelectionManager2.latestSelection = new TextRange(j9);
                                    textFieldSelectionManager2.oldValue = TextFieldValue.m661copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j9, 5);
                                    textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                    return Unit.INSTANCE;
                                default:
                                    Function0 function6 = textFieldSelectionManager.requestAutofillAction;
                                    if (function6 != null) {
                                        function6.invoke();
                                    }
                                    return Unit.INSTANCE;
                            }
                        }
                    };
                    Resources resources5 = context2.getResources();
                    SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda4 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(function5, null, 1);
                    if (i7 != 0) {
                        mutableObjectList.add(new TextContextMenuItem(textContextMenuItems5.key, resources5.getString(textContextMenuItems5.stringId), textContextMenuItems5.drawableId, selectionManager_androidKt$$ExternalSyntheticLambda4));
                    }
                }
                textContextMenuBuilderScope.separator();
                return Unit.INSTANCE;
            case 12:
                PaddingValues paddingValues = (PaddingValues) obj2;
                Alignment.Horizontal horizontal = (Alignment.Horizontal) r8;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                long j9 = ((Size) ((TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1) obj3).get()).packedValue;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j9 >> 32));
                if (fIntBitsToFloat > 0.0f) {
                    float fMo89toPx0680j_4 = layoutNodeDrawScope.mo89toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                    float fMo89toPx0680j_5 = layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo115calculateLeftPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection()));
                    float fAlign = horizontal.align(MathKt.roundToInt(fIntBitsToFloat), MathKt.roundToInt((Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32)) - fMo89toPx0680j_5) - layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo116calculateRightPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection()))), layoutNodeDrawScope.getLayoutDirection()) + fMo89toPx0680j_5;
                    float f19 = 2;
                    float f20 = fIntBitsToFloat / f19;
                    float f21 = fAlign + f20;
                    float f22 = (f21 - f20) - fMo89toPx0680j_4;
                    float f23 = f22 < 0.0f ? 0.0f : f22;
                    float f24 = f21 + f20 + fMo89toPx0680j_4;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32));
                    float f25 = f24 > fIntBitsToFloat2 ? fIntBitsToFloat2 : f24;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j9 & 4294967295L));
                    float f26 = (-fIntBitsToFloat3) / f19;
                    float f27 = fIntBitsToFloat3 / f19;
                    SVG svg = canvasDrawScope.drawContext;
                    long jM795getSizeNHjbRc2 = svg.m795getSizeNHjbRc();
                    svg.getCanvas().save();
                    try {
                        ((RealDiskCache.RealEditor) svg.rootElement).m784clipRectN_I0leg(f23, f26, f25, f27, 0);
                        layoutNodeDrawScope.drawContent();
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(svg, jM795getSizeNHjbRc2);
                    }
                } else {
                    layoutNodeDrawScope.drawContent();
                }
                return Unit.INSTANCE;
            case 13:
                JobKt.launch$default((CoroutineScope) obj3, null, new NavHostKt$NavHost$28$1((FocusStateImpl) obj, (MutableState) obj2, (TooltipStateImpl) r8, null, 20), 3);
                return Unit.INSTANCE;
            case 14:
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda9 = new Recomposer$$ExternalSyntheticLambda6(17, (CoroutineScope) obj2, (TooltipStateImpl) r8);
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsActions.OnLongClick, new AccessibilityAction((String) obj3, recomposer$$ExternalSyntheticLambda9));
                return Unit.INSTANCE;
            case 15:
                MeasureScope measureScope = (MeasureScope) obj3;
                DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) obj2;
                Placeable placeable = (Placeable) r8;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                float fPositionOf = measureScope.isLookingAhead() ? ((NodeChain) draggableAnchorsNode.state.lock).getAnchors().positionOf(((DerivedSnapshotState) draggableAnchorsNode.state.runs).getValue()) : ((ParcelableSnapshotMutableFloatState) ((NodeChain) draggableAnchorsNode.state.lock).head).getFloatValue();
                boolean zIsLookingAhead = measureScope.isLookingAhead();
                if (Float.isNaN(fPositionOf)) {
                    throw new AnchoredDraggableUninitializedException(zIsLookingAhead, draggableAnchorsNode.didInitializeAnchors, ((NodeChain) draggableAnchorsNode.state.lock).getAnchors(), ((DerivedSnapshotState) draggableAnchorsNode.state.runs).getValue());
                }
                LayoutDirection layoutDirection = HitTestResultKt.requireLayoutNode(draggableAnchorsNode).layoutDirection;
                LayoutDirection layoutDirection2 = LayoutDirection.Rtl;
                Orientation orientation = Orientation.Horizontal;
                float f28 = (layoutDirection == layoutDirection2 && draggableAnchorsNode.orientation == orientation) ? -1.0f : 1.0f;
                Orientation orientation2 = draggableAnchorsNode.orientation;
                float f29 = orientation2 == orientation ? f28 * fPositionOf : 0.0f;
                float f30 = orientation2 == Orientation.Vertical ? fPositionOf : 0.0f;
                placementScope2.motionFrameOfReferencePlacement = true;
                Placeable.PlacementScope.place$default(placementScope2, placeable, MathKt.roundToInt(f29), MathKt.roundToInt(f30));
                Unit unit2 = Unit.INSTANCE;
                placementScope2.motionFrameOfReferencePlacement = false;
                return Unit.INSTANCE;
            case 16:
                SVGAndroidRenderer sVGAndroidRenderer = (SVGAndroidRenderer) obj3;
                Outline$Rounded outline$Rounded = (Outline$Rounded) obj2;
                SolidColor solidColor = (SolidColor) r8;
                DrawScope drawScope4 = (DrawScope) obj;
                float f31 = ((Dp) ((Function0) sVGAndroidRenderer.document).invoke()).value;
                float f32 = 2;
                float fMin2 = Math.min(Dp.m701equalsimpl0(f31, 0.0f) ? 1.0f : (float) Math.ceil(drawScope4.mo89toPx0680j_4(f31)), (float) Math.ceil((Size.m384getMinDimensionimpl(drawScope4.mo472getSizeNHjbRc()) - (((float) Math.ceil(drawScope4.mo89toPx0680j_4(((Dp) ((Function0) sVGAndroidRenderer.state).invoke()).value))) * f32)) / f32));
                float f33 = fMin2 < 0.0f ? 0.0f : fMin2;
                float fCeil = (float) Math.ceil(drawScope4.mo89toPx0680j_4(((Dp) ((Function0) sVGAndroidRenderer.state).invoke()).value));
                float f34 = f33 / f32;
                float f35 = f34 + fCeil;
                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f35)) << 32) | (((long) Float.floatToRawIntBits(f35)) & 4294967295L);
                float f36 = fCeil * f32;
                long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope4.mo472getSizeNHjbRc() & 4294967295L)) - f33) - f36)) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope4.mo472getSizeNHjbRc() >> 32)) - f33) - f36)) << 32);
                if (fCeil == 0.0f && f32 * f33 > Size.m384getMinDimensionimpl(drawScope4.mo472getSizeNHjbRc())) {
                    i7 = 1;
                }
                long jM283shrinkKibmq7A = BorderKt.m283shrinkKibmq7A(fCeil, outline$Rounded.roundRect.topLeftCornerRadius);
                Stroke stroke2 = new Stroke(f33, 0.0f, 0, 0, 30);
                if (i7 != 0) {
                    Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope4, solidColor, 0L, 0L, jM283shrinkKibmq7A, 0.0f, null, null, 0, 246);
                } else if (Float.intBitsToFloat((int) (jM283shrinkKibmq7A >> 32)) < f34) {
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (drawScope4.mo472getSizeNHjbRc() >> 32)) - f33;
                    float fIntBitsToFloat5 = Float.intBitsToFloat((int) (drawScope4.mo472getSizeNHjbRc() & 4294967295L)) - f33;
                    SVG drawContext2 = drawScope4.getDrawContext();
                    long jM795getSizeNHjbRc3 = drawContext2.m795getSizeNHjbRc();
                    drawContext2.getCanvas().save();
                    try {
                        ((RealDiskCache.RealEditor) drawContext2.rootElement).m784clipRectN_I0leg(f33, f33, fIntBitsToFloat4, fIntBitsToFloat5, 0);
                        Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope4, solidColor, 0L, 0L, jM283shrinkKibmq7A, 0.0f, null, null, 0, 246);
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext2, jM795getSizeNHjbRc3);
                    }
                } else {
                    Modifier.CC.m315drawRoundRectZuiqVtQ$default(drawScope4, solidColor, jFloatToRawIntBits2, jFloatToRawIntBits3, BorderKt.m283shrinkKibmq7A(f34, jM283shrinkKibmq7A), 0.0f, stroke2, null, 0, 208);
                }
                return Unit.INSTANCE;
            case 17:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj3;
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = (SaveableStateRegistryWrapper) r8;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                if (!mutableScatterMap.contains(obj2)) {
                    saveableStateHolderImpl.savedStates.remove(obj2);
                    mutableScatterMap.set(obj2, saveableStateRegistryWrapper);
                    return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(saveableStateHolderImpl, obj2, saveableStateRegistryWrapper, i6);
                }
                throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
            case 18:
                List list = (List) obj3;
                ((LazyListIntervalContent) obj).items(list.size(), null, new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i6, list), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$2(list, (SimpleDateFormat) obj2, (Function1) r8, i6), true));
                return Unit.INSTANCE;
            case 19:
                List list2 = (List) obj3;
                ((LazyListIntervalContent) obj).items(list2.size(), new ContinuationCallback(i2, new AsyncImagePainter$$ExternalSyntheticLambda0(i3), list2), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i5, list2), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$2(list2, (Function1) r8, (ParcelableSnapshotMutableLongState) obj2, i5), true));
                return Unit.INSTANCE;
            case 20:
                final List list3 = (List) obj3;
                final List list4 = (List) obj2;
                Function2 function6 = (Function2) r8;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                if (!list3.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, "active_header", new ComposableLambdaImpl(1806500718, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            switch (i7) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m808SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_active, gapComposer) + " (" + list3.size() + ")", appColors.statusActive, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer2 = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m808SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_closed, gapComposer2) + " (" + list3.size() + ")", appColors2.statusClosed, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }, true), 2);
                    lazyListIntervalContent.items(list3.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(4, list3, new AsyncImagePainter$$ExternalSyntheticLambda0(14)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i2, list3), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$3(i8, list3, function6), true));
                }
                if (!list4.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, "closed_header", new ComposableLambdaImpl(-2008266587, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            switch (i8) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m808SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_active, gapComposer) + " (" + list4.size() + ")", appColors.statusActive, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer2 = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m808SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_closed, gapComposer2) + " (" + list4.size() + ")", appColors2.statusClosed, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }, true), 2);
                    lazyListIntervalContent.items(list4.size(), new ContinuationCallback(i4, new AsyncImagePainter$$ExternalSyntheticLambda0(15), list4), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i4, list4), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$3(i6, list4, function6), true));
                }
                if (list3.isEmpty() && list4.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, null, ComposableSingletons$ConnectionsScreenKt.f24lambda1, 3);
                }
                return Unit.INSTANCE;
            case 21:
                return invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$ShareToTvScreen$2$$ExternalSyntheticLambda0(obj);
            default:
                Function0 function7 = (Function0) obj3;
                Function0 function8 = (Function0) obj2;
                MutableState mutableState3 = (MutableState) r8;
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                mutableState3.setValue(Boolean.valueOf(focusStateImpl.getHasFocus()));
                if (!zBooleanValue && focusStateImpl.getHasFocus()) {
                    function7.invoke();
                } else if (zBooleanValue && !focusStateImpl.getHasFocus()) {
                    function8.invoke();
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(MutableState mutableState, ArrayList arrayList, List list, boolean z) {
        this.$r8$classId = 5;
        this.f$0 = mutableState;
        this.f$1 = arrayList;
        this.f$2 = list;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Object obj, Function1 function1, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$2 = function1;
        this.f$1 = obj2;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = 6;
        this.f$2 = function1;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Ref$FloatRef ref$FloatRef, ScrollScope scrollScope, Ref$FloatRef ref$FloatRef2, DefaultFlingBehavior defaultFlingBehavior) {
        this.$r8$classId = 4;
        this.f$0 = ref$FloatRef;
        this.f$1 = scrollScope;
        this.f$2 = ref$FloatRef2;
    }
}
