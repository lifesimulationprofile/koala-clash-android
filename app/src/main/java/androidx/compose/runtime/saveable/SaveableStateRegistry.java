package androidx.compose.runtime.saveable;

import coil.network.RealNetworkObserver;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateRegistry {
    boolean canBeSaved(Object obj);

    Object consumeRestored(String str);

    Map performSave();

    RealNetworkObserver registerProvider(String str, Function0 function0);
}
