package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintsState;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintController$track$1$listener$1 {
    public final /* synthetic */ ProducerScope $$this$callbackFlow;
    public final /* synthetic */ ConstraintController this$0;

    public ConstraintController$track$1$listener$1(ConstraintController constraintController, ProducerScope producerScope) {
        this.this$0 = constraintController;
        this.$$this$callbackFlow = producerScope;
    }

    public final void onConstraintChanged(Object obj) {
        ConstraintController constraintController = this.this$0;
        Object constraintsNotMet = constraintController.isConstrained(obj) ? new ConstraintsState.ConstraintsNotMet(constraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE;
        ProducerCoroutine producerCoroutine = (ProducerCoroutine) this.$$this$callbackFlow;
        producerCoroutine.getClass();
        producerCoroutine.mo851trySendJP2dKIU(constraintsNotMet);
    }
}
