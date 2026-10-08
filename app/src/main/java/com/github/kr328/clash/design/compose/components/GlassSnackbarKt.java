package com.github.kr328.clash.design.compose.components;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.material.icons.rounded.CheckCircleKt;
import androidx.compose.material.icons.rounded.ErrorOutlineKt;
import androidx.compose.material.icons.rounded.InfoKt;
import androidx.compose.material.icons.rounded.WarningAmberKt;
import androidx.compose.material3.BottomSheetKt$BottomSheet$settleToDismiss$1$1$2;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlassSnackbarKt {
    public static final DynamicProvidableCompositionLocal LocalGlassSnackbarHost = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(27));

    public static final void GlassSnackbar(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Modifier modifier, GapComposer gapComposer, int i) {
        int i2;
        int i3;
        long jColor;
        long jColor2;
        ImageVector imageVectorBuild;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl2;
        Modifier modifier2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1071188863);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changed(snackbarDataImpl) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i4 = i2 | 48;
        if ((i4 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            modifier2 = modifier;
            snackbarDataImpl2 = snackbarDataImpl;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            GlassSnackbarVisuals glassSnackbarVisuals = snackbarDataImpl.visuals;
            GlassSnackbarVisuals glassSnackbarVisuals2 = glassSnackbarVisuals instanceof GlassSnackbarVisuals ? glassSnackbarVisuals : null;
            if (glassSnackbarVisuals2 == null || (i3 = glassSnackbarVisuals2.type) == 0) {
                i3 = 4;
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i3);
            if (iOrdinal == 0) {
                jColor = appColors.accentBorder;
                jColor2 = appColors.buttonActiveEnd;
                ImageVector imageVector = CheckCircleKt._checkCircle;
                if (imageVector != null) {
                    imageVectorBuild = imageVector;
                } else {
                    ImageVector.Builder builder = new ImageVector.Builder("Rounded.CheckCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i5 = VectorKt.$r8$clinit;
                    SolidColor solidColor = new SolidColor(Color.Black);
                    Headers.Builder builder2 = new Headers.Builder(2);
                    builder2.moveTo(12.0f, 2.0f);
                    builder2.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder2.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    builder2.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    builder2.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    builder2.close();
                    builder2.moveTo(9.29f, 16.29f);
                    builder2.lineTo(5.7f, 12.7f);
                    builder2.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0.0f, -1.41f);
                    builder2.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
                    builder2.lineTo(10.0f, 14.17f);
                    builder2.lineToRelative(6.88f, -6.88f);
                    builder2.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
                    builder2.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0.0f, 1.41f);
                    builder2.lineToRelative(-7.59f, 7.59f);
                    builder2.curveToRelative(-0.38f, 0.39f, -1.02f, 0.39f, -1.41f, 0.0f);
                    builder2.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                    ImageVector imageVectorBuild2 = builder.build();
                    CheckCircleKt._checkCircle = imageVectorBuild2;
                    imageVectorBuild = imageVectorBuild2;
                }
                Unit unit = Unit.INSTANCE;
            } else if (iOrdinal == 1) {
                long jColor3 = BrushKt.Color(4293874512L);
                jColor = BrushKt.Color(Color.m438getRedimpl(jColor3), Color.m437getGreenimpl(jColor3), Color.m435getBlueimpl(jColor3), 0.5f, Color.m436getColorSpaceimpl(jColor3));
                jColor2 = BrushKt.Color(4293874512L);
                ImageVector imageVector2 = ErrorOutlineKt._errorOutline;
                if (imageVector2 != null) {
                    imageVectorBuild = imageVector2;
                } else {
                    ImageVector.Builder builder3 = new ImageVector.Builder("Rounded.ErrorOutline", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i6 = VectorKt.$r8$clinit;
                    SolidColor solidColor2 = new SolidColor(Color.Black);
                    Headers.Builder builder4 = new Headers.Builder(2);
                    builder4.moveTo(12.0f, 7.0f);
                    builder4.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
                    builder4.verticalLineToRelative(4.0f);
                    builder4.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
                    builder4.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
                    builder4.lineTo(11.0f, 8.0f);
                    builder4.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
                    builder4.close();
                    builder4.moveTo(11.99f, 2.0f);
                    builder4.curveTo(6.47f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder4.reflectiveCurveToRelative(4.47f, 10.0f, 9.99f, 10.0f);
                    builder4.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
                    builder4.reflectiveCurveTo(17.52f, 2.0f, 11.99f, 2.0f);
                    builder4.close();
                    builder4.moveTo(12.0f, 20.0f);
                    builder4.curveToRelative(-4.42f, 0.0f, -8.0f, -3.58f, -8.0f, -8.0f);
                    builder4.reflectiveCurveToRelative(3.58f, -8.0f, 8.0f, -8.0f);
                    builder4.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
                    builder4.reflectiveCurveToRelative(-3.58f, 8.0f, -8.0f, 8.0f);
                    builder4.close();
                    builder4.moveTo(13.0f, 17.0f);
                    builder4.horizontalLineToRelative(-2.0f);
                    builder4.verticalLineToRelative(-2.0f);
                    builder4.horizontalLineToRelative(2.0f);
                    builder4.verticalLineToRelative(2.0f);
                    builder4.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder3, builder4.namesAndValues, solidColor2);
                    ImageVector imageVectorBuild3 = builder3.build();
                    ErrorOutlineKt._errorOutline = imageVectorBuild3;
                    imageVectorBuild = imageVectorBuild3;
                }
                Unit unit2 = Unit.INSTANCE;
            } else if (iOrdinal == 2) {
                long jColor4 = BrushKt.Color(4294945600L);
                jColor = BrushKt.Color(Color.m438getRedimpl(jColor4), Color.m437getGreenimpl(jColor4), Color.m435getBlueimpl(jColor4), 0.5f, Color.m436getColorSpaceimpl(jColor4));
                jColor2 = BrushKt.Color(4294945600L);
                ImageVector imageVectorBuild4 = WarningAmberKt._warningAmber;
                if (imageVectorBuild4 == null) {
                    ImageVector.Builder builder5 = new ImageVector.Builder("Rounded.WarningAmber", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i7 = VectorKt.$r8$clinit;
                    SolidColor solidColor3 = new SolidColor(Color.Black);
                    Headers.Builder builder6 = new Headers.Builder(2);
                    builder6.moveTo(12.0f, 5.99f);
                    builder6.lineTo(19.53f, 19.0f);
                    builder6.lineTo(4.47f, 19.0f);
                    builder6.lineTo(12.0f, 5.99f);
                    builder6.moveTo(2.74f, 18.0f);
                    builder6.curveToRelative(-0.77f, 1.33f, 0.19f, 3.0f, 1.73f, 3.0f);
                    builder6.horizontalLineToRelative(15.06f);
                    builder6.curveToRelative(1.54f, 0.0f, 2.5f, -1.67f, 1.73f, -3.0f);
                    builder6.lineTo(13.73f, 4.99f);
                    builder6.curveToRelative(-0.77f, -1.33f, -2.69f, -1.33f, -3.46f, 0.0f);
                    builder6.lineTo(2.74f, 18.0f);
                    builder6.close();
                    builder6.moveTo(11.0f, 11.0f);
                    builder6.verticalLineToRelative(2.0f);
                    builder6.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                    builder6.reflectiveCurveToRelative(1.0f, -0.45f, 1.0f, -1.0f);
                    builder6.verticalLineToRelative(-2.0f);
                    builder6.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    builder6.reflectiveCurveToRelative(-1.0f, 0.45f, -1.0f, 1.0f);
                    builder6.close();
                    builder6.moveTo(11.0f, 16.0f);
                    builder6.horizontalLineToRelative(2.0f);
                    builder6.verticalLineToRelative(2.0f);
                    builder6.horizontalLineToRelative(-2.0f);
                    builder6.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder5, builder6.namesAndValues, solidColor3);
                    imageVectorBuild4 = builder5.build();
                    WarningAmberKt._warningAmber = imageVectorBuild4;
                }
                imageVectorBuild = imageVectorBuild4;
                Unit unit3 = Unit.INSTANCE;
            } else {
                if (iOrdinal != 3) {
                    throw new HttpException();
                }
                jColor = appColors.cardBorder;
                jColor2 = appColors.textSecondary;
                imageVectorBuild = InfoKt._info;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder7 = new ImageVector.Builder("Rounded.Info", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i8 = VectorKt.$r8$clinit;
                    SolidColor solidColor4 = new SolidColor(Color.Black);
                    Headers.Builder builder8 = new Headers.Builder(2);
                    builder8.moveTo(12.0f, 2.0f);
                    builder8.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder8.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    builder8.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    builder8.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    builder8.close();
                    builder8.moveTo(12.0f, 17.0f);
                    builder8.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
                    builder8.verticalLineToRelative(-4.0f);
                    builder8.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
                    builder8.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
                    builder8.verticalLineToRelative(4.0f);
                    builder8.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
                    builder8.close();
                    builder8.moveTo(13.0f, 9.0f);
                    builder8.horizontalLineToRelative(-2.0f);
                    builder8.lineTo(11.0f, 7.0f);
                    builder8.horizontalLineToRelative(2.0f);
                    builder8.verticalLineToRelative(2.0f);
                    builder8.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder7, builder8.namesAndValues, solidColor4);
                    imageVectorBuild = builder7.build();
                    InfoKt._info = imageVectorBuild;
                }
                Unit unit4 = Unit.INSTANCE;
            }
            long j = jColor2;
            ImageVector imageVector3 = imageVectorBuild;
            float f = 14;
            RoundedCornerShape roundedCornerShapeM156RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m156RoundedCornerShape0680j_4(f);
            long j2 = appColors.cardBackground;
            long jM412compositeOverOWjLjI = BrushKt.m412compositeOverOWjLjI(BrushKt.Color(Color.m438getRedimpl(j2), Color.m437getGreenimpl(j2), Color.m435getBlueimpl(j2), 0.92f, Color.m436getColorSpaceimpl(j2)), appColors.appBackground);
            gapComposer.startReplaceGroup(461536216);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = ArcSplineKt.Animatable$default(0.85f);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Animatable animatable = (Animatable) objRememberedValue;
            Object objM = Density.CC.m(461537717, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = ArcSplineKt.Animatable$default(0.0f);
                gapComposer.updateRememberedValue(objM);
            }
            Animatable animatable2 = (Animatable) objM;
            gapComposer.end(false);
            Unit unit5 = Unit.INSTANCE;
            gapComposer.startReplaceGroup(461539510);
            boolean zChangedInstance = gapComposer.changedInstance(animatable);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable, null, 1);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit5, (Function2) objRememberedValue2);
            gapComposer.startReplaceGroup(461544233);
            boolean zChangedInstance2 = gapComposer.changedInstance(animatable2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable2, null, 2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit5, (Function2) objRememberedValue3);
            float f2 = 16;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(OffsetKt.m126paddingVpY3zN4(companion, f2, 8), 1.0f);
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            if (fFloatValue != 1.0f || fFloatValue != 1.0f) {
                modifierFillMaxWidth = BrushKt.m415graphicsLayer_6ThJ44$default(modifierFillMaxWidth, fFloatValue, fFloatValue, 0.0f, 0.0f, 0.0f, null, false, 524284);
            }
            Modifier modifierM126paddingVpY3zN4 = OffsetKt.m126paddingVpY3zN4(ImageKt.m45borderxT4_qwU(1, jColor, ImageKt.m44backgroundbw27NRU(ClipKt.clip(ClipKt.alpha(modifierFillMaxWidth, ((Number) animatable2.getValue()).floatValue()), roundedCornerShapeM156RoundedCornerShape0680j_4), jM412compositeOverOWjLjI, BrushKt.RectangleShape), roundedCornerShapeM156RoundedCornerShape0680j_4), f2, f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i9 = (int) (j3 ^ (j3 >>> 32));
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
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i9);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m294setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m293reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m108spacedBy0680j_4(12), Alignment.Companion.CenterVertically, gapComposer, 54);
            long j4 = gapComposer.compositeKeyHashCode;
            int i10 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i10, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            IconKt.m248Iconww6aTOc(imageVector3, null, SizeKt.m137size3ABfNKs(companion, 22), j, gapComposer, 432, 0);
            String str = glassSnackbarVisuals.message;
            long j5 = appColors.textPrimary;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            TextKt.m274TextNvy7gAk(str, new LayoutWeightElement(1.0f, false), j5, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131064);
            gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(-1074558372);
            if (glassSnackbarVisuals.withDismissAction) {
                gapComposer2.startReplaceGroup(-1074556022);
                boolean z = (i4 & 14) == 4;
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (z || objRememberedValue4 == neverEqualPolicy) {
                    snackbarDataImpl2 = snackbarDataImpl;
                    objRememberedValue4 = new SnackbarHostKt$$ExternalSyntheticLambda6(snackbarDataImpl2, 1);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                } else {
                    snackbarDataImpl2 = snackbarDataImpl;
                }
                Function0 function0 = (Function0) objRememberedValue4;
                gapComposer2.end(false);
                modifier2 = companion;
                Modifier modifierM137size3ABfNKs = SizeKt.m137size3ABfNKs(modifier2, 24);
                int i11 = IconButtonDefaults.$r8$clinit;
                long j6 = appColors.textSecondary;
                long j7 = Color.Unspecified;
                ScrimKt.IconButton(function0, modifierM137size3ABfNKs, false, IconButtonDefaults.m246defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme, ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value).m245copyjRlVdoo(j7, j6, j7, BrushKt.Color(Color.m438getRedimpl(j6), Color.m437getGreenimpl(j6), Color.m435getBlueimpl(j6), 0.38f, Color.m436getColorSpaceimpl(j6))), null, ComposableSingletons$GlassSnackbarKt.f29lambda1, gapComposer, 1572912, 52);
                gapComposer2 = gapComposer;
            } else {
                snackbarDataImpl2 = snackbarDataImpl;
                modifier2 = companion;
            }
            gapComposer2.end(false);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(snackbarDataImpl2, modifier2, i, 7);
        }
    }

    public static final void GlassSnackbarHost(final SnackbarHostState snackbarHostState, final Modifier modifier, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        int i4;
        gapComposer.startRestartGroup(1684637550);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 = i3 | 48;
        } else {
            i4 = i3 | (gapComposer.changed(modifier) ? 32 : 16);
        }
        if ((i4 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            final float fMo89toPx0680j_4 = ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo89toPx0680j_4(100);
            ScrimKt.SnackbarHost(snackbarHostState, modifier, Thread_jvmKt.rememberComposableLambda(663774017, new Function3() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt.GlassSnackbarHost.1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    final SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(snackbarDataImpl) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-77646980);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = ArcSplineKt.Animatable$default(0.0f);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        final Animatable animatable = (Animatable) objRememberedValue;
                        Object objM = Density.CC.m(-77645284, gapComposer2, false);
                        if (objM == neverEqualPolicy) {
                            objM = ArcSplineKt.Animatable$default(1.0f);
                            gapComposer2.updateRememberedValue(objM);
                        }
                        final Animatable animatable2 = (Animatable) objM;
                        gapComposer2.end(false);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                        gapComposer2.startReplaceGroup(-77640691);
                        boolean zChangedInstance = gapComposer2.changedInstance(animatable);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda1(animatable, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        Modifier modifierAlpha = ClipKt.alpha(OffsetKt.offset((Function1) objRememberedValue3), ((Number) animatable2.getValue()).floatValue());
                        gapComposer2.startReplaceGroup(-77635412);
                        int i6 = iIntValue & 14;
                        boolean zChangedInstance2 = (i6 == 4) | gapComposer2.changedInstance(animatable) | gapComposer2.changed(fMo89toPx0680j_4) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(animatable2);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                            final float f = fMo89toPx0680j_4;
                            PointerInputEventHandler pointerInputEventHandler = new PointerInputEventHandler() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                                    Animatable animatable3 = animatable;
                                    float f2 = f;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0 glassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0 = new GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0(animatable3, f2, pointerInputScope, coroutineScope2, animatable2, snackbarDataImpl);
                                    TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2(28, coroutineScope2, animatable3);
                                    float f3 = DragGestureDetectorKt.mouseToTouchSlopRatio;
                                    Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1(new BasicTextKt$$ExternalSyntheticLambda3(2), textKt$$ExternalSyntheticLambda2, glassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0, new ImmLeaksCleaner$$ExternalSyntheticLambda0(10), (Continuation) null, 2), continuation);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitEachGesture != coroutineSingletons) {
                                        objAwaitEachGesture = Unit.INSTANCE;
                                    }
                                    return objAwaitEachGesture == coroutineSingletons ? objAwaitEachGesture : Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(pointerInputEventHandler);
                            objRememberedValue4 = pointerInputEventHandler;
                        }
                        gapComposer2.end(false);
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierAlpha, snackbarDataImpl, (PointerInputEventHandler) objRememberedValue4);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i7 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPointerInput);
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
                        Stack.m294setimpl(gapComposer2, Integer.valueOf(i7), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m293reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m294setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        GlassSnackbarKt.GlassSnackbar(snackbarDataImpl, null, gapComposer2, i6);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i4 & 112) | (i4 & 14) | 384);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    GlassSnackbarKt.GlassSnackbarHost(snackbarHostState, modifier, (GapComposer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static Object showGlassSnackbar$default(SnackbarHostState snackbarHostState, String str, int i, Continuation continuation, int i2) {
        int i3 = 1;
        boolean z = (i2 & 8) == 0;
        if ((i2 & 16) == 0) {
            i3 = 3;
        } else if (i == 2) {
            i3 = 2;
        }
        return snackbarHostState.showSnackbar(new GlassSnackbarVisuals(i, i3, str, z), continuation);
    }
}
