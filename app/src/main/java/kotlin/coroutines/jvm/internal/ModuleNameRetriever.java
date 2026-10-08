package kotlin.coroutines.jvm.internal;

import coil.network.RealNetworkObserver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModuleNameRetriever {
    public static RealNetworkObserver cache;
    public static final RealNetworkObserver notOnJava9;

    static {
        Object obj = null;
        notOnJava9 = new RealNetworkObserver(obj, obj, obj, 18, false);
    }
}
