package kotlin.comparisons;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.navigation.compose.NavHostControllerKt$NavControllerSaver$2;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComparisonsKt__ComparisonsKt {
    public static int compareValues(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static ChainingListenableFuture getInstance(Context context) {
        CallbackToFutureAdapter.SafeFuture future;
        ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
        synchronized (processCameraProvider.mLock) {
            future = processCameraProvider.mCameraXInitializeFuture;
            if (future == null) {
                future = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(10, processCameraProvider, new CameraX(context)));
                processCameraProvider.mCameraXInitializeFuture = future;
            }
        }
        OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(11, new NavHostControllerKt$NavControllerSaver$2(context, 1));
        return Futures.transformAsync(future, new PreviewView.AnonymousClass1(18, onBackPressedDispatcher$$ExternalSyntheticLambda0), SetsKt.directExecutor());
    }
}
