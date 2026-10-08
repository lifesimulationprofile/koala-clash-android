package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HeightInLinesNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HeightInLinesNode f$0;

    public /* synthetic */ HeightInLinesNode$$ExternalSyntheticLambda0(HeightInLinesNode heightInLinesNode, int i) {
        this.$r8$classId = i;
        this.f$0 = heightInLinesNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                if (this.f$0.fontResolutionState != null) {
                    return Unit.INSTANCE;
                }
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Font resolution state is not set.");
                throw new HttpException();
            default:
                if (this.f$0.fontResolutionState != null) {
                    return Unit.INSTANCE;
                }
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Font resolution state is not set.");
                throw new HttpException();
        }
    }
}
