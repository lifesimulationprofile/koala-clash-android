package com.github.kr328.clash.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.github.kr328.clash.design.compose.components.LiquidGlassNavItem;
import com.google.android.gms.internal.mlkit_vision_common.zzkd;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PropertiesScreenKt$$ExternalSyntheticLambda17 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Function0 f$4;

    public /* synthetic */ PropertiesScreenKt$$ExternalSyntheticLambda17(ImageVector imageVector, String str, String str2, boolean z, Function0 function0, int i) {
        this.f$0 = imageVector;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = z;
        this.f$4 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                PropertiesScreenKt.NavigationRow((ImageVector) this.f$0, (String) this.f$1, (String) this.f$2, this.f$3, this.f$4, (GapComposer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                zzkd.LiquidGlassNavCell((LiquidGlassNavItem) this.f$0, this.f$3, this.f$4, (Function3) this.f$1, (Modifier) this.f$2, (GapComposer) obj, iUpdateChangedFlags2);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ PropertiesScreenKt$$ExternalSyntheticLambda17(LiquidGlassNavItem liquidGlassNavItem, boolean z, Function0 function0, Function3 function3, Modifier modifier, int i) {
        this.f$0 = liquidGlassNavItem;
        this.f$3 = z;
        this.f$4 = function0;
        this.f$1 = function3;
        this.f$2 = modifier;
    }
}
