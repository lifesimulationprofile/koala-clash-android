package androidx.compose.foundation.text.contextmenu.data;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuItem extends TextContextMenuComponent {
    public final String label;
    public final int leadingIcon;
    public final Function1 onClick;

    public TextContextMenuItem(Object obj, String str, int i, Function1 function1) {
        super(obj);
        this.label = str;
        this.leadingIcon = i;
        this.onClick = function1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextContextMenuItem(key=");
        sb.append(this.key);
        sb.append(", label=\"");
        sb.append(this.label);
        sb.append("\", leadingIcon=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.leadingIcon, ')');
    }
}
