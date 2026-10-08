package androidx.work.impl.utils;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkForegroundUpdater {
    public final ForegroundProcessor mForegroundProcessor;
    public final WorkManagerTaskExecutor mTaskExecutor;
    public final WorkSpecDao_Impl mWorkSpecDao;

    static {
        Logger$LogcatLogger.tagWithPrefix("WMFgUpdater");
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, Processor processor, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.mForegroundProcessor = processor;
        this.mTaskExecutor = workManagerTaskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }
}
