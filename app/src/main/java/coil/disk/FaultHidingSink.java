package coil.disk;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FaultHidingSink implements Sink {
    public final Sink delegate;
    public boolean hasErrors;
    public final DiskLruCache$$ExternalSyntheticLambda0 onException;

    public FaultHidingSink(Sink sink, DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0) {
        this.delegate = sink;
        this.onException = diskLruCache$$ExternalSyntheticLambda0;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            close$okio$ForwardingSink();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public final void close$okio$ForwardingSink() {
        this.delegate.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        try {
            flush$okio$ForwardingSink();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public final void flush$okio$ForwardingSink() {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.delegate.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public final void write(long j, Buffer buffer) {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            this.delegate.write(j, buffer);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
