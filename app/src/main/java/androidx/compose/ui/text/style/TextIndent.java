package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextIndent {
    public static final TextIndent None = new TextIndent(TextUnitKt.getSp(0), TextUnitKt.getSp(0));
    public final long firstLine;
    public final long restLine;

    public TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m722equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m722equalsimpl0(this.restLine, textIndent.restLine);
    }

    public final int hashCode() {
        return TextUnit.m725hashCodeimpl(this.restLine) + (TextUnit.m725hashCodeimpl(this.firstLine) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.m726toStringimpl(this.firstLine)) + ", restLine=" + ((Object) TextUnit.m726toStringimpl(this.restLine)) + ')';
    }
}
