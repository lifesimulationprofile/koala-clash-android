package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicRangesCompatBaseImpl implements DynamicRangesCompat$DynamicRangeProfilesCompatImpl {
    public static final Toolbar.AnonymousClass1 COMPAT_INSTANCE = new Toolbar.AnonymousClass1(10, new DynamicRangesCompatBaseImpl());
    public static final Set SDR_ONLY = Collections.singleton(DynamicRange.SDR);

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl
    public final Set getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        Preconditions.checkArgument("DynamicRange is not supported: " + dynamicRange, DynamicRange.SDR.equals(dynamicRange));
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl
    public final Set getSupportedDynamicRanges() {
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl
    public final DynamicRangeProfiles unwrap() {
        return null;
    }
}
