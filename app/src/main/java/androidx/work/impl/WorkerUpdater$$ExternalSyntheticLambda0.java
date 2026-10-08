package androidx.work.impl;

import android.os.Trace;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import coil.request.RequestService;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkerUpdater$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda0(TextStyle textStyle, LayoutDirection layoutDirection, String str, Density density, FontFamily$Resolver fontFamily$Resolver) {
        this.f$0 = textStyle;
        this.f$2 = layoutDirection;
        this.f$1 = str;
        this.f$3 = density;
        this.f$4 = fontFamily$Resolver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        int i = this.$r8$classId;
        Object obj = this.f$4;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                WorkManagerImpl workManagerImpl = (WorkManagerImpl) obj4;
                RequestService requestService = (RequestService) obj3;
                AndroidDialog_androidKt$Dialog$2$1 androidDialog_androidKt$Dialog$2$1 = (AndroidDialog_androidKt$Dialog$2$1) obj2;
                WorkRequest workRequest = (WorkRequest) obj;
                WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                String str = this.f$1;
                ArrayList workSpecIdAndStatesForName = workSpecDao_ImplWorkSpecDao.getWorkSpecIdAndStatesForName(str);
                if (workSpecIdAndStatesForName.size() > 1) {
                    requestService.markState(new Operation.State.FAILURE(new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.")));
                    return;
                }
                WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) CollectionsKt.firstOrNull(workSpecIdAndStatesForName);
                if (idAndState == null) {
                    androidDialog_androidKt$Dialog$2$1.invoke();
                    return;
                }
                String str2 = idAndState.id;
                WorkSpec workSpec = workSpecDao_ImplWorkSpecDao.getWorkSpec(str2);
                if (workSpec == null) {
                    requestService.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + str2 + ", that matches a name \"" + str + "\", wasn't found")));
                    return;
                }
                if (!workSpec.isPeriodic()) {
                    requestService.markState(new Operation.State.FAILURE(new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.")));
                    return;
                }
                if (idAndState.state == 6) {
                    workSpecDao_ImplWorkSpecDao.delete(str2);
                    androidDialog_androidKt$Dialog$2$1.invoke();
                    return;
                }
                try {
                    WorkerUpdater.updateWorkImpl(workManagerImpl.mProcessor, workDatabase, workManagerImpl.mConfiguration, workManagerImpl.mSchedulers, WorkSpec.copy$default(workRequest.workSpec, idAndState.id, 0, null, null, 0, 0L, 0, 0, 0L, 0, 8388606), workRequest.tags);
                    requestService.markState(Operation.SUCCESS);
                    return;
                } catch (Throwable th) {
                    requestService.markState(new Operation.State.FAILURE(th));
                    return;
                }
            default:
                TextStyle textStyle = (TextStyle) obj4;
                LayoutDirection layoutDirection = (LayoutDirection) obj3;
                String str3 = this.f$1;
                Density density = (Density) obj2;
                FontFamily$Resolver fontFamily$Resolver = (FontFamily$Resolver) obj;
                Trace.beginSection("BackgroundTextMeasurement");
                try {
                    Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                    MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
                    if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(null, null)) == null) {
                        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                    }
                    try {
                        Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                        try {
                            TextStyle textStyleResolveDefaults = ParagraphKt.resolveDefaults(textStyle, layoutDirection);
                            EmptyList emptyList = EmptyList.INSTANCE;
                            AndroidParagraphIntrinsics androidParagraphIntrinsics = new AndroidParagraphIntrinsics(str3, textStyleResolveDefaults, emptyList, emptyList, fontFamily$Resolver, density);
                            androidParagraphIntrinsics.getMaxIntrinsicWidth();
                            androidParagraphIntrinsics.getMinIntrinsicWidth();
                            Unit unit = Unit.INSTANCE;
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            mutableSnapshotTakeNestedMutableSnapshot.apply().check();
                            mutableSnapshotTakeNestedMutableSnapshot.dispose();
                            Trace.endSection();
                            return;
                        } catch (Throwable th2) {
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            mutableSnapshotTakeNestedMutableSnapshot.dispose();
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    Trace.endSection();
                    throw th5;
                }
        }
    }

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda0(WorkManagerImpl workManagerImpl, String str, RequestService requestService, AndroidDialog_androidKt$Dialog$2$1 androidDialog_androidKt$Dialog$2$1, PeriodicWorkRequest periodicWorkRequest) {
        this.f$0 = workManagerImpl;
        this.f$1 = str;
        this.f$2 = requestService;
        this.f$3 = androidDialog_androidKt$Dialog$2$1;
        this.f$4 = periodicWorkRequest;
    }
}
