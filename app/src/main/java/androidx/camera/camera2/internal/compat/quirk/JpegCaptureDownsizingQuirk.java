package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class JpegCaptureDownsizingQuirk implements SoftwareJpegEncodingPreferredQuirk {
    public static final HashSet KNOWN_AFFECTED_FRONT_CAMERA_DEVICES = new HashSet(Arrays.asList("redmi note 8 pro"));
}
