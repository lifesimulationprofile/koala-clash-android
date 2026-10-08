package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ReceiveChannel {
    void cancel(CancellationException cancellationException);

    SelectClause1 getOnReceive();

    BufferedChannel.BufferedChannelIterator iterator();

    Object receive(Continuation continuation);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    Object mo848receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    Object mo850tryReceivePtdJZtk();
}
