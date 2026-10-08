package androidx.camera.camera2.internal;

import com.caverock.androidsvg.SVGAndroidRenderer;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$1;

    public /* synthetic */ SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2, int i) {
        this.$r8$classId = i;
        this.f$0 = synchronizedCaptureSessionImpl;
        this.f$1 = synchronizedCaptureSessionImpl2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.f$1;
                Objects.requireNonNull(synchronizedCaptureSessionImpl.mCaptureSessionStateCallback);
                synchronizedCaptureSessionImpl.mCaptureSessionStateCallback.onSessionFinished(synchronizedCaptureSessionImpl2);
                return;
            default:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl3 = this.f$0;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl4 = this.f$1;
                SVGAndroidRenderer sVGAndroidRenderer = synchronizedCaptureSessionImpl3.mCaptureSessionRepository;
                synchronized (sVGAndroidRenderer.document) {
                    ((LinkedHashSet) sVGAndroidRenderer.state).remove(synchronizedCaptureSessionImpl3);
                    ((LinkedHashSet) sVGAndroidRenderer.stateStack).remove(synchronizedCaptureSessionImpl3);
                    break;
                }
                synchronizedCaptureSessionImpl3.onSessionFinished(synchronizedCaptureSessionImpl4);
                if (synchronizedCaptureSessionImpl3.mCameraCaptureSessionCompat != null) {
                    Objects.requireNonNull(synchronizedCaptureSessionImpl3.mCaptureSessionStateCallback);
                    synchronizedCaptureSessionImpl3.mCaptureSessionStateCallback.onClosed(synchronizedCaptureSessionImpl4);
                    return;
                } else {
                    LazyKt__LazyJVMKt.w("SyncCaptureSessionBase", "[" + synchronizedCaptureSessionImpl3 + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
                    return;
                }
        }
    }
}
