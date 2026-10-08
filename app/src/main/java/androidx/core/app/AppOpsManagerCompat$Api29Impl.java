package androidx.core.app;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpsManagerCompat$Api29Impl {
    public static String getOpPackageName(Context context) {
        return context.getOpPackageName();
    }

    public static void setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void setBubbleMetadata(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void setContextual(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
