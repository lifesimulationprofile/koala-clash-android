package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwi implements zzwf {
    public final ArrayList zza;

    public zzwi(Context context, zzwd zzwdVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.add(new zzwx(context, zzwdVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwf
    public final void zza(StatusLine statusLine) {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzwf) obj).zza(statusLine);
        }
    }
}
