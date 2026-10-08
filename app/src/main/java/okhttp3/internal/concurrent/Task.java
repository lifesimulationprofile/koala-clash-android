package okhttp3.internal.concurrent;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Task {
    public final boolean cancelable;
    public final String name;
    public long nextExecuteNanoTime = -1;
    public TaskQueue queue;

    public Task(String str, boolean z) {
        this.name = str;
        this.cancelable = z;
    }

    public abstract long runOnce();

    public final String toString() {
        return this.name;
    }
}
