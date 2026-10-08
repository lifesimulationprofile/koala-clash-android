package com.github.kr328.clash.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjm;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogsScreenKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ LogsScreenKt$$ExternalSyntheticLambda5(Function0 function0, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                LogsScreenKt.LogcatRow(this.f$0, gapComposer, Stack.updateChangedFlags(1));
                break;
            case 1:
                HomeScreenKt.AddProfilePillButton(this.f$0, gapComposer, Stack.updateChangedFlags(1));
                break;
            default:
                zzjm.NewProfileSheet(this.f$0, gapComposer, Stack.updateChangedFlags(7));
                break;
        }
        return Unit.INSTANCE;
    }
}
