package com.github.kr328.clash.compose.connections;

import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.connections.ComposableSingletons$ConnectionsScreenKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$ConnectionsScreenKt$lambda1$1 implements Function3 {
    public static final ComposableSingletons$ConnectionsScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$ConnectionsScreenKt$lambda1$1();

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        GapComposer gapComposer = (GapComposer) obj2;
        int iIntValue = ((Number) obj3).intValue();
        if ((iIntValue & 6) == 0) {
            iIntValue |= gapComposer.changed(lazyItemScopeImpl) ? 4 : 2;
        }
        if ((iIntValue & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            ConnectionsScreenKt.EmptyState(LazyItemScope$CC.fillParentMaxSize$default(lazyItemScopeImpl), gapComposer, 0);
        }
        return Unit.INSTANCE;
    }
}
