package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.VerticalAlignmentLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InteractiveComponentSizeKt {
    public static final StaticProvidableCompositionLocal LocalMinimumInteractiveComponentSize;
    public static final HorizontalAlignmentLine MinimumInteractiveTopAlignmentLine = new HorizontalAlignmentLine(InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1.INSTANCE);
    public static final VerticalAlignmentLine MinimumInteractiveLeftAlignmentLine = new VerticalAlignmentLine(InteractiveComponentSizeKt$MinimumInteractiveLeftAlignmentLine$1.INSTANCE);

    static {
        Stack.staticCompositionLocalOf(new ImmLeaksCleaner$$ExternalSyntheticLambda0(24));
        LocalMinimumInteractiveComponentSize = new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(25));
    }
}
