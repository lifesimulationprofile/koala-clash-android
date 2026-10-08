package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.internal.mlkit_vision_common.zzaw;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatEmojiTextHelper {
    public final EmptyStrongMemoryCache mEmojiTextViewHelper;
    public final TextView mView;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new EmptyStrongMemoryCache(textView);
    }

    public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return ((zzaw) this.mEmojiTextViewHelper.weakMemoryCache).getFilters(inputFilterArr);
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setAllCaps(boolean z) {
        ((zzaw) this.mEmojiTextViewHelper.weakMemoryCache).setAllCaps(z);
    }

    public final void setEnabled(boolean z) {
        ((zzaw) this.mEmojiTextViewHelper.weakMemoryCache).setEnabled(z);
    }
}
