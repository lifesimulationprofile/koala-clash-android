package com.google.android.gms.internal.mlkit_vision_common;

import androidx.compose.ui.unit.Density;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import fi.iki.elonen.NanoHTTPD$Method$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgu implements ObjectEncoder {
    public static final zzgu zza = new zzgu();
    public static final FieldDescriptor zzb = new FieldDescriptor("appId", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("appVersion", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(2))));
    public static final FieldDescriptor zzd = new FieldDescriptor("firebaseProjectId", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(3))));
    public static final FieldDescriptor zze = new FieldDescriptor("mlSdkVersion", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(4))));
    public static final FieldDescriptor zzf = new FieldDescriptor("tfliteSchemaVersion", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(5))));
    public static final FieldDescriptor zzg = new FieldDescriptor("gcmSenderId", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(6))));
    public static final FieldDescriptor zzh = new FieldDescriptor("apiKey", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(7))));
    public static final FieldDescriptor zzi = new FieldDescriptor("languages", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(8))));
    public static final FieldDescriptor zzj = new FieldDescriptor("mlSdkInstanceId", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(9))));
    public static final FieldDescriptor zzk = new FieldDescriptor("isClearcutClient", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(10))));
    public static final FieldDescriptor zzl = new FieldDescriptor("isStandaloneMlkit", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(11))));
    public static final FieldDescriptor zzm = new FieldDescriptor("isJsonLogging", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(12))));
    public static final FieldDescriptor zzn = new FieldDescriptor("buildLevel", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(13))));
    public static final FieldDescriptor zzo = new FieldDescriptor("optionalModuleVersion", Density.CC.m(NanoHTTPD$Method$EnumUnboxingLocalUtility.m(zzai.class, new zzad(14))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        zzla zzlaVar = (zzla) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzlaVar.zza);
        objectEncoderContext.add(zzc, zzlaVar.zzb);
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, zzlaVar.zzc);
        objectEncoderContext.add(zzf, zzlaVar.zzd);
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, zzlaVar.zze);
        objectEncoderContext.add(zzj, zzlaVar.zzf);
        objectEncoderContext.add(zzk, zzlaVar.zzg);
        objectEncoderContext.add(zzl, zzlaVar.zzh);
        objectEncoderContext.add(zzm, zzlaVar.zzi);
        objectEncoderContext.add(zzn, zzlaVar.zzj);
        objectEncoderContext.add(zzo, zzlaVar.zzk);
    }
}
