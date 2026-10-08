package com.github.kr328.clash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.service.StatusProvider;
import com.github.kr328.clash.util.ClashKt;
import kotlin.io.FilesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RestartReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 798292259) {
                if (iHashCode != 1737074039 || !action.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
                    return;
                }
            } else if (!action.equals("android.intent.action.BOOT_COMPLETED")) {
                return;
            }
            boolean z = StatusProvider.serviceRunning;
            Global.INSTANCE.getClass();
            if (FilesKt.resolve(Global.getApplication$1().getFilesDir(), "service_running.lock").exists()) {
                ClashKt.startClashService(context);
            }
        }
    }
}
