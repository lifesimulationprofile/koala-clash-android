package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry$CallbackAndContract;
import androidx.activity.result.ActivityResultRegistry$LifecycleContainer;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.view.PreviewView;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import androidx.work.WorkManager;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentActivity$activityResultRegistry$1 {
    public final /* synthetic */ AppCompatActivity this$0;
    public final LinkedHashMap rcToKey = new LinkedHashMap();
    public final LinkedHashMap keyToRc = new LinkedHashMap();
    public final LinkedHashMap keyToLifecycleContainers = new LinkedHashMap();
    public final ArrayList launchedKeys = new ArrayList();
    public final transient LinkedHashMap keyToCallback = new LinkedHashMap();
    public final LinkedHashMap parsedPendingResults = new LinkedHashMap();
    public final Bundle pendingResults = new Bundle();

    public ComponentActivity$activityResultRegistry$1(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = (String) this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        ActivityResultRegistry$CallbackAndContract activityResultRegistry$CallbackAndContract = (ActivityResultRegistry$CallbackAndContract) this.keyToCallback.get(str);
        if ((activityResultRegistry$CallbackAndContract != null ? activityResultRegistry$CallbackAndContract.callback : null) != null) {
            ArrayList arrayList = this.launchedKeys;
            if (arrayList.contains(str)) {
                activityResultRegistry$CallbackAndContract.callback.onActivityResult(activityResultRegistry$CallbackAndContract.contract.parseResult(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.parsedPendingResults.remove(str);
        this.pendingResults.putParcelable(str, new ActivityResult(intent, i2));
        return true;
    }

    public final void onLaunch(int i, WorkManager workManager, Object obj) {
        Bundle bundleExtra;
        int i2;
        AppCompatActivity appCompatActivity = this.this$0;
        PreviewView.AnonymousClass1 synchronousResult = workManager.getSynchronousResult(appCompatActivity, obj);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, i, synchronousResult, 1));
            return;
        }
        Intent intentCreateIntent = workManager.createIntent(appCompatActivity, obj);
        if (intentCreateIntent.getExtras() != null && intentCreateIntent.getExtras().getClassLoader() == null) {
            intentCreateIntent.setExtrasClassLoader(appCompatActivity.getClassLoader());
        }
        if (intentCreateIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentCreateIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentCreateIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentCreateIntent.getAction())) {
            String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < stringArrayExtra.length; i3++) {
                if (TextUtils.isEmpty(stringArrayExtra[i3])) {
                    throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i3], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i3));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i4 = 0;
                for (int i5 = 0; i5 < stringArrayExtra.length; i5++) {
                    if (!hashSet.contains(Integer.valueOf(i5))) {
                        strArr[i4] = stringArrayExtra[i5];
                        i4++;
                    }
                }
            }
            appCompatActivity.requestPermissions(stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentCreateIntent.getAction())) {
            appCompatActivity.startActivityForResult(intentCreateIntent, i, bundle);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i2 = i;
            try {
                appCompatActivity.startIntentSenderForResult(intentSenderRequest.intentSender, i2, intentSenderRequest.fillInIntent, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues, 0, bundle);
                Unit unit = Unit.INSTANCE;
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, i2, e, 2));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }

    public final ActivityResultRegistry$register$2 register(String str, WorkManager workManager, ActivityResultCallback activityResultCallback) {
        registerKey(str);
        this.keyToCallback.put(str, new ActivityResultRegistry$CallbackAndContract(activityResultCallback, workManager));
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.pendingResults;
        ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(str, bundle);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(workManager.parseResult(activityResult.data, activityResult.resultCode));
        }
        return new ActivityResultRegistry$register$2(this, str, workManager, 1);
    }

    public final void registerKey(String str) {
        LinkedHashMap linkedHashMap = this.keyToRc;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        ImmLeaksCleaner$$ExternalSyntheticLambda0 immLeaksCleaner$$ExternalSyntheticLambda0 = new ImmLeaksCleaner$$ExternalSyntheticLambda0(5);
        for (Number number : new ConstrainedOnceSequence(new GeneratorSequence(immLeaksCleaner$$ExternalSyntheticLambda0, new DiskLruCache$$ExternalSyntheticLambda0(18, immLeaksCleaner$$ExternalSyntheticLambda0), 0))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.rcToKey;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void unregister$activity(String str) {
        Integer num;
        if (!this.launchedKeys.contains(str) && (num = (Integer) this.keyToRc.remove(str)) != null) {
            this.rcToKey.remove(num);
        }
        this.keyToCallback.remove(str);
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("Dropping pending result for request ", str, ": ");
            sbM13m.append(linkedHashMap.get(str));
            Log.w("ActivityResultRegistry", sbM13m.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.pendingResults;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) BundleCompat.getParcelable(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.keyToLifecycleContainers;
        ActivityResultRegistry$LifecycleContainer activityResultRegistry$LifecycleContainer = (ActivityResultRegistry$LifecycleContainer) linkedHashMap2.get(str);
        if (activityResultRegistry$LifecycleContainer != null) {
            ArrayList arrayList = activityResultRegistry$LifecycleContainer.observers;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                activityResultRegistry$LifecycleContainer.lifecycle.removeObserver((LifecycleEventObserver) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
