package androidx.appcompat.app;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TwilightManager$TwilightState {
    public boolean isNight;
    public long nextUpdate;

    public long availableTimeNanos() {
        if (this.isNight) {
            return Long.MAX_VALUE;
        }
        return Math.max(0L, this.nextUpdate - System.nanoTime());
    }
}
