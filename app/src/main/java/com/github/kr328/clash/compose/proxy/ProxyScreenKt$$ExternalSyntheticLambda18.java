package com.github.kr328.clash.compose.proxy;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProxyScreenKt$$ExternalSyntheticLambda18 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ ProxyScreenKt$$ExternalSyntheticLambda18(MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.setValue(Boolean.TRUE);
                break;
            case 1:
                this.f$0.setValue(Boolean.FALSE);
                break;
            case 2:
                this.f$0.setValue(Boolean.TRUE);
                break;
            case 3:
                this.f$0.setValue(null);
                break;
            case 4:
                this.f$0.setValue(Boolean.FALSE);
                break;
            case 5:
                this.f$0.setValue(Boolean.FALSE);
                break;
            case 6:
                this.f$0.setValue(Boolean.TRUE);
                break;
            case 7:
                this.f$0.setValue(Boolean.TRUE);
                break;
            case 8:
                this.f$0.setValue(Boolean.FALSE);
                break;
            case 9:
                this.f$0.setValue(null);
                break;
            case 10:
                this.f$0.setValue(Boolean.TRUE);
                break;
            default:
                this.f$0.setValue(Boolean.FALSE);
                break;
        }
        return Unit.INSTANCE;
    }
}
