package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzv extends zzp {
    public final /* synthetic */ zzw zza;

    public zzv(zzw zzwVar) {
        this.zza = zzwVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzw zzwVar = this.zza;
        zzf.zza(i, zzwVar.zzc);
        Object[] objArr = zzwVar.zzb;
        int i2 = i + i;
        Object obj = objArr[i2];
        obj.getClass();
        Object obj2 = objArr[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
