package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CameraCaptureSessionCompat$StateCallbackExecutorWrapper f$0;
    public final /* synthetic */ CameraCaptureSession f$1;

    public /* synthetic */ CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0(CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int i) {
        this.$r8$classId = i;
        this.f$0 = cameraCaptureSessionCompat$StateCallbackExecutorWrapper;
        this.f$1 = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.mWrappedCallback.onActive(this.f$1);
                break;
            case 1:
                this.f$0.mWrappedCallback.onClosed(this.f$1);
                break;
            case 2:
                this.f$0.mWrappedCallback.onCaptureQueueEmpty(this.f$1);
                break;
            case 3:
                this.f$0.mWrappedCallback.onConfigured(this.f$1);
                break;
            case 4:
                this.f$0.mWrappedCallback.onReady(this.f$1);
                break;
            default:
                this.f$0.mWrappedCallback.onConfigureFailed(this.f$1);
                break;
        }
    }
}
