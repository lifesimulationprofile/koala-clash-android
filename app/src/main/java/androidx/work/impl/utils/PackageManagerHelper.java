package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PackageManagerHelper {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("PackageManagerHelper");

    public static void setComponentEnabled(Context context, Class cls, boolean z) {
        String str = TAG;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z2 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z2 = true;
            }
            if (z == z2) {
                Logger$LogcatLogger.get().debug(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z ? "enabled" : "disabled");
            logger$LogcatLogger.debug(str, sb.toString());
        } catch (Exception e) {
            Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z ? "enabled" : "disabled");
            String string = sb2.toString();
            if (logger$LogcatLogger2.mLoggingLevel <= 3) {
                Log.d(str, string, e);
            }
        }
    }
}
