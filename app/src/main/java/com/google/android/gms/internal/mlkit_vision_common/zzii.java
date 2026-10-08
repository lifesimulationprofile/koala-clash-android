package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum zzii implements zzag {
    zza("UNKNOWN_FORMAT"),
    zzb("NV16"),
    zzc("NV21"),
    zzd("YV12"),
    zze("YUV_420_888"),
    /* JADX INFO: Fake field, exist only in values array */
    EF11("JPEG"),
    zzg("BITMAP"),
    /* JADX INFO: Fake field, exist only in values array */
    EF79("CM_SAMPLE_BUFFER_REF"),
    /* JADX INFO: Fake field, exist only in values array */
    EF88("UI_IMAGE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF101("CV_PIXEL_BUFFER_REF");

    public final int zzl;

    zzii(String str) {
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzag
    public final int zza() {
        return this.zzl;
    }
}
