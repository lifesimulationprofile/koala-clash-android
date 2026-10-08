package androidx.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Averages {
    public long applyTimeNanos;
    public long measureTimeNanos;
    public int nestedPrefetchCount;
    public long pauseTimeNanos;
    public long resumeTimeNanos;

    public static long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = 4;
        return (j / j3) + ((j2 / j3) * ((long) 3));
    }
}
