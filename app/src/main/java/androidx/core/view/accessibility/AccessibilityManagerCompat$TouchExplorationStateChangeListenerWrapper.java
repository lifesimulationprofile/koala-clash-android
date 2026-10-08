package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.tasks.zzs;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final zzs mListener;

    public AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(zzs zzsVar) {
        this.mListener = zzsVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) {
            return this.mListener.equals(((AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) obj).mListener);
        }
        return false;
    }

    public final int hashCode() {
        return this.mListener.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.mListener.zza;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) dropdownMenuEndIconDelegate.textInputLayout.getEditText();
        if (autoCompleteTextView == null || autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        CheckableImageButton checkableImageButton = dropdownMenuEndIconDelegate.endIconView;
        int i = z ? 2 : 1;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
