package com.github.kr328.clash.service.data;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import java.util.concurrent.Callable;
import kotlin.Unit;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImportedDao_Impl$4 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Dispatcher this$0;
    public final /* synthetic */ Imported val$imported;

    public /* synthetic */ ImportedDao_Impl$4(Dispatcher dispatcher, Imported imported, int i) {
        this.$r8$classId = i;
        this.this$0 = dispatcher;
        this.val$imported = imported;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                Dispatcher dispatcher = this.this$0;
                Database_Impl database_Impl = (Database_Impl) dispatcher.executorServiceOrNull;
                database_Impl.beginTransaction();
                try {
                    WorkTagDao_Impl$1 workTagDao_Impl$1 = (WorkTagDao_Impl$1) dispatcher.readyAsyncCalls;
                    Imported imported = this.val$imported;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$1.acquire();
                    try {
                        workTagDao_Impl$1.bind(frameworkSQLiteStatementAcquire, imported);
                        long jExecuteInsert = frameworkSQLiteStatementAcquire.executeInsert();
                        workTagDao_Impl$1.release(frameworkSQLiteStatementAcquire);
                        Long lValueOf = Long.valueOf(jExecuteInsert);
                        database_Impl.setTransactionSuccessful();
                        database_Impl.internalEndTransaction();
                        return lValueOf;
                    } catch (Throwable th) {
                        workTagDao_Impl$1.release(frameworkSQLiteStatementAcquire);
                        throw th;
                    }
                } catch (Throwable th2) {
                    database_Impl.internalEndTransaction();
                    throw th2;
                }
            default:
                Dispatcher dispatcher2 = this.this$0;
                Database_Impl database_Impl2 = (Database_Impl) dispatcher2.executorServiceOrNull;
                database_Impl2.beginTransaction();
                try {
                    WorkSpecDao_Impl.AnonymousClass2 anonymousClass2 = (WorkSpecDao_Impl.AnonymousClass2) dispatcher2.runningAsyncCalls;
                    Imported imported2 = this.val$imported;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = anonymousClass2.acquire();
                    try {
                        anonymousClass2.bind(frameworkSQLiteStatementAcquire2, imported2);
                        frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                        anonymousClass2.release(frameworkSQLiteStatementAcquire2);
                        database_Impl2.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        database_Impl2.internalEndTransaction();
                        return unit;
                    } catch (Throwable th3) {
                        anonymousClass2.release(frameworkSQLiteStatementAcquire2);
                        throw th3;
                    }
                } catch (Throwable th4) {
                    database_Impl2.internalEndTransaction();
                    throw th4;
                }
        }
    }
}
