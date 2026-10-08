package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Magnifier_androidKt {
    public static final SemanticsPropertyKey MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot");

    public static boolean isPlatformMagnifierSupported$default() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static Modifier m53magnifierjPUL71Q$default(Function1 function1, Function1 function2, PlatformMagnifierFactory platformMagnifierFactory) {
        return isPlatformMagnifierSupported$default() ? new MagnifierElement(function1, function2, platformMagnifierFactory) : Modifier.Companion.$$INSTANCE;
    }
}
