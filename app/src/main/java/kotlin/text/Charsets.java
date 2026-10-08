package kotlin.text;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Charsets {
    public static final Charset US_ASCII;
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    static {
        Charset.forName("UTF-16");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        US_ASCII = Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
    }
}
