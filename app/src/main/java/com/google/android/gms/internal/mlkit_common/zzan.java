package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzan extends zzaj {
    public final transient zzaq zza;
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzan(zzaq zzaqVar, Object[] objArr, int i) {
        this.zza = zzaqVar;
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzaf zzamVar = super.zza;
        if (zzamVar == null) {
            zzamVar = new zzam(this);
            super.zza = zzamVar;
        }
        return zzamVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int zza(Object[] objArr) {
        zzaf zzamVar = super.zza;
        if (zzamVar == null) {
            zzamVar = new zzam(this);
            super.zza = zzamVar;
        }
        return zzamVar.zza(objArr);
    }
}
