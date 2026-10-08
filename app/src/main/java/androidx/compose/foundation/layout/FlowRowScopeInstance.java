package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowRowScopeInstance implements RowScope {
    public static final FlowRowScopeInstance INSTANCE = new FlowRowScopeInstance();

    @Override // androidx.compose.foundation.layout.RowScope
    public final Modifier weight(boolean z) {
        if (1.0f <= 0.0d) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
        }
        return new LayoutWeightElement(1.0f, true);
    }
}
