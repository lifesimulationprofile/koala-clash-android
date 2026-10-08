package com.google.android.material.internal;

import android.graphics.Matrix;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DescendantOffsetUtils {
    public static final ThreadLocal matrix = new ThreadLocal();
    public static final ThreadLocal rectF = new ThreadLocal();

    public static void offsetDescendantMatrix(TextInputLayout textInputLayout, View view, Matrix matrix2) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != textInputLayout) {
            View view2 = (View) parent;
            offsetDescendantMatrix(textInputLayout, view2, matrix2);
            matrix2.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix2.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix2.preConcat(view.getMatrix());
    }
}
