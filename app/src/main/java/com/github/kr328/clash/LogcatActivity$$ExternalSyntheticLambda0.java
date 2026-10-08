package com.github.kr328.clash;

import com.github.kr328.clash.common.util.ComponentsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogcatActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LogcatActivity f$0;

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda0(LogcatActivity logcatActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = logcatActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        LogcatActivity logcatActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = LogcatActivity.$r8$clinit;
                logcatActivity.stopService(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatService.class)));
                logcatActivity.finish();
                break;
            case 1:
                int i3 = LogcatActivity.$r8$clinit;
                logcatActivity.finish();
                break;
            default:
                int i4 = LogcatActivity.$r8$clinit;
                logcatActivity.finish();
                break;
        }
        return Unit.INSTANCE;
    }
}
