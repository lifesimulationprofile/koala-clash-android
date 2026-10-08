package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import androidx.room.TransactionExecutor;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemAlarmDispatcher implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemAlarmDispatcher");
    public final CommandHandler mCommandHandler;
    public SystemAlarmService mCompletedListener;
    public final Context mContext;
    public Intent mCurrentIntent;
    public final ArrayList mIntents;
    public final Processor mProcessor;
    public final WorkManagerTaskExecutor mTaskExecutor;
    public final WorkLauncherImpl mWorkLauncher;
    public final WorkManagerImpl mWorkManager;
    public final WorkTimer mWorkTimer;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final SystemAlarmDispatcher this$0;

        public /* synthetic */ AnonymousClass1(SystemAlarmDispatcher systemAlarmDispatcher, int i) {
            this.$r8$classId = i;
            this.this$0 = systemAlarmDispatcher;
        }

        private final void run$androidx$work$impl$background$systemalarm$SystemAlarmDispatcher$1() {
            HighPriorityExecutor highPriorityExecutor;
            AnonymousClass1 anonymousClass1;
            synchronized (this.this$0.mIntents) {
                SystemAlarmDispatcher systemAlarmDispatcher = this.this$0;
                systemAlarmDispatcher.mCurrentIntent = (Intent) systemAlarmDispatcher.mIntents.get(0);
            }
            Intent intent = this.this$0.mCurrentIntent;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = this.this$0.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
                Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                String str = SystemAlarmDispatcher.TAG;
                logger$LogcatLogger.debug(str, "Processing command " + this.this$0.mCurrentIntent + ", " + intExtra);
                PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.this$0.mContext, action + " (" + intExtra + ")");
                try {
                    Logger$LogcatLogger.get().debug(str, "Acquiring operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                    wakeLockNewWakeLock.acquire();
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.this$0;
                    systemAlarmDispatcher2.mCommandHandler.onHandleIntent(systemAlarmDispatcher2.mCurrentIntent, intExtra, systemAlarmDispatcher2);
                    Logger$LogcatLogger.get().debug(str, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                    wakeLockNewWakeLock.release();
                    SystemAlarmDispatcher systemAlarmDispatcher3 = this.this$0;
                    highPriorityExecutor = systemAlarmDispatcher3.mTaskExecutor.mMainThreadExecutor;
                    anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher3, 1);
                } catch (Throwable th) {
                    try {
                        Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                        String str2 = SystemAlarmDispatcher.TAG;
                        logger$LogcatLogger2.error(str2, "Unexpected error in onHandleIntent", th);
                        Logger$LogcatLogger.get().debug(str2, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                        wakeLockNewWakeLock.release();
                        SystemAlarmDispatcher systemAlarmDispatcher4 = this.this$0;
                        highPriorityExecutor = systemAlarmDispatcher4.mTaskExecutor.mMainThreadExecutor;
                        anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher4, 1);
                    } catch (Throwable th2) {
                        Logger$LogcatLogger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + action + ") " + wakeLockNewWakeLock);
                        wakeLockNewWakeLock.release();
                        SystemAlarmDispatcher systemAlarmDispatcher5 = this.this$0;
                        systemAlarmDispatcher5.mTaskExecutor.mMainThreadExecutor.execute(new AnonymousClass1(systemAlarmDispatcher5, 1));
                        throw th2;
                    }
                }
                highPriorityExecutor.execute(anonymousClass1);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    run$androidx$work$impl$background$systemalarm$SystemAlarmDispatcher$1();
                    return;
                default:
                    SystemAlarmDispatcher systemAlarmDispatcher = this.this$0;
                    Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                    String str = SystemAlarmDispatcher.TAG;
                    logger$LogcatLogger.debug(str, "Checking if commands are complete.");
                    SystemAlarmDispatcher.assertMainThread();
                    synchronized (systemAlarmDispatcher.mIntents) {
                        try {
                            if (systemAlarmDispatcher.mCurrentIntent != null) {
                                Logger$LogcatLogger.get().debug(str, "Removing command " + systemAlarmDispatcher.mCurrentIntent);
                                if (!((Intent) systemAlarmDispatcher.mIntents.remove(0)).equals(systemAlarmDispatcher.mCurrentIntent)) {
                                    throw new IllegalStateException("Dequeue-d command is not the first.");
                                }
                                systemAlarmDispatcher.mCurrentIntent = null;
                            }
                            TransactionExecutor transactionExecutor = systemAlarmDispatcher.mTaskExecutor.mBackgroundExecutor;
                            if (!systemAlarmDispatcher.mCommandHandler.hasPendingCommands() && systemAlarmDispatcher.mIntents.isEmpty() && !transactionExecutor.hasPendingTasks()) {
                                Logger$LogcatLogger.get().debug(str, "No more commands & intents.");
                                SystemAlarmService systemAlarmService = systemAlarmDispatcher.mCompletedListener;
                                if (systemAlarmService != null) {
                                    systemAlarmService.onAllCommandsCompleted();
                                }
                            } else if (!systemAlarmDispatcher.mIntents.isEmpty()) {
                                systemAlarmDispatcher.processCommand();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
            }
        }
    }

    public SystemAlarmDispatcher(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.mContext = applicationContext;
        StartStopTokens startStopTokens = new StartStopTokens(0);
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(systemAlarmService);
        Configuration configuration = instance$1.mConfiguration;
        this.mWorkManager = instance$1;
        this.mCommandHandler = new CommandHandler(applicationContext, configuration.clock, startStopTokens);
        this.mWorkTimer = new WorkTimer(configuration.runnableScheduler);
        Processor processor = instance$1.mProcessor;
        this.mProcessor = processor;
        WorkManagerTaskExecutor workManagerTaskExecutor = instance$1.mWorkTaskExecutor;
        this.mTaskExecutor = workManagerTaskExecutor;
        this.mWorkLauncher = new WorkLauncherImpl(0, processor, workManagerTaskExecutor);
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
    }

    public static void assertMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void add(Intent intent, int i) {
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        String str = TAG;
        logger$LogcatLogger.debug(str, "Adding command " + intent + " (" + i + ")");
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger$LogcatLogger.get().warning(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction()) {
            return;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.mIntents) {
            try {
                boolean zIsEmpty = this.mIntents.isEmpty();
                this.mIntents.add(intent);
                if (zIsEmpty) {
                    processCommand();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean hasIntentWithAction() {
        assertMainThread();
        synchronized (this.mIntents) {
            try {
                ArrayList arrayList = this.mIntents;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        HighPriorityExecutor highPriorityExecutor = this.mTaskExecutor.mMainThreadExecutor;
        String str = CommandHandler.TAG;
        Intent intent = new Intent(this.mContext, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        highPriorityExecutor.execute(new AppCompatTextHelper.AnonymousClass2(this, intent, 0, 2));
    }

    public final void processCommand() {
        assertMainThread();
        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mContext, "ProcessCommand");
        try {
            wakeLockNewWakeLock.acquire();
            this.mWorkManager.mWorkTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, 0));
        } finally {
            wakeLockNewWakeLock.release();
        }
    }
}
