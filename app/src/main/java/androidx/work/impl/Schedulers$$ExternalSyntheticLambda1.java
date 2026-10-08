package androidx.work.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.camera.view.TextureViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Schedulers$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.f$0;
                WorkGenerationalId workGenerationalId = (WorkGenerationalId) this.f$1;
                Configuration configuration = (Configuration) this.f$2;
                WorkDatabase workDatabase = (WorkDatabase) this.f$3;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Scheduler) it.next()).cancel(workGenerationalId.workSpecId);
                }
                Schedulers.schedule(configuration, workDatabase, list);
                break;
            case 1:
                CameraBurstCaptureCallback cameraBurstCaptureCallback = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback.mCallbackMap).onCaptureCompleted((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (TotalCaptureResult) this.f$3);
                break;
            case 2:
                CameraBurstCaptureCallback cameraBurstCaptureCallback2 = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback2.mCallbackMap).onCaptureProgressed((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (CaptureResult) this.f$3);
                break;
            case 3:
                CameraBurstCaptureCallback cameraBurstCaptureCallback3 = (CameraBurstCaptureCallback) this.f$0;
                ((CameraCaptureSession.CaptureCallback) cameraBurstCaptureCallback3.mCallbackMap).onCaptureFailed((CameraCaptureSession) this.f$1, (CaptureRequest) this.f$2, (CaptureFailure) this.f$3);
                break;
            default:
                TextureViewImplementation textureViewImplementation = (TextureViewImplementation) this.f$0;
                Surface surface = (Surface) this.f$1;
                CallbackToFutureAdapter.SafeFuture safeFuture = (CallbackToFutureAdapter.SafeFuture) this.f$2;
                SurfaceRequest surfaceRequest = (SurfaceRequest) this.f$3;
                LazyKt__LazyJVMKt.d("TextureViewImpl", "Safe to release surface.");
                PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2 = textureViewImplementation.mOnSurfaceNotInUseListener;
                if (previewView$1$$ExternalSyntheticLambda2 != null) {
                    previewView$1$$ExternalSyntheticLambda2.onSurfaceNotInUse();
                    textureViewImplementation.mOnSurfaceNotInUseListener = null;
                }
                surface.release();
                if (textureViewImplementation.mSurfaceReleaseFuture == safeFuture) {
                    textureViewImplementation.mSurfaceReleaseFuture = null;
                }
                if (textureViewImplementation.mSurfaceRequest == surfaceRequest) {
                    textureViewImplementation.mSurfaceRequest = null;
                }
                break;
        }
    }
}
