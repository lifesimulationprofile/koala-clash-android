package com.google.android.gms.common.api.internal;

import coil.memory.RealStrongMemoryCache;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ApiKey {
    public final int zaa;
    public final RealStrongMemoryCache zab;
    public final Api$ApiOptions zac;
    public final String zad;

    public ApiKey(RealStrongMemoryCache realStrongMemoryCache, Api$ApiOptions api$ApiOptions, String str) {
        this.zab = realStrongMemoryCache;
        this.zac = api$ApiOptions;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{realStrongMemoryCache, api$ApiOptions, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return zzah.equal(this.zab, apiKey.zab) && zzah.equal(this.zac, apiKey.zac) && zzah.equal(this.zad, apiKey.zad);
    }

    public final int hashCode() {
        return this.zaa;
    }
}
