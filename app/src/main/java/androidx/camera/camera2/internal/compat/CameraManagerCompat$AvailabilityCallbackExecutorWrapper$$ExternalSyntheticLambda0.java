package androidx.camera.camera2.internal.compat;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ CameraManagerCompat$AvailabilityCallbackExecutorWrapper$$ExternalSyntheticLambda0(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = availabilityCallbackExecutorWrapper;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.mWrappedCallback.onCameraAvailable(this.f$1);
                break;
            default:
                this.f$0.mWrappedCallback.onCameraUnavailable(this.f$1);
                break;
        }
    }
}
