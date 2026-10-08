package kotlinx.coroutines.channels;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProduceKt$awaitClose$4$1 implements Function1 {
    public final /* synthetic */ Object $cont;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ProduceKt$awaitClose$4$1(int i, Object obj) {
        this.$r8$classId = i;
        this.$cont = obj;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004d  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        boolean z2;
        switch (this.$r8$classId) {
            case 0:
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.$cont;
                Unit unit = Unit.INSTANCE;
                cancellableContinuationImpl.resumeWith(unit);
                return unit;
            case 1:
                float[] fArr = ((Matrix) obj).values;
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.$cont;
                if (layoutCoordinates.isAttached()) {
                    RulerKt.findRootCoordinates(layoutCoordinates).mo527transformFromEL8BTi8(layoutCoordinates, fArr);
                }
                return Unit.INSTANCE;
            case 2:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                SelectionManager selectionManager = (SelectionManager) this.$cont;
                if (BasicTextKt.platformDefaultKeyMapping.m169mapZmokQxo(keyEvent) == 18) {
                    selectionManager.copy$foundation();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                ((CancellationHandle) this.$cont).cancel();
                return Unit.INSTANCE;
            case 4:
                KeyEvent keyEvent2 = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                if (Key.m502equalsimpl0(Key_androidKt.Key(keyEvent2.getKeyCode()), Key.Back)) {
                    z2 = true;
                    if (Key_androidKt.m504getTypeZmokQxo(keyEvent2) == 1) {
                        ((Function0) this.$cont).invoke();
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            case 5:
                Modifier.CC.m309drawImagegbVJVH8$default((DrawScope) obj, new AndroidImageBitmap((Bitmap) this.$cont), 0L, 0.0f, null, 0, 62);
                return Unit.INSTANCE;
            default:
                GraphicsLayerKt.drawLayer((DrawScope) obj, (GraphicsLayer) this.$cont);
                return Unit.INSTANCE;
        }
    }
}
