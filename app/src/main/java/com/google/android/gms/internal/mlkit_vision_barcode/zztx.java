package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.text.font.AndroidFontResolveInterceptor;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontWeightAdjustmentHelperApi31;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztx {
    public static final FontFamilyResolverImpl createFontFamilyResolver(Context context) {
        return new FontFamilyResolverImpl(new AndroidUriHandler(context, 2), new AndroidFontResolveInterceptor(Build.VERSION.SDK_INT >= 31 ? FontWeightAdjustmentHelperApi31.INSTANCE.fontWeightAdjustment(context) : 0));
    }
}
