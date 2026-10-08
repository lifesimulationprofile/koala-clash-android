package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SupportedRepeatingSurfaceSize {
    public static final Size MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = new Size(320, 240);
    public static final CompareSizesByArea SIZE_COMPARATOR = new CompareSizesByArea(false);
    public final RepeatingStreamConstraintForVideoRecordingQuirk mQuirk = (RepeatingStreamConstraintForVideoRecordingQuirk) DeviceQuirks.sQuirks.get(RepeatingStreamConstraintForVideoRecordingQuirk.class);
}
