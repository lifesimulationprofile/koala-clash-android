package androidx.compose.foundation.text.contextmenu.internal;

import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MaintainWindowPositionPopupPositionProvider implements PopupPositionProvider {
    public final Toolbar.AnonymousClass1 popupPositionProvider;
    public LayoutDirection previousLayoutDirection;
    public IntSize previousPopupContentSize;
    public IntOffset previousPosition;
    public IntSize previousWindowSize;

    public MaintainWindowPositionPopupPositionProvider(Toolbar.AnonymousClass1 anonymousClass1) {
        this.popupPositionProvider = anonymousClass1;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo8calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        IntOffset intOffset = this.previousPosition;
        if (intOffset != null) {
            IntSize intSize = this.previousWindowSize;
            if ((intSize == null ? false : IntSize.m717equalsimpl0(intSize.packedValue, j)) && this.previousLayoutDirection == layoutDirection) {
                IntSize intSize2 = this.previousPopupContentSize;
                if (intSize2 != null ? IntSize.m717equalsimpl0(intSize2.packedValue, j2) : false) {
                    return intOffset.packedValue;
                }
            }
        }
        long jMo8calculatePositionllwVHH4 = this.popupPositionProvider.mo8calculatePositionllwVHH4(intRect, j, layoutDirection, j2);
        this.previousWindowSize = new IntSize(j);
        this.previousLayoutDirection = layoutDirection;
        this.previousPopupContentSize = new IntSize(j2);
        this.previousPosition = new IntOffset(jMo8calculatePositionllwVHH4);
        return jMo8calculatePositionllwVHH4;
    }
}
