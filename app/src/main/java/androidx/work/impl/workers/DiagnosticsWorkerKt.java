package androidx.work.impl.workers;

import android.database.Cursor;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import coil.ImageLoader$Builder;
import coil.request.RequestService;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DiagnosticsWorkerKt {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DiagnosticsWrkr");

    public static final String access$workSpecRows(RequestService requestService, ImageLoader$Builder imageLoader$Builder, Request.Builder builder, ArrayList arrayList) {
        String str;
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            WorkSpec workSpec = (WorkSpec) obj;
            WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
            String str2 = workSpec.id;
            SystemIdInfo systemIdInfo = builder.getSystemIdInfo(workGenerationalIdGenerationalId);
            Integer numValueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) requestService.systemCallbacks;
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT name FROM workname WHERE work_spec_id=?", 1);
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(1);
            } else {
                roomSQLiteQueryAcquire.bindString(str2, 1);
            }
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList2.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                }
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, ",", null, null, null, 62);
                String strJoinToString$default2 = CollectionsKt.joinToString$default(imageLoader$Builder.getTagsForWorkSpecId(str2), ",", null, null, null, 62);
                StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("\n", str2, "\t ");
                sbM13m.append(workSpec.workerClassName);
                sbM13m.append("\t ");
                sbM13m.append(numValueOf);
                sbM13m.append("\t ");
                switch (workSpec.state) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                sbM13m.append(str);
                sbM13m.append("\t ");
                sbM13m.append(strJoinToString$default);
                sbM13m.append("\t ");
                sbM13m.append(strJoinToString$default2);
                sbM13m.append('\t');
                sb.append(sbM13m.toString());
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        }
        return sb.toString();
    }
}
