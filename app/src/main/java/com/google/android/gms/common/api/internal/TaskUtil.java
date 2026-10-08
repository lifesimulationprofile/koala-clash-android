package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TaskUtil {
    public static void trySetResultOrApiException(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (status.zzb <= 0) {
            taskCompletionSource.zza.zze(obj);
        } else {
            taskCompletionSource.trySetException(status.zzd != null ? new ResolvableApiException(status) : new ApiException(status));
        }
    }
}
