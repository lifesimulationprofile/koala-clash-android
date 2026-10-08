package androidx.compose.runtime.saveable;

import android.app.PendingIntent;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import coil.network.RealNetworkObserver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableHolder implements RememberObserver {
    public RealNetworkObserver entry;
    public Object[] inputs;
    public String key;
    public SaveableStateRegistry registry;
    public Saver saver;
    public Object value;
    public final BasicTextKt$$ExternalSyntheticLambda0 valueProvider = new BasicTextKt$$ExternalSyntheticLambda0(24, this);

    public SaveableHolder(Saver saver, SaveableStateRegistry saveableStateRegistry, String str, Object obj, Object[] objArr) {
        this.saver = saver;
        this.registry = saveableStateRegistry;
        this.key = str;
        this.value = obj;
        this.inputs = objArr;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        RealNetworkObserver realNetworkObserver = this.entry;
        if (realNetworkObserver != null) {
            realNetworkObserver.unregister();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        RealNetworkObserver realNetworkObserver = this.entry;
        if (realNetworkObserver != null) {
            realNetworkObserver.unregister();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() throws PendingIntent.CanceledException {
        register$1();
    }

    public final void register$1() throws PendingIntent.CanceledException {
        String strGenerateCannotBeSavedErrorMessage;
        SaveableStateRegistry saveableStateRegistry = this.registry;
        if (this.entry != null) {
            throw new IllegalArgumentException(("entry(" + this.entry + ") is not null").toString());
        }
        if (saveableStateRegistry != null) {
            BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = this.valueProvider;
            Object objInvoke = basicTextKt$$ExternalSyntheticLambda0.invoke();
            if (objInvoke == null || saveableStateRegistry.canBeSaved(objInvoke)) {
                this.entry = saveableStateRegistry.registerProvider(this.key, basicTextKt$$ExternalSyntheticLambda0);
                return;
            }
            if (objInvoke instanceof SnapshotMutableState) {
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) objInvoke;
                if (snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$3 || snapshotMutableState.getPolicy() == NeverEqualPolicy.INSTANCE$1) {
                    strGenerateCannotBeSavedErrorMessage = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    strGenerateCannotBeSavedErrorMessage = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                strGenerateCannotBeSavedErrorMessage = SaverKt.generateCannotBeSavedErrorMessage(objInvoke);
            }
            throw new IllegalArgumentException(strGenerateCannotBeSavedErrorMessage);
        }
    }
}
