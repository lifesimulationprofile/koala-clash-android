package kotlinx.coroutines.flow.internal;

import android.os.Parcel;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.service.FilesProvider;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManagerDelegate;
import com.github.kr328.clash.service.remote.IProfileManagerDelegate;
import fi.iki.elonen.NanoHTTPD$Method$EnumUnboxingLocalUtility;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelFlow implements FusibleFlow {
    public final int capacity;
    public final CoroutineContext context;
    public final int onBufferOverflow;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlow$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public Object $collector;
        public final /* synthetic */ int $r8$classId;
        public Object L$0;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.L$0 = obj;
            this.$collector = obj2;
            this.this$0 = obj3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((FlowCollector) this.$collector, (ChannelFlow) this.this$0, continuation, 0);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((ProcessGroup) this.this$0, continuation, 1);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                case 2:
                    return new AnonymousClass2((ProxyViewModel) this.this$0, continuation, 2);
                case 3:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((ProxyViewModel) this.$collector, (String) this.this$0, continuation, 3);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                case 4:
                    return new AnonymousClass2((ProxyViewModel) this.L$0, (String) this.$collector, (ArrayList) this.this$0, continuation, 4);
                case 5:
                    return new AnonymousClass2((Function0) this.L$0, (MutableState) this.$collector, (MutableState) this.this$0, continuation, 5);
                case 6:
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2((MutableState) this.$collector, (MutableState) this.this$0, continuation, 6);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                case 7:
                    return new AnonymousClass2((String) this.L$0, (String) this.$collector, (FilesProvider) this.this$0, continuation, 7);
                case 8:
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2((IClashManagerDelegate) this.$collector, (String) this.this$0, continuation, 8);
                    anonymousClass6.L$0 = obj;
                    return anonymousClass6;
                case 9:
                    AnonymousClass2 anonymousClass7 = new AnonymousClass2((IProfileManagerDelegate) this.$collector, (Profile) this.this$0, continuation, 9);
                    anonymousClass7.L$0 = obj;
                    return anonymousClass7;
                default:
                    AnonymousClass2 anonymousClass8 = new AnonymousClass2((SendChannel) this.$collector, this.this$0, continuation, 10);
                    anonymousClass8.L$0 = obj;
                    return anonymousClass8;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 1:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 5:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 6:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 7:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 8:
                    return ((AnonymousClass2) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 9:
                    return ((AnonymousClass2) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Code duplicated, block: B:257:0x0488  */
        /* JADX WARN: Code duplicated, block: B:260:0x049f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x02ca -> B:154:0x02a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:259:0x049d -> B:261:0x04a0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 1264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$collector = obj;
            this.this$0 = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = obj;
        }
    }

    public ChannelFlow(CoroutineContext coroutineContext, int i, int i2) {
        this.context = coroutineContext;
        this.capacity = i;
        this.onBufferOverflow = i2;
    }

    public String additionalToStringProps() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCoroutineScope = JobKt.coroutineScope(new AnonymousClass2(flowCollector, this, null, 0), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public abstract Object collectTo(ProducerScope producerScope, Continuation continuation);

    public abstract ChannelFlow create(CoroutineContext coroutineContext, int i, int i2);

    public Flow dropChannelOperators() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, int i2) {
        CoroutineContext coroutineContext2 = this.context;
        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2);
        int i3 = this.onBufferOverflow;
        int i4 = this.capacity;
        if (i2 == 1) {
            if (i4 != -3) {
                if (i == -3) {
                    i = i4;
                } else if (i4 != -2) {
                    if (i == -2) {
                        i = i4;
                    } else {
                        i += i4;
                        if (i < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            i2 = i3;
        }
        return (Intrinsics.areEqual(coroutineContextPlus, coroutineContext2) && i == i4 && i2 == i3) ? this : create(coroutineContextPlus, i, i2);
    }

    public ReceiveChannel produceImpl(CoroutineScope coroutineScope) {
        int i = this.capacity;
        if (i == -3) {
            i = -2;
        }
        Function2 filesActivity$showError$1 = new FilesActivity$showError$1(this, null, 24);
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(JobKt.newCoroutineContext(coroutineScope, this.context), ChannelKt.Channel$default(i, this.onBufferOverflow, 4));
        producerCoroutine.start(3, producerCoroutine, filesActivity$showError$1);
        return producerCoroutine;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strAdditionalToStringProps = additionalToStringProps();
        if (strAdditionalToStringProps != null) {
            arrayList.add(strAdditionalToStringProps);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext = this.context;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int i = this.capacity;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        int i2 = this.onBufferOverflow;
        if (i2 != 1) {
            arrayList.add("onBufferOverflow=".concat(NanoHTTPD$Method$EnumUnboxingLocalUtility.stringValueOf(i2)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return Modifier.CC.m(sb, CollectionsKt.joinToString$default(arrayList, ", ", null, null, null, 62), ']');
    }
}
