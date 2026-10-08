package kotlin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UnsignedKt implements androidx.arch.core.util.Function {
    public static QuirkSettings buildQuirkSettings(Context context, Bundle bundle) {
        boolean z = bundle.getBoolean("androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED", true);
        String[] strArrLoadQuirks = loadQuirks(context, bundle, "androidx.camera.core.quirks.FORCE_ENABLED");
        String[] strArrLoadQuirks2 = loadQuirks(context, bundle, "androidx.camera.core.quirks.FORCE_DISABLED");
        LazyKt__LazyJVMKt.d("QuirkSettingsLoader", "Loaded quirk settings from metadata:");
        LazyKt__LazyJVMKt.d("QuirkSettingsLoader", "  KEY_DEFAULT_QUIRK_ENABLED = " + z);
        LazyKt__LazyJVMKt.d("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(strArrLoadQuirks));
        LazyKt__LazyJVMKt.d("QuirkSettingsLoader", "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(strArrLoadQuirks2));
        return new QuirkSettings(z, new HashSet(resolveQuirkNames(strArrLoadQuirks)), new HashSet(resolveQuirkNames(strArrLoadQuirks2)));
    }

    public static String[] loadQuirks(Context context, Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            return new String[0];
        }
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            LazyKt__LazyJVMKt.w("QuirkSettingsLoader", "Resource ID not found for key: ".concat(str));
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(i);
        } catch (Resources.NotFoundException e) {
            LazyKt__LazyJVMKt.w("QuirkSettingsLoader", "Quirk class names resource not found: " + i, e);
            return new String[0];
        }
    }

    public static HashSet resolveQuirkNames(String[] strArr) {
        Class<?> cls;
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            try {
                cls = Class.forName(str);
                if (!Quirk.class.isAssignableFrom(cls)) {
                    LazyKt__LazyJVMKt.w("QuirkSettingsLoader", str + " does not implement the Quirk interface.");
                    cls = null;
                }
            } catch (ClassNotFoundException e) {
                LazyKt__LazyJVMKt.w("QuirkSettingsLoader", "Class not found: " + str, e);
            }
            if (cls != null) {
                hashSet.add(cls);
            }
        }
        return hashSet;
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * ((double) 2048)) + (j & 2047);
    }
}
