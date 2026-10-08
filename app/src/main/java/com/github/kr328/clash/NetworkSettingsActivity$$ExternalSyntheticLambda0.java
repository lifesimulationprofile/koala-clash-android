package com.github.kr328.clash;

import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.store.ServiceStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NetworkSettingsActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NetworkSettingsActivity f$0;

    public /* synthetic */ NetworkSettingsActivity$$ExternalSyntheticLambda0(NetworkSettingsActivity networkSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = networkSettingsActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        NetworkSettingsActivity networkSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = NetworkSettingsActivity.$r8$clinit;
                return new UiStore(networkSettingsActivity);
            case 1:
                int i3 = NetworkSettingsActivity.$r8$clinit;
                return new ServiceStore(networkSettingsActivity);
            case 2:
                networkSettingsActivity.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(AccessControlActivity.class)));
                return Unit.INSTANCE;
            default:
                networkSettingsActivity.finish();
                return Unit.INSTANCE;
        }
    }
}
