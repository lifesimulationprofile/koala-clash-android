package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum zzrn implements zzfc {
    zza("FORMAT_UNKNOWN"),
    zzb("FORMAT_CODE_128"),
    zzc("FORMAT_CODE_39"),
    zzd("FORMAT_CODE_93"),
    zze("FORMAT_CODABAR"),
    zzf("FORMAT_DATA_MATRIX"),
    zzg("FORMAT_EAN_13"),
    zzh("FORMAT_EAN_8"),
    zzi("FORMAT_ITF"),
    zzj("FORMAT_QR_CODE"),
    zzk("FORMAT_UPC_A"),
    zzl("FORMAT_UPC_E"),
    zzm("FORMAT_PDF417"),
    zzn("FORMAT_AZTEC");

    public final int zzp;

    zzrn(String str) {
        this.zzp = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzp;
    }
}
