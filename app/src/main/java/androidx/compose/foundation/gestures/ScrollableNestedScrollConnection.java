package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public boolean enabled;
    public final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public final Object mo96onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) throws Throwable {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long jM733minusAH228Gc;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            int i = scrollableNestedScrollConnection$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, (ContinuationImpl) continuation);
        }
        Object objM100doFlingAnimationQWom1Mo = scrollableNestedScrollConnection$onPostFling$1.result;
        int i2 = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM100doFlingAnimationQWom1Mo);
            jM733minusAH228Gc = 0;
            if (this.enabled) {
                ScrollingLogic scrollingLogic = this.scrollingLogic;
                if (!scrollingLogic.isFlinging) {
                    scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                    scrollableNestedScrollConnection$onPostFling$1.label = 1;
                    objM100doFlingAnimationQWom1Mo = scrollingLogic.m100doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objM100doFlingAnimationQWom1Mo == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                jM733minusAH228Gc = Velocity.m733minusAH228Gc(j2, jM733minusAH228Gc);
            }
            return new Velocity(jM733minusAH228Gc);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
        ResultKt.throwOnFailure(objM100doFlingAnimationQWom1Mo);
        jM733minusAH228Gc = ((Velocity) objM100doFlingAnimationQWom1Mo).packedValue;
        jM733minusAH228Gc = Velocity.m733minusAH228Gc(j2, jM733minusAH228Gc);
        return new Velocity(jM733minusAH228Gc);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public final long mo97onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.enabled) {
            return 0L;
        }
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        if (scrollingLogic.scrollableState.isScrollInProgress()) {
            return 0L;
        }
        return scrollingLogic.m105toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(scrollingLogic.scrollableState.dispatchRawDelta(scrollingLogic.reverseIfNeeded(scrollingLogic.m104toFloatk4lQ0M(j2)))));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final Object mo98onPreFlingQWom1Mo(long j, Continuation continuation) {
        return new Velocity(0L);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final /* synthetic */ long mo99onPreScrollOzD1aCk(int i, long j) {
        return 0L;
    }
}
