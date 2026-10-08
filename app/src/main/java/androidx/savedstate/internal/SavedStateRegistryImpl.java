package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import java.util.LinkedHashMap;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    public boolean attached;
    public boolean isRestored;
    public final SvgDecoder$$ExternalSyntheticLambda0 onAttach;
    public final SavedStateRegistryOwner owner;
    public Bundle restoredState;
    public final AsyncTimeout.Companion lock = new AsyncTimeout.Companion(13);
    public final LinkedHashMap keyToProviders = new LinkedHashMap();
    public boolean isAllowingSavingState = true;

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, SvgDecoder$$ExternalSyntheticLambda0 svgDecoder$$ExternalSyntheticLambda0) {
        this.owner = savedStateRegistryOwner;
        this.onAttach = svgDecoder$$ExternalSyntheticLambda0;
    }

    public final void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
        if (savedStateRegistryOwner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.onAttach.invoke();
        savedStateRegistryOwner.getLifecycle().addObserver(new NavController$$ExternalSyntheticLambda0(1, this));
        this.attached = true;
    }
}
