package androidx.compose.animation;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentTransform {
    public final ExitTransitionImpl initialContentExit;
    public final SizeTransformImpl sizeTransform;
    public final EnterTransitionImpl targetContentEnter;
    public final ParcelableSnapshotMutableFloatState targetContentZIndex$delegate;

    public ContentTransform(EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, float f, SizeTransformImpl sizeTransformImpl) {
        this.targetContentEnter = enterTransitionImpl;
        this.initialContentExit = exitTransitionImpl;
        this.targetContentZIndex$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.sizeTransform = sizeTransformImpl;
    }
}
