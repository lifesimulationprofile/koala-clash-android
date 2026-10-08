package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityAction {
    public final Function action;
    public final String label;

    public AccessibilityAction(String str, Function function) {
        this.label = str;
        this.action = function;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        return Intrinsics.areEqual(this.label, accessibilityAction.label) && Intrinsics.areEqual(this.action, accessibilityAction.action);
    }

    public final String getLabel() {
        return this.label;
    }

    public final int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Function function = this.action;
        return iHashCode + (function != null ? function.hashCode() : 0);
    }

    public final String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
