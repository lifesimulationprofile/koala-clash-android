package androidx.navigationevent;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEvent {
    public final long frameTimeMillis;
    public final float progress;
    public final int swipeEdge;
    public final float touchX;
    public final float touchY;

    public NavigationEvent(int i, float f, float f2, float f3, long j) {
        this.swipeEdge = i;
        this.progress = f;
        this.touchX = f2;
        this.touchY = f3;
        this.frameTimeMillis = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavigationEvent.class == obj.getClass()) {
            NavigationEvent navigationEvent = (NavigationEvent) obj;
            return this.touchX == navigationEvent.touchX && this.touchY == navigationEvent.touchY && this.progress == navigationEvent.progress && this.swipeEdge == navigationEvent.swipeEdge && this.frameTimeMillis == navigationEvent.frameTimeMillis;
        }
        return false;
    }

    public final int hashCode() {
        int iM = (ImageAnalysis$$ExternalSyntheticLambda1.m(this.progress, ImageAnalysis$$ExternalSyntheticLambda1.m(this.touchY, Float.floatToIntBits(this.touchX) * 31, 31), 31) + this.swipeEdge) * 31;
        long j = this.frameTimeMillis;
        return iM + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + ')';
    }
}
