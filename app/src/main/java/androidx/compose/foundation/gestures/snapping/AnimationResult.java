package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult {
    public final AnimationState currentAnimationState;
    public final Float remainingOffset;

    public AnimationResult(Float f, AnimationState animationState) {
        this.remainingOffset = f;
        this.currentAnimationState = animationState;
    }
}
