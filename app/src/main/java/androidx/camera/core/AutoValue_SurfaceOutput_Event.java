package androidx.camera.core;

import androidx.camera.core.processing.SurfaceOutputImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceOutput_Event {
    public final SurfaceOutputImpl surfaceOutput;

    public AutoValue_SurfaceOutput_Event(SurfaceOutputImpl surfaceOutputImpl) {
        this.surfaceOutput = surfaceOutputImpl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AutoValue_SurfaceOutput_Event) && this.surfaceOutput.equals(((AutoValue_SurfaceOutput_Event) obj).surfaceOutput);
    }

    public final int hashCode() {
        return this.surfaceOutput.hashCode() ^ (-721379959);
    }

    public final String toString() {
        return "Event{eventCode=0, surfaceOutput=" + this.surfaceOutput + "}";
    }
}
