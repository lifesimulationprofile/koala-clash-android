package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.compose.AsyncImageKt;
import coil.decode.SvgDecoder;
import coil.memory.MemoryCache$Key;
import coil.request.ImageRequest;
import coil.transition.CrossfadeTransition;
import com.github.kr328.clash.design.compose.components.PreferencesKt$$ExternalSyntheticLambda9;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzkg;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.Headers;
import okhttp3.RequestBody$Companion$toRequestBody$2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkg {
    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    /* JADX INFO: renamed from: ProfileAvatar-uFdPcIQ, reason: not valid java name */
    public static final void m823ProfileAvataruFdPcIQ(Modifier modifier, final float f, final String str, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1675290161);
        int i2 = i | 6;
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(str) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(-348031617);
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                if (str != null) {
                    File file = new File(str);
                    if (file.isFile()) {
                        objRememberedValue = file;
                    } else {
                        objRememberedValue = null;
                    }
                } else {
                    objRememberedValue = null;
                }
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            File file2 = (File) objRememberedValue;
            gapComposer2.end(false);
            modifier2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137size3ABfNKs = SizeKt.m137size3ABfNKs(modifier2, f);
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            Modifier modifierM44backgroundbw27NRU = ImageKt.m44backgroundbw27NRU(ClipKt.clip(modifierM137size3ABfNKs, roundedCornerShape), appColors.cardBackground, BrushKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
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
            long jLastModified = file2 != null ? file2.lastModified() : 0L;
            String absolutePath = file2 != null ? file2.getAbsolutePath() : null;
            gapComposer2.startReplaceGroup(49513113);
            boolean zChanged = gapComposer2.changed(absolutePath) | gapComposer2.changed(jLastModified);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState = (MutableState) objRememberedValue2;
            gapComposer2.end(false);
            if (file2 == null || ((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(1535969309);
                ImageVector imageVectorBuild = RequestBody$Companion$toRequestBody$2._public;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder = new ImageVector.Builder("Filled.Public", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i4 = VectorKt.$r8$clinit;
                    SolidColor solidColor = new SolidColor(Color.Black);
                    Headers.Builder builder2 = new Headers.Builder(2);
                    builder2.moveTo(12.0f, 2.0f);
                    builder2.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    builder2.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    builder2.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    builder2.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    builder2.close();
                    builder2.moveTo(11.0f, 19.93f);
                    builder2.curveToRelative(-3.95f, -0.49f, -7.0f, -3.85f, -7.0f, -7.93f);
                    builder2.curveToRelative(0.0f, -0.62f, 0.08f, -1.21f, 0.21f, -1.79f);
                    builder2.lineTo(9.0f, 15.0f);
                    builder2.verticalLineToRelative(1.0f);
                    builder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                    builder2.verticalLineToRelative(1.93f);
                    builder2.close();
                    builder2.moveTo(17.9f, 17.39f);
                    builder2.curveToRelative(-0.26f, -0.81f, -1.0f, -1.39f, -1.9f, -1.39f);
                    builder2.horizontalLineToRelative(-1.0f);
                    builder2.verticalLineToRelative(-3.0f);
                    builder2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    builder2.lineTo(8.0f, 12.0f);
                    builder2.verticalLineToRelative(-2.0f);
                    builder2.horizontalLineToRelative(2.0f);
                    builder2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                    builder2.lineTo(11.0f, 7.0f);
                    builder2.horizontalLineToRelative(2.0f);
                    builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                    builder2.verticalLineToRelative(-0.41f);
                    builder2.curveToRelative(2.93f, 1.19f, 5.0f, 4.06f, 5.0f, 7.41f);
                    builder2.curveToRelative(0.0f, 2.08f, -0.8f, 3.97f, -2.1f, 5.39f);
                    builder2.close();
                    ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                    imageVectorBuild = builder.build();
                    RequestBody$Companion$toRequestBody$2._public = imageVectorBuild;
                }
                IconKt.m248Iconww6aTOc(imageVectorBuild, null, SizeKt.m137size3ABfNKs(modifier2, 0.6f * f), appColors.textPrimary, gapComposer, 48, 0);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(1535035434);
                ImageRequest.Builder builder3 = new ImageRequest.Builder((Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext));
                builder3.data = file2;
                builder3.decoderFactory = new SvgDecoder.Factory();
                String str2 = file2.getAbsolutePath() + ":" + jLastModified;
                builder3.memoryCacheKey = str2 != null ? new MemoryCache$Key(str2) : null;
                builder3.transitionFactory = new CrossfadeTransition.Factory(100);
                ImageRequest imageRequestBuild = builder3.build();
                Modifier modifierClip = ClipKt.clip(SizeKt.m137size3ABfNKs(modifier2, f), roundedCornerShape);
                gapComposer2.startReplaceGroup(49542884);
                boolean zChanged2 = gapComposer2.changed(mutableState);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new PreferencesKt$$ExternalSyntheticLambda9(mutableState, 1);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                gapComposer2.end(false);
                AsyncImageKt.m777AsyncImagegl8XCv8(imageRequestBuild, modifierClip, (Function1) objRememberedValue3, ContentScale.Companion.Crop, gapComposer2, 1572912, 4008);
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.ProfileAvatarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    zzkg.m823ProfileAvataruFdPcIQ(modifier2, f, str, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
