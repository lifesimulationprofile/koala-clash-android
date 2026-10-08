package androidx.compose.ui.text.android;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutHelper$BidiRun {
    public final int end;
    public final boolean isRtl;
    public final int start;

    public LayoutHelper$BidiRun(int i, int i2, boolean z) {
        this.start = i;
        this.end = i2;
        this.isRtl = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutHelper$BidiRun)) {
            return false;
        }
        LayoutHelper$BidiRun layoutHelper$BidiRun = (LayoutHelper$BidiRun) obj;
        return this.start == layoutHelper$BidiRun.start && this.end == layoutHelper$BidiRun.end && this.isRtl == layoutHelper$BidiRun.isRtl;
    }

    public final int hashCode() {
        return (((this.start * 31) + this.end) * 31) + (this.isRtl ? 1231 : 1237);
    }

    public final String toString() {
        return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
    }
}
