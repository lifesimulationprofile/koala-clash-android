package coil.request;

import android.util.Log;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Parameters implements Iterable, KMappedMarker {
    public static final Parameters EMPTY = new Parameters(EmptyMap.INSTANCE);
    public final Map entries;

    public Parameters(Map map) {
        this.entries = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Parameters) {
            return Intrinsics.areEqual(this.entries, ((Parameters) obj).entries);
        }
        return false;
    }

    public final int hashCode() {
        return this.entries.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Map map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (entry.getValue() != null) {
                throw new ClassCastException();
            }
            arrayList.add(new Pair(str, null));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Builder {
        public final LinkedHashMap entries;

        public Builder(int i) {
            switch (i) {
                case 2:
                    this.entries = new LinkedHashMap();
                    break;
                default:
                    this.entries = new LinkedHashMap(0, 0.75f, true);
                    break;
            }
        }

        public void addMigrations(Migration... migrationArr) {
            for (Migration migration : migrationArr) {
                int i = migration.startVersion;
                int i2 = migration.endVersion;
                Integer numValueOf = Integer.valueOf(i);
                LinkedHashMap linkedHashMap = this.entries;
                Object treeMap = linkedHashMap.get(numValueOf);
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    linkedHashMap.put(numValueOf, treeMap);
                }
                TreeMap treeMap2 = (TreeMap) treeMap;
                if (treeMap2.containsKey(Integer.valueOf(i2))) {
                    Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + migration);
                }
                treeMap2.put(Integer.valueOf(i2), migration);
            }
        }

        public Builder(Parameters parameters) {
            this.entries = new LinkedHashMap(parameters.entries);
        }
    }
}
