package androidx.navigation;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavDestinationBuilder {
    public final Object actions;
    public final Object arguments;
    public Object deepLinks;
    public final Object navigator;
    public final Object route;

    public NavDestinationBuilder(Context context, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.navigator = workManagerTaskExecutor;
        this.route = context.getApplicationContext();
        this.arguments = new Object();
        this.actions = new LinkedHashSet();
    }

    public NavDestination build() {
        NavDestination navDestinationInstantiateDestination = instantiateDestination();
        navDestinationInstantiateDestination.getClass();
        LinkedHashMap linkedHashMap = navDestinationInstantiateDestination._arguments;
        Iterator it = ((LinkedHashMap) this.arguments).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getValue().getClass();
            throw new ClassCastException();
        }
        ArrayList arrayList = (ArrayList) this.deepLinks;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            final NavDeepLink navDeepLink = (NavDeepLink) obj;
            final int i2 = 1;
            ArrayList arrayListMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(linkedHashMap, new Function1() { // from class: androidx.navigation.NavDestination$route$missingRequiredArguments$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    switch (i2) {
                        case 0:
                            return Boolean.valueOf(!navDeepLink.getArgumentsNames$navigation_common_release().contains((String) obj2));
                        default:
                            return Boolean.valueOf(!navDeepLink.getArgumentsNames$navigation_common_release().contains((String) obj2));
                    }
                }
            });
            if (!arrayListMissingRequiredArguments.isEmpty()) {
                throw new IllegalArgumentException(("Deep link " + navDeepLink.uriPattern + " can't be used to open destination " + navDestinationInstantiateDestination + ".\nFollowing required arguments are missing: " + arrayListMissingRequiredArguments).toString());
            }
            navDestinationInstantiateDestination.deepLinks.add(navDeepLink);
        }
        Iterator it2 = ((LinkedHashMap) this.actions).entrySet().iterator();
        if (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            ((Number) entry2.getKey()).intValue();
            entry2.getValue().getClass();
            throw new ClassCastException();
        }
        String str = (String) this.route;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            String strConcat = "android-app://androidx.navigation/".concat(str);
            final NavDeepLink navDeepLink2 = new NavDeepLink(strConcat);
            final int i3 = 0;
            ArrayList arrayListMissingRequiredArguments2 = NavArgumentKt.missingRequiredArguments(linkedHashMap, new Function1() { // from class: androidx.navigation.NavDestination$route$missingRequiredArguments$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    switch (i3) {
                        case 0:
                            return Boolean.valueOf(!navDeepLink2.getArgumentsNames$navigation_common_release().contains((String) obj2));
                        default:
                            return Boolean.valueOf(!navDeepLink2.getArgumentsNames$navigation_common_release().contains((String) obj2));
                    }
                }
            });
            if (!arrayListMissingRequiredArguments2.isEmpty()) {
                throw new IllegalArgumentException(("Cannot set route \"" + str + "\" for destination " + navDestinationInstantiateDestination + ". Following required arguments are missing: " + arrayListMissingRequiredArguments2).toString());
            }
            navDestinationInstantiateDestination.routeDeepLink = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(18, strConcat));
            navDestinationInstantiateDestination.id = strConcat.hashCode();
            navDestinationInstantiateDestination.route = str;
        }
        return navDestinationInstantiateDestination;
    }

    public NavDestination instantiateDestination() {
        return ((Navigator) this.navigator).createDestination();
    }

    public abstract Object readSystemState();

    public void setState(Object obj) {
        synchronized (this.arguments) {
            Object obj2 = this.deepLinks;
            if (obj2 == null || !obj2.equals(obj)) {
                this.deepLinks = obj;
                ((WorkManagerTaskExecutor) this.navigator).mMainThreadExecutor.execute(new HandlerContext$$ExternalSyntheticLambda0(1, CollectionsKt.toList((LinkedHashSet) this.actions), this));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();

    public NavDestinationBuilder(Navigator navigator, String str) {
        this.navigator = navigator;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }
}
