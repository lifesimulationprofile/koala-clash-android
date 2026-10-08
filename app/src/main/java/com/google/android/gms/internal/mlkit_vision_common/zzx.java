package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzx extends zzs {
    public final transient zzz zza;
    public final transient zzy zzb;

    public zzx(zzz zzzVar, zzy zzyVar) {
        this.zza = zzzVar;
        this.zzb = zzyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        this.zza.getClass();
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zza(Object[] objArr) {
        return this.zzb.zza(objArr);
    }
}
