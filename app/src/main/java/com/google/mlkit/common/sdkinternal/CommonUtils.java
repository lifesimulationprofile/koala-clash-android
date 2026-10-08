package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CommonUtils {
    public static final GmsLogger zza = new GmsLogger(0, "CommonUtils", "");

    public static String getAppVersion(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            String strConcat = "Exception thrown when trying to get app version ".concat(e.toString());
            GmsLogger gmsLogger = zza;
            if (!Log.isLoggable(gmsLogger.zza, 6)) {
                return "";
            }
            Log.e("CommonUtils", gmsLogger.zza(strConcat));
            return "";
        }
    }
}
