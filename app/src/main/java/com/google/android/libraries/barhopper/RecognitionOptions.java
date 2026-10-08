package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
@UsedByNative("jni_common.cc")
public class RecognitionOptions {

    @UsedByNative("jni_common.cc")
    private int barcodeFormats = 0;

    @UsedByNative("jni_common.cc")
    private boolean outputUnrecognizedBarcodes = false;

    @UsedByNative("jni_common.cc")
    private boolean useQrMobilenetV3 = false;

    @UsedByNative("jni_common.cc")
    private boolean enableQrAlignmentGrid = true;

    @UsedByNative("jni_common.cc")
    private boolean enableUseKeypointAsFinderPattern = true;

    @UsedByNative("jni_common.cc")
    private boolean useHalideAffineCrop = false;

    @UsedByNative("jni_common.cc")
    private MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();

    @UsedByNative("jni_common.cc")
    private MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();

    @UsedByNative("jni_common.cc")
    private OnedRecognitionOptions onedRecognitionOptions = new OnedRecognitionOptions();

    @UsedByNative("jni_common.cc")
    private boolean qrEnableFourthCornerApproximation = false;

    public final void setBarcodeFormats(int i) {
        this.barcodeFormats = i;
    }

    public final void setEnableQrAlignmentGrid() {
        this.enableQrAlignmentGrid = true;
    }

    public final void setEnableUseKeypointAsFinderPattern() {
        this.enableUseKeypointAsFinderPattern = true;
    }

    public final void setMultiScaleDecodingOptions(MultiScaleDecodingOptions multiScaleDecodingOptions) {
        this.multiScaleDecodingOptions = multiScaleDecodingOptions;
    }

    public final void setMultiScaleDetectionOptions(MultiScaleDetectionOptions multiScaleDetectionOptions) {
        this.multiScaleDetectionOptions = multiScaleDetectionOptions;
    }

    public final void setOutputUnrecognizedBarcodes(boolean z) {
        this.outputUnrecognizedBarcodes = z;
    }

    public final void setQrEnableFourthCornerApproximation(boolean z) {
        this.qrEnableFourthCornerApproximation = z;
    }
}
