package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer getBuffer();

    long indexOf(byte b, long j, long j2);

    InputStream inputStream();

    boolean rangeEquals(long j, ByteString byteString);

    long readAll(RealBufferedSink realBufferedSink);

    byte readByte();

    byte[] readByteArray();

    ByteString readByteString(long j);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    short readShort();

    short readShortLe();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j);

    boolean request(long j);

    void require(long j);

    void skip(long j);
}
