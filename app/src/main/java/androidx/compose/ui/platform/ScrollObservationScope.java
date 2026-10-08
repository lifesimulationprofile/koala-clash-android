package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollObservationScope implements OwnerScope {
    public final List allScopes;
    public final int semanticsNodeId;
    public Float oldXValue = null;
    public Float oldYValue = null;
    public ScrollAxisRange horizontalScrollAxisRange = null;
    public ScrollAxisRange verticalScrollAxisRange = null;

    public ScrollObservationScope(int i, ArrayList arrayList) {
        this.semanticsNodeId = i;
        this.allScopes = arrayList;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.allScopes.contains(this);
    }
}
