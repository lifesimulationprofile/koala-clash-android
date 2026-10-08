package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class OutputConfigurationParamsApi24 {
        public long mDynamicRangeProfile = 1;
        public boolean mIsShared;
        public final OutputConfiguration mOutputConfiguration;
        public String mPhysicalCameraId;

        public OutputConfigurationParamsApi24(OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi24)) {
                return false;
            }
            OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
            return Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi24.mOutputConfiguration) && this.mIsShared == outputConfigurationParamsApi24.mIsShared && this.mDynamicRangeProfile == outputConfigurationParamsApi24.mDynamicRangeProfile && Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi24.mPhysicalCameraId);
        }

        public final int hashCode() {
            int iHashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i = (this.mIsShared ? 1 : 0) ^ ((iHashCode << 5) - iHashCode);
            int i2 = (i << 5) - i;
            String str = this.mPhysicalCameraId;
            int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i2;
            int i3 = (iHashCode2 << 5) - iHashCode2;
            long j = this.mDynamicRangeProfile;
            return ((int) (j ^ (j >>> 32))) ^ i3;
        }
    }

    public OutputConfigurationCompatApi24Impl(int i, Surface surface) {
        super(new OutputConfigurationParamsApi24(new OutputConfiguration(i, surface)));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public Object getOutputConfiguration() {
        Object obj = this.mObject;
        Preconditions.checkArgument(obj instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) obj).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public final Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = j;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public void setPhysicalCameraId(String str) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = str;
    }
}
