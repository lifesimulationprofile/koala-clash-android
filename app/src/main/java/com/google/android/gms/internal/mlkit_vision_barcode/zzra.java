package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum zzra implements zzfc {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("TYPE_UNKNOWN"),
    zzb("TYPE_THIN"),
    zzc("TYPE_THICK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF33("TYPE_GMV");

    public final int zzf;

    zzra(String str) {
        this.zzf = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzf;
    }
}
