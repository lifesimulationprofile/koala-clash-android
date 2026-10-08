package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WakeLocksHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends LifecycleService {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemAlarmService");
    public SystemAlarmDispatcher mDispatcher;
    public boolean mIsShutdown;

    public final void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        Logger$LogcatLogger.get().debug(TAG, "All commands completed in dispatcher");
        String str = WakeLocks.TAG;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (WakeLocksHolder.INSTANCE) {
            linkedHashMap.putAll(WakeLocksHolder.wakeLocks);
            Unit unit = Unit.INSTANCE;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger$LogcatLogger.get().warning(WakeLocks.TAG, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.mDispatcher = systemAlarmDispatcher;
        if (systemAlarmDispatcher.mCompletedListener != null) {
            Logger$LogcatLogger.get().error(SystemAlarmDispatcher.TAG, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            systemAlarmDispatcher.mCompletedListener = this;
        }
        this.mIsShutdown = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        systemAlarmDispatcher.getClass();
        Logger$LogcatLogger.get().debug(SystemAlarmDispatcher.TAG, "Destroying SystemAlarmDispatcher");
        systemAlarmDispatcher.mProcessor.removeExecutionListener(systemAlarmDispatcher);
        systemAlarmDispatcher.mCompletedListener = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger$LogcatLogger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.getClass();
            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
            String str = SystemAlarmDispatcher.TAG;
            logger$LogcatLogger.debug(str, "Destroying SystemAlarmDispatcher");
            systemAlarmDispatcher.mProcessor.removeExecutionListener(systemAlarmDispatcher);
            systemAlarmDispatcher.mCompletedListener = null;
            SystemAlarmDispatcher systemAlarmDispatcher2 = new SystemAlarmDispatcher(this);
            this.mDispatcher = systemAlarmDispatcher2;
            if (systemAlarmDispatcher2.mCompletedListener != null) {
                Logger$LogcatLogger.get().error(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                systemAlarmDispatcher2.mCompletedListener = this;
            }
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.add(intent, i2);
        return 3;
    }
}
