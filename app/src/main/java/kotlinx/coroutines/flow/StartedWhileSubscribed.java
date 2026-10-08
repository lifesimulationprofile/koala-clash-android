package kotlinx.coroutines.flow;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.ui.Modifier;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StartedWhileSubscribed {
    public final boolean equals(Object obj) {
        return obj instanceof StartedWhileSubscribed;
    }

    public final int hashCode() {
        return (((int) 0) * 31) + ((int) 9223372034707292160L);
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("SharingStarted.WhileSubscribed("), CollectionsKt.joinToString$default(MatrixExt.build(new ListBuilder(2)), null, null, null, null, 63), ')');
    }
}
