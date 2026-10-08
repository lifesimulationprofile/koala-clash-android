package androidx.work.impl.constraints;

import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.model.WorkSpec;
import coil.memory.EmptyStrongMemoryCache;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkConstraintsTrackerKt {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkConstraintsTracker");

    public static final JobImpl listen(EmptyStrongMemoryCache emptyStrongMemoryCache, WorkSpec workSpec, ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        JobImpl jobImplJob$default = JobKt.Job$default();
        JobKt.launch$default(JobKt.CoroutineScope(CoroutineContext.DefaultImpls.plus(executorCoroutineDispatcherImpl, jobImplJob$default)), null, new NavHostKt$NavHost$28$1(emptyStrongMemoryCache, workSpec, onConstraintsStateChangedListener, null, 26), 3);
        return jobImplJob$default;
    }
}
