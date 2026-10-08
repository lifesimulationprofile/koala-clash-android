package androidx.compose.ui.window;

import androidx.compose.ui.unit.LayoutDirection;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.EnqueueRunnable;
import coil.request.RequestService;
import java.util.Collections;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDialog_androidKt$Dialog$2$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $dialog;
    public final /* synthetic */ Object $layoutDirection;
    public final /* synthetic */ Object $onDismissRequest;
    public final /* synthetic */ Object $properties;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidDialog_androidKt$Dialog$2$1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        super(0);
        this.$r8$classId = i;
        this.$dialog = obj;
        this.$onDismissRequest = obj2;
        this.$properties = obj3;
        this.$layoutDirection = obj4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                ((DialogWrapper) this.$dialog).updateParameters((Function0) this.$onDismissRequest, (DialogProperties) this.$properties, (LayoutDirection) this.$layoutDirection);
                break;
            default:
                new EnqueueRunnable(new WorkContinuationImpl((WorkManagerImpl) this.$onDismissRequest, (String) this.$properties, 2, Collections.singletonList((WorkRequest) this.$dialog), 0), (RequestService) this.$layoutDirection).run();
                break;
        }
        return Unit.INSTANCE;
    }
}
