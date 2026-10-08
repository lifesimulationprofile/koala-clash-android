package androidx.compose.foundation.text.contextmenu.data;

import android.view.textclassifier.TextClassification;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuTextClassificationItem extends TextContextMenuComponent {
    public final int index;
    public final TextClassification textClassification;

    public TextContextMenuTextClassificationItem(Object obj, TextClassification textClassification, int i) {
        super(obj);
        this.textClassification = textClassification;
        this.index = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextContextMenuRemoteActionItem(key=");
        sb.append(this.key);
        sb.append(", textClassification=");
        sb.append(this.textClassification);
        sb.append(", index=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.index, ')');
    }
}
