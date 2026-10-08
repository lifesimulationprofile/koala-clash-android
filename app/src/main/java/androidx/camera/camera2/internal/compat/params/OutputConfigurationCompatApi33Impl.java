package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class OutputConfigurationCompatApi33Impl extends OutputConfigurationCompatApi28Impl {
    public OutputConfigurationCompatApi33Impl(int i, Surface surface) {
        super(new OutputConfiguration(i, surface));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final Object getOutputConfiguration() {
        Object obj = this.mObject;
        Preconditions.checkArgument(obj instanceof OutputConfiguration);
        return obj;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final void setDynamicRangeProfile(long j) {
        ((OutputConfiguration) getOutputConfiguration()).setDynamicRangeProfile(j);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final void setMirrorMode(int i) {
        ((OutputConfiguration) getOutputConfiguration()).setMirrorMode(i);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final void setStreamUseCase(long j) {
        if (j == -1) {
            return;
        }
        ((OutputConfiguration) getOutputConfiguration()).setStreamUseCase(j);
    }
}
