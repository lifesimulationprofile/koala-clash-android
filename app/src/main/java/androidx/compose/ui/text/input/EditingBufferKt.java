package androidx.compose.ui.text.input;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m658updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM640getLengthimpl;
        int iM642getMinimpl = TextRange.m642getMinimpl(j);
        int iM641getMaximpl = TextRange.m641getMaximpl(j);
        if ((TextRange.m642getMinimpl(j2) < TextRange.m641getMaximpl(j)) && (TextRange.m642getMinimpl(j) < TextRange.m641getMaximpl(j2))) {
            if ((TextRange.m642getMinimpl(j2) <= TextRange.m642getMinimpl(j)) && (TextRange.m641getMaximpl(j) <= TextRange.m641getMaximpl(j2))) {
                iM642getMinimpl = TextRange.m642getMinimpl(j2);
                iM641getMaximpl = iM642getMinimpl;
            } else {
                if ((TextRange.m642getMinimpl(j) <= TextRange.m642getMinimpl(j2)) && (TextRange.m641getMaximpl(j2) <= TextRange.m641getMaximpl(j))) {
                    iM640getLengthimpl = TextRange.m640getLengthimpl(j2);
                } else {
                    int iM642getMinimpl2 = TextRange.m642getMinimpl(j2);
                    if (iM642getMinimpl >= TextRange.m641getMaximpl(j2) || iM642getMinimpl2 > iM642getMinimpl) {
                        iM641getMaximpl = TextRange.m642getMinimpl(j2);
                    } else {
                        iM642getMinimpl = TextRange.m642getMinimpl(j2);
                        iM640getLengthimpl = TextRange.m640getLengthimpl(j2);
                    }
                }
                iM641getMaximpl -= iM640getLengthimpl;
            }
        } else if (iM641getMaximpl > TextRange.m642getMinimpl(j2)) {
            iM642getMinimpl -= TextRange.m640getLengthimpl(j2);
            iM640getLengthimpl = TextRange.m640getLengthimpl(j2);
            iM641getMaximpl -= iM640getLengthimpl;
        }
        return ParagraphKt.TextRange(iM642getMinimpl, iM641getMaximpl);
    }
}
