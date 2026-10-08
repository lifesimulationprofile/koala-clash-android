package com.google.android.gms.tasks;

import androidx.work.Worker;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh implements zzq {
    public final Executor zza;
    public final Object zzc;
    public final /* synthetic */ int $r8$classId = 0;
    public final Object zzb = new Object();

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    private final void zzd$com$google$android$gms$tasks$zzh(zzw zzwVar) {
        if (zzwVar.zzd) {
            synchronized (this.zzb) {
            }
            this.zza.execute(new Worker.AnonymousClass1(24, this));
        }
    }

    private final void zzd$com$google$android$gms$tasks$zzj(zzw zzwVar) {
        synchronized (this.zzb) {
        }
        this.zza.execute(new Worker.AnonymousClass2(19, this, zzwVar, false));
    }

    private final void zzd$com$google$android$gms$tasks$zzl(zzw zzwVar) {
        if (zzwVar.isSuccessful() || zzwVar.zzd) {
            return;
        }
        synchronized (this.zzb) {
        }
        this.zza.execute(new Worker.AnonymousClass2(20, this, zzwVar, false));
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(zzw zzwVar) {
        switch (this.$r8$classId) {
            case 0:
                zzd$com$google$android$gms$tasks$zzh(zzwVar);
                return;
            case 1:
                zzd$com$google$android$gms$tasks$zzj(zzwVar);
                return;
            case 2:
                zzd$com$google$android$gms$tasks$zzl(zzwVar);
                return;
            default:
                if (zzwVar.isSuccessful()) {
                    synchronized (this.zzb) {
                        break;
                    }
                    this.zza.execute(new Worker.AnonymousClass2(21, this, zzwVar, false));
                    return;
                }
                return;
        }
    }

    public zzh(Executor executor, OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public zzh(Executor executor, OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public zzh(Executor executor, OnSuccessListener onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }
}
