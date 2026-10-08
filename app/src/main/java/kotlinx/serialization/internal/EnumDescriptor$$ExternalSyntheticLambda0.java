package kotlinx.serialization.internal;

import androidx.compose.material.icons.filled.DomainKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EnumDescriptor$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ EnumDescriptor$$ExternalSyntheticLambda0(int i, String str, EnumDescriptor enumDescriptor) {
        this.$r8$classId = 0;
        this.f$0 = i;
        this.f$1 = str;
        this.f$2 = enumDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.f$1;
                EnumDescriptor enumDescriptor = (EnumDescriptor) this.f$2;
                int i = this.f$0;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i];
                for (int i2 = 0; i2 < i; i2++) {
                    serialDescriptorArr[i2] = DomainKt.buildSerialDescriptor$default(str + '.' + enumDescriptor.names[i2], StructureKind.MAP.INSTANCE$3, new SerialDescriptor[0]);
                }
                return serialDescriptorArr;
            case 1:
                SnapshotStateMap snapshotStateMap = (SnapshotStateMap) this.f$1;
                SnapshotStateMap snapshotStateMap2 = (SnapshotStateMap) this.f$2;
                int i3 = this.f$0;
                return new Pair(snapshotStateMap.get(Integer.valueOf(i3)), snapshotStateMap2.get(Integer.valueOf(i3)));
            default:
                SnapshotStateMap snapshotStateMap3 = (SnapshotStateMap) this.f$1;
                SnapshotStateMap snapshotStateMap4 = (SnapshotStateMap) this.f$2;
                int i4 = this.f$0;
                return new Pair(snapshotStateMap3.get(Integer.valueOf(i4)), snapshotStateMap4.get(Integer.valueOf(i4)));
        }
    }

    public /* synthetic */ EnumDescriptor$$ExternalSyntheticLambda0(SnapshotStateMap snapshotStateMap, int i, SnapshotStateMap snapshotStateMap2, int i2) {
        this.$r8$classId = i2;
        this.f$1 = snapshotStateMap;
        this.f$0 = i;
        this.f$2 = snapshotStateMap2;
    }
}
