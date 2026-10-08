package dev.chrisbanes.haze;

import androidx.compose.runtime.snapshots.StateSetIterator;
import androidx.compose.ui.node.HitTestResultKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeEffectNode$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ HazeSourceNode f$1;

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda3(HazeEffectNode hazeEffectNode, HazeSourceNode hazeSourceNode) {
        this.f$1 = hazeSourceNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(this.f$1 == null || ((HazeArea) obj).zIndex$delegate.getFloatValue() < 0.0f);
            default:
                ((Long) obj).longValue();
                Iterator it = this.f$1.area.preDrawListeners.iterator();
                while (true) {
                    StateSetIterator stateSetIterator = (StateSetIterator) it;
                    if (!stateSetIterator.hasNext()) {
                        return Unit.INSTANCE;
                    }
                    HitTestResultKt.invalidateDraw(((HazeEffectNode$areaPreDrawListener$2$1) stateSetIterator.next()).$tmp0);
                }
                break;
        }
    }

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda3(HazeSourceNode hazeSourceNode) {
        this.f$1 = hazeSourceNode;
    }
}
