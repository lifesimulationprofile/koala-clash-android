package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api24Impl {
    public static boolean areNotificationsEnabled(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static void setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z) {
        builder.setAllowGeneratedReplies(z);
    }

    public static void setRemoteInputHistory(Notification.Builder builder) {
        builder.setRemoteInputHistory(null);
    }
}
