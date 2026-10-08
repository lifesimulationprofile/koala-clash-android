package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.material3.internal.ripple.RippleNodeConfig;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Drag$Opacity;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$InsetRing;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$Opacity;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Hover$Opacity;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.work.CoroutineWorker;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.model.WorkSpec;
import coil.RealImageLoader$execute$3;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsd;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbNode$onAttach$1$1 implements FlowCollector {
    public final /* synthetic */ Object $pressCount;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ ThumbNode$onAttach$1$1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.$pressCount = obj;
        this.this$0 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0081  */
    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 flowKt__ReduceKt$first$$inlined$collectWhile$2$1;
        ThumbNode$onAttach$1$1 thumbNode$onAttach$1$1;
        Object obj2 = obj;
        int i = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj3 = this.this$0;
        Object obj4 = this.$pressCount;
        switch (i) {
            case 0:
                Interaction interaction = (Interaction) obj2;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj4;
                if (interaction instanceof PressInteraction.Press) {
                    ref$IntRef.element++;
                } else if ((interaction instanceof PressInteraction.Release) || (interaction instanceof PressInteraction.Cancel)) {
                    ref$IntRef.element--;
                }
                boolean z = ref$IntRef.element > 0;
                ThumbNode thumbNode = (ThumbNode) obj3;
                if (thumbNode.isPressed != z) {
                    thumbNode.isPressed = z;
                    HitTestResultKt.invalidateMeasurement(thumbNode);
                }
                return Unit.INSTANCE;
            case 1:
                long j = ((Offset) obj2).packedValue;
                Animatable animatable = (Animatable) obj4;
                if ((((Offset) animatable.getValue()).packedValue & 9223372034707292159L) == 9205357640488583168L || (j & 9223372034707292159L) == 9205357640488583168L || Float.intBitsToFloat((int) (((Offset) animatable.getValue()).packedValue & 4294967295L)) == Float.intBitsToFloat((int) (j & 4294967295L))) {
                    Object objSnapTo = animatable.snapTo(new Offset(j), continuation);
                    return objSnapTo == coroutineSingletons ? objSnapTo : Unit.INSTANCE;
                }
                JobKt.launch$default((CoroutineScope) obj3, null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1$2$1(animatable, j, (Continuation) null), 3);
                return Unit.INSTANCE;
            case 2:
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                Interaction interaction2 = (Interaction) obj2;
                AndroidRippleNode androidRippleNode = (AndroidRippleNode) obj4;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = androidRippleNode.isFocused$delegate;
                if (interaction2 instanceof PressInteraction) {
                    if (androidRippleNode.hasValidSize) {
                        androidRippleNode.handlePressInteraction((PressInteraction) interaction2);
                    } else {
                        androidRippleNode.pendingInteractions.add(interaction2);
                    }
                }
                boolean zBooleanValue = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue();
                ArrayList arrayList = androidRippleNode.interactions;
                if (interaction2 instanceof HoverInteraction$Enter) {
                    arrayList.add(interaction2);
                } else if (interaction2 instanceof HoverInteraction$Exit) {
                    arrayList.remove(((HoverInteraction$Exit) interaction2).enter);
                } else if (interaction2 instanceof FocusInteraction$Focus) {
                    arrayList.add(interaction2);
                    parcelableSnapshotMutableState.setValue(Boolean.TRUE);
                    Unit unit = Unit.INSTANCE;
                } else if (interaction2 instanceof FocusInteraction$Unfocus) {
                    arrayList.remove(((FocusInteraction$Unfocus) interaction2).focus);
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                        } else if (!(((Interaction) arrayList.get(i2)) instanceof FocusInteraction$Focus)) {
                            i2++;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else if (interaction2 instanceof DragInteraction$Start) {
                    arrayList.add(interaction2);
                } else if (interaction2 instanceof DragInteraction$Stop) {
                    arrayList.remove(((DragInteraction$Stop) interaction2).start);
                } else {
                    if (!(interaction2 instanceof DragInteraction$Cancel)) {
                        return Unit.INSTANCE;
                    }
                    arrayList.remove(((DragInteraction$Cancel) interaction2).start);
                }
                Interaction interaction3 = (Interaction) CollectionsKt.lastOrNull(arrayList);
                RippleNodeConfig rippleNodeConfig = (RippleNodeConfig) androidRippleNode.rippleNodeConfig.invoke();
                zzsd zzsdVar = rippleNodeConfig.focus;
                if (!Intrinsics.areEqual(androidRippleNode.currentInteraction, interaction3)) {
                    Continuation continuation2 = null;
                    if (interaction3 != null) {
                        boolean z2 = interaction3 instanceof HoverInteraction$Enter;
                        float f = 0.0f;
                        if (z2) {
                            if (rippleNodeConfig.hover instanceof RippleNodeConfig$Hover$Opacity) {
                                f = 0.08f;
                            }
                        } else if (interaction3 instanceof FocusInteraction$Focus) {
                            if (zzsdVar instanceof RippleNodeConfig$Focus$Opacity) {
                                f = 0.1f;
                            }
                        } else if ((interaction3 instanceof DragInteraction$Start) && (rippleNodeConfig.drag instanceof RippleNodeConfig$Drag$Opacity)) {
                            f = 0.16f;
                        }
                        TweenSpec tweenSpec = androidx.compose.material3.internal.ripple.RippleKt.DefaultTweenSpec;
                        if (!z2 && ((interaction3 instanceof FocusInteraction$Focus) || (interaction3 instanceof DragInteraction$Start))) {
                            tweenSpec = new TweenSpec(45, 0, EasingKt.LinearEasing);
                        }
                        JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$29$1.AnonymousClass1.C00031(androidRippleNode, f, tweenSpec, (Continuation) null), 3);
                    } else {
                        Interaction interaction4 = androidRippleNode.currentInteraction;
                        TweenSpec tweenSpec2 = androidx.compose.material3.internal.ripple.RippleKt.DefaultTweenSpec;
                        if (!(interaction4 instanceof HoverInteraction$Enter) && !(interaction4 instanceof FocusInteraction$Focus) && (interaction4 instanceof DragInteraction$Start)) {
                            tweenSpec2 = new TweenSpec(150, 0, EasingKt.LinearEasing);
                        }
                        JobKt.launch$default(coroutineScope, null, new RealImageLoader$execute$3(androidRippleNode, tweenSpec2, continuation2, 20), 3);
                    }
                    if (!(zzsdVar instanceof RippleNodeConfig$Focus$InsetRing)) {
                        JobKt.launch$default(coroutineScope, null, new CoroutineWorker.AnonymousClass1(androidRippleNode, continuation2, 13), 3);
                    } else if (zBooleanValue != ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                        JobKt.launch$default(coroutineScope, null, new SnackbarHostKt$animatedScale$1$1(androidRippleNode, interaction3 instanceof FocusInteraction$Focus, rippleNodeConfig, continuation2, 1), 3);
                    }
                    androidRippleNode.currentInteraction = interaction3;
                }
                return Unit.INSTANCE;
            case 3:
                ((OnConstraintsStateChangedListener) obj4).onConstraintsStateChanged((WorkSpec) obj3, (ConstraintsState) obj2);
                return Unit.INSTANCE;
            case 4:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj4;
                if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
                    distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
                    int i3 = distinctFlowImpl$collect$2$emit$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        distinctFlowImpl$collect$2$emit$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
                    }
                } else {
                    distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
                }
                Object obj5 = distinctFlowImpl$collect$2$emit$1.result;
                int i4 = distinctFlowImpl$collect$2$emit$1.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    Object obj6 = ref$ObjectRef.element;
                    if (obj6 == ChannelFlowKt.NULL || !Intrinsics.areEqual(obj6, obj2)) {
                        ref$ObjectRef.element = obj2;
                        distinctFlowImpl$collect$2$emit$1.label = 1;
                        if (((FlowCollector) obj3).emit(obj2, distinctFlowImpl$collect$2$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj5);
                }
                return Unit.INSTANCE;
            default:
                if (continuation instanceof FlowKt__ReduceKt$first$$inlined$collectWhile$2$1) {
                    flowKt__ReduceKt$first$$inlined$collectWhile$2$1 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2$1) continuation;
                    int i5 = flowKt__ReduceKt$first$$inlined$collectWhile$2$1.label;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        flowKt__ReduceKt$first$$inlined$collectWhile$2$1.label = i5 - Integer.MIN_VALUE;
                    } else {
                        flowKt__ReduceKt$first$$inlined$collectWhile$2$1 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2$1(this, continuation);
                    }
                } else {
                    flowKt__ReduceKt$first$$inlined$collectWhile$2$1 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2$1(this, continuation);
                }
                Object objInvoke = flowKt__ReduceKt$first$$inlined$collectWhile$2$1.result;
                int i6 = flowKt__ReduceKt$first$$inlined$collectWhile$2$1.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(objInvoke);
                    flowKt__ReduceKt$first$$inlined$collectWhile$2$1.L$0 = this;
                    flowKt__ReduceKt$first$$inlined$collectWhile$2$1.L$1 = obj2;
                    flowKt__ReduceKt$first$$inlined$collectWhile$2$1.label = 1;
                    objInvoke = ((Function2) obj4).invoke(obj2, flowKt__ReduceKt$first$$inlined$collectWhile$2$1);
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    thumbNode$onAttach$1$1 = this;
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = flowKt__ReduceKt$first$$inlined$collectWhile$2$1.L$1;
                    thumbNode$onAttach$1$1 = flowKt__ReduceKt$first$$inlined$collectWhile$2$1.L$0;
                    ResultKt.throwOnFailure(objInvoke);
                }
                if (!((Boolean) objInvoke).booleanValue()) {
                    return Unit.INSTANCE;
                }
                ((Ref$ObjectRef) thumbNode$onAttach$1$1.this$0).element = obj2;
                throw new AbortFlowException(thumbNode$onAttach$1$1);
        }
    }

    public ThumbNode$onAttach$1$1(DistinctFlowImpl distinctFlowImpl, Ref$ObjectRef ref$ObjectRef, FlowCollector flowCollector) {
        this.$r8$classId = 4;
        this.$pressCount = ref$ObjectRef;
        this.this$0 = flowCollector;
    }
}
