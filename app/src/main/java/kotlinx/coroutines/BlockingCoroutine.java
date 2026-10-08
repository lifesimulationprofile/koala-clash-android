package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BlockingCoroutine extends AbstractCoroutine {
    public final Thread blockedThread;
    public final EventLoopImplPlatform eventLoop;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoopImplPlatform eventLoopImplPlatform) {
        super(coroutineContext, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoopImplPlatform;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.blockedThread;
        if (Intrinsics.areEqual(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
