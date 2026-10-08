package coil.compose;

import androidx.compose.ui.unit.Constraints;
import coil.size.Dimension;
import coil.size.RealSizeResolver;
import coil.size.Size;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsSizeResolver$size$$inlined$mapNotNull$1 implements Flow {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class AnonymousClass1 extends ContinuationImpl {
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public /* synthetic */ AnonymousClass2(FlowCollector flowCollector, int i) {
            this.$r8$classId = i;
            this.$this_unsafeFlow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:9:0x0022  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1;
            int i = this.$r8$classId;
            Size size = null;
            Dimension pixels = Dimension.Undefined.INSTANCE;
            FlowCollector flowCollector = this.$this_unsafeFlow;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (i) {
                case 0:
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.label;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i2 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    int i3 = anonymousClass1.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        long j = ((Constraints) obj).value;
                        RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
                        int i4 = (int) (3 & j);
                        int i5 = (((i4 & 2) >> 1) * 3) + ((i4 & 1) << 1);
                        if (!(((((int) (j >> 33)) & ((1 << (i5 + 13)) - 1)) - 1 == 0) | ((((1 << (18 - i5)) - 1) & ((int) (j >> (i5 + 46)))) - 1 == 0))) {
                            Dimension pixels2 = Constraints.m677getHasBoundedWidthimpl(j) ? new Dimension.Pixels(Constraints.m681getMaxWidthimpl(j)) : pixels;
                            if (Constraints.m676getHasBoundedHeightimpl(j)) {
                                pixels = new Dimension.Pixels(Constraints.m680getMaxHeightimpl(j));
                            }
                            size = new Size(pixels2, pixels);
                        }
                        if (size != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(size, anonymousClass1) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                default:
                    if (continuation instanceof AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1) {
                        asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 = (AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1) continuation;
                        int i6 = asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1.label = i6 - Integer.MIN_VALUE;
                        } else {
                            asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 = new AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1(this, continuation);
                        }
                    } else {
                        asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 = new AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1(this, continuation);
                    }
                    Object obj3 = asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1.result;
                    int i7 = asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1.label;
                    if (i7 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        long j2 = ((androidx.compose.ui.geometry.Size) obj).packedValue;
                        if (j2 == 9205357640488583168L) {
                            size = Size.ORIGINAL;
                        } else {
                            RealSizeResolver realSizeResolver2 = UtilsKt.OriginalSizeResolver;
                            if (androidx.compose.ui.geometry.Size.m385getWidthimpl(j2) >= 0.5d && androidx.compose.ui.geometry.Size.m383getHeightimpl(j2) >= 0.5d) {
                                float fM385getWidthimpl = androidx.compose.ui.geometry.Size.m385getWidthimpl(j2);
                                Dimension pixels3 = (Float.isInfinite(fM385getWidthimpl) || Float.isNaN(fM385getWidthimpl)) ? pixels : new Dimension.Pixels(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m385getWidthimpl(j2)));
                                float fM383getHeightimpl = androidx.compose.ui.geometry.Size.m383getHeightimpl(j2);
                                if (!Float.isInfinite(fM383getHeightimpl) && !Float.isNaN(fM383getHeightimpl)) {
                                    pixels = new Dimension.Pixels(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m383getHeightimpl(j2)));
                                }
                                size = new Size(pixels3, pixels);
                            }
                        }
                        if (size != null) {
                            asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1.label = 1;
                            if (flowCollector.emit(size, asyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    } else {
                        if (i7 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj3);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    public /* synthetic */ ConstraintsSizeResolver$size$$inlined$mapNotNull$1(StateFlowImpl stateFlowImpl, int i) {
        this.$r8$classId = i;
        this.$this_unsafeTransform$inlined = stateFlowImpl;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Object objCollect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, 0), continuation);
                return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
            default:
                Object objCollect2 = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, 1), continuation);
                return objCollect2 == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect2 : Unit.INSTANCE;
        }
    }
}
