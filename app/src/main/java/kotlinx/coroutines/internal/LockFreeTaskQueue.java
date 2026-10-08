package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class LockFreeTaskQueue {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _cur$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new LockFreeTaskQueueCore(8, false);

    public final boolean addLast(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int iAddLast = lockFreeTaskQueueCore.addLast(runnable);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
                }
            } else if (iAddLast == 2) {
                return false;
            }
        }
    }

    public final void close() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore.close()) {
                return;
            }
            LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
            }
        }
    }

    public final int getSize() {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) _cur$volatile$FU.get(this);
        lockFreeTaskQueueCore.getClass();
        long j = LockFreeTaskQueueCore._state$volatile$FU.get(lockFreeTaskQueueCore);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object removeFirstOrNull() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            Object objRemoveFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
            if (objRemoveFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return objRemoveFirstOrNull;
            }
            LockFreeTaskQueueCore next = lockFreeTaskQueueCore.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeTaskQueueCore, next) && atomicReferenceFieldUpdater.get(this) == lockFreeTaskQueueCore) {
            }
        }
    }
}
