package androidx.room.util;

import android.database.Cursor;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.IOException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyMap;
import kotlin.collections.SetsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TableInfo {
    public final Object columns;
    public final Set foreignKeys;
    public final Set indices;
    public final String name;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Column {
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public abstract class Companion {
            public static boolean defaultValueEquals(String str, String str2) {
                if (str.equals(str2)) {
                    return true;
                }
                if (str.length() != 0) {
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < str.length()) {
                        char cCharAt = str.charAt(i);
                        int i4 = i3 + 1;
                        if (i3 != 0 || cCharAt == '(') {
                            if (cCharAt == '(') {
                                i2++;
                            } else if (cCharAt != ')' || (i2 = i2 - 1) != 0 || i3 == str.length() - 1) {
                            }
                            i++;
                            i3 = i4;
                        }
                    }
                    if (i2 == 0) {
                        return Intrinsics.areEqual(StringsKt.trim(str.substring(1, str.length() - 1)).toString(), str2);
                    }
                }
                return false;
            }
        }

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            this.defaultValue = str3;
            this.createdFrom = i2;
            String upperCase = str2.toUpperCase(Locale.US);
            this.affinity = StringsKt.contains(upperCase, "INT", false) ? 3 : (StringsKt.contains(upperCase, "CHAR", false) || StringsKt.contains(upperCase, "CLOB", false) || StringsKt.contains(upperCase, "TEXT", false)) ? 2 : StringsKt.contains(upperCase, "BLOB", false) ? 5 : (StringsKt.contains(upperCase, "REAL", false) || StringsKt.contains(upperCase, "FLOA", false) || StringsKt.contains(upperCase, "DOUB", false)) ? 4 : 1;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Column)) {
                    return false;
                }
                Column column = (Column) obj;
                if (this.primaryKeyPosition != column.primaryKeyPosition) {
                    return false;
                }
                int i = column.createdFrom;
                String str = column.defaultValue;
                if (!Intrinsics.areEqual(this.name, column.name) || this.notNull != column.notNull) {
                    return false;
                }
                String str2 = this.defaultValue;
                int i2 = this.createdFrom;
                if (i2 == 1 && i == 2 && str2 != null && !Companion.defaultValueEquals(str2, str)) {
                    return false;
                }
                if (i2 == 2 && i == 1 && str != null && !Companion.defaultValueEquals(str, str2)) {
                    return false;
                }
                if (i2 != 0 && i2 == i) {
                    if (str2 != null) {
                        if (!Companion.defaultValueEquals(str2, str)) {
                            return false;
                        }
                    } else if (str != null) {
                        return false;
                    }
                }
                if (this.affinity != column.affinity) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, str, "'}");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ForeignKey {
        public final List columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List list, List list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (Intrinsics.areEqual(this.referenceTable, foreignKey.referenceTable) && Intrinsics.areEqual(this.onDelete, foreignKey.onDelete) && Intrinsics.areEqual(this.onUpdate, foreignKey.onUpdate) && Intrinsics.areEqual(this.columnNames, foreignKey.columnNames)) {
                return Intrinsics.areEqual(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public final int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + Modifier.CC.m(Modifier.CC.m(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate)) * 31);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ForeignKeyWithSequence implements Comparable {
        public final String from;
        public final int id;
        public final int sequence;
        public final String to;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.id = i;
            this.sequence = i2;
            this.from = str;
            this.to = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
            int i = this.id - foreignKeyWithSequence.id;
            return i == 0 ? this.sequence - foreignKeyWithSequence.sequence : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Index {
        public final List columns;
        public final String name;
        public final List orders;
        public final boolean unique;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
        public Index(String str, boolean z, List list, List list2) {
            this.name = str;
            this.unique = z;
            this.columns = list;
            this.orders = list2;
            if (list2.isEmpty()) {
                int size = list.size();
                list2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    list2.add("ASC");
                }
            }
            this.orders = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Index) {
                Index index = (Index) obj;
                String str = index.name;
                if (this.unique == index.unique && Intrinsics.areEqual(this.columns, index.columns) && Intrinsics.areEqual(this.orders, index.orders)) {
                    String str2 = this.name;
                    return StringsKt__StringsJVMKt.startsWith(str2, "index_", false) ? StringsKt__StringsJVMKt.startsWith(str, "index_", false) : str2.equals(str);
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.name;
            return this.orders.hashCode() + ((this.columns.hashCode() + ((((StringsKt__StringsJVMKt.startsWith(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public final String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }
    }

    public TableInfo(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        this.name = str;
        this.columns = map;
        this.foreignKeys = abstractSet;
        this.indices = abstractSet2;
    }

    public static final TableInfo read(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) throws IOException {
        Map mapBuild;
        Cursor cursorQuery = frameworkSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorQuery.getColumnCount() <= 0) {
                mapBuild = EmptyMap.INSTANCE;
                cursorQuery.close();
            } else {
                int columnIndex = cursorQuery.getColumnIndex("name");
                int columnIndex2 = cursorQuery.getColumnIndex("type");
                int columnIndex3 = cursorQuery.getColumnIndex("notnull");
                int columnIndex4 = cursorQuery.getColumnIndex("pk");
                int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
                MapBuilder mapBuilder = new MapBuilder();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    mapBuilder.put(string, new Column(string, cursorQuery.getString(columnIndex2), cursorQuery.getInt(columnIndex3) != 0, cursorQuery.getInt(columnIndex4), cursorQuery.getString(columnIndex5), 2));
                }
                mapBuild = mapBuilder.build();
                cursorQuery.close();
            }
            Cursor cursorQuery2 = frameworkSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = cursorQuery2.getColumnIndex("id");
                int columnIndex7 = cursorQuery2.getColumnIndex("seq");
                int columnIndex8 = cursorQuery2.getColumnIndex("table");
                int columnIndex9 = cursorQuery2.getColumnIndex("on_delete");
                int columnIndex10 = cursorQuery2.getColumnIndex("on_update");
                List foreignKeyFieldMappings = TableInfoKt.readForeignKeyFieldMappings(cursorQuery2);
                cursorQuery2.moveToPosition(-1);
                SetBuilder setBuilder = new SetBuilder();
                while (cursorQuery2.moveToNext()) {
                    if (cursorQuery2.getInt(columnIndex7) == 0) {
                        int i = cursorQuery2.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = columnIndex6;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : foreignKeyFieldMappings) {
                            int i3 = columnIndex7;
                            List list = foreignKeyFieldMappings;
                            if (((ForeignKeyWithSequence) obj).id == i) {
                                arrayList3.add(obj);
                            }
                            columnIndex7 = i3;
                            foreignKeyFieldMappings = list;
                        }
                        int i4 = columnIndex7;
                        List list2 = foreignKeyFieldMappings;
                        int i5 = 0;
                        for (int size = arrayList3.size(); i5 < size; size = size) {
                            Object obj2 = arrayList3.get(i5);
                            i5++;
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                            arrayList.add(foreignKeyWithSequence.from);
                            arrayList2.add(foreignKeyWithSequence.to);
                        }
                        setBuilder.add(new ForeignKey(cursorQuery2.getString(columnIndex8), cursorQuery2.getString(columnIndex9), cursorQuery2.getString(columnIndex10), arrayList, arrayList2));
                        columnIndex6 = i2;
                        columnIndex7 = i4;
                        foreignKeyFieldMappings = list2;
                    }
                }
                SetBuilder setBuilderBuild = SetsKt.build(setBuilder);
                cursorQuery2.close();
                Cursor cursorQuery3 = frameworkSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = cursorQuery3.getColumnIndex("name");
                    int columnIndex12 = cursorQuery3.getColumnIndex("origin");
                    int columnIndex13 = cursorQuery3.getColumnIndex("unique");
                    SetBuilder setBuilderBuild2 = null;
                    if (columnIndex11 == -1 || columnIndex12 == -1 || columnIndex13 == -1) {
                        cursorQuery3.close();
                    } else {
                        SetBuilder setBuilder2 = new SetBuilder();
                        while (cursorQuery3.moveToNext()) {
                            if ("c".equals(cursorQuery3.getString(columnIndex12))) {
                                Index index = TableInfoKt.readIndex(frameworkSQLiteDatabase, cursorQuery3.getString(columnIndex11), cursorQuery3.getInt(columnIndex13) == 1);
                                if (index == null) {
                                    cursorQuery3.close();
                                } else {
                                    setBuilder2.add(index);
                                }
                            }
                        }
                        setBuilderBuild2 = SetsKt.build(setBuilder2);
                        cursorQuery3.close();
                    }
                    return new TableInfo(str, mapBuild, setBuilderBuild, setBuilderBuild2);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery3, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(cursorQuery2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(cursorQuery, th5);
                throw th6;
            }
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!this.name.equals(tableInfo.name) || !this.columns.equals(tableInfo.columns) || !Intrinsics.areEqual(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.foreignKeys.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
