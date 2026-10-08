package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcg extends zzbs {
    public final /* synthetic */ zzci zza;
    public final Object zzb;
    public int zzc;

    public zzcg(zzci zzciVar, int i) {
        this.zza = zzciVar;
        Object obj = zzci.zzd;
        this.zzb = zzciVar.zzB()[i];
        this.zzc = i;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzci zzciVar = this.zza;
        Map mapZzl = zzciVar.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzciVar.zzC()[i];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzci zzciVar = this.zza;
        Map mapZzl = zzciVar.zzl();
        Object obj2 = this.zzb;
        if (mapZzl != null) {
            return mapZzl.put(obj2, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzciVar.put(obj2, obj);
            return null;
        }
        Object obj3 = zzciVar.zzC()[i];
        zzciVar.zzC()[this.zzc] = obj;
        return obj3;
    }

    public final void zza() {
        int i = this.zzc;
        Object obj = this.zzb;
        zzci zzciVar = this.zza;
        if (i != -1 && i < zzciVar.size()) {
            if (com.google.android.gms.internal.mlkit_vision_common.zzlo.zza(obj, zzciVar.zzB()[this.zzc])) {
                return;
            }
        }
        Object obj2 = zzci.zzd;
        this.zzc = zzciVar.zzw(obj);
    }
}
