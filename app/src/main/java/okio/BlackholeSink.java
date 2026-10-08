package okio;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BlackholeSink implements Sink {
    @Override // okio.Sink
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        buffer.skip(j);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }
}
