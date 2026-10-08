package coil.decode;

import coil.util.Utils;
import java.io.Closeable;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FileImageSource extends ResponseBody {
    public final Closeable closeable;
    public final String diskCacheKey;
    public final Path file;
    public final FileSystem fileSystem;
    public boolean isClosed;
    public RealBufferedSource source;

    public FileImageSource(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        this.file = path;
        this.fileSystem = fileSystem;
        this.diskCacheKey = str;
        this.closeable = closeable;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.isClosed = true;
            RealBufferedSource realBufferedSource = this.source;
            if (realBufferedSource != null) {
                Utils.closeQuietly(realBufferedSource);
            }
            Closeable closeable = this.closeable;
            if (closeable != null) {
                Utils.closeQuietly(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okhttp3.ResponseBody
    public final ImageSource$Metadata getMetadata() {
        return null;
    }

    @Override // okhttp3.ResponseBody
    public final synchronized BufferedSource source() {
        if (this.isClosed) {
            throw new IllegalStateException("closed");
        }
        RealBufferedSource realBufferedSource = this.source;
        if (realBufferedSource != null) {
            return realBufferedSource;
        }
        RealBufferedSource realBufferedSource2 = new RealBufferedSource(this.fileSystem.source(this.file));
        this.source = realBufferedSource2;
        return realBufferedSource2;
    }
}
