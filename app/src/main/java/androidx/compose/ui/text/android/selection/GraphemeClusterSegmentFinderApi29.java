package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import com.google.android.gms.internal.mlkit_vision_barcode.zztt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderApi29 extends zztt {
    public final CharSequence text;
    public final TextPaint textPaint;

    public GraphemeClusterSegmentFinderApi29(CharSequence charSequence, TextPaint textPaint) {
        this.text = charSequence;
        this.textPaint = textPaint;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztt
    public final int next(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztt
    public final int previous(int i) {
        CharSequence charSequence = this.text;
        return this.textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
    }
}
