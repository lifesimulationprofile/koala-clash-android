package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GapComposer$derivedStateObserver$1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ GapComposer$derivedStateObserver$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    public final void done() {
        switch (this.$r8$classId) {
            case 0:
                ((GapComposer) this.this$0).childrenComposing--;
                break;
            default:
                ((SnapshotStateObserver.ObservedScopeMap) this.this$0).deriveStateScopeCount--;
                break;
        }
    }

    public final void start() {
        switch (this.$r8$classId) {
            case 0:
                ((GapComposer) this.this$0).childrenComposing++;
                break;
            default:
                ((SnapshotStateObserver.ObservedScopeMap) this.this$0).deriveStateScopeCount++;
                break;
        }
    }
}
