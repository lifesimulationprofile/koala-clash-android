package androidx.core.content.res;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$FontFileResourceEntry {
    public final String mFileName;
    public final boolean mItalic;
    public final int mResourceId;
    public final int mTtcIndex;
    public final String mVariationSettings;
    public final int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(String str, int i, boolean z, String str2, int i2, int i3) {
        this.mFileName = str;
        this.mWeight = i;
        this.mItalic = z;
        this.mVariationSettings = str2;
        this.mTtcIndex = i2;
        this.mResourceId = i3;
    }
}
