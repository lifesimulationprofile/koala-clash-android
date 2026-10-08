package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfi implements EncoderConfig {
    public static final zzff zzb = new zzff(1);
    public Object zzc;
    public Serializable zzd;
    public Object zze;

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public /* bridge */ /* synthetic */ EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        ((HashMap) this.zzc).put(cls, objectEncoder);
        ((HashMap) this.zzd).remove(cls);
        return this;
    }
}
