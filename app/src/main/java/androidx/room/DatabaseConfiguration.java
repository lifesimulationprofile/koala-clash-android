package androidx.room;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import coil.request.Parameters;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List callbacks;
    public final Context context;
    public final int journalMode;
    public final Parameters.Builder migrationContainer;
    public final Set migrationNotRequiredFrom;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, Parameters.Builder builder, ArrayList arrayList, boolean z, int i, Executor executor, Executor executor2, boolean z2, boolean z3, LinkedHashSet linkedHashSet, ArrayList arrayList2, ArrayList arrayList3) {
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = builder;
        this.callbacks = arrayList;
        this.allowMainThreadQueries = z;
        this.journalMode = i;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = linkedHashSet;
    }
}
