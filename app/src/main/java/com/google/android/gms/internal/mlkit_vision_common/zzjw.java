package com.google.android.gms.internal.mlkit_vision_common;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.model.Profile;
import com.koala.clash.R;
import java.util.List;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjw {
    public static final void ProfileItem(Profile profile, Function0 function0, GapComposer gapComposer, int i) {
        String strStringResource;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-206798604);
        if (((i | (gapComposer2.changedInstance(profile) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 12;
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(f);
            Profile.Type type = profile.type;
            gapComposer2.startReplaceGroup(-800192313);
            if (type == Profile.Type.Url) {
                strStringResource = profile.source;
            } else {
                strStringResource = type == Profile.Type.File ? StringResources_androidKt.stringResource(R.string.file, gapComposer2) : "";
            }
            String str = strStringResource;
            gapComposer2.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM125padding3ABfNKs = OffsetKt.m125padding3ABfNKs(ImageKt.m48clickableoSLSa3U$default(15, ImageKt.m45borderxT4_qwU(1, appColors.cardBorder, ImageKt.m44backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), roundedCornerShapeM156RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM156RoundedCornerShape0680j_4), null, function0, false), 16);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM125padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i2);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, gapComposer2, 48);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            zzkg.m823ProfileAvataruFdPcIQ(null, 36, profile.profileImagePath, gapComposer2, 48);
            OffsetKt.Spacer(gapComposer2, SizeKt.m141width3ABfNKs(companion, f));
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            String str2 = profile.name;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m274TextNvy7gAk(str2, null, appColors.textPrimary, 0L, null, FontWeight.Medium, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer, 1572864, 24960, 110522);
            OffsetKt.Spacer(gapComposer, SizeKt.m132height3ABfNKs(companion, 2));
            TextKt.m274TextNvy7gAk(str, null, appColors.textSecondary, TextUnitKt.getSp(12), null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 24576, 24960, 110570);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(profile, function0, i, 27);
        }
    }

    public static final void ShareToTvScreen(StateFlow stateFlow, StateFlow stateFlow2, final Function1 function1, Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(296248598);
        int i2 = i | (gapComposer.changedInstance(stateFlow) ? 4 : 2) | (gapComposer.changedInstance(stateFlow2) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        if ((i2 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final MutableState mutableStateCollectAsState = Stack.collectAsState(stateFlow, gapComposer, i2 & 14);
            final MutableState mutableStateCollectAsState2 = Stack.collectAsState(stateFlow2, gapComposer, (i2 >> 3) & 14);
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScaffoldKt.m260ScaffoldTvnljyQ(null, Thread_jvmKt.rememberComposableLambda(374519770, new LogsScreenKt.AnonymousClass2(appColors, function0, 17), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(158021925, new Function3() { // from class: com.github.kr328.clash.compose.sharetotv.ShareToTvScreenKt$ShareToTvScreen$2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        Modifier modifierPadding = OffsetKt.padding(fillElement, paddingValues);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding);
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
                        Stack.m294setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        boolean zBooleanValue = ((Boolean) mutableStateCollectAsState2.getValue()).booleanValue();
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        AppColors appColors2 = appColors;
                        if (zBooleanValue) {
                            State state = mutableStateCollectAsState;
                            if (((List) state.getValue()).isEmpty()) {
                                gapComposer2.startReplaceGroup(-1448657710);
                                TextKt.m274TextNvy7gAk(StringResources_androidKt.stringResource(R.string.share_to_tv_no_profiles, gapComposer2), flowRowOverflow.align(companion, biasAlignment), appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer2, 0, 0, 131064);
                                gapComposer2 = gapComposer2;
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-1448267699);
                                float f = 16;
                                float f2 = 8;
                                PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(f, f2, f, f2);
                                Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(f2);
                                gapComposer2.startReplaceGroup(2031504051);
                                boolean zChanged = gapComposer2.changed(appColors2) | gapComposer2.changed(state);
                                Function1 function2 = function1;
                                boolean zChanged2 = zChanged | gapComposer2.changed(function2);
                                Object objRememberedValue = gapComposer2.rememberedValue();
                                if (zChanged2 || objRememberedValue == Composer$Companion.Empty) {
                                    objRememberedValue = new LifecycleEffectKt$$ExternalSyntheticLambda1(appColors2, state, function2, 21);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                gapComposer2.end(false);
                                ProgressionUtilKt.LazyColumn(24966, 490, null, null, spacedAlignedM108spacedBy0680j_4, paddingValuesImpl, null, gapComposer2, null, fillElement, (Function1) objRememberedValue, false, false);
                                gapComposer2.end(false);
                            }
                        } else {
                            gapComposer2.startReplaceGroup(-1449017310);
                            ProgressIndicatorKt.m255CircularProgressIndicator4lLiAd8(flowRowOverflow.align(SizeKt.m137size3ABfNKs(companion, 48), biasAlignment), appColors2.textPrimary, 3, 0L, 0, 0.0f, gapComposer2, 384, 56);
                            gapComposer2 = gapComposer2;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 445);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextFieldImplKt$$ExternalSyntheticLambda10(stateFlow, stateFlow2, function1, function0, i);
        }
    }
}
