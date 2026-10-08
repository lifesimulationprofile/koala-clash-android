package androidx.compose.material3.internal;

import androidx.compose.runtime.MutableState;
import kotlin.jvm.internal.MutablePropertyReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1 extends MutablePropertyReference implements KProperty0 {
    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        return ((MutableState) this.receiver).getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return get();
    }
}
