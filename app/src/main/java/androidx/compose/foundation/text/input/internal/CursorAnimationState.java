package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnimationState {
    public final boolean animate;
    public final AtomicReference animationJob = new AtomicReference(null);
    public final ParcelableSnapshotMutableFloatState cursorAlpha$delegate = new ParcelableSnapshotMutableFloatState(0.0f);

    public CursorAnimationState(boolean z) {
        this.animate = z;
    }
}
