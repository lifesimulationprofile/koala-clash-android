package com.github.kr328.clash.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.util.BroadcastKt;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileUpdateWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileUpdateWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ProfileUpdateWorker L$0;
        public UUID L$1;
        public Context L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileUpdateWorker.this.doWork(this);
        }
    }

    public ProfileUpdateWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0107  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:63:0x0119  */
    /* JADX WARN: Code duplicated, block: B:66:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    public final Object doWork(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object failure;
        UUID uuid;
        Context context;
        ProfileUpdateWorker profileUpdateWorker;
        UUID uuid2;
        ProfileUpdateWorker profileUpdateWorker2;
        String message;
        String message2;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.mWorkerParams.mInputData.mValues.get("uuid");
                String str = obj2 instanceof String ? (String) obj2 : null;
                if (str != null) {
                    try {
                        failure = UUID.fromString(str);
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    if (failure instanceof Result.Failure) {
                        failure = null;
                    }
                    UUID uuid3 = (UUID) failure;
                    if (uuid3 != null) {
                        Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = uuid3;
                        Context context2 = this.mAppContext;
                        anonymousClass1.L$2 = context2;
                        anonymousClass1.label = 1;
                        Object objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid3, anonymousClass1);
                        if (objQueryByUUID != coroutineSingletons) {
                            uuid = uuid3;
                            obj = objQueryByUUID;
                            context = context2;
                            profileUpdateWorker = this;
                        }
                        return coroutineSingletons;
                    }
                }
                return new ListenableWorker.Result.Failure();
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                context = anonymousClass1.L$2;
                uuid2 = anonymousClass1.L$1;
                profileUpdateWorker2 = anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    BroadcastKt.sendBroadcastSelf(context, new Intent(Intents.ACTION_PROFILE_UPDATE_COMPLETED).putExtra("uuid", uuid2.toString()));
                    ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
                    ProfileProcessor.scheduleLogoFetch(context, uuid2);
                    return new ListenableWorker.Result.Success(Data.EMPTY);
                } catch (HwidLimitException e) {
                    e = e;
                    message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = "HWID_LIMIT";
                    }
                    BroadcastKt.sendProfileUpdateFailed(context, uuid2, message2);
                    return new ListenableWorker.Result.Success(Data.EMPTY);
                } catch (Exception e2) {
                    e = e2;
                    Log.w("KoalaClash", "Profile auto update failed for " + uuid2 + ": " + e.getMessage(), null);
                    message = e.getMessage();
                    if (message == null) {
                        message = "Unknown";
                    }
                    BroadcastKt.sendProfileUpdateFailed(context, uuid2, message);
                    return profileUpdateWorker2.mWorkerParams.mRunAttemptCount < 3 ? new ListenableWorker.Result.Retry() : new ListenableWorker.Result.Success(Data.EMPTY);
                }
            }
            context = anonymousClass1.L$2;
            uuid = anonymousClass1.L$1;
            profileUpdateWorker = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            Imported imported = (Imported) obj;
            if (imported == null || imported.type == Profile.Type.File) {
                int i3 = ProfileAutoUpdate.$r8$clinit;
                WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
                CancelWorkRunnable.AnonymousClass3 anonymousClass3 = new CancelWorkRunnable.AnonymousClass3(instance$1, "profile-auto-update:" + uuid, true);
                WorkManagerTaskExecutor workManagerTaskExecutor = instance$1.mWorkTaskExecutor;
                workManagerTaskExecutor.executeOnTaskThread(anonymousClass3);
                workManagerTaskExecutor.executeOnTaskThread(new CancelWorkRunnable.AnonymousClass3(instance$1, "profile-update-now:" + uuid, true));
                return new ListenableWorker.Result.Success(Data.EMPTY);
            }
            try {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                FilesActivity$showError$1 filesActivity$showError$1 = new FilesActivity$showError$1(context, uuid, continuation, 17);
                anonymousClass1.L$0 = profileUpdateWorker;
                anonymousClass1.L$1 = uuid;
                anonymousClass1.L$2 = context;
                anonymousClass1.label = 2;
                if (JobKt.withContext(defaultIoScheduler, filesActivity$showError$1, anonymousClass1) != coroutineSingletons) {
                    uuid2 = uuid;
                    profileUpdateWorker2 = profileUpdateWorker;
                    BroadcastKt.sendBroadcastSelf(context, new Intent(Intents.ACTION_PROFILE_UPDATE_COMPLETED).putExtra("uuid", uuid2.toString()));
                    ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
                    ProfileProcessor.scheduleLogoFetch(context, uuid2);
                    return new ListenableWorker.Result.Success(Data.EMPTY);
                }
                return coroutineSingletons;
            } catch (HwidLimitException e3) {
                e = e3;
                uuid2 = uuid;
                message2 = e.getMessage();
                if (message2 == null) {
                    message2 = "HWID_LIMIT";
                }
                BroadcastKt.sendProfileUpdateFailed(context, uuid2, message2);
                return new ListenableWorker.Result.Success(Data.EMPTY);
            } catch (Exception e4) {
                e = e4;
                uuid2 = uuid;
                profileUpdateWorker2 = profileUpdateWorker;
                Log.w("KoalaClash", "Profile auto update failed for " + uuid2 + ": " + e.getMessage(), null);
                message = e.getMessage();
                if (message == null) {
                    message = "Unknown";
                }
                BroadcastKt.sendProfileUpdateFailed(context, uuid2, message);
                if (profileUpdateWorker2.mWorkerParams.mRunAttemptCount < 3) {
                }
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }
}
