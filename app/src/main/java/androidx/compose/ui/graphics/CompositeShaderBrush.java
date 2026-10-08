package androidx.compose.ui.graphics;

import android.graphics.ComposeShader;
import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeShaderBrush extends ShaderBrush {
    public final ShaderBrush dstBrush;
    public final ShaderBrush srcBrush;

    public CompositeShaderBrush(ShaderBrush shaderBrush, ShaderBrush shaderBrush2) {
        this.dstBrush = shaderBrush;
        this.srcBrush = shaderBrush2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo429createShaderuvyYCjk(long j) {
        Shader shaderMo429createShaderuvyYCjk = this.dstBrush.mo429createShaderuvyYCjk(j);
        Shader shaderMo429createShaderuvyYCjk2 = this.srcBrush.mo429createShaderuvyYCjk(j);
        return Build.VERSION.SDK_INT >= 29 ? CanvasZHelper$$ExternalSyntheticApiModelOutline0.m(shaderMo429createShaderuvyYCjk, shaderMo429createShaderuvyYCjk2, BrushKt.m422toAndroidBlendModes9anfk8(5)) : new ComposeShader(shaderMo429createShaderuvyYCjk, shaderMo429createShaderuvyYCjk2, BrushKt.m426toPorterDuffModes9anfk8(5));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeShaderBrush)) {
            return false;
        }
        CompositeShaderBrush compositeShaderBrush = (CompositeShaderBrush) obj;
        return this.dstBrush.equals(compositeShaderBrush.dstBrush) && this.srcBrush.equals(compositeShaderBrush.srcBrush);
    }

    public final int hashCode() {
        return ((this.srcBrush.hashCode() + (this.dstBrush.hashCode() * 31)) * 31) + 5;
    }

    public final String toString() {
        return "CompositeShaderBrush(dstBrush=" + this.dstBrush + ", srcBrush=" + this.srcBrush + ", blendMode=" + ((Object) BrushKt.m427toStringimpl(5)) + ')';
    }
}
