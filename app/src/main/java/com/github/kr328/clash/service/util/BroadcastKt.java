package com.github.kr328.clash.service.util;

import android.content.Context;
import android.content.Intent;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.constants.Permissions;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BroadcastKt {
    public static final void sendBroadcastSelf(Context context, Intent intent) {
        Intent intent2 = intent.setPackage(context.getPackageName());
        String str = Permissions.RECEIVE_SELF_BROADCASTS;
        context.sendBroadcast(intent2, Permissions.RECEIVE_SELF_BROADCASTS);
    }

    public static final void sendProfileChanged(Context context, UUID uuid) {
        String str = Intents.ACTION_START_CLASH;
        sendBroadcastSelf(context, new Intent(Intents.ACTION_PROFILE_CHANGED).putExtra("uuid", uuid.toString()));
    }

    public static final void sendProfileUpdateFailed(Context context, UUID uuid, String str) {
        sendBroadcastSelf(context, new Intent(Intents.ACTION_PROFILE_UPDATE_FAILED).putExtra("uuid", uuid.toString()).putExtra("fail_reason", str));
    }
}
