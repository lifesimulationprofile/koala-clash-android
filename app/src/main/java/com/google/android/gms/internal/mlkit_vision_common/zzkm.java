package com.google.android.gms.internal.mlkit_vision_common;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.core.app.NotificationCompat$Builder;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkm {
    public static void notifyLoadingNotification(Service service) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(service, "clash_status_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
        notificationCompat$Builder.setFlag(2);
        notificationCompat$Builder.mColor = service.getColor(R.color.color_clash);
        notificationCompat$Builder.setFlag(8);
        notificationCompat$Builder.mShowWhen = false;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(service.getText(R.string.loading));
        Notification notificationBuild = notificationCompat$Builder.build();
        if (Build.VERSION.SDK_INT >= 34) {
            service.startForeground(R.id.nf_clash_status, notificationBuild, 1073741824);
        } else {
            service.startForeground(R.id.nf_clash_status, notificationBuild);
        }
    }
}
