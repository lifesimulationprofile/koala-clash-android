package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehaviorKt$animateDecay$1 extends ContinuationImpl {
    public float F$0;
    public AnimationState L$0;
    public Ref$FloatRef L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CoroutineContext.Element.DefaultImpls.access$animateDecay(null, 0.0f, null, null, null, this);
    }
}
