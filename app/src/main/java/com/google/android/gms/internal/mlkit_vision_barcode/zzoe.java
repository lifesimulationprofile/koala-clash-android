package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoe implements ObjectEncoder {
    public static final zzoe zza = new zzoe();
    public static final FieldDescriptor zzb = new FieldDescriptor("appName", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("sessionId", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("startZoomLevel", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("endZoomLevel", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("durationMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("predictedArea", Density.CC.m(Density.CC.m(zzfe.class, new zzez(6))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        ((zzut) obj).getClass();
        objectEncoderContext.add(zzb, (Object) null);
        objectEncoderContext.add(zzc, (Object) null);
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) null);
        objectEncoderContext.add(zzf, (Object) null);
        objectEncoderContext.add(zzg, (Object) null);
    }
}
