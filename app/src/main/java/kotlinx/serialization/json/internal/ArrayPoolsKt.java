package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ArrayPoolsKt {
    public static final int MAX_CHARS_IN_POOL;

    static {
        Object failure;
        try {
            failure = StringsKt__StringsJVMKt.toIntOrNull(System.getProperty("kotlinx.serialization.json.pool.size"));
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Integer num = (Integer) failure;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
