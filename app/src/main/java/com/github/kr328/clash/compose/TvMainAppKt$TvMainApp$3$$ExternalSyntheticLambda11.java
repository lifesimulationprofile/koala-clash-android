package com.github.kr328.clash.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda11 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$0;

    public /* synthetic */ TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda11(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, int i) {
        this.$r8$classId = i;
        this.f$0 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$0;
        switch (i) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                float f = TvMainAppKt.TvOverscanHorizontal;
                parcelableSnapshotMutableIntState.setIntValue(iIntValue);
                break;
            default:
                parcelableSnapshotMutableIntState.setIntValue((int) (((IntSize) obj).packedValue & 4294967295L));
                break;
        }
        return Unit.INSTANCE;
    }
}
