package com.google.android.gms.internal.mlkit_vision_common;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.animation.Scale;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.BackgroundElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RadialGradient;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import coil.network.HttpException;
import com.github.kr328.clash.design.compose.components.ControlButtonKt$WhenMappings;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeState;
import dev.chrisbanes.haze.materials.HazeMaterials;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkb {
    public static final void ControlButton(final ControlButtonState controlButtonState, final Function0 function0, final Function0 function1, Modifier modifier, HazeState hazeState, boolean z, GapComposer gapComposer, int i) {
        int i2;
        boolean z2;
        boolean z3;
        long j;
        boolean z4;
        Modifier modifier2;
        gapComposer.startRestartGroup(1613475795);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(controlButtonState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i2 | 3072;
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(hazeState) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= gapComposer.changed(z) ? 131072 : 65536;
        }
        if ((74899 & i3) == 74898 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            boolean z5 = controlButtonState == ControlButtonState.Connecting || controlButtonState == ControlButtonState.Disconnecting;
            gapComposer.startReplaceGroup(-1393874954);
            int i4 = i3 & 14;
            boolean z6 = i4 == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            final boolean z7 = z5;
            Object obj = Composer$Companion.Empty;
            if (z6 || objRememberedValue == obj) {
                if (ControlButtonKt$WhenMappings.$EnumSwitchMapping$0[controlButtonState.ordinal()] == 1) {
                    z2 = true;
                    z3 = false;
                    objRememberedValue = MatrixExt.listOf(new Color(appColors.buttonActiveStart), new Color(appColors.buttonActiveEnd));
                } else {
                    z2 = true;
                    z3 = false;
                    objRememberedValue = MatrixExt.listOf(new Color(appColors.buttonInactiveStart), new Color(appColors.buttonInactiveEnd));
                }
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                z2 = true;
                z3 = false;
            }
            List list = (List) objRememberedValue;
            boolean z8 = z3;
            Object objM = Density.CC.m(-1393866577, gapComposer, z8);
            if (objM == obj) {
                objM = new MutableInteractionSourceImpl();
                gapComposer.updateRememberedValue(objM);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objM;
            gapComposer.end(z8);
            MutableState mutableStateCollectIsFocusedAsState = com.google.android.gms.internal.mlkit_vision_barcode.zzgn.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 6);
            if (((Boolean) mutableStateCollectIsFocusedAsState.getValue()).booleanValue()) {
                j = Color.White;
            } else {
                j = controlButtonState == ControlButtonState.Connected ? appColors.accentBorder : appColors.buttonInactiveBorder;
            }
            State stateM23animateColorAsStateeuL9pac = SingleValueAnimationKt.m23animateColorAsStateeuL9pac(j, ArcSplineKt.tween$default(300, 6, null), "border-color", gapComposer, 432, 8);
            float f = ((Boolean) mutableStateCollectIsFocusedAsState.getValue()).booleanValue() ? 3 : 2;
            gapComposer.startReplaceGroup(-1393849679);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = hazeState != null ? companion.then(new HazeEffectNodeElement(hazeState, HazeMaterials.m834thinIv8Zu3U(gapComposer))) : companion;
            gapComposer.end(false);
            float f2 = z ? 122 : 144;
            final float f3 = z ? 62 : 72;
            float f4 = z ? 170.0f : 200.0f;
            final float f5 = z ? 40 : 48;
            float f6 = z ? 3 : 4;
            Modifier modifierThen2 = ClipKt.clip(SizeKt.m137size3ABfNKs(companion, f2), RoundedCornerShapeKt.CircleShape).then(modifierThen);
            final float f7 = f6;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                long j2 = ((Color) it.next()).value;
                arrayList.add(new Color(BrushKt.Color(Color.m438getRedimpl(j2), Color.m437getGreenimpl(j2), Color.m435getBlueimpl(j2), 0.5f, Color.m436getColorSpaceimpl(j2))));
            }
            Modifier modifierM45borderxT4_qwU = ImageKt.m45borderxT4_qwU(f, ((Color) stateM23animateColorAsStateeuL9pac.getValue()).value, modifierThen2.then(new BackgroundElement(0L, new RadialGradient(arrayList, null, 9205357640488583168L, f4, 0), BrushKt.RectangleShape, 1)), RoundedCornerShapeKt.CircleShape);
            gapComposer.startReplaceGroup(-1393818622);
            boolean zChanged = gapComposer.changed(z7) | gapComposer.changedInstance(hapticFeedback) | (i4 == 4 ? z2 : false) | ((i3 & 112) == 32 ? z2 : false) | ((i3 & 896) == 256 ? z2 : false);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == obj) {
                z4 = false;
                Object obj2 = new Function0() { // from class: com.github.kr328.clash.design.compose.components.ControlButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        if (!z7) {
                            ((PlatformHapticFeedback) hapticFeedback).m501performHapticFeedbackCdsT49E(0);
                            int iOrdinal = controlButtonState.ordinal();
                            if (iOrdinal == 0) {
                                function0.invoke();
                            } else if (iOrdinal == 2) {
                                function1.invoke();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(obj2);
                objRememberedValue2 = obj2;
            } else {
                z4 = false;
            }
            gapComposer.end(z4);
            Modifier modifierM47clickableO2vRcR0$default = ImageKt.m47clickableO2vRcR0$default(modifierM45borderxT4_qwU, mutableInteractionSourceImpl, null, false, null, (Function0) objRememberedValue2, 28);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z4);
            long j3 = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM47clickableO2vRcR0$default);
            ComposeUiNode.Companion.getClass();
            Function0 function2 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(function2);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Scale.Crossfade(controlButtonState, (Modifier) null, ArcSplineKt.tween$default(300, 6, null), "control-button-overlay", Thread_jvmKt.rememberComposableLambda(-2017781400, new Function3() { // from class: com.github.kr328.clash.design.compose.components.ControlButtonKt$ControlButton$3$1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    ControlButtonState controlButtonState2 = (ControlButtonState) obj3;
                    GapComposer gapComposer2 = (GapComposer) obj4;
                    int iIntValue = ((Number) obj5).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(controlButtonState2) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        float f8 = f3;
                        Modifier modifierM137size3ABfNKs = SizeKt.m137size3ABfNKs(companion2, f8);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        long j4 = gapComposer2.compositeKeyHashCode;
                        int i6 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM137size3ABfNKs);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m294setimpl(gapComposer2, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                        int iOrdinal = controlButtonState2.ordinal();
                        if (iOrdinal == 0) {
                            gapComposer2.startReplaceGroup(-444746954);
                            IconKt.m247Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_power_on, gapComposer2), null, SizeKt.m137size3ABfNKs(companion2, f8), Color.Unspecified, gapComposer2, 3128);
                            gapComposer2.end(false);
                        } else if (iOrdinal == 1) {
                            gapComposer2.startReplaceGroup(-445331862);
                            ProgressIndicatorKt.m255CircularProgressIndicator4lLiAd8(SizeKt.m137size3ABfNKs(companion2, f5), Color.White, f7, 0L, 0, 0.0f, gapComposer2, 48, 56);
                            gapComposer2 = gapComposer2;
                            gapComposer2.end(false);
                        } else if (iOrdinal != 2) {
                            if (iOrdinal != 3) {
                                gapComposer2.startReplaceGroup(-14368730);
                                gapComposer2.end(false);
                                throw new HttpException();
                            }
                            gapComposer2.startReplaceGroup(-445331862);
                            ProgressIndicatorKt.m255CircularProgressIndicator4lLiAd8(SizeKt.m137size3ABfNKs(companion2, f5), Color.White, f7, 0L, 0, 0.0f, gapComposer2, 48, 56);
                            gapComposer2 = gapComposer2;
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-445067277);
                            IconKt.m247Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_power_pause, gapComposer2), null, SizeKt.m137size3ABfNKs(companion2, f8), Color.Unspecified, gapComposer2, 3128);
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i4 | 28032);
            gapComposer.end(z2);
            modifier2 = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda4(controlButtonState, function0, function1, modifier2, hazeState, z, i);
        }
    }
}
