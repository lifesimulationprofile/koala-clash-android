package com.google.mlkit.vision.barcode.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class BarcodeRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        RoomOpenHelper roomOpenHelperBuilder = Component.builder(zzi.class);
        roomOpenHelperBuilder.add(new Dependency(1, 0, MlKitContext.class));
        roomOpenHelperBuilder.identityHash = new ByteString.Companion(19);
        Component componentBuild = roomOpenHelperBuilder.build();
        RoomOpenHelper roomOpenHelperBuilder2 = Component.builder(zzg.class);
        roomOpenHelperBuilder2.add(new Dependency(1, 0, zzi.class));
        roomOpenHelperBuilder2.add(new Dependency(1, 0, ExecutorSelector.class));
        roomOpenHelperBuilder2.add(new Dependency(1, 0, MlKitContext.class));
        roomOpenHelperBuilder2.identityHash = new Path.Companion(20);
        Component componentBuild2 = roomOpenHelperBuilder2.build();
        zzcq zzcqVar = zzcs.zza;
        Object[] objArr = {componentBuild, componentBuild2};
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
            }
        }
        return new zzdk(2, objArr);
    }
}
