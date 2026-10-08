package androidx.work.impl;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Schedulers {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Schedulers");

    public static void markScheduled(WorkSpecDao_Impl workSpecDao_Impl, SystemClock systemClock, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            systemClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                workSpecDao_Impl.markWorkSpecScheduled(((WorkSpec) obj).id, jCurrentTimeMillis);
            }
        }
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List list) {
        ArrayList eligibleWorkForSchedulingWithContentUris;
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                eligibleWorkForSchedulingWithContentUris = workSpecDao_ImplWorkSpecDao.getEligibleWorkForSchedulingWithContentUris();
                markScheduled(workSpecDao_ImplWorkSpecDao, configuration.clock, eligibleWorkForSchedulingWithContentUris);
            } else {
                eligibleWorkForSchedulingWithContentUris = null;
            }
            ArrayList eligibleWorkForScheduling = workSpecDao_ImplWorkSpecDao.getEligibleWorkForScheduling(configuration.maxSchedulerLimit);
            markScheduled(workSpecDao_ImplWorkSpecDao, configuration.clock, eligibleWorkForScheduling);
            if (eligibleWorkForSchedulingWithContentUris != null) {
                eligibleWorkForScheduling.addAll(eligibleWorkForSchedulingWithContentUris);
            }
            ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            if (eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Scheduler scheduler = (Scheduler) it.next();
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it2.next();
                    if (!scheduler2.hasLimitedSchedulingSlots()) {
                        scheduler2.schedule(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.internalEndTransaction();
            throw th;
        }
    }
}
