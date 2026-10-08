package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LimitedDispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements CoroutineContext.Element {
    public CoroutineDispatcher() {
        super(ContinuationInterceptor$Key.$$INSTANCE);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        InlineList.safeDispatch(this, coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        if (!(key instanceof AbstractCoroutineContextKey)) {
            if (ContinuationInterceptor$Key.$$INSTANCE == key) {
                return this;
            }
            return null;
        }
        if (this.key != ((AbstractCoroutineContextKey) key)) {
            return null;
        }
        throw null;
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !(this instanceof Unconfined);
    }

    public CoroutineDispatcher limitedParallelism(int i) {
        InlineList.checkParallelism(i);
        return new LimitedDispatcher(this, i);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return ContinuationInterceptor$Key.$$INSTANCE == key ? EmptyCoroutineContext.INSTANCE : this;
        }
        if (this.key != ((AbstractCoroutineContextKey) key)) {
            return this;
        }
        throw null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + JobKt.getHexAddress(this);
    }
}
