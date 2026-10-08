package kotlin.io;

import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import coil.ImageLoader$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ByteStreamsKt {
    /* JADX WARN: Code duplicated, block: B:172:0x0297  */
    public static final void LazyList(int i, int i2, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Arrangement.Vertical vertical, PaddingValuesImpl paddingValuesImpl, LazyListState lazyListState, GapComposer gapComposer, Alignment.Horizontal horizontal, Modifier modifier, Function1 function1, boolean z, boolean z2) {
        int i3;
        int i4;
        LazyListState lazyListState2;
        boolean z3;
        Object lazyListKt$rememberLazyListMeasurePolicy$1$1;
        int i5;
        boolean z4;
        LazyListState lazyListState3;
        KProperty0 kProperty0;
        Modifier modifierLazyLayoutBeyondBoundsModifier;
        boolean z5 = z;
        gapComposer.startRestartGroup(924924659);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(lazyListState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(paddingValuesImpl) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changed(z5) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(true) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= gapComposer.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changed(z2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changed(androidEdgeEffectOverscrollEffect) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(horizontal) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(vertical) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i6 = i4 | 432;
        if ((i2 & 3072) == 0) {
            i6 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, ((306783379 & i3) == 306783378 && (i6 & 1171) == 1170) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            int i7 = i3 & (-234881025);
            gapComposer.endDefaults();
            int i8 = i7 >> 3;
            int i9 = i8 & 14;
            int i10 = ((i6 >> 6) & 112) | i9;
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer);
            int i11 = i6;
            boolean z6 = (((i10 & 14) ^ 6) > 4 && gapComposer.changed(lazyListState)) || (i10 & 6) == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z6 || objRememberedValue == neverEqualPolicy) {
                LazyItemScopeImpl lazyItemScopeImpl = new LazyItemScopeImpl();
                lazyItemScopeImpl.maxWidthState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                lazyItemScopeImpl.maxHeightState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
                NeverEqualPolicy neverEqualPolicy2 = NeverEqualPolicy.INSTANCE$1;
                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda0 = new TooltipKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 1);
                ImageLoader$Builder imageLoader$Builder = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                objRememberedValue = new LockFreeLinkedListNode.AnonymousClass1(0, 1, State.class, new DerivedSnapshotState(new GapComposer$$ExternalSyntheticLambda0(new DerivedSnapshotState(tooltipKt$$ExternalSyntheticLambda0, neverEqualPolicy2), lazyListState, lazyItemScopeImpl, 2), neverEqualPolicy2), "value", "getValue()Ljava/lang/Object;");
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            KProperty0 kProperty1 = (KProperty0) objRememberedValue;
            int i12 = i7 >> 9;
            int i13 = i9 | (i12 & 112);
            boolean z7 = ((((i13 & 112) ^ 48) > 32 && gapComposer.changed(true)) || (i13 & 48) == 32) | ((((i13 & 14) ^ 6) > 4 && gapComposer.changed(lazyListState)) || (i13 & 6) == 4);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z7 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(lazyListState);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 = (LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            GraphicsContext graphicsContext = (GraphicsContext) gapComposer.consume(CompositionLocalsKt.LocalGraphicsContext);
            DummyHandle dummyHandle = !((Boolean) gapComposer.consume(CompositionLocalsKt.LocalProvidableScrollCaptureInProgress)).booleanValue() ? StickyItemsPlacement$Companion.StickToTopPlacement : null;
            int i14 = i11 << 18;
            int i15 = (i7 & 65520) | (i12 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | ((i11 << 27) & 1879048192);
            boolean z8 = ((((i15 & 112) ^ 48) > 32 && gapComposer.changed(lazyListState)) || (i15 & 48) == 32) | ((((i15 & 896) ^ 384) > 256 && gapComposer.changed(paddingValuesImpl)) || (i15 & 384) == 256) | ((((i15 & 7168) ^ 3072) > 2048 && gapComposer.changed(z5)) || (i15 & 3072) == 2048);
            if (((57344 & i15) ^ 24576) > 16384 && gapComposer.changed(true)) {
                z3 = true;
            } else if ((i15 & 24576) == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean zChanged = (((i15 & 234881024) ^ 100663296) > 67108864 && gapComposer.changed((Object) null)) | z8 | z3 | gapComposer.changed(0) | ((((i15 & 3670016) ^ 1572864) > 1048576 && gapComposer.changed(horizontal)) || (i15 & 1572864) == 1048576) | (((i15 & 29360128) ^ 12582912) > 8388608 && gapComposer.changed((Object) null)) | ((((i15 & 1879048192) ^ 805306368) > 536870912 && gapComposer.changed(vertical)) || (i15 & 805306368) == 536870912) | gapComposer.changed(graphicsContext) | gapComposer.changed(dummyHandle);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                i5 = 4;
                z4 = true;
                lazyListKt$rememberLazyListMeasurePolicy$1$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, paddingValuesImpl, z5, kProperty1, vertical, coroutineScope, graphicsContext, dummyHandle, horizontal);
                lazyListState3 = lazyListState;
                kProperty0 = kProperty1;
                z5 = z5;
                gapComposer.updateRememberedValue(lazyListKt$rememberLazyListMeasurePolicy$1$1);
            } else {
                lazyListState3 = lazyListState;
                lazyListKt$rememberLazyListMeasurePolicy$1$1 = objRememberedValue4;
                kProperty0 = kProperty1;
                i5 = 4;
                z4 = true;
            }
            LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$2 = (LazyListKt$rememberLazyListMeasurePolicy$1$1) lazyListKt$rememberLazyListMeasurePolicy$1$1;
            Orientation orientation = Orientation.Vertical;
            if (z2) {
                gapComposer.startReplaceGroup(-2077147368);
                boolean zChanged2 = (((((i8 & 14) ^ 6) <= i5 || !gapComposer.changed(lazyListState3)) && (i8 & 6) != i5) ? false : z4) | gapComposer.changed(0);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new LazyListBeyondBoundsState(lazyListState3);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                modifierLazyLayoutBeyondBoundsModifier = LazyLayoutKt.lazyLayoutBeyondBoundsModifier((LazyListBeyondBoundsState) objRememberedValue5, lazyListState3.beyondBoundsInfo, z5, orientation);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2076718545);
                gapComposer.end(false);
                modifierLazyLayoutBeyondBoundsModifier = Modifier.Companion.$$INSTANCE;
            }
            KProperty0 kProperty2 = kProperty0;
            LazyListState lazyListState4 = lazyListState3;
            Modifier modifierScrollableArea$default = ImageKt.scrollableArea$default(LazyLayoutKt.lazyLayoutSemantics(modifier.then(lazyListState3.remeasurementModifier).then(lazyListState3.awaitLayoutModifier), kProperty0, lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1, orientation, z2, z5).then(modifierLazyLayoutBeyondBoundsModifier).then(lazyListState3.itemAnimator.modifier), lazyListState4, orientation, androidEdgeEffectOverscrollEffect, z2, z, flingBehavior, lazyListState3.internalInteractionSource);
            lazyListState2 = lazyListState4;
            LazyLayoutKt.LazyLayout(kProperty2, modifierScrollableArea$default, lazyListState2.prefetchState, lazyListKt$rememberLazyListMeasurePolicy$1$2, gapComposer, 0);
        } else {
            lazyListState2 = lazyListState;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LazyDslKt$$ExternalSyntheticLambda0(modifier, lazyListState2, paddingValuesImpl, z, flingBehavior, z2, androidEdgeEffectOverscrollEffect, horizontal, vertical, function1, i, i2);
        }
    }

    public static long copyTo$default(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = inputStream.read(bArr);
        long j = 0;
        while (i >= 0) {
            outputStream.write(bArr, 0, i);
            j += (long) i;
            i = inputStream.read(bArr);
        }
        return j;
    }
}
