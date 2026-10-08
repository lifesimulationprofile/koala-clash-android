package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum zzio implements zzag {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("SOURCE_UNKNOWN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("BITMAP"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("BYTEARRAY"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("BYTEBUFFER"),
    /* JADX INFO: Fake field, exist only in values array */
    EF8("FILEPATH"),
    zzf("ANDROID_MEDIA_IMAGE");

    public final int zzh;

    zzio(String str) {
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzag
    public final int zza() {
        return this.zzh;
    }
}
