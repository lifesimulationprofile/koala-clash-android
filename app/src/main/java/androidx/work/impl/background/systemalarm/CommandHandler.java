package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.compose.ui.unit.Density;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CommandHandler implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("CommandHandler");
    public final SystemClock mClock;
    public final Context mContext;
    public final StartStopTokens mStartStopTokens;
    public final HashMap mPendingDelayMet = new HashMap();
    public final Object mLock = new Object();

    public CommandHandler(Context context, SystemClock systemClock, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mClock = systemClock;
        this.mStartStopTokens = startStopTokens;
    }

    public static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void writeWorkGenerationalId(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.workSpecId);
        intent.putExtra("KEY_WORKSPEC_GENERATION", workGenerationalId.generation);
    }

    public final boolean hasPendingCommands() {
        boolean z;
        synchronized (this.mLock) {
            z = !this.mPendingDelayMet.isEmpty();
        }
        return z;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.mLock) {
            try {
                DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) this.mPendingDelayMet.remove(workGenerationalId);
                this.mStartStopTokens.remove(workGenerationalId);
                if (delayMetCommandHandler != null) {
                    delayMetCommandHandler.onExecuted(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onHandleIntent(Intent intent, int i, SystemAlarmDispatcher systemAlarmDispatcher) throws Throwable {
        List<StartStopToken> listRemove;
        ArrayList arrayList;
        String action = intent.getAction();
        int i2 = 2;
        int i3 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            Logger$LogcatLogger.get().debug(TAG, "Handling constraints changed " + intent);
            Context context = this.mContext;
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(context, this.mClock, i, systemAlarmDispatcher);
            ArrayList scheduledWork = systemAlarmDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getScheduledWork();
            String str = ConstraintProxy.TAG;
            int size = scheduledWork.size();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int i4 = 0;
            while (i4 < size) {
                Object obj = scheduledWork.get(i4);
                i4++;
                Constraints constraints = ((WorkSpec) obj).constraints;
                z |= constraints.requiresBatteryNotLow;
                z2 |= constraints.requiresCharging;
                z3 |= constraints.requiresStorageNotLow;
                z4 |= constraints.requiredNetworkType != 1;
                if (z && z2 && z3 && z4) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.TAG;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
            context.sendBroadcast(intent2);
            ArrayList arrayList2 = new ArrayList(scheduledWork.size());
            constraintsCommandHandler.mClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size2 = scheduledWork.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = scheduledWork.get(i5);
                i5++;
                WorkSpec workSpec = (WorkSpec) obj2;
                if (jCurrentTimeMillis >= workSpec.calculateNextRunTime() && (!workSpec.hasConstraints() || constraintsCommandHandler.mWorkConstraintsTracker.areAllConstraintsMet(workSpec))) {
                    arrayList2.add(workSpec);
                }
            }
            int size3 = arrayList2.size();
            while (i3 < size3) {
                Object obj3 = arrayList2.get(i3);
                i3++;
                WorkSpec workSpec2 = (WorkSpec) obj3;
                String str3 = workSpec2.id;
                WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                writeWorkGenerationalId(intent3, workGenerationalIdGenerationalId);
                Logger$LogcatLogger.get().debug(ConstraintsCommandHandler.TAG, "Creating a delay_met command for workSpec with id (" + str3 + ")");
                systemAlarmDispatcher.mTaskExecutor.mMainThreadExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent3, constraintsCommandHandler.mStartId, i2));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            Logger$LogcatLogger.get().debug(TAG, "Handling reschedule " + intent + ", " + i);
            systemAlarmDispatcher.mWorkManager.rescheduleEligibleWork();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            Logger$LogcatLogger.get().error(TAG, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            Context context2 = this.mContext;
            WorkGenerationalId workGenerationalId = readWorkGenerationalId(intent);
            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
            String str4 = TAG;
            logger$LogcatLogger.debug(str4, "Handling schedule work for " + workGenerationalId);
            WorkDatabase workDatabase = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec3 = workDatabase.workSpecDao().getWorkSpec(workGenerationalId.workSpecId);
                if (workSpec3 == null) {
                    Logger$LogcatLogger.get().warning(str4, "Skipping scheduling " + workGenerationalId + " because it's no longer in the DB");
                    return;
                }
                if (Density.CC._isFinished(workSpec3.state)) {
                    Logger$LogcatLogger.get().warning(str4, "Skipping scheduling " + workGenerationalId + "because it is finished.");
                    return;
                }
                long jCalculateNextRunTime = workSpec3.calculateNextRunTime();
                if (workSpec3.hasConstraints()) {
                    Logger$LogcatLogger.get().debug(str4, "Opportunistically setting an alarm for " + workGenerationalId + "at " + jCalculateNextRunTime);
                    Alarms.setAlarm(context2, workDatabase, workGenerationalId, jCalculateNextRunTime);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    systemAlarmDispatcher.mTaskExecutor.mMainThreadExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent4, i, i2));
                } else {
                    Logger$LogcatLogger.get().debug(str4, "Setting up Alarms for " + workGenerationalId + "at " + jCalculateNextRunTime);
                    Alarms.setAlarm(context2, workDatabase, workGenerationalId, jCalculateNextRunTime);
                }
                workDatabase.setTransactionSuccessful();
                return;
            } finally {
                workDatabase.internalEndTransaction();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.mLock) {
                try {
                    WorkGenerationalId workGenerationalId2 = readWorkGenerationalId(intent);
                    Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                    String str5 = TAG;
                    logger$LogcatLogger2.debug(str5, "Handing delay met for " + workGenerationalId2);
                    if (this.mPendingDelayMet.containsKey(workGenerationalId2)) {
                        Logger$LogcatLogger.get().debug(str5, "WorkSpec " + workGenerationalId2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i, systemAlarmDispatcher, this.mStartStopTokens.tokenFor(workGenerationalId2));
                        this.mPendingDelayMet.put(workGenerationalId2, delayMetCommandHandler);
                        delayMetCommandHandler.handleProcessWork();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                Logger$LogcatLogger.get().warning(TAG, "Ignoring intent " + intent);
                return;
            }
            WorkGenerationalId workGenerationalId3 = readWorkGenerationalId(intent);
            boolean z5 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            Logger$LogcatLogger.get().debug(TAG, "Handling onExecutionCompleted " + intent + ", " + i);
            onExecuted(workGenerationalId3, z5);
            return;
        }
        StartStopTokens startStopTokens = this.mStartStopTokens;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        if (extras2.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i6 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            arrayList = new ArrayList(1);
            StartStopToken startStopTokenRemove = startStopTokens.remove(new WorkGenerationalId(string, i6));
            if (startStopTokenRemove != null) {
                listRemove = arrayList;
                arrayList.add(startStopTokenRemove);
                listRemove = arrayList;
            }
        } else {
            listRemove = startStopTokens.remove(string);
        }
        listRemove = arrayList;
        for (StartStopToken startStopToken : listRemove) {
            Logger$LogcatLogger.get().debug(TAG, "Handing stopWork work for " + string);
            systemAlarmDispatcher.mWorkLauncher.stopWork(startStopToken, -512);
            Context context3 = this.mContext;
            WorkDatabase workDatabase2 = systemAlarmDispatcher.mWorkManager.mWorkDatabase;
            WorkGenerationalId workGenerationalId4 = startStopToken.id;
            String str6 = Alarms.TAG;
            Request.Builder builderSystemIdInfoDao = workDatabase2.systemIdInfoDao();
            SystemIdInfo systemIdInfo = builderSystemIdInfoDao.getSystemIdInfo(workGenerationalId4);
            if (systemIdInfo != null) {
                Alarms.cancelExactAlarm(context3, workGenerationalId4, systemIdInfo.systemId);
                Logger$LogcatLogger.get().debug(Alarms.TAG, "Removing SystemIdInfo for workSpecId (" + workGenerationalId4 + ")");
                String str7 = workGenerationalId4.workSpecId;
                int i7 = workGenerationalId4.generation;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) builderSystemIdInfoDao.url;
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) builderSystemIdInfoDao.headers;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
                if (str7 == null) {
                    frameworkSQLiteStatementAcquire.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire.bindString(str7, 1);
                }
                frameworkSQLiteStatementAcquire.bindLong(2, i7);
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                } catch (Throwable th2) {
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                    throw th2;
                }
            }
            systemAlarmDispatcher.onExecuted(startStopToken.id, false);
        }
    }
}
