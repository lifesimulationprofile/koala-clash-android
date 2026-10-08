package androidx.compose.ui.text.input;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.CircularArray;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.github.kr328.clash.log.LogcatCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EditingBuffer {
    public int compositionEnd;
    public int compositionStart;
    public final LogcatCache gapBuffer;
    public int selectionEnd;
    public int selectionStart;

    public EditingBuffer(AnnotatedString annotatedString, long j) {
        String str = annotatedString.text;
        LogcatCache logcatCache = new LogcatCache(2);
        logcatCache.array = str;
        logcatCache.removed = -1;
        logcatCache.appended = -1;
        this.gapBuffer = logcatCache;
        this.selectionStart = TextRange.m642getMinimpl(j);
        this.selectionEnd = TextRange.m641getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM642getMinimpl = TextRange.m642getMinimpl(j);
        int iM641getMaximpl = TextRange.m641getMaximpl(j);
        if (iM642getMinimpl < 0 || iM642getMinimpl > str.length()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(iM642getMinimpl, "start (", ") offset is outside of text region ");
            sbM.append(str.length());
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (iM641getMaximpl < 0 || iM641getMaximpl > str.length()) {
            StringBuilder sbM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(iM641getMaximpl, "end (", ") offset is outside of text region ");
            sbM2.append(str.length());
            throw new IndexOutOfBoundsException(sbM2.toString());
        }
        if (iM642getMinimpl > iM641getMaximpl) {
            throw new IllegalArgumentException(Modifier.CC.m(iM642getMinimpl, iM641getMaximpl, "Do not set reversed range: ", " > "));
        }
    }

    public final void delete$ui_text(int i, int i2) {
        long jTextRange = ParagraphKt.TextRange(i, i2);
        this.gapBuffer.replace(i, i2, "");
        long jM658updateRangeAfterDeletepWDy79M = EditingBufferKt.m658updateRangeAfterDeletepWDy79M(ParagraphKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m642getMinimpl(jM658updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m641getMaximpl(jM658updateRangeAfterDeletepWDy79M));
        int i3 = this.compositionStart;
        if (i3 != -1) {
            long jM658updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m658updateRangeAfterDeletepWDy79M(ParagraphKt.TextRange(i3, this.compositionEnd), jTextRange);
            if (TextRange.m639getCollapsedimpl(jM658updateRangeAfterDeletepWDy79M2)) {
                this.compositionStart = -1;
                this.compositionEnd = -1;
            } else {
                this.compositionStart = TextRange.m642getMinimpl(jM658updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m641getMaximpl(jM658updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text(int i) {
        LogcatCache logcatCache = this.gapBuffer;
        CircularArray circularArray = (CircularArray) logcatCache.lock;
        if (circularArray == null) {
            return ((String) logcatCache.array).charAt(i);
        }
        if (i < logcatCache.removed) {
            return ((String) logcatCache.array).charAt(i);
        }
        int iGapLength = circularArray.head - circularArray.gapLength();
        int i2 = logcatCache.removed;
        if (i >= iGapLength + i2) {
            return ((String) logcatCache.array).charAt(i - ((iGapLength - logcatCache.appended) + i2));
        }
        int i3 = i - i2;
        int i4 = circularArray.tail;
        return i3 < i4 ? ((char[]) circularArray.elements)[i3] : ((char[]) circularArray.elements)[(i3 - i4) + circularArray.capacityBitmask];
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text, reason: not valid java name */
    public final TextRange m657getCompositionMzsxiRA$ui_text() {
        int i = this.compositionStart;
        if (i != -1) {
            return new TextRange(ParagraphKt.TextRange(i, this.compositionEnd));
        }
        return null;
    }

    public final void replace$ui_text(int i, int i2, String str) {
        LogcatCache logcatCache = this.gapBuffer;
        if (i < 0 || i > logcatCache.getLength()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "start (", ") offset is outside of text region ");
            sbM.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (i2 < 0 || i2 > logcatCache.getLength()) {
            StringBuilder sbM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "end (", ") offset is outside of text region ");
            sbM2.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM2.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(Modifier.CC.m(i, i2, "Do not set reversed range: ", " > "));
        }
        logcatCache.replace(i, i2, str);
        setSelectionStart(str.length() + i);
        setSelectionEnd(str.length() + i);
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void setComposition$ui_text(int i, int i2) {
        LogcatCache logcatCache = this.gapBuffer;
        if (i < 0 || i > logcatCache.getLength()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "start (", ") offset is outside of text region ");
            sbM.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (i2 < 0 || i2 > logcatCache.getLength()) {
            StringBuilder sbM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "end (", ") offset is outside of text region ");
            sbM2.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM2.toString());
        }
        if (i >= i2) {
            throw new IllegalArgumentException(Modifier.CC.m(i, i2, "Do not set reversed or empty range: ", " > "));
        }
        this.compositionStart = i;
        this.compositionEnd = i2;
    }

    public final void setSelection$ui_text(int i, int i2) {
        LogcatCache logcatCache = this.gapBuffer;
        if (i < 0 || i > logcatCache.getLength()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "start (", ") offset is outside of text region ");
            sbM.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM.toString());
        }
        if (i2 < 0 || i2 > logcatCache.getLength()) {
            StringBuilder sbM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "end (", ") offset is outside of text region ");
            sbM2.append(logcatCache.getLength());
            throw new IndexOutOfBoundsException(sbM2.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(Modifier.CC.m(i, i2, "Do not set reversed range: ", " > "));
        }
        setSelectionStart(i);
        setSelectionEnd(i2);
    }

    public final void setSelectionEnd(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + i);
        }
        this.selectionEnd = i;
    }

    public final void setSelectionStart(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + i);
        }
        this.selectionStart = i;
    }

    public final String toString() {
        return this.gapBuffer.toString();
    }
}
