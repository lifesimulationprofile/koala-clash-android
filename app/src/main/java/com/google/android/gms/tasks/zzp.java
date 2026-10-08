package com.google.android.gms.tasks;

import androidx.work.Worker;
import com.google.mlkit.common.internal.zzd;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzp implements OnSuccessListener, OnFailureListener, OnCanceledListener, zzq {
    public final Executor zza;
    public final zzw zzc;

    public zzp(Executor executor, zzd zzdVar, zzw zzwVar) {
        this.zza = executor;
        this.zzc = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.zzc.zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(zzw zzwVar) {
        this.zza.execute(new Worker.AnonymousClass2(22, this, zzwVar, false));
    }
}
