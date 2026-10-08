package kotlin.collections;

import android.content.Context;
import android.os.Build;
import androidx.core.view.WindowCompat;
import androidx.core.widget.TextViewCompat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArraysKt__ArraysJVMKt {
    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    public static Context getApplicationContext(Context context) {
        int deviceId;
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (deviceId = context.getDeviceId()) != applicationContext.getDeviceId()) {
            applicationContext = TextViewCompat.Api34Impl.createDeviceContext(applicationContext, deviceId);
        }
        if (i >= 30) {
            String attributionTag = WindowCompat.Api30Impl.getAttributionTag(context);
            if (!Objects.equals(attributionTag, WindowCompat.Api30Impl.getAttributionTag(applicationContext))) {
                return WindowCompat.Api30Impl.createAttributionContext(applicationContext, attributionTag);
            }
        }
        return applicationContext;
    }
}
