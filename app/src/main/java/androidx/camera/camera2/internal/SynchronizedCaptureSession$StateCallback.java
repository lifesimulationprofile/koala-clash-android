package androidx.camera.camera2.internal;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SynchronizedCaptureSession$StateCallback {
    public abstract void onConfigureFailed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onConfigured(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onReady(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public abstract void onSessionFinished(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl);

    public void onActive(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onClosed(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
    }

    public void onSurfacePrepared(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, Surface surface) {
    }
}
