package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceRequest$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceRequest f$0;

    public /* synthetic */ SurfaceRequest$$ExternalSyntheticLambda4(SurfaceRequest surfaceRequest, int i) {
        this.$r8$classId = i;
        this.f$0 = surfaceRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.mSurfaceFuture.cancel(true);
                break;
            default:
                this.f$0.willNotProvideSurface();
                break;
        }
    }
}
