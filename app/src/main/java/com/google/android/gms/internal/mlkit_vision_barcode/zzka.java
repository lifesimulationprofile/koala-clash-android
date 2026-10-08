package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzka implements ObjectEncoder {
    public static final zzka zza = new zzka();
    public static final FieldDescriptor zzb = new FieldDescriptor("maxMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("minMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("avgMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("firstQuartileMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("medianMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("thirdQuartileMs", Density.CC.m(Density.CC.m(zzfe.class, new zzez(6))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zzqd zzqdVar = (zzqd) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzqdVar.zza);
        objectEncoderContext.add(zzc, zzqdVar.zzb);
        objectEncoderContext.add(zzd, zzqdVar.zzc);
        objectEncoderContext.add(zze, zzqdVar.zzd);
        objectEncoderContext.add(zzf, zzqdVar.zze);
        objectEncoderContext.add(zzg, zzqdVar.zzf);
    }
}
