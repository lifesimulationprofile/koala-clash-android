package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode.zzbk;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfx extends com.google.android.gms.internal.mlkit_common.zzas {
    public final zzbk zza;
    public com.google.android.gms.internal.mlkit_common.zzas zzb;

    public zzfx(zzgd zzgdVar) {
        super(2);
        this.zza = new zzbk(zzgdVar);
        this.zzb = zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzas
    public final byte zza() {
        com.google.android.gms.internal.mlkit_common.zzas zzasVar = this.zzb;
        if (zzasVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzasVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }

    public final zzcy zzb() {
        zzbk zzbkVar = this.zza;
        if (zzbkVar.hasNext()) {
            return new zzcy(zzbkVar.zza());
        }
        return null;
    }
}
