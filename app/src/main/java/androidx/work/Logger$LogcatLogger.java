package androidx.work;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Logger$LogcatLogger {
    public static final Object sLock = new Object();
    public static volatile Logger$LogcatLogger sLogger;
    public final int mLoggingLevel;

    public Logger$LogcatLogger(int i) {
        this.mLoggingLevel = i;
    }

    public static Logger$LogcatLogger get() {
        Logger$LogcatLogger logger$LogcatLogger;
        synchronized (sLock) {
            try {
                if (sLogger == null) {
                    sLogger = new Logger$LogcatLogger(3);
                }
                logger$LogcatLogger = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger$LogcatLogger;
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public final void debug(String str, String str2) {
        if (this.mLoggingLevel <= 3) {
            Log.d(str, str2);
        }
    }

    public final void error(String str, String str2) {
        if (this.mLoggingLevel <= 6) {
            Log.e(str, str2);
        }
    }

    public final void info(String str, String str2) {
        if (this.mLoggingLevel <= 4) {
            Log.i(str, str2);
        }
    }

    public final void warning(String str, String str2) {
        if (this.mLoggingLevel <= 5) {
            Log.w(str, str2);
        }
    }

    public final void error(String str, String str2, Throwable th) {
        if (this.mLoggingLevel <= 6) {
            Log.e(str, str2, th);
        }
    }
}
