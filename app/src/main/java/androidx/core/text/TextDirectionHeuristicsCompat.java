package androidx.core.text;

import kotlinx.serialization.json.internal.Composer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextDirectionHeuristicsCompat {
    public static final Composer FIRSTSTRONG_LTR;
    public static final Composer FIRSTSTRONG_RTL;
    public static final Composer LTR = new Composer((FirstStrong) null, false);
    public static final Composer RTL = new Composer((FirstStrong) null, true);

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class FirstStrong {
        public static final FirstStrong INSTANCE = new FirstStrong();
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new Composer(firstStrong, false);
        FIRSTSTRONG_RTL = new Composer(firstStrong, true);
    }
}
