package kotlin;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.Futures$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultKt {
    public static CallbackToFutureAdapter.SafeFuture surfaceListWithTimeout(ArrayList arrayList, SequentialExecutor sequentialExecutor, HandlerScheduledExecutorService handlerScheduledExecutorService) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(Futures.nonCancellationPropagating(((DeferrableSurface) obj).getSurface()));
        }
        return CallbackToFutureAdapter.getFuture(new PreviewView$1$$ExternalSyntheticLambda2(CallbackToFutureAdapter.getFuture(new Futures$$ExternalSyntheticLambda0(new ListFuture(new ArrayList(arrayList2), false, SetsKt.directExecutor()), handlerScheduledExecutorService, 5000L)), sequentialExecutor, arrayList));
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
