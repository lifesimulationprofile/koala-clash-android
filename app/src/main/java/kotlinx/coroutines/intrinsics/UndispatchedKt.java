package kotlinx.coroutines.intrinsics;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UndispatchedKt {
    public static ImageVector _close;

    public static final ImageVector getClose() {
        ImageVector imageVector = _close;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Close", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(19.0f, 6.41f);
        builder2.lineTo(17.59f, 5.0f);
        builder2.lineTo(12.0f, 10.59f);
        builder2.lineTo(6.41f, 5.0f);
        builder2.lineTo(5.0f, 6.41f);
        builder2.lineTo(10.59f, 12.0f);
        builder2.lineTo(5.0f, 17.59f);
        builder2.lineTo(6.41f, 19.0f);
        builder2.lineTo(12.0f, 13.41f);
        builder2.lineTo(17.59f, 19.0f);
        builder2.lineTo(19.0f, 17.59f);
        builder2.lineTo(13.41f, 12.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _close = imageVectorBuild;
        return imageVectorBuild;
    }

    public static final Object startUndispatchedOrReturn(ScopeCoroutine scopeCoroutine, ScopeCoroutine scopeCoroutine2, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            completedExceptionally = function2.invoke(scopeCoroutine2, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == JobKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        scopeCoroutine.afterCompletionUndispatched();
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return JobKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
    }
}
