package androidx.compose.material3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.view.PreviewView;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.TextFieldImplKt$DecoratedLabel$labelScope$1$1;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableGapRememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import com.google.android.gms.internal.mlkit_vision_common.zzjw;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.Request;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    private final Object invoke$androidx$compose$material3$ButtonKt$$ExternalSyntheticLambda4(Object obj, Object obj2) {
        PaddingValues paddingValues = (PaddingValues) this.f$0;
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            Modifier modifierPadding = OffsetKt.padding(SizeKt.m131defaultMinSizeVpY3zN4(Modifier.Companion.$$INSTANCE, ButtonDefaults.MinWidth, ButtonDefaults.MinHeight), paddingValues);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterVertically, gapComposer, 54);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierPadding);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) RowScopeInstance.INSTANCE, (Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$ScaffoldKt$$ExternalSyntheticLambda6(Object obj, Object obj2) {
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) this.f$0;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) scaffoldKt$ScaffoldLayout$contentPadding$1$1, (Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$TooltipKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        MutableState mutableState = (MutableState) this.f$0;
        Function2 function2 = (Function2) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnGloballyPositioned);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m294setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m294setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m293reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m294setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function2.invoke(gapComposer, 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$internal$TextFieldImplKt$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        Function3 function3 = (Function3) this.f$0;
        TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            function3.invoke(textFieldImplKt$DecoratedLabel$labelScope$1$1, gapComposer, 6);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$runtime$GapComposerKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        zzky zzkyVar = (zzky) this.f$0;
        SlotWriter slotWriter = (SlotWriter) this.f$1;
        int iIntValue = ((Integer) obj).intValue();
        if (obj2 instanceof ComposeNodeLifecycleCallback) {
            ((MutableVector) zzkyVar.zze).add((ComposeNodeLifecycleCallback) obj2);
        } else if (!(obj2 instanceof ReusableGapRememberObserverHolder)) {
            if (obj2 instanceof RememberObserverHolder) {
                Stack.removeData(slotWriter, iIntValue, obj2);
                zzkyVar.forgetting((RememberObserverHolder) obj2);
            } else if (obj2 instanceof RecomposeScopeImpl) {
                Stack.removeData(slotWriter, iIntValue, obj2);
                ((RecomposeScopeImpl) obj2).release();
            }
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$FilesActivity$$ExternalSyntheticLambda5(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        int i = FilesActivity.$r8$clinit;
        ((FilesActivity) this.f$0).Content((String) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$LogsScreenKt$$ExternalSyntheticLambda3(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        LogsScreenKt.LogFileRow((LogFile) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(9));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$$ExternalSyntheticLambda30(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        ConnectionsScreenKt.ProcessCard((ProcessGroup) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$5$2$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$1;
        Boolean bool = (Boolean) obj2;
        bool.booleanValue();
        JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
        mutableState.setValue((ConnectionInfo) obj);
        mutableState2.setValue(bool);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$profiles$ProfilesScreenKt$$ExternalSyntheticLambda5(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        zzjo.EmptyProfilesContent((Function0) this.f$0, (Modifier) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$proxy$ProxyScreenKt$$ExternalSyntheticLambda14(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        ProxyScreenKt.EmptyMessage((ImageVector) this.f$0, (String) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        zzjw.ProfileItem((Profile) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:299:0x0759 A[DONT_INVERT, LOOP:4: B:299:0x0759->B:303:0x0769, LOOP_START, PHI: r0 r1
      0x0759: PHI (r0v81 int) = (r0v45 int), (r0v82 int) binds: [B:298:0x0757, B:303:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0759: PHI (r1v123 java.util.List) = (r1v45 java.util.List), (r1v124 java.util.List) binds: [B:298:0x0757, B:303:0x0769] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:300:0x075b  */
    /* JADX WARN: Code duplicated, block: B:303:0x0769 A[LOOP:4: B:299:0x0759->B:303:0x0769, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:306:0x0774 A[LOOP:5: B:306:0x0774->B:313:0x0793, LOOP_START, PHI: r0 r1
      0x0774: PHI (r0v75 int) = (r0v47 int), (r0v79 int) binds: [B:305:0x0772, B:313:0x0793] A[DONT_GENERATE, DONT_INLINE]
      0x0774: PHI (r1v119 java.util.List) = (r1v46 java.util.List), (r1v120 java.util.List) binds: [B:305:0x0772, B:313:0x0793] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:308:0x0782 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:309:0x0784  */
    /* JADX WARN: Code duplicated, block: B:313:0x0793 A[LOOP:5: B:306:0x0774->B:313:0x0793, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:315:0x0797  */
    /* JADX WARN: Code duplicated, block: B:318:0x07a2 A[LOOP:6: B:317:0x07a0->B:318:0x07a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:321:0x07d3  */
    /* JADX WARN: Code duplicated, block: B:323:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:326:0x07eb A[LOOP:7: B:322:0x07d5->B:326:0x07eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:327:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:334:0x0815  */
    /* JADX WARN: Code duplicated, block: B:336:0x0823 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:337:0x0825  */
    /* JADX WARN: Code duplicated, block: B:341:0x0838  */
    /* JADX WARN: Code duplicated, block: B:344:0x0843 A[LOOP:9: B:343:0x0841->B:344:0x0843, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:352:0x086a  */
    /* JADX WARN: Code duplicated, block: B:355:0x0879  */
    /* JADX WARN: Code duplicated, block: B:356:0x087b  */
    /* JADX WARN: Code duplicated, block: B:363:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:368:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:371:0x08bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:372:0x08be  */
    /* JADX WARN: Code duplicated, block: B:373:0x08c0  */
    /* JADX WARN: Code duplicated, block: B:377:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:379:0x08de  */
    /* JADX WARN: Code duplicated, block: B:380:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:388:0x0916  */
    /* JADX WARN: Code duplicated, block: B:389:0x091a  */
    /* JADX WARN: Code duplicated, block: B:392:0x092c  */
    /* JADX WARN: Code duplicated, block: B:393:0x0934  */
    /* JADX WARN: Code duplicated, block: B:396:0x093e A[LOOP:11: B:386:0x0912->B:396:0x093e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:397:0x0945  */
    /* JADX WARN: Code duplicated, block: B:399:0x094e  */
    /* JADX WARN: Code duplicated, block: B:401:0x0959 A[LOOP:20: B:400:0x0957->B:401:0x0959, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:404:0x097e A[LOOP:21: B:403:0x097c->B:404:0x097e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:407:0x0997 A[LOOP:22: B:406:0x0995->B:407:0x0997, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:409:0x09ab  */
    /* JADX WARN: Code duplicated, block: B:411:0x09c9  */
    /* JADX WARN: Code duplicated, block: B:413:0x09d1  */
    /* JADX WARN: Code duplicated, block: B:415:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:417:0x09ec  */
    /* JADX WARN: Code duplicated, block: B:419:0x09f3 A[LOOP:12: B:418:0x09f1->B:419:0x09f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:423:0x0a07  */
    /* JADX WARN: Code duplicated, block: B:424:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:427:0x0a13  */
    /* JADX WARN: Code duplicated, block: B:428:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:499:0x0b5a  */
    /* JADX WARN: Code duplicated, block: B:501:0x0b62  */
    /* JADX WARN: Code duplicated, block: B:503:0x0b6a  */
    /* JADX WARN: Code duplicated, block: B:504:0x0b71  */
    /* JADX WARN: Code duplicated, block: B:505:0x0b74  */
    /* JADX WARN: Code duplicated, block: B:507:0x0b7c  */
    /* JADX WARN: Code duplicated, block: B:509:0x0b84  */
    /* JADX WARN: Code duplicated, block: B:511:0x0b8c  */
    /* JADX WARN: Code duplicated, block: B:514:0x0b97  */
    /* JADX WARN: Code duplicated, block: B:515:0x0b9c  */
    /* JADX WARN: Code duplicated, block: B:517:0x0ba4  */
    /* JADX WARN: Code duplicated, block: B:522:0x0bb3  */
    /* JADX WARN: Code duplicated, block: B:525:0x0bd4  */
    /* JADX WARN: Code duplicated, block: B:526:0x0bd9  */
    /* JADX WARN: Code duplicated, block: B:528:0x0bdc  */
    /* JADX WARN: Code duplicated, block: B:529:0x0be1  */
    /* JADX WARN: Code duplicated, block: B:533:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:535:0x0bf5  */
    /* JADX WARN: Code duplicated, block: B:601:0x076c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0795 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x07fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0831 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x09a9 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r56v1 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v43 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        long j;
        int i2;
        int i3;
        ?? arrayList;
        IntRange intRange;
        long j2;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        int i8;
        int iMax;
        int i9;
        List arrayList2;
        int size;
        int size2;
        int iMax2;
        int i10;
        int iMin;
        int i11;
        int i12;
        int i13;
        List arrayList3;
        int size3;
        int i14;
        ?? r6;
        int size4;
        int iMax3;
        int i15;
        boolean z;
        int iM690constrainWidthK40F9xA;
        int iM689constrainHeightK40F9xA;
        boolean z2;
        boolean z3;
        ArrayList arrayList4;
        int size5;
        int i16;
        int i17;
        int size6;
        int i18;
        int i19;
        int size7;
        int i20;
        ArrayList arrayList5;
        LazyLayoutItemAnimator lazyLayoutItemAnimator;
        LazyListItemProviderImpl lazyListItemProviderImpl;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i21;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int i22;
        ArrayDeque arrayDeque;
        int i23;
        List list;
        LazyListMeasuredItem lazyListMeasuredItem3;
        Integer numValueOf;
        LazyListMeasuredItem lazyListMeasuredItem4;
        Integer numValueOf2;
        boolean z4;
        SubcomposeMeasureScope subcomposeMeasureScope;
        int iIntValue;
        int iIntValue2;
        LazyListMeasureResult lazyListMeasureResult;
        int size8;
        int i24;
        int i25;
        LazyListMeasuredItem lazyListMeasuredItem5;
        LazyListMeasuredItem lazyListMeasuredItem6;
        int i26;
        MutableIntList mutableIntList;
        int i27;
        Object obj3;
        int i28;
        int iMax4;
        int i29;
        int i30;
        int iM689constrainHeightK40F9xA2;
        int size9;
        int i31;
        int size10;
        int[] iArr;
        int i32;
        int[] iArr2;
        int i33;
        IntProgression intProgression;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        LazyListMeasuredItem lazyListMeasuredItem7;
        int i39;
        int iIntValue3;
        List arrayList6;
        int i40;
        int iIntValue4;
        int i41 = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        TextRange textRange = null;
        int i42 = 0;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (i41) {
            case 0:
                ((Integer) obj2).getClass();
                TextKt.ProvideTextStyle((TextStyle) obj5, (ComposableLambdaImpl) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 1:
                ((Integer) obj2).getClass();
                ImageKt.Canvas((Modifier) obj5, (Function1) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 2:
                ((Integer) obj2).getClass();
                ((ContextMenuScope) obj5).Content$foundation((ContextMenuColors) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 3:
                float fFloatValue = ((Float) obj).floatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) obj5).dragTo(fFloatValue, ((Float) obj2).floatValue());
                ((Ref$FloatRef) obj4).element = fFloatValue;
                return Unit.INSTANCE;
            case 4:
                LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) obj5;
                LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = (LazyLayoutItemContentFactory.CachedItemContent) obj4;
                Object obj6 = cachedItemContent.key;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    LazyListItemProviderImpl lazyListItemProviderImpl2 = (LazyListItemProviderImpl) lazyLayoutItemContentFactory.itemProvider.invoke();
                    int index = cachedItemContent.index;
                    if (index >= lazyListItemProviderImpl2.getItemCount() || !lazyListItemProviderImpl2.getKey(index).equals(obj6)) {
                        index = lazyListItemProviderImpl2.keyIndexMap.getIndex(obj6);
                        i = -1;
                        if (index != -1) {
                            cachedItemContent.index = index;
                        }
                    } else {
                        i = -1;
                    }
                    int i43 = index;
                    if (i43 != i) {
                        gapComposer.startReplaceGroup(-1664741271);
                        LazyLayoutKt.m150SkippableItemJVlU9Rs(lazyListItemProviderImpl2, lazyLayoutItemContentFactory.saveableStateHolder, i43, obj6, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1664505826);
                        gapComposer.end(false);
                    }
                    boolean zChangedInstance = gapComposer.changedInstance(cachedItemContent);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Recomposer$$ExternalSyntheticLambda0(10, cachedItemContent);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Stack.DisposableEffect(obj6, (Function1) objRememberedValue, gapComposer);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 5:
                boolean zM717equalsimpl0 = IntSize.m717equalsimpl0(0L, 0L);
                LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$1 = (LazyListKt$rememberLazyListMeasurePolicy$1$1) obj4;
                SubcomposeMeasureScope subcomposeMeasureScope2 = (SubcomposeMeasureScope) obj;
                LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl = new LazyLayoutMeasureScopeImpl((LazyLayoutItemContentFactory) obj5, subcomposeMeasureScope2);
                long j3 = ((Constraints) obj2).value;
                lazyListKt$rememberLazyListMeasurePolicy$1$1.getClass();
                Arrangement.Vertical vertical = lazyListKt$rememberLazyListMeasurePolicy$1$1.$verticalArrangement;
                boolean z5 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                PaddingValuesImpl paddingValuesImpl = lazyListKt$rememberLazyListMeasurePolicy$1$1.$contentPadding;
                LazyListState lazyListState = lazyListKt$rememberLazyListMeasurePolicy$1$1.$state;
                lazyListState.measurementScopeInvalidator.getValue();
                boolean z6 = lazyListState.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                Orientation orientation = Orientation.Vertical;
                ImageKt.m46checkScrollableContainerConstraintsK40F9xA(j3, orientation);
                int iMo83roundToPx0680j_4 = subcomposeMeasureScope2.mo83roundToPx0680j_4(paddingValuesImpl.mo115calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection()));
                int iMo83roundToPx0680j_5 = subcomposeMeasureScope2.mo83roundToPx0680j_4(paddingValuesImpl.mo116calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection()));
                int iMo83roundToPx0680j_6 = subcomposeMeasureScope2.mo83roundToPx0680j_4(paddingValuesImpl.top);
                int iMo83roundToPx0680j_7 = subcomposeMeasureScope2.mo83roundToPx0680j_4(paddingValuesImpl.bottom);
                int i44 = iMo83roundToPx0680j_6 + iMo83roundToPx0680j_7;
                int i45 = iMo83roundToPx0680j_4 + iMo83roundToPx0680j_5;
                int i46 = z5 ? z5 ? iMo83roundToPx0680j_7 : iMo83roundToPx0680j_5 : iMo83roundToPx0680j_6;
                int i47 = i44 - i46;
                long jM691offsetNN6EwU = ConstraintsKt.m691offsetNN6EwU(-i45, -i44, j3);
                LazyListItemProviderImpl lazyListItemProviderImpl3 = (LazyListItemProviderImpl) lazyListKt$rememberLazyListMeasurePolicy$1$1.$itemProviderLambda.invoke();
                LazyItemScopeImpl lazyItemScopeImpl = lazyListItemProviderImpl3.itemScope;
                int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(jM691offsetNN6EwU);
                int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(jM691offsetNN6EwU);
                lazyItemScopeImpl.maxWidthState.setIntValue(iM681getMaxWidthimpl);
                lazyItemScopeImpl.maxHeightState.setIntValue(iM680getMaxHeightimpl);
                if (vertical == null) {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                    throw new HttpException();
                }
                int iMo83roundToPx0680j_8 = subcomposeMeasureScope2.mo83roundToPx0680j_4(vertical.mo109getSpacingD9Ej5fM());
                int itemCount = lazyListItemProviderImpl3.getItemCount();
                int iM680getMaxHeightimpl2 = Constraints.m680getMaxHeightimpl(j3) - i44;
                boolean z7 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                if (!z7 || iM680getMaxHeightimpl2 > 0) {
                    j = ((long) iMo83roundToPx0680j_4) << 32;
                } else {
                    iMo83roundToPx0680j_6 += iM680getMaxHeightimpl2;
                    j = ((long) iMo83roundToPx0680j_4) << 32;
                }
                LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM691offsetNN6EwU, lazyListItemProviderImpl3, lazyLayoutMeasureScopeImpl, itemCount, iMo83roundToPx0680j_8, lazyListKt$rememberLazyListMeasurePolicy$1$1.$horizontalAlignment, z7, i46, i47, (((long) iMo83roundToPx0680j_6) & 4294967295L) | j, lazyListKt$rememberLazyListMeasurePolicy$1$1.$state);
                int i48 = i46;
                boolean z8 = z6;
                Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Exchange exchange = lazyListState.scrollPosition;
                    int intValue = ((ParcelableSnapshotMutableIntState) exchange.call).getIntValue();
                    int iFindIndexByKey = LazyLayoutKt.findIndexByKey(intValue, lazyListItemProviderImpl3, exchange.codec);
                    if (intValue != iFindIndexByKey) {
                        i2 = i48;
                        ((ParcelableSnapshotMutableIntState) exchange.call).setIntValue(iFindIndexByKey);
                        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = (LazyLayoutNearestRangeState) exchange.connection;
                        i3 = iFindIndexByKey;
                        if (intValue != lazyLayoutNearestRangeState.lastFirstVisibleItem) {
                            lazyLayoutNearestRangeState.lastFirstVisibleItem = intValue;
                            int i49 = (intValue / 30) * 30;
                            lazyLayoutNearestRangeState.value$delegate.setValue(RangesKt.until(Math.max(i49 - 100, 0), i49 + 130));
                        }
                    } else {
                        i2 = i48;
                        i3 = iFindIndexByKey;
                    }
                    int intValue2 = ((ParcelableSnapshotMutableIntState) exchange.finder).getIntValue();
                    Unit unit = Unit.INSTANCE;
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    LazyLayoutPinnedItemList lazyLayoutPinnedItemList = lazyListState.pinnedItems;
                    PreviewView.AnonymousClass1 anonymousClass1 = lazyListState.beyondBoundsInfo;
                    MutableVector mutableVector = (MutableVector) anonymousClass1.this$0;
                    boolean z9 = mutableVector.size != 0;
                    List list2 = EmptyList.INSTANCE;
                    if (z9 || !lazyLayoutPinnedItemList.items.isEmpty()) {
                        arrayList = new ArrayList();
                        if (((MutableVector) anonymousClass1.this$0).size != 0) {
                            int i50 = mutableVector.size;
                            if (i50 == 0) {
                                throw new NoSuchElementException("MutableVector is empty.");
                            }
                            Object[] objArr = mutableVector.content;
                            int i51 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr[0]).start;
                            int i52 = 0;
                            while (i52 < i50) {
                                int i53 = i52;
                                int i54 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr[i52]).start;
                                if (i54 < i51) {
                                    i51 = i54;
                                }
                                i52 = i53 + 1;
                            }
                            if (i51 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
                            }
                            int i55 = mutableVector.size;
                            if (i55 == 0) {
                                throw new NoSuchElementException("MutableVector is empty.");
                            }
                            Object[] objArr2 = mutableVector.content;
                            int i56 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr2[0]).end;
                            int i57 = 0;
                            while (i57 < i55) {
                                Object[] objArr3 = objArr2;
                                int i58 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr2[i57]).end;
                                if (i58 > i56) {
                                    i56 = i58;
                                }
                                i57++;
                                objArr2 = objArr3;
                            }
                            intRange = new IntRange(i51, Math.min(i56, lazyListItemProviderImpl3.getItemCount() - 1), 1);
                        } else {
                            intRange = IntRange.EMPTY;
                        }
                        int size11 = lazyLayoutPinnedItemList.items.size();
                        for (int i59 = 0; i59 < size11; i59++) {
                            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) lazyLayoutPinnedItemList.get(i59);
                            int iFindIndexByKey2 = LazyLayoutKt.findIndexByKey(lazyLayoutPinnableItem.index, lazyListItemProviderImpl3, lazyLayoutPinnableItem.key);
                            int i60 = intRange.first;
                            if ((iFindIndexByKey2 > intRange.last || i60 > iFindIndexByKey2) && iFindIndexByKey2 >= 0 && iFindIndexByKey2 < lazyListItemProviderImpl3.getItemCount()) {
                                arrayList.add(Integer.valueOf(iFindIndexByKey2));
                            }
                        }
                        int i61 = intRange.first;
                        int i62 = intRange.last;
                        if (i61 <= i62) {
                            while (true) {
                                arrayList.add(Integer.valueOf(i61));
                                if (i61 != i62) {
                                    i61++;
                                }
                            }
                        }
                    } else {
                        intValue2 = intValue2;
                        arrayList = list2;
                    }
                    float fFloatValue2 = (subcomposeMeasureScope2.isLookingAhead() || !z8) ? lazyListState.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState._lazyLayoutScrollDeltaBetweenPasses.cache).value$delegate.getValue()).floatValue();
                    boolean z10 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                    LazyLayoutItemAnimator lazyLayoutItemAnimator2 = lazyListState.itemAnimator;
                    boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                    CoroutineScope coroutineScope = lazyListKt$rememberLazyListMeasurePolicy$1$1.$coroutineScope;
                    MutableState mutableState = lazyListState.placementScopeInvalidator;
                    DummyHandle dummyHandle = lazyListKt$rememberLazyListMeasurePolicy$1$1.$stickyItemsPlacement;
                    boolean z11 = lazyListState.skipItemPlacementAnimation;
                    if (i2 < 0) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                    }
                    if (i47 < 0) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                    }
                    EmptyMap emptyMap = EmptyMap.INSTANCE;
                    LazyListItemProviderImpl lazyListItemProviderImpl4 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.itemProvider;
                    if (itemCount <= 0) {
                        int iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(jM691offsetNN6EwU);
                        int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(jM691offsetNN6EwU);
                        lazyLayoutItemAnimator2.onMeasured(iM683getMinWidthimpl, iM682getMinHeightimpl, new ArrayList(), lazyListItemProviderImpl4.keyIndexMap, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, zIsLookingAhead, z8, 0, 0);
                        if (!zIsLookingAhead) {
                            lazyLayoutItemAnimator2.m149getMinSizeToFitDisappearingItemsYbymL2g();
                            if (!zM717equalsimpl0) {
                                iM683getMinWidthimpl = ConstraintsKt.m690constrainWidthK40F9xA((int) 0, jM691offsetNN6EwU);
                                iM682getMinHeightimpl = ConstraintsKt.m689constrainHeightK40F9xA((int) 0, jM691offsetNN6EwU);
                            }
                        }
                        subcomposeMeasureScope = subcomposeMeasureScope2;
                        lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, 0.0f, subcomposeMeasureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(iM683getMinWidthimpl + i45, j3), ConstraintsKt.m689constrainHeightK40F9xA(iM682getMinHeightimpl + i44, j3), emptyMap, new BasicTextKt$$ExternalSyntheticLambda3(14)), 0.0f, false, coroutineScope, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints, list2, -i2, iM680getMaxHeightimpl2 + i47, 0, z10, orientation, i47, iMo83roundToPx0680j_8);
                    } else {
                        float f2 = fFloatValue2;
                        int i63 = i2;
                        MeasureScope measureScope = r6;
                        int i64 = itemCount;
                        int i65 = i3;
                        if (i65 >= i64) {
                            i65 = i64 - 1;
                            intValue2 = 0;
                        }
                        int iRound = Math.round(f2);
                        int i66 = intValue2 - iRound;
                        if (i65 == 0 && i66 < 0) {
                            iRound += i66;
                            i66 = 0;
                        }
                        int i67 = i65;
                        ArrayDeque arrayDeque2 = new ArrayDeque();
                        int i68 = -i63;
                        int i69 = i68 + (iMo83roundToPx0680j_8 < 0 ? iMo83roundToPx0680j_8 : 0);
                        int i70 = i66 + i69;
                        int iMax5 = 0;
                        while (true) {
                            j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints;
                            if (i70 < 0 && i67 > 0) {
                                MutableState mutableState2 = mutableState;
                                int i71 = i67 - 1;
                                LazyListMeasuredItem lazyListMeasuredItemM144getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i71, j2);
                                arrayDeque2.add(0, lazyListMeasuredItemM144getAndMeasure0kLqBqw);
                                iMax5 = Math.max(iMax5, lazyListMeasuredItemM144getAndMeasure0kLqBqw.crossAxisSize);
                                i70 += lazyListMeasuredItemM144getAndMeasure0kLqBqw.mainAxisSizeWithSpacings;
                                i67 = i71;
                                mutableState = mutableState2;
                            }
                        }
                        MutableState mutableState3 = mutableState;
                        if (i70 < i69) {
                            iRound -= i69 - i70;
                            i70 = i69;
                        }
                        int i72 = iRound;
                        int i73 = i70 - i69;
                        int i74 = iM680getMaxHeightimpl2 + i47;
                        int i75 = iMax5;
                        int i76 = i74 < 0 ? 0 : i74;
                        int i77 = i68;
                        int i78 = -i73;
                        int i79 = i73;
                        int i80 = i67;
                        int i81 = 0;
                        boolean z12 = false;
                        while (i81 < arrayDeque2.size) {
                            if (i78 >= i76) {
                                arrayDeque2.removeAt(i81);
                                Unit unit2 = Unit.INSTANCE;
                                z12 = true;
                            } else {
                                i80++;
                                i78 += ((LazyListMeasuredItem) arrayDeque2.get(i81)).mainAxisSizeWithSpacings;
                                i81++;
                            }
                        }
                        int iMax6 = i75;
                        int i82 = i80;
                        boolean z13 = z12;
                        while (i82 < i64 && (i78 < i76 || i78 <= 0 || arrayDeque2.isEmpty())) {
                            int i83 = i76;
                            LazyListMeasuredItem lazyListMeasuredItemM144getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i82, j2);
                            int i84 = i64;
                            int i85 = lazyListMeasuredItemM144getAndMeasure0kLqBqw2.mainAxisSizeWithSpacings;
                            i78 += i85;
                            if (i78 > i69 || i82 == i84 - 1) {
                                iMax6 = Math.max(iMax6, lazyListMeasuredItemM144getAndMeasure0kLqBqw2.crossAxisSize);
                                arrayDeque2.addLast(lazyListMeasuredItemM144getAndMeasure0kLqBqw2);
                            } else {
                                i79 -= i85;
                                Unit unit3 = Unit.INSTANCE;
                                i67 = i82 + 1;
                                z13 = true;
                            }
                            i82++;
                            i76 = i83;
                            i64 = i84;
                        }
                        int i86 = i64;
                        if (i78 < iM680getMaxHeightimpl2) {
                            int i87 = iM680getMaxHeightimpl2 - i78;
                            i78 += i87;
                            i7 = i79 - i87;
                            while (i7 < i63 && i67 > 0) {
                                int i88 = i63;
                                int i89 = i67 - 1;
                                int i90 = i87;
                                LazyListMeasuredItem lazyListMeasuredItemM144getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i89, j2);
                                i67 = i89;
                                arrayDeque2.add(0, lazyListMeasuredItemM144getAndMeasure0kLqBqw3);
                                iMax6 = Math.max(iMax6, lazyListMeasuredItemM144getAndMeasure0kLqBqw3.crossAxisSize);
                                i7 += lazyListMeasuredItemM144getAndMeasure0kLqBqw3.mainAxisSizeWithSpacings;
                                i63 = i88;
                                i87 = i90;
                            }
                            i4 = i63;
                            i5 = i72 + i87;
                            if (i7 < 0) {
                                i5 += i7;
                                i78 += i7;
                                i6 = i67;
                                i7 = 0;
                            } else {
                                i6 = i67;
                            }
                        } else {
                            i4 = i63;
                            i5 = i72;
                            i6 = i67;
                            i7 = i79;
                        }
                        int i91 = iMax6;
                        int i92 = i82;
                        float f3 = (Integer.signum(Math.round(f2)) != Integer.signum(i5) || Math.abs(Math.round(f2)) < Math.abs(i5)) ? f2 : i5;
                        float f4 = f2 - f3;
                        float f5 = 0.0f;
                        if (zIsLookingAhead && i5 > i72 && f4 <= 0.0f) {
                            f5 = (i5 - i72) + f4;
                        }
                        if (i7 < 0) {
                            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                        }
                        int i93 = -i7;
                        LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.first();
                        if (i4 > 0 || iMo83roundToPx0680j_8 < 0) {
                            int size12 = arrayDeque2.getSize();
                            f = f3;
                            int i94 = 0;
                            while (true) {
                                if (i94 < size12) {
                                    i8 = i93;
                                    int i95 = ((LazyListMeasuredItem) arrayDeque2.get(i94)).mainAxisSizeWithSpacings;
                                    if (i7 != 0 && i95 <= i7 && i94 != MatrixExt.getLastIndex(arrayDeque2)) {
                                        i7 -= i95;
                                        i94++;
                                        lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque2.get(i94);
                                        i93 = i8;
                                    }
                                }
                            }
                            iMax = Math.max(0, i6);
                            i9 = i6 - 1;
                            arrayList2 = null;
                            if (iMax <= i9) {
                                while (true) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i9, j2));
                                    if (i9 != iMax) {
                                        i9--;
                                    }
                                }
                            }
                            size = arrayList.size() - 1;
                            if (size >= 0) {
                                while (true) {
                                    i40 = size - 1;
                                    iIntValue4 = ((Number) arrayList.get(size)).intValue();
                                    if (iIntValue4 < iMax) {
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(iIntValue4, j2));
                                    }
                                    if (i40 < 0) {
                                        size = i40;
                                    }
                                }
                            }
                            if (arrayList2 == null) {
                                arrayList2 = list2;
                            }
                            iMax2 = i91;
                            i10 = 0;
                            for (size2 = arrayList2.size(); i10 < size2; size2 = size2) {
                                iMax2 = Math.max(iMax2, ((LazyListMeasuredItem) arrayList2.get(i10)).crossAxisSize);
                                i10++;
                            }
                            iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i86 - 1);
                            i11 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                            if (i11 <= iMin) {
                                arrayList6 = null;
                                while (true) {
                                    if (arrayList6 == null) {
                                        arrayList6 = new ArrayList();
                                    }
                                    i12 = iMax2;
                                    arrayList3 = arrayList6;
                                    i13 = i7;
                                    arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i11, j2));
                                    if (i11 != iMin) {
                                        i11++;
                                        i7 = i13;
                                        arrayList6 = arrayList3;
                                        iMax2 = i12;
                                    }
                                }
                            } else {
                                i12 = iMax2;
                                i13 = i7;
                                arrayList3 = null;
                            }
                            if (arrayList3 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList3)).index > iMin) {
                                iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList3)).index;
                            }
                            size3 = arrayList.size();
                            i14 = 0;
                            r6 = arrayList;
                            while (i14 < size3) {
                                ?? r56 = r6;
                                iIntValue3 = ((Number) r6.get(i14)).intValue();
                                if (iIntValue3 <= iMin) {
                                    if (arrayList3 == null) {
                                        arrayList3 = new ArrayList();
                                    }
                                    arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(iIntValue3, j2));
                                }
                                i14++;
                                r6 = r56;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = list2;
                            }
                            size4 = arrayList3.size();
                            iMax3 = i12;
                            for (i15 = 0; i15 < size4; i15++) {
                                iMax3 = Math.max(iMax3, ((LazyListMeasuredItem) arrayList3.get(i15)).crossAxisSize);
                            }
                            if (!Intrinsics.areEqual(lazyListMeasuredItem8, arrayDeque2.first()) && arrayList2.isEmpty() && arrayList3.isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            iM690constrainWidthK40F9xA = ConstraintsKt.m690constrainWidthK40F9xA(iMax3, jM691offsetNN6EwU);
                            iM689constrainHeightK40F9xA = ConstraintsKt.m689constrainHeightK40F9xA(i78, jM691offsetNN6EwU);
                            if (i78 < Math.min(iM689constrainHeightK40F9xA, iM680getMaxHeightimpl2)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 && i8 != 0) {
                                InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                            }
                            z3 = z;
                            LazyListMeasuredItem lazyListMeasuredItem9 = lazyListMeasuredItem8;
                            arrayList4 = new ArrayList(arrayList3.size() + arrayList2.size() + arrayDeque2.getSize());
                            if (z2) {
                                if (arrayList2.isEmpty() || !arrayList3.isEmpty()) {
                                    InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                                }
                                size10 = arrayDeque2.getSize();
                                iArr = new int[size10];
                                for (i32 = 0; i32 < size10; i32++) {
                                    if (z10) {
                                        i39 = (size10 - i32) - 1;
                                    } else {
                                        i39 = i32;
                                    }
                                    iArr[i32] = ((LazyListMeasuredItem) arrayDeque2.get(i39)).size;
                                }
                                iArr2 = new int[size10];
                                if (vertical != null) {
                                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                    throw new HttpException();
                                }
                                vertical.arrange(iM689constrainHeightK40F9xA, measureScope, iArr, iArr2);
                                if (z10) {
                                    i33 = size10;
                                    IntRange intRange2 = new IntRange(0, i33 - 1, 1);
                                    intProgression = new IntProgression(intRange2.last, 0, -intRange2.step);
                                } else {
                                    i33 = size10;
                                    intProgression = new IntRange(0, size10 - 1, 1);
                                }
                                i34 = intProgression.first;
                                i35 = intProgression.last;
                                i36 = intProgression.step;
                                if ((i36 <= 0 && i34 <= i35) || (i36 < 0 && i35 <= i34)) {
                                    while (true) {
                                        i37 = iArr2[i34];
                                        if (z10) {
                                            i38 = (i33 - i34) - 1;
                                        } else {
                                            i38 = i34;
                                        }
                                        lazyListMeasuredItem7 = (LazyListMeasuredItem) arrayDeque2.get(i38);
                                        if (z10) {
                                            i37 = (iM689constrainHeightK40F9xA - i37) - lazyListMeasuredItem7.size;
                                        }
                                        lazyListMeasuredItem7.position(i37, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                        arrayList4.add(lazyListMeasuredItem7);
                                        if (i34 != i35) {
                                            i34 += i36;
                                            i36 = i36;
                                            iArr2 = iArr2;
                                        }
                                    }
                                }
                            } else {
                                measureScope = measureScope;
                                size5 = arrayList2.size();
                                i16 = i8;
                                i17 = 0;
                                while (i17 < size5) {
                                    List list3 = arrayList2;
                                    LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayList2.get(i17);
                                    i16 -= lazyListMeasuredItem10.mainAxisSizeWithSpacings;
                                    lazyListMeasuredItem10.position(i16, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList4.add(lazyListMeasuredItem10);
                                    i17++;
                                    size5 = size5;
                                    arrayList2 = list3;
                                }
                                size6 = arrayDeque2.getSize();
                                i18 = i8;
                                for (i19 = 0; i19 < size6; i19++) {
                                    LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) arrayDeque2.get(i19);
                                    lazyListMeasuredItem11.position(i18, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList4.add(lazyListMeasuredItem11);
                                    i18 += lazyListMeasuredItem11.mainAxisSizeWithSpacings;
                                }
                                size7 = arrayList3.size();
                                for (i20 = 0; i20 < size7; i20++) {
                                    LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) arrayList3.get(i20);
                                    lazyListMeasuredItem12.position(i18, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList4.add(lazyListMeasuredItem12);
                                    i18 += lazyListMeasuredItem12.mainAxisSizeWithSpacings;
                                }
                            }
                            if (z11) {
                                arrayList5 = arrayList4;
                                lazyLayoutItemAnimator = lazyLayoutItemAnimator2;
                                lazyListItemProviderImpl = lazyListItemProviderImpl4;
                            } else {
                                lazyListItemProviderImpl = lazyListItemProviderImpl4;
                                lazyLayoutItemAnimator = lazyLayoutItemAnimator2;
                                int i96 = i13;
                                lazyLayoutItemAnimator.onMeasured(iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA, arrayList4, lazyListItemProviderImpl.keyIndexMap, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, zIsLookingAhead, z8, i96, i78);
                                arrayList5 = arrayList4;
                                i13 = i96;
                            }
                            if (!zIsLookingAhead) {
                                lazyLayoutItemAnimator.m149getMinSizeToFitDisappearingItemsYbymL2g();
                                if (!zM717equalsimpl0) {
                                    iM690constrainWidthK40F9xA = ConstraintsKt.m690constrainWidthK40F9xA(Math.max(iM690constrainWidthK40F9xA, (int) 0), jM691offsetNN6EwU);
                                    iM689constrainHeightK40F9xA2 = ConstraintsKt.m689constrainHeightK40F9xA(Math.max(iM689constrainHeightK40F9xA, (int) 0), jM691offsetNN6EwU);
                                    if (iM689constrainHeightK40F9xA2 != iM689constrainHeightK40F9xA) {
                                        size9 = arrayList5.size();
                                        for (i31 = 0; i31 < size9; i31++) {
                                            ((LazyListMeasuredItem) arrayList5.get(i31)).mainAxisLayoutSize = iM689constrainHeightK40F9xA2;
                                        }
                                    }
                                    iM689constrainHeightK40F9xA = iM689constrainHeightK40F9xA2;
                                }
                            }
                            lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque2.firstOrNull();
                            if (lazyListMeasuredItem != null) {
                                i21 = lazyListMeasuredItem.index;
                            } else {
                                i21 = 0;
                            }
                            lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque2.lastOrNull();
                            if (lazyListMeasuredItem2 != null) {
                                i22 = lazyListMeasuredItem2.index;
                            } else {
                                i22 = 0;
                            }
                            lazyListItemProviderImpl.intervalContent.getClass();
                            MutableIntList mutableIntList2 = IntListKt.EmptyIntList;
                            if (dummyHandle != null || arrayList5.isEmpty() || (i26 = mutableIntList2._size) == 0) {
                                arrayDeque = arrayDeque2;
                                i23 = i77;
                                list = list2;
                            } else {
                                if (i22 - i21 < 0 || i26 == 0) {
                                    mutableIntList = mutableIntList2;
                                } else {
                                    IntRange intRangeUntil = RangesKt.until(0, i26);
                                    int i97 = intRangeUntil.first;
                                    int i98 = intRangeUntil.last;
                                    if (i97 <= i98) {
                                        i30 = -1;
                                        while (mutableIntList2.get(i97) <= i21) {
                                            i30 = mutableIntList2.get(i97);
                                            if (i97 != i98) {
                                                i97++;
                                            } else {
                                                i29 = -1;
                                            }
                                        }
                                        i29 = -1;
                                    } else {
                                        i29 = -1;
                                        i30 = -1;
                                    }
                                    if (i30 == i29) {
                                        mutableIntList = IntListKt.EmptyIntList;
                                    } else {
                                        mutableIntList = new MutableIntList(1);
                                        mutableIntList.add(i30);
                                    }
                                }
                                ArrayList arrayList7 = new ArrayList();
                                ArrayList arrayList8 = new ArrayList(arrayList5.size());
                                int size13 = arrayList5.size();
                                int i99 = 0;
                                while (i99 < size13) {
                                    ArrayDeque arrayDeque3 = arrayDeque2;
                                    Object obj7 = arrayList5.get(i99);
                                    int i100 = size13;
                                    int i101 = ((LazyListMeasuredItem) obj7).index;
                                    int i102 = i99;
                                    int[] iArr3 = mutableIntList2.content;
                                    int i103 = mutableIntList2._size;
                                    MutableIntList mutableIntList3 = mutableIntList2;
                                    int i104 = 0;
                                    while (i104 < i103) {
                                        int i105 = i104;
                                        if (iArr3[i105] == i101) {
                                            arrayList8.add(obj7);
                                        }
                                        i104 = i105 + 1;
                                        break;
                                    }
                                    i99 = i102 + 1;
                                    arrayDeque2 = arrayDeque3;
                                    size13 = i100;
                                    mutableIntList2 = mutableIntList3;
                                }
                                arrayDeque = arrayDeque2;
                                int[] iArr4 = mutableIntList.content;
                                int i106 = mutableIntList._size;
                                int i107 = 0;
                                while (i107 < i106) {
                                    int i108 = iArr4[i107];
                                    int size14 = arrayList5.size();
                                    int[] iArr5 = iArr4;
                                    int i109 = 0;
                                    int i110 = 0;
                                    while (true) {
                                        if (i109 < size14) {
                                            Object obj8 = arrayList5.get(i109);
                                            int i111 = i109 + 1;
                                            if (((LazyListMeasuredItem) obj8).index == i108) {
                                                i27 = i110;
                                            } else {
                                                i110++;
                                                i109 = i111;
                                            }
                                        } else {
                                            i27 = -1;
                                        }
                                    }
                                    long j4 = j2;
                                    LazyListMeasuredItem lazyListMeasuredItemM144getAndMeasure0kLqBqw4 = i27 == -1 ? lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i108, j2) : (LazyListMeasuredItem) arrayList5.remove(i27);
                                    int i112 = lazyListMeasuredItemM144getAndMeasure0kLqBqw4.mainAxisSizeWithSpacings;
                                    int iM146getOffsetBjo55l4 = i27 == -1 ? Integer.MIN_VALUE : (int) (lazyListMeasuredItemM144getAndMeasure0kLqBqw4.m146getOffsetBjo55l4(0) & 4294967295L);
                                    int size15 = arrayList8.size();
                                    int i113 = 0;
                                    while (true) {
                                        if (i113 < size15) {
                                            obj3 = arrayList8.get(i113);
                                            int i114 = i113;
                                            if (((LazyListMeasuredItem) obj3).index == i108) {
                                                i113 = i114 + 1;
                                            }
                                        } else {
                                            obj3 = null;
                                        }
                                    }
                                    LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) obj3;
                                    int iM146getOffsetBjo55l5 = lazyListMeasuredItem13 != null ? (int) (lazyListMeasuredItem13.m146getOffsetBjo55l4(0) & 4294967295L) : Integer.MIN_VALUE;
                                    if (iM146getOffsetBjo55l4 == Integer.MIN_VALUE) {
                                        iMax4 = i77;
                                        i28 = iMax4;
                                    } else {
                                        i28 = i77;
                                        iMax4 = Math.max(i28, iM146getOffsetBjo55l4);
                                    }
                                    if (iM146getOffsetBjo55l5 != Integer.MIN_VALUE) {
                                        iMax4 = Math.min(iMax4, iM146getOffsetBjo55l5 - i112);
                                    }
                                    lazyListMeasuredItemM144getAndMeasure0kLqBqw4.nonScrollableItem = true;
                                    lazyListMeasuredItemM144getAndMeasure0kLqBqw4.position(iMax4, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList7.add(lazyListMeasuredItemM144getAndMeasure0kLqBqw4);
                                    i107++;
                                    arrayList8 = arrayList8;
                                    i77 = i28;
                                    iArr4 = iArr5;
                                    j2 = j4;
                                }
                                i23 = i77;
                                list = arrayList7;
                            }
                            if (z3) {
                                lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(arrayList5);
                                if (lazyListMeasuredItem6 != null) {
                                    numValueOf = Integer.valueOf(lazyListMeasuredItem6.index);
                                } else {
                                    numValueOf = null;
                                }
                            } else {
                                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                                if (lazyListMeasuredItem3 != null) {
                                    numValueOf = Integer.valueOf(lazyListMeasuredItem3.index);
                                } else {
                                    numValueOf = null;
                                }
                            }
                            if (z3) {
                                lazyListMeasuredItem5 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList5);
                                if (lazyListMeasuredItem5 != null) {
                                    numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                                } else {
                                    numValueOf2 = null;
                                }
                            } else {
                                lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                                if (lazyListMeasuredItem4 != null) {
                                    numValueOf2 = Integer.valueOf(lazyListMeasuredItem4.index);
                                } else {
                                    numValueOf2 = null;
                                }
                            }
                            if (i92 >= i86 || i78 > iM680getMaxHeightimpl2) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            subcomposeMeasureScope = subcomposeMeasureScope2;
                            MeasureResult measureResultLayout = subcomposeMeasureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(iM690constrainWidthK40F9xA + i45, j3), ConstraintsKt.m689constrainHeightK40F9xA(iM689constrainHeightK40F9xA + i44, j3), emptyMap, new LifecycleEffectKt$$ExternalSyntheticLambda1(mutableState3, arrayList5, list, zIsLookingAhead));
                            if (numValueOf != null) {
                                iIntValue = numValueOf.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            if (numValueOf2 != null) {
                                iIntValue2 = numValueOf2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            if (!arrayList5.isEmpty()) {
                                ArrayList arrayList9 = new ArrayList(list);
                                size8 = arrayList5.size();
                                for (i24 = 0; i24 < size8; i24++) {
                                    LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) arrayList5.get(i24);
                                    i25 = lazyListMeasuredItem14.index;
                                    if (iIntValue > i25 && i25 <= iIntValue2) {
                                        arrayList9.add(lazyListMeasuredItem14);
                                    }
                                }
                                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList9, LazyLayoutKt.LazyLayoutMeasuredItemIndexComparator);
                                list2 = arrayList9;
                            }
                            lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem9, i13, z4, f, measureResultLayout, f5, z13, coroutineScope, measureScope, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints, list2, i23, i74, i86, z10, orientation, i47, iMo83roundToPx0680j_8);
                        } else {
                            f = f3;
                        }
                        i8 = i93;
                        iMax = Math.max(0, i6);
                        i9 = i6 - 1;
                        arrayList2 = null;
                        if (iMax <= i9) {
                            while (true) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i9, j2));
                                if (i9 != iMax) {
                                    i9--;
                                }
                            }
                        }
                        size = arrayList.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                i40 = size - 1;
                                iIntValue4 = ((Number) arrayList.get(size)).intValue();
                                if (iIntValue4 < iMax) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(iIntValue4, j2));
                                }
                                if (i40 < 0) {
                                    size = i40;
                                }
                            }
                        }
                        if (arrayList2 == null) {
                            arrayList2 = list2;
                        }
                        iMax2 = i91;
                        i10 = 0;
                        while (i10 < size2) {
                            iMax2 = Math.max(iMax2, ((LazyListMeasuredItem) arrayList2.get(i10)).crossAxisSize);
                            i10++;
                        }
                        iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i86 - 1);
                        i11 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                        if (i11 <= iMin) {
                            arrayList6 = null;
                            while (true) {
                                if (arrayList6 == null) {
                                    arrayList6 = new ArrayList();
                                }
                                i12 = iMax2;
                                arrayList3 = arrayList6;
                                i13 = i7;
                                arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(i11, j2));
                                if (i11 != iMin) {
                                    i11++;
                                    i7 = i13;
                                    arrayList6 = arrayList3;
                                    iMax2 = i12;
                                }
                            }
                        } else {
                            i12 = iMax2;
                            i13 = i7;
                            arrayList3 = null;
                        }
                        if (arrayList3 != null) {
                            iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList3)).index;
                        }
                        size3 = arrayList.size();
                        i14 = 0;
                        r6 = arrayList;
                        while (i14 < size3) {
                            ?? r57 = r6;
                            iIntValue3 = ((Number) r6.get(i14)).intValue();
                            if (iIntValue3 <= iMin) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m144getAndMeasure0kLqBqw(iIntValue3, j2));
                            }
                            i14++;
                            r6 = r57;
                        }
                        if (arrayList3 == null) {
                            arrayList3 = list2;
                        }
                        size4 = arrayList3.size();
                        iMax3 = i12;
                        while (i15 < size4) {
                            iMax3 = Math.max(iMax3, ((LazyListMeasuredItem) arrayList3.get(i15)).crossAxisSize);
                        }
                        if (!Intrinsics.areEqual(lazyListMeasuredItem8, arrayDeque2.first())) {
                            z = false;
                        } else {
                            z = false;
                        }
                        iM690constrainWidthK40F9xA = ConstraintsKt.m690constrainWidthK40F9xA(iMax3, jM691offsetNN6EwU);
                        iM689constrainHeightK40F9xA = ConstraintsKt.m689constrainHeightK40F9xA(i78, jM691offsetNN6EwU);
                        if (i78 < Math.min(iM689constrainHeightK40F9xA, iM680getMaxHeightimpl2)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                        }
                        z3 = z;
                        LazyListMeasuredItem lazyListMeasuredItem15 = lazyListMeasuredItem8;
                        arrayList4 = new ArrayList(arrayList3.size() + arrayList2.size() + arrayDeque2.getSize());
                        if (z2) {
                            if (arrayList2.isEmpty()) {
                                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                            } else {
                                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                            }
                            size10 = arrayDeque2.getSize();
                            iArr = new int[size10];
                            while (i32 < size10) {
                                if (z10) {
                                    i39 = i32;
                                } else {
                                    i39 = (size10 - i32) - 1;
                                }
                                iArr[i32] = ((LazyListMeasuredItem) arrayDeque2.get(i39)).size;
                            }
                            iArr2 = new int[size10];
                            if (vertical != null) {
                                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                                throw new HttpException();
                            }
                            vertical.arrange(iM689constrainHeightK40F9xA, measureScope, iArr, iArr2);
                            if (z10) {
                                i33 = size10;
                                intProgression = new IntRange(0, size10 - 1, 1);
                            } else {
                                i33 = size10;
                                IntRange intRange3 = new IntRange(0, i33 - 1, 1);
                                intProgression = new IntProgression(intRange3.last, 0, -intRange3.step);
                            }
                            i34 = intProgression.first;
                            i35 = intProgression.last;
                            i36 = intProgression.step;
                            if (i36 <= 0) {
                                while (true) {
                                    i37 = iArr2[i34];
                                    if (z10) {
                                        i38 = i34;
                                    } else {
                                        i38 = (i33 - i34) - 1;
                                    }
                                    lazyListMeasuredItem7 = (LazyListMeasuredItem) arrayDeque2.get(i38);
                                    if (z10) {
                                        i37 = (iM689constrainHeightK40F9xA - i37) - lazyListMeasuredItem7.size;
                                    }
                                    lazyListMeasuredItem7.position(i37, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList4.add(lazyListMeasuredItem7);
                                    if (i34 != i35) {
                                        i34 += i36;
                                        i36 = i36;
                                        iArr2 = iArr2;
                                    }
                                }
                            } else {
                                while (true) {
                                    i37 = iArr2[i34];
                                    if (z10) {
                                        i38 = i34;
                                    } else {
                                        i38 = (i33 - i34) - 1;
                                    }
                                    lazyListMeasuredItem7 = (LazyListMeasuredItem) arrayDeque2.get(i38);
                                    if (z10) {
                                        i37 = (iM689constrainHeightK40F9xA - i37) - lazyListMeasuredItem7.size;
                                    }
                                    lazyListMeasuredItem7.position(i37, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                    arrayList4.add(lazyListMeasuredItem7);
                                    if (i34 != i35) {
                                        i34 += i36;
                                        i36 = i36;
                                        iArr2 = iArr2;
                                    }
                                }
                            }
                        } else {
                            measureScope = measureScope;
                            size5 = arrayList2.size();
                            i16 = i8;
                            i17 = 0;
                            while (i17 < size5) {
                                List list4 = arrayList2;
                                LazyListMeasuredItem lazyListMeasuredItem16 = (LazyListMeasuredItem) arrayList2.get(i17);
                                i16 -= lazyListMeasuredItem16.mainAxisSizeWithSpacings;
                                lazyListMeasuredItem16.position(i16, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                arrayList4.add(lazyListMeasuredItem16);
                                i17++;
                                size5 = size5;
                                arrayList2 = list4;
                            }
                            size6 = arrayDeque2.getSize();
                            i18 = i8;
                            while (i19 < size6) {
                                LazyListMeasuredItem lazyListMeasuredItem17 = (LazyListMeasuredItem) arrayDeque2.get(i19);
                                lazyListMeasuredItem17.position(i18, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                arrayList4.add(lazyListMeasuredItem17);
                                i18 += lazyListMeasuredItem17.mainAxisSizeWithSpacings;
                            }
                            size7 = arrayList3.size();
                            while (i20 < size7) {
                                LazyListMeasuredItem lazyListMeasuredItem18 = (LazyListMeasuredItem) arrayList3.get(i20);
                                lazyListMeasuredItem18.position(i18, iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA);
                                arrayList4.add(lazyListMeasuredItem18);
                                i18 += lazyListMeasuredItem18.mainAxisSizeWithSpacings;
                            }
                        }
                        if (z11) {
                            lazyListItemProviderImpl = lazyListItemProviderImpl4;
                            lazyLayoutItemAnimator = lazyLayoutItemAnimator2;
                            int i910 = i13;
                            lazyLayoutItemAnimator.onMeasured(iM690constrainWidthK40F9xA, iM689constrainHeightK40F9xA, arrayList4, lazyListItemProviderImpl.keyIndexMap, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, zIsLookingAhead, z8, i910, i78);
                            arrayList5 = arrayList4;
                            i13 = i910;
                        } else {
                            arrayList5 = arrayList4;
                            lazyLayoutItemAnimator = lazyLayoutItemAnimator2;
                            lazyListItemProviderImpl = lazyListItemProviderImpl4;
                        }
                        if (!zIsLookingAhead) {
                            lazyLayoutItemAnimator.m149getMinSizeToFitDisappearingItemsYbymL2g();
                            if (!zM717equalsimpl0) {
                                iM690constrainWidthK40F9xA = ConstraintsKt.m690constrainWidthK40F9xA(Math.max(iM690constrainWidthK40F9xA, (int) 0), jM691offsetNN6EwU);
                                iM689constrainHeightK40F9xA2 = ConstraintsKt.m689constrainHeightK40F9xA(Math.max(iM689constrainHeightK40F9xA, (int) 0), jM691offsetNN6EwU);
                                if (iM689constrainHeightK40F9xA2 != iM689constrainHeightK40F9xA) {
                                    size9 = arrayList5.size();
                                    while (i31 < size9) {
                                        ((LazyListMeasuredItem) arrayList5.get(i31)).mainAxisLayoutSize = iM689constrainHeightK40F9xA2;
                                    }
                                }
                                iM689constrainHeightK40F9xA = iM689constrainHeightK40F9xA2;
                            }
                        }
                        lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque2.firstOrNull();
                        if (lazyListMeasuredItem != null) {
                            i21 = lazyListMeasuredItem.index;
                        } else {
                            i21 = 0;
                        }
                        lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque2.lastOrNull();
                        if (lazyListMeasuredItem2 != null) {
                            i22 = lazyListMeasuredItem2.index;
                        } else {
                            i22 = 0;
                        }
                        lazyListItemProviderImpl.intervalContent.getClass();
                        MutableIntList mutableIntList4 = IntListKt.EmptyIntList;
                        if (dummyHandle != null) {
                            arrayDeque = arrayDeque2;
                            i23 = i77;
                            list = list2;
                        } else {
                            arrayDeque = arrayDeque2;
                            i23 = i77;
                            list = list2;
                        }
                        if (z3) {
                            lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(arrayList5);
                            if (lazyListMeasuredItem6 != null) {
                                numValueOf = Integer.valueOf(lazyListMeasuredItem6.index);
                            } else {
                                numValueOf = null;
                            }
                        } else {
                            lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                            if (lazyListMeasuredItem3 != null) {
                                numValueOf = Integer.valueOf(lazyListMeasuredItem3.index);
                            } else {
                                numValueOf = null;
                            }
                        }
                        if (z3) {
                            lazyListMeasuredItem5 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList5);
                            if (lazyListMeasuredItem5 != null) {
                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem5.index);
                            } else {
                                numValueOf2 = null;
                            }
                        } else {
                            lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                            if (lazyListMeasuredItem4 != null) {
                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem4.index);
                            } else {
                                numValueOf2 = null;
                            }
                        }
                        if (i92 >= i86) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        subcomposeMeasureScope = subcomposeMeasureScope2;
                        MeasureResult measureResultLayout2 = subcomposeMeasureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(iM690constrainWidthK40F9xA + i45, j3), ConstraintsKt.m689constrainHeightK40F9xA(iM689constrainHeightK40F9xA + i44, j3), emptyMap, new LifecycleEffectKt$$ExternalSyntheticLambda1(mutableState3, arrayList5, list, zIsLookingAhead));
                        if (numValueOf != null) {
                            iIntValue = numValueOf.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (numValueOf2 != null) {
                            iIntValue2 = numValueOf2.intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        if (!arrayList5.isEmpty()) {
                            ArrayList arrayList10 = new ArrayList(list);
                            size8 = arrayList5.size();
                            while (i24 < size8) {
                                LazyListMeasuredItem lazyListMeasuredItem19 = (LazyListMeasuredItem) arrayList5.get(i24);
                                i25 = lazyListMeasuredItem19.index;
                                if (iIntValue > i25) {
                                }
                            }
                            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList10, LazyLayoutKt.LazyLayoutMeasuredItemIndexComparator);
                            list2 = arrayList10;
                        }
                        lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem15, i13, z4, f, measureResultLayout2, f5, z13, coroutineScope, measureScope, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints, list2, i23, i74, i86, z10, orientation, i47, iMo83roundToPx0680j_8);
                    }
                    lazyListState.applyMeasureResult$foundation(lazyListMeasureResult, subcomposeMeasureScope.isLookingAhead(), false);
                    return lazyListMeasureResult;
                } catch (Throwable th) {
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            case 6:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) obj5;
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    composableLambdaImpl.invoke((Object) lazySaveableStateHolder, (Object) gapComposer2, (Object) 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 7:
                TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj5;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj4;
                GapComposer gapComposer3 = (GapComposer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                if (gapComposer3.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    boolean zChanged = gapComposer3.changed(textContextMenuDataProvider);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = Stack.derivedStateOf(new FocusableNode.AnonymousClass1(0, textContextMenuDataProvider, TextContextMenuDataProvider.class, "data", "data()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", 0, 0, 1));
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown(textContextMenuSession, (TextContextMenuData) ((State) objRememberedValue2).getValue(), gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 8:
                ((Integer) obj2).getClass();
                DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown((TextContextMenuSession) obj5, (TextContextMenuData) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 9:
                ((Integer) obj2).getClass();
                ((TextContextMenuHelperApi28) obj5).IconBox((Drawable) obj4, (GapComposer) obj, Stack.updateChangedFlags(49));
                return Unit.INSTANCE;
            case 10:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj5;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj4;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                Context context = (Context) obj2;
                boolean editable = textFieldSelectionManager.getEditable();
                AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
                String str = transformedText$foundation != null ? transformedText$foundation.text : null;
                TextRange textRange2 = textFieldSelectionManager.latestSelection;
                if (textRange2 != null) {
                    long j5 = textRange2.packedValue;
                    OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                    textRange = new TextRange(ParagraphKt.TextRange(offsetMapping.originalToTransformed((int) (j5 >> 32)), offsetMapping.originalToTransformed((int) (j5 & 4294967295L))));
                }
                PlatformSelectionBehaviors_androidKt.m215addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, editable, str, textRange, textFieldSelectionManager.platformSelectionBehaviors, new LifecycleEffectKt$$ExternalSyntheticLambda1(textFieldSelectionManager, coroutineScope2, context, 11));
                return Unit.INSTANCE;
            case 11:
                Function2 function2 = (Function2) obj5;
                Function2 function3 = (Function2) obj4;
                GapComposer gapComposer4 = (GapComposer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                if (gapComposer4.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    Modifier modifierThen = OffsetKt.padding(Modifier.Companion.$$INSTANCE, AlertDialogKt.TitlePadding).then(new HorizontalAlignElement(function2 == null ? Alignment.Companion.Start : Alignment.Companion.CenterHorizontally));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    long j6 = gapComposer4.compositeKeyHashCode;
                    int i115 = (int) (j6 ^ (j6 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierThen);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m294setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m294setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m294setimpl(gapComposer4, Integer.valueOf(i115), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m293reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m294setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    function3.invoke(gapComposer4, 0);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 12:
                return invoke$androidx$compose$material3$ButtonKt$$ExternalSyntheticLambda4(obj, obj2);
            case 13:
                ((Integer) obj2).getClass();
                ((DefaultBasicAlertDialogOverride) obj5).BasicAlertDialog((Request.Builder) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 14:
                ((Integer) obj2).getClass();
                ((DefaultSingleRowTopAppBarOverride) obj5).SingleRowTopAppBar((SingleRowTopAppBarOverrideScope) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 15:
                return invoke$androidx$compose$material3$ScaffoldKt$$ExternalSyntheticLambda6(obj, obj2);
            case 16:
                ((Integer) obj2).getClass();
                SheetDefaultsKt.DragHandleWithTooltip((Modifier) obj5, (Function2) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 17:
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj4;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj5;
                GapComposer gapComposer5 = (GapComposer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                if (gapComposer5.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    composableLambdaImpl2.invoke((Object) snackbarDataImpl, (Object) gapComposer5, (Object) 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 18:
                return invoke$androidx$compose$material3$TooltipKt$$ExternalSyntheticLambda1(obj, obj2);
            case 19:
                return invoke$androidx$compose$material3$internal$TextFieldImplKt$$ExternalSyntheticLambda0(obj, obj2);
            case 20:
                return invoke$androidx$compose$runtime$GapComposerKt$$ExternalSyntheticLambda1(obj, obj2);
            case 21:
                return invoke$com$github$kr328$clash$FilesActivity$$ExternalSyntheticLambda5(obj, obj2);
            case 22:
                return invoke$com$github$kr328$clash$compose$LogsScreenKt$$ExternalSyntheticLambda3(obj, obj2);
            case 23:
                return invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$$ExternalSyntheticLambda30(obj, obj2);
            case 24:
                return invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$5$2$$ExternalSyntheticLambda1(obj, obj2);
            case 25:
                return invoke$com$github$kr328$clash$compose$profiles$ProfilesScreenKt$$ExternalSyntheticLambda5(obj, obj2);
            case 26:
                return invoke$com$github$kr328$clash$compose$proxy$ProxyScreenKt$$ExternalSyntheticLambda14(obj, obj2);
            case 27:
                return invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$$ExternalSyntheticLambda1(obj, obj2);
            default:
                JobKt.launch$default((CoroutineScope) obj5, null, new GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1((Animatable) obj4, ((Float) obj2).floatValue(), false ? 1 : 0, i42), 3);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(ComposableLambdaImpl composableLambdaImpl, Object obj, int i) {
        this.$r8$classId = i;
        this.f$1 = composableLambdaImpl;
        this.f$0 = obj;
    }

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(Object obj, Object obj2, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
