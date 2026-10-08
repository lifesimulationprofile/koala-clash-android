package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NoEndIconDelegate extends EndIconDelegate {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoEndIconDelegate(TextInputLayout textInputLayout, int i, int i2) {
        super(textInputLayout, i);
        this.$r8$classId = i2;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        switch (this.$r8$classId) {
            case 0:
                TextInputLayout textInputLayout = this.textInputLayout;
                textInputLayout.setEndIconOnClickListener(null);
                textInputLayout.setEndIconDrawable((Drawable) null);
                textInputLayout.setEndIconContentDescription((CharSequence) null);
                break;
            default:
                int i = this.customEndIcon;
                TextInputLayout textInputLayout2 = this.textInputLayout;
                textInputLayout2.setEndIconDrawable(i);
                textInputLayout2.setEndIconOnClickListener(null);
                textInputLayout2.setEndIconOnLongClickListener(null);
                break;
        }
    }
}
