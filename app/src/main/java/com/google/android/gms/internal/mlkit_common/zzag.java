package com.google.android.gms.internal.mlkit_common;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzag {
    public final Object zza;
    public final Object zzb;
    public final Object zzc;

    public zzag(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zza;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.zzb);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.zzc);
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Multiple entries with same key: ", strValueOf, "=", strValueOf2, " and ");
        sbM.append(strValueOf3);
        sbM.append("=");
        sbM.append(strValueOf4);
        return new IllegalArgumentException(sbM.toString());
    }
}
