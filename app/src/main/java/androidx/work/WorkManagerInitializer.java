package androidx.work;

import android.content.Context;
import androidx.appcompat.app.ActionBar;
import androidx.startup.Initializer;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        Logger$LogcatLogger.get().debug(TAG, "Initializing WorkManager with default configuration.");
        Configuration configuration = new Configuration();
        synchronized (WorkManagerImpl.sLock) {
            try {
                WorkManagerImpl workManagerImpl = WorkManagerImpl.sDelegatedInstance;
                if (workManagerImpl != null && WorkManagerImpl.sDefaultInstance != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (WorkManagerImpl.sDefaultInstance == null) {
                        WorkManagerImpl.sDefaultInstance = ActionBar.createWorkManager(applicationContext, configuration);
                    }
                    WorkManagerImpl.sDelegatedInstance = WorkManagerImpl.sDefaultInstance;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return WorkManagerImpl.getInstance$1(context);
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
