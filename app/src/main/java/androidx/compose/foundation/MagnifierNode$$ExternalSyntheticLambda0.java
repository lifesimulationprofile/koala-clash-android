package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MagnifierNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MagnifierNode f$0;

    public /* synthetic */ MagnifierNode$$ExternalSyntheticLambda0(MagnifierNode magnifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = magnifierNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.updateMagnifier();
                return Unit.INSTANCE;
            case 1:
                return new Offset(this.f$0.sourceCenterInRoot);
            default:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.f$0.layoutCoordinates$delegate.getValue();
                return new Offset(layoutCoordinates != null ? layoutCoordinates.mo523localToRootMKHz9U(0L) : 9205357640488583168L);
        }
    }
}
