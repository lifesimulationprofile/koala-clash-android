package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.koala.clash.R;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PasswordToggleEndIconDelegate extends EndIconDelegate {
    public final ClearTextEndIconDelegate.AnonymousClass3 onEditTextAttachedListener;
    public final ClearTextEndIconDelegate.AnonymousClass4 onEndIconChangedListener;
    public final DropdownMenuEndIconDelegate.AnonymousClass1 textWatcher;

    public PasswordToggleEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.textWatcher = new DropdownMenuEndIconDelegate.AnonymousClass1(this, 1);
        int i2 = 2;
        this.onEditTextAttachedListener = new ClearTextEndIconDelegate.AnonymousClass3(this, i2);
        this.onEndIconChangedListener = new ClearTextEndIconDelegate.AnonymousClass4(this, i2);
    }

    public static boolean access$000(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate) {
        EditText editText = passwordToggleEndIconDelegate.textInputLayout.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.design_password_eye;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setEndIconOnClickListener(new Toolbar.AnonymousClass4(7, this));
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        ClearTextEndIconDelegate.AnonymousClass3 anonymousClass3 = this.onEditTextAttachedListener;
        linkedHashSet.add(anonymousClass3);
        if (textInputLayout.editText != null) {
            anonymousClass3.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.onEndIconChangedListener);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
