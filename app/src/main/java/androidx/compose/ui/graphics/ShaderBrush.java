package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import coil.memory.EmptyStrongMemoryCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    public long createdSize = 9205357640488583168L;
    public EmptyStrongMemoryCache internalTransformShader;

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo409applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        EmptyStrongMemoryCache emptyStrongMemoryCache = this.internalTransformShader;
        if (emptyStrongMemoryCache == null || !Size.m382equalsimpl0(this.createdSize, j)) {
            if (Size.m386isEmptyimpl(j)) {
                this.internalTransformShader = null;
                this.createdSize = 9205357640488583168L;
                emptyStrongMemoryCache = null;
            } else {
                emptyStrongMemoryCache = this.internalTransformShader;
                if (emptyStrongMemoryCache == null) {
                    emptyStrongMemoryCache = new EmptyStrongMemoryCache(3);
                    this.internalTransformShader = emptyStrongMemoryCache;
                }
                emptyStrongMemoryCache.weakMemoryCache = mo429createShaderuvyYCjk(j);
                this.internalTransformShader = emptyStrongMemoryCache;
                this.createdSize = j;
            }
        }
        Paint paint = androidPaint.internalPaint;
        long jColor = BrushKt.Color(paint.getColor());
        long j2 = Color.Black;
        if (!Color.m433equalsimpl0(jColor, j2)) {
            androidPaint.m402setColor8_81llA(j2);
        }
        if (!Intrinsics.areEqual(androidPaint.internalShader, emptyStrongMemoryCache != null ? (Shader) emptyStrongMemoryCache.weakMemoryCache : null)) {
            androidPaint.setShader(emptyStrongMemoryCache != null ? (Shader) emptyStrongMemoryCache.weakMemoryCache : null);
        }
        if (paint.getAlpha() / 255.0f == f) {
            return;
        }
        androidPaint.setAlpha(f);
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo429createShaderuvyYCjk(long j);
}
