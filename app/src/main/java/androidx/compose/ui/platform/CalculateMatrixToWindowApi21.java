package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    public final int[] tmpLocation;
    public final float[] tmpMatrix;

    public CalculateMatrixToWindowApi21(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.tmpLocation = new int[size];
        this.tmpMatrix = new float[size];
        for (int i = 0; i < size; i++) {
            this.tmpLocation[i] = ((Integer) arrayList.get(i)).intValue();
            this.tmpMatrix[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo601calculateMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Matrix.m443resetimpl(fArr);
        m602transformMatrixToWindowEL8BTi8(view, fArr);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    public void m602transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        boolean z = parent instanceof View;
        float[] fArr2 = this.tmpMatrix;
        if (z) {
            m602transformMatrixToWindowEL8BTi8((View) parent, fArr);
            float f = -view.getScrollX();
            float f2 = -view.getScrollY();
            Matrix.m443resetimpl(fArr2);
            Matrix.m445translateimpl(fArr2, f, f2);
            InvertMatrixKt.m611preTransformJiSxe2E(fArr, fArr2);
            float left = view.getLeft();
            float top = view.getTop();
            Matrix.m443resetimpl(fArr2);
            Matrix.m445translateimpl(fArr2, left, top);
            InvertMatrixKt.m611preTransformJiSxe2E(fArr, fArr2);
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            float f3 = -view.getScrollX();
            float f4 = -view.getScrollY();
            Matrix.m443resetimpl(fArr2);
            Matrix.m445translateimpl(fArr2, f3, f4);
            InvertMatrixKt.m611preTransformJiSxe2E(fArr, fArr2);
            float f5 = iArr[0];
            float f6 = iArr[1];
            Matrix.m443resetimpl(fArr2);
            Matrix.m445translateimpl(fArr2, f5, f6);
            InvertMatrixKt.m611preTransformJiSxe2E(fArr, fArr2);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        BrushKt.m421setFromtUYjHk(matrix, fArr2);
        InvertMatrixKt.m611preTransformJiSxe2E(fArr, fArr2);
    }

    public CalculateMatrixToWindowApi21(int i, int i2) {
        this.tmpLocation = new int[]{i, i2};
        this.tmpMatrix = new float[]{0.0f, 1.0f};
    }

    public CalculateMatrixToWindowApi21(int i, int i2, int i3) {
        this.tmpLocation = new int[]{i, i2, i3};
        this.tmpMatrix = new float[]{0.0f, 0.5f, 1.0f};
    }

    public CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }
}
