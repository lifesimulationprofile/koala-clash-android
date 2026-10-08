package androidx.compose.ui.text.font;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public final String fontFamilyName;
    public final String name;

    public GenericFontFamily(String str, String str2) {
        this.name = str;
        this.fontFamilyName = str2;
    }

    public final String toString() {
        return this.fontFamilyName;
    }
}
