package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StartDelayAnimationSpec implements AnimationSpec {
    public final AnimationSpec animationSpec;
    public final long startDelayNanos;

    public StartDelayAnimationSpec(FiniteAnimationSpec finiteAnimationSpec, long j) {
        this.animationSpec = finiteAnimationSpec;
        this.startDelayNanos = j;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StartDelayAnimationSpec)) {
            return false;
        }
        StartDelayAnimationSpec startDelayAnimationSpec = (StartDelayAnimationSpec) obj;
        return startDelayAnimationSpec.startDelayNanos == this.startDelayNanos && Intrinsics.areEqual(startDelayAnimationSpec.animationSpec, this.animationSpec);
    }

    public final int hashCode() {
        int iHashCode = this.animationSpec.hashCode() * 31;
        long j = this.startDelayNanos;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new StartDelayVectorizedAnimationSpec(this.animationSpec.vectorize(twoWayConverterImpl), this.startDelayNanos);
    }
}
