package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CursorUtil {
    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strJoinToString$default;
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    String strConcat = ".".concat(str);
                    String str2 = "." + str + '`';
                    int length = columnNames.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            String str3 = columnNames[i2];
                            int i3 = i + 1;
                            if (str3.length() < str.length() + 2 || !(str3.endsWith(strConcat) || (str3.charAt(0) == '`' && str3.endsWith(str2)))) {
                                i2++;
                                i = i3;
                            } else {
                                columnIndex = i;
                            }
                        } else {
                            columnIndex = -1;
                        }
                    }
                } else {
                    columnIndex = -1;
                }
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            strJoinToString$default = ArraysKt.joinToString$default(63, cursor.getColumnNames());
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            strJoinToString$default = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strJoinToString$default);
    }
}
