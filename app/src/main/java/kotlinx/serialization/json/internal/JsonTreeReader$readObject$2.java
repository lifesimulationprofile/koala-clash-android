package kotlinx.serialization.json.internal;

import coil.memory.RealWeakMemoryCache;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {
    public DeepRecursiveScopeImpl L$0;
    public RealWeakMemoryCache L$1;
    public LinkedHashMap L$2;
    public String L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RealWeakMemoryCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(RealWeakMemoryCache realWeakMemoryCache, BaseContinuationImpl baseContinuationImpl) {
        super(baseContinuationImpl);
        this.this$0 = realWeakMemoryCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RealWeakMemoryCache.access$readObject(this.this$0, null, this);
    }
}
