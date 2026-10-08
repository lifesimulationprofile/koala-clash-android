package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.github.kr328.clash.remote.StatusClient;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Wrappers {
    public static final Wrappers zza;
    public StatusClient zzb;

    static {
        Wrappers wrappers = new Wrappers();
        wrappers.zzb = null;
        zza = wrappers;
    }

    public static StatusClient packageManager(Context context) {
        StatusClient statusClient;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    wrappers.zzb = new StatusClient(context, false);
                }
                statusClient = wrappers.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return statusClient;
    }
}
