package androidx.compose.ui.text.android.style;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceSpan extends MetricAffectingSpan {
    public final /* synthetic */ int $r8$classId;
    public final Object typeface;

    public /* synthetic */ TypefaceSpan(int i, Object obj) {
        this.$r8$classId = i;
        this.typeface = obj;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.$r8$classId) {
            case 0:
                textPaint.setTypeface((Typeface) this.typeface);
                break;
            default:
                textPaint.setFontFeatureSettings((String) this.typeface);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.$r8$classId) {
            case 0:
                textPaint.setTypeface((Typeface) this.typeface);
                break;
            default:
                textPaint.setFontFeatureSettings((String) this.typeface);
                break;
        }
    }
}
