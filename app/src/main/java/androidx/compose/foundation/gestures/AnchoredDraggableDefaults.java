package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnchoredDraggableDefaults {
    public static final TweenSpec SnapAnimationSpec = ArcSplineKt.tween$default(0, 7, null);
    public static final BorderKt$$ExternalSyntheticLambda1 PositionalThreshold = new BorderKt$$ExternalSyntheticLambda1(26);
    public static final DecayAnimationSpecImpl DecayAnimationSpec = ArcSplineKt.exponentialDecay$default();
}
