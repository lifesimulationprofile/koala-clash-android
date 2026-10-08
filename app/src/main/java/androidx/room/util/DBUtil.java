package androidx.room.util;

import android.database.Cursor;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.CloseableKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DBUtil {
    public static final void dropFtsSyncTriggers(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        ListBuilder listBuilderCreateListBuilder = MatrixExt.createListBuilder();
        Cursor cursorQuery = frameworkSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                listBuilderCreateListBuilder.add(cursorQuery.getString(0));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        cursorQuery.close();
        ListIterator listIterator = MatrixExt.build(listBuilderCreateListBuilder).listIterator(0);
        while (true) {
            ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
            if (!itr.hasNext()) {
                return;
            }
            String str = (String) itr.next();
            if (StringsKt__StringsJVMKt.startsWith(str, "room_fts_content_sync_", false)) {
                frameworkSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }
}
