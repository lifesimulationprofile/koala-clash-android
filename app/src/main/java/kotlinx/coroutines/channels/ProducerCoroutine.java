package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProducerCoroutine extends AbstractCoroutine implements ProducerScope, Channel {
    public final BufferedChannel _channel;

    public ProducerCoroutine(CoroutineContext coroutineContext, BufferedChannel bufferedChannel) {
        super(coroutineContext, true);
        this._channel = bufferedChannel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancelInternal(CancellationException cancellationException) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cancellationException);
        this._channel.closeOrCancelImpl(cancellationException$default, true);
        cancelImpl$kotlinx_coroutines_core(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        return this._channel.getOnReceive();
    }

    public final void invokeOnClose(ProduceKt$awaitClose$4$1 produceKt$awaitClose$4$1) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.closeHandler$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, null, produceKt$awaitClose$4$1)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(bufferedChannel);
                    Symbol symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
                    if (obj != symbol) {
                        if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    Symbol symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, symbol, symbol2)) {
                            produceKt$awaitClose$4$1.invoke(bufferedChannel.getCloseCause());
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(bufferedChannel) == symbol);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final BufferedChannel.BufferedChannelIterator iterator() {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return bufferedChannel.new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (this._channel.closeOrCancelImpl(th, false) || z) {
            return;
        }
        JobKt.handleCoroutineException(th, this.context);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        this._channel.closeOrCancelImpl(null, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) {
        return this._channel.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo848receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return BufferedChannel.m847receiveCatchingJP2dKIU$suspendImpl(bufferedChannel, combineKt$combineInternal$2);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) {
        return this._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo850tryReceivePtdJZtk() {
        return this._channel.mo850tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo851trySendJP2dKIU(Object obj) {
        return this._channel.mo851trySendJP2dKIU(obj);
    }
}
