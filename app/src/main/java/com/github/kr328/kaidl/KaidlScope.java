package com.github.kr328.kaidl;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class KaidlScope implements CoroutineScope {
    public static final KaidlScope INSTANCE = new KaidlScope();
    public final /* synthetic */ ContextScope $$delegate_0;

    public KaidlScope() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }
}
