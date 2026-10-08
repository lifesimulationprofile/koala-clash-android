package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Executor {
    public static final zzh zza;
    public static final /* synthetic */ zzh[] zzb;

    static {
        zzh zzhVar = new zzh("INSTANCE", 0);
        zza = zzhVar;
        zzb = new zzh[]{zzhVar};
    }

    public static zzh[] values() {
        return (zzh[]) zzb.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
