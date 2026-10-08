package androidx.compose.foundation.text.contextmenu.data;

import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuData {
    public static final TextContextMenuData Empty = new TextContextMenuData(EmptyList.INSTANCE);
    public final Object components;

    public TextContextMenuData(List list) {
        this.components = list;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    public final String toString() {
        return "TextContextMenuData(components=" + ListUtilsKt.fastJoinToString$default(this.components, "\n\t", null, 56) + ')';
    }
}
