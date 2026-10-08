package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassification;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextClassificationResult {
    public final long selection;
    public final CharSequence text;
    public final TextClassification textClassification;

    public TextClassificationResult(CharSequence charSequence, long j, TextClassification textClassification) {
        this.text = charSequence;
        this.selection = j;
        this.textClassification = textClassification;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextClassificationResult)) {
            return false;
        }
        TextClassificationResult textClassificationResult = (TextClassificationResult) obj;
        return Intrinsics.areEqual(this.text, textClassificationResult.text) && TextRange.m638equalsimpl0(this.selection, textClassificationResult.selection) && Intrinsics.areEqual(this.textClassification, textClassificationResult.textClassification);
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        int i = TextRange.$r8$clinit;
        long j = this.selection;
        return this.textClassification.hashCode() + ((((int) (j ^ (j >>> 32))) + iHashCode) * 31);
    }

    public final String toString() {
        return "TextClassificationResult(text=" + ((Object) this.text) + ", selection=" + ((Object) TextRange.m644toStringimpl(this.selection)) + ", textClassification=" + this.textClassification + ')';
    }
}
