package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.work.JobListenableFuture;
import coil.memory.EmptyStrongMemoryCache;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDragAndDropManager implements View.OnDragListener, DragAndDropManager {
    public final ArraySet interestedTargets;
    public final AndroidDragAndDropManager$modifier$1 modifier;
    public final DragAndDropNode rootDragAndDropNode;

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1] */
    public AndroidDragAndDropManager() {
        DragAndDropNode dragAndDropNode = new DragAndDropNode();
        dragAndDropNode.size = 0L;
        this.rootDragAndDropNode = dragAndDropNode;
        this.interestedTargets = new ArraySet(0);
        this.modifier = new ModifierNodeElement() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final Modifier.Node create() {
                return this.this$0.rootDragAndDropNode;
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            public final int hashCode() {
                return this.this$0.rootDragAndDropNode.hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public final /* bridge */ /* synthetic */ void update(Modifier.Node node) {
            }
        };
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        EmptyStrongMemoryCache emptyStrongMemoryCache = new EmptyStrongMemoryCache(2, dragEvent);
        int action = dragEvent.getAction();
        TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
        ArraySet arraySet = this.interestedTargets;
        DragAndDropNode dragAndDropNode = this.rootDragAndDropNode;
        switch (action) {
            case 1:
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                DragAndDropNode$acceptDragAndDropTransfer$1 dragAndDropNode$acceptDragAndDropTransfer$1 = new DragAndDropNode$acceptDragAndDropTransfer$1(emptyStrongMemoryCache, dragAndDropNode, ref$BooleanRef);
                if (dragAndDropNode$acceptDragAndDropTransfer$1.invoke(dragAndDropNode) == traversableNode$Companion$TraverseDescendantsAction) {
                    HitTestResultKt.traverseDescendants(dragAndDropNode, dragAndDropNode$acceptDragAndDropTransfer$1);
                }
                boolean z = ref$BooleanRef.element;
                arraySet.getClass();
                ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                while (keyIterator.hasNext()) {
                    ((DragAndDropNode) keyIterator.next()).onStarted(emptyStrongMemoryCache);
                }
                return z;
            case 2:
                dragAndDropNode.onMoved(emptyStrongMemoryCache);
                return false;
            case 3:
                return dragAndDropNode.onDrop(emptyStrongMemoryCache);
            case 4:
                JobListenableFuture.AnonymousClass1 anonymousClass1 = new JobListenableFuture.AnonymousClass1(8, emptyStrongMemoryCache);
                if (anonymousClass1.invoke(dragAndDropNode) == traversableNode$Companion$TraverseDescendantsAction) {
                    HitTestResultKt.traverseDescendants(dragAndDropNode, anonymousClass1);
                }
                arraySet.clear();
                return false;
            case 5:
                dragAndDropNode.onEntered(emptyStrongMemoryCache);
                return false;
            case 6:
                dragAndDropNode.onExited(emptyStrongMemoryCache);
                return false;
            default:
                return false;
        }
    }
}
