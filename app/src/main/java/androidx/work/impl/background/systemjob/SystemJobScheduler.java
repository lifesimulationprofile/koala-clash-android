package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.disk.RealDiskCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemJobScheduler implements Scheduler {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemJobScheduler");
    public final Configuration mConfiguration;
    public final Context mContext;
    public final JobScheduler mJobScheduler;
    public final SystemJobInfoConverter mSystemJobInfoConverter;
    public final WorkDatabase mWorkDatabase;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context, configuration.clock);
        this.mContext = context;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
        this.mWorkDatabase = workDatabase;
        this.mConfiguration = configuration;
    }

    public static void cancelJobById(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static ArrayList getPendingJobIds(Context context, JobScheduler jobScheduler, String str) {
        ArrayList pendingJobs = getPendingJobs(context, jobScheduler);
        if (pendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        int size = pendingJobs.size();
        int i = 0;
        while (i < size) {
            Object obj = pendingJobs.get(i);
            i++;
            JobInfo jobInfo = (JobInfo) obj;
            WorkGenerationalId workGenerationalIdFromJobInfo = getWorkGenerationalIdFromJobInfo(jobInfo);
            if (workGenerationalIdFromJobInfo != null && str.equals(workGenerationalIdFromJobInfo.workSpecId)) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList getPendingJobs(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        Context context = this.mContext;
        JobScheduler jobScheduler = this.mJobScheduler;
        ArrayList pendingJobIds = getPendingJobIds(context, jobScheduler, str);
        if (pendingJobIds == null || pendingJobIds.isEmpty()) {
            return;
        }
        int size = pendingJobIds.size();
        int i = 0;
        while (i < size) {
            Object obj = pendingJobIds.get(i);
            i++;
            cancelJobById(jobScheduler, ((Integer) obj).intValue());
        }
        Request.Builder builderSystemIdInfoDao = this.mWorkDatabase.systemIdInfoDao();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) builderSystemIdInfoDao.url;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) builderSystemIdInfoDao.tags;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        int iIntValue;
        ArrayList pendingJobIds;
        int iIntValue2;
        WorkDatabase workDatabase = this.mWorkDatabase;
        final RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(28, workDatabase);
        WorkDatabase workDatabase2 = (WorkDatabase) realEditor.editor;
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                String str = workSpec.id;
                WorkSpec workSpec2 = workSpecDao_ImplWorkSpecDao.getWorkSpec(str);
                String str2 = TAG;
                if (workSpec2 == null) {
                    Logger$LogcatLogger.get().warning(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != 1) {
                    Logger$LogcatLogger.get().warning(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.setTransactionSuccessful();
                } else {
                    WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workGenerationalIdGenerationalId);
                    Configuration configuration = this.mConfiguration;
                    if (systemIdInfo != null) {
                        iIntValue = systemIdInfo.systemId;
                    } else {
                        configuration.getClass();
                        final int i = configuration.maxJobSchedulerId;
                        iIntValue = ((Number) workDatabase2.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda1
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                WorkDatabase workDatabase3 = (WorkDatabase) realEditor.editor;
                                Long longValue = workDatabase3.preferenceDao().getLongValue("next_job_scheduler_id");
                                int i2 = 0;
                                int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
                                workDatabase3.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i) {
                                    workDatabase3.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i2 = iLongValue;
                                }
                                return Integer.valueOf(i2);
                            }
                        })).intValue();
                    }
                    if (systemIdInfo == null) {
                        workDatabase.systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workGenerationalIdGenerationalId.generation, iIntValue, workGenerationalIdGenerationalId.workSpecId));
                    }
                    scheduleInternal(workSpec, iIntValue);
                    if (Build.VERSION.SDK_INT == 23 && (pendingJobIds = getPendingJobIds(this.mContext, this.mJobScheduler, str)) != null) {
                        int iIndexOf = pendingJobIds.indexOf(Integer.valueOf(iIntValue));
                        if (iIndexOf >= 0) {
                            pendingJobIds.remove(iIndexOf);
                        }
                        if (pendingJobIds.isEmpty()) {
                            configuration.getClass();
                            final int i2 = configuration.maxJobSchedulerId;
                            iIntValue2 = ((Number) workDatabase2.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda1
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    WorkDatabase workDatabase3 = (WorkDatabase) realEditor.editor;
                                    Long longValue = workDatabase3.preferenceDao().getLongValue("next_job_scheduler_id");
                                    int i3 = 0;
                                    int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
                                    workDatabase3.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                    if (iLongValue < 0 || iLongValue > i2) {
                                        workDatabase3.preferenceDao().insertPreference(new Preference("next_job_scheduler_id", Long.valueOf(1)));
                                    } else {
                                        i3 = iLongValue;
                                    }
                                    return Integer.valueOf(i3);
                                }
                            })).intValue();
                        } else {
                            iIntValue2 = ((Integer) pendingJobIds.get(0)).intValue();
                        }
                        scheduleInternal(workSpec, iIntValue2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.internalEndTransaction();
            } catch (Throwable th) {
                workDatabase.internalEndTransaction();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
    
        if (r10 < 26) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void scheduleInternal(androidx.work.impl.model.WorkSpec r21, int r22) {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobScheduler.scheduleInternal(androidx.work.impl.model.WorkSpec, int):void");
    }
}
