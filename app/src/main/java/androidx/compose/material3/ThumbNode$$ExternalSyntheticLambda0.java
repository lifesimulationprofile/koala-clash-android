package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil.disk.RealDiskCache;
import com.caverock.androidsvg.SVG;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(float f, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$2 = f;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006b A[PHI: r3
      0x006b: PHI (r3v7 float) = (r3v4 float), (r3v11 float) binds: [B:21:0x0080, B:14:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float fFloatValue;
        switch (this.$r8$classId) {
            case 0:
                Placeable placeable = (Placeable) this.f$0;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                Animatable animatable = ((ThumbNode) this.f$1).offsetAnim;
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (int) (animatable != null ? ((Number) animatable.getValue()).floatValue() : this.f$2), 0);
                return Unit.INSTANCE;
            case 1:
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) this.f$0;
                Function1 function1 = (Function1) this.f$1;
                long jLongValue = ((Long) obj).longValue();
                if (updatableAnimationState.lastFrameTime == Long.MIN_VALUE) {
                    updatableAnimationState.lastFrameTime = jLongValue;
                }
                float f = updatableAnimationState.value;
                AnimationVector1D animationVector1D = new AnimationVector1D(f);
                float f2 = this.f$2;
                AnimationVector1D animationVector1D2 = UpdatableAnimationState.ZeroVector;
                long durationNanos = f2 == 0.0f ? updatableAnimationState.vectorizedSpec.getDurationNanos(new AnimationVector1D(f), animationVector1D2, updatableAnimationState.lastVelocity) : MathKt.roundToLong((jLongValue - updatableAnimationState.lastFrameTime) / f2);
                float f3 = ((AnimationVector1D) updatableAnimationState.vectorizedSpec.getValueFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity)).value;
                updatableAnimationState.lastVelocity = (AnimationVector1D) updatableAnimationState.vectorizedSpec.getVelocityFromNanos(durationNanos, animationVector1D, animationVector1D2, updatableAnimationState.lastVelocity);
                updatableAnimationState.lastFrameTime = jLongValue;
                float f4 = updatableAnimationState.value - f3;
                updatableAnimationState.value = f3;
                function1.invoke(Float.valueOf(f4));
                return Unit.INSTANCE;
            case 2:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) this.f$0;
                LazyListScrollScopeKt$LazyLayoutScrollScope$1 lazyListScrollScopeKt$LazyLayoutScrollScope$1 = (LazyListScrollScopeKt$LazyLayoutScrollScope$1) this.f$1;
                AnimationScope animationScope = (AnimationScope) obj;
                float f5 = this.f$2;
                float f6 = 0.0f;
                if (f5 > 0.0f) {
                    fFloatValue = ((Number) animationScope.value$delegate.getValue()).floatValue();
                    if (fFloatValue <= f5) {
                        f5 = fFloatValue;
                    }
                    f6 = f5;
                } else if (f5 < 0.0f) {
                    fFloatValue = ((Number) animationScope.value$delegate.getValue()).floatValue();
                    if (fFloatValue >= f5) {
                        f5 = fFloatValue;
                    }
                    f6 = f5;
                }
                float f7 = f6 - ref$FloatRef.element;
                if (f7 != ((ScrollScope) lazyListScrollScopeKt$LazyLayoutScrollScope$1.$$delegate_0).scrollBy(f7) || f6 != ((Number) animationScope.value$delegate.getValue()).floatValue()) {
                    animationScope.cancelAnimation();
                }
                ref$FloatRef.element += f7;
                return Unit.INSTANCE;
            default:
                float f8 = this.f$2;
                AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) this.f$0;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                SVG svg = layoutNodeDrawScope.canvasDrawScope.drawContext;
                long jM795getSizeNHjbRc = svg.m795getSizeNHjbRc();
                svg.getCanvas().save();
                try {
                    RealDiskCache.RealEditor realEditor = (RealDiskCache.RealEditor) svg.rootElement;
                    realEditor.translate(f8, 0.0f);
                    realEditor.m785rotateUv8p0NA(45.0f, 0L);
                    Modifier.CC.m309drawImagegbVJVH8$default(layoutNodeDrawScope, androidImageBitmap, 0L, 0.0f, blendModeColorFilter, 0, 46);
                    return Unit.INSTANCE;
                } finally {
                    ImageAnalysis$$ExternalSyntheticLambda1.m(svg, jM795getSizeNHjbRc);
                }
        }
    }

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(UpdatableAnimationState updatableAnimationState, float f, Function1 function1) {
        this.$r8$classId = 1;
        this.f$0 = updatableAnimationState;
        this.f$2 = f;
        this.f$1 = function1;
    }

    public /* synthetic */ ThumbNode$$ExternalSyntheticLambda0(Placeable placeable, ThumbNode thumbNode, float f) {
        this.$r8$classId = 0;
        this.f$0 = placeable;
        this.f$1 = thumbNode;
        this.f$2 = f;
    }
}
