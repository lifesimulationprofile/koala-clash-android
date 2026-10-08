package kotlin.jdk7;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import java.util.concurrent.ExecutorService;
import kotlin.ExceptionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AutoCloseableKt {
    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) throws Exception {
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    Density.CC.m(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    ExceptionsKt.addSuppressed(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (autoCloseable instanceof ExecutorService) {
                LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) autoCloseable);
                return;
            }
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            }
            if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
    }

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m839finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        int iM681getMaxWidthimpl = ((z || i == 2 || i == 4 || i == 5) && Constraints.m677getHasBoundedWidthimpl(j)) ? Constraints.m681getMaxWidthimpl(j) : Integer.MAX_VALUE;
        if (Constraints.m683getMinWidthimpl(j) != iM681getMaxWidthimpl) {
            iM681getMaxWidthimpl = RangesKt.coerceIn(BasicTextKt.ceilToIntPx(f), Constraints.m683getMinWidthimpl(j), iM681getMaxWidthimpl);
        }
        return Constraints.Companion.m686fitPrioritizingWidthZbe2FdA(0, iM681getMaxWidthimpl, 0, Constraints.m680getMaxHeightimpl(j));
    }
}
