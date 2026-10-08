package androidx.compose.ui.focus;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.ui.platform.AndroidComposeView;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusInvalidationManager {
    public final MutableScatterSet focusEventNodes;
    public final FocusOwnerImpl focusOwner;
    public final MutableScatterSet focusTargetNodes;
    public boolean isInvalidationScheduled;
    public final AndroidComposeView owner;

    public FocusInvalidationManager(FocusOwnerImpl focusOwnerImpl, AndroidComposeView androidComposeView) {
        this.focusOwner = focusOwnerImpl;
        this.owner = androidComposeView;
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.focusTargetNodes = new MutableScatterSet();
        this.focusEventNodes = new MutableScatterSet();
    }

    public final void scheduleInvalidation$2() {
        if (this.isInvalidationScheduled) {
            return;
        }
        FocusableNode.AnonymousClass1 anonymousClass1 = new FocusableNode.AnonymousClass1(0, this, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0, 0, 2);
        MutableObjectList mutableObjectList = this.owner.endApplyChangesListeners;
        if (mutableObjectList.indexOf(anonymousClass1) < 0) {
            mutableObjectList.add(anonymousClass1);
        }
        this.isInvalidationScheduled = true;
    }
}
