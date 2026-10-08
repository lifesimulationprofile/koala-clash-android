package androidx.camera.camera2.internal;

import androidx.work.impl.StartStopTokens;
import coil.network.RealNetworkObserver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RealNetworkObserver f$0;

    public /* synthetic */ Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(RealNetworkObserver realNetworkObserver, int i) {
        this.$r8$classId = i;
        this.f$0 = realNetworkObserver;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                RealNetworkObserver realNetworkObserver = this.f$0;
                if (!((AtomicBoolean) realNetworkObserver.listener).getAndSet(true)) {
                    ((Camera2CameraImpl) ((StartStopTokens) realNetworkObserver.networkCallback).runs).mExecutor.execute(new Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(realNetworkObserver, 1));
                    break;
                }
                break;
            default:
                RealNetworkObserver realNetworkObserver2 = this.f$0;
                if (((Camera2CameraImpl) ((StartStopTokens) realNetworkObserver2.networkCallback).runs).mState == 8) {
                    ((Camera2CameraImpl) ((StartStopTokens) realNetworkObserver2.networkCallback).runs).debugLog("Camera onError timeout, reopen it.", null);
                    ((Camera2CameraImpl) ((StartStopTokens) realNetworkObserver2.networkCallback).runs).setState(7);
                    ((Camera2CameraImpl) ((StartStopTokens) realNetworkObserver2.networkCallback).runs).mStateCallback.scheduleCameraReopen();
                } else {
                    Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) ((StartStopTokens) realNetworkObserver2.networkCallback).runs;
                    camera2CameraImpl.debugLog("Camera skip reopen at state: ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf(camera2CameraImpl.mState)), null);
                }
                break;
        }
    }
}
