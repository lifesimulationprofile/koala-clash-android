package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Locale {
    public final java.util.Locale platformLocale;

    public Locale(java.util.Locale locale) {
        this.platformLocale = locale;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Locale)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual(this.platformLocale.toLanguageTag(), ((Locale) obj).platformLocale.toLanguageTag());
    }

    public final int hashCode() {
        return this.platformLocale.toLanguageTag().hashCode();
    }

    public final String toString() {
        return this.platformLocale.toLanguageTag();
    }
}
