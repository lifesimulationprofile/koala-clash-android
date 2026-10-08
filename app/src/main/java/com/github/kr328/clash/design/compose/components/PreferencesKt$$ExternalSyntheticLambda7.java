package com.github.kr328.clash.design.compose.components;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.google.android.gms.internal.mlkit_vision_common.zzkf;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreferencesKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Modifier f$1;

    public /* synthetic */ PreferencesKt$$ExternalSyntheticLambda7(String str, Modifier modifier, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = str;
        this.f$1 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                zzkf.PreferenceTip(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(1));
                break;
            default:
                zzkf.PreferenceCategory(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }
}
