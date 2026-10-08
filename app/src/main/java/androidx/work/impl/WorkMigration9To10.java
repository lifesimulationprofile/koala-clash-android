package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkMigration9To10 extends Migration {
    public final /* synthetic */ int $r8$classId = 0;
    public final Context context;

    public WorkMigration9To10(Context context, int i, int i2) {
        super(i, i2);
        this.context = context;
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        int i = this.$r8$classId;
        Context context = this.context;
        switch (i) {
            case 0:
                frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    frameworkSQLiteDatabase.beginTransaction();
                    try {
                        frameworkSQLiteDatabase.execSQL(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                        frameworkSQLiteDatabase.execSQL(new Object[]{"reschedule_needed", Long.valueOf(j2)});
                        sharedPreferences.edit().clear().apply();
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        frameworkSQLiteDatabase.endTransaction();
                    } catch (Throwable th) {
                        frameworkSQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i2 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i3 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    frameworkSQLiteDatabase.beginTransaction();
                    try {
                        frameworkSQLiteDatabase.execSQL(new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                        frameworkSQLiteDatabase.execSQL(new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                        sharedPreferences2.edit().clear().apply();
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        return;
                    } finally {
                        frameworkSQLiteDatabase.endTransaction();
                    }
                }
                return;
            default:
                if (this.endVersion >= 10) {
                    frameworkSQLiteDatabase.execSQL(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    context.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
        }
    }

    public WorkMigration9To10(Context context) {
        super(9, 10);
        this.context = context;
    }
}
