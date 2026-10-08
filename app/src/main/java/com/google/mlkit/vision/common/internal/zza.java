package com.google.mlkit.vision.common.internal;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Selection;
import com.google.android.gms.internal.mlkit_vision_common.zzlv;
import com.google.android.gms.internal.mlkit_vision_common.zzlx;
import com.google.android.gms.internal.mlkit_vision_common.zzmv;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.mlkit.vision.common.InputImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Unit;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zza implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zza(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzlx zzlxVar;
        int i = this.$r8$classId;
        Object obj = this.zza;
        Object obj2 = this.zzb;
        switch (i) {
            case 0:
                zzh zzhVar = (zzh) obj;
                InputImage inputImage = (InputImage) obj2;
                HashMap map = zzlx.zza;
                zzmw.zza();
                int i2 = zzmv.$r8$clinit;
                zzmw.zza();
                if (Boolean.parseBoolean("")) {
                    HashMap map2 = zzlx.zza;
                    if (map2.get("detectorTaskWithResource#run") == null) {
                        map2.put("detectorTaskWithResource#run", new zzlx("detectorTaskWithResource#run"));
                    }
                    zzlxVar = (zzlx) map2.get("detectorTaskWithResource#run");
                } else {
                    zzlxVar = zzlv.zza;
                }
                zzlxVar.zzb();
                try {
                    List listRun = zzhVar.zzd.run(inputImage);
                    zzlxVar.close();
                    return listRun;
                } catch (Throwable th) {
                    try {
                        zzlxVar.close();
                        break;
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            break;
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            case 1:
                Dispatcher dispatcher = (Dispatcher) obj2;
                WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) dispatcher.runningSyncCalls;
                Database_Impl database_Impl = (Database_Impl) dispatcher.executorServiceOrNull;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
                frameworkSQLiteStatementAcquire.bindString(((UUID) obj).toString(), 1);
                try {
                    database_Impl.beginTransaction();
                    try {
                        frameworkSQLiteStatementAcquire.executeUpdateDelete();
                        database_Impl.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        database_Impl.internalEndTransaction();
                        workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                        return unit;
                    } catch (Throwable th3) {
                        database_Impl.internalEndTransaction();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                    throw th4;
                }
            default:
                RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) obj;
                Cursor cursorQuery = ((Database_Impl) ((RealNetworkObserver) obj2).connectivityManager).query(roomSQLiteQuery);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uuid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "proxy");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "selected");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new Selection(UUID.fromString(cursorQuery.getString(columnIndexOrThrow)), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3)));
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th5) {
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th5;
                }
        }
    }

    public /* synthetic */ zza(zzh zzhVar, InputImage inputImage) {
        this.$r8$classId = 0;
        this.zza = zzhVar;
        this.zzb = inputImage;
    }
}
