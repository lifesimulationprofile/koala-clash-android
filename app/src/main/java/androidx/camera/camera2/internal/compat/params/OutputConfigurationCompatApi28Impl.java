package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class OutputConfigurationCompatApi28Impl extends OutputConfigurationCompatApi26Impl {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class OutputConfigurationParamsApi28 {
        public long mDynamicRangeProfile = 1;
        public final OutputConfiguration mOutputConfiguration;

        public OutputConfigurationParamsApi28(OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi28)) {
                return false;
            }
            OutputConfigurationParamsApi28 outputConfigurationParamsApi28 = (OutputConfigurationParamsApi28) obj;
            return Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi28.mOutputConfiguration) && this.mDynamicRangeProfile == outputConfigurationParamsApi28.mDynamicRangeProfile;
        }

        public final int hashCode() {
            int iHashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            long j = this.mDynamicRangeProfile;
            return ((int) (j ^ (j >>> 32))) ^ i;
        }
    }

    public OutputConfigurationCompatApi28Impl(int i, Surface surface) {
        super(new OutputConfigurationParamsApi28(new OutputConfiguration(i, surface)));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public Object getOutputConfiguration() {
        Object obj = this.mObject;
        Preconditions.checkArgument(obj instanceof OutputConfigurationParamsApi28);
        return ((OutputConfigurationParamsApi28) obj).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final String getPhysicalCameraId() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile = j;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final void setPhysicalCameraId(String str) {
        ((OutputConfiguration) getOutputConfiguration()).setPhysicalCameraId(str);
    }
}
