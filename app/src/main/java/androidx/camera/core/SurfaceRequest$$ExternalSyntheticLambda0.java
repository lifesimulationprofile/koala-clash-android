package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceRequest$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f$0;
    public final /* synthetic */ AutoValue_SurfaceRequest_TransformationInfo f$1;

    public /* synthetic */ SurfaceRequest$$ExternalSyntheticLambda0(SurfaceRequest.TransformationInfoListener transformationInfoListener, AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo, int i) {
        this.$r8$classId = i;
        this.f$0 = transformationInfoListener;
        this.f$1 = autoValue_SurfaceRequest_TransformationInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.onTransformationInfoUpdate(this.f$1);
                break;
            default:
                this.f$0.onTransformationInfoUpdate(this.f$1);
                break;
        }
    }
}
