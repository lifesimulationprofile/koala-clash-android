package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Fade {
    public final FiniteAnimationSpec animationSpec;

    public Fade(FiniteAnimationSpec finiteAnimationSpec) {
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Fade) {
            return Float.compare(0.0f, 0.0f) == 0 && Intrinsics.areEqual(this.animationSpec, ((Fade) obj).animationSpec);
        }
        return false;
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (Float.floatToIntBits(0.0f) * 31);
    }

    public final String toString() {
        return "Fade(alpha=0.0, animationSpec=" + this.animationSpec + ')';
    }
}
