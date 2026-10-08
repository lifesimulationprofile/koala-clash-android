package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgk implements Iterator {
    public final /* synthetic */ zzgh zza;
    public int zzb = -1;
    public boolean zzc;
    public Iterator zzd;

    public /* synthetic */ zzgk(zzgh zzghVar) {
        this.zza = zzghVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzgh zzghVar = this.zza;
        if (i >= zzghVar.zzb) {
            return !zzghVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzgh zzghVar = this.zza;
        return i < zzghVar.zzb ? (zzgi) zzghVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        int i = zzgh.$r8$clinit;
        zzgh zzghVar = this.zza;
        zzghVar.zzo();
        int i2 = this.zzb;
        if (i2 >= zzghVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i2 - 1;
            zzghVar.zzm(i2);
        }
    }

    public final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }
}
