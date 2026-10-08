package androidx.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UnionInsetsConsumingModifierNode extends InsetsConsumingModifierNode {
    public WindowInsets insets;

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public final WindowInsets calculateInsets(WindowInsets windowInsets) {
        return new UnionInsets(windowInsets, this.insets);
    }
}
