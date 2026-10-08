package androidx.compose.ui.autofill;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.view.ViewStructure;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PopulateViewStructure_androidKt$populate$7 extends Lambda implements Function4 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $this_populate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PopulateViewStructure_androidKt$populate$7(int i, Object obj) {
        super(4);
        this.$r8$classId = i;
        this.$this_populate = obj;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.$r8$classId) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                int iIntValue2 = ((Number) obj2).intValue();
                ((ViewStructure) this.$this_populate).setDimens(iIntValue, iIntValue2, 0, 0, ((Number) obj3).intValue() - iIntValue, ((Number) obj4).intValue() - iIntValue2);
                return Unit.INSTANCE;
            default:
                SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
                ((SupportSQLiteQuery) this.$this_populate).bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
        }
    }
}
