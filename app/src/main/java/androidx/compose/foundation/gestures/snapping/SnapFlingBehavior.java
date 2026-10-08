package androidx.compose.foundation.gestures.snapping;

import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import com.caverock.androidsvg.SVG;
import com.google.mlkit.common.internal.zzd;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    public final AnimationSpec snapAnimationSpec;
    public final SVG snapLayoutInfoProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Function1 L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00121 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00121(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, 0.0f, null, this);
        }
    }

    public SnapFlingBehavior(SVG svg, AnimationSpec animationSpec) {
        this.snapLayoutInfoProvider = svg;
        this.snapAnimationSpec = animationSpec;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object access$tryApproach(SnapFlingBehavior snapFlingBehavior, ScrollScope scrollScope, float f, float f2, SnapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0 snapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0, ContinuationImpl continuationImpl) {
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$1;
        ApproachAnimation anonymousClass1;
        if (continuationImpl instanceof SnapFlingBehavior$tryApproach$1) {
            snapFlingBehavior$tryApproach$1 = (SnapFlingBehavior$tryApproach$1) continuationImpl;
            int i = snapFlingBehavior$tryApproach$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$tryApproach$1.label = i - Integer.MIN_VALUE;
            } else {
                snapFlingBehavior$tryApproach$1 = new SnapFlingBehavior$tryApproach$1(snapFlingBehavior, continuationImpl);
            }
        } else {
            snapFlingBehavior$tryApproach$1 = new SnapFlingBehavior$tryApproach$1(snapFlingBehavior, continuationImpl);
        }
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$2 = snapFlingBehavior$tryApproach$1;
        Object objApproachAnimation = snapFlingBehavior$tryApproach$2.result;
        int i2 = snapFlingBehavior$tryApproach$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objApproachAnimation);
            if (Math.abs(f) == 0.0f || Math.abs(f2) == 0.0f) {
                return ArcSplineKt.AnimationState$default(f, f2, 28);
            }
            snapFlingBehavior$tryApproach$2.label = 1;
            if (Math.abs(ArcSplineKt.calculateTargetValue(ScrollableKt.NoOpDecayAnimationSpec, 0.0f, f2)) >= Math.abs(f)) {
                anonymousClass1 = new zzd();
            } else {
                anonymousClass1 = new PreviewView.AnonymousClass1(24, snapFlingBehavior.snapAnimationSpec);
            }
            objApproachAnimation = anonymousClass1.approachAnimation(scrollScope, new Float(f), new Float(f2), snapFlingBehavior$fling$result$1$$ExternalSyntheticLambda0, snapFlingBehavior$tryApproach$2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objApproachAnimation == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objApproachAnimation);
        }
        return ((AnimationResult) objApproachAnimation).currentAnimationState;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
        if (!Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec)) {
            return false;
        }
        Object obj2 = ScrollableKt.NoOpDecayAnimationSpec;
        return obj2.equals(obj2) && snapFlingBehavior.snapLayoutInfoProvider.equals(this.snapLayoutInfoProvider);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(ScrollScope scrollScope, float f, Function1 function1, ContinuationImpl continuationImpl) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Function1 function2;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            ScrollableKt$DefaultScrollMotionDurationScale$1 scrollableKt$DefaultScrollMotionDurationScale$1 = ScrollableKt.DefaultScrollMotionDurationScale;
            DefaultFlingBehavior.AnonymousClass2 anonymousClass2 = new DefaultFlingBehavior.AnonymousClass2(this, f, function1, scrollScope, (Continuation) null);
            anonymousClass1.L$0 = function1;
            anonymousClass1.label = 1;
            objWithContext = JobKt.withContext(scrollableKt$DefaultScrollMotionDurationScale$1, anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
            function2 = function1;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        AnimationResult animationResult = (AnimationResult) objWithContext;
        function2.invoke(new Float(0.0f));
        return animationResult;
    }

    public final int hashCode() {
        return this.snapLayoutInfoProvider.hashCode() + ((ScrollableKt.NoOpDecayAnimationSpec.hashCode() + (this.snapAnimationSpec.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollScope scrollScope, float f, Continuation continuation) {
        return performFling(scrollScope, f, ScrollableKt.NoOnReport, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performFling(ScrollScope scrollScope, float f, BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3, ContinuationImpl continuationImpl) throws Throwable {
        C00121 c00121;
        if (continuationImpl instanceof C00121) {
            c00121 = (C00121) continuationImpl;
            int i = c00121.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00121.label = i - Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuationImpl);
            }
        } else {
            c00121 = new C00121(continuationImpl);
        }
        Object objFling = c00121.result;
        int i2 = c00121.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFling);
            c00121.label = 1;
            objFling = fling(scrollScope, f, basicTextKt$$ExternalSyntheticLambda3, c00121);
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFling == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        return new Float(animationResult.remainingOffset.floatValue() != 0.0f ? ((Number) animationResult.currentAnimationState.getVelocity()).floatValue() : 0.0f);
    }
}
