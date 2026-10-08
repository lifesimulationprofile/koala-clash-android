package com.google.android.material.internal;

import android.text.TextPaint;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.resources.TextAppearance;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextDrawableHelper {
    public final WeakReference delegate;
    public TextAppearance textAppearance;
    public float textWidth;
    public final TextPaint textPaint = new TextPaint(1);
    public final Chip.AnonymousClass1 fontCallback = new Chip.AnonymousClass1(1, this);
    public boolean textWidthDirty = true;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface TextDrawableDelegate {
        int[] getState();
    }

    public TextDrawableHelper(ChipDrawable chipDrawable) {
        this.delegate = new WeakReference(null);
        this.delegate = new WeakReference(chipDrawable);
    }
}
