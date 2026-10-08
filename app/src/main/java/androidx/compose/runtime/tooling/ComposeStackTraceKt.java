package androidx.compose.runtime.tooling;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.EmptyList;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComposeStackTraceKt {
    public static final boolean tryAttachComposeStackTrace(Throwable th, Function0 function0) {
        List listAsList;
        Object objInvoke;
        Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
        DiagnosticComposeException diagnosticComposeException = null;
        if (num == null || num.intValue() >= 19) {
            listAsList = Arrays.asList(th.getSuppressed());
        } else {
            Method method = PlatformImplementations$ReflectThrowable.getSuppressed;
            listAsList = (method == null || (objInvoke = method.invoke(th, null)) == null) ? EmptyList.INSTANCE : Arrays.asList((Throwable[]) objInvoke);
        }
        int size = listAsList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (((Throwable) listAsList.get(i)) instanceof DiagnosticComposeException) {
                return false;
            }
        }
        try {
            ComposeStackTrace composeStackTrace = (ComposeStackTrace) function0.invoke();
            if (composeStackTrace != null) {
                List list = composeStackTrace.frames;
                if (composeStackTrace.hasSourceInformation) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (((ComposeStackTraceFrame) list.get(i2)).sourceInfo != null) {
                            z = true;
                            break;
                        }
                    }
                } else if (!list.isEmpty()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                diagnosticComposeException = new DiagnosticComposeException(composeStackTrace);
            }
        } catch (Throwable th2) {
            diagnosticComposeException = th2;
        }
        if (diagnosticComposeException != null) {
            ExceptionsKt.addSuppressed(th, diagnosticComposeException);
        }
        return z;
    }
}
