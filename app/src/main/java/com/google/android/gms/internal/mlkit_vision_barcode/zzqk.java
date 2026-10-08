package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.work.impl.WorkLauncherImpl;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqk {
    public final zzqi zza;
    public final Integer zzb;

    public /* synthetic */ zzqk(WorkLauncherImpl workLauncherImpl) {
        this.zza = (zzqi) workLauncherImpl.processor;
        this.zzb = (Integer) workLauncherImpl.workTaskExecutor;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqkVar = (zzqk) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zza, zzqkVar.zza) && com.google.android.gms.common.internal.zzah.equal(this.zzb, zzqkVar.zzb) && com.google.android.gms.common.internal.zzah.equal(null, null) && com.google.android.gms.common.internal.zzah.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, null, null});
    }
}
