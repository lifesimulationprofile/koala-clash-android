package kotlin;

import android.media.ImageReader;
import com.google.android.gms.tasks.zzr;
import java.lang.reflect.Method;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ExceptionsKt {
    public static void addSuppressed(Throwable th, Throwable th2) {
        if (th != th2) {
            Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = PlatformImplementations$ReflectThrowable.addSuppressed;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static zzr createIsolatedReader(int i, int i2, int i3, int i4) {
        return new zzr(ImageReader.newInstance(i, i2, i3, i4));
    }
}
