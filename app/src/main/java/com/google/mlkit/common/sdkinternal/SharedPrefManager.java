package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.UUID;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPrefManager {
    public static final Component COMPONENT;
    public final Context zza;

    static {
        RoomOpenHelper roomOpenHelperBuilder = Component.builder(SharedPrefManager.class);
        roomOpenHelperBuilder.add(new Dependency(1, 0, MlKitContext.class));
        roomOpenHelperBuilder.add(new Dependency(1, 0, Context.class));
        roomOpenHelperBuilder.identityHash = new AsyncTimeout.Companion(19);
        COMPONENT = roomOpenHelperBuilder.build();
    }

    public SharedPrefManager(Context context) {
        this.zza = context;
    }

    public final synchronized String getMlSdkInstanceId() {
        String string = this.zza.getSharedPreferences("com.google.mlkit.internal", 0).getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        this.zza.getSharedPreferences("com.google.mlkit.internal", 0).edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }
}
