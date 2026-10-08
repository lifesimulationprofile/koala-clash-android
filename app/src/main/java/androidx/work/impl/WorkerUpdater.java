package androidx.work.impl;

import android.os.Build;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import coil.ImageLoader$Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkerUpdater {
    public static final void updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List list, final WorkSpec workSpec, final Set set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Worker with ", str, " doesn't exist"));
        }
        if (Density.CC._isFinished(workSpec2.state)) {
            return;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            StringBuilder sb = new StringBuilder("Can't update ");
            sb.append(workSpec2.isPeriodic() ? "Periodic" : "OneTime");
            sb.append(" Worker to ");
            throw new UnsupportedOperationException(ImageAnalysis$$ExternalSyntheticLambda1.m(sb, workSpec.isPeriodic() ? "Periodic" : "OneTime", " Worker. Update operation must preserve worker's type."));
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        Runnable runnable = new Runnable(workSpec2, workSpec, list, str, set, zIsEnqueued) { // from class: androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda1
            public final /* synthetic */ WorkSpec f$1;
            public final /* synthetic */ WorkSpec f$2;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ Set f$5;
            public final /* synthetic */ boolean f$6;

            {
                this.f$4 = str;
                this.f$5 = set;
                this.f$6 = zIsEnqueued;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                WorkDatabase workDatabase2 = this.f$0;
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase2.workSpecDao();
                ImageLoader$Builder imageLoader$BuilderWorkTagDao = workDatabase2.workTagDao();
                WorkSpec workSpec3 = this.f$1;
                int i = workSpec3.state;
                int i2 = workSpec3.runAttemptCount;
                long j = workSpec3.lastEnqueueTime;
                int i3 = workSpec3.generation + 1;
                int i4 = workSpec3.periodCount;
                long j2 = workSpec3.nextScheduleTimeOverride;
                int i5 = workSpec3.nextScheduleTimeOverrideGeneration;
                WorkSpec workSpec4 = this.f$2;
                WorkSpec workSpecCopy$default = WorkSpec.copy$default(workSpec4, null, i, null, null, i2, j, i4, i3, j2, i5, 4447229);
                if (workSpec4.nextScheduleTimeOverrideGeneration == 1) {
                    workSpecCopy$default.nextScheduleTimeOverride = workSpec4.nextScheduleTimeOverride;
                    workSpecCopy$default.nextScheduleTimeOverrideGeneration++;
                }
                if (Build.VERSION.SDK_INT < 26) {
                    Constraints constraints = workSpecCopy$default.constraints;
                    String str2 = workSpecCopy$default.workerClassName;
                    if (Intrinsics.areEqual(str2, ConstraintTrackingWorker.class.getName()) || !(constraints.requiresBatteryNotLow || constraints.requiresStorageNotLow)) {
                        workSpecCopy$default = workSpecCopy$default;
                    } else {
                        Data.Builder builder = new Data.Builder();
                        builder.putAll(workSpecCopy$default.input.mValues);
                        builder.mValues.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str2);
                        Data data = new Data(builder.mValues);
                        Data.toByteArrayInternal(data);
                        workSpecCopy$default = WorkSpec.copy$default(workSpecCopy$default, null, 0, ConstraintTrackingWorker.class.getName(), data, 0, 0L, 0, 0, 0L, 0, 8388587);
                    }
                }
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
                workDatabase_Impl.assertNotSuspendingTransaction();
                workDatabase_Impl.beginTransaction();
                try {
                    WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = (WorkSpecDao_Impl.AnonymousClass2) workSpecDao_ImplWorkSpecDao.__updateAdapterOfWorkSpec;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                    try {
                        anonymousClass2.bind(frameworkSQLiteStatementAcquire, workSpecCopy$default);
                        frameworkSQLiteStatementAcquire.executeUpdateDelete();
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        workDatabase_Impl.setTransactionSuccessful();
                        workDatabase_Impl.internalEndTransaction();
                        WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) imageLoader$BuilderWorkTagDao.applicationContext;
                        workDatabase_Impl2.assertNotSuspendingTransaction();
                        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) imageLoader$BuilderWorkTagDao.options;
                        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = workTagDao_Impl$2.acquire();
                        String str3 = this.f$4;
                        frameworkSQLiteStatementAcquire2.bindString(str3, 1);
                        workDatabase_Impl2.beginTransaction();
                        try {
                            frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                            workDatabase_Impl2.setTransactionSuccessful();
                            workDatabase_Impl2.internalEndTransaction();
                            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire2);
                            imageLoader$BuilderWorkTagDao.insertTags(str3, this.f$5);
                            if (this.f$6) {
                                return;
                            }
                            workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled(str3, -1L);
                            workDatabase2.workProgressDao().delete(str3);
                        } catch (Throwable th) {
                            workDatabase_Impl2.internalEndTransaction();
                            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    workDatabase_Impl.internalEndTransaction();
                    throw th3;
                }
            }
        };
        workDatabase.beginTransaction();
        try {
            runnable.run();
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            if (zIsEnqueued) {
                return;
            }
            Schedulers.schedule(configuration, workDatabase, list);
        } catch (Throwable th) {
            workDatabase.internalEndTransaction();
            throw th;
        }
    }
}
