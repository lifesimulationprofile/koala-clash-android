package com.github.kr328.clash.compose.settings;

import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.internal.concurrent.TaskLoggerKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsScreenKt$SettingsScreen$3$1 implements Function2 {
    public final /* synthetic */ AppColors $colors;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SettingsScreenKt$SettingsScreen$3$1(AppColors appColors, int i) {
        this.$r8$classId = i;
        this.$colors = appColors;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        AppColors appColors = this.$colors;
        switch (i) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m274TextNvy7gAk(StringResources_androidKt.stringResource(R.string.settings, gapComposer), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 1572864, 0, 131002);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(RangesKt.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer2), null, appColors.textPrimary, gapComposer2, 0, 4);
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = TaskLoggerKt._search;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Filled.Search", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i2 = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Headers.Builder builder2 = new Headers.Builder(2);
                        builder2.moveTo(15.5f, 14.0f);
                        builder2.horizontalLineToRelative(-0.79f);
                        builder2.lineToRelative(-0.28f, -0.27f);
                        builder2.curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f);
                        builder2.curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f);
                        builder2.reflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f);
                        builder2.reflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f);
                        builder2.curveToRelative(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f);
                        builder2.lineToRelative(0.27f, 0.28f);
                        builder2.verticalLineToRelative(0.79f);
                        builder2.lineToRelative(5.0f, 4.99f);
                        builder2.lineTo(20.49f, 19.0f);
                        builder2.lineToRelative(-4.99f, -5.0f);
                        builder2.close();
                        builder2.moveTo(9.5f, 14.0f);
                        builder2.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
                        builder2.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
                        builder2.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
                        builder2.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
                        builder2.close();
                        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
                        imageVectorBuild = builder.build();
                        TaskLoggerKt._search = imageVectorBuild;
                    }
                    IconKt.m248Iconww6aTOc(imageVectorBuild, null, null, appColors.textPrimary, gapComposer3, 48, 4);
                }
                break;
            case 3:
                GapComposer gapComposer4 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(Handshake.Companion.getMoreVert(), null, null, appColors.textPrimary, gapComposer4, 48, 4);
                }
                break;
            case 4:
                GapComposer gapComposer5 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(UndispatchedKt.getClose(), StringResources_androidKt.stringResource(R.string.close, gapComposer5), null, appColors.textPrimary, gapComposer5, 0, 4);
                }
                break;
            case 5:
                GapComposer gapComposer6 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m274TextNvy7gAk(StringResources_androidKt.stringResource(R.string.share_to_tv_title, gapComposer6), null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262138);
                }
                break;
            case 6:
                GapComposer gapComposer7 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(RangesKt.getArrowBack(), null, null, appColors.textPrimary, gapComposer7, 48, 4);
                }
                break;
            default:
                GapComposer gapComposer8 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer8.getSkipping()) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    IconKt.m248Iconww6aTOc(RangesKt.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer8), null, appColors.textPrimary, gapComposer8, 0, 4);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
