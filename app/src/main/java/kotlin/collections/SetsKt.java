package kotlin.collections;

import android.os.Handler;
import android.os.Looper;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzu;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SetsKt {
    public static SetBuilder build(SetBuilder setBuilder) {
        MapBuilder mapBuilder = setBuilder.backing;
        mapBuilder.build();
        return mapBuilder.size > 0 ? setBuilder : SetBuilder.Empty;
    }

    public static zzt directExecutor() {
        if (zzt.sDirectExecutor != null) {
            return zzt.sDirectExecutor;
        }
        synchronized (zzt.class) {
            try {
                if (zzt.sDirectExecutor == null) {
                    zzt.sDirectExecutor = new zzt(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzt.sDirectExecutor;
    }

    public static HighPriorityExecutor highPriorityExecutor() {
        if (HighPriorityExecutor.sExecutor != null) {
            return HighPriorityExecutor.sExecutor;
        }
        synchronized (HighPriorityExecutor.class) {
            try {
                if (HighPriorityExecutor.sExecutor == null) {
                    HighPriorityExecutor.sExecutor = new HighPriorityExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return HighPriorityExecutor.sExecutor;
    }

    public static zzu ioExecutor() {
        if (zzu.sExecutor != null) {
            return zzu.sExecutor;
        }
        synchronized (zzu.class) {
            try {
                if (zzu.sExecutor == null) {
                    zzu.sExecutor = new zzu(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzu.sExecutor;
    }

    public static HandlerScheduledExecutorService mainThreadExecutor() {
        if (PredictiveBackHandlerKt.sInstance != null) {
            return PredictiveBackHandlerKt.sInstance;
        }
        synchronized (PredictiveBackHandlerKt.class) {
            try {
                if (PredictiveBackHandlerKt.sInstance == null) {
                    PredictiveBackHandlerKt.sInstance = new HandlerScheduledExecutorService(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return PredictiveBackHandlerKt.sInstance;
    }

    public static LinkedHashSet minus(Set set, Object obj) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size()));
        boolean z = false;
        for (Object obj2 : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static LinkedHashSet plus(Set set, Iterable iterable) {
        int size;
        Integer numValueOf = iterable instanceof Collection ? Integer.valueOf(((Collection) iterable).size()) : null;
        if (numValueOf != null) {
            size = set.size() + numValueOf.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.addAll(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static LinkedHashSet plus(Set set, Object obj) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
