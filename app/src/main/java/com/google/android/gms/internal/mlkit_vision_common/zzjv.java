package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.filled.DnsKt;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda4;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.UpdateDialogKt;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda18;
import com.github.kr328.clash.compose.settings.SettingsEntry;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$$ExternalSyntheticLambda6;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.remote.Remote;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpz;
import com.google.android.gms.internal.mlkit_vision_common.zzjv;
import com.koala.clash.R;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import okhttp3.Headers;
import okhttp3.internal.http.HttpMethod;
import okio.Options$Companion;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjv {
    public static final void BuildInfoFooter(int i, GapComposer gapComposer, Modifier modifier, Function0 function0, boolean z) {
        GapComposer gapComposer2;
        Modifier modifier2;
        gapComposer.startRestartGroup(-381278243);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(1843976365);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(1843978656);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FilesActivity$showError$1(mutableState, null, 13);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue2);
            gapComposer2 = gapComposer;
            modifier2 = modifier;
            zzkc.m822GlassSurfaceYxtnGt4(modifier2, 12, null, Thread_jvmKt.rememberComposableLambda(2119322778, new HomeScreenKt.AnonymousClass2(z, appColors, function0, mutableState), gapComposer), gapComposer2, ((i2 >> 6) & 14) | 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SettingsScreenKt$$ExternalSyntheticLambda6(z, function0, modifier2, i);
        }
    }

    public static final void SettingsRow(SettingsEntry settingsEntry, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(415203615);
        if ((((gapComposer.changed(settingsEntry) ? 4 : 2) | i) & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-723558107);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Modifier modifierM132height3ABfNKs = SizeKt.m132height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 64);
            gapComposer.startReplaceGroup(-723552865);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 28);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            float f = 12;
            gapComposer2 = gapComposer;
            zzkc.m822GlassSurfaceYxtnGt4(ImageKt.m45borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent, FocusTraversalKt.onFocusChanged(modifierM132height3ABfNKs, (Function1) objRememberedValue2), RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(f)), f, null, Thread_jvmKt.rememberComposableLambda(-1731266878, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(7, settingsEntry, appColors), gapComposer), gapComposer2, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 29, settingsEntry);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:104:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:109:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0145  */
    /* JADX WARN: Code duplicated, block: B:67:0x0167  */
    /* JADX WARN: Code duplicated, block: B:70:0x017c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0190  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:80:0x0327  */
    /* JADX WARN: Code duplicated, block: B:84:0x033e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0454  */
    /* JADX WARN: Code duplicated, block: B:92:0x0468  */
    /* JADX WARN: Code duplicated, block: B:96:0x0591  */
    /* JADX WARN: Code duplicated, block: B:98:0x05b1 A[ADDED_TO_REGION] */
    public static final void SettingsScreen(Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Modifier modifier, final PaddingValuesImpl paddingValuesImpl, boolean z, GapComposer gapComposer, int i, int i2) {
        boolean z2;
        final SnackbarHostState snackbarHostState;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        MutableState mutableState;
        Object objM;
        MutableState mutableState2;
        Object objM2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final Context context;
        Object objRememberedValue4;
        final CoroutineScope coroutineScope;
        Object objRememberedValue5;
        final MutableState mutableState3;
        Object objM3;
        ListBuilder listBuilderCreateListBuilder;
        ImageVector imageVectorBuild;
        ImageVector imageVectorBuild2;
        GapComposer gapComposer2;
        Modifier modifier2;
        boolean z3;
        boolean zChangedInstance;
        Object objRememberedValue6;
        MutableState mutableState4;
        Object objM4;
        ImageVector imageVectorBuild3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(-1578400540);
        int i3 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | 196608;
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changed(paddingValuesImpl) ? 1048576 : 524288;
        }
        int i4 = 12582912 | i3;
        int i5 = i2 & 256;
        if (i5 == 0) {
            if ((i & 100663296) == 0) {
                z2 = z;
                i4 |= gapComposer.changed(z2) ? 67108864 : 33554432;
            }
            if ((i4 & 38347923) == 38347922 || !gapComposer.getSkipping()) {
                if (i5 != 0) {
                    z2 = false;
                }
                final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
                gapComposer.startReplaceGroup(-995676386);
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer$Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objM = Density.CC.m(-995673723, gapComposer, false);
                if (objM == neverEqualPolicy) {
                    objM = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objM);
                }
                mutableState2 = (MutableState) objM;
                objM2 = Density.CC.m(-995671868, gapComposer, false);
                if (objM2 == neverEqualPolicy) {
                    objM2 = new ParcelableSnapshotMutableIntState(0);
                    gapComposer.updateRememberedValue(objM2);
                }
                parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
                gapComposer.end(false);
                Boolean bool = (Boolean) mutableState.getValue();
                bool.getClass();
                Integer numValueOf = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
                gapComposer.startReplaceGroup(-995669122);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 6);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gapComposer.end(false);
                Stack.LaunchedEffect(bool, numValueOf, (Function2) objRememberedValue2, gapComposer);
                Unit unit = Unit.INSTANCE;
                gapComposer.startReplaceGroup(-995661558);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(13, mutableState, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                gapComposer.end(false);
                Stack.DisposableEffect(unit, (Function1) objRememberedValue3, gapComposer);
                context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                gapComposer.startReplaceGroup(-995632175);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                mutableState3 = (MutableState) objRememberedValue5;
                objM3 = Density.CC.m(-995629851, gapComposer, false);
                if (objM3 == neverEqualPolicy) {
                    objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objM3);
                }
                final MutableState mutableState5 = (MutableState) objM3;
                gapComposer.end(false);
                listBuilderCreateListBuilder = MatrixExt.createListBuilder();
                listBuilderCreateListBuilder.add(new SettingsEntry(HttpMethod.getSettings(), R.string.app, function0));
                imageVectorBuild = DnsKt._dns;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i6 = VectorKt.$r8$clinit;
                    SolidColor solidColor = new SolidColor(Color.Black);
                    Headers.Builder builder2 = new Headers.Builder(2);
                    builder2.moveTo(20.0f, 13.0f);
                    builder2.horizontalLineTo(4.0f);
                    builder2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                    builder2.verticalLineToRelative(6.0f);
                    builder2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                    builder2.horizontalLineToRelative(16.0f);
                    builder2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                    builder2.verticalLineToRelative(-6.0f);
                    builder2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    builder2.close();
                    builder2.moveTo(7.0f, 19.0f);
                    builder2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                    builder2.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                    builder2.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                    builder2.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                    builder2.close();
                    builder2.moveTo(20.0f, 3.0f);
                    builder2.horizontalLineTo(4.0f);
                    builder2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                    builder2.verticalLineToRelative(6.0f);
                    builder2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                    builder2.horizontalLineToRelative(16.0f);
                    builder2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                    builder2.verticalLineTo(4.0f);
                    builder2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    builder2.close();
                    builder2.moveTo(7.0f, 9.0f);
                    builder2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                    builder2.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                    builder2.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                    builder2.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                    builder2.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                    imageVectorBuild = builder.build();
                    DnsKt._dns = imageVectorBuild;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    listBuilderCreateListBuilder.add(new SettingsEntry(Options$Companion.getSwapHoriz(), R.string.connections, function2));
                }
                imageVectorBuild2 = CharsKt._article;
                if (imageVectorBuild2 == null) {
                    ImageVector.Builder builder3 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                    int i7 = VectorKt.$r8$clinit;
                    long j = Color.Black;
                    SolidColor solidColor2 = new SolidColor(j);
                    Headers.Builder builder4 = new Headers.Builder(2);
                    builder4.moveTo(19.0f, 5.0f);
                    builder4.verticalLineToRelative(14.0f);
                    builder4.horizontalLineTo(5.0f);
                    builder4.verticalLineTo(5.0f);
                    builder4.horizontalLineTo(19.0f);
                    builder4.moveTo(19.0f, 3.0f);
                    builder4.horizontalLineTo(5.0f);
                    builder4.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                    builder4.verticalLineToRelative(14.0f);
                    builder4.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                    builder4.horizontalLineToRelative(14.0f);
                    builder4.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                    builder4.verticalLineTo(5.0f);
                    builder4.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                    builder4.lineTo(19.0f, 3.0f);
                    builder4.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                    SolidColor solidColor3 = new SolidColor(j);
                    Headers.Builder builder5 = new Headers.Builder(2);
                    builder5.moveTo(14.0f, 17.0f);
                    builder5.horizontalLineTo(7.0f);
                    builder5.verticalLineToRelative(-2.0f);
                    builder5.horizontalLineToRelative(7.0f);
                    builder5.verticalLineTo(17.0f);
                    builder5.close();
                    builder5.moveTo(17.0f, 13.0f);
                    builder5.horizontalLineTo(7.0f);
                    builder5.verticalLineToRelative(-2.0f);
                    builder5.horizontalLineToRelative(10.0f);
                    builder5.verticalLineTo(13.0f);
                    builder5.close();
                    builder5.moveTo(17.0f, 9.0f);
                    builder5.horizontalLineTo(7.0f);
                    builder5.verticalLineTo(7.0f);
                    builder5.horizontalLineToRelative(10.0f);
                    builder5.verticalLineTo(9.0f);
                    builder5.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder5.namesAndValues, solidColor3);
                    imageVectorBuild2 = builder3.build();
                    CharsKt._article = imageVectorBuild2;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
                if (((Boolean) mutableState.getValue()).booleanValue() && ((Boolean) mutableState2.getValue()).booleanValue()) {
                    imageVectorBuild3 = zzpz._swapVerticalCircle;
                    if (imageVectorBuild3 == null) {
                        ImageVector.Builder builder6 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i8 = VectorKt.$r8$clinit;
                        SolidColor solidColor4 = new SolidColor(Color.Black);
                        Headers.Builder builder7 = new Headers.Builder(2);
                        builder7.moveTo(12.0f, 2.0f);
                        builder7.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                        builder7.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                        builder7.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                        builder7.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                        builder7.close();
                        builder7.moveTo(6.5f, 9.0f);
                        builder7.lineTo(10.0f, 5.5f);
                        builder7.lineTo(13.5f, 9.0f);
                        builder7.lineTo(11.0f, 9.0f);
                        builder7.verticalLineToRelative(4.0f);
                        builder7.lineTo(9.0f, 13.0f);
                        builder7.lineTo(9.0f, 9.0f);
                        builder7.lineTo(6.5f, 9.0f);
                        builder7.close();
                        builder7.moveTo(17.5f, 15.0f);
                        builder7.lineTo(14.0f, 18.5f);
                        builder7.lineTo(10.5f, 15.0f);
                        builder7.lineTo(13.0f, 15.0f);
                        builder7.verticalLineToRelative(-4.0f);
                        builder7.horizontalLineToRelative(2.0f);
                        builder7.verticalLineToRelative(4.0f);
                        builder7.horizontalLineToRelative(2.5f);
                        builder7.close();
                        ImageVector.Builder.m500addPathoIyEayM$default(builder6, builder7.namesAndValues, solidColor4);
                        imageVectorBuild3 = builder6.build();
                        zzpz._swapVerticalCircle = imageVectorBuild3;
                    }
                    listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
                }
                final ListBuilder listBuilderBuild = MatrixExt.build(listBuilderCreateListBuilder);
                boolean z4 = z2;
                ScaffoldKt.m260ScaffoldTvnljyQ(ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProxyScreenKt.AnonymousClass1(z2, appColors, 3), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        PaddingValues paddingValues = (PaddingValues) obj;
                        GapComposer gapComposer3 = (GapComposer) obj2;
                        int iIntValue = ((Number) obj3).intValue();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                        }
                        if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                            gapComposer3.skipToGroupEnd();
                        } else {
                            Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape);
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                            long j2 = gapComposer3.compositeKeyHashCode;
                            int i9 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM44backgroundbw27NRU);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m294setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m294setimpl(gapComposer3, Integer.valueOf(i9), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m293reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m294setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            if (1.0f <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                            float f = 8;
                            float f2 = 16;
                            PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo117calculateTopPaddingD9Ej5fM() + f, f2, f);
                            Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(12);
                            gapComposer3.startReplaceGroup(-71810661);
                            List list = listBuilderBuild;
                            boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                            if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                                objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(11, list);
                                gapComposer3.updateRememberedValue(objRememberedValue7);
                            }
                            gapComposer3.end(false);
                            ProgressionUtilKt.LazyColumn(24576, 490, null, null, spacedAlignedM108spacedBy0680j_4, paddingValuesImpl2, null, gapComposer3, null, modifierFillMaxWidth, (Function1) objRememberedValue7, false, false);
                            MutableState mutableState6 = mutableState5;
                            boolean zBooleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
                            gapComposer3.startReplaceGroup(-71802873);
                            CoroutineScope coroutineScope2 = coroutineScope;
                            boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                            SnackbarHostState snackbarHostState2 = snackbarHostState;
                            boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                            Context context2 = context;
                            boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                                PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState6, snackbarHostState2, context2, mutableState3, 1);
                                gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                                objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                            }
                            gapComposer3.end(false);
                            zzjv.BuildInfoFooter(0, gapComposer3, OffsetKt.m129paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                            gapComposer3.end(true);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 805306416, 444);
                gapComposer2 = gapComposer;
                if (((UpdateInfo) mutableState3.getValue()) != null) {
                    UpdateInfo updateInfo = (UpdateInfo) mutableState3.getValue();
                    gapComposer2.startReplaceGroup(-995499547);
                    zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                    objRememberedValue6 = gapComposer2.rememberedValue();
                    if (!zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                        mutableState4 = mutableState3;
                        BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda1 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                        gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda1);
                        objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda1;
                    } else {
                        mutableState4 = mutableState3;
                    }
                    Function0 function5 = (Function0) objRememberedValue6;
                    objM4 = Density.CC.m(-995475816, gapComposer2, false);
                    if (objM4 == neverEqualPolicy) {
                        objM4 = new ProxyScreenKt$$ExternalSyntheticLambda18(mutableState4, 9);
                        gapComposer2.updateRememberedValue(objM4);
                    }
                    gapComposer2.end(false);
                    UpdateDialogKt.UpdateDialog(updateInfo, function5, (Function0) objM4, gapComposer2, 384);
                }
                modifier2 = Modifier.Companion.$$INSTANCE;
                z3 = z4;
            } else {
                gapComposer.skipToGroupEnd();
                z3 = z2;
                gapComposer2 = gapComposer;
                modifier2 = modifier;
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, function4, modifier2, paddingValuesImpl, z3, i, i2, 2);
            }
        }
        i4 = 113246208 | i3;
        z2 = z;
        if ((i4 & 38347923) == 38347922) {
            if (i5 != 0) {
                z2 = false;
            }
            final AppColors appColors2 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            gapComposer.startReplaceGroup(-995676386);
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objM = Density.CC.m(-995673723, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            mutableState2 = (MutableState) objM;
            objM2 = Density.CC.m(-995671868, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ParcelableSnapshotMutableIntState(0);
                gapComposer.updateRememberedValue(objM2);
            }
            parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
            gapComposer.end(false);
            Boolean bool2 = (Boolean) mutableState.getValue();
            bool2.getClass();
            Integer numValueOf2 = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
            gapComposer.startReplaceGroup(-995669122);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(bool2, numValueOf2, (Function2) objRememberedValue2, gapComposer);
            Unit unit2 = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-995661558);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(13, mutableState, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit2, (Function1) objRememberedValue3, gapComposer);
            context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            gapComposer.startReplaceGroup(-995632175);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            mutableState3 = (MutableState) objRememberedValue5;
            objM3 = Density.CC.m(-995629851, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState6 = (MutableState) objM3;
            gapComposer.end(false);
            listBuilderCreateListBuilder = MatrixExt.createListBuilder();
            listBuilderCreateListBuilder.add(new SettingsEntry(HttpMethod.getSettings(), R.string.app, function0));
            imageVectorBuild = DnsKt._dns;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder8 = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i9 = VectorKt.$r8$clinit;
                SolidColor solidColor5 = new SolidColor(Color.Black);
                Headers.Builder builder9 = new Headers.Builder(2);
                builder9.moveTo(20.0f, 13.0f);
                builder9.horizontalLineTo(4.0f);
                builder9.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                builder9.verticalLineToRelative(6.0f);
                builder9.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                builder9.horizontalLineToRelative(16.0f);
                builder9.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                builder9.verticalLineToRelative(-6.0f);
                builder9.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                builder9.close();
                builder9.moveTo(7.0f, 19.0f);
                builder9.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                builder9.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                builder9.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                builder9.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                builder9.close();
                builder9.moveTo(20.0f, 3.0f);
                builder9.horizontalLineTo(4.0f);
                builder9.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                builder9.verticalLineToRelative(6.0f);
                builder9.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                builder9.horizontalLineToRelative(16.0f);
                builder9.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                builder9.verticalLineTo(4.0f);
                builder9.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                builder9.close();
                builder9.moveTo(7.0f, 9.0f);
                builder9.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                builder9.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                builder9.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                builder9.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                builder9.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder8, builder9.namesAndValues, solidColor5);
                imageVectorBuild = builder8.build();
                DnsKt._dns = imageVectorBuild;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                listBuilderCreateListBuilder.add(new SettingsEntry(Options$Companion.getSwapHoriz(), R.string.connections, function2));
            }
            imageVectorBuild2 = CharsKt._article;
            if (imageVectorBuild2 == null) {
                ImageVector.Builder builder10 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                int i10 = VectorKt.$r8$clinit;
                long j2 = Color.Black;
                SolidColor solidColor6 = new SolidColor(j2);
                Headers.Builder builder11 = new Headers.Builder(2);
                builder11.moveTo(19.0f, 5.0f);
                builder11.verticalLineToRelative(14.0f);
                builder11.horizontalLineTo(5.0f);
                builder11.verticalLineTo(5.0f);
                builder11.horizontalLineTo(19.0f);
                builder11.moveTo(19.0f, 3.0f);
                builder11.horizontalLineTo(5.0f);
                builder11.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                builder11.verticalLineToRelative(14.0f);
                builder11.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                builder11.horizontalLineToRelative(14.0f);
                builder11.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                builder11.verticalLineTo(5.0f);
                builder11.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                builder11.lineTo(19.0f, 3.0f);
                builder11.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder10, builder11.namesAndValues, solidColor6);
                SolidColor solidColor7 = new SolidColor(j2);
                Headers.Builder builder12 = new Headers.Builder(2);
                builder12.moveTo(14.0f, 17.0f);
                builder12.horizontalLineTo(7.0f);
                builder12.verticalLineToRelative(-2.0f);
                builder12.horizontalLineToRelative(7.0f);
                builder12.verticalLineTo(17.0f);
                builder12.close();
                builder12.moveTo(17.0f, 13.0f);
                builder12.horizontalLineTo(7.0f);
                builder12.verticalLineToRelative(-2.0f);
                builder12.horizontalLineToRelative(10.0f);
                builder12.verticalLineTo(13.0f);
                builder12.close();
                builder12.moveTo(17.0f, 9.0f);
                builder12.horizontalLineTo(7.0f);
                builder12.verticalLineTo(7.0f);
                builder12.horizontalLineToRelative(10.0f);
                builder12.verticalLineTo(9.0f);
                builder12.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder10, builder12.namesAndValues, solidColor7);
                imageVectorBuild2 = builder10.build();
                CharsKt._article = imageVectorBuild2;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild3 = zzpz._swapVerticalCircle;
                if (imageVectorBuild3 == null) {
                    ImageVector.Builder builder13 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i11 = VectorKt.$r8$clinit;
                    SolidColor solidColor8 = new SolidColor(Color.Black);
                    Headers.Builder builder14 = new Headers.Builder(2);
                    builder14.moveTo(12.0f, 2.0f);
                    builder14.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder14.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    builder14.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    builder14.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    builder14.close();
                    builder14.moveTo(6.5f, 9.0f);
                    builder14.lineTo(10.0f, 5.5f);
                    builder14.lineTo(13.5f, 9.0f);
                    builder14.lineTo(11.0f, 9.0f);
                    builder14.verticalLineToRelative(4.0f);
                    builder14.lineTo(9.0f, 13.0f);
                    builder14.lineTo(9.0f, 9.0f);
                    builder14.lineTo(6.5f, 9.0f);
                    builder14.close();
                    builder14.moveTo(17.5f, 15.0f);
                    builder14.lineTo(14.0f, 18.5f);
                    builder14.lineTo(10.5f, 15.0f);
                    builder14.lineTo(13.0f, 15.0f);
                    builder14.verticalLineToRelative(-4.0f);
                    builder14.horizontalLineToRelative(2.0f);
                    builder14.verticalLineToRelative(4.0f);
                    builder14.horizontalLineToRelative(2.5f);
                    builder14.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder13, builder14.namesAndValues, solidColor8);
                    imageVectorBuild3 = builder13.build();
                    zzpz._swapVerticalCircle = imageVectorBuild3;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
            }
            final ListBuilder listBuilderBuild2 = MatrixExt.build(listBuilderCreateListBuilder);
            boolean z5 = z2;
            ScaffoldKt.m260ScaffoldTvnljyQ(ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors2.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProxyScreenKt.AnonymousClass1(z2, appColors2, 3), gapComposer), null, null, null, 0, appColors2.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors2.appBackground, BrushKt.RectangleShape);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                        long j3 = gapComposer3.compositeKeyHashCode;
                        int i12 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM44backgroundbw27NRU);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m294setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m294setimpl(gapComposer3, Integer.valueOf(i12), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                        float f = 8;
                        float f2 = 16;
                        PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo117calculateTopPaddingD9Ej5fM() + f, f2, f);
                        Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(12);
                        gapComposer3.startReplaceGroup(-71810661);
                        List list = listBuilderBuild2;
                        boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                        Object objRememberedValue7 = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(11, list);
                            gapComposer3.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer3.end(false);
                        ProgressionUtilKt.LazyColumn(24576, 490, null, null, spacedAlignedM108spacedBy0680j_4, paddingValuesImpl2, null, gapComposer3, null, modifierFillMaxWidth, (Function1) objRememberedValue7, false, false);
                        MutableState mutableState7 = mutableState6;
                        boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
                        gapComposer3.startReplaceGroup(-71802873);
                        CoroutineScope coroutineScope2 = coroutineScope;
                        boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                        SnackbarHostState snackbarHostState2 = snackbarHostState;
                        boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                        Context context2 = context;
                        boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                            PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState7, snackbarHostState2, context2, mutableState3, 1);
                            gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                            objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                        }
                        gapComposer3.end(false);
                        zzjv.BuildInfoFooter(0, gapComposer3, OffsetKt.m129paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                        gapComposer3.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            gapComposer2 = gapComposer;
            if (((UpdateInfo) mutableState3.getValue()) != null) {
                UpdateInfo updateInfo2 = (UpdateInfo) mutableState3.getValue();
                gapComposer2.startReplaceGroup(-995499547);
                zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChangedInstance) {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda2 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda2);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda2;
                } else {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda3 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda3);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda3;
                }
                Function0 function6 = (Function0) objRememberedValue6;
                objM4 = Density.CC.m(-995475816, gapComposer2, false);
                if (objM4 == neverEqualPolicy) {
                    objM4 = new ProxyScreenKt$$ExternalSyntheticLambda18(mutableState4, 9);
                    gapComposer2.updateRememberedValue(objM4);
                }
                gapComposer2.end(false);
                UpdateDialogKt.UpdateDialog(updateInfo2, function6, (Function0) objM4, gapComposer2, 384);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z5;
        } else {
            if (i5 != 0) {
                z2 = false;
            }
            final AppColors appColors3 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            gapComposer.startReplaceGroup(-995676386);
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objM = Density.CC.m(-995673723, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            mutableState2 = (MutableState) objM;
            objM2 = Density.CC.m(-995671868, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ParcelableSnapshotMutableIntState(0);
                gapComposer.updateRememberedValue(objM2);
            }
            parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
            gapComposer.end(false);
            Boolean bool3 = (Boolean) mutableState.getValue();
            bool3.getClass();
            Integer numValueOf3 = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
            gapComposer.startReplaceGroup(-995669122);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(bool3, numValueOf3, (Function2) objRememberedValue2, gapComposer);
            Unit unit3 = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-995661558);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(13, mutableState, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit3, (Function1) objRememberedValue3, gapComposer);
            context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            gapComposer.startReplaceGroup(-995632175);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            mutableState3 = (MutableState) objRememberedValue5;
            objM3 = Density.CC.m(-995629851, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState7 = (MutableState) objM3;
            gapComposer.end(false);
            listBuilderCreateListBuilder = MatrixExt.createListBuilder();
            listBuilderCreateListBuilder.add(new SettingsEntry(HttpMethod.getSettings(), R.string.app, function0));
            imageVectorBuild = DnsKt._dns;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder15 = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i12 = VectorKt.$r8$clinit;
                SolidColor solidColor9 = new SolidColor(Color.Black);
                Headers.Builder builder16 = new Headers.Builder(2);
                builder16.moveTo(20.0f, 13.0f);
                builder16.horizontalLineTo(4.0f);
                builder16.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                builder16.verticalLineToRelative(6.0f);
                builder16.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                builder16.horizontalLineToRelative(16.0f);
                builder16.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                builder16.verticalLineToRelative(-6.0f);
                builder16.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                builder16.close();
                builder16.moveTo(7.0f, 19.0f);
                builder16.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                builder16.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                builder16.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                builder16.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                builder16.close();
                builder16.moveTo(20.0f, 3.0f);
                builder16.horizontalLineTo(4.0f);
                builder16.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                builder16.verticalLineToRelative(6.0f);
                builder16.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                builder16.horizontalLineToRelative(16.0f);
                builder16.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                builder16.verticalLineTo(4.0f);
                builder16.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                builder16.close();
                builder16.moveTo(7.0f, 9.0f);
                builder16.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                builder16.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                builder16.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                builder16.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                builder16.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder15, builder16.namesAndValues, solidColor9);
                imageVectorBuild = builder15.build();
                DnsKt._dns = imageVectorBuild;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                listBuilderCreateListBuilder.add(new SettingsEntry(Options$Companion.getSwapHoriz(), R.string.connections, function2));
            }
            imageVectorBuild2 = CharsKt._article;
            if (imageVectorBuild2 == null) {
                ImageVector.Builder builder17 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                int i13 = VectorKt.$r8$clinit;
                long j3 = Color.Black;
                SolidColor solidColor10 = new SolidColor(j3);
                Headers.Builder builder18 = new Headers.Builder(2);
                builder18.moveTo(19.0f, 5.0f);
                builder18.verticalLineToRelative(14.0f);
                builder18.horizontalLineTo(5.0f);
                builder18.verticalLineTo(5.0f);
                builder18.horizontalLineTo(19.0f);
                builder18.moveTo(19.0f, 3.0f);
                builder18.horizontalLineTo(5.0f);
                builder18.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                builder18.verticalLineToRelative(14.0f);
                builder18.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                builder18.horizontalLineToRelative(14.0f);
                builder18.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                builder18.verticalLineTo(5.0f);
                builder18.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                builder18.lineTo(19.0f, 3.0f);
                builder18.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder17, builder18.namesAndValues, solidColor10);
                SolidColor solidColor11 = new SolidColor(j3);
                Headers.Builder builder19 = new Headers.Builder(2);
                builder19.moveTo(14.0f, 17.0f);
                builder19.horizontalLineTo(7.0f);
                builder19.verticalLineToRelative(-2.0f);
                builder19.horizontalLineToRelative(7.0f);
                builder19.verticalLineTo(17.0f);
                builder19.close();
                builder19.moveTo(17.0f, 13.0f);
                builder19.horizontalLineTo(7.0f);
                builder19.verticalLineToRelative(-2.0f);
                builder19.horizontalLineToRelative(10.0f);
                builder19.verticalLineTo(13.0f);
                builder19.close();
                builder19.moveTo(17.0f, 9.0f);
                builder19.horizontalLineTo(7.0f);
                builder19.verticalLineTo(7.0f);
                builder19.horizontalLineToRelative(10.0f);
                builder19.verticalLineTo(9.0f);
                builder19.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder17, builder19.namesAndValues, solidColor11);
                imageVectorBuild2 = builder17.build();
                CharsKt._article = imageVectorBuild2;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild3 = zzpz._swapVerticalCircle;
                if (imageVectorBuild3 == null) {
                    ImageVector.Builder builder110 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i14 = VectorKt.$r8$clinit;
                    SolidColor solidColor12 = new SolidColor(Color.Black);
                    Headers.Builder builder111 = new Headers.Builder(2);
                    builder111.moveTo(12.0f, 2.0f);
                    builder111.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder111.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    builder111.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    builder111.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    builder111.close();
                    builder111.moveTo(6.5f, 9.0f);
                    builder111.lineTo(10.0f, 5.5f);
                    builder111.lineTo(13.5f, 9.0f);
                    builder111.lineTo(11.0f, 9.0f);
                    builder111.verticalLineToRelative(4.0f);
                    builder111.lineTo(9.0f, 13.0f);
                    builder111.lineTo(9.0f, 9.0f);
                    builder111.lineTo(6.5f, 9.0f);
                    builder111.close();
                    builder111.moveTo(17.5f, 15.0f);
                    builder111.lineTo(14.0f, 18.5f);
                    builder111.lineTo(10.5f, 15.0f);
                    builder111.lineTo(13.0f, 15.0f);
                    builder111.verticalLineToRelative(-4.0f);
                    builder111.horizontalLineToRelative(2.0f);
                    builder111.verticalLineToRelative(4.0f);
                    builder111.horizontalLineToRelative(2.5f);
                    builder111.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder110, builder111.namesAndValues, solidColor12);
                    imageVectorBuild3 = builder110.build();
                    zzpz._swapVerticalCircle = imageVectorBuild3;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
            }
            final ListBuilder listBuilderBuild3 = MatrixExt.build(listBuilderCreateListBuilder);
            boolean z6 = z2;
            ScaffoldKt.m260ScaffoldTvnljyQ(ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors3.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProxyScreenKt.AnonymousClass1(z2, appColors3, 3), gapComposer), null, null, null, 0, appColors3.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors3.appBackground, BrushKt.RectangleShape);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                        long j4 = gapComposer3.compositeKeyHashCode;
                        int i15 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM44backgroundbw27NRU);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m294setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m294setimpl(gapComposer3, Integer.valueOf(i15), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                        float f = 8;
                        float f2 = 16;
                        PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo117calculateTopPaddingD9Ej5fM() + f, f2, f);
                        Arrangement.SpacedAligned spacedAlignedM108spacedBy0680j_4 = Arrangement.m108spacedBy0680j_4(12);
                        gapComposer3.startReplaceGroup(-71810661);
                        List list = listBuilderBuild3;
                        boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                        Object objRememberedValue7 = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(11, list);
                            gapComposer3.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer3.end(false);
                        ProgressionUtilKt.LazyColumn(24576, 490, null, null, spacedAlignedM108spacedBy0680j_4, paddingValuesImpl2, null, gapComposer3, null, modifierFillMaxWidth, (Function1) objRememberedValue7, false, false);
                        MutableState mutableState8 = mutableState7;
                        boolean zBooleanValue = ((Boolean) mutableState8.getValue()).booleanValue();
                        gapComposer3.startReplaceGroup(-71802873);
                        CoroutineScope coroutineScope2 = coroutineScope;
                        boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                        SnackbarHostState snackbarHostState2 = snackbarHostState;
                        boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                        Context context2 = context;
                        boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                            PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState8, snackbarHostState2, context2, mutableState3, 1);
                            gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                            objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                        }
                        gapComposer3.end(false);
                        zzjv.BuildInfoFooter(0, gapComposer3, OffsetKt.m129paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                        gapComposer3.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            gapComposer2 = gapComposer;
            if (((UpdateInfo) mutableState3.getValue()) != null) {
                UpdateInfo updateInfo3 = (UpdateInfo) mutableState3.getValue();
                gapComposer2.startReplaceGroup(-995499547);
                zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChangedInstance) {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda4 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda4);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda4;
                } else {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda5 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda5);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda5;
                }
                Function0 function7 = (Function0) objRememberedValue6;
                objM4 = Density.CC.m(-995475816, gapComposer2, false);
                if (objM4 == neverEqualPolicy) {
                    objM4 = new ProxyScreenKt$$ExternalSyntheticLambda18(mutableState4, 9);
                    gapComposer2.updateRememberedValue(objM4);
                }
                gapComposer2.end(false);
                UpdateDialogKt.UpdateDialog(updateInfo3, function7, (Function0) objM4, gapComposer2, 384);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z6;
        }
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, function4, modifier2, paddingValuesImpl, z3, i, i2, 2);
        }
    }
}
