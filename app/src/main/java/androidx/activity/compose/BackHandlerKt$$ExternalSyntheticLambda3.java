package androidx.activity.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda3(int i, int i2, Function0 function0, boolean z) {
        this.$r8$classId = i2;
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        Integer num = (Integer) obj2;
        switch (this.$r8$classId) {
            case 0:
                num.getClass();
                BackHandlerKt.BackHandler(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(this.f$2 | 1));
                break;
            default:
                num.intValue();
                ProxyScreenKt.GroupTestButton(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(this.f$2 | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
