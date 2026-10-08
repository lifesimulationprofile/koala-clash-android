package com.github.kr328.clash.compose.proxy;

import androidx.compose.material.icons.outlined.InboxKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.res.StringResources_androidKt;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.proxy.ComposableSingletons$ProxyScreenKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$ProxyScreenKt$lambda1$1 implements Function2 {
    public static final ComposableSingletons$ProxyScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$ProxyScreenKt$lambda1$1();

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            ProxyScreenKt.EmptyMessage(InboxKt.getInbox(), StringResources_androidKt.stringResource(R.string.proxy_empty_tips, gapComposer), gapComposer, 0);
        }
        return Unit.INSTANCE;
    }
}
