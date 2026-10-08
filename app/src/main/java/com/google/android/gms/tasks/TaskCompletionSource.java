package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzah;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TaskCompletionSource {
    public final zzw zza = new zzw();

    public TaskCompletionSource() {
    }

    public final boolean trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (zzwVar.zza) {
            try {
                if (zzwVar.zzc) {
                    return false;
                }
                zzwVar.zzc = true;
                zzwVar.zzf = exc;
                zzwVar.zzb.zzb(zzwVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TaskCompletionSource(ConnectionPool connectionPool) {
        zzs zzsVar = new zzs(this);
        connectionPool.getClass();
        ((zzw) connectionPool.delegate).addOnSuccessListener(TaskExecutors.MAIN_THREAD, new ConnectionPool(10, zzsVar));
    }
}
