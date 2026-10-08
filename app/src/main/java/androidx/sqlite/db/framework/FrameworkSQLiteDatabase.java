package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.compose.ui.autofill.PopulateViewStructure_androidKt$populate$7;
import androidx.sqlite.db.SupportSQLiteQuery;
import coil.disk.RealDiskCache;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements Closeable {
    public static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public final SQLiteDatabase delegate;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    public final void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public final void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    public final FrameworkSQLiteStatement compileStatement(String str) {
        return new FrameworkSQLiteStatement(this.delegate.compileStatement(str));
    }

    public final void endTransaction() {
        this.delegate.endTransaction();
    }

    public final void execSQL(String str) {
        this.delegate.execSQL(str);
    }

    public final boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public final boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public final Cursor query(String str) {
        return query(new RealDiskCache.RealEditor(26, str));
    }

    public final void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public final void execSQL(Object[] objArr) {
        this.delegate.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        final PopulateViewStructure_androidKt$populate$7 populateViewStructure_androidKt$populate$7 = new PopulateViewStructure_androidKt$populate$7(1, supportSQLiteQuery);
        return this.delegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$$ExternalSyntheticLambda0
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return (Cursor) populateViewStructure_androidKt$populate$7.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
    }
}
