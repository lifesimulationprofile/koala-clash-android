package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Unit;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TaskQueue {
    public Task activeTask;
    public boolean cancelActiveTask;
    public final ArrayList futureTasks = new ArrayList();
    public final String name;
    public boolean shutdown;
    public final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String str) {
        this.taskRunner = taskRunner;
        this.name = str;
    }

    public final void cancelAll() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            try {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.cancelable) {
            this.cancelActiveTask = true;
        }
        ArrayList arrayList = this.futureTasks;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).cancelable) {
                Task task2 = (Task) arrayList.get(size);
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"canceled"}, 1)) + ": " + task2.name);
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void schedule(Task task, long j) {
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.cancelable) {
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"schedule canceled (queue is shutdown)"}, 1)) + ": " + task.name);
                }
            } else {
                if (TaskRunner.logger.isLoggable(Level.FINE)) {
                    TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"schedule failed (queue is shutdown)"}, 1)) + ": " + task.name);
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072 A[LOOP:0: B:23:0x0060->B:27:0x0072, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:33:0x0081 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0076 A[EDGE_INSN: B:39:0x0076->B:29:0x0076 BREAK  A[LOOP:0: B:23:0x0060->B:27:0x0072], SYNTHETIC] */
    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        int size;
        int size2;
        int i;
        Object obj;
        String strConcat;
        TaskQueue taskQueue = task.queue;
        if (taskQueue != this) {
            if (taskQueue != null) {
                throw new IllegalStateException("task is in multiple queues");
            }
            task.queue = this;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.futureTasks;
        int iIndexOf = arrayList.indexOf(task);
        if (iIndexOf == -1) {
            task.nextExecuteNanoTime = j2;
            if (TaskRunner.logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(TaskLoggerKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(TaskLoggerKt.formatDuration(j2 - jNanoTime));
                }
                TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{strConcat}, 1)) + ": " + task.name);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        } else if (task.nextExecuteNanoTime > j2) {
            arrayList.remove(iIndexOf);
            task.nextExecuteNanoTime = j2;
            if (TaskRunner.logger.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(TaskLoggerKt.formatDuration(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(TaskLoggerKt.formatDuration(j2 - jNanoTime));
                }
                TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{strConcat}, 1)) + ": " + task.name);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((Task) obj).nextExecuteNanoTime - jNanoTime > j) {
                    break;
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, task);
            if (size2 == 0) {
                return true;
            }
        } else if (TaskRunner.logger.isLoggable(Level.FINE)) {
            TaskRunner.logger.fine(this.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"already scheduled"}, 1)) + ": " + task.name);
            return false;
        }
        return false;
    }

    public final void shutdown() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this.taskRunner) {
            try {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        return this.name;
    }
}
