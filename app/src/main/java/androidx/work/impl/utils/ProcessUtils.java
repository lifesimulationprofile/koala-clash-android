package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.work.Logger$LogcatLogger;
import androidx.work.WorkManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProcessUtils {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ProcessUtils");

    public static final boolean isDefaultProcess(Context context) {
        String processName;
        Object next;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Api28Impl.INSTANCE.getProcessName();
        } else {
            processName = null;
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, WorkManager.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                if (objInvoke instanceof String) {
                    processName = (String) objInvoke;
                } else {
                    int iMyPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<T> it = runningAppProcesses.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (((ActivityManager.RunningAppProcessInfo) next).pid != iMyPid);
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                        if (runningAppProcessInfo != null) {
                            processName = runningAppProcessInfo.processName;
                        }
                    }
                }
            } catch (Throwable th) {
                if (Logger$LogcatLogger.get().mLoggingLevel <= 3) {
                    Log.d(TAG, "Unable to check ActivityThread for processName", th);
                }
            }
        }
        return Intrinsics.areEqual(processName, context.getApplicationInfo().processName);
    }
}
