package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureSession$$ExternalSyntheticLambda4 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CaptureSession f$0;

    public /* synthetic */ CaptureSession$$ExternalSyntheticLambda4(CaptureSession captureSession) {
        this.f$0 = captureSession;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        String str;
        CaptureSession captureSession = this.f$0;
        synchronized (captureSession.mSessionLock) {
            Preconditions.checkState("Release completer expected to be null", captureSession.mReleaseCompleter == null);
            captureSession.mReleaseCompleter = completer;
            str = "Release[session=" + captureSession + "]";
        }
        return str;
    }

    public void onCaptureSequenceCompletedOrAborted() {
        CaptureSession captureSession = this.f$0;
        synchronized (captureSession.mSessionLock) {
            try {
                if (captureSession.mState == 5) {
                    captureSession.issueRepeatingCaptureRequests(captureSession.mSessionConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
