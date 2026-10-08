package androidx.compose.foundation.lazy;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 {
    public final /* synthetic */ LazyListState $state;
    public final DerivedSnapshotState totalItemsCount$delegate;

    public LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(LazyListState lazyListState) {
        this.$state = lazyListState;
        this.totalItemsCount$delegate = Stack.derivedStateOf(new BasicTextKt$$ExternalSyntheticLambda0(5, lazyListState));
    }
}
