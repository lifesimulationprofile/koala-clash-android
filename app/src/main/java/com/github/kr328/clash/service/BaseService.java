package com.github.kr328.clash.service;

import android.app.Service;
import com.github.kr328.clash.service.util.CoroutineKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseService extends Service implements CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.CoroutineScope(Dispatchers.Default);

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineKt.cancelAndJoinBlocking(this);
    }
}
