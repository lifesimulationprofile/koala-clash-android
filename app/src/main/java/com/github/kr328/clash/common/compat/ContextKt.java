package com.github.kr328.clash.common.compat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextKt {
    public static final Intent registerReceiverCompat(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, null, str == null ? 2 : 4);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, null);
    }
}
