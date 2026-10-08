package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends zzeh implements zzfn {
    private static final zzj zzb;
    private int zzd;
    private zzeo zzf;
    private int zzg;
    private zzu zzh;
    private zzp zzi;
    private zzjv zzj;
    private int zzk;
    private zzeo zzl;
    private byte zzm = 2;
    private int zze = 17;

    static {
        zzj zzjVar = new zzj();
        zzb = zzjVar;
        zzeh.zzV(zzj.class, zzjVar);
    }

    public zzj() {
        zzfv zzfvVar = zzfv.zza;
        this.zzf = zzfvVar;
        this.zzl = zzfvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i, zzeh zzehVar) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzfw(zzb, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", zzi.zza, "zzf", zzah.class, "zzg", "zzh", "zzi", "zzk", "zzl", zzak.class, "zzj"});
        }
        if (i2 == 3) {
            return new zzj();
        }
        if (i2 == 4) {
            return new zze(8, zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzm = zzehVar == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
