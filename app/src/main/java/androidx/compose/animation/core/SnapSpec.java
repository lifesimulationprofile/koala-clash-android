package androidx.compose.animation.core;

import com.google.android.gms.dynamite.zzo;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapSpec implements DurationBasedAnimationSpec {
    public final int delay;

    public SnapSpec(int i) {
        this.delay = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof SnapSpec) && ((SnapSpec) obj).delay == this.delay;
    }

    public final int hashCode() {
        return this.delay;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final VectorizedDurationBasedAnimationSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        return new zzo(this.delay);
    }
}
