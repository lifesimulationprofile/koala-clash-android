package androidx.work.impl.utils;

import android.database.Cursor;
import android.os.Build;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Configuration;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i;
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList arrayListMutableListOf = MatrixExt.mutableListOf(workContinuationImpl);
        int i2 = 0;
        while (!arrayListMutableListOf.isEmpty()) {
            List list = ((WorkContinuationImpl) CollectionsKt__MutableCollectionsKt.removeLast(arrayListMutableListOf)).mWork;
            if (list.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).workSpec.constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i2 += i;
        }
        if (i2 == 0) {
            return;
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workSpecDao_ImplWorkSpecDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int i3 = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            int i4 = configuration.contentUriTriggerWorkersLimit;
            if (i3 + i2 <= i4) {
                return;
            }
            StringBuilder sb = new StringBuilder("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ");
            sb.append(i4);
            sb.append(";\nalready enqueued count: ");
            sb.append(i3);
            sb.append(";\ncurrent enqueue operation count: ");
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(sb, i2, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }
}
