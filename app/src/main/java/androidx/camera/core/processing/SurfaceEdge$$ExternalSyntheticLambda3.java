package androidx.camera.core.processing;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ SurfaceEdge f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda3(SurfaceEdge surfaceEdge, int i, int i2) {
        this.f$0 = surfaceEdge;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        SurfaceEdge surfaceEdge = this.f$0;
        int i = surfaceEdge.mRotationDegrees;
        int i2 = this.f$1;
        boolean z2 = true;
        if (i != i2) {
            surfaceEdge.mRotationDegrees = i2;
            z = true;
        } else {
            z = false;
        }
        int i3 = surfaceEdge.mTargetRotation;
        int i4 = this.f$2;
        if (i3 != i4) {
            surfaceEdge.mTargetRotation = i4;
        } else {
            z2 = z;
        }
        if (z2) {
            surfaceEdge.notifyTransformationInfoUpdate();
        }
    }
}
