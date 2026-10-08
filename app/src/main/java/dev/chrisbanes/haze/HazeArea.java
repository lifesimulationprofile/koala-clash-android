package dev.chrisbanes.haze;

import android.view.WindowId;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.layer.GraphicsLayer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeArea {
    public boolean contentDrawing;
    public WindowId windowId;
    public final ParcelableSnapshotMutableState positionOnScreen$delegate = Stack.mutableStateOf$default(new Offset(9205357640488583168L));
    public final ParcelableSnapshotMutableState size$delegate = Stack.mutableStateOf$default(new Size(9205357640488583168L));
    public final ParcelableSnapshotMutableFloatState zIndex$delegate = new ParcelableSnapshotMutableFloatState(0.0f);
    public final SnapshotStateSet preDrawListeners = new SnapshotStateSet();
    public final ParcelableSnapshotMutableState contentLayer$delegate = Stack.mutableStateOf$default(null);

    public final GraphicsLayer getContentLayer() {
        return (GraphicsLayer) this.contentLayer$delegate.getValue();
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m824getPositionOnScreenF1C5BW0() {
        return ((Offset) this.positionOnScreen$delegate.getValue()).packedValue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HazeArea(");
        sb.append("positionOnScreen=" + Offset.m373toStringimpl(m824getPositionOnScreenF1C5BW0()) + ", ");
        sb.append("size=" + Size.m388toStringimpl(((Size) this.size$delegate.getValue()).packedValue) + ", ");
        sb.append("zIndex=" + this.zIndex$delegate.getFloatValue() + ", ");
        sb.append("contentLayer=" + getContentLayer() + ", ");
        sb.append("contentDrawing=" + this.contentDrawing);
        sb.append(")");
        return sb.toString();
    }
}
