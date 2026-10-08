package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteStatement delegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.delegate = sQLiteStatement;
    }

    public final long executeInsert() {
        return this.delegate.executeInsert();
    }

    public final int executeUpdateDelete() {
        return this.delegate.executeUpdateDelete();
    }
}
