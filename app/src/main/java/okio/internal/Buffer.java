package okio.internal;

import java.io.EOFException;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: okio.internal.-Buffer, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Buffer {
    public static final byte[] HEX_DIGIT_BYTES = "0123456789abcdef".getBytes(Charsets.UTF_8);

    public static final String readUtf8Line(long j, okio.Buffer buffer) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == 13) {
                String string = buffer.readString(j2, Charsets.UTF_8);
                buffer.skip(2L);
                return string;
            }
        }
        String string2 = buffer.readString(j, Charsets.UTF_8);
        buffer.skip(1L);
        return string2;
    }
}
