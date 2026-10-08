package com.google.android.datatransport.runtime;

import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.work.impl.utils.StartWorkRunnable;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TransportImpl {
    public final Encoding payloadEncoding;
    public final Transformer transformer;
    public final AutoValue_TransportContext transportContext;
    public final TransportRuntime transportInternal;

    public TransportImpl(AutoValue_TransportContext autoValue_TransportContext, Encoding encoding, Transformer transformer, TransportRuntime transportRuntime) {
        this.transportContext = autoValue_TransportContext;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportRuntime;
    }

    public final void send(AutoValue_Event autoValue_Event) {
        TransportRuntime transportRuntime = this.transportInternal;
        Scheduler scheduler = transportRuntime.scheduler;
        Priority priority = autoValue_Event.priority;
        AutoValue_TransportContext autoValue_TransportContext = this.transportContext;
        String str = autoValue_TransportContext.backendName;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        AutoValue_TransportContext autoValue_TransportContext2 = new AutoValue_TransportContext(str, autoValue_TransportContext.extras, priority);
        AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
        anonymousClass1.TINT_CHECKABLE_BUTTON_LIST = new HashMap();
        anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(transportRuntime.eventClock.getTime());
        anonymousClass1.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(transportRuntime.uptimeClock.getTime());
        anonymousClass1.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = "FIREBASE_ML_SDK";
        anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(this.payloadEncoding, (byte[]) this.transformer.apply(autoValue_Event.payload));
        anonymousClass1.TINT_COLOR_CONTROL_NORMAL = null;
        DefaultScheduler defaultScheduler = (DefaultScheduler) scheduler;
        defaultScheduler.executor.execute(new StartWorkRunnable(defaultScheduler, autoValue_TransportContext2, anonymousClass1.build(), 3));
    }
}
