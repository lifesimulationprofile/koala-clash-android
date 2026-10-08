package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsModifierKt {
    public static final AtomicInteger lastIdentifier = new AtomicInteger(0);

    public static final Modifier semantics(Modifier modifier, boolean z, Function1 function1) {
        return modifier.then(new AppendedSemanticsElement(function1, z));
    }
}
