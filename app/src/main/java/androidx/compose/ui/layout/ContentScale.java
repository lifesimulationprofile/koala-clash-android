package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ContentScale {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Companion {
        public static final ContentScale$Companion$Fit$1 Crop = new ContentScale$Companion$Fit$1(2);
        public static final ContentScale$Companion$Fit$1 Fit = new ContentScale$Companion$Fit$1(0);
        public static final ContentScale$Companion$Fit$1 Inside = new ContentScale$Companion$Fit$1(3);
        public static final FixedScale None = new FixedScale();
    }

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo514computeScaleFactorH7hwNQA(long j, long j2);
}
