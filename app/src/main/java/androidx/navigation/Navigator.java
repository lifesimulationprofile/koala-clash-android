package androidx.navigation;

import androidx.work.JobListenableFuture;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.ListIterator;
import kotlin.io.FileTreeWalk;
import kotlin.io.LinesSequence;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Navigator {
    public NavController$NavControllerNavigatorState _state;
    public boolean isAttached;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    public abstract NavDestination createDestination();

    public final NavController$NavControllerNavigatorState getState() {
        NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = this._state;
        if (navController$NavControllerNavigatorState != null) {
            return navController$NavControllerNavigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public NavDestination navigate(NavDestination navDestination) {
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }

    public void navigate(List list, NavOptions navOptions) {
        FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new FilteringSequence(new GeneratorSequence(new LinesSequence(2, list), new JobListenableFuture.AnonymousClass1(this, navOptions), 3), false, new Remote$$ExternalSyntheticLambda1(19)));
        while (fileTreeWalkIterator.hasNext()) {
            getState().push((NavBackStackEntry) fileTreeWalkIterator.next());
        }
    }

    public void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        List list = (List) getState().backStack.$$delegate_0.getValue();
        if (!list.contains(navBackStackEntry)) {
            throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + list).toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        NavBackStackEntry navBackStackEntry2 = null;
        while (popBackStack()) {
            navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
                break;
            }
        }
        if (navBackStackEntry2 != null) {
            getState().pop(navBackStackEntry2, z);
        }
    }
}
