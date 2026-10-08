package com.github.kr328.clash.compose.proxy;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySelectorSheetKt$ProxySelectorSheet$swallowSheetSwipe$1$1 implements NestedScrollConnection {
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo96onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return new Velocity(VelocityKt.Velocity(0.0f, Velocity.m732getYimpl(j2)));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo97onPostScrollDzOQY0M(long j, long j2, int i) {
        return (4294967295L & ((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L))))) | (Float.floatToRawIntBits(0.0f) << 32);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public final Object mo98onPreFlingQWom1Mo(long j, Continuation continuation) {
        return new Velocity(0L);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final /* synthetic */ long mo99onPreScrollOzD1aCk(int i, long j) {
        return 0L;
    }
}
