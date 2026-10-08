package kotlinx.coroutines;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ChildHandleNode extends JobNode implements ChildHandle {
    public final ChildJob childJob;

    public ChildHandleNode(ChildJob childJob) {
        this.childJob = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean childCancelled(Throwable th) {
        return getJob().childCancelled(th);
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        ((JobSupport) this.childJob).cancelImpl$kotlinx_coroutines_core(getJob());
    }
}
