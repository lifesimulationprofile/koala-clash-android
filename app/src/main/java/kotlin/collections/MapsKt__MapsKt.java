package kotlin.collections;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MapsKt__MapsKt {
    public static void checkMainThread() {
        Preconditions.checkState("Not in application's main thread", isMainThread());
    }

    public static Object getValue(Object obj, Map map) {
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map mapOf(Pair... pairArr) {
        if (pairArr.length <= 0) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final void putAll(HashMap map, Pair[] pairArr) {
        for (Pair pair : pairArr) {
            map.put(pair.first, pair.second);
        }
    }

    public static void runOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            Preconditions.checkState("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(runnable));
        }
    }

    public static Map toMap(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        int i = 0;
        if (size == 1) {
            Pair pair = (Pair) arrayList.get(0);
            return Collections.singletonMap(pair.first, pair.second);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(arrayList.size()));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair2 = (Pair) obj;
            linkedHashMap.put(pair2.first, pair2.second);
        }
        return linkedHashMap;
    }

    public static Map toMap(Map map) {
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }
}
