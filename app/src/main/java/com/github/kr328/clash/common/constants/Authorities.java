package com.github.kr328.clash.common.constants;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.common.util.GlobalKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Authorities {
    public static final String FILES_PROVIDER;
    public static final String SETTINGS_PROVIDER;
    public static final String STATUS_PROVIDER;

    static {
        String str = GlobalKt.packageName;
        STATUS_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".status");
        SETTINGS_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".settings");
        FILES_PROVIDER = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".files");
    }
}
