package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.IntSize;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    public final ParcelableSnapshotMutableState targetSize = Stack.mutableStateOf$default(new IntSize(0));
    public final Transition transition;

    public AnimatedVisibilityScopeImpl(Transition transition) {
        this.transition = transition;
    }

    @Override // androidx.compose.animation.AnimatedVisibilityScope
    public final Transition getTransition() {
        return this.transition;
    }
}
