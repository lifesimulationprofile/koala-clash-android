package com.github.kr328.clash.common.util;

import android.content.Intent;
import android.net.Uri;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntentKt {
    public static final UUID getUuid(Intent intent) {
        String schemeSpecificPart;
        Uri data = intent.getData();
        if (data != null) {
            if (!Intrinsics.areEqual(data.getScheme(), "uuid")) {
                data = null;
            }
            if (data != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null) {
                return UUID.fromString(schemeSpecificPart);
            }
        }
        return null;
    }
}
