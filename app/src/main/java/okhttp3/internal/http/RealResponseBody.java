package okhttp3.internal.http;

import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    public final long contentLength;
    public final String contentTypeString;
    public final RealBufferedSource source;

    public RealResponseBody(String str, long j, RealBufferedSource realBufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = realBufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        String str = this.contentTypeString;
        if (str == null) {
            return null;
        }
        Pattern pattern = MediaType.TYPE_SUBTYPE;
        try {
            return MediaType.Companion.get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.source;
    }
}
