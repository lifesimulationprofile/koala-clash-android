package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Key_androidKt {
    public static final long Key(int i) {
        long j = (((long) i) << 32) | (((long) 0) & 4294967295L);
        int i2 = Key.$r8$clinit;
        return j;
    }

    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m503getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        return Key(keyEvent.getKeyCode());
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m504getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? 0 : 1;
        }
        return 2;
    }

    public static final Modifier onKeyEvent(Modifier modifier, Function1 function1) {
        return modifier.then(new KeyInputElement(function1, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, Function1 function1) {
        return modifier.then(new KeyInputElement(null, function1));
    }
}
