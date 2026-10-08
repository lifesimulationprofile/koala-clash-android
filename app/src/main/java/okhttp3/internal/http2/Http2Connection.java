package okhttp3.internal.http2;

import androidx.compose.runtime.MutableState;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.github.kr328.clash.compose.FileAction;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.model.Profile;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.Buffer;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final PushObserver$Companion$PushObserverCancel pushObserver;
    public final TaskQueue pushQueue;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final Socket socket;
    public final LinkedHashMap streams = new LinkedHashMap();
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ReaderRunnable implements Function0 {
        public final /* synthetic */ int $r8$classId;
        public final Object reader;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ ReaderRunnable(int i, Object obj, Object obj2) {
            this.$r8$classId = i;
            this.reader = obj;
            this.this$0 = obj2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.$r8$classId) {
                case 0:
                    Http2Connection http2Connection = (Http2Connection) this.this$0;
                    Http2Reader http2Reader = (Http2Reader) this.reader;
                    try {
                        if (!http2Reader.nextFrame(true, this)) {
                            throw new IOException("Required SETTINGS preface not received");
                        }
                        while (http2Reader.nextFrame(false, this)) {
                        }
                        http2Connection.close$okhttp(1, 9, null);
                        Util.closeQuietly(http2Reader);
                        return Unit.INSTANCE;
                    } catch (IOException e) {
                        http2Connection.close$okhttp(2, 2, e);
                    } catch (Throwable th) {
                        http2Connection.close$okhttp(3, 3, null);
                        Util.closeQuietly(http2Reader);
                        throw th;
                    }
                    break;
                case 1:
                    ((Function1) this.reader).invoke(new FileAction.Open((File) this.this$0));
                    return Unit.INSTANCE;
                case 2:
                    ((MutableState) this.this$0).setValue((File) this.reader);
                    return Unit.INSTANCE;
                case 3:
                    ((Function1) this.reader).invoke((LogMessage) this.this$0);
                    return Unit.INSTANCE;
                case 4:
                    ((Function1) this.reader).invoke(((ProviderItemState) this.this$0).provider);
                    return Unit.INSTANCE;
                case 5:
                    ((Function1) this.reader).invoke(((ProcessGroup) this.this$0).process);
                    return Unit.INSTANCE;
                case 6:
                    ((MutableState) this.this$0).setValue((Profile) this.reader);
                    return Unit.INSTANCE;
                default:
                    ((Function1) this.reader).invoke(((AppInfo) this.this$0).packageName);
                    return Unit.INSTANCE;
            }
        }

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            this.$r8$classId = 0;
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(SVGAndroidRenderer sVGAndroidRenderer) {
        this.listener = (Listener) sVGAndroidRenderer.matrixStack;
        String str = (String) sVGAndroidRenderer.state;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            throw null;
        }
        this.connectionName = str;
        this.nextStreamId = 3;
        TaskRunner taskRunner = (TaskRunner) sVGAndroidRenderer.canvas;
        this.taskRunner = taskRunner;
        this.writerQueue = taskRunner.newQueue();
        this.pushQueue = taskRunner.newQueue();
        this.settingsListenerQueue = taskRunner.newQueue();
        this.pushObserver = PushObserver$Companion$PushObserverCancel.CANCEL;
        Settings settings = new Settings();
        settings.set(7, 16777216);
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        Socket socket = (Socket) sVGAndroidRenderer.document;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            throw null;
        }
        this.socket = socket;
        RealBufferedSink realBufferedSink = (RealBufferedSink) sVGAndroidRenderer.parentStack;
        if (realBufferedSink == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            throw null;
        }
        this.writer = new Http2Writer(realBufferedSink);
        RealBufferedSource realBufferedSource = (RealBufferedSource) sVGAndroidRenderer.stateStack;
        if (realBufferedSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("source");
            throw null;
        }
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(realBufferedSource));
        this.currentPushRequests = new LinkedHashSet();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(1, 9, null);
    }

    public final void close$okhttp(int i, int i2, IOException iOException) {
        int i3;
        Object[] array;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        try {
            shutdown(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    array = null;
                } else {
                    array = this.streams.values().toArray(new Http2Stream[0]);
                    this.streams.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(i2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    public final synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    public final synchronized boolean isHealthy(long j) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final void shutdown(int i) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i2 = this.lastGoodStreamId;
                Unit unit = Unit.INSTANCE;
                this.writer.goAway(Util.EMPTY_BYTE_ARRAY, i2, i);
            }
        }
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    public final void writeData(int i, boolean z, Buffer buffer, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.writeBytesTotal;
                            j3 = this.writeBytesMaximum;
                            if (j2 >= j3) {
                                if (!this.streams.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.writer.maxFrameSize);
                j4 = iMin;
                this.writeBytesTotal += j4;
                Unit unit = Unit.INSTANCE;
            }
            j -= j4;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    public final void writeSynResetLater$okhttp(int i, int i2) {
        this.writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(this.connectionName + '[' + i + "] writeSynReset", this, i, i2, 0), 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        final String str = this.connectionName + '[' + i + "] windowUpdate";
        this.writerQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                Http2Connection http2Connection = this;
                try {
                    http2Connection.writer.windowUpdate(i, j);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
            }
        }, 0L);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public abstract void onStream(Http2Stream http2Stream);

        public void onSettings(Settings settings) {
        }
    }
}
