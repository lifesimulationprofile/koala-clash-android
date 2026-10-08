package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StartDelayVectorizedAnimationSpec implements VectorizedAnimationSpec {
    public final long startDelayNanos;
    public final VectorizedAnimationSpec vectorizedAnimationSpec;

    public StartDelayVectorizedAnimationSpec(VectorizedAnimationSpec vectorizedAnimationSpec, long j) {
        this.vectorizedAnimationSpec = vectorizedAnimationSpec;
        this.startDelayNanos = j;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StartDelayVectorizedAnimationSpec)) {
            return false;
        }
        StartDelayVectorizedAnimationSpec startDelayVectorizedAnimationSpec = (StartDelayVectorizedAnimationSpec) obj;
        return startDelayVectorizedAnimationSpec.startDelayNanos == this.startDelayNanos && Intrinsics.areEqual(startDelayVectorizedAnimationSpec.vectorizedAnimationSpec, this.vectorizedAnimationSpec);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.vectorizedAnimationSpec.getDurationNanos(animationVector, animationVector2, animationVector3) + this.startDelayNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return getVelocityFromNanos(getDurationNanos(animationVector, animationVector2, animationVector3), animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j2 = this.startDelayNanos;
        return j < j2 ? animationVector : this.vectorizedAnimationSpec.getValueFromNanos(j - j2, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j2 = this.startDelayNanos;
        return j < j2 ? animationVector3 : this.vectorizedAnimationSpec.getVelocityFromNanos(j - j2, animationVector, animationVector2, animationVector3);
    }

    public final int hashCode() {
        int iHashCode = this.vectorizedAnimationSpec.hashCode() * 31;
        long j = this.startDelayNanos;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final boolean isInfinite() {
        return this.vectorizedAnimationSpec.isInfinite();
    }
}
