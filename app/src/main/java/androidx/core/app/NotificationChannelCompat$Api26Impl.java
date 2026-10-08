package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationChannelCompat$Api26Impl {
    public static Notification.Builder createBuilder(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static NotificationChannel createNotificationChannel(int i, CharSequence charSequence, String str) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static void enableLights(NotificationChannel notificationChannel) {
        notificationChannel.enableLights(false);
    }

    public static void enableVibration(NotificationChannel notificationChannel) {
        notificationChannel.enableVibration(false);
    }

    public static void setBadgeIconType(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static void setDescription(NotificationChannel notificationChannel) {
        notificationChannel.setDescription(null);
    }

    public static void setGroup(NotificationChannel notificationChannel) {
        notificationChannel.setGroup(null);
    }

    public static void setGroupAlertBehavior(Notification.Builder builder) {
        builder.setGroupAlertBehavior(0);
    }

    public static void setLightColor(NotificationChannel notificationChannel) {
        notificationChannel.setLightColor(0);
    }

    public static void setSettingsText(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void setShortcutId(Notification.Builder builder) {
        builder.setShortcutId(null);
    }

    public static void setShowBadge(NotificationChannel notificationChannel) {
        notificationChannel.setShowBadge(true);
    }

    public static void setSound(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
        notificationChannel.setSound(uri, audioAttributes);
    }

    public static void setTimeoutAfter(Notification.Builder builder) {
        builder.setTimeoutAfter(0L);
    }

    public static void setVibrationPattern(NotificationChannel notificationChannel) {
        notificationChannel.setVibrationPattern(null);
    }

    public static void createNotificationChannel(NotificationManager notificationManager, NotificationChannel notificationChannel) {
        notificationManager.createNotificationChannel(notificationChannel);
    }
}
