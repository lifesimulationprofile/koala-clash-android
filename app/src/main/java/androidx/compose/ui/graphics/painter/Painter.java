package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil.disk.RealDiskCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Painter {
    public BlendModeColorFilter colorFilter;
    public AndroidPaint layerPaint;
    public float alpha = 1.0f;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;

    public abstract void applyAlpha(float f);

    public abstract void applyColorFilter(BlendModeColorFilter blendModeColorFilter);

    /* JADX INFO: renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m493drawx_KDEd0(LayoutNodeDrawScope layoutNodeDrawScope, long j, float f, BlendModeColorFilter blendModeColorFilter) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (this.alpha != f) {
            applyAlpha(f);
            this.alpha = f;
        }
        if (!Intrinsics.areEqual(this.colorFilter, blendModeColorFilter)) {
            applyColorFilter(blendModeColorFilter);
            this.colorFilter = blendModeColorFilter;
        }
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        if (this.layoutDirection != layoutDirection) {
            applyLayoutDirection(layoutDirection);
            this.layoutDirection = layoutDirection;
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() >> 32)) - Float.intBitsToFloat(i);
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() & 4294967295L)) - Float.intBitsToFloat(i2);
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).inset(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f > 0.0f) {
            try {
                if (Float.intBitsToFloat(i) > 0.0f && Float.intBitsToFloat(i2) > 0.0f) {
                    onDraw(layoutNodeDrawScope);
                }
            } finally {
                ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).inset(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
            }
        }
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo490getIntrinsicSizeNHjbRc();

    public abstract void onDraw(LayoutNodeDrawScope layoutNodeDrawScope);

    public void applyLayoutDirection(LayoutDirection layoutDirection) {
    }
}
