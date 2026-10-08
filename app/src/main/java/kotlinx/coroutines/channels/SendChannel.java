package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface SendChannel {
    Object send(Object obj, Continuation continuation);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo851trySendJP2dKIU(Object obj);
}
