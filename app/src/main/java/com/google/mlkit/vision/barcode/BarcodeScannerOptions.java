package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BarcodeScannerOptions {
    public final int zza;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BarcodeScannerOptions) && this.zza == ((BarcodeScannerOptions) obj).zza && zzah.equal(null, null) && zzah.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Boolean.FALSE, null, null});
    }
}
