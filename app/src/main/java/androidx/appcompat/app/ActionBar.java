package androidx.appcompat.app;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.room.RoomDatabase;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.impl.CleanupCallback;
import androidx.work.impl.Migration_1_2;
import androidx.work.impl.Processor;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkManagerImplExtKt$WorkManagerImpl$1;
import androidx.work.impl.WorkMigration9To10;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.koala.clash.R;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {
    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        RoomDatabase.Builder builder;
        WorkManagerTaskExecutor workManagerTaskExecutor = new WorkManagerTaskExecutor(configuration.taskExecutor);
        Context applicationContext = context.getApplicationContext();
        SystemClock systemClock = configuration.clock;
        if (context.getResources().getBoolean(R.bool.workmanager_test_configuration)) {
            builder = new RoomDatabase.Builder(applicationContext, WorkDatabase.class, null);
            builder.allowMainThreadQueries = true;
        } else {
            if (StringsKt.isBlank("androidx.work.workdb")) {
                throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            }
            RoomDatabase.Builder builder2 = new RoomDatabase.Builder(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            builder2.factory = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(15, applicationContext);
            builder = builder2;
        }
        builder.queryExecutor = workManagerTaskExecutor.mBackgroundExecutor;
        builder.callbacks.add(new CleanupCallback(systemClock));
        builder.addMigrations(Migration_1_2.INSTANCE);
        builder.addMigrations(new WorkMigration9To10(applicationContext, 2, 3));
        builder.addMigrations(Migration_1_2.INSTANCE$5);
        builder.addMigrations(Migration_1_2.INSTANCE$6);
        builder.addMigrations(new WorkMigration9To10(applicationContext, 5, 6));
        builder.addMigrations(Migration_1_2.INSTANCE$7);
        builder.addMigrations(Migration_1_2.INSTANCE$8);
        builder.addMigrations(Migration_1_2.INSTANCE$9);
        builder.addMigrations(new WorkMigration9To10(applicationContext));
        builder.addMigrations(new WorkMigration9To10(applicationContext, 10, 11));
        builder.addMigrations(Migration_1_2.INSTANCE$1);
        builder.addMigrations(Migration_1_2.INSTANCE$2);
        builder.addMigrations(Migration_1_2.INSTANCE$3);
        builder.addMigrations(Migration_1_2.INSTANCE$4);
        builder.requireMigration = false;
        builder.allowDestructiveMigrationOnDowngrade = true;
        WorkDatabase workDatabase = (WorkDatabase) builder.build();
        Trackers trackers = new Trackers(context.getApplicationContext(), workManagerTaskExecutor);
        Processor processor = new Processor(context.getApplicationContext(), configuration, workManagerTaskExecutor, workDatabase);
        WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE.getClass();
        String str = Schedulers.TAG;
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger$LogcatLogger.get().debug(Schedulers.TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return new WorkManagerImpl(context.getApplicationContext(), configuration, workManagerTaskExecutor, workDatabase, MatrixExt.listOf(systemJobScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(0, processor, workManagerTaskExecutor), workManagerTaskExecutor)), processor, trackers);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021 A[PHI: r0
      0x0021: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:9:0x001f, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    public static Typeface maybeCopyWithFontWeightAdjustment(android.content.res.Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        int weight = configuration.fontWeightAdjustment + typeface.getWeight();
        int i = 1;
        if (weight < 1) {
            weight = i;
        } else {
            i = 1000;
            if (weight > 1000) {
                weight = i;
            }
        }
        return Typeface.create(typeface, weight, typeface.isItalic());
    }
}
