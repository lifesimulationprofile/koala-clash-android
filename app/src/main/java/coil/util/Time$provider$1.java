package coil.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Time$provider$1 extends FunctionReferenceImpl implements Function0 {
    public static final Time$provider$1 INSTANCE = new Time$provider$1(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
