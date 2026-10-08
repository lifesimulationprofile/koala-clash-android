package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import okhttp3.internal.concurrent.Task;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Connection$pushResetLater$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushResetLater$$inlined$execute$default$1(String str, Http2Connection http2Connection, int i, int i2) {
        super(str, true);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
    }

    private final long runOnce$okhttp3$internal$http2$Http2Connection$pushHeadersLater$$inlined$execute$default$1() {
        this.this$0.pushObserver.getClass();
        try {
            this.this$0.writer.rstStream(this.$streamId$inlined, 9);
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }

    private final long runOnce$okhttp3$internal$http2$Http2Connection$pushResetLater$$inlined$execute$default$1() {
        this.this$0.pushObserver.getClass();
        synchronized (this.this$0) {
            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            Unit unit = Unit.INSTANCE;
        }
        return -1L;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        switch (this.$r8$classId) {
            case 0:
                return runOnce$okhttp3$internal$http2$Http2Connection$pushResetLater$$inlined$execute$default$1();
            case 1:
                return runOnce$okhttp3$internal$http2$Http2Connection$pushHeadersLater$$inlined$execute$default$1();
            default:
                this.this$0.pushObserver.getClass();
                try {
                    this.this$0.writer.rstStream(this.$streamId$inlined, 9);
                    synchronized (this.this$0) {
                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushResetLater$$inlined$execute$default$1(String str, Http2Connection http2Connection, int i, List list) {
        super(str, true);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushResetLater$$inlined$execute$default$1(String str, Http2Connection http2Connection, int i, List list, boolean z) {
        super(str, true);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
    }
}
