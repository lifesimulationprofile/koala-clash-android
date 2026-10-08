package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface DrawScope extends Density {
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    void mo460drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    void mo461drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    void mo462drawImageAZ2fEMs(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    void mo463drawImagegbVJVH8(AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    void mo464drawLineNGM6Ib0(long j, long j2, long j3, float f, int i);

    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    void mo465drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawPath-LG529CI */
    void mo466drawPathLG529CI(AndroidPath androidPath, long j, DrawStyle drawStyle);

    /* JADX INFO: renamed from: drawRect-AsUm42w */
    void mo467drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    void mo468drawRectnJ9OG0(long j, long j2, long j3, float f, int i);

    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    void mo469drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i);

    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    void mo470drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo471getCenterF1C5BW0();

    SVG getDrawContext();

    LayoutDirection getLayoutDirection();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo472getSizeNHjbRc();

    /* JADX INFO: renamed from: record-JVtK1S4 */
    void mo473recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1);
}
