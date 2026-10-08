package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult {
    public final int endReason;
    public final AnimationState endState;

    public AnimationResult(int i, AnimationState animationState) {
        this.endState = animationState;
        this.endReason = i;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AnimationResult(endReason=");
        int i = this.endReason;
        if (i != 1) {
            str = i != 2 ? "null" : "Finished";
        } else {
            str = "BoundReached";
        }
        sb.append(str);
        sb.append(", endState=");
        sb.append(this.endState);
        sb.append(')');
        return sb.toString();
    }
}
