package kotlinx.coroutines.channels;

import androidx.compose.ui.graphics.vector.ImageVector;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelKt {
    public static ImageVector _bolt;

    public static BufferedChannel Channel$default(int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if (i == -2) {
            if (i2 != 1) {
                return new ConflatedBufferedChannel(1, i2);
            }
            Channel.Factory.getClass();
            return new BufferedChannel(Channel.Factory.CHANNEL_DEFAULT_CAPACITY);
        }
        if (i == -1) {
            if (i2 == 1) {
                return new ConflatedBufferedChannel(1, 2);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == 0) {
            return i2 == 1 ? new BufferedChannel(0) : new ConflatedBufferedChannel(1, i2);
        }
        if (i != Integer.MAX_VALUE) {
            return i2 == 1 ? new BufferedChannel(i) : new ConflatedBufferedChannel(i, i2);
        }
        return new BufferedChannel(Integer.MAX_VALUE);
    }
}
