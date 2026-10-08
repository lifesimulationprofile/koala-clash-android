package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabasePathHelper {
    public static final void migrateDatabase(Context context) {
        Map mapSingletonMap;
        if (context.getDatabasePath("androidx.work.workdb").exists()) {
            Logger$LogcatLogger.get().debug(WorkDatabasePathHelperKt.TAG, "Migrating WorkDatabase to the no-backup directory");
            File databasePath = context.getDatabasePath("androidx.work.workdb");
            File file = new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), "androidx.work.workdb");
            String[] strArr = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
            int iMapCapacity = MapsKt__MapsKt.mapCapacity(strArr.length);
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
            for (String str : strArr) {
                linkedHashMap.put(new File(databasePath.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(databasePath, file);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath, file);
                mapSingletonMap = linkedHashMap2;
            }
            for (Map.Entry entry : mapSingletonMap.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        Logger$LogcatLogger.get().warning(WorkDatabasePathHelperKt.TAG, "Over-writing contents of " + file3);
                    }
                    Logger$LogcatLogger.get().debug(WorkDatabasePathHelperKt.TAG, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }
}
