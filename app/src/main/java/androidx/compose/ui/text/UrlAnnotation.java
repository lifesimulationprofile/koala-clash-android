package androidx.compose.ui.text;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UrlAnnotation implements AnnotatedString.Annotation {
    public final String url;

    public UrlAnnotation(String str) {
        this.url = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlAnnotation) {
            return Intrinsics.areEqual(this.url, ((UrlAnnotation) obj).url);
        }
        return false;
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("UrlAnnotation(url="), this.url, ')');
    }
}
