package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UnsafeLazyImpl implements Lazy, Serializable {
    public Object _value;
    public Function0 initializer;

    @Override // kotlin.Lazy
    public final Object getValue() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) {
            this._value = this.initializer.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public final String toString() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
