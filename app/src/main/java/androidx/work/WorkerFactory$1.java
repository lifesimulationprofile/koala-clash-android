package androidx.work;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkerFactory$1 {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkerFactory");

    public static ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = TAG;
        ListenableWorker listenableWorker = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable th) {
            Logger$LogcatLogger.get().error(str2, "Invalid class: " + str, th);
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                listenableWorker = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                Logger$LogcatLogger.get().error(str2, "Could not instantiate " + str, th2);
            }
        }
        if (listenableWorker == null || !listenableWorker.mUsed) {
            return listenableWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + WorkerFactory$1.class.getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
