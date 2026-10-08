package kotlinx.coroutines.flow;

import androidx.compose.runtime.Recomposer$join$2;
import androidx.navigation.compose.NavHostKt$NavHost$25$1$1;
import coil.network.HttpException;
import com.github.kr328.clash.remote.Remote$launch$2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Float $initialValue;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ StateFlowImpl $shared;
    public /* synthetic */ Object $started;
    public final /* synthetic */ Flow $upstream;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharing$1(Flow flow, StateFlowImpl stateFlowImpl, Float f, Continuation continuation) {
        super(2, continuation);
        this.$upstream = flow;
        this.$shared = stateFlowImpl;
        this.$initialValue = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FlowKt__ShareKt$launchSharing$1((StartedWhileSubscribed) this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
            default:
                FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(this.$upstream, this.$shared, this.$initialValue, continuation);
                flowKt__ShareKt$launchSharing$1.$started = obj;
                return flowKt__ShareKt$launchSharing$1;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((FlowKt__ShareKt$launchSharing$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((FlowKt__ShareKt$launchSharing$1) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.$r8$classId;
        Flow flow = this.$upstream;
        Float f = this.$initialValue;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        StateFlowImpl stateFlowImpl = this.$shared;
        int i2 = 2;
        switch (i) {
            case 0:
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 3;
                            if (flow.collect(stateFlowImpl, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else if (i3 != 3 && i3 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) this.$started;
                    if (startedWhileSubscribed == SharingStarted$Companion.Eagerly) {
                        this.label = 1;
                        if (flow.collect(stateFlowImpl, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        Continuation continuation = null;
                        if (startedWhileSubscribed == SharingStarted$Companion.Lazily) {
                            SubscriptionCountStateFlow subscriptionCount = stateFlowImpl.getSubscriptionCount();
                            Remote$launch$2 remote$launch$2 = new Remote$launch$2(i2, continuation, i2);
                            this.label = 2;
                            if (FlowKt.first(subscriptionCount, remote$launch$2, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            this.label = 3;
                            if (flow.collect(stateFlowImpl, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            SubscriptionCountStateFlow subscriptionCount2 = stateFlowImpl.getSubscriptionCount();
                            StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(startedWhileSubscribed, null);
                            int i4 = FlowKt__MergeKt.$r8$clinit;
                            final ChannelFlowTransformLatest channelFlowTransformLatest = new ChannelFlowTransformLatest(startedWhileSubscribed$command$1, subscriptionCount2, EmptyCoroutineContext.INSTANCE, -2, 1);
                            final Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(i2, continuation, 15);
                            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.distinctUntilChanged(new Flow() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
                                @Override // kotlinx.coroutines.flow.Flow
                                public final Object collect(FlowCollector flowCollector, Continuation continuation2) {
                                    Object objCollect = channelFlowTransformLatest.collect(new NavHostKt$NavHost$25$1$1(new Ref$BooleanRef(), flowCollector, recomposer$join$2, 3), continuation2);
                                    return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
                                }
                            }));
                            FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(flow, stateFlowImpl, f, null);
                            this.label = 4;
                            if (FlowKt.collectLatest(flowDistinctUntilChanged, flowKt__ShareKt$launchSharing$1, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    int iOrdinal = ((SharingCommand) this.$started).ordinal();
                    if (iOrdinal == 0) {
                        this.label = 1;
                        if (flow.collect(stateFlowImpl, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new HttpException();
                        }
                        if (f == FlowKt.NO_VALUE) {
                            stateFlowImpl.getClass();
                            throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
                        }
                        stateFlowImpl.setValue(f);
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharing$1(StartedWhileSubscribed startedWhileSubscribed, Flow flow, StateFlowImpl stateFlowImpl, Float f, Continuation continuation) {
        super(2, continuation);
        this.$started = startedWhileSubscribed;
        this.$upstream = flow;
        this.$shared = stateFlowImpl;
        this.$initialValue = f;
    }
}
