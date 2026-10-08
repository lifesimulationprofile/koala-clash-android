package com.google.mlkit.common.internal;

import androidx.appcompat.widget.Toolbar;
import androidx.room.RoomOpenHelper;
import androidx.room.TransactionElement;
import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_common.zzak;
import com.google.android.gms.internal.mlkit_common.zzal;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModelManager$RemoteModelManagerRegistration;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.List;
import okio.AsyncTimeout;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        RoomOpenHelper roomOpenHelperBuilder = Component.builder(ByteString.Companion.class);
        roomOpenHelperBuilder.add(new Dependency(1, 0, MlKitContext.class));
        roomOpenHelperBuilder.identityHash = new AsyncTimeout.Companion(17);
        Component componentBuild = roomOpenHelperBuilder.build();
        RoomOpenHelper roomOpenHelperBuilder2 = Component.builder(MlKitThreadPool.class);
        roomOpenHelperBuilder2.identityHash = new ByteString.Companion(17);
        Component componentBuild2 = roomOpenHelperBuilder2.build();
        RoomOpenHelper roomOpenHelperBuilder3 = Component.builder(Toolbar.AnonymousClass1.class);
        roomOpenHelperBuilder3.add(new Dependency(2, 0, RemoteModelManager$RemoteModelManagerRegistration.class));
        roomOpenHelperBuilder3.identityHash = new Path.Companion(18);
        Component componentBuild3 = roomOpenHelperBuilder3.build();
        RoomOpenHelper roomOpenHelperBuilder4 = Component.builder(ExecutorSelector.class);
        roomOpenHelperBuilder4.add(new Dependency(1, 1, MlKitThreadPool.class));
        roomOpenHelperBuilder4.identityHash = new zzd();
        Component componentBuild4 = roomOpenHelperBuilder4.build();
        RoomOpenHelper roomOpenHelperBuilder5 = Component.builder(Cleaner.class);
        roomOpenHelperBuilder5.identityHash = new TransactionElement.Key(17);
        Component componentBuild5 = roomOpenHelperBuilder5.build();
        RoomOpenHelper roomOpenHelperBuilder6 = Component.builder(AsyncTimeout.Companion.class);
        roomOpenHelperBuilder6.add(new Dependency(1, 0, Cleaner.class));
        roomOpenHelperBuilder6.identityHash = new AsyncTimeout.Companion(18);
        Component componentBuild6 = roomOpenHelperBuilder6.build();
        RoomOpenHelper roomOpenHelperBuilder7 = Component.builder(TransactionElement.Key.class);
        roomOpenHelperBuilder7.add(new Dependency(1, 0, MlKitContext.class));
        roomOpenHelperBuilder7.identityHash = new ByteString.Companion(18);
        Component componentBuild7 = roomOpenHelperBuilder7.build();
        RoomOpenHelper roomOpenHelperBuilder8 = Component.builder(RemoteModelManager$RemoteModelManagerRegistration.class);
        roomOpenHelperBuilder8.version = 1;
        roomOpenHelperBuilder8.add(new Dependency(1, 1, TransactionElement.Key.class));
        roomOpenHelperBuilder8.identityHash = new Path.Companion(19);
        Component componentBuild8 = roomOpenHelperBuilder8.build();
        zzad zzadVar = zzaf.zza;
        Object[] objArr = {SharedPrefManager.COMPONENT, componentBuild, componentBuild2, componentBuild3, componentBuild4, componentBuild5, componentBuild6, componentBuild7, componentBuild8};
        zzak.zza(9, objArr);
        return new zzal(9, objArr);
    }
}
