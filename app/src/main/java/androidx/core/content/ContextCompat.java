package androidx.core.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatBuilder$Api24Impl;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.os.ExecutorCompat$HandlerExecutor;
import androidx.core.os.HandlerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextCompat {
    public static int checkSelfPermission(Context context, String str) {
        boolean zAreNotificationsEnabled;
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
        if (i >= 24) {
            zAreNotificationsEnabled = NotificationCompatBuilder$Api24Impl.areNotificationsEnabled(notificationManagerCompat.mNotificationManager);
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                zAreNotificationsEnabled = ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i2), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return zAreNotificationsEnabled ? 0 : -1;
    }

    public static Executor getMainExecutor(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? HandlerCompat.Api28Impl.getMainExecutor(context) : new ExecutorCompat$HandlerExecutor(new Handler(context.getMainLooper()), 0);
    }
}
