package androidx.navigation.compose;

import android.content.Context;
import androidx.navigation.NavHostController;
import androidx.navigation.NavigatorProvider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavHostControllerKt {
    public static final NavHostController access$createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        NavigatorProvider navigatorProvider = navHostController._navigatorProvider;
        navigatorProvider.addNavigator(new ComposeNavGraphNavigator(navigatorProvider));
        navHostController._navigatorProvider.addNavigator(new ComposeNavigator());
        navHostController._navigatorProvider.addNavigator(new DialogNavigator());
        return navHostController;
    }
}
