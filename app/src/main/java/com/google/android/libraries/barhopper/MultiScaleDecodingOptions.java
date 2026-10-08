package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
@UsedByNative("jni_common.cc")
public final class MultiScaleDecodingOptions {

    @UsedByNative("jni_common.cc")
    private float[] extraScales = new float[0];

    @UsedByNative("jni_common.cc")
    private int minimumDetectedDimension = 10;

    @UsedByNative("jni_common.cc")
    private boolean skipProcessingIfBarcodeFound = true;

    public final void setExtraScales(float[] fArr) {
        this.extraScales = fArr;
    }

    public final void setMinimumDetectedDimension(int i) {
        this.minimumDetectedDimension = i;
    }

    public final void setSkipProcessingIfBarcodeFound(boolean z) {
        this.skipProcessingIfBarcodeFound = z;
    }
}
