package androidx.compose.foundation.gestures;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 extends ContinuationImpl {
    public MouseWheelScrollingLogic L$0;
    public Ref$ObjectRef L$1;
    public Ref$FloatRef L$2;
    public ScrollingLogic L$3;
    public Ref$ObjectRef L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MouseWheelScrollingLogic.access$dispatchMouseWheelScroll$waitNextScrollDelta(null, null, null, null, null, 0L, this);
    }
}
