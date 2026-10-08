package androidx.lifecycle.viewmodel.internal;

import androidx.compose.ui.unit.Density;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelImpl {
    public volatile boolean isCleared;
    public final SynchronizedObject lock = new SynchronizedObject();
    public final LinkedHashMap keyToCloseables = new LinkedHashMap();
    public final LinkedHashSet closeables = new LinkedHashSet();

    public static void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                Density.CC.m(autoCloseable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
