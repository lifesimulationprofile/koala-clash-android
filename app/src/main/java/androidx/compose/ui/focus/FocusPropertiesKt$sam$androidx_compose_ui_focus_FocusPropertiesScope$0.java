package androidx.compose.ui.focus;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 implements FunctionAdapter {
    public final /* synthetic */ Function1 function;

    public FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(Function1 function1) {
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0)) {
            return false;
        }
        return Intrinsics.areEqual(this.function, ((FunctionAdapter) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return this.function.hashCode();
    }
}
