package androidx.compose.foundation.lazy;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyDslKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ LazyListState f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ int f$11;
    public final /* synthetic */ PaddingValuesImpl f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Arrangement.Vertical f$4;
    public final /* synthetic */ Alignment.Horizontal f$5;
    public final /* synthetic */ FlingBehavior f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f$8;
    public final /* synthetic */ Function1 f$9;

    public /* synthetic */ LazyDslKt$$ExternalSyntheticLambda0(Modifier modifier, LazyListState lazyListState, PaddingValuesImpl paddingValuesImpl, boolean z, FlingBehavior flingBehavior, boolean z2, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Function1 function1, int i, int i2) {
        this.f$0 = modifier;
        this.f$1 = lazyListState;
        this.f$2 = paddingValuesImpl;
        this.f$3 = z;
        this.f$6 = flingBehavior;
        this.f$7 = z2;
        this.f$8 = androidEdgeEffectOverscrollEffect;
        this.f$5 = horizontal;
        this.f$4 = vertical;
        this.f$9 = function1;
        this.f$10 = i;
        this.f$11 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                ProgressionUtilKt.LazyColumn(Stack.updateChangedFlags(this.f$10 | 1), this.f$11, this.f$8, this.f$6, this.f$4, this.f$2, this.f$1, (GapComposer) obj, this.f$5, this.f$0, this.f$9, this.f$3, this.f$7);
                break;
            default:
                ((Integer) obj2).getClass();
                ByteStreamsKt.LazyList(Stack.updateChangedFlags(this.f$10 | 1), Stack.updateChangedFlags(this.f$11), this.f$8, this.f$6, this.f$4, this.f$2, this.f$1, (GapComposer) obj, this.f$5, this.f$0, this.f$9, this.f$3, this.f$7);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ LazyDslKt$$ExternalSyntheticLambda0(Modifier modifier, LazyListState lazyListState, PaddingValuesImpl paddingValuesImpl, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Function1 function1, int i, int i2) {
        this.f$0 = modifier;
        this.f$1 = lazyListState;
        this.f$2 = paddingValuesImpl;
        this.f$3 = z;
        this.f$4 = vertical;
        this.f$5 = horizontal;
        this.f$6 = flingBehavior;
        this.f$7 = z2;
        this.f$8 = androidEdgeEffectOverscrollEffect;
        this.f$9 = function1;
        this.f$10 = i;
        this.f$11 = i2;
    }
}
