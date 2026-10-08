package com.github.kr328.clash.remote;

import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.work.impl.StartStopTokens;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.service.remote.IRemoteService;
import com.github.kr328.clash.service.remote.IRemoteServiceProxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Service {
    public static final long TOGGLE_CRASHED_INTERVAL = TimeUnit.SECONDS.toMillis(10);
    public final Application context;
    public final ImageLoader$Builder$$ExternalSyntheticLambda2 crashed;
    public final StartStopTokens remote = new StartStopTokens(19);
    public final Service$connection$1 connection = new ServiceConnection() { // from class: com.github.kr328.clash.remote.Service$connection$1
        public long lastCrashed = -1;

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            StartStopTokens startStopTokens = this.this$0.remote;
            Reflection.getOrCreateKotlinClass(IRemoteService.class);
            startStopTokens.set(iBinder instanceof IRemoteService ? (IRemoteService) iBinder : new IRemoteServiceProxy(iBinder));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Service service = this.this$0;
            StartStopTokens startStopTokens = service.remote;
            startStopTokens.set(null);
            if (System.currentTimeMillis() - this.lastCrashed < Service.TOGGLE_CRASHED_INTERVAL) {
                try {
                    service.context.unbindService(service.connection);
                } catch (Exception unused) {
                }
                startStopTokens.set(null);
                service.crashed.invoke();
            }
            this.lastCrashed = System.currentTimeMillis();
            Log.w("KoalaClash", "RemoteService killed or crashed", null);
        }
    };

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.kr328.clash.remote.Service$connection$1] */
    public Service(Application application, ImageLoader$Builder$$ExternalSyntheticLambda2 imageLoader$Builder$$ExternalSyntheticLambda2) {
        this.context = application;
        this.crashed = imageLoader$Builder$$ExternalSyntheticLambda2;
    }
}
