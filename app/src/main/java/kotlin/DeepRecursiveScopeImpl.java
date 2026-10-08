package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DeepRecursiveScopeImpl implements Continuation {
    public Continuation cont;
    public JsonTreeReader$readDeepRecursive$1 function;
    public Object result;
    public Unit value;

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.cont = null;
        this.result = obj;
    }
}
