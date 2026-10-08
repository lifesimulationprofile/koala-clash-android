package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import coil.disk.RealDiskCache;
import java.util.concurrent.Callable;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Alarms {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Alarms");

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Api19Impl {
        public static void setExact(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExact(i, j, pendingIntent);
        }
    }

    public static void cancelExactAlarm(Context context, WorkGenerationalId workGenerationalId, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = CommandHandler.TAG;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        PendingIntent service = PendingIntent.getService(context, i, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger$LogcatLogger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i + ")");
        alarmManager.cancel(service);
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long j) {
        Request.Builder builderSystemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = builderSystemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            int i = systemIdInfo.systemId;
            cancelExactAlarm(context, workGenerationalId, i);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = CommandHandler.TAG;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
            PendingIntent service = PendingIntent.getService(context, i, intent, 201326592);
            if (alarmManager != null) {
                Api19Impl.setExact(alarmManager, 0, j, service);
                return;
            }
            return;
        }
        final RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(28, workDatabase);
        int iIntValue = ((Number) workDatabase.runInTransaction(new Callable() { // from class: androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase2 = (WorkDatabase) realEditor.editor;
                Long longValue = workDatabase2.preferenceDao().getLongValue("next_alarm_manager_id");
                int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
                workDatabase2.preferenceDao().insertPreference(new Preference("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
            }
        })).intValue();
        builderSystemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(workGenerationalId.generation, iIntValue, workGenerationalId.workSpecId));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = CommandHandler.TAG;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        CommandHandler.writeWorkGenerationalId(intent2, workGenerationalId);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            Api19Impl.setExact(alarmManager2, 0, j, service2);
        }
    }
}
