package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ long J$0;
    public long J$1;
    public int label;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).packedValue;
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j = ((Velocity) obj).packedValue;
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, (Continuation) obj2);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = j;
        return scrollingLogic$onScrollStopped$performFling$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.label;
        ScrollingLogic scrollingLogic = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = this.J$0;
            Request.Builder builder = scrollingLogic.nestedScrollDispatcher;
            this.J$0 = j;
            this.label = 1;
            obj = builder.m859dispatchPreFlingQWom1Mo(j, this);
            if (obj != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                j2 = this.J$1;
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
                j3 = ((Velocity) obj).packedValue;
                Request.Builder builder2 = scrollingLogic.nestedScrollDispatcher;
                long jM733minusAH228Gc = Velocity.m733minusAH228Gc(j2, j3);
                this.J$0 = j;
                this.J$1 = j3;
                this.label = 3;
                obj = builder2.m858dispatchPostFlingRZ2iAVY(jM733minusAH228Gc, j3, this);
                if (obj != coroutineSingletons) {
                    j4 = j;
                    j5 = j3;
                }
                return coroutineSingletons;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j5 = this.J$1;
            j4 = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Velocity(Velocity.m733minusAH228Gc(j4, Velocity.m733minusAH228Gc(j5, ((Velocity) obj).packedValue)));
        long jM733minusAH228Gc2 = Velocity.m733minusAH228Gc(j, ((Velocity) obj).packedValue);
        this.J$0 = j;
        this.J$1 = jM733minusAH228Gc2;
        this.label = 2;
        obj = scrollingLogic.m100doFlingAnimationQWom1Mo(jM733minusAH228Gc2, this);
        if (obj != coroutineSingletons) {
            j2 = jM733minusAH228Gc2;
            j3 = ((Velocity) obj).packedValue;
            Request.Builder builder3 = scrollingLogic.nestedScrollDispatcher;
            long jM733minusAH228Gc3 = Velocity.m733minusAH228Gc(j2, j3);
            this.J$0 = j;
            this.J$1 = j3;
            this.label = 3;
            obj = builder3.m858dispatchPostFlingRZ2iAVY(jM733minusAH228Gc3, j3, this);
            if (obj != coroutineSingletons) {
                j4 = j;
                j5 = j3;
                return new Velocity(Velocity.m733minusAH228Gc(j4, Velocity.m733minusAH228Gc(j5, ((Velocity) obj).packedValue)));
            }
        }
        return coroutineSingletons;
    }
}
