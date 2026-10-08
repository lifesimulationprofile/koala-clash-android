package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import coil.network.RealNetworkObserver;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    public final /* synthetic */ SaveableStateRegistryImpl $$delegate_0;
    public final DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 onDispose;

    public DisposableSaveableStateRegistry(SaveableStateRegistryImpl saveableStateRegistryImpl, DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 disposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1) {
        this.$$delegate_0 = saveableStateRegistryImpl;
        this.onDispose = disposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        return this.$$delegate_0.consumeRestored(str);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final RealNetworkObserver registerProvider(String str, Function0 function0) {
        return this.$$delegate_0.registerProvider(str, function0);
    }
}
