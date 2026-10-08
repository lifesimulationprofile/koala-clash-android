package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BlurKt {
    /* JADX INFO: renamed from: configureShadow-FoewPVk$default, reason: not valid java name */
    public static AndroidPaint m495configureShadowFoewPVk$default(AndroidPaint androidPaint, int i, BlurMaskFilter blurMaskFilter, int i2) {
        long j = Color.Black;
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            blurMaskFilter = null;
        }
        int i3 = (i2 & 8) != 0 ? 0 : 1;
        androidPaint.m402setColor8_81llA(j);
        androidPaint.m401setBlendModes9anfk8(i);
        androidPaint.m406setStylek9PVt8s(i3);
        BrushKt.getNativePaint(androidPaint).setMaskFilter(blurMaskFilter);
        return androidPaint;
    }
}
