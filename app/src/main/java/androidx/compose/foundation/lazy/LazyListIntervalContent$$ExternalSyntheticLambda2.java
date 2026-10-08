package androidx.compose.foundation.lazy;

import android.graphics.Typeface;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import com.caverock.androidsvg.SVG;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyListIntervalContent$$ExternalSyntheticLambda2 implements Function4 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LazyListIntervalContent$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e6  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        char c;
        SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0;
        long jM217convertToContainerCoordinatesR5De75A;
        switch (this.$r8$classId) {
            case 0:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$0;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                ((Integer) obj2).getClass();
                GapComposer gapComposer = (GapComposer) obj3;
                int iIntValue = ((Integer) obj4).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= gapComposer.changed(lazyItemScopeImpl) ? 4 : 2;
                }
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 131) != 130)) {
                    composableLambdaImpl.invoke(lazyItemScopeImpl, gapComposer, Integer.valueOf(iIntValue & 14));
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 1:
                SelectionManager selectionManager = (SelectionManager) this.f$0;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj2;
                SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda1 = (SelectionAdjustment$Companion$$ExternalSyntheticLambda0) obj4;
                long jMo520getSizeYbymL2g = layoutCoordinates.mo520getSizeYbymL2g();
                float fIntBitsToFloat = (int) (jMo520getSizeYbymL2g >> 32);
                float fIntBitsToFloat2 = (int) (jMo520getSizeYbymL2g & 4294967295L);
                long jFloatToRawIntBits = ((Offset) obj3).packedValue;
                int i = (int) (jFloatToRawIntBits >> 32);
                float fIntBitsToFloat3 = Float.intBitsToFloat(i);
                if (0.0f <= fIntBitsToFloat3 && fIntBitsToFloat3 <= fIntBitsToFloat) {
                    c = ' ';
                    selectionAdjustment$Companion$$ExternalSyntheticLambda0 = selectionAdjustment$Companion$$ExternalSyntheticLambda1;
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
                    if (0.0f > fIntBitsToFloat4 || fIntBitsToFloat4 > fIntBitsToFloat2) {
                    }
                    jM217convertToContainerCoordinatesR5De75A = selectionManager.m217convertToContainerCoordinatesR5De75A(layoutCoordinates, jFloatToRawIntBits);
                    if ((9223372034707292159L & jM217convertToContainerCoordinatesR5De75A) != 9205357640488583168L) {
                        selectionManager.setInTouchMode(zBooleanValue);
                        selectionManager.previousSelectionLayout = null;
                        selectionManager.m218updateSelectionjyLRC_s$foundation(jM217convertToContainerCoordinatesR5De75A, 9205357640488583168L, false, selectionAdjustment$Companion$$ExternalSyntheticLambda0);
                        FocusRequester.m348requestFocus3ESFkO8$default(selectionManager.focusRequester);
                        selectionManager.showToolbar = false;
                        selectionManager.updateSelectionToolbar();
                        selectionManager.isLongPressOrClickSelection = true;
                    }
                    return Unit.INSTANCE;
                }
                c = ' ';
                selectionAdjustment$Companion$$ExternalSyntheticLambda0 = selectionAdjustment$Companion$$ExternalSyntheticLambda1;
                if (Float.intBitsToFloat(i) < 0.0f) {
                    fIntBitsToFloat = 0.0f;
                } else if (Float.intBitsToFloat(i) <= fIntBitsToFloat) {
                    fIntBitsToFloat = Float.intBitsToFloat(i);
                }
                int i2 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i2) < 0.0f) {
                    fIntBitsToFloat2 = 0.0f;
                } else if (Float.intBitsToFloat(i2) <= fIntBitsToFloat2) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                }
                jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << c) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
                jM217convertToContainerCoordinatesR5De75A = selectionManager.m217convertToContainerCoordinatesR5De75A(layoutCoordinates, jFloatToRawIntBits);
                if ((9223372034707292159L & jM217convertToContainerCoordinatesR5De75A) != 9205357640488583168L) {
                    selectionManager.setInTouchMode(zBooleanValue);
                    selectionManager.previousSelectionLayout = null;
                    selectionManager.m218updateSelectionjyLRC_s$foundation(jM217convertToContainerCoordinatesR5De75A, 9205357640488583168L, false, selectionAdjustment$Companion$$ExternalSyntheticLambda0);
                    FocusRequester.m348requestFocus3ESFkO8$default(selectionManager.focusRequester);
                    selectionManager.showToolbar = false;
                    selectionManager.updateSelectionToolbar();
                    selectionManager.isLongPressOrClickSelection = true;
                }
                return Unit.INSTANCE;
            default:
                AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) this.f$0;
                TypefaceResult$Immutable typefaceResult$ImmutableM654resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m654resolveDPcqOEQ((SystemFontFamily) obj, (FontWeight) obj2, ((FontStyle) obj3).value, ((FontSynthesis) obj4).value);
                if (typefaceResult$ImmutableM654resolveDPcqOEQ instanceof TypefaceResult$Immutable) {
                    return (Typeface) typefaceResult$ImmutableM654resolveDPcqOEQ.value;
                }
                SVG svg = new SVG(typefaceResult$ImmutableM654resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                androidParagraphIntrinsics.resolvedTypefaces = svg;
                return (Typeface) svg.idToElementMap;
        }
    }
}
