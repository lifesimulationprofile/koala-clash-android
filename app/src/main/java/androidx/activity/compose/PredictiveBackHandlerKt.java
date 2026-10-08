package androidx.activity.compose;

import android.content.Context;
import android.util.TypedValue;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda6;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PredictiveBackHandlerKt {
    public static volatile HandlerScheduledExecutorService sInstance;

    public static final void PredictiveBackHandler(boolean z, Function2 function2, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-642000585);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.getCurrent(gapComposer);
            OnBackPressedDispatcherOwner current2 = LocalOnBackPressedDispatcherOwner.getCurrent(gapComposer);
            Object obj = current == null ? current2 : current;
            if (obj == null) {
                throw new IllegalArgumentException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = new BackHandlerDispatcherCompat(current != null ? current.getNavigationEventDispatcher() : null, current2 != null ? current2.getOnBackPressedDispatcher() : null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Object obj3 = (BackHandlerDispatcherCompat) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj2) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged = gapComposer.changed(obj3) | gapComposer.changed(j);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == obj2) {
                objRememberedValue3 = new ComposePredictiveBackHandler(coroutineScope, new PredictiveBackHandlerInfo(j, obj));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) objRememberedValue3;
            gapComposer.startReplaceGroup(-348495408);
            boolean zChangedInstance = gapComposer.changedInstance(composePredictiveBackHandler) | gapComposer.changedInstance(function2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == obj2) {
                objRememberedValue4 = new Recomposer$$ExternalSyntheticLambda6(2, composePredictiveBackHandler, function2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
            int i3 = i2;
            Boolean boolValueOf = Boolean.valueOf(z);
            int i4 = i3 & 14;
            boolean zChangedInstance2 = gapComposer.changedInstance(composePredictiveBackHandler) | (i4 == 4);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new BackHandlerKt$$ExternalSyntheticLambda1(composePredictiveBackHandler, z, 1);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            LifecycleEffectKt.LifecycleStartEffect(boolValueOf, composePredictiveBackHandler, null, (Function1) objRememberedValue5, gapComposer, i4);
            boolean zChangedInstance3 = gapComposer.changedInstance(obj3) | gapComposer.changedInstance(composePredictiveBackHandler);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == obj2) {
                objRememberedValue6 = new BackHandlerKt$$ExternalSyntheticLambda2(1, obj3, composePredictiveBackHandler);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.DisposableEffect(obj3, composePredictiveBackHandler, (Function1) objRememberedValue6, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda6(i, 1, function2, z);
        }
    }

    public static TypedValue resolve(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int resolveOrThrow(int i, Context context, String str) {
        TypedValue typedValueResolve = resolve(context, i);
        if (typedValueResolve != null) {
            return typedValueResolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }
}
