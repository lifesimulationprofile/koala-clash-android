package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GmsLogger {
    public final String zza;
    public final String zzb;

    public GmsLogger(int i, String str, String str2) {
        switch (i) {
            case 1:
                this.zza = str;
                this.zzb = str2;
                return;
            default:
                Object[] objArr = {str, 23};
                if (!(str.length() <= 23)) {
                    throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
                }
                this.zza = str;
                this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
                return;
        }
    }

    public String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }
}
