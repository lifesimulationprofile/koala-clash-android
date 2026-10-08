package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.MeasureResult;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListStateKt$EmptyLazyListMeasureResult$1 implements MeasureResult {
    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map getAlignmentLines() {
        return EmptyMap.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final /* synthetic */ Function1 getRulers() {
        return null;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getWidth() {
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final void placeChildren() {
    }
}
