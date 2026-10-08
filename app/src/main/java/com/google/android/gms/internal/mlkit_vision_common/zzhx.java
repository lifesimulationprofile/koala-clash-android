package com.google.android.gms.internal.mlkit_vision_common;

import androidx.work.impl.utils.futures.AbstractFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzhx {
    public abstract boolean casListeners(AbstractFuture abstractFuture, AbstractFuture.Listener listener, AbstractFuture.Listener listener2);

    public abstract boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

    public abstract void putNext(AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

    public abstract void putThread(AbstractFuture.Waiter waiter, Thread thread);
}
