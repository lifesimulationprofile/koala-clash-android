package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StackTraceRecoveryKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Object failure;
        Object failure2;
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
        new StackTraceElement("_COROUTINE._BOUNDARY", "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            failure = BaseContinuationImpl.class.getCanonicalName();
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m835exceptionOrNullimpl(failure) != null) {
            failure = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            failure2 = StackTraceRecoveryKt.class.getCanonicalName();
        } catch (Throwable th2) {
            failure2 = new Result.Failure(th2);
        }
        if (Result.m835exceptionOrNullimpl(failure2) != null) {
            failure2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
