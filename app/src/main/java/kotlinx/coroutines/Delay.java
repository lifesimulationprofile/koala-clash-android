package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Delay {
    DisposableHandle invokeOnTimeout(long j, TimeoutCoroutine timeoutCoroutine, CoroutineContext coroutineContext);

    void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl);
}
