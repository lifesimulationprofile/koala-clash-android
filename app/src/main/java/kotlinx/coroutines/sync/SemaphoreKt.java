package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemaphoreKt {
    public static final int MAX_SPIN_CYCLES = InlineList.systemProp$default(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");
    public static final Symbol PERMIT = new Symbol("PERMIT", 0);
    public static final Symbol TAKEN = new Symbol("TAKEN", 0);
    public static final Symbol BROKEN = new Symbol("BROKEN", 0);
    public static final Symbol CANCELLED = new Symbol("CANCELLED", 0);
    public static final int SEGMENT_SIZE = InlineList.systemProp$default(16, 12, "kotlinx.coroutines.semaphore.segmentSize");
}
