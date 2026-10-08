package androidx.work;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.app.ActivityRecreator;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.emoji2.text.MetadataListReader;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.internal.mlkit_vision_common.zzat;
import com.google.android.gms.tasks.zzt;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0;
import okhttp3.Dispatcher;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoroutineWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CoroutineWorker$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    private final void run$androidx$work$impl$workers$ConstraintTrackingWorker$$ExternalSyntheticLambda0() {
        ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f$0;
        if (constraintTrackingWorker.future.value instanceof AbstractFuture.Cancellation) {
            return;
        }
        Object obj = constraintTrackingWorker.mWorkerParams.mInputData.mValues.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        String str = obj instanceof String ? (String) obj : null;
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        if (str == null || str.length() == 0) {
            logger$LogcatLogger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            constraintTrackingWorker.future.set(new ListenableWorker.Result.Failure());
            return;
        }
        WorkerFactory$1 workerFactory$1 = constraintTrackingWorker.mWorkerParams.mWorkerFactory;
        Context context = constraintTrackingWorker.mAppContext;
        WorkerParameters workerParameters = constraintTrackingWorker.workerParameters;
        workerFactory$1.getClass();
        ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = WorkerFactory$1.createWorkerWithDefaultFallback(context, str, workerParameters);
        constraintTrackingWorker.delegate = listenableWorkerCreateWorkerWithDefaultFallback;
        if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
            logger$LogcatLogger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
            constraintTrackingWorker.future.set(new ListenableWorker.Result.Failure());
            return;
        }
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(constraintTrackingWorker.mAppContext);
        WorkSpec workSpec = instance$1.mWorkDatabase.workSpecDao().getWorkSpec(constraintTrackingWorker.mWorkerParams.mId.toString());
        if (workSpec == null) {
            SettableFuture settableFuture = constraintTrackingWorker.future;
            String str2 = ConstraintTrackingWorkerKt.TAG;
            settableFuture.set(new ListenableWorker.Result.Failure());
            return;
        }
        EmptyStrongMemoryCache emptyStrongMemoryCache = new EmptyStrongMemoryCache(instance$1.mTrackers);
        int i = 3;
        constraintTrackingWorker.future.addListener(new CoroutineWorker$$ExternalSyntheticLambda0(6, WorkConstraintsTrackerKt.listen(emptyStrongMemoryCache, workSpec, instance$1.mWorkTaskExecutor.mTaskDispatcher, constraintTrackingWorker)), new zzt(3));
        if (!emptyStrongMemoryCache.areAllConstraintsMet(workSpec)) {
            logger$LogcatLogger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + str + ". Requesting retry.");
            constraintTrackingWorker.future.set(new ListenableWorker.Result.Retry());
            return;
        }
        logger$LogcatLogger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate ".concat(str));
        try {
            SettableFuture settableFutureStartWork = constraintTrackingWorker.delegate.startWork();
            settableFutureStartWork.addListener(new HandlerContext$$ExternalSyntheticLambda0(i, constraintTrackingWorker, settableFutureStartWork), constraintTrackingWorker.mWorkerParams.mBackgroundExecutor);
        } catch (Throwable th) {
            String str3 = ConstraintTrackingWorkerKt.TAG;
            String strM$1 = ImageAnalysis$$ExternalSyntheticLambda1.m$1("Delegated worker ", str, " threw exception in startWork.");
            if (logger$LogcatLogger.mLoggingLevel <= 3) {
                Log.d(str3, strM$1, th);
            }
            synchronized (constraintTrackingWorker.lock) {
                try {
                    if (!constraintTrackingWorker.areConstraintsUnmet) {
                        constraintTrackingWorker.future.set(new ListenableWorker.Result.Failure());
                    } else {
                        logger$LogcatLogger.debug(str3, "Constraints were unmet, Retrying.");
                        constraintTrackingWorker.future.set(new ListenableWorker.Result.Retry());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.$r8$classId) {
            case 0:
                CoroutineWorker coroutineWorker = (CoroutineWorker) this.f$0;
                if (coroutineWorker.future.value instanceof AbstractFuture.Cancellation) {
                    coroutineWorker.job.cancel((CancellationException) null);
                    return;
                }
                return;
            case 1:
                Activity activity = (Activity) this.f$0;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = ActivityRecreator.mainHandler;
                Method method = ActivityRecreator.requestRelaunchActivityMethod;
                int i = Build.VERSION.SDK_INT;
                if (i >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i != 26 && i != 27) || method != null) && (ActivityRecreator.performStopActivity2ParamsMethod != null || ActivityRecreator.performStopActivity3ParamsMethod != null)) {
                    try {
                        Object obj2 = ActivityRecreator.tokenField.get(activity);
                        if (obj2 != null && (obj = ActivityRecreator.mainThreadField.get(activity)) != null) {
                            Application application = activity.getApplication();
                            ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(activity);
                            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                            handler.post(new Worker.AnonymousClass2(3, lifecycleCheckCallbacks, obj2));
                            int i2 = 4;
                            try {
                                if (i == 26 || i == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new Worker.AnonymousClass2(i2, application, lifecycleCheckCallbacks));
                                return;
                            } catch (Throwable th) {
                                handler.post(new Worker.AnonymousClass2(i2, application, lifecycleCheckCallbacks));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 2:
                View view = (View) this.f$0;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 3:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    try {
                        if (fontRequestMetadataLoader.mCallback == null) {
                            return;
                        }
                        try {
                            FontsContractCompat$FontInfo fontsContractCompat$FontInfoRetrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                            int i3 = fontsContractCompat$FontInfoRetrieveFontInfo.mResultCode;
                            if (i3 == 2) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                }
                            }
                            if (i3 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i3 + ")");
                            }
                            try {
                                int i4 = TraceCompat.$r8$clinit;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                ByteString.Companion companion = fontRequestMetadataLoader.mFontProviderHelper;
                                Context context = fontRequestMetadataLoader.mContext;
                                companion.getClass();
                                FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = {fontsContractCompat$FontInfoRetrieveFontInfo};
                                TypefaceCompatBaseImpl typefaceCompatBaseImpl = TypefaceCompat.sTypefaceCompatImpl;
                                androidx.tracing.Trace.beginSection("TypefaceCompat.createFromFontInfo");
                                try {
                                    Typeface typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferMmap = TypefaceCompatUtil.mmap(fontRequestMetadataLoader.mContext, fontsContractCompat$FontInfoRetrieveFontInfo.mUri);
                                    if (mappedByteBufferMmap == null || typefaceCreateFromFontInfo == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        Dispatcher dispatcher = new Dispatcher(typefaceCreateFromFontInfo, MetadataListReader.read(mappedByteBufferMmap));
                                        Trace.endSection();
                                        Trace.endSection();
                                        synchronized (fontRequestMetadataLoader.mLock) {
                                            try {
                                                zzat zzatVar = fontRequestMetadataLoader.mCallback;
                                                if (zzatVar != null) {
                                                    zzatVar.onLoaded(dispatcher);
                                                }
                                            } catch (Throwable th2) {
                                                throw th2;
                                            }
                                            break;
                                        }
                                        fontRequestMetadataLoader.cleanUp();
                                        return;
                                    } catch (Throwable th3) {
                                        int i5 = TraceCompat.$r8$clinit;
                                        Trace.endSection();
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    Trace.endSection();
                                    throw th4;
                                }
                            } catch (Throwable th5) {
                                int i6 = TraceCompat.$r8$clinit;
                                Trace.endSection();
                                throw th5;
                            }
                            break;
                        } catch (Throwable th6) {
                            synchronized (fontRequestMetadataLoader.mLock) {
                                try {
                                    zzat zzatVar2 = fontRequestMetadataLoader.mCallback;
                                    if (zzatVar2 != null) {
                                        zzatVar2.onFailed(th6);
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                } catch (Throwable th7) {
                                    throw th7;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        throw th8;
                    }
                }
            case 4:
                ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) this.f$0;
                LifecycleRegistry lifecycleRegistry = processLifecycleOwner.registry;
                if (processLifecycleOwner.resumedCounter == 0) {
                    processLifecycleOwner.pauseSent = true;
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                }
                if (processLifecycleOwner.startedCounter == 0 && processLifecycleOwner.pauseSent) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner.stopSent = true;
                    return;
                }
                return;
            case 5:
                run$androidx$work$impl$workers$ConstraintTrackingWorker$$ExternalSyntheticLambda0();
                return;
            default:
                ((JobImpl) this.f$0).cancel((CancellationException) null);
                return;
        }
    }
}
