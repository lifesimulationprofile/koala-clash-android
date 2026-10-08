package androidx.concurrent.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CallbackToFutureAdapter {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Completer {
        public boolean attemptedSetting;
        public ResolvableFuture cancellationFuture;
        public SafeFuture future;
        public Object tag;

        public final void finalize() {
            ResolvableFuture resolvableFuture;
            SafeFuture safeFuture = this.future;
            if (safeFuture != null) {
                SafeFuture.AnonymousClass1 anonymousClass1 = safeFuture.delegate;
                if (!anonymousClass1.isDone()) {
                    anonymousClass1.setException(new AbstractFuture.Failure.AnonymousClass1("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag, 2));
                }
            }
            if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
                return;
            }
            resolvableFuture.set(null);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001d  */
        public final boolean set(Object obj) {
            boolean z = true;
            this.attemptedSetting = true;
            SafeFuture safeFuture = this.future;
            if (safeFuture != null) {
                SafeFuture.AnonymousClass1 anonymousClass1 = safeFuture.delegate;
                anonymousClass1.getClass();
                if (obj == null) {
                    obj = AbstractResolvableFuture.NULL;
                }
                if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(anonymousClass1, null, obj)) {
                    AbstractResolvableFuture.complete(anonymousClass1);
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (z) {
                this.tag = null;
                this.future = null;
                this.cancellationFuture = null;
            }
            return z;
        }

        public final boolean setException(Throwable th) {
            this.attemptedSetting = true;
            SafeFuture safeFuture = this.future;
            boolean z = safeFuture != null && safeFuture.delegate.setException(th);
            if (z) {
                this.tag = null;
                this.future = null;
                this.cancellationFuture = null;
            }
            return z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface Resolver {
        Object attachCompleter(Completer completer);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SafeFuture implements ListenableFuture {
        public final WeakReference completerWeakReference;
        public final AnonymousClass1 delegate = new AbstractResolvableFuture() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public final String pendingToString() {
                Completer completer = (Completer) SafeFuture.this.completerWeakReference.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.tag + "]";
            }
        };

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1] */
        public SafeFuture(Completer completer) {
            this.completerWeakReference = new WeakReference(completer);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            Completer completer = (Completer) this.completerWeakReference.get();
            boolean zCancel = cancel(z);
            if (zCancel && completer != null) {
                completer.tag = null;
                completer.future = null;
                completer.cancellationFuture.set(null);
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            return get();
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.delegate.value instanceof AbstractResolvableFuture.Cancellation;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return isDone();
        }

        public final String toString() {
            return toString();
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return get(j, timeUnit);
        }
    }

    public static SafeFuture getFuture(Resolver resolver) {
        Completer completer = new Completer();
        completer.cancellationFuture = new ResolvableFuture();
        SafeFuture safeFuture = new SafeFuture(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        try {
            Object objAttachCompleter = resolver.attachCompleter(completer);
            if (objAttachCompleter == null) {
                return safeFuture;
            }
            completer.tag = objAttachCompleter;
            return safeFuture;
        } catch (Exception e) {
            safeFuture.delegate.setException(e);
            return safeFuture;
        }
    }
}
