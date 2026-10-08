package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavController$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ NavController$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                NavHostController navHostController = (NavHostController) this.f$0;
                navHostController.hostLifecycleState = event.getTargetState();
                if (navHostController._graph != null) {
                    ArrayList arrayList = new ArrayList(navHostController.backQueue);
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                        navBackStackEntry.getClass();
                        navBackStackEntry.hostLifecycleState = event.getTargetState();
                        navBackStackEntry.updateState();
                    }
                }
                break;
            default:
                SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.f$0;
                if (event == Lifecycle.Event.ON_START) {
                    savedStateRegistryImpl.isAllowingSavingState = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    savedStateRegistryImpl.isAllowingSavingState = false;
                }
                break;
        }
    }
}
