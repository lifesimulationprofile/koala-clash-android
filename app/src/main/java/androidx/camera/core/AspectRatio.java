package androidx.camera.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.work.WorkManager;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzs;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AspectRatio {
    public static Object await(zzw zzwVar) throws InterruptedException {
        String name;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && ((name = looperMyLooper.getThread().getName()) == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler")))) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        if (zzwVar.isComplete()) {
            return zza(zzwVar);
        }
        zzs zzsVar = new zzs(1);
        Executor executor = TaskExecutors.zza;
        zzwVar.addOnSuccessListener(executor, zzsVar);
        zzwVar.addOnFailureListener(executor, zzsVar);
        zzwVar.zzb.zza(new zzh(executor, (OnCanceledListener) zzsVar));
        zzwVar.zzi();
        ((CountDownLatch) zzsVar.zza).await();
        return zza(zzwVar);
    }

    public static final ManagedActivityResultLauncher rememberLauncherForActivityResult(WorkManager workManager, Function1 function1, GapComposer gapComposer, int i) {
        Object obj;
        Stack.rememberUpdatedState(workManager, gapComposer);
        Object objRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer);
        Object[] objArr = new Object[0];
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj2 = Composer$Companion.Empty;
        if (objRememberedValue == obj2) {
            objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Object obj3 = (String) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer);
        ActivityResultRegistryOwner activityResultRegistryOwner = (ActivityResultRegistryOwner) gapComposer.consume(LocalActivityResultRegistryOwner.LocalComposition);
        if (activityResultRegistryOwner == null) {
            gapComposer.startReplaceGroup(1213380307);
            Object baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof ActivityResultRegistryOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            activityResultRegistryOwner = (ActivityResultRegistryOwner) baseContext;
        } else {
            gapComposer.startReplaceGroup(1213379439);
        }
        gapComposer.end(false);
        if (activityResultRegistryOwner == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        Object activityResultRegistry = activityResultRegistryOwner.getActivityResultRegistry();
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj2) {
            objRememberedValue2 = new ActivityResultLauncherHolder();
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue2;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == obj2) {
            objRememberedValue3 = new ManagedActivityResultLauncher(activityResultLauncherHolder);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue3;
        boolean zChangedInstance = gapComposer.changedInstance(activityResultLauncherHolder) | gapComposer.changedInstance(activityResultRegistry) | gapComposer.changed(obj3) | gapComposer.changedInstance(workManager) | gapComposer.changed(objRememberUpdatedState);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == obj2) {
            obj = workManager;
            objRememberedValue4 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(activityResultLauncherHolder, activityResultRegistry, obj3, obj, objRememberUpdatedState, 0);
            gapComposer.updateRememberedValue(objRememberedValue4);
        } else {
            obj = workManager;
        }
        Function1 function2 = (Function1) objRememberedValue4;
        boolean zChanged = gapComposer.changed(activityResultRegistry) | gapComposer.changed(obj3) | gapComposer.changed(obj);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == obj2) {
            objRememberedValue5 = new DisposableEffectImpl(function2);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        return managedActivityResultLauncher;
    }

    public static Object zza(zzw zzwVar) throws ExecutionException {
        if (zzwVar.isSuccessful()) {
            return zzwVar.getResult();
        }
        if (zzwVar.zzd) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(zzwVar.getException());
    }
}
