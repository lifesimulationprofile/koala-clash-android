package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.fragment.app.FragmentManager$1;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 {
    public final /* synthetic */ BaseMenuWrapper $handler$inlined;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, BaseMenuWrapper baseMenuWrapper, int i) {
        this.$r8$classId = i;
        this.$handler$inlined = baseMenuWrapper;
    }

    public final void runStopOrDisposeEffect() {
        switch (this.$r8$classId) {
            case 0:
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) this.$handler$inlined;
                ((FragmentManager$1) composeBackHandler.mContext).setEnabled(false);
                ((BackHandlerCompat$navigationEventHandler$1) composeBackHandler.mMenuItems).setBackEnabled(false);
                break;
            default:
                ((ComposePredictiveBackHandler) this.$handler$inlined).setBackEnabled(false);
                break;
        }
    }
}
