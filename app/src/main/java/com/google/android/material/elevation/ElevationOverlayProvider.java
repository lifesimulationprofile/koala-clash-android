package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.core.graphics.ColorUtils;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ElevationOverlayProvider {
    public static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayAccentColor;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        TypedValue typedValueResolve = PredictiveBackHandlerKt.resolve(context, R.attr.elevationOverlayEnabled);
        boolean z = (typedValueResolve == null || typedValueResolve.type != 18 || typedValueResolve.data == 0) ? false : true;
        int color = BackHandlerKt.getColor(context, R.attr.elevationOverlayColor, 0);
        int color2 = BackHandlerKt.getColor(context, R.attr.elevationOverlayAccentColor, 0);
        int color3 = BackHandlerKt.getColor(context, R.attr.colorSurface, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = color;
        this.elevationOverlayAccentColor = color2;
        this.colorSurface = color3;
        this.displayDensity = f;
    }

    public final int compositeOverlayIfNeeded(int i, float f) {
        int i2;
        if (!this.elevationOverlayEnabled || ColorUtils.setAlphaComponent(i, 255) != this.colorSurface) {
            return i;
        }
        float f2 = this.displayDensity;
        float fMin = (f2 <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iLayer = BackHandlerKt.layer(fMin, ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor);
        if (fMin > 0.0f && (i2 = this.elevationOverlayAccentColor) != 0) {
            iLayer = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, OVERLAY_ACCENT_COLOR_ALPHA), iLayer);
        }
        return ColorUtils.setAlphaComponent(iLayer, iAlpha);
    }
}
