package com.google.mlkit.vision.barcode.internal;

import androidx.appcompat.widget.AppCompatDrawableManager;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzru;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwo;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zza implements zzwo {
    public zzrb zza;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwo
    public StatusLine zza() {
        AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
        zzra zzraVar = zzb.zzf() ? zzra.zzc : zzra.zzb;
        zzrb zzrbVar = this.zza;
        anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = zzraVar;
        zza zzaVar = new zza();
        zzaVar.zza = zzrbVar;
        anonymousClass1.TINT_COLOR_CONTROL_STATE_LIST = new zzru(zzaVar);
        return new StatusLine(anonymousClass1, 0);
    }
}
