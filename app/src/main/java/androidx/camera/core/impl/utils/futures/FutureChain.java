package androidx.camera.core.impl.utils.futures;

import androidx.appcompat.widget.Toolbar;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class FutureChain implements ListenableFuture {
    public CallbackToFutureAdapter.Completer mCompleter;
    public final ListenableFuture mDelegate;

    public FutureChain(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.mDelegate = listenableFuture;
    }

    public static FutureChain from(ListenableFuture listenableFuture) {
        return listenableFuture instanceof FutureChain ? (FutureChain) listenableFuture : new FutureChain(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mDelegate.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.mDelegate.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.mDelegate.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.mDelegate.get(j, timeUnit);
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new Toolbar.AnonymousClass1(20, this));
    }
}
