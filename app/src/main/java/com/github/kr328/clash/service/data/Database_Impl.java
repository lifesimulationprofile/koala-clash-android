package com.github.kr328.clash.service.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.network.RealNetworkObserver;
import com.google.android.material.internal.CheckableGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Database_Impl extends Database {
    public static final /* synthetic */ int $r8$clinit = 0;
    public volatile Dispatcher _importedDao;
    public volatile RealNetworkObserver _selectionDao;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "imported", "selections");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(new CheckableGroup(databaseConfiguration.context, databaseConfiguration.name, new RoomOpenHelper(databaseConfiguration, new WorkDatabase_Impl.AnonymousClass1(this), "8c35d7d374f413febfcb9ee273005d53", "8731d63cf0904261553028e2b05e0179"), false, false));
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations() {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(Dispatcher.class, list);
        map.put(RealNetworkObserver.class, list);
        return map;
    }

    @Override // com.github.kr328.clash.service.data.Database
    public final Dispatcher openImportedDao() {
        Dispatcher dispatcher;
        if (this._importedDao != null) {
            return this._importedDao;
        }
        synchronized (this) {
            try {
                if (this._importedDao == null) {
                    Dispatcher dispatcher2 = new Dispatcher();
                    dispatcher2.executorServiceOrNull = this;
                    dispatcher2.readyAsyncCalls = new WorkTagDao_Impl$1(dispatcher2, this, 7);
                    dispatcher2.runningAsyncCalls = new WorkSpecDao_Impl.AnonymousClass2(dispatcher2, this);
                    dispatcher2.runningSyncCalls = new WorkTagDao_Impl$2(this, 20);
                    this._importedDao = dispatcher2;
                }
                dispatcher = this._importedDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dispatcher;
    }

    @Override // com.github.kr328.clash.service.data.Database
    public final RealNetworkObserver openSelectionProxyDao() {
        RealNetworkObserver realNetworkObserver;
        if (this._selectionDao != null) {
            return this._selectionDao;
        }
        synchronized (this) {
            try {
                if (this._selectionDao == null) {
                    this._selectionDao = new RealNetworkObserver(this);
                }
                realNetworkObserver = this._selectionDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return realNetworkObserver;
    }
}
