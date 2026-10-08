package com.github.kr328.clash.util;

import android.content.ContentResolver;
import android.net.Uri;
import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentKt {
    public static final Object copyContentTo(ContentResolver contentResolver, Uri uri, Uri uri2, SuspendLambda suspendLambda) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = JobKt.withContext(DefaultIoScheduler.INSTANCE, new LogcatActivity$writeLogTo$2$1(contentResolver, uri, uri2, null, 9), suspendLambda);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }
}
