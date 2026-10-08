package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewSpec {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final SpringSpec DefaultScrollAnimationSpec = ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);
        public static final BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1 DefaultBringIntoViewSpec = new BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1(1);
    }

    float calculateScrollDistance(float f, float f2, float f3);

    SpringSpec getScrollAnimationSpec();
}
