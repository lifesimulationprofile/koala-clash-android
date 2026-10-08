package kotlin.io;

import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import java.io.Closeable;
import kotlin.ExceptionsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableKt {
    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final int visibleItemsAverageSize(LazyListMeasureResult lazyListMeasureResult) {
        ?? r0 = lazyListMeasureResult.visibleItemsInfo;
        if (r0.isEmpty()) {
            return 0;
        }
        int size = r0.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((LazyListMeasuredItem) r0.get(i2)).size;
        }
        return (i / r0.size()) + lazyListMeasureResult.mainAxisItemSpacing;
    }
}
