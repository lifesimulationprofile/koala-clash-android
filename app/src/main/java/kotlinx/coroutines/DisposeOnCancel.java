package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposeOnCancel implements CancelHandler {
    public final /* synthetic */ int $r8$classId;
    public final Object handle;

    public /* synthetic */ DisposeOnCancel(int i, Object obj) {
        this.$r8$classId = i;
        this.handle = obj;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void invoke(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                ((DisposableHandle) this.handle).dispose();
                break;
            case 1:
                ((ScheduledFuture) this.handle).cancel(false);
                break;
            default:
                ((Function1) this.handle).invoke(th);
                break;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "DisposeOnCancel[" + ((DisposableHandle) this.handle) + ']';
            case 1:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.handle) + ']';
            default:
                return "CancelHandler.UserSupplied[" + ((Function1) this.handle).getClass().getSimpleName() + '@' + JobKt.getHexAddress(this) + ']';
        }
    }
}
