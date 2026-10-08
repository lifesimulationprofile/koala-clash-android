package androidx.work.impl.utils;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Operation;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    public final RequestService mOperation = new RequestService(17);

    /* JADX INFO: renamed from: androidx.work.impl.utils.CancelWorkRunnable$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass3 extends CancelWorkRunnable {
        public final /* synthetic */ boolean val$allowReschedule;
        public final /* synthetic */ String val$name;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public AnonymousClass3(WorkManagerImpl workManagerImpl, String str, boolean z) {
            this.val$workManagerImpl = workManagerImpl;
            this.val$name = str;
            this.val$allowReschedule = z;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        public final void runInternal() {
            WorkManagerImpl workManagerImpl = this.val$workManagerImpl;
            WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                ArrayList unfinishedWorkWithName = workDatabase.workSpecDao().getUnfinishedWorkWithName(this.val$name);
                int size = unfinishedWorkWithName.size();
                int i = 0;
                while (i < size) {
                    Object obj = unfinishedWorkWithName.get(i);
                    i++;
                    CancelWorkRunnable.cancel(workManagerImpl, (String) obj);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.internalEndTransaction();
                if (this.val$allowReschedule) {
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
            } catch (Throwable th) {
                workDatabase.internalEndTransaction();
                throw th;
            }
        }
    }

    public static void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        WorkLauncherImpl workLauncherImplDependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int state = workSpecDao_ImplWorkSpecDao.getState(str2);
            if (state != 3 && state != 4) {
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) workSpecDao_ImplWorkSpecDao.__preparedStmtOfSetCancelledState;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
                if (str2 == null) {
                    frameworkSQLiteStatementAcquire.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire.bindString(str2, 1);
                }
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                } catch (Throwable th) {
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                    throw th;
                }
            }
            linkedList.addAll(workLauncherImplDependencyDao.getDependentWorkIds(str2));
        }
        Processor processor = workManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            Logger$LogcatLogger.get().debug(Processor.TAG, "Processor cancelling " + str);
            processor.mCancelledIds.add(str);
            workerWrapperCleanUpWorkerUnsafe = processor.cleanUpWorkerUnsafe(str);
        }
        Processor.interrupt(str, workerWrapperCleanUpWorkerUnsafe, 1);
        Iterator it = workManagerImpl.mSchedulers.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(str);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        RequestService requestService = this.mOperation;
        try {
            runInternal();
            requestService.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            requestService.markState(new Operation.State.FAILURE(th));
        }
    }

    public abstract void runInternal();
}
