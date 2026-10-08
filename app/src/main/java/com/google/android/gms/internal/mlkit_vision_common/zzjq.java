package com.google.android.gms.internal.mlkit_vision_common;

import android.app.Application;
import android.content.Context;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.FocusableNode$focusTargetNode$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollElement;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import coil.disk.DiskLruCache;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.proxy.ProxyScreenState;
import com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$$ExternalSyntheticLambda3;
import com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjq {
    public static final void ProxySelectorSheet(Function0 function0, boolean z, GapComposer gapComposer, int i, int i2) {
        boolean z2;
        int i3;
        gapComposer.startRestartGroup(1747734173);
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 = i | 48;
            z2 = z;
        } else if ((i & 48) == 0) {
            z2 = z;
            i3 = i | (gapComposer.changed(z2) ? 32 : 16);
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i3 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final boolean z3 = i4 != 0 ? false : z2;
            ProxyViewModel.Factory factory = new ProxyViewModel.Factory((Application) ((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getApplicationContext(), 0);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.getCurrent(gapComposer);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            final ProxyViewModel proxyViewModel = (ProxyViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(ProxyViewModel.class), current, factory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, gapComposer);
            gapComposer.startReplaceGroup(-735683829);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-735678448);
            boolean z4 = (i3 & 112) == 32;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z4 || objRememberedValue2 == obj) {
                objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda1(3, mutableState, z3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            SheetState sheetStateRememberModalBottomSheetState = ScrimKt.rememberModalBottomSheetState((Function1) objRememberedValue2, gapComposer, 6, 0);
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            final float f = 500;
            gapComposer.startReplaceGroup(-735668180);
            boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changed(sheetStateRememberModalBottomSheetState);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == obj) {
                Object proxySelectorSheetKt$$ExternalSyntheticLambda1 = new ProxySelectorSheetKt$$ExternalSyntheticLambda1(coroutineScope, mutableState, sheetStateRememberModalBottomSheetState, function0, 0);
                gapComposer.updateRememberedValue(proxySelectorSheetKt$$ExternalSyntheticLambda1);
                objRememberedValue4 = proxySelectorSheetKt$$ExternalSyntheticLambda1;
            }
            final Function0 function1 = (Function0) objRememberedValue4;
            Object objM = Density.CC.m(-735652734, gapComposer, false);
            if (objM == obj) {
                objM = new ProxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1();
                gapComposer.updateRememberedValue(objM);
            }
            final ProxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1 proxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1 = (ProxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1) objM;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-735639171);
            boolean zChangedInstance2 = gapComposer.changedInstance(proxyViewModel);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == obj) {
                objRememberedValue5 = new DiskLruCache.AnonymousClass1(proxyViewModel, null, 6);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue5);
            gapComposer.startReplaceGroup(-735636985);
            boolean zChangedInstance3 = gapComposer.changedInstance(proxyViewModel);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == obj) {
                objRememberedValue6 = new DiskLruCache$$ExternalSyntheticLambda0(10, proxyViewModel);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit, (Function1) objRememberedValue6, gapComposer);
            final ProxyScreenState proxyScreenState = new ProxyScreenState((List) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.groupNames, gapComposer).getValue(), (Map) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.groups, gapComposer).getValue(), (Set) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.expandedGroups, gapComposer).getValue(), (TunnelState.Mode) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.currentMode, gapComposer).getValue(), (TunnelState.Mode) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.configMode, gapComposer).getValue(), ((Boolean) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.modeSwitchAllowed, gapComposer).getValue()).booleanValue(), (ProxySort) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.proxySort, gapComposer).getValue(), ((Boolean) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.isLoading, gapComposer).getValue()).booleanValue(), (Set) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.testingGroups, gapComposer).getValue(), (Set) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.testingNodes, gapComposer).getValue(), (Set) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.testedProxies, gapComposer).getValue(), (String) FlowExtKt.collectAsStateWithLifecycle(proxyViewModel.error, gapComposer).getValue());
            ScrimKt.m264ModalBottomSheetYbuCTN8(z3 ? function1 : function0, null, sheetStateRememberModalBottomSheetState, 0.0f, false, null, appColors.appBackground, appColors.textPrimary, 0.0f, 0L, null, null, null, Thread_jvmKt.rememberComposableLambda(2022813435, new Function3() { // from class: com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$ProxySelectorSheet$3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Modifier modifierThen;
                    GapComposer gapComposer2 = (GapComposer) obj3;
                    if ((((Number) obj4).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(840778962);
                        boolean z5 = z3;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (z5) {
                            gapComposer2.startReplaceGroup(840781237);
                            Function0 function2 = function1;
                            boolean zChanged = gapComposer2.changed(function2);
                            Object objRememberedValue7 = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue7 == neverEqualPolicy) {
                                objRememberedValue7 = new ProduceKt$awaitClose$4$1(4, function2);
                                gapComposer2.updateRememberedValue(objRememberedValue7);
                            }
                            gapComposer2.end(false);
                            modifierThen = Key_androidKt.onPreviewKeyEvent(companion, (Function1) objRememberedValue7).then(new NestedScrollElement(proxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1));
                        } else {
                            modifierThen = companion;
                        }
                        gapComposer2.end(false);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i5 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m294setimpl(gapComposer2, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer2.startReplaceGroup(-263660131);
                        ProxyViewModel proxyViewModel2 = proxyViewModel;
                        boolean zChangedInstance4 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy) {
                            objRememberedValue8 = new FocusableNode$focusTargetNode$1(2, proxyViewModel2, ProxyViewModel.class, "selectProxy", "selectProxy(Ljava/lang/String;Ljava/lang/String;)V", 0, 0, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        gapComposer2.end(false);
                        Function2 function3 = (Function2) ((FunctionReferenceImpl) objRememberedValue8);
                        gapComposer2.startReplaceGroup(-263658344);
                        boolean zChangedInstance5 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue9 == neverEqualPolicy) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, proxyViewModel2, ProxyViewModel.class, "toggle", "toggle(Ljava/lang/String;)V", 0, 0, 9);
                            gapComposer2.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                            objRememberedValue9 = jobKt__JobKt$invokeOnCompletion$1;
                        }
                        gapComposer2.end(false);
                        Function1 function4 = (Function1) ((FunctionReferenceImpl) objRememberedValue9);
                        gapComposer2.startReplaceGroup(-263656773);
                        boolean zChangedInstance6 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue10 == neverEqualPolicy) {
                            FocusableNode.AnonymousClass1 anonymousClass1 = new FocusableNode.AnonymousClass1(0, proxyViewModel2, ProxyViewModel.class, "expandAll", "expandAll()V", 0, 0, 5);
                            gapComposer2.updateRememberedValue(anonymousClass1);
                            objRememberedValue10 = anonymousClass1;
                        }
                        gapComposer2.end(false);
                        Function0 function5 = (Function0) ((FunctionReferenceImpl) objRememberedValue10);
                        gapComposer2.startReplaceGroup(-263655043);
                        boolean zChangedInstance7 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue11 = gapComposer2.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue11 == neverEqualPolicy) {
                            FocusableNode.AnonymousClass1 anonymousClass2 = new FocusableNode.AnonymousClass1(0, proxyViewModel2, ProxyViewModel.class, "collapseAll", "collapseAll()V", 0, 0, 6);
                            gapComposer2.updateRememberedValue(anonymousClass2);
                            objRememberedValue11 = anonymousClass2;
                        }
                        gapComposer2.end(false);
                        Function0 function6 = (Function0) ((FunctionReferenceImpl) objRememberedValue11);
                        gapComposer2.startReplaceGroup(-263653317);
                        boolean zChangedInstance8 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue12 = gapComposer2.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue12 == neverEqualPolicy) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$2 = new JobKt__JobKt$invokeOnCompletion$1(1, proxyViewModel2, ProxyViewModel.class, "testGroup", "testGroup(Ljava/lang/String;)V", 0, 0, 10);
                            gapComposer2.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$2);
                            objRememberedValue12 = jobKt__JobKt$invokeOnCompletion$2;
                        }
                        gapComposer2.end(false);
                        Function1 function7 = (Function1) ((FunctionReferenceImpl) objRememberedValue12);
                        gapComposer2.startReplaceGroup(-263651653);
                        boolean zChangedInstance9 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue13 = gapComposer2.rememberedValue();
                        if (zChangedInstance9 || objRememberedValue13 == neverEqualPolicy) {
                            FocusableNode$focusTargetNode$1 focusableNode$focusTargetNode$1 = new FocusableNode$focusTargetNode$1(2, proxyViewModel2, ProxyViewModel.class, "testProxy", "testProxy(Ljava/lang/String;Ljava/lang/String;)V", 0, 0, 2);
                            gapComposer2.updateRememberedValue(focusableNode$focusTargetNode$1);
                            objRememberedValue13 = focusableNode$focusTargetNode$1;
                        }
                        gapComposer2.end(false);
                        Function2 function8 = (Function2) ((FunctionReferenceImpl) objRememberedValue13);
                        gapComposer2.startReplaceGroup(-263649959);
                        boolean zChangedInstance10 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue14 = gapComposer2.rememberedValue();
                        if (zChangedInstance10 || objRememberedValue14 == neverEqualPolicy) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$3 = new JobKt__JobKt$invokeOnCompletion$1(1, proxyViewModel2, ProxyViewModel.class, "setSort", "setSort(Lcom/github/kr328/clash/core/model/ProxySort;)V", 0, 0, 11);
                            gapComposer2.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$3);
                            objRememberedValue14 = jobKt__JobKt$invokeOnCompletion$3;
                        }
                        gapComposer2.end(false);
                        Function1 function9 = (Function1) ((FunctionReferenceImpl) objRememberedValue14);
                        gapComposer2.startReplaceGroup(-263648327);
                        boolean zChangedInstance11 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue15 = gapComposer2.rememberedValue();
                        if (zChangedInstance11 || objRememberedValue15 == neverEqualPolicy) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$4 = new JobKt__JobKt$invokeOnCompletion$1(1, proxyViewModel2, ProxyViewModel.class, "setMode", "setMode(Lcom/github/kr328/clash/core/model/TunnelState$Mode;)V", 0, 0, 12);
                            gapComposer2.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$4);
                            objRememberedValue15 = jobKt__JobKt$invokeOnCompletion$4;
                        }
                        gapComposer2.end(false);
                        Function1 function10 = (Function1) ((FunctionReferenceImpl) objRememberedValue15);
                        gapComposer2.startReplaceGroup(-263646858);
                        boolean zChangedInstance12 = gapComposer2.changedInstance(proxyViewModel2);
                        Object objRememberedValue16 = gapComposer2.rememberedValue();
                        if (zChangedInstance12 || objRememberedValue16 == neverEqualPolicy) {
                            FocusableNode.AnonymousClass1 anonymousClass3 = new FocusableNode.AnonymousClass1(0, proxyViewModel2, ProxyViewModel.class, "load", "load()V", 0, 0, 7);
                            gapComposer2.updateRememberedValue(anonymousClass3);
                            objRememberedValue16 = anonymousClass3;
                        }
                        gapComposer2.end(false);
                        Modifier modifierM132height3ABfNKs = SizeKt.m132height3ABfNKs(companion, f);
                        ProxyScreenKt.ProxyScreen(proxyScreenState, function1, function3, function4, function5, function6, function7, function8, function9, function10, (Function0) ((FunctionReferenceImpl) objRememberedValue16), modifierM132height3ABfNKs, gapComposer2, 0);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 0, 3078, 6970);
            z2 = z3;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxySelectorSheetKt$$ExternalSyntheticLambda3(i, i2, function0, z2);
        }
    }
}
