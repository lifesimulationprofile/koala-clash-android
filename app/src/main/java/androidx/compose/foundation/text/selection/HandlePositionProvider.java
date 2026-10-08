package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    public final Alignment handleReferencePoint;
    public final OffsetProvider positionProvider;
    public long prevPosition = 0;

    public HandlePositionProvider(Alignment alignment, OffsetProvider offsetProvider) {
        this.handleReferencePoint = alignment;
        this.positionProvider = offsetProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo8calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        long jMo167provideF1C5BW0 = this.positionProvider.mo167provideF1C5BW0();
        if ((9223372034707292159L & jMo167provideF1C5BW0) == 9205357640488583168L) {
            jMo167provideF1C5BW0 = this.prevPosition;
        }
        this.prevPosition = jMo167provideF1C5BW0;
        return IntOffset.m711plusqkQi6aY(IntOffset.m711plusqkQi6aY((((long) intRect.left) << 32) | (((long) intRect.top) & 4294967295L), IntOffsetKt.m714roundk4lQ0M(jMo167provideF1C5BW0)), this.handleReferencePoint.mo304alignKFBX0sM(j2, 0L, layoutDirection));
    }
}
