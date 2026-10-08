package androidx.compose.ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNodeCopy {
    public final MutableIntSet children;
    public final SemanticsConfiguration unmergedConfig;

    public SemanticsNodeCopy(SemanticsNode semanticsNode, IntObjectMap intObjectMap) {
        this.unmergedConfig = semanticsNode.unmergedConfig;
        List children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode);
        this.children = new MutableIntSet(children$ui$default.size());
        int size = children$ui$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) children$ui$default.get(i);
            if (intObjectMap.containsKey(semanticsNode2.id)) {
                this.children.add(semanticsNode2.id);
            }
        }
    }
}
