package com.github.kr328.clash.compose.newprofile;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.google.android.gms.internal.mlkit_vision_common.zzjm;
import com.google.android.gms.internal.mlkit_vision_common.zzjs;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NewProfileSheetKt$$ExternalSyntheticLambda11 implements Function2 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ NewProfileSheetKt$$ExternalSyntheticLambda11(int i, Modifier modifier, String str, Function0 function0, boolean z) {
        this.f$1 = str;
        this.f$2 = z;
        this.f$3 = function0;
        this.f$0 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                zzjm.TrailingIconButton((ImageVector) this.f$0, (String) this.f$1, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(3073);
                ConnectionsScreenKt.ConnectionDetailSheet((ConnectionInfo) this.f$0, this.f$2, this.f$3, (Function0) this.f$1, (GapComposer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                zzjs.SegmentedPill((String) this.f$1, this.f$2, this.f$3, (Modifier) this.f$0, (GapComposer) obj, iUpdateChangedFlags3);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ NewProfileSheetKt$$ExternalSyntheticLambda11(ImageVector imageVector, String str, boolean z, Function0 function0, int i) {
        this.f$0 = imageVector;
        this.f$1 = str;
        this.f$2 = z;
        this.f$3 = function0;
    }

    public /* synthetic */ NewProfileSheetKt$$ExternalSyntheticLambda11(ConnectionInfo connectionInfo, boolean z, Function0 function0, Function0 function1, int i) {
        this.f$0 = connectionInfo;
        this.f$2 = z;
        this.f$3 = function0;
        this.f$1 = function1;
    }
}
