package androidx.activity.compose;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeBackHandler extends BaseMenuWrapper {
    public Function0 currentOnBackCompleted;

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCompleted() {
        this.currentOnBackCompleted.invoke();
    }
}
