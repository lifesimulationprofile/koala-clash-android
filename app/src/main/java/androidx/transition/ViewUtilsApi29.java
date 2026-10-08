package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewUtilsApi29 extends ViewUtilsApi23 {
    @Override // androidx.transition.ViewUtilsApi19
    public final float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.ViewUtilsApi23
    public final void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // androidx.transition.ViewUtilsApi19
    public final void setTransitionAlpha(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsApi19
    public final void setTransitionVisibility(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // androidx.transition.ViewUtilsApi23
    public final void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi23
    public final void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
