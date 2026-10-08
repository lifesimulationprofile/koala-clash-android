package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.core.view.MenuItemCompat$Api26Impl;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Processor implements ForegroundProcessor {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Processor");
    public final Context mAppContext;
    public final Configuration mConfiguration;
    public final WorkDatabase mWorkDatabase;
    public final WorkManagerTaskExecutor mWorkTaskExecutor;
    public final HashMap mEnqueuedWorkMap = new HashMap();
    public final HashMap mForegroundWorkMap = new HashMap();
    public final HashSet mCancelledIds = new HashSet();
    public final ArrayList mOuterListeners = new ArrayList();
    public PowerManager.WakeLock mForegroundLock = null;
    public final Object mLock = new Object();
    public final HashMap mWorkRuns = new HashMap();

    public Processor(Context context, Configuration configuration, WorkManagerTaskExecutor workManagerTaskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workManagerTaskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    public static boolean interrupt(String str, WorkerWrapper workerWrapper, int i) {
        if (workerWrapper == null) {
            Logger$LogcatLogger.get().debug(TAG, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.mInterrupted = i;
        workerWrapper.tryCheckForInterruptionAndResolve();
        workerWrapper.mWorkerResultFuture.cancel(true);
        if (workerWrapper.mWorker == null || !(workerWrapper.mWorkerResultFuture.value instanceof AbstractFuture.Cancellation)) {
            Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, "WorkSpec " + workerWrapper.mWorkSpec + " is already done. Not interrupting.");
        } else {
            workerWrapper.mWorker.stop(i);
        }
        Logger$LogcatLogger.get().debug(TAG, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public final WorkerWrapper cleanUpWorkerUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.remove(str);
        boolean z = workerWrapper != null;
        if (!z) {
            workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z) {
            synchronized (this.mLock) {
                try {
                    if (this.mForegroundWorkMap.isEmpty()) {
                        Context context = this.mAppContext;
                        String str2 = SystemForegroundDispatcher.TAG;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.mAppContext.startService(intent);
                        } catch (Throwable th) {
                            Logger$LogcatLogger.get().error(TAG, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.mForegroundLock;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.mForegroundLock = null;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return workerWrapper;
    }

    public final WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe == null) {
                    return null;
                }
                return workerWrapperUnsafe.mWorkSpec;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    public final boolean isCancelled(String str) {
        boolean zContains;
        synchronized (this.mLock) {
            zContains = this.mCancelledIds.contains(str);
        }
        return zContains;
    }

    public final boolean isEnqueued(String str) {
        boolean z;
        synchronized (this.mLock) {
            z = getWorkerWrapperUnsafe(str) != null;
        }
        return z;
    }

    public final void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public final void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger$LogcatLogger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(str);
                if (workerWrapper != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                        this.mForegroundLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, workerWrapper);
                    Intent intentCreateStartForegroundIntent = SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, WorkSpecKt.generationalId(workerWrapper.mWorkSpec), foregroundInfo);
                    Context context = this.mAppContext;
                    if (Build.VERSION.SDK_INT >= 26) {
                        MenuItemCompat$Api26Impl.startForegroundService(context, intentCreateStartForegroundIntent);
                    } else {
                        context.startService(intentCreateStartForegroundIntent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean startWork(StartStopToken startStopToken, SystemClock systemClock) {
        WorkGenerationalId workGenerationalId = startStopToken.id;
        final String str = workGenerationalId.workSpecId;
        final ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.Processor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = this.f$0.mWorkDatabase;
                ImageLoader$Builder imageLoader$BuilderWorkTagDao = workDatabase.workTagDao();
                String str2 = str;
                arrayList.addAll(imageLoader$BuilderWorkTagDao.getTagsForWorkSpecId(str2));
                return workDatabase.workSpecDao().getWorkSpec(str2);
            }
        });
        if (workSpec == null) {
            Logger$LogcatLogger.get().warning(TAG, "Didn't find WorkSpec for id " + workGenerationalId);
            this.mWorkTaskExecutor.mMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(27, this, workGenerationalId));
            return false;
        }
        synchronized (this.mLock) {
            try {
                if (isEnqueued(str)) {
                    Set set = (Set) this.mWorkRuns.get(str);
                    if (((StartStopToken) set.iterator().next()).id.generation == workGenerationalId.generation) {
                        set.add(startStopToken);
                        Logger$LogcatLogger.get().debug(TAG, "Work " + workGenerationalId + " is already enqueued for processing");
                    } else {
                        this.mWorkTaskExecutor.mMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(27, this, workGenerationalId));
                    }
                    return false;
                }
                if (workSpec.generation != workGenerationalId.generation) {
                    this.mWorkTaskExecutor.mMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(27, this, workGenerationalId));
                    return false;
                }
                Context context = this.mAppContext;
                Configuration configuration = this.mConfiguration;
                WorkManagerTaskExecutor workManagerTaskExecutor = this.mWorkTaskExecutor;
                WorkDatabase workDatabase = this.mWorkDatabase;
                TooltipPopup tooltipPopup = new TooltipPopup();
                new SystemClock();
                tooltipPopup.mContext = context.getApplicationContext();
                tooltipPopup.mMessageView = workManagerTaskExecutor;
                tooltipPopup.mContentView = this;
                tooltipPopup.mLayoutParams = configuration;
                tooltipPopup.mTmpDisplayFrame = workDatabase;
                tooltipPopup.mTmpAnchorPos = workSpec;
                tooltipPopup.mTmpAppPos = arrayList;
                WorkerWrapper workerWrapper = new WorkerWrapper(tooltipPopup);
                SettableFuture settableFuture = workerWrapper.mFuture;
                settableFuture.addListener(new Processor$$ExternalSyntheticLambda1(this, settableFuture, workerWrapper, 0), this.mWorkTaskExecutor.mMainThreadExecutor);
                this.mEnqueuedWorkMap.put(str, workerWrapper);
                HashSet hashSet = new HashSet();
                hashSet.add(startStopToken);
                this.mWorkRuns.put(str, hashSet);
                this.mWorkTaskExecutor.mBackgroundExecutor.execute(workerWrapper);
                Logger$LogcatLogger.get().debug(TAG, "Processor: processing " + workGenerationalId);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean stopWork(StartStopToken startStopToken, int i) {
        String str = startStopToken.id.workSpecId;
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(str) == null) {
                    Set set = (Set) this.mWorkRuns.get(str);
                    if (set != null && set.contains(startStopToken)) {
                        return interrupt(str, cleanUpWorkerUnsafe(str), i);
                    }
                    return false;
                }
                Logger$LogcatLogger.get().debug(TAG, "Ignored stopWork. WorkerWrapper " + str + " is in foreground");
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
