package com.github.kr328.clash.design.compose.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.rounded.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import okhttp3.Headers;

/* JADX INFO: renamed from: com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferencesKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$PreferencesKt$lambda1$1 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public static final ComposableSingletons$PreferencesKt$lambda1$1 INSTANCE$1 = new ComposableSingletons$PreferencesKt$lambda1$1(1);
    public static final ComposableSingletons$PreferencesKt$lambda1$1 INSTANCE = new ComposableSingletons$PreferencesKt$lambda1$1(0);

    public /* synthetic */ ComposableSingletons$PreferencesKt$lambda1$1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(SequencesKt__SequenceBuilderKt.getKeyboardArrowRight(), null, null, ((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors)).textSecondary, gapComposer, 48, 4);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = CloseKt._close;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Close", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Headers.Builder builder2 = new Headers.Builder(2);
                        builder2.moveTo(18.3f, 5.71f);
                        builder2.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
                        builder2.lineTo(12.0f, 10.59f);
                        builder2.lineTo(7.11f, 5.7f);
                        builder2.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
                        builder2.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
                        builder2.lineTo(10.59f, 12.0f);
                        builder2.lineTo(5.7f, 16.89f);
                        builder2.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
                        builder2.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
                        builder2.lineTo(12.0f, 13.41f);
                        builder2.lineToRelative(4.89f, 4.89f);
                        builder2.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
                        builder2.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
                        builder2.lineTo(13.41f, 12.0f);
                        builder2.lineToRelative(4.89f, -4.89f);
                        builder2.curveToRelative(0.38f, -0.38f, 0.38f, -1.02f, 0.0f, -1.4f);
                        builder2.close();
                        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                        imageVectorBuild = builder.build();
                        CloseKt._close = imageVectorBuild;
                    }
                    IconKt.m248Iconww6aTOc(imageVectorBuild, null, SizeKt.m137size3ABfNKs(Modifier.Companion.$$INSTANCE, 18), 0L, gapComposer2, 432, 8);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
