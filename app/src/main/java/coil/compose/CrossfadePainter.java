package coil.compose;

import android.os.SystemClock;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil.disk.RealDiskCache;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadePainter extends Painter {
    public final ContentScale contentScale;
    public final int durationMillis;
    public final Painter end;
    public final boolean fadeStart;
    public boolean isDone;
    public Painter start;
    public final ParcelableSnapshotMutableIntState invalidateTick$delegate = new ParcelableSnapshotMutableIntState(0);
    public long startTimeMillis = -1;
    public final ParcelableSnapshotMutableFloatState maxAlpha$delegate = new ParcelableSnapshotMutableFloatState(1.0f);
    public final ParcelableSnapshotMutableState colorFilter$delegate = Stack.mutableStateOf$default(null);

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, int i, boolean z) {
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale;
        this.durationMillis = i;
        this.fadeStart = z;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.maxAlpha$delegate.setFloatValue(f);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter$delegate.setValue(blendModeColorFilter);
    }

    public final void drawPainter(LayoutNodeDrawScope layoutNodeDrawScope, Painter painter, float f) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (painter == null || f <= 0.0f) {
            return;
        }
        long jMo472getSizeNHjbRc = layoutNodeDrawScope.mo472getSizeNHjbRc();
        long jMo490getIntrinsicSizeNHjbRc = painter.mo490getIntrinsicSizeNHjbRc();
        long jM537timesUQTWf7w = (jMo490getIntrinsicSizeNHjbRc == 9205357640488583168L || Size.m386isEmptyimpl(jMo490getIntrinsicSizeNHjbRc) || jMo472getSizeNHjbRc == 9205357640488583168L || Size.m386isEmptyimpl(jMo472getSizeNHjbRc)) ? jMo472getSizeNHjbRc : RulerKt.m537timesUQTWf7w(jMo490getIntrinsicSizeNHjbRc, this.contentScale.mo514computeScaleFactorH7hwNQA(jMo490getIntrinsicSizeNHjbRc, jMo472getSizeNHjbRc));
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.colorFilter$delegate;
        if (jMo472getSizeNHjbRc == 9205357640488583168L || Size.m386isEmptyimpl(jMo472getSizeNHjbRc)) {
            painter.m493drawx_KDEd0(layoutNodeDrawScope, jM537timesUQTWf7w, f, (BlendModeColorFilter) parcelableSnapshotMutableState.getValue());
            return;
        }
        long j = jM537timesUQTWf7w;
        float f2 = 2;
        float fM385getWidthimpl = (Size.m385getWidthimpl(jMo472getSizeNHjbRc) - Size.m385getWidthimpl(j)) / f2;
        float fM383getHeightimpl = (Size.m383getHeightimpl(jMo472getSizeNHjbRc) - Size.m383getHeightimpl(j)) / f2;
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).inset(fM385getWidthimpl, fM383getHeightimpl, fM385getWidthimpl, fM383getHeightimpl);
        painter.m493drawx_KDEd0(layoutNodeDrawScope, j, f, (BlendModeColorFilter) parcelableSnapshotMutableState.getValue());
        float f3 = -fM385getWidthimpl;
        float f4 = -fM383getHeightimpl;
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).inset(f3, f4, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo490getIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long jMo490getIntrinsicSizeNHjbRc = painter != null ? painter.mo490getIntrinsicSizeNHjbRc() : 0L;
        Painter painter2 = this.end;
        long jMo490getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo490getIntrinsicSizeNHjbRc() : 0L;
        boolean z = jMo490getIntrinsicSizeNHjbRc != 9205357640488583168L;
        boolean z2 = jMo490getIntrinsicSizeNHjbRc2 != 9205357640488583168L;
        if (z && z2) {
            return SizeKt.Size(Math.max(Size.m385getWidthimpl(jMo490getIntrinsicSizeNHjbRc), Size.m385getWidthimpl(jMo490getIntrinsicSizeNHjbRc2)), Math.max(Size.m383getHeightimpl(jMo490getIntrinsicSizeNHjbRc), Size.m383getHeightimpl(jMo490getIntrinsicSizeNHjbRc2)));
        }
        return 9205357640488583168L;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z = this.isDone;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.maxAlpha$delegate;
        Painter painter = this.end;
        if (z) {
            drawPainter(layoutNodeDrawScope, painter, parcelableSnapshotMutableFloatState.getFloatValue());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = jUptimeMillis;
        }
        float f = (jUptimeMillis - this.startTimeMillis) / this.durationMillis;
        float floatValue = parcelableSnapshotMutableFloatState.getFloatValue() * RangesKt.coerceIn(f, 0.0f, 1.0f);
        float floatValue2 = this.fadeStart ? parcelableSnapshotMutableFloatState.getFloatValue() - floatValue : parcelableSnapshotMutableFloatState.getFloatValue();
        this.isDone = f >= 1.0f;
        drawPainter(layoutNodeDrawScope, this.start, floatValue2);
        drawPainter(layoutNodeDrawScope, painter, floatValue);
        if (this.isDone) {
            this.start = null;
        } else {
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.invalidateTick$delegate;
            parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + 1);
        }
    }
}
