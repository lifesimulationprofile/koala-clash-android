package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListenableWorker {
    public final Context mAppContext;
    public volatile int mStopReason = -256;
    public boolean mUsed;
    public final WorkerParameters mWorkerParams;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Result {

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class Retry extends Result {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return "Retry";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class Success extends Result {
            public final Data mOutputData;

            public Success(Data data) {
                this.mOutputData = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public final String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public abstract SettableFuture startWork();

    public final void stop(int i) {
        this.mStopReason = i;
        onStopped();
    }

    public void onStopped() {
    }
}
