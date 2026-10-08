package androidx.compose.foundation.text.selection;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionRegistrarKt {
    public static final DynamicProvidableCompositionLocal LocalSelectionRegistrar = new DynamicProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(17));

    public static final boolean hasSelection(SelectionRegistrarImpl selectionRegistrarImpl, long j) {
        MutableLongObjectMap subselections;
        if (selectionRegistrarImpl == null || (subselections = selectionRegistrarImpl.getSubselections()) == null) {
            return false;
        }
        return subselections.containsKey(j);
    }
}
