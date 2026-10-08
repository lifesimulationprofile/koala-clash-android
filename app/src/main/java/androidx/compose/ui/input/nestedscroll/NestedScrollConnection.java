package androidx.compose.ui.input.nestedscroll;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    Object mo96onPostFlingRZ2iAVY(long j, long j2, Continuation continuation);

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    long mo97onPostScrollDzOQY0M(long j, long j2, int i);

    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    Object mo98onPreFlingQWom1Mo(long j, Continuation continuation);

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    long mo99onPreScrollOzD1aCk(int i, long j);
}
