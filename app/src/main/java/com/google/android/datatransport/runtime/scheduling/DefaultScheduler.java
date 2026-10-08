package com.google.android.datatransport.runtime.scheduling;

import com.caverock.androidsvg.SVG;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final MetadataBackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final SVG workScheduler;

    public DefaultScheduler(Executor executor, MetadataBackendRegistry metadataBackendRegistry, SVG svg, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = metadataBackendRegistry;
        this.workScheduler = svg;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }
}
