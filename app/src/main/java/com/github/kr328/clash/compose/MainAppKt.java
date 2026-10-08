package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitState;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.outlined.CheckBoxKt;
import androidx.compose.material.icons.outlined.SwapHorizKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.unit.Density;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$1;
import androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2;
import androidx.navigation.compose.NavHostKt;
import androidx.work.impl.WorkLauncherImpl;
import com.caverock.androidsvg.SVG;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import com.github.kr328.clash.compose.profiles.ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.components.LiquidGlassNavItem;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.design.model.LogFile;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqv;
import com.google.android.gms.internal.mlkit_vision_common.zzjm;
import com.google.android.gms.internal.mlkit_vision_common.zzjq;
import com.google.android.gms.internal.mlkit_vision_common.zzjs;
import com.google.android.gms.internal.mlkit_vision_common.zzkd;
import com.koala.clash.R;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import io.github.g00fy2.quickie.ScanQRCode;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MainAppKt {
    public static final void MainApp(int i, GapComposer gapComposer) {
        int i2;
        NavDestination navDestination;
        String str;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-909902631);
        if (i == 0 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            i2 = 1;
        } else {
            int i3 = 0;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
            Context context = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
            Object[] objArrCopyOf = Arrays.copyOf(new Navigator[0], 0);
            WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(10, NavHostControllerKt$NavControllerSaver$1.INSTANCE, new NavHostControllerKt$NavControllerSaver$2(context, i3));
            boolean zChangedInstance = gapComposer2.changedInstance(context);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new Handshake.AnonymousClass2(19, context);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            final NavHostController navHostController = (NavHostController) SaverKt.rememberSaveable(objArrCopyOf, workLauncherImpl, (Function0) objRememberedValue, gapComposer2, 0, 4);
            gapComposer2 = gapComposer;
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) Stack.collectAsState(navHostController.currentBackStackEntryFlow, null, null, gapComposer2, 48, 2).getValue();
            String str2 = (navBackStackEntry == null || (navDestination = navBackStackEntry.destination) == null || (str = navDestination.route) == null) ? "home" : str;
            final Context context2 = (Context) gapComposer2.consume(staticProvidableCompositionLocal);
            final AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(-1832748781);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            Object objM = Density.CC.m(-1832746669, gapComposer2, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objM);
            }
            final MutableState mutableState2 = (MutableState) objM;
            gapComposer2.end(false);
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer2);
            gapComposer2.startReplaceGroup(-1832743247);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SnackbarHostState();
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue3;
            gapComposer2.end(false);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            Unit unit = Unit.INSTANCE;
            gapComposer2.startReplaceGroup(-1832738620);
            boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(context2);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new MainAppKt$$ExternalSyntheticLambda0(coroutineScope, snackbarHostState, context2, i3);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            gapComposer2.end(false);
            Stack.DisposableEffect(unit, (Function1) objRememberedValue5, gapComposer2);
            ScanQRCode scanQRCode = new ScanQRCode(5);
            gapComposer2.startReplaceGroup(-1832690633);
            boolean zChangedInstance3 = gapComposer2.changedInstance(context2);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new MainAppKt$$ExternalSyntheticLambda1(context2, i3);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            gapComposer2.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = AspectRatio.rememberLauncherForActivityResult(scanQRCode, (Function1) objRememberedValue6, gapComposer2, 0);
            ImageVector imageVectorBuild = HomeKt._home;
            if (imageVectorBuild != null) {
                i2 = 1;
            } else {
                ImageVector.Builder builder = new ImageVector.Builder("Filled.Home", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i4 = VectorKt.$r8$clinit;
                SolidColor solidColor = new SolidColor(Color.Black);
                Headers.Builder builder2 = new Headers.Builder(2);
                i2 = 1;
                builder2.moveTo(10.0f, 20.0f);
                builder2.verticalLineToRelative(-6.0f);
                builder2.horizontalLineToRelative(4.0f);
                builder2.verticalLineToRelative(6.0f);
                builder2.horizontalLineToRelative(5.0f);
                builder2.verticalLineToRelative(-8.0f);
                builder2.horizontalLineToRelative(3.0f);
                builder2.lineTo(12.0f, 3.0f);
                builder2.lineTo(2.0f, 12.0f);
                builder2.horizontalLineToRelative(3.0f);
                builder2.verticalLineToRelative(8.0f);
                builder2.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                imageVectorBuild = builder.build();
                HomeKt._home = imageVectorBuild;
            }
            LiquidGlassNavItem liquidGlassNavItem = new LiquidGlassNavItem(imageVectorBuild, "home", StringResources_androidKt.stringResource(R.string.tab_home, gapComposer2));
            ImageVector imageVectorBuild2 = MediaType.Companion._person;
            if (imageVectorBuild2 == null) {
                ImageVector.Builder builder3 = new ImageVector.Builder("Filled.Person", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i5 = VectorKt.$r8$clinit;
                SolidColor solidColor2 = new SolidColor(Color.Black);
                Headers.Builder builder4 = new Headers.Builder(2);
                builder4.moveTo(12.0f, 12.0f);
                builder4.curveToRelative(2.21f, 0.0f, 4.0f, -1.79f, 4.0f, -4.0f);
                builder4.reflectiveCurveToRelative(-1.79f, -4.0f, -4.0f, -4.0f);
                builder4.reflectiveCurveToRelative(-4.0f, 1.79f, -4.0f, 4.0f);
                builder4.reflectiveCurveToRelative(1.79f, 4.0f, 4.0f, 4.0f);
                builder4.close();
                builder4.moveTo(12.0f, 14.0f);
                builder4.curveToRelative(-2.67f, 0.0f, -8.0f, 1.34f, -8.0f, 4.0f);
                builder4.verticalLineToRelative(2.0f);
                builder4.horizontalLineToRelative(16.0f);
                builder4.verticalLineToRelative(-2.0f);
                builder4.curveToRelative(0.0f, -2.66f, -5.33f, -4.0f, -8.0f, -4.0f);
                builder4.close();
                ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                imageVectorBuild2 = builder3.build();
                MediaType.Companion._person = imageVectorBuild2;
            }
            LiquidGlassNavItem liquidGlassNavItem2 = new LiquidGlassNavItem(imageVectorBuild2, "profiles", StringResources_androidKt.stringResource(R.string.tab_profiles, gapComposer2));
            LiquidGlassNavItem liquidGlassNavItem3 = new LiquidGlassNavItem(HttpMethod.getSettings(), "settings", StringResources_androidKt.stringResource(R.string.tab_settings, gapComposer2));
            LiquidGlassNavItem[] liquidGlassNavItemArr = new LiquidGlassNavItem[3];
            liquidGlassNavItemArr[0] = liquidGlassNavItem;
            liquidGlassNavItemArr[i2] = liquidGlassNavItem2;
            liquidGlassNavItemArr[2] = liquidGlassNavItem3;
            final List listListOf = MatrixExt.listOf(liquidGlassNavItemArr);
            final String str3 = str2;
            Stack.CompositionLocalProvider(GlassSnackbarKt.LocalGlassSnackbarHost.defaultProvidedValue$runtime(snackbarHostState), Thread_jvmKt.rememberComposableLambda(1671991321, new Function2() { // from class: com.github.kr328.clash.compose.MainAppKt.MainApp.2

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.MainAppKt$MainApp$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
                public final class AnonymousClass1 implements Function2 {
                    public final /* synthetic */ Object $currentRoute;
                    public final /* synthetic */ Object $navController;
                    public final /* synthetic */ Object $navHazeState;
                    public final /* synthetic */ Object $navItems;
                    public final /* synthetic */ int $r8$classId;

                    public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
                        this.$r8$classId = i;
                        this.$navItems = obj;
                        this.$currentRoute = obj2;
                        this.$navController = obj3;
                        this.$navHazeState = obj4;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        int i = this.$r8$classId;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        Object obj3 = this.$navHazeState;
                        Object obj4 = this.$navController;
                        Object obj5 = this.$currentRoute;
                        Object obj6 = this.$navItems;
                        switch (i) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj;
                                NavHostController navHostController = (NavHostController) obj4;
                                String str = (String) obj5;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    List list = (List) obj6;
                                    gapComposer.startReplaceGroup(712925675);
                                    boolean zChanged = gapComposer.changed(str) | gapComposer.changedInstance(navHostController);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new BlurEffectKt$$ExternalSyntheticLambda1(11, str, navHostController);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    gapComposer.end(false);
                                    zzkd.LiquidGlassNavBar(list, str, (Function1) objRememberedValue, null, (HazeState) obj3, gapComposer, 0);
                                }
                                break;
                            case 1:
                                GapComposer gapComposer2 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    Modifier modifierM48clickableoSLSa3U$default = ImageKt.m48clickableoSLSa3U$default(15, SizeKt.FillWholeMaxSize, null, (Function0) obj6, false);
                                    DateFormat dateFormat = (DateFormat) obj5;
                                    LogFile logFile = (LogFile) obj4;
                                    AppColors appColors = (AppColors) obj3;
                                    BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                    SVG svg = gapComposer2.applier;
                                    long j = gapComposer2.compositeKeyHashCode;
                                    int i2 = (int) (j ^ (j >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM48clickableoSLSa3U$default);
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
                                    Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16, 12);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                    long j2 = gapComposer2.compositeKeyHashCode;
                                    int i3 = (int) (j2 ^ (j2 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM126paddingVpY3zN4);
                                    gapComposer2.startReusableNode();
                                    if (gapComposer2.inserting) {
                                        gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        gapComposer2.useNode();
                                    }
                                    Stack.m294setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                                    Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                                    Modifier.CC.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                    Stack.m294setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                                    long j3 = gapComposer2.compositeKeyHashCode;
                                    int i4 = (int) (j3 ^ (j3 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
                                    gapComposer2.startReusableNode();
                                    if (gapComposer2.inserting) {
                                        gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        gapComposer2.useNode();
                                    }
                                    Stack.m294setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                                    Stack.m294setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                                    Modifier.CC.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                    Stack.m294setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                                    String str2 = dateFormat.format(logFile.date);
                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                    TextKt.m274TextNvy7gAk(str2, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer2, 0, 0, 131066);
                                    TextKt.m274TextNvy7gAk(logFile.fileName, null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, TextStyle.m645copyp1EtxEg$default(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, 0L, 0L, null, SystemFontFamily.Monospace, 0L, 0L, null, 16777183), gapComposer2, 0, 0, 131066);
                                    gapComposer2.end(true);
                                    gapComposer2.end(true);
                                    gapComposer2.end(true);
                                }
                                break;
                            default:
                                GapComposer gapComposer3 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    Function0 function0 = (Function0) obj6;
                                    Function0 function1 = (Function0) obj5;
                                    Function0 function2 = (Function0) obj4;
                                    Function0 function3 = (Function0) obj3;
                                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.m108spacedBy0680j_4(2), Alignment.Companion.Start, gapComposer3, 6);
                                    long j4 = gapComposer3.compositeKeyHashCode;
                                    int i5 = (int) (j4 ^ (j4 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
                                    ComposeUiNode.Companion.getClass();
                                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                                    gapComposer3.startReusableNode();
                                    if (gapComposer3.inserting) {
                                        gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                                    } else {
                                        gapComposer3.useNode();
                                    }
                                    Stack.m294setimpl(gapComposer3, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m294setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m294setimpl(gapComposer3, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m293reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                    Stack.m294setimpl(gapComposer3, modifierMaterializeModifier4, ComposeUiNode.Companion.SetModifier);
                                    ImageVector imageVectorBuild = CheckBoxKt._checkBox;
                                    if (imageVectorBuild == null) {
                                        ImageVector.Builder builder = new ImageVector.Builder("Outlined.CheckBox", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                        int i6 = VectorKt.$r8$clinit;
                                        SolidColor solidColor = new SolidColor(Color.Black);
                                        Headers.Builder builder2 = new Headers.Builder(2);
                                        builder2.moveTo(19.0f, 3.0f);
                                        builder2.lineTo(5.0f, 3.0f);
                                        builder2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                                        builder2.verticalLineToRelative(14.0f);
                                        builder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                                        builder2.horizontalLineToRelative(14.0f);
                                        builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                                        builder2.lineTo(21.0f, 5.0f);
                                        builder2.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
                                        builder2.close();
                                        builder2.moveTo(19.0f, 19.0f);
                                        builder2.lineTo(5.0f, 19.0f);
                                        builder2.lineTo(5.0f, 5.0f);
                                        builder2.horizontalLineToRelative(14.0f);
                                        builder2.verticalLineToRelative(14.0f);
                                        builder2.close();
                                        builder2.moveTo(17.99f, 9.0f);
                                        builder2.lineToRelative(-1.41f, -1.42f);
                                        builder2.lineToRelative(-6.59f, 6.59f);
                                        builder2.lineToRelative(-2.58f, -2.57f);
                                        builder2.lineToRelative(-1.42f, 1.41f);
                                        builder2.lineToRelative(4.0f, 3.99f);
                                        builder2.close();
                                        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                                        imageVectorBuild = builder.build();
                                        CheckBoxKt._checkBox = imageVectorBuild;
                                    }
                                    String strStringResource = StringResources_androidKt.stringResource(R.string.select_all, gapComposer3);
                                    gapComposer3.startReplaceGroup(797878125);
                                    boolean zChanged2 = gapComposer3.changed(function0) | gapComposer3.changed(function1);
                                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                        objRememberedValue2 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function0, function1, 3);
                                        gapComposer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    gapComposer3.end(false);
                                    zzjs.ActionRow(imageVectorBuild, strStringResource, (Function0) objRememberedValue2, gapComposer3, 0);
                                    ImageVector imageVectorBuild2 = zzqv._checkBoxOutlineBlank;
                                    if (imageVectorBuild2 == null) {
                                        ImageVector.Builder builder3 = new ImageVector.Builder("Outlined.CheckBoxOutlineBlank", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                        int i7 = VectorKt.$r8$clinit;
                                        SolidColor solidColor2 = new SolidColor(Color.Black);
                                        Headers.Builder builder4 = new Headers.Builder(2);
                                        builder4.moveTo(19.0f, 5.0f);
                                        builder4.verticalLineToRelative(14.0f);
                                        builder4.horizontalLineTo(5.0f);
                                        builder4.verticalLineTo(5.0f);
                                        builder4.horizontalLineToRelative(14.0f);
                                        PathNode.RelativeMoveTo relativeMoveTo = new PathNode.RelativeMoveTo(0.0f, -2.0f);
                                        ArrayList arrayList = builder4.namesAndValues;
                                        arrayList.add(relativeMoveTo);
                                        builder4.horizontalLineTo(5.0f);
                                        builder4.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                                        builder4.verticalLineToRelative(14.0f);
                                        builder4.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                                        builder4.horizontalLineToRelative(14.0f);
                                        builder4.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                                        builder4.verticalLineTo(5.0f);
                                        builder4.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
                                        builder4.close();
                                        ImageVector.Builder.m500addPathoIyEayM$default(builder3, arrayList, solidColor2);
                                        imageVectorBuild2 = builder3.build();
                                        zzqv._checkBoxOutlineBlank = imageVectorBuild2;
                                    }
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.select_none, gapComposer3);
                                    gapComposer3.startReplaceGroup(797888878);
                                    boolean zChanged3 = gapComposer3.changed(function0) | gapComposer3.changed(function2);
                                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                        objRememberedValue3 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function0, function2, 4);
                                        gapComposer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    gapComposer3.end(false);
                                    zzjs.ActionRow(imageVectorBuild2, strStringResource2, (Function0) objRememberedValue3, gapComposer3, 0);
                                    ImageVector imageVectorBuild3 = SwapHorizKt._swapHoriz;
                                    if (imageVectorBuild3 == null) {
                                        ImageVector.Builder builder5 = new ImageVector.Builder("Outlined.SwapHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                        int i8 = VectorKt.$r8$clinit;
                                        SolidColor solidColor3 = new SolidColor(Color.Black);
                                        Headers.Builder builder6 = new Headers.Builder(2);
                                        builder6.moveTo(6.99f, 11.0f);
                                        builder6.lineTo(3.0f, 15.0f);
                                        builder6.lineToRelative(3.99f, 4.0f);
                                        builder6.verticalLineToRelative(-3.0f);
                                        builder6.horizontalLineTo(14.0f);
                                        builder6.verticalLineToRelative(-2.0f);
                                        builder6.horizontalLineTo(6.99f);
                                        builder6.verticalLineToRelative(-3.0f);
                                        builder6.close();
                                        builder6.moveTo(21.0f, 9.0f);
                                        builder6.lineToRelative(-3.99f, -4.0f);
                                        builder6.verticalLineToRelative(3.0f);
                                        builder6.horizontalLineTo(10.0f);
                                        builder6.verticalLineToRelative(2.0f);
                                        builder6.horizontalLineToRelative(7.01f);
                                        builder6.verticalLineToRelative(3.0f);
                                        builder6.lineTo(21.0f, 9.0f);
                                        builder6.close();
                                        ImageVector.Builder.m500addPathoIyEayM$default(builder5, builder6.namesAndValues, solidColor3);
                                        imageVectorBuild3 = builder5.build();
                                        SwapHorizKt._swapHoriz = imageVectorBuild3;
                                    }
                                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.select_invert, gapComposer3);
                                    gapComposer3.startReplaceGroup(797899376);
                                    boolean zChanged4 = gapComposer3.changed(function0) | gapComposer3.changed(function3);
                                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                        objRememberedValue4 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function0, function3, 5);
                                        gapComposer3.updateRememberedValue(objRememberedValue4);
                                    }
                                    gapComposer3.end(false);
                                    zzjs.ActionRow(imageVectorBuild3, strStringResource3, (Function0) objRememberedValue4, gapComposer3, 0);
                                    gapComposer3.end(true);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.MainAppKt$MainApp$2$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
                public final class C00042 implements Function2 {
                    public final /* synthetic */ int $r8$classId;
                    public final /* synthetic */ SnackbarHostState $snackbarHostState;

                    public /* synthetic */ C00042(SnackbarHostState snackbarHostState, int i) {
                        this.$r8$classId = i;
                        this.$snackbarHostState = snackbarHostState;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        switch (this.$r8$classId) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    GlassSnackbarKt.GlassSnackbarHost(this.$snackbarHostState, null, gapComposer, 6, 2);
                                }
                                break;
                            default:
                                GapComposer gapComposer2 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    GlassSnackbarKt.GlassSnackbarHost(this.$snackbarHostState, null, gapComposer2, 0, 2);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        long j = appColors.appBackground;
                        List list = listListOf;
                        String str4 = str3;
                        final HazeState hazeState = hazeStateRememberHazeState;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-453186700, new AnonymousClass1(list, str4, navHostController, hazeState, 0), gapComposer3);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(1424082195, new C00042(snackbarHostState, 0), gapComposer3);
                        final MutableState mutableState3 = mutableState2;
                        final MutableState mutableState4 = mutableState;
                        final NavHostController navHostController2 = navHostController;
                        final Context context3 = context2;
                        final ManagedActivityResultLauncher managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult;
                        ScaffoldKt.m260ScaffoldTvnljyQ(null, null, composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, 0, j, 0L, null, Thread_jvmKt.rememberComposableLambda(827301610, new Function3() { // from class: com.github.kr328.clash.compose.MainAppKt.MainApp.2.3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                PaddingValues paddingValues = (PaddingValues) obj3;
                                GapComposer gapComposer4 = (GapComposer) obj4;
                                int iIntValue = ((Number) obj5).intValue();
                                if ((iIntValue & 6) == 0) {
                                    iIntValue |= gapComposer4.changed(paddingValues) ? 4 : 2;
                                }
                                if ((iIntValue & 19) == 18 && gapComposer4.getSkipping()) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                                    Modifier modifierThen = fillElement.then(new HazeSourceElement(hazeState));
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                    long j2 = gapComposer4.compositeKeyHashCode;
                                    int i6 = (int) (j2 ^ (j2 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierThen);
                                    ComposeUiNode.Companion.getClass();
                                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                    gapComposer4.startReusableNode();
                                    if (gapComposer4.inserting) {
                                        gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        gapComposer4.useNode();
                                    }
                                    Stack.m294setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m294setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m294setimpl(gapComposer4, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m293reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                    Stack.m294setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                    gapComposer4.startReplaceGroup(-1630919266);
                                    Context context4 = context3;
                                    boolean zChangedInstance4 = gapComposer4.changedInstance(context4);
                                    ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    boolean zChangedInstance5 = ((iIntValue & 14) == 4) | zChangedInstance4 | gapComposer4.changedInstance(managedActivityResultLauncher2);
                                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                                    if (zChangedInstance5 || objRememberedValue7 == Composer$Companion.Empty) {
                                        ActivityResultRegistryKt$$ExternalSyntheticLambda1 activityResultRegistryKt$$ExternalSyntheticLambda1 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(context4, managedActivityResultLauncher2, paddingValues, mutableState3, mutableState4);
                                        gapComposer4.updateRememberedValue(activityResultRegistryKt$$ExternalSyntheticLambda1);
                                        objRememberedValue7 = activityResultRegistryKt$$ExternalSyntheticLambda1;
                                    }
                                    gapComposer4.end(false);
                                    NavHostKt.NavHost(navHostController2, fillElement, (Alignment) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) objRememberedValue7, gapComposer4, 432);
                                    gapComposer4.end(true);
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer3), gapComposer3, 805309824, 435);
                        gapComposer3.startReplaceGroup(-126155634);
                        MutableState mutableState5 = mutableState;
                        boolean zBooleanValue = ((Boolean) mutableState5.getValue()).booleanValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zBooleanValue) {
                            gapComposer3.startReplaceGroup(-126153750);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            if (objRememberedValue7 == neverEqualPolicy2) {
                                objRememberedValue7 = new TooltipKt$$ExternalSyntheticLambda0(mutableState5, 13);
                                gapComposer3.updateRememberedValue(objRememberedValue7);
                            }
                            gapComposer3.end(false);
                            zzjq.ProxySelectorSheet((Function0) objRememberedValue7, false, gapComposer3, 6, 2);
                        }
                        gapComposer3.end(false);
                        MutableState mutableState6 = mutableState2;
                        if (((Boolean) mutableState6.getValue()).booleanValue()) {
                            gapComposer3.startReplaceGroup(-126150481);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (objRememberedValue8 == neverEqualPolicy2) {
                                objRememberedValue8 = new TooltipKt$$ExternalSyntheticLambda0(mutableState6, 14);
                                gapComposer3.updateRememberedValue(objRememberedValue8);
                            }
                            gapComposer3.end(false);
                            zzjm.NewProfileSheet((Function0) objRememberedValue8, gapComposer3, 6);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer2, 56);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesKt__UtilsKt$$ExternalSyntheticLambda0(i, i2);
        }
    }

    public static final void ScreenWrapper(AnimatedVisibilityScope animatedVisibilityScope, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(2010810680);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(animatedVisibilityScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            boolean z = animatedVisibilityScope.getTransition().targetState$delegate.getValue() == EnterExitState.PostExit;
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            gapComposer.startReplaceGroup(-996130838);
            Modifier modifierPointerInput = Modifier.Companion.$$INSTANCE;
            if (z) {
                Unit unit = Unit.INSTANCE;
                gapComposer.startReplaceGroup(-996129519);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = MainAppKt$ScreenWrapper$1$1.INSTANCE;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                gapComposer.end(false);
                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierPointerInput, unit, (PointerInputEventHandler) objRememberedValue);
            }
            gapComposer.end(false);
            Modifier modifierThen = fillElement.then(modifierPointerInput);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
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
            Stack.m294setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i2 >> 3) & 14));
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(animatedVisibilityScope, composableLambdaImpl, i, 5);
        }
    }
}
