package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.google.android.material.internal.CheckableGroup;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface Factory {
        SupportSQLiteOpenHelper create(CheckableGroup checkableGroup);
    }

    FrameworkSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);
}
