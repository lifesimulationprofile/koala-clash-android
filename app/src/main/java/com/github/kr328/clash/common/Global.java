package com.github.kr328.clash.common;

import android.app.Application;
import com.github.kr328.clash.MainApplication;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Global implements CoroutineScope {
    public static final Global INSTANCE = new Global();
    public static MainApplication application_;
    public final /* synthetic */ ContextScope $$delegate_0;

    public Global() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
    }

    public static Application getApplication$1() {
        MainApplication mainApplication = application_;
        if (mainApplication != null) {
            return mainApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("application_");
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }
}
