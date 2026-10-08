package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;
import okhttp3.Request;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollElement extends ModifierNodeElement {
    public final NestedScrollConnection connection;

    public NestedScrollElement(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new NestedScrollNode(this.connection, null);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof NestedScrollElement) && Intrinsics.areEqual(((NestedScrollElement) obj).connection, this.connection);
    }

    public final int hashCode() {
        return this.connection.hashCode() * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) node;
        nestedScrollNode.connection = this.connection;
        Request.Builder builder = nestedScrollNode.resolvedDispatcher;
        if (((NestedScrollNode) builder.url) == nestedScrollNode) {
            builder.url = null;
        }
        Request.Builder builder2 = new Request.Builder(5);
        nestedScrollNode.resolvedDispatcher = builder2;
        if (nestedScrollNode.isAttached) {
            builder2.url = nestedScrollNode;
            builder2.method = null;
            nestedScrollNode.lastKnownParentNode = null;
            builder2.headers = new Handshake.AnonymousClass2(5, nestedScrollNode);
            builder2.tags = nestedScrollNode.getCoroutineScope();
        }
    }
}
