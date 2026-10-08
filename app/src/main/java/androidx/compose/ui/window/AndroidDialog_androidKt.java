package androidx.compose.ui.window;

import android.view.View;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidDialog_androidKt {
    public static final void Dialog(Function0 function0, DialogProperties dialogProperties, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(826668973);
        int i2 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changed(dialogProperties) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            UUID uuid = (UUID) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer);
            dialogProperties.getClass();
            boolean zChanged = gapComposer.changed(2) | gapComposer.changed(view) | gapComposer.changed(density) | gapComposer.changed((Object) null);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == obj) {
                DialogWrapper dialogWrapper = new DialogWrapper(function0, dialogProperties, view, layoutDirection, density, uuid);
                ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(-1338939603, new PopupLayout$Content$4(6, mutableStateRememberUpdatedState), true);
                DialogLayout dialogLayout = dialogWrapper.dialogLayout;
                dialogLayout.setParentCompositionContext(compositionContextImplRememberCompositionContext);
                dialogLayout.content$delegate.setValue(composableLambdaImpl2);
                dialogLayout.shouldCreateCompositionOnAttachedToWindow = true;
                dialogLayout.createComposition();
                gapComposer.updateRememberedValue(dialogWrapper);
                objRememberedValue2 = dialogWrapper;
            }
            DialogWrapper dialogWrapper2 = (DialogWrapper) objRememberedValue2;
            boolean zChangedInstance = gapComposer.changedInstance(dialogWrapper2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj) {
                objRememberedValue3 = new DialogWrapper.AnonymousClass2(dialogWrapper2, 1);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(dialogWrapper2, (Function1) objRememberedValue3, gapComposer);
            boolean zChangedInstance2 = gapComposer.changedInstance(dialogWrapper2) | ((i2 & 14) == 4) | ((i2 & 112) == 32) | gapComposer.changed(layoutDirection.ordinal());
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj) {
                objRememberedValue4 = new AndroidDialog_androidKt$Dialog$2$1(dialogWrapper2, function0, dialogProperties, layoutDirection, 0);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt$NavHost$29$1.AnonymousClass1(function0, dialogProperties, composableLambdaImpl, i, 3);
        }
    }

    public static final void access$DialogLayout(Modifier modifier, Function2 function2, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1090521195);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) ((j >>> 32) ^ j);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            int i4 = (((((i2 << 3) & 112) | (((i2 >> 3) & 14) | 384)) << 6) & 896) | 6;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function2.invoke(gapComposer, Integer.valueOf((i4 >> 6) & 14));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidDialog_androidKt$DialogLayout$2(i, 0, modifier, function2);
        }
    }
}
