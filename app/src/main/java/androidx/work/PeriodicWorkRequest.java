package androidx.work;

import androidx.work.impl.model.WorkSpec;
import java.util.LinkedHashSet;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Builder extends WorkRequest.Builder {
        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest buildInternal$work_runtime_release() {
            if (this.backoffCriteriaSet && ((WorkSpec) this.workSpec).constraints.requiresDeviceIdle) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            WorkSpec workSpec = (WorkSpec) this.workSpec;
            if (workSpec.expedited) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new PeriodicWorkRequest((UUID) this.id, workSpec, (LinkedHashSet) this.tags);
        }

        @Override // androidx.work.WorkRequest.Builder
        public final WorkRequest.Builder getThisObject$work_runtime_release() {
            return this;
        }
    }
}
