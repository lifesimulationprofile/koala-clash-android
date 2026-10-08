package androidx.compose.material3;

import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.NavOptions;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScaffoldKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Function f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Function f$7;

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda8(int i, List list, Function1 function1, Modifier modifier, HazeState hazeState, List list2, Function0 function0, Function0 function2, int i2) {
        this.f$4 = i;
        this.f$0 = list;
        this.f$1 = function1;
        this.f$2 = modifier;
        this.f$3 = hazeState;
        this.f$5 = list2;
        this.f$7 = function0;
        this.f$6 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int iMo83roundToPx0680j_4;
        int iMo83roundToPx0680j_5;
        int i;
        final NavOptions.Builder builder;
        Integer numValueOf;
        int iIntValue;
        int iMo83roundToPx0680j_6;
        int bottom;
        switch (this.$r8$classId) {
            case 0:
                final WindowInsets windowInsets = (WindowInsets) this.f$0;
                Function2 function2 = (Function2) this.f$1;
                Function2 function3 = (Function2) this.f$2;
                Function2 function4 = (Function2) this.f$3;
                Function2 function5 = (Function2) this.f$5;
                ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) this.f$6;
                Function2 function6 = (Function2) this.f$7;
                final SubcomposeMeasureScope subcomposeMeasureScope = (SubcomposeMeasureScope) obj;
                Constraints constraints = (Constraints) obj2;
                float f = ScaffoldKt.FabSpacing;
                final int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(constraints.value);
                final int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(constraints.value);
                long jM674copyZbe2FdA$default = Constraints.m674copyZbe2FdA$default(constraints.value, 0, 0, 0, 0, 10);
                int left = windowInsets.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection());
                int right = windowInsets.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection());
                int bottom2 = windowInsets.getBottom(subcomposeMeasureScope);
                final Placeable placeableMo515measureBRTryo0 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2))).mo515measureBRTryo0(jM674copyZbe2FdA$default);
                int i2 = (-left) - right;
                int i3 = -bottom2;
                final Placeable placeableMo515measureBRTryo1 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function3))).mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(i2, i3, jM674copyZbe2FdA$default));
                final Placeable placeableMo515measureBRTryo2 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function4))).mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(i2, i3, jM674copyZbe2FdA$default));
                int i4 = placeableMo515measureBRTryo2.width;
                int i5 = this.f$4;
                if (i4 == 0 && placeableMo515measureBRTryo2.height == 0) {
                    builder = null;
                } else {
                    int i6 = placeableMo515measureBRTryo2.height;
                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                    if (i5 == 0) {
                        if (subcomposeMeasureScope.getLayoutDirection() == layoutDirection) {
                            iMo83roundToPx0680j_4 = subcomposeMeasureScope.mo83roundToPx0680j_4(f);
                            i = iMo83roundToPx0680j_4 + left;
                        } else {
                            iMo83roundToPx0680j_5 = subcomposeMeasureScope.mo83roundToPx0680j_4(f);
                            i = ((iM681getMaxWidthimpl - iMo83roundToPx0680j_5) - i4) - right;
                        }
                    } else if (i5 != 2 && i5 != 3) {
                        i = (((iM681getMaxWidthimpl - i4) + left) - right) / 2;
                    } else if (subcomposeMeasureScope.getLayoutDirection() == layoutDirection) {
                        iMo83roundToPx0680j_5 = subcomposeMeasureScope.mo83roundToPx0680j_4(f);
                        i = ((iM681getMaxWidthimpl - iMo83roundToPx0680j_5) - i4) - right;
                    } else {
                        iMo83roundToPx0680j_4 = subcomposeMeasureScope.mo83roundToPx0680j_4(f);
                        i = iMo83roundToPx0680j_4 + left;
                    }
                    builder = new NavOptions.Builder(i, i6);
                }
                final Placeable placeableMo515measureBRTryo3 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, function5))).mo515measureBRTryo0(jM674copyZbe2FdA$default);
                int i7 = 0;
                boolean z = placeableMo515measureBRTryo3.width == 0 && placeableMo515measureBRTryo3.height == 0;
                if (builder != null) {
                    int i8 = builder.exitAnim;
                    if (z || i5 == 3) {
                        iMo83roundToPx0680j_6 = subcomposeMeasureScope.mo83roundToPx0680j_4(f) + i8;
                        bottom = windowInsets.getBottom(subcomposeMeasureScope);
                    } else {
                        iMo83roundToPx0680j_6 = placeableMo515measureBRTryo3.height + i8;
                        bottom = subcomposeMeasureScope.mo83roundToPx0680j_4(f);
                    }
                    numValueOf = Integer.valueOf(bottom + iMo83roundToPx0680j_6);
                } else {
                    numValueOf = null;
                }
                int i9 = placeableMo515measureBRTryo1.height;
                if (i9 != 0) {
                    if (numValueOf != null) {
                        iIntValue = numValueOf.intValue();
                    } else {
                        Integer numValueOf2 = !z ? Integer.valueOf(placeableMo515measureBRTryo3.height) : null;
                        iIntValue = numValueOf2 != null ? numValueOf2.intValue() : windowInsets.getBottom(subcomposeMeasureScope);
                    }
                    i7 = iIntValue + i9;
                }
                final int i10 = i7;
                InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets, subcomposeMeasureScope);
                scaffoldKt$ScaffoldLayout$contentPadding$1$1.paddingHolder$delegate.setValue(new PaddingValuesImpl(OffsetKt.calculateStartPadding(insetsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), (placeableMo515measureBRTryo0.width == 0 && placeableMo515measureBRTryo0.height == 0) ? insetsPaddingValues.mo117calculateTopPaddingD9Ej5fM() : subcomposeMeasureScope.mo86toDpu2uoSUM(placeableMo515measureBRTryo0.height), OffsetKt.calculateEndPadding(insetsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), z ? insetsPaddingValues.mo114calculateBottomPaddingD9Ej5fM() : subcomposeMeasureScope.mo86toDpu2uoSUM(placeableMo515measureBRTryo3.height)));
                final Placeable placeableMo515measureBRTryo4 = ((Measurable) CollectionsKt.first(subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, function6))).mo515measureBRTryo0(jM674copyZbe2FdA$default);
                final Integer num = numValueOf;
                return subcomposeMeasureScope.layout(iM681getMaxWidthimpl, iM680getMaxHeightimpl, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj3;
                        Placeable.PlacementScope.place$default(placementScope, placeableMo515measureBRTryo4, 0, 0);
                        Placeable.PlacementScope.place$default(placementScope, placeableMo515measureBRTryo0, 0, 0);
                        Placeable placeable = placeableMo515measureBRTryo1;
                        int i11 = iM681getMaxWidthimpl - placeable.width;
                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                        LayoutDirection layoutDirection2 = subcomposeMeasureScope2.getLayoutDirection();
                        WindowInsets windowInsets2 = windowInsets;
                        int left2 = ((windowInsets2.getLeft(subcomposeMeasureScope2, layoutDirection2) + i11) - windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection())) / 2;
                        int i12 = iM680getMaxHeightimpl;
                        Placeable.PlacementScope.place$default(placementScope, placeable, left2, i12 - i10);
                        Placeable placeable2 = placeableMo515measureBRTryo3;
                        Placeable.PlacementScope.place$default(placementScope, placeable2, 0, i12 - placeable2.height);
                        NavOptions.Builder builder2 = builder;
                        if (builder2 != null) {
                            Placeable.PlacementScope.place$default(placementScope, placeableMo515measureBRTryo2, builder2.enterAnim, i12 - num.intValue());
                        }
                        return Unit.INSTANCE;
                    }
                });
            default:
                ((Integer) obj2).getClass();
                TvGlassTabRowKt.TvGlassTabRow(this.f$4, (List) this.f$0, (Function1) this.f$1, (Modifier) this.f$2, (HazeState) this.f$3, (List) this.f$5, (Function0) this.f$7, (Function0) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(12586369));
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda8(WindowInsets windowInsets, Function2 function2, Function2 function3, Function2 function4, int i, Function2 function5, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, Function2 function6) {
        this.f$0 = windowInsets;
        this.f$1 = function2;
        this.f$2 = function3;
        this.f$3 = function4;
        this.f$4 = i;
        this.f$5 = function5;
        this.f$6 = scaffoldKt$ScaffoldLayout$contentPadding$1$1;
        this.f$7 = function6;
    }
}
