package com.github.kr328.clash.service.clash.module;

import android.os.Build;
import java.net.InetSocketAddress;
import kotlin.Result;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TunModule$attach$2 extends FunctionReferenceImpl implements Function3 {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object failure;
        int iIntValue = ((Number) obj).intValue();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj2;
        InetSocketAddress inetSocketAddress2 = (InetSocketAddress) obj3;
        TunModule tunModule = (TunModule) this.receiver;
        tunModule.getClass();
        int iIntValue2 = -1;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                failure = Integer.valueOf(tunModule.connectivity.getConnectionOwnerUid(iIntValue, inetSocketAddress, inetSocketAddress2));
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (Result.m835exceptionOrNullimpl(failure) != null) {
                failure = -1;
            }
            iIntValue2 = ((Number) failure).intValue();
        }
        return Integer.valueOf(iIntValue2);
    }
}
