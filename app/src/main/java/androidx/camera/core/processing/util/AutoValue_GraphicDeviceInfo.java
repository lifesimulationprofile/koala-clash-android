package androidx.camera.core.processing.util;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_GraphicDeviceInfo {
    public final String eglExtensions;
    public final String eglVersion;
    public final String glExtensions;
    public final String glVersion;

    public AutoValue_GraphicDeviceInfo(String str, String str2, String str3, String str4) {
        this.glVersion = str;
        this.eglVersion = str2;
        this.glExtensions = str3;
        this.eglExtensions = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_GraphicDeviceInfo) {
            AutoValue_GraphicDeviceInfo autoValue_GraphicDeviceInfo = (AutoValue_GraphicDeviceInfo) obj;
            if (this.glVersion.equals(autoValue_GraphicDeviceInfo.glVersion) && this.eglVersion.equals(autoValue_GraphicDeviceInfo.eglVersion) && this.glExtensions.equals(autoValue_GraphicDeviceInfo.glExtensions) && this.eglExtensions.equals(autoValue_GraphicDeviceInfo.eglExtensions)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GraphicDeviceInfo{glVersion=");
        sb.append(this.glVersion);
        sb.append(", eglVersion=");
        sb.append(this.eglVersion);
        sb.append(", glExtensions=");
        sb.append(this.glExtensions);
        sb.append(", eglExtensions=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.eglExtensions, "}");
    }
}
