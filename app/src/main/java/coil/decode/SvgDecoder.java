package coil.decode;

import coil.fetch.SourceResult;
import coil.request.Options;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SvgDecoder implements Decoder {
    public final Options options;
    public final ResponseBody source;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Factory implements Decoder.Factory {
        @Override // coil.decode.Decoder.Factory
        public final Decoder create(SourceResult sourceResult, Options options) {
            long jIndexOf;
            String str = sourceResult.mimeType;
            ResponseBody responseBody = sourceResult.source;
            if (!Intrinsics.areEqual(str, "image/svg+xml")) {
                BufferedSource bufferedSourceSource = responseBody.source();
                if (!bufferedSourceSource.rangeEquals(0L, SvgDecodeUtils.LEFT_ANGLE_BRACKET)) {
                    return null;
                }
                ByteString byteString = SvgDecodeUtils.SVG_TAG;
                byte[] bArr = byteString.data;
                if (bArr.length <= 0) {
                    throw new IllegalArgumentException("bytes is empty");
                }
                byte b = bArr[0];
                long length = 1024 - ((long) bArr.length);
                long j = 0;
                while (true) {
                    if (j >= length) {
                        jIndexOf = -1;
                        break;
                    }
                    byte b2 = b;
                    long j2 = length;
                    jIndexOf = bufferedSourceSource.indexOf(b2, j, j2);
                    if (jIndexOf == -1 || bufferedSourceSource.rangeEquals(jIndexOf, byteString)) {
                        break;
                    }
                    j = jIndexOf + 1;
                    length = j2;
                    b = b2;
                }
                if (jIndexOf == -1) {
                    return null;
                }
            }
            return new SvgDecoder(responseBody, options);
        }

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Factory);
        }

        public final int hashCode() {
            return 1231;
        }
    }

    public SvgDecoder(ResponseBody responseBody, Options options) {
        this.source = responseBody;
        this.options = options;
    }

    @Override // coil.decode.Decoder
    public final Object decode(Continuation continuation) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(new SvgDecoder$$ExternalSyntheticLambda0(0, this), (Continuation) null, 0);
        return JobKt.withContext(EmptyCoroutineContext.INSTANCE, interruptibleKt$runInterruptible$2, (ContinuationImpl) continuation);
    }
}
