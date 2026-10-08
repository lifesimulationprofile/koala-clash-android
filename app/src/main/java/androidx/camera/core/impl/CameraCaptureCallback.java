package androidx.camera.core.impl;

import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled(int i) {
    }

    public void onCaptureStarted(int i) {
    }

    public void onCaptureCompleted(int i, CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(int i, Path.Companion companion) {
    }
}
