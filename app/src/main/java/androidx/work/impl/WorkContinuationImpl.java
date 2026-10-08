package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkContinuationImpl extends WorkContinuation {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkContinuationImpl");
    public final ArrayList mAllIds = new ArrayList();
    public boolean mEnqueued;
    public final int mExistingWorkPolicy;
    public final ArrayList mIds;
    public final String mName;
    public RequestService mOperation;
    public final List mWork;
    public final WorkManagerImpl mWorkManagerImpl;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, int i, List list, int i2) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = str;
        this.mExistingWorkPolicy = i;
        this.mWork = list;
        this.mIds = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i == 1 && ((WorkRequest) list.get(i3)).workSpec.nextScheduleTimeOverride != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String string = ((WorkRequest) list.get(i3)).id.toString();
            this.mIds.add(string);
            this.mAllIds.add(string);
        }
    }

    public static HashSet prerequisitesFor(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        workContinuationImpl.getClass();
        return hashSet;
    }

    public final Operation enqueue() {
        if (this.mEnqueued) {
            Logger$LogcatLogger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", this.mIds) + ")");
        } else {
            RequestService requestService = new RequestService(17);
            this.mWorkManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new EnqueueRunnable(this, requestService));
            this.mOperation = requestService;
        }
        return this.mOperation;
    }
}
