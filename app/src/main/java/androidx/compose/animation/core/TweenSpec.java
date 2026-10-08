package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TweenSpec implements DurationBasedAnimationSpec {
    public final int delay;
    public final int durationMillis;
    public final Easing easing;

    public TweenSpec(int i, int i2, Easing easing) {
        this.durationMillis = i;
        this.delay = i2;
        this.easing = easing;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TweenSpec) {
            TweenSpec tweenSpec = (TweenSpec) obj;
            if (tweenSpec.durationMillis == this.durationMillis && tweenSpec.delay == this.delay && Intrinsics.areEqual(tweenSpec.easing, this.easing)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.easing.hashCode() + (this.durationMillis * 31)) * 31) + this.delay;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new Huffman.Node(this.durationMillis, this.delay, this.easing);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new Huffman.Node(this.durationMillis, this.delay, this.easing);
    }
}
