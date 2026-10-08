package kotlinx.serialization.json.internal;

import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3 {
    public /* synthetic */ DeepRecursiveScopeImpl L$0;
    public int label;
    public final /* synthetic */ RealWeakMemoryCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(RealWeakMemoryCache realWeakMemoryCache, Continuation continuation) {
        super(3, continuation);
        this.this$0 = realWeakMemoryCache;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, (Continuation) obj3);
        jsonTreeReader$readDeepRecursive$1.L$0 = (DeepRecursiveScopeImpl) obj;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RealWeakMemoryCache realWeakMemoryCache = this.this$0;
        RoomOpenHelper roomOpenHelper = (RoomOpenHelper) realWeakMemoryCache.cache;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeepRecursiveScopeImpl deepRecursiveScopeImpl = this.L$0;
            byte bPeekNextToken = roomOpenHelper.peekNextToken();
            if (bPeekNextToken == 1) {
                return realWeakMemoryCache.readValue(true);
            }
            if (bPeekNextToken == 0) {
                return realWeakMemoryCache.readValue(false);
            }
            if (bPeekNextToken != 6) {
                if (bPeekNextToken == 8) {
                    return realWeakMemoryCache.readArray();
                }
                RoomOpenHelper.fail$default(roomOpenHelper, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.label = 1;
            obj = RealWeakMemoryCache.access$readObject(realWeakMemoryCache, deepRecursiveScopeImpl, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (JsonElement) obj;
    }
}
