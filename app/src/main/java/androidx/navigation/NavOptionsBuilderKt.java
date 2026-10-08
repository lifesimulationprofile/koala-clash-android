package androidx.navigation;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavOptionsBuilderKt {
    public static final NavOptions navOptions(Function1 function1) {
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        function1.invoke(navOptionsBuilder);
        boolean z = navOptionsBuilder.launchSingleTop;
        boolean z2 = navOptionsBuilder.restoreState;
        int i = navOptionsBuilder.popUpToId;
        boolean z3 = navOptionsBuilder.saveState;
        NavOptions.Builder builder = navOptionsBuilder.builder;
        return new NavOptions(z, z2, i, false, z3, builder.enterAnim, builder.exitAnim);
    }
}
