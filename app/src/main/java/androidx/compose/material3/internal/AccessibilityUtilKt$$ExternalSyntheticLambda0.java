package androidx.compose.material3.internal;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessibilityUtilKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ int $r8$classId;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.$r8$classId) {
            case 0:
                MeasureScope measureScope = (MeasureScope) obj;
                int iMo83roundToPx0680j_4 = measureScope.mo83roundToPx0680j_4(AccessibilityUtilKt.HorizontalSemanticsBoundsPadding);
                long j = ((Constraints) obj3).value;
                int i = iMo83roundToPx0680j_4 * 2;
                Placeable placeableMo515measureBRTryo0 = ((Measurable) obj2).mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(i, 0, j));
                return measureScope.layout(placeableMo515measureBRTryo0.width - i, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new SnapshotStateList$$ExternalSyntheticLambda1(iMo83roundToPx0680j_4, 1, placeableMo515measureBRTryo0));
            case 1:
                ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
                GapComposer gapComposer = (GapComposer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= gapComposer.changed(contextMenuColors) ? 4 : 2;
                }
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    BoxKt.Box(ImageKt.m44backgroundbw27NRU(SizeKt.m132height3ABfNKs(SizeKt.fillMaxWidth(OffsetKt.m127paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 0.0f, ContextMenuSpec.DividerVerticalPadding, 1), 1.0f), ContextMenuSpec.DividerHeight), contextMenuColors.iconColor, BrushKt.RectangleShape), gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 2:
                GapComposer gapComposer2 = (GapComposer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            default:
                MeasureScope measureScope2 = (MeasureScope) obj;
                int iMo83roundToPx0680j_5 = measureScope2.mo83roundToPx0680j_4(AccessibilityUtilKt.VerticalSemanticsBoundsPadding);
                long j2 = ((Constraints) obj3).value;
                int i2 = iMo83roundToPx0680j_5 * 2;
                Placeable placeableMo515measureBRTryo1 = ((Measurable) obj2).mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(0, i2, j2));
                return measureScope2.layout(placeableMo515measureBRTryo1.width, placeableMo515measureBRTryo1.height - i2, EmptyMap.INSTANCE, new SnapshotStateList$$ExternalSyntheticLambda1(iMo83roundToPx0680j_5, 2, placeableMo515measureBRTryo1));
        }
    }
}
