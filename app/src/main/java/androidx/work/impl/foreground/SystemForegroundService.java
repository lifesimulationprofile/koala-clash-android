package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemFgService");
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.SystemForegroundService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Notification val$notification;
        public final /* synthetic */ int val$notificationId;
        public final /* synthetic */ int val$notificationType;

        public AnonymousClass1(int i, Notification notification, int i2) {
            this.val$notificationId = i;
            this.val$notification = notification;
            this.val$notificationType = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = Build.VERSION.SDK_INT;
            int i2 = this.val$notificationType;
            Notification notification = this.val$notification;
            int i3 = this.val$notificationId;
            SystemForegroundService systemForegroundService = SystemForegroundService.this;
            if (i >= 31) {
                Api31Impl.startForeground(systemForegroundService, i3, notification, i2);
            } else if (i >= 29) {
                Api29Impl.startForeground(systemForegroundService, i3, notification, i2);
            } else {
                systemForegroundService.startForeground(i3, notification);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Api29Impl {
        public static void startForeground(Service service, int i, Notification notification, int i2) {
            service.startForeground(i, notification, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Api31Impl {
        public static void startForeground(Service service, int i, Notification notification, int i2) {
            try {
                service.startForeground(i, notification, i2);
            } catch (ForegroundServiceStartNotAllowedException e) {
                Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                String str = SystemForegroundService.TAG;
                if (logger$LogcatLogger.mLoggingLevel <= 5) {
                    Log.w(str, "Unable to start foreground service", e);
                }
            } catch (SecurityException e2) {
                Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                String str2 = SystemForegroundService.TAG;
                if (logger$LogcatLogger2.mLoggingLevel <= 5) {
                    Log.w(str2, "Unable to start foreground service", e2);
                }
            }
        }
    }

    public final void initializeDispatcher$1() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.mCallback != null) {
            Logger$LogcatLogger.get().error(SystemForegroundDispatcher.TAG, "A callback already exists.");
        } else {
            systemForegroundDispatcher.mCallback = this;
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        initializeDispatcher$1();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        boolean z = this.mIsShutdown;
        String str = TAG;
        if (z) {
            Logger$LogcatLogger.get().info(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            initializeDispatcher$1();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
        systemForegroundDispatcher.getClass();
        String str2 = SystemForegroundDispatcher.TAG;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            Logger$LogcatLogger.get().info(str2, "Started foreground service " + intent);
            systemForegroundDispatcher.mTaskExecutor.executeOnTaskThread(new Worker.AnonymousClass2(12, systemForegroundDispatcher, intent.getStringExtra("KEY_WORKSPEC_ID"), false));
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            systemForegroundDispatcher.handleNotify(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            Logger$LogcatLogger.get().info(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = systemForegroundDispatcher.mCallback;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.mIsShutdown = true;
            Logger$LogcatLogger.get().debug(str, "All commands completed.");
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
        Logger$LogcatLogger.get().info(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        final WorkManagerImpl workManagerImpl = systemForegroundDispatcher.mWorkManagerImpl;
        final UUID uuidFromString = UUID.fromString(stringExtra);
        workManagerImpl.getClass();
        workManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public final void runInternal() {
                WorkManagerImpl workManagerImpl2 = workManagerImpl;
                WorkDatabase workDatabase = workManagerImpl2.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    CancelWorkRunnable.cancel(workManagerImpl2, uuidFromString.toString());
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                    Schedulers.schedule(workManagerImpl2.mConfiguration, workManagerImpl2.mWorkDatabase, workManagerImpl2.mSchedulers);
                } catch (Throwable th) {
                    workDatabase.internalEndTransaction();
                    throw th;
                }
            }
        });
        return 3;
    }
}
