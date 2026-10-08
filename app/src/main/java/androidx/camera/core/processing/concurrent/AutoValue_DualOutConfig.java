package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.AutoValue_OutConfig;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_DualOutConfig {
    public final AutoValue_OutConfig primaryOutConfig;
    public final AutoValue_OutConfig secondaryOutConfig;

    public AutoValue_DualOutConfig(AutoValue_OutConfig autoValue_OutConfig, AutoValue_OutConfig autoValue_OutConfig2) {
        this.primaryOutConfig = autoValue_OutConfig;
        this.secondaryOutConfig = autoValue_OutConfig2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_DualOutConfig) {
            AutoValue_DualOutConfig autoValue_DualOutConfig = (AutoValue_DualOutConfig) obj;
            if (this.primaryOutConfig.equals(autoValue_DualOutConfig.primaryOutConfig) && this.secondaryOutConfig.equals(autoValue_DualOutConfig.secondaryOutConfig)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.primaryOutConfig.hashCode() ^ 1000003) * 1000003) ^ this.secondaryOutConfig.hashCode();
    }

    public final String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.primaryOutConfig + ", secondaryOutConfig=" + this.secondaryOutConfig + "}";
    }
}
