package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectableKt {
    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m152selectableO2vRcR0(final boolean z, final RippleNodeFactory rippleNodeFactory, final boolean z2, final Role role, final Function0 function0) {
        if (rippleNodeFactory != null) {
            return new SelectableElement(z, null, rippleNodeFactory, z2, role, function0);
        }
        return rippleNodeFactory == null ? new SelectableElement(z, null, null, z2, role, function0) : new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                GapComposer gapComposer = (GapComposer) obj2;
                ((Number) obj3).intValue();
                gapComposer.startReplaceGroup(-1525724089);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                Modifier modifierThen = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl, rippleNodeFactory).then(new SelectableElement(z, mutableInteractionSourceImpl, null, z2, role, function0));
                gapComposer.end(false);
                return modifierThen;
            }
        });
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m153toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z2, Role role, Function1 function1) {
        return modifier.then(new ToggleableElement(z, mutableInteractionSourceImpl, z2, role, function1));
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m154triStateToggleableO2vRcR0(final ToggleableState toggleableState, final RippleNodeFactory rippleNodeFactory, final boolean z, final Role role, final Function0 function0) {
        if (rippleNodeFactory != null) {
            return new TriStateToggleableElement(toggleableState, null, rippleNodeFactory, z, role, function0);
        }
        return rippleNodeFactory == null ? new TriStateToggleableElement(toggleableState, null, null, z, role, function0) : new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                GapComposer gapComposer = (GapComposer) obj2;
                ((Number) obj3).intValue();
                gapComposer.startReplaceGroup(-1525724089);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                Modifier modifierThen = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl, rippleNodeFactory).then(new TriStateToggleableElement(toggleableState, mutableInteractionSourceImpl, null, z, role, function0));
                gapComposer.end(false);
                return modifierThen;
            }
        });
    }
}
