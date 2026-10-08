package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 {
    public final /* synthetic */ PaddingValuesImpl $contentPadding;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    public final /* synthetic */ Function0 $itemProviderLambda;
    public final /* synthetic */ boolean $reverseLayout;
    public final /* synthetic */ LazyListState $state;
    public final /* synthetic */ DummyHandle $stickyItemsPlacement;
    public final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    public LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, PaddingValuesImpl paddingValuesImpl, boolean z, KProperty0 kProperty0, Arrangement.Vertical vertical, CoroutineScope coroutineScope, GraphicsContext graphicsContext, DummyHandle dummyHandle, Alignment.Horizontal horizontal) {
        this.$state = lazyListState;
        this.$contentPadding = paddingValuesImpl;
        this.$reverseLayout = z;
        this.$itemProviderLambda = kProperty0;
        this.$verticalArrangement = vertical;
        this.$coroutineScope = coroutineScope;
        this.$stickyItemsPlacement = dummyHandle;
        this.$horizontalAlignment = horizontal;
    }
}
