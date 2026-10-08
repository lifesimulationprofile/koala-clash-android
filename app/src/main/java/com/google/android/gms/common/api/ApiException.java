package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class ApiException extends Exception {
    public final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    public ApiException(Status status) {
        int i = status.zzb;
        String str = status.zzc;
        super(i + ": " + (str == null ? "" : str));
        this.mStatus = status;
    }
}
