package com.github.kr328.clash;

import android.os.Build;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.core.content.ContextCompat;
import androidx.work.CoroutineWorker;
import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.MainAppKt;
import com.github.kr328.clash.compose.TvMainAppKt;
import com.github.kr328.clash.compose.UpdateDialogKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.store.AppStore;
import io.github.g00fy2.quickie.ScanQRCode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ParcelableSnapshotMutableState pendingUpdate$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: renamed from: com.github.kr328.clash.MainActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ MainActivity this$0;

        public /* synthetic */ AnonymousClass1(boolean z, MainActivity mainActivity, int i) {
            this.$r8$classId = i;
            this.$isTv = z;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(917229957, new AnonymousClass1(this.$isTv, this.this$0, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        if (this.$isTv) {
                            gapComposer2.startReplaceGroup(-1241842449);
                            TvMainAppKt.TvMainApp(0, gapComposer2);
                        } else {
                            gapComposer2.startReplaceGroup(-1241841907);
                            MainAppKt.MainApp(0, gapComposer2);
                        }
                        gapComposer2.end(false);
                        MainActivity mainActivity = this.this$0;
                        UpdateInfo updateInfo = (UpdateInfo) mainActivity.pendingUpdate$delegate.getValue();
                        if (updateInfo != null) {
                            gapComposer2.startReplaceGroup(-1241835181);
                            boolean zChanged = gapComposer2.changed(mainActivity) | gapComposer2.changed(updateInfo);
                            Object objRememberedValue = gapComposer2.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(22, mainActivity, updateInfo);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-1241819588);
                            boolean zChanged2 = gapComposer2.changed(mainActivity);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new SvgDecoder$$ExternalSyntheticLambda0(9, mainActivity);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            gapComposer2.end(false);
                            UpdateDialogKt.UpdateDialog(updateInfo, function0, (Function0) objRememberedValue2, gapComposer2, 0);
                        }
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Exception {
        super.onCreate(bundle);
        boolean zIsTvDevice = TvKt.isTvDevice(this);
        if (!zIsTvDevice && Build.VERSION.SDK_INT >= 33) {
            ActivityResultRegistry$register$2 activityResultRegistry$register$2RegisterForActivityResult = registerForActivityResult(new ScanQRCode(4), new ZslControlImpl$$ExternalSyntheticLambda0(28));
            if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                activityResultRegistry$register$2RegisterForActivityResult.launch("android.permission.POST_NOTIFICATIONS");
            }
        }
        AppStore appStore = new AppStore(this);
        KProperty kProperty = AppStore.$$delegatedProperties[1];
        Continuation continuation = null;
        if (((Boolean) appStore.autoCheckUpdate$delegate.getValue()).booleanValue()) {
            JobKt.launch$default(JobKt.MainScope(), null, new CoroutineWorker.AnonymousClass1(this, continuation, 18), 3);
        }
        JobKt.launch$default(JobKt.MainScope(), null, new FilesActivity$showError$1(this, continuation, 4), 3);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-239933041, new AnonymousClass1(zIsTvDevice, this, 0), true));
    }
}
