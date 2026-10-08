package androidx.activity.compose;

import android.content.Context;
import android.graphics.Paint;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogicKt;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.work.WorkManager;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.request.RequestService;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$3;
import com.github.kr328.clash.compose.proxy.ProxyScreenState;
import com.github.kr328.clash.core.model.ProxyGroup;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityResultRegistryKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ ActivityResultRegistryKt$$ExternalSyntheticLambda1(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, PaddingValues paddingValues, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = 4;
        this.f$0 = context;
        this.f$1 = managedActivityResultLauncher;
        this.f$2 = paddingValues;
        this.f$4 = mutableState;
        this.f$3 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i;
        int i2 = this.$r8$classId;
        int i3 = 0;
        Object obj2 = this.f$4;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (i2) {
            case 0:
                ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) obj6;
                activityResultLauncherHolder.launcher = ((ComponentActivity$activityResultRegistry$1) obj5).register((String) obj4, (WorkManager) obj3, new OnBackPressedDispatcher$$ExternalSyntheticLambda0(1, (MutableState) obj2));
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(1, activityResultLauncherHolder);
            case 1:
                MouseWheelScrollingLogic mouseWheelScrollingLogic = (MouseWheelScrollingLogic) obj6;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj5;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj4;
                ScrollingLogic scrollingLogic = (ScrollingLogic) obj3;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj2;
                float fFloatValue = ((Float) obj).floatValue();
                MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = MouseWheelScrollingLogic.sumOrNull(mouseWheelScrollingLogic.channel);
                if (mouseWheelScrollDeltaSumOrNull != null) {
                    RequestService requestService = mouseWheelScrollingLogic.velocityTracker;
                    long j = mouseWheelScrollDeltaSumOrNull.timeMillis;
                    long j2 = mouseWheelScrollDeltaSumOrNull.value;
                    ((VelocityTracker1D) requestService.systemCallbacks).addDataPoint(Float.intBitsToFloat((int) (j2 >> 32)), j);
                    ((VelocityTracker1D) requestService.hardwareBitmapService).addDataPoint(Float.intBitsToFloat((int) (j2 & 4294967295L)), j);
                    MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDeltaPlus = ((MouseWheelScrollingLogic.MouseWheelScrollDelta) ref$ObjectRef.element).plus(mouseWheelScrollDeltaSumOrNull);
                    ref$ObjectRef.element = mouseWheelScrollDeltaPlus;
                    float fM106toSingleAxisDeltaFromAnglek4lQ0M = scrollingLogic.m106toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m103reverseIfNeededMKHz9U(mouseWheelScrollDeltaPlus.value));
                    ref$FloatRef.element = fM106toSingleAxisDeltaFromAnglek4lQ0M;
                    ref$BooleanRef.element = !MouseWheelScrollingLogicKt.access$isLowScrollingDelta(fM106toSingleAxisDeltaFromAnglek4lQ0M - fFloatValue);
                }
                return Boolean.valueOf(mouseWheelScrollDeltaSumOrNull != null);
            case 2:
                OffsetMapping offsetMapping = (OffsetMapping) obj5;
                TextFieldValue textFieldValue = (TextFieldValue) obj4;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj3;
                SolidColor solidColor = (SolidColor) obj2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                float floatValue = ((CursorAnimationState) obj6).cursorAlpha$delegate.getFloatValue();
                if (floatValue != 0.0f) {
                    long j3 = textFieldValue.selection;
                    int i4 = TextRange.$r8$clinit;
                    int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j3 >> 32));
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    Rect cursorRect = layoutResult != null ? layoutResult.value.getCursorRect(iOriginalToTransformed) : new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                    float fFloor = (float) Math.floor(layoutNodeDrawScope.mo89toPx0680j_4(TextFieldCursor_androidKt.DefaultCursorThickness));
                    if (fFloor < 1.0f) {
                        fFloor = 1.0f;
                    }
                    float f = fFloor / 2;
                    float f2 = cursorRect.left + f;
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32)) - f;
                    if (f2 > fIntBitsToFloat) {
                        f2 = fIntBitsToFloat;
                    }
                    if (f2 >= f) {
                        f = f2;
                    }
                    float fFloor2 = ((int) fFloor) % 2 == 1 ? ((float) Math.floor(f)) + 0.5f : (float) Math.rint(f);
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.top)) & 4294967295L);
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fFloor2)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.bottom)) & 4294967295L);
                    Canvas canvas = canvasDrawScope.drawParams.canvas;
                    AndroidPaint androidPaintPaint = canvasDrawScope.strokePaint;
                    if (androidPaintPaint == null) {
                        androidPaintPaint = BrushKt.Paint();
                        androidPaintPaint.m406setStylek9PVt8s(1);
                        canvasDrawScope.strokePaint = androidPaintPaint;
                    }
                    Paint paint = androidPaintPaint.internalPaint;
                    solidColor.mo409applyToPq9zytI(floatValue, canvasDrawScope.drawContext.m795getSizeNHjbRc(), androidPaintPaint);
                    if (!Intrinsics.areEqual(androidPaintPaint.internalColorFilter, null)) {
                        androidPaintPaint.setColorFilter(null);
                    }
                    if (androidPaintPaint._blendMode != 3) {
                        androidPaintPaint.m401setBlendModes9anfk8(3);
                    }
                    if (paint.getStrokeWidth() != fFloor) {
                        androidPaintPaint.setStrokeWidth(fFloor);
                    }
                    if (paint.getStrokeMiter() != 4.0f) {
                        paint.setStrokeMiter(4.0f);
                    }
                    if (androidPaintPaint.m399getStrokeCapKaPHkGw() == 0) {
                        i = 0;
                    } else {
                        i = 0;
                        androidPaintPaint.m404setStrokeCapBeK7IIE(0);
                    }
                    if (androidPaintPaint.m400getStrokeJoinLxFBmk8() != 0) {
                        androidPaintPaint.m405setStrokeJoinWw9F2mQ(i);
                    }
                    if (!paint.isFilterBitmap()) {
                        androidPaintPaint.m403setFilterQualityvDHp3xo(1);
                    }
                    canvas.mo397drawLineWko1d7g(jFloatToRawIntBits, jFloatToRawIntBits2, androidPaintPaint);
                }
                return Unit.INSTANCE;
            case 3:
                LegacyTextInputMethodRequest legacyTextInputMethodRequest = (LegacyTextInputMethodRequest) obj;
                LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = ((AndroidLegacyPlatformTextInputServiceAdapter) obj5).textInputModifierNode;
                legacyTextInputMethodRequest.state = (TextFieldValue) obj6;
                legacyTextInputMethodRequest.imeOptions = (ImeOptions) obj4;
                legacyTextInputMethodRequest.onEditCommand = (LifecycleEffectKt$$ExternalSyntheticLambda1) obj3;
                legacyTextInputMethodRequest.onImeActionPerformed = (Function1) obj2;
                legacyTextInputMethodRequest.legacyTextFieldState = legacyAdaptingPlatformTextInputModifierNode != null ? legacyAdaptingPlatformTextInputModifierNode.legacyTextFieldState : null;
                legacyTextInputMethodRequest.textFieldSelectionManager = legacyAdaptingPlatformTextInputModifierNode != null ? legacyAdaptingPlatformTextInputModifierNode.textFieldSelectionManager : null;
                legacyTextInputMethodRequest.viewConfiguration = legacyAdaptingPlatformTextInputModifierNode != null ? (ViewConfiguration) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalViewConfiguration) : null;
                return Unit.INSTANCE;
            case 4:
                final Context context = (Context) obj6;
                final ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj5;
                final PaddingValues paddingValues = (PaddingValues) obj4;
                final MutableState mutableState = (MutableState) obj2;
                final MutableState mutableState2 = (MutableState) obj3;
                NavGraphBuilder navGraphBuilder = (NavGraphBuilder) obj;
                NavGraphBuilderKt.composable$default(navGraphBuilder, "home", new ComposableLambdaImpl(-1415775533, new Function4() { // from class: com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$1
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj7, Object obj8, Object obj9, Object obj10) {
                        GapComposer gapComposer = (GapComposer) obj9;
                        int iIntValue = ((Number) obj10).intValue();
                        MainAppKt.ScreenWrapper((AnimatedContentScopeImpl) obj7, Thread_jvmKt.rememberComposableLambda(363257647, new FilesScreenKt.AnonymousClass2(context, managedActivityResultLauncher, paddingValues, mutableState, mutableState2, 2), gapComposer), gapComposer, (iIntValue & 14) | 48);
                        return Unit.INSTANCE;
                    }
                }, true));
                NavGraphBuilderKt.composable$default(navGraphBuilder, "profiles", new ComposableLambdaImpl(1792274954, new MainAppKt$MainApp$2$3$1$1$1$2(context, paddingValues, mutableState, i3), true));
                NavGraphBuilderKt.composable$default(navGraphBuilder, "settings", new ComposableLambdaImpl(-558720437, new MainAppKt$MainApp$2$3$1$1$1$3(i3, context, paddingValues), true));
                return Unit.INSTANCE;
            default:
                final ProxyScreenState proxyScreenState = (ProxyScreenState) obj6;
                final Function1 function1 = (Function1) obj5;
                final Function2 function2 = (Function2) obj4;
                final Function1 function3 = (Function1) obj3;
                final Function2 function4 = (Function2) obj2;
                final List list = proxyScreenState.groupNames;
                ((LazyListIntervalContent) obj).items(list.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(10, list, new AsyncImagePainter$$ExternalSyntheticLambda0(24)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(11, list), new ComposableLambdaImpl(802480018, new Function4() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordionList$lambda$33$lambda$32$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj7, Object obj8, Object obj9, Object obj10) {
                        int i5;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj7;
                        int iIntValue = ((Number) obj8).intValue();
                        GapComposer gapComposer = (GapComposer) obj9;
                        int iIntValue2 = ((Number) obj10).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i5 = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i5 = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i5 |= gapComposer.changed(iIntValue) ? 32 : 16;
                        }
                        if (gapComposer.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                            final String str = (String) list.get(iIntValue);
                            gapComposer.startReplaceGroup(969367112);
                            ProxyScreenState proxyScreenState2 = proxyScreenState;
                            ProxyGroup proxyGroup = (ProxyGroup) proxyScreenState2.groups.get(str);
                            gapComposer.startReplaceGroup(308365904);
                            if (proxyGroup != null) {
                                boolean zContains = proxyScreenState2.expandedGroups.contains(str);
                                boolean zContains2 = proxyScreenState2.testingGroups.contains(str);
                                Set set = proxyScreenState2.testingNodes;
                                Set set2 = proxyScreenState2.testedProxies;
                                gapComposer.startReplaceGroup(308378002);
                                final Function1 function5 = function1;
                                boolean zChanged = gapComposer.changed(function5) | gapComposer.changed(str);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                                if (zChanged || objRememberedValue == neverEqualPolicy) {
                                    final int i6 = 0;
                                    objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordionList$3$1$2$1$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            switch (i6) {
                                                case 0:
                                                    function5.invoke(str);
                                                    break;
                                                default:
                                                    function5.invoke(str);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                Function0 function0 = (Function0) objRememberedValue;
                                gapComposer.end(false);
                                gapComposer.startReplaceGroup(308379970);
                                final Function2 function6 = function2;
                                boolean zChanged2 = gapComposer.changed(function6) | gapComposer.changed(str);
                                Object objRememberedValue2 = gapComposer.rememberedValue();
                                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                    final int i7 = 0;
                                    objRememberedValue2 = new Function1() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordionList$3$1$2$2$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj11) {
                                            switch (i7) {
                                                case 0:
                                                    function6.invoke(str, (String) obj11);
                                                    break;
                                                default:
                                                    function6.invoke(str, (String) obj11);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue2);
                                }
                                Function1 function7 = (Function1) objRememberedValue2;
                                gapComposer.end(false);
                                gapComposer.startReplaceGroup(308382352);
                                final Function1 function8 = function3;
                                boolean zChanged3 = gapComposer.changed(function8) | gapComposer.changed(str);
                                Object objRememberedValue3 = gapComposer.rememberedValue();
                                if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                    final int i8 = 1;
                                    objRememberedValue3 = new Function0() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordionList$3$1$2$1$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            switch (i8) {
                                                case 0:
                                                    function8.invoke(str);
                                                    break;
                                                default:
                                                    function8.invoke(str);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function9 = (Function0) objRememberedValue3;
                                gapComposer.end(false);
                                gapComposer.startReplaceGroup(308384192);
                                final Function2 function10 = function4;
                                boolean zChanged4 = gapComposer.changed(function10) | gapComposer.changed(str);
                                Object objRememberedValue4 = gapComposer.rememberedValue();
                                if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                    final int i9 = 1;
                                    objRememberedValue4 = new Function1() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordionList$3$1$2$2$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj11) {
                                            switch (i9) {
                                                case 0:
                                                    function10.invoke(str, (String) obj11);
                                                    break;
                                                default:
                                                    function10.invoke(str, (String) obj11);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    gapComposer.updateRememberedValue(objRememberedValue4);
                                }
                                gapComposer.end(false);
                                ProxyScreenKt.ProxyGroupAccordion(str, proxyGroup, zContains, zContains2, set, set2, function0, function7, function9, (Function1) objRememberedValue4, gapComposer, 0);
                            }
                            gapComposer.end(false);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ActivityResultRegistryKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }
}
