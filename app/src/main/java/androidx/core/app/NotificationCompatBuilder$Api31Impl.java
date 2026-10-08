package androidx.core.app;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api31Impl {
    public static void setAuthenticationRequired(Notification.Action.Builder builder) {
        builder.setAuthenticationRequired(false);
    }

    public static void setForegroundServiceBehavior(Notification.Builder builder, int i) {
        builder.setForegroundServiceBehavior(i);
    }
}
