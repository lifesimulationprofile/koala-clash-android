package androidx.compose.ui.text;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VerbatimTtsAnnotation implements AnnotatedString.Annotation {
    public final String verbatim;

    public VerbatimTtsAnnotation(String str) {
        this.verbatim = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerbatimTtsAnnotation) {
            return Intrinsics.areEqual(this.verbatim, ((VerbatimTtsAnnotation) obj).verbatim);
        }
        return false;
    }

    public final int hashCode() {
        return this.verbatim.hashCode();
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("VerbatimTtsAnnotation(verbatim="), this.verbatim, ')');
    }
}
