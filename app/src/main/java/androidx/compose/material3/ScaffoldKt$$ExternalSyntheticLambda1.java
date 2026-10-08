package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScaffoldKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ ComposableLambdaImpl f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(int i, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, Function2 function4, WindowInsets windowInsets, Function2 function5, int i2) {
        this.f$0 = i;
        this.f$1 = function2;
        this.f$2 = composableLambdaImpl;
        this.f$3 = function3;
        this.f$4 = function4;
        this.f$5 = windowInsets;
        this.f$6 = function5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Function2 function2 = (Function2) this.f$1;
                Function2 function3 = (Function2) this.f$3;
                Function2 function4 = (Function2) this.f$4;
                MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) this.f$5;
                Function2 function5 = (Function2) this.f$6;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ScaffoldKt.m261ScaffoldLayoutFMILGgc(this.f$0, function2, this.f$2, function3, function4, mutableWindowInsets, function5, gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                ScaffoldKt.m261ScaffoldLayoutFMILGgc(this.f$0, (Function2) this.f$1, this.f$2, (Function2) this.f$3, (Function2) this.f$4, (WindowInsets) this.f$5, (Function2) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                this.f$2.invoke(this.f$1, (Boolean) this.f$3, this.f$4, this.f$6, this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$0) | 1);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(int i, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, Function2 function4, MutableWindowInsets mutableWindowInsets, Function2 function5) {
        this.f$0 = i;
        this.f$1 = function2;
        this.f$2 = composableLambdaImpl;
        this.f$3 = function3;
        this.f$4 = function4;
        this.f$5 = mutableWindowInsets;
        this.f$6 = function5;
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, int i) {
        this.f$2 = composableLambdaImpl;
        this.f$1 = obj;
        this.f$3 = bool;
        this.f$4 = obj2;
        this.f$6 = obj3;
        this.f$5 = obj4;
        this.f$0 = i;
    }
}
