package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkTagDao_Impl$2 extends SharedSQLiteStatement {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkTagDao_Impl$2(RoomDatabase roomDatabase, int i) {
        super(roomDatabase);
        this.$r8$classId = i;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.$r8$classId) {
            case 0:
                return "DELETE FROM worktag WHERE work_spec_id=?";
            case 1:
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            case 2:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            case 3:
                return "DELETE from WorkProgress where work_spec_id=?";
            case 4:
                return "DELETE FROM WorkProgress";
            case 5:
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            case 6:
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            case 7:
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            case 8:
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            case 9:
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            case 10:
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            case 11:
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            case 12:
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            case 13:
                return "DELETE FROM workspec WHERE id=?";
            case 14:
                return "UPDATE workspec SET state=? WHERE id=?";
            case 15:
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            case 16:
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            case 17:
                return "UPDATE workspec SET output=? WHERE id=?";
            case 18:
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            case 19:
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            case 20:
                return "DELETE FROM imported WHERE uuid = ?";
            default:
                return "DELETE FROM selections WHERE uuid = ? AND proxy = ?";
        }
    }
}
