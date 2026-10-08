package androidx.compose.ui.input.pointer;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StylusHoverIconModifierElement extends ModifierNodeElement {
    public final DpTouchBoundsExpansion touchBoundsExpansion;

    public StylusHoverIconModifierElement(DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.touchBoundsExpansion = dpTouchBoundsExpansion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new StylusHoverIconModifierNode(BasicTextKt.handwritingPointerIcon, this.touchBoundsExpansion);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusHoverIconModifierElement)) {
            return false;
        }
        StylusHoverIconModifierElement stylusHoverIconModifierElement = (StylusHoverIconModifierElement) obj;
        AndroidPointerIconType androidPointerIconType = BasicTextKt.handwritingPointerIcon;
        return androidPointerIconType.equals(androidPointerIconType) && Intrinsics.areEqual(this.touchBoundsExpansion, stylusHoverIconModifierElement.touchBoundsExpansion);
    }

    public final int hashCode() {
        int i = ((1022 * 31) + 1237) * 31;
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.touchBoundsExpansion;
        return i + (dpTouchBoundsExpansion == null ? 0 : dpTouchBoundsExpansion.hashCode());
    }

    public final String toString() {
        return "StylusHoverIconModifierElement(icon=" + BasicTextKt.handwritingPointerIcon + ", overrideDescendants=false, touchBoundsExpansion=" + this.touchBoundsExpansion + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        StylusHoverIconModifierNode stylusHoverIconModifierNode = (StylusHoverIconModifierNode) node;
        AndroidPointerIconType androidPointerIconType = BasicTextKt.handwritingPointerIcon;
        if (!Intrinsics.areEqual(stylusHoverIconModifierNode.icon, androidPointerIconType)) {
            stylusHoverIconModifierNode.icon = androidPointerIconType;
            if (stylusHoverIconModifierNode.cursorInBoundsOfNode) {
                stylusHoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority();
            }
        }
        stylusHoverIconModifierNode.dpTouchBoundsExpansion = this.touchBoundsExpansion;
    }
}
