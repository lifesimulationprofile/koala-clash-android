package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface TextDragObserver {
    void onCancel();

    /* JADX INFO: renamed from: onDown-k-4lQ0M, reason: not valid java name */
    void mo172onDownk4lQ0M();

    /* JADX INFO: renamed from: onDrag-k-4lQ0M, reason: not valid java name */
    void mo173onDragk4lQ0M(long j);

    /* JADX INFO: renamed from: onStart-3MmeM6k, reason: not valid java name */
    void mo174onStart3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0);

    void onStop();

    void onUp();
}
