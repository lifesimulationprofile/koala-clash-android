package com.github.kr328.clash.service;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda0;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.request.RequestService;
import com.github.kr328.clash.service.model.Profile;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileAutoUpdate {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long BACKOFF_DELAY_MILLIS;
    public static final long MIN_INTERVAL_MILLIS;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        MIN_INTERVAL_MILLIS = timeUnit.toMillis(15L);
        BACKOFF_DELAY_MILLIS = timeUnit.toMillis(10L);
    }

    public static Constraints constraints() {
        return new Constraints(2, false, false, false, false, -1L, -1L, Build.VERSION.SDK_INT >= 24 ? CollectionsKt.toSet(new LinkedHashSet()) : EmptySet.INSTANCE);
    }

    public static Data inputOf(UUID uuid) throws Throwable {
        Pair[] pairArr = {new Pair("uuid", uuid.toString())};
        Data.Builder builder = new Data.Builder();
        Pair pair = pairArr[0];
        builder.put(pair.second, (String) pair.first);
        Data data = new Data(builder.mValues);
        Data.toByteArrayInternal(data);
        return data;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0028  */
    public static void sync(Context context, List list) {
        Class cls;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Profile profile = (Profile) it.next();
            Profile.Type type = profile.type;
            long j = profile.interval;
            UUID uuid = profile.uuid;
            if (type != Profile.Type.File) {
                long j2 = MIN_INTERVAL_MILLIS;
                if (j < j2) {
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    it = it;
                    WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
                    CancelWorkRunnable.AnonymousClass3 anonymousClass3 = new CancelWorkRunnable.AnonymousClass3(instance$1, "profile-auto-update:" + uuid, true);
                    WorkManagerTaskExecutor workManagerTaskExecutor = instance$1.mWorkTaskExecutor;
                    workManagerTaskExecutor.executeOnTaskThread(anonymousClass3);
                    workManagerTaskExecutor.executeOnTaskThread(new CancelWorkRunnable.AnonymousClass3(instance$1, "profile-update-now:" + uuid, true));
                } else {
                    WorkManagerImpl instance$2 = WorkManagerImpl.getInstance$1(context);
                    WorkManagerTaskExecutor workManagerTaskExecutor2 = instance$2.mWorkTaskExecutor;
                    long j3 = BACKOFF_DELAY_MILLIS;
                    if (j < j2) {
                        workManagerTaskExecutor2.executeOnTaskThread(new CancelWorkRunnable.AnonymousClass3(instance$2, "profile-auto-update:" + uuid, true));
                        cls = ProfileUpdateWorker.class;
                    } else {
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(ProfileUpdateWorker.class);
                        WorkSpec workSpec = (WorkSpec) builder.workSpec;
                        long millis = timeUnit.toMillis(j);
                        workSpec.getClass();
                        String str = WorkSpec.TAG;
                        if (millis < 900000) {
                            Logger$LogcatLogger.get().warning(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
                        }
                        long j4 = millis < 900000 ? 900000L : millis;
                        long j5 = millis < 900000 ? 900000L : millis;
                        if (j4 < 900000) {
                            Logger$LogcatLogger.get().warning(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
                        }
                        workSpec.intervalDuration = j4 < 900000 ? 900000L : j4;
                        if (j5 < 300000) {
                            Logger$LogcatLogger.get().warning(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
                        }
                        if (j5 > workSpec.intervalDuration) {
                            Logger$LogcatLogger.get().warning(str, "Flex duration greater than interval duration; Changed to " + j4);
                        }
                        workSpec.flexDuration = RangesKt.coerceIn(j5, 300000L, workSpec.intervalDuration);
                        ((WorkSpec) builder.workSpec).constraints = constraints();
                        ((WorkSpec) builder.workSpec).input = inputOf(uuid);
                        PeriodicWorkRequest.Builder builder2 = (PeriodicWorkRequest.Builder) builder.setBackoffCriteria(j3);
                        ((LinkedHashSet) builder2.tags).add("profile-auto-update");
                        PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) builder2.build();
                        String str2 = "profile-auto-update:" + uuid;
                        RequestService requestService = new RequestService(17);
                        cls = ProfileUpdateWorker.class;
                        workManagerTaskExecutor2.mBackgroundExecutor.execute(new WorkerUpdater$$ExternalSyntheticLambda0(instance$2, str2, requestService, new AndroidDialog_androidKt$Dialog$2$1(periodicWorkRequest, instance$2, str2, requestService, 1), periodicWorkRequest));
                    }
                    long j6 = profile.updatedAt;
                    if (j >= j2 && (j6 <= 0 || jCurrentTimeMillis - j6 >= j)) {
                        OneTimeWorkRequest.Builder builder3 = new OneTimeWorkRequest.Builder(cls);
                        ((WorkSpec) builder3.workSpec).constraints = constraints();
                        ((WorkSpec) builder3.workSpec).input = inputOf(uuid);
                        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                        OneTimeWorkRequest.Builder builder4 = (OneTimeWorkRequest.Builder) builder3.setBackoffCriteria(j3);
                        ((LinkedHashSet) builder4.tags).add("profile-auto-update");
                        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) builder4.build();
                        new WorkContinuationImpl(WorkManagerImpl.getInstance$1(context), "profile-update-now:" + uuid, 2, Collections.singletonList(oneTimeWorkRequest), 0).enqueue();
                    }
                }
            } else {
                jCurrentTimeMillis = jCurrentTimeMillis;
                it = it;
                WorkManagerImpl instance$3 = WorkManagerImpl.getInstance$1(context);
                CancelWorkRunnable.AnonymousClass3 anonymousClass4 = new CancelWorkRunnable.AnonymousClass3(instance$3, "profile-auto-update:" + uuid, true);
                WorkManagerTaskExecutor workManagerTaskExecutor3 = instance$3.mWorkTaskExecutor;
                workManagerTaskExecutor3.executeOnTaskThread(anonymousClass4);
                workManagerTaskExecutor3.executeOnTaskThread(new CancelWorkRunnable.AnonymousClass3(instance$3, "profile-update-now:" + uuid, true));
            }
            jCurrentTimeMillis = jCurrentTimeMillis;
            it = it;
        }
    }
}
