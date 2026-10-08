package androidx.compose.ui.spatial;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RectListKt {
    public static final long EverythingButLastChildOffset = (((long) 1023) << 50) ^ (-1);
    public static final long EverythingButParentId = (-1) ^ (((long) 33554431) << 25);
    public static final long TombStone;

    static {
        long j = 33554431;
        TombStone = j | (((long) Math.min(0, 1023)) << 50) | (j << 25);
    }
}
