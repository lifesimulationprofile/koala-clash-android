package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.MeasuredSizeAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class OnSizeChangedNode extends Modifier.Node implements MeasuredSizeAwareModifierNode {
    public Function1 onSizeChanged;
    public long previousSize;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return true;
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo63onRemeasuredozmzZPI(long j) {
        if (IntSize.m717equalsimpl0(this.previousSize, j)) {
            return;
        }
        this.onSizeChanged.invoke(new IntSize(j));
        this.previousSize = j;
    }
}
