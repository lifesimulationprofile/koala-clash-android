package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class LowMemoryQuirk implements Quirk {
    public static final HashSet DEVICE_MODELS = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));
}
