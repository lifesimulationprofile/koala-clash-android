package kotlinx.coroutines.internal;

import androidx.compose.runtime.TracingContext;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ThreadState {
    public final CoroutineContext context;
    public final TracingContext[] elements;
    public int i;
    public final Object[] values;

    public ThreadState(int i, CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.values = new Object[i];
        this.elements = new TracingContext[i];
    }
}
