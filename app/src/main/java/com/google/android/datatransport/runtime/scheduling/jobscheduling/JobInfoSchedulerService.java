package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.appcompat.widget.TooltipPopup;
import androidx.work.Worker;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        if (string == null) {
            throw new NullPointerException("Null backendName");
        }
        Priority priorityValueOf = PriorityMapping.valueOf(i);
        byte[] bArrDecode = string2 != null ? Base64.decode(string2, 0) : null;
        TooltipPopup tooltipPopup = TransportRuntime.getInstance().uploader;
        ((Executor) tooltipPopup.mTmpDisplayFrame).execute(new Uploader$$Lambda$1(tooltipPopup, new AutoValue_TransportContext(string, bArrDecode, priorityValueOf), i2, new Worker.AnonymousClass2(15, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
