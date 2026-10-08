package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$slideInHorizontally$2 extends Lambda implements Function1 {
    public final /* synthetic */ Function1 $initialOffsetX;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EnterExitTransitionKt$slideInHorizontally$2(Function1 function1, int i) {
        super(1);
        this.$r8$classId = i;
        this.$initialOffsetX = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return new IntOffset((((long) ((Number) this.$initialOffsetX.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
            default:
                return new IntOffset((((long) ((Number) this.$initialOffsetX.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
        }
    }
}
