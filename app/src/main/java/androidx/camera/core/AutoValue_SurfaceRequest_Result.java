package androidx.camera.core;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_Result {
    public final int resultCode;
    public final Surface surface;

    public AutoValue_SurfaceRequest_Result(int i, Surface surface) {
        this.resultCode = i;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.surface = surface;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SurfaceRequest_Result)) {
            return false;
        }
        AutoValue_SurfaceRequest_Result autoValue_SurfaceRequest_Result = (AutoValue_SurfaceRequest_Result) obj;
        return this.resultCode == autoValue_SurfaceRequest_Result.resultCode && this.surface.equals(autoValue_SurfaceRequest_Result.surface);
    }

    public final int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }

    public final String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    }
}
