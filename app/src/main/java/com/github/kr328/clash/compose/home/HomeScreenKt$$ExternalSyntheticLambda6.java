package com.github.kr328.clash.compose.home;

import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda6(int i, int i2, Object obj, boolean z) {
        this.$r8$classId = i2;
        this.f$0 = z;
        this.f$1 = obj;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$2 | 1);
                HomeScreenKt.ConnectionTimer(this.f$0, (Long) this.f$1, (GapComposer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$2 | 1);
                PredictiveBackHandlerKt.PredictiveBackHandler(this.f$0, (Function2) this.f$1, (GapComposer) obj, iUpdateChangedFlags2);
                break;
        }
        return Unit.INSTANCE;
    }
}
