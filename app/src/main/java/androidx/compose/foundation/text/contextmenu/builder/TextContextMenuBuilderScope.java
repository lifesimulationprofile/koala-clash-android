package androidx.compose.foundation.text.contextmenu.builder;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuBuilderScope {
    public final MutableObjectList components = new MutableObjectList();
    public final MutableObjectList filters = new MutableObjectList();

    public final void separator() {
        this.components.add(TextContextMenuSeparator.INSTANCE);
    }
}
