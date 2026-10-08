package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum zzvw implements zzfc {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("UNRECOGNIZED"),
    zzb("CODE_128"),
    zzc("CODE_39"),
    zzd("CODE_93"),
    zze("CODABAR"),
    zzf("DATA_MATRIX"),
    zzg("EAN_13"),
    zzh("EAN_8"),
    zzi("ITF"),
    zzj("QR_CODE"),
    zzk("UPC_A"),
    zzl("UPC_E"),
    zzm("PDF417"),
    zzn("AZTEC"),
    /* JADX INFO: Fake field, exist only in values array */
    EF180("DATABAR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF197("TEZ_CODE");

    public final int zzr;

    zzvw(String str) {
        this.zzr = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzr;
    }
}
