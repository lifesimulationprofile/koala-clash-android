package com.google.mlkit.common;

import com.google.android.gms.common.internal.zzah;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MlKitException extends Exception {
    public final int zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MlKitException(String str, int i) {
        super(str);
        zzah.checkNotEmpty(str, "Provided message must not be empty.");
        this.zza = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MlKitException(String str, Exception exc) {
        super(str, exc);
        zzah.checkNotEmpty(str, "Provided message must not be empty.");
        this.zza = 13;
    }
}
