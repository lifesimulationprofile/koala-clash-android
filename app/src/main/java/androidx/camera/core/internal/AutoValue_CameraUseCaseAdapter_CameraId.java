package androidx.camera.core.internal;

import androidx.camera.core.impl.AutoValue_Identifier;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_CameraUseCaseAdapter_CameraId {
    public final AutoValue_Identifier cameraConfigId;
    public final String cameraIdString;

    public AutoValue_CameraUseCaseAdapter_CameraId(String str, AutoValue_Identifier autoValue_Identifier) {
        if (str == null) {
            throw new NullPointerException("Null cameraIdString");
        }
        this.cameraIdString = str;
        if (autoValue_Identifier == null) {
            throw new NullPointerException("Null cameraConfigId");
        }
        this.cameraConfigId = autoValue_Identifier;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_CameraUseCaseAdapter_CameraId) {
            AutoValue_CameraUseCaseAdapter_CameraId autoValue_CameraUseCaseAdapter_CameraId = (AutoValue_CameraUseCaseAdapter_CameraId) obj;
            if (this.cameraIdString.equals(autoValue_CameraUseCaseAdapter_CameraId.cameraIdString) && this.cameraConfigId.equals(autoValue_CameraUseCaseAdapter_CameraId.cameraConfigId)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.cameraIdString.hashCode() ^ 1000003) * 1000003) ^ this.cameraConfigId.hashCode();
    }

    public final String toString() {
        return "CameraId{cameraIdString=" + this.cameraIdString + ", cameraConfigId=" + this.cameraConfigId + "}";
    }
}
