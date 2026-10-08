package androidx.compose.foundation.text.selection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface MouseSelectionObserver {
    /* JADX INFO: renamed from: onDrag-3MmeM6k */
    boolean mo205onDrag3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0);

    void onDragDone();

    /* JADX INFO: renamed from: onExtend-k-4lQ0M */
    boolean mo206onExtendk4lQ0M(long j);

    /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
    boolean mo207onExtendDragk4lQ0M(long j);

    /* JADX INFO: renamed from: onStart-9KIMszo */
    boolean mo208onStart9KIMszo(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, int i);
}
