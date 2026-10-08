package coil;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(RealImageLoader realImageLoader) {
        Job.Key key = Job.Key.$$INSTANCE$1;
        this.this$0 = realImageLoader;
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(Throwable th, CoroutineContext coroutineContext) {
        this.this$0.getClass();
    }
}
