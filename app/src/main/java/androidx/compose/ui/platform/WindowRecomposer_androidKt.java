package androidx.compose.ui.platform;

import android.view.View;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.CompositionContext;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WindowRecomposer_androidKt {
    public static final MutableScatterMap animationScale;

    static {
        long[] jArr = ScatterMapKt.EmptyGroup;
        animationScale = new MutableScatterMap();
    }

    public static final CompositionContext getCompositionContext(View view) {
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }
}
