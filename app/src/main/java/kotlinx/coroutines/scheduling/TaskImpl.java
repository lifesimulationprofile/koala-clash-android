package kotlinx.coroutines.scheduling;

import androidx.compose.ui.Modifier;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.block.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.block;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(JobKt.getHexAddress(runnable));
        sb.append(", ");
        sb.append(this.submissionTime);
        sb.append(", ");
        return Modifier.CC.m(sb, this.taskContext ? "Blocking" : "Non-blocking", ']');
    }
}
