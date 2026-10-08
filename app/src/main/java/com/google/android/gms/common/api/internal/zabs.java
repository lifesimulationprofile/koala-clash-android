package com.google.android.gms.common.api.internal;

import coil.request.RequestService;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (zzah.equal(this.zaa, zabsVar.zaa) && zzah.equal(this.zab, zabsVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        RequestService requestService = new RequestService(this);
        requestService.add(this.zaa, "key");
        requestService.add(this.zab, "feature");
        return requestService.toString();
    }
}
