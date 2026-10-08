package fi.iki.elonen;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdk;
import com.google.android.gms.internal.mlkit_vision_common.zzad;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class NanoHTTPD$Method$EnumUnboxingLocalUtility {
    public static int _lookup(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return valueOf$1(str);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static int m(int i, int i2, int i3) {
        return zzdk.zzA(i) + i2 + i3;
    }

    public static /* synthetic */ String stringValueOf(int i) {
        if (i == 1) {
            return "SUSPEND";
        }
        if (i != 2) {
            return i != 3 ? "null" : "DROP_LATEST";
        }
        return "DROP_OLDEST";
    }

    public static /* synthetic */ int valueOf$1(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("GET")) {
            return 1;
        }
        if (str.equals("PUT")) {
            return 2;
        }
        if (str.equals("POST")) {
            return 3;
        }
        if (str.equals("DELETE")) {
            return 4;
        }
        if (str.equals("HEAD")) {
            return 5;
        }
        if (str.equals("OPTIONS")) {
            return 6;
        }
        if (str.equals("TRACE")) {
            return 7;
        }
        if (str.equals("CONNECT")) {
            return 8;
        }
        if (str.equals("PATCH")) {
            return 9;
        }
        if (str.equals("PROPFIND")) {
            return 10;
        }
        if (str.equals("PROPPATCH")) {
            return 11;
        }
        if (str.equals("MKCOL")) {
            return 12;
        }
        if (str.equals("MOVE")) {
            return 13;
        }
        if (str.equals("COPY")) {
            return 14;
        }
        if (str.equals("LOCK")) {
            return 15;
        }
        if (str.equals("UNLOCK")) {
            return 16;
        }
        throw new IllegalArgumentException("No enum constant fi.iki.elonen.NanoHTTPD.Method.".concat(str));
    }

    public static int m(int i, int i2, int i3, int i4) {
        return zzdk.zzA(i) + i2 + i3 + i4;
    }

    public static zzad m(HashMap map, int i) {
        Collections.unmodifiableMap(new HashMap(map));
        return new zzad(i);
    }

    public static HashMap m(Class cls, zzad zzadVar) {
        HashMap map = new HashMap();
        map.put(cls, zzadVar);
        return map;
    }
}
