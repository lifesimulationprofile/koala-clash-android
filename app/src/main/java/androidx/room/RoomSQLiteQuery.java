package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final TreeMap queryPool = new TreeMap();
    public int argCount;
    public final int[] bindingTypes;
    public final byte[][] blobBindings;
    public final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    public volatile String query;
    public final String[] stringBindings;

    public RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }

    public static final RoomSQLiteQuery acquire(String str, int i) {
        TreeMap treeMap = queryPool;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry != null) {
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) entryCeilingEntry.getValue();
                roomSQLiteQuery.query = str;
                roomSQLiteQuery.argCount = i;
                return roomSQLiteQuery;
            }
            Unit unit = Unit.INSTANCE;
            RoomSQLiteQuery roomSQLiteQuery2 = new RoomSQLiteQuery(i);
            roomSQLiteQuery2.query = str;
            roomSQLiteQuery2.argCount = i;
            return roomSQLiteQuery2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(double d, int i) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(String str, int i) {
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        int i = this.argCount;
        if (1 > i) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.bindingTypes[i2];
            if (i3 == 1) {
                supportSQLiteProgram.bindNull(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.bindLong(i2, this.longBindings[i2]);
            } else if (i3 == 3) {
                supportSQLiteProgram.bindDouble(this.doubleBindings[i2], i2);
            } else if (i3 == 4) {
                String str = this.stringBindings[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                supportSQLiteProgram.bindString(str, i2);
            } else if (i3 == 5) {
                byte[] bArr = this.blobBindings[i2];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                supportSQLiteProgram.bindBlob(i2, bArr);
            }
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void release() {
        TreeMap treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
