package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.koala.clash.R.attr.radioButtonStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ViewUtils.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialRadioButton, com.koala.clash.R.attr.radioButtonStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setButtonTintList(ShortcutManagerCompat.getColorStateList(context2, typedArrayObtainStyledAttributes, 0));
        }
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int color = BackHandlerKt.getColor(this, com.koala.clash.R.attr.colorControlActivated);
            int color2 = BackHandlerKt.getColor(this, com.koala.clash.R.attr.colorOnSurface);
            int color3 = BackHandlerKt.getColor(this, com.koala.clash.R.attr.colorSurface);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{BackHandlerKt.layer(1.0f, color3, color), BackHandlerKt.layer(0.54f, color3, color2), BackHandlerKt.layer(0.38f, color3, color2), BackHandlerKt.layer(0.38f, color3, color2)});
        }
        return this.materialThemeColorsTintList;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
