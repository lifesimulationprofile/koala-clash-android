package androidx.work.impl;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.SystemClock;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CleanupCallback {
    public final SystemClock clock;

    public CleanupCallback(SystemClock systemClock) {
        this.clock = systemClock;
    }

    public final void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
            this.clock.getClass();
            sb.append(System.currentTimeMillis() - WorkDatabaseKt.PRUNE_THRESHOLD_MILLIS);
            sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            frameworkSQLiteDatabase.execSQL(sb.toString());
            frameworkSQLiteDatabase.setTransactionSuccessful();
        } finally {
            frameworkSQLiteDatabase.endTransaction();
        }
    }
}
