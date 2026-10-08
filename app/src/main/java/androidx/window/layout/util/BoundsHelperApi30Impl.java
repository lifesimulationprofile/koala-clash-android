package androidx.window.layout.util;

import android.app.Activity;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.WindowManager;
import androidx.window.layout.WindowMetrics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BoundsHelperApi30Impl implements BoundsHelper, WindowMetricsCompatHelper {
    public static final BoundsHelperApi30Impl INSTANCE = new BoundsHelperApi30Impl();
    public static final BoundsHelperApi30Impl INSTANCE$1 = new BoundsHelperApi30Impl();

    @Override // androidx.window.layout.util.BoundsHelper
    public Rect currentWindowBounds(Activity activity) {
        return ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
    }

    @Override // androidx.window.layout.util.WindowMetricsCompatHelper
    public WindowMetrics currentWindowMetrics(ContextWrapper contextWrapper, DensityCompatHelper densityCompatHelper) {
        WindowManager windowManager = (WindowManager) contextWrapper.getSystemService(WindowManager.class);
        return new WindowMetrics(windowManager.getCurrentWindowMetrics().getBounds(), contextWrapper.getResources().getDisplayMetrics().density);
    }
}
