package kotlinx.coroutines;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.util.Log;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import coil.RealImageLoader$execute$3;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0;
import com.github.kr328.clash.compose.connections.AppIconResolverKt;
import com.github.kr328.clash.compose.connections.ProcessAppInfo;
import com.github.kr328.clash.compose.qrcode.QrServerState;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.service.ClashService;
import com.github.kr328.clash.service.clash.module.ConfigurationModule;
import com.github.kr328.clash.service.clash.module.Module;
import com.github.kr328.clash.service.remote.IClashManager;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterruptibleKt$runInterruptible$2(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.L$0 = obj;
        this.$block = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2((Function0) this.$block, continuation, 0);
                interruptibleKt$runInterruptible$2.L$0 = obj;
                return interruptibleKt$runInterruptible$2;
            case 1:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$3 = new InterruptibleKt$runInterruptible$2((CursorAnimationState) this.$block, continuation, 1);
                interruptibleKt$runInterruptible$3.L$0 = obj;
                return interruptibleKt$runInterruptible$3;
            case 2:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$4 = new InterruptibleKt$runInterruptible$2((LifecycleCoroutineScopeImpl) this.$block, continuation, 2);
                interruptibleKt$runInterruptible$4.L$0 = obj;
                return interruptibleKt$runInterruptible$4;
            case 3:
                return new InterruptibleKt$runInterruptible$2((Callable) this.L$0, (CancellableContinuationImpl) this.$block, continuation, 3);
            case 4:
                return new InterruptibleKt$runInterruptible$2((Context) this.L$0, (String) this.$block, continuation, 4);
            case 5:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$5 = new InterruptibleKt$runInterruptible$2((String) this.$block, continuation, 5);
                interruptibleKt$runInterruptible$5.L$0 = obj;
                return interruptibleKt$runInterruptible$5;
            case 6:
                return new InterruptibleKt$runInterruptible$2((Function0) this.$block, (MutableState) this.L$0, continuation);
            case 7:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$6 = new InterruptibleKt$runInterruptible$2((TunnelState.Mode) this.$block, continuation, 7);
                interruptibleKt$runInterruptible$6.L$0 = obj;
                return interruptibleKt$runInterruptible$6;
            case 8:
                return new InterruptibleKt$runInterruptible$2((MutableState) this.L$0, (MutableState) this.$block, continuation, 8);
            case 9:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$7 = new InterruptibleKt$runInterruptible$2((ClashService) this.$block, continuation, 9);
                interruptibleKt$runInterruptible$7.L$0 = obj;
                return interruptibleKt$runInterruptible$7;
            case 10:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$8 = new InterruptibleKt$runInterruptible$2((Ref$BooleanRef) this.$block, continuation, 10);
                interruptibleKt$runInterruptible$8.L$0 = obj;
                return interruptibleKt$runInterruptible$8;
            case 11:
                return new InterruptibleKt$runInterruptible$2((Module) this.L$0, (String) this.$block, continuation, 11);
            default:
                return new InterruptibleKt$runInterruptible$2((Parcel) this.L$0, (Ref$ObjectRef) this.$block, continuation, 12);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((InterruptibleKt$runInterruptible$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((InterruptibleKt$runInterruptible$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                ((InterruptibleKt$runInterruptible$2) create((ConfigurationModule.LoadException) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.TRUE;
            case 10:
                return ((InterruptibleKt$runInterruptible$2) create((Intent) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i;
        boolean z;
        Object failure;
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = ((CoroutineScope) this.L$0).getCoroutineContext();
                Function0 function0 = (Function0) this.$block;
                try {
                    ThreadState threadState = new ThreadState();
                    threadState.cancelHandle = JobKt.invokeOnCompletion(JobKt.getJob(coroutineContext), true, threadState);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ThreadState._state$volatile$FU;
                    try {
                        do {
                            i = atomicIntegerFieldUpdater.get(threadState);
                            if (i != 0) {
                                if (i != 2 && i != 3) {
                                    ThreadState.invalidState(i);
                                    throw null;
                                }
                            }
                            return function0.invoke();
                        } while (!atomicIntegerFieldUpdater.compareAndSet(threadState, i, 0));
                        return function0.invoke();
                    } finally {
                        threadState.clearInterrupt();
                    }
                } catch (InterruptedException e) {
                    throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                CursorAnimationState cursorAnimationState = (CursorAnimationState) this.$block;
                Job job = (Job) cursorAnimationState.animationJob.getAndSet(null);
                AtomicReference atomicReference = cursorAnimationState.animationJob;
                StandaloneCoroutine standaloneCoroutineLaunch$default = JobKt.launch$default(coroutineScope, null, new RealImageLoader$execute$3(job, cursorAnimationState, null, 14), 3);
                while (!atomicReference.compareAndSet(null, standaloneCoroutineLaunch$default)) {
                    if (atomicReference.get() != null) {
                        z = false;
                        return Boolean.valueOf(z);
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            case 2:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) this.$block;
                Lifecycle lifecycle = lifecycleCoroutineScopeImpl.lifecycle;
                if (lifecycle.getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                    lifecycle.addObserver(lifecycleCoroutineScopeImpl);
                } else {
                    JobKt.cancel(coroutineScope2.getCoroutineContext(), (CancellationException) null);
                }
                return Unit.INSTANCE;
            case 3:
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.$block;
                ResultKt.throwOnFailure(obj);
                try {
                    cancellableContinuationImpl.resumeWith(((Callable) this.L$0).call());
                    break;
                } catch (Throwable th) {
                    cancellableContinuationImpl.resumeWith(new Result.Failure(th));
                }
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                Context context = (Context) this.L$0;
                String str = (String) this.$block;
                ConcurrentHashMap concurrentHashMap = AppIconResolverKt.appInfoCache;
                ProcessAppInfo processAppInfo = (ProcessAppInfo) concurrentHashMap.get(str);
                if (processAppInfo != null) {
                    return processAppInfo;
                }
                PackageManager packageManager = context.getPackageManager();
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                    String string = applicationInfo.loadLabel(packageManager).toString();
                    Drawable drawableLoadIcon = applicationInfo.loadIcon(packageManager);
                    if (Build.VERSION.SDK_INT >= 26 && BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m782m(drawableLoadIcon) && BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m(drawableLoadIcon).getBackground() == null) {
                        drawableLoadIcon = BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m(drawableLoadIcon).getForeground();
                    }
                    failure = new ProcessAppInfo(string, drawableLoadIcon);
                    break;
                } catch (Throwable th2) {
                    failure = new Result.Failure(th2);
                }
                if (Result.m835exceptionOrNullimpl(failure) != null) {
                    failure = new ProcessAppInfo(str, null);
                }
                ProcessAppInfo processAppInfo2 = (ProcessAppInfo) failure;
                concurrentHashMap.put(str, processAppInfo2);
                return processAppInfo2;
            case 5:
                ResultKt.throwOnFailure(obj);
                ((IClashManager) this.L$0).addClosedConnections((String) this.$block);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) ((MutableState) this.L$0).getValue()).booleanValue()) {
                    ((Function0) this.$block).invoke();
                }
                return Unit.INSTANCE;
            case 7:
                ResultKt.throwOnFailure(obj);
                ((IClashManager) this.L$0).patchOverrideMode((TunnelState.Mode) this.$block);
                return Unit.INSTANCE;
            case 8:
                ResultKt.throwOnFailure(obj);
                if (((String) ((MutableState) this.L$0).getValue()) != null) {
                    ((MutableState) this.$block).setValue(QrServerState.ProfileError);
                }
                return Unit.INSTANCE;
            case 9:
                ResultKt.throwOnFailure(obj);
                ((ClashService) this.$block).reason = ((ConfigurationModule.LoadException) this.L$0).message;
                return Boolean.TRUE;
            case 10:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.$block;
                ResultKt.throwOnFailure(obj);
                String action = ((Intent) this.L$0).getAction();
                if (action != null) {
                    int iHashCode = action.hashCode();
                    if (iHashCode != -2128145023) {
                        if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                            ref$BooleanRef.element = true;
                        }
                    } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                        ref$BooleanRef.element = false;
                    }
                }
                return Unit.INSTANCE;
            case 11:
                ResultKt.throwOnFailure(obj);
                Module module = (Module) this.L$0;
                ArrayList arrayList = module.receivers;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) obj2;
                    broadcastReceiver.onReceive(null, null);
                    module.service.unregisterReceiver(broadcastReceiver);
                }
                return new Integer(Log.d("KoalaClash", ((String) this.$block) + ": destroyed", null));
            default:
                ResultKt.throwOnFailure(obj);
                ((Parcel) this.L$0).recycle();
                ((Function0) ((Ref$ObjectRef) this.$block).element).invoke();
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterruptibleKt$runInterruptible$2(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$block = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterruptibleKt$runInterruptible$2(Function0 function0, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 6;
        this.$block = function0;
        this.L$0 = mutableState;
    }
}
