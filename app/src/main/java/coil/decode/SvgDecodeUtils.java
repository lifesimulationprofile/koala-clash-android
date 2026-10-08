package coil.decode;

import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SvgDecodeUtils {
    public static final ByteString LEFT_ANGLE_BRACKET;
    public static final ByteString SVG_TAG;

    static {
        ByteString byteString = new ByteString("<svg".getBytes(Charsets.UTF_8));
        byteString.utf8 = "<svg";
        SVG_TAG = byteString;
        ByteString byteString2 = new ByteString("<".getBytes(Charsets.UTF_8));
        byteString2.utf8 = "<";
        LEFT_ANGLE_BRACKET = byteString2;
    }
}
