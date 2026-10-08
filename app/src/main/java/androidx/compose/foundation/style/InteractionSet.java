package androidx.compose.foundation.style;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.style.InteractionSet;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InteractionSet implements Factory, ComponentFactory {
    public static InteractionSet snackbarManager;
    public Object setOrValue;

    public /* synthetic */ InteractionSet(Object obj) {
        this.setOrValue = obj;
    }

    public static InteractionSet obtain(boolean z, int i, int i2, int i3, int i4) {
        return new InteractionSet(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }

    public void add(Interaction interaction) {
        Object obj = this.setOrValue;
        if (obj == null) {
            this.setOrValue = interaction;
            return;
        }
        if (obj instanceof MutableScatterSet) {
            ((MutableScatterSet) obj).add(interaction);
            return;
        }
        if (obj.equals(interaction)) {
            return;
        }
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        MutableScatterSet mutableScatterSet2 = new MutableScatterSet(2);
        mutableScatterSet2.plusAssign((Interaction) obj);
        mutableScatterSet2.plusAssign(interaction);
        this.setOrValue = mutableScatterSet2;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        return this.setOrValue;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return this.setOrValue;
    }

    public void pauseTimeout() {
        synchronized (this.setOrValue) {
        }
    }

    public void remove(Interaction interaction) {
        Object obj = this.setOrValue;
        if (Intrinsics.areEqual(obj, interaction)) {
            this.setOrValue = null;
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            mutableScatterSet.remove(interaction);
            int i = mutableScatterSet._size;
            if (i == 0) {
                this.setOrValue = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.setOrValue = mutableScatterSet.first();
            }
        }
    }

    public InteractionSet() {
        this.setOrValue = new Object();
        new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager$1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                if (message.what != 0) {
                    return false;
                }
                InteractionSet interactionSet = this.this$0;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (interactionSet.setOrValue) {
                    throw null;
                }
            }
        });
    }
}
