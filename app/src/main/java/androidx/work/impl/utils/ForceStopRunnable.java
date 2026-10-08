package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.LocaleListCompat;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.memory.EmptyStrongMemoryCache;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ForceStopRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ForceStopRunnable");
    public static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    public final Context mContext;
    public final EmptyStrongMemoryCache mPreferenceUtils;
    public int mRetryCount = 0;
    public final WorkManagerImpl mWorkManager;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            if (Logger$LogcatLogger.get().mLoggingLevel <= 2) {
                Log.v(TAG, "Rescheduling alarm that keeps track of force-stops.");
            }
            ForceStopRunnable.setAlarm(context);
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mPreferenceUtils = workManagerImpl.mPreferenceUtils;
    }

    public static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0223  */
    /* JADX WARN: Code duplicated, block: B:106:0x023b  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    public final void forceStopRunnable() {
        boolean z;
        EmptyStrongMemoryCache emptyStrongMemoryCache = this.mPreferenceUtils;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        Configuration configuration = workManagerImpl.mConfiguration;
        EmptyStrongMemoryCache emptyStrongMemoryCache2 = workManagerImpl.mPreferenceUtils;
        WorkDatabase workDatabase2 = workManagerImpl.mWorkDatabase;
        String str = SystemJobScheduler.TAG;
        Context context = this.mContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler);
        Request.Builder builderSystemIdInfoDao = workDatabase.systemIdInfoDao();
        builderSystemIdInfoDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) builderSystemIdInfoDao.url;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            HashSet hashSet = new HashSet(pendingJobs != null ? pendingJobs.size() : 0);
            if (pendingJobs != null && !pendingJobs.isEmpty()) {
                int size = pendingJobs.size();
                int i = 0;
                while (i < size) {
                    Object obj = pendingJobs.get(i);
                    i++;
                    JobInfo jobInfo = (JobInfo) obj;
                    WorkGenerationalId workGenerationalIdFromJobInfo = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo);
                    if (workGenerationalIdFromJobInfo != null) {
                        hashSet.add(workGenerationalIdFromJobInfo.workSpecId);
                    } else {
                        SystemJobScheduler.cancelJobById(jobScheduler, jobInfo.getId());
                    }
                }
            }
            int size2 = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    z = false;
                    break;
                }
                Object obj2 = arrayList.get(i2);
                i2++;
                if (!hashSet.contains((String) obj2)) {
                    Logger$LogcatLogger.get().debug(SystemJobScheduler.TAG, "Reconciling jobs");
                    z = true;
                    break;
                }
            }
            if (z) {
                workDatabase.beginTransaction();
                try {
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                    int size3 = arrayList.size();
                    int i3 = 0;
                    while (i3 < size3) {
                        Object obj3 = arrayList.get(i3);
                        i3++;
                        workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled((String) obj3, -1L);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                } catch (Throwable th) {
                    workDatabase.internalEndTransaction();
                    throw th;
                }
            }
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase2.workSpecDao();
            SVG svgWorkProgressDao = workDatabase2.workProgressDao();
            workDatabase2.beginTransaction();
            try {
                ArrayList runningWork = workSpecDao_ImplWorkSpecDao2.getRunningWork();
                boolean zIsEmpty = runningWork.isEmpty();
                if (!zIsEmpty) {
                    int size4 = runningWork.size();
                    int i4 = 0;
                    while (i4 < size4) {
                        Object obj4 = runningWork.get(i4);
                        i4++;
                        String str2 = ((WorkSpec) obj4).id;
                        workSpecDao_ImplWorkSpecDao2.setState(str2, 1);
                        workSpecDao_ImplWorkSpecDao2.setStopReason(str2, -512);
                        workSpecDao_ImplWorkSpecDao2.markWorkSpecScheduled(str2, -1L);
                        runningWork = runningWork;
                        zIsEmpty = zIsEmpty;
                    }
                }
                boolean z2 = zIsEmpty;
                WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) svgWorkProgressDao.rootElement;
                workDatabase_Impl2.assertNotSuspendingTransaction();
                WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) svgWorkProgressDao.idToElementMap;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
                workDatabase_Impl2.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl2.setTransactionSuccessful();
                    workDatabase_Impl2.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                    workDatabase2.setTransactionSuccessful();
                    workDatabase2.internalEndTransaction();
                    boolean z3 = !z2 || z;
                    Long longValue = ((WorkDatabase) emptyStrongMemoryCache2.weakMemoryCache).preferenceDao().getLongValue("reschedule_needed");
                    String str3 = TAG;
                    if (longValue != null && longValue.longValue() == 1) {
                        Logger$LogcatLogger.get().debug(str3, "Rescheduling Workers.");
                        workManagerImpl.rescheduleEligibleWork();
                        emptyStrongMemoryCache2.getClass();
                        ((WorkDatabase) emptyStrongMemoryCache2.weakMemoryCache).preferenceDao().insertPreference(new Preference("reschedule_needed", 0L));
                        return;
                    }
                    try {
                        int i5 = Build.VERSION.SDK_INT;
                        int i6 = i5 >= 31 ? 570425344 : 536870912;
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
                        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i6);
                        if (i5 < 30) {
                            if (broadcast == null) {
                                setAlarm(context);
                                Logger$LogcatLogger.get().debug(str3, "Application was force-stopped, rescheduling.");
                                workManagerImpl.rescheduleEligibleWork();
                                configuration.clock.getClass();
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                emptyStrongMemoryCache.getClass();
                                ((WorkDatabase) emptyStrongMemoryCache.weakMemoryCache).preferenceDao().insertPreference(new Preference("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis)));
                                return;
                            }
                            if (z3) {
                                Logger$LogcatLogger.get().debug(str3, "Found unfinished work, scheduling it.");
                                Schedulers.schedule(configuration, workDatabase2, workManagerImpl.mSchedulers);
                            }
                        }
                        if (broadcast != null) {
                            broadcast.cancel();
                        }
                        List historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                        if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                            Long longValue2 = ((WorkDatabase) emptyStrongMemoryCache.weakMemoryCache).preferenceDao().getLongValue("last_force_stop_ms");
                            long jLongValue = longValue2 != null ? longValue2.longValue() : 0L;
                            for (int i7 = 0; i7 < historicalProcessExitReasons.size(); i7++) {
                                ApplicationExitInfo applicationExitInfoM = ForceStopRunnable$$ExternalSyntheticApiModelOutline0.m(historicalProcessExitReasons.get(i7));
                                if (applicationExitInfoM.getReason() == 10 && applicationExitInfoM.getTimestamp() >= jLongValue) {
                                    Logger$LogcatLogger.get().debug(str3, "Application was force-stopped, rescheduling.");
                                    workManagerImpl.rescheduleEligibleWork();
                                    configuration.clock.getClass();
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    emptyStrongMemoryCache.getClass();
                                    ((WorkDatabase) emptyStrongMemoryCache.weakMemoryCache).preferenceDao().insertPreference(new Preference("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis2)));
                                    return;
                                }
                            }
                        }
                        if (z3) {
                            Logger$LogcatLogger.get().debug(str3, "Found unfinished work, scheduling it.");
                            Schedulers.schedule(configuration, workDatabase2, workManagerImpl.mSchedulers);
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                        if (Logger$LogcatLogger.get().mLoggingLevel <= 5) {
                            Log.w(str3, "Ignoring exception", e);
                        }
                    } catch (SecurityException e2) {
                        e = e2;
                        if (Logger$LogcatLogger.get().mLoggingLevel <= 5) {
                            Log.w(str3, "Ignoring exception", e);
                        }
                    }
                } catch (Throwable th2) {
                    workDatabase_Impl2.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                    throw th2;
                }
            } catch (Throwable th3) {
                workDatabase2.internalEndTransaction();
                throw th3;
            }
        } catch (Throwable th4) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th4;
        }
    }

    public final boolean multiProcessChecks() {
        this.mWorkManager.mConfiguration.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = TAG;
        if (zIsEmpty) {
            Logger$LogcatLogger.get().debug(str, "The default process name was not specified.");
            return true;
        }
        boolean zIsDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext);
        Logger$LogcatLogger.get().debug(str, "Is default app process = " + zIsDefaultProcess);
        return zIsDefaultProcess;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.mContext;
        String str = TAG;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        try {
            if (!multiProcessChecks()) {
                workManagerImpl.onForceStopRunnableCompleted();
                return;
            }
            while (true) {
                try {
                    WorkDatabasePathHelper.migrateDatabase(context);
                    Logger$LogcatLogger.get().debug(str, "Performing cleanup operations.");
                    try {
                        forceStopRunnable();
                        workManagerImpl.onForceStopRunnableCompleted();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e) {
                        int i = this.mRetryCount + 1;
                        this.mRetryCount = i;
                        if (i >= 3) {
                            String str2 = Build.VERSION.SDK_INT >= 24 ? LocaleListCompat.Api24Impl.isUserUnlocked(context) : true ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            Logger$LogcatLogger.get().error(str, str2, e);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e);
                            workManagerImpl.mConfiguration.getClass();
                            throw illegalStateException;
                        }
                        String str3 = "Retrying after " + (((long) i) * 300);
                        if (Logger$LogcatLogger.get().mLoggingLevel <= 3) {
                            Log.d(str, str3, e);
                        }
                        try {
                            Thread.sleep(((long) this.mRetryCount) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e2) {
                    Logger$LogcatLogger.get().error(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e2);
                    workManagerImpl.mConfiguration.getClass();
                    throw illegalStateException2;
                }
            }
        } catch (Throwable th) {
            workManagerImpl.onForceStopRunnableCompleted();
            throw th;
        }
    }
}
