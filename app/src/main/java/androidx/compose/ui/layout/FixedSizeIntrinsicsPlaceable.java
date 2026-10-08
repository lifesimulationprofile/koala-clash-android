package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public final /* synthetic */ int $r8$classId;

    public FixedSizeIntrinsicsPlaceable(int i, int i2, int i3) {
        this.$r8$classId = i3;
        switch (i3) {
            case 1:
                m532setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
            case 2:
                m532setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
            default:
                m532setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        switch (this.$r8$classId) {
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public final void mo519placeAtf8xVGno(long j, float f, Function1 function1) {
        int i = this.$r8$classId;
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$layout$FixedSizeIntrinsicsPlaceable, reason: not valid java name */
    private final void m516xf00bb1d6(long j, float f, Function1 function1) {
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$layout$MeasuringIntrinsics$EmptyPlaceable, reason: not valid java name */
    private final void m517xa65dbe67(long j, float f, Function1 function1) {
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$node$NodeMeasuringIntrinsics$EmptyPlaceable, reason: not valid java name */
    private final void m518x3c56d5b1(long j, float f, Function1 function1) {
    }
}
