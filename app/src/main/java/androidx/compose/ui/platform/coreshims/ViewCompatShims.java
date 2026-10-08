package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.core.view.MenuItemCompat$Api26Impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompatShims {
    public static ExposureStateImpl getAutofillId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new ExposureStateImpl(MenuItemCompat$Api26Impl.getAutofillId(view));
        }
        return null;
    }
}
