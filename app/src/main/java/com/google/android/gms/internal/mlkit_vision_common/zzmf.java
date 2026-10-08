package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import coil.request.RequestService;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmf implements zzmc {
    public final ArrayList zza;

    public zzmf(Context context, zzma zzmaVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.add(new zzmp(context, zzmaVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void zza(RequestService requestService) {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzmc) obj).zza(requestService);
        }
    }
}
