package androidx.core.content.res;

import androidx.core.provider.FontRequest;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$ProviderResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {
    public final FontRequest mFallbackRequest;
    public final FontRequest mRequest;
    public final int mStrategy;
    public final String mSystemFontFamilyName;
    public final int mTimeoutMs;

    public FontResourcesParserCompat$ProviderResourceEntry(FontRequest fontRequest, FontRequest fontRequest2, int i, int i2, String str) {
        this.mRequest = fontRequest;
        this.mFallbackRequest = fontRequest2;
        this.mStrategy = i;
        this.mTimeoutMs = i2;
        this.mSystemFontFamilyName = str;
    }
}
