package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IconHelper {
    public static Context zza;
    public static Boolean zzb;

    public static void applyIconTint(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        ColorStateList colorStateListCreateFromXml;
        ColorStateList colorStateList;
        ResourcesCompat.ColorStateListCacheEntry colorStateListCacheEntry;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ResourcesCompat.ColorStateListCacheKey colorStateListCacheKey = new ResourcesCompat.ColorStateListCacheKey(resources, theme);
        synchronized (ResourcesCompat.sColorStateCacheLock) {
            try {
                SparseArray sparseArray = (SparseArray) ResourcesCompat.sColorStateCaches.get(colorStateListCacheKey);
                colorStateListCreateFromXml = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (colorStateListCacheEntry = (ResourcesCompat.ColorStateListCacheEntry) sparseArray.get(i)) == null) {
                    colorStateList = null;
                } else {
                    if (colorStateListCacheEntry.mConfiguration.equals(resources.getConfiguration())) {
                        if (theme != null || colorStateListCacheEntry.mThemeHash != 0) {
                            if (theme == null || colorStateListCacheEntry.mThemeHash != theme.hashCode()) {
                            }
                        }
                        colorStateList = colorStateListCacheEntry.mValue;
                    }
                    sparseArray.remove(i);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            try {
                colorStateListCreateFromXml = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateListCreateFromXml == null) {
            return resources.getColorStateList(i, theme);
        }
        ResourcesCompat.addColorStateListToCache(colorStateListCacheKey, i, colorStateListCreateFromXml, theme);
        return colorStateListCreateFromXml;
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }

    public static void refreshIconDrawableState(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }
}
