package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Slide {
    public final FiniteAnimationSpec animationSpec;
    public final Lambda slideOffset;

    /* JADX WARN: Multi-variable type inference failed */
    public Slide(Function1 function1, FiniteAnimationSpec finiteAnimationSpec) {
        this.slideOffset = (Lambda) function1;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Slide)) {
            return false;
        }
        Slide slide = (Slide) obj;
        return this.slideOffset.equals(slide.slideOffset) && this.animationSpec.equals(slide.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (this.slideOffset.hashCode() * 31);
    }

    public final String toString() {
        return "Slide(slideOffset=" + this.slideOffset + ", animationSpec=" + this.animationSpec + ')';
    }
}
