package kotlin.jvm.internal;

import com.github.kr328.clash.core.model.Provider;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PropertyReference1Impl extends PropertyReference implements KProperty1 {
    public PropertyReference1Impl(String str, String str2) {
        super(CallableReference.NoReceiver.INSTANCE, Provider.class, str, str2, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return get(obj);
    }
}
