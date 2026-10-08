package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.provider.CallbackWrapper$2;
import androidx.work.ForegroundInfo;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.foreground.SystemForegroundService.AnonymousClass1;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.memory.EmptyStrongMemoryCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemFgDispatcher");
    public SystemForegroundService mCallback;
    public final EmptyStrongMemoryCache mConstraintsTracker;
    public final Context mContext;
    public WorkGenerationalId mCurrentForegroundId;
    public final LinkedHashMap mForegroundInfoById;
    public final Object mLock = new Object();
    public final WorkManagerTaskExecutor mTaskExecutor;
    public final HashMap mTrackedWorkSpecs;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashMap mWorkSpecById;

    public SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
        this.mWorkManagerImpl = instance$1;
        this.mTaskExecutor = instance$1.mWorkTaskExecutor;
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashMap();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new EmptyStrongMemoryCache(instance$1.mTrackers);
        instance$1.mProcessor.addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.workSpecId);
        intent.putExtra("KEY_GENERATION", workGenerationalId.generation);
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.workSpecId);
        intent.putExtra("KEY_GENERATION", workGenerationalId.generation);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.mNotification);
        return intent;
    }

    public final void handleNotify(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        WorkGenerationalId workGenerationalId = new WorkGenerationalId(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger$LogcatLogger.get().debug(TAG, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null || this.mCallback == null) {
            return;
        }
        ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.mForegroundInfoById;
        linkedHashMap.put(workGenerationalId, foregroundInfo);
        if (this.mCurrentForegroundId == null) {
            this.mCurrentForegroundId = workGenerationalId;
            SystemForegroundService systemForegroundService = this.mCallback;
            systemForegroundService.mHandler.post(systemForegroundService.new AnonymousClass1(intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.mCallback;
        systemForegroundService2.mHandler.post(new AppCompatTextHelper.AnonymousClass2(systemForegroundService2, intExtra, notification, 3));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).mForegroundServiceType;
        }
        ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.mCurrentForegroundId);
        if (foregroundInfo2 != null) {
            SystemForegroundService systemForegroundService3 = this.mCallback;
            systemForegroundService3.mHandler.post(systemForegroundService3.new AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, i));
        }
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            String str = workSpec.id;
            Logger$LogcatLogger.get().debug(TAG, "Constraints unmet for WorkSpec " + str);
            WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
            WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
            workManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(workManagerImpl.mProcessor, new StartStopToken(workGenerationalIdGenerationalId), true, -512));
        }
    }

    public final void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            try {
                Iterator it = this.mTrackedWorkSpecs.values().iterator();
                while (it.hasNext()) {
                    ((Job) it.next()).cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mWorkManagerImpl.mProcessor.removeExecutionListener(this);
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                Job job = ((WorkSpec) this.mWorkSpecById.remove(workGenerationalId)) != null ? (Job) this.mTrackedWorkSpecs.remove(workGenerationalId) : null;
                if (job != null) {
                    job.cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.mForegroundInfoById.remove(workGenerationalId);
        if (workGenerationalId.equals(this.mCurrentForegroundId)) {
            if (this.mForegroundInfoById.size() > 0) {
                Iterator it = this.mForegroundInfoById.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.mCurrentForegroundId = (WorkGenerationalId) entry.getKey();
                if (this.mCallback != null) {
                    ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                    SystemForegroundService systemForegroundService = this.mCallback;
                    systemForegroundService.mHandler.post(systemForegroundService.new AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, foregroundInfo2.mForegroundServiceType));
                    SystemForegroundService systemForegroundService2 = this.mCallback;
                    systemForegroundService2.mHandler.post(new CallbackWrapper$2(foregroundInfo2.mNotificationId, 2, systemForegroundService2));
                }
            } else {
                this.mCurrentForegroundId = null;
            }
        }
        SystemForegroundService systemForegroundService3 = this.mCallback;
        if (foregroundInfo == null || systemForegroundService3 == null) {
            return;
        }
        Logger$LogcatLogger.get().debug(TAG, "Removing Notification (id: " + foregroundInfo.mNotificationId + ", workSpecId: " + workGenerationalId + ", notificationType: " + foregroundInfo.mForegroundServiceType);
        systemForegroundService3.mHandler.post(new CallbackWrapper$2(foregroundInfo.mNotificationId, 2, systemForegroundService3));
    }
}
