package okhttp3.internal.http;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ExchangeCodec {
    void cancel();

    void finishRequest();

    void flushRequest();

    RealConnection getConnection();

    Source openResponseBodySource(Response response);

    Response.Builder readResponseHeaders(boolean z);

    long reportedContentLength(Response response);

    void writeRequestHeaders(Request request);
}
