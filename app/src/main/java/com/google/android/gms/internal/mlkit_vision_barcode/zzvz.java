package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvz {
    public final zzdk zza;

    public /* synthetic */ zzvz(ConnectionPool connectionPool) {
        this.zza = (zzdk) connectionPool.delegate;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzvz) {
            return com.google.android.gms.common.internal.zzah.equal(this.zza, ((zzvz) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }
}
