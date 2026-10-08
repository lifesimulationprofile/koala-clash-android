package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationScope {
    public long finishedTimeNanos = Long.MIN_VALUE;
    public final ParcelableSnapshotMutableState isRunning$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
    public long lastFrameTimeNanos;
    public final Function0 onCancel;
    public final long startTimeNanos;
    public final Object targetValue;
    public final TwoWayConverterImpl typeConverter;
    public final ParcelableSnapshotMutableState value$delegate;
    public AnimationVector velocityVector;

    public AnimationScope(Object obj, TwoWayConverterImpl twoWayConverterImpl, AnimationVector animationVector, long j, Object obj2, long j2, Function0 function0) {
        this.typeConverter = twoWayConverterImpl;
        this.targetValue = obj2;
        this.startTimeNanos = j2;
        this.onCancel = function0;
        this.value$delegate = Stack.mutableStateOf$default(obj);
        this.velocityVector = ArcSplineKt.copy(animationVector);
        this.lastFrameTimeNanos = j;
    }

    public final void cancelAnimation() {
        this.isRunning$delegate.setValue(Boolean.FALSE);
        this.onCancel.invoke();
    }

    public final Object getVelocity() {
        return this.typeConverter.convertFromVector.invoke(this.velocityVector);
    }
}
