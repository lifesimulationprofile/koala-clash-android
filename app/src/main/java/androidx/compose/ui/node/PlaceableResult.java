package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceableResult implements OwnerScope {
    public final LookaheadCapablePlaceable placeable;
    public MeasureResult result;

    public PlaceableResult(MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.result = measureResult;
        this.placeable = lookaheadCapablePlaceable;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }
}
