package coil.decode;

import coil.fetch.SourceResult;
import coil.request.Options;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Decoder {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface Factory {
        Decoder create(SourceResult sourceResult, Options options);
    }

    Object decode(Continuation continuation);
}
