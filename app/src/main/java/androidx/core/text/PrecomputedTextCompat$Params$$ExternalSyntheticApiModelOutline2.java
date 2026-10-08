package androidx.core.text;

import android.text.PrecomputedText;
import android.text.TextPaint;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextSelection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2 {
    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ PrecomputedText.Params.Builder m(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* synthetic */ TextClassification.Request.Builder m(CharSequence charSequence, int i, int i2) {
        return new TextClassification.Request.Builder(charSequence, i, i2);
    }

    public static /* synthetic */ TextClassificationContext.Builder m(String str, String str2) {
        return new TextClassificationContext.Builder(str, str2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TextSelection.Request.Builder m749m(CharSequence charSequence, int i, int i2) {
        return new TextSelection.Request.Builder(charSequence, i, i2);
    }

    public static /* synthetic */ void m() {
    }
}
