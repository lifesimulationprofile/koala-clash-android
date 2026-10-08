package com.github.kr328.clash;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlActivity$reloadApps$1 extends ContinuationImpl {
    public AccessControlActivity L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AccessControlActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessControlActivity$reloadApps$1(AccessControlActivity accessControlActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = accessControlActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AccessControlActivity.access$reloadApps(this.this$0, this);
    }
}
