package com.google.mlkit.vision.common;

import android.graphics.Bitmap;
import android.media.Image;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.zzs;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InputImage {
    public volatile Bitmap zza;
    public volatile zzs zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;

    public InputImage(Bitmap bitmap) {
        zzah.checkNotNull(bitmap);
        this.zza = bitmap;
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        zza(0);
        this.zzf = 0;
        this.zzg = -1;
    }

    public static void zza(int i) {
        boolean z = true;
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            z = false;
        }
        zzah.checkArgument("Invalid rotation. Only 0, 90, 180, 270 are supported currently.", z);
    }

    public final Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return ((Image) this.zzc.zza).getPlanes();
    }

    public InputImage(Image image, int i, int i2, int i3) {
        this.zzc = new zzs(image);
        this.zzd = i;
        this.zze = i2;
        zza(i3);
        this.zzf = i3;
        this.zzg = 35;
    }
}
