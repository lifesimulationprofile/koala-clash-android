package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl$takeFocus$1 extends Lambda implements Function1 {
    public final /* synthetic */ int $focusDirection;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusOwnerImpl$takeFocus$1(int i, int i2) {
        super(1);
        this.$r8$classId = i2;
        this.$focusDirection = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return Boolean.valueOf(((FocusTargetNode) obj).m350requestFocus3ESFkO8(this.$focusDirection));
    }
}
