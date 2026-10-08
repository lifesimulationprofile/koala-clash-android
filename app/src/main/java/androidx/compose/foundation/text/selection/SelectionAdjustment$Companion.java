package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.ParagraphKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionAdjustment$Companion implements BoundaryFunction {
    public final /* synthetic */ int $r8$classId;
    public static final SelectionAdjustment$Companion INSTANCE = new SelectionAdjustment$Companion(1);
    public static final SelectionAdjustment$Companion INSTANCE$1 = new SelectionAdjustment$Companion(2);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 None = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(0);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 Word = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(1);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 Paragraph = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(2);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 CharacterWithWordAccelerate = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(3);

    public /* synthetic */ SelectionAdjustment$Companion(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.foundation.text.selection.BoundaryFunction
    /* JADX INFO: renamed from: getBoundary-fzxv0v0 */
    public long mo211getBoundaryfzxv0v0(SelectableInfo selectableInfo, int i) {
        switch (this.$r8$classId) {
            case 1:
                String str = selectableInfo.textLayoutResult.layoutInput.text.text;
                return ParagraphKt.TextRange(BasicTextKt.findParagraphStart(str, i), BasicTextKt.findParagraphEnd(str, i));
            default:
                return selectableInfo.textLayoutResult.m636getWordBoundaryjx7JFs(i);
        }
    }
}
