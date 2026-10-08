package com.github.kr328.clash;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatorMutex$mutateWith$2;
import androidx.compose.material3.BottomSheetKt$BottomSheet$4$1$1;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Recomposer$join$2;
import coil.network.HttpException;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1;
import com.github.kr328.clash.compose.home.HomeViewModel;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel$importFromFile$1$uuid$1;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel$refreshProfiles$1$invokeSuspend$$inlined$sortedBy$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.qrserver.QrProfileServer;
import com.github.kr328.clash.service.HwidLimitException;
import com.github.kr328.clash.service.ProfileAutoUpdate;
import com.github.kr328.clash.service.ProfileManager;
import com.github.kr328.clash.service.ProfileProcessor;
import com.github.kr328.clash.service.RemoteService;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.clash.module.Module;
import com.github.kr328.clash.service.clash.module.NetworkObserveModule;
import com.github.kr328.clash.service.clash.module.TunModule;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManager;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.util.RemoteKt;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeSourceNode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FilesActivity$showError$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public Object $throwable;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$showError$1(AccessControlActivity accessControlActivity, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 1;
        this.this$0 = accessControlActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FilesActivity$showError$1((FilesActivity) this.this$0, (Throwable) this.$throwable, continuation, 0);
            case 1:
                return new FilesActivity$showError$1((AccessControlActivity) this.this$0, continuation);
            case 2:
                return new FilesActivity$showError$1((AccessControlActivity) this.$throwable, continuation, 2);
            case 3:
                return new FilesActivity$showError$1((LogcatActivity) this.this$0, (LogFile) this.$throwable, continuation, 3);
            case 4:
                FilesActivity$showError$1 filesActivity$showError$1 = new FilesActivity$showError$1((MainActivity) this.$throwable, continuation, 4);
                filesActivity$showError$1.this$0 = obj;
                return filesActivity$showError$1;
            case 5:
                FilesActivity$showError$1 filesActivity$showError$2 = new FilesActivity$showError$1((Provider) this.$throwable, continuation, 5);
                filesActivity$showError$2.this$0 = obj;
                return filesActivity$showError$2;
            case 6:
                FilesActivity$showError$1 filesActivity$showError$3 = new FilesActivity$showError$1((ShareToTvActivity) this.$throwable, continuation, 6);
                filesActivity$showError$3.this$0 = obj;
                return filesActivity$showError$3;
            case 7:
                return new FilesActivity$showError$1((Profile) this.this$0, (ShareToTvActivity) this.$throwable, continuation, 7);
            case 8:
                FilesActivity$showError$1 filesActivity$showError$4 = new FilesActivity$showError$1((ConnectionInfo) this.$throwable, continuation, 8);
                filesActivity$showError$4.this$0 = obj;
                return filesActivity$showError$4;
            case 9:
                FilesActivity$showError$1 filesActivity$showError$5 = new FilesActivity$showError$1((HomeViewModel) this.$throwable, continuation, 9);
                filesActivity$showError$5.this$0 = obj;
                return filesActivity$showError$5;
            case 10:
                return new FilesActivity$showError$1((NewProfileViewModel) this.this$0, (Uri) this.$throwable, continuation, 10);
            case 11:
                FilesActivity$showError$1 filesActivity$showError$6 = new FilesActivity$showError$1((ProfilesViewModel) this.$throwable, continuation, 11);
                filesActivity$showError$6.this$0 = obj;
                return filesActivity$showError$6;
            case 12:
                return new FilesActivity$showError$1((TunnelState.Mode) this.this$0, (ProxyViewModel) this.$throwable, continuation, 12);
            case 13:
                return new FilesActivity$showError$1((MutableState) this.$throwable, continuation, 13);
            case 14:
                return new FilesActivity$showError$1((QrProfileServer) this.this$0, (byte[]) this.$throwable, continuation, 14);
            case 15:
                return new FilesActivity$showError$1((QrProfileServer) this.this$0, (String) this.$throwable, continuation, 15);
            case 16:
                return new FilesActivity$showError$1((ProfileManager) this.this$0, (UUID) this.$throwable, continuation, 16);
            case 17:
                return new FilesActivity$showError$1((Context) this.this$0, (UUID) this.$throwable, continuation, 17);
            case 18:
                return new FilesActivity$showError$1((TunModule) this.this$0, (TunService) this.$throwable, continuation, 18);
            case 19:
                return new FilesActivity$showError$1((ArrayList) this.this$0, (Module) this.$throwable, continuation, 19);
            case 20:
                FilesActivity$showError$1 filesActivity$showError$7 = new FilesActivity$showError$1((NetworkObserveModule) this.$throwable, continuation, 20);
                filesActivity$showError$7.this$0 = obj;
                return filesActivity$showError$7;
            case 21:
                return new FilesActivity$showError$1((Function2) this.this$0, (IClashManager) this.$throwable, continuation, 21);
            case 22:
                return new FilesActivity$showError$1((Function2) this.this$0, (IProfileManager) this.$throwable, continuation, 22);
            case 23:
                return new FilesActivity$showError$1((ComponentActivity) this.this$0, (HazeSourceNode) this.$throwable, continuation, 23);
            case 24:
                FilesActivity$showError$1 filesActivity$showError$8 = new FilesActivity$showError$1((ChannelFlow) this.$throwable, continuation, 24);
                filesActivity$showError$8.this$0 = obj;
                return filesActivity$showError$8;
            case 25:
                FilesActivity$showError$1 filesActivity$showError$9 = new FilesActivity$showError$1((ChannelFlowOperator) this.$throwable, continuation, 25);
                filesActivity$showError$9.this$0 = obj;
                return filesActivity$showError$9;
            default:
                FilesActivity$showError$1 filesActivity$showError$10 = new FilesActivity$showError$1((FlowCollector) this.$throwable, continuation, 26);
                filesActivity$showError$10.this$0 = obj;
                return filesActivity$showError$10;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((FilesActivity$showError$1) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 15:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 16:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 17:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 18:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 19:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 20:
                return ((FilesActivity$showError$1) create((Network) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 21:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 22:
                return ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 23:
                ((FilesActivity$showError$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 24:
                return ((FilesActivity$showError$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 25:
                return ((FilesActivity$showError$1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((FilesActivity$showError$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.github.kr328.clash.AccessControlActivity$finish$1$2, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objWithContext;
        AccessControlActivity accessControlActivity;
        Object value;
        Object failure;
        Object objWithProfile$default;
        Object failure2;
        Object objWithProfile$default2;
        Object objWithContext2;
        Object failure3;
        Object objWithProfile$default3;
        Object objWithProfile$default4;
        Object failure4;
        Object objWithProfile$default5;
        MutableState mutableState;
        Object objWithContext3;
        int i = this.$r8$classId;
        EmptyList emptyList = EmptyList.INSTANCE;
        int i2 = 4;
        int i3 = 0;
        int i4 = 2;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i5 = 1;
        switch (i) {
            case 0:
                Throwable th = (Throwable) this.$throwable;
                int i6 = this.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    SnackbarHostState snackbarHostState = ((FilesActivity) this.this$0).snackbarHostState;
                    String message = th.getMessage();
                    if (message == null) {
                        message = th.getClass().getSimpleName();
                    }
                    this.label = 1;
                    if (GlassSnackbarKt.showGlassSnackbar$default(snackbarHostState, message, 2, this, 28) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                AccessControlActivity accessControlActivity2 = (AccessControlActivity) this.this$0;
                int i7 = this.label;
                int accessControlActivity$finish$1$2 = 3;
                try {
                    if (i7 != 0) {
                        if (i7 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i7 != 2) {
                                if (i7 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Throwable th2 = (Throwable) this.$throwable;
                                ResultKt.throwOnFailure(obj);
                                throw th2;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    NonCancellable nonCancellable = NonCancellable.INSTANCE;
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    CoroutineContext coroutineContextPlus = CoroutineContext.DefaultImpls.plus(nonCancellable, DefaultIoScheduler.INSTANCE);
                    AccessControlActivity$finish$1$1 accessControlActivity$finish$1$1 = new AccessControlActivity$finish$1$1(accessControlActivity2, z2 ? 1 : 0, i3);
                    this.label = 1;
                    if (JobKt.withContext(coroutineContextPlus, accessControlActivity$finish$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
                    accessControlActivity$finish$1$2 = new AccessControlActivity$finish$1$2(accessControlActivity2, z3 ? 1 : 0, i3);
                    this.label = 2;
                    if (JobKt.withContext(nonCancellable2, accessControlActivity$finish$1$2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    NonCancellable nonCancellable3 = NonCancellable.INSTANCE;
                    AccessControlActivity$finish$1$2 accessControlActivity$finish$1$3 = new AccessControlActivity$finish$1$2(accessControlActivity2, z ? 1 : 0, i3);
                    this.$throwable = th3;
                    this.label = accessControlActivity$finish$1$2;
                    if (JobKt.withContext(nonCancellable3, accessControlActivity$finish$1$3, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    throw th3;
                }
            case 2:
                AccessControlActivity accessControlActivity3 = (AccessControlActivity) this.$throwable;
                int i8 = this.label;
                if (i8 != 0) {
                    if (i8 == 1) {
                        AccessControlActivity accessControlActivity4 = (AccessControlActivity) this.this$0;
                        ResultKt.throwOnFailure(obj);
                        accessControlActivity = accessControlActivity4;
                        objWithContext = obj;
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                AccessControlActivity$finish$1$2 accessControlActivity$finish$1$4 = new AccessControlActivity$finish$1$2(accessControlActivity3, z4 ? 1 : 0, i5);
                this.this$0 = accessControlActivity3;
                this.label = 1;
                objWithContext = JobKt.withContext(defaultIoScheduler, accessControlActivity$finish$1$4, this);
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
                accessControlActivity = accessControlActivity3;
                accessControlActivity.selected = (Set) objWithContext;
                StateFlowImpl stateFlowImpl = accessControlActivity3.selectionVersion;
                do {
                    value = stateFlowImpl.getValue();
                } while (!stateFlowImpl.compareAndSet(value, new Integer(((Number) value).intValue() + 1)));
                this.this$0 = null;
                this.label = 2;
                if (AccessControlActivity.access$reloadApps(accessControlActivity3, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.INSTANCE;
            case 3:
                LogcatActivity logcatActivity = (LogcatActivity) this.this$0;
                int i9 = this.label;
                if (i9 == 0) {
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                    LogcatActivity$LocalLogContent$1$1$1 logcatActivity$LocalLogContent$1$1$1 = new LogcatActivity$LocalLogContent$1$1$1(logcatActivity, (LogFile) this.$throwable, z5 ? 1 : 0, i5);
                    this.label = 1;
                    if (JobKt.withContext(defaultIoScheduler2, logcatActivity$LocalLogContent$1$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                logcatActivity.finish();
                return Unit.INSTANCE;
            case 4:
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$1 = new ShareToTvActivity$onCreate$1$list$1$1(i4, z6 ? 1 : 0, i4);
                        this.label = 1;
                        objWithProfile$default = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$1, this);
                        if (objWithProfile$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithProfile$default = obj;
                    }
                    failure = (List) objWithProfile$default;
                    break;
                } catch (Throwable th4) {
                    failure = new Result.Failure(th4);
                }
                List list = (List) (failure instanceof Result.Failure ? null : failure);
                if (list == null) {
                    return Unit.INSTANCE;
                }
                int i11 = ProfileAutoUpdate.$r8$clinit;
                ProfileAutoUpdate.sync(((MainActivity) this.$throwable).getApplicationContext(), list);
                return Unit.INSTANCE;
            case 5:
                int i12 = this.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IClashManager iClashManager = (IClashManager) this.this$0;
                    Provider provider = (Provider) this.$throwable;
                    Provider.Type type = provider.type;
                    String str = provider.name;
                    this.label = 1;
                    if (iClashManager.updateProvider(type, str, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 6:
                ShareToTvActivity shareToTvActivity = (ShareToTvActivity) this.$throwable;
                int i13 = this.label;
                try {
                    if (i13 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$2 = new ShareToTvActivity$onCreate$1$list$1$1(i4, z7 ? 1 : 0, i3);
                        this.label = 1;
                        objWithProfile$default2 = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$2, this);
                        if (objWithProfile$default2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i13 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithProfile$default2 = obj;
                    }
                    failure2 = (List) objWithProfile$default2;
                    break;
                } catch (Throwable th5) {
                    failure2 = new Result.Failure(th5);
                }
                Object obj2 = emptyList;
                if (!(failure2 instanceof Result.Failure)) {
                    obj2 = failure2;
                }
                StateFlowImpl stateFlowImpl2 = shareToTvActivity.profiles;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : (List) obj2) {
                    Profile profile = (Profile) obj3;
                    int iOrdinal = profile.type.ordinal();
                    if (iOrdinal == 0 || (iOrdinal == 1 && !StringsKt.isBlank(profile.source))) {
                        arrayList.add(obj3);
                    }
                }
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, arrayList);
                StateFlowImpl stateFlowImpl3 = shareToTvActivity.loaded;
                Boolean bool = Boolean.TRUE;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, bool);
                return Unit.INSTANCE;
            case 7:
                Profile profile2 = (Profile) this.this$0;
                ShareToTvActivity shareToTvActivity2 = (ShareToTvActivity) this.$throwable;
                int i14 = this.label;
                if (i14 == 0) {
                    ResultKt.throwOnFailure(obj);
                    int iOrdinal2 = profile2.type.ordinal();
                    if (iOrdinal2 == 0) {
                        DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler3 = DefaultIoScheduler.INSTANCE;
                        LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(shareToTvActivity2, profile2, z8 ? 1 : 0, i2);
                        this.label = 1;
                        objWithContext2 = JobKt.withContext(defaultIoScheduler3, logcatActivity$writeLogTo$2$1, this);
                        if (objWithContext2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else if (iOrdinal2 != 1) {
                        shareToTvActivity2.finish();
                    } else {
                        shareToTvActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ImageAnalysis$$ExternalSyntheticLambda1.m(shareToTvActivity2.callbackUrl, "?url=", URLEncoder.encode(profile2.source, "UTF-8")))));
                        shareToTvActivity2.finish();
                    }
                    return Unit.INSTANCE;
                }
                if (i14 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objWithContext2 = obj;
                String str2 = (String) objWithContext2;
                if (str2 == null || StringsKt.isBlank(str2)) {
                    Toast.makeText(shareToTvActivity2, R.string.share_to_tv_file_not_found, 0).show();
                    return Unit.INSTANCE;
                }
                shareToTvActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ImageAnalysis$$ExternalSyntheticLambda1.m(shareToTvActivity2.callbackUrl, "?mode=file#", URLEncoder.encode(str2, "UTF-8")))));
                shareToTvActivity2.finish();
                return Unit.INSTANCE;
            case 8:
                int i15 = this.label;
                try {
                    if (i15 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1 = new ConnectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1((ConnectionInfo) this.$throwable, z9 ? 1 : 0, i3);
                        this.label = 1;
                        if (RemoteKt.withClash$default(connectionsScreenKt$ConnectionsScreen$6$1$1$1$1$1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i15 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            case 9:
                HomeViewModel homeViewModel = (HomeViewModel) this.$throwable;
                int i16 = this.label;
                try {
                    if (i16 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$3 = new ShareToTvActivity$onCreate$1$list$1$1(i4, z10 ? 1 : 0, i2);
                        this.label = 1;
                        objWithProfile$default3 = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$3, this);
                        if (objWithProfile$default3 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i16 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithProfile$default3 = obj;
                    }
                    failure3 = (Profile) objWithProfile$default3;
                    break;
                } catch (Throwable th6) {
                    failure3 = new Result.Failure(th6);
                }
                boolean z14 = failure3 instanceof Result.Failure;
                Object obj4 = failure3;
                if (z14) {
                    obj4 = null;
                }
                homeViewModel._activeProfile.setValue((Profile) obj4);
                StateFlowImpl stateFlowImpl4 = homeViewModel._loaded;
                Boolean bool2 = Boolean.TRUE;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, bool2);
                return Unit.INSTANCE;
            case 10:
                NewProfileViewModel newProfileViewModel = (NewProfileViewModel) this.this$0;
                StateFlowImpl stateFlowImpl5 = newProfileViewModel._error;
                StateFlowImpl stateFlowImpl6 = newProfileViewModel._isLoading;
                int i17 = this.label;
                Continuation continuation = null;
                try {
                    if (i17 != 0) {
                        if (i17 == 1) {
                            ResultKt.throwOnFailure(obj);
                            objWithProfile$default4 = obj;
                        } else {
                            if (i17 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        StateFlowImpl stateFlowImpl7 = newProfileViewModel._completed;
                        Boolean bool3 = Boolean.TRUE;
                        stateFlowImpl7.getClass();
                        stateFlowImpl7.updateState(null, bool3);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    Boolean bool4 = Boolean.TRUE;
                    stateFlowImpl6.getClass();
                    stateFlowImpl6.updateState(null, bool4);
                    stateFlowImpl5.setValue(null);
                    NewProfileViewModel$importFromFile$1$uuid$1 newProfileViewModel$importFromFile$1$uuid$1 = new NewProfileViewModel$importFromFile$1$uuid$1(newProfileViewModel.app.getString(R.string.new_profile), continuation, i3);
                    this.label = 1;
                    objWithProfile$default4 = RemoteKt.withProfile$default(newProfileViewModel$importFromFile$1$uuid$1, this);
                    if (objWithProfile$default4 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    UUID uuid = (UUID) objWithProfile$default4;
                    DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler4 = DefaultIoScheduler.INSTANCE;
                    LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$2 = new LogcatActivity$writeLogTo$2$1(newProfileViewModel, uuid, (Uri) this.$throwable, continuation, 6);
                    this.label = 2;
                    if (JobKt.withContext(defaultIoScheduler4, logcatActivity$writeLogTo$2$2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    StateFlowImpl stateFlowImpl8 = newProfileViewModel._completed;
                    Boolean bool5 = Boolean.TRUE;
                    stateFlowImpl8.getClass();
                    stateFlowImpl8.updateState(null, bool5);
                    break;
                } catch (Exception e) {
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    stateFlowImpl5.getClass();
                    stateFlowImpl5.updateState(null, message2);
                } finally {
                    Boolean bool6 = Boolean.FALSE;
                    stateFlowImpl6.getClass();
                    stateFlowImpl6.updateState(null, bool6);
                }
                return Unit.INSTANCE;
            case 11:
                ProfilesViewModel profilesViewModel = (ProfilesViewModel) this.$throwable;
                int i18 = this.label;
                try {
                    if (i18 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$4 = new ShareToTvActivity$onCreate$1$list$1$1(i4, z11 ? 1 : 0, 5);
                        this.label = 1;
                        objWithProfile$default5 = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$4, this);
                        if (objWithProfile$default5 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i18 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithProfile$default5 = obj;
                    }
                    failure4 = (List) objWithProfile$default5;
                    break;
                } catch (Throwable th7) {
                    failure4 = new Result.Failure(th7);
                }
                Object obj5 = emptyList;
                if (!(failure4 instanceof Result.Failure)) {
                    obj5 = failure4;
                }
                List list2 = (List) obj5;
                StateFlowImpl stateFlowImpl9 = profilesViewModel._profiles;
                List listSortedWith = CollectionsKt.sortedWith(list2, new ProfilesViewModel$refreshProfiles$1$invokeSuspend$$inlined$sortedBy$1());
                stateFlowImpl9.getClass();
                stateFlowImpl9.updateState(null, listSortedWith);
                StateFlowImpl stateFlowImpl10 = profilesViewModel._loaded;
                Boolean bool7 = Boolean.TRUE;
                stateFlowImpl10.getClass();
                stateFlowImpl10.updateState(null, bool7);
                int i19 = ProfileAutoUpdate.$r8$clinit;
                ProfileAutoUpdate.sync(profilesViewModel.application, list2);
                return Unit.INSTANCE;
            case 12:
                TunnelState.Mode mode = (TunnelState.Mode) this.this$0;
                int i20 = this.label;
                if (i20 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (mode == ((ProxyViewModel) this.$throwable)._configMode.getValue()) {
                        mode = null;
                    }
                    InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2((Object) mode, (Continuation) (z12 ? 1 : 0), 7);
                    this.label = 1;
                    if (RemoteKt.withClash$default(interruptibleKt$runInterruptible$2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i20 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 13:
                int i21 = this.label;
                if (i21 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutableState = (MutableState) this.$throwable;
                    DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler5 = DefaultIoScheduler.INSTANCE;
                    Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(i4, z13 ? 1 : 0, 10);
                    this.this$0 = mutableState;
                    this.label = 1;
                    objWithContext3 = JobKt.withContext(defaultIoScheduler5, recomposer$join$2, this);
                    if (objWithContext3 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i21 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableState = (MutableState) this.this$0;
                    ResultKt.throwOnFailure(obj);
                    objWithContext3 = obj;
                }
                mutableState.setValue((String) objWithContext3);
                return Unit.INSTANCE;
            case 14:
                int i22 = this.label;
                if (i22 != 0) {
                    if (i22 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 = ((QrProfileServer) this.this$0).onFileReceived;
                byte[] bArr = (byte[]) this.$throwable;
                this.label = 1;
                Object objInvoke = tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1.invoke(bArr, this);
                return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
            case 15:
                int i23 = this.label;
                if (i23 != 0) {
                    if (i23 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2 = ((QrProfileServer) this.this$0).onUrlReceived;
                String str3 = (String) this.$throwable;
                this.label = 1;
                Object objInvoke2 = tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2.invoke(str3, this);
                return objInvoke2 == coroutineSingletons ? coroutineSingletons : objInvoke2;
            case 16:
                UUID uuid2 = (UUID) this.$throwable;
                RemoteService remoteService = ((ProfileManager) this.this$0).context;
                int i24 = this.label;
                try {
                    if (i24 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
                        this.label = 1;
                        Object objWithContext4 = JobKt.withContext(NonCancellable.INSTANCE, new MutatorMutex$mutateWith$2(remoteService, uuid2, null), this);
                        if (objWithContext4 != coroutineSingletons) {
                            objWithContext4 = Unit.INSTANCE;
                        }
                        if (objWithContext4 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i24 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    BroadcastKt.sendBroadcastSelf(remoteService, new Intent(Intents.ACTION_PROFILE_UPDATE_COMPLETED).putExtra("uuid", uuid2.toString()));
                    ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
                    ProfileProcessor.scheduleLogoFetch(remoteService, uuid2);
                    break;
                } catch (HwidLimitException e2) {
                    String message3 = e2.getMessage();
                    if (message3 == null) {
                        message3 = "HWID_LIMIT";
                    }
                    BroadcastKt.sendProfileUpdateFailed(remoteService, uuid2, message3);
                } catch (Exception e3) {
                    String message4 = e3.getMessage();
                    if (message4 == null) {
                        message4 = "Unknown";
                    }
                    BroadcastKt.sendProfileUpdateFailed(remoteService, uuid2, message4);
                }
                return Unit.INSTANCE;
            case 17:
                int i25 = this.label;
                if (i25 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProfileProcessor profileProcessor3 = ProfileProcessor.INSTANCE;
                    Context context = (Context) this.this$0;
                    UUID uuid3 = (UUID) this.$throwable;
                    this.label = 1;
                    Object objWithContext5 = JobKt.withContext(NonCancellable.INSTANCE, new MutatorMutex$mutateWith$2(context, uuid3, null), this);
                    if (objWithContext5 != coroutineSingletons) {
                        objWithContext5 = Unit.INSTANCE;
                    }
                    if (objWithContext5 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i25 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 18:
                int i26 = this.label;
                if (i26 == 0) {
                    ResultKt.throwOnFailure(obj);
                    TunModule tunModule = (TunModule) this.this$0;
                    this.label = 1;
                    BufferedChannel bufferedChannel = tunModule.close;
                    Object obj6 = Unit.INSTANCE;
                    Object objSend = bufferedChannel.send(obj6, this);
                    if (objSend == coroutineSingletons) {
                        obj6 = objSend;
                    }
                    if (obj6 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i26 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((TunService) this.$throwable).stopSelf();
                return Unit.INSTANCE;
            case 19:
                Module module = (Module) this.$throwable;
                int i27 = this.label;
                if (i27 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ((ArrayList) this.this$0).add(module);
                    this.label = 1;
                    if (module.execute(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i27 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 20:
                int i28 = this.label;
                if (i28 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Network network = (Network) this.this$0;
                    NetworkObserveModule networkObserveModule = (NetworkObserveModule) this.$throwable;
                    this.label = 1;
                    Object objSend2 = networkObserveModule.events.send(network, this);
                    if (objSend2 != coroutineSingletons) {
                        objSend2 = Unit.INSTANCE;
                    }
                    if (objSend2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i28 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boolean.FALSE;
            case 21:
                int i29 = this.label;
                if (i29 != 0) {
                    if (i29 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                Function2 function2 = (Function2) this.this$0;
                IClashManager iClashManager2 = (IClashManager) this.$throwable;
                this.label = 1;
                Object objInvoke3 = function2.invoke(iClashManager2, this);
                return objInvoke3 == coroutineSingletons ? coroutineSingletons : objInvoke3;
            case 22:
                int i30 = this.label;
                if (i30 != 0) {
                    if (i30 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                Function2 function3 = (Function2) this.this$0;
                IProfileManager iProfileManager = (IProfileManager) this.$throwable;
                this.label = 1;
                Object objInvoke4 = function3.invoke(iProfileManager, this);
                return objInvoke4 == coroutineSingletons ? coroutineSingletons : objInvoke4;
            case 23:
                int i31 = this.label;
                if (i31 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlowAsStateFlow = FlowKt.asStateFlow(((ComponentActivity) this.this$0).lifecycleRegistry._currentStateFlow);
                    BottomSheetKt$BottomSheet$4$1$1 bottomSheetKt$BottomSheet$4$1$1 = new BottomSheetKt$BottomSheet$4$1$1(i2, (HazeSourceNode) this.$throwable);
                    this.label = 1;
                    if (readonlyStateFlowAsStateFlow.$$delegate_0.collect(bottomSheetKt$BottomSheet$4$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i31 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new HttpException();
            case 24:
                int i32 = this.label;
                if (i32 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope = (ProducerScope) this.this$0;
                    ChannelFlow channelFlow = (ChannelFlow) this.$throwable;
                    this.label = 1;
                    if (channelFlow.collectTo(producerScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i32 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 25:
                int i33 = this.label;
                if (i33 == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) this.this$0;
                    ChannelFlowOperator channelFlowOperator = (ChannelFlowOperator) this.$throwable;
                    this.label = 1;
                    if (channelFlowOperator.flowCollect(flowCollector, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i33 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i34 = this.label;
                if (i34 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj7 = this.this$0;
                    FlowCollector flowCollector2 = (FlowCollector) this.$throwable;
                    this.label = 1;
                    if (flowCollector2.emit(obj7, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i34 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilesActivity$showError$1(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$throwable = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilesActivity$showError$1(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$throwable = obj;
    }
}
