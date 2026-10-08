package androidx.activity.compose;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BackHandlerKt {
    public static volatile Handler sHandler;

    public static final void BackHandler(boolean z, Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-361453782);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
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
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged = gapComposer.changed(obj3) | gapComposer.changed(j);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj4 = objRememberedValue2;
            if (zChanged || objRememberedValue2 == obj2) {
                ComposeBackHandler composeBackHandler = new ComposeBackHandler(new BackHandlerInfo(j, obj));
                composeBackHandler.currentOnBackCompleted = new ImmLeaksCleaner$$ExternalSyntheticLambda0(2);
                gapComposer.updateRememberedValue(composeBackHandler);
                obj4 = composeBackHandler;
            }
            ComposeBackHandler composeBackHandler2 = (ComposeBackHandler) obj4;
            gapComposer.startReplaceGroup(-585289004);
            boolean zChangedInstance = gapComposer.changedInstance(composeBackHandler2) | ((i2 & 112) == 32);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj2) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(1, composeBackHandler2, function0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
            int i3 = i2;
            Boolean boolValueOf = Boolean.valueOf(z);
            int i4 = i3 & 14;
            boolean zChangedInstance2 = gapComposer.changedInstance(composeBackHandler2) | (i4 == 4);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj2) {
                objRememberedValue4 = new BackHandlerKt$$ExternalSyntheticLambda1(composeBackHandler2, z, 0);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LifecycleEffectKt.LifecycleStartEffect(boolValueOf, composeBackHandler2, null, (Function1) objRememberedValue4, gapComposer, i4);
            boolean zChangedInstance3 = gapComposer.changedInstance(obj3) | gapComposer.changedInstance(composeBackHandler2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new BackHandlerKt$$ExternalSyntheticLambda2(0, obj3, composeBackHandler2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.DisposableEffect(obj3, composeBackHandler2, (Function1) objRememberedValue5, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(i, 0, function0, z);
        }
    }

    public static int compositeARGBWithAlpha(int i, int i2) {
        return ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i2) / 255);
    }

    public static int getColor(View view, int i) {
        return PredictiveBackHandlerKt.resolveOrThrow(i, view.getContext(), view.getClass().getCanonicalName());
    }

    public static Handler getInstance() {
        if (sHandler != null) {
            return sHandler;
        }
        synchronized (BackHandlerKt.class) {
            try {
                if (sHandler == null) {
                    sHandler = HandlerCompat.createAsync(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sHandler;
    }

    public static boolean isColorLight(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = ColorUtils.TEMP_ARRAY;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) iRed) / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = ((double) iGreen) / 255.0d;
        double dPow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) iBlue) / 255.0d;
        double dPow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d4 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d4;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d4 / 100.0d > 0.5d;
    }

    public static int layer(float f, int i, int i2) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static int getColor(Context context, int i, int i2) {
        TypedValue typedValueResolve = PredictiveBackHandlerKt.resolve(context, i);
        return typedValueResolve != null ? typedValueResolve.data : i2;
    }
}
