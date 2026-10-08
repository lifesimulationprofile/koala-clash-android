package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface DynamicRangesCompat$DynamicRangeProfilesCompatImpl {
    Set getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange);

    Set getSupportedDynamicRanges();

    DynamicRangeProfiles unwrap();
}
