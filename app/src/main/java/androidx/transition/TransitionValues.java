package androidx.transition;

import android.view.View;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionValues {
    public final View view;
    public final HashMap values = new HashMap();
    public final ArrayList mTargetedTransitions = new ArrayList();

    public TransitionValues(View view) {
        this.view = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public final int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public final String toString() {
        String strM = ImageAnalysis$$ExternalSyntheticLambda1.m(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n", "    values:");
        HashMap map = this.values;
        for (String str : map.keySet()) {
            strM = strM + "    " + str + ": " + map.get(str) + "\n";
        }
        return strM;
    }
}
