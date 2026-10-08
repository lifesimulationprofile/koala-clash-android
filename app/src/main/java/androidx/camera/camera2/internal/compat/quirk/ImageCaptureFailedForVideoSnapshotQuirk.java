package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class ImageCaptureFailedForVideoSnapshotQuirk implements Quirk {
    public static final HashSet PROBLEMATIC_UNI_SOC_MODELS = new HashSet(Arrays.asList("itel l6006", "itel w6004", "moto g(20)", "moto e13", "moto e20", "rmx3231", "rmx3511", "sm-a032f", "sm-a035m", "tecno mobile bf6"));
}
