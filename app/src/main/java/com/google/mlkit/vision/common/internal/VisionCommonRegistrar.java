package com.google.mlkit.vision.common.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgq;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzu;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        RoomOpenHelper roomOpenHelperBuilder = Component.builder(zzc.class);
        roomOpenHelperBuilder.add(new Dependency(2, 0, zzgq.class));
        roomOpenHelperBuilder.identityHash = zzc.zza$1;
        Object[] objArr = {roomOpenHelperBuilder.build()};
        for (int i = 0; i < 1; i++) {
            zzn zznVar = zzp.zza;
            if (objArr[i] == null) {
                throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
            }
        }
        zzn zznVar2 = zzp.zza;
        return new zzu(1, objArr);
    }
}
