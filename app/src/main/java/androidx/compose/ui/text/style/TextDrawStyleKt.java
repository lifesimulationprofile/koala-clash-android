package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextDrawStyleKt {
    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m673modulateDxMtmZc(float f, long j) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), Color.m434getAlphaimpl(j) * f, Color.m436getColorSpaceimpl(j));
    }
}
