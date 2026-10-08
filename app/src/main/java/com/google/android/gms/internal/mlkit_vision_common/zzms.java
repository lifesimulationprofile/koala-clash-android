package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_common.zzsr;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzms {
    public static zzsr zza;

    public static synchronized zzmj zza(zzma zzmaVar) {
        try {
            if (zza == null) {
                zza = new zzsr(2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzmj) zza.get(zzmaVar);
    }
}
