package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Regex implements Serializable {
    public final Pattern nativePattern;

    public Regex(String str) {
        this.nativePattern = Pattern.compile(str);
    }

    public final boolean matches(CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String toString() {
        return this.nativePattern.toString();
    }
}
