package androidx.work.impl.utils;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Operation;
import androidx.work.WorkRequest;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("EnqueueRunnable");
    public final RequestService mOperation;
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, RequestService requestService) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = requestService;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0137  */
    /* JADX WARN: Code duplicated, block: B:70:0x013c  */
    /* JADX WARN: Code duplicated, block: B:71:0x013e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0144  */
    /* JADX WARN: Code duplicated, block: B:75:0x0147  */
    /* JADX WARN: Code duplicated, block: B:77:0x014a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0154  */
    /* JADX WARN: Code duplicated, block: B:96:0x019f  */
    public static boolean processContinuation(WorkContinuationImpl workContinuationImpl) throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        List list;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        boolean z9;
        HashSet hashSetPrerequisitesFor = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        List list2 = workContinuationImpl.mWork;
        int i2 = 0;
        String[] strArr = (String[]) hashSetPrerequisitesFor.toArray(new String[0]);
        String str = workContinuationImpl.mName;
        int i3 = workContinuationImpl.mExistingWorkPolicy;
        workManagerImpl.mConfiguration.clock.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        boolean z10 = strArr != null && strArr.length > 0;
        if (z10) {
            int length = strArr.length;
            z = false;
            z2 = false;
            z3 = true;
            while (true) {
                if (i2 < length) {
                    String str2 = strArr[i2];
                    WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(str2);
                    if (workSpec == null) {
                        Logger$LogcatLogger.get().error(TAG, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    } else {
                        int i4 = workSpec.state;
                        z3 &= i4 == 3;
                        if (i4 == 4) {
                            z2 = true;
                        } else if (i4 == 6) {
                            z = true;
                        }
                        i2++;
                    }
                }
                z6 = false;
                workContinuationImpl.mEnqueued = true;
                return z6;
            }
        }
        z = false;
        z2 = false;
        z3 = true;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty || z10) {
            list = list2;
            z4 = zIsEmpty;
            z5 = false;
        } else {
            ArrayList workSpecIdAndStatesForName = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (workSpecIdAndStatesForName.isEmpty()) {
                list = list2;
                z4 = zIsEmpty;
            } else if (i3 == 3 || i3 == 4) {
                WorkLauncherImpl workLauncherImplDependencyDao = workDatabase.dependencyDao();
                ArrayList arrayList = new ArrayList();
                int size = workSpecIdAndStatesForName.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = workSpecIdAndStatesForName.get(i5);
                    i5++;
                    WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) obj;
                    String str3 = idAndState.id;
                    List list3 = list2;
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workLauncherImplDependencyDao.processor;
                    WorkLauncherImpl workLauncherImpl = workLauncherImplDependencyDao;
                    boolean z11 = zIsEmpty;
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                    if (str3 == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(str3, 1);
                    }
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            z7 = false;
                            if (cursorQuery.getInt(0) != 0) {
                                z8 = true;
                            }
                            cursorQuery.close();
                            roomSQLiteQueryAcquire.release();
                            if (z8) {
                                i = idAndState.state;
                                if (i == 3) {
                                    z9 = true;
                                } else {
                                    z9 = z7;
                                }
                                boolean z12 = z3 & z9;
                                if (i == 4) {
                                    z2 = true;
                                } else if (i == 6) {
                                    z = true;
                                }
                                arrayList.add(idAndState.id);
                                z3 = z12;
                            }
                            list2 = list3;
                            workLauncherImplDependencyDao = workLauncherImpl;
                            zIsEmpty = z11;
                        } else {
                            z7 = false;
                        }
                        z8 = z7;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        if (z8) {
                            i = idAndState.state;
                            if (i == 3) {
                                z9 = true;
                            } else {
                                z9 = z7;
                            }
                            boolean z13 = z3 & z9;
                            if (i == 4) {
                                z2 = true;
                            } else if (i == 6) {
                                z = true;
                            }
                            arrayList.add(idAndState.id);
                            z3 = z13;
                        }
                        list2 = list3;
                        workLauncherImplDependencyDao = workLauncherImpl;
                        zIsEmpty = z11;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                }
                list = list2;
                z4 = zIsEmpty;
                List list4 = arrayList;
                list4 = arrayList;
                if (i3 == 4 && (z || z2)) {
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                    ArrayList workSpecIdAndStatesForName2 = workSpecDao_ImplWorkSpecDao.getWorkSpecIdAndStatesForName(str);
                    int size2 = workSpecIdAndStatesForName2.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj2 = workSpecIdAndStatesForName2.get(i6);
                        i6++;
                        workSpecDao_ImplWorkSpecDao.delete(((WorkSpec.IdAndState) obj2).id);
                    }
                    z = false;
                    z2 = false;
                    list4 = Collections.EMPTY_LIST;
                }
                strArr = (String[]) list4.toArray(strArr);
                z10 = strArr.length > 0;
            } else {
                if (i3 == 2) {
                    int size3 = workSpecIdAndStatesForName.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 < size3) {
                            Object obj3 = workSpecIdAndStatesForName.get(i7);
                            i7++;
                            int i8 = ((WorkSpec.IdAndState) obj3).state;
                            if (i8 == 1 || i8 == 2) {
                                z6 = false;
                                workContinuationImpl.mEnqueued = true;
                                return z6;
                            }
                        }
                    }
                }
                new CancelWorkRunnable.AnonymousClass3(workManagerImpl, str, false).run();
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase.workSpecDao();
                int size4 = workSpecIdAndStatesForName.size();
                int i9 = 0;
                while (i9 < size4) {
                    Object obj4 = workSpecIdAndStatesForName.get(i9);
                    i9++;
                    workSpecDao_ImplWorkSpecDao2.delete(((WorkSpec.IdAndState) obj4).id);
                }
                list = list2;
                z4 = zIsEmpty;
                z5 = true;
            }
            z5 = false;
        }
        boolean z14 = z5;
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            WorkRequest workRequest = (WorkRequest) it.next();
            WorkSpec workSpecCopy$default = workRequest.workSpec;
            UUID uuid = workRequest.id;
            if (!z10 || z3) {
                workSpecCopy$default.lastEnqueueTime = jCurrentTimeMillis;
            } else if (z2) {
                workSpecCopy$default.state = 4;
            } else if (z) {
                workSpecCopy$default.state = 6;
            } else {
                workSpecCopy$default.state = 5;
            }
            if (workSpecCopy$default.state == 1) {
                z14 = true;
            }
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao3 = workDatabase.workSpecDao();
            if (Build.VERSION.SDK_INT < 26) {
                Constraints constraints = workSpecCopy$default.constraints;
                String str4 = workSpecCopy$default.workerClassName;
                if (Intrinsics.areEqual(str4, ConstraintTrackingWorker.class.getName()) || !(constraints.requiresBatteryNotLow || constraints.requiresStorageNotLow)) {
                    workSpecCopy$default = workSpecCopy$default;
                } else {
                    Data.Builder builder = new Data.Builder();
                    builder.putAll(workSpecCopy$default.input.mValues);
                    builder.mValues.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str4);
                    Data data = new Data(builder.mValues);
                    Data.toByteArrayInternal(data);
                    workSpecCopy$default = WorkSpec.copy$default(workSpecCopy$default, null, 0, ConstraintTrackingWorker.class.getName(), data, 0, 0L, 0, 0, 0L, 0, 8388587);
                }
            }
            WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao3.__db;
            workDatabase_Impl2.assertNotSuspendingTransaction();
            workDatabase_Impl2.beginTransaction();
            try {
                ((WorkTagDao_Impl$1) workSpecDao_ImplWorkSpecDao3.__insertionAdapterOfWorkSpec).insert(workSpecCopy$default);
                workDatabase_Impl2.setTransactionSuccessful();
                workDatabase_Impl2.internalEndTransaction();
                if (z10) {
                    for (String str5 : strArr) {
                        Dependency dependency = new Dependency(uuid.toString(), str5);
                        WorkLauncherImpl workLauncherImplDependencyDao2 = workDatabase.dependencyDao();
                        WorkDatabase_Impl workDatabase_Impl3 = (WorkDatabase_Impl) workLauncherImplDependencyDao2.processor;
                        workDatabase_Impl3.assertNotSuspendingTransaction();
                        workDatabase_Impl3.beginTransaction();
                        try {
                            ((WorkTagDao_Impl$1) workLauncherImplDependencyDao2.workTaskExecutor).insert(dependency);
                            workDatabase_Impl3.setTransactionSuccessful();
                            workDatabase_Impl3.internalEndTransaction();
                        } catch (Throwable th2) {
                            workDatabase_Impl3.internalEndTransaction();
                            throw th2;
                        }
                    }
                }
                workDatabase.workTagDao().insertTags(uuid.toString(), workRequest.tags);
                if (!z4) {
                    RequestService requestServiceWorkNameDao = workDatabase.workNameDao();
                    WorkName workName = new WorkName(str, uuid.toString());
                    WorkDatabase_Impl workDatabase_Impl4 = (WorkDatabase_Impl) requestServiceWorkNameDao.systemCallbacks;
                    workDatabase_Impl4.assertNotSuspendingTransaction();
                    workDatabase_Impl4.beginTransaction();
                    try {
                        ((WorkTagDao_Impl$1) requestServiceWorkNameDao.hardwareBitmapService).insert(workName);
                        workDatabase_Impl4.setTransactionSuccessful();
                        workDatabase_Impl4.internalEndTransaction();
                    } catch (Throwable th3) {
                        workDatabase_Impl4.internalEndTransaction();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                workDatabase_Impl2.internalEndTransaction();
                throw th4;
            }
        }
        z6 = z14;
        workContinuationImpl.mEnqueued = true;
        return z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        RequestService requestService = this.mOperation;
        WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        try {
            HashSet hashSet = new HashSet();
            hashSet.addAll(workContinuationImpl.mIds);
            HashSet hashSetPrerequisitesFor = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(workContinuationImpl.mIds);
                    z = false;
                    break;
                } else if (hashSetPrerequisitesFor.contains((String) it.next())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                throw new IllegalStateException("WorkContinuation has cycles (" + workContinuationImpl + ")");
            }
            WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.mConfiguration, workContinuationImpl);
                boolean zProcessContinuation = processContinuation(workContinuationImpl);
                workDatabase.setTransactionSuccessful();
                workDatabase.internalEndTransaction();
                if (zProcessContinuation) {
                    PackageManagerHelper.setComponentEnabled(workManagerImpl.mContext, RescheduleReceiver.class, true);
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
                requestService.markState(Operation.SUCCESS);
            } catch (Throwable th) {
                workDatabase.internalEndTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            requestService.markState(new Operation.State.FAILURE(th2));
        }
    }
}
