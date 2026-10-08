package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeEffectNode$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ LayoutNodeDrawScope f$0;

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda2(LayoutNodeDrawScope layoutNodeDrawScope) {
        this.f$0 = layoutNodeDrawScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        switch (this.$r8$classId) {
            case 0:
                HazeKt.drawContentSafely(this.f$0);
                break;
            default:
                HazeKt.drawContentSafely(this.f$0);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda2(LayoutNodeDrawScope layoutNodeDrawScope, GraphicsLayer graphicsLayer) {
        this.f$0 = layoutNodeDrawScope;
    }
}
