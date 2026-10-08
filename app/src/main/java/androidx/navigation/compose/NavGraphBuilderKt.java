package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavigatorProvider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavGraphBuilderKt {
    public static void composable$default(NavGraphBuilder navGraphBuilder, String str, ComposableLambdaImpl composableLambdaImpl) {
        NavigatorProvider navigatorProvider = navGraphBuilder.provider;
        navigatorProvider.getClass();
        navGraphBuilder.destinations.add(new ComposeNavigatorDestinationBuilder((ComposeNavigator) navigatorProvider.getNavigator(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(ComposeNavigator.class)), str, composableLambdaImpl).build());
    }
}
