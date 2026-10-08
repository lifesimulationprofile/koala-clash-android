package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SettableFuture extends AbstractFuture {
    public final boolean set(Object obj) {
        if (obj == null) {
            obj = AbstractFuture.NULL;
        }
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, obj)) {
            return false;
        }
        AbstractFuture.complete(this);
        return true;
    }

    public final boolean setException(Throwable th) {
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, new AbstractFuture.Failure(th))) {
            return false;
        }
        AbstractFuture.complete(this);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    public final boolean setFuture(ListenableFuture listenableFuture) {
        AbstractFuture.Failure failure;
        listenableFuture.getClass();
        Object obj = this.value;
        if (obj != null) {
            if (obj instanceof AbstractFuture.Cancellation) {
                listenableFuture.cancel(((AbstractFuture.Cancellation) obj).wasInterrupted);
            }
        } else if (listenableFuture.isDone()) {
            if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, AbstractFuture.getFutureValue(listenableFuture))) {
                AbstractFuture.complete(this);
                return true;
            }
        } else {
            AbstractFuture.SetFuture setFuture = new AbstractFuture.SetFuture(this, listenableFuture);
            if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                    return true;
                } catch (Throwable th) {
                    try {
                        failure = new AbstractFuture.Failure(th);
                    } catch (Throwable unused) {
                        failure = AbstractFuture.Failure.FALLBACK_INSTANCE;
                    }
                    AbstractFuture.ATOMIC_HELPER.casValue(this, setFuture, failure);
                    return true;
                }
            }
            obj = this.value;
            if (obj instanceof AbstractFuture.Cancellation) {
                listenableFuture.cancel(((AbstractFuture.Cancellation) obj).wasInterrupted);
            }
        }
        return false;
    }
}
