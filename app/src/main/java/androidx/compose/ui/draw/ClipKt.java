package androidx.compose.ui.draw;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClipKt {
    public static final Modifier alpha(Modifier modifier, float f) {
        return f == 1.0f ? modifier : BrushKt.m415graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, f, 0.0f, 0.0f, null, true, 520187);
    }

    public static final Modifier clip(Modifier modifier, Shape shape) {
        return BrushKt.m415graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, shape, true, 518143);
    }

    public static final Modifier clipToBounds(Modifier modifier) {
        return BrushKt.m415graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, true, 520191);
    }

    public static final Modifier drawBehind(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawBehindElement(function1));
    }

    public static final Modifier drawWithCache(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawWithCacheElement(function1));
    }

    public static final Modifier drawWithContent(Modifier modifier, Function1 function1) {
        return modifier.then(new DrawWithContentElement(function1));
    }

    public static Modifier paint$default(Modifier modifier, Painter painter, Alignment alignment, ContentScale contentScale, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        if ((i & 4) != 0) {
            alignment = Alignment.Companion.Center;
        }
        Alignment alignment2 = alignment;
        if ((i & 16) != 0) {
            f = 1.0f;
        }
        return modifier.then(new PainterElement(painter, alignment2, contentScale, f, blendModeColorFilter));
    }

    /* JADX INFO: renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static Modifier m337shadows4CzXII$default(Modifier modifier, float f, RoundedCornerShape roundedCornerShape, long j, long j2, int i) {
        boolean z = Dp.m700compareTo0680j_4(f, (float) 0) > 0;
        return (Dp.m700compareTo0680j_4(f, (float) 0) > 0 || z) ? modifier.then(new ShadowGraphicsLayerElement(f, roundedCornerShape, z, (i & 8) != 0 ? GraphicsLayerScopeKt.DefaultShadowColor : j, (i & 16) != 0 ? GraphicsLayerScopeKt.DefaultShadowColor : j2)) : modifier;
    }
}
