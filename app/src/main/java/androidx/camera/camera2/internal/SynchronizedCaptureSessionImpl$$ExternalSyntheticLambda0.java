package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.core.util.Preconditions;
import androidx.work.impl.StartStopTokens;
import com.caverock.androidsvg.SVGAndroidRenderer;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = synchronizedCaptureSessionImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.f$0;
                synchronizedCaptureSessionImpl.debugLog("Session call super.close()");
                Preconditions.checkNotNull(synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
                SVGAndroidRenderer sVGAndroidRenderer = synchronizedCaptureSessionImpl.mCaptureSessionRepository;
                synchronized (sVGAndroidRenderer.document) {
                    ((LinkedHashSet) sVGAndroidRenderer.stateStack).add(synchronizedCaptureSessionImpl);
                    break;
                }
                ((CameraCaptureSession) ((StartStopTokens) synchronizedCaptureSessionImpl.mCameraCaptureSessionCompat.this$0).runs).close();
                synchronizedCaptureSessionImpl.mExecutor.execute(new SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(synchronizedCaptureSessionImpl, 1));
                return;
            default:
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = this.f$0;
                synchronizedCaptureSessionImpl2.onSessionFinished(synchronizedCaptureSessionImpl2);
                return;
        }
    }
}
