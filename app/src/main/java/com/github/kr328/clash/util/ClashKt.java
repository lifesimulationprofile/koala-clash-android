package com.github.kr328.clash.util;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.ClashService;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.util.BroadcastKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClashKt {
    public static final Intent startClashService(Context context) {
        UiStore uiStore = new UiStore(context);
        KProperty kProperty = UiStore.$$delegatedProperties[0];
        if (!((Boolean) uiStore.enableVpn$delegate.getValue()).booleanValue()) {
            Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ClashService.class));
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
                return null;
            }
            context.startService(intent);
            return null;
        }
        Intent intentPrepare = VpnService.prepare(context);
        if (intentPrepare != null) {
            return intentPrepare;
        }
        Intent intent2 = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(TunService.class));
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent2);
            return null;
        }
        context.startService(intent2);
        return null;
    }

    public static final void stopClashService(Context context) {
        String str = Intents.ACTION_START_CLASH;
        BroadcastKt.sendBroadcastSelf(context, new Intent(Intents.ACTION_CLASH_REQUEST_STOP));
    }
}
