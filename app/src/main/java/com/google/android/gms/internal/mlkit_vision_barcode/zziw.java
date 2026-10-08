package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zziw implements ObjectEncoder {
    public static final zziw zza = new zziw();
    public static final FieldDescriptor zzb = new FieldDescriptor("format", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(zzb, ((zzvz) obj).zza);
    }
}
