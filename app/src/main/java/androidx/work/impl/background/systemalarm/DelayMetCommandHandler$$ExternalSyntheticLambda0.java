package androidx.work.impl.background.systemalarm;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DelayMetCommandHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DelayMetCommandHandler f$0;

    public /* synthetic */ DelayMetCommandHandler$$ExternalSyntheticLambda0(DelayMetCommandHandler delayMetCommandHandler, int i) {
        this.$r8$classId = i;
        this.f$0 = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                DelayMetCommandHandler.m771$r8$lambda$82vXfMh9MXtNtLNgTa3KWbb4VE(this.f$0);
                break;
            default:
                DelayMetCommandHandler.m772$r8$lambda$r8ATJcovysxdAeSwS9XE6krknU(this.f$0);
                break;
        }
    }
}
