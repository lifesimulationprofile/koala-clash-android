package androidx.compose.ui.text.font;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontResolveInterceptor {
    public final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int i) {
        this.fontWeightAdjustment = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment;
    }

    public final int hashCode() {
        return this.fontWeightAdjustment;
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("AndroidFontResolveInterceptor(fontWeightAdjustment="), this.fontWeightAdjustment, ')');
    }
}
