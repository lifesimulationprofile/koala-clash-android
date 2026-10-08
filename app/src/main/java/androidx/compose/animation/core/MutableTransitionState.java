package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableTransitionState extends Lifecycle {
    public final ParcelableSnapshotMutableState currentState$delegate;
    public final ParcelableSnapshotMutableState targetState$delegate;

    public MutableTransitionState(Object obj) {
        super(2);
        this.currentState$delegate = Stack.mutableStateOf$default(obj);
        this.targetState$delegate = Stack.mutableStateOf$default(obj);
    }

    @Override // androidx.lifecycle.Lifecycle
    /* JADX INFO: renamed from: getCurrentState */
    public final Object mo767getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void setCurrentState$animation_core(Object obj) {
        this.currentState$delegate.setValue(obj);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionRemoved$animation_core() {
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void transitionConfigured$animation_core(Transition transition) {
    }
}
