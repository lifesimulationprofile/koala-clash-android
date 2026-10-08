package androidx.compose.foundation;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public BorderCache borderCache;
    public SolidColor brush;
    public final CacheDrawModifierNodeImpl drawWithCacheModifierNode;
    public Shape shape;
    public float width;

    public BorderModifierNode(float f, SolidColor solidColor, Shape shape) {
        this.width = f;
        this.brush = solidColor;
        this.shape = shape;
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = new CacheDrawModifierNodeImpl(new CacheDrawScope(), new Recomposer$$ExternalSyntheticLambda0(2, this));
        delegate(cacheDrawModifierNodeImpl);
        this.drawWithCacheModifierNode = cacheDrawModifierNodeImpl;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean isImportantForBounds() {
        return false;
    }
}
