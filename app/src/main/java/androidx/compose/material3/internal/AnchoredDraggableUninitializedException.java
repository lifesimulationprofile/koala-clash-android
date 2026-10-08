package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DefaultDraggableAnchors;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableUninitializedException extends Throwable {
    public final String message;

    public AnchoredDraggableUninitializedException(boolean z, boolean z2, DefaultDraggableAnchors defaultDraggableAnchors, Object obj) {
        this.message = "AnchoredDraggableState was not initialized correctly. isLookingAhead=" + z + ",didLookahead=" + z2 + ",anchors=" + defaultDraggableAnchors + ",targetValue=" + obj;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
