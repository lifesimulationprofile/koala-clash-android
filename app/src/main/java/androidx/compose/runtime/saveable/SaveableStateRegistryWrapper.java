package androidx.compose.runtime.saveable;

import android.os.Bundle;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.work.impl.WorkLauncherImpl;
import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import coil.memory.RealStrongMemoryCache;
import coil.network.RealNetworkObserver;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateRegistryWrapper implements SaveableStateRegistry, SavedStateRegistryOwner {
    public final /* synthetic */ SaveableStateRegistryImpl $$delegate_0;
    public RealStrongMemoryCache _controller;
    public LifecycleRegistry _lifecycle;

    public SaveableStateRegistryWrapper(SaveableStateRegistryImpl saveableStateRegistryImpl) {
        this.$$delegate_0 = saveableStateRegistryImpl;
        Object objConsumeRestored = saveableStateRegistryImpl.consumeRestored("androidx.savedstate.SavedStateRegistry");
        Bundle bundle = objConsumeRestored instanceof Bundle ? (Bundle) objConsumeRestored : null;
        if (bundle != null && this._controller == null) {
            RealStrongMemoryCache realStrongMemoryCache = new RealStrongMemoryCache(new SavedStateRegistryImpl(this, new SvgDecoder$$ExternalSyntheticLambda0(1, this)));
            this._controller = realStrongMemoryCache;
            realStrongMemoryCache.performRestore(bundle);
        }
        saveableStateRegistryImpl.registerProvider("androidx.savedstate.SavedStateRegistry", new BasicTextKt$$ExternalSyntheticLambda0(25, this));
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        return this.$$delegate_0.consumeRestored(str);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        LifecycleRegistry lifecycleRegistry = this._lifecycle;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this, false);
        this._lifecycle = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final WorkLauncherImpl getSavedStateRegistry() {
        RealStrongMemoryCache realStrongMemoryCache = this._controller;
        if (realStrongMemoryCache == null) {
            RealStrongMemoryCache realStrongMemoryCache2 = new RealStrongMemoryCache(new SavedStateRegistryImpl(this, new SvgDecoder$$ExternalSyntheticLambda0(1, this)));
            this._controller = realStrongMemoryCache2;
            realStrongMemoryCache2.performRestore(null);
            realStrongMemoryCache = realStrongMemoryCache2;
        }
        return (WorkLauncherImpl) realStrongMemoryCache.cache;
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
