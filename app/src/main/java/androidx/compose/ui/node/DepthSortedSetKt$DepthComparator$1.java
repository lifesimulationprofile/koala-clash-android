package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DepthSortedSetKt$DepthComparator$1 implements Comparator {
    public static final DepthSortedSetKt$DepthComparator$1 INSTANCE = new DepthSortedSetKt$DepthComparator$1(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DepthSortedSetKt$DepthComparator$1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                LayoutNode layoutNode = (LayoutNode) obj;
                LayoutNode layoutNode2 = (LayoutNode) obj2;
                int iCompare = Intrinsics.compare(layoutNode.depth, layoutNode2.depth);
                return iCompare != 0 ? iCompare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            default:
                LayoutNode layoutNode3 = (LayoutNode) obj;
                LayoutNode layoutNode4 = (LayoutNode) obj2;
                int iCompare2 = Intrinsics.compare(layoutNode4.depth, layoutNode3.depth);
                return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(layoutNode3.hashCode(), layoutNode4.hashCode());
        }
    }
}
