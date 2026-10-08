package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.AndroidCursorHandle_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.ProvidersScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.core.model.Proxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(long j, Object obj, Function2 function2, int i) {
        this.$r8$classId = i;
        this.f$0 = j;
        this.f$1 = obj;
        this.f$2 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) this.f$1;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$2;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    LayoutUtilKt.m280ProvideContentColorTextStyle3JVO9M(this.f$0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, Thread_jvmKt.rememberComposableLambda(417635459, new TextKt$$ExternalSyntheticLambda2(12, paddingValues, composableLambdaImpl), gapComposer), gapComposer, 384);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                AndroidCursorHandle_androidKt.m163CursorHandleUSBMPiE((OffsetProvider) this.f$1, (Modifier) this.f$2, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                TextStyle textStyle = (TextStyle) this.f$1;
                Function2 function2 = (Function2) this.f$2;
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    TextFieldImplKt.m282Decoration3JVO9M(this.f$0, textStyle, function2, gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 3:
                ((Integer) obj2).getClass();
                ProvidersScreenKt.ProviderRow((ProviderItemState) this.f$1, this.f$0, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                ProxyScreenKt.m813GroupIconXOJAsU((String) this.f$1, (Proxy.Type) this.f$2, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(ProviderItemState providerItemState, long j, Function0 function0, int i) {
        this.$r8$classId = 3;
        this.f$1 = providerItemState;
        this.f$0 = j;
        this.f$2 = function0;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda2(Object obj, Object obj2, long j, int i, int i2) {
        this.$r8$classId = i2;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = j;
    }
}
