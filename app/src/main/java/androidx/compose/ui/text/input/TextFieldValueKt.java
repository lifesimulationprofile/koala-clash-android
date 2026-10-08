package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        annotatedString.getClass();
        return annotatedString.subSequence(TextRange.m642getMinimpl(j), TextRange.m641getMaximpl(j));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        AnnotatedString annotatedString2 = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        int iM641getMaximpl = TextRange.m641getMaximpl(j);
        int iM641getMaximpl2 = TextRange.m641getMaximpl(j);
        int length = iM641getMaximpl2 + i;
        if (((i ^ length) & (iM641getMaximpl2 ^ length)) < 0) {
            length = annotatedString2.text.length();
        }
        return annotatedString.subSequence(iM641getMaximpl, Math.min(length, annotatedString2.text.length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        int iM642getMinimpl = TextRange.m642getMinimpl(j);
        int i2 = iM642getMinimpl - i;
        if (((iM642getMinimpl ^ i2) & (i ^ iM642getMinimpl)) < 0) {
            i2 = 0;
        }
        return annotatedString.subSequence(Math.max(0, i2), TextRange.m642getMinimpl(j));
    }
}
