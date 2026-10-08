package com.github.kr328.clash.compose.proxy;

import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.Scale;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.GestureNodeKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.PercentCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$copy$1;
import androidx.compose.material.icons.filled.ExpandMoreKt;
import androidx.compose.material.icons.filled.SyncKt;
import androidx.compose.material.icons.filled.TouchAppKt;
import androidx.compose.material.icons.filled.UnfoldLessKt;
import androidx.compose.material.icons.filled.UnfoldMoreKt;
import androidx.compose.material.icons.outlined.WarningAmberKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.AsyncImageKt;
import com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda4;
import com.github.kr328.clash.compose.HwidLimitDialogKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$3$1;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$3$2;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzkh;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__AppendableKt;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.serialization.json.JsonKt;
import okhttp3.Headers;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.Options$Companion;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProxyScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.proxy.ProxyScreenKt$GroupTestButton$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ boolean $isTesting;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(boolean z, AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$isTesting = z;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            int i2 = 0;
            boolean z = this.$isTesting;
            AppColors appColors = this.$colors;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        if (z) {
                            gapComposer.startReplaceGroup(1149306710);
                            ProgressIndicatorKt.m255CircularProgressIndicator4lLiAd8(SizeKt.m137size3ABfNKs(companion, 18), appColors.textPrimary, 2, 0L, 0, 0.0f, gapComposer, 390, 56);
                            gapComposer.end(false);
                        } else {
                            gapComposer.startReplaceGroup(1149506412);
                            ImageVector imageVectorBuild = CertificateChainCleaner._speed;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder = new ImageVector.Builder("Filled.Speed", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i3 = VectorKt.$r8$clinit;
                                SolidColor solidColor = new SolidColor(Color.Black);
                                Headers.Builder builder2 = new Headers.Builder(2);
                                builder2.moveTo(20.38f, 8.57f);
                                builder2.lineToRelative(-1.23f, 1.85f);
                                builder2.arcToRelative(8.0f, 8.0f, -0.22f, 7.58f, true);
                                builder2.lineTo(5.07f, 18.0f);
                                PathNode.ArcTo arcTo = new PathNode.ArcTo(8.0f, 8.0f, 0.0f, false, true, 15.58f, 6.85f);
                                ArrayList arrayList = builder2.namesAndValues;
                                arrayList.add(arcTo);
                                builder2.lineToRelative(1.85f, -1.23f);
                                arrayList.add(new PathNode.ArcTo(10.0f, 10.0f, 0.0f, false, false, 3.35f, 19.0f));
                                builder2.arcToRelative(2.0f, 2.0f, 1.72f, 1.0f, false);
                                builder2.horizontalLineToRelative(13.85f);
                                builder2.arcToRelative(2.0f, 2.0f, 1.74f, -1.0f, false);
                                builder2.arcToRelative(10.0f, 10.0f, -0.27f, -10.44f, false);
                                builder2.close();
                                builder2.moveTo(10.59f, 15.41f);
                                builder2.arcToRelative(2.0f, 2.0f, 2.83f, 0.0f, false);
                                builder2.lineToRelative(5.66f, -8.49f);
                                builder2.lineToRelative(-8.49f, 5.66f);
                                builder2.arcToRelative(2.0f, 2.0f, 0.0f, 2.83f, false);
                                builder2.close();
                                ImageVector.Builder.m500addPathoIyEayM$default(builder, arrayList, solidColor);
                                imageVectorBuild = builder.build();
                                CertificateChainCleaner._speed = imageVectorBuild;
                            }
                            IconKt.m248Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.proxy_test_group, gapComposer), SizeKt.m137size3ABfNKs(companion, 20), appColors.textSecondary, gapComposer, 384, 0);
                            gapComposer.end(false);
                        }
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild2 = SyncKt._sync;
                        if (imageVectorBuild2 == null) {
                            ImageVector.Builder builder3 = new ImageVector.Builder("Filled.Sync", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i4 = VectorKt.$r8$clinit;
                            SolidColor solidColor2 = new SolidColor(Color.Black);
                            Headers.Builder builder4 = new Headers.Builder(2);
                            builder4.moveTo(12.0f, 4.0f);
                            builder4.lineTo(12.0f, 1.0f);
                            builder4.lineTo(8.0f, 5.0f);
                            builder4.lineToRelative(4.0f, 4.0f);
                            builder4.lineTo(12.0f, 6.0f);
                            builder4.curveToRelative(3.31f, 0.0f, 6.0f, 2.69f, 6.0f, 6.0f);
                            builder4.curveToRelative(0.0f, 1.01f, -0.25f, 1.97f, -0.7f, 2.8f);
                            builder4.lineToRelative(1.46f, 1.46f);
                            builder4.curveTo(19.54f, 15.03f, 20.0f, 13.57f, 20.0f, 12.0f);
                            builder4.curveToRelative(0.0f, -4.42f, -3.58f, -8.0f, -8.0f, -8.0f);
                            builder4.close();
                            builder4.moveTo(12.0f, 18.0f);
                            builder4.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
                            builder4.curveToRelative(0.0f, -1.01f, 0.25f, -1.97f, 0.7f, -2.8f);
                            builder4.lineTo(5.24f, 7.74f);
                            builder4.curveTo(4.46f, 8.97f, 4.0f, 10.43f, 4.0f, 12.0f);
                            builder4.curveToRelative(0.0f, 4.42f, 3.58f, 8.0f, 8.0f, 8.0f);
                            builder4.verticalLineToRelative(3.0f);
                            builder4.lineToRelative(4.0f, -4.0f);
                            builder4.lineToRelative(-4.0f, -4.0f);
                            builder4.verticalLineToRelative(3.0f);
                            builder4.close();
                            ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                            imageVectorBuild2 = builder3.build();
                            SyncKt._sync = imageVectorBuild2;
                        }
                        IconKt.m248Iconww6aTOc(imageVectorBuild2, StringResources_androidKt.stringResource(R.string.update_all, gapComposer2), null, z ? appColors.textPrimary : appColors.textSecondary, gapComposer2, 0, 4);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else if (!z) {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1702094573, new LogsScreenKt.AnonymousClass6(appColors, 25), gapComposer3);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j = Color.Transparent;
                        AppBarKt.m236TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, null, null, 0.0f, null, TopAppBarDefaults.m277topAppBarColors5tl4gsc(j, j, 0L, appColors.textPrimary, 0L, gapComposer3, 52), null, gapComposer3, 6, 446);
                    }
                    break;
                default:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else if (!z) {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(1959424767, new SettingsScreenKt$SettingsScreen$3$1(appColors, i2), gapComposer4);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-789458627, new SettingsScreenKt$SettingsScreen$3$2(), gapComposer4);
                        PaddingValuesImpl paddingValuesImpl2 = TopAppBarDefaults.ContentPadding;
                        long j2 = Color.Transparent;
                        long j3 = appColors.textPrimary;
                        AppBarKt.m236TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda2, null, composableLambdaImplRememberComposableLambda3, null, 0.0f, null, TopAppBarDefaults.m277topAppBarColors5tl4gsc(j2, j2, j3, j3, 0L, gapComposer4, 48), null, gapComposer4, 390, 442);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void CenterMessage(ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-2137870880);
        if ((i & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, fillElement);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, i, 4);
        }
    }

    public static final void EmptyMessage(ImageVector imageVector, String str, GapComposer gapComposer, int i) {
        String str2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-2024548072);
        int i2 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            str2 = str;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(12);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM125padding3ABfNKs = OffsetKt.m125padding3ABfNKs(companion, 32);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM108spacedBy0680j_4, horizontal, gapComposer2, 54);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) ((j >>> 32) ^ j);
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
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            IconKt.m248Iconww6aTOc(imageVector, null, SizeKt.m137size3ABfNKs(companion, 48), appColors.textSecondary, gapComposer2, (i2 & 14) | 432, 0);
            str2 = str;
            TextKt.m274TextNvy7gAk(str2, null, appColors.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, (i2 >> 3) & 14, 0, 130042);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(imageVector, str2, i, 26);
        }
    }

    public static final void ErrorContent(String str, Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        int i3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(734267679);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2;
        if ((i4 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            i3 = 1;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
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
            Integer numValueOf = Integer.valueOf(i5);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(16);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM125padding3ABfNKs = OffsetKt.m125padding3ABfNKs(companion, 32);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM108spacedBy0680j_4, horizontal, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM125padding3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            ImageVector imageVectorBuild = WarningAmberKt._warningAmber;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Outlined.WarningAmber", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i7 = VectorKt.$r8$clinit;
                SolidColor solidColor = new SolidColor(Color.Black);
                Headers.Builder builder2 = new Headers.Builder(2);
                builder2.moveTo(12.0f, 5.99f);
                builder2.lineTo(19.53f, 19.0f);
                builder2.lineTo(4.47f, 19.0f);
                builder2.lineTo(12.0f, 5.99f);
                builder2.moveTo(12.0f, 2.0f);
                builder2.lineTo(1.0f, 21.0f);
                builder2.horizontalLineToRelative(22.0f);
                builder2.lineTo(12.0f, 2.0f);
                builder2.close();
                builder2.moveTo(13.0f, 16.0f);
                builder2.horizontalLineToRelative(-2.0f);
                builder2.verticalLineToRelative(2.0f);
                builder2.horizontalLineToRelative(2.0f);
                builder2.verticalLineToRelative(-2.0f);
                builder2.close();
                builder2.moveTo(13.0f, 10.0f);
                builder2.horizontalLineToRelative(-2.0f);
                builder2.verticalLineToRelative(4.0f);
                builder2.horizontalLineToRelative(2.0f);
                builder2.verticalLineToRelative(-4.0f);
                builder2.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                imageVectorBuild = builder.build();
                WarningAmberKt._warningAmber = imageVectorBuild;
            }
            IconKt.m248Iconww6aTOc(imageVectorBuild, null, SizeKt.m137size3ABfNKs(companion, 48), appColors.textSecondary, gapComposer2, 432, 0);
            TextKt.m274TextNvy7gAk(str, null, appColors.textPrimary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, i4 & 14, 0, 130042);
            float f = 12;
            Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(ImageKt.m48clickableoSLSa3U$default(15, ImageKt.m45borderxT4_qwU(1, appColors.accentBorder, ImageKt.m44backgroundbw27NRU(ClipKt.clip(companion, RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(f)), appColors.accentFill, BrushKt.RectangleShape), RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(f)), null, function0, false), 24, f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i8 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM126paddingVpY3zN4);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i8, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            TextKt.m274TextNvy7gAk(StringResources_androidKt.stringResource(R.string.proxy_retry, gapComposer), null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 1572864, 0, 262074);
            gapComposer2 = gapComposer;
            i3 = 1;
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HwidLimitDialogKt$$ExternalSyntheticLambda0(str, function0, i, i3);
        }
    }

    /* JADX INFO: renamed from: GroupIcon-XO-JAsU, reason: not valid java name */
    public static final void m813GroupIconXOJAsU(String str, Proxy.Type type, long j, GapComposer gapComposer, int i) {
        Modifier.Companion companion;
        ImageVector imageVectorBuild;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-50253209);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(type) ? 32 : 16) | (gapComposer2.changed(j) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(ClipKt.clip(SizeKt.m137size3ABfNKs(companion2, 36), RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(9)), BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), 0.15f, Color.m436getColorSpaceimpl(j)), BrushKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM44backgroundbw27NRU);
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
            if (str == null || StringsKt.isBlank(str)) {
                gapComposer2.startReplaceGroup(-1835799925);
                switch (type.ordinal()) {
                    case 24:
                        companion = companion2;
                        imageVectorBuild = StringsKt__AppendableKt._accountTree;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.AccountTree", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i4 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Headers.Builder builder2 = new Headers.Builder(2);
                            builder2.moveTo(22.0f, 11.0f);
                            builder2.verticalLineTo(3.0f);
                            builder2.horizontalLineToRelative(-7.0f);
                            builder2.verticalLineToRelative(3.0f);
                            builder2.horizontalLineTo(9.0f);
                            builder2.verticalLineTo(3.0f);
                            builder2.horizontalLineTo(2.0f);
                            builder2.verticalLineToRelative(8.0f);
                            builder2.horizontalLineToRelative(7.0f);
                            builder2.verticalLineTo(8.0f);
                            builder2.horizontalLineToRelative(2.0f);
                            builder2.verticalLineToRelative(10.0f);
                            builder2.horizontalLineToRelative(4.0f);
                            builder2.verticalLineToRelative(3.0f);
                            builder2.horizontalLineToRelative(7.0f);
                            builder2.verticalLineToRelative(-8.0f);
                            builder2.horizontalLineToRelative(-7.0f);
                            builder2.verticalLineToRelative(3.0f);
                            builder2.horizontalLineToRelative(-2.0f);
                            builder2.verticalLineTo(8.0f);
                            builder2.horizontalLineToRelative(2.0f);
                            builder2.verticalLineToRelative(3.0f);
                            builder2.close();
                            ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                            imageVectorBuild = builder.build();
                            StringsKt__AppendableKt._accountTree = imageVectorBuild;
                        }
                        break;
                    case 25:
                        companion = companion2;
                        imageVectorBuild = TouchAppKt._touchApp;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder3 = new ImageVector.Builder("Filled.TouchApp", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i5 = VectorKt.$r8$clinit;
                            SolidColor solidColor2 = new SolidColor(Color.Black);
                            Headers.Builder builder4 = new Headers.Builder(2);
                            builder4.moveTo(9.0f, 11.24f);
                            builder4.verticalLineTo(7.5f);
                            builder4.curveTo(9.0f, 6.12f, 10.12f, 5.0f, 11.5f, 5.0f);
                            builder4.reflectiveCurveTo(14.0f, 6.12f, 14.0f, 7.5f);
                            builder4.verticalLineToRelative(3.74f);
                            builder4.curveToRelative(1.21f, -0.81f, 2.0f, -2.18f, 2.0f, -3.74f);
                            builder4.curveTo(16.0f, 5.01f, 13.99f, 3.0f, 11.5f, 3.0f);
                            builder4.reflectiveCurveTo(7.0f, 5.01f, 7.0f, 7.5f);
                            builder4.curveTo(7.0f, 9.06f, 7.79f, 10.43f, 9.0f, 11.24f);
                            builder4.close();
                            builder4.moveTo(18.84f, 15.87f);
                            builder4.lineToRelative(-4.54f, -2.26f);
                            builder4.curveToRelative(-0.17f, -0.07f, -0.35f, -0.11f, -0.54f, -0.11f);
                            builder4.horizontalLineTo(13.0f);
                            builder4.verticalLineToRelative(-6.0f);
                            builder4.curveTo(13.0f, 6.67f, 12.33f, 6.0f, 11.5f, 6.0f);
                            builder4.reflectiveCurveTo(10.0f, 6.67f, 10.0f, 7.5f);
                            builder4.verticalLineToRelative(10.74f);
                            builder4.curveToRelative(-3.6f, -0.76f, -3.54f, -0.75f, -3.67f, -0.75f);
                            builder4.curveToRelative(-0.31f, 0.0f, -0.59f, 0.13f, -0.79f, 0.33f);
                            builder4.lineToRelative(-0.79f, 0.8f);
                            builder4.lineToRelative(4.94f, 4.94f);
                            builder4.curveTo(9.96f, 23.83f, 10.34f, 24.0f, 10.75f, 24.0f);
                            builder4.horizontalLineToRelative(6.79f);
                            builder4.curveToRelative(0.75f, 0.0f, 1.33f, -0.55f, 1.44f, -1.28f);
                            builder4.lineToRelative(0.75f, -5.27f);
                            builder4.curveToRelative(0.01f, -0.07f, 0.02f, -0.14f, 0.02f, -0.2f);
                            builder4.curveTo(19.75f, 16.63f, 19.37f, 16.09f, 18.84f, 15.87f);
                            builder4.close();
                            ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                            imageVectorBuild = builder3.build();
                            TouchAppKt._touchApp = imageVectorBuild;
                        }
                        break;
                    case 26:
                        companion = companion2;
                        imageVectorBuild = StatusLine.Companion._shield;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder5 = new ImageVector.Builder("Filled.Shield", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i6 = VectorKt.$r8$clinit;
                            SolidColor solidColor3 = new SolidColor(Color.Black);
                            ArrayList arrayList = new ArrayList(32);
                            arrayList.add(new PathNode.MoveTo(12.0f, 1.0f));
                            arrayList.add(new PathNode.LineTo(3.0f, 5.0f));
                            arrayList.add(new PathNode.RelativeVerticalTo(6.0f));
                            arrayList.add(new PathNode.RelativeCurveTo(0.0f, 5.55f, 3.84f, 10.74f, 9.0f, 12.0f));
                            arrayList.add(new PathNode.RelativeCurveTo(5.16f, -1.26f, 9.0f, -6.45f, 9.0f, -12.0f));
                            arrayList.add(new PathNode.VerticalTo(5.0f));
                            arrayList.add(new PathNode.RelativeLineTo(-9.0f, -4.0f));
                            arrayList.add(PathNode.Close.INSTANCE);
                            ImageVector.Builder.m500addPathoIyEayM$default(builder5, arrayList, solidColor3);
                            imageVectorBuild = builder5.build();
                            StatusLine.Companion._shield = imageVectorBuild;
                        }
                        break;
                    case 27:
                        companion = companion2;
                        imageVectorBuild = ChannelKt._bolt;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder6 = new ImageVector.Builder("Filled.Bolt", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i7 = VectorKt.$r8$clinit;
                            SolidColor solidColor4 = new SolidColor(Color.Black);
                            Headers.Builder builder7 = new Headers.Builder(2);
                            builder7.moveTo(11.0f, 21.0f);
                            builder7.horizontalLineToRelative(-1.0f);
                            builder7.lineToRelative(1.0f, -7.0f);
                            builder7.horizontalLineTo(7.5f);
                            builder7.curveToRelative(-0.58f, 0.0f, -0.57f, -0.32f, -0.38f, -0.66f);
                            builder7.curveToRelative(0.19f, -0.34f, 0.05f, -0.08f, 0.07f, -0.12f);
                            builder7.curveTo(8.48f, 10.94f, 10.42f, 7.54f, 13.0f, 3.0f);
                            builder7.horizontalLineToRelative(1.0f);
                            builder7.lineToRelative(-1.0f, 7.0f);
                            builder7.horizontalLineToRelative(3.5f);
                            builder7.curveToRelative(0.49f, 0.0f, 0.56f, 0.33f, 0.47f, 0.51f);
                            builder7.lineToRelative(-0.07f, 0.15f);
                            builder7.curveTo(12.96f, 17.55f, 11.0f, 21.0f, 11.0f, 21.0f);
                            builder7.close();
                            ImageVector.Builder.m500addPathoIyEayM$default(builder6, builder7.namesAndValues, solidColor4);
                            imageVectorBuild = builder6.build();
                            ChannelKt._bolt = imageVectorBuild;
                        }
                        break;
                    case 28:
                        companion = companion2;
                        imageVectorBuild = Options$Companion.getSwapHoriz();
                        break;
                    default:
                        imageVectorBuild = JsonKt._lan;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder8 = new ImageVector.Builder("Filled.Lan", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i8 = VectorKt.$r8$clinit;
                            companion = companion2;
                            SolidColor solidColor5 = new SolidColor(Color.Black);
                            Headers.Builder builder9 = new Headers.Builder(2);
                            builder9.moveTo(13.0f, 22.0f);
                            builder9.lineToRelative(8.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -7.0f);
                            builder9.lineToRelative(-3.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -4.0f);
                            builder9.lineToRelative(-5.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -2.0f);
                            builder9.lineToRelative(3.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -7.0f);
                            builder9.lineToRelative(-8.0f, 0.0f);
                            builder9.lineToRelative(0.0f, 7.0f);
                            builder9.lineToRelative(3.0f, 0.0f);
                            builder9.lineToRelative(0.0f, 2.0f);
                            builder9.lineToRelative(-5.0f, 0.0f);
                            builder9.lineToRelative(0.0f, 4.0f);
                            builder9.lineToRelative(-3.0f, 0.0f);
                            builder9.lineToRelative(0.0f, 7.0f);
                            builder9.lineToRelative(8.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -7.0f);
                            builder9.lineToRelative(-3.0f, 0.0f);
                            builder9.lineToRelative(0.0f, -2.0f);
                            builder9.lineToRelative(8.0f, 0.0f);
                            builder9.lineToRelative(0.0f, 2.0f);
                            builder9.lineToRelative(-3.0f, 0.0f);
                            builder9.close();
                            ImageVector.Builder.m500addPathoIyEayM$default(builder8, builder9.namesAndValues, solidColor5);
                            imageVectorBuild = builder8.build();
                            JsonKt._lan = imageVectorBuild;
                        } else {
                            companion = companion2;
                        }
                        break;
                }
                IconKt.m248Iconww6aTOc(imageVectorBuild, null, SizeKt.m137size3ABfNKs(companion, 18), j, gapComposer2, ((i2 << 3) & 7168) | 432, 0);
                gapComposer2 = gapComposer2;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-1835979756);
                AsyncImageKt.m777AsyncImagegl8XCv8(str, SizeKt.m137size3ABfNKs(companion2, 22), null, null, gapComposer2, (i2 & 14) | 432, 4088);
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda2(str, type, j, i, 4);
        }
    }

    public static final void GroupTestButton(boolean z, Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        Function0 function1;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(-293024294);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            function1 = function0;
            gapComposer2 = gapComposer;
        } else {
            function1 = function0;
            gapComposer2 = gapComposer;
            ScrimKt.IconButton(function1, SizeKt.m137size3ABfNKs(Modifier.Companion.$$INSTANCE, 36), !z, null, null, Thread_jvmKt.rememberComposableLambda(1670115704, new AnonymousClass1(z, (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors), 0), gapComposer), gapComposer2, ((i2 >> 3) & 14) | 1572912, 56);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(i, 1, function1, z);
        }
    }

    /* JADX INFO: renamed from: GroupTypeBadge-RPmYEkk, reason: not valid java name */
    public static final void m814GroupTypeBadgeRPmYEkk(final Proxy.Type type, final long j, GapComposer gapComposer, final int i) {
        int i2;
        gapComposer.startRestartGroup(-1859748230);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer.changed(type) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            PercentCornerSize percentCornerSize = new PercentCornerSize(50);
            RoundedCornerShape roundedCornerShape2 = new RoundedCornerShape(percentCornerSize, percentCornerSize, percentCornerSize, percentCornerSize);
            TextKt.m274TextNvy7gAk(type.name(), OffsetKt.m126paddingVpY3zN4(ImageKt.m45borderxT4_qwU(1, BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), 0.35f, Color.m436getColorSpaceimpl(j)), ImageKt.m44backgroundbw27NRU(ClipKt.clip(Modifier.Companion.$$INSTANCE, roundedCornerShape2), BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), 0.12f, Color.m436getColorSpaceimpl(j)), BrushKt.RectangleShape), roundedCornerShape2), 6, 2), j, TextUnitKt.getSp(10), null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, ((i2 << 3) & 896) | 1597440, 24576, 114600);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    ProxyScreenKt.m814GroupTypeBadgeRPmYEkk(type, j, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void PingBadge(final int i, final boolean z, final boolean z2, final Function0 function0, GapComposer gapComposer, final int i2) {
        int i3;
        long jColor;
        FontWeight fontWeight;
        gapComposer.startRestartGroup(-1852164377);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            boolean z3 = 1 <= i && i < 30000;
            String strValueOf = "—";
            if (!z) {
                jColor = appColors.textSecondary;
                fontWeight = FontWeight.SemiBold;
            } else if (z3) {
                strValueOf = String.valueOf(i);
                jColor = appColors.textPrimary;
                fontWeight = FontWeight.Bold;
            } else {
                jColor = BrushKt.Color(4293212469L);
                fontWeight = FontWeight.SemiBold;
            }
            long j = jColor;
            FontWeight fontWeight2 = fontWeight;
            long j2 = z2 ? appColors.accentBorder : appColors.cardBorder;
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(12);
            TextKt.m274TextNvy7gAk(strValueOf, OffsetKt.m126paddingVpY3zN4(ImageKt.m45borderxT4_qwU(1, j2, ImageKt.m48clickableoSLSa3U$default(15, ClipKt.clip(Modifier.Companion.$$INSTANCE, roundedCornerShapeM156RoundedCornerShape0680j_4), null, function0, false), roundedCornerShapeM156RoundedCornerShape0680j_4), 8, 2), j, 0L, null, fontWeight2, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 0, 0, 131000);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.PingBadge(i, z, z2, function0, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyGroupAccordion(final String str, final ProxyGroup proxyGroup, final boolean z, final boolean z2, final Set set, final Set set2, final Function0 function0, final Function1 function1, final Function0 function2, final Function1 function3, GapComposer gapComposer, final int i) {
        long jColor;
        GapComposer gapComposer2 = gapComposer;
        Proxy.Type type = proxyGroup.type;
        gapComposer2.startRestartGroup(10356700);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changedInstance(proxyGroup) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changed(z2) ? 2048 : 1024) | (gapComposer2.changedInstance(set) ? 16384 : 8192) | (gapComposer2.changedInstance(set2) ? 131072 : 65536) | (gapComposer2.changedInstance(function0) ? 1048576 : 524288) | (gapComposer2.changedInstance(function1) ? 8388608 : 4194304) | (gapComposer2.changedInstance(function2) ? 67108864 : 33554432) | (gapComposer2.changedInstance(function3) ? 536870912 : 268435456);
        if ((306783379 & i2) == 306783378 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AppColorsKt.LocalAppColors;
            AppColors appColors = (AppColors) gapComposer2.consume(staticProvidableCompositionLocal);
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(14);
            gapComposer2.startReplaceGroup(1547306068);
            boolean zIsInDarkTheme = zzkh.isInDarkTheme(gapComposer2);
            Proxy.Type type2 = Proxy.Type.Fallback;
            Proxy.Type type3 = Proxy.Type.URLTest;
            Proxy.Type type4 = Proxy.Type.Selector;
            if (type == type4) {
                jColor = BrushKt.Color(zIsInDarkTheme ? 4284524026L : 4280640491L);
            } else if (type == type3) {
                jColor = BrushKt.Color(zIsInDarkTheme ? 4283096704L : 4279608138L);
            } else if (type == type2) {
                jColor = BrushKt.Color(zIsInDarkTheme ? 4294677052L : 4292441862L);
            } else if (type == Proxy.Type.LoadBalance) {
                jColor = BrushKt.Color(zIsInDarkTheme ? 4289170426L : 4286331629L);
            } else if (type == Proxy.Type.Relay) {
                jColor = BrushKt.Color(zIsInDarkTheme ? 4294210230L : 4292552567L);
            } else {
                jColor = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).textSecondary;
            }
            Object objM = Density.CC.m(1053434306, gapComposer2, false);
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objM);
            }
            MutableState mutableState = (MutableState) objM;
            gapComposer2.end(false);
            boolean z3 = type == type4 || type == type2 || type == type3;
            Modifier modifierM45borderxT4_qwU = ImageKt.m45borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 1, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : appColors.cardBorder, ImageKt.m44backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), roundedCornerShapeM156RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM156RoundedCornerShape0680j_4);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM45borderxT4_qwU);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer2.startReplaceGroup(295734677);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 23);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.end(false);
            int i4 = i2 << 3;
            int i5 = i2 >> 3;
            m815ProxyGroupHeaderTgFrcIs(str, proxyGroup, jColor, z, z2, function0, function2, (Function1) objRememberedValue, gapComposer2, (i2 & 14) | 12582912 | (i2 & 112) | (i4 & 7168) | (i4 & 57344) | (458752 & i5) | (3670016 & (i2 >> 6)));
            EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(220, 6, null), 2);
            CubicBezierEasing cubicBezierEasing = EasingKt.FastOutSlowInEasing;
            final boolean z4 = z3;
            gapComposer2 = gapComposer2;
            Scale.AnimatedVisibility(z, null, enterTransitionImplFadeIn$default.plus(EnterExitTransitionKt.expandVertically$default(ArcSplineKt.tween$default(250, 2, cubicBezierEasing), 14)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(160, 6, null), 2).plus(EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.tween$default(220, 2, cubicBezierEasing), 14)), null, Thread_jvmKt.rememberComposableLambda(-520746326, new Function3() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordion$1$2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    ((Number) obj3).intValue();
                    Modifier modifierM129paddingqDBjuR0$default = OffsetKt.m129paddingqDBjuR0$default(OffsetKt.m127paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 10, 0.0f, 2), 0.0f, 2, 0.0f, 12, 5);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.m108spacedBy0680j_4(8), Alignment.Companion.Start, gapComposer3, 6);
                    long j2 = gapComposer3.compositeKeyHashCode;
                    int i6 = (int) (j2 ^ (j2 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM129paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m294setimpl(gapComposer3, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m294setimpl(gapComposer3, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m293reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m294setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    gapComposer3.startReplaceGroup(1124626848);
                    ProxyGroup proxyGroup2 = proxyGroup;
                    for (final Proxy proxy : proxyGroup2.proxies) {
                        String str2 = proxyGroup2.now;
                        String str3 = proxy.name;
                        boolean zAreEqual = Intrinsics.areEqual(str2, str3);
                        boolean zContains = set.contains(str + "\n" + str3);
                        boolean zContains2 = set2.contains(str3);
                        gapComposer3.startReplaceGroup(-1582975063);
                        final boolean z5 = z4;
                        boolean zChanged = gapComposer3.changed(z5);
                        final Function1 function4 = function1;
                        boolean zChanged2 = zChanged | gapComposer3.changed(function4) | gapComposer3.changedInstance(proxy);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy2) {
                            objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupAccordion$1$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    if (z5) {
                                        function4.invoke(proxy.name);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function5 = (Function0) objRememberedValue2;
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(-1582972361);
                        Function1 function6 = function3;
                        boolean zChanged3 = gapComposer3.changed(function6) | gapComposer3.changedInstance(proxy);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy2) {
                            objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(27, function6, proxy);
                            gapComposer3.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer3.end(false);
                        ProxyScreenKt.ProxyNodeCard(proxy, zAreEqual, zContains, zContains2, function5, (Function0) objRememberedValue3, gapComposer3, 0);
                    }
                    gapComposer3.end(false);
                    gapComposer3.end(true);
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer2, 1572870 | (i5 & 112));
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(str, proxyGroup, z, z2, set, set2, function0, function1, function2, function3, i) { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda1
                public final /* synthetic */ String f$0;
                public final /* synthetic */ ProxyGroup f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ Set f$4;
                public final /* synthetic */ Set f$5;
                public final /* synthetic */ Function0 f$6;
                public final /* synthetic */ Function1 f$7;
                public final /* synthetic */ Function0 f$8;
                public final /* synthetic */ Function1 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ProxyScreenKt.ProxyGroupAccordion(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyGroupAccordionList(ProxyScreenState proxyScreenState, Function1 function1, Function2 function2, Function1 function3, Function2 function4, GapComposer gapComposer, int i) {
        int i2;
        Object obj;
        gapComposer.startRestartGroup(48345031);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(proxyScreenState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            obj = function4;
            i2 |= gapComposer.changedInstance(obj) ? 16384 : 8192;
        } else {
            obj = function4;
        }
        if ((i2 & 9363) == 9362 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            List list = proxyScreenState.groupNames;
            Map map = proxyScreenState.groups;
            TunnelState.Mode mode = proxyScreenState.currentMode;
            int iIndexOf = list.indexOf("GLOBAL");
            boolean z = mode == TunnelState.Mode.Global && iIndexOf >= 0 && map.containsKey("GLOBAL");
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(1689823969);
            boolean zChanged = gapComposer.changed(z) | gapComposer.changed(lazyListStateRememberLazyListState) | gapComposer.changed(iIndexOf);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == obj2) {
                objRememberedValue = new ProxyScreenKt$ProxyGroupAccordionList$1$1(z, lazyListStateRememberLazyListState, iIndexOf, null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue);
            boolean z2 = mode == TunnelState.Mode.Rule && !list.contains("GLOBAL") && !list.isEmpty() && map.containsKey(CollectionsKt.first(list));
            Boolean boolValueOf2 = Boolean.valueOf(z2);
            gapComposer.startReplaceGroup(1689835096);
            boolean zChanged2 = gapComposer.changed(z2) | gapComposer.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == obj2) {
                objRememberedValue2 = new TextFieldSelectionManager$copy$1(z2, lazyListStateRememberLazyListState, (Continuation) null);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, boolValueOf2, (Function2) objRememberedValue2);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            float f = 16;
            float f2 = 12;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(f, f2, f, f2);
            Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(10);
            gapComposer.startReplaceGroup(1689846068);
            boolean z3 = ((i2 & 14) == 4) | ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((i2 & 7168) == 2048) | ((i2 & 57344) == 16384);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue3 == obj2) {
                Object activityResultRegistryKt$$ExternalSyntheticLambda1 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(proxyScreenState, function1, function2, function3, obj, 5);
                gapComposer.updateRememberedValue(activityResultRegistryKt$$ExternalSyntheticLambda1);
                objRememberedValue3 = activityResultRegistryKt$$ExternalSyntheticLambda1;
            }
            gapComposer.end(false);
            ProgressionUtilKt.LazyColumn(24966, 488, null, null, spacedAlignedM108spacedBy0680j_4, paddingValuesImpl, lazyListStateRememberLazyListState, gapComposer, null, fillElement, (Function1) objRememberedValue3, false, false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda5(proxyScreenState, function1, function2, function3, function4, i, 3);
        }
    }

    /* JADX INFO: renamed from: ProxyGroupHeader-TgFrcIs, reason: not valid java name */
    public static final void m815ProxyGroupHeaderTgFrcIs(final String str, ProxyGroup proxyGroup, final long j, final boolean z, boolean z2, final Function0 function0, Function0 function1, final Function1 function2, GapComposer gapComposer, final int i) {
        ProxyGroup proxyGroup2;
        BiasAlignment.Vertical vertical;
        AppColors appColors;
        final Function0 function3;
        boolean z3 = z2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1251945757);
        int i2 = (gapComposer2.changed(str) ? 4 : 2) | i | (gapComposer2.changedInstance(proxyGroup) ? 32 : 16) | (gapComposer2.changed(j) ? 256 : 128);
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(z3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 1048576 : 524288;
        }
        int i3 = i2;
        if ((4793491 & i3) == 4793490 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            function3 = function1;
            proxyGroup2 = proxyGroup;
        } else {
            AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 0.0f : -90.0f, ArcSplineKt.tween$default(250, 2, EasingKt.FastOutSlowInEasing), "chevron", gapComposer2, 3072);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            gapComposer2.startReplaceGroup(634148725);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new GestureNodeKt$$ExternalSyntheticLambda0(function2, 4);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.end(false);
            float f = 12;
            Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(ImageKt.m48clickableoSLSa3U$default(15, FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue), null, function0, false), 14, f);
            BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m108spacedBy0680j_4(f), vertical2, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM126paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m294setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            String str2 = proxyGroup.icon;
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            m813GroupIconXOJAsU(str2, proxyGroup.type, j, gapComposer2, i3 & 896);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m108spacedBy0680j_4(3), Alignment.Companion.Start, gapComposer2, 6);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m274TextNvy7gAk(str, null, appColors2.textPrimary, TextUnitKt.getSp(15), null, FontWeight.SemiBold, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer2, (i3 & 14) | 1597440, 24960, 110506);
            GapComposer gapComposer3 = gapComposer2;
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.m108spacedBy0680j_4(6), vertical2, gapComposer3, 54);
            long j4 = gapComposer3.compositeKeyHashCode;
            int i6 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            Stack.m294setimpl(gapComposer3, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            proxyGroup2 = proxyGroup;
            m814GroupTypeBadgeRPmYEkk(proxyGroup2.type, j, gapComposer3, (i3 >> 3) & 112);
            gapComposer3.startReplaceGroup(904519782);
            if (StringsKt.isBlank(proxyGroup2.now)) {
                vertical = vertical2;
                appColors = appColors2;
            } else {
                String str3 = proxyGroup2.now;
                TextStyle textStyle = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelSmall;
                long j5 = appColors2.textSecondary;
                long sp = TextUnitKt.getSp(11);
                if (1.0f <= 0.0d) {
                    InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                }
                vertical = vertical2;
                appColors = appColors2;
                TextKt.m274TextNvy7gAk(str3, new LayoutWeightElement(1.0f, false), j5, sp, null, null, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer, 24576, 24960, 110568);
                gapComposer3 = gapComposer;
            }
            gapComposer3.end(false);
            gapComposer3.end(true);
            gapComposer3.end(true);
            RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.m108spacedBy0680j_4(2), vertical, gapComposer3, 54);
            long j6 = gapComposer3.compositeKeyHashCode;
            int i7 = (int) (j6 ^ (j6 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            Stack.m294setimpl(gapComposer3, rowMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
            z3 = z2;
            function3 = function1;
            GroupTestButton(z3, function3, gapComposer3, ((i3 >> 12) & 14) | ((i3 >> 15) & 112));
            ImageVector imageVectorBuild = ExpandMoreKt._expandMore;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Filled.ExpandMore", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i8 = VectorKt.$r8$clinit;
                SolidColor solidColor = new SolidColor(Color.Black);
                ArrayList arrayList = new ArrayList(32);
                arrayList.add(new PathNode.MoveTo(16.59f, 8.59f));
                arrayList.add(new PathNode.LineTo(12.0f, 13.17f));
                arrayList.add(new PathNode.LineTo(7.41f, 8.59f));
                arrayList.add(new PathNode.LineTo(6.0f, 10.0f));
                arrayList.add(new PathNode.RelativeLineTo(6.0f, 6.0f));
                arrayList.add(new PathNode.RelativeLineTo(6.0f, -6.0f));
                arrayList.add(PathNode.Close.INSTANCE);
                ImageVector.Builder.m500addPathoIyEayM$default(builder, arrayList, solidColor);
                imageVectorBuild = builder.build();
                ExpandMoreKt._expandMore = imageVectorBuild;
            }
            long j7 = appColors.textSecondary;
            Modifier modifierM137size3ABfNKs = SizeKt.m137size3ABfNKs(companion, 20);
            float fFloatValue = ((Number) stateAnimateFloatAsState.getValue()).floatValue();
            if (fFloatValue != 0.0f) {
                modifierM137size3ABfNKs = BrushKt.m415graphicsLayer_6ThJ44$default(modifierM137size3ABfNKs, 0.0f, 0.0f, 0.0f, 0.0f, fFloatValue, null, false, 524031);
            }
            Modifier modifier = modifierM137size3ABfNKs;
            GapComposer gapComposer4 = gapComposer3;
            IconKt.m248Iconww6aTOc(imageVectorBuild, null, modifier, j7, gapComposer4, 48, 0);
            gapComposer2 = gapComposer4;
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z4 = z3;
            final ProxyGroup proxyGroup3 = proxyGroup2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ProxyScreenKt.m815ProxyGroupHeaderTgFrcIs(str, proxyGroup3, j, z, z4, function0, function3, function2, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyHeader(final boolean z, final boolean z2, final ProxySort proxySort, final TunnelState.Mode mode, final TunnelState.Mode mode2, final boolean z3, final Function0 function0, final Function0 function1, final Function1 function2, final Function1 function3, GapComposer gapComposer, final int i) {
        int i2;
        MutableState mutableState;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-117296816);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(proxySort) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(mode) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(mode2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changed(z3) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 536870912 : 268435456;
        }
        if ((306783379 & i2) == 306783378 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(153684934);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            gapComposer2.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int i3 = i2;
            Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 8, 6);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM126paddingVpY3zN4);
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
            Integer numValueOf = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
            ScrimKt.IconButton(function0, flowRowOverflow.align(companion, Alignment.Companion.CenterStart), false, null, null, Thread_jvmKt.rememberComposableLambda(1292559348, new LogsScreenKt.AnonymousClass6(appColors, 26), gapComposer2), gapComposer, ((i3 >> 18) & 14) | 1572864, 60);
            Modifier modifierAlign = flowRowOverflow.align(companion, Alignment.Companion.CenterEnd);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            long j2 = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierAlign);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            ScrimKt.IconButton(function1, null, z2, null, null, Thread_jvmKt.rememberComposableLambda(2076762840, new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyHeader$1$2$1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ImageVector imageVectorBuild;
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        boolean z4 = z;
                        if (z4) {
                            imageVectorBuild = UnfoldLessKt._unfoldLess;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder = new ImageVector.Builder("Filled.UnfoldLess", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i6 = VectorKt.$r8$clinit;
                                SolidColor solidColor = new SolidColor(Color.Black);
                                Headers.Builder builder2 = new Headers.Builder(2);
                                builder2.moveTo(7.41f, 18.59f);
                                builder2.lineTo(8.83f, 20.0f);
                                builder2.lineTo(12.0f, 16.83f);
                                builder2.lineTo(15.17f, 20.0f);
                                builder2.lineToRelative(1.41f, -1.41f);
                                builder2.lineTo(12.0f, 14.0f);
                                builder2.lineToRelative(-4.59f, 4.59f);
                                builder2.close();
                                builder2.moveTo(16.59f, 5.41f);
                                builder2.lineTo(15.17f, 4.0f);
                                builder2.lineTo(12.0f, 7.17f);
                                builder2.lineTo(8.83f, 4.0f);
                                builder2.lineTo(7.41f, 5.41f);
                                builder2.lineTo(12.0f, 10.0f);
                                builder2.lineToRelative(4.59f, -4.59f);
                                builder2.close();
                                ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                                imageVectorBuild = builder.build();
                                UnfoldLessKt._unfoldLess = imageVectorBuild;
                            }
                        } else {
                            imageVectorBuild = UnfoldMoreKt._unfoldMore;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder3 = new ImageVector.Builder("Filled.UnfoldMore", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i7 = VectorKt.$r8$clinit;
                                SolidColor solidColor2 = new SolidColor(Color.Black);
                                Headers.Builder builder4 = new Headers.Builder(2);
                                builder4.moveTo(12.0f, 5.83f);
                                builder4.lineTo(15.17f, 9.0f);
                                builder4.lineToRelative(1.41f, -1.41f);
                                builder4.lineTo(12.0f, 3.0f);
                                builder4.lineTo(7.41f, 7.59f);
                                builder4.lineTo(8.83f, 9.0f);
                                builder4.lineTo(12.0f, 5.83f);
                                builder4.close();
                                builder4.moveTo(12.0f, 18.17f);
                                builder4.lineTo(8.83f, 15.0f);
                                builder4.lineToRelative(-1.41f, 1.41f);
                                builder4.lineTo(12.0f, 21.0f);
                                builder4.lineToRelative(4.59f, -4.59f);
                                builder4.lineTo(15.17f, 15.0f);
                                builder4.lineTo(12.0f, 18.17f);
                                builder4.close();
                                ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                                ImageVector imageVectorBuild2 = builder3.build();
                                UnfoldMoreKt._unfoldMore = imageVectorBuild2;
                                imageVectorBuild = imageVectorBuild2;
                            }
                        }
                        ImageVector imageVector = imageVectorBuild;
                        String strStringResource = StringResources_androidKt.stringResource(z4 ? R.string.proxy_collapse_all : R.string.proxy_expand_all, gapComposer3);
                        boolean z5 = z2;
                        AppColors appColors2 = appColors;
                        IconKt.m248Iconww6aTOc(imageVector, strStringResource, null, z5 ? appColors2.textPrimary : appColors2.textSecondary, gapComposer3, 0, 4);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, ((i3 << 3) & 896) | ((i3 >> 21) & 14) | 1572864, 58);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            gapComposer.startReplaceGroup(527238548);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                mutableState = mutableState2;
                objRememberedValue2 = new ProxyScreenKt$$ExternalSyntheticLambda18(mutableState, 0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState = mutableState2;
            }
            gapComposer.end(false);
            ScrimKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Thread_jvmKt.rememberComposableLambda(76807518, new LogsScreenKt.AnonymousClass6(appColors, 27), gapComposer), gapComposer, 1572870, 62);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            gapComposer.startReplaceGroup(527250869);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ProxyScreenKt$$ExternalSyntheticLambda18(mutableState, 4);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function4 = (Function0) objRememberedValue3;
            gapComposer.end(false);
            int i7 = i3 >> 6;
            ProxySettingsMenu(zBooleanValue, function4, proxySort, mode, mode2, z3, function2, function3, gapComposer, (i3 & 896) | 48 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i7) | (i7 & 29360128));
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.ProxyHeader(z, z2, proxySort, mode, mode2, z3, function0, function1, function2, function3, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyNodeCard(final Proxy proxy, final boolean z, final boolean z2, final boolean z3, final Function0 function0, final Function0 function1, GapComposer gapComposer, final int i) {
        long jColor;
        long j;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(568817853);
        int i2 = i | (gapComposer.changedInstance(proxy) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(z2) ? 256 : 128) | (gapComposer.changed(z3) ? 2048 : 1024) | (gapComposer.changedInstance(function0) ? 16384 : 8192) | (gapComposer.changedInstance(function1) ? 131072 : 65536);
        if ((74899 & i2) == 74898 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(10);
            gapComposer.startReplaceGroup(213713291);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            if (z) {
                jColor = appColors.accentFill;
            } else {
                long j2 = appColors.cardBackground;
                jColor = BrushKt.Color(Color.m438getRedimpl(j2), Color.m437getGreenimpl(j2), Color.m435getBlueimpl(j2), 0.4f, Color.m436getColorSpaceimpl(j2));
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                j = Color.White;
            } else {
                j = z ? appColors.accentBorder : appColors.cardBorder;
            }
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = SizeKt.fillMaxWidth(companion, 1.0f).then(new SizeElement(0.0f, (2 & 1) != 0 ? Float.NaN : 46, 0.0f, (2 & 2) != 0 ? Float.NaN : 0.0f, 5));
            gapComposer.startReplaceGroup(213727877);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 24);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(ImageKt.m48clickableoSLSa3U$default(15, ImageKt.m45borderxT4_qwU(f, j, ImageKt.m44backgroundbw27NRU(ClipKt.clip(FocusTraversalKt.onFocusChanged(modifierThen, (Function1) objRememberedValue2), roundedCornerShapeM156RoundedCornerShape0680j_4), jColor, BrushKt.RectangleShape), roundedCornerShapeM156RoundedCornerShape0680j_4), null, function0, false), 16, 8);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m108spacedBy0680j_4(6), Alignment.Companion.CenterVertically, gapComposer, 54);
            long j3 = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM126paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m294setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            float f2 = 2;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m108spacedBy0680j_4(f2), Alignment.Companion.Start, gapComposer, 6);
            long j4 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            String str = proxy.title;
            if (StringsKt.isBlank(str)) {
                str = proxy.name;
            }
            String str2 = str;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m274TextNvy7gAk(str2, null, appColors.textPrimary, TextUnitKt.getSp(13), null, FontWeight.Medium, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 1597440, 24960, 110506);
            gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(794779099);
            if (!StringsKt.isBlank(proxy.subtitle)) {
                TextKt.m274TextNvy7gAk(proxy.subtitle, null, appColors.textSecondary, TextUnitKt.getSp(10), null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer, 24576, 24960, 110570);
                gapComposer2 = gapComposer;
            }
            gapComposer2.end(false);
            gapComposer2.end(true);
            Modifier modifierThen2 = companion.then(new SizeElement((2 & 1) != 0 ? Float.NaN : 44, 0.0f, (2 & 2) != 0 ? Float.NaN : 0.0f, 0.0f, 10));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.CenterEnd, false);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            if (z2) {
                gapComposer2.startReplaceGroup(-1130855966);
                GapComposer gapComposer3 = gapComposer2;
                ProgressIndicatorKt.m255CircularProgressIndicator4lLiAd8(SizeKt.m137size3ABfNKs(companion, 14), appColors.textPrimary, f2, 0L, 0, 0.0f, gapComposer3, 390, 56);
                gapComposer2 = gapComposer3;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(794811501);
                int i6 = i2 >> 6;
                PingBadge(proxy.delay, z3, z, function1, gapComposer2, (i6 & 112) | ((i2 << 3) & 896) | (i6 & 7168));
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, z2, z3, function0, function1, i) { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda9
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function0 f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ProxyScreenKt.ProxyNodeCard(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyScreen(final ProxyScreenState proxyScreenState, final Function0 function0, final Function2 function2, final Function1 function1, final Function0 function3, final Function0 function4, final Function1 function5, final Function2 function6, final Function1 function7, final Function1 function8, Function0 function9, final Modifier modifier, GapComposer gapComposer, final int i) {
        boolean z;
        final Function0 function10 = function9;
        String str = proxyScreenState.error;
        List list = proxyScreenState.groupNames;
        gapComposer.startRestartGroup(1403105193);
        int i2 = i | (gapComposer.changed(proxyScreenState) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changedInstance(function3) ? 16384 : 8192) | (gapComposer.changedInstance(function4) ? 131072 : 65536) | (gapComposer.changedInstance(function5) ? 1048576 : 524288) | (gapComposer.changedInstance(function6) ? 8388608 : 4194304) | (gapComposer.changedInstance(function7) ? 67108864 : 33554432) | (gapComposer.changedInstance(function8) ? 536870912 : 268435456);
        int i3 = 48 | (gapComposer.changedInstance(function10) ? 4 : 2);
        if ((i2 & 306783379) == 306783378 && (i3 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(SizeKt.fillMaxWidth(modifier, 1.0f), appColors.appBackground, BrushKt.RectangleShape);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
            long j = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM44backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m294setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            boolean z2 = !list.isEmpty() && proxyScreenState.expandedGroups.containsAll(list);
            boolean z3 = !list.isEmpty();
            ProxySort proxySort = proxyScreenState.sort;
            TunnelState.Mode mode = proxyScreenState.currentMode;
            TunnelState.Mode mode2 = proxyScreenState.configMode;
            boolean z4 = proxyScreenState.modeSwitchAllowed;
            gapComposer.startReplaceGroup(860714943);
            int i5 = i2 & 14;
            boolean z5 = (i5 == 4) | ((i2 & 458752) == 131072) | ((i2 & 57344) == 16384);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z5 || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new GapComposer$$ExternalSyntheticLambda0(proxyScreenState, function4, function3, 13);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            ProxyHeader(z2, z3, proxySort, mode, mode2, z4, function0, (Function0) objRememberedValue, function7, function8, gapComposer, ((i2 << 15) & 3670016) | (i2 & 234881024) | (i2 & 1879048192));
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            Modifier modifierThen = modifierFillMaxWidth.then(new LayoutWeightElement(1.0f, true));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j2 = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            if (proxyScreenState.isLoading && list.isEmpty()) {
                gapComposer.startReplaceGroup(1504359340);
                CenterMessage(Thread_jvmKt.rememberComposableLambda(326731556, new LogsScreenKt.AnonymousClass6(appColors, 28), gapComposer), gapComposer, 6);
                gapComposer.end(false);
                function10 = function9;
            } else if (str != null) {
                gapComposer.startReplaceGroup(1504364050);
                function10 = function9;
                ErrorContent(str, function10, gapComposer, (i3 << 3) & 112);
                gapComposer.end(false);
            } else {
                function10 = function9;
                if (list.isEmpty()) {
                    gapComposer.startReplaceGroup(1504369273);
                    CenterMessage(ComposableSingletons$ProxyScreenKt.f28lambda1, gapComposer, 6);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(1504377042);
                    int i7 = i5 | ((i2 >> 6) & 112) | (i2 & 896);
                    int i8 = i2 >> 9;
                    z = true;
                    ProxyGroupAccordionList(proxyScreenState, function1, function2, function5, function6, gapComposer, i7 | (i8 & 7168) | (i8 & 57344));
                    gapComposer.end(false);
                }
                gapComposer.end(z);
                gapComposer.end(z);
            }
            z = true;
            gapComposer.end(z);
            gapComposer.end(z);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(function0, function2, function1, function3, function4, function5, function6, function7, function8, function10, modifier, i) { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda13
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Function0 f$10;
                public final /* synthetic */ Modifier f$11;
                public final /* synthetic */ Function2 f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function0 f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function2 f$7;
                public final /* synthetic */ Function1 f$8;
                public final /* synthetic */ Function1 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ProxyScreenKt.ProxyScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, (GapComposer) obj, Stack.updateChangedFlags(1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxySettingsMenu(final boolean z, final Function0 function0, final ProxySort proxySort, final TunnelState.Mode mode, final TunnelState.Mode mode2, final boolean z2, final Function1 function1, final Function1 function2, GapComposer gapComposer, final int i) {
        boolean z3;
        int i2;
        gapComposer.startRestartGroup(1789650877);
        if ((i & 6) == 0) {
            z3 = z;
            i2 = (gapComposer.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(proxySort) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(mode) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(mode2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            AndroidMenu_androidKt.m234DropdownMenuIlH_yew(z3, function0, null, 0L, null, null, RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(20), BrushKt.m412compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(140775138, new LogsScreenKt.C00212(z2, mode, mode2, function2, proxySort, function1), gapComposer), gapComposer, i2 & 126);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.ProxySettingsMenu(z, function0, proxySort, mode, mode2, z2, function1, function2, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SegmentedPill(String str, boolean z, Function0 function0, Modifier modifier, boolean z2, GapComposer gapComposer, int i, int i2) {
        boolean z3;
        int i3;
        long jColor;
        boolean z4;
        boolean z5;
        boolean z6;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1458177244);
        int i4 = i | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024) | (gapComposer2.changed(modifier) ? 16384 : 8192);
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 = i4 | 196608;
            z3 = z2;
        } else {
            z3 = z2;
            i3 = i4 | (gapComposer2.changed(z3) ? 131072 : 65536);
        }
        if ((74897 & i3) == 74896 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            z6 = z3;
        } else {
            boolean z7 = i5 != 0 ? false : z3;
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(11);
            if (z) {
                jColor = appColors.accentFill;
            } else {
                long j = appColors.cardBackground;
                jColor = BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), 0.5f, Color.m436getColorSpaceimpl(j));
            }
            long j2 = z ? appColors.accentBorder : appColors.cardBorder;
            State stateM23animateColorAsStateeuL9pac = SingleValueAnimationKt.m23animateColorAsStateeuL9pac(jColor, null, "pillBg", gapComposer2, 384, 10);
            State stateM23animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m23animateColorAsStateeuL9pac(j2, null, "pillBorder", gapComposer, 384, 10);
            Modifier modifierClip = ClipKt.clip(SizeKt.m132height3ABfNKs(modifier, 38), roundedCornerShapeM156RoundedCornerShape0680j_4);
            long j3 = ((Color) stateM23animateColorAsStateeuL9pac.getValue()).value;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Modifier modifierM127paddingVpY3zN4$default = OffsetKt.m127paddingVpY3zN4$default(ImageKt.m48clickableoSLSa3U$default(15, ImageKt.m45borderxT4_qwU(1, ((Color) stateM23animateColorAsStateeuL9pac2.getValue()).value, ImageKt.m44backgroundbw27NRU(modifierClip, j3, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM156RoundedCornerShape0680j_4), null, function0, false), 8, 0.0f, 2);
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j4 = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM127paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i6);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
            TextKt.m274TextNvy7gAk(str, null, appColors.textPrimary, TextUnitKt.getSp(13), null, z ? FontWeight.Bold : FontWeight.Medium, 0L, new TextAlign(3), 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer, ((i3 >> 3) & 14) | 24576, 24960, 109482);
            gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(137278776);
            if (z7) {
                BiasAlignment biasAlignment2 = Alignment.Companion.TopEnd;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                float f = 5;
                Modifier modifierM137size3ABfNKs = SizeKt.m137size3ABfNKs(OffsetKt.m129paddingqDBjuR0$default(flowRowOverflow.align(companion, biasAlignment2), 0.0f, f, f, 0.0f, 9), 10);
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                Modifier modifierClip2 = ClipKt.clip(modifierM137size3ABfNKs, roundedCornerShape);
                long j5 = appColors.appBackground;
                Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(modifierClip2, BrushKt.Color(Color.m438getRedimpl(j5), Color.m437getGreenimpl(j5), Color.m435getBlueimpl(j5), 0.6f, Color.m436getColorSpaceimpl(j5)), rectangleShapeKt$RectangleShape$1);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                long j6 = gapComposer2.compositeKeyHashCode;
                int i7 = (int) (j6 ^ (j6 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM44backgroundbw27NRU);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                Modifier modifierClip3 = ClipKt.clip(SizeKt.m137size3ABfNKs(companion, 7), roundedCornerShape);
                long j7 = appColors.textPrimary;
                z5 = false;
                BoxKt.Box(ImageKt.m44backgroundbw27NRU(modifierClip3, BrushKt.Color(Color.m438getRedimpl(j7), Color.m437getGreenimpl(j7), Color.m435getBlueimpl(j7), 0.78f, Color.m436getColorSpaceimpl(j7)), rectangleShapeKt$RectangleShape$1), gapComposer2, 0);
                z4 = true;
                gapComposer2.end(true);
            } else {
                z4 = true;
                z5 = false;
            }
            gapComposer2.end(z5);
            gapComposer2.end(z4);
            z6 = z7;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesScreenKt$$ExternalSyntheticLambda4(str, z, function0, modifier, z6, i, i2);
        }
    }

    public static final void SettingsSection(String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1252361885);
        if (((i | (gapComposer2.changed(str) ? 4 : 2)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m108spacedBy0680j_4(10), Alignment.Companion.Start, gapComposer2, 6);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m294setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m274TextNvy7gAk(str.toUpperCase(Locale.ROOT), OffsetKt.m129paddingqDBjuR0$default(companion, 4, 0.0f, 0.0f, 0.0f, 14), appColors.textSecondary, TextUnitKt.getSp(11), null, FontWeight.SemiBold, TextUnitKt.getSp(0.6d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 102260784, 0, 130728);
            gapComposer2 = gapComposer;
            composableLambdaImpl.invoke((Object) gapComposer2, (Object) 6);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BasicTooltipKt$$ExternalSyntheticLambda7(str, composableLambdaImpl, i, 3);
        }
    }
}
