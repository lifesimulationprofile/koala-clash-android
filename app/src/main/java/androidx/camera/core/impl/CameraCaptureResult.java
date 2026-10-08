package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraCaptureResult {
    CameraCaptureMetaData$AeState getAeState();

    CameraCaptureMetaData$AfState getAfState();

    CameraCaptureMetaData$AwbState getAwbState();

    CaptureResult getCaptureResult();

    TagBundle getTagBundle();

    long getTimestamp();
}
