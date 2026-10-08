package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import coil.request.Parameters;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class LruCache {
    public int hitCount;
    public final ByteString.Companion lock;
    public final Parameters.Builder map;
    public final int maxSize;
    public int missCount;
    public int size;

    public LruCache(int i) {
        this.maxSize = i;
        if (i <= 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
            throw null;
        }
        this.map = new Parameters.Builder(1);
        this.lock = new ByteString.Companion(5);
    }

    public final Object get(Object obj) {
        synchronized (this.lock) {
            Object obj2 = this.map.entries.get(obj);
            if (obj2 != null) {
                this.hitCount++;
                return obj2;
            }
            this.missCount++;
            return null;
        }
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        synchronized (this.lock) {
            try {
                this.size += safeSizeOf(obj, obj2);
                objPut = this.map.entries.put(obj, obj2);
                if (objPut != null) {
                    this.size -= safeSizeOf(obj, objPut);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            entryRemoved(obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final Object remove(Object obj) {
        Object objRemove;
        synchronized (this.lock) {
            try {
                objRemove = this.map.entries.remove(obj);
                if (objRemove != null) {
                    this.size -= safeSizeOf(obj, objRemove);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            entryRemoved(obj, objRemove, null);
        }
        return objRemove;
    }

    public final int safeSizeOf(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + obj + '=' + obj2);
    }

    public int sizeOf(Object obj, Object obj2) {
        return 1;
    }

    public final String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void trimToSize(int i) {
        Object next;
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (this.size < 0 || (this.map.entries.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size > i && !this.map.entries.isEmpty()) {
                        Set setEntrySet = this.map.entries.entrySet();
                        if (setEntrySet instanceof List) {
                            List list = (List) setEntrySet;
                            next = list.isEmpty() ? null : list.get(0);
                        } else {
                            Iterator it = setEntrySet.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.entries.remove(key);
                        this.size -= safeSizeOf(key, value);
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public void entryRemoved(Object obj, Object obj2, Object obj3) {
    }
}
