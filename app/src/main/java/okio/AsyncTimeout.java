package okio;

import android.content.Context;
import android.graphics.Typeface;
import android.media.CamcorderProfile;
import android.os.Process;
import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.CamcorderProfileHelper;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import coil.network.NetworkObserver;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final Condition condition;
    public static AsyncTimeout head;
    public static final ReentrantLock lock;
    public AsyncTimeout next;
    public int state;
    public long timeoutAt;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Watchdog extends Thread {
        public final /* synthetic */ int $r8$classId = 0;

        public /* synthetic */ Watchdog(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    break;
                default:
                    Process.setThreadPriority(19);
                    synchronized (this) {
                        while (true) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                                return;
                            }
                        }
                    }
                    break;
            }
            while (true) {
                try {
                    ReentrantLock reentrantLock = AsyncTimeout.lock;
                    ReentrantLock reentrantLock2 = AsyncTimeout.lock;
                    reentrantLock2.lock();
                    try {
                        AsyncTimeout asyncTimeoutAwaitTimeout = Companion.awaitTimeout();
                        if (asyncTimeoutAwaitTimeout == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                        reentrantLock2.unlock();
                        if (asyncTimeoutAwaitTimeout != null) {
                            asyncTimeoutAwaitTimeout.timedOut();
                        }
                    } finally {
                        reentrantLock2.unlock();
                    }
                } catch (InterruptedException unused2) {
                }
            }
        }

        public /* synthetic */ Watchdog(ThreadGroup threadGroup, String str) {
            super(threadGroup, str);
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        condition = reentrantLock.newCondition();
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void enter() {
        long j = this.timeoutNanos;
        boolean z = this.hasDeadline;
        if (j != 0 || z) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                Companion.access$insertIntoQueue(this, j, z);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i = this.state;
            this.state = 0;
            if (i != 1) {
                boolean z = i == 2;
                reentrantLock.unlock();
                return z;
            }
            AsyncTimeout asyncTimeout = head;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                if (asyncTimeout2 == this) {
                    asyncTimeout.next = this.next;
                    this.next = null;
                    reentrantLock.unlock();
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Companion implements CamcorderProfileHelper, Function, PlatformTypefaces, CreationExtras.Key, ProfileInstaller$DiagnosticsCallback, NetworkObserver, Factory, DynamiteModule.VersionPolicy.IVersions, ComponentFactory {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static final void access$insertIntoQueue(AsyncTimeout asyncTimeout, long j, boolean z) {
            AsyncTimeout asyncTimeout2;
            ReentrantLock reentrantLock = AsyncTimeout.lock;
            if (AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                Watchdog watchdog = new Watchdog("Okio Watchdog");
                watchdog.setDaemon(true);
                watchdog.start();
            }
            long jNanoTime = System.nanoTime();
            if (j != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
            } else if (j != 0) {
                asyncTimeout.timeoutAt = j + jNanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            }
            long j2 = asyncTimeout.timeoutAt - jNanoTime;
            AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
            while (true) {
                asyncTimeout2 = asyncTimeout3.next;
                if (asyncTimeout2 == null || j2 < asyncTimeout2.timeoutAt - jNanoTime) {
                    break;
                } else {
                    asyncTimeout3 = asyncTimeout2;
                }
            }
            asyncTimeout.next = asyncTimeout2;
            asyncTimeout3.next = asyncTimeout;
            if (asyncTimeout3 == AsyncTimeout.head) {
                AsyncTimeout.condition.signal();
            }
        }

        public static AsyncTimeout awaitTimeout() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head.next;
            if (asyncTimeout == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.condition.await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (AsyncTimeout.head.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jNanoTime2 = asyncTimeout.timeoutAt - System.nanoTime();
            if (jNanoTime2 > 0) {
                AsyncTimeout.condition.await(jNanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout.head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            asyncTimeout.state = 2;
            return asyncTimeout;
        }

        /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
        public static Typeface m863createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
            if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Normal) && (str == null || str.length() == 0)) {
                return Typeface.DEFAULT;
            }
            return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), fontWeight.weight, i == 1);
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            switch (this.$r8$classId) {
                case 17:
                    return new ByteString.Companion(1);
                case 18:
                    return new Companion(1);
                default:
                    return new SharedPrefManager((Context) restrictedComponentContainer.get(Context.class));
            }
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createDefault-FO1MlWM */
        public Typeface mo655createDefaultFO1MlWM(FontWeight fontWeight, int i) {
            return m863createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createNamed-RetOiIg */
        public Typeface mo656createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
            return m863createAndroidTypefaceApi28RetOiIg(genericFontFamily.name, fontWeight, i);
        }

        @Override // javax.inject.Provider
        public Object get() {
            Path.Companion companion = new Path.Companion(16);
            HashMap map = new HashMap();
            Set set = Collections.EMPTY_SET;
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(Priority.DEFAULT, new AutoValue_SchedulerConfig_ConfigValue(30000L, 86400000L, set));
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(Priority.HIGHEST, new AutoValue_SchedulerConfig_ConfigValue(1000L, 86400000L, set));
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig$Flag.NETWORK_UNMETERED, SchedulerConfig$Flag.DEVICE_IDLE)));
            if (setUnmodifiableSet == null) {
                throw new NullPointerException("Null flags");
            }
            map.put(Priority.VERY_LOW, new AutoValue_SchedulerConfig_ConfigValue(86400000L, 86400000L, setUnmodifiableSet));
            if (map.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            new HashMap();
            return new AutoValue_SchedulerConfig(companion, map);
        }

        @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
        public boolean hasProfile(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }

        @Override // coil.network.NetworkObserver
        public boolean isOnline() {
            return true;
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onDiagnosticReceived() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
            String str;
            switch (i) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i == 6 || i == 7 || i == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
        public int zza(Context context, String str) {
            return DynamiteModule.getLocalVersion(context, str);
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
        public int zzb(Context context, String str, boolean z) {
            return DynamiteModule.zza(context, str, z);
        }

        @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
        public CamcorderProfile get(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // coil.network.NetworkObserver
        public void shutdown() {
        }

        @Override // androidx.arch.core.util.Function
        public Object apply(Object obj) {
            return obj;
        }
    }

    public void timedOut() {
    }
}
