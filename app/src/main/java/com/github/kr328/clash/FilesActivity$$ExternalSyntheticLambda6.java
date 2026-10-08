package com.github.kr328.clash;

import android.app.PendingIntent;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.remote.FilesClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda6(Object obj, Object obj2, Object obj3, String str, Object obj4, Object obj5, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = str;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws PendingIntent.CanceledException {
        boolean z;
        int i = this.$r8$classId;
        Object obj = this.f$5;
        Object obj2 = this.f$4;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (i) {
            case 0:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj5;
                FilesActivity filesActivity = (FilesActivity) obj4;
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                FilesClient filesClient = (FilesClient) obj2;
                MutableState mutableState = (MutableState) obj;
                int i2 = FilesActivity.$r8$clinit;
                if (snapshotStateList.isEmpty()) {
                    filesActivity.finish();
                } else {
                    snapshotStateList.remove(MatrixExt.getLastIndex(snapshotStateList));
                    JobKt.launch$default(coroutineScope, null, new FilesActivity$Content$2$1$1(snapshotStateList, this.f$3, filesClient, mutableState, null, 0), 3);
                }
                break;
            case 1:
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj5;
                FilesActivity filesActivity2 = (FilesActivity) obj4;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj3;
                FilesClient filesClient2 = (FilesClient) obj2;
                MutableState mutableState2 = (MutableState) obj;
                int i3 = FilesActivity.$r8$clinit;
                if (snapshotStateList2.isEmpty()) {
                    filesActivity2.finish();
                } else {
                    snapshotStateList2.remove(MatrixExt.getLastIndex(snapshotStateList2));
                    JobKt.launch$default(coroutineScope2, null, new FilesActivity$Content$2$1$1(snapshotStateList2, this.f$3, filesClient2, mutableState2, null, 1), 3);
                }
                break;
            default:
                SaveableHolder saveableHolder = (SaveableHolder) obj5;
                Saver saver = (Saver) obj4;
                SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) obj3;
                Object[] objArr = (Object[]) obj;
                boolean z2 = true;
                if (saveableHolder.registry != saveableStateRegistry) {
                    saveableHolder.registry = saveableStateRegistry;
                    z = true;
                } else {
                    z = false;
                }
                String str = saveableHolder.key;
                String str2 = this.f$3;
                if (Intrinsics.areEqual(str, str2)) {
                    z2 = z;
                } else {
                    saveableHolder.key = str2;
                }
                saveableHolder.saver = saver;
                saveableHolder.value = obj2;
                saveableHolder.inputs = objArr;
                RealNetworkObserver realNetworkObserver = saveableHolder.entry;
                if (realNetworkObserver != null && z2) {
                    realNetworkObserver.unregister();
                    saveableHolder.entry = null;
                    saveableHolder.register$1();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
