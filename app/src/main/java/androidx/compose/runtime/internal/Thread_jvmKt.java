package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Thread_jvmKt {
    public static final StackTraceElement[] EmptyStackTraceElements = new StackTraceElement[0];
    public static final ThreadMap emptyThreadMap = new ThreadMap(0, new long[0], new Object[0]);

    public static final int bitsForSlot(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static final ComposableLambdaImpl rememberComposableLambda(int i, Function function, GapComposer gapComposer) {
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new ComposableLambdaImpl(i, function, true);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) objRememberedValue;
        if (!Intrinsics.areEqual(composableLambdaImpl._block, function)) {
            boolean z = composableLambdaImpl._block == null;
            composableLambdaImpl._block = function;
            if (!z && composableLambdaImpl.tracked) {
                RecomposeScopeImpl recomposeScopeImpl = composableLambdaImpl.scope;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                    composableLambdaImpl.scope = null;
                }
                ArrayList arrayList = composableLambdaImpl.scopes;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RecomposeScopeImpl) arrayList.get(i2)).invalidate();
                    }
                    arrayList.clear();
                }
            }
        }
        return composableLambdaImpl;
    }

    public static final boolean replacableWith(RecomposeScopeImpl recomposeScopeImpl, RecomposeScopeImpl recomposeScopeImpl2) {
        if (recomposeScopeImpl == null) {
            return true;
        }
        if (recomposeScopeImpl instanceof RecomposeScopeImpl) {
            return !recomposeScopeImpl.getValid() || recomposeScopeImpl.equals(recomposeScopeImpl2) || Intrinsics.areEqual(recomposeScopeImpl.anchor, recomposeScopeImpl2.anchor);
        }
        return false;
    }
}
