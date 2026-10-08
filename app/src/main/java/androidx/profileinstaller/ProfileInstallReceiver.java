package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import coil.memory.EmptyStrongMemoryCache;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File codeCacheDir;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            Encoding.writeProfile(context, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new EmptyStrongMemoryCache(15, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                EmptyStrongMemoryCache emptyStrongMemoryCache = new EmptyStrongMemoryCache(15, this);
                try {
                    Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    emptyStrongMemoryCache.onResultReceived(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    emptyStrongMemoryCache.onResultReceived(7, e);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            EmptyStrongMemoryCache emptyStrongMemoryCache2 = new EmptyStrongMemoryCache(15, this);
            int iMyPid = Process.myPid();
            if (Build.VERSION.SDK_INT < 24) {
                emptyStrongMemoryCache2.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(iMyPid, 10);
                emptyStrongMemoryCache2.onResultReceived(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        EmptyStrongMemoryCache emptyStrongMemoryCache3 = new EmptyStrongMemoryCache(15, this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            if (!"SAVE_PROFILE".equals(string2)) {
                emptyStrongMemoryCache3.onResultReceived(16, null);
                return;
            }
            int i = extras.getInt("EXTRA_PID", Process.myPid());
            if (Build.VERSION.SDK_INT < 24) {
                emptyStrongMemoryCache3.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(i, 10);
                emptyStrongMemoryCache3.onResultReceived(12, null);
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            codeCacheDir = context.createDeviceProtectedStorageContext().getCacheDir();
        } else if (i2 >= 24) {
            codeCacheDir = context.createDeviceProtectedStorageContext().getCodeCacheDir();
        } else {
            codeCacheDir = i2 == 23 ? context.getCodeCacheDir() : context.getCacheDir();
        }
        if (Encoding.deleteFilesRecursively(codeCacheDir)) {
            emptyStrongMemoryCache3.onResultReceived(14, null);
        } else {
            emptyStrongMemoryCache3.onResultReceived(15, null);
        }
    }
}
