package com.github.kr328.clash;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PropertiesActivity$commit$1 extends ContinuationImpl {
    public PropertiesActivity L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PropertiesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertiesActivity$commit$1(PropertiesActivity propertiesActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = propertiesActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PropertiesActivity.access$commit(this.this$0, null, null, null, this);
    }
}
