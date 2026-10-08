package androidx.camera.core.processing;

import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SurfaceEdge f$0;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda0(SurfaceEdge surfaceEdge, int i) {
        this.$r8$classId = i;
        this.f$0 = surfaceEdge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SetsKt.mainThreadExecutor().execute(new SurfaceEdge$$ExternalSyntheticLambda0(this.f$0, 1));
                break;
            default:
                SurfaceEdge surfaceEdge = this.f$0;
                if (!surfaceEdge.mIsClosed) {
                    surfaceEdge.invalidate();
                }
                break;
        }
    }
}
