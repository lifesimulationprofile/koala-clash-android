package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModifierNodeElement implements Modifier.Element {
    @Override // androidx.compose.ui.Modifier
    public final boolean all(Function1 function1) {
        return ((Boolean) function1.invoke(this)).booleanValue();
    }

    public abstract Modifier.Node create();

    @Override // androidx.compose.ui.Modifier
    public final Object foldIn(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // androidx.compose.ui.Modifier
    public final /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public abstract void update(Modifier.Node node);
}
