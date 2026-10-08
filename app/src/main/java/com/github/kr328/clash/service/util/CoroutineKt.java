package com.github.kr328.clash.service.util;

import androidx.work.CoroutineWorker;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineKt {
    public static final void cancelAndJoinBlocking(CoroutineScope coroutineScope) {
        JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new CoroutineWorker.AnonymousClass1(coroutineScope, (Continuation) null, 24));
    }
}
