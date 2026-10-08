package androidx.navigation.compose;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("dialog")
public final class DialogNavigator extends Navigator {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Destination extends NavDestination implements FloatingWindow {
        public final ComposableLambdaImpl content;
        public final DialogProperties dialogProperties;

        public Destination(DialogNavigator dialogNavigator) {
            ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$DialogNavigatorKt.f12lambda1;
            DialogProperties dialogProperties = new DialogProperties();
            super(dialogNavigator);
            this.dialogProperties = dialogProperties;
            this.content = composableLambdaImpl;
        }
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$DialogNavigatorKt.f12lambda1;
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            getState().push((NavBackStackEntry) it.next());
        }
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        getState().popWithTransition(navBackStackEntry, z);
        int iIndexOf = CollectionsKt.indexOf((Iterable) getState().transitionsInProgress.$$delegate_0.getValue(), navBackStackEntry);
        int i = 0;
        for (Object obj : (Iterable) getState().transitionsInProgress.$$delegate_0.getValue()) {
            int i2 = i + 1;
            if (i < 0) {
                MatrixExt.throwIndexOverflow();
                throw null;
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            if (i > iIndexOf) {
                getState().markTransitionComplete(navBackStackEntry2);
            }
            i = i2;
        }
    }
}
